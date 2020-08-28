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

/** Hierarchy: x10006 -> x17297 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x10006_outr_UnitPipe **/
class x10006_outr_UnitPipe_kernel(
  list_b9853: List[Bool],
  list_x9867: List[DecoupledIO[AppCommandDense]],
  list_x9868: List[DecoupledIO[AppLoadData]],
  list_x9855_in_buffer_1: List[NBufInterface],
  list_x9488_reg: List[StandardInterface],
  list_x2682_tmp_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x10006_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x10006_outr_UnitPipe_iiCtr"))
  
  abstract class x10006_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9855_in_buffer_1 = Flipped(new NBufInterface(ModuleParams.getParams("x9855_in_buffer_1_p").asInstanceOf[NBufParams] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9854_in_buffer_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9854_in_buffer_0_p").asInstanceOf[NBufParams] ))
      val in_x9860_in_buffer_6 = Flipped(new NBufInterface(ModuleParams.getParams("x9860_in_buffer_6_p").asInstanceOf[NBufParams] ))
      val in_x9488_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9488_reg_p").asInstanceOf[MemParams] ))
      val in_x9861_in_buffer_7 = Flipped(new NBufInterface(ModuleParams.getParams("x9861_in_buffer_7_p").asInstanceOf[NBufParams] ))
      val in_x9868 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9868_p").asInstanceOf[(Int, Int)] )))
      val in_b9853 = Input(Bool())
      val in_x9867 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9867_p").asInstanceOf[(Int,Int)] ))
      val in_x9857_in_buffer_3 = Flipped(new NBufInterface(ModuleParams.getParams("x9857_in_buffer_3_p").asInstanceOf[NBufParams] ))
      val in_b9553 = Input(Bool())
      val in_x9862_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9862_reg_p").asInstanceOf[NBufParams] ))
      val in_x9858_in_buffer_4 = Flipped(new NBufInterface(ModuleParams.getParams("x9858_in_buffer_4_p").asInstanceOf[NBufParams] ))
      val in_x9856_in_buffer_2 = Flipped(new NBufInterface(ModuleParams.getParams("x9856_in_buffer_2_p").asInstanceOf[NBufParams] ))
      val in_x9859_in_buffer_5 = Flipped(new NBufInterface(ModuleParams.getParams("x9859_in_buffer_5_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x9855_in_buffer_1 = {io.in_x9855_in_buffer_1} ; io.in_x9855_in_buffer_1 := DontCare
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x9854_in_buffer_0 = {io.in_x9854_in_buffer_0} ; io.in_x9854_in_buffer_0 := DontCare
    def x9860_in_buffer_6 = {io.in_x9860_in_buffer_6} ; io.in_x9860_in_buffer_6 := DontCare
    def x9488_reg = {io.in_x9488_reg} ; io.in_x9488_reg := DontCare
    def x9861_in_buffer_7 = {io.in_x9861_in_buffer_7} ; io.in_x9861_in_buffer_7 := DontCare
    def x9868 = {io.in_x9868} 
    def b9853 = {io.in_b9853} 
    def x9867 = {io.in_x9867} 
    def x9857_in_buffer_3 = {io.in_x9857_in_buffer_3} ; io.in_x9857_in_buffer_3 := DontCare
    def b9553 = {io.in_b9553} 
    def x9862_reg = {io.in_x9862_reg} ; io.in_x9862_reg := DontCare
    def x9858_in_buffer_4 = {io.in_x9858_in_buffer_4} ; io.in_x9858_in_buffer_4 := DontCare
    def x9856_in_buffer_2 = {io.in_x9856_in_buffer_2} ; io.in_x9856_in_buffer_2 := DontCare
    def x9859_in_buffer_5 = {io.in_x9859_in_buffer_5} ; io.in_x9859_in_buffer_5 := DontCare
  }
  def connectWires0(module: x10006_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x9855_in_buffer_1.connectLedger(module.io.in_x9855_in_buffer_1)
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x9854_in_buffer_0.connectLedger(module.io.in_x9854_in_buffer_0)
    x9860_in_buffer_6.connectLedger(module.io.in_x9860_in_buffer_6)
    x9488_reg.connectLedger(module.io.in_x9488_reg)
    x9861_in_buffer_7.connectLedger(module.io.in_x9861_in_buffer_7)
    module.io.in_x9868 <> x9868
    module.io.in_b9853 <> b9853
    module.io.in_x9867 <> x9867
    x9857_in_buffer_3.connectLedger(module.io.in_x9857_in_buffer_3)
    module.io.in_b9553 <> b9553
    x9862_reg.connectLedger(module.io.in_x9862_reg)
    x9858_in_buffer_4.connectLedger(module.io.in_x9858_in_buffer_4)
    x9856_in_buffer_2.connectLedger(module.io.in_x9856_in_buffer_2)
    x9859_in_buffer_5.connectLedger(module.io.in_x9859_in_buffer_5)
  }
  val b9853 = list_b9853(0)
  val b9553 = list_b9853(1)
  val x9867 = list_x9867(0)
  val x9868 = list_x9868(0)
  val x9855_in_buffer_1 = list_x9855_in_buffer_1(0)
  val x9854_in_buffer_0 = list_x9855_in_buffer_1(1)
  val x9860_in_buffer_6 = list_x9855_in_buffer_1(2)
  val x9861_in_buffer_7 = list_x9855_in_buffer_1(3)
  val x9857_in_buffer_3 = list_x9855_in_buffer_1(4)
  val x9862_reg = list_x9855_in_buffer_1(5)
  val x9858_in_buffer_4 = list_x9855_in_buffer_1(6)
  val x9856_in_buffer_2 = list_x9855_in_buffer_1(7)
  val x9859_in_buffer_5 = list_x9855_in_buffer_1(8)
  val x9488_reg = list_x9488_reg(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x10006_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x10006_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x10006_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9880_inr_UnitPipe = new x9880_inr_UnitPipe_kernel(List(x2682_tmp_DRAM), List(x9867), List(x9862_reg), List(x9488_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x9880_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9880_inr_UnitPipe.sm.io.ctrInc)
      x9880_inr_UnitPipe.backpressure := x9867.ready | x9880_inr_UnitPipe.sm.io.doneLatch
      x9880_inr_UnitPipe.forwardpressure := true.B | x9880_inr_UnitPipe.sm.io.doneLatch
      x9880_inr_UnitPipe.sm.io.enableOut.zip(x9880_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9880_inr_UnitPipe.sm.io.break := false.B
      x9880_inr_UnitPipe.mask := true.B & true.B
      x9880_inr_UnitPipe.configure("x9880_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9880_inr_UnitPipe.kernel()
      val x9882_ctr = new CtrObject(Left(Some(0)), Left(Some(3136)), Left(Some(1)), 16, 32, false)
      val x9883_ctrchain = (new CChainObject(List[CtrObject](x9882_ctr), "x9883_ctrchain")).cchain.io 
      x9883_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x9883_ctrchain_p", (x9883_ctrchain.par, x9883_ctrchain.widths))
      val x10005_inr_Foreach = new x10005_inr_Foreach_kernel(List(x9868), List(x9855_in_buffer_1,x9854_in_buffer_0,x9860_in_buffer_6,x9861_in_buffer_7,x9857_in_buffer_3,x9858_in_buffer_4,x9856_in_buffer_2,x9859_in_buffer_5) , Some(me), List(x9883_ctrchain), 1, 1, 1, List(16), List(32), breakpoints, rr)
      x10005_inr_Foreach.sm.io.ctrDone := (x10005_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x10005_inr_Foreach.backpressure := true.B | x10005_inr_Foreach.sm.io.doneLatch
      x10005_inr_Foreach.forwardpressure := x9868.valid | x10005_inr_Foreach.sm.io.doneLatch
      x10005_inr_Foreach.sm.io.enableOut.zip(x10005_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x10005_inr_Foreach.sm.io.break := false.B
      x10005_inr_Foreach.mask := ~x10005_inr_Foreach.cchain.head.output.noop & true.B
      x10005_inr_Foreach.configure("x10005_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x10005_inr_Foreach.kernel()
      x9854_in_buffer_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9855_in_buffer_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9856_in_buffer_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9857_in_buffer_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9858_in_buffer_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9859_in_buffer_5.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9860_in_buffer_6.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9861_in_buffer_7.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9862_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x10006_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x10006_outr_UnitPipe **/
