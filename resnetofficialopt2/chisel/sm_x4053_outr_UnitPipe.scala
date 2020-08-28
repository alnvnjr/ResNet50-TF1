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

/** Hierarchy: x4053 -> x4054 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4053_outr_UnitPipe **/
class x4053_outr_UnitPipe_kernel(
  list_x3994_fifo: List[FIFOInterface],
  list_x3995: List[DecoupledIO[AppLoadData]],
  list_x3992_bias_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x4053_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4053_outr_UnitPipe_iiCtr"))
  
  abstract class x4053_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3994_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x3994_fifo_p").asInstanceOf[MemParams] ))
      val in_x3995 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3995_p").asInstanceOf[(Int, Int)] )))
      val in_x3992_bias_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3992_bias_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x3994_fifo = {io.in_x3994_fifo} ; io.in_x3994_fifo := DontCare
    def x3995 = {io.in_x3995} 
    def x3992_bias_SRAM_0 = {io.in_x3992_bias_SRAM_0} ; io.in_x3992_bias_SRAM_0 := DontCare
  }
  def connectWires0(module: x4053_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3994_fifo.connectLedger(module.io.in_x3994_fifo)
    module.io.in_x3995 <> x3995
    x3992_bias_SRAM_0.connectLedger(module.io.in_x3992_bias_SRAM_0)
  }
  val x3994_fifo = list_x3994_fifo(0)
  val x3995 = list_x3995(0)
  val x3992_bias_SRAM_0 = list_x3992_bias_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4053_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4053_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4053_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4024_reg = (new x4024_reg).m.io.asInstanceOf[StandardInterface]
      val x4025_reg = (new x4025_reg).m.io.asInstanceOf[StandardInterface]
      val x4026_reg = (new x4026_reg).m.io.asInstanceOf[StandardInterface]
      val x4035_inr_UnitPipe = new x4035_inr_UnitPipe_kernel(List(x3994_fifo), List(x4026_reg,x4025_reg,x4024_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x4035_inr_UnitPipe.sm.io.ctrDone := risingEdge(x4035_inr_UnitPipe.sm.io.ctrInc)
      x4035_inr_UnitPipe.backpressure := true.B | x4035_inr_UnitPipe.sm.io.doneLatch
      x4035_inr_UnitPipe.forwardpressure := (~x3994_fifo.empty | ~(x3994_fifo.accessActivesOut(1))) | x4035_inr_UnitPipe.sm.io.doneLatch
      x4035_inr_UnitPipe.sm.io.enableOut.zip(x4035_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4035_inr_UnitPipe.sm.io.break := false.B
      x4035_inr_UnitPipe.mask := true.B & true.B
      x4035_inr_UnitPipe.configure("x4035_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4035_inr_UnitPipe.kernel()
      val x18768_rd_x4026 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18768_rd_x4026""")
      val x18768_rd_x4026_banks = List[UInt]()
      val x18768_rd_x4026_ofs = List[UInt]()
      val x18768_rd_x4026_en = List[Bool](true.B)
      x18768_rd_x4026.toSeq.zip(x4026_reg.connectRPort(18768, x18768_rd_x4026_banks, x18768_rd_x4026_ofs, io.sigsIn.backpressure, x18768_rd_x4026_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4037_ctr = new CtrObject(Left(Some(0)), Right(x18768_rd_x4026), Left(Some(1)), 1, 32, false)
      val x4038_ctrchain = (new CChainObject(List[CtrObject](x4037_ctr), "x4038_ctrchain")).cchain.io 
      x4038_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x4038_ctrchain_p", (x4038_ctrchain.par, x4038_ctrchain.widths))
      val x4052_inr_Foreach = new x4052_inr_Foreach_kernel(List(x3995), List(x4025_reg,x3992_bias_SRAM_0,x4024_reg) , Some(me), List(x4038_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x4052_inr_Foreach.sm.io.ctrDone := (x4052_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x4052_inr_Foreach.backpressure := true.B | x4052_inr_Foreach.sm.io.doneLatch
      x4052_inr_Foreach.forwardpressure := x3995.valid | x4052_inr_Foreach.sm.io.doneLatch
      x4052_inr_Foreach.sm.io.enableOut.zip(x4052_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x4052_inr_Foreach.sm.io.break := false.B
      x4052_inr_Foreach.mask := ~x4052_inr_Foreach.cchain.head.output.noop & true.B
      x4052_inr_Foreach.configure("x4052_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4052_inr_Foreach.kernel()
    }
    val module = Module(new x4053_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4053_outr_UnitPipe **/
