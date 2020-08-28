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

/** Hierarchy: x3898 -> x1256 **/
/** BEGIN None x3898_outr_Foreach **/
class x3898_outr_Foreach_kernel(
  list_x3098_c27_SRAM_0: List[StandardInterface],
  list_x3871: List[DecoupledIO[Bool]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x3230: List[DecoupledIO[AppCommandDense]],
  list_x3142: List[DecoupledIO[AppLoadData]],
  list_x3870: List[DecoupledIO[AppStoreData]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 3, isFSM = false   , latency = 0.0.toInt, myName = "x3898_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3898_outr_Foreach_iiCtr"))
  
  abstract class x3898_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3230 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3230_p").asInstanceOf[(Int,Int)] ))
      val in_x3098_c27_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3098_c27_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x3140 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3140_p").asInstanceOf[(Int,Int)] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3870 = Decoupled(new AppStoreData(ModuleParams.getParams("x3870_p").asInstanceOf[(Int,Int)] ))
      val in_x3871 = Flipped(Decoupled(Bool()))
      val in_x2679_i0_pad_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3066_c101_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3142 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3142_p").asInstanceOf[(Int, Int)] )))
      val in_x3232 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3232_p").asInstanceOf[(Int, Int)] )))
      val in_x3869 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3869_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 1))
      val rr = Input(Bool())
    })
    def x3230 = {io.in_x3230} 
    def x3098_c27_SRAM_0 = {io.in_x3098_c27_SRAM_0} ; io.in_x3098_c27_SRAM_0 := DontCare
    def x3140 = {io.in_x3140} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3870 = {io.in_x3870} 
    def x3871 = {io.in_x3871} 
    def x2679_i0_pad_DRAM = {io.in_x2679_i0_pad_DRAM} 
    def x3066_c101_DRAM = {io.in_x3066_c101_DRAM} 
    def x3142 = {io.in_x3142} 
    def x3232 = {io.in_x3232} 
    def x3869 = {io.in_x3869} 
  }
  def connectWires0(module: x3898_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x3230 <> x3230
    x3098_c27_SRAM_0.connectLedger(module.io.in_x3098_c27_SRAM_0)
    module.io.in_x3140 <> x3140
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x3870 <> x3870
    module.io.in_x3871 <> x3871
    module.io.in_x2679_i0_pad_DRAM <> x2679_i0_pad_DRAM
    module.io.in_x3066_c101_DRAM <> x3066_c101_DRAM
    module.io.in_x3142 <> x3142
    module.io.in_x3232 <> x3232
    module.io.in_x3869 <> x3869
  }
  val x3098_c27_SRAM_0 = list_x3098_c27_SRAM_0(0)
  val x3871 = list_x3871(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x2679_i0_pad_DRAM = list_x2682_tmp_DRAM(1)
  val x3066_c101_DRAM = list_x2682_tmp_DRAM(2)
  val x3230 = list_x3230(0)
  val x3140 = list_x3230(1)
  val x3869 = list_x3230(2)
  val x3142 = list_x3142(0)
  val x3232 = list_x3142(1)
  val x3870 = list_x3870(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3898_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3898_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3898_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3120 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b3120.suggestName("b3120")
      val b3120_chain = Module(new RegChainPass(3, 32, myName = "b3120_chain")); b3120_chain.io <> DontCare
      b3120_chain.chain_pass(b3120, io.sigsOut.smDoneIn.head)
      val b3120_chain_read_1 = b3120_chain.read(1).FP(true,32,0)
      val b3120_chain_read_2 = b3120_chain.read(2).FP(true,32,0)
      val b3121 = ~io.sigsIn.cchainOutputs.head.oobs(0); b3121.suggestName("b3121")
      val b3121_chain = Module(new RegChainPass(3, 1, myName = "b3121_chain")); b3121_chain.io <> DontCare
      b3121_chain.chain_pass(b3121, io.sigsOut.smDoneIn.head)
      val b3121_chain_read_1: Bool = b3121_chain.read(1).apply(0)
      val b3121_chain_read_2: Bool = b3121_chain.read(2).apply(0)
      val x3122_tmp0_SRAM_conv_0 = (new x3122_tmp0_SRAM_conv_0).m.io.asInstanceOf[NBufInterface]
      val x3123_tmp0_SRAM_conv_1 = (new x3123_tmp0_SRAM_conv_1).m.io.asInstanceOf[NBufInterface]
      val x3124_tmp0_SRAM_conv_2 = (new x3124_tmp0_SRAM_conv_2).m.io.asInstanceOf[NBufInterface]
      val x3125_tmp0_SRAM_conv_3 = (new x3125_tmp0_SRAM_conv_3).m.io.asInstanceOf[NBufInterface]
      val x3126_tmp0_SRAM_conv_4 = (new x3126_tmp0_SRAM_conv_4).m.io.asInstanceOf[NBufInterface]
      val x3127_tmp0_SRAM_conv_5 = (new x3127_tmp0_SRAM_conv_5).m.io.asInstanceOf[NBufInterface]
      val x3128_tmp0_SRAM_conv_6 = (new x3128_tmp0_SRAM_conv_6).m.io.asInstanceOf[NBufInterface]
      val x3129_tmp0_SRAM_conv_7 = (new x3129_tmp0_SRAM_conv_7).m.io.asInstanceOf[StandardInterface]
      val x3130_tmp0_SRAM_conv_8 = (new x3130_tmp0_SRAM_conv_8).m.io.asInstanceOf[NBufInterface]
      val x3131_tmp0_SRAM_conv_9 = (new x3131_tmp0_SRAM_conv_9).m.io.asInstanceOf[NBufInterface]
      val x3132_c101_SRAM_0 = (new x3132_c101_SRAM_0).m.io.asInstanceOf[NBufInterface]
      val x3133_ctr = new CtrObject(Left(Some(0)), Left(Some(2)), Left(Some(1)), 1, 32, false)
      val x3134_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 32, false)
      val x3135_ctrchain_copyx3170_inr_UnitPipe = (new CChainObject(List[CtrObject](x3133_ctr,x3134_ctr), "x3135_ctrchain_copyx3170_inr_UnitPipe")).cchain.io 
      x3135_ctrchain_copyx3170_inr_UnitPipe.setup.isStream := false.B
      ModuleParams.addParams("x3135_ctrchain_p", (x3135_ctrchain_copyx3170_inr_UnitPipe.par, x3135_ctrchain_copyx3170_inr_UnitPipe.widths))
      val x3135_ctrchain_copyx3210_outr_UnitPipe = (new CChainObject(List[CtrObject](x3133_ctr,x3134_ctr), "x3135_ctrchain_copyx3210_outr_UnitPipe")).cchain.io 
      x3135_ctrchain_copyx3210_outr_UnitPipe.setup.isStream := false.B
      ModuleParams.addParams("x3135_ctrchain_p", (x3135_ctrchain_copyx3170_inr_UnitPipe.par, x3135_ctrchain_copyx3170_inr_UnitPipe.widths))
      val x3211_outr_Foreach = new x3211_outr_Foreach_kernel(List(x3140), List(x3132_c101_SRAM_0), List(b3120,x3066_c101_DRAM), List(x3142), List(b3121) , Some(me), List(x3135_ctrchain_copyx3170_inr_UnitPipe,x3135_ctrchain_copyx3210_outr_UnitPipe), 0, 2, 2, List(1, 1), List(32, 32), breakpoints, rr)
      b3120_chain.connectStageCtrl((x3211_outr_Foreach.done).DS(1.toInt, rr, x3211_outr_Foreach.sm.io.backpressure), x3211_outr_Foreach.baseEn, 0)
      b3121_chain.connectStageCtrl((x3211_outr_Foreach.done).DS(1.toInt, rr, x3211_outr_Foreach.sm.io.backpressure), x3211_outr_Foreach.baseEn, 0)
      x3211_outr_Foreach.backpressure := true.B | x3211_outr_Foreach.sm.io.doneLatch
      x3211_outr_Foreach.forwardpressure := true.B | x3211_outr_Foreach.sm.io.doneLatch
      x3211_outr_Foreach.sm.io.enableOut.zip(x3211_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x3211_outr_Foreach.sm.io.break := false.B
      x3211_outr_Foreach.mask := ~x3211_outr_Foreach.cchain.head.output.noop & b3121
      x3211_outr_Foreach.configure("x3211_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3211_outr_Foreach.kernel()
      val x3212_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 32, false)
      val x3213_ctrchain = (new CChainObject(List[CtrObject](x3212_ctr), "x3213_ctrchain")).cchain.io 
      x3213_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x3213_ctrchain_p", (x3213_ctrchain.par, x3213_ctrchain.widths))
      val x3700_outr_Foreach = new x3700_outr_Foreach_kernel(List(x3230), List(x3232), List(x3131_tmp0_SRAM_conv_9,x3125_tmp0_SRAM_conv_3,x3122_tmp0_SRAM_conv_0,x3126_tmp0_SRAM_conv_4,x3130_tmp0_SRAM_conv_8,x3123_tmp0_SRAM_conv_1,x3127_tmp0_SRAM_conv_5,x3124_tmp0_SRAM_conv_2,x3132_c101_SRAM_0,x3128_tmp0_SRAM_conv_6), List(x3129_tmp0_SRAM_conv_7), List(x2679_i0_pad_DRAM), List(b3121_chain_read_1) , Some(me), List(x3213_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x3700_outr_Foreach.sm.io.ctrDone := (x3700_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b3120_chain.connectStageCtrl((x3700_outr_Foreach.done).DS(1.toInt, rr, x3700_outr_Foreach.sm.io.backpressure), x3700_outr_Foreach.baseEn, 1)
      b3121_chain.connectStageCtrl((x3700_outr_Foreach.done).DS(1.toInt, rr, x3700_outr_Foreach.sm.io.backpressure), x3700_outr_Foreach.baseEn, 1)
      x3700_outr_Foreach.backpressure := true.B | x3700_outr_Foreach.sm.io.doneLatch
      x3700_outr_Foreach.forwardpressure := true.B | x3700_outr_Foreach.sm.io.doneLatch
      x3700_outr_Foreach.sm.io.enableOut.zip(x3700_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x3700_outr_Foreach.sm.io.break := false.B
      x3700_outr_Foreach.mask := ~x3700_outr_Foreach.cchain.head.output.noop & b3121_chain_read_1
      x3700_outr_Foreach.configure("x3700_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3700_outr_Foreach.kernel()
      val x3701_ctr = new CtrObject(Left(Some(0)), Left(Some(2)), Left(Some(1)), 1, 32, false)
      val x3702_ctrchain = (new CChainObject(List[CtrObject](x3701_ctr), "x3702_ctrchain")).cchain.io 
      x3702_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x3702_ctrchain_p", (x3702_ctrchain.par, x3702_ctrchain.widths))
      val x3897_outr_Foreach = new x3897_outr_Foreach_kernel(List(x3098_c27_SRAM_0), List(x3871), List(x3131_tmp0_SRAM_conv_9,x3125_tmp0_SRAM_conv_3,x3122_tmp0_SRAM_conv_0,x3126_tmp0_SRAM_conv_4,x3130_tmp0_SRAM_conv_8,x3123_tmp0_SRAM_conv_1,x3127_tmp0_SRAM_conv_5,x3124_tmp0_SRAM_conv_2,x3128_tmp0_SRAM_conv_6), List(b3120_chain_read_2,x2682_tmp_DRAM), List(x3870), List(x3869), List(b3121_chain_read_2) , Some(me), List(x3702_ctrchain), 2, 3, 1, List(1), List(32), breakpoints, rr)
      x3897_outr_Foreach.sm.io.ctrDone := (x3897_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b3120_chain.connectStageCtrl((x3897_outr_Foreach.done).DS(1.toInt, rr, x3897_outr_Foreach.sm.io.backpressure), x3897_outr_Foreach.baseEn, 2)
      b3121_chain.connectStageCtrl((x3897_outr_Foreach.done).DS(1.toInt, rr, x3897_outr_Foreach.sm.io.backpressure), x3897_outr_Foreach.baseEn, 2)
      x3897_outr_Foreach.backpressure := true.B | x3897_outr_Foreach.sm.io.doneLatch
      x3897_outr_Foreach.forwardpressure := true.B | x3897_outr_Foreach.sm.io.doneLatch
      x3897_outr_Foreach.sm.io.enableOut.zip(x3897_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x3897_outr_Foreach.sm.io.break := false.B
      x3897_outr_Foreach.mask := ~x3897_outr_Foreach.cchain.head.output.noop & b3121_chain_read_2
      x3897_outr_Foreach.configure("x3897_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3897_outr_Foreach.kernel()
    }
    val module = Module(new x3898_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3898_outr_Foreach **/
