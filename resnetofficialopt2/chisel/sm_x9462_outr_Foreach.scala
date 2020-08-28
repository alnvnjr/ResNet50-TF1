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

/** Hierarchy: x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9462_outr_Foreach **/
class x9462_outr_Foreach_kernel(
  list_x18770_rd_x3918: List[Bool],
  list_x9401: List[DecoupledIO[Bool]],
  list_x4085: List[DecoupledIO[AppLoadData]],
  list_x9400: List[DecoupledIO[AppStoreData]],
  list_x3942_reg: List[StandardInterface],
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x4336: List[DecoupledIO[AppCommandDense]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 2, isFSM = false   , latency = 0.0.toInt, myName = "x9462_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9462_outr_Foreach_iiCtr"))
  
  abstract class x9462_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9400 = Decoupled(new AppStoreData(ModuleParams.getParams("x9400_p").asInstanceOf[(Int,Int)] ))
      val in_x3942_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3942_reg_p").asInstanceOf[MemParams] ))
      val in_x3947_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3947_reg_p").asInstanceOf[MemParams] ))
      val in_x3938_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3938_reg_p").asInstanceOf[MemParams] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3919_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3919_reg_p").asInstanceOf[MemParams] ))
      val in_x9401 = Flipped(Decoupled(Bool()))
      val in_x3941_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3941_reg_p").asInstanceOf[MemParams] ))
      val in_x3935_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3935_reg_p").asInstanceOf[MemParams] ))
      val in_x3937_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3937_reg_p").asInstanceOf[MemParams] ))
      val in_x18770_rd_x3918 = Input(Bool())
      val in_x3945_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3945_reg_p").asInstanceOf[MemParams] ))
      val in_x4085 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4085_p").asInstanceOf[(Int, Int)] )))
      val in_x3936_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3936_reg_p").asInstanceOf[MemParams] ))
      val in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x4336 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4336_p").asInstanceOf[(Int,Int)] ))
      val in_x3940_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3940_reg_p").asInstanceOf[MemParams] ))
      val in_x3943_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3943_reg_p").asInstanceOf[MemParams] ))
      val in_x3946_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3946_reg_p").asInstanceOf[MemParams] ))
      val in_x4338 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4338_p").asInstanceOf[(Int, Int)] )))
      val in_x3992_bias_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3992_bias_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x4083 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4083_p").asInstanceOf[(Int,Int)] ))
      val in_x3939_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3939_reg_p").asInstanceOf[MemParams] ))
      val in_x3918_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3918_reg_p").asInstanceOf[MemParams] ))
      val in_x9399 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9399_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x9400 = {io.in_x9400} 
    def x3942_reg = {io.in_x3942_reg} ; io.in_x3942_reg := DontCare
    def x3947_reg = {io.in_x3947_reg} ; io.in_x3947_reg := DontCare
    def x3938_reg = {io.in_x3938_reg} ; io.in_x3938_reg := DontCare
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3919_reg = {io.in_x3919_reg} ; io.in_x3919_reg := DontCare
    def x9401 = {io.in_x9401} 
    def x3941_reg = {io.in_x3941_reg} ; io.in_x3941_reg := DontCare
    def x3935_reg = {io.in_x3935_reg} ; io.in_x3935_reg := DontCare
    def x3937_reg = {io.in_x3937_reg} ; io.in_x3937_reg := DontCare
    def x18770_rd_x3918 = {io.in_x18770_rd_x3918} 
    def x3945_reg = {io.in_x3945_reg} ; io.in_x3945_reg := DontCare
    def x4085 = {io.in_x4085} 
    def x3936_reg = {io.in_x3936_reg} ; io.in_x3936_reg := DontCare
    def x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = {io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM} 
    def x4336 = {io.in_x4336} 
    def x3940_reg = {io.in_x3940_reg} ; io.in_x3940_reg := DontCare
    def x3943_reg = {io.in_x3943_reg} ; io.in_x3943_reg := DontCare
    def x3946_reg = {io.in_x3946_reg} ; io.in_x3946_reg := DontCare
    def x4338 = {io.in_x4338} 
    def x3992_bias_SRAM_0 = {io.in_x3992_bias_SRAM_0} ; io.in_x3992_bias_SRAM_0 := DontCare
    def x4083 = {io.in_x4083} 
    def x3939_reg = {io.in_x3939_reg} ; io.in_x3939_reg := DontCare
    def x3918_reg = {io.in_x3918_reg} ; io.in_x3918_reg := DontCare
    def x9399 = {io.in_x9399} 
  }
  def connectWires0(module: x9462_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x9400 <> x9400
    x3942_reg.connectLedger(module.io.in_x3942_reg)
    x3947_reg.connectLedger(module.io.in_x3947_reg)
    x3938_reg.connectLedger(module.io.in_x3938_reg)
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3919_reg.connectLedger(module.io.in_x3919_reg)
    module.io.in_x9401 <> x9401
    x3941_reg.connectLedger(module.io.in_x3941_reg)
    x3935_reg.connectLedger(module.io.in_x3935_reg)
    x3937_reg.connectLedger(module.io.in_x3937_reg)
    module.io.in_x18770_rd_x3918 <> x18770_rd_x3918
    x3945_reg.connectLedger(module.io.in_x3945_reg)
    module.io.in_x4085 <> x4085
    x3936_reg.connectLedger(module.io.in_x3936_reg)
    module.io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM <> x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM
    module.io.in_x4336 <> x4336
    x3940_reg.connectLedger(module.io.in_x3940_reg)
    x3943_reg.connectLedger(module.io.in_x3943_reg)
    x3946_reg.connectLedger(module.io.in_x3946_reg)
    module.io.in_x4338 <> x4338
    x3992_bias_SRAM_0.connectLedger(module.io.in_x3992_bias_SRAM_0)
    module.io.in_x4083 <> x4083
    x3939_reg.connectLedger(module.io.in_x3939_reg)
    x3918_reg.connectLedger(module.io.in_x3918_reg)
    module.io.in_x9399 <> x9399
  }
  val x18770_rd_x3918 = list_x18770_rd_x3918(0)
  val x9401 = list_x9401(0)
  val x4085 = list_x4085(0)
  val x4338 = list_x4085(1)
  val x9400 = list_x9400(0)
  val x3942_reg = list_x3942_reg(0)
  val x3947_reg = list_x3942_reg(1)
  val x3938_reg = list_x3942_reg(2)
  val x3919_reg = list_x3942_reg(3)
  val x3941_reg = list_x3942_reg(4)
  val x3935_reg = list_x3942_reg(5)
  val x3937_reg = list_x3942_reg(6)
  val x3945_reg = list_x3942_reg(7)
  val x3936_reg = list_x3942_reg(8)
  val x3940_reg = list_x3942_reg(9)
  val x3943_reg = list_x3942_reg(10)
  val x3946_reg = list_x3942_reg(11)
  val x3992_bias_SRAM_0 = list_x3942_reg(12)
  val x3939_reg = list_x3942_reg(13)
  val x3918_reg = list_x3942_reg(14)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = list_x2682_tmp_DRAM(1)
  val x4336 = list_x4336(0)
  val x4083 = list_x4336(1)
  val x9399 = list_x4336(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9462_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x9462_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9462_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b4059 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b4059.suggestName("b4059")
      val b4059_chain = Module(new RegChainPass(2, 32, myName = "b4059_chain")); b4059_chain.io <> DontCare
      b4059_chain.chain_pass(b4059, io.sigsOut.smDoneIn.head)
      val b4059_chain_read_1 = b4059_chain.read(1).FP(true,32,0)
      val b4060 = ~io.sigsIn.cchainOutputs.head.oobs(0); b4060.suggestName("b4060")
      val b4060_chain = Module(new RegChainPass(2, 1, myName = "b4060_chain")); b4060_chain.io <> DontCare
      b4060_chain.chain_pass(b4060, io.sigsOut.smDoneIn.head)
      val b4060_chain_read_1: Bool = b4060_chain.read(1).apply(0)
      val x4061_out_SRAM_conv_0 = (new x4061_out_SRAM_conv_0).m.io.asInstanceOf[StandardInterface]
      val x4062_out_SRAM_conv_1 = (new x4062_out_SRAM_conv_1).m.io.asInstanceOf[NBufInterface]
      val x18771_rd_x3936 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18771_rd_x3936""")
      val x18771_rd_x3936_banks = List[UInt]()
      val x18771_rd_x3936_ofs = List[UInt]()
      val x18771_rd_x3936_en = List[Bool](true.B)
      x18771_rd_x3936.toSeq.zip(x3936_reg.connectRPort(18771, x18771_rd_x3936_banks, x18771_rd_x3936_ofs, io.sigsIn.backpressure, x18771_rd_x3936_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4064_ctr = new CtrObject(Left(Some(0)), Right(x18771_rd_x3936), Left(Some(1)), 1, 32, false)
      val x4065_ctrchain = (new CChainObject(List[CtrObject](x4064_ctr), "x4065_ctrchain")).cchain.io 
      x4065_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x4065_ctrchain_p", (x4065_ctrchain.par, x4065_ctrchain.widths))
      val x18772_rd_x3918 = Wire(Bool()).suggestName("""x18772_rd_x3918""")
      val x18772_rd_x3918_banks = List[UInt]()
      val x18772_rd_x3918_ofs = List[UInt]()
      val x18772_rd_x3918_en = List[Bool](true.B)
      x18772_rd_x3918.toSeq.zip(x3918_reg.connectRPort(18772, x18772_rd_x3918_banks, x18772_rd_x3918_ofs, io.sigsIn.backpressure, x18772_rd_x3918_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9344_outr_Foreach = new x9344_outr_Foreach_kernel(List(x4062_out_SRAM_conv_1), List(x3942_reg,x3947_reg,x3938_reg,x3919_reg,x3935_reg,x3937_reg,x3940_reg,x3946_reg,x4061_out_SRAM_conv_0,x3939_reg,x3918_reg), List(x2682_tmp_DRAM,b4059,x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM), List(b4060,x18772_rd_x3918), List(x4085,x4338), List(x4336,x4083) , Some(me), List(x4065_ctrchain), 0, 6, 1, List(1), List(32), breakpoints, rr)
      x9344_outr_Foreach.sm.io.ctrDone := (x9344_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b4059_chain.connectStageCtrl((x9344_outr_Foreach.done).DS(1.toInt, rr, x9344_outr_Foreach.sm.io.backpressure), x9344_outr_Foreach.baseEn, 0)
      b4060_chain.connectStageCtrl((x9344_outr_Foreach.done).DS(1.toInt, rr, x9344_outr_Foreach.sm.io.backpressure), x9344_outr_Foreach.baseEn, 0)
      x9344_outr_Foreach.backpressure := true.B | x9344_outr_Foreach.sm.io.doneLatch
      x9344_outr_Foreach.forwardpressure := true.B | x9344_outr_Foreach.sm.io.doneLatch
      x9344_outr_Foreach.sm.io.enableOut.zip(x9344_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x9344_outr_Foreach.sm.io.break := false.B
      x9344_outr_Foreach.mask := ~x9344_outr_Foreach.cchain.head.output.noop & b4060 & x18772_rd_x3918
      x9344_outr_Foreach.configure("x9344_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9344_outr_Foreach.kernel()
      val x9345_ctr = new CtrObject(Left(Some(0)), Left(Some(32)), Left(Some(1)), 1, 32, false)
      val x9346_ctrchain = (new CChainObject(List[CtrObject](x9345_ctr), "x9346_ctrchain")).cchain.io 
      x9346_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x9346_ctrchain_p", (x9346_ctrchain.par, x9346_ctrchain.widths))
      val x18779_rd_x3918 = Wire(Bool()).suggestName("""x18779_rd_x3918""")
      val x18779_rd_x3918_banks = List[UInt]()
      val x18779_rd_x3918_ofs = List[UInt]()
      val x18779_rd_x3918_en = List[Bool](true.B)
      x18779_rd_x3918.toSeq.zip(x3918_reg.connectRPort(18779, x18779_rd_x3918_banks, x18779_rd_x3918_ofs, io.sigsIn.backpressure, x18779_rd_x3918_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9461_outr_Foreach = new x9461_outr_Foreach_kernel(List(x4062_out_SRAM_conv_1), List(b4060_chain_read_1,x18779_rd_x3918), List(x9401), List(x2682_tmp_DRAM,b4059_chain_read_1), List(x9399), List(x9400), List(x3942_reg,x3919_reg,x3941_reg,x3945_reg,x3940_reg,x3943_reg,x3992_bias_SRAM_0,x3918_reg) , Some(me), List(x9346_ctrchain), 1, 3, 1, List(1), List(32), breakpoints, rr)
      x9461_outr_Foreach.sm.io.ctrDone := (x9461_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b4059_chain.connectStageCtrl((x9461_outr_Foreach.done).DS(1.toInt, rr, x9461_outr_Foreach.sm.io.backpressure), x9461_outr_Foreach.baseEn, 1)
      b4060_chain.connectStageCtrl((x9461_outr_Foreach.done).DS(1.toInt, rr, x9461_outr_Foreach.sm.io.backpressure), x9461_outr_Foreach.baseEn, 1)
      x9461_outr_Foreach.backpressure := true.B | x9461_outr_Foreach.sm.io.doneLatch
      x9461_outr_Foreach.forwardpressure := true.B | x9461_outr_Foreach.sm.io.doneLatch
      x9461_outr_Foreach.sm.io.enableOut.zip(x9461_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x9461_outr_Foreach.sm.io.break := false.B
      x9461_outr_Foreach.mask := ~x9461_outr_Foreach.cchain.head.output.noop & b4060_chain_read_1 & x18779_rd_x3918
      x9461_outr_Foreach.configure("x9461_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9461_outr_Foreach.kernel()
    }
    val module = Module(new x9462_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x9462_outr_Foreach **/
