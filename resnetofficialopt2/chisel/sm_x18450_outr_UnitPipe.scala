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

/** Hierarchy: x18450 -> x18477 -> x1256 **/
/** BEGIN None x18450_outr_UnitPipe **/
class x18450_outr_UnitPipe_kernel(
  list_b18379: List[Bool],
  list_x18380_feature_map_0: List[NBufInterface],
  list_x18390: List[DecoupledIO[AppLoadData]],
  list_x18388: List[DecoupledIO[AppCommandDense]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x18450_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18450_outr_UnitPipe_iiCtr"))
  
  abstract class x18450_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18388 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18388_p").asInstanceOf[(Int,Int)] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x18380_feature_map_0 = Flipped(new NBufInterface(ModuleParams.getParams("x18380_feature_map_0_p").asInstanceOf[NBufParams] ))
      val in_b18379 = Input(Bool())
      val in_x18382_reg = Flipped(new NBufInterface(ModuleParams.getParams("x18382_reg_p").asInstanceOf[NBufParams] ))
      val in_x18390 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18390_p").asInstanceOf[(Int, Int)] )))
      val in_x18381_reg = Flipped(new NBufInterface(ModuleParams.getParams("x18381_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x18388 = {io.in_x18388} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x18380_feature_map_0 = {io.in_x18380_feature_map_0} ; io.in_x18380_feature_map_0 := DontCare
    def b18379 = {io.in_b18379} 
    def x18382_reg = {io.in_x18382_reg} ; io.in_x18382_reg := DontCare
    def x18390 = {io.in_x18390} 
    def x18381_reg = {io.in_x18381_reg} ; io.in_x18381_reg := DontCare
  }
  def connectWires0(module: x18450_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18388 <> x18388
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x18380_feature_map_0.connectLedger(module.io.in_x18380_feature_map_0)
    module.io.in_b18379 <> b18379
    x18382_reg.connectLedger(module.io.in_x18382_reg)
    module.io.in_x18390 <> x18390
    x18381_reg.connectLedger(module.io.in_x18381_reg)
  }
  val b18379 = list_b18379(0)
  val x18380_feature_map_0 = list_x18380_feature_map_0(0)
  val x18382_reg = list_x18380_feature_map_0(1)
  val x18381_reg = list_x18380_feature_map_0(2)
  val x18390 = list_x18390(0)
  val x18388 = list_x18388(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18450_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18450_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18450_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18389_fifo = (new x18389_fifo).m.io.asInstanceOf[FIFOInterface]
      val x18418_inr_UnitPipe = new x18418_inr_UnitPipe_kernel(List(x2682_tmp_DRAM), List(x18389_fifo), List(x18388), List(x18382_reg,x18381_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x18418_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18418_inr_UnitPipe.sm.io.ctrInc)
      x18418_inr_UnitPipe.backpressure := x18388.ready & (~x18389_fifo.full | ~(x18389_fifo.accessActivesOut(0))) | x18418_inr_UnitPipe.sm.io.doneLatch
      x18418_inr_UnitPipe.forwardpressure := true.B | x18418_inr_UnitPipe.sm.io.doneLatch
      x18418_inr_UnitPipe.sm.io.enableOut.zip(x18418_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18418_inr_UnitPipe.sm.io.break := false.B
      x18418_inr_UnitPipe.mask := true.B & true.B
      x18418_inr_UnitPipe.configure("x18418_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18418_inr_UnitPipe.kernel()
      val x18449_outr_UnitPipe = new x18449_outr_UnitPipe_kernel(List(x18389_fifo), List(x18390), List(x18380_feature_map_0) , Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, rr)
      x18449_outr_UnitPipe.sm.io.ctrDone := risingEdge(x18449_outr_UnitPipe.sm.io.ctrInc)
      x18449_outr_UnitPipe.backpressure := true.B | x18449_outr_UnitPipe.sm.io.doneLatch
      x18449_outr_UnitPipe.forwardpressure := true.B | x18449_outr_UnitPipe.sm.io.doneLatch
      x18449_outr_UnitPipe.sm.io.enableOut.zip(x18449_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18449_outr_UnitPipe.sm.io.break := false.B
      x18449_outr_UnitPipe.mask := true.B & true.B
      x18449_outr_UnitPipe.configure("x18449_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18449_outr_UnitPipe.kernel()
      x18380_feature_map_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x18381_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x18382_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x18450_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18450_outr_UnitPipe **/
