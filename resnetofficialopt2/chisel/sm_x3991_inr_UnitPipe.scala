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

/** Hierarchy: x3991 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x3991_inr_UnitPipe **/
class x3991_inr_UnitPipe_kernel(
  list_b3916: List[FixedPoint],
  list_x3944_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 2.0.toInt, myName = "x3991_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3991_inr_UnitPipe_iiCtr"))
  
  abstract class x3991_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3944_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3944_reg_p").asInstanceOf[MemParams] ))
      val in_x3905_bias_start_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3905_bias_start_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x3912_nr_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3912_nr_args_0_p").asInstanceOf[MemParams] ))
      val in_x3910_nc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3910_nc_args_0_p").asInstanceOf[MemParams] ))
      val in_x3942_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3942_reg_p").asInstanceOf[MemParams] ))
      val in_x3947_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3947_reg_p").asInstanceOf[MemParams] ))
      val in_x3938_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3938_reg_p").asInstanceOf[MemParams] ))
      val in_x3902_in2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3902_in2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x3934_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3934_reg_p").asInstanceOf[MemParams] ))
      val in_x3906_load_idx_0_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3906_load_idx_0_args_0_p").asInstanceOf[MemParams] ))
      val in_x3909_out2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3909_out2D_args_0_p").asInstanceOf[MemParams] ))
      val in_b3916 = Input(new FixedPoint(true, 32, 0))
      val in_x3941_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3941_reg_p").asInstanceOf[MemParams] ))
      val in_x3935_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3935_reg_p").asInstanceOf[MemParams] ))
      val in_x3937_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3937_reg_p").asInstanceOf[MemParams] ))
      val in_x3903_in_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3903_in_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x3945_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3945_reg_p").asInstanceOf[MemParams] ))
      val in_x3908_or_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3908_or_args_0_p").asInstanceOf[MemParams] ))
      val in_x3936_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3936_reg_p").asInstanceOf[MemParams] ))
      val in_x3913_out_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3913_out_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x3904_weights_start_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3904_weights_start_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x3940_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3940_reg_p").asInstanceOf[MemParams] ))
      val in_x3943_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3943_reg_p").asInstanceOf[MemParams] ))
      val in_x3946_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3946_reg_p").asInstanceOf[MemParams] ))
      val in_x3911_oc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3911_oc_args_0_p").asInstanceOf[MemParams] ))
      val in_x3907_store_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3907_store_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x3939_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3939_reg_p").asInstanceOf[MemParams] ))
      val in_x3918_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3918_reg_p").asInstanceOf[MemParams] ))
      val in_x3901_stride_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3901_stride_args_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3944_reg = {io.in_x3944_reg} ; io.in_x3944_reg := DontCare
    def x3905_bias_start_idx_args_0 = {io.in_x3905_bias_start_idx_args_0} ; io.in_x3905_bias_start_idx_args_0 := DontCare
    def x3912_nr_args_0 = {io.in_x3912_nr_args_0} ; io.in_x3912_nr_args_0 := DontCare
    def x3910_nc_args_0 = {io.in_x3910_nc_args_0} ; io.in_x3910_nc_args_0 := DontCare
    def x3942_reg = {io.in_x3942_reg} ; io.in_x3942_reg := DontCare
    def x3947_reg = {io.in_x3947_reg} ; io.in_x3947_reg := DontCare
    def x3938_reg = {io.in_x3938_reg} ; io.in_x3938_reg := DontCare
    def x3902_in2D_args_0 = {io.in_x3902_in2D_args_0} ; io.in_x3902_in2D_args_0 := DontCare
    def x3934_reg = {io.in_x3934_reg} ; io.in_x3934_reg := DontCare
    def x3906_load_idx_0_args_0 = {io.in_x3906_load_idx_0_args_0} ; io.in_x3906_load_idx_0_args_0 := DontCare
    def x3909_out2D_args_0 = {io.in_x3909_out2D_args_0} ; io.in_x3909_out2D_args_0 := DontCare
    def b3916 = {io.in_b3916} 
    def x3941_reg = {io.in_x3941_reg} ; io.in_x3941_reg := DontCare
    def x3935_reg = {io.in_x3935_reg} ; io.in_x3935_reg := DontCare
    def x3937_reg = {io.in_x3937_reg} ; io.in_x3937_reg := DontCare
    def x3903_in_channels_args_0 = {io.in_x3903_in_channels_args_0} ; io.in_x3903_in_channels_args_0 := DontCare
    def x3945_reg = {io.in_x3945_reg} ; io.in_x3945_reg := DontCare
    def x3908_or_args_0 = {io.in_x3908_or_args_0} ; io.in_x3908_or_args_0 := DontCare
    def x3936_reg = {io.in_x3936_reg} ; io.in_x3936_reg := DontCare
    def x3913_out_channels_args_0 = {io.in_x3913_out_channels_args_0} ; io.in_x3913_out_channels_args_0 := DontCare
    def x3904_weights_start_idx_args_0 = {io.in_x3904_weights_start_idx_args_0} ; io.in_x3904_weights_start_idx_args_0 := DontCare
    def x3940_reg = {io.in_x3940_reg} ; io.in_x3940_reg := DontCare
    def x3943_reg = {io.in_x3943_reg} ; io.in_x3943_reg := DontCare
    def x3946_reg = {io.in_x3946_reg} ; io.in_x3946_reg := DontCare
    def x3911_oc_args_0 = {io.in_x3911_oc_args_0} ; io.in_x3911_oc_args_0 := DontCare
    def x3907_store_idx_args_0 = {io.in_x3907_store_idx_args_0} ; io.in_x3907_store_idx_args_0 := DontCare
    def x3939_reg = {io.in_x3939_reg} ; io.in_x3939_reg := DontCare
    def x3918_reg = {io.in_x3918_reg} ; io.in_x3918_reg := DontCare
    def x3901_stride_args_0 = {io.in_x3901_stride_args_0} ; io.in_x3901_stride_args_0 := DontCare
  }
  def connectWires0(module: x3991_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3944_reg.connectLedger(module.io.in_x3944_reg)
    x3905_bias_start_idx_args_0.connectLedger(module.io.in_x3905_bias_start_idx_args_0)
    x3912_nr_args_0.connectLedger(module.io.in_x3912_nr_args_0)
    x3910_nc_args_0.connectLedger(module.io.in_x3910_nc_args_0)
    x3942_reg.connectLedger(module.io.in_x3942_reg)
    x3947_reg.connectLedger(module.io.in_x3947_reg)
    x3938_reg.connectLedger(module.io.in_x3938_reg)
    x3902_in2D_args_0.connectLedger(module.io.in_x3902_in2D_args_0)
    x3934_reg.connectLedger(module.io.in_x3934_reg)
    x3906_load_idx_0_args_0.connectLedger(module.io.in_x3906_load_idx_0_args_0)
    x3909_out2D_args_0.connectLedger(module.io.in_x3909_out2D_args_0)
    module.io.in_b3916 <> b3916
    x3941_reg.connectLedger(module.io.in_x3941_reg)
    x3935_reg.connectLedger(module.io.in_x3935_reg)
    x3937_reg.connectLedger(module.io.in_x3937_reg)
    x3903_in_channels_args_0.connectLedger(module.io.in_x3903_in_channels_args_0)
    x3945_reg.connectLedger(module.io.in_x3945_reg)
    x3908_or_args_0.connectLedger(module.io.in_x3908_or_args_0)
    x3936_reg.connectLedger(module.io.in_x3936_reg)
    x3913_out_channels_args_0.connectLedger(module.io.in_x3913_out_channels_args_0)
    x3904_weights_start_idx_args_0.connectLedger(module.io.in_x3904_weights_start_idx_args_0)
    x3940_reg.connectLedger(module.io.in_x3940_reg)
    x3943_reg.connectLedger(module.io.in_x3943_reg)
    x3946_reg.connectLedger(module.io.in_x3946_reg)
    x3911_oc_args_0.connectLedger(module.io.in_x3911_oc_args_0)
    x3907_store_idx_args_0.connectLedger(module.io.in_x3907_store_idx_args_0)
    x3939_reg.connectLedger(module.io.in_x3939_reg)
    x3918_reg.connectLedger(module.io.in_x3918_reg)
    x3901_stride_args_0.connectLedger(module.io.in_x3901_stride_args_0)
  }
  val b3916 = list_b3916(0)
  val x3944_reg = list_x3944_reg(0)
  val x3905_bias_start_idx_args_0 = list_x3944_reg(1)
  val x3912_nr_args_0 = list_x3944_reg(2)
  val x3910_nc_args_0 = list_x3944_reg(3)
  val x3942_reg = list_x3944_reg(4)
  val x3947_reg = list_x3944_reg(5)
  val x3938_reg = list_x3944_reg(6)
  val x3902_in2D_args_0 = list_x3944_reg(7)
  val x3934_reg = list_x3944_reg(8)
  val x3906_load_idx_0_args_0 = list_x3944_reg(9)
  val x3909_out2D_args_0 = list_x3944_reg(10)
  val x3941_reg = list_x3944_reg(11)
  val x3935_reg = list_x3944_reg(12)
  val x3937_reg = list_x3944_reg(13)
  val x3903_in_channels_args_0 = list_x3944_reg(14)
  val x3945_reg = list_x3944_reg(15)
  val x3908_or_args_0 = list_x3944_reg(16)
  val x3936_reg = list_x3944_reg(17)
  val x3913_out_channels_args_0 = list_x3944_reg(18)
  val x3904_weights_start_idx_args_0 = list_x3944_reg(19)
  val x3940_reg = list_x3944_reg(20)
  val x3943_reg = list_x3944_reg(21)
  val x3946_reg = list_x3944_reg(22)
  val x3911_oc_args_0 = list_x3944_reg(23)
  val x3907_store_idx_args_0 = list_x3944_reg(24)
  val x3939_reg = list_x3944_reg(25)
  val x3918_reg = list_x3944_reg(26)
  val x3901_stride_args_0 = list_x3944_reg(27)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3991_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3991_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3991_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      object Block1Chunker0 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x3948_rd_x3918 = Wire(Bool()).suggestName("""x3948_rd_x3918""")
          val x3948_rd_x3918_banks = List[UInt]()
          val x3948_rd_x3918_ofs = List[UInt]()
          val x3948_rd_x3918_en = List[Bool](true.B)
          x3948_rd_x3918.toSeq.zip(x3918_reg.connectRPort(3948, x3948_rd_x3918_banks, x3948_rd_x3918_ofs, io.sigsIn.backpressure, x3948_rd_x3918_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x3951 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3951""")
          val x3951_banks = List[UInt](b3916.r)
          val x3951_ofs = List[UInt](b3916.r)
          val x3951_en = List[Bool](true.B)
          x3951.toSeq.zip(x3905_bias_start_idx_args_0.connectRPort(3951, x3951_banks, x3951_ofs, io.sigsIn.backpressure, x3951_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19588 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19588_x3951_D1") 
          (0 until 1).foreach{i => x19588(i).r := getRetimed(x3951(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3952_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3952_elem_0""")
          x3952_elem_0.r := x19588(0).r
          val x3953 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3953""")
          val x3953_banks = List[UInt](b3916.r)
          val x3953_ofs = List[UInt](b3916.r)
          val x3953_en = List[Bool](true.B)
          x3953.toSeq.zip(x3902_in2D_args_0.connectRPort(3953, x3953_banks, x3953_ofs, io.sigsIn.backpressure, x3953_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19589 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19589_x3953_D1") 
          (0 until 1).foreach{i => x19589(i).r := getRetimed(x3953(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3954_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3954_elem_0""")
          x3954_elem_0.r := x19589(0).r
          val x3955 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3955""")
          val x3955_banks = List[UInt](b3916.r)
          val x3955_ofs = List[UInt](b3916.r)
          val x3955_en = List[Bool](true.B)
          x3955.toSeq.zip(x3903_in_channels_args_0.connectRPort(3955, x3955_banks, x3955_ofs, io.sigsIn.backpressure, x3955_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19590 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19590_x3955_D1") 
          (0 until 1).foreach{i => x19590(i).r := getRetimed(x3955(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3956_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3956_elem_0""")
          x3956_elem_0.r := x19590(0).r
          val x3957 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3957""")
          val x3957_banks = List[UInt](b3916.r)
          val x3957_ofs = List[UInt](b3916.r)
          val x3957_en = List[Bool](true.B)
          x3957.toSeq.zip(x3906_load_idx_0_args_0.connectRPort(3957, x3957_banks, x3957_ofs, io.sigsIn.backpressure, x3957_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19591 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19591_x3957_D1") 
          (0 until 1).foreach{i => x19591(i).r := getRetimed(x3957(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3958_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3958_elem_0""")
          x3958_elem_0.r := x19591(0).r
          val x3959 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3959""")
          val x3959_banks = List[UInt](b3916.r)
          val x3959_ofs = List[UInt](b3916.r)
          val x3959_en = List[Bool](true.B)
          x3959.toSeq.zip(x3910_nc_args_0.connectRPort(3959, x3959_banks, x3959_ofs, io.sigsIn.backpressure, x3959_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19592 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19592_x3959_D1") 
          (0 until 1).foreach{i => x19592(i).r := getRetimed(x3959(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3960_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3960_elem_0""")
          x3960_elem_0.r := x19592(0).r
          val x3961 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3961""")
          val x3961_banks = List[UInt](b3916.r)
          val x3961_ofs = List[UInt](b3916.r)
          val x3961_en = List[Bool](true.B)
          x3961.toSeq.zip(x3912_nr_args_0.connectRPort(3961, x3961_banks, x3961_ofs, io.sigsIn.backpressure, x3961_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19593 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19593_x3961_D1") 
          (0 until 1).foreach{i => x19593(i).r := getRetimed(x3961(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3962_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3962_elem_0""")
          x3962_elem_0.r := x19593(0).r
          val x3963 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3963""")
          val x3963_banks = List[UInt](b3916.r)
          val x3963_ofs = List[UInt](b3916.r)
          val x3963_en = List[Bool](true.B)
          x3963.toSeq.zip(x3911_oc_args_0.connectRPort(3963, x3963_banks, x3963_ofs, io.sigsIn.backpressure, x3963_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19594 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19594_x3963_D1") 
          (0 until 1).foreach{i => x19594(i).r := getRetimed(x3963(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3964_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3964_elem_0""")
          x3964_elem_0.r := x19594(0).r
          val x3965 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3965""")
          val x3965_banks = List[UInt](b3916.r)
          val x3965_ofs = List[UInt](b3916.r)
          val x3965_en = List[Bool](true.B)
          x3965.toSeq.zip(x3908_or_args_0.connectRPort(3965, x3965_banks, x3965_ofs, io.sigsIn.backpressure, x3965_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19595 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19595_x3965_D1") 
          (0 until 1).foreach{i => x19595(i).r := getRetimed(x3965(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3966_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3966_elem_0""")
          x3966_elem_0.r := x19595(0).r
          val x3967 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3967""")
          val x3967_banks = List[UInt](b3916.r)
          val x3967_ofs = List[UInt](b3916.r)
          val x3967_en = List[Bool](true.B)
          x3967.toSeq.zip(x3909_out2D_args_0.connectRPort(3967, x3967_banks, x3967_ofs, io.sigsIn.backpressure, x3967_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19596 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19596_x3967_D1") 
          (0 until 1).foreach{i => x19596(i).r := getRetimed(x3967(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3968_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3968_elem_0""")
          x3968_elem_0.r := x19596(0).r
          val x3969 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3969""")
          val x3969_banks = List[UInt](b3916.r)
          val x3969_ofs = List[UInt](b3916.r)
          val x3969_en = List[Bool](true.B)
          x3969.toSeq.zip(x3913_out_channels_args_0.connectRPort(3969, x3969_banks, x3969_ofs, io.sigsIn.backpressure, x3969_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19597 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19597_x3969_D1") 
          (0 until 1).foreach{i => x19597(i).r := getRetimed(x3969(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3970_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3970_elem_0""")
          x3970_elem_0.r := x19597(0).r
          val x3971 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3971""")
          val x3971_banks = List[UInt](b3916.r)
          val x3971_ofs = List[UInt](b3916.r)
          val x3971_en = List[Bool](true.B)
          x3971.toSeq.zip(x3907_store_idx_args_0.connectRPort(3971, x3971_banks, x3971_ofs, io.sigsIn.backpressure, x3971_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19598 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19598_x3971_D1") 
          (0 until 1).foreach{i => x19598(i).r := getRetimed(x3971(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3972_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3972_elem_0""")
          x3972_elem_0.r := x19598(0).r
          val x3973 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3973""")
          val x3973_banks = List[UInt](b3916.r)
          val x3973_ofs = List[UInt](b3916.r)
          val x3973_en = List[Bool](true.B)
          x3973.toSeq.zip(x3901_stride_args_0.connectRPort(3973, x3973_banks, x3973_ofs, io.sigsIn.backpressure, x3973_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19599 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19599_x3973_D1") 
          (0 until 1).foreach{i => x19599(i).r := getRetimed(x3973(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3974_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3974_elem_0""")
          x3974_elem_0.r := x19599(0).r
          val x3975 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x3975""")
          val x3975_banks = List[UInt](b3916.r)
          val x3975_ofs = List[UInt](b3916.r)
          val x3975_en = List[Bool](true.B)
          x3975.toSeq.zip(x3904_weights_start_idx_args_0.connectRPort(3975, x3975_banks, x3975_ofs, io.sigsIn.backpressure, x3975_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x3948_rd_x3918), true)).foreach{case (a,b) => a := b}
          val x19600 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x19600_x3975_D1") 
          (0 until 1).foreach{i => x19600(i).r := getRetimed(x3975(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x3976_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3976_elem_0""")
          x3976_elem_0.r := x19600(0).r
          val x3977_wr_x3934_banks = List[UInt]()
          val x3977_wr_x3934_ofs = List[UInt]()
          val x3977_wr_x3934_en = List[Bool](true.B)
          val x3977_wr_x3934_data = List[UInt](x3952_elem_0.r)
          x3934_reg.connectWPort(3977, x3977_wr_x3934_banks, x3977_wr_x3934_ofs, x3977_wr_x3934_data, x3977_wr_x3934_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3978_wr_x3935_banks = List[UInt]()
          val x3978_wr_x3935_ofs = List[UInt]()
          val x3978_wr_x3935_en = List[Bool](true.B)
          val x3978_wr_x3935_data = List[UInt](x3954_elem_0.r)
          x3935_reg.connectWPort(3978, x3978_wr_x3935_banks, x3978_wr_x3935_ofs, x3978_wr_x3935_data, x3978_wr_x3935_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3979_wr_x3936_banks = List[UInt]()
          val x3979_wr_x3936_ofs = List[UInt]()
          val x3979_wr_x3936_en = List[Bool](true.B)
          val x3979_wr_x3936_data = List[UInt](x3956_elem_0.r)
          x3936_reg.connectWPort(3979, x3979_wr_x3936_banks, x3979_wr_x3936_ofs, x3979_wr_x3936_data, x3979_wr_x3936_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3980_wr_x3937_banks = List[UInt]()
          val x3980_wr_x3937_ofs = List[UInt]()
          val x3980_wr_x3937_en = List[Bool](true.B)
          val x3980_wr_x3937_data = List[UInt](x3958_elem_0.r)
          x3937_reg.connectWPort(3980, x3980_wr_x3937_banks, x3980_wr_x3937_ofs, x3980_wr_x3937_data, x3980_wr_x3937_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3981_wr_x3938_banks = List[UInt]()
          val x3981_wr_x3938_ofs = List[UInt]()
          val x3981_wr_x3938_en = List[Bool](true.B)
          val x3981_wr_x3938_data = List[UInt](x3960_elem_0.r)
          x3938_reg.connectWPort(3981, x3981_wr_x3938_banks, x3981_wr_x3938_ofs, x3981_wr_x3938_data, x3981_wr_x3938_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3982_wr_x3939_banks = List[UInt]()
          val x3982_wr_x3939_ofs = List[UInt]()
          val x3982_wr_x3939_en = List[Bool](true.B)
          val x3982_wr_x3939_data = List[UInt](x3962_elem_0.r)
          x3939_reg.connectWPort(3982, x3982_wr_x3939_banks, x3982_wr_x3939_ofs, x3982_wr_x3939_data, x3982_wr_x3939_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3983_wr_x3941_banks = List[UInt]()
          val x3983_wr_x3941_ofs = List[UInt]()
          val x3983_wr_x3941_en = List[Bool](true.B)
          val x3983_wr_x3941_data = List[UInt](x3964_elem_0.r)
          x3941_reg.connectWPort(3983, x3983_wr_x3941_banks, x3983_wr_x3941_ofs, x3983_wr_x3941_data, x3983_wr_x3941_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3984_wr_x3940_banks = List[UInt]()
          val x3984_wr_x3940_ofs = List[UInt]()
          val x3984_wr_x3940_en = List[Bool](true.B)
          val x3984_wr_x3940_data = List[UInt](x3964_elem_0.r)
          x3940_reg.connectWPort(3984, x3984_wr_x3940_banks, x3984_wr_x3940_ofs, x3984_wr_x3940_data, x3984_wr_x3940_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3985_wr_x3942_banks = List[UInt]()
          val x3985_wr_x3942_ofs = List[UInt]()
          val x3985_wr_x3942_en = List[Bool](true.B)
          val x3985_wr_x3942_data = List[UInt](x3966_elem_0.r)
          x3942_reg.connectWPort(3985, x3985_wr_x3942_banks, x3985_wr_x3942_ofs, x3985_wr_x3942_data, x3985_wr_x3942_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]("x3968_elem_0" -> x3968_elem_0, "x3970_elem_0" -> x3970_elem_0, "x3972_elem_0" -> x3972_elem_0, "x3974_elem_0" -> x3974_elem_0, "x3976_elem_0" -> x3976_elem_0)
        }
      }
      val block1chunk0: Map[String, Any] = Block1Chunker0.gen()
      object Block1Chunker1 { // 5 nodes, 5 weight
        def gen(): Map[String, Any] = {
          val x3986_wr_x3943_banks = List[UInt]()
          val x3986_wr_x3943_ofs = List[UInt]()
          val x3986_wr_x3943_en = List[Bool](true.B)
          val x3986_wr_x3943_data = List[UInt](block1chunk0("x3968_elem_0").asInstanceOf[FixedPoint].r)
          x3943_reg.connectWPort(3986, x3986_wr_x3943_banks, x3986_wr_x3943_ofs, x3986_wr_x3943_data, x3986_wr_x3943_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3987_wr_x3944_banks = List[UInt]()
          val x3987_wr_x3944_ofs = List[UInt]()
          val x3987_wr_x3944_en = List[Bool](true.B)
          val x3987_wr_x3944_data = List[UInt](block1chunk0("x3970_elem_0").asInstanceOf[FixedPoint].r)
          x3944_reg.connectWPort(3987, x3987_wr_x3944_banks, x3987_wr_x3944_ofs, x3987_wr_x3944_data, x3987_wr_x3944_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3988_wr_x3945_banks = List[UInt]()
          val x3988_wr_x3945_ofs = List[UInt]()
          val x3988_wr_x3945_en = List[Bool](true.B)
          val x3988_wr_x3945_data = List[UInt](block1chunk0("x3972_elem_0").asInstanceOf[FixedPoint].r)
          x3945_reg.connectWPort(3988, x3988_wr_x3945_banks, x3988_wr_x3945_ofs, x3988_wr_x3945_data, x3988_wr_x3945_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3989_wr_x3946_banks = List[UInt]()
          val x3989_wr_x3946_ofs = List[UInt]()
          val x3989_wr_x3946_en = List[Bool](true.B)
          val x3989_wr_x3946_data = List[UInt](block1chunk0("x3974_elem_0").asInstanceOf[FixedPoint].r)
          x3946_reg.connectWPort(3989, x3989_wr_x3946_banks, x3989_wr_x3946_ofs, x3989_wr_x3946_data, x3989_wr_x3946_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x3990_wr_x3947_banks = List[UInt]()
          val x3990_wr_x3947_ofs = List[UInt]()
          val x3990_wr_x3947_en = List[Bool](true.B)
          val x3990_wr_x3947_data = List[UInt](block1chunk0("x3976_elem_0").asInstanceOf[FixedPoint].r)
          x3947_reg.connectWPort(3990, x3990_wr_x3947_banks, x3990_wr_x3947_ofs, x3990_wr_x3947_data, x3990_wr_x3947_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]()
        }
      }
      val block1chunk1: Map[String, Any] = Block1Chunker1.gen()
    }
    val module = Module(new x3991_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3991_inr_UnitPipe **/
