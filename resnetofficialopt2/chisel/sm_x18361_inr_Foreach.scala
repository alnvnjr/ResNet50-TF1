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

/** Hierarchy: x18361 -> x18366 -> x18367 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x18361_inr_Foreach **/
class x18361_inr_Foreach_kernel(
  list_x18014_feature_map_sum_0: List[NBufInterface],
  list_x18216: List[DecoupledIO[AppStoreData]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.2.toInt, myName = "x18361_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18361_inr_Foreach_iiCtr"))
  
  abstract class x18361_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18216 = Decoupled(new AppStoreData(ModuleParams.getParams("x18216_p").asInstanceOf[(Int,Int)] ))
      val in_x18014_feature_map_sum_0 = Flipped(new NBufInterface(ModuleParams.getParams("x18014_feature_map_sum_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(16), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18216 = {io.in_x18216} 
    def x18014_feature_map_sum_0 = {io.in_x18014_feature_map_sum_0} ; io.in_x18014_feature_map_sum_0 := DontCare
  }
  def connectWires0(module: x18361_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18216 <> x18216
    x18014_feature_map_sum_0.connectLedger(module.io.in_x18014_feature_map_sum_0)
  }
  val x18014_feature_map_sum_0 = list_x18014_feature_map_sum_0(0)
  val x18216 = list_x18216(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18361_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x18361_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18361_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b18231 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b18231.suggestName("b18231")
      val b18232 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b18232.suggestName("b18232")
      val b18233 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b18233.suggestName("b18233")
      val b18234 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b18234.suggestName("b18234")
      val b18235 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b18235.suggestName("b18235")
      val b18236 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b18236.suggestName("b18236")
      val b18237 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b18237.suggestName("b18237")
      val b18238 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b18238.suggestName("b18238")
      val b18239 = io.sigsIn.cchainOutputs.head.counts(8).FP(true, 32, 0); b18239.suggestName("b18239")
      val b18240 = io.sigsIn.cchainOutputs.head.counts(9).FP(true, 32, 0); b18240.suggestName("b18240")
      val b18241 = io.sigsIn.cchainOutputs.head.counts(10).FP(true, 32, 0); b18241.suggestName("b18241")
      val b18242 = io.sigsIn.cchainOutputs.head.counts(11).FP(true, 32, 0); b18242.suggestName("b18242")
      val b18243 = io.sigsIn.cchainOutputs.head.counts(12).FP(true, 32, 0); b18243.suggestName("b18243")
      val b18244 = io.sigsIn.cchainOutputs.head.counts(13).FP(true, 32, 0); b18244.suggestName("b18244")
      val b18245 = io.sigsIn.cchainOutputs.head.counts(14).FP(true, 32, 0); b18245.suggestName("b18245")
      val b18246 = io.sigsIn.cchainOutputs.head.counts(15).FP(true, 32, 0); b18246.suggestName("b18246")
      val b18247 = ~io.sigsIn.cchainOutputs.head.oobs(0); b18247.suggestName("b18247")
      val b18248 = ~io.sigsIn.cchainOutputs.head.oobs(1); b18248.suggestName("b18248")
      val b18249 = ~io.sigsIn.cchainOutputs.head.oobs(2); b18249.suggestName("b18249")
      val b18250 = ~io.sigsIn.cchainOutputs.head.oobs(3); b18250.suggestName("b18250")
      val b18251 = ~io.sigsIn.cchainOutputs.head.oobs(4); b18251.suggestName("b18251")
      val b18252 = ~io.sigsIn.cchainOutputs.head.oobs(5); b18252.suggestName("b18252")
      val b18253 = ~io.sigsIn.cchainOutputs.head.oobs(6); b18253.suggestName("b18253")
      val b18254 = ~io.sigsIn.cchainOutputs.head.oobs(7); b18254.suggestName("b18254")
      val b18255 = ~io.sigsIn.cchainOutputs.head.oobs(8); b18255.suggestName("b18255")
      val b18256 = ~io.sigsIn.cchainOutputs.head.oobs(9); b18256.suggestName("b18256")
      val b18257 = ~io.sigsIn.cchainOutputs.head.oobs(10); b18257.suggestName("b18257")
      val b18258 = ~io.sigsIn.cchainOutputs.head.oobs(11); b18258.suggestName("b18258")
      val b18259 = ~io.sigsIn.cchainOutputs.head.oobs(12); b18259.suggestName("b18259")
      val b18260 = ~io.sigsIn.cchainOutputs.head.oobs(13); b18260.suggestName("b18260")
      val b18261 = ~io.sigsIn.cchainOutputs.head.oobs(14); b18261.suggestName("b18261")
      val b18262 = ~io.sigsIn.cchainOutputs.head.oobs(15); b18262.suggestName("b18262")
      object Block2Chunker0 { // 34 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x18279 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18279""")
          val ensig0 = Wire(Bool())
          ensig0 := x18216.ready
          x18279.r := Math.arith_right_shift(b18231, 4, Some(0.2), ensig0,"x18279").r
          val x18282 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18282""")
          x18282.r := Math.arith_right_shift(b18232, 4, Some(0.2), ensig0,"x18282").r
          val x18285 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18285""")
          x18285.r := Math.arith_right_shift(b18233, 4, Some(0.2), ensig0,"x18285").r
          val x18288 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18288""")
          x18288.r := Math.arith_right_shift(b18234, 4, Some(0.2), ensig0,"x18288").r
          val x18291 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18291""")
          x18291.r := Math.arith_right_shift(b18235, 4, Some(0.2), ensig0,"x18291").r
          val x18294 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18294""")
          x18294.r := Math.arith_right_shift(b18236, 4, Some(0.2), ensig0,"x18294").r
          val x18297 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18297""")
          x18297.r := Math.arith_right_shift(b18237, 4, Some(0.2), ensig0,"x18297").r
          val x18300 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18300""")
          x18300.r := Math.arith_right_shift(b18238, 4, Some(0.2), ensig0,"x18300").r
          val x18303 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18303""")
          x18303.r := Math.arith_right_shift(b18239, 4, Some(0.2), ensig0,"x18303").r
          val x18306 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18306""")
          x18306.r := Math.arith_right_shift(b18240, 4, Some(0.2), ensig0,"x18306").r
          val x18309 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18309""")
          x18309.r := Math.arith_right_shift(b18241, 4, Some(0.2), ensig0,"x18309").r
          val x18312 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18312""")
          x18312.r := Math.arith_right_shift(b18242, 4, Some(0.2), ensig0,"x18312").r
          val x18315 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18315""")
          x18315.r := Math.arith_right_shift(b18243, 4, Some(0.2), ensig0,"x18315").r
          val x18318 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18318""")
          x18318.r := Math.arith_right_shift(b18244, 4, Some(0.2), ensig0,"x18318").r
          val x18321 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18321""")
          x18321.r := Math.arith_right_shift(b18245, 4, Some(0.2), ensig0,"x18321").r
          val x18324 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18324""")
          x18324.r := Math.arith_right_shift(b18246, 4, Some(0.2), ensig0,"x18324").r
          val x18327_rd = Wire(Vec(16, new FixedPoint(true, 10, 22))).suggestName("""x18327_rd""")
          def create_x18327_rd_banks(): List[UInt] = {
            val x18327_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x18327_rd_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x18327_rd_banks0 ++ x18327_rd_banks1
          }
          val x18327_rd_banks = create_x18327_rd_banks()
          def create_x18327_rd_ofs(): List[UInt] = {
            val x18327_rd_ofs0 = List[UInt](x18279.r,x18282.r,x18285.r,x18288.r,x18291.r,x18294.r,x18297.r,x18300.r,x18303.r,x18306.r,x18309.r,x18312.r,x18315.r,x18318.r,x18321.r,x18324.r)
            x18327_rd_ofs0
          }
          val x18327_rd_ofs = create_x18327_rd_ofs()
          val x18327_rd_en = List[Bool](b18247,b18248,b18249,b18250,b18251,b18252,b18253,b18254,b18255,b18256,b18257,b18258,b18259,b18260,b18261,b18262)
          x18327_rd.toSeq.zip(x18014_feature_map_sum_0.connectRPort(18327, x18327_rd_banks, x18327_rd_ofs, io.sigsIn.backpressure, x18327_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x18328_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18328_elem_0""")
          x18328_elem_0.r := x18327_rd(0).r
          val x18329_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18329_elem_1""")
          x18329_elem_1.r := x18327_rd(1).r
          val x18330_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18330_elem_2""")
          x18330_elem_2.r := x18327_rd(2).r
          val x18331_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18331_elem_3""")
          x18331_elem_3.r := x18327_rd(3).r
          val x18332_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18332_elem_4""")
          x18332_elem_4.r := x18327_rd(4).r
          val x18333_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18333_elem_5""")
          x18333_elem_5.r := x18327_rd(5).r
          val x18334_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18334_elem_6""")
          x18334_elem_6.r := x18327_rd(6).r
          val x18335_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18335_elem_7""")
          x18335_elem_7.r := x18327_rd(7).r
          val x18336_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18336_elem_8""")
          x18336_elem_8.r := x18327_rd(8).r
          val x18337_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18337_elem_9""")
          x18337_elem_9.r := x18327_rd(9).r
          val x18338_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18338_elem_10""")
          x18338_elem_10.r := x18327_rd(10).r
          val x18339_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18339_elem_11""")
          x18339_elem_11.r := x18327_rd(11).r
          val x18340_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18340_elem_12""")
          x18340_elem_12.r := x18327_rd(12).r
          val x18341_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18341_elem_13""")
          x18341_elem_13.r := x18327_rd(13).r
          val x18342_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18342_elem_14""")
          x18342_elem_14.r := x18327_rd(14).r
          val x18343_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18343_elem_15""")
          x18343_elem_15.r := x18327_rd(15).r
          val x18344_tuple = Wire(UInt(33.W)).suggestName("""x18344_tuple""")
          x18344_tuple.r := Cat(true.B,x18328_elem_0.r)
          Map[String,Any]("x18329_elem_1" -> x18329_elem_1, "x18330_elem_2" -> x18330_elem_2, "x18331_elem_3" -> x18331_elem_3, "x18332_elem_4" -> x18332_elem_4, "x18333_elem_5" -> x18333_elem_5, "x18334_elem_6" -> x18334_elem_6, "x18335_elem_7" -> x18335_elem_7, "x18336_elem_8" -> x18336_elem_8, "x18337_elem_9" -> x18337_elem_9, "x18338_elem_10" -> x18338_elem_10, "x18339_elem_11" -> x18339_elem_11, "x18340_elem_12" -> x18340_elem_12, "x18341_elem_13" -> x18341_elem_13, "x18342_elem_14" -> x18342_elem_14, "x18343_elem_15" -> x18343_elem_15, "x18344_tuple" -> x18344_tuple)
        }
      }
      val block2chunk0: Map[String, Any] = Block2Chunker0.gen()
      object Block2Chunker1 { // 32 nodes, 47 weight
        def gen(): Map[String, Any] = {
          val x18345_tuple = Wire(UInt(33.W)).suggestName("""x18345_tuple""")
          x18345_tuple.r := Cat(true.B,block2chunk0("x18329_elem_1").asInstanceOf[FixedPoint].r)
          val x18346_tuple = Wire(UInt(33.W)).suggestName("""x18346_tuple""")
          x18346_tuple.r := Cat(true.B,block2chunk0("x18330_elem_2").asInstanceOf[FixedPoint].r)
          val x18347_tuple = Wire(UInt(33.W)).suggestName("""x18347_tuple""")
          x18347_tuple.r := Cat(true.B,block2chunk0("x18331_elem_3").asInstanceOf[FixedPoint].r)
          val x18348_tuple = Wire(UInt(33.W)).suggestName("""x18348_tuple""")
          x18348_tuple.r := Cat(true.B,block2chunk0("x18332_elem_4").asInstanceOf[FixedPoint].r)
          val x18349_tuple = Wire(UInt(33.W)).suggestName("""x18349_tuple""")
          x18349_tuple.r := Cat(true.B,block2chunk0("x18333_elem_5").asInstanceOf[FixedPoint].r)
          val x18350_tuple = Wire(UInt(33.W)).suggestName("""x18350_tuple""")
          x18350_tuple.r := Cat(true.B,block2chunk0("x18334_elem_6").asInstanceOf[FixedPoint].r)
          val x18351_tuple = Wire(UInt(33.W)).suggestName("""x18351_tuple""")
          x18351_tuple.r := Cat(true.B,block2chunk0("x18335_elem_7").asInstanceOf[FixedPoint].r)
          val x18352_tuple = Wire(UInt(33.W)).suggestName("""x18352_tuple""")
          x18352_tuple.r := Cat(true.B,block2chunk0("x18336_elem_8").asInstanceOf[FixedPoint].r)
          val x18353_tuple = Wire(UInt(33.W)).suggestName("""x18353_tuple""")
          x18353_tuple.r := Cat(true.B,block2chunk0("x18337_elem_9").asInstanceOf[FixedPoint].r)
          val x18354_tuple = Wire(UInt(33.W)).suggestName("""x18354_tuple""")
          x18354_tuple.r := Cat(true.B,block2chunk0("x18338_elem_10").asInstanceOf[FixedPoint].r)
          val x18355_tuple = Wire(UInt(33.W)).suggestName("""x18355_tuple""")
          x18355_tuple.r := Cat(true.B,block2chunk0("x18339_elem_11").asInstanceOf[FixedPoint].r)
          val x18356_tuple = Wire(UInt(33.W)).suggestName("""x18356_tuple""")
          x18356_tuple.r := Cat(true.B,block2chunk0("x18340_elem_12").asInstanceOf[FixedPoint].r)
          val x18357_tuple = Wire(UInt(33.W)).suggestName("""x18357_tuple""")
          x18357_tuple.r := Cat(true.B,block2chunk0("x18341_elem_13").asInstanceOf[FixedPoint].r)
          val x18358_tuple = Wire(UInt(33.W)).suggestName("""x18358_tuple""")
          x18358_tuple.r := Cat(true.B,block2chunk0("x18342_elem_14").asInstanceOf[FixedPoint].r)
          val x18359_tuple = Wire(UInt(33.W)).suggestName("""x18359_tuple""")
          x18359_tuple.r := Cat(true.B,block2chunk0("x18343_elem_15").asInstanceOf[FixedPoint].r)
          val x21967 = Wire(Bool()).suggestName("x21967_b18247_D2") 
          x21967.r := getRetimed(b18247.r, 2.toInt, io.sigsIn.backpressure)
          val x21968 = Wire(Bool()).suggestName("x21968_b18252_D2") 
          x21968.r := getRetimed(b18252.r, 2.toInt, io.sigsIn.backpressure)
          val x21969 = Wire(Bool()).suggestName("x21969_b18260_D2") 
          x21969.r := getRetimed(b18260.r, 2.toInt, io.sigsIn.backpressure)
          val x21970 = Wire(Bool()).suggestName("x21970_b18261_D2") 
          x21970.r := getRetimed(b18261.r, 2.toInt, io.sigsIn.backpressure)
          val x21971 = Wire(Bool()).suggestName("x21971_b18251_D2") 
          x21971.r := getRetimed(b18251.r, 2.toInt, io.sigsIn.backpressure)
          val x21972 = Wire(Bool()).suggestName("x21972_b18248_D2") 
          x21972.r := getRetimed(b18248.r, 2.toInt, io.sigsIn.backpressure)
          val x21973 = Wire(Bool()).suggestName("x21973_b18257_D2") 
          x21973.r := getRetimed(b18257.r, 2.toInt, io.sigsIn.backpressure)
          val x21974 = Wire(Bool()).suggestName("x21974_b18255_D2") 
          x21974.r := getRetimed(b18255.r, 2.toInt, io.sigsIn.backpressure)
          val x21975 = Wire(Bool()).suggestName("x21975_b18262_D2") 
          x21975.r := getRetimed(b18262.r, 2.toInt, io.sigsIn.backpressure)
          val x21976 = Wire(Bool()).suggestName("x21976_b18250_D2") 
          x21976.r := getRetimed(b18250.r, 2.toInt, io.sigsIn.backpressure)
          val x21977 = Wire(Bool()).suggestName("x21977_b18254_D2") 
          x21977.r := getRetimed(b18254.r, 2.toInt, io.sigsIn.backpressure)
          val x21978 = Wire(Bool()).suggestName("x21978_b18258_D2") 
          x21978.r := getRetimed(b18258.r, 2.toInt, io.sigsIn.backpressure)
          val x21979 = Wire(Bool()).suggestName("x21979_b18256_D2") 
          x21979.r := getRetimed(b18256.r, 2.toInt, io.sigsIn.backpressure)
          val x21980 = Wire(Bool()).suggestName("x21980_b18249_D2") 
          x21980.r := getRetimed(b18249.r, 2.toInt, io.sigsIn.backpressure)
          val x21981 = Wire(Bool()).suggestName("x21981_b18253_D2") 
          x21981.r := getRetimed(b18253.r, 2.toInt, io.sigsIn.backpressure)
          val x21982 = Wire(Bool()).suggestName("x21982_b18259_D2") 
          x21982.r := getRetimed(b18259.r, 2.toInt, io.sigsIn.backpressure)
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21967 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21972 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21980 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21976 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21971 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21968 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21981 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21977 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21974 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21979 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21973 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21978 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21982 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21969 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21970 & io.sigsIn.backpressure
          x18216.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21975 & io.sigsIn.backpressure
          x18216.bits.wdata(0) := block2chunk0("x18344_tuple").asInstanceOf[UInt](31,0)
          x18216.bits.wdata(1) := x18345_tuple(31,0)
          x18216.bits.wdata(2) := x18346_tuple(31,0)
          x18216.bits.wdata(3) := x18347_tuple(31,0)
          x18216.bits.wdata(4) := x18348_tuple(31,0)
          x18216.bits.wdata(5) := x18349_tuple(31,0)
          x18216.bits.wdata(6) := x18350_tuple(31,0)
          x18216.bits.wdata(7) := x18351_tuple(31,0)
          x18216.bits.wdata(8) := x18352_tuple(31,0)
          x18216.bits.wdata(9) := x18353_tuple(31,0)
          x18216.bits.wdata(10) := x18354_tuple(31,0)
          x18216.bits.wdata(11) := x18355_tuple(31,0)
          x18216.bits.wdata(12) := x18356_tuple(31,0)
          x18216.bits.wdata(13) := x18357_tuple(31,0)
          x18216.bits.wdata(14) := x18358_tuple(31,0)
          x18216.bits.wdata(15) := x18359_tuple(31,0)
          x18216.bits.wstrb := List(block2chunk0("x18344_tuple").asInstanceOf[UInt], x18345_tuple, x18346_tuple, x18347_tuple, x18348_tuple, x18349_tuple, x18350_tuple, x18351_tuple, x18352_tuple, x18353_tuple, x18354_tuple, x18355_tuple, x18356_tuple, x18357_tuple, x18358_tuple, x18359_tuple).map{_(32,32)}.reduce(Cat(_,_))
          Map[String,Any]()
        }
      }
      val block2chunk1: Map[String, Any] = Block2Chunker1.gen()
    }
    val module = Module(new x18361_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x18361_inr_Foreach **/
