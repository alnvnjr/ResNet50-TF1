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

/** Hierarchy: x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9344_outr_Foreach **/
class x9344_outr_Foreach_kernel(
  list_x4062_out_SRAM_conv_1: List[NBufInterface],
  list_x3942_reg: List[StandardInterface],
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_b4060: List[Bool],
  list_x4085: List[DecoupledIO[AppLoadData]],
  list_x4336: List[DecoupledIO[AppCommandDense]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 6, isFSM = false   , latency = 0.0.toInt, myName = "x9344_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9344_outr_Foreach_iiCtr"))
  
  abstract class x9344_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4062_out_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x4062_out_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_x3942_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3942_reg_p").asInstanceOf[MemParams] ))
      val in_x3947_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3947_reg_p").asInstanceOf[MemParams] ))
      val in_x3938_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3938_reg_p").asInstanceOf[MemParams] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3919_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3919_reg_p").asInstanceOf[MemParams] ))
      val in_b4059 = Input(new FixedPoint(true, 32, 0))
      val in_x3935_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3935_reg_p").asInstanceOf[MemParams] ))
      val in_x3937_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3937_reg_p").asInstanceOf[MemParams] ))
      val in_b4060 = Input(Bool())
      val in_x4085 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4085_p").asInstanceOf[(Int, Int)] )))
      val in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x4336 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4336_p").asInstanceOf[(Int,Int)] ))
      val in_x3940_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3940_reg_p").asInstanceOf[MemParams] ))
      val in_x3946_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3946_reg_p").asInstanceOf[MemParams] ))
      val in_x4061_out_SRAM_conv_0 = Flipped(new StandardInterface(ModuleParams.getParams("x4061_out_SRAM_conv_0_p").asInstanceOf[MemParams] ))
      val in_x4338 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4338_p").asInstanceOf[(Int, Int)] )))
      val in_x4083 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4083_p").asInstanceOf[(Int,Int)] ))
      val in_x3939_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3939_reg_p").asInstanceOf[MemParams] ))
      val in_x3918_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3918_reg_p").asInstanceOf[MemParams] ))
      val in_x18772_rd_x3918 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(6, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(6, 1))
      val rr = Input(Bool())
    })
    def x4062_out_SRAM_conv_1 = {io.in_x4062_out_SRAM_conv_1} ; io.in_x4062_out_SRAM_conv_1 := DontCare
    def x3942_reg = {io.in_x3942_reg} ; io.in_x3942_reg := DontCare
    def x3947_reg = {io.in_x3947_reg} ; io.in_x3947_reg := DontCare
    def x3938_reg = {io.in_x3938_reg} ; io.in_x3938_reg := DontCare
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3919_reg = {io.in_x3919_reg} ; io.in_x3919_reg := DontCare
    def b4059 = {io.in_b4059} 
    def x3935_reg = {io.in_x3935_reg} ; io.in_x3935_reg := DontCare
    def x3937_reg = {io.in_x3937_reg} ; io.in_x3937_reg := DontCare
    def b4060 = {io.in_b4060} 
    def x4085 = {io.in_x4085} 
    def x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = {io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM} 
    def x4336 = {io.in_x4336} 
    def x3940_reg = {io.in_x3940_reg} ; io.in_x3940_reg := DontCare
    def x3946_reg = {io.in_x3946_reg} ; io.in_x3946_reg := DontCare
    def x4061_out_SRAM_conv_0 = {io.in_x4061_out_SRAM_conv_0} ; io.in_x4061_out_SRAM_conv_0 := DontCare
    def x4338 = {io.in_x4338} 
    def x4083 = {io.in_x4083} 
    def x3939_reg = {io.in_x3939_reg} ; io.in_x3939_reg := DontCare
    def x3918_reg = {io.in_x3918_reg} ; io.in_x3918_reg := DontCare
    def x18772_rd_x3918 = {io.in_x18772_rd_x3918} 
  }
  def connectWires0(module: x9344_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x4062_out_SRAM_conv_1.connectLedger(module.io.in_x4062_out_SRAM_conv_1)
    x3942_reg.connectLedger(module.io.in_x3942_reg)
    x3947_reg.connectLedger(module.io.in_x3947_reg)
    x3938_reg.connectLedger(module.io.in_x3938_reg)
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3919_reg.connectLedger(module.io.in_x3919_reg)
    module.io.in_b4059 <> b4059
    x3935_reg.connectLedger(module.io.in_x3935_reg)
    x3937_reg.connectLedger(module.io.in_x3937_reg)
    module.io.in_b4060 <> b4060
    module.io.in_x4085 <> x4085
    module.io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM <> x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM
    module.io.in_x4336 <> x4336
    x3940_reg.connectLedger(module.io.in_x3940_reg)
    x3946_reg.connectLedger(module.io.in_x3946_reg)
    x4061_out_SRAM_conv_0.connectLedger(module.io.in_x4061_out_SRAM_conv_0)
    module.io.in_x4338 <> x4338
    module.io.in_x4083 <> x4083
    x3939_reg.connectLedger(module.io.in_x3939_reg)
    x3918_reg.connectLedger(module.io.in_x3918_reg)
    module.io.in_x18772_rd_x3918 <> x18772_rd_x3918
  }
  val x4062_out_SRAM_conv_1 = list_x4062_out_SRAM_conv_1(0)
  val x3942_reg = list_x3942_reg(0)
  val x3947_reg = list_x3942_reg(1)
  val x3938_reg = list_x3942_reg(2)
  val x3919_reg = list_x3942_reg(3)
  val x3935_reg = list_x3942_reg(4)
  val x3937_reg = list_x3942_reg(5)
  val x3940_reg = list_x3942_reg(6)
  val x3946_reg = list_x3942_reg(7)
  val x4061_out_SRAM_conv_0 = list_x3942_reg(8)
  val x3939_reg = list_x3942_reg(9)
  val x3918_reg = list_x3942_reg(10)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b4059 = list_x2682_tmp_DRAM(1)
  val x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = list_x2682_tmp_DRAM(2)
  val b4060 = list_b4060(0)
  val x18772_rd_x3918 = list_b4060(1)
  val x4085 = list_x4085(0)
  val x4338 = list_x4085(1)
  val x4336 = list_x4336(0)
  val x4083 = list_x4336(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9344_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x9344_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9344_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b4067 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b4067.suggestName("b4067")
      val b4067_chain = Module(new RegChainPass(6, 32, myName = "b4067_chain")); b4067_chain.io <> DontCare
      b4067_chain.chain_pass(b4067, io.sigsOut.smDoneIn.head)
      val b4067_chain_read_1 = b4067_chain.read(1).FP(true,32,0)
      val b4067_chain_read_2 = b4067_chain.read(2).FP(true,32,0)
      val b4067_chain_read_3 = b4067_chain.read(3).FP(true,32,0)
      val b4067_chain_read_4 = b4067_chain.read(4).FP(true,32,0)
      val b4067_chain_read_5 = b4067_chain.read(5).FP(true,32,0)
      val b4068 = ~io.sigsIn.cchainOutputs.head.oobs(0); b4068.suggestName("b4068")
      val b4068_chain = Module(new RegChainPass(6, 1, myName = "b4068_chain")); b4068_chain.io <> DontCare
      b4068_chain.chain_pass(b4068, io.sigsOut.smDoneIn.head)
      val b4068_chain_read_1: Bool = b4068_chain.read(1).apply(0)
      val b4068_chain_read_2: Bool = b4068_chain.read(2).apply(0)
      val b4068_chain_read_3: Bool = b4068_chain.read(3).apply(0)
      val b4068_chain_read_4: Bool = b4068_chain.read(4).apply(0)
      val b4068_chain_read_5: Bool = b4068_chain.read(5).apply(0)
      val x4069_weight_SRAM_0 = (new x4069_weight_SRAM_0).m.io.asInstanceOf[NBufInterface]
      val x4070_reg = (new x4070_reg).m.io.asInstanceOf[NBufInterface]
      val x4071_reg = (new x4071_reg).m.io.asInstanceOf[NBufInterface]
      val x4072_reg = (new x4072_reg).m.io.asInstanceOf[NBufInterface]
      val x4082_inr_UnitPipe = new x4082_inr_UnitPipe_kernel(List(b4068,b4060), List(b4059,b4067), List(x4070_reg,x4072_reg,x4071_reg), List(x3947_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x4082_inr_UnitPipe.sm.io.ctrDone := risingEdge(x4082_inr_UnitPipe.sm.io.ctrInc)
      b4067_chain.connectStageCtrl((x4082_inr_UnitPipe.done).DS(1.toInt, rr, x4082_inr_UnitPipe.sm.io.backpressure), x4082_inr_UnitPipe.baseEn, 0)
      b4068_chain.connectStageCtrl((x4082_inr_UnitPipe.done).DS(1.toInt, rr, x4082_inr_UnitPipe.sm.io.backpressure), x4082_inr_UnitPipe.baseEn, 0)
      x4082_inr_UnitPipe.backpressure := true.B | x4082_inr_UnitPipe.sm.io.doneLatch
      x4082_inr_UnitPipe.forwardpressure := true.B | x4082_inr_UnitPipe.sm.io.doneLatch
      x4082_inr_UnitPipe.sm.io.enableOut.zip(x4082_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4082_inr_UnitPipe.sm.io.break := false.B
      x4082_inr_UnitPipe.mask := true.B & b4068 & b4060
      x4082_inr_UnitPipe.configure("x4082_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4082_inr_UnitPipe.kernel()
      val x4240_outr_UnitPipe = new x4240_outr_UnitPipe_kernel(List(x4085), List(x4083), List(b4068_chain_read_1,b4060), List(x4070_reg,x4072_reg,x4069_weight_SRAM_0,x4071_reg), List(x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM) , Some(me), List(), 1, 2, 2, List(1), List(32), breakpoints, rr)
      b4067_chain.connectStageCtrl((x4240_outr_UnitPipe.done).DS(1.toInt, rr, x4240_outr_UnitPipe.sm.io.backpressure), x4240_outr_UnitPipe.baseEn, 1)
      b4068_chain.connectStageCtrl((x4240_outr_UnitPipe.done).DS(1.toInt, rr, x4240_outr_UnitPipe.sm.io.backpressure), x4240_outr_UnitPipe.baseEn, 1)
      x4240_outr_UnitPipe.backpressure := true.B | x4240_outr_UnitPipe.sm.io.doneLatch
      x4240_outr_UnitPipe.forwardpressure := true.B | x4240_outr_UnitPipe.sm.io.doneLatch
      x4240_outr_UnitPipe.sm.io.enableOut.zip(x4240_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4240_outr_UnitPipe.sm.io.break := false.B
      x4240_outr_UnitPipe.mask := true.B & b4068_chain_read_1 & b4060
      x4240_outr_UnitPipe.configure("x4240_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4240_outr_UnitPipe.kernel()
      val x4241_weight_SRAM_reshape_0 = (new x4241_weight_SRAM_reshape_0).m.io.asInstanceOf[NBufInterface]
      val x4242_ctr = new CtrObject(Left(Some(0)), Left(Some(9)), Left(Some(1)), 1, 32, false)
      val x4243_ctr = new CtrObject(Left(Some(0)), Left(Some(32)), Left(Some(1)), 4, 32, false)
      val x4244_ctrchain = (new CChainObject(List[CtrObject](x4242_ctr,x4243_ctr), "x4244_ctrchain")).cchain.io 
      x4244_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x4244_ctrchain_p", (x4244_ctrchain.par, x4244_ctrchain.widths))
      val x18774_rd_x3918 = Wire(Bool()).suggestName("""x18774_rd_x3918""")
      val x18774_rd_x3918_banks = List[UInt]()
      val x18774_rd_x3918_ofs = List[UInt]()
      val x18774_rd_x3918_en = List[Bool](true.B)
      x18774_rd_x3918.toSeq.zip(x3918_reg.connectRPort(18774, x18774_rd_x3918_banks, x18774_rd_x3918_ofs, io.sigsIn.backpressure, x18774_rd_x3918_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4321_inr_Foreach = new x4321_inr_Foreach_kernel(List(x18774_rd_x3918,b4068_chain_read_2,b4060), List(x4069_weight_SRAM_0,x4241_weight_SRAM_reshape_0), List(x3919_reg) , Some(me), List(x4244_ctrchain), 2, 1, 1, List(1, 4), List(32, 32), breakpoints, rr)
      x4321_inr_Foreach.sm.io.ctrDone := (x4321_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b4067_chain.connectStageCtrl((x4321_inr_Foreach.done).DS(1.toInt, rr, x4321_inr_Foreach.sm.io.backpressure), x4321_inr_Foreach.baseEn, 2)
      b4068_chain.connectStageCtrl((x4321_inr_Foreach.done).DS(1.toInt, rr, x4321_inr_Foreach.sm.io.backpressure), x4321_inr_Foreach.baseEn, 2)
      x4321_inr_Foreach.backpressure := true.B | x4321_inr_Foreach.sm.io.doneLatch
      x4321_inr_Foreach.forwardpressure := true.B | x4321_inr_Foreach.sm.io.doneLatch
      x4321_inr_Foreach.sm.io.enableOut.zip(x4321_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x4321_inr_Foreach.sm.io.break := false.B
      x4321_inr_Foreach.mask := ~x4321_inr_Foreach.cchain.head.output.noop & b4068_chain_read_2 & b4060 & x18774_rd_x3918
      x4321_inr_Foreach.configure("x4321_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4321_inr_Foreach.kernel()
      val x4322_img2D_0 = (new x4322_img2D_0).m.io.asInstanceOf[NBufInterface]
      val x4323_img2D_1 = (new x4323_img2D_1).m.io.asInstanceOf[NBufInterface]
      val x4324_img2D_2 = (new x4324_img2D_2).m.io.asInstanceOf[NBufInterface]
      val x4325_img2D_3 = (new x4325_img2D_3).m.io.asInstanceOf[NBufInterface]
      val x4326_img2D_4 = (new x4326_img2D_4).m.io.asInstanceOf[NBufInterface]
      val x4327_img2D_5 = (new x4327_img2D_5).m.io.asInstanceOf[NBufInterface]
      val x4328_img2D_6 = (new x4328_img2D_6).m.io.asInstanceOf[NBufInterface]
      val x4329_img2D_7 = (new x4329_img2D_7).m.io.asInstanceOf[NBufInterface]
      val x4330_img2D_8 = (new x4330_img2D_8).m.io.asInstanceOf[NBufInterface]
      val x4331_reg = (new x4331_reg).m.io.asInstanceOf[NBufInterface]
      val x4335_inr_UnitPipe = new x4335_inr_UnitPipe_kernel(List(b4068_chain_read_3,b4060), List(b4067_chain_read_3), List(x4331_reg,x4241_weight_SRAM_reshape_0), List(x3935_reg) , Some(me), List(), 3, 1, 1, List(1), List(32), breakpoints, rr)
      x4335_inr_UnitPipe.sm.io.ctrDone := risingEdge(x4335_inr_UnitPipe.sm.io.ctrInc)
      b4067_chain.connectStageCtrl((x4335_inr_UnitPipe.done).DS(1.toInt, rr, x4335_inr_UnitPipe.sm.io.backpressure), x4335_inr_UnitPipe.baseEn, 3)
      b4068_chain.connectStageCtrl((x4335_inr_UnitPipe.done).DS(1.toInt, rr, x4335_inr_UnitPipe.sm.io.backpressure), x4335_inr_UnitPipe.baseEn, 3)
      x4335_inr_UnitPipe.backpressure := true.B | x4335_inr_UnitPipe.sm.io.doneLatch
      x4335_inr_UnitPipe.forwardpressure := true.B | x4335_inr_UnitPipe.sm.io.doneLatch
      x4335_inr_UnitPipe.sm.io.enableOut.zip(x4335_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4335_inr_UnitPipe.sm.io.break := false.B
      x4335_inr_UnitPipe.mask := true.B & b4068_chain_read_3 & b4060
      x4335_inr_UnitPipe.configure("x4335_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4335_inr_UnitPipe.kernel()
      val x4449_outr_UnitPipe = new x4449_outr_UnitPipe_kernel(List(x4326_img2D_4,x4322_img2D_0,x4329_img2D_7,x4323_img2D_1,x4327_img2D_5,x4328_img2D_6,x4331_reg,x4324_img2D_2,x4241_weight_SRAM_reshape_0,x4325_img2D_3,x4330_img2D_8), List(x4336), List(b4068_chain_read_4,b4060), List(x4338), List(x3935_reg,x3937_reg), List(x2682_tmp_DRAM) , Some(me), List(), 4, 2, 2, List(1), List(32), breakpoints, rr)
      b4067_chain.connectStageCtrl((x4449_outr_UnitPipe.done).DS(1.toInt, rr, x4449_outr_UnitPipe.sm.io.backpressure), x4449_outr_UnitPipe.baseEn, 4)
      b4068_chain.connectStageCtrl((x4449_outr_UnitPipe.done).DS(1.toInt, rr, x4449_outr_UnitPipe.sm.io.backpressure), x4449_outr_UnitPipe.baseEn, 4)
      x4449_outr_UnitPipe.backpressure := true.B | x4449_outr_UnitPipe.sm.io.doneLatch
      x4449_outr_UnitPipe.forwardpressure := true.B | x4449_outr_UnitPipe.sm.io.doneLatch
      x4449_outr_UnitPipe.sm.io.enableOut.zip(x4449_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4449_outr_UnitPipe.sm.io.break := false.B
      x4449_outr_UnitPipe.mask := true.B & b4068_chain_read_4 & b4060
      x4449_outr_UnitPipe.configure("x4449_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4449_outr_UnitPipe.kernel()
      val x18776_rd_x3942 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18776_rd_x3942""")
      val x18776_rd_x3942_banks = List[UInt]()
      val x18776_rd_x3942_ofs = List[UInt]()
      val x18776_rd_x3942_en = List[Bool](true.B)
      x18776_rd_x3942.toSeq.zip(x3942_reg.connectRPort(18776, x18776_rd_x3942_banks, x18776_rd_x3942_ofs, io.sigsIn.backpressure, x18776_rd_x3942_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4451_ctr = new CtrObject(Left(Some(0)), Right(x18776_rd_x3942), Left(Some(1)), 1, 32, false)
      val x18777_rd_x3940 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18777_rd_x3940""")
      val x18777_rd_x3940_banks = List[UInt]()
      val x18777_rd_x3940_ofs = List[UInt]()
      val x18777_rd_x3940_en = List[Bool](true.B)
      x18777_rd_x3940.toSeq.zip(x3940_reg.connectRPort(18777, x18777_rd_x3940_banks, x18777_rd_x3940_ofs, io.sigsIn.backpressure, x18777_rd_x3940_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4453_ctr = new CtrObject(Left(Some(0)), Right(x18777_rd_x3940), Left(Some(1)), 1, 32, false)
      val x4454_ctr = new CtrObject(Left(Some(0)), Left(Some(32)), Left(Some(1)), 32, 32, false)
      val x4455_ctrchain = (new CChainObject(List[CtrObject](x4451_ctr,x4453_ctr,x4454_ctr), "x4455_ctrchain")).cchain.io 
      x4455_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x4455_ctrchain_p", (x4455_ctrchain.par, x4455_ctrchain.widths))
      val x18778_rd_x3919 = Wire(Bool()).suggestName("""x18778_rd_x3919""")
      val x18778_rd_x3919_banks = List[UInt]()
      val x18778_rd_x3919_ofs = List[UInt]()
      val x18778_rd_x3919_en = List[Bool](true.B)
      x18778_rd_x3919.toSeq.zip(x3919_reg.connectRPort(18778, x18778_rd_x3919_banks, x18778_rd_x3919_ofs, io.sigsIn.backpressure, x18778_rd_x3919_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9343_inr_Foreach = new x9343_inr_Foreach_kernel(List(x18778_rd_x3919,b4068_chain_read_5,b4060), List(b4067_chain_read_5), List(x3938_reg,x3946_reg,x4061_out_SRAM_conv_0,x3939_reg,x3918_reg), List(x4062_out_SRAM_conv_1,x4326_img2D_4,x4322_img2D_0,x4329_img2D_7,x4323_img2D_1,x4327_img2D_5,x4328_img2D_6,x4324_img2D_2,x4241_weight_SRAM_reshape_0,x4325_img2D_3,x4330_img2D_8) , Some(me), List(x4455_ctrchain), 5, 1, 1, List(1, 1, 32), List(32, 32, 32), breakpoints, rr)
      x9343_inr_Foreach.sm.io.ctrDone := (x9343_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b4067_chain.connectStageCtrl((x9343_inr_Foreach.done).DS(1.toInt, rr, x9343_inr_Foreach.sm.io.backpressure), x9343_inr_Foreach.baseEn, 5)
      b4068_chain.connectStageCtrl((x9343_inr_Foreach.done).DS(1.toInt, rr, x9343_inr_Foreach.sm.io.backpressure), x9343_inr_Foreach.baseEn, 5)
      x9343_inr_Foreach.backpressure := true.B | x9343_inr_Foreach.sm.io.doneLatch
      x9343_inr_Foreach.forwardpressure := true.B | x9343_inr_Foreach.sm.io.doneLatch
      x9343_inr_Foreach.sm.io.enableOut.zip(x9343_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x9343_inr_Foreach.sm.io.break := false.B
      x9343_inr_Foreach.mask := ~x9343_inr_Foreach.cchain.head.output.noop & b4068_chain_read_5 & b4060 & x18778_rd_x3919
      x9343_inr_Foreach.configure("x9343_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9343_inr_Foreach.kernel()
      x4062_out_SRAM_conv_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x9344_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x9344_outr_Foreach **/
