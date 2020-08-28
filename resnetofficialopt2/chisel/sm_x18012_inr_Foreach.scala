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

/** Hierarchy: x18012 -> x18013 -> x18367 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x18012_inr_Foreach **/
class x18012_inr_Foreach_kernel(
  list_x17883: List[DecoupledIO[AppLoadData]],
  list_x17881_feature_map_b_0: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x18012_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18012_inr_Foreach_iiCtr"))
  
  abstract class x18012_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x17883 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17883_p").asInstanceOf[(Int, Int)] )))
      val in_x17881_feature_map_b_0 = Flipped(new NBufInterface(ModuleParams.getParams("x17881_feature_map_b_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(16), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x17883 = {io.in_x17883} 
    def x17881_feature_map_b_0 = {io.in_x17881_feature_map_b_0} ; io.in_x17881_feature_map_b_0 := DontCare
  }
  def connectWires0(module: x18012_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x17883 <> x17883
    x17881_feature_map_b_0.connectLedger(module.io.in_x17881_feature_map_b_0)
  }
  val x17883 = list_x17883(0)
  val x17881_feature_map_b_0 = list_x17881_feature_map_b_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18012_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x18012_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18012_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b17898 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b17898.suggestName("b17898")
      val b17899 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b17899.suggestName("b17899")
      val b17900 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b17900.suggestName("b17900")
      val b17901 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b17901.suggestName("b17901")
      val b17902 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b17902.suggestName("b17902")
      val b17903 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b17903.suggestName("b17903")
      val b17904 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b17904.suggestName("b17904")
      val b17905 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b17905.suggestName("b17905")
      val b17906 = io.sigsIn.cchainOutputs.head.counts(8).FP(true, 32, 0); b17906.suggestName("b17906")
      val b17907 = io.sigsIn.cchainOutputs.head.counts(9).FP(true, 32, 0); b17907.suggestName("b17907")
      val b17908 = io.sigsIn.cchainOutputs.head.counts(10).FP(true, 32, 0); b17908.suggestName("b17908")
      val b17909 = io.sigsIn.cchainOutputs.head.counts(11).FP(true, 32, 0); b17909.suggestName("b17909")
      val b17910 = io.sigsIn.cchainOutputs.head.counts(12).FP(true, 32, 0); b17910.suggestName("b17910")
      val b17911 = io.sigsIn.cchainOutputs.head.counts(13).FP(true, 32, 0); b17911.suggestName("b17911")
      val b17912 = io.sigsIn.cchainOutputs.head.counts(14).FP(true, 32, 0); b17912.suggestName("b17912")
      val b17913 = io.sigsIn.cchainOutputs.head.counts(15).FP(true, 32, 0); b17913.suggestName("b17913")
      val b17914 = ~io.sigsIn.cchainOutputs.head.oobs(0); b17914.suggestName("b17914")
      val b17915 = ~io.sigsIn.cchainOutputs.head.oobs(1); b17915.suggestName("b17915")
      val b17916 = ~io.sigsIn.cchainOutputs.head.oobs(2); b17916.suggestName("b17916")
      val b17917 = ~io.sigsIn.cchainOutputs.head.oobs(3); b17917.suggestName("b17917")
      val b17918 = ~io.sigsIn.cchainOutputs.head.oobs(4); b17918.suggestName("b17918")
      val b17919 = ~io.sigsIn.cchainOutputs.head.oobs(5); b17919.suggestName("b17919")
      val b17920 = ~io.sigsIn.cchainOutputs.head.oobs(6); b17920.suggestName("b17920")
      val b17921 = ~io.sigsIn.cchainOutputs.head.oobs(7); b17921.suggestName("b17921")
      val b17922 = ~io.sigsIn.cchainOutputs.head.oobs(8); b17922.suggestName("b17922")
      val b17923 = ~io.sigsIn.cchainOutputs.head.oobs(9); b17923.suggestName("b17923")
      val b17924 = ~io.sigsIn.cchainOutputs.head.oobs(10); b17924.suggestName("b17924")
      val b17925 = ~io.sigsIn.cchainOutputs.head.oobs(11); b17925.suggestName("b17925")
      val b17926 = ~io.sigsIn.cchainOutputs.head.oobs(12); b17926.suggestName("b17926")
      val b17927 = ~io.sigsIn.cchainOutputs.head.oobs(13); b17927.suggestName("b17927")
      val b17928 = ~io.sigsIn.cchainOutputs.head.oobs(14); b17928.suggestName("b17928")
      val b17929 = ~io.sigsIn.cchainOutputs.head.oobs(15); b17929.suggestName("b17929")
      object Block1Chunker0 { // 34 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x17930 = Wire(Vec(16, new FixedPoint(true, 10, 22))).suggestName("""x17930""")
          x17883.ready := b17918 & b17929 & b17919 & b17923 & b17915 & b17921 & b17927 & b17924 & b17916 & b17926 & b17920 & b17914 & b17925 & b17917 & b17928 & b17922 & (io.sigsIn.datapathEn) 
          (0 until 16).map{ i => x17930(i).r := x17883.bits.rdata(i).r }
          val x21897 = Wire(Vec(16, new FixedPoint(true, 10, 22))).suggestName("x21897_x17930_D1") 
          (0 until 16).foreach{i => x21897(i).r := getRetimed(x17930(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x17931_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17931_elem_0""")
          x17931_elem_0.r := x21897(0).r
          val x17932_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17932_elem_1""")
          x17932_elem_1.r := x21897(1).r
          val x17933_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17933_elem_2""")
          x17933_elem_2.r := x21897(2).r
          val x17934_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17934_elem_3""")
          x17934_elem_3.r := x21897(3).r
          val x17935_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17935_elem_4""")
          x17935_elem_4.r := x21897(4).r
          val x17936_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17936_elem_5""")
          x17936_elem_5.r := x21897(5).r
          val x17937_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17937_elem_6""")
          x17937_elem_6.r := x21897(6).r
          val x17938_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17938_elem_7""")
          x17938_elem_7.r := x21897(7).r
          val x17939_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17939_elem_8""")
          x17939_elem_8.r := x21897(8).r
          val x17940_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17940_elem_9""")
          x17940_elem_9.r := x21897(9).r
          val x17941_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17941_elem_10""")
          x17941_elem_10.r := x21897(10).r
          val x17942_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17942_elem_11""")
          x17942_elem_11.r := x21897(11).r
          val x17943_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17943_elem_12""")
          x17943_elem_12.r := x21897(12).r
          val x17944_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17944_elem_13""")
          x17944_elem_13.r := x21897(13).r
          val x17945_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17945_elem_14""")
          x17945_elem_14.r := x21897(14).r
          val x17946_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17946_elem_15""")
          x17946_elem_15.r := x21897(15).r
          val x17963 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17963""")
          x17963.r := Math.arith_right_shift(b17898, 4, Some(0.2), true.B,"x17963").r
          val x17966 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17966""")
          x17966.r := Math.arith_right_shift(b17899, 4, Some(0.2), true.B,"x17966").r
          val x17969 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17969""")
          x17969.r := Math.arith_right_shift(b17900, 4, Some(0.2), true.B,"x17969").r
          val x17972 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17972""")
          x17972.r := Math.arith_right_shift(b17901, 4, Some(0.2), true.B,"x17972").r
          val x17975 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17975""")
          x17975.r := Math.arith_right_shift(b17902, 4, Some(0.2), true.B,"x17975").r
          val x17978 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17978""")
          x17978.r := Math.arith_right_shift(b17903, 4, Some(0.2), true.B,"x17978").r
          val x17981 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17981""")
          x17981.r := Math.arith_right_shift(b17904, 4, Some(0.2), true.B,"x17981").r
          val x17984 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17984""")
          x17984.r := Math.arith_right_shift(b17905, 4, Some(0.2), true.B,"x17984").r
          val x17987 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17987""")
          x17987.r := Math.arith_right_shift(b17906, 4, Some(0.2), true.B,"x17987").r
          val x17990 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17990""")
          x17990.r := Math.arith_right_shift(b17907, 4, Some(0.2), true.B,"x17990").r
          val x17993 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17993""")
          x17993.r := Math.arith_right_shift(b17908, 4, Some(0.2), true.B,"x17993").r
          val x17996 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17996""")
          x17996.r := Math.arith_right_shift(b17909, 4, Some(0.2), true.B,"x17996").r
          val x17999 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17999""")
          x17999.r := Math.arith_right_shift(b17910, 4, Some(0.2), true.B,"x17999").r
          val x18002 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18002""")
          x18002.r := Math.arith_right_shift(b17911, 4, Some(0.2), true.B,"x18002").r
          val x18005 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18005""")
          x18005.r := Math.arith_right_shift(b17912, 4, Some(0.2), true.B,"x18005").r
          val x18008 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18008""")
          x18008.r := Math.arith_right_shift(b17913, 4, Some(0.2), true.B,"x18008").r
          Map[String,Any]("x17931_elem_0" -> x17931_elem_0, "x17932_elem_1" -> x17932_elem_1, "x17933_elem_2" -> x17933_elem_2, "x17934_elem_3" -> x17934_elem_3, "x17935_elem_4" -> x17935_elem_4, "x17936_elem_5" -> x17936_elem_5, "x17937_elem_6" -> x17937_elem_6, "x17938_elem_7" -> x17938_elem_7, "x17939_elem_8" -> x17939_elem_8, "x17940_elem_9" -> x17940_elem_9, "x17941_elem_10" -> x17941_elem_10, "x17942_elem_11" -> x17942_elem_11, "x17943_elem_12" -> x17943_elem_12, "x17944_elem_13" -> x17944_elem_13, "x17945_elem_14" -> x17945_elem_14, "x17946_elem_15" -> x17946_elem_15, "x17963" -> x17963, "x17966" -> x17966, "x17969" -> x17969, "x17972" -> x17972, "x17975" -> x17975, "x17978" -> x17978, "x17981" -> x17981, "x17984" -> x17984, "x17987" -> x17987, "x17990" -> x17990, "x17993" -> x17993, "x17996" -> x17996, "x17999" -> x17999, "x18002" -> x18002, "x18005" -> x18005, "x18008" -> x18008)
        }
      }
      val block1chunk0: Map[String, Any] = Block1Chunker0.gen()
      object Block1Chunker1 { // 33 nodes, 48 weight
        def gen(): Map[String, Any] = {
          val x21898 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21898_x18008_D1") 
          x21898.r := getRetimed(block1chunk0("x18008").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21899 = Wire(Bool()).suggestName("x21899_b17920_D1") 
          x21899.r := getRetimed(b17920.r, 1.toInt, io.sigsIn.backpressure)
          val x21900 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21900_x17969_D1") 
          x21900.r := getRetimed(block1chunk0("x17969").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21901 = Wire(Bool()).suggestName("x21901_b17929_D1") 
          x21901.r := getRetimed(b17929.r, 1.toInt, io.sigsIn.backpressure)
          val x21902 = Wire(Bool()).suggestName("x21902_b17924_D1") 
          x21902.r := getRetimed(b17924.r, 1.toInt, io.sigsIn.backpressure)
          val x21903 = Wire(Bool()).suggestName("x21903_b17925_D1") 
          x21903.r := getRetimed(b17925.r, 1.toInt, io.sigsIn.backpressure)
          val x21904 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21904_x18005_D1") 
          x21904.r := getRetimed(block1chunk0("x18005").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21905 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21905_x17972_D1") 
          x21905.r := getRetimed(block1chunk0("x17972").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21906 = Wire(Bool()).suggestName("x21906_b17928_D1") 
          x21906.r := getRetimed(b17928.r, 1.toInt, io.sigsIn.backpressure)
          val x21907 = Wire(Bool()).suggestName("x21907_b17923_D1") 
          x21907.r := getRetimed(b17923.r, 1.toInt, io.sigsIn.backpressure)
          val x21908 = Wire(Bool()).suggestName("x21908_b17916_D1") 
          x21908.r := getRetimed(b17916.r, 1.toInt, io.sigsIn.backpressure)
          val x21909 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21909_x17966_D1") 
          x21909.r := getRetimed(block1chunk0("x17966").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21910 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21910_x17975_D1") 
          x21910.r := getRetimed(block1chunk0("x17975").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21911 = Wire(Bool()).suggestName("x21911_b17919_D1") 
          x21911.r := getRetimed(b17919.r, 1.toInt, io.sigsIn.backpressure)
          val x21912 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21912_x17999_D1") 
          x21912.r := getRetimed(block1chunk0("x17999").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21913 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21913_x17990_D1") 
          x21913.r := getRetimed(block1chunk0("x17990").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21914 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21914_x17963_D1") 
          x21914.r := getRetimed(block1chunk0("x17963").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21915 = Wire(Bool()).suggestName("x21915_b17915_D1") 
          x21915.r := getRetimed(b17915.r, 1.toInt, io.sigsIn.backpressure)
          val x21916 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21916_x17984_D1") 
          x21916.r := getRetimed(block1chunk0("x17984").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21917 = Wire(Bool()).suggestName("x21917_b17918_D1") 
          x21917.r := getRetimed(b17918.r, 1.toInt, io.sigsIn.backpressure)
          val x21918 = Wire(Bool()).suggestName("x21918_b17914_D1") 
          x21918.r := getRetimed(b17914.r, 1.toInt, io.sigsIn.backpressure)
          val x21919 = Wire(Bool()).suggestName("x21919_b17926_D1") 
          x21919.r := getRetimed(b17926.r, 1.toInt, io.sigsIn.backpressure)
          val x21920 = Wire(Bool()).suggestName("x21920_b17921_D1") 
          x21920.r := getRetimed(b17921.r, 1.toInt, io.sigsIn.backpressure)
          val x21921 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21921_x17981_D1") 
          x21921.r := getRetimed(block1chunk0("x17981").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21922 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21922_x17996_D1") 
          x21922.r := getRetimed(block1chunk0("x17996").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21923 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21923_x17987_D1") 
          x21923.r := getRetimed(block1chunk0("x17987").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21924 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21924_x18002_D1") 
          x21924.r := getRetimed(block1chunk0("x18002").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21925 = Wire(Bool()).suggestName("x21925_b17917_D1") 
          x21925.r := getRetimed(b17917.r, 1.toInt, io.sigsIn.backpressure)
          val x21926 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21926_x17978_D1") 
          x21926.r := getRetimed(block1chunk0("x17978").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21927 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21927_x17993_D1") 
          x21927.r := getRetimed(block1chunk0("x17993").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21928 = Wire(Bool()).suggestName("x21928_b17927_D1") 
          x21928.r := getRetimed(b17927.r, 1.toInt, io.sigsIn.backpressure)
          val x21929 = Wire(Bool()).suggestName("x21929_b17922_D1") 
          x21929.r := getRetimed(b17922.r, 1.toInt, io.sigsIn.backpressure)
          def create_x18011_wr_banks(): List[UInt] = {
            val x18011_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x18011_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x18011_wr_banks0 ++ x18011_wr_banks1
          }
          val x18011_wr_banks = create_x18011_wr_banks()
          def create_x18011_wr_ofs(): List[UInt] = {
            val x18011_wr_ofs0 = List[UInt](x21914.r,x21909.r,x21900.r,x21905.r,x21910.r,x21926.r,x21921.r,x21916.r,x21923.r,x21913.r,x21927.r,x21922.r,x21912.r,x21924.r,x21904.r,x21898.r)
            x18011_wr_ofs0
          }
          val x18011_wr_ofs = create_x18011_wr_ofs()
          val x18011_wr_en = List[Bool](x21918,x21915,x21908,x21925,x21917,x21911,x21899,x21920,x21929,x21907,x21902,x21903,x21919,x21928,x21906,x21901)
          def create_x18011_wr_data(): List[UInt] = {
            val x18011_wr_data0 = List[UInt](block1chunk0("x17931_elem_0").asInstanceOf[FixedPoint].r,block1chunk0("x17932_elem_1").asInstanceOf[FixedPoint].r)
            val x18011_wr_data1 = List[UInt](block1chunk0("x17933_elem_2").asInstanceOf[FixedPoint].r,block1chunk0("x17934_elem_3").asInstanceOf[FixedPoint].r)
            val x18011_wr_data2 = List[UInt](block1chunk0("x17935_elem_4").asInstanceOf[FixedPoint].r,block1chunk0("x17936_elem_5").asInstanceOf[FixedPoint].r)
            val x18011_wr_data3 = List[UInt](block1chunk0("x17937_elem_6").asInstanceOf[FixedPoint].r,block1chunk0("x17938_elem_7").asInstanceOf[FixedPoint].r)
            val x18011_wr_data4 = List[UInt](block1chunk0("x17939_elem_8").asInstanceOf[FixedPoint].r,block1chunk0("x17940_elem_9").asInstanceOf[FixedPoint].r)
            val x18011_wr_data5 = List[UInt](block1chunk0("x17941_elem_10").asInstanceOf[FixedPoint].r,block1chunk0("x17942_elem_11").asInstanceOf[FixedPoint].r)
            val x18011_wr_data6 = List[UInt](block1chunk0("x17943_elem_12").asInstanceOf[FixedPoint].r,block1chunk0("x17944_elem_13").asInstanceOf[FixedPoint].r)
            val x18011_wr_data7 = List[UInt](block1chunk0("x17945_elem_14").asInstanceOf[FixedPoint].r,block1chunk0("x17946_elem_15").asInstanceOf[FixedPoint].r)
            x18011_wr_data0 ++ x18011_wr_data1 ++ x18011_wr_data2 ++ x18011_wr_data3 ++ x18011_wr_data4 ++ x18011_wr_data5 ++ x18011_wr_data6 ++ x18011_wr_data7
          }
          val x18011_wr_data = create_x18011_wr_data()
          x17881_feature_map_b_0.connectWPort(18011, x18011_wr_banks, x18011_wr_ofs, x18011_wr_data, x18011_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]()
        }
      }
      val block1chunk1: Map[String, Any] = Block1Chunker1.gen()
    }
    val module = Module(new x18012_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x18012_inr_Foreach **/
