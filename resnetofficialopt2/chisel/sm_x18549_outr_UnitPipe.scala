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

/** Hierarchy: x18549 -> x18620 -> x1256 **/
/** BEGIN None x18549_outr_UnitPipe **/
class x18549_outr_UnitPipe_kernel(
  list_x18505: List[DecoupledIO[AppLoadData]],
  list_x18503_c90_row_SRAM_0: List[NBufInterface],
  list_x3083_c90_DRAM: List[FixedPoint],
  list_x18504: List[DecoupledIO[AppCommandDense]],
  list_b18502: List[Bool],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x18549_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18549_outr_UnitPipe_iiCtr"))
  
  abstract class x18549_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18504 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18504_p").asInstanceOf[(Int,Int)] ))
      val in_x18503_c90_row_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x18503_c90_row_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x3083_c90_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_b18502 = Input(Bool())
      val in_x18505 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18505_p").asInstanceOf[(Int, Int)] )))
      val in_b18501 = Input(new FixedPoint(true, 32, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x18504 = {io.in_x18504} 
    def x18503_c90_row_SRAM_0 = {io.in_x18503_c90_row_SRAM_0} ; io.in_x18503_c90_row_SRAM_0 := DontCare
    def x3083_c90_DRAM = {io.in_x3083_c90_DRAM} 
    def b18502 = {io.in_b18502} 
    def x18505 = {io.in_x18505} 
    def b18501 = {io.in_b18501} 
  }
  def connectWires0(module: x18549_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18504 <> x18504
    x18503_c90_row_SRAM_0.connectLedger(module.io.in_x18503_c90_row_SRAM_0)
    module.io.in_x3083_c90_DRAM <> x3083_c90_DRAM
    module.io.in_b18502 <> b18502
    module.io.in_x18505 <> x18505
    module.io.in_b18501 <> b18501
  }
  val x18505 = list_x18505(0)
  val x18503_c90_row_SRAM_0 = list_x18503_c90_row_SRAM_0(0)
  val x3083_c90_DRAM = list_x3083_c90_DRAM(0)
  val b18501 = list_x3083_c90_DRAM(1)
  val x18504 = list_x18504(0)
  val b18502 = list_b18502(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18549_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18549_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18549_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18514_inr_UnitPipe = new x18514_inr_UnitPipe_kernel(List(x3083_c90_DRAM,b18501), List(x18504) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x18514_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18514_inr_UnitPipe.sm.io.ctrInc)
      x18514_inr_UnitPipe.backpressure := x18504.ready | x18514_inr_UnitPipe.sm.io.doneLatch
      x18514_inr_UnitPipe.forwardpressure := true.B | x18514_inr_UnitPipe.sm.io.doneLatch
      x18514_inr_UnitPipe.sm.io.enableOut.zip(x18514_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18514_inr_UnitPipe.sm.io.break := false.B
      x18514_inr_UnitPipe.mask := true.B & true.B
      x18514_inr_UnitPipe.configure("x18514_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18514_inr_UnitPipe.kernel()
      val x18516_ctr = new CtrObject(Left(Some(0)), Left(Some(2048)), Left(Some(1)), 4, 32, false)
      val x18517_ctrchain = (new CChainObject(List[CtrObject](x18516_ctr), "x18517_ctrchain")).cchain.io 
      x18517_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x18517_ctrchain_p", (x18517_ctrchain.par, x18517_ctrchain.widths))
      val x18548_inr_Foreach = new x18548_inr_Foreach_kernel(List(x18505), List(x18503_c90_row_SRAM_0) , Some(me), List(x18517_ctrchain), 1, 1, 1, List(4), List(32), breakpoints, rr)
      x18548_inr_Foreach.sm.io.ctrDone := (x18548_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x18548_inr_Foreach.backpressure := true.B | x18548_inr_Foreach.sm.io.doneLatch
      x18548_inr_Foreach.forwardpressure := x18505.valid | x18548_inr_Foreach.sm.io.doneLatch
      x18548_inr_Foreach.sm.io.enableOut.zip(x18548_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x18548_inr_Foreach.sm.io.break := false.B
      x18548_inr_Foreach.mask := ~x18548_inr_Foreach.cchain.head.output.noop & true.B
      x18548_inr_Foreach.configure("x18548_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18548_inr_Foreach.kernel()
      x18503_c90_row_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x18549_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18549_outr_UnitPipe **/
