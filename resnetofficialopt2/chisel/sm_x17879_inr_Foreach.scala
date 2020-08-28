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

/** Hierarchy: x17879 -> x17880 -> x18367 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17879_inr_Foreach **/
class x17879_inr_Foreach_kernel(
  list_x17750: List[DecoupledIO[AppLoadData]],
  list_x17748_feature_map_a_0: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x17879_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17879_inr_Foreach_iiCtr"))
  
  abstract class x17879_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x17748_feature_map_a_0 = Flipped(new NBufInterface(ModuleParams.getParams("x17748_feature_map_a_0_p").asInstanceOf[NBufParams] ))
      val in_x17750 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17750_p").asInstanceOf[(Int, Int)] )))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(16), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x17748_feature_map_a_0 = {io.in_x17748_feature_map_a_0} ; io.in_x17748_feature_map_a_0 := DontCare
    def x17750 = {io.in_x17750} 
  }
  def connectWires0(module: x17879_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x17748_feature_map_a_0.connectLedger(module.io.in_x17748_feature_map_a_0)
    module.io.in_x17750 <> x17750
  }
  val x17750 = list_x17750(0)
  val x17748_feature_map_a_0 = list_x17748_feature_map_a_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17879_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x17879_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17879_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b17765 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b17765.suggestName("b17765")
      val b17766 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b17766.suggestName("b17766")
      val b17767 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b17767.suggestName("b17767")
      val b17768 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b17768.suggestName("b17768")
      val b17769 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b17769.suggestName("b17769")
      val b17770 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b17770.suggestName("b17770")
      val b17771 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b17771.suggestName("b17771")
      val b17772 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b17772.suggestName("b17772")
      val b17773 = io.sigsIn.cchainOutputs.head.counts(8).FP(true, 32, 0); b17773.suggestName("b17773")
      val b17774 = io.sigsIn.cchainOutputs.head.counts(9).FP(true, 32, 0); b17774.suggestName("b17774")
      val b17775 = io.sigsIn.cchainOutputs.head.counts(10).FP(true, 32, 0); b17775.suggestName("b17775")
      val b17776 = io.sigsIn.cchainOutputs.head.counts(11).FP(true, 32, 0); b17776.suggestName("b17776")
      val b17777 = io.sigsIn.cchainOutputs.head.counts(12).FP(true, 32, 0); b17777.suggestName("b17777")
      val b17778 = io.sigsIn.cchainOutputs.head.counts(13).FP(true, 32, 0); b17778.suggestName("b17778")
      val b17779 = io.sigsIn.cchainOutputs.head.counts(14).FP(true, 32, 0); b17779.suggestName("b17779")
      val b17780 = io.sigsIn.cchainOutputs.head.counts(15).FP(true, 32, 0); b17780.suggestName("b17780")
      val b17781 = ~io.sigsIn.cchainOutputs.head.oobs(0); b17781.suggestName("b17781")
      val b17782 = ~io.sigsIn.cchainOutputs.head.oobs(1); b17782.suggestName("b17782")
      val b17783 = ~io.sigsIn.cchainOutputs.head.oobs(2); b17783.suggestName("b17783")
      val b17784 = ~io.sigsIn.cchainOutputs.head.oobs(3); b17784.suggestName("b17784")
      val b17785 = ~io.sigsIn.cchainOutputs.head.oobs(4); b17785.suggestName("b17785")
      val b17786 = ~io.sigsIn.cchainOutputs.head.oobs(5); b17786.suggestName("b17786")
      val b17787 = ~io.sigsIn.cchainOutputs.head.oobs(6); b17787.suggestName("b17787")
      val b17788 = ~io.sigsIn.cchainOutputs.head.oobs(7); b17788.suggestName("b17788")
      val b17789 = ~io.sigsIn.cchainOutputs.head.oobs(8); b17789.suggestName("b17789")
      val b17790 = ~io.sigsIn.cchainOutputs.head.oobs(9); b17790.suggestName("b17790")
      val b17791 = ~io.sigsIn.cchainOutputs.head.oobs(10); b17791.suggestName("b17791")
      val b17792 = ~io.sigsIn.cchainOutputs.head.oobs(11); b17792.suggestName("b17792")
      val b17793 = ~io.sigsIn.cchainOutputs.head.oobs(12); b17793.suggestName("b17793")
      val b17794 = ~io.sigsIn.cchainOutputs.head.oobs(13); b17794.suggestName("b17794")
      val b17795 = ~io.sigsIn.cchainOutputs.head.oobs(14); b17795.suggestName("b17795")
      val b17796 = ~io.sigsIn.cchainOutputs.head.oobs(15); b17796.suggestName("b17796")
      object Block1Chunker0 { // 34 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x17797 = Wire(Vec(16, new FixedPoint(true, 10, 22))).suggestName("""x17797""")
          x17750.ready := b17783 & b17794 & b17790 & b17787 & b17786 & b17791 & b17782 & b17796 & b17785 & b17793 & b17789 & b17792 & b17781 & b17795 & b17784 & b17788 & (io.sigsIn.datapathEn) 
          (0 until 16).map{ i => x17797(i).r := x17750.bits.rdata(i).r }
          val x21862 = Wire(Vec(16, new FixedPoint(true, 10, 22))).suggestName("x21862_x17797_D1") 
          (0 until 16).foreach{i => x21862(i).r := getRetimed(x17797(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x17798_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17798_elem_0""")
          x17798_elem_0.r := x21862(0).r
          val x17799_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17799_elem_1""")
          x17799_elem_1.r := x21862(1).r
          val x17800_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17800_elem_2""")
          x17800_elem_2.r := x21862(2).r
          val x17801_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17801_elem_3""")
          x17801_elem_3.r := x21862(3).r
          val x17802_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17802_elem_4""")
          x17802_elem_4.r := x21862(4).r
          val x17803_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17803_elem_5""")
          x17803_elem_5.r := x21862(5).r
          val x17804_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17804_elem_6""")
          x17804_elem_6.r := x21862(6).r
          val x17805_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17805_elem_7""")
          x17805_elem_7.r := x21862(7).r
          val x17806_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17806_elem_8""")
          x17806_elem_8.r := x21862(8).r
          val x17807_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17807_elem_9""")
          x17807_elem_9.r := x21862(9).r
          val x17808_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17808_elem_10""")
          x17808_elem_10.r := x21862(10).r
          val x17809_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17809_elem_11""")
          x17809_elem_11.r := x21862(11).r
          val x17810_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17810_elem_12""")
          x17810_elem_12.r := x21862(12).r
          val x17811_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17811_elem_13""")
          x17811_elem_13.r := x21862(13).r
          val x17812_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17812_elem_14""")
          x17812_elem_14.r := x21862(14).r
          val x17813_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17813_elem_15""")
          x17813_elem_15.r := x21862(15).r
          val x17830 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17830""")
          x17830.r := Math.arith_right_shift(b17765, 4, Some(0.2), true.B,"x17830").r
          val x17833 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17833""")
          x17833.r := Math.arith_right_shift(b17766, 4, Some(0.2), true.B,"x17833").r
          val x17836 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17836""")
          x17836.r := Math.arith_right_shift(b17767, 4, Some(0.2), true.B,"x17836").r
          val x17839 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17839""")
          x17839.r := Math.arith_right_shift(b17768, 4, Some(0.2), true.B,"x17839").r
          val x17842 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17842""")
          x17842.r := Math.arith_right_shift(b17769, 4, Some(0.2), true.B,"x17842").r
          val x17845 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17845""")
          x17845.r := Math.arith_right_shift(b17770, 4, Some(0.2), true.B,"x17845").r
          val x17848 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17848""")
          x17848.r := Math.arith_right_shift(b17771, 4, Some(0.2), true.B,"x17848").r
          val x17851 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17851""")
          x17851.r := Math.arith_right_shift(b17772, 4, Some(0.2), true.B,"x17851").r
          val x17854 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17854""")
          x17854.r := Math.arith_right_shift(b17773, 4, Some(0.2), true.B,"x17854").r
          val x17857 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17857""")
          x17857.r := Math.arith_right_shift(b17774, 4, Some(0.2), true.B,"x17857").r
          val x17860 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17860""")
          x17860.r := Math.arith_right_shift(b17775, 4, Some(0.2), true.B,"x17860").r
          val x17863 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17863""")
          x17863.r := Math.arith_right_shift(b17776, 4, Some(0.2), true.B,"x17863").r
          val x17866 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17866""")
          x17866.r := Math.arith_right_shift(b17777, 4, Some(0.2), true.B,"x17866").r
          val x17869 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17869""")
          x17869.r := Math.arith_right_shift(b17778, 4, Some(0.2), true.B,"x17869").r
          val x17872 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17872""")
          x17872.r := Math.arith_right_shift(b17779, 4, Some(0.2), true.B,"x17872").r
          val x17875 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17875""")
          x17875.r := Math.arith_right_shift(b17780, 4, Some(0.2), true.B,"x17875").r
          Map[String,Any]("x17798_elem_0" -> x17798_elem_0, "x17799_elem_1" -> x17799_elem_1, "x17800_elem_2" -> x17800_elem_2, "x17801_elem_3" -> x17801_elem_3, "x17802_elem_4" -> x17802_elem_4, "x17803_elem_5" -> x17803_elem_5, "x17804_elem_6" -> x17804_elem_6, "x17805_elem_7" -> x17805_elem_7, "x17806_elem_8" -> x17806_elem_8, "x17807_elem_9" -> x17807_elem_9, "x17808_elem_10" -> x17808_elem_10, "x17809_elem_11" -> x17809_elem_11, "x17810_elem_12" -> x17810_elem_12, "x17811_elem_13" -> x17811_elem_13, "x17812_elem_14" -> x17812_elem_14, "x17813_elem_15" -> x17813_elem_15, "x17830" -> x17830, "x17833" -> x17833, "x17836" -> x17836, "x17839" -> x17839, "x17842" -> x17842, "x17845" -> x17845, "x17848" -> x17848, "x17851" -> x17851, "x17854" -> x17854, "x17857" -> x17857, "x17860" -> x17860, "x17863" -> x17863, "x17866" -> x17866, "x17869" -> x17869, "x17872" -> x17872, "x17875" -> x17875)
        }
      }
      val block1chunk0: Map[String, Any] = Block1Chunker0.gen()
      object Block1Chunker1 { // 33 nodes, 48 weight
        def gen(): Map[String, Any] = {
          val x21863 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21863_x17875_D1") 
          x21863.r := getRetimed(block1chunk0("x17875").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21864 = Wire(Bool()).suggestName("x21864_b17788_D1") 
          x21864.r := getRetimed(b17788.r, 1.toInt, io.sigsIn.backpressure)
          val x21865 = Wire(Bool()).suggestName("x21865_b17791_D1") 
          x21865.r := getRetimed(b17791.r, 1.toInt, io.sigsIn.backpressure)
          val x21866 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21866_x17857_D1") 
          x21866.r := getRetimed(block1chunk0("x17857").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21867 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21867_x17830_D1") 
          x21867.r := getRetimed(block1chunk0("x17830").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21868 = Wire(Bool()).suggestName("x21868_b17783_D1") 
          x21868.r := getRetimed(b17783.r, 1.toInt, io.sigsIn.backpressure)
          val x21869 = Wire(Bool()).suggestName("x21869_b17787_D1") 
          x21869.r := getRetimed(b17787.r, 1.toInt, io.sigsIn.backpressure)
          val x21870 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21870_x17866_D1") 
          x21870.r := getRetimed(block1chunk0("x17866").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21871 = Wire(Bool()).suggestName("x21871_b17793_D1") 
          x21871.r := getRetimed(b17793.r, 1.toInt, io.sigsIn.backpressure)
          val x21872 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21872_x17863_D1") 
          x21872.r := getRetimed(block1chunk0("x17863").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21873 = Wire(Bool()).suggestName("x21873_b17784_D1") 
          x21873.r := getRetimed(b17784.r, 1.toInt, io.sigsIn.backpressure)
          val x21874 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21874_x17848_D1") 
          x21874.r := getRetimed(block1chunk0("x17848").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21875 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21875_x17851_D1") 
          x21875.r := getRetimed(block1chunk0("x17851").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21876 = Wire(Bool()).suggestName("x21876_b17795_D1") 
          x21876.r := getRetimed(b17795.r, 1.toInt, io.sigsIn.backpressure)
          val x21877 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21877_x17854_D1") 
          x21877.r := getRetimed(block1chunk0("x17854").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21878 = Wire(Bool()).suggestName("x21878_b17789_D1") 
          x21878.r := getRetimed(b17789.r, 1.toInt, io.sigsIn.backpressure)
          val x21879 = Wire(Bool()).suggestName("x21879_b17786_D1") 
          x21879.r := getRetimed(b17786.r, 1.toInt, io.sigsIn.backpressure)
          val x21880 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21880_x17860_D1") 
          x21880.r := getRetimed(block1chunk0("x17860").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21881 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21881_x17869_D1") 
          x21881.r := getRetimed(block1chunk0("x17869").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21882 = Wire(Bool()).suggestName("x21882_b17794_D1") 
          x21882.r := getRetimed(b17794.r, 1.toInt, io.sigsIn.backpressure)
          val x21883 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21883_x17845_D1") 
          x21883.r := getRetimed(block1chunk0("x17845").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21884 = Wire(Bool()).suggestName("x21884_b17781_D1") 
          x21884.r := getRetimed(b17781.r, 1.toInt, io.sigsIn.backpressure)
          val x21885 = Wire(Bool()).suggestName("x21885_b17796_D1") 
          x21885.r := getRetimed(b17796.r, 1.toInt, io.sigsIn.backpressure)
          val x21886 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21886_x17833_D1") 
          x21886.r := getRetimed(block1chunk0("x17833").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21887 = Wire(Bool()).suggestName("x21887_b17790_D1") 
          x21887.r := getRetimed(b17790.r, 1.toInt, io.sigsIn.backpressure)
          val x21888 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21888_x17842_D1") 
          x21888.r := getRetimed(block1chunk0("x17842").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21889 = Wire(Bool()).suggestName("x21889_b17792_D1") 
          x21889.r := getRetimed(b17792.r, 1.toInt, io.sigsIn.backpressure)
          val x21890 = Wire(Bool()).suggestName("x21890_b17785_D1") 
          x21890.r := getRetimed(b17785.r, 1.toInt, io.sigsIn.backpressure)
          val x21891 = Wire(Bool()).suggestName("x21891_b17782_D1") 
          x21891.r := getRetimed(b17782.r, 1.toInt, io.sigsIn.backpressure)
          val x21892 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21892_x17872_D1") 
          x21892.r := getRetimed(block1chunk0("x17872").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21893 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21893_x17839_D1") 
          x21893.r := getRetimed(block1chunk0("x17839").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21894 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21894_x17836_D1") 
          x21894.r := getRetimed(block1chunk0("x17836").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          def create_x17878_wr_banks(): List[UInt] = {
            val x17878_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x17878_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x17878_wr_banks0 ++ x17878_wr_banks1
          }
          val x17878_wr_banks = create_x17878_wr_banks()
          def create_x17878_wr_ofs(): List[UInt] = {
            val x17878_wr_ofs0 = List[UInt](x21867.r,x21886.r,x21894.r,x21893.r,x21888.r,x21883.r,x21874.r,x21875.r,x21877.r,x21866.r,x21880.r,x21872.r,x21870.r,x21881.r,x21892.r,x21863.r)
            x17878_wr_ofs0
          }
          val x17878_wr_ofs = create_x17878_wr_ofs()
          val x17878_wr_en = List[Bool](x21884,x21891,x21868,x21873,x21890,x21879,x21869,x21864,x21878,x21887,x21865,x21889,x21871,x21882,x21876,x21885)
          def create_x17878_wr_data(): List[UInt] = {
            val x17878_wr_data0 = List[UInt](block1chunk0("x17798_elem_0").asInstanceOf[FixedPoint].r,block1chunk0("x17799_elem_1").asInstanceOf[FixedPoint].r)
            val x17878_wr_data1 = List[UInt](block1chunk0("x17800_elem_2").asInstanceOf[FixedPoint].r,block1chunk0("x17801_elem_3").asInstanceOf[FixedPoint].r)
            val x17878_wr_data2 = List[UInt](block1chunk0("x17802_elem_4").asInstanceOf[FixedPoint].r,block1chunk0("x17803_elem_5").asInstanceOf[FixedPoint].r)
            val x17878_wr_data3 = List[UInt](block1chunk0("x17804_elem_6").asInstanceOf[FixedPoint].r,block1chunk0("x17805_elem_7").asInstanceOf[FixedPoint].r)
            val x17878_wr_data4 = List[UInt](block1chunk0("x17806_elem_8").asInstanceOf[FixedPoint].r,block1chunk0("x17807_elem_9").asInstanceOf[FixedPoint].r)
            val x17878_wr_data5 = List[UInt](block1chunk0("x17808_elem_10").asInstanceOf[FixedPoint].r,block1chunk0("x17809_elem_11").asInstanceOf[FixedPoint].r)
            val x17878_wr_data6 = List[UInt](block1chunk0("x17810_elem_12").asInstanceOf[FixedPoint].r,block1chunk0("x17811_elem_13").asInstanceOf[FixedPoint].r)
            val x17878_wr_data7 = List[UInt](block1chunk0("x17812_elem_14").asInstanceOf[FixedPoint].r,block1chunk0("x17813_elem_15").asInstanceOf[FixedPoint].r)
            x17878_wr_data0 ++ x17878_wr_data1 ++ x17878_wr_data2 ++ x17878_wr_data3 ++ x17878_wr_data4 ++ x17878_wr_data5 ++ x17878_wr_data6 ++ x17878_wr_data7
          }
          val x17878_wr_data = create_x17878_wr_data()
          x17748_feature_map_a_0.connectWPort(17878, x17878_wr_banks, x17878_wr_ofs, x17878_wr_data, x17878_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]()
        }
      }
      val block1chunk1: Map[String, Any] = Block1Chunker1.gen()
    }
    val module = Module(new x17879_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x17879_inr_Foreach **/
