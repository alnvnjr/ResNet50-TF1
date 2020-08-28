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

/** Hierarchy: x18366 -> x18367 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x18366_outr_UnitPipe **/
class x18366_outr_UnitPipe_kernel(
  list_x18216: List[DecoupledIO[AppStoreData]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x17719_reg: List[StandardInterface],
  list_x18215: List[DecoupledIO[AppCommandDense]],
  list_b17747: List[Bool],
  list_x18217: List[DecoupledIO[Bool]],
  list_x18014_feature_map_sum_0: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 3, isFSM = false   , latency = 0.0.toInt, myName = "x18366_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18366_outr_UnitPipe_iiCtr"))
  
  abstract class x18366_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x18215 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18215_p").asInstanceOf[(Int,Int)] ))
      val in_b17747 = Input(Bool())
      val in_x17719_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17719_reg_p").asInstanceOf[MemParams] ))
      val in_x18216 = Decoupled(new AppStoreData(ModuleParams.getParams("x18216_p").asInstanceOf[(Int,Int)] ))
      val in_x18217 = Flipped(Decoupled(Bool()))
      val in_b17746 = Input(new FixedPoint(true, 32, 0))
      val in_x18014_feature_map_sum_0 = Flipped(new NBufInterface(ModuleParams.getParams("x18014_feature_map_sum_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 3, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 3))
      val rr = Input(Bool())
    })
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x18215 = {io.in_x18215} 
    def b17747 = {io.in_b17747} 
    def x17719_reg = {io.in_x17719_reg} ; io.in_x17719_reg := DontCare
    def x18216 = {io.in_x18216} 
    def x18217 = {io.in_x18217} 
    def b17746 = {io.in_b17746} 
    def x18014_feature_map_sum_0 = {io.in_x18014_feature_map_sum_0} ; io.in_x18014_feature_map_sum_0 := DontCare
  }
  def connectWires0(module: x18366_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x18215 <> x18215
    module.io.in_b17747 <> b17747
    x17719_reg.connectLedger(module.io.in_x17719_reg)
    module.io.in_x18216 <> x18216
    module.io.in_x18217 <> x18217
    module.io.in_b17746 <> b17746
    x18014_feature_map_sum_0.connectLedger(module.io.in_x18014_feature_map_sum_0)
  }
  val x18216 = list_x18216(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b17746 = list_x2682_tmp_DRAM(1)
  val x17719_reg = list_x17719_reg(0)
  val x18215 = list_x18215(0)
  val b17747 = list_b17747(0)
  val x18217 = list_x18217(0)
  val x18014_feature_map_sum_0 = list_x18014_feature_map_sum_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18366_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18366_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18366_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18228_inr_UnitPipe = new x18228_inr_UnitPipe_kernel(List(x2682_tmp_DRAM,b17746), List(x18215), List(x17719_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x18228_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18228_inr_UnitPipe.sm.io.ctrInc)
      x18228_inr_UnitPipe.backpressure := x18215.ready | x18228_inr_UnitPipe.sm.io.doneLatch
      x18228_inr_UnitPipe.forwardpressure := true.B | x18228_inr_UnitPipe.sm.io.doneLatch
      x18228_inr_UnitPipe.sm.io.enableOut.zip(x18228_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18228_inr_UnitPipe.sm.io.break := false.B
      x18228_inr_UnitPipe.mask := true.B & true.B
      x18228_inr_UnitPipe.configure("x18228_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18228_inr_UnitPipe.kernel()
      val x18229_ctr = new CtrObject(Left(Some(0)), Left(Some(3136)), Left(Some(1)), 16, 32, false)
      val x18230_ctrchain = (new CChainObject(List[CtrObject](x18229_ctr), "x18230_ctrchain")).cchain.io 
      x18230_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x18230_ctrchain_p", (x18230_ctrchain.par, x18230_ctrchain.widths))
      val x18361_inr_Foreach = new x18361_inr_Foreach_kernel(List(x18014_feature_map_sum_0), List(x18216) , Some(me), List(x18230_ctrchain), 1, 1, 1, List(16), List(32), breakpoints, rr)
      x18361_inr_Foreach.sm.io.ctrDone := (x18361_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x18361_inr_Foreach.backpressure := x18216.ready | x18361_inr_Foreach.sm.io.doneLatch
      x18361_inr_Foreach.forwardpressure := true.B | x18361_inr_Foreach.sm.io.doneLatch
      x18361_inr_Foreach.sm.io.enableOut.zip(x18361_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x18361_inr_Foreach.sm.io.break := false.B
      x18361_inr_Foreach.mask := ~x18361_inr_Foreach.cchain.head.output.noop & true.B
      x18361_inr_Foreach.configure("x18361_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18361_inr_Foreach.kernel()
      val x18365_inr_UnitPipe = new x18365_inr_UnitPipe_kernel(List(x18217) , Some(me), List(), 2, 1, 1, List(1), List(32), breakpoints, rr)
      x18365_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18365_inr_UnitPipe.sm.io.ctrInc)
      x18365_inr_UnitPipe.backpressure := true.B | x18365_inr_UnitPipe.sm.io.doneLatch
      x18365_inr_UnitPipe.forwardpressure := x18217.valid | x18365_inr_UnitPipe.sm.io.doneLatch
      x18365_inr_UnitPipe.sm.io.enableOut.zip(x18365_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18365_inr_UnitPipe.sm.io.break := false.B
      x18365_inr_UnitPipe.mask := true.B & true.B
      x18365_inr_UnitPipe.configure("x18365_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18365_inr_UnitPipe.kernel()
      x18014_feature_map_sum_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x18366_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18366_outr_UnitPipe **/
