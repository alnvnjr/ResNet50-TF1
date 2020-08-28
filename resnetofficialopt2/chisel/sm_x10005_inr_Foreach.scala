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

/** Hierarchy: x10005 -> x10006 -> x17297 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x10005_inr_Foreach **/
class x10005_inr_Foreach_kernel(
  list_x9868: List[DecoupledIO[AppLoadData]],
  list_x9855_in_buffer_1: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x10005_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x10005_inr_Foreach_iiCtr"))
  
  abstract class x10005_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9855_in_buffer_1 = Flipped(new NBufInterface(ModuleParams.getParams("x9855_in_buffer_1_p").asInstanceOf[NBufParams] ))
      val in_x9854_in_buffer_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9854_in_buffer_0_p").asInstanceOf[NBufParams] ))
      val in_x9860_in_buffer_6 = Flipped(new NBufInterface(ModuleParams.getParams("x9860_in_buffer_6_p").asInstanceOf[NBufParams] ))
      val in_x9861_in_buffer_7 = Flipped(new NBufInterface(ModuleParams.getParams("x9861_in_buffer_7_p").asInstanceOf[NBufParams] ))
      val in_x9868 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9868_p").asInstanceOf[(Int, Int)] )))
      val in_x9857_in_buffer_3 = Flipped(new NBufInterface(ModuleParams.getParams("x9857_in_buffer_3_p").asInstanceOf[NBufParams] ))
      val in_x9858_in_buffer_4 = Flipped(new NBufInterface(ModuleParams.getParams("x9858_in_buffer_4_p").asInstanceOf[NBufParams] ))
      val in_x9856_in_buffer_2 = Flipped(new NBufInterface(ModuleParams.getParams("x9856_in_buffer_2_p").asInstanceOf[NBufParams] ))
      val in_x9859_in_buffer_5 = Flipped(new NBufInterface(ModuleParams.getParams("x9859_in_buffer_5_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(16), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9855_in_buffer_1 = {io.in_x9855_in_buffer_1} ; io.in_x9855_in_buffer_1 := DontCare
    def x9854_in_buffer_0 = {io.in_x9854_in_buffer_0} ; io.in_x9854_in_buffer_0 := DontCare
    def x9860_in_buffer_6 = {io.in_x9860_in_buffer_6} ; io.in_x9860_in_buffer_6 := DontCare
    def x9861_in_buffer_7 = {io.in_x9861_in_buffer_7} ; io.in_x9861_in_buffer_7 := DontCare
    def x9868 = {io.in_x9868} 
    def x9857_in_buffer_3 = {io.in_x9857_in_buffer_3} ; io.in_x9857_in_buffer_3 := DontCare
    def x9858_in_buffer_4 = {io.in_x9858_in_buffer_4} ; io.in_x9858_in_buffer_4 := DontCare
    def x9856_in_buffer_2 = {io.in_x9856_in_buffer_2} ; io.in_x9856_in_buffer_2 := DontCare
    def x9859_in_buffer_5 = {io.in_x9859_in_buffer_5} ; io.in_x9859_in_buffer_5 := DontCare
  }
  def connectWires0(module: x10005_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x9855_in_buffer_1.connectLedger(module.io.in_x9855_in_buffer_1)
    x9854_in_buffer_0.connectLedger(module.io.in_x9854_in_buffer_0)
    x9860_in_buffer_6.connectLedger(module.io.in_x9860_in_buffer_6)
    x9861_in_buffer_7.connectLedger(module.io.in_x9861_in_buffer_7)
    module.io.in_x9868 <> x9868
    x9857_in_buffer_3.connectLedger(module.io.in_x9857_in_buffer_3)
    x9858_in_buffer_4.connectLedger(module.io.in_x9858_in_buffer_4)
    x9856_in_buffer_2.connectLedger(module.io.in_x9856_in_buffer_2)
    x9859_in_buffer_5.connectLedger(module.io.in_x9859_in_buffer_5)
  }
  val x9868 = list_x9868(0)
  val x9855_in_buffer_1 = list_x9855_in_buffer_1(0)
  val x9854_in_buffer_0 = list_x9855_in_buffer_1(1)
  val x9860_in_buffer_6 = list_x9855_in_buffer_1(2)
  val x9861_in_buffer_7 = list_x9855_in_buffer_1(3)
  val x9857_in_buffer_3 = list_x9855_in_buffer_1(4)
  val x9858_in_buffer_4 = list_x9855_in_buffer_1(5)
  val x9856_in_buffer_2 = list_x9855_in_buffer_1(6)
  val x9859_in_buffer_5 = list_x9855_in_buffer_1(7)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x10005_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x10005_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x10005_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b9884 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b9884.suggestName("b9884")
      val b9885 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b9885.suggestName("b9885")
      val b9886 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b9886.suggestName("b9886")
      val b9887 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b9887.suggestName("b9887")
      val b9888 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b9888.suggestName("b9888")
      val b9889 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b9889.suggestName("b9889")
      val b9890 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b9890.suggestName("b9890")
      val b9891 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b9891.suggestName("b9891")
      val b9892 = io.sigsIn.cchainOutputs.head.counts(8).FP(true, 32, 0); b9892.suggestName("b9892")
      val b9893 = io.sigsIn.cchainOutputs.head.counts(9).FP(true, 32, 0); b9893.suggestName("b9893")
      val b9894 = io.sigsIn.cchainOutputs.head.counts(10).FP(true, 32, 0); b9894.suggestName("b9894")
      val b9895 = io.sigsIn.cchainOutputs.head.counts(11).FP(true, 32, 0); b9895.suggestName("b9895")
      val b9896 = io.sigsIn.cchainOutputs.head.counts(12).FP(true, 32, 0); b9896.suggestName("b9896")
      val b9897 = io.sigsIn.cchainOutputs.head.counts(13).FP(true, 32, 0); b9897.suggestName("b9897")
      val b9898 = io.sigsIn.cchainOutputs.head.counts(14).FP(true, 32, 0); b9898.suggestName("b9898")
      val b9899 = io.sigsIn.cchainOutputs.head.counts(15).FP(true, 32, 0); b9899.suggestName("b9899")
      val b9900 = ~io.sigsIn.cchainOutputs.head.oobs(0); b9900.suggestName("b9900")
      val b9901 = ~io.sigsIn.cchainOutputs.head.oobs(1); b9901.suggestName("b9901")
      val b9902 = ~io.sigsIn.cchainOutputs.head.oobs(2); b9902.suggestName("b9902")
      val b9903 = ~io.sigsIn.cchainOutputs.head.oobs(3); b9903.suggestName("b9903")
      val b9904 = ~io.sigsIn.cchainOutputs.head.oobs(4); b9904.suggestName("b9904")
      val b9905 = ~io.sigsIn.cchainOutputs.head.oobs(5); b9905.suggestName("b9905")
      val b9906 = ~io.sigsIn.cchainOutputs.head.oobs(6); b9906.suggestName("b9906")
      val b9907 = ~io.sigsIn.cchainOutputs.head.oobs(7); b9907.suggestName("b9907")
      val b9908 = ~io.sigsIn.cchainOutputs.head.oobs(8); b9908.suggestName("b9908")
      val b9909 = ~io.sigsIn.cchainOutputs.head.oobs(9); b9909.suggestName("b9909")
      val b9910 = ~io.sigsIn.cchainOutputs.head.oobs(10); b9910.suggestName("b9910")
      val b9911 = ~io.sigsIn.cchainOutputs.head.oobs(11); b9911.suggestName("b9911")
      val b9912 = ~io.sigsIn.cchainOutputs.head.oobs(12); b9912.suggestName("b9912")
      val b9913 = ~io.sigsIn.cchainOutputs.head.oobs(13); b9913.suggestName("b9913")
      val b9914 = ~io.sigsIn.cchainOutputs.head.oobs(14); b9914.suggestName("b9914")
      val b9915 = ~io.sigsIn.cchainOutputs.head.oobs(15); b9915.suggestName("b9915")
      object Block3Chunker0 { // 34 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x9916 = Wire(Vec(16, new FixedPoint(true, 10, 22))).suggestName("""x9916""")
          x9868.ready := b9910 & b9909 & b9908 & b9915 & b9904 & b9911 & b9900 & b9912 & b9907 & b9902 & b9905 & b9913 & b9901 & b9906 & b9914 & b9903 & (io.sigsIn.datapathEn) 
          (0 until 16).map{ i => x9916(i).r := x9868.bits.rdata(i).r }
          val x20713 = Wire(Vec(16, new FixedPoint(true, 10, 22))).suggestName("x20713_x9916_D1") 
          (0 until 16).foreach{i => x20713(i).r := getRetimed(x9916(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9917_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9917_elem_0""")
          x9917_elem_0.r := x20713(0).r
          val x9918_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9918_elem_1""")
          x9918_elem_1.r := x20713(1).r
          val x9919_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9919_elem_2""")
          x9919_elem_2.r := x20713(2).r
          val x9920_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9920_elem_3""")
          x9920_elem_3.r := x20713(3).r
          val x9921_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9921_elem_4""")
          x9921_elem_4.r := x20713(4).r
          val x9922_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9922_elem_5""")
          x9922_elem_5.r := x20713(5).r
          val x9923_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9923_elem_6""")
          x9923_elem_6.r := x20713(6).r
          val x9924_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9924_elem_7""")
          x9924_elem_7.r := x20713(7).r
          val x9925_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9925_elem_8""")
          x9925_elem_8.r := x20713(8).r
          val x9926_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9926_elem_9""")
          x9926_elem_9.r := x20713(9).r
          val x9927_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9927_elem_10""")
          x9927_elem_10.r := x20713(10).r
          val x9928_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9928_elem_11""")
          x9928_elem_11.r := x20713(11).r
          val x9929_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9929_elem_12""")
          x9929_elem_12.r := x20713(12).r
          val x9930_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9930_elem_13""")
          x9930_elem_13.r := x20713(13).r
          val x9931_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9931_elem_14""")
          x9931_elem_14.r := x20713(14).r
          val x9932_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9932_elem_15""")
          x9932_elem_15.r := x20713(15).r
          val x9949 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9949""")
          x9949.r := Math.arith_right_shift(b9884, 4, Some(0.2), true.B,"x9949").r
          val x9952 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9952""")
          x9952.r := Math.arith_right_shift(b9885, 4, Some(0.2), true.B,"x9952").r
          val x9955 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9955""")
          x9955.r := Math.arith_right_shift(b9886, 4, Some(0.2), true.B,"x9955").r
          val x9958 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9958""")
          x9958.r := Math.arith_right_shift(b9887, 4, Some(0.2), true.B,"x9958").r
          val x9961 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9961""")
          x9961.r := Math.arith_right_shift(b9888, 4, Some(0.2), true.B,"x9961").r
          val x9964 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9964""")
          x9964.r := Math.arith_right_shift(b9889, 4, Some(0.2), true.B,"x9964").r
          val x9967 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9967""")
          x9967.r := Math.arith_right_shift(b9890, 4, Some(0.2), true.B,"x9967").r
          val x9970 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9970""")
          x9970.r := Math.arith_right_shift(b9891, 4, Some(0.2), true.B,"x9970").r
          val x9973 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9973""")
          x9973.r := Math.arith_right_shift(b9892, 4, Some(0.2), true.B,"x9973").r
          val x9976 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9976""")
          x9976.r := Math.arith_right_shift(b9893, 4, Some(0.2), true.B,"x9976").r
          val x9979 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9979""")
          x9979.r := Math.arith_right_shift(b9894, 4, Some(0.2), true.B,"x9979").r
          val x9982 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9982""")
          x9982.r := Math.arith_right_shift(b9895, 4, Some(0.2), true.B,"x9982").r
          val x9985 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9985""")
          x9985.r := Math.arith_right_shift(b9896, 4, Some(0.2), true.B,"x9985").r
          val x9988 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9988""")
          x9988.r := Math.arith_right_shift(b9897, 4, Some(0.2), true.B,"x9988").r
          val x9991 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9991""")
          x9991.r := Math.arith_right_shift(b9898, 4, Some(0.2), true.B,"x9991").r
          val x9994 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9994""")
          x9994.r := Math.arith_right_shift(b9899, 4, Some(0.2), true.B,"x9994").r
          Map[String,Any]("x9917_elem_0" -> x9917_elem_0, "x9918_elem_1" -> x9918_elem_1, "x9919_elem_2" -> x9919_elem_2, "x9920_elem_3" -> x9920_elem_3, "x9921_elem_4" -> x9921_elem_4, "x9922_elem_5" -> x9922_elem_5, "x9923_elem_6" -> x9923_elem_6, "x9924_elem_7" -> x9924_elem_7, "x9925_elem_8" -> x9925_elem_8, "x9926_elem_9" -> x9926_elem_9, "x9927_elem_10" -> x9927_elem_10, "x9928_elem_11" -> x9928_elem_11, "x9929_elem_12" -> x9929_elem_12, "x9930_elem_13" -> x9930_elem_13, "x9931_elem_14" -> x9931_elem_14, "x9932_elem_15" -> x9932_elem_15, "x9949" -> x9949, "x9952" -> x9952, "x9955" -> x9955, "x9958" -> x9958, "x9961" -> x9961, "x9964" -> x9964, "x9967" -> x9967, "x9970" -> x9970, "x9973" -> x9973, "x9976" -> x9976, "x9979" -> x9979, "x9982" -> x9982, "x9985" -> x9985, "x9988" -> x9988, "x9991" -> x9991, "x9994" -> x9994)
        }
      }
      val block3chunk0: Map[String, Any] = Block3Chunker0.gen()
      object Block3Chunker1 { // 33 nodes, 48 weight
        def gen(): Map[String, Any] = {
          val x20714 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20714_x9982_D1") 
          x20714.r := getRetimed(block3chunk0("x9982").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20715 = Wire(Bool()).suggestName("x20715_b9907_D1") 
          x20715.r := getRetimed(b9907.r, 1.toInt, io.sigsIn.backpressure)
          val x20716 = Wire(Bool()).suggestName("x20716_b9901_D1") 
          x20716.r := getRetimed(b9901.r, 1.toInt, io.sigsIn.backpressure)
          val x20717 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20717_x9961_D1") 
          x20717.r := getRetimed(block3chunk0("x9961").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20718 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20718_x9994_D1") 
          x20718.r := getRetimed(block3chunk0("x9994").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20719 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20719_x9988_D1") 
          x20719.r := getRetimed(block3chunk0("x9988").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20720 = Wire(Bool()).suggestName("x20720_b9909_D1") 
          x20720.r := getRetimed(b9909.r, 1.toInt, io.sigsIn.backpressure)
          val x20721 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20721_x9973_D1") 
          x20721.r := getRetimed(block3chunk0("x9973").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20722 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20722_x9970_D1") 
          x20722.r := getRetimed(block3chunk0("x9970").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20723 = Wire(Bool()).suggestName("x20723_b9914_D1") 
          x20723.r := getRetimed(b9914.r, 1.toInt, io.sigsIn.backpressure)
          val x20724 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20724_x9949_D1") 
          x20724.r := getRetimed(block3chunk0("x9949").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20725 = Wire(Bool()).suggestName("x20725_b9904_D1") 
          x20725.r := getRetimed(b9904.r, 1.toInt, io.sigsIn.backpressure)
          val x20726 = Wire(Bool()).suggestName("x20726_b9910_D1") 
          x20726.r := getRetimed(b9910.r, 1.toInt, io.sigsIn.backpressure)
          val x20727 = Wire(Bool()).suggestName("x20727_b9900_D1") 
          x20727.r := getRetimed(b9900.r, 1.toInt, io.sigsIn.backpressure)
          val x20728 = Wire(Bool()).suggestName("x20728_b9913_D1") 
          x20728.r := getRetimed(b9913.r, 1.toInt, io.sigsIn.backpressure)
          val x20729 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20729_x9964_D1") 
          x20729.r := getRetimed(block3chunk0("x9964").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20730 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20730_x9985_D1") 
          x20730.r := getRetimed(block3chunk0("x9985").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20731 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20731_x9952_D1") 
          x20731.r := getRetimed(block3chunk0("x9952").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20732 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20732_x9967_D1") 
          x20732.r := getRetimed(block3chunk0("x9967").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20733 = Wire(Bool()).suggestName("x20733_b9903_D1") 
          x20733.r := getRetimed(b9903.r, 1.toInt, io.sigsIn.backpressure)
          val x20734 = Wire(Bool()).suggestName("x20734_b9905_D1") 
          x20734.r := getRetimed(b9905.r, 1.toInt, io.sigsIn.backpressure)
          val x20735 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20735_x9958_D1") 
          x20735.r := getRetimed(block3chunk0("x9958").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20736 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20736_x9991_D1") 
          x20736.r := getRetimed(block3chunk0("x9991").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20737 = Wire(Bool()).suggestName("x20737_b9911_D1") 
          x20737.r := getRetimed(b9911.r, 1.toInt, io.sigsIn.backpressure)
          val x20738 = Wire(Bool()).suggestName("x20738_b9902_D1") 
          x20738.r := getRetimed(b9902.r, 1.toInt, io.sigsIn.backpressure)
          val x20739 = Wire(Bool()).suggestName("x20739_b9912_D1") 
          x20739.r := getRetimed(b9912.r, 1.toInt, io.sigsIn.backpressure)
          val x20740 = Wire(Bool()).suggestName("x20740_b9906_D1") 
          x20740.r := getRetimed(b9906.r, 1.toInt, io.sigsIn.backpressure)
          val x20741 = Wire(Bool()).suggestName("x20741_b9908_D1") 
          x20741.r := getRetimed(b9908.r, 1.toInt, io.sigsIn.backpressure)
          val x20742 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20742_x9955_D1") 
          x20742.r := getRetimed(block3chunk0("x9955").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20743 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20743_x9976_D1") 
          x20743.r := getRetimed(block3chunk0("x9976").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20744 = Wire(Bool()).suggestName("x20744_b9915_D1") 
          x20744.r := getRetimed(b9915.r, 1.toInt, io.sigsIn.backpressure)
          val x20745 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20745_x9979_D1") 
          x20745.r := getRetimed(block3chunk0("x9979").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          def create_x9997_wr_banks(): List[UInt] = {
            val x9997_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x9997_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x9997_wr_banks0 ++ x9997_wr_banks1
          }
          val x9997_wr_banks = create_x9997_wr_banks()
          def create_x9997_wr_ofs(): List[UInt] = {
            val x9997_wr_ofs0 = List[UInt](x20724.r,x20731.r,x20742.r,x20735.r,x20717.r,x20729.r,x20732.r,x20722.r,x20721.r,x20743.r,x20745.r,x20714.r,x20730.r,x20719.r,x20736.r,x20718.r)
            x9997_wr_ofs0
          }
          val x9997_wr_ofs = create_x9997_wr_ofs()
          val x9997_wr_en = List[Bool](x20727,x20716,x20738,x20733,x20725,x20734,x20740,x20715,x20741,x20720,x20726,x20737,x20739,x20728,x20723,x20744)
          def create_x9997_wr_data(): List[UInt] = {
            val x9997_wr_data0 = List[UInt](block3chunk0("x9917_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x9918_elem_1").asInstanceOf[FixedPoint].r)
            val x9997_wr_data1 = List[UInt](block3chunk0("x9919_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x9920_elem_3").asInstanceOf[FixedPoint].r)
            val x9997_wr_data2 = List[UInt](block3chunk0("x9921_elem_4").asInstanceOf[FixedPoint].r,block3chunk0("x9922_elem_5").asInstanceOf[FixedPoint].r)
            val x9997_wr_data3 = List[UInt](block3chunk0("x9923_elem_6").asInstanceOf[FixedPoint].r,block3chunk0("x9924_elem_7").asInstanceOf[FixedPoint].r)
            val x9997_wr_data4 = List[UInt](block3chunk0("x9925_elem_8").asInstanceOf[FixedPoint].r,block3chunk0("x9926_elem_9").asInstanceOf[FixedPoint].r)
            val x9997_wr_data5 = List[UInt](block3chunk0("x9927_elem_10").asInstanceOf[FixedPoint].r,block3chunk0("x9928_elem_11").asInstanceOf[FixedPoint].r)
            val x9997_wr_data6 = List[UInt](block3chunk0("x9929_elem_12").asInstanceOf[FixedPoint].r,block3chunk0("x9930_elem_13").asInstanceOf[FixedPoint].r)
            val x9997_wr_data7 = List[UInt](block3chunk0("x9931_elem_14").asInstanceOf[FixedPoint].r,block3chunk0("x9932_elem_15").asInstanceOf[FixedPoint].r)
            x9997_wr_data0 ++ x9997_wr_data1 ++ x9997_wr_data2 ++ x9997_wr_data3 ++ x9997_wr_data4 ++ x9997_wr_data5 ++ x9997_wr_data6 ++ x9997_wr_data7
          }
          val x9997_wr_data = create_x9997_wr_data()
          x9855_in_buffer_1.connectWPort(9997, x9997_wr_banks, x9997_wr_ofs, x9997_wr_data, x9997_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]("x20714" -> x20714, "x20715" -> x20715, "x20716" -> x20716, "x20717" -> x20717, "x20718" -> x20718, "x20719" -> x20719, "x20720" -> x20720, "x20721" -> x20721, "x20722" -> x20722, "x20723" -> x20723, "x20724" -> x20724, "x20725" -> x20725, "x20726" -> x20726, "x20727" -> x20727, "x20728" -> x20728, "x20729" -> x20729, "x20730" -> x20730, "x20731" -> x20731, "x20732" -> x20732, "x20733" -> x20733, "x20734" -> x20734, "x20735" -> x20735, "x20736" -> x20736, "x20737" -> x20737, "x20738" -> x20738, "x20739" -> x20739, "x20740" -> x20740, "x20741" -> x20741, "x20742" -> x20742, "x20743" -> x20743, "x20744" -> x20744, "x20745" -> x20745)
        }
      }
      val block3chunk1: Map[String, Any] = Block3Chunker1.gen()
      object Block3Chunker2 { // 3 nodes, 48 weight
        def gen(): Map[String, Any] = {
          def create_x9998_wr_banks(): List[UInt] = {
            val x9998_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x9998_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x9998_wr_banks0 ++ x9998_wr_banks1
          }
          val x9998_wr_banks = create_x9998_wr_banks()
          def create_x9998_wr_ofs(): List[UInt] = {
            val x9998_wr_ofs0 = List[UInt](block3chunk1("x20724").asInstanceOf[FixedPoint].r,block3chunk1("x20731").asInstanceOf[FixedPoint].r,block3chunk1("x20742").asInstanceOf[FixedPoint].r)
            val x9998_wr_ofs1 = List[UInt](block3chunk1("x20735").asInstanceOf[FixedPoint].r,block3chunk1("x20717").asInstanceOf[FixedPoint].r,block3chunk1("x20729").asInstanceOf[FixedPoint].r)
            val x9998_wr_ofs2 = List[UInt](block3chunk1("x20732").asInstanceOf[FixedPoint].r,block3chunk1("x20722").asInstanceOf[FixedPoint].r,block3chunk1("x20721").asInstanceOf[FixedPoint].r)
            val x9998_wr_ofs3 = List[UInt](block3chunk1("x20743").asInstanceOf[FixedPoint].r,block3chunk1("x20745").asInstanceOf[FixedPoint].r,block3chunk1("x20714").asInstanceOf[FixedPoint].r)
            val x9998_wr_ofs4 = List[UInt](block3chunk1("x20730").asInstanceOf[FixedPoint].r,block3chunk1("x20719").asInstanceOf[FixedPoint].r,block3chunk1("x20736").asInstanceOf[FixedPoint].r)
            val x9998_wr_ofs5 = List[UInt](block3chunk1("x20718").asInstanceOf[FixedPoint].r)
            x9998_wr_ofs0 ++ x9998_wr_ofs1 ++ x9998_wr_ofs2 ++ x9998_wr_ofs3 ++ x9998_wr_ofs4 ++ x9998_wr_ofs5
          }
          val x9998_wr_ofs = create_x9998_wr_ofs()
          def create_x9998_wr_en(): List[Bool] = {
            val x9998_wr_en0 = List[Bool](block3chunk1("x20727").asInstanceOf[Bool],block3chunk1("x20716").asInstanceOf[Bool],block3chunk1("x20738").asInstanceOf[Bool],block3chunk1("x20733").asInstanceOf[Bool])
            val x9998_wr_en1 = List[Bool](block3chunk1("x20725").asInstanceOf[Bool],block3chunk1("x20734").asInstanceOf[Bool],block3chunk1("x20740").asInstanceOf[Bool],block3chunk1("x20715").asInstanceOf[Bool])
            val x9998_wr_en2 = List[Bool](block3chunk1("x20741").asInstanceOf[Bool],block3chunk1("x20720").asInstanceOf[Bool],block3chunk1("x20726").asInstanceOf[Bool],block3chunk1("x20737").asInstanceOf[Bool])
            val x9998_wr_en3 = List[Bool](block3chunk1("x20739").asInstanceOf[Bool],block3chunk1("x20728").asInstanceOf[Bool],block3chunk1("x20723").asInstanceOf[Bool],block3chunk1("x20744").asInstanceOf[Bool])
            x9998_wr_en0 ++ x9998_wr_en1 ++ x9998_wr_en2 ++ x9998_wr_en3
          }
          val x9998_wr_en = create_x9998_wr_en()
          def create_x9998_wr_data(): List[UInt] = {
            val x9998_wr_data0 = List[UInt](block3chunk0("x9917_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x9918_elem_1").asInstanceOf[FixedPoint].r)
            val x9998_wr_data1 = List[UInt](block3chunk0("x9919_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x9920_elem_3").asInstanceOf[FixedPoint].r)
            val x9998_wr_data2 = List[UInt](block3chunk0("x9921_elem_4").asInstanceOf[FixedPoint].r,block3chunk0("x9922_elem_5").asInstanceOf[FixedPoint].r)
            val x9998_wr_data3 = List[UInt](block3chunk0("x9923_elem_6").asInstanceOf[FixedPoint].r,block3chunk0("x9924_elem_7").asInstanceOf[FixedPoint].r)
            val x9998_wr_data4 = List[UInt](block3chunk0("x9925_elem_8").asInstanceOf[FixedPoint].r,block3chunk0("x9926_elem_9").asInstanceOf[FixedPoint].r)
            val x9998_wr_data5 = List[UInt](block3chunk0("x9927_elem_10").asInstanceOf[FixedPoint].r,block3chunk0("x9928_elem_11").asInstanceOf[FixedPoint].r)
            val x9998_wr_data6 = List[UInt](block3chunk0("x9929_elem_12").asInstanceOf[FixedPoint].r,block3chunk0("x9930_elem_13").asInstanceOf[FixedPoint].r)
            val x9998_wr_data7 = List[UInt](block3chunk0("x9931_elem_14").asInstanceOf[FixedPoint].r,block3chunk0("x9932_elem_15").asInstanceOf[FixedPoint].r)
            x9998_wr_data0 ++ x9998_wr_data1 ++ x9998_wr_data2 ++ x9998_wr_data3 ++ x9998_wr_data4 ++ x9998_wr_data5 ++ x9998_wr_data6 ++ x9998_wr_data7
          }
          val x9998_wr_data = create_x9998_wr_data()
          x9854_in_buffer_0.connectWPort(9998, x9998_wr_banks, x9998_wr_ofs, x9998_wr_data, x9998_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x9999_wr_banks(): List[UInt] = {
            val x9999_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x9999_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x9999_wr_banks0 ++ x9999_wr_banks1
          }
          val x9999_wr_banks = create_x9999_wr_banks()
          def create_x9999_wr_ofs(): List[UInt] = {
            val x9999_wr_ofs0 = List[UInt](block3chunk1("x20724").asInstanceOf[FixedPoint].r,block3chunk1("x20731").asInstanceOf[FixedPoint].r,block3chunk1("x20742").asInstanceOf[FixedPoint].r)
            val x9999_wr_ofs1 = List[UInt](block3chunk1("x20735").asInstanceOf[FixedPoint].r,block3chunk1("x20717").asInstanceOf[FixedPoint].r,block3chunk1("x20729").asInstanceOf[FixedPoint].r)
            val x9999_wr_ofs2 = List[UInt](block3chunk1("x20732").asInstanceOf[FixedPoint].r,block3chunk1("x20722").asInstanceOf[FixedPoint].r,block3chunk1("x20721").asInstanceOf[FixedPoint].r)
            val x9999_wr_ofs3 = List[UInt](block3chunk1("x20743").asInstanceOf[FixedPoint].r,block3chunk1("x20745").asInstanceOf[FixedPoint].r,block3chunk1("x20714").asInstanceOf[FixedPoint].r)
            val x9999_wr_ofs4 = List[UInt](block3chunk1("x20730").asInstanceOf[FixedPoint].r,block3chunk1("x20719").asInstanceOf[FixedPoint].r,block3chunk1("x20736").asInstanceOf[FixedPoint].r)
            val x9999_wr_ofs5 = List[UInt](block3chunk1("x20718").asInstanceOf[FixedPoint].r)
            x9999_wr_ofs0 ++ x9999_wr_ofs1 ++ x9999_wr_ofs2 ++ x9999_wr_ofs3 ++ x9999_wr_ofs4 ++ x9999_wr_ofs5
          }
          val x9999_wr_ofs = create_x9999_wr_ofs()
          def create_x9999_wr_en(): List[Bool] = {
            val x9999_wr_en0 = List[Bool](block3chunk1("x20727").asInstanceOf[Bool],block3chunk1("x20716").asInstanceOf[Bool],block3chunk1("x20738").asInstanceOf[Bool],block3chunk1("x20733").asInstanceOf[Bool])
            val x9999_wr_en1 = List[Bool](block3chunk1("x20725").asInstanceOf[Bool],block3chunk1("x20734").asInstanceOf[Bool],block3chunk1("x20740").asInstanceOf[Bool],block3chunk1("x20715").asInstanceOf[Bool])
            val x9999_wr_en2 = List[Bool](block3chunk1("x20741").asInstanceOf[Bool],block3chunk1("x20720").asInstanceOf[Bool],block3chunk1("x20726").asInstanceOf[Bool],block3chunk1("x20737").asInstanceOf[Bool])
            val x9999_wr_en3 = List[Bool](block3chunk1("x20739").asInstanceOf[Bool],block3chunk1("x20728").asInstanceOf[Bool],block3chunk1("x20723").asInstanceOf[Bool],block3chunk1("x20744").asInstanceOf[Bool])
            x9999_wr_en0 ++ x9999_wr_en1 ++ x9999_wr_en2 ++ x9999_wr_en3
          }
          val x9999_wr_en = create_x9999_wr_en()
          def create_x9999_wr_data(): List[UInt] = {
            val x9999_wr_data0 = List[UInt](block3chunk0("x9917_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x9918_elem_1").asInstanceOf[FixedPoint].r)
            val x9999_wr_data1 = List[UInt](block3chunk0("x9919_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x9920_elem_3").asInstanceOf[FixedPoint].r)
            val x9999_wr_data2 = List[UInt](block3chunk0("x9921_elem_4").asInstanceOf[FixedPoint].r,block3chunk0("x9922_elem_5").asInstanceOf[FixedPoint].r)
            val x9999_wr_data3 = List[UInt](block3chunk0("x9923_elem_6").asInstanceOf[FixedPoint].r,block3chunk0("x9924_elem_7").asInstanceOf[FixedPoint].r)
            val x9999_wr_data4 = List[UInt](block3chunk0("x9925_elem_8").asInstanceOf[FixedPoint].r,block3chunk0("x9926_elem_9").asInstanceOf[FixedPoint].r)
            val x9999_wr_data5 = List[UInt](block3chunk0("x9927_elem_10").asInstanceOf[FixedPoint].r,block3chunk0("x9928_elem_11").asInstanceOf[FixedPoint].r)
            val x9999_wr_data6 = List[UInt](block3chunk0("x9929_elem_12").asInstanceOf[FixedPoint].r,block3chunk0("x9930_elem_13").asInstanceOf[FixedPoint].r)
            val x9999_wr_data7 = List[UInt](block3chunk0("x9931_elem_14").asInstanceOf[FixedPoint].r,block3chunk0("x9932_elem_15").asInstanceOf[FixedPoint].r)
            x9999_wr_data0 ++ x9999_wr_data1 ++ x9999_wr_data2 ++ x9999_wr_data3 ++ x9999_wr_data4 ++ x9999_wr_data5 ++ x9999_wr_data6 ++ x9999_wr_data7
          }
          val x9999_wr_data = create_x9999_wr_data()
          x9860_in_buffer_6.connectWPort(9999, x9999_wr_banks, x9999_wr_ofs, x9999_wr_data, x9999_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x10000_wr_banks(): List[UInt] = {
            val x10000_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x10000_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x10000_wr_banks0 ++ x10000_wr_banks1
          }
          val x10000_wr_banks = create_x10000_wr_banks()
          def create_x10000_wr_ofs(): List[UInt] = {
            val x10000_wr_ofs0 = List[UInt](block3chunk1("x20724").asInstanceOf[FixedPoint].r,block3chunk1("x20731").asInstanceOf[FixedPoint].r,block3chunk1("x20742").asInstanceOf[FixedPoint].r)
            val x10000_wr_ofs1 = List[UInt](block3chunk1("x20735").asInstanceOf[FixedPoint].r,block3chunk1("x20717").asInstanceOf[FixedPoint].r,block3chunk1("x20729").asInstanceOf[FixedPoint].r)
            val x10000_wr_ofs2 = List[UInt](block3chunk1("x20732").asInstanceOf[FixedPoint].r,block3chunk1("x20722").asInstanceOf[FixedPoint].r,block3chunk1("x20721").asInstanceOf[FixedPoint].r)
            val x10000_wr_ofs3 = List[UInt](block3chunk1("x20743").asInstanceOf[FixedPoint].r,block3chunk1("x20745").asInstanceOf[FixedPoint].r,block3chunk1("x20714").asInstanceOf[FixedPoint].r)
            val x10000_wr_ofs4 = List[UInt](block3chunk1("x20730").asInstanceOf[FixedPoint].r,block3chunk1("x20719").asInstanceOf[FixedPoint].r,block3chunk1("x20736").asInstanceOf[FixedPoint].r)
            val x10000_wr_ofs5 = List[UInt](block3chunk1("x20718").asInstanceOf[FixedPoint].r)
            x10000_wr_ofs0 ++ x10000_wr_ofs1 ++ x10000_wr_ofs2 ++ x10000_wr_ofs3 ++ x10000_wr_ofs4 ++ x10000_wr_ofs5
          }
          val x10000_wr_ofs = create_x10000_wr_ofs()
          def create_x10000_wr_en(): List[Bool] = {
            val x10000_wr_en0 = List[Bool](block3chunk1("x20727").asInstanceOf[Bool],block3chunk1("x20716").asInstanceOf[Bool],block3chunk1("x20738").asInstanceOf[Bool],block3chunk1("x20733").asInstanceOf[Bool])
            val x10000_wr_en1 = List[Bool](block3chunk1("x20725").asInstanceOf[Bool],block3chunk1("x20734").asInstanceOf[Bool],block3chunk1("x20740").asInstanceOf[Bool],block3chunk1("x20715").asInstanceOf[Bool])
            val x10000_wr_en2 = List[Bool](block3chunk1("x20741").asInstanceOf[Bool],block3chunk1("x20720").asInstanceOf[Bool],block3chunk1("x20726").asInstanceOf[Bool],block3chunk1("x20737").asInstanceOf[Bool])
            val x10000_wr_en3 = List[Bool](block3chunk1("x20739").asInstanceOf[Bool],block3chunk1("x20728").asInstanceOf[Bool],block3chunk1("x20723").asInstanceOf[Bool],block3chunk1("x20744").asInstanceOf[Bool])
            x10000_wr_en0 ++ x10000_wr_en1 ++ x10000_wr_en2 ++ x10000_wr_en3
          }
          val x10000_wr_en = create_x10000_wr_en()
          def create_x10000_wr_data(): List[UInt] = {
            val x10000_wr_data0 = List[UInt](block3chunk0("x9917_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x9918_elem_1").asInstanceOf[FixedPoint].r)
            val x10000_wr_data1 = List[UInt](block3chunk0("x9919_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x9920_elem_3").asInstanceOf[FixedPoint].r)
            val x10000_wr_data2 = List[UInt](block3chunk0("x9921_elem_4").asInstanceOf[FixedPoint].r,block3chunk0("x9922_elem_5").asInstanceOf[FixedPoint].r)
            val x10000_wr_data3 = List[UInt](block3chunk0("x9923_elem_6").asInstanceOf[FixedPoint].r,block3chunk0("x9924_elem_7").asInstanceOf[FixedPoint].r)
            val x10000_wr_data4 = List[UInt](block3chunk0("x9925_elem_8").asInstanceOf[FixedPoint].r,block3chunk0("x9926_elem_9").asInstanceOf[FixedPoint].r)
            val x10000_wr_data5 = List[UInt](block3chunk0("x9927_elem_10").asInstanceOf[FixedPoint].r,block3chunk0("x9928_elem_11").asInstanceOf[FixedPoint].r)
            val x10000_wr_data6 = List[UInt](block3chunk0("x9929_elem_12").asInstanceOf[FixedPoint].r,block3chunk0("x9930_elem_13").asInstanceOf[FixedPoint].r)
            val x10000_wr_data7 = List[UInt](block3chunk0("x9931_elem_14").asInstanceOf[FixedPoint].r,block3chunk0("x9932_elem_15").asInstanceOf[FixedPoint].r)
            x10000_wr_data0 ++ x10000_wr_data1 ++ x10000_wr_data2 ++ x10000_wr_data3 ++ x10000_wr_data4 ++ x10000_wr_data5 ++ x10000_wr_data6 ++ x10000_wr_data7
          }
          val x10000_wr_data = create_x10000_wr_data()
          x9861_in_buffer_7.connectWPort(10000, x10000_wr_banks, x10000_wr_ofs, x10000_wr_data, x10000_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]()
        }
      }
      val block3chunk2: Map[String, Any] = Block3Chunker2.gen()
      object Block3Chunker3 { // 3 nodes, 48 weight
        def gen(): Map[String, Any] = {
          def create_x10001_wr_banks(): List[UInt] = {
            val x10001_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x10001_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x10001_wr_banks0 ++ x10001_wr_banks1
          }
          val x10001_wr_banks = create_x10001_wr_banks()
          def create_x10001_wr_ofs(): List[UInt] = {
            val x10001_wr_ofs0 = List[UInt](block3chunk1("x20724").asInstanceOf[FixedPoint].r,block3chunk1("x20731").asInstanceOf[FixedPoint].r,block3chunk1("x20742").asInstanceOf[FixedPoint].r)
            val x10001_wr_ofs1 = List[UInt](block3chunk1("x20735").asInstanceOf[FixedPoint].r,block3chunk1("x20717").asInstanceOf[FixedPoint].r,block3chunk1("x20729").asInstanceOf[FixedPoint].r)
            val x10001_wr_ofs2 = List[UInt](block3chunk1("x20732").asInstanceOf[FixedPoint].r,block3chunk1("x20722").asInstanceOf[FixedPoint].r,block3chunk1("x20721").asInstanceOf[FixedPoint].r)
            val x10001_wr_ofs3 = List[UInt](block3chunk1("x20743").asInstanceOf[FixedPoint].r,block3chunk1("x20745").asInstanceOf[FixedPoint].r,block3chunk1("x20714").asInstanceOf[FixedPoint].r)
            val x10001_wr_ofs4 = List[UInt](block3chunk1("x20730").asInstanceOf[FixedPoint].r,block3chunk1("x20719").asInstanceOf[FixedPoint].r,block3chunk1("x20736").asInstanceOf[FixedPoint].r)
            val x10001_wr_ofs5 = List[UInt](block3chunk1("x20718").asInstanceOf[FixedPoint].r)
            x10001_wr_ofs0 ++ x10001_wr_ofs1 ++ x10001_wr_ofs2 ++ x10001_wr_ofs3 ++ x10001_wr_ofs4 ++ x10001_wr_ofs5
          }
          val x10001_wr_ofs = create_x10001_wr_ofs()
          def create_x10001_wr_en(): List[Bool] = {
            val x10001_wr_en0 = List[Bool](block3chunk1("x20727").asInstanceOf[Bool],block3chunk1("x20716").asInstanceOf[Bool],block3chunk1("x20738").asInstanceOf[Bool],block3chunk1("x20733").asInstanceOf[Bool])
            val x10001_wr_en1 = List[Bool](block3chunk1("x20725").asInstanceOf[Bool],block3chunk1("x20734").asInstanceOf[Bool],block3chunk1("x20740").asInstanceOf[Bool],block3chunk1("x20715").asInstanceOf[Bool])
            val x10001_wr_en2 = List[Bool](block3chunk1("x20741").asInstanceOf[Bool],block3chunk1("x20720").asInstanceOf[Bool],block3chunk1("x20726").asInstanceOf[Bool],block3chunk1("x20737").asInstanceOf[Bool])
            val x10001_wr_en3 = List[Bool](block3chunk1("x20739").asInstanceOf[Bool],block3chunk1("x20728").asInstanceOf[Bool],block3chunk1("x20723").asInstanceOf[Bool],block3chunk1("x20744").asInstanceOf[Bool])
            x10001_wr_en0 ++ x10001_wr_en1 ++ x10001_wr_en2 ++ x10001_wr_en3
          }
          val x10001_wr_en = create_x10001_wr_en()
          def create_x10001_wr_data(): List[UInt] = {
            val x10001_wr_data0 = List[UInt](block3chunk0("x9917_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x9918_elem_1").asInstanceOf[FixedPoint].r)
            val x10001_wr_data1 = List[UInt](block3chunk0("x9919_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x9920_elem_3").asInstanceOf[FixedPoint].r)
            val x10001_wr_data2 = List[UInt](block3chunk0("x9921_elem_4").asInstanceOf[FixedPoint].r,block3chunk0("x9922_elem_5").asInstanceOf[FixedPoint].r)
            val x10001_wr_data3 = List[UInt](block3chunk0("x9923_elem_6").asInstanceOf[FixedPoint].r,block3chunk0("x9924_elem_7").asInstanceOf[FixedPoint].r)
            val x10001_wr_data4 = List[UInt](block3chunk0("x9925_elem_8").asInstanceOf[FixedPoint].r,block3chunk0("x9926_elem_9").asInstanceOf[FixedPoint].r)
            val x10001_wr_data5 = List[UInt](block3chunk0("x9927_elem_10").asInstanceOf[FixedPoint].r,block3chunk0("x9928_elem_11").asInstanceOf[FixedPoint].r)
            val x10001_wr_data6 = List[UInt](block3chunk0("x9929_elem_12").asInstanceOf[FixedPoint].r,block3chunk0("x9930_elem_13").asInstanceOf[FixedPoint].r)
            val x10001_wr_data7 = List[UInt](block3chunk0("x9931_elem_14").asInstanceOf[FixedPoint].r,block3chunk0("x9932_elem_15").asInstanceOf[FixedPoint].r)
            x10001_wr_data0 ++ x10001_wr_data1 ++ x10001_wr_data2 ++ x10001_wr_data3 ++ x10001_wr_data4 ++ x10001_wr_data5 ++ x10001_wr_data6 ++ x10001_wr_data7
          }
          val x10001_wr_data = create_x10001_wr_data()
          x9857_in_buffer_3.connectWPort(10001, x10001_wr_banks, x10001_wr_ofs, x10001_wr_data, x10001_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x10002_wr_banks(): List[UInt] = {
            val x10002_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x10002_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x10002_wr_banks0 ++ x10002_wr_banks1
          }
          val x10002_wr_banks = create_x10002_wr_banks()
          def create_x10002_wr_ofs(): List[UInt] = {
            val x10002_wr_ofs0 = List[UInt](block3chunk1("x20724").asInstanceOf[FixedPoint].r,block3chunk1("x20731").asInstanceOf[FixedPoint].r,block3chunk1("x20742").asInstanceOf[FixedPoint].r)
            val x10002_wr_ofs1 = List[UInt](block3chunk1("x20735").asInstanceOf[FixedPoint].r,block3chunk1("x20717").asInstanceOf[FixedPoint].r,block3chunk1("x20729").asInstanceOf[FixedPoint].r)
            val x10002_wr_ofs2 = List[UInt](block3chunk1("x20732").asInstanceOf[FixedPoint].r,block3chunk1("x20722").asInstanceOf[FixedPoint].r,block3chunk1("x20721").asInstanceOf[FixedPoint].r)
            val x10002_wr_ofs3 = List[UInt](block3chunk1("x20743").asInstanceOf[FixedPoint].r,block3chunk1("x20745").asInstanceOf[FixedPoint].r,block3chunk1("x20714").asInstanceOf[FixedPoint].r)
            val x10002_wr_ofs4 = List[UInt](block3chunk1("x20730").asInstanceOf[FixedPoint].r,block3chunk1("x20719").asInstanceOf[FixedPoint].r,block3chunk1("x20736").asInstanceOf[FixedPoint].r)
            val x10002_wr_ofs5 = List[UInt](block3chunk1("x20718").asInstanceOf[FixedPoint].r)
            x10002_wr_ofs0 ++ x10002_wr_ofs1 ++ x10002_wr_ofs2 ++ x10002_wr_ofs3 ++ x10002_wr_ofs4 ++ x10002_wr_ofs5
          }
          val x10002_wr_ofs = create_x10002_wr_ofs()
          def create_x10002_wr_en(): List[Bool] = {
            val x10002_wr_en0 = List[Bool](block3chunk1("x20727").asInstanceOf[Bool],block3chunk1("x20716").asInstanceOf[Bool],block3chunk1("x20738").asInstanceOf[Bool],block3chunk1("x20733").asInstanceOf[Bool])
            val x10002_wr_en1 = List[Bool](block3chunk1("x20725").asInstanceOf[Bool],block3chunk1("x20734").asInstanceOf[Bool],block3chunk1("x20740").asInstanceOf[Bool],block3chunk1("x20715").asInstanceOf[Bool])
            val x10002_wr_en2 = List[Bool](block3chunk1("x20741").asInstanceOf[Bool],block3chunk1("x20720").asInstanceOf[Bool],block3chunk1("x20726").asInstanceOf[Bool],block3chunk1("x20737").asInstanceOf[Bool])
            val x10002_wr_en3 = List[Bool](block3chunk1("x20739").asInstanceOf[Bool],block3chunk1("x20728").asInstanceOf[Bool],block3chunk1("x20723").asInstanceOf[Bool],block3chunk1("x20744").asInstanceOf[Bool])
            x10002_wr_en0 ++ x10002_wr_en1 ++ x10002_wr_en2 ++ x10002_wr_en3
          }
          val x10002_wr_en = create_x10002_wr_en()
          def create_x10002_wr_data(): List[UInt] = {
            val x10002_wr_data0 = List[UInt](block3chunk0("x9917_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x9918_elem_1").asInstanceOf[FixedPoint].r)
            val x10002_wr_data1 = List[UInt](block3chunk0("x9919_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x9920_elem_3").asInstanceOf[FixedPoint].r)
            val x10002_wr_data2 = List[UInt](block3chunk0("x9921_elem_4").asInstanceOf[FixedPoint].r,block3chunk0("x9922_elem_5").asInstanceOf[FixedPoint].r)
            val x10002_wr_data3 = List[UInt](block3chunk0("x9923_elem_6").asInstanceOf[FixedPoint].r,block3chunk0("x9924_elem_7").asInstanceOf[FixedPoint].r)
            val x10002_wr_data4 = List[UInt](block3chunk0("x9925_elem_8").asInstanceOf[FixedPoint].r,block3chunk0("x9926_elem_9").asInstanceOf[FixedPoint].r)
            val x10002_wr_data5 = List[UInt](block3chunk0("x9927_elem_10").asInstanceOf[FixedPoint].r,block3chunk0("x9928_elem_11").asInstanceOf[FixedPoint].r)
            val x10002_wr_data6 = List[UInt](block3chunk0("x9929_elem_12").asInstanceOf[FixedPoint].r,block3chunk0("x9930_elem_13").asInstanceOf[FixedPoint].r)
            val x10002_wr_data7 = List[UInt](block3chunk0("x9931_elem_14").asInstanceOf[FixedPoint].r,block3chunk0("x9932_elem_15").asInstanceOf[FixedPoint].r)
            x10002_wr_data0 ++ x10002_wr_data1 ++ x10002_wr_data2 ++ x10002_wr_data3 ++ x10002_wr_data4 ++ x10002_wr_data5 ++ x10002_wr_data6 ++ x10002_wr_data7
          }
          val x10002_wr_data = create_x10002_wr_data()
          x9858_in_buffer_4.connectWPort(10002, x10002_wr_banks, x10002_wr_ofs, x10002_wr_data, x10002_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x10003_wr_banks(): List[UInt] = {
            val x10003_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x10003_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x10003_wr_banks0 ++ x10003_wr_banks1
          }
          val x10003_wr_banks = create_x10003_wr_banks()
          def create_x10003_wr_ofs(): List[UInt] = {
            val x10003_wr_ofs0 = List[UInt](block3chunk1("x20724").asInstanceOf[FixedPoint].r,block3chunk1("x20731").asInstanceOf[FixedPoint].r,block3chunk1("x20742").asInstanceOf[FixedPoint].r)
            val x10003_wr_ofs1 = List[UInt](block3chunk1("x20735").asInstanceOf[FixedPoint].r,block3chunk1("x20717").asInstanceOf[FixedPoint].r,block3chunk1("x20729").asInstanceOf[FixedPoint].r)
            val x10003_wr_ofs2 = List[UInt](block3chunk1("x20732").asInstanceOf[FixedPoint].r,block3chunk1("x20722").asInstanceOf[FixedPoint].r,block3chunk1("x20721").asInstanceOf[FixedPoint].r)
            val x10003_wr_ofs3 = List[UInt](block3chunk1("x20743").asInstanceOf[FixedPoint].r,block3chunk1("x20745").asInstanceOf[FixedPoint].r,block3chunk1("x20714").asInstanceOf[FixedPoint].r)
            val x10003_wr_ofs4 = List[UInt](block3chunk1("x20730").asInstanceOf[FixedPoint].r,block3chunk1("x20719").asInstanceOf[FixedPoint].r,block3chunk1("x20736").asInstanceOf[FixedPoint].r)
            val x10003_wr_ofs5 = List[UInt](block3chunk1("x20718").asInstanceOf[FixedPoint].r)
            x10003_wr_ofs0 ++ x10003_wr_ofs1 ++ x10003_wr_ofs2 ++ x10003_wr_ofs3 ++ x10003_wr_ofs4 ++ x10003_wr_ofs5
          }
          val x10003_wr_ofs = create_x10003_wr_ofs()
          def create_x10003_wr_en(): List[Bool] = {
            val x10003_wr_en0 = List[Bool](block3chunk1("x20727").asInstanceOf[Bool],block3chunk1("x20716").asInstanceOf[Bool],block3chunk1("x20738").asInstanceOf[Bool],block3chunk1("x20733").asInstanceOf[Bool])
            val x10003_wr_en1 = List[Bool](block3chunk1("x20725").asInstanceOf[Bool],block3chunk1("x20734").asInstanceOf[Bool],block3chunk1("x20740").asInstanceOf[Bool],block3chunk1("x20715").asInstanceOf[Bool])
            val x10003_wr_en2 = List[Bool](block3chunk1("x20741").asInstanceOf[Bool],block3chunk1("x20720").asInstanceOf[Bool],block3chunk1("x20726").asInstanceOf[Bool],block3chunk1("x20737").asInstanceOf[Bool])
            val x10003_wr_en3 = List[Bool](block3chunk1("x20739").asInstanceOf[Bool],block3chunk1("x20728").asInstanceOf[Bool],block3chunk1("x20723").asInstanceOf[Bool],block3chunk1("x20744").asInstanceOf[Bool])
            x10003_wr_en0 ++ x10003_wr_en1 ++ x10003_wr_en2 ++ x10003_wr_en3
          }
          val x10003_wr_en = create_x10003_wr_en()
          def create_x10003_wr_data(): List[UInt] = {
            val x10003_wr_data0 = List[UInt](block3chunk0("x9917_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x9918_elem_1").asInstanceOf[FixedPoint].r)
            val x10003_wr_data1 = List[UInt](block3chunk0("x9919_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x9920_elem_3").asInstanceOf[FixedPoint].r)
            val x10003_wr_data2 = List[UInt](block3chunk0("x9921_elem_4").asInstanceOf[FixedPoint].r,block3chunk0("x9922_elem_5").asInstanceOf[FixedPoint].r)
            val x10003_wr_data3 = List[UInt](block3chunk0("x9923_elem_6").asInstanceOf[FixedPoint].r,block3chunk0("x9924_elem_7").asInstanceOf[FixedPoint].r)
            val x10003_wr_data4 = List[UInt](block3chunk0("x9925_elem_8").asInstanceOf[FixedPoint].r,block3chunk0("x9926_elem_9").asInstanceOf[FixedPoint].r)
            val x10003_wr_data5 = List[UInt](block3chunk0("x9927_elem_10").asInstanceOf[FixedPoint].r,block3chunk0("x9928_elem_11").asInstanceOf[FixedPoint].r)
            val x10003_wr_data6 = List[UInt](block3chunk0("x9929_elem_12").asInstanceOf[FixedPoint].r,block3chunk0("x9930_elem_13").asInstanceOf[FixedPoint].r)
            val x10003_wr_data7 = List[UInt](block3chunk0("x9931_elem_14").asInstanceOf[FixedPoint].r,block3chunk0("x9932_elem_15").asInstanceOf[FixedPoint].r)
            x10003_wr_data0 ++ x10003_wr_data1 ++ x10003_wr_data2 ++ x10003_wr_data3 ++ x10003_wr_data4 ++ x10003_wr_data5 ++ x10003_wr_data6 ++ x10003_wr_data7
          }
          val x10003_wr_data = create_x10003_wr_data()
          x9856_in_buffer_2.connectWPort(10003, x10003_wr_banks, x10003_wr_ofs, x10003_wr_data, x10003_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]()
        }
      }
      val block3chunk3: Map[String, Any] = Block3Chunker3.gen()
      object Block3Chunker4 { // 1 nodes, 16 weight
        def gen(): Map[String, Any] = {
          def create_x10004_wr_banks(): List[UInt] = {
            val x10004_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x10004_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x10004_wr_banks0 ++ x10004_wr_banks1
          }
          val x10004_wr_banks = create_x10004_wr_banks()
          def create_x10004_wr_ofs(): List[UInt] = {
            val x10004_wr_ofs0 = List[UInt](block3chunk1("x20724").asInstanceOf[FixedPoint].r,block3chunk1("x20731").asInstanceOf[FixedPoint].r,block3chunk1("x20742").asInstanceOf[FixedPoint].r)
            val x10004_wr_ofs1 = List[UInt](block3chunk1("x20735").asInstanceOf[FixedPoint].r,block3chunk1("x20717").asInstanceOf[FixedPoint].r,block3chunk1("x20729").asInstanceOf[FixedPoint].r)
            val x10004_wr_ofs2 = List[UInt](block3chunk1("x20732").asInstanceOf[FixedPoint].r,block3chunk1("x20722").asInstanceOf[FixedPoint].r,block3chunk1("x20721").asInstanceOf[FixedPoint].r)
            val x10004_wr_ofs3 = List[UInt](block3chunk1("x20743").asInstanceOf[FixedPoint].r,block3chunk1("x20745").asInstanceOf[FixedPoint].r,block3chunk1("x20714").asInstanceOf[FixedPoint].r)
            val x10004_wr_ofs4 = List[UInt](block3chunk1("x20730").asInstanceOf[FixedPoint].r,block3chunk1("x20719").asInstanceOf[FixedPoint].r,block3chunk1("x20736").asInstanceOf[FixedPoint].r)
            val x10004_wr_ofs5 = List[UInt](block3chunk1("x20718").asInstanceOf[FixedPoint].r)
            x10004_wr_ofs0 ++ x10004_wr_ofs1 ++ x10004_wr_ofs2 ++ x10004_wr_ofs3 ++ x10004_wr_ofs4 ++ x10004_wr_ofs5
          }
          val x10004_wr_ofs = create_x10004_wr_ofs()
          def create_x10004_wr_en(): List[Bool] = {
            val x10004_wr_en0 = List[Bool](block3chunk1("x20727").asInstanceOf[Bool],block3chunk1("x20716").asInstanceOf[Bool],block3chunk1("x20738").asInstanceOf[Bool],block3chunk1("x20733").asInstanceOf[Bool])
            val x10004_wr_en1 = List[Bool](block3chunk1("x20725").asInstanceOf[Bool],block3chunk1("x20734").asInstanceOf[Bool],block3chunk1("x20740").asInstanceOf[Bool],block3chunk1("x20715").asInstanceOf[Bool])
            val x10004_wr_en2 = List[Bool](block3chunk1("x20741").asInstanceOf[Bool],block3chunk1("x20720").asInstanceOf[Bool],block3chunk1("x20726").asInstanceOf[Bool],block3chunk1("x20737").asInstanceOf[Bool])
            val x10004_wr_en3 = List[Bool](block3chunk1("x20739").asInstanceOf[Bool],block3chunk1("x20728").asInstanceOf[Bool],block3chunk1("x20723").asInstanceOf[Bool],block3chunk1("x20744").asInstanceOf[Bool])
            x10004_wr_en0 ++ x10004_wr_en1 ++ x10004_wr_en2 ++ x10004_wr_en3
          }
          val x10004_wr_en = create_x10004_wr_en()
          def create_x10004_wr_data(): List[UInt] = {
            val x10004_wr_data0 = List[UInt](block3chunk0("x9917_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x9918_elem_1").asInstanceOf[FixedPoint].r)
            val x10004_wr_data1 = List[UInt](block3chunk0("x9919_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x9920_elem_3").asInstanceOf[FixedPoint].r)
            val x10004_wr_data2 = List[UInt](block3chunk0("x9921_elem_4").asInstanceOf[FixedPoint].r,block3chunk0("x9922_elem_5").asInstanceOf[FixedPoint].r)
            val x10004_wr_data3 = List[UInt](block3chunk0("x9923_elem_6").asInstanceOf[FixedPoint].r,block3chunk0("x9924_elem_7").asInstanceOf[FixedPoint].r)
            val x10004_wr_data4 = List[UInt](block3chunk0("x9925_elem_8").asInstanceOf[FixedPoint].r,block3chunk0("x9926_elem_9").asInstanceOf[FixedPoint].r)
            val x10004_wr_data5 = List[UInt](block3chunk0("x9927_elem_10").asInstanceOf[FixedPoint].r,block3chunk0("x9928_elem_11").asInstanceOf[FixedPoint].r)
            val x10004_wr_data6 = List[UInt](block3chunk0("x9929_elem_12").asInstanceOf[FixedPoint].r,block3chunk0("x9930_elem_13").asInstanceOf[FixedPoint].r)
            val x10004_wr_data7 = List[UInt](block3chunk0("x9931_elem_14").asInstanceOf[FixedPoint].r,block3chunk0("x9932_elem_15").asInstanceOf[FixedPoint].r)
            x10004_wr_data0 ++ x10004_wr_data1 ++ x10004_wr_data2 ++ x10004_wr_data3 ++ x10004_wr_data4 ++ x10004_wr_data5 ++ x10004_wr_data6 ++ x10004_wr_data7
          }
          val x10004_wr_data = create_x10004_wr_data()
          x9859_in_buffer_5.connectWPort(10004, x10004_wr_banks, x10004_wr_ofs, x10004_wr_data, x10004_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]()
        }
      }
      val block3chunk4: Map[String, Any] = Block3Chunker4.gen()
    }
    val module = Module(new x10005_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x10005_inr_Foreach **/
