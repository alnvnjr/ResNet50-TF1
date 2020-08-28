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

/** Hierarchy: x9843 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9843_inr_Foreach **/
class x9843_inr_Foreach_kernel(
  list_x18792_rd_x9466: List[Bool],
  list_x9554_bias_SRAM_0: List[NBufInterface],
  list_x9465_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 4.2.toInt, myName = "x9843_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9843_inr_Foreach_iiCtr"))
  
  abstract class x9843_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9465_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9465_reg_p").asInstanceOf[MemParams] ))
      val in_x18792_rd_x9466 = Input(Bool())
      val in_x9554_bias_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9554_bias_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_b9553 = Input(Bool())
      val in_x9767_weight_SRAM_reshape_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9767_weight_SRAM_reshape_0_p").asInstanceOf[NBufParams] ))
      val in_x18791_rd_x3921 = Input(Bool())
      val in_x9583_weight_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9583_weight_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1, 4), List(32, 32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9465_reg = {io.in_x9465_reg} ; io.in_x9465_reg := DontCare
    def x18792_rd_x9466 = {io.in_x18792_rd_x9466} 
    def x9554_bias_SRAM_0 = {io.in_x9554_bias_SRAM_0} ; io.in_x9554_bias_SRAM_0 := DontCare
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def b9553 = {io.in_b9553} 
    def x9767_weight_SRAM_reshape_0 = {io.in_x9767_weight_SRAM_reshape_0} ; io.in_x9767_weight_SRAM_reshape_0 := DontCare
    def x18791_rd_x3921 = {io.in_x18791_rd_x3921} 
    def x9583_weight_SRAM_0 = {io.in_x9583_weight_SRAM_0} ; io.in_x9583_weight_SRAM_0 := DontCare
  }
  def connectWires0(module: x9843_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x9465_reg.connectLedger(module.io.in_x9465_reg)
    module.io.in_x18792_rd_x9466 <> x18792_rd_x9466
    x9554_bias_SRAM_0.connectLedger(module.io.in_x9554_bias_SRAM_0)
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    module.io.in_b9553 <> b9553
    x9767_weight_SRAM_reshape_0.connectLedger(module.io.in_x9767_weight_SRAM_reshape_0)
    module.io.in_x18791_rd_x3921 <> x18791_rd_x3921
    x9583_weight_SRAM_0.connectLedger(module.io.in_x9583_weight_SRAM_0)
  }
  val x18792_rd_x9466 = list_x18792_rd_x9466(0)
  val b9553 = list_x18792_rd_x9466(1)
  val x18791_rd_x3921 = list_x18792_rd_x9466(2)
  val x9554_bias_SRAM_0 = list_x9554_bias_SRAM_0(0)
  val x9767_weight_SRAM_reshape_0 = list_x9554_bias_SRAM_0(1)
  val x9583_weight_SRAM_0 = list_x9554_bias_SRAM_0(2)
  val x9465_reg = list_x9465_reg(0)
  val x3920_reg = list_x9465_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9843_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x9843_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9843_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b9774 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b9774.suggestName("b9774")
      val b9775 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b9775.suggestName("b9775")
      val b9776 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b9776.suggestName("b9776")
      val b9777 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b9777.suggestName("b9777")
      val b9778 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b9778.suggestName("b9778")
      val b9779 = ~io.sigsIn.cchainOutputs.head.oobs(0); b9779.suggestName("b9779")
      val b9780 = ~io.sigsIn.cchainOutputs.head.oobs(1); b9780.suggestName("b9780")
      val b9781 = ~io.sigsIn.cchainOutputs.head.oobs(2); b9781.suggestName("b9781")
      val b9782 = ~io.sigsIn.cchainOutputs.head.oobs(3); b9782.suggestName("b9782")
      val b9783 = ~io.sigsIn.cchainOutputs.head.oobs(4); b9783.suggestName("b9783")
      object Block2Chunker0 { // 46 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x9784_rd_x9465 = Wire(Bool()).suggestName("""x9784_rd_x9465""")
          val x9784_rd_x9465_banks = List[UInt]()
          val x9784_rd_x9465_ofs = List[UInt]()
          val x9784_rd_x9465_en = List[Bool](true.B)
          x9784_rd_x9465.toSeq.zip(x9465_reg.connectRPort(9784, x9784_rd_x9465_banks, x9784_rd_x9465_ofs, io.sigsIn.backpressure, x9784_rd_x9465_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x9788_rd_x3920 = Wire(Bool()).suggestName("""x9788_rd_x3920""")
          val x9788_rd_x3920_banks = List[UInt]()
          val x9788_rd_x3920_ofs = List[UInt]()
          val x9788_rd_x3920_en = List[Bool](true.B)
          x9788_rd_x3920.toSeq.zip(x3920_reg.connectRPort(9788, x9788_rd_x3920_banks, x9788_rd_x3920_ofs, io.sigsIn.backpressure, x9788_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x9792_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9792_sum""")
          x9792_sum.r := Math.add(b9775,b9774,Some(1.0), true.B, Truncate, Wrapping, "x9792_sum").r
          val x19069 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19069""")
          x19069.r := Math.and(x9792_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19069").r
          val x9794_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9794_sum""")
          x9794_sum.r := Math.add(b9776,b9774,Some(1.0), true.B, Truncate, Wrapping, "x9794_sum").r
          val x19070 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19070""")
          x19070.r := Math.and(x9794_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19070").r
          val x9796_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9796_sum""")
          x9796_sum.r := Math.add(b9777,b9774,Some(1.0), true.B, Truncate, Wrapping, "x9796_sum").r
          val x19071 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19071""")
          x19071.r := Math.and(x9796_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19071").r
          val x9798_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9798_sum""")
          x9798_sum.r := Math.add(b9778,b9774,Some(1.0), true.B, Truncate, Wrapping, "x9798_sum").r
          val x19072 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19072""")
          x19072.r := Math.and(x9798_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19072").r
          val x9800 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9800""")
          x9800.r := Math.arith_left_shift(b9775, 8, Some(0.2), true.B,"x9800").r
          val x9801 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9801""")
          x9801.r := Math.arith_right_shift(b9774, 3, Some(0.2), true.B,"x9801").r
          val x9802_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9802_sum""")
          x9802_sum.r := Math.add(x9800,x9801,Some(1.0), true.B, Truncate, Wrapping, "x9802_sum").r
          val x9805 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9805""")
          x9805.r := Math.arith_left_shift(b9776, 8, Some(0.2), true.B,"x9805").r
          val x9806_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9806_sum""")
          x9806_sum.r := Math.add(x9805,x9801,Some(1.0), true.B, Truncate, Wrapping, "x9806_sum").r
          val x9809 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9809""")
          x9809.r := Math.arith_left_shift(b9777, 8, Some(0.2), true.B,"x9809").r
          val x9810_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9810_sum""")
          x9810_sum.r := Math.add(x9809,x9801,Some(1.0), true.B, Truncate, Wrapping, "x9810_sum").r
          val x9813 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9813""")
          x9813.r := Math.arith_left_shift(b9778, 8, Some(0.2), true.B,"x9813").r
          val x9814_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9814_sum""")
          x9814_sum.r := Math.add(x9813,x9801,Some(1.0), true.B, Truncate, Wrapping, "x9814_sum").r
          val x20687 = Wire(Bool()).suggestName("x20687_b9781_D1") 
          x20687.r := getRetimed(b9781.r, 1.toInt, io.sigsIn.backpressure)
          val x20688 = Wire(Bool()).suggestName("x20688_b9779_D1") 
          x20688.r := getRetimed(b9779.r, 1.toInt, io.sigsIn.backpressure)
          val x20689 = Wire(Bool()).suggestName("x20689_b9782_D1") 
          x20689.r := getRetimed(b9782.r, 1.toInt, io.sigsIn.backpressure)
          val x20690 = Wire(Bool()).suggestName("x20690_b9553_D1") 
          x20690.r := getRetimed(b9553.r, 1.toInt, io.sigsIn.backpressure)
          val x20691 = Wire(Bool()).suggestName("x20691_b9783_D1") 
          x20691.r := getRetimed(b9783.r, 1.toInt, io.sigsIn.backpressure)
          val x20692 = Wire(Bool()).suggestName("x20692_b9780_D1") 
          x20692.r := getRetimed(b9780.r, 1.toInt, io.sigsIn.backpressure)
          val x20693 = Wire(Bool()).suggestName("x20693_x9788_rd_x3920_D1") 
          x20693.r := getRetimed(x9788_rd_x3920.r, 1.toInt, io.sigsIn.backpressure)
          val x20694 = Wire(Bool()).suggestName("x20694_x9784_rd_x9465_D1") 
          x20694.r := getRetimed(x9784_rd_x9465.r, 1.toInt, io.sigsIn.backpressure)
          val x9817_rd = Wire(Vec(4, new FixedPoint(true, 10, 22))).suggestName("""x9817_rd""")
          val x9817_rd_banks = List[UInt](x19069.r,x19070.r,x19071.r,x19072.r)
          val x9817_rd_ofs = List[UInt](x9802_sum.r,x9806_sum.r,x9810_sum.r,x9814_sum.r)
          val x9817_rd_en = List[Bool](x20692,x20687,x20689,x20691)
          x9817_rd.toSeq.zip(x9583_weight_SRAM_0.connectRPort(9817, x9817_rd_banks, x9817_rd_ofs, io.sigsIn.backpressure, x9817_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) && x20694 & x20688 & x20690 & x20693), true)).foreach{case (a,b) => a := b}
          val x9818_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9818_elem_0""")
          x9818_elem_0.r := x9817_rd(0).r
          val x9819_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9819_elem_1""")
          x9819_elem_1.r := x9817_rd(1).r
          val x9820_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9820_elem_2""")
          x9820_elem_2.r := x9817_rd(2).r
          val x9821_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9821_elem_3""")
          x9821_elem_3.r := x9817_rd(3).r
          val x19073 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19073""")
          x19073.r := Math.and(b9775,31L.FP(true, 32, 0),Some(0.2), true.B,"x19073").r
          val x19074 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19074""")
          x19074.r := Math.and(b9776,31L.FP(true, 32, 0),Some(0.2), true.B,"x19074").r
          val x19075 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19075""")
          x19075.r := Math.and(b9777,31L.FP(true, 32, 0),Some(0.2), true.B,"x19075").r
          val x19076 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19076""")
          x19076.r := Math.and(b9778,31L.FP(true, 32, 0),Some(0.2), true.B,"x19076").r
          val x9826 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9826""")
          x9826.r := Math.arith_right_shift(b9775, 5, Some(0.2), true.B,"x9826").r
          val x9827 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9827""")
          x9827.r := Math.arith_left_shift(x9826, 11, Some(0.2), true.B,"x9827").r
          val x9828_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9828_sum""")
          x9828_sum.r := Math.add(x9827,b9774,Some(1.0), true.B, Truncate, Wrapping, "x9828_sum").r
          val x9830 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9830""")
          x9830.r := Math.arith_right_shift(b9776, 5, Some(0.2), true.B,"x9830").r
          val x9831 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9831""")
          x9831.r := Math.arith_left_shift(x9830, 11, Some(0.2), true.B,"x9831").r
          val x9832_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9832_sum""")
          x9832_sum.r := Math.add(x9831,b9774,Some(1.0), true.B, Truncate, Wrapping, "x9832_sum").r
          val x9834 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9834""")
          x9834.r := Math.arith_right_shift(b9777, 5, Some(0.2), true.B,"x9834").r
          val x9835 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9835""")
          x9835.r := Math.arith_left_shift(x9834, 11, Some(0.2), true.B,"x9835").r
          val x9836_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9836_sum""")
          x9836_sum.r := Math.add(x9835,b9774,Some(1.0), true.B, Truncate, Wrapping, "x9836_sum").r
          val x9838 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9838""")
          x9838.r := Math.arith_right_shift(b9778, 5, Some(0.2), true.B,"x9838").r
          Map[String,Any]("x9784_rd_x9465" -> x9784_rd_x9465, "x9788_rd_x3920" -> x9788_rd_x3920, "x9818_elem_0" -> x9818_elem_0, "x9819_elem_1" -> x9819_elem_1, "x9820_elem_2" -> x9820_elem_2, "x9821_elem_3" -> x9821_elem_3, "x19073" -> x19073, "x19074" -> x19074, "x19075" -> x19075, "x19076" -> x19076, "x9828_sum" -> x9828_sum, "x9832_sum" -> x9832_sum, "x9836_sum" -> x9836_sum, "x9838" -> x9838)
        }
      }
      val block2chunk0: Map[String, Any] = Block2Chunker0.gen()
      object Block2Chunker1 { // 19 nodes, 22 weight
        def gen(): Map[String, Any] = {
          val x9839 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9839""")
          x9839.r := Math.arith_left_shift(block2chunk0("x9838").asInstanceOf[FixedPoint], 11, Some(0.2), true.B,"x9839").r
          val x9840_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9840_sum""")
          x9840_sum.r := Math.add(x9839,b9774,Some(1.0), true.B, Truncate, Wrapping, "x9840_sum").r
          val x20695 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20695_x19076_D3") 
          x20695.r := getRetimed(block2chunk0("x19076").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x20696 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20696_x9828_sum_D2") 
          x20696.r := getRetimed(block2chunk0("x9828_sum").asInstanceOf[FixedPoint].r, 2.toInt, io.sigsIn.backpressure)
          val x20697 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20697_x9832_sum_D2") 
          x20697.r := getRetimed(block2chunk0("x9832_sum").asInstanceOf[FixedPoint].r, 2.toInt, io.sigsIn.backpressure)
          val x20698 = Wire(Bool()).suggestName("x20698_b9781_D3") 
          x20698.r := getRetimed(b9781.r, 3.toInt, io.sigsIn.backpressure)
          val x20699 = Wire(Bool()).suggestName("x20699_b9779_D3") 
          x20699.r := getRetimed(b9779.r, 3.toInt, io.sigsIn.backpressure)
          val x20700 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20700_x9836_sum_D2") 
          x20700.r := getRetimed(block2chunk0("x9836_sum").asInstanceOf[FixedPoint].r, 2.toInt, io.sigsIn.backpressure)
          val x20701 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20701_x19075_D3") 
          x20701.r := getRetimed(block2chunk0("x19075").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x20702 = Wire(Bool()).suggestName("x20702_b9782_D3") 
          x20702.r := getRetimed(b9782.r, 3.toInt, io.sigsIn.backpressure)
          val x20703 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20703_x9840_sum_D2") 
          x20703.r := getRetimed(x9840_sum.r, 2.toInt, io.sigsIn.backpressure)
          val x20704 = Wire(Bool()).suggestName("x20704_b9553_D3") 
          x20704.r := getRetimed(b9553.r, 3.toInt, io.sigsIn.backpressure)
          val x20705 = Wire(Bool()).suggestName("x20705_b9783_D3") 
          x20705.r := getRetimed(b9783.r, 3.toInt, io.sigsIn.backpressure)
          val x20706 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20706_x19074_D3") 
          x20706.r := getRetimed(block2chunk0("x19074").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x20707 = Wire(Bool()).suggestName("x20707_b9780_D3") 
          x20707.r := getRetimed(b9780.r, 3.toInt, io.sigsIn.backpressure)
          val x20708 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20708_x19073_D3") 
          x20708.r := getRetimed(block2chunk0("x19073").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x20709 = Wire(Bool()).suggestName("x20709_x9788_rd_x3920_D3") 
          x20709.r := getRetimed(block2chunk0("x9788_rd_x3920").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x20710 = Wire(Bool()).suggestName("x20710_x9784_rd_x9465_D3") 
          x20710.r := getRetimed(block2chunk0("x9784_rd_x9465").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x9842_wr_banks = List[UInt](x20708.r,x20706.r,x20701.r,x20695.r)
          val x9842_wr_ofs = List[UInt](x20696.r,x20697.r,x20700.r,x20703.r)
          val x9842_wr_en = List[Bool](x20707,x20698,x20702,x20705)
          def create_x9842_wr_data(): List[UInt] = {
            val x9842_wr_data0 = List[UInt](block2chunk0("x9818_elem_0").asInstanceOf[FixedPoint].r,block2chunk0("x9819_elem_1").asInstanceOf[FixedPoint].r,block2chunk0("x9820_elem_2").asInstanceOf[FixedPoint].r,block2chunk0("x9821_elem_3").asInstanceOf[FixedPoint].r)
            x9842_wr_data0
          }
          val x9842_wr_data = create_x9842_wr_data()
          x9767_weight_SRAM_reshape_0.connectWPort(9842, x9842_wr_banks, x9842_wr_ofs, x9842_wr_data, x9842_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x20709 & x20704 & x20710 & x20699))
          Map[String,Any]()
        }
      }
      val block2chunk1: Map[String, Any] = Block2Chunker1.gen()
      x9554_bias_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 3)
      x9583_weight_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x9767_weight_SRAM_reshape_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x9843_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x9843_inr_Foreach **/
