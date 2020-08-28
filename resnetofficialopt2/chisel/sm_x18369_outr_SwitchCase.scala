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

/** Hierarchy: x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x18369_outr_SwitchCase **/
class x18369_outr_SwitchCase_kernel(
  list_x18216: List[DecoupledIO[AppStoreData]],
  list_x17883: List[DecoupledIO[AppLoadData]],
  list_x18215: List[DecoupledIO[AppCommandDense]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x18217: List[DecoupledIO[Bool]],
  list_x3902_in2D_args_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x18369_outr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18369_outr_SwitchCase_iiCtr"))
  
  abstract class x18369_outr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3902_in2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3902_in2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x18215 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18215_p").asInstanceOf[(Int,Int)] ))
      val in_x3906_load_idx_0_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3906_load_idx_0_args_0_p").asInstanceOf[MemParams] ))
      val in_b3916 = Input(new FixedPoint(true, 32, 0))
      val in_x17883 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17883_p").asInstanceOf[(Int, Int)] )))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x18216 = Decoupled(new AppStoreData(ModuleParams.getParams("x18216_p").asInstanceOf[(Int,Int)] ))
      val in_x3903_in_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3903_in_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x9468_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9468_reg_p").asInstanceOf[MemParams] ))
      val in_x17882 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17882_p").asInstanceOf[(Int,Int)] ))
      val in_x17749 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17749_p").asInstanceOf[(Int,Int)] ))
      val in_x3921_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3921_reg_p").asInstanceOf[MemParams] ))
      val in_x9467_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9467_reg_p").asInstanceOf[MemParams] ))
      val in_x17750 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17750_p").asInstanceOf[(Int, Int)] )))
      val in_x18217 = Flipped(Decoupled(Bool()))
      val in_x3907_store_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3907_store_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3902_in2D_args_0 = {io.in_x3902_in2D_args_0} ; io.in_x3902_in2D_args_0 := DontCare
    def x18215 = {io.in_x18215} 
    def x3906_load_idx_0_args_0 = {io.in_x3906_load_idx_0_args_0} ; io.in_x3906_load_idx_0_args_0 := DontCare
    def b3916 = {io.in_b3916} 
    def x17883 = {io.in_x17883} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x18216 = {io.in_x18216} 
    def x3903_in_channels_args_0 = {io.in_x3903_in_channels_args_0} ; io.in_x3903_in_channels_args_0 := DontCare
    def x9468_reg = {io.in_x9468_reg} ; io.in_x9468_reg := DontCare
    def x17882 = {io.in_x17882} 
    def x17749 = {io.in_x17749} 
    def x3921_reg = {io.in_x3921_reg} ; io.in_x3921_reg := DontCare
    def x9467_reg = {io.in_x9467_reg} ; io.in_x9467_reg := DontCare
    def x17750 = {io.in_x17750} 
    def x18217 = {io.in_x18217} 
    def x3907_store_idx_args_0 = {io.in_x3907_store_idx_args_0} ; io.in_x3907_store_idx_args_0 := DontCare
  }
  def connectWires0(module: x18369_outr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3902_in2D_args_0.connectLedger(module.io.in_x3902_in2D_args_0)
    module.io.in_x18215 <> x18215
    x3906_load_idx_0_args_0.connectLedger(module.io.in_x3906_load_idx_0_args_0)
    module.io.in_b3916 <> b3916
    module.io.in_x17883 <> x17883
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    module.io.in_x18216 <> x18216
    x3903_in_channels_args_0.connectLedger(module.io.in_x3903_in_channels_args_0)
    x9468_reg.connectLedger(module.io.in_x9468_reg)
    module.io.in_x17882 <> x17882
    module.io.in_x17749 <> x17749
    x3921_reg.connectLedger(module.io.in_x3921_reg)
    x9467_reg.connectLedger(module.io.in_x9467_reg)
    module.io.in_x17750 <> x17750
    module.io.in_x18217 <> x18217
    x3907_store_idx_args_0.connectLedger(module.io.in_x3907_store_idx_args_0)
  }
  val x18216 = list_x18216(0)
  val x17883 = list_x17883(0)
  val x17750 = list_x17883(1)
  val x18215 = list_x18215(0)
  val x17882 = list_x18215(1)
  val x17749 = list_x18215(2)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b3916 = list_x2682_tmp_DRAM(1)
  val x18217 = list_x18217(0)
  val x3902_in2D_args_0 = list_x3902_in2D_args_0(0)
  val x3906_load_idx_0_args_0 = list_x3902_in2D_args_0(1)
  val x3920_reg = list_x3902_in2D_args_0(2)
  val x3903_in_channels_args_0 = list_x3902_in2D_args_0(3)
  val x9468_reg = list_x3902_in2D_args_0(4)
  val x3921_reg = list_x3902_in2D_args_0(5)
  val x9467_reg = list_x3902_in2D_args_0(6)
  val x3907_store_idx_args_0 = list_x3902_in2D_args_0(7)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18369_outr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x18369_outr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18369_outr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      // Controller Stack: Stack(x18370, x18372, x18373, x18374, x1256)
      val x17716_load_idx_1_args_0 = (new x17716_load_idx_1_args_0).m.io.asInstanceOf[StandardInterface]
      val x17717_reg = (new x17717_reg).m.io.asInstanceOf[StandardInterface]
      val x17718_reg = (new x17718_reg).m.io.asInstanceOf[StandardInterface]
      val x17719_reg = (new x17719_reg).m.io.asInstanceOf[StandardInterface]
      val x17720_reg = (new x17720_reg).m.io.asInstanceOf[StandardInterface]
      val x17740_inr_UnitPipe = new x17740_inr_UnitPipe_kernel(List(b3916), List(x3902_in2D_args_0,x17719_reg,x3906_load_idx_0_args_0,x17720_reg,x3920_reg,x3903_in_channels_args_0,x17716_load_idx_1_args_0,x9467_reg,x17717_reg,x3907_store_idx_args_0,x17718_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x17740_inr_UnitPipe.sm.io.ctrDone := risingEdge(x17740_inr_UnitPipe.sm.io.ctrInc)
      x17740_inr_UnitPipe.backpressure := true.B | x17740_inr_UnitPipe.sm.io.doneLatch
      x17740_inr_UnitPipe.forwardpressure := true.B | x17740_inr_UnitPipe.sm.io.doneLatch
      x17740_inr_UnitPipe.sm.io.enableOut.zip(x17740_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x17740_inr_UnitPipe.sm.io.break := false.B
      x17740_inr_UnitPipe.mask := true.B & true.B
      x17740_inr_UnitPipe.configure("x17740_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17740_inr_UnitPipe.kernel()
      val x18809_rd_x17720 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18809_rd_x17720""")
      val x18809_rd_x17720_banks = List[UInt]()
      val x18809_rd_x17720_ofs = List[UInt]()
      val x18809_rd_x17720_en = List[Bool](true.B)
      x18809_rd_x17720.toSeq.zip(x17720_reg.connectRPort(18809, x18809_rd_x17720_banks, x18809_rd_x17720_ofs, io.sigsIn.backpressure, x18809_rd_x17720_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17742_ctr = new CtrObject(Left(Some(0)), Right(x18809_rd_x17720), Left(Some(3136)), 1, 32, false)
      val x17743_ctrchain = (new CChainObject(List[CtrObject](x17742_ctr), "x17743_ctrchain")).cchain.io 
      x17743_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x17743_ctrchain_p", (x17743_ctrchain.par, x17743_ctrchain.widths))
      val x18810_rd_x3920 = Wire(Bool()).suggestName("""x18810_rd_x3920""")
      val x18810_rd_x3920_banks = List[UInt]()
      val x18810_rd_x3920_ofs = List[UInt]()
      val x18810_rd_x3920_en = List[Bool](true.B)
      x18810_rd_x3920.toSeq.zip(x3920_reg.connectRPort(18810, x18810_rd_x3920_banks, x18810_rd_x3920_ofs, io.sigsIn.backpressure, x18810_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18811_rd_x9467 = Wire(Bool()).suggestName("""x18811_rd_x9467""")
      val x18811_rd_x9467_banks = List[UInt]()
      val x18811_rd_x9467_ofs = List[UInt]()
      val x18811_rd_x9467_en = List[Bool](true.B)
      x18811_rd_x9467.toSeq.zip(x9467_reg.connectRPort(18811, x18811_rd_x9467_banks, x18811_rd_x9467_ofs, io.sigsIn.backpressure, x18811_rd_x9467_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18367_outr_Foreach = new x18367_outr_Foreach_kernel(List(x17719_reg,x3920_reg,x9468_reg,x3921_reg,x9467_reg,x17717_reg,x17718_reg), List(x18216), List(x17883,x17750), List(x18215,x17882,x17749), List(x18810_rd_x3920,x18811_rd_x9467), List(x18217), List(x2682_tmp_DRAM) , Some(me), List(x17743_ctrchain), 1, 4, 1, List(1), List(32), breakpoints, rr)
      x18367_outr_Foreach.sm.io.ctrDone := (x18367_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x18367_outr_Foreach.backpressure := true.B | x18367_outr_Foreach.sm.io.doneLatch
      x18367_outr_Foreach.forwardpressure := true.B | x18367_outr_Foreach.sm.io.doneLatch
      x18367_outr_Foreach.sm.io.enableOut.zip(x18367_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x18367_outr_Foreach.sm.io.break := false.B
      x18367_outr_Foreach.mask := ~x18367_outr_Foreach.cchain.head.output.noop & x18810_rd_x3920 & x18811_rd_x9467
      x18367_outr_Foreach.configure("x18367_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18367_outr_Foreach.kernel()
    }
    val module = Module(new x18369_outr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END SwitchCase x18369_outr_SwitchCase **/
