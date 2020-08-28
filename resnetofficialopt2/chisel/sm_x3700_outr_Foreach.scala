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

/** Hierarchy: x3700 -> x3898 -> x1256 **/
/** BEGIN None x3700_outr_Foreach **/
class x3700_outr_Foreach_kernel(
  list_x3230: List[DecoupledIO[AppCommandDense]],
  list_x3232: List[DecoupledIO[AppLoadData]],
  list_x3131_tmp0_SRAM_conv_9: List[NBufInterface],
  list_x3129_tmp0_SRAM_conv_7: List[StandardInterface],
  list_x2679_i0_pad_DRAM: List[FixedPoint],
  list_b3121: List[Bool],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 1, isFSM = false   , latency = 0.0.toInt, myName = "x3700_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3700_outr_Foreach_iiCtr"))
  
  abstract class x3700_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3230 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3230_p").asInstanceOf[(Int,Int)] ))
      val in_b3121 = Input(Bool())
      val in_x3131_tmp0_SRAM_conv_9 = Flipped(new NBufInterface(ModuleParams.getParams("x3131_tmp0_SRAM_conv_9_p").asInstanceOf[NBufParams] ))
      val in_x3125_tmp0_SRAM_conv_3 = Flipped(new NBufInterface(ModuleParams.getParams("x3125_tmp0_SRAM_conv_3_p").asInstanceOf[NBufParams] ))
      val in_x3122_tmp0_SRAM_conv_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3122_tmp0_SRAM_conv_0_p").asInstanceOf[NBufParams] ))
      val in_x3126_tmp0_SRAM_conv_4 = Flipped(new NBufInterface(ModuleParams.getParams("x3126_tmp0_SRAM_conv_4_p").asInstanceOf[NBufParams] ))
      val in_x3130_tmp0_SRAM_conv_8 = Flipped(new NBufInterface(ModuleParams.getParams("x3130_tmp0_SRAM_conv_8_p").asInstanceOf[NBufParams] ))
      val in_x3123_tmp0_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x3123_tmp0_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_x2679_i0_pad_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3129_tmp0_SRAM_conv_7 = Flipped(new StandardInterface(ModuleParams.getParams("x3129_tmp0_SRAM_conv_7_p").asInstanceOf[MemParams] ))
      val in_x3127_tmp0_SRAM_conv_5 = Flipped(new NBufInterface(ModuleParams.getParams("x3127_tmp0_SRAM_conv_5_p").asInstanceOf[NBufParams] ))
      val in_x3124_tmp0_SRAM_conv_2 = Flipped(new NBufInterface(ModuleParams.getParams("x3124_tmp0_SRAM_conv_2_p").asInstanceOf[NBufParams] ))
      val in_x3232 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3232_p").asInstanceOf[(Int, Int)] )))
      val in_x3132_c101_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3132_c101_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x3128_tmp0_SRAM_conv_6 = Flipped(new NBufInterface(ModuleParams.getParams("x3128_tmp0_SRAM_conv_6_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3230 = {io.in_x3230} 
    def b3121 = {io.in_b3121} 
    def x3131_tmp0_SRAM_conv_9 = {io.in_x3131_tmp0_SRAM_conv_9} ; io.in_x3131_tmp0_SRAM_conv_9 := DontCare
    def x3125_tmp0_SRAM_conv_3 = {io.in_x3125_tmp0_SRAM_conv_3} ; io.in_x3125_tmp0_SRAM_conv_3 := DontCare
    def x3122_tmp0_SRAM_conv_0 = {io.in_x3122_tmp0_SRAM_conv_0} ; io.in_x3122_tmp0_SRAM_conv_0 := DontCare
    def x3126_tmp0_SRAM_conv_4 = {io.in_x3126_tmp0_SRAM_conv_4} ; io.in_x3126_tmp0_SRAM_conv_4 := DontCare
    def x3130_tmp0_SRAM_conv_8 = {io.in_x3130_tmp0_SRAM_conv_8} ; io.in_x3130_tmp0_SRAM_conv_8 := DontCare
    def x3123_tmp0_SRAM_conv_1 = {io.in_x3123_tmp0_SRAM_conv_1} ; io.in_x3123_tmp0_SRAM_conv_1 := DontCare
    def x2679_i0_pad_DRAM = {io.in_x2679_i0_pad_DRAM} 
    def x3129_tmp0_SRAM_conv_7 = {io.in_x3129_tmp0_SRAM_conv_7} ; io.in_x3129_tmp0_SRAM_conv_7 := DontCare
    def x3127_tmp0_SRAM_conv_5 = {io.in_x3127_tmp0_SRAM_conv_5} ; io.in_x3127_tmp0_SRAM_conv_5 := DontCare
    def x3124_tmp0_SRAM_conv_2 = {io.in_x3124_tmp0_SRAM_conv_2} ; io.in_x3124_tmp0_SRAM_conv_2 := DontCare
    def x3232 = {io.in_x3232} 
    def x3132_c101_SRAM_0 = {io.in_x3132_c101_SRAM_0} ; io.in_x3132_c101_SRAM_0 := DontCare
    def x3128_tmp0_SRAM_conv_6 = {io.in_x3128_tmp0_SRAM_conv_6} ; io.in_x3128_tmp0_SRAM_conv_6 := DontCare
  }
  def connectWires0(module: x3700_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x3230 <> x3230
    module.io.in_b3121 <> b3121
    x3131_tmp0_SRAM_conv_9.connectLedger(module.io.in_x3131_tmp0_SRAM_conv_9)
    x3125_tmp0_SRAM_conv_3.connectLedger(module.io.in_x3125_tmp0_SRAM_conv_3)
    x3122_tmp0_SRAM_conv_0.connectLedger(module.io.in_x3122_tmp0_SRAM_conv_0)
    x3126_tmp0_SRAM_conv_4.connectLedger(module.io.in_x3126_tmp0_SRAM_conv_4)
    x3130_tmp0_SRAM_conv_8.connectLedger(module.io.in_x3130_tmp0_SRAM_conv_8)
    x3123_tmp0_SRAM_conv_1.connectLedger(module.io.in_x3123_tmp0_SRAM_conv_1)
    module.io.in_x2679_i0_pad_DRAM <> x2679_i0_pad_DRAM
    x3129_tmp0_SRAM_conv_7.connectLedger(module.io.in_x3129_tmp0_SRAM_conv_7)
    x3127_tmp0_SRAM_conv_5.connectLedger(module.io.in_x3127_tmp0_SRAM_conv_5)
    x3124_tmp0_SRAM_conv_2.connectLedger(module.io.in_x3124_tmp0_SRAM_conv_2)
    module.io.in_x3232 <> x3232
    x3132_c101_SRAM_0.connectLedger(module.io.in_x3132_c101_SRAM_0)
    x3128_tmp0_SRAM_conv_6.connectLedger(module.io.in_x3128_tmp0_SRAM_conv_6)
  }
  val x3230 = list_x3230(0)
  val x3232 = list_x3232(0)
  val x3131_tmp0_SRAM_conv_9 = list_x3131_tmp0_SRAM_conv_9(0)
  val x3125_tmp0_SRAM_conv_3 = list_x3131_tmp0_SRAM_conv_9(1)
  val x3122_tmp0_SRAM_conv_0 = list_x3131_tmp0_SRAM_conv_9(2)
  val x3126_tmp0_SRAM_conv_4 = list_x3131_tmp0_SRAM_conv_9(3)
  val x3130_tmp0_SRAM_conv_8 = list_x3131_tmp0_SRAM_conv_9(4)
  val x3123_tmp0_SRAM_conv_1 = list_x3131_tmp0_SRAM_conv_9(5)
  val x3127_tmp0_SRAM_conv_5 = list_x3131_tmp0_SRAM_conv_9(6)
  val x3124_tmp0_SRAM_conv_2 = list_x3131_tmp0_SRAM_conv_9(7)
  val x3132_c101_SRAM_0 = list_x3131_tmp0_SRAM_conv_9(8)
  val x3128_tmp0_SRAM_conv_6 = list_x3131_tmp0_SRAM_conv_9(9)
  val x3129_tmp0_SRAM_conv_7 = list_x3129_tmp0_SRAM_conv_7(0)
  val x2679_i0_pad_DRAM = list_x2679_i0_pad_DRAM(0)
  val b3121 = list_b3121(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3700_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3700_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3700_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3214 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b3214.suggestName("b3214")
      val b3215 = ~io.sigsIn.cchainOutputs.head.oobs(0); b3215.suggestName("b3215")
      val x3216_lb0_0 = (new x3216_lb0_0).m.io.asInstanceOf[NBufInterface]
      val x3217_ctr = new CtrObject(Left(Some(0)), Left(Some(115)), Left(Some(1)), 1, 32, false)
      val x3218_ctrchain = (new CChainObject(List[CtrObject](x3217_ctr), "x3218_ctrchain")).cchain.io 
      x3218_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x3218_ctrchain_p", (x3218_ctrchain.par, x3218_ctrchain.widths))
      val x3699_outr_Foreach = new x3699_outr_Foreach_kernel(List(x3230), List(x3232), List(b3121,b3215), List(x2679_i0_pad_DRAM,b3214), List(x3129_tmp0_SRAM_conv_7), List(x3131_tmp0_SRAM_conv_9,x3125_tmp0_SRAM_conv_3,x3216_lb0_0,x3122_tmp0_SRAM_conv_0,x3126_tmp0_SRAM_conv_4,x3130_tmp0_SRAM_conv_8,x3123_tmp0_SRAM_conv_1,x3127_tmp0_SRAM_conv_5,x3124_tmp0_SRAM_conv_2,x3132_c101_SRAM_0,x3128_tmp0_SRAM_conv_6) , Some(me), List(x3218_ctrchain), 0, 3, 1, List(1), List(32), breakpoints, rr)
      x3699_outr_Foreach.sm.io.ctrDone := (x3699_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x3699_outr_Foreach.backpressure := true.B | x3699_outr_Foreach.sm.io.doneLatch
      x3699_outr_Foreach.forwardpressure := true.B | x3699_outr_Foreach.sm.io.doneLatch
      x3699_outr_Foreach.sm.io.enableOut.zip(x3699_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x3699_outr_Foreach.sm.io.break := false.B
      x3699_outr_Foreach.mask := ~x3699_outr_Foreach.cchain.head.output.noop & b3215 & b3121
      x3699_outr_Foreach.configure("x3699_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3699_outr_Foreach.kernel()
      x3122_tmp0_SRAM_conv_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x3123_tmp0_SRAM_conv_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x3124_tmp0_SRAM_conv_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x3125_tmp0_SRAM_conv_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x3126_tmp0_SRAM_conv_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x3127_tmp0_SRAM_conv_5.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x3128_tmp0_SRAM_conv_6.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x3130_tmp0_SRAM_conv_8.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x3131_tmp0_SRAM_conv_9.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x3132_c101_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x3700_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3700_outr_Foreach **/
