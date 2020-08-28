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

/** Hierarchy: x9546 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9546_inr_UnitPipe **/
class x9546_inr_UnitPipe_kernel(
  list_b3916: List[FixedPoint],
  list_x9485_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 2.0.toInt, myName = "x9546_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9546_inr_UnitPipe_iiCtr"))
  
  abstract class x9546_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9485_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9485_reg_p").asInstanceOf[MemParams] ))
      val in_x3905_bias_start_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3905_bias_start_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x3910_nc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3910_nc_args_0_p").asInstanceOf[MemParams] ))
      val in_x9494_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9494_reg_p").asInstanceOf[MemParams] ))
      val in_x9465_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9465_reg_p").asInstanceOf[MemParams] ))
      val in_x3902_in2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3902_in2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x9497_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9497_reg_p").asInstanceOf[MemParams] ))
      val in_x9490_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9490_reg_p").asInstanceOf[MemParams] ))
      val in_x3906_load_idx_0_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3906_load_idx_0_args_0_p").asInstanceOf[MemParams] ))
      val in_x9488_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9488_reg_p").asInstanceOf[MemParams] ))
      val in_x3909_out2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3909_out2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x9493_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9493_reg_p").asInstanceOf[MemParams] ))
      val in_b3916 = Input(new FixedPoint(true, 32, 0))
      val in_x9498_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9498_reg_p").asInstanceOf[MemParams] ))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x3903_in_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3903_in_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x9484_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9484_reg_p").asInstanceOf[MemParams] ))
      val in_x9496_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9496_reg_p").asInstanceOf[MemParams] ))
      val in_x9483_use_relu_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x9483_use_relu_args_0_p").asInstanceOf[MemParams] ))
      val in_x9491_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9491_reg_p").asInstanceOf[MemParams] ))
      val in_x9487_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9487_reg_p").asInstanceOf[MemParams] ))
      val in_x9492_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9492_reg_p").asInstanceOf[MemParams] ))
      val in_x3908_or_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3908_or_args_0_p").asInstanceOf[MemParams] ))
      val in_x3913_out_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3913_out_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x3904_weights_start_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3904_weights_start_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x9486_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9486_reg_p").asInstanceOf[MemParams] ))
      val in_x9495_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9495_reg_p").asInstanceOf[MemParams] ))
      val in_x3911_oc_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3911_oc_args_0_p").asInstanceOf[MemParams] ))
      val in_x9482_inB_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x9482_inB_args_0_p").asInstanceOf[MemParams] ))
      val in_x3907_store_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3907_store_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x9489_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9489_reg_p").asInstanceOf[MemParams] ))
      val in_x3901_stride_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3901_stride_args_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9485_reg = {io.in_x9485_reg} ; io.in_x9485_reg := DontCare
    def x3905_bias_start_idx_args_0 = {io.in_x3905_bias_start_idx_args_0} ; io.in_x3905_bias_start_idx_args_0 := DontCare
    def x3910_nc_args_0 = {io.in_x3910_nc_args_0} ; io.in_x3910_nc_args_0 := DontCare
    def x9494_reg = {io.in_x9494_reg} ; io.in_x9494_reg := DontCare
    def x9465_reg = {io.in_x9465_reg} ; io.in_x9465_reg := DontCare
    def x3902_in2D_args_0 = {io.in_x3902_in2D_args_0} ; io.in_x3902_in2D_args_0 := DontCare
    def x9497_reg = {io.in_x9497_reg} ; io.in_x9497_reg := DontCare
    def x9490_reg = {io.in_x9490_reg} ; io.in_x9490_reg := DontCare
    def x3906_load_idx_0_args_0 = {io.in_x3906_load_idx_0_args_0} ; io.in_x3906_load_idx_0_args_0 := DontCare
    def x9488_reg = {io.in_x9488_reg} ; io.in_x9488_reg := DontCare
    def x3909_out2D_args_0 = {io.in_x3909_out2D_args_0} ; io.in_x3909_out2D_args_0 := DontCare
    def x9493_reg = {io.in_x9493_reg} ; io.in_x9493_reg := DontCare
    def b3916 = {io.in_b3916} 
    def x9498_reg = {io.in_x9498_reg} ; io.in_x9498_reg := DontCare
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x3903_in_channels_args_0 = {io.in_x3903_in_channels_args_0} ; io.in_x3903_in_channels_args_0 := DontCare
    def x9484_reg = {io.in_x9484_reg} ; io.in_x9484_reg := DontCare
    def x9496_reg = {io.in_x9496_reg} ; io.in_x9496_reg := DontCare
    def x9483_use_relu_args_0 = {io.in_x9483_use_relu_args_0} ; io.in_x9483_use_relu_args_0 := DontCare
    def x9491_reg = {io.in_x9491_reg} ; io.in_x9491_reg := DontCare
    def x9487_reg = {io.in_x9487_reg} ; io.in_x9487_reg := DontCare
    def x9492_reg = {io.in_x9492_reg} ; io.in_x9492_reg := DontCare
    def x3908_or_args_0 = {io.in_x3908_or_args_0} ; io.in_x3908_or_args_0 := DontCare
    def x3913_out_channels_args_0 = {io.in_x3913_out_channels_args_0} ; io.in_x3913_out_channels_args_0 := DontCare
    def x3904_weights_start_idx_args_0 = {io.in_x3904_weights_start_idx_args_0} ; io.in_x3904_weights_start_idx_args_0 := DontCare
    def x9486_reg = {io.in_x9486_reg} ; io.in_x9486_reg := DontCare
    def x9495_reg = {io.in_x9495_reg} ; io.in_x9495_reg := DontCare
    def x3911_oc_args_0 = {io.in_x3911_oc_args_0} ; io.in_x3911_oc_args_0 := DontCare
    def x9482_inB_args_0 = {io.in_x9482_inB_args_0} ; io.in_x9482_inB_args_0 := DontCare
    def x3907_store_idx_args_0 = {io.in_x3907_store_idx_args_0} ; io.in_x3907_store_idx_args_0 := DontCare
    def x9489_reg = {io.in_x9489_reg} ; io.in_x9489_reg := DontCare
    def x3901_stride_args_0 = {io.in_x3901_stride_args_0} ; io.in_x3901_stride_args_0 := DontCare
  }
  def connectWires0(module: x9546_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x9485_reg.connectLedger(module.io.in_x9485_reg)
    x3905_bias_start_idx_args_0.connectLedger(module.io.in_x3905_bias_start_idx_args_0)
    x3910_nc_args_0.connectLedger(module.io.in_x3910_nc_args_0)
    x9494_reg.connectLedger(module.io.in_x9494_reg)
    x9465_reg.connectLedger(module.io.in_x9465_reg)
    x3902_in2D_args_0.connectLedger(module.io.in_x3902_in2D_args_0)
    x9497_reg.connectLedger(module.io.in_x9497_reg)
    x9490_reg.connectLedger(module.io.in_x9490_reg)
    x3906_load_idx_0_args_0.connectLedger(module.io.in_x3906_load_idx_0_args_0)
    x9488_reg.connectLedger(module.io.in_x9488_reg)
    x3909_out2D_args_0.connectLedger(module.io.in_x3909_out2D_args_0)
    x9493_reg.connectLedger(module.io.in_x9493_reg)
    module.io.in_b3916 <> b3916
    x9498_reg.connectLedger(module.io.in_x9498_reg)
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    x3903_in_channels_args_0.connectLedger(module.io.in_x3903_in_channels_args_0)
    x9484_reg.connectLedger(module.io.in_x9484_reg)
    x9496_reg.connectLedger(module.io.in_x9496_reg)
    x9483_use_relu_args_0.connectLedger(module.io.in_x9483_use_relu_args_0)
    x9491_reg.connectLedger(module.io.in_x9491_reg)
    x9487_reg.connectLedger(module.io.in_x9487_reg)
    x9492_reg.connectLedger(module.io.in_x9492_reg)
    x3908_or_args_0.connectLedger(module.io.in_x3908_or_args_0)
    x3913_out_channels_args_0.connectLedger(module.io.in_x3913_out_channels_args_0)
    x3904_weights_start_idx_args_0.connectLedger(module.io.in_x3904_weights_start_idx_args_0)
    x9486_reg.connectLedger(module.io.in_x9486_reg)
    x9495_reg.connectLedger(module.io.in_x9495_reg)
    x3911_oc_args_0.connectLedger(module.io.in_x3911_oc_args_0)
    x9482_inB_args_0.connectLedger(module.io.in_x9482_inB_args_0)
    x3907_store_idx_args_0.connectLedger(module.io.in_x3907_store_idx_args_0)
    x9489_reg.connectLedger(module.io.in_x9489_reg)
    x3901_stride_args_0.connectLedger(module.io.in_x3901_stride_args_0)
  }
  val b3916 = list_b3916(0)
  val x9485_reg = list_x9485_reg(0)
  val x3905_bias_start_idx_args_0 = list_x9485_reg(1)
  val x3910_nc_args_0 = list_x9485_reg(2)
  val x9494_reg = list_x9485_reg(3)
  val x9465_reg = list_x9485_reg(4)
  val x3902_in2D_args_0 = list_x9485_reg(5)
  val x9497_reg = list_x9485_reg(6)
  val x9490_reg = list_x9485_reg(7)
  val x3906_load_idx_0_args_0 = list_x9485_reg(8)
  val x9488_reg = list_x9485_reg(9)
  val x3909_out2D_args_0 = list_x9485_reg(10)
  val x9493_reg = list_x9485_reg(11)
  val x9498_reg = list_x9485_reg(12)
  val x3920_reg = list_x9485_reg(13)
  val x3903_in_channels_args_0 = list_x9485_reg(14)
  val x9484_reg = list_x9485_reg(15)
  val x9496_reg = list_x9485_reg(16)
  val x9483_use_relu_args_0 = list_x9485_reg(17)
  val x9491_reg = list_x9485_reg(18)
  val x9487_reg = list_x9485_reg(19)
  val x9492_reg = list_x9485_reg(20)
  val x3908_or_args_0 = list_x9485_reg(21)
  val x3913_out_channels_args_0 = list_x9485_reg(22)
  val x3904_weights_start_idx_args_0 = list_x9485_reg(23)
  val x9486_reg = list_x9485_reg(24)
  val x9495_reg = list_x9485_reg(25)
  val x3911_oc_args_0 = list_x9485_reg(26)
  val x9482_inB_args_0 = list_x9485_reg(27)
  val x3907_store_idx_args_0 = list_x9485_reg(28)
  val x9489_reg = list_x9485_reg(29)
  val x3901_stride_args_0 = list_x9485_reg(30)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9546_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9546_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9546_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      object Block1Chunker0 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x9499_rd_x9465 = Wire(Bool()).suggestName("""x9499_rd_x9465""")
          val x9499_rd_x9465_banks = List[UInt]()
          val x9499_rd_x9465_ofs = List[UInt]()
          val x9499_rd_x9465_en = List[Bool](true.B)
          x9499_rd_x9465.toSeq.zip(x9465_reg.connectRPort(9499, x9499_rd_x9465_banks, x9499_rd_x9465_ofs, io.sigsIn.backpressure, x9499_rd_x9465_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x9500_rd_x3920 = Wire(Bool()).suggestName("""x9500_rd_x3920""")
          val x9500_rd_x3920_banks = List[UInt]()
          val x9500_rd_x3920_ofs = List[UInt]()
          val x9500_rd_x3920_en = List[Bool](true.B)
          x9500_rd_x3920.toSeq.zip(x3920_reg.connectRPort(9500, x9500_rd_x3920_banks, x9500_rd_x3920_ofs, io.sigsIn.backpressure, x9500_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x9503 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9503""")
          val x9503_banks = List[UInt](b3916.r)
          val x9503_ofs = List[UInt](b3916.r)
          val x9503_en = List[Bool](true.B)
          x9503.toSeq.zip(x3905_bias_start_idx_args_0.connectRPort(9503, x9503_banks, x9503_ofs, io.sigsIn.backpressure, x9503_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20631 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20631_x9503_D1") 
          (0 until 1).foreach{i => x20631(i).r := getRetimed(x9503(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9504_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9504_elem_0""")
          x9504_elem_0.r := x20631(0).r
          val x9505 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9505""")
          val x9505_banks = List[UInt](b3916.r)
          val x9505_ofs = List[UInt](b3916.r)
          val x9505_en = List[Bool](true.B)
          x9505.toSeq.zip(x3902_in2D_args_0.connectRPort(9505, x9505_banks, x9505_ofs, io.sigsIn.backpressure, x9505_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20632 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20632_x9505_D1") 
          (0 until 1).foreach{i => x20632(i).r := getRetimed(x9505(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9506_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9506_elem_0""")
          x9506_elem_0.r := x20632(0).r
          val x9507 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9507""")
          val x9507_banks = List[UInt](b3916.r)
          val x9507_ofs = List[UInt](b3916.r)
          val x9507_en = List[Bool](true.B)
          x9507.toSeq.zip(x9482_inB_args_0.connectRPort(9507, x9507_banks, x9507_ofs, io.sigsIn.backpressure, x9507_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20633 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20633_x9507_D1") 
          (0 until 1).foreach{i => x20633(i).r := getRetimed(x9507(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9508_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9508_elem_0""")
          x9508_elem_0.r := x20633(0).r
          val x9509 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9509""")
          val x9509_banks = List[UInt](b3916.r)
          val x9509_ofs = List[UInt](b3916.r)
          val x9509_en = List[Bool](true.B)
          x9509.toSeq.zip(x3903_in_channels_args_0.connectRPort(9509, x9509_banks, x9509_ofs, io.sigsIn.backpressure, x9509_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20634 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20634_x9509_D1") 
          (0 until 1).foreach{i => x20634(i).r := getRetimed(x9509(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9510_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9510_elem_0""")
          x9510_elem_0.r := x20634(0).r
          val x9511 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9511""")
          val x9511_banks = List[UInt](b3916.r)
          val x9511_ofs = List[UInt](b3916.r)
          val x9511_en = List[Bool](true.B)
          x9511.toSeq.zip(x3906_load_idx_0_args_0.connectRPort(9511, x9511_banks, x9511_ofs, io.sigsIn.backpressure, x9511_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20635 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20635_x9511_D1") 
          (0 until 1).foreach{i => x20635(i).r := getRetimed(x9511(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9512_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9512_elem_0""")
          x9512_elem_0.r := x20635(0).r
          val x9513 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9513""")
          val x9513_banks = List[UInt](b3916.r)
          val x9513_ofs = List[UInt](b3916.r)
          val x9513_en = List[Bool](true.B)
          x9513.toSeq.zip(x3910_nc_args_0.connectRPort(9513, x9513_banks, x9513_ofs, io.sigsIn.backpressure, x9513_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20636 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20636_x9513_D1") 
          (0 until 1).foreach{i => x20636(i).r := getRetimed(x9513(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9514_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9514_elem_0""")
          x9514_elem_0.r := x20636(0).r
          val x9515 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9515""")
          val x9515_banks = List[UInt](b3916.r)
          val x9515_ofs = List[UInt](b3916.r)
          val x9515_en = List[Bool](true.B)
          x9515.toSeq.zip(x3911_oc_args_0.connectRPort(9515, x9515_banks, x9515_ofs, io.sigsIn.backpressure, x9515_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20637 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20637_x9515_D1") 
          (0 until 1).foreach{i => x20637(i).r := getRetimed(x9515(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9516_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9516_elem_0""")
          x9516_elem_0.r := x20637(0).r
          val x9517 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9517""")
          val x9517_banks = List[UInt](b3916.r)
          val x9517_ofs = List[UInt](b3916.r)
          val x9517_en = List[Bool](true.B)
          x9517.toSeq.zip(x3908_or_args_0.connectRPort(9517, x9517_banks, x9517_ofs, io.sigsIn.backpressure, x9517_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20638 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20638_x9517_D1") 
          (0 until 1).foreach{i => x20638(i).r := getRetimed(x9517(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9518_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9518_elem_0""")
          x9518_elem_0.r := x20638(0).r
          val x9519 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9519""")
          val x9519_banks = List[UInt](b3916.r)
          val x9519_ofs = List[UInt](b3916.r)
          val x9519_en = List[Bool](true.B)
          x9519.toSeq.zip(x3909_out2D_args_0.connectRPort(9519, x9519_banks, x9519_ofs, io.sigsIn.backpressure, x9519_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20639 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20639_x9519_D1") 
          (0 until 1).foreach{i => x20639(i).r := getRetimed(x9519(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9520_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9520_elem_0""")
          x9520_elem_0.r := x20639(0).r
          val x9521 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9521""")
          val x9521_banks = List[UInt](b3916.r)
          val x9521_ofs = List[UInt](b3916.r)
          val x9521_en = List[Bool](true.B)
          x9521.toSeq.zip(x3913_out_channels_args_0.connectRPort(9521, x9521_banks, x9521_ofs, io.sigsIn.backpressure, x9521_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20640 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20640_x9521_D1") 
          (0 until 1).foreach{i => x20640(i).r := getRetimed(x9521(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9522_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9522_elem_0""")
          x9522_elem_0.r := x20640(0).r
          val x9523 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9523""")
          val x9523_banks = List[UInt](b3916.r)
          val x9523_ofs = List[UInt](b3916.r)
          val x9523_en = List[Bool](true.B)
          x9523.toSeq.zip(x3907_store_idx_args_0.connectRPort(9523, x9523_banks, x9523_ofs, io.sigsIn.backpressure, x9523_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20641 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20641_x9523_D1") 
          (0 until 1).foreach{i => x20641(i).r := getRetimed(x9523(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9524_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9524_elem_0""")
          x9524_elem_0.r := x20641(0).r
          val x9525 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9525""")
          val x9525_banks = List[UInt](b3916.r)
          val x9525_ofs = List[UInt](b3916.r)
          val x9525_en = List[Bool](true.B)
          x9525.toSeq.zip(x3901_stride_args_0.connectRPort(9525, x9525_banks, x9525_ofs, io.sigsIn.backpressure, x9525_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20642 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20642_x9525_D1") 
          (0 until 1).foreach{i => x20642(i).r := getRetimed(x9525(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9526_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9526_elem_0""")
          x9526_elem_0.r := x20642(0).r
          val x9527 = Wire(Vec(1, Bool())).suggestName("""x9527""")
          val x9527_banks = List[UInt](b3916.r)
          val x9527_ofs = List[UInt](b3916.r)
          val x9527_en = List[Bool](true.B)
          x9527.toSeq.zip(x9483_use_relu_args_0.connectRPort(9527, x9527_banks, x9527_ofs, io.sigsIn.backpressure, x9527_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20643 = Wire(Vec(1, Bool())).suggestName("x20643_x9527_D1") 
          (0 until 1).foreach{i => x20643(i).r := getRetimed(x9527(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9528_elem_0 = Wire(Bool()).suggestName("""x9528_elem_0""")
          x9528_elem_0.r := x20643(0).r
          val x9529 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x9529""")
          val x9529_banks = List[UInt](b3916.r)
          val x9529_ofs = List[UInt](b3916.r)
          val x9529_en = List[Bool](true.B)
          x9529.toSeq.zip(x3904_weights_start_idx_args_0.connectRPort(9529, x9529_banks, x9529_ofs, io.sigsIn.backpressure, x9529_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9500_rd_x3920 & x9499_rd_x9465), true)).foreach{case (a,b) => a := b}
          val x20644 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x20644_x9529_D1") 
          (0 until 1).foreach{i => x20644(i).r := getRetimed(x9529(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9530_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9530_elem_0""")
          x9530_elem_0.r := x20644(0).r
          val x9531_wr_x9484_banks = List[UInt]()
          val x9531_wr_x9484_ofs = List[UInt]()
          val x9531_wr_x9484_en = List[Bool](true.B)
          val x9531_wr_x9484_data = List[UInt](x9504_elem_0.r)
          x9484_reg.connectWPort(9531, x9531_wr_x9484_banks, x9531_wr_x9484_ofs, x9531_wr_x9484_data, x9531_wr_x9484_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9532_wr_x9485_banks = List[UInt]()
          val x9532_wr_x9485_ofs = List[UInt]()
          val x9532_wr_x9485_en = List[Bool](true.B)
          val x9532_wr_x9485_data = List[UInt](x9506_elem_0.r)
          x9485_reg.connectWPort(9532, x9532_wr_x9485_banks, x9532_wr_x9485_ofs, x9532_wr_x9485_data, x9532_wr_x9485_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9533_wr_x9486_banks = List[UInt]()
          val x9533_wr_x9486_ofs = List[UInt]()
          val x9533_wr_x9486_en = List[Bool](true.B)
          val x9533_wr_x9486_data = List[UInt](x9508_elem_0.r)
          x9486_reg.connectWPort(9533, x9533_wr_x9486_banks, x9533_wr_x9486_ofs, x9533_wr_x9486_data, x9533_wr_x9486_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9534_wr_x9487_banks = List[UInt]()
          val x9534_wr_x9487_ofs = List[UInt]()
          val x9534_wr_x9487_en = List[Bool](true.B)
          val x9534_wr_x9487_data = List[UInt](x9510_elem_0.r)
          x9487_reg.connectWPort(9534, x9534_wr_x9487_banks, x9534_wr_x9487_ofs, x9534_wr_x9487_data, x9534_wr_x9487_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9535_wr_x9488_banks = List[UInt]()
          val x9535_wr_x9488_ofs = List[UInt]()
          val x9535_wr_x9488_en = List[Bool](true.B)
          val x9535_wr_x9488_data = List[UInt](x9512_elem_0.r)
          x9488_reg.connectWPort(9535, x9535_wr_x9488_banks, x9535_wr_x9488_ofs, x9535_wr_x9488_data, x9535_wr_x9488_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]("x9514_elem_0" -> x9514_elem_0, "x9516_elem_0" -> x9516_elem_0, "x9518_elem_0" -> x9518_elem_0, "x9520_elem_0" -> x9520_elem_0, "x9522_elem_0" -> x9522_elem_0, "x9524_elem_0" -> x9524_elem_0, "x9526_elem_0" -> x9526_elem_0, "x9528_elem_0" -> x9528_elem_0, "x9530_elem_0" -> x9530_elem_0)
        }
      }
      val block1chunk0: Map[String, Any] = Block1Chunker0.gen()
      object Block1Chunker1 { // 10 nodes, 10 weight
        def gen(): Map[String, Any] = {
          val x9536_wr_x9489_banks = List[UInt]()
          val x9536_wr_x9489_ofs = List[UInt]()
          val x9536_wr_x9489_en = List[Bool](true.B)
          val x9536_wr_x9489_data = List[UInt](block1chunk0("x9514_elem_0").asInstanceOf[FixedPoint].r)
          x9489_reg.connectWPort(9536, x9536_wr_x9489_banks, x9536_wr_x9489_ofs, x9536_wr_x9489_data, x9536_wr_x9489_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9537_wr_x9491_banks = List[UInt]()
          val x9537_wr_x9491_ofs = List[UInt]()
          val x9537_wr_x9491_en = List[Bool](true.B)
          val x9537_wr_x9491_data = List[UInt](block1chunk0("x9516_elem_0").asInstanceOf[FixedPoint].r)
          x9491_reg.connectWPort(9537, x9537_wr_x9491_banks, x9537_wr_x9491_ofs, x9537_wr_x9491_data, x9537_wr_x9491_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9538_wr_x9490_banks = List[UInt]()
          val x9538_wr_x9490_ofs = List[UInt]()
          val x9538_wr_x9490_en = List[Bool](true.B)
          val x9538_wr_x9490_data = List[UInt](block1chunk0("x9516_elem_0").asInstanceOf[FixedPoint].r)
          x9490_reg.connectWPort(9538, x9538_wr_x9490_banks, x9538_wr_x9490_ofs, x9538_wr_x9490_data, x9538_wr_x9490_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9539_wr_x9492_banks = List[UInt]()
          val x9539_wr_x9492_ofs = List[UInt]()
          val x9539_wr_x9492_en = List[Bool](true.B)
          val x9539_wr_x9492_data = List[UInt](block1chunk0("x9518_elem_0").asInstanceOf[FixedPoint].r)
          x9492_reg.connectWPort(9539, x9539_wr_x9492_banks, x9539_wr_x9492_ofs, x9539_wr_x9492_data, x9539_wr_x9492_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9540_wr_x9493_banks = List[UInt]()
          val x9540_wr_x9493_ofs = List[UInt]()
          val x9540_wr_x9493_en = List[Bool](true.B)
          val x9540_wr_x9493_data = List[UInt](block1chunk0("x9520_elem_0").asInstanceOf[FixedPoint].r)
          x9493_reg.connectWPort(9540, x9540_wr_x9493_banks, x9540_wr_x9493_ofs, x9540_wr_x9493_data, x9540_wr_x9493_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9541_wr_x9494_banks = List[UInt]()
          val x9541_wr_x9494_ofs = List[UInt]()
          val x9541_wr_x9494_en = List[Bool](true.B)
          val x9541_wr_x9494_data = List[UInt](block1chunk0("x9522_elem_0").asInstanceOf[FixedPoint].r)
          x9494_reg.connectWPort(9541, x9541_wr_x9494_banks, x9541_wr_x9494_ofs, x9541_wr_x9494_data, x9541_wr_x9494_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9542_wr_x9495_banks = List[UInt]()
          val x9542_wr_x9495_ofs = List[UInt]()
          val x9542_wr_x9495_en = List[Bool](true.B)
          val x9542_wr_x9495_data = List[UInt](block1chunk0("x9524_elem_0").asInstanceOf[FixedPoint].r)
          x9495_reg.connectWPort(9542, x9542_wr_x9495_banks, x9542_wr_x9495_ofs, x9542_wr_x9495_data, x9542_wr_x9495_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9543_wr_x9496_banks = List[UInt]()
          val x9543_wr_x9496_ofs = List[UInt]()
          val x9543_wr_x9496_en = List[Bool](true.B)
          val x9543_wr_x9496_data = List[UInt](block1chunk0("x9526_elem_0").asInstanceOf[FixedPoint].r)
          x9496_reg.connectWPort(9543, x9543_wr_x9496_banks, x9543_wr_x9496_ofs, x9543_wr_x9496_data, x9543_wr_x9496_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9544_wr_x9497_banks = List[UInt]()
          val x9544_wr_x9497_ofs = List[UInt]()
          val x9544_wr_x9497_en = List[Bool](true.B)
          val x9544_wr_x9497_data = List[UInt](block1chunk0("x9528_elem_0").asInstanceOf[Bool].r)
          x9497_reg.connectWPort(9544, x9544_wr_x9497_banks, x9544_wr_x9497_ofs, x9544_wr_x9497_data, x9544_wr_x9497_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          val x9545_wr_x9498_banks = List[UInt]()
          val x9545_wr_x9498_ofs = List[UInt]()
          val x9545_wr_x9498_en = List[Bool](true.B)
          val x9545_wr_x9498_data = List[UInt](block1chunk0("x9530_elem_0").asInstanceOf[FixedPoint].r)
          x9498_reg.connectWPort(9545, x9545_wr_x9498_banks, x9545_wr_x9498_ofs, x9545_wr_x9498_data, x9545_wr_x9498_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]()
        }
      }
      val block1chunk1: Map[String, Any] = Block1Chunker1.gen()
    }
    val module = Module(new x9546_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9546_inr_UnitPipe **/
