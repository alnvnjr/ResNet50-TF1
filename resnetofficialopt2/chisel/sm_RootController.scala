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

/** Hierarchy: x1256 **/
/** BEGIN None RootController **/
class RootController_kernel(
  list_x9561: List[DecoupledIO[AppLoadData]],
  list_x9400: List[DecoupledIO[AppStoreData]],
  list_x9401: List[DecoupledIO[Bool]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x18504: List[DecoupledIO[AppCommandDense]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 7, isFSM = false   , latency = 0.0.toInt, myName = "RootController_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "RootController_iiCtr"))
  
  abstract class RootController_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18504 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18504_p").asInstanceOf[(Int,Int)] ))
      val in_x18388 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18388_p").asInstanceOf[(Int,Int)] ))
      val in_x3230 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3230_p").asInstanceOf[(Int,Int)] ))
      val in_x9400 = Decoupled(new AppStoreData(ModuleParams.getParams("x9400_p").asInstanceOf[(Int,Int)] ))
      val in_x3140 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3140_p").asInstanceOf[(Int,Int)] ))
      val in_x9561 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9561_p").asInstanceOf[(Int, Int)] )))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3099 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3099_p").asInstanceOf[(Int,Int)] ))
      val in_x18215 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18215_p").asInstanceOf[(Int,Int)] ))
      val in_x18479 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18479_p").asInstanceOf[(Int,Int)] ))
      val in_x9401 = Flipped(Decoupled(Bool()))
      val in_x9593 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9593_p").asInstanceOf[(Int,Int)] ))
      val in_x3870 = Decoupled(new AppStoreData(ModuleParams.getParams("x3870_p").asInstanceOf[(Int,Int)] ))
      val in_x3995 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3995_p").asInstanceOf[(Int, Int)] )))
      val in_x9868 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9868_p").asInstanceOf[(Int, Int)] )))
      val in_x18480 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18480_p").asInstanceOf[(Int, Int)] )))
      val in_x17550 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17550_p").asInstanceOf[(Int,Int)] ))
      val in_x17883 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17883_p").asInstanceOf[(Int, Int)] )))
      val in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3083_c90_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x18216 = Decoupled(new AppStoreData(ModuleParams.getParams("x18216_p").asInstanceOf[(Int,Int)] ))
      val in_x3871 = Flipped(Decoupled(Bool()))
      val in_x18621 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18621_p").asInstanceOf[(Int,Int)] ))
      val in_x3081_c27_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x17882 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17882_p").asInstanceOf[(Int,Int)] ))
      val in_x17749 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17749_p").asInstanceOf[(Int,Int)] ))
      val in_x9560 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9560_p").asInstanceOf[(Int,Int)] ))
      val in_x2679_i0_pad_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9867 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9867_p").asInstanceOf[(Int,Int)] ))
      val in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3066_c101_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x4085 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4085_p").asInstanceOf[(Int, Int)] )))
      val in_x3142 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3142_p").asInstanceOf[(Int, Int)] )))
      val in_x18505 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18505_p").asInstanceOf[(Int, Int)] )))
      val in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9595 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9595_p").asInstanceOf[(Int, Int)] )))
      val in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x4336 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4336_p").asInstanceOf[(Int,Int)] ))
      val in_x17551 = Decoupled(new AppStoreData(ModuleParams.getParams("x17551_p").asInstanceOf[(Int,Int)] ))
      val in_x18622 = Decoupled(new AppStoreData(ModuleParams.getParams("x18622_p").asInstanceOf[(Int,Int)] ))
      val in_x18390 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18390_p").asInstanceOf[(Int, Int)] )))
      val in_x17552 = Flipped(Decoupled(Bool()))
      val in_x17750 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17750_p").asInstanceOf[(Int, Int)] )))
      val in_x4338 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4338_p").asInstanceOf[(Int, Int)] )))
      val in_x18217 = Flipped(Decoupled(Bool()))
      val in_x2680_tmp76_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3993 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3993_p").asInstanceOf[(Int,Int)] ))
      val in_x3232 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3232_p").asInstanceOf[(Int, Int)] )))
      val in_x3100 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3100_p").asInstanceOf[(Int, Int)] )))
      val in_x18623 = Flipped(Decoupled(Bool()))
      val in_x4083 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4083_p").asInstanceOf[(Int,Int)] ))
      val in_x3869 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3869_p").asInstanceOf[(Int,Int)] ))
      val in_x9399 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9399_p").asInstanceOf[(Int,Int)] ))
      val in_x3096_c87_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(7, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(7, 1))
      val rr = Input(Bool())
    })
    def x18504 = {io.in_x18504} 
    def x18388 = {io.in_x18388} 
    def x3230 = {io.in_x3230} 
    def x9400 = {io.in_x9400} 
    def x3140 = {io.in_x3140} 
    def x9561 = {io.in_x9561} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3099 = {io.in_x3099} 
    def x18215 = {io.in_x18215} 
    def x18479 = {io.in_x18479} 
    def x9401 = {io.in_x9401} 
    def x9593 = {io.in_x9593} 
    def x3870 = {io.in_x3870} 
    def x3995 = {io.in_x3995} 
    def x9868 = {io.in_x9868} 
    def x18480 = {io.in_x18480} 
    def x17550 = {io.in_x17550} 
    def x17883 = {io.in_x17883} 
    def x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = {io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM} 
    def x3083_c90_DRAM = {io.in_x3083_c90_DRAM} 
    def x18216 = {io.in_x18216} 
    def x3871 = {io.in_x3871} 
    def x18621 = {io.in_x18621} 
    def x3081_c27_DRAM = {io.in_x3081_c27_DRAM} 
    def x17882 = {io.in_x17882} 
    def x17749 = {io.in_x17749} 
    def x9560 = {io.in_x9560} 
    def x2679_i0_pad_DRAM = {io.in_x2679_i0_pad_DRAM} 
    def x9867 = {io.in_x9867} 
    def x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = {io.in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM} 
    def x3066_c101_DRAM = {io.in_x3066_c101_DRAM} 
    def x4085 = {io.in_x4085} 
    def x3142 = {io.in_x3142} 
    def x18505 = {io.in_x18505} 
    def x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = {io.in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM} 
    def x9595 = {io.in_x9595} 
    def x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = {io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM} 
    def x4336 = {io.in_x4336} 
    def x17551 = {io.in_x17551} 
    def x18622 = {io.in_x18622} 
    def x18390 = {io.in_x18390} 
    def x17552 = {io.in_x17552} 
    def x17750 = {io.in_x17750} 
    def x4338 = {io.in_x4338} 
    def x18217 = {io.in_x18217} 
    def x2680_tmp76_DRAM = {io.in_x2680_tmp76_DRAM} 
    def x3993 = {io.in_x3993} 
    def x3232 = {io.in_x3232} 
    def x3100 = {io.in_x3100} 
    def x18623 = {io.in_x18623} 
    def x4083 = {io.in_x4083} 
    def x3869 = {io.in_x3869} 
    def x9399 = {io.in_x9399} 
    def x3096_c87_DRAM = {io.in_x3096_c87_DRAM} 
  }
  def connectWires0(module: RootController_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18504 <> x18504
    module.io.in_x18388 <> x18388
    module.io.in_x3230 <> x3230
    module.io.in_x9400 <> x9400
    module.io.in_x3140 <> x3140
    module.io.in_x9561 <> x9561
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x3099 <> x3099
    module.io.in_x18215 <> x18215
    module.io.in_x18479 <> x18479
    module.io.in_x9401 <> x9401
    module.io.in_x9593 <> x9593
    module.io.in_x3870 <> x3870
    module.io.in_x3995 <> x3995
    module.io.in_x9868 <> x9868
    module.io.in_x18480 <> x18480
    module.io.in_x17550 <> x17550
    module.io.in_x17883 <> x17883
    module.io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM <> x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM
    module.io.in_x3083_c90_DRAM <> x3083_c90_DRAM
    module.io.in_x18216 <> x18216
    module.io.in_x3871 <> x3871
    module.io.in_x18621 <> x18621
    module.io.in_x3081_c27_DRAM <> x3081_c27_DRAM
    module.io.in_x17882 <> x17882
    module.io.in_x17749 <> x17749
    module.io.in_x9560 <> x9560
    module.io.in_x2679_i0_pad_DRAM <> x2679_i0_pad_DRAM
    module.io.in_x9867 <> x9867
    module.io.in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM <> x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM
    module.io.in_x3066_c101_DRAM <> x3066_c101_DRAM
    module.io.in_x4085 <> x4085
    module.io.in_x3142 <> x3142
    module.io.in_x18505 <> x18505
    module.io.in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM <> x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM
    module.io.in_x9595 <> x9595
    module.io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM <> x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM
    module.io.in_x4336 <> x4336
    module.io.in_x17551 <> x17551
    module.io.in_x18622 <> x18622
    module.io.in_x18390 <> x18390
    module.io.in_x17552 <> x17552
    module.io.in_x17750 <> x17750
    module.io.in_x4338 <> x4338
    module.io.in_x18217 <> x18217
    module.io.in_x2680_tmp76_DRAM <> x2680_tmp76_DRAM
    module.io.in_x3993 <> x3993
    module.io.in_x3232 <> x3232
    module.io.in_x3100 <> x3100
    module.io.in_x18623 <> x18623
    module.io.in_x4083 <> x4083
    module.io.in_x3869 <> x3869
    module.io.in_x9399 <> x9399
    module.io.in_x3096_c87_DRAM <> x3096_c87_DRAM
  }
  val x9561 = list_x9561(0)
  val x3995 = list_x9561(1)
  val x9868 = list_x9561(2)
  val x18480 = list_x9561(3)
  val x17883 = list_x9561(4)
  val x4085 = list_x9561(5)
  val x3142 = list_x9561(6)
  val x18505 = list_x9561(7)
  val x9595 = list_x9561(8)
  val x18390 = list_x9561(9)
  val x17750 = list_x9561(10)
  val x4338 = list_x9561(11)
  val x3232 = list_x9561(12)
  val x3100 = list_x9561(13)
  val x9400 = list_x9400(0)
  val x3870 = list_x9400(1)
  val x18216 = list_x9400(2)
  val x17551 = list_x9400(3)
  val x18622 = list_x9400(4)
  val x9401 = list_x9401(0)
  val x3871 = list_x9401(1)
  val x17552 = list_x9401(2)
  val x18217 = list_x9401(3)
  val x18623 = list_x9401(4)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = list_x2682_tmp_DRAM(1)
  val x3083_c90_DRAM = list_x2682_tmp_DRAM(2)
  val x3081_c27_DRAM = list_x2682_tmp_DRAM(3)
  val x2679_i0_pad_DRAM = list_x2682_tmp_DRAM(4)
  val x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = list_x2682_tmp_DRAM(5)
  val x3066_c101_DRAM = list_x2682_tmp_DRAM(6)
  val x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = list_x2682_tmp_DRAM(7)
  val x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = list_x2682_tmp_DRAM(8)
  val x2680_tmp76_DRAM = list_x2682_tmp_DRAM(9)
  val x3096_c87_DRAM = list_x2682_tmp_DRAM(10)
  val x18504 = list_x18504(0)
  val x18388 = list_x18504(1)
  val x3230 = list_x18504(2)
  val x3140 = list_x18504(3)
  val x3099 = list_x18504(4)
  val x18215 = list_x18504(5)
  val x18479 = list_x18504(6)
  val x9593 = list_x18504(7)
  val x17550 = list_x18504(8)
  val x18621 = list_x18504(9)
  val x17882 = list_x18504(10)
  val x17749 = list_x18504(11)
  val x9560 = list_x18504(12)
  val x9867 = list_x18504(13)
  val x4336 = list_x18504(14)
  val x3993 = list_x18504(15)
  val x4083 = list_x18504(16)
  val x3869 = list_x18504(17)
  val x9399 = list_x18504(18)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "RootController")
    implicit val stack = ControllerStack.stack.toList
    class RootController_concrete(depth: Int)(implicit stack: List[KernelHash]) extends RootController_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3098_c27_SRAM_0 = (new x3098_c27_SRAM_0).m.io.asInstanceOf[StandardInterface]
      val x3117_outr_UnitPipe = new x3117_outr_UnitPipe_kernel(List(x3081_c27_DRAM), List(x3099), List(x3100), List(x3098_c27_SRAM_0) , Some(me), List(), 0, 2, 2, List(1), List(32), breakpoints, rr)
      x3117_outr_UnitPipe.backpressure := true.B | x3117_outr_UnitPipe.sm.io.doneLatch
      x3117_outr_UnitPipe.forwardpressure := true.B | x3117_outr_UnitPipe.sm.io.doneLatch
      x3117_outr_UnitPipe.sm.io.enableOut.zip(x3117_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3117_outr_UnitPipe.sm.io.break := false.B
      x3117_outr_UnitPipe.mask := true.B & true.B
      x3117_outr_UnitPipe.configure("x3117_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3117_outr_UnitPipe.kernel()
      val x3118_ctr = new CtrObject(Left(Some(0)), Left(Some(64)), Left(Some(2)), 1, 32, false)
      val x3119_ctrchain = (new CChainObject(List[CtrObject](x3118_ctr), "x3119_ctrchain")).cchain.io 
      x3119_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x3119_ctrchain_p", (x3119_ctrchain.par, x3119_ctrchain.widths))
      val x3898_outr_Foreach = new x3898_outr_Foreach_kernel(List(x3098_c27_SRAM_0), List(x3871), List(x2682_tmp_DRAM,x2679_i0_pad_DRAM,x3066_c101_DRAM), List(x3230,x3140,x3869), List(x3142,x3232), List(x3870) , Some(me), List(x3119_ctrchain), 1, 3, 1, List(1), List(32), breakpoints, rr)
      x3898_outr_Foreach.sm.io.ctrDone := (x3898_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x3898_outr_Foreach.backpressure := true.B | x3898_outr_Foreach.sm.io.doneLatch
      x3898_outr_Foreach.forwardpressure := true.B | x3898_outr_Foreach.sm.io.doneLatch
      x3898_outr_Foreach.sm.io.enableOut.zip(x3898_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x3898_outr_Foreach.sm.io.break := false.B
      x3898_outr_Foreach.mask := ~x3898_outr_Foreach.cchain.head.output.noop & true.B
      x3898_outr_Foreach.configure("x3898_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3898_outr_Foreach.kernel()
      val x3899_check_Fused_Conv2D_BiasAdd_k3_0 = (new x3899_check_Fused_Conv2D_BiasAdd_k3_0).m.io.asInstanceOf[StandardInterface]
      val x3900_check_Fused_Conv2D_BiasAdd_k1_0 = (new x3900_check_Fused_Conv2D_BiasAdd_k1_0).m.io.asInstanceOf[StandardInterface]
      val x3901_stride_args_0 = (new x3901_stride_args_0).m.io.asInstanceOf[StandardInterface]
      val x3902_in2D_args_0 = (new x3902_in2D_args_0).m.io.asInstanceOf[StandardInterface]
      val x3903_in_channels_args_0 = (new x3903_in_channels_args_0).m.io.asInstanceOf[StandardInterface]
      val x3904_weights_start_idx_args_0 = (new x3904_weights_start_idx_args_0).m.io.asInstanceOf[StandardInterface]
      val x3905_bias_start_idx_args_0 = (new x3905_bias_start_idx_args_0).m.io.asInstanceOf[StandardInterface]
      val x3906_load_idx_0_args_0 = (new x3906_load_idx_0_args_0).m.io.asInstanceOf[StandardInterface]
      val x3907_store_idx_args_0 = (new x3907_store_idx_args_0).m.io.asInstanceOf[StandardInterface]
      val x3908_or_args_0 = (new x3908_or_args_0).m.io.asInstanceOf[StandardInterface]
      val x3909_out2D_args_0 = (new x3909_out2D_args_0).m.io.asInstanceOf[StandardInterface]
      val x3910_nc_args_0 = (new x3910_nc_args_0).m.io.asInstanceOf[StandardInterface]
      val x3911_oc_args_0 = (new x3911_oc_args_0).m.io.asInstanceOf[StandardInterface]
      val x3912_nr_args_0 = (new x3912_nr_args_0).m.io.asInstanceOf[StandardInterface]
      val x3913_out_channels_args_0 = (new x3913_out_channels_args_0).m.io.asInstanceOf[StandardInterface]
      val x3914_ctr = new CtrObject(Left(Some(0)), Left(Some(68)), Left(Some(1)), 1, 32, false)
      val x3915_ctrchain = (new CChainObject(List[CtrObject](x3914_ctr), "x3915_ctrchain")).cchain.io 
      x3915_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x3915_ctrchain_p", (x3915_ctrchain.par, x3915_ctrchain.widths))
      val x18374_outr_Foreach = new x18374_outr_Foreach_kernel(List(x2682_tmp_DRAM,x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM,x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM,x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM,x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM), List(x9561,x3995,x9868,x17883,x4085,x9595,x17750,x4338), List(x9400,x18216,x17551), List(x3905_bias_start_idx_args_0,x3912_nr_args_0,x3910_nc_args_0,x3902_in2D_args_0,x3906_load_idx_0_args_0,x3899_check_Fused_Conv2D_BiasAdd_k3_0,x3909_out2D_args_0,x3903_in_channels_args_0,x3900_check_Fused_Conv2D_BiasAdd_k1_0,x3908_or_args_0,x3913_out_channels_args_0,x3904_weights_start_idx_args_0,x3911_oc_args_0,x3907_store_idx_args_0,x3901_stride_args_0), List(x18215,x9593,x17550,x17882,x17749,x9560,x9867,x4336,x3993,x4083,x9399), List(x9401,x17552,x18217) , Some(me), List(x3915_ctrchain), 2, 2, 1, List(1), List(32), breakpoints, rr)
      x18374_outr_Foreach.sm.io.ctrDone := (x18374_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x18374_outr_Foreach.backpressure := true.B | x18374_outr_Foreach.sm.io.doneLatch
      x18374_outr_Foreach.forwardpressure := true.B | x18374_outr_Foreach.sm.io.doneLatch
      x18374_outr_Foreach.sm.io.enableOut.zip(x18374_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x18374_outr_Foreach.sm.io.break := false.B
      x18374_outr_Foreach.mask := ~x18374_outr_Foreach.cchain.head.output.noop & true.B
      x18374_outr_Foreach.configure("x18374_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18374_outr_Foreach.kernel()
      val x18375_tmp75_SRAM_0 = (new x18375_tmp75_SRAM_0).m.io.asInstanceOf[StandardInterface]
      val x18376_ctr = new CtrObject(Left(Some(0)), Left(Some(2048)), Left(Some(1)), 1, 32, false)
      val x18377_ctrchain = (new CChainObject(List[CtrObject](x18376_ctr), "x18377_ctrchain")).cchain.io 
      x18377_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x18377_ctrchain_p", (x18377_ctrchain.par, x18377_ctrchain.widths))
      val x18477_outr_Foreach = new x18477_outr_Foreach_kernel(List(x2682_tmp_DRAM), List(x18388), List(x18390), List(x18375_tmp75_SRAM_0) , Some(me), List(x18377_ctrchain), 3, 4, 1, List(1), List(32), breakpoints, rr)
      x18477_outr_Foreach.sm.io.ctrDone := (x18477_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x18477_outr_Foreach.backpressure := true.B | x18477_outr_Foreach.sm.io.doneLatch
      x18477_outr_Foreach.forwardpressure := true.B | x18477_outr_Foreach.sm.io.doneLatch
      x18477_outr_Foreach.sm.io.enableOut.zip(x18477_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x18477_outr_Foreach.sm.io.break := false.B
      x18477_outr_Foreach.mask := ~x18477_outr_Foreach.cchain.head.output.noop & true.B
      x18477_outr_Foreach.configure("x18477_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18477_outr_Foreach.kernel()
      val x18478_c87_SRAM_0 = (new x18478_c87_SRAM_0).m.io.asInstanceOf[StandardInterface]
      val x18497_outr_UnitPipe = new x18497_outr_UnitPipe_kernel(List(x3096_c87_DRAM), List(x18479), List(x18480), List(x18478_c87_SRAM_0) , Some(me), List(), 4, 2, 2, List(1), List(32), breakpoints, rr)
      x18497_outr_UnitPipe.backpressure := true.B | x18497_outr_UnitPipe.sm.io.doneLatch
      x18497_outr_UnitPipe.forwardpressure := true.B | x18497_outr_UnitPipe.sm.io.doneLatch
      x18497_outr_UnitPipe.sm.io.enableOut.zip(x18497_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18497_outr_UnitPipe.sm.io.break := false.B
      x18497_outr_UnitPipe.mask := true.B & true.B
      x18497_outr_UnitPipe.configure("x18497_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18497_outr_UnitPipe.kernel()
      val x18498_tmp76_SRAM_0 = (new x18498_tmp76_SRAM_0).m.io.asInstanceOf[StandardInterface]
      val x18499_ctr = new CtrObject(Left(Some(0)), Left(Some(1001)), Left(Some(1)), 1, 32, false)
      val x18500_ctrchain = (new CChainObject(List[CtrObject](x18499_ctr), "x18500_ctrchain")).cchain.io 
      x18500_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x18500_ctrchain_p", (x18500_ctrchain.par, x18500_ctrchain.widths))
      val x18620_outr_Foreach = new x18620_outr_Foreach_kernel(List(x3083_c90_DRAM), List(x18504), List(x18505), List(x18375_tmp75_SRAM_0,x18498_tmp76_SRAM_0,x18478_c87_SRAM_0) , Some(me), List(x18500_ctrchain), 5, 3, 1, List(1), List(32), breakpoints, rr)
      x18620_outr_Foreach.sm.io.ctrDone := (x18620_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x18620_outr_Foreach.backpressure := true.B | x18620_outr_Foreach.sm.io.doneLatch
      x18620_outr_Foreach.forwardpressure := true.B | x18620_outr_Foreach.sm.io.doneLatch
      x18620_outr_Foreach.sm.io.enableOut.zip(x18620_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x18620_outr_Foreach.sm.io.break := false.B
      x18620_outr_Foreach.mask := ~x18620_outr_Foreach.cchain.head.output.noop & true.B
      x18620_outr_Foreach.configure("x18620_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18620_outr_Foreach.kernel()
      val x18644_outr_UnitPipe = new x18644_outr_UnitPipe_kernel(List(x18622), List(x18623), List(x2680_tmp76_DRAM), List(x18621), List(x18498_tmp76_SRAM_0) , Some(me), List(), 6, 3, 3, List(1), List(32), breakpoints, rr)
      x18644_outr_UnitPipe.backpressure := true.B | x18644_outr_UnitPipe.sm.io.doneLatch
      x18644_outr_UnitPipe.forwardpressure := true.B | x18644_outr_UnitPipe.sm.io.doneLatch
      x18644_outr_UnitPipe.sm.io.enableOut.zip(x18644_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18644_outr_UnitPipe.sm.io.break := false.B
      x18644_outr_UnitPipe.mask := true.B & true.B
      x18644_outr_UnitPipe.configure("x18644_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18644_outr_UnitPipe.kernel()
    }
    val module = Module(new RootController_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END AccelScope RootController **/
