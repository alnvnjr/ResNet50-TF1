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

/** Hierarchy: x3896 -> x3897 -> x3898 -> x1256 **/
/** BEGIN None x3896_outr_UnitPipe **/
class x3896_outr_UnitPipe_kernel(
  list_x3871: List[DecoupledIO[Bool]],
  list_x3864_reg: List[NBufInterface],
  list_x3870: List[DecoupledIO[AppStoreData]],
  list_b3121: List[Bool],
  list_x3869: List[DecoupledIO[AppCommandDense]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 3, isFSM = false   , latency = 0.0.toInt, myName = "x3896_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3896_outr_UnitPipe_iiCtr"))
  
  abstract class x3896_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b3121 = Input(Bool())
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3870 = Decoupled(new AppStoreData(ModuleParams.getParams("x3870_p").asInstanceOf[(Int,Int)] ))
      val in_b3704 = Input(Bool())
      val in_x3871 = Flipped(Decoupled(Bool()))
      val in_x3864_reg = Flipped(new NBufInterface(ModuleParams.getParams("x3864_reg_p").asInstanceOf[NBufParams] ))
      val in_x3705_tmp0_SRAM_pool_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3705_tmp0_SRAM_pool_0_p").asInstanceOf[NBufParams] ))
      val in_x3869 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3869_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 3, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 3))
      val rr = Input(Bool())
    })
    def b3121 = {io.in_b3121} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3870 = {io.in_x3870} 
    def b3704 = {io.in_b3704} 
    def x3871 = {io.in_x3871} 
    def x3864_reg = {io.in_x3864_reg} ; io.in_x3864_reg := DontCare
    def x3705_tmp0_SRAM_pool_0 = {io.in_x3705_tmp0_SRAM_pool_0} ; io.in_x3705_tmp0_SRAM_pool_0 := DontCare
    def x3869 = {io.in_x3869} 
  }
  def connectWires0(module: x3896_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b3121 <> b3121
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x3870 <> x3870
    module.io.in_b3704 <> b3704
    module.io.in_x3871 <> x3871
    x3864_reg.connectLedger(module.io.in_x3864_reg)
    x3705_tmp0_SRAM_pool_0.connectLedger(module.io.in_x3705_tmp0_SRAM_pool_0)
    module.io.in_x3869 <> x3869
  }
  val x3871 = list_x3871(0)
  val x3864_reg = list_x3864_reg(0)
  val x3705_tmp0_SRAM_pool_0 = list_x3864_reg(1)
  val x3870 = list_x3870(0)
  val b3121 = list_b3121(0)
  val b3704 = list_b3121(1)
  val x3869 = list_x3869(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3896_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3896_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3896_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3880_inr_UnitPipe = new x3880_inr_UnitPipe_kernel(List(x2682_tmp_DRAM), List(x3869), List(x3864_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x3880_inr_UnitPipe.sm.io.ctrDone := risingEdge(x3880_inr_UnitPipe.sm.io.ctrInc)
      x3880_inr_UnitPipe.backpressure := x3869.ready | x3880_inr_UnitPipe.sm.io.doneLatch
      x3880_inr_UnitPipe.forwardpressure := true.B | x3880_inr_UnitPipe.sm.io.doneLatch
      x3880_inr_UnitPipe.sm.io.enableOut.zip(x3880_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3880_inr_UnitPipe.sm.io.break := false.B
      x3880_inr_UnitPipe.mask := true.B & true.B
      x3880_inr_UnitPipe.configure("x3880_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3880_inr_UnitPipe.kernel()
      val x3881_ctr = new CtrObject(Left(Some(0)), Left(Some(3136)), Left(Some(1)), 1, 32, false)
      val x3882_ctrchain = (new CChainObject(List[CtrObject](x3881_ctr), "x3882_ctrchain")).cchain.io 
      x3882_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x3882_ctrchain_p", (x3882_ctrchain.par, x3882_ctrchain.widths))
      val x3891_inr_Foreach = new x3891_inr_Foreach_kernel(List(x3705_tmp0_SRAM_pool_0), List(x3870) , Some(me), List(x3882_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x3891_inr_Foreach.sm.io.ctrDone := (x3891_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x3891_inr_Foreach.backpressure := x3870.ready | x3891_inr_Foreach.sm.io.doneLatch
      x3891_inr_Foreach.forwardpressure := true.B | x3891_inr_Foreach.sm.io.doneLatch
      x3891_inr_Foreach.sm.io.enableOut.zip(x3891_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x3891_inr_Foreach.sm.io.break := false.B
      x3891_inr_Foreach.mask := ~x3891_inr_Foreach.cchain.head.output.noop & true.B
      x3891_inr_Foreach.configure("x3891_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3891_inr_Foreach.kernel()
      val x3895_inr_UnitPipe = new x3895_inr_UnitPipe_kernel(List(x3871) , Some(me), List(), 2, 1, 1, List(1), List(32), breakpoints, rr)
      x3895_inr_UnitPipe.sm.io.ctrDone := risingEdge(x3895_inr_UnitPipe.sm.io.ctrInc)
      x3895_inr_UnitPipe.backpressure := true.B | x3895_inr_UnitPipe.sm.io.doneLatch
      x3895_inr_UnitPipe.forwardpressure := x3871.valid | x3895_inr_UnitPipe.sm.io.doneLatch
      x3895_inr_UnitPipe.sm.io.enableOut.zip(x3895_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3895_inr_UnitPipe.sm.io.break := false.B
      x3895_inr_UnitPipe.mask := true.B & true.B
      x3895_inr_UnitPipe.configure("x3895_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3895_inr_UnitPipe.kernel()
      x3705_tmp0_SRAM_pool_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 2)
      x3864_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x3896_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3896_outr_UnitPipe **/
