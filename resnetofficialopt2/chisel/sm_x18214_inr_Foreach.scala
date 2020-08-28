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

/** Hierarchy: x18214 -> x18367 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x18214_inr_Foreach **/
class x18214_inr_Foreach_kernel(
  list_b17747: List[Bool],
  list_x17748_feature_map_a_0: List[NBufInterface],
  list_x3920_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 4.2.toInt, myName = "x18214_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18214_inr_Foreach_iiCtr"))
  
  abstract class x18214_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b17747 = Input(Bool())
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x18813_rd_x9468 = Input(Bool())
      val in_x17748_feature_map_a_0 = Flipped(new NBufInterface(ModuleParams.getParams("x17748_feature_map_a_0_p").asInstanceOf[NBufParams] ))
      val in_x18812_rd_x3921 = Input(Bool())
      val in_x9467_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9467_reg_p").asInstanceOf[MemParams] ))
      val in_x17881_feature_map_b_0 = Flipped(new NBufInterface(ModuleParams.getParams("x17881_feature_map_b_0_p").asInstanceOf[NBufParams] ))
      val in_x18014_feature_map_sum_0 = Flipped(new NBufInterface(ModuleParams.getParams("x18014_feature_map_sum_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(16), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b17747 = {io.in_b17747} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x18813_rd_x9468 = {io.in_x18813_rd_x9468} 
    def x17748_feature_map_a_0 = {io.in_x17748_feature_map_a_0} ; io.in_x17748_feature_map_a_0 := DontCare
    def x18812_rd_x3921 = {io.in_x18812_rd_x3921} 
    def x9467_reg = {io.in_x9467_reg} ; io.in_x9467_reg := DontCare
    def x17881_feature_map_b_0 = {io.in_x17881_feature_map_b_0} ; io.in_x17881_feature_map_b_0 := DontCare
    def x18014_feature_map_sum_0 = {io.in_x18014_feature_map_sum_0} ; io.in_x18014_feature_map_sum_0 := DontCare
  }
  def connectWires0(module: x18214_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b17747 <> b17747
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    module.io.in_x18813_rd_x9468 <> x18813_rd_x9468
    x17748_feature_map_a_0.connectLedger(module.io.in_x17748_feature_map_a_0)
    module.io.in_x18812_rd_x3921 <> x18812_rd_x3921
    x9467_reg.connectLedger(module.io.in_x9467_reg)
    x17881_feature_map_b_0.connectLedger(module.io.in_x17881_feature_map_b_0)
    x18014_feature_map_sum_0.connectLedger(module.io.in_x18014_feature_map_sum_0)
  }
  val b17747 = list_b17747(0)
  val x18813_rd_x9468 = list_b17747(1)
  val x18812_rd_x3921 = list_b17747(2)
  val x17748_feature_map_a_0 = list_x17748_feature_map_a_0(0)
  val x17881_feature_map_b_0 = list_x17748_feature_map_a_0(1)
  val x18014_feature_map_sum_0 = list_x17748_feature_map_a_0(2)
  val x3920_reg = list_x3920_reg(0)
  val x9467_reg = list_x3920_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18214_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x18214_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18214_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b18019 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b18019.suggestName("b18019")
      val b18020 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b18020.suggestName("b18020")
      val b18021 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b18021.suggestName("b18021")
      val b18022 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b18022.suggestName("b18022")
      val b18023 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b18023.suggestName("b18023")
      val b18024 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b18024.suggestName("b18024")
      val b18025 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b18025.suggestName("b18025")
      val b18026 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b18026.suggestName("b18026")
      val b18027 = io.sigsIn.cchainOutputs.head.counts(8).FP(true, 32, 0); b18027.suggestName("b18027")
      val b18028 = io.sigsIn.cchainOutputs.head.counts(9).FP(true, 32, 0); b18028.suggestName("b18028")
      val b18029 = io.sigsIn.cchainOutputs.head.counts(10).FP(true, 32, 0); b18029.suggestName("b18029")
      val b18030 = io.sigsIn.cchainOutputs.head.counts(11).FP(true, 32, 0); b18030.suggestName("b18030")
      val b18031 = io.sigsIn.cchainOutputs.head.counts(12).FP(true, 32, 0); b18031.suggestName("b18031")
      val b18032 = io.sigsIn.cchainOutputs.head.counts(13).FP(true, 32, 0); b18032.suggestName("b18032")
      val b18033 = io.sigsIn.cchainOutputs.head.counts(14).FP(true, 32, 0); b18033.suggestName("b18033")
      val b18034 = io.sigsIn.cchainOutputs.head.counts(15).FP(true, 32, 0); b18034.suggestName("b18034")
      val b18035 = ~io.sigsIn.cchainOutputs.head.oobs(0); b18035.suggestName("b18035")
      val b18036 = ~io.sigsIn.cchainOutputs.head.oobs(1); b18036.suggestName("b18036")
      val b18037 = ~io.sigsIn.cchainOutputs.head.oobs(2); b18037.suggestName("b18037")
      val b18038 = ~io.sigsIn.cchainOutputs.head.oobs(3); b18038.suggestName("b18038")
      val b18039 = ~io.sigsIn.cchainOutputs.head.oobs(4); b18039.suggestName("b18039")
      val b18040 = ~io.sigsIn.cchainOutputs.head.oobs(5); b18040.suggestName("b18040")
      val b18041 = ~io.sigsIn.cchainOutputs.head.oobs(6); b18041.suggestName("b18041")
      val b18042 = ~io.sigsIn.cchainOutputs.head.oobs(7); b18042.suggestName("b18042")
      val b18043 = ~io.sigsIn.cchainOutputs.head.oobs(8); b18043.suggestName("b18043")
      val b18044 = ~io.sigsIn.cchainOutputs.head.oobs(9); b18044.suggestName("b18044")
      val b18045 = ~io.sigsIn.cchainOutputs.head.oobs(10); b18045.suggestName("b18045")
      val b18046 = ~io.sigsIn.cchainOutputs.head.oobs(11); b18046.suggestName("b18046")
      val b18047 = ~io.sigsIn.cchainOutputs.head.oobs(12); b18047.suggestName("b18047")
      val b18048 = ~io.sigsIn.cchainOutputs.head.oobs(13); b18048.suggestName("b18048")
      val b18049 = ~io.sigsIn.cchainOutputs.head.oobs(14); b18049.suggestName("b18049")
      val b18050 = ~io.sigsIn.cchainOutputs.head.oobs(15); b18050.suggestName("b18050")
      object Block1Chunker0 { // 34 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x18051_rd_x9467 = Wire(Bool()).suggestName("""x18051_rd_x9467""")
          val x18051_rd_x9467_banks = List[UInt]()
          val x18051_rd_x9467_ofs = List[UInt]()
          val x18051_rd_x9467_en = List[Bool](true.B)
          x18051_rd_x9467.toSeq.zip(x9467_reg.connectRPort(18051, x18051_rd_x9467_banks, x18051_rd_x9467_ofs, io.sigsIn.backpressure, x18051_rd_x9467_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x18067_rd_x3920 = Wire(Bool()).suggestName("""x18067_rd_x3920""")
          val x18067_rd_x3920_banks = List[UInt]()
          val x18067_rd_x3920_ofs = List[UInt]()
          val x18067_rd_x3920_en = List[Bool](true.B)
          x18067_rd_x3920.toSeq.zip(x3920_reg.connectRPort(18067, x18067_rd_x3920_banks, x18067_rd_x3920_ofs, io.sigsIn.backpressure, x18067_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x18099 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18099""")
          x18099.r := Math.arith_right_shift(b18019, 4, Some(0.2), true.B,"x18099").r
          val x18102 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18102""")
          x18102.r := Math.arith_right_shift(b18020, 4, Some(0.2), true.B,"x18102").r
          val x18105 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18105""")
          x18105.r := Math.arith_right_shift(b18021, 4, Some(0.2), true.B,"x18105").r
          val x18108 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18108""")
          x18108.r := Math.arith_right_shift(b18022, 4, Some(0.2), true.B,"x18108").r
          val x18111 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18111""")
          x18111.r := Math.arith_right_shift(b18023, 4, Some(0.2), true.B,"x18111").r
          val x18114 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18114""")
          x18114.r := Math.arith_right_shift(b18024, 4, Some(0.2), true.B,"x18114").r
          val x18117 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18117""")
          x18117.r := Math.arith_right_shift(b18025, 4, Some(0.2), true.B,"x18117").r
          val x18120 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18120""")
          x18120.r := Math.arith_right_shift(b18026, 4, Some(0.2), true.B,"x18120").r
          val x18123 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18123""")
          x18123.r := Math.arith_right_shift(b18027, 4, Some(0.2), true.B,"x18123").r
          val x18126 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18126""")
          x18126.r := Math.arith_right_shift(b18028, 4, Some(0.2), true.B,"x18126").r
          val x18129 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18129""")
          x18129.r := Math.arith_right_shift(b18029, 4, Some(0.2), true.B,"x18129").r
          val x18132 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18132""")
          x18132.r := Math.arith_right_shift(b18030, 4, Some(0.2), true.B,"x18132").r
          val x18135 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18135""")
          x18135.r := Math.arith_right_shift(b18031, 4, Some(0.2), true.B,"x18135").r
          val x18138 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18138""")
          x18138.r := Math.arith_right_shift(b18032, 4, Some(0.2), true.B,"x18138").r
          val x18141 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18141""")
          x18141.r := Math.arith_right_shift(b18033, 4, Some(0.2), true.B,"x18141").r
          val x18144 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18144""")
          x18144.r := Math.arith_right_shift(b18034, 4, Some(0.2), true.B,"x18144").r
          val x18147_rd = Wire(Vec(16, new FixedPoint(true, 10, 22))).suggestName("""x18147_rd""")
          def create_x18147_rd_banks(): List[UInt] = {
            val x18147_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x18147_rd_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x18147_rd_banks0 ++ x18147_rd_banks1
          }
          val x18147_rd_banks = create_x18147_rd_banks()
          def create_x18147_rd_ofs(): List[UInt] = {
            val x18147_rd_ofs0 = List[UInt](x18099.r,x18102.r,x18105.r,x18108.r,x18111.r,x18114.r,x18117.r,x18120.r,x18123.r,x18126.r,x18129.r,x18132.r,x18135.r,x18138.r,x18141.r,x18144.r)
            x18147_rd_ofs0
          }
          val x18147_rd_ofs = create_x18147_rd_ofs()
          val x18147_rd_en = List[Bool](b18035,b18036,b18037,b18038,b18039,b18040,b18041,b18042,b18043,b18044,b18045,b18046,b18047,b18048,b18049,b18050)
          x18147_rd.toSeq.zip(x17748_feature_map_a_0.connectRPort(18147, x18147_rd_banks, x18147_rd_ofs, io.sigsIn.backpressure, x18147_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && x18067_rd_x3920 & x18051_rd_x9467 & b17747), true)).foreach{case (a,b) => a := b}
          val x18148_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18148_elem_0""")
          x18148_elem_0.r := x18147_rd(0).r
          val x18149_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18149_elem_1""")
          x18149_elem_1.r := x18147_rd(1).r
          val x18150_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18150_elem_2""")
          x18150_elem_2.r := x18147_rd(2).r
          val x18151_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18151_elem_3""")
          x18151_elem_3.r := x18147_rd(3).r
          val x18152_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18152_elem_4""")
          x18152_elem_4.r := x18147_rd(4).r
          val x18153_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18153_elem_5""")
          x18153_elem_5.r := x18147_rd(5).r
          val x18154_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18154_elem_6""")
          x18154_elem_6.r := x18147_rd(6).r
          val x18155_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18155_elem_7""")
          x18155_elem_7.r := x18147_rd(7).r
          val x18156_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18156_elem_8""")
          x18156_elem_8.r := x18147_rd(8).r
          val x18157_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18157_elem_9""")
          x18157_elem_9.r := x18147_rd(9).r
          val x18158_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18158_elem_10""")
          x18158_elem_10.r := x18147_rd(10).r
          val x18159_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18159_elem_11""")
          x18159_elem_11.r := x18147_rd(11).r
          val x18160_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18160_elem_12""")
          x18160_elem_12.r := x18147_rd(12).r
          val x18161_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18161_elem_13""")
          x18161_elem_13.r := x18147_rd(13).r
          val x18162_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18162_elem_14""")
          x18162_elem_14.r := x18147_rd(14).r
          Map[String,Any]("x18051_rd_x9467" -> x18051_rd_x9467, "x18067_rd_x3920" -> x18067_rd_x3920, "x18099" -> x18099, "x18102" -> x18102, "x18105" -> x18105, "x18108" -> x18108, "x18111" -> x18111, "x18114" -> x18114, "x18117" -> x18117, "x18120" -> x18120, "x18123" -> x18123, "x18126" -> x18126, "x18129" -> x18129, "x18132" -> x18132, "x18135" -> x18135, "x18138" -> x18138, "x18141" -> x18141, "x18144" -> x18144, "x18147_rd" -> x18147_rd, "x18148_elem_0" -> x18148_elem_0, "x18149_elem_1" -> x18149_elem_1, "x18150_elem_2" -> x18150_elem_2, "x18151_elem_3" -> x18151_elem_3, "x18152_elem_4" -> x18152_elem_4, "x18153_elem_5" -> x18153_elem_5, "x18154_elem_6" -> x18154_elem_6, "x18155_elem_7" -> x18155_elem_7, "x18156_elem_8" -> x18156_elem_8, "x18157_elem_9" -> x18157_elem_9, "x18158_elem_10" -> x18158_elem_10, "x18159_elem_11" -> x18159_elem_11, "x18160_elem_12" -> x18160_elem_12, "x18161_elem_13" -> x18161_elem_13, "x18162_elem_14" -> x18162_elem_14)
        }
      }
      val block1chunk0: Map[String, Any] = Block1Chunker0.gen()
      object Block1Chunker1 { // 34 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x18163_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18163_elem_15""")
          x18163_elem_15.r := block1chunk0("x18147_rd").asInstanceOf[Vec[FixedPoint]](15).r
          val x18164_rd = Wire(Vec(16, new FixedPoint(true, 10, 22))).suggestName("""x18164_rd""")
          def create_x18164_rd_banks(): List[UInt] = {
            val x18164_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x18164_rd_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x18164_rd_banks0 ++ x18164_rd_banks1
          }
          val x18164_rd_banks = create_x18164_rd_banks()
          def create_x18164_rd_ofs(): List[UInt] = {
            val x18164_rd_ofs0 = List[UInt](block1chunk0("x18099").asInstanceOf[FixedPoint].r,block1chunk0("x18102").asInstanceOf[FixedPoint].r,block1chunk0("x18105").asInstanceOf[FixedPoint].r)
            val x18164_rd_ofs1 = List[UInt](block1chunk0("x18108").asInstanceOf[FixedPoint].r,block1chunk0("x18111").asInstanceOf[FixedPoint].r,block1chunk0("x18114").asInstanceOf[FixedPoint].r)
            val x18164_rd_ofs2 = List[UInt](block1chunk0("x18117").asInstanceOf[FixedPoint].r,block1chunk0("x18120").asInstanceOf[FixedPoint].r,block1chunk0("x18123").asInstanceOf[FixedPoint].r)
            val x18164_rd_ofs3 = List[UInt](block1chunk0("x18126").asInstanceOf[FixedPoint].r,block1chunk0("x18129").asInstanceOf[FixedPoint].r,block1chunk0("x18132").asInstanceOf[FixedPoint].r)
            val x18164_rd_ofs4 = List[UInt](block1chunk0("x18135").asInstanceOf[FixedPoint].r,block1chunk0("x18138").asInstanceOf[FixedPoint].r,block1chunk0("x18141").asInstanceOf[FixedPoint].r)
            val x18164_rd_ofs5 = List[UInt](block1chunk0("x18144").asInstanceOf[FixedPoint].r)
            x18164_rd_ofs0 ++ x18164_rd_ofs1 ++ x18164_rd_ofs2 ++ x18164_rd_ofs3 ++ x18164_rd_ofs4 ++ x18164_rd_ofs5
          }
          val x18164_rd_ofs = create_x18164_rd_ofs()
          val x18164_rd_en = List[Bool](b18035,b18036,b18037,b18038,b18039,b18040,b18041,b18042,b18043,b18044,b18045,b18046,b18047,b18048,b18049,b18050)
          x18164_rd.toSeq.zip(x17881_feature_map_b_0.connectRPort(18164, x18164_rd_banks, x18164_rd_ofs, io.sigsIn.backpressure, x18164_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x18067_rd_x3920").asInstanceOf[Bool] & block1chunk0("x18051_rd_x9467").asInstanceOf[Bool] & b17747), true)).foreach{case (a,b) => a := b}
          val x18165_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18165_elem_0""")
          x18165_elem_0.r := x18164_rd(0).r
          val x18166_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18166_elem_1""")
          x18166_elem_1.r := x18164_rd(1).r
          val x18167_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18167_elem_2""")
          x18167_elem_2.r := x18164_rd(2).r
          val x18168_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18168_elem_3""")
          x18168_elem_3.r := x18164_rd(3).r
          val x18169_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18169_elem_4""")
          x18169_elem_4.r := x18164_rd(4).r
          val x18170_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18170_elem_5""")
          x18170_elem_5.r := x18164_rd(5).r
          val x18171_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18171_elem_6""")
          x18171_elem_6.r := x18164_rd(6).r
          val x18172_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18172_elem_7""")
          x18172_elem_7.r := x18164_rd(7).r
          val x18173_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18173_elem_8""")
          x18173_elem_8.r := x18164_rd(8).r
          val x18174_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18174_elem_9""")
          x18174_elem_9.r := x18164_rd(9).r
          val x18175_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18175_elem_10""")
          x18175_elem_10.r := x18164_rd(10).r
          val x18176_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18176_elem_11""")
          x18176_elem_11.r := x18164_rd(11).r
          val x18177_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18177_elem_12""")
          x18177_elem_12.r := x18164_rd(12).r
          val x18178_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18178_elem_13""")
          x18178_elem_13.r := x18164_rd(13).r
          val x18179_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18179_elem_14""")
          x18179_elem_14.r := x18164_rd(14).r
          val x18180_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18180_elem_15""")
          x18180_elem_15.r := x18164_rd(15).r
          val x18181_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18181_sum""")
          x18181_sum.r := Math.add(block1chunk0("x18148_elem_0").asInstanceOf[FixedPoint],x18165_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x18181_sum").r
          val x18182_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18182_sum""")
          x18182_sum.r := Math.add(block1chunk0("x18149_elem_1").asInstanceOf[FixedPoint],x18166_elem_1,Some(1.0), true.B, Truncate, Wrapping, "x18182_sum").r
          val x18183_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18183_sum""")
          x18183_sum.r := Math.add(block1chunk0("x18150_elem_2").asInstanceOf[FixedPoint],x18167_elem_2,Some(1.0), true.B, Truncate, Wrapping, "x18183_sum").r
          val x18184_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18184_sum""")
          x18184_sum.r := Math.add(block1chunk0("x18151_elem_3").asInstanceOf[FixedPoint],x18168_elem_3,Some(1.0), true.B, Truncate, Wrapping, "x18184_sum").r
          val x18185_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18185_sum""")
          x18185_sum.r := Math.add(block1chunk0("x18152_elem_4").asInstanceOf[FixedPoint],x18169_elem_4,Some(1.0), true.B, Truncate, Wrapping, "x18185_sum").r
          val x18186_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18186_sum""")
          x18186_sum.r := Math.add(block1chunk0("x18153_elem_5").asInstanceOf[FixedPoint],x18170_elem_5,Some(1.0), true.B, Truncate, Wrapping, "x18186_sum").r
          val x18187_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18187_sum""")
          x18187_sum.r := Math.add(block1chunk0("x18154_elem_6").asInstanceOf[FixedPoint],x18171_elem_6,Some(1.0), true.B, Truncate, Wrapping, "x18187_sum").r
          val x18188_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18188_sum""")
          x18188_sum.r := Math.add(block1chunk0("x18155_elem_7").asInstanceOf[FixedPoint],x18172_elem_7,Some(1.0), true.B, Truncate, Wrapping, "x18188_sum").r
          val x18189_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18189_sum""")
          x18189_sum.r := Math.add(block1chunk0("x18156_elem_8").asInstanceOf[FixedPoint],x18173_elem_8,Some(1.0), true.B, Truncate, Wrapping, "x18189_sum").r
          val x18190_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18190_sum""")
          x18190_sum.r := Math.add(block1chunk0("x18157_elem_9").asInstanceOf[FixedPoint],x18174_elem_9,Some(1.0), true.B, Truncate, Wrapping, "x18190_sum").r
          val x18191_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18191_sum""")
          x18191_sum.r := Math.add(block1chunk0("x18158_elem_10").asInstanceOf[FixedPoint],x18175_elem_10,Some(1.0), true.B, Truncate, Wrapping, "x18191_sum").r
          val x18192_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18192_sum""")
          x18192_sum.r := Math.add(block1chunk0("x18159_elem_11").asInstanceOf[FixedPoint],x18176_elem_11,Some(1.0), true.B, Truncate, Wrapping, "x18192_sum").r
          val x18193_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18193_sum""")
          x18193_sum.r := Math.add(block1chunk0("x18160_elem_12").asInstanceOf[FixedPoint],x18177_elem_12,Some(1.0), true.B, Truncate, Wrapping, "x18193_sum").r
          val x18194_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18194_sum""")
          x18194_sum.r := Math.add(block1chunk0("x18161_elem_13").asInstanceOf[FixedPoint],x18178_elem_13,Some(1.0), true.B, Truncate, Wrapping, "x18194_sum").r
          val x18195_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18195_sum""")
          x18195_sum.r := Math.add(block1chunk0("x18162_elem_14").asInstanceOf[FixedPoint],x18179_elem_14,Some(1.0), true.B, Truncate, Wrapping, "x18195_sum").r
          val x18196_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18196_sum""")
          x18196_sum.r := Math.add(x18163_elem_15,x18180_elem_15,Some(1.0), true.B, Truncate, Wrapping, "x18196_sum").r
          Map[String,Any]("x18181_sum" -> x18181_sum, "x18182_sum" -> x18182_sum, "x18183_sum" -> x18183_sum, "x18184_sum" -> x18184_sum, "x18185_sum" -> x18185_sum, "x18186_sum" -> x18186_sum, "x18187_sum" -> x18187_sum, "x18188_sum" -> x18188_sum, "x18189_sum" -> x18189_sum, "x18190_sum" -> x18190_sum, "x18191_sum" -> x18191_sum, "x18192_sum" -> x18192_sum, "x18193_sum" -> x18193_sum, "x18194_sum" -> x18194_sum, "x18195_sum" -> x18195_sum, "x18196_sum" -> x18196_sum)
        }
      }
      val block1chunk1: Map[String, Any] = Block1Chunker1.gen()
      object Block1Chunker2 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x18197 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18197""")
          x18197.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18181_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18181_sum").asInstanceOf[FixedPoint]).r
          val x18198 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18198""")
          x18198.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18182_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18182_sum").asInstanceOf[FixedPoint]).r
          val x18199 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18199""")
          x18199.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18183_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18183_sum").asInstanceOf[FixedPoint]).r
          val x18200 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18200""")
          x18200.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18184_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18184_sum").asInstanceOf[FixedPoint]).r
          val x18201 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18201""")
          x18201.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18185_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18185_sum").asInstanceOf[FixedPoint]).r
          val x18202 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18202""")
          x18202.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18186_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18186_sum").asInstanceOf[FixedPoint]).r
          val x18203 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18203""")
          x18203.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18187_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18187_sum").asInstanceOf[FixedPoint]).r
          val x18204 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18204""")
          x18204.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18188_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18188_sum").asInstanceOf[FixedPoint]).r
          val x18205 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18205""")
          x18205.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18189_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18189_sum").asInstanceOf[FixedPoint]).r
          val x18206 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18206""")
          x18206.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18190_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18190_sum").asInstanceOf[FixedPoint]).r
          val x18207 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18207""")
          x18207.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18191_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18191_sum").asInstanceOf[FixedPoint]).r
          val x18208 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18208""")
          x18208.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18192_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18192_sum").asInstanceOf[FixedPoint]).r
          val x18209 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18209""")
          x18209.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18193_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18193_sum").asInstanceOf[FixedPoint]).r
          val x18210 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18210""")
          x18210.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18194_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18194_sum").asInstanceOf[FixedPoint]).r
          val x18211 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18211""")
          x18211.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18195_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18195_sum").asInstanceOf[FixedPoint]).r
          val x18212 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18212""")
          x18212.r := Mux((0.FP(true, 10, 22) > block1chunk1("x18196_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x18196_sum").asInstanceOf[FixedPoint]).r
          val x21930 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21930_x18129_D3") 
          x21930.r := getRetimed(block1chunk0("x18129").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21931 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21931_x18114_D3") 
          x21931.r := getRetimed(block1chunk0("x18114").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21932 = Wire(Bool()).suggestName("x21932_b18050_D3") 
          x21932.r := getRetimed(b18050.r, 3.toInt, io.sigsIn.backpressure)
          val x21933 = Wire(Bool()).suggestName("x21933_b18040_D3") 
          x21933.r := getRetimed(b18040.r, 3.toInt, io.sigsIn.backpressure)
          val x21934 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21934_x18120_D3") 
          x21934.r := getRetimed(block1chunk0("x18120").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21935 = Wire(Bool()).suggestName("x21935_b18043_D3") 
          x21935.r := getRetimed(b18043.r, 3.toInt, io.sigsIn.backpressure)
          val x21936 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21936_x18111_D3") 
          x21936.r := getRetimed(block1chunk0("x18111").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21937 = Wire(Bool()).suggestName("x21937_b17747_D3") 
          x21937.r := getRetimed(b17747.r, 3.toInt, io.sigsIn.backpressure)
          val x21938 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21938_x18126_D3") 
          x21938.r := getRetimed(block1chunk0("x18126").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21939 = Wire(Bool()).suggestName("x21939_b18037_D3") 
          x21939.r := getRetimed(b18037.r, 3.toInt, io.sigsIn.backpressure)
          val x21940 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21940_x18123_D3") 
          x21940.r := getRetimed(block1chunk0("x18123").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21941 = Wire(Bool()).suggestName("x21941_b18047_D3") 
          x21941.r := getRetimed(b18047.r, 3.toInt, io.sigsIn.backpressure)
          val x21942 = Wire(Bool()).suggestName("x21942_b18036_D3") 
          x21942.r := getRetimed(b18036.r, 3.toInt, io.sigsIn.backpressure)
          val x21943 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21943_x18108_D3") 
          x21943.r := getRetimed(block1chunk0("x18108").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21944 = Wire(Bool()).suggestName("x21944_b18039_D3") 
          x21944.r := getRetimed(b18039.r, 3.toInt, io.sigsIn.backpressure)
          val x21945 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21945_x18132_D3") 
          x21945.r := getRetimed(block1chunk0("x18132").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21946 = Wire(Bool()).suggestName("x21946_b18044_D3") 
          x21946.r := getRetimed(b18044.r, 3.toInt, io.sigsIn.backpressure)
          val x21947 = Wire(Bool()).suggestName("x21947_b18049_D3") 
          x21947.r := getRetimed(b18049.r, 3.toInt, io.sigsIn.backpressure)
          val x21948 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21948_x18144_D3") 
          x21948.r := getRetimed(block1chunk0("x18144").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21949 = Wire(Bool()).suggestName("x21949_b18048_D3") 
          x21949.r := getRetimed(b18048.r, 3.toInt, io.sigsIn.backpressure)
          val x21950 = Wire(Bool()).suggestName("x21950_b18038_D3") 
          x21950.r := getRetimed(b18038.r, 3.toInt, io.sigsIn.backpressure)
          val x21951 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21951_x18135_D3") 
          x21951.r := getRetimed(block1chunk0("x18135").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21952 = Wire(Bool()).suggestName("x21952_b18035_D3") 
          x21952.r := getRetimed(b18035.r, 3.toInt, io.sigsIn.backpressure)
          val x21953 = Wire(Bool()).suggestName("x21953_x18067_rd_x3920_D3") 
          x21953.r := getRetimed(block1chunk0("x18067_rd_x3920").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x21954 = Wire(Bool()).suggestName("x21954_b18045_D3") 
          x21954.r := getRetimed(b18045.r, 3.toInt, io.sigsIn.backpressure)
          val x21955 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21955_x18105_D3") 
          x21955.r := getRetimed(block1chunk0("x18105").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21956 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21956_x18099_D3") 
          x21956.r := getRetimed(block1chunk0("x18099").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21957 = Wire(Bool()).suggestName("x21957_b18041_D3") 
          x21957.r := getRetimed(b18041.r, 3.toInt, io.sigsIn.backpressure)
          val x21958 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21958_x18141_D3") 
          x21958.r := getRetimed(block1chunk0("x18141").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21959 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21959_x18102_D3") 
          x21959.r := getRetimed(block1chunk0("x18102").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21960 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21960_x18117_D3") 
          x21960.r := getRetimed(block1chunk0("x18117").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          val x21961 = Wire(Bool()).suggestName("x21961_x18051_rd_x9467_D3") 
          x21961.r := getRetimed(block1chunk0("x18051_rd_x9467").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x21962 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21962_x18138_D3") 
          x21962.r := getRetimed(block1chunk0("x18138").asInstanceOf[FixedPoint].r, 3.toInt, io.sigsIn.backpressure)
          Map[String,Any]("x18197" -> x18197, "x18198" -> x18198, "x18199" -> x18199, "x18200" -> x18200, "x18201" -> x18201, "x18202" -> x18202, "x18203" -> x18203, "x18204" -> x18204, "x18205" -> x18205, "x18206" -> x18206, "x18207" -> x18207, "x18208" -> x18208, "x18209" -> x18209, "x18210" -> x18210, "x18211" -> x18211, "x18212" -> x18212, "x21930" -> x21930, "x21931" -> x21931, "x21932" -> x21932, "x21933" -> x21933, "x21934" -> x21934, "x21935" -> x21935, "x21936" -> x21936, "x21937" -> x21937, "x21938" -> x21938, "x21939" -> x21939, "x21940" -> x21940, "x21941" -> x21941, "x21942" -> x21942, "x21943" -> x21943, "x21944" -> x21944, "x21945" -> x21945, "x21946" -> x21946, "x21947" -> x21947, "x21948" -> x21948, "x21949" -> x21949, "x21950" -> x21950, "x21951" -> x21951, "x21952" -> x21952, "x21953" -> x21953, "x21954" -> x21954, "x21955" -> x21955, "x21956" -> x21956, "x21957" -> x21957, "x21958" -> x21958, "x21959" -> x21959, "x21960" -> x21960, "x21961" -> x21961, "x21962" -> x21962)
        }
      }
      val block1chunk2: Map[String, Any] = Block1Chunker2.gen()
      object Block1Chunker3 { // 3 nodes, 18 weight
        def gen(): Map[String, Any] = {
          val x21963 = Wire(Bool()).suggestName("x21963_b18046_D3") 
          x21963.r := getRetimed(b18046.r, 3.toInt, io.sigsIn.backpressure)
          val x21964 = Wire(Bool()).suggestName("x21964_b18042_D3") 
          x21964.r := getRetimed(b18042.r, 3.toInt, io.sigsIn.backpressure)
          def create_x18213_wr_banks(): List[UInt] = {
            val x18213_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
            val x18213_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
            x18213_wr_banks0 ++ x18213_wr_banks1
          }
          val x18213_wr_banks = create_x18213_wr_banks()
          def create_x18213_wr_ofs(): List[UInt] = {
            val x18213_wr_ofs0 = List[UInt](block1chunk2("x21956").asInstanceOf[FixedPoint].r,block1chunk2("x21959").asInstanceOf[FixedPoint].r,block1chunk2("x21955").asInstanceOf[FixedPoint].r)
            val x18213_wr_ofs1 = List[UInt](block1chunk2("x21943").asInstanceOf[FixedPoint].r,block1chunk2("x21936").asInstanceOf[FixedPoint].r,block1chunk2("x21931").asInstanceOf[FixedPoint].r)
            val x18213_wr_ofs2 = List[UInt](block1chunk2("x21960").asInstanceOf[FixedPoint].r,block1chunk2("x21934").asInstanceOf[FixedPoint].r,block1chunk2("x21940").asInstanceOf[FixedPoint].r)
            val x18213_wr_ofs3 = List[UInt](block1chunk2("x21938").asInstanceOf[FixedPoint].r,block1chunk2("x21930").asInstanceOf[FixedPoint].r,block1chunk2("x21945").asInstanceOf[FixedPoint].r)
            val x18213_wr_ofs4 = List[UInt](block1chunk2("x21951").asInstanceOf[FixedPoint].r,block1chunk2("x21962").asInstanceOf[FixedPoint].r,block1chunk2("x21958").asInstanceOf[FixedPoint].r)
            val x18213_wr_ofs5 = List[UInt](block1chunk2("x21948").asInstanceOf[FixedPoint].r)
            x18213_wr_ofs0 ++ x18213_wr_ofs1 ++ x18213_wr_ofs2 ++ x18213_wr_ofs3 ++ x18213_wr_ofs4 ++ x18213_wr_ofs5
          }
          val x18213_wr_ofs = create_x18213_wr_ofs()
          def create_x18213_wr_en(): List[Bool] = {
            val x18213_wr_en0 = List[Bool](block1chunk2("x21952").asInstanceOf[Bool],block1chunk2("x21942").asInstanceOf[Bool],block1chunk2("x21939").asInstanceOf[Bool],block1chunk2("x21950").asInstanceOf[Bool])
            val x18213_wr_en1 = List[Bool](block1chunk2("x21944").asInstanceOf[Bool],block1chunk2("x21933").asInstanceOf[Bool],block1chunk2("x21957").asInstanceOf[Bool],x21964)
            val x18213_wr_en2 = List[Bool](block1chunk2("x21935").asInstanceOf[Bool],block1chunk2("x21946").asInstanceOf[Bool],block1chunk2("x21954").asInstanceOf[Bool],x21963)
            val x18213_wr_en3 = List[Bool](block1chunk2("x21941").asInstanceOf[Bool],block1chunk2("x21949").asInstanceOf[Bool],block1chunk2("x21947").asInstanceOf[Bool],block1chunk2("x21932").asInstanceOf[Bool])
            x18213_wr_en0 ++ x18213_wr_en1 ++ x18213_wr_en2 ++ x18213_wr_en3
          }
          val x18213_wr_en = create_x18213_wr_en()
          def create_x18213_wr_data(): List[UInt] = {
            val x18213_wr_data0 = List[UInt](block1chunk2("x18197").asInstanceOf[FixedPoint].r,block1chunk2("x18198").asInstanceOf[FixedPoint].r,block1chunk2("x18199").asInstanceOf[FixedPoint].r)
            val x18213_wr_data1 = List[UInt](block1chunk2("x18200").asInstanceOf[FixedPoint].r,block1chunk2("x18201").asInstanceOf[FixedPoint].r,block1chunk2("x18202").asInstanceOf[FixedPoint].r)
            val x18213_wr_data2 = List[UInt](block1chunk2("x18203").asInstanceOf[FixedPoint].r,block1chunk2("x18204").asInstanceOf[FixedPoint].r,block1chunk2("x18205").asInstanceOf[FixedPoint].r)
            val x18213_wr_data3 = List[UInt](block1chunk2("x18206").asInstanceOf[FixedPoint].r,block1chunk2("x18207").asInstanceOf[FixedPoint].r,block1chunk2("x18208").asInstanceOf[FixedPoint].r)
            val x18213_wr_data4 = List[UInt](block1chunk2("x18209").asInstanceOf[FixedPoint].r,block1chunk2("x18210").asInstanceOf[FixedPoint].r,block1chunk2("x18211").asInstanceOf[FixedPoint].r)
            val x18213_wr_data5 = List[UInt](block1chunk2("x18212").asInstanceOf[FixedPoint].r)
            x18213_wr_data0 ++ x18213_wr_data1 ++ x18213_wr_data2 ++ x18213_wr_data3 ++ x18213_wr_data4 ++ x18213_wr_data5
          }
          val x18213_wr_data = create_x18213_wr_data()
          x18014_feature_map_sum_0.connectWPort(18213, x18213_wr_banks, x18213_wr_ofs, x18213_wr_data, x18213_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && block1chunk2("x21953").asInstanceOf[Bool] & block1chunk2("x21961").asInstanceOf[Bool] & block1chunk2("x21937").asInstanceOf[Bool]))
          Map[String,Any]()
        }
      }
      val block1chunk3: Map[String, Any] = Block1Chunker3.gen()
      x17748_feature_map_a_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 2)
      x17881_feature_map_b_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x18014_feature_map_sum_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x18214_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x18214_inr_Foreach **/
