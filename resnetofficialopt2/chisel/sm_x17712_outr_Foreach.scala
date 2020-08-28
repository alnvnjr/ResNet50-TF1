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

/** Hierarchy: x17712 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17712_outr_Foreach **/
class x17712_outr_Foreach_kernel(
  list_b9552: List[FixedPoint],
  list_x17552: List[DecoupledIO[Bool]],
  list_x17550: List[DecoupledIO[AppCommandDense]],
  list_x17551: List[DecoupledIO[AppStoreData]],
  list_x9845_out_SRAM_conv_1: List[NBufInterface],
  list_x18802_rd_x3920: List[Bool],
  list_x9465_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 3, isFSM = false   , latency = 0.0.toInt, myName = "x17712_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17712_outr_Foreach_iiCtr"))
  
  abstract class x17712_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9845_out_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x9845_out_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_x9465_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9465_reg_p").asInstanceOf[MemParams] ))
      val in_b9552 = Input(new FixedPoint(true, 32, 0))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9497_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9497_reg_p").asInstanceOf[MemParams] ))
      val in_x9490_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9490_reg_p").asInstanceOf[MemParams] ))
      val in_x9554_bias_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9554_bias_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x9493_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9493_reg_p").asInstanceOf[MemParams] ))
      val in_x17550 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17550_p").asInstanceOf[(Int,Int)] ))
      val in_x18802_rd_x3920 = Input(Bool())
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x9491_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9491_reg_p").asInstanceOf[MemParams] ))
      val in_b9553 = Input(Bool())
      val in_x9492_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9492_reg_p").asInstanceOf[MemParams] ))
      val in_x18803_rd_x9465 = Input(Bool())
      val in_x3921_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3921_reg_p").asInstanceOf[MemParams] ))
      val in_x17551 = Decoupled(new AppStoreData(ModuleParams.getParams("x17551_p").asInstanceOf[(Int,Int)] ))
      val in_x9495_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9495_reg_p").asInstanceOf[MemParams] ))
      val in_x17552 = Flipped(Decoupled(Bool()))
      val in_x9466_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9466_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 1))
      val rr = Input(Bool())
    })
    def x9845_out_SRAM_conv_1 = {io.in_x9845_out_SRAM_conv_1} ; io.in_x9845_out_SRAM_conv_1 := DontCare
    def x9465_reg = {io.in_x9465_reg} ; io.in_x9465_reg := DontCare
    def b9552 = {io.in_b9552} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x9497_reg = {io.in_x9497_reg} ; io.in_x9497_reg := DontCare
    def x9490_reg = {io.in_x9490_reg} ; io.in_x9490_reg := DontCare
    def x9554_bias_SRAM_0 = {io.in_x9554_bias_SRAM_0} ; io.in_x9554_bias_SRAM_0 := DontCare
    def x9493_reg = {io.in_x9493_reg} ; io.in_x9493_reg := DontCare
    def x17550 = {io.in_x17550} 
    def x18802_rd_x3920 = {io.in_x18802_rd_x3920} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x9491_reg = {io.in_x9491_reg} ; io.in_x9491_reg := DontCare
    def b9553 = {io.in_b9553} 
    def x9492_reg = {io.in_x9492_reg} ; io.in_x9492_reg := DontCare
    def x18803_rd_x9465 = {io.in_x18803_rd_x9465} 
    def x3921_reg = {io.in_x3921_reg} ; io.in_x3921_reg := DontCare
    def x17551 = {io.in_x17551} 
    def x9495_reg = {io.in_x9495_reg} ; io.in_x9495_reg := DontCare
    def x17552 = {io.in_x17552} 
    def x9466_reg = {io.in_x9466_reg} ; io.in_x9466_reg := DontCare
  }
  def connectWires0(module: x17712_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x9845_out_SRAM_conv_1.connectLedger(module.io.in_x9845_out_SRAM_conv_1)
    x9465_reg.connectLedger(module.io.in_x9465_reg)
    module.io.in_b9552 <> b9552
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x9497_reg.connectLedger(module.io.in_x9497_reg)
    x9490_reg.connectLedger(module.io.in_x9490_reg)
    x9554_bias_SRAM_0.connectLedger(module.io.in_x9554_bias_SRAM_0)
    x9493_reg.connectLedger(module.io.in_x9493_reg)
    module.io.in_x17550 <> x17550
    module.io.in_x18802_rd_x3920 <> x18802_rd_x3920
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    x9491_reg.connectLedger(module.io.in_x9491_reg)
    module.io.in_b9553 <> b9553
    x9492_reg.connectLedger(module.io.in_x9492_reg)
    module.io.in_x18803_rd_x9465 <> x18803_rd_x9465
    x3921_reg.connectLedger(module.io.in_x3921_reg)
    module.io.in_x17551 <> x17551
    x9495_reg.connectLedger(module.io.in_x9495_reg)
    module.io.in_x17552 <> x17552
    x9466_reg.connectLedger(module.io.in_x9466_reg)
  }
  val b9552 = list_b9552(0)
  val x2682_tmp_DRAM = list_b9552(1)
  val x17552 = list_x17552(0)
  val x17550 = list_x17550(0)
  val x17551 = list_x17551(0)
  val x9845_out_SRAM_conv_1 = list_x9845_out_SRAM_conv_1(0)
  val x9554_bias_SRAM_0 = list_x9845_out_SRAM_conv_1(1)
  val x18802_rd_x3920 = list_x18802_rd_x3920(0)
  val b9553 = list_x18802_rd_x3920(1)
  val x18803_rd_x9465 = list_x18802_rd_x3920(2)
  val x9465_reg = list_x9465_reg(0)
  val x9497_reg = list_x9465_reg(1)
  val x9490_reg = list_x9465_reg(2)
  val x9493_reg = list_x9465_reg(3)
  val x3920_reg = list_x9465_reg(4)
  val x9491_reg = list_x9465_reg(5)
  val x9492_reg = list_x9465_reg(6)
  val x3921_reg = list_x9465_reg(7)
  val x9495_reg = list_x9465_reg(8)
  val x9466_reg = list_x9465_reg(9)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17712_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x17712_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17712_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b17302 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b17302.suggestName("b17302")
      val b17302_chain = Module(new RegChainPass(3, 32, myName = "b17302_chain")); b17302_chain.io <> DontCare
      b17302_chain.chain_pass(b17302, io.sigsOut.smDoneIn.head)
      val b17302_chain_read_1 = b17302_chain.read(1).FP(true,32,0)
      val b17302_chain_read_2 = b17302_chain.read(2).FP(true,32,0)
      val b17303 = ~io.sigsIn.cchainOutputs.head.oobs(0); b17303.suggestName("b17303")
      val b17303_chain = Module(new RegChainPass(3, 1, myName = "b17303_chain")); b17303_chain.io <> DontCare
      b17303_chain.chain_pass(b17303, io.sigsOut.smDoneIn.head)
      val b17303_chain_read_1: Bool = b17303_chain.read(1).apply(0)
      val b17303_chain_read_2: Bool = b17303_chain.read(2).apply(0)
      val x17304_out_SRAM_bias_0 = (new x17304_out_SRAM_bias_0).m.io.asInstanceOf[NBufInterface]
      val x18804_rd_x9492 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18804_rd_x9492""")
      val x18804_rd_x9492_banks = List[UInt]()
      val x18804_rd_x9492_ofs = List[UInt]()
      val x18804_rd_x9492_en = List[Bool](true.B)
      x18804_rd_x9492.toSeq.zip(x9492_reg.connectRPort(18804, x18804_rd_x9492_banks, x18804_rd_x9492_ofs, io.sigsIn.backpressure, x18804_rd_x9492_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17306_ctr = new CtrObject(Left(Some(0)), Right(x18804_rd_x9492), Left(Some(1)), 1, 32, false)
      val x18805_rd_x9490 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18805_rd_x9490""")
      val x18805_rd_x9490_banks = List[UInt]()
      val x18805_rd_x9490_ofs = List[UInt]()
      val x18805_rd_x9490_en = List[Bool](true.B)
      x18805_rd_x9490.toSeq.zip(x9490_reg.connectRPort(18805, x18805_rd_x9490_banks, x18805_rd_x9490_ofs, io.sigsIn.backpressure, x18805_rd_x9490_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17308_ctr = new CtrObject(Left(Some(0)), Right(x18805_rd_x9490), Left(Some(1)), 8, 32, false)
      val x17309_ctrchain = (new CChainObject(List[CtrObject](x17306_ctr,x17308_ctr), "x17309_ctrchain")).cchain.io 
      x17309_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x17309_ctrchain_p", (x17309_ctrchain.par, x17309_ctrchain.widths))
      val x18806_rd_x3921 = Wire(Bool()).suggestName("""x18806_rd_x3921""")
      val x18806_rd_x3921_banks = List[UInt]()
      val x18806_rd_x3921_ofs = List[UInt]()
      val x18806_rd_x3921_en = List[Bool](true.B)
      x18806_rd_x3921.toSeq.zip(x3921_reg.connectRPort(18806, x18806_rd_x3921_banks, x18806_rd_x3921_ofs, io.sigsIn.backpressure, x18806_rd_x3921_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18807_rd_x9466 = Wire(Bool()).suggestName("""x18807_rd_x9466""")
      val x18807_rd_x9466_banks = List[UInt]()
      val x18807_rd_x9466_ofs = List[UInt]()
      val x18807_rd_x9466_en = List[Bool](true.B)
      x18807_rd_x9466.toSeq.zip(x9466_reg.connectRPort(18807, x18807_rd_x9466_banks, x18807_rd_x9466_ofs, io.sigsIn.backpressure, x18807_rd_x9466_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17538_inr_Foreach = new x17538_inr_Foreach_kernel(List(b17303,x18806_rd_x3921,b9553,x18807_rd_x9466), List(b17302), List(x9465_reg,x9497_reg,x3920_reg,x9491_reg), List(x9845_out_SRAM_conv_1,x9554_bias_SRAM_0,x17304_out_SRAM_bias_0) , Some(me), List(x17309_ctrchain), 0, 1, 1, List(1, 8), List(32, 32), breakpoints, rr)
      x17538_inr_Foreach.sm.io.ctrDone := (x17538_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b17302_chain.connectStageCtrl((x17538_inr_Foreach.done).DS(1.toInt, rr, x17538_inr_Foreach.sm.io.backpressure), x17538_inr_Foreach.baseEn, 0)
      b17303_chain.connectStageCtrl((x17538_inr_Foreach.done).DS(1.toInt, rr, x17538_inr_Foreach.sm.io.backpressure), x17538_inr_Foreach.baseEn, 0)
      x17538_inr_Foreach.backpressure := true.B | x17538_inr_Foreach.sm.io.doneLatch
      x17538_inr_Foreach.forwardpressure := true.B | x17538_inr_Foreach.sm.io.doneLatch
      x17538_inr_Foreach.sm.io.enableOut.zip(x17538_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x17538_inr_Foreach.sm.io.break := false.B
      x17538_inr_Foreach.mask := ~x17538_inr_Foreach.cchain.head.output.noop & b17303 & b9553 & x18806_rd_x3921 & x18807_rd_x9466
      x17538_inr_Foreach.configure("x17538_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17538_inr_Foreach.kernel()
      val x17539_reg = (new x17539_reg).m.io.asInstanceOf[NBufInterface]
      val x17540_reg = (new x17540_reg).m.io.asInstanceOf[NBufInterface]
      val x17549_inr_UnitPipe = new x17549_inr_UnitPipe_kernel(List(b17303_chain_read_1,b9553), List(b9552,b17302_chain_read_1), List(x9493_reg), List(x17539_reg,x17304_out_SRAM_bias_0,x17540_reg) , Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x17549_inr_UnitPipe.sm.io.ctrDone := risingEdge(x17549_inr_UnitPipe.sm.io.ctrInc)
      b17302_chain.connectStageCtrl((x17549_inr_UnitPipe.done).DS(1.toInt, rr, x17549_inr_UnitPipe.sm.io.backpressure), x17549_inr_UnitPipe.baseEn, 1)
      b17303_chain.connectStageCtrl((x17549_inr_UnitPipe.done).DS(1.toInt, rr, x17549_inr_UnitPipe.sm.io.backpressure), x17549_inr_UnitPipe.baseEn, 1)
      x17549_inr_UnitPipe.backpressure := true.B | x17549_inr_UnitPipe.sm.io.doneLatch
      x17549_inr_UnitPipe.forwardpressure := true.B | x17549_inr_UnitPipe.sm.io.doneLatch
      x17549_inr_UnitPipe.sm.io.enableOut.zip(x17549_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x17549_inr_UnitPipe.sm.io.break := false.B
      x17549_inr_UnitPipe.mask := true.B & b17303_chain_read_1 & b9553
      x17549_inr_UnitPipe.configure("x17549_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17549_inr_UnitPipe.kernel()
      val x17711_outr_UnitPipe = new x17711_outr_UnitPipe_kernel(List(x9495_reg), List(b17303_chain_read_2,b9553), List(x17552), List(x17550), List(x17539_reg,x17304_out_SRAM_bias_0,x17540_reg), List(x17551), List(x2682_tmp_DRAM) , Some(me), List(), 2, 1, 1, List(1), List(32), breakpoints, rr)
      b17302_chain.connectStageCtrl((x17711_outr_UnitPipe.done).DS(1.toInt, rr, x17711_outr_UnitPipe.sm.io.backpressure), x17711_outr_UnitPipe.baseEn, 2)
      b17303_chain.connectStageCtrl((x17711_outr_UnitPipe.done).DS(1.toInt, rr, x17711_outr_UnitPipe.sm.io.backpressure), x17711_outr_UnitPipe.baseEn, 2)
      x17711_outr_UnitPipe.backpressure := true.B | x17711_outr_UnitPipe.sm.io.doneLatch
      x17711_outr_UnitPipe.forwardpressure := true.B | x17711_outr_UnitPipe.sm.io.doneLatch
      x17711_outr_UnitPipe.sm.io.enableOut.zip(x17711_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x17711_outr_UnitPipe.sm.io.break := false.B
      x17711_outr_UnitPipe.mask := true.B & b17303_chain_read_2 & b9553
      x17711_outr_UnitPipe.configure("x17711_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17711_outr_UnitPipe.kernel()
      x9554_bias_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 5)
      x9845_out_SRAM_conv_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x17712_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x17712_outr_Foreach **/
