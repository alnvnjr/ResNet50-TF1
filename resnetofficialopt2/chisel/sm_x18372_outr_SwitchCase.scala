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

/** Hierarchy: x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x18372_outr_SwitchCase **/
class x18372_outr_SwitchCase_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x18215: List[DecoupledIO[AppCommandDense]],
  list_x18216: List[DecoupledIO[AppStoreData]],
  list_x9561: List[DecoupledIO[AppLoadData]],
  list_x17552: List[DecoupledIO[Bool]],
  list_x3905_bias_start_idx_args_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x18372_outr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18372_outr_SwitchCase_iiCtr"))
  
  abstract class x18372_outr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3905_bias_start_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3905_bias_start_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x3910_nc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3910_nc_args_0_p").asInstanceOf[MemParams] ))
      val in_x9561 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9561_p").asInstanceOf[(Int, Int)] )))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3902_in2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3902_in2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x18215 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18215_p").asInstanceOf[(Int,Int)] ))
      val in_x9593 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9593_p").asInstanceOf[(Int,Int)] ))
      val in_x3906_load_idx_0_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3906_load_idx_0_args_0_p").asInstanceOf[MemParams] ))
      val in_x9868 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9868_p").asInstanceOf[(Int, Int)] )))
      val in_x3909_out2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3909_out2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x17550 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17550_p").asInstanceOf[(Int,Int)] ))
      val in_b3916 = Input(new FixedPoint(true, 32, 0))
      val in_x17883 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17883_p").asInstanceOf[(Int, Int)] )))
      val in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x18216 = Decoupled(new AppStoreData(ModuleParams.getParams("x18216_p").asInstanceOf[(Int,Int)] ))
      val in_x3903_in_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3903_in_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x3900_check_Fused_Conv2D_BiasAdd_k1_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3900_check_Fused_Conv2D_BiasAdd_k1_0_p").asInstanceOf[MemParams] ))
      val in_x17882 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17882_p").asInstanceOf[(Int,Int)] ))
      val in_x17749 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17749_p").asInstanceOf[(Int,Int)] ))
      val in_x9560 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9560_p").asInstanceOf[(Int,Int)] ))
      val in_x9867 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9867_p").asInstanceOf[(Int,Int)] ))
      val in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3908_or_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3908_or_args_0_p").asInstanceOf[MemParams] ))
      val in_x9595 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9595_p").asInstanceOf[(Int, Int)] )))
      val in_x3921_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3921_reg_p").asInstanceOf[MemParams] ))
      val in_x17551 = Decoupled(new AppStoreData(ModuleParams.getParams("x17551_p").asInstanceOf[(Int,Int)] ))
      val in_x3913_out_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3913_out_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x3904_weights_start_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3904_weights_start_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x17552 = Flipped(Decoupled(Bool()))
      val in_x17750 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17750_p").asInstanceOf[(Int, Int)] )))
      val in_x3911_oc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3911_oc_args_0_p").asInstanceOf[MemParams] ))
      val in_x18217 = Flipped(Decoupled(Bool()))
      val in_x3907_store_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3907_store_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x3901_stride_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3901_stride_args_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x3905_bias_start_idx_args_0 = {io.in_x3905_bias_start_idx_args_0} ; io.in_x3905_bias_start_idx_args_0 := DontCare
    def x3910_nc_args_0 = {io.in_x3910_nc_args_0} ; io.in_x3910_nc_args_0 := DontCare
    def x9561 = {io.in_x9561} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3902_in2D_args_0 = {io.in_x3902_in2D_args_0} ; io.in_x3902_in2D_args_0 := DontCare
    def x18215 = {io.in_x18215} 
    def x9593 = {io.in_x9593} 
    def x3906_load_idx_0_args_0 = {io.in_x3906_load_idx_0_args_0} ; io.in_x3906_load_idx_0_args_0 := DontCare
    def x9868 = {io.in_x9868} 
    def x3909_out2D_args_0 = {io.in_x3909_out2D_args_0} ; io.in_x3909_out2D_args_0 := DontCare
    def x17550 = {io.in_x17550} 
    def b3916 = {io.in_b3916} 
    def x17883 = {io.in_x17883} 
    def x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = {io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x18216 = {io.in_x18216} 
    def x3903_in_channels_args_0 = {io.in_x3903_in_channels_args_0} ; io.in_x3903_in_channels_args_0 := DontCare
    def x3900_check_Fused_Conv2D_BiasAdd_k1_0 = {io.in_x3900_check_Fused_Conv2D_BiasAdd_k1_0} ; io.in_x3900_check_Fused_Conv2D_BiasAdd_k1_0 := DontCare
    def x17882 = {io.in_x17882} 
    def x17749 = {io.in_x17749} 
    def x9560 = {io.in_x9560} 
    def x9867 = {io.in_x9867} 
    def x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = {io.in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM} 
    def x3908_or_args_0 = {io.in_x3908_or_args_0} ; io.in_x3908_or_args_0 := DontCare
    def x9595 = {io.in_x9595} 
    def x3921_reg = {io.in_x3921_reg} ; io.in_x3921_reg := DontCare
    def x17551 = {io.in_x17551} 
    def x3913_out_channels_args_0 = {io.in_x3913_out_channels_args_0} ; io.in_x3913_out_channels_args_0 := DontCare
    def x3904_weights_start_idx_args_0 = {io.in_x3904_weights_start_idx_args_0} ; io.in_x3904_weights_start_idx_args_0 := DontCare
    def x17552 = {io.in_x17552} 
    def x17750 = {io.in_x17750} 
    def x3911_oc_args_0 = {io.in_x3911_oc_args_0} ; io.in_x3911_oc_args_0 := DontCare
    def x18217 = {io.in_x18217} 
    def x3907_store_idx_args_0 = {io.in_x3907_store_idx_args_0} ; io.in_x3907_store_idx_args_0 := DontCare
    def x3901_stride_args_0 = {io.in_x3901_stride_args_0} ; io.in_x3901_stride_args_0 := DontCare
  }
  def connectWires0(module: x18372_outr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x3905_bias_start_idx_args_0.connectLedger(module.io.in_x3905_bias_start_idx_args_0)
    x3910_nc_args_0.connectLedger(module.io.in_x3910_nc_args_0)
    module.io.in_x9561 <> x9561
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3902_in2D_args_0.connectLedger(module.io.in_x3902_in2D_args_0)
    module.io.in_x18215 <> x18215
    module.io.in_x9593 <> x9593
    x3906_load_idx_0_args_0.connectLedger(module.io.in_x3906_load_idx_0_args_0)
    module.io.in_x9868 <> x9868
    x3909_out2D_args_0.connectLedger(module.io.in_x3909_out2D_args_0)
    module.io.in_x17550 <> x17550
    module.io.in_b3916 <> b3916
    module.io.in_x17883 <> x17883
    module.io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM <> x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    module.io.in_x18216 <> x18216
    x3903_in_channels_args_0.connectLedger(module.io.in_x3903_in_channels_args_0)
    x3900_check_Fused_Conv2D_BiasAdd_k1_0.connectLedger(module.io.in_x3900_check_Fused_Conv2D_BiasAdd_k1_0)
    module.io.in_x17882 <> x17882
    module.io.in_x17749 <> x17749
    module.io.in_x9560 <> x9560
    module.io.in_x9867 <> x9867
    module.io.in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM <> x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM
    x3908_or_args_0.connectLedger(module.io.in_x3908_or_args_0)
    module.io.in_x9595 <> x9595
    x3921_reg.connectLedger(module.io.in_x3921_reg)
    module.io.in_x17551 <> x17551
    x3913_out_channels_args_0.connectLedger(module.io.in_x3913_out_channels_args_0)
    x3904_weights_start_idx_args_0.connectLedger(module.io.in_x3904_weights_start_idx_args_0)
    module.io.in_x17552 <> x17552
    module.io.in_x17750 <> x17750
    x3911_oc_args_0.connectLedger(module.io.in_x3911_oc_args_0)
    module.io.in_x18217 <> x18217
    x3907_store_idx_args_0.connectLedger(module.io.in_x3907_store_idx_args_0)
    x3901_stride_args_0.connectLedger(module.io.in_x3901_stride_args_0)
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b3916 = list_x2682_tmp_DRAM(1)
  val x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = list_x2682_tmp_DRAM(2)
  val x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = list_x2682_tmp_DRAM(3)
  val x18215 = list_x18215(0)
  val x9593 = list_x18215(1)
  val x17550 = list_x18215(2)
  val x17882 = list_x18215(3)
  val x17749 = list_x18215(4)
  val x9560 = list_x18215(5)
  val x9867 = list_x18215(6)
  val x18216 = list_x18216(0)
  val x17551 = list_x18216(1)
  val x9561 = list_x9561(0)
  val x9868 = list_x9561(1)
  val x17883 = list_x9561(2)
  val x9595 = list_x9561(3)
  val x17750 = list_x9561(4)
  val x17552 = list_x17552(0)
  val x18217 = list_x17552(1)
  val x3905_bias_start_idx_args_0 = list_x3905_bias_start_idx_args_0(0)
  val x3910_nc_args_0 = list_x3905_bias_start_idx_args_0(1)
  val x3902_in2D_args_0 = list_x3905_bias_start_idx_args_0(2)
  val x3906_load_idx_0_args_0 = list_x3905_bias_start_idx_args_0(3)
  val x3909_out2D_args_0 = list_x3905_bias_start_idx_args_0(4)
  val x3920_reg = list_x3905_bias_start_idx_args_0(5)
  val x3903_in_channels_args_0 = list_x3905_bias_start_idx_args_0(6)
  val x3900_check_Fused_Conv2D_BiasAdd_k1_0 = list_x3905_bias_start_idx_args_0(7)
  val x3908_or_args_0 = list_x3905_bias_start_idx_args_0(8)
  val x3921_reg = list_x3905_bias_start_idx_args_0(9)
  val x3913_out_channels_args_0 = list_x3905_bias_start_idx_args_0(10)
  val x3904_weights_start_idx_args_0 = list_x3905_bias_start_idx_args_0(11)
  val x3911_oc_args_0 = list_x3905_bias_start_idx_args_0(12)
  val x3907_store_idx_args_0 = list_x3905_bias_start_idx_args_0(13)
  val x3901_stride_args_0 = list_x3905_bias_start_idx_args_0(14)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18372_outr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x18372_outr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18372_outr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      // Controller Stack: Stack(x18373, x18374, x1256)
      val x9465_reg = (new x9465_reg).m.io.asInstanceOf[StandardInterface]
      val x9466_reg = (new x9466_reg).m.io.asInstanceOf[StandardInterface]
      val x9467_reg = (new x9467_reg).m.io.asInstanceOf[StandardInterface]
      val x9468_reg = (new x9468_reg).m.io.asInstanceOf[StandardInterface]
      val x9479_inr_UnitPipe = new x9479_inr_UnitPipe_kernel(List(b3916), List(x9465_reg,x3920_reg,x9468_reg,x3900_check_Fused_Conv2D_BiasAdd_k1_0,x9467_reg,x9466_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x9479_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9479_inr_UnitPipe.sm.io.ctrInc)
      x9479_inr_UnitPipe.backpressure := true.B | x9479_inr_UnitPipe.sm.io.doneLatch
      x9479_inr_UnitPipe.forwardpressure := true.B | x9479_inr_UnitPipe.sm.io.doneLatch
      x9479_inr_UnitPipe.sm.io.enableOut.zip(x9479_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9479_inr_UnitPipe.sm.io.break := false.B
      x9479_inr_UnitPipe.mask := true.B & true.B
      x9479_inr_UnitPipe.configure("x9479_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9479_inr_UnitPipe.kernel()
      val x18784_rd_x9465 = Wire(Bool()).suggestName("""x18784_rd_x9465""")
      val x18784_rd_x9465_banks = List[UInt]()
      val x18784_rd_x9465_ofs = List[UInt]()
      val x18784_rd_x9465_en = List[Bool](true.B)
      x18784_rd_x9465.toSeq.zip(x9465_reg.connectRPort(18784, x18784_rd_x9465_banks, x18784_rd_x9465_ofs, io.sigsIn.backpressure, x18784_rd_x9465_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18785_rd_x9467 = Wire(Bool()).suggestName("""x18785_rd_x9467""")
      val x18785_rd_x9467_banks = List[UInt]()
      val x18785_rd_x9467_ofs = List[UInt]()
      val x18785_rd_x9467_en = List[Bool](true.B)
      x18785_rd_x9467.toSeq.zip(x9467_reg.connectRPort(18785, x18785_rd_x9467_banks, x18785_rd_x9467_ofs, io.sigsIn.backpressure, x18785_rd_x9467_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18370_outr_Switch_obj = new x18370_outr_Switch_kernel(List(x2682_tmp_DRAM,b3916,x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM,x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM), List(x18215,x9593,x17550,x17882,x17749,x9560,x9867), List(x3905_bias_start_idx_args_0,x3910_nc_args_0,x9465_reg,x3902_in2D_args_0,x3906_load_idx_0_args_0,x3909_out2D_args_0,x3920_reg,x3903_in_channels_args_0,x9468_reg,x3908_or_args_0,x3921_reg,x3913_out_channels_args_0,x3904_weights_start_idx_args_0,x9467_reg,x3911_oc_args_0,x3907_store_idx_args_0,x9466_reg,x3901_stride_args_0), List(x18784_rd_x9465,x18785_rd_x9467), List(x18216,x17551), List(x9561,x9868,x17883,x9595,x17750), List(x17552,x18217) , Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, rr)
      val x17715_outr_SwitchCase_switch_sel_reg = RegInit(false.B)
      x17715_outr_SwitchCase_switch_sel_reg := Mux(risingEdge(x18370_outr_Switch_obj.en), x18784_rd_x9465, x17715_outr_SwitchCase_switch_sel_reg)
      x18370_outr_Switch_obj.sm.io.selectsIn(0) := x18784_rd_x9465
      val x18369_outr_SwitchCase_switch_sel_reg = RegInit(false.B)
      x18369_outr_SwitchCase_switch_sel_reg := Mux(risingEdge(x18370_outr_Switch_obj.en), x18785_rd_x9467, x18369_outr_SwitchCase_switch_sel_reg)
      x18370_outr_Switch_obj.sm.io.selectsIn(1) := x18785_rd_x9467
      x18370_outr_Switch_obj.backpressure := true.B | x18370_outr_Switch_obj.sm.io.doneLatch
      x18370_outr_Switch_obj.forwardpressure := true.B | x18370_outr_Switch_obj.sm.io.doneLatch
      x18370_outr_Switch_obj.sm.io.enableOut.zip(x18370_outr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x18370_outr_Switch_obj.sm.io.break := false.B
      x18370_outr_Switch_obj.mask := true.B & true.B
      x18370_outr_Switch_obj.configure("x18370_outr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18370_outr_Switch_obj.kernel()
    }
    val module = Module(new x18372_outr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END SwitchCase x18372_outr_SwitchCase **/
