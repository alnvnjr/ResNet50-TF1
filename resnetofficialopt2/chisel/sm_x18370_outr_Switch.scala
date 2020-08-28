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

/** Hierarchy: x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x18370_outr_Switch **/
class x18370_outr_Switch_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x18215: List[DecoupledIO[AppCommandDense]],
  list_x3905_bias_start_idx_args_0: List[StandardInterface],
  list_x18784_rd_x9465: List[Bool],
  list_x18216: List[DecoupledIO[AppStoreData]],
  list_x9561: List[DecoupledIO[AppLoadData]],
  list_x17552: List[DecoupledIO[Bool]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Fork, 2, isFSM = false   ,cases = 2, latency = 0.0.toInt, myName = "x18370_outr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18370_outr_Switch_iiCtr"))
  
  abstract class x18370_outr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3905_bias_start_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3905_bias_start_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x3910_nc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3910_nc_args_0_p").asInstanceOf[MemParams] ))
      val in_x9465_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9465_reg_p").asInstanceOf[MemParams] ))
      val in_x9561 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9561_p").asInstanceOf[(Int, Int)] )))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3902_in2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3902_in2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x18215 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18215_p").asInstanceOf[(Int,Int)] ))
      val in_x9593 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9593_p").asInstanceOf[(Int,Int)] ))
      val in_x3906_load_idx_0_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3906_load_idx_0_args_0_p").asInstanceOf[MemParams] ))
      val in_x18784_rd_x9465 = Input(Bool())
      val in_x9868 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9868_p").asInstanceOf[(Int, Int)] )))
      val in_x3909_out2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3909_out2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x17550 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17550_p").asInstanceOf[(Int,Int)] ))
      val in_b3916 = Input(new FixedPoint(true, 32, 0))
      val in_x17883 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17883_p").asInstanceOf[(Int, Int)] )))
      val in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x18216 = Decoupled(new AppStoreData(ModuleParams.getParams("x18216_p").asInstanceOf[(Int,Int)] ))
      val in_x3903_in_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3903_in_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x9468_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9468_reg_p").asInstanceOf[MemParams] ))
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
      val in_x9467_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9467_reg_p").asInstanceOf[MemParams] ))
      val in_x17552 = Flipped(Decoupled(Bool()))
      val in_x17750 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17750_p").asInstanceOf[(Int, Int)] )))
      val in_x3911_oc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3911_oc_args_0_p").asInstanceOf[MemParams] ))
      val in_x18217 = Flipped(Decoupled(Bool()))
      val in_x3907_store_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3907_store_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x18785_rd_x9467 = Input(Bool())
      val in_x9466_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9466_reg_p").asInstanceOf[MemParams] ))
      val in_x3901_stride_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3901_stride_args_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x3905_bias_start_idx_args_0 = {io.in_x3905_bias_start_idx_args_0} ; io.in_x3905_bias_start_idx_args_0 := DontCare
    def x3910_nc_args_0 = {io.in_x3910_nc_args_0} ; io.in_x3910_nc_args_0 := DontCare
    def x9465_reg = {io.in_x9465_reg} ; io.in_x9465_reg := DontCare
    def x9561 = {io.in_x9561} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3902_in2D_args_0 = {io.in_x3902_in2D_args_0} ; io.in_x3902_in2D_args_0 := DontCare
    def x18215 = {io.in_x18215} 
    def x9593 = {io.in_x9593} 
    def x3906_load_idx_0_args_0 = {io.in_x3906_load_idx_0_args_0} ; io.in_x3906_load_idx_0_args_0 := DontCare
    def x18784_rd_x9465 = {io.in_x18784_rd_x9465} 
    def x9868 = {io.in_x9868} 
    def x3909_out2D_args_0 = {io.in_x3909_out2D_args_0} ; io.in_x3909_out2D_args_0 := DontCare
    def x17550 = {io.in_x17550} 
    def b3916 = {io.in_b3916} 
    def x17883 = {io.in_x17883} 
    def x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = {io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x18216 = {io.in_x18216} 
    def x3903_in_channels_args_0 = {io.in_x3903_in_channels_args_0} ; io.in_x3903_in_channels_args_0 := DontCare
    def x9468_reg = {io.in_x9468_reg} ; io.in_x9468_reg := DontCare
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
    def x9467_reg = {io.in_x9467_reg} ; io.in_x9467_reg := DontCare
    def x17552 = {io.in_x17552} 
    def x17750 = {io.in_x17750} 
    def x3911_oc_args_0 = {io.in_x3911_oc_args_0} ; io.in_x3911_oc_args_0 := DontCare
    def x18217 = {io.in_x18217} 
    def x3907_store_idx_args_0 = {io.in_x3907_store_idx_args_0} ; io.in_x3907_store_idx_args_0 := DontCare
    def x18785_rd_x9467 = {io.in_x18785_rd_x9467} 
    def x9466_reg = {io.in_x9466_reg} ; io.in_x9466_reg := DontCare
    def x3901_stride_args_0 = {io.in_x3901_stride_args_0} ; io.in_x3901_stride_args_0 := DontCare
  }
  def connectWires0(module: x18370_outr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x3905_bias_start_idx_args_0.connectLedger(module.io.in_x3905_bias_start_idx_args_0)
    x3910_nc_args_0.connectLedger(module.io.in_x3910_nc_args_0)
    x9465_reg.connectLedger(module.io.in_x9465_reg)
    module.io.in_x9561 <> x9561
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3902_in2D_args_0.connectLedger(module.io.in_x3902_in2D_args_0)
    module.io.in_x18215 <> x18215
    module.io.in_x9593 <> x9593
    x3906_load_idx_0_args_0.connectLedger(module.io.in_x3906_load_idx_0_args_0)
    module.io.in_x18784_rd_x9465 <> x18784_rd_x9465
    module.io.in_x9868 <> x9868
    x3909_out2D_args_0.connectLedger(module.io.in_x3909_out2D_args_0)
    module.io.in_x17550 <> x17550
    module.io.in_b3916 <> b3916
    module.io.in_x17883 <> x17883
    module.io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM <> x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    module.io.in_x18216 <> x18216
    x3903_in_channels_args_0.connectLedger(module.io.in_x3903_in_channels_args_0)
    x9468_reg.connectLedger(module.io.in_x9468_reg)
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
    x9467_reg.connectLedger(module.io.in_x9467_reg)
    module.io.in_x17552 <> x17552
    module.io.in_x17750 <> x17750
    x3911_oc_args_0.connectLedger(module.io.in_x3911_oc_args_0)
    module.io.in_x18217 <> x18217
    x3907_store_idx_args_0.connectLedger(module.io.in_x3907_store_idx_args_0)
    module.io.in_x18785_rd_x9467 <> x18785_rd_x9467
    x9466_reg.connectLedger(module.io.in_x9466_reg)
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
  val x3905_bias_start_idx_args_0 = list_x3905_bias_start_idx_args_0(0)
  val x3910_nc_args_0 = list_x3905_bias_start_idx_args_0(1)
  val x9465_reg = list_x3905_bias_start_idx_args_0(2)
  val x3902_in2D_args_0 = list_x3905_bias_start_idx_args_0(3)
  val x3906_load_idx_0_args_0 = list_x3905_bias_start_idx_args_0(4)
  val x3909_out2D_args_0 = list_x3905_bias_start_idx_args_0(5)
  val x3920_reg = list_x3905_bias_start_idx_args_0(6)
  val x3903_in_channels_args_0 = list_x3905_bias_start_idx_args_0(7)
  val x9468_reg = list_x3905_bias_start_idx_args_0(8)
  val x3908_or_args_0 = list_x3905_bias_start_idx_args_0(9)
  val x3921_reg = list_x3905_bias_start_idx_args_0(10)
  val x3913_out_channels_args_0 = list_x3905_bias_start_idx_args_0(11)
  val x3904_weights_start_idx_args_0 = list_x3905_bias_start_idx_args_0(12)
  val x9467_reg = list_x3905_bias_start_idx_args_0(13)
  val x3911_oc_args_0 = list_x3905_bias_start_idx_args_0(14)
  val x3907_store_idx_args_0 = list_x3905_bias_start_idx_args_0(15)
  val x9466_reg = list_x3905_bias_start_idx_args_0(16)
  val x3901_stride_args_0 = list_x3905_bias_start_idx_args_0(17)
  val x18784_rd_x9465 = list_x18784_rd_x9465(0)
  val x18785_rd_x9467 = list_x18784_rd_x9465(1)
  val x18216 = list_x18216(0)
  val x17551 = list_x18216(1)
  val x9561 = list_x9561(0)
  val x9868 = list_x9561(1)
  val x17883 = list_x9561(2)
  val x9595 = list_x9561(3)
  val x17750 = list_x9561(4)
  val x17552 = list_x17552(0)
  val x18217 = list_x17552(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18370_outr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x18370_outr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18370_outr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x17715_outr_SwitchCase_obj = new x17715_outr_SwitchCase_kernel(List(x2682_tmp_DRAM,b3916,x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM,x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM), List(x3905_bias_start_idx_args_0,x3910_nc_args_0,x9465_reg,x3902_in2D_args_0,x3906_load_idx_0_args_0,x3909_out2D_args_0,x3920_reg,x3903_in_channels_args_0,x3908_or_args_0,x3921_reg,x3913_out_channels_args_0,x3904_weights_start_idx_args_0,x3911_oc_args_0,x3907_store_idx_args_0,x9466_reg,x3901_stride_args_0), List(x9593,x17550,x9560,x9867), List(x9561,x9868,x9595), List(x17552), List(x17551) , Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, rr)
      x17715_outr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x17715_outr_SwitchCase_obj.sm.io.ctrInc)
      x17715_outr_SwitchCase_obj.backpressure := true.B | x17715_outr_SwitchCase_obj.sm.io.doneLatch
      x17715_outr_SwitchCase_obj.forwardpressure := true.B | x17715_outr_SwitchCase_obj.sm.io.doneLatch
      x17715_outr_SwitchCase_obj.sm.io.enableOut.zip(x17715_outr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x17715_outr_SwitchCase_obj.sm.io.break := false.B
      x17715_outr_SwitchCase_obj.mask := true.B & true.B
      x17715_outr_SwitchCase_obj.configure("x17715_outr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17715_outr_SwitchCase_obj.kernel()
      val x18369_outr_SwitchCase_obj = new x18369_outr_SwitchCase_kernel(List(x18216), List(x17883,x17750), List(x18215,x17882,x17749), List(x2682_tmp_DRAM,b3916), List(x18217), List(x3902_in2D_args_0,x3906_load_idx_0_args_0,x3920_reg,x3903_in_channels_args_0,x9468_reg,x3921_reg,x9467_reg,x3907_store_idx_args_0) , Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, rr)
      x18369_outr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x18369_outr_SwitchCase_obj.sm.io.ctrInc)
      x18369_outr_SwitchCase_obj.backpressure := true.B | x18369_outr_SwitchCase_obj.sm.io.doneLatch
      x18369_outr_SwitchCase_obj.forwardpressure := true.B | x18369_outr_SwitchCase_obj.sm.io.doneLatch
      x18369_outr_SwitchCase_obj.sm.io.enableOut.zip(x18369_outr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x18369_outr_SwitchCase_obj.sm.io.break := false.B
      x18369_outr_SwitchCase_obj.mask := true.B & true.B
      x18369_outr_SwitchCase_obj.configure("x18369_outr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18369_outr_SwitchCase_obj.kernel()
    }
    val module = Module(new x18370_outr_Switch_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END Switch x18370_outr_Switch **/
