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

/** Hierarchy: x3299 -> x3300 -> x3699 -> x3700 -> x3898 -> x1256 **/
/** BEGIN None x3299_outr_UnitPipe **/
class x3299_outr_UnitPipe_kernel(
  list_x3216_lb0_0: List[NBufInterface],
  list_x3232: List[DecoupledIO[AppLoadData]],
  list_b3228: List[FixedPoint],
  list_b3121: List[Bool],
  list_x3231_fifo: List[FIFOInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x3299_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3299_outr_UnitPipe_iiCtr"))
  
  abstract class x3299_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b3121 = Input(Bool())
      val in_x3216_lb0_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3216_lb0_0_p").asInstanceOf[NBufParams] ))
      val in_x3231_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x3231_fifo_p").asInstanceOf[MemParams] ))
      val in_b3229 = Input(Bool())
      val in_b3215 = Input(Bool())
      val in_b3228 = Input(new FixedPoint(true, 32, 0))
      val in_b3220 = Input(Bool())
      val in_x3232 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3232_p").asInstanceOf[(Int, Int)] )))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def b3121 = {io.in_b3121} 
    def x3216_lb0_0 = {io.in_x3216_lb0_0} ; io.in_x3216_lb0_0 := DontCare
    def x3231_fifo = {io.in_x3231_fifo} ; io.in_x3231_fifo := DontCare
    def b3229 = {io.in_b3229} 
    def b3215 = {io.in_b3215} 
    def b3228 = {io.in_b3228} 
    def b3220 = {io.in_b3220} 
    def x3232 = {io.in_x3232} 
  }
  def connectWires0(module: x3299_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b3121 <> b3121
    x3216_lb0_0.connectLedger(module.io.in_x3216_lb0_0)
    x3231_fifo.connectLedger(module.io.in_x3231_fifo)
    module.io.in_b3229 <> b3229
    module.io.in_b3215 <> b3215
    module.io.in_b3228 <> b3228
    module.io.in_b3220 <> b3220
    module.io.in_x3232 <> x3232
  }
  val x3216_lb0_0 = list_x3216_lb0_0(0)
  val x3232 = list_x3232(0)
  val b3228 = list_b3228(0)
  val b3121 = list_b3121(0)
  val b3229 = list_b3121(1)
  val b3215 = list_b3121(2)
  val b3220 = list_b3121(3)
  val x3231_fifo = list_x3231_fifo(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3299_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3299_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3299_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3263_reg = (new x3263_reg).m.io.asInstanceOf[StandardInterface]
      val x3264_reg = (new x3264_reg).m.io.asInstanceOf[StandardInterface]
      val x3265_reg = (new x3265_reg).m.io.asInstanceOf[StandardInterface]
      val x3274_inr_UnitPipe = new x3274_inr_UnitPipe_kernel(List(x3231_fifo), List(x3263_reg,x3265_reg,x3264_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x3274_inr_UnitPipe.sm.io.ctrDone := risingEdge(x3274_inr_UnitPipe.sm.io.ctrInc)
      x3274_inr_UnitPipe.backpressure := true.B | x3274_inr_UnitPipe.sm.io.doneLatch
      x3274_inr_UnitPipe.forwardpressure := (~x3231_fifo.empty | ~(x3231_fifo.accessActivesOut(1))) | x3274_inr_UnitPipe.sm.io.doneLatch
      x3274_inr_UnitPipe.sm.io.enableOut.zip(x3274_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3274_inr_UnitPipe.sm.io.break := false.B
      x3274_inr_UnitPipe.mask := true.B & true.B
      x3274_inr_UnitPipe.configure("x3274_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3274_inr_UnitPipe.kernel()
      val x18765_rd_x3265 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18765_rd_x3265""")
      val x18765_rd_x3265_banks = List[UInt]()
      val x18765_rd_x3265_ofs = List[UInt]()
      val x18765_rd_x3265_en = List[Bool](true.B)
      x18765_rd_x3265.toSeq.zip(x3265_reg.connectRPort(18765, x18765_rd_x3265_banks, x18765_rd_x3265_ofs, io.sigsIn.backpressure, x18765_rd_x3265_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x3276_ctr = new CtrObject(Left(Some(0)), Right(x18765_rd_x3265), Left(Some(1)), 2, 32, false)
      val x3277_ctrchain = (new CChainObject(List[CtrObject](x3276_ctr), "x3277_ctrchain")).cchain.io 
      x3277_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x3277_ctrchain_p", (x3277_ctrchain.par, x3277_ctrchain.widths))
      val x3298_inr_Foreach = new x3298_inr_Foreach_kernel(List(b3228), List(x3232), List(x3216_lb0_0), List(x3263_reg,x3264_reg) , Some(me), List(x3277_ctrchain), 1, 1, 1, List(2), List(32), breakpoints, rr)
      x3298_inr_Foreach.sm.io.ctrDone := (x3298_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x3298_inr_Foreach.backpressure := true.B | x3298_inr_Foreach.sm.io.doneLatch
      x3298_inr_Foreach.forwardpressure := x3232.valid | x3298_inr_Foreach.sm.io.doneLatch
      x3298_inr_Foreach.sm.io.enableOut.zip(x3298_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x3298_inr_Foreach.sm.io.break := false.B
      x3298_inr_Foreach.mask := ~x3298_inr_Foreach.cchain.head.output.noop & true.B
      x3298_inr_Foreach.configure("x3298_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3298_inr_Foreach.kernel()
    }
    val module = Module(new x3299_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3299_outr_UnitPipe **/
