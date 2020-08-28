package accel
import fringe._
import fringe.templates.memory._
import fringe.templates._
import fringe.Ledger._
import fringe.utils._
import fringe.utils.implicits._
import fringe.templates.math._
import fringe.templates.counters._
import fringe.templates.vector._
import fringe.SpatialBlocks._
import fringe.templates.memory._
import fringe.templates.memory.implicits._
import fringe.templates.retiming._
import emul.ResidualGenerator._
import api._
import chisel3._
import chisel3.util._
import Args._
import scala.collection.immutable._

/** Hierarchy: x4239 -> x4240 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4239_outr_UnitPipe **/
class x4239_outr_UnitPipe_kernel(
  list_x4084_fifo: List[FIFOInterface],
  list_x4085: List[DecoupledIO[AppLoadData]],
  list_x4069_weight_SRAM_0: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x4239_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4239_outr_UnitPipe_iiCtr"))
  
  abstract class x4239_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4069_weight_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4069_weight_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x4085 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4085_p").asInstanceOf[(Int, Int)] )))
      val in_x4084_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x4084_fifo_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x4069_weight_SRAM_0 = {io.in_x4069_weight_SRAM_0} ; io.in_x4069_weight_SRAM_0 := DontCare
    def x4085 = {io.in_x4085} 
    def x4084_fifo = {io.in_x4084_fifo} ; io.in_x4084_fifo := DontCare
  }
  def connectWires0(module: x4239_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x4069_weight_SRAM_0.connectLedger(module.io.in_x4069_weight_SRAM_0)
    module.io.in_x4085 <> x4085
    x4084_fifo.connectLedger(module.io.in_x4084_fifo)
  }
  val x4084_fifo = list_x4084_fifo(0)
  val x4085 = list_x4085(0)
  val x4069_weight_SRAM_0 = list_x4069_weight_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4239_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4239_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4239_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4117_reg = (new x4117_reg).m.io.asInstanceOf[StandardInterface]
      val x4118_reg = (new x4118_reg).m.io.asInstanceOf[StandardInterface]
      val x4119_reg = (new x4119_reg).m.io.asInstanceOf[StandardInterface]
      val x4128_inr_UnitPipe = new x4128_inr_UnitPipe_kernel(List(x4084_fifo), List(x4119_reg,x4117_reg,x4118_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x4128_inr_UnitPipe.sm.io.ctrDone := risingEdge(x4128_inr_UnitPipe.sm.io.ctrInc)
      x4128_inr_UnitPipe.backpressure := true.B | x4128_inr_UnitPipe.sm.io.doneLatch
      x4128_inr_UnitPipe.forwardpressure := (~x4084_fifo.empty | ~(x4084_fifo.accessActivesOut(1))) | x4128_inr_UnitPipe.sm.io.doneLatch
      x4128_inr_UnitPipe.sm.io.enableOut.zip(x4128_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4128_inr_UnitPipe.sm.io.break := false.B
      x4128_inr_UnitPipe.mask := true.B & true.B
      x4128_inr_UnitPipe.configure("x4128_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4128_inr_UnitPipe.kernel()
      val x18773_rd_x4119 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18773_rd_x4119""")
      val x18773_rd_x4119_banks = List[UInt]()
      val x18773_rd_x4119_ofs = List[UInt]()
      val x18773_rd_x4119_en = List[Bool](true.B)
      x18773_rd_x4119.toSeq.zip(x4119_reg.connectRPort(18773, x18773_rd_x4119_banks, x18773_rd_x4119_ofs, io.sigsIn.backpressure, x18773_rd_x4119_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4130_ctr = new CtrObject(Left(Some(0)), Right(x18773_rd_x4119), Left(Some(1)), 8, 32, false)
      val x4131_ctrchain = (new CChainObject(List[CtrObject](x4130_ctr), "x4131_ctrchain")).cchain.io 
      x4131_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x4131_ctrchain_p", (x4131_ctrchain.par, x4131_ctrchain.widths))
      val x4238_inr_Foreach = new x4238_inr_Foreach_kernel(List(x4085), List(x4117_reg,x4118_reg), List(x4069_weight_SRAM_0) , Some(me), List(x4131_ctrchain), 1, 1, 1, List(8), List(32), breakpoints, rr)
      x4238_inr_Foreach.sm.io.ctrDone := (x4238_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x4238_inr_Foreach.backpressure := true.B | x4238_inr_Foreach.sm.io.doneLatch
      x4238_inr_Foreach.forwardpressure := x4085.valid | x4238_inr_Foreach.sm.io.doneLatch
      x4238_inr_Foreach.sm.io.enableOut.zip(x4238_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x4238_inr_Foreach.sm.io.break := false.B
      x4238_inr_Foreach.mask := ~x4238_inr_Foreach.cchain.head.output.noop & true.B
      x4238_inr_Foreach.configure("x4238_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4238_inr_Foreach.kernel()
    }
    val module = Module(new x4239_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4239_outr_UnitPipe **/
