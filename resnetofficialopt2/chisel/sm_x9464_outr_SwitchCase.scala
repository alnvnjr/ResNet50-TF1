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

/** Hierarchy: x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9464_outr_SwitchCase **/
class x9464_outr_SwitchCase_kernel(
  list_x9401: List[DecoupledIO[Bool]],
  list_x3905_bias_start_idx_args_0: List[StandardInterface],
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x9400: List[DecoupledIO[AppStoreData]],
  list_x4336: List[DecoupledIO[AppCommandDense]],
  list_x3995: List[DecoupledIO[AppLoadData]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 3, isFSM = false   , latency = 0.0.toInt, myName = "x9464_outr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9464_outr_SwitchCase_iiCtr"))
  
  abstract class x9464_outr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3905_bias_start_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3905_bias_start_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x3912_nr_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3912_nr_args_0_p").asInstanceOf[MemParams] ))
      val in_x3910_nc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3910_nc_args_0_p").asInstanceOf[MemParams] ))
      val in_x9400 = Decoupled(new AppStoreData(ModuleParams.getParams("x9400_p").asInstanceOf[(Int,Int)] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3919_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3919_reg_p").asInstanceOf[MemParams] ))
      val in_x3902_in2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3902_in2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x9401 = Flipped(Decoupled(Bool()))
      val in_x3906_load_idx_0_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3906_load_idx_0_args_0_p").asInstanceOf[MemParams] ))
      val in_x3995 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3995_p").asInstanceOf[(Int, Int)] )))
      val in_x3909_out2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3909_out2D_args_0_p").asInstanceOf[MemParams] ))
      val in_b3916 = Input(new FixedPoint(true, 32, 0))
      val in_x3903_in_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3903_in_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x4085 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4085_p").asInstanceOf[(Int, Int)] )))
      val in_x3908_or_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3908_or_args_0_p").asInstanceOf[MemParams] ))
      val in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x4336 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4336_p").asInstanceOf[(Int,Int)] ))
      val in_x3913_out_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3913_out_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x3904_weights_start_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3904_weights_start_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x3911_oc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3911_oc_args_0_p").asInstanceOf[MemParams] ))
      val in_x4338 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4338_p").asInstanceOf[(Int, Int)] )))
      val in_x3993 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3993_p").asInstanceOf[(Int,Int)] ))
      val in_x3907_store_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3907_store_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x4083 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4083_p").asInstanceOf[(Int,Int)] ))
      val in_x3918_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3918_reg_p").asInstanceOf[MemParams] ))
      val in_x3901_stride_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3901_stride_args_0_p").asInstanceOf[MemParams] ))
      val in_x9399 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9399_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 1))
      val rr = Input(Bool())
    })
    def x3905_bias_start_idx_args_0 = {io.in_x3905_bias_start_idx_args_0} ; io.in_x3905_bias_start_idx_args_0 := DontCare
    def x3912_nr_args_0 = {io.in_x3912_nr_args_0} ; io.in_x3912_nr_args_0 := DontCare
    def x3910_nc_args_0 = {io.in_x3910_nc_args_0} ; io.in_x3910_nc_args_0 := DontCare
    def x9400 = {io.in_x9400} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3919_reg = {io.in_x3919_reg} ; io.in_x3919_reg := DontCare
    def x3902_in2D_args_0 = {io.in_x3902_in2D_args_0} ; io.in_x3902_in2D_args_0 := DontCare
    def x9401 = {io.in_x9401} 
    def x3906_load_idx_0_args_0 = {io.in_x3906_load_idx_0_args_0} ; io.in_x3906_load_idx_0_args_0 := DontCare
    def x3995 = {io.in_x3995} 
    def x3909_out2D_args_0 = {io.in_x3909_out2D_args_0} ; io.in_x3909_out2D_args_0 := DontCare
    def b3916 = {io.in_b3916} 
    def x3903_in_channels_args_0 = {io.in_x3903_in_channels_args_0} ; io.in_x3903_in_channels_args_0 := DontCare
    def x4085 = {io.in_x4085} 
    def x3908_or_args_0 = {io.in_x3908_or_args_0} ; io.in_x3908_or_args_0 := DontCare
    def x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = {io.in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM} 
    def x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = {io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM} 
    def x4336 = {io.in_x4336} 
    def x3913_out_channels_args_0 = {io.in_x3913_out_channels_args_0} ; io.in_x3913_out_channels_args_0 := DontCare
    def x3904_weights_start_idx_args_0 = {io.in_x3904_weights_start_idx_args_0} ; io.in_x3904_weights_start_idx_args_0 := DontCare
    def x3911_oc_args_0 = {io.in_x3911_oc_args_0} ; io.in_x3911_oc_args_0 := DontCare
    def x4338 = {io.in_x4338} 
    def x3993 = {io.in_x3993} 
    def x3907_store_idx_args_0 = {io.in_x3907_store_idx_args_0} ; io.in_x3907_store_idx_args_0 := DontCare
    def x4083 = {io.in_x4083} 
    def x3918_reg = {io.in_x3918_reg} ; io.in_x3918_reg := DontCare
    def x3901_stride_args_0 = {io.in_x3901_stride_args_0} ; io.in_x3901_stride_args_0 := DontCare
    def x9399 = {io.in_x9399} 
  }
  def connectWires0(module: x9464_outr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x3905_bias_start_idx_args_0.connectLedger(module.io.in_x3905_bias_start_idx_args_0)
    x3912_nr_args_0.connectLedger(module.io.in_x3912_nr_args_0)
    x3910_nc_args_0.connectLedger(module.io.in_x3910_nc_args_0)
    module.io.in_x9400 <> x9400
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3919_reg.connectLedger(module.io.in_x3919_reg)
    x3902_in2D_args_0.connectLedger(module.io.in_x3902_in2D_args_0)
    module.io.in_x9401 <> x9401
    x3906_load_idx_0_args_0.connectLedger(module.io.in_x3906_load_idx_0_args_0)
    module.io.in_x3995 <> x3995
    x3909_out2D_args_0.connectLedger(module.io.in_x3909_out2D_args_0)
    module.io.in_b3916 <> b3916
    x3903_in_channels_args_0.connectLedger(module.io.in_x3903_in_channels_args_0)
    module.io.in_x4085 <> x4085
    x3908_or_args_0.connectLedger(module.io.in_x3908_or_args_0)
    module.io.in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM <> x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM
    module.io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM <> x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM
    module.io.in_x4336 <> x4336
    x3913_out_channels_args_0.connectLedger(module.io.in_x3913_out_channels_args_0)
    x3904_weights_start_idx_args_0.connectLedger(module.io.in_x3904_weights_start_idx_args_0)
    x3911_oc_args_0.connectLedger(module.io.in_x3911_oc_args_0)
    module.io.in_x4338 <> x4338
    module.io.in_x3993 <> x3993
    x3907_store_idx_args_0.connectLedger(module.io.in_x3907_store_idx_args_0)
    module.io.in_x4083 <> x4083
    x3918_reg.connectLedger(module.io.in_x3918_reg)
    x3901_stride_args_0.connectLedger(module.io.in_x3901_stride_args_0)
    module.io.in_x9399 <> x9399
  }
  val x9401 = list_x9401(0)
  val x3905_bias_start_idx_args_0 = list_x3905_bias_start_idx_args_0(0)
  val x3912_nr_args_0 = list_x3905_bias_start_idx_args_0(1)
  val x3910_nc_args_0 = list_x3905_bias_start_idx_args_0(2)
  val x3919_reg = list_x3905_bias_start_idx_args_0(3)
  val x3902_in2D_args_0 = list_x3905_bias_start_idx_args_0(4)
  val x3906_load_idx_0_args_0 = list_x3905_bias_start_idx_args_0(5)
  val x3909_out2D_args_0 = list_x3905_bias_start_idx_args_0(6)
  val x3903_in_channels_args_0 = list_x3905_bias_start_idx_args_0(7)
  val x3908_or_args_0 = list_x3905_bias_start_idx_args_0(8)
  val x3913_out_channels_args_0 = list_x3905_bias_start_idx_args_0(9)
  val x3904_weights_start_idx_args_0 = list_x3905_bias_start_idx_args_0(10)
  val x3911_oc_args_0 = list_x3905_bias_start_idx_args_0(11)
  val x3907_store_idx_args_0 = list_x3905_bias_start_idx_args_0(12)
  val x3918_reg = list_x3905_bias_start_idx_args_0(13)
  val x3901_stride_args_0 = list_x3905_bias_start_idx_args_0(14)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b3916 = list_x2682_tmp_DRAM(1)
  val x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = list_x2682_tmp_DRAM(2)
  val x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = list_x2682_tmp_DRAM(3)
  val x9400 = list_x9400(0)
  val x4336 = list_x4336(0)
  val x3993 = list_x4336(1)
  val x4083 = list_x4336(2)
  val x9399 = list_x4336(3)
  val x3995 = list_x3995(0)
  val x4085 = list_x3995(1)
  val x4338 = list_x3995(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9464_outr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x9464_outr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9464_outr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      // Controller Stack: Stack(x18373, x18374, x1256)
      val x3934_reg = (new x3934_reg).m.io.asInstanceOf[StandardInterface]
      val x3935_reg = (new x3935_reg).m.io.asInstanceOf[StandardInterface]
      val x3936_reg = (new x3936_reg).m.io.asInstanceOf[StandardInterface]
      val x3937_reg = (new x3937_reg).m.io.asInstanceOf[StandardInterface]
      val x3938_reg = (new x3938_reg).m.io.asInstanceOf[StandardInterface]
      val x3939_reg = (new x3939_reg).m.io.asInstanceOf[StandardInterface]
      val x3940_reg = (new x3940_reg).m.io.asInstanceOf[StandardInterface]
      val x3941_reg = (new x3941_reg).m.io.asInstanceOf[StandardInterface]
      val x3942_reg = (new x3942_reg).m.io.asInstanceOf[StandardInterface]
      val x3943_reg = (new x3943_reg).m.io.asInstanceOf[StandardInterface]
      val x3944_reg = (new x3944_reg).m.io.asInstanceOf[StandardInterface]
      val x3945_reg = (new x3945_reg).m.io.asInstanceOf[StandardInterface]
      val x3946_reg = (new x3946_reg).m.io.asInstanceOf[StandardInterface]
      val x3947_reg = (new x3947_reg).m.io.asInstanceOf[StandardInterface]
      val x3991_inr_UnitPipe = new x3991_inr_UnitPipe_kernel(List(b3916), List(x3944_reg,x3905_bias_start_idx_args_0,x3912_nr_args_0,x3910_nc_args_0,x3942_reg,x3947_reg,x3938_reg,x3902_in2D_args_0,x3934_reg,x3906_load_idx_0_args_0,x3909_out2D_args_0,x3941_reg,x3935_reg,x3937_reg,x3903_in_channels_args_0,x3945_reg,x3908_or_args_0,x3936_reg,x3913_out_channels_args_0,x3904_weights_start_idx_args_0,x3940_reg,x3943_reg,x3946_reg,x3911_oc_args_0,x3907_store_idx_args_0,x3939_reg,x3918_reg,x3901_stride_args_0) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x3991_inr_UnitPipe.sm.io.ctrDone := risingEdge(x3991_inr_UnitPipe.sm.io.ctrInc)
      x3991_inr_UnitPipe.backpressure := true.B | x3991_inr_UnitPipe.sm.io.doneLatch
      x3991_inr_UnitPipe.forwardpressure := true.B | x3991_inr_UnitPipe.sm.io.doneLatch
      x3991_inr_UnitPipe.sm.io.enableOut.zip(x3991_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3991_inr_UnitPipe.sm.io.break := false.B
      x3991_inr_UnitPipe.mask := true.B & true.B
      x3991_inr_UnitPipe.configure("x3991_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3991_inr_UnitPipe.kernel()
      val x3992_bias_SRAM_0 = (new x3992_bias_SRAM_0).m.io.asInstanceOf[StandardInterface]
      val x4054_outr_UnitPipe = new x4054_outr_UnitPipe_kernel(List(x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM), List(x3993), List(x3995), List(x3944_reg,x3934_reg,x3992_bias_SRAM_0) , Some(me), List(), 1, 2, 2, List(1), List(32), breakpoints, rr)
      x4054_outr_UnitPipe.backpressure := true.B | x4054_outr_UnitPipe.sm.io.doneLatch
      x4054_outr_UnitPipe.forwardpressure := true.B | x4054_outr_UnitPipe.sm.io.doneLatch
      x4054_outr_UnitPipe.sm.io.enableOut.zip(x4054_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4054_outr_UnitPipe.sm.io.break := false.B
      x4054_outr_UnitPipe.mask := true.B & true.B
      x4054_outr_UnitPipe.configure("x4054_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4054_outr_UnitPipe.kernel()
      val x18769_rd_x3944 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18769_rd_x3944""")
      val x18769_rd_x3944_banks = List[UInt]()
      val x18769_rd_x3944_ofs = List[UInt]()
      val x18769_rd_x3944_en = List[Bool](true.B)
      x18769_rd_x3944.toSeq.zip(x3944_reg.connectRPort(18769, x18769_rd_x3944_banks, x18769_rd_x3944_ofs, io.sigsIn.backpressure, x18769_rd_x3944_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4056_ctr = new CtrObject(Left(Some(0)), Right(x18769_rd_x3944), Left(Some(32)), 1, 32, false)
      val x4057_ctrchain = (new CChainObject(List[CtrObject](x4056_ctr), "x4057_ctrchain")).cchain.io 
      x4057_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x4057_ctrchain_p", (x4057_ctrchain.par, x4057_ctrchain.widths))
      val x18770_rd_x3918 = Wire(Bool()).suggestName("""x18770_rd_x3918""")
      val x18770_rd_x3918_banks = List[UInt]()
      val x18770_rd_x3918_ofs = List[UInt]()
      val x18770_rd_x3918_en = List[Bool](true.B)
      x18770_rd_x3918.toSeq.zip(x3918_reg.connectRPort(18770, x18770_rd_x3918_banks, x18770_rd_x3918_ofs, io.sigsIn.backpressure, x18770_rd_x3918_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9462_outr_Foreach = new x9462_outr_Foreach_kernel(List(x18770_rd_x3918), List(x9401), List(x4085,x4338), List(x9400), List(x3942_reg,x3947_reg,x3938_reg,x3919_reg,x3941_reg,x3935_reg,x3937_reg,x3945_reg,x3936_reg,x3940_reg,x3943_reg,x3946_reg,x3992_bias_SRAM_0,x3939_reg,x3918_reg), List(x2682_tmp_DRAM,x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM), List(x4336,x4083,x9399) , Some(me), List(x4057_ctrchain), 2, 2, 1, List(1), List(32), breakpoints, rr)
      x9462_outr_Foreach.sm.io.ctrDone := (x9462_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x9462_outr_Foreach.backpressure := true.B | x9462_outr_Foreach.sm.io.doneLatch
      x9462_outr_Foreach.forwardpressure := true.B | x9462_outr_Foreach.sm.io.doneLatch
      x9462_outr_Foreach.sm.io.enableOut.zip(x9462_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x9462_outr_Foreach.sm.io.break := false.B
      x9462_outr_Foreach.mask := ~x9462_outr_Foreach.cchain.head.output.noop & x18770_rd_x3918
      x9462_outr_Foreach.configure("x9462_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9462_outr_Foreach.kernel()
    }
    val module = Module(new x9464_outr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END SwitchCase x9464_outr_SwitchCase **/
