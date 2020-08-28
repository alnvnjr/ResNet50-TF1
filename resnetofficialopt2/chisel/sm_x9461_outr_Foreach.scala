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

/** Hierarchy: x9461 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9461_outr_Foreach **/
class x9461_outr_Foreach_kernel(
  list_x4062_out_SRAM_conv_1: List[NBufInterface],
  list_b4060: List[Bool],
  list_x9401: List[DecoupledIO[Bool]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x9399: List[DecoupledIO[AppCommandDense]],
  list_x9400: List[DecoupledIO[AppStoreData]],
  list_x3942_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 3, isFSM = false   , latency = 0.0.toInt, myName = "x9461_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9461_outr_Foreach_iiCtr"))
  
  abstract class x9461_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4062_out_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x4062_out_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_x9400 = Decoupled(new AppStoreData(ModuleParams.getParams("x9400_p").asInstanceOf[(Int,Int)] ))
      val in_x3942_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3942_reg_p").asInstanceOf[MemParams] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3919_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3919_reg_p").asInstanceOf[MemParams] ))
      val in_x9401 = Flipped(Decoupled(Bool()))
      val in_b4059 = Input(new FixedPoint(true, 32, 0))
      val in_x3941_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3941_reg_p").asInstanceOf[MemParams] ))
      val in_x3945_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3945_reg_p").asInstanceOf[MemParams] ))
      val in_b4060 = Input(Bool())
      val in_x3940_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3940_reg_p").asInstanceOf[MemParams] ))
      val in_x3943_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3943_reg_p").asInstanceOf[MemParams] ))
      val in_x18779_rd_x3918 = Input(Bool())
      val in_x3992_bias_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3992_bias_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x3918_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3918_reg_p").asInstanceOf[MemParams] ))
      val in_x9399 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9399_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 1))
      val rr = Input(Bool())
    })
    def x4062_out_SRAM_conv_1 = {io.in_x4062_out_SRAM_conv_1} ; io.in_x4062_out_SRAM_conv_1 := DontCare
    def x9400 = {io.in_x9400} 
    def x3942_reg = {io.in_x3942_reg} ; io.in_x3942_reg := DontCare
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3919_reg = {io.in_x3919_reg} ; io.in_x3919_reg := DontCare
    def x9401 = {io.in_x9401} 
    def b4059 = {io.in_b4059} 
    def x3941_reg = {io.in_x3941_reg} ; io.in_x3941_reg := DontCare
    def x3945_reg = {io.in_x3945_reg} ; io.in_x3945_reg := DontCare
    def b4060 = {io.in_b4060} 
    def x3940_reg = {io.in_x3940_reg} ; io.in_x3940_reg := DontCare
    def x3943_reg = {io.in_x3943_reg} ; io.in_x3943_reg := DontCare
    def x18779_rd_x3918 = {io.in_x18779_rd_x3918} 
    def x3992_bias_SRAM_0 = {io.in_x3992_bias_SRAM_0} ; io.in_x3992_bias_SRAM_0 := DontCare
    def x3918_reg = {io.in_x3918_reg} ; io.in_x3918_reg := DontCare
    def x9399 = {io.in_x9399} 
  }
  def connectWires0(module: x9461_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x4062_out_SRAM_conv_1.connectLedger(module.io.in_x4062_out_SRAM_conv_1)
    module.io.in_x9400 <> x9400
    x3942_reg.connectLedger(module.io.in_x3942_reg)
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3919_reg.connectLedger(module.io.in_x3919_reg)
    module.io.in_x9401 <> x9401
    module.io.in_b4059 <> b4059
    x3941_reg.connectLedger(module.io.in_x3941_reg)
    x3945_reg.connectLedger(module.io.in_x3945_reg)
    module.io.in_b4060 <> b4060
    x3940_reg.connectLedger(module.io.in_x3940_reg)
    x3943_reg.connectLedger(module.io.in_x3943_reg)
    module.io.in_x18779_rd_x3918 <> x18779_rd_x3918
    x3992_bias_SRAM_0.connectLedger(module.io.in_x3992_bias_SRAM_0)
    x3918_reg.connectLedger(module.io.in_x3918_reg)
    module.io.in_x9399 <> x9399
  }
  val x4062_out_SRAM_conv_1 = list_x4062_out_SRAM_conv_1(0)
  val b4060 = list_b4060(0)
  val x18779_rd_x3918 = list_b4060(1)
  val x9401 = list_x9401(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b4059 = list_x2682_tmp_DRAM(1)
  val x9399 = list_x9399(0)
  val x9400 = list_x9400(0)
  val x3942_reg = list_x3942_reg(0)
  val x3919_reg = list_x3942_reg(1)
  val x3941_reg = list_x3942_reg(2)
  val x3945_reg = list_x3942_reg(3)
  val x3940_reg = list_x3942_reg(4)
  val x3943_reg = list_x3942_reg(5)
  val x3992_bias_SRAM_0 = list_x3942_reg(6)
  val x3918_reg = list_x3942_reg(7)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9461_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x9461_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9461_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b9348 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b9348.suggestName("b9348")
      val b9348_chain = Module(new RegChainPass(3, 32, myName = "b9348_chain")); b9348_chain.io <> DontCare
      b9348_chain.chain_pass(b9348, io.sigsOut.smDoneIn.head)
      val b9348_chain_read_1 = b9348_chain.read(1).FP(true,32,0)
      val b9348_chain_read_2 = b9348_chain.read(2).FP(true,32,0)
      val b9349 = ~io.sigsIn.cchainOutputs.head.oobs(0); b9349.suggestName("b9349")
      val b9349_chain = Module(new RegChainPass(3, 1, myName = "b9349_chain")); b9349_chain.io <> DontCare
      b9349_chain.chain_pass(b9349, io.sigsOut.smDoneIn.head)
      val b9349_chain_read_1: Bool = b9349_chain.read(1).apply(0)
      val b9349_chain_read_2: Bool = b9349_chain.read(2).apply(0)
      val x9350_out_SRAM_bias_0 = (new x9350_out_SRAM_bias_0).m.io.asInstanceOf[NBufInterface]
      val x18780_rd_x3942 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18780_rd_x3942""")
      val x18780_rd_x3942_banks = List[UInt]()
      val x18780_rd_x3942_ofs = List[UInt]()
      val x18780_rd_x3942_en = List[Bool](true.B)
      x18780_rd_x3942.toSeq.zip(x3942_reg.connectRPort(18780, x18780_rd_x3942_banks, x18780_rd_x3942_ofs, io.sigsIn.backpressure, x18780_rd_x3942_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9352_ctr = new CtrObject(Left(Some(0)), Right(x18780_rd_x3942), Left(Some(1)), 1, 32, false)
      val x18781_rd_x3940 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18781_rd_x3940""")
      val x18781_rd_x3940_banks = List[UInt]()
      val x18781_rd_x3940_ofs = List[UInt]()
      val x18781_rd_x3940_en = List[Bool](true.B)
      x18781_rd_x3940.toSeq.zip(x3940_reg.connectRPort(18781, x18781_rd_x3940_banks, x18781_rd_x3940_ofs, io.sigsIn.backpressure, x18781_rd_x3940_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9354_ctr = new CtrObject(Left(Some(0)), Right(x18781_rd_x3940), Left(Some(1)), 1, 32, false)
      val x9355_ctrchain = (new CChainObject(List[CtrObject](x9352_ctr,x9354_ctr), "x9355_ctrchain")).cchain.io 
      x9355_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x9355_ctrchain_p", (x9355_ctrchain.par, x9355_ctrchain.widths))
      val x18782_rd_x3918 = Wire(Bool()).suggestName("""x18782_rd_x3918""")
      val x18782_rd_x3918_banks = List[UInt]()
      val x18782_rd_x3918_ofs = List[UInt]()
      val x18782_rd_x3918_en = List[Bool](true.B)
      x18782_rd_x3918.toSeq.zip(x3918_reg.connectRPort(18782, x18782_rd_x3918_banks, x18782_rd_x3918_ofs, io.sigsIn.backpressure, x18782_rd_x3918_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9387_inr_Foreach = new x9387_inr_Foreach_kernel(List(x18782_rd_x3918,b4060,b9349), List(b4059,b9348), List(x3919_reg,x3941_reg,x3992_bias_SRAM_0), List(x4062_out_SRAM_conv_1,x9350_out_SRAM_bias_0) , Some(me), List(x9355_ctrchain), 0, 1, 1, List(1, 1), List(32, 32), breakpoints, rr)
      x9387_inr_Foreach.sm.io.ctrDone := (x9387_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b9348_chain.connectStageCtrl((x9387_inr_Foreach.done).DS(1.toInt, rr, x9387_inr_Foreach.sm.io.backpressure), x9387_inr_Foreach.baseEn, 0)
      b9349_chain.connectStageCtrl((x9387_inr_Foreach.done).DS(1.toInt, rr, x9387_inr_Foreach.sm.io.backpressure), x9387_inr_Foreach.baseEn, 0)
      x9387_inr_Foreach.backpressure := true.B | x9387_inr_Foreach.sm.io.doneLatch
      x9387_inr_Foreach.forwardpressure := true.B | x9387_inr_Foreach.sm.io.doneLatch
      x9387_inr_Foreach.sm.io.enableOut.zip(x9387_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x9387_inr_Foreach.sm.io.break := false.B
      x9387_inr_Foreach.mask := ~x9387_inr_Foreach.cchain.head.output.noop & b9349 & b4060 & x18782_rd_x3918
      x9387_inr_Foreach.configure("x9387_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9387_inr_Foreach.kernel()
      val x9388_reg = (new x9388_reg).m.io.asInstanceOf[NBufInterface]
      val x9389_reg = (new x9389_reg).m.io.asInstanceOf[NBufInterface]
      val x9398_inr_UnitPipe = new x9398_inr_UnitPipe_kernel(List(b4060,b9349_chain_read_1), List(b4059,b9348_chain_read_1), List(x3943_reg), List(x9388_reg,x9389_reg,x9350_out_SRAM_bias_0) , Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x9398_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9398_inr_UnitPipe.sm.io.ctrInc)
      b9348_chain.connectStageCtrl((x9398_inr_UnitPipe.done).DS(1.toInt, rr, x9398_inr_UnitPipe.sm.io.backpressure), x9398_inr_UnitPipe.baseEn, 1)
      b9349_chain.connectStageCtrl((x9398_inr_UnitPipe.done).DS(1.toInt, rr, x9398_inr_UnitPipe.sm.io.backpressure), x9398_inr_UnitPipe.baseEn, 1)
      x9398_inr_UnitPipe.backpressure := true.B | x9398_inr_UnitPipe.sm.io.doneLatch
      x9398_inr_UnitPipe.forwardpressure := true.B | x9398_inr_UnitPipe.sm.io.doneLatch
      x9398_inr_UnitPipe.sm.io.enableOut.zip(x9398_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9398_inr_UnitPipe.sm.io.break := false.B
      x9398_inr_UnitPipe.mask := true.B & b9349_chain_read_1 & b4060
      x9398_inr_UnitPipe.configure("x9398_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9398_inr_UnitPipe.kernel()
      val x9460_outr_UnitPipe = new x9460_outr_UnitPipe_kernel(List(x9401), List(x9388_reg,x9389_reg,x9350_out_SRAM_bias_0), List(x9399), List(x3945_reg), List(x9400), List(b4060,b9349_chain_read_2), List(x2682_tmp_DRAM) , Some(me), List(), 2, 1, 1, List(1), List(32), breakpoints, rr)
      b9348_chain.connectStageCtrl((x9460_outr_UnitPipe.done).DS(1.toInt, rr, x9460_outr_UnitPipe.sm.io.backpressure), x9460_outr_UnitPipe.baseEn, 2)
      b9349_chain.connectStageCtrl((x9460_outr_UnitPipe.done).DS(1.toInt, rr, x9460_outr_UnitPipe.sm.io.backpressure), x9460_outr_UnitPipe.baseEn, 2)
      x9460_outr_UnitPipe.backpressure := true.B | x9460_outr_UnitPipe.sm.io.doneLatch
      x9460_outr_UnitPipe.forwardpressure := true.B | x9460_outr_UnitPipe.sm.io.doneLatch
      x9460_outr_UnitPipe.sm.io.enableOut.zip(x9460_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9460_outr_UnitPipe.sm.io.break := false.B
      x9460_outr_UnitPipe.mask := true.B & b9349_chain_read_2 & b4060
      x9460_outr_UnitPipe.configure("x9460_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9460_outr_UnitPipe.kernel()
      x4062_out_SRAM_conv_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x9461_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x9461_outr_Foreach **/
