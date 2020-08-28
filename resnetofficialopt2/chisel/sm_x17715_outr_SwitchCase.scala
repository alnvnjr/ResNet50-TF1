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

/** Hierarchy: x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17715_outr_SwitchCase **/
class x17715_outr_SwitchCase_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x3905_bias_start_idx_args_0: List[StandardInterface],
  list_x9593: List[DecoupledIO[AppCommandDense]],
  list_x9561: List[DecoupledIO[AppLoadData]],
  list_x17552: List[DecoupledIO[Bool]],
  list_x17551: List[DecoupledIO[AppStoreData]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x17715_outr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17715_outr_SwitchCase_iiCtr"))
  
  abstract class x17715_outr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3905_bias_start_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3905_bias_start_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x3910_nc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3910_nc_args_0_p").asInstanceOf[MemParams] ))
      val in_x9465_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9465_reg_p").asInstanceOf[MemParams] ))
      val in_x9561 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9561_p").asInstanceOf[(Int, Int)] )))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3902_in2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3902_in2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x9593 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9593_p").asInstanceOf[(Int,Int)] ))
      val in_x3906_load_idx_0_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3906_load_idx_0_args_0_p").asInstanceOf[MemParams] ))
      val in_x9868 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9868_p").asInstanceOf[(Int, Int)] )))
      val in_x3909_out2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3909_out2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x17550 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17550_p").asInstanceOf[(Int,Int)] ))
      val in_b3916 = Input(new FixedPoint(true, 32, 0))
      val in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x3903_in_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3903_in_channels_args_0_p").asInstanceOf[MemParams] ))
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
      val in_x3911_oc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3911_oc_args_0_p").asInstanceOf[MemParams] ))
      val in_x3907_store_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3907_store_idx_args_0_p").asInstanceOf[MemParams] ))
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
    def x9593 = {io.in_x9593} 
    def x3906_load_idx_0_args_0 = {io.in_x3906_load_idx_0_args_0} ; io.in_x3906_load_idx_0_args_0 := DontCare
    def x9868 = {io.in_x9868} 
    def x3909_out2D_args_0 = {io.in_x3909_out2D_args_0} ; io.in_x3909_out2D_args_0 := DontCare
    def x17550 = {io.in_x17550} 
    def b3916 = {io.in_b3916} 
    def x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = {io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x3903_in_channels_args_0 = {io.in_x3903_in_channels_args_0} ; io.in_x3903_in_channels_args_0 := DontCare
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
    def x3911_oc_args_0 = {io.in_x3911_oc_args_0} ; io.in_x3911_oc_args_0 := DontCare
    def x3907_store_idx_args_0 = {io.in_x3907_store_idx_args_0} ; io.in_x3907_store_idx_args_0 := DontCare
    def x9466_reg = {io.in_x9466_reg} ; io.in_x9466_reg := DontCare
    def x3901_stride_args_0 = {io.in_x3901_stride_args_0} ; io.in_x3901_stride_args_0 := DontCare
  }
  def connectWires0(module: x17715_outr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x3905_bias_start_idx_args_0.connectLedger(module.io.in_x3905_bias_start_idx_args_0)
    x3910_nc_args_0.connectLedger(module.io.in_x3910_nc_args_0)
    x9465_reg.connectLedger(module.io.in_x9465_reg)
    module.io.in_x9561 <> x9561
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3902_in2D_args_0.connectLedger(module.io.in_x3902_in2D_args_0)
    module.io.in_x9593 <> x9593
    x3906_load_idx_0_args_0.connectLedger(module.io.in_x3906_load_idx_0_args_0)
    module.io.in_x9868 <> x9868
    x3909_out2D_args_0.connectLedger(module.io.in_x3909_out2D_args_0)
    module.io.in_x17550 <> x17550
    module.io.in_b3916 <> b3916
    module.io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM <> x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    x3903_in_channels_args_0.connectLedger(module.io.in_x3903_in_channels_args_0)
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
    x3911_oc_args_0.connectLedger(module.io.in_x3911_oc_args_0)
    x3907_store_idx_args_0.connectLedger(module.io.in_x3907_store_idx_args_0)
    x9466_reg.connectLedger(module.io.in_x9466_reg)
    x3901_stride_args_0.connectLedger(module.io.in_x3901_stride_args_0)
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b3916 = list_x2682_tmp_DRAM(1)
  val x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = list_x2682_tmp_DRAM(2)
  val x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = list_x2682_tmp_DRAM(3)
  val x3905_bias_start_idx_args_0 = list_x3905_bias_start_idx_args_0(0)
  val x3910_nc_args_0 = list_x3905_bias_start_idx_args_0(1)
  val x9465_reg = list_x3905_bias_start_idx_args_0(2)
  val x3902_in2D_args_0 = list_x3905_bias_start_idx_args_0(3)
  val x3906_load_idx_0_args_0 = list_x3905_bias_start_idx_args_0(4)
  val x3909_out2D_args_0 = list_x3905_bias_start_idx_args_0(5)
  val x3920_reg = list_x3905_bias_start_idx_args_0(6)
  val x3903_in_channels_args_0 = list_x3905_bias_start_idx_args_0(7)
  val x3908_or_args_0 = list_x3905_bias_start_idx_args_0(8)
  val x3921_reg = list_x3905_bias_start_idx_args_0(9)
  val x3913_out_channels_args_0 = list_x3905_bias_start_idx_args_0(10)
  val x3904_weights_start_idx_args_0 = list_x3905_bias_start_idx_args_0(11)
  val x3911_oc_args_0 = list_x3905_bias_start_idx_args_0(12)
  val x3907_store_idx_args_0 = list_x3905_bias_start_idx_args_0(13)
  val x9466_reg = list_x3905_bias_start_idx_args_0(14)
  val x3901_stride_args_0 = list_x3905_bias_start_idx_args_0(15)
  val x9593 = list_x9593(0)
  val x17550 = list_x9593(1)
  val x9560 = list_x9593(2)
  val x9867 = list_x9593(3)
  val x9561 = list_x9561(0)
  val x9868 = list_x9561(1)
  val x9595 = list_x9561(2)
  val x17552 = list_x17552(0)
  val x17551 = list_x17551(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17715_outr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x17715_outr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17715_outr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      // Controller Stack: Stack(x18370, x18372, x18373, x18374, x1256)
      val x9482_inB_args_0 = (new x9482_inB_args_0).m.io.asInstanceOf[StandardInterface]
      val x9483_use_relu_args_0 = (new x9483_use_relu_args_0).m.io.asInstanceOf[StandardInterface]
      val x9484_reg = (new x9484_reg).m.io.asInstanceOf[StandardInterface]
      val x9485_reg = (new x9485_reg).m.io.asInstanceOf[StandardInterface]
      val x9486_reg = (new x9486_reg).m.io.asInstanceOf[StandardInterface]
      val x9487_reg = (new x9487_reg).m.io.asInstanceOf[StandardInterface]
      val x9488_reg = (new x9488_reg).m.io.asInstanceOf[StandardInterface]
      val x9489_reg = (new x9489_reg).m.io.asInstanceOf[StandardInterface]
      val x9490_reg = (new x9490_reg).m.io.asInstanceOf[StandardInterface]
      val x9491_reg = (new x9491_reg).m.io.asInstanceOf[StandardInterface]
      val x9492_reg = (new x9492_reg).m.io.asInstanceOf[StandardInterface]
      val x9493_reg = (new x9493_reg).m.io.asInstanceOf[StandardInterface]
      val x9494_reg = (new x9494_reg).m.io.asInstanceOf[StandardInterface]
      val x9495_reg = (new x9495_reg).m.io.asInstanceOf[StandardInterface]
      val x9496_reg = (new x9496_reg).m.io.asInstanceOf[StandardInterface]
      val x9497_reg = (new x9497_reg).m.io.asInstanceOf[StandardInterface]
      val x9498_reg = (new x9498_reg).m.io.asInstanceOf[StandardInterface]
      val x9546_inr_UnitPipe = new x9546_inr_UnitPipe_kernel(List(b3916), List(x9485_reg,x3905_bias_start_idx_args_0,x3910_nc_args_0,x9494_reg,x9465_reg,x3902_in2D_args_0,x9497_reg,x9490_reg,x3906_load_idx_0_args_0,x9488_reg,x3909_out2D_args_0,x9493_reg,x9498_reg,x3920_reg,x3903_in_channels_args_0,x9484_reg,x9496_reg,x9483_use_relu_args_0,x9491_reg,x9487_reg,x9492_reg,x3908_or_args_0,x3913_out_channels_args_0,x3904_weights_start_idx_args_0,x9486_reg,x9495_reg,x3911_oc_args_0,x9482_inB_args_0,x3907_store_idx_args_0,x9489_reg,x3901_stride_args_0) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x9546_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9546_inr_UnitPipe.sm.io.ctrInc)
      x9546_inr_UnitPipe.backpressure := true.B | x9546_inr_UnitPipe.sm.io.doneLatch
      x9546_inr_UnitPipe.forwardpressure := true.B | x9546_inr_UnitPipe.sm.io.doneLatch
      x9546_inr_UnitPipe.sm.io.enableOut.zip(x9546_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9546_inr_UnitPipe.sm.io.break := false.B
      x9546_inr_UnitPipe.mask := true.B & true.B
      x9546_inr_UnitPipe.configure("x9546_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9546_inr_UnitPipe.kernel()
      val x18786_rd_x9494 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18786_rd_x9494""")
      val x18786_rd_x9494_banks = List[UInt]()
      val x18786_rd_x9494_ofs = List[UInt]()
      val x18786_rd_x9494_en = List[Bool](true.B)
      x18786_rd_x9494.toSeq.zip(x9494_reg.connectRPort(18786, x18786_rd_x9494_banks, x18786_rd_x9494_ofs, io.sigsIn.backpressure, x18786_rd_x9494_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9548_ctr = new CtrObject(Left(Some(0)), Right(x18786_rd_x9494), Left(Some(32)), 1, 32, false)
      val x9549_ctrchain = (new CChainObject(List[CtrObject](x9548_ctr), "x9549_ctrchain")).cchain.io 
      x9549_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x9549_ctrchain_p", (x9549_ctrchain.par, x9549_ctrchain.widths))
      val x18787_rd_x3920 = Wire(Bool()).suggestName("""x18787_rd_x3920""")
      val x18787_rd_x3920_banks = List[UInt]()
      val x18787_rd_x3920_ofs = List[UInt]()
      val x18787_rd_x3920_en = List[Bool](true.B)
      x18787_rd_x3920.toSeq.zip(x3920_reg.connectRPort(18787, x18787_rd_x3920_banks, x18787_rd_x3920_ofs, io.sigsIn.backpressure, x18787_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18788_rd_x9465 = Wire(Bool()).suggestName("""x18788_rd_x9465""")
      val x18788_rd_x9465_banks = List[UInt]()
      val x18788_rd_x9465_ofs = List[UInt]()
      val x18788_rd_x9465_en = List[Bool](true.B)
      x18788_rd_x9465.toSeq.zip(x9465_reg.connectRPort(18788, x18788_rd_x9465_banks, x18788_rd_x9465_ofs, io.sigsIn.backpressure, x18788_rd_x9465_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17713_outr_Foreach = new x17713_outr_Foreach_kernel(List(x9485_reg,x9465_reg,x9497_reg,x9490_reg,x9488_reg,x9493_reg,x9498_reg,x3920_reg,x9484_reg,x9496_reg,x9491_reg,x9487_reg,x9492_reg,x3921_reg,x9486_reg,x9495_reg,x9466_reg,x9489_reg), List(x9593,x17550,x9560,x9867), List(x2682_tmp_DRAM,x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM,x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM), List(x9561,x9868,x9595), List(x17552), List(x17551), List(x18787_rd_x3920,x18788_rd_x9465) , Some(me), List(x9549_ctrchain), 1, 7, 1, List(1), List(32), breakpoints, rr)
      x17713_outr_Foreach.sm.io.ctrDone := (x17713_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x17713_outr_Foreach.backpressure := true.B | x17713_outr_Foreach.sm.io.doneLatch
      x17713_outr_Foreach.forwardpressure := true.B | x17713_outr_Foreach.sm.io.doneLatch
      x17713_outr_Foreach.sm.io.enableOut.zip(x17713_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x17713_outr_Foreach.sm.io.break := false.B
      x17713_outr_Foreach.mask := ~x17713_outr_Foreach.cchain.head.output.noop & x18787_rd_x3920 & x18788_rd_x9465
      x17713_outr_Foreach.configure("x17713_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17713_outr_Foreach.kernel()
    }
    val module = Module(new x17715_outr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END SwitchCase x17715_outr_SwitchCase **/
