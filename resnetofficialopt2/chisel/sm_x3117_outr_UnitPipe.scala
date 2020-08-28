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

/** Hierarchy: x3117 -> x1256 **/
/** BEGIN None x3117_outr_UnitPipe **/
class x3117_outr_UnitPipe_kernel(
  list_x3081_c27_DRAM: List[FixedPoint],
  list_x3099: List[DecoupledIO[AppCommandDense]],
  list_x3100: List[DecoupledIO[AppLoadData]],
  list_x3098_c27_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x3117_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3117_outr_UnitPipe_iiCtr"))
  
  abstract class x3117_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3098_c27_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3098_c27_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x3081_c27_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3099 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3099_p").asInstanceOf[(Int,Int)] ))
      val in_x3100 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3100_p").asInstanceOf[(Int, Int)] )))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x3098_c27_SRAM_0 = {io.in_x3098_c27_SRAM_0} ; io.in_x3098_c27_SRAM_0 := DontCare
    def x3081_c27_DRAM = {io.in_x3081_c27_DRAM} 
    def x3099 = {io.in_x3099} 
    def x3100 = {io.in_x3100} 
  }
  def connectWires0(module: x3117_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3098_c27_SRAM_0.connectLedger(module.io.in_x3098_c27_SRAM_0)
    module.io.in_x3081_c27_DRAM <> x3081_c27_DRAM
    module.io.in_x3099 <> x3099
    module.io.in_x3100 <> x3100
  }
  val x3081_c27_DRAM = list_x3081_c27_DRAM(0)
  val x3099 = list_x3099(0)
  val x3100 = list_x3100(0)
  val x3098_c27_SRAM_0 = list_x3098_c27_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3117_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3117_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3117_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3105_inr_UnitPipe = new x3105_inr_UnitPipe_kernel(List(x3081_c27_DRAM), List(x3099) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x3105_inr_UnitPipe.sm.io.ctrDone := risingEdge(x3105_inr_UnitPipe.sm.io.ctrInc)
      x3105_inr_UnitPipe.backpressure := x3099.ready | x3105_inr_UnitPipe.sm.io.doneLatch
      x3105_inr_UnitPipe.forwardpressure := true.B | x3105_inr_UnitPipe.sm.io.doneLatch
      x3105_inr_UnitPipe.sm.io.enableOut.zip(x3105_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3105_inr_UnitPipe.sm.io.break := false.B
      x3105_inr_UnitPipe.mask := true.B & true.B
      x3105_inr_UnitPipe.configure("x3105_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3105_inr_UnitPipe.kernel()
      val x3107_ctr = new CtrObject(Left(Some(0)), Left(Some(64)), Left(Some(1)), 1, 32, false)
      val x3108_ctrchain = (new CChainObject(List[CtrObject](x3107_ctr), "x3108_ctrchain")).cchain.io 
      x3108_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x3108_ctrchain_p", (x3108_ctrchain.par, x3108_ctrchain.widths))
      val x3116_inr_Foreach = new x3116_inr_Foreach_kernel(List(x3100), List(x3098_c27_SRAM_0) , Some(me), List(x3108_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x3116_inr_Foreach.sm.io.ctrDone := (x3116_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x3116_inr_Foreach.backpressure := true.B | x3116_inr_Foreach.sm.io.doneLatch
      x3116_inr_Foreach.forwardpressure := x3100.valid | x3116_inr_Foreach.sm.io.doneLatch
      x3116_inr_Foreach.sm.io.enableOut.zip(x3116_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x3116_inr_Foreach.sm.io.break := false.B
      x3116_inr_Foreach.mask := ~x3116_inr_Foreach.cchain.head.output.noop & true.B
      x3116_inr_Foreach.configure("x3116_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3116_inr_Foreach.kernel()
    }
    val module = Module(new x3117_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3117_outr_UnitPipe **/
