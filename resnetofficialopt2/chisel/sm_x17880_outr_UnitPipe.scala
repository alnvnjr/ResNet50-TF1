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

/** Hierarchy: x17880 -> x18367 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17880_outr_UnitPipe **/
class x17880_outr_UnitPipe_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x17749: List[DecoupledIO[AppCommandDense]],
  list_b17747: List[Bool],
  list_x17748_feature_map_a_0: List[NBufInterface],
  list_x17750: List[DecoupledIO[AppLoadData]],
  list_x17717_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x17880_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17880_outr_UnitPipe_iiCtr"))
  
  abstract class x17880_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_b17747 = Input(Bool())
      val in_x17748_feature_map_a_0 = Flipped(new NBufInterface(ModuleParams.getParams("x17748_feature_map_a_0_p").asInstanceOf[NBufParams] ))
      val in_x17749 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17749_p").asInstanceOf[(Int,Int)] ))
      val in_x17717_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17717_reg_p").asInstanceOf[MemParams] ))
      val in_x17750 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17750_p").asInstanceOf[(Int, Int)] )))
      val in_b17746 = Input(new FixedPoint(true, 32, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def b17747 = {io.in_b17747} 
    def x17748_feature_map_a_0 = {io.in_x17748_feature_map_a_0} ; io.in_x17748_feature_map_a_0 := DontCare
    def x17749 = {io.in_x17749} 
    def x17717_reg = {io.in_x17717_reg} ; io.in_x17717_reg := DontCare
    def x17750 = {io.in_x17750} 
    def b17746 = {io.in_b17746} 
  }
  def connectWires0(module: x17880_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_b17747 <> b17747
    x17748_feature_map_a_0.connectLedger(module.io.in_x17748_feature_map_a_0)
    module.io.in_x17749 <> x17749
    x17717_reg.connectLedger(module.io.in_x17717_reg)
    module.io.in_x17750 <> x17750
    module.io.in_b17746 <> b17746
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b17746 = list_x2682_tmp_DRAM(1)
  val x17749 = list_x17749(0)
  val b17747 = list_b17747(0)
  val x17748_feature_map_a_0 = list_x17748_feature_map_a_0(0)
  val x17750 = list_x17750(0)
  val x17717_reg = list_x17717_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17880_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x17880_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17880_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x17761_inr_UnitPipe = new x17761_inr_UnitPipe_kernel(List(x2682_tmp_DRAM,b17746), List(x17749), List(x17717_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x17761_inr_UnitPipe.sm.io.ctrDone := risingEdge(x17761_inr_UnitPipe.sm.io.ctrInc)
      x17761_inr_UnitPipe.backpressure := x17749.ready | x17761_inr_UnitPipe.sm.io.doneLatch
      x17761_inr_UnitPipe.forwardpressure := true.B | x17761_inr_UnitPipe.sm.io.doneLatch
      x17761_inr_UnitPipe.sm.io.enableOut.zip(x17761_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x17761_inr_UnitPipe.sm.io.break := false.B
      x17761_inr_UnitPipe.mask := true.B & true.B
      x17761_inr_UnitPipe.configure("x17761_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17761_inr_UnitPipe.kernel()
      val x17763_ctr = new CtrObject(Left(Some(0)), Left(Some(3136)), Left(Some(1)), 16, 32, false)
      val x17764_ctrchain = (new CChainObject(List[CtrObject](x17763_ctr), "x17764_ctrchain")).cchain.io 
      x17764_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x17764_ctrchain_p", (x17764_ctrchain.par, x17764_ctrchain.widths))
      val x17879_inr_Foreach = new x17879_inr_Foreach_kernel(List(x17750), List(x17748_feature_map_a_0) , Some(me), List(x17764_ctrchain), 1, 1, 1, List(16), List(32), breakpoints, rr)
      x17879_inr_Foreach.sm.io.ctrDone := (x17879_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x17879_inr_Foreach.backpressure := true.B | x17879_inr_Foreach.sm.io.doneLatch
      x17879_inr_Foreach.forwardpressure := x17750.valid | x17879_inr_Foreach.sm.io.doneLatch
      x17879_inr_Foreach.sm.io.enableOut.zip(x17879_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x17879_inr_Foreach.sm.io.break := false.B
      x17879_inr_Foreach.mask := ~x17879_inr_Foreach.cchain.head.output.noop & true.B
      x17879_inr_Foreach.configure("x17879_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17879_inr_Foreach.kernel()
      x17748_feature_map_a_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x17880_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x17880_outr_UnitPipe **/
