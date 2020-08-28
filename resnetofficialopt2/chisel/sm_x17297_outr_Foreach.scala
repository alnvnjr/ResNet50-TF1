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

/** Hierarchy: x17297 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17297_outr_Foreach **/
class x17297_outr_Foreach_kernel(
  list_x9845_out_SRAM_conv_1: List[NBufInterface],
  list_x9485_reg: List[StandardInterface],
  list_x9867: List[DecoupledIO[AppCommandDense]],
  list_x9868: List[DecoupledIO[AppLoadData]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x18796_rd_x9465: List[Bool],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 3, isFSM = false   , latency = 0.0.toInt, myName = "x17297_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17297_outr_Foreach_iiCtr"))
  
  abstract class x17297_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9485_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9485_reg_p").asInstanceOf[MemParams] ))
      val in_x9845_out_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x9845_out_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_x9465_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9465_reg_p").asInstanceOf[MemParams] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9490_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9490_reg_p").asInstanceOf[MemParams] ))
      val in_x18796_rd_x9465 = Input(Bool())
      val in_x9488_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9488_reg_p").asInstanceOf[MemParams] ))
      val in_x9554_bias_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9554_bias_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x9868 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9868_p").asInstanceOf[(Int, Int)] )))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x18795_rd_x3920 = Input(Bool())
      val in_x9496_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9496_reg_p").asInstanceOf[MemParams] ))
      val in_x9867 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9867_p").asInstanceOf[(Int,Int)] ))
      val in_b9553 = Input(Bool())
      val in_x9492_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9492_reg_p").asInstanceOf[MemParams] ))
      val in_x3921_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3921_reg_p").asInstanceOf[MemParams] ))
      val in_x9486_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9486_reg_p").asInstanceOf[MemParams] ))
      val in_x9767_weight_SRAM_reshape_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9767_weight_SRAM_reshape_0_p").asInstanceOf[NBufParams] ))
      val in_x9844_out_SRAM_conv_0 = Flipped(new StandardInterface(ModuleParams.getParams("x9844_out_SRAM_conv_0_p").asInstanceOf[MemParams] ))
      val in_x9466_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9466_reg_p").asInstanceOf[MemParams] ))
      val in_x9489_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9489_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 1))
      val rr = Input(Bool())
    })
    def x9485_reg = {io.in_x9485_reg} ; io.in_x9485_reg := DontCare
    def x9845_out_SRAM_conv_1 = {io.in_x9845_out_SRAM_conv_1} ; io.in_x9845_out_SRAM_conv_1 := DontCare
    def x9465_reg = {io.in_x9465_reg} ; io.in_x9465_reg := DontCare
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x9490_reg = {io.in_x9490_reg} ; io.in_x9490_reg := DontCare
    def x18796_rd_x9465 = {io.in_x18796_rd_x9465} 
    def x9488_reg = {io.in_x9488_reg} ; io.in_x9488_reg := DontCare
    def x9554_bias_SRAM_0 = {io.in_x9554_bias_SRAM_0} ; io.in_x9554_bias_SRAM_0 := DontCare
    def x9868 = {io.in_x9868} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x18795_rd_x3920 = {io.in_x18795_rd_x3920} 
    def x9496_reg = {io.in_x9496_reg} ; io.in_x9496_reg := DontCare
    def x9867 = {io.in_x9867} 
    def b9553 = {io.in_b9553} 
    def x9492_reg = {io.in_x9492_reg} ; io.in_x9492_reg := DontCare
    def x3921_reg = {io.in_x3921_reg} ; io.in_x3921_reg := DontCare
    def x9486_reg = {io.in_x9486_reg} ; io.in_x9486_reg := DontCare
    def x9767_weight_SRAM_reshape_0 = {io.in_x9767_weight_SRAM_reshape_0} ; io.in_x9767_weight_SRAM_reshape_0 := DontCare
    def x9844_out_SRAM_conv_0 = {io.in_x9844_out_SRAM_conv_0} ; io.in_x9844_out_SRAM_conv_0 := DontCare
    def x9466_reg = {io.in_x9466_reg} ; io.in_x9466_reg := DontCare
    def x9489_reg = {io.in_x9489_reg} ; io.in_x9489_reg := DontCare
  }
  def connectWires0(module: x17297_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x9485_reg.connectLedger(module.io.in_x9485_reg)
    x9845_out_SRAM_conv_1.connectLedger(module.io.in_x9845_out_SRAM_conv_1)
    x9465_reg.connectLedger(module.io.in_x9465_reg)
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x9490_reg.connectLedger(module.io.in_x9490_reg)
    module.io.in_x18796_rd_x9465 <> x18796_rd_x9465
    x9488_reg.connectLedger(module.io.in_x9488_reg)
    x9554_bias_SRAM_0.connectLedger(module.io.in_x9554_bias_SRAM_0)
    module.io.in_x9868 <> x9868
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    module.io.in_x18795_rd_x3920 <> x18795_rd_x3920
    x9496_reg.connectLedger(module.io.in_x9496_reg)
    module.io.in_x9867 <> x9867
    module.io.in_b9553 <> b9553
    x9492_reg.connectLedger(module.io.in_x9492_reg)
    x3921_reg.connectLedger(module.io.in_x3921_reg)
    x9486_reg.connectLedger(module.io.in_x9486_reg)
    x9767_weight_SRAM_reshape_0.connectLedger(module.io.in_x9767_weight_SRAM_reshape_0)
    x9844_out_SRAM_conv_0.connectLedger(module.io.in_x9844_out_SRAM_conv_0)
    x9466_reg.connectLedger(module.io.in_x9466_reg)
    x9489_reg.connectLedger(module.io.in_x9489_reg)
  }
  val x9845_out_SRAM_conv_1 = list_x9845_out_SRAM_conv_1(0)
  val x9554_bias_SRAM_0 = list_x9845_out_SRAM_conv_1(1)
  val x9767_weight_SRAM_reshape_0 = list_x9845_out_SRAM_conv_1(2)
  val x9485_reg = list_x9485_reg(0)
  val x9465_reg = list_x9485_reg(1)
  val x9490_reg = list_x9485_reg(2)
  val x9488_reg = list_x9485_reg(3)
  val x3920_reg = list_x9485_reg(4)
  val x9496_reg = list_x9485_reg(5)
  val x9492_reg = list_x9485_reg(6)
  val x3921_reg = list_x9485_reg(7)
  val x9486_reg = list_x9485_reg(8)
  val x9844_out_SRAM_conv_0 = list_x9485_reg(9)
  val x9466_reg = list_x9485_reg(10)
  val x9489_reg = list_x9485_reg(11)
  val x9867 = list_x9867(0)
  val x9868 = list_x9868(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x18796_rd_x9465 = list_x18796_rd_x9465(0)
  val x18795_rd_x3920 = list_x18796_rd_x9465(1)
  val b9553 = list_x18796_rd_x9465(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17297_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x17297_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17297_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b9852 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b9852.suggestName("b9852")
      val b9852_chain = Module(new RegChainPass(3, 32, myName = "b9852_chain")); b9852_chain.io <> DontCare
      b9852_chain.chain_pass(b9852, io.sigsOut.smDoneIn.head)
      val b9852_chain_read_1 = b9852_chain.read(1).FP(true,32,0)
      val b9852_chain_read_2 = b9852_chain.read(2).FP(true,32,0)
      val b9853 = ~io.sigsIn.cchainOutputs.head.oobs(0); b9853.suggestName("b9853")
      val b9853_chain = Module(new RegChainPass(3, 1, myName = "b9853_chain")); b9853_chain.io <> DontCare
      b9853_chain.chain_pass(b9853, io.sigsOut.smDoneIn.head)
      val b9853_chain_read_1: Bool = b9853_chain.read(1).apply(0)
      val b9853_chain_read_2: Bool = b9853_chain.read(2).apply(0)
      val x9854_in_buffer_0 = (new x9854_in_buffer_0).m.io.asInstanceOf[NBufInterface]
      val x9855_in_buffer_1 = (new x9855_in_buffer_1).m.io.asInstanceOf[NBufInterface]
      val x9856_in_buffer_2 = (new x9856_in_buffer_2).m.io.asInstanceOf[NBufInterface]
      val x9857_in_buffer_3 = (new x9857_in_buffer_3).m.io.asInstanceOf[NBufInterface]
      val x9858_in_buffer_4 = (new x9858_in_buffer_4).m.io.asInstanceOf[NBufInterface]
      val x9859_in_buffer_5 = (new x9859_in_buffer_5).m.io.asInstanceOf[NBufInterface]
      val x9860_in_buffer_6 = (new x9860_in_buffer_6).m.io.asInstanceOf[NBufInterface]
      val x9861_in_buffer_7 = (new x9861_in_buffer_7).m.io.asInstanceOf[NBufInterface]
      val x9862_reg = (new x9862_reg).m.io.asInstanceOf[NBufInterface]
      val x9866_inr_UnitPipe = new x9866_inr_UnitPipe_kernel(List(b9853,b9553), List(b9852), List(x9862_reg), List(x9485_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x9866_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9866_inr_UnitPipe.sm.io.ctrInc)
      b9852_chain.connectStageCtrl((x9866_inr_UnitPipe.done).DS(1.toInt, rr, x9866_inr_UnitPipe.sm.io.backpressure), x9866_inr_UnitPipe.baseEn, 0)
      b9853_chain.connectStageCtrl((x9866_inr_UnitPipe.done).DS(1.toInt, rr, x9866_inr_UnitPipe.sm.io.backpressure), x9866_inr_UnitPipe.baseEn, 0)
      x9866_inr_UnitPipe.backpressure := true.B | x9866_inr_UnitPipe.sm.io.doneLatch
      x9866_inr_UnitPipe.forwardpressure := true.B | x9866_inr_UnitPipe.sm.io.doneLatch
      x9866_inr_UnitPipe.sm.io.enableOut.zip(x9866_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9866_inr_UnitPipe.sm.io.break := false.B
      x9866_inr_UnitPipe.mask := true.B & b9853 & b9553
      x9866_inr_UnitPipe.configure("x9866_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9866_inr_UnitPipe.kernel()
      val x10006_outr_UnitPipe = new x10006_outr_UnitPipe_kernel(List(b9853_chain_read_1,b9553), List(x9867), List(x9868), List(x9855_in_buffer_1,x9854_in_buffer_0,x9860_in_buffer_6,x9861_in_buffer_7,x9857_in_buffer_3,x9862_reg,x9858_in_buffer_4,x9856_in_buffer_2,x9859_in_buffer_5), List(x9488_reg), List(x2682_tmp_DRAM) , Some(me), List(), 1, 2, 2, List(1), List(32), breakpoints, rr)
      b9852_chain.connectStageCtrl((x10006_outr_UnitPipe.done).DS(1.toInt, rr, x10006_outr_UnitPipe.sm.io.backpressure), x10006_outr_UnitPipe.baseEn, 1)
      b9853_chain.connectStageCtrl((x10006_outr_UnitPipe.done).DS(1.toInt, rr, x10006_outr_UnitPipe.sm.io.backpressure), x10006_outr_UnitPipe.baseEn, 1)
      x10006_outr_UnitPipe.backpressure := true.B | x10006_outr_UnitPipe.sm.io.doneLatch
      x10006_outr_UnitPipe.forwardpressure := true.B | x10006_outr_UnitPipe.sm.io.doneLatch
      x10006_outr_UnitPipe.sm.io.enableOut.zip(x10006_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x10006_outr_UnitPipe.sm.io.break := false.B
      x10006_outr_UnitPipe.mask := true.B & b9853_chain_read_1 & b9553
      x10006_outr_UnitPipe.configure("x10006_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x10006_outr_UnitPipe.kernel()
      val x18797_rd_x9486 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18797_rd_x9486""")
      val x18797_rd_x9486_banks = List[UInt]()
      val x18797_rd_x9486_ofs = List[UInt]()
      val x18797_rd_x9486_en = List[Bool](true.B)
      x18797_rd_x9486.toSeq.zip(x9486_reg.connectRPort(18797, x18797_rd_x9486_banks, x18797_rd_x9486_ofs, io.sigsIn.backpressure, x18797_rd_x9486_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x10008_ctr = new CtrObject(Left(Some(0)), Right(x18797_rd_x9486), Left(Some(1)), 1, 32, false)
      val x18798_rd_x9490 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18798_rd_x9490""")
      val x18798_rd_x9490_banks = List[UInt]()
      val x18798_rd_x9490_ofs = List[UInt]()
      val x18798_rd_x9490_en = List[Bool](true.B)
      x18798_rd_x9490.toSeq.zip(x9490_reg.connectRPort(18798, x18798_rd_x9490_banks, x18798_rd_x9490_ofs, io.sigsIn.backpressure, x18798_rd_x9490_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x10010_ctr = new CtrObject(Left(Some(0)), Right(x18798_rd_x9490), Left(Some(1)), 8, 32, false)
      val x18799_rd_x9492 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18799_rd_x9492""")
      val x18799_rd_x9492_banks = List[UInt]()
      val x18799_rd_x9492_ofs = List[UInt]()
      val x18799_rd_x9492_en = List[Bool](true.B)
      x18799_rd_x9492.toSeq.zip(x9492_reg.connectRPort(18799, x18799_rd_x9492_banks, x18799_rd_x9492_ofs, io.sigsIn.backpressure, x18799_rd_x9492_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x10012_ctr = new CtrObject(Left(Some(0)), Right(x18799_rd_x9492), Left(Some(1)), 1, 32, false)
      val x10013_ctr = new CtrObject(Left(Some(0)), Left(Some(32)), Left(Some(1)), 32, 32, false)
      val x10014_ctrchain = (new CChainObject(List[CtrObject](x10008_ctr,x10010_ctr,x10012_ctr,x10013_ctr), "x10014_ctrchain")).cchain.io 
      x10014_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x10014_ctrchain_p", (x10014_ctrchain.par, x10014_ctrchain.widths))
      val x18800_rd_x3920 = Wire(Bool()).suggestName("""x18800_rd_x3920""")
      val x18800_rd_x3920_banks = List[UInt]()
      val x18800_rd_x3920_ofs = List[UInt]()
      val x18800_rd_x3920_en = List[Bool](true.B)
      x18800_rd_x3920.toSeq.zip(x3920_reg.connectRPort(18800, x18800_rd_x3920_banks, x18800_rd_x3920_ofs, io.sigsIn.backpressure, x18800_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18801_rd_x9466 = Wire(Bool()).suggestName("""x18801_rd_x9466""")
      val x18801_rd_x9466_banks = List[UInt]()
      val x18801_rd_x9466_ofs = List[UInt]()
      val x18801_rd_x9466_en = List[Bool](true.B)
      x18801_rd_x9466.toSeq.zip(x9466_reg.connectRPort(18801, x18801_rd_x9466_banks, x18801_rd_x9466_ofs, io.sigsIn.backpressure, x18801_rd_x9466_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17296_inr_Foreach = new x17296_inr_Foreach_kernel(List(x18800_rd_x3920,x18801_rd_x9466,b9853_chain_read_2,b9553), List(b9852_chain_read_2), List(x9855_in_buffer_1,x9845_out_SRAM_conv_1,x9854_in_buffer_0,x9860_in_buffer_6,x9861_in_buffer_7,x9857_in_buffer_3,x9858_in_buffer_4,x9856_in_buffer_2,x9767_weight_SRAM_reshape_0,x9859_in_buffer_5), List(x9485_reg,x9465_reg,x9496_reg,x3921_reg,x9844_out_SRAM_conv_0,x9489_reg) , Some(me), List(x10014_ctrchain), 2, 1, 1, List(1, 8, 1, 32), List(32, 32, 32, 32), breakpoints, rr)
      x17296_inr_Foreach.sm.io.ctrDone := (x17296_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b9852_chain.connectStageCtrl((x17296_inr_Foreach.done).DS(1.toInt, rr, x17296_inr_Foreach.sm.io.backpressure), x17296_inr_Foreach.baseEn, 2)
      b9853_chain.connectStageCtrl((x17296_inr_Foreach.done).DS(1.toInt, rr, x17296_inr_Foreach.sm.io.backpressure), x17296_inr_Foreach.baseEn, 2)
      x17296_inr_Foreach.backpressure := true.B | x17296_inr_Foreach.sm.io.doneLatch
      x17296_inr_Foreach.forwardpressure := true.B | x17296_inr_Foreach.sm.io.doneLatch
      x17296_inr_Foreach.sm.io.enableOut.zip(x17296_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x17296_inr_Foreach.sm.io.break := false.B
      x17296_inr_Foreach.mask := ~x17296_inr_Foreach.cchain.head.output.noop & b9853_chain_read_2 & b9553 & x18800_rd_x3920 & x18801_rd_x9466
      x17296_inr_Foreach.configure("x17296_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17296_inr_Foreach.kernel()
      x9554_bias_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 4)
      x9767_weight_SRAM_reshape_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x9845_out_SRAM_conv_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x17297_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x17297_outr_Foreach **/
