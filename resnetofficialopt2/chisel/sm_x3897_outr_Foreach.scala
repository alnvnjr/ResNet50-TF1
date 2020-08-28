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

/** Hierarchy: x3897 -> x3898 -> x1256 **/
/** BEGIN None x3897_outr_Foreach **/
class x3897_outr_Foreach_kernel(
  list_x3098_c27_SRAM_0: List[StandardInterface],
  list_x3871: List[DecoupledIO[Bool]],
  list_x3131_tmp0_SRAM_conv_9: List[NBufInterface],
  list_b3120: List[FixedPoint],
  list_x3870: List[DecoupledIO[AppStoreData]],
  list_x3869: List[DecoupledIO[AppCommandDense]],
  list_b3121: List[Bool],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 3, isFSM = false   , latency = 0.0.toInt, myName = "x3897_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3897_outr_Foreach_iiCtr"))
  
  abstract class x3897_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3098_c27_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3098_c27_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_b3120 = Input(new FixedPoint(true, 32, 0))
      val in_b3121 = Input(Bool())
      val in_x3131_tmp0_SRAM_conv_9 = Flipped(new NBufInterface(ModuleParams.getParams("x3131_tmp0_SRAM_conv_9_p").asInstanceOf[NBufParams] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3125_tmp0_SRAM_conv_3 = Flipped(new NBufInterface(ModuleParams.getParams("x3125_tmp0_SRAM_conv_3_p").asInstanceOf[NBufParams] ))
      val in_x3870 = Decoupled(new AppStoreData(ModuleParams.getParams("x3870_p").asInstanceOf[(Int,Int)] ))
      val in_x3122_tmp0_SRAM_conv_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3122_tmp0_SRAM_conv_0_p").asInstanceOf[NBufParams] ))
      val in_x3126_tmp0_SRAM_conv_4 = Flipped(new NBufInterface(ModuleParams.getParams("x3126_tmp0_SRAM_conv_4_p").asInstanceOf[NBufParams] ))
      val in_x3130_tmp0_SRAM_conv_8 = Flipped(new NBufInterface(ModuleParams.getParams("x3130_tmp0_SRAM_conv_8_p").asInstanceOf[NBufParams] ))
      val in_x3871 = Flipped(Decoupled(Bool()))
      val in_x3123_tmp0_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x3123_tmp0_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_x3127_tmp0_SRAM_conv_5 = Flipped(new NBufInterface(ModuleParams.getParams("x3127_tmp0_SRAM_conv_5_p").asInstanceOf[NBufParams] ))
      val in_x3124_tmp0_SRAM_conv_2 = Flipped(new NBufInterface(ModuleParams.getParams("x3124_tmp0_SRAM_conv_2_p").asInstanceOf[NBufParams] ))
      val in_x3128_tmp0_SRAM_conv_6 = Flipped(new NBufInterface(ModuleParams.getParams("x3128_tmp0_SRAM_conv_6_p").asInstanceOf[NBufParams] ))
      val in_x3869 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3869_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 1))
      val rr = Input(Bool())
    })
    def x3098_c27_SRAM_0 = {io.in_x3098_c27_SRAM_0} ; io.in_x3098_c27_SRAM_0 := DontCare
    def b3120 = {io.in_b3120} 
    def b3121 = {io.in_b3121} 
    def x3131_tmp0_SRAM_conv_9 = {io.in_x3131_tmp0_SRAM_conv_9} ; io.in_x3131_tmp0_SRAM_conv_9 := DontCare
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3125_tmp0_SRAM_conv_3 = {io.in_x3125_tmp0_SRAM_conv_3} ; io.in_x3125_tmp0_SRAM_conv_3 := DontCare
    def x3870 = {io.in_x3870} 
    def x3122_tmp0_SRAM_conv_0 = {io.in_x3122_tmp0_SRAM_conv_0} ; io.in_x3122_tmp0_SRAM_conv_0 := DontCare
    def x3126_tmp0_SRAM_conv_4 = {io.in_x3126_tmp0_SRAM_conv_4} ; io.in_x3126_tmp0_SRAM_conv_4 := DontCare
    def x3130_tmp0_SRAM_conv_8 = {io.in_x3130_tmp0_SRAM_conv_8} ; io.in_x3130_tmp0_SRAM_conv_8 := DontCare
    def x3871 = {io.in_x3871} 
    def x3123_tmp0_SRAM_conv_1 = {io.in_x3123_tmp0_SRAM_conv_1} ; io.in_x3123_tmp0_SRAM_conv_1 := DontCare
    def x3127_tmp0_SRAM_conv_5 = {io.in_x3127_tmp0_SRAM_conv_5} ; io.in_x3127_tmp0_SRAM_conv_5 := DontCare
    def x3124_tmp0_SRAM_conv_2 = {io.in_x3124_tmp0_SRAM_conv_2} ; io.in_x3124_tmp0_SRAM_conv_2 := DontCare
    def x3128_tmp0_SRAM_conv_6 = {io.in_x3128_tmp0_SRAM_conv_6} ; io.in_x3128_tmp0_SRAM_conv_6 := DontCare
    def x3869 = {io.in_x3869} 
  }
  def connectWires0(module: x3897_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x3098_c27_SRAM_0.connectLedger(module.io.in_x3098_c27_SRAM_0)
    module.io.in_b3120 <> b3120
    module.io.in_b3121 <> b3121
    x3131_tmp0_SRAM_conv_9.connectLedger(module.io.in_x3131_tmp0_SRAM_conv_9)
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3125_tmp0_SRAM_conv_3.connectLedger(module.io.in_x3125_tmp0_SRAM_conv_3)
    module.io.in_x3870 <> x3870
    x3122_tmp0_SRAM_conv_0.connectLedger(module.io.in_x3122_tmp0_SRAM_conv_0)
    x3126_tmp0_SRAM_conv_4.connectLedger(module.io.in_x3126_tmp0_SRAM_conv_4)
    x3130_tmp0_SRAM_conv_8.connectLedger(module.io.in_x3130_tmp0_SRAM_conv_8)
    module.io.in_x3871 <> x3871
    x3123_tmp0_SRAM_conv_1.connectLedger(module.io.in_x3123_tmp0_SRAM_conv_1)
    x3127_tmp0_SRAM_conv_5.connectLedger(module.io.in_x3127_tmp0_SRAM_conv_5)
    x3124_tmp0_SRAM_conv_2.connectLedger(module.io.in_x3124_tmp0_SRAM_conv_2)
    x3128_tmp0_SRAM_conv_6.connectLedger(module.io.in_x3128_tmp0_SRAM_conv_6)
    module.io.in_x3869 <> x3869
  }
  val x3098_c27_SRAM_0 = list_x3098_c27_SRAM_0(0)
  val x3871 = list_x3871(0)
  val x3131_tmp0_SRAM_conv_9 = list_x3131_tmp0_SRAM_conv_9(0)
  val x3125_tmp0_SRAM_conv_3 = list_x3131_tmp0_SRAM_conv_9(1)
  val x3122_tmp0_SRAM_conv_0 = list_x3131_tmp0_SRAM_conv_9(2)
  val x3126_tmp0_SRAM_conv_4 = list_x3131_tmp0_SRAM_conv_9(3)
  val x3130_tmp0_SRAM_conv_8 = list_x3131_tmp0_SRAM_conv_9(4)
  val x3123_tmp0_SRAM_conv_1 = list_x3131_tmp0_SRAM_conv_9(5)
  val x3127_tmp0_SRAM_conv_5 = list_x3131_tmp0_SRAM_conv_9(6)
  val x3124_tmp0_SRAM_conv_2 = list_x3131_tmp0_SRAM_conv_9(7)
  val x3128_tmp0_SRAM_conv_6 = list_x3131_tmp0_SRAM_conv_9(8)
  val b3120 = list_b3120(0)
  val x2682_tmp_DRAM = list_b3120(1)
  val x3870 = list_x3870(0)
  val x3869 = list_x3869(0)
  val b3121 = list_b3121(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3897_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3897_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3897_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3703 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b3703.suggestName("b3703")
      val b3703_chain = Module(new RegChainPass(3, 32, myName = "b3703_chain")); b3703_chain.io <> DontCare
      b3703_chain.chain_pass(b3703, io.sigsOut.smDoneIn.head)
      val b3703_chain_read_1 = b3703_chain.read(1).FP(true,32,0)
      val b3703_chain_read_2 = b3703_chain.read(2).FP(true,32,0)
      val b3704 = ~io.sigsIn.cchainOutputs.head.oobs(0); b3704.suggestName("b3704")
      val b3704_chain = Module(new RegChainPass(3, 1, myName = "b3704_chain")); b3704_chain.io <> DontCare
      b3704_chain.chain_pass(b3704, io.sigsOut.smDoneIn.head)
      val b3704_chain_read_1: Bool = b3704_chain.read(1).apply(0)
      val b3704_chain_read_2: Bool = b3704_chain.read(2).apply(0)
      val x3705_tmp0_SRAM_pool_0 = (new x3705_tmp0_SRAM_pool_0).m.io.asInstanceOf[NBufInterface]
      val x3706_ctr = new CtrObject(Left(Some(0)), Left(Some(56)), Left(Some(1)), 1, 32, false)
      val x3707_ctr = new CtrObject(Left(Some(0)), Left(Some(56)), Left(Some(1)), 1, 32, false)
      val x3708_ctrchain = (new CChainObject(List[CtrObject](x3706_ctr,x3707_ctr), "x3708_ctrchain")).cchain.io 
      x3708_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x3708_ctrchain_p", (x3708_ctrchain.par, x3708_ctrchain.widths))
      val x3863_inr_Foreach = new x3863_inr_Foreach_kernel(List(b3121,b3704), List(b3120,b3703), List(x3131_tmp0_SRAM_conv_9,x3125_tmp0_SRAM_conv_3,x3122_tmp0_SRAM_conv_0,x3126_tmp0_SRAM_conv_4,x3130_tmp0_SRAM_conv_8,x3123_tmp0_SRAM_conv_1,x3127_tmp0_SRAM_conv_5,x3124_tmp0_SRAM_conv_2,x3705_tmp0_SRAM_pool_0,x3128_tmp0_SRAM_conv_6), List(x3098_c27_SRAM_0) , Some(me), List(x3708_ctrchain), 0, 1, 1, List(1, 1), List(32, 32), breakpoints, rr)
      x3863_inr_Foreach.sm.io.ctrDone := (x3863_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b3703_chain.connectStageCtrl((x3863_inr_Foreach.done).DS(1.toInt, rr, x3863_inr_Foreach.sm.io.backpressure), x3863_inr_Foreach.baseEn, 0)
      b3704_chain.connectStageCtrl((x3863_inr_Foreach.done).DS(1.toInt, rr, x3863_inr_Foreach.sm.io.backpressure), x3863_inr_Foreach.baseEn, 0)
      x3863_inr_Foreach.backpressure := true.B | x3863_inr_Foreach.sm.io.doneLatch
      x3863_inr_Foreach.forwardpressure := true.B | x3863_inr_Foreach.sm.io.doneLatch
      x3863_inr_Foreach.sm.io.enableOut.zip(x3863_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x3863_inr_Foreach.sm.io.break := false.B
      x3863_inr_Foreach.mask := ~x3863_inr_Foreach.cchain.head.output.noop & b3704 & b3121
      x3863_inr_Foreach.configure("x3863_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3863_inr_Foreach.kernel()
      val x3864_reg = (new x3864_reg).m.io.asInstanceOf[NBufInterface]
      val x3868_inr_UnitPipe = new x3868_inr_UnitPipe_kernel(List(b3121,b3704_chain_read_1), List(b3120,b3703_chain_read_1), List(x3864_reg,x3705_tmp0_SRAM_pool_0) , Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x3868_inr_UnitPipe.sm.io.ctrDone := risingEdge(x3868_inr_UnitPipe.sm.io.ctrInc)
      b3703_chain.connectStageCtrl((x3868_inr_UnitPipe.done).DS(1.toInt, rr, x3868_inr_UnitPipe.sm.io.backpressure), x3868_inr_UnitPipe.baseEn, 1)
      b3704_chain.connectStageCtrl((x3868_inr_UnitPipe.done).DS(1.toInt, rr, x3868_inr_UnitPipe.sm.io.backpressure), x3868_inr_UnitPipe.baseEn, 1)
      x3868_inr_UnitPipe.backpressure := true.B | x3868_inr_UnitPipe.sm.io.doneLatch
      x3868_inr_UnitPipe.forwardpressure := true.B | x3868_inr_UnitPipe.sm.io.doneLatch
      x3868_inr_UnitPipe.sm.io.enableOut.zip(x3868_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3868_inr_UnitPipe.sm.io.break := false.B
      x3868_inr_UnitPipe.mask := true.B & b3704_chain_read_1 & b3121
      x3868_inr_UnitPipe.configure("x3868_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3868_inr_UnitPipe.kernel()
      val x3896_outr_UnitPipe = new x3896_outr_UnitPipe_kernel(List(x3871), List(x3864_reg,x3705_tmp0_SRAM_pool_0), List(x3870), List(b3121,b3704_chain_read_2), List(x3869), List(x2682_tmp_DRAM) , Some(me), List(), 2, 3, 3, List(1), List(32), breakpoints, rr)
      b3703_chain.connectStageCtrl((x3896_outr_UnitPipe.done).DS(1.toInt, rr, x3896_outr_UnitPipe.sm.io.backpressure), x3896_outr_UnitPipe.baseEn, 2)
      b3704_chain.connectStageCtrl((x3896_outr_UnitPipe.done).DS(1.toInt, rr, x3896_outr_UnitPipe.sm.io.backpressure), x3896_outr_UnitPipe.baseEn, 2)
      x3896_outr_UnitPipe.backpressure := true.B | x3896_outr_UnitPipe.sm.io.doneLatch
      x3896_outr_UnitPipe.forwardpressure := true.B | x3896_outr_UnitPipe.sm.io.doneLatch
      x3896_outr_UnitPipe.sm.io.enableOut.zip(x3896_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3896_outr_UnitPipe.sm.io.break := false.B
      x3896_outr_UnitPipe.mask := true.B & b3704_chain_read_2 & b3121
      x3896_outr_UnitPipe.configure("x3896_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3896_outr_UnitPipe.kernel()
      x3122_tmp0_SRAM_conv_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x3123_tmp0_SRAM_conv_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x3124_tmp0_SRAM_conv_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x3125_tmp0_SRAM_conv_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x3126_tmp0_SRAM_conv_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x3127_tmp0_SRAM_conv_5.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x3128_tmp0_SRAM_conv_6.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x3130_tmp0_SRAM_conv_8.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x3131_tmp0_SRAM_conv_9.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x3897_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3897_outr_Foreach **/
