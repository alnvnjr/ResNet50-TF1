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

/** Hierarchy: x3863 -> x3897 -> x3898 -> x1256 **/
/** BEGIN None x3863_inr_Foreach **/
class x3863_inr_Foreach_kernel(
  list_b3121: List[Bool],
  list_b3120: List[FixedPoint],
  list_x3131_tmp0_SRAM_conv_9: List[NBufInterface],
  list_x3098_c27_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 13.7.toInt, myName = "x3863_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3863_inr_Foreach_iiCtr"))
  
  abstract class x3863_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3098_c27_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3098_c27_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_b3120 = Input(new FixedPoint(true, 32, 0))
      val in_b3121 = Input(Bool())
      val in_x3131_tmp0_SRAM_conv_9 = Flipped(new NBufInterface(ModuleParams.getParams("x3131_tmp0_SRAM_conv_9_p").asInstanceOf[NBufParams] ))
      val in_x3125_tmp0_SRAM_conv_3 = Flipped(new NBufInterface(ModuleParams.getParams("x3125_tmp0_SRAM_conv_3_p").asInstanceOf[NBufParams] ))
      val in_x3122_tmp0_SRAM_conv_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3122_tmp0_SRAM_conv_0_p").asInstanceOf[NBufParams] ))
      val in_b3704 = Input(Bool())
      val in_b3703 = Input(new FixedPoint(true, 32, 0))
      val in_x3126_tmp0_SRAM_conv_4 = Flipped(new NBufInterface(ModuleParams.getParams("x3126_tmp0_SRAM_conv_4_p").asInstanceOf[NBufParams] ))
      val in_x3130_tmp0_SRAM_conv_8 = Flipped(new NBufInterface(ModuleParams.getParams("x3130_tmp0_SRAM_conv_8_p").asInstanceOf[NBufParams] ))
      val in_x3123_tmp0_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x3123_tmp0_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_x3127_tmp0_SRAM_conv_5 = Flipped(new NBufInterface(ModuleParams.getParams("x3127_tmp0_SRAM_conv_5_p").asInstanceOf[NBufParams] ))
      val in_x3124_tmp0_SRAM_conv_2 = Flipped(new NBufInterface(ModuleParams.getParams("x3124_tmp0_SRAM_conv_2_p").asInstanceOf[NBufParams] ))
      val in_x3705_tmp0_SRAM_pool_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3705_tmp0_SRAM_pool_0_p").asInstanceOf[NBufParams] ))
      val in_x3128_tmp0_SRAM_conv_6 = Flipped(new NBufInterface(ModuleParams.getParams("x3128_tmp0_SRAM_conv_6_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1, 1), List(32, 32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3098_c27_SRAM_0 = {io.in_x3098_c27_SRAM_0} ; io.in_x3098_c27_SRAM_0 := DontCare
    def b3120 = {io.in_b3120} 
    def b3121 = {io.in_b3121} 
    def x3131_tmp0_SRAM_conv_9 = {io.in_x3131_tmp0_SRAM_conv_9} ; io.in_x3131_tmp0_SRAM_conv_9 := DontCare
    def x3125_tmp0_SRAM_conv_3 = {io.in_x3125_tmp0_SRAM_conv_3} ; io.in_x3125_tmp0_SRAM_conv_3 := DontCare
    def x3122_tmp0_SRAM_conv_0 = {io.in_x3122_tmp0_SRAM_conv_0} ; io.in_x3122_tmp0_SRAM_conv_0 := DontCare
    def b3704 = {io.in_b3704} 
    def b3703 = {io.in_b3703} 
    def x3126_tmp0_SRAM_conv_4 = {io.in_x3126_tmp0_SRAM_conv_4} ; io.in_x3126_tmp0_SRAM_conv_4 := DontCare
    def x3130_tmp0_SRAM_conv_8 = {io.in_x3130_tmp0_SRAM_conv_8} ; io.in_x3130_tmp0_SRAM_conv_8 := DontCare
    def x3123_tmp0_SRAM_conv_1 = {io.in_x3123_tmp0_SRAM_conv_1} ; io.in_x3123_tmp0_SRAM_conv_1 := DontCare
    def x3127_tmp0_SRAM_conv_5 = {io.in_x3127_tmp0_SRAM_conv_5} ; io.in_x3127_tmp0_SRAM_conv_5 := DontCare
    def x3124_tmp0_SRAM_conv_2 = {io.in_x3124_tmp0_SRAM_conv_2} ; io.in_x3124_tmp0_SRAM_conv_2 := DontCare
    def x3705_tmp0_SRAM_pool_0 = {io.in_x3705_tmp0_SRAM_pool_0} ; io.in_x3705_tmp0_SRAM_pool_0 := DontCare
    def x3128_tmp0_SRAM_conv_6 = {io.in_x3128_tmp0_SRAM_conv_6} ; io.in_x3128_tmp0_SRAM_conv_6 := DontCare
  }
  def connectWires0(module: x3863_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x3098_c27_SRAM_0.connectLedger(module.io.in_x3098_c27_SRAM_0)
    module.io.in_b3120 <> b3120
    module.io.in_b3121 <> b3121
    x3131_tmp0_SRAM_conv_9.connectLedger(module.io.in_x3131_tmp0_SRAM_conv_9)
    x3125_tmp0_SRAM_conv_3.connectLedger(module.io.in_x3125_tmp0_SRAM_conv_3)
    x3122_tmp0_SRAM_conv_0.connectLedger(module.io.in_x3122_tmp0_SRAM_conv_0)
    module.io.in_b3704 <> b3704
    module.io.in_b3703 <> b3703
    x3126_tmp0_SRAM_conv_4.connectLedger(module.io.in_x3126_tmp0_SRAM_conv_4)
    x3130_tmp0_SRAM_conv_8.connectLedger(module.io.in_x3130_tmp0_SRAM_conv_8)
    x3123_tmp0_SRAM_conv_1.connectLedger(module.io.in_x3123_tmp0_SRAM_conv_1)
    x3127_tmp0_SRAM_conv_5.connectLedger(module.io.in_x3127_tmp0_SRAM_conv_5)
    x3124_tmp0_SRAM_conv_2.connectLedger(module.io.in_x3124_tmp0_SRAM_conv_2)
    x3705_tmp0_SRAM_pool_0.connectLedger(module.io.in_x3705_tmp0_SRAM_pool_0)
    x3128_tmp0_SRAM_conv_6.connectLedger(module.io.in_x3128_tmp0_SRAM_conv_6)
  }
  val b3121 = list_b3121(0)
  val b3704 = list_b3121(1)
  val b3120 = list_b3120(0)
  val b3703 = list_b3120(1)
  val x3131_tmp0_SRAM_conv_9 = list_x3131_tmp0_SRAM_conv_9(0)
  val x3125_tmp0_SRAM_conv_3 = list_x3131_tmp0_SRAM_conv_9(1)
  val x3122_tmp0_SRAM_conv_0 = list_x3131_tmp0_SRAM_conv_9(2)
  val x3126_tmp0_SRAM_conv_4 = list_x3131_tmp0_SRAM_conv_9(3)
  val x3130_tmp0_SRAM_conv_8 = list_x3131_tmp0_SRAM_conv_9(4)
  val x3123_tmp0_SRAM_conv_1 = list_x3131_tmp0_SRAM_conv_9(5)
  val x3127_tmp0_SRAM_conv_5 = list_x3131_tmp0_SRAM_conv_9(6)
  val x3124_tmp0_SRAM_conv_2 = list_x3131_tmp0_SRAM_conv_9(7)
  val x3705_tmp0_SRAM_pool_0 = list_x3131_tmp0_SRAM_conv_9(8)
  val x3128_tmp0_SRAM_conv_6 = list_x3131_tmp0_SRAM_conv_9(9)
  val x3098_c27_SRAM_0 = list_x3098_c27_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3863_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3863_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3863_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3709 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b3709.suggestName("b3709")
      val b3710 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b3710.suggestName("b3710")
      val b3711 = ~io.sigsIn.cchainOutputs.head.oobs(0); b3711.suggestName("b3711")
      val b3712 = ~io.sigsIn.cchainOutputs.head.oobs(1); b3712.suggestName("b3712")
      object Block1Chunker0 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x3713 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3713""")
          x3713.r := Math.arith_left_shift(b3709, 1, Some(0.2), true.B,"x3713").r
          val x3714 = Wire(Bool()).suggestName("""x3714""")
          x3714.r := Math.lte(112L.FP(true, 32, 0), x3713, Some(0.4), true.B,"x3714").r
          val x3715 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3715""")
          x3715.r := Math.arith_left_shift(b3710, 1, Some(0.2), true.B,"x3715").r
          val x3716 = Wire(Bool()).suggestName("""x3716""")
          x3716.r := Math.lte(112L.FP(true, 32, 0), x3715, Some(0.4), true.B,"x3716").r
          val x3717 = Wire(Bool()).suggestName("""x3717""")
          x3717 := x3714 | x3716
          val x3718 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3718""")
          x3718.r := Mux((111L.FP(true, 32, 0) < x3713), 111L.FP(true, 32, 0), x3713).r
          val x3719 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3719""")
          x3719.r := Mux((111L.FP(true, 32, 0) < x3715), 111L.FP(true, 32, 0), x3715).r
          val x3723_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3723_mul""")
          x3723_mul.r := (Math.mul(x3718, 224L.FP(true, 32, 0), Some(6.0), true.B, Truncate, Wrapping, "x3723_mul")).r
          val x3724 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3724""")
          x3724.r := Math.arith_left_shift(x3719, 1, Some(0.2), true.B,"x3724").r
          val x19545 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19545_x3724_D6") 
          x19545.r := getRetimed(x3724.r, 6.toInt, io.sigsIn.backpressure)
          val x3725_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3725_sum""")
          x3725_sum.r := Math.add(x3723_mul,x19545,Some(1.0), true.B, Truncate, Wrapping, "x3725_sum").r
          val x19546 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19546_b3703_D7") 
          x19546.r := getRetimed(b3703.r, 7.toInt, io.sigsIn.backpressure)
          val x3726_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3726_sum""")
          x3726_sum.r := Math.add(x3725_sum,x19546,Some(1.0), true.B, Truncate, Wrapping, "x3726_sum").r
          val x19547 = Wire(Bool()).suggestName("x19547_b3121_D8") 
          x19547.r := getRetimed(b3121.r, 8.toInt, io.sigsIn.backpressure)
          val x19548 = Wire(Bool()).suggestName("x19548_b3712_D8") 
          x19548.r := getRetimed(b3712.r, 8.toInt, io.sigsIn.backpressure)
          val x19549 = Wire(Bool()).suggestName("x19549_b3711_D8") 
          x19549.r := getRetimed(b3711.r, 8.toInt, io.sigsIn.backpressure)
          val x19550 = Wire(Bool()).suggestName("x19550_b3704_D8") 
          x19550.r := getRetimed(b3704.r, 8.toInt, io.sigsIn.backpressure)
          val x3728_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3728_rd""")
          val x3728_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3728_rd_ofs = List[UInt](x3726_sum.r)
          val x3728_rd_en = List[Bool](true.B)
          x3728_rd.toSeq.zip(x3123_tmp0_SRAM_conv_1.connectRPort(3728, x3728_rd_banks, x3728_rd_ofs, io.sigsIn.backpressure, x3728_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.2.toInt, rr, io.sigsIn.backpressure) && x19549 & x19548 & x19550 & x19547), true)).foreach{case (a,b) => a := b}
          val x3729_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3729_elem_0""")
          x3729_elem_0.r := x3728_rd(0).r
          val x3730_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3730_sum""")
          x3730_sum.r := Math.add(b3120,b3703,Some(1.0), true.B, Truncate, Wrapping, "x3730_sum").r
          val x19551 = Wire(Bool()).suggestName("x19551_b3121_D1") 
          x19551.r := getRetimed(b3121.r, 1.toInt, io.sigsIn.backpressure)
          val x19552 = Wire(Bool()).suggestName("x19552_b3712_D1") 
          x19552.r := getRetimed(b3712.r, 1.toInt, io.sigsIn.backpressure)
          val x19553 = Wire(Bool()).suggestName("x19553_b3711_D1") 
          x19553.r := getRetimed(b3711.r, 1.toInt, io.sigsIn.backpressure)
          val x19554 = Wire(Bool()).suggestName("x19554_b3704_D1") 
          x19554.r := getRetimed(b3704.r, 1.toInt, io.sigsIn.backpressure)
          val x3733_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3733_rd""")
          val x3733_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3733_rd_ofs = List[UInt](x3730_sum.r)
          val x3733_rd_en = List[Bool](true.B)
          x3733_rd.toSeq.zip(x3098_c27_SRAM_0.connectRPort(3733, x3733_rd_banks, x3733_rd_ofs, io.sigsIn.backpressure, x3733_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) && x19553 & x19552 & x19554 & x19551), true)).foreach{case (a,b) => a := b}
          val x3734_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3734_elem_0""")
          x3734_elem_0.r := x3733_rd(0).r
          val x19555 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19555_x3734_elem_0_D7") 
          x19555.r := getRetimed(x3734_elem_0.r, 7.toInt, io.sigsIn.backpressure)
          val x3735_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3735_sum""")
          x3735_sum.r := Math.add(x3729_elem_0,x19555,Some(1.0), true.B, Truncate, Wrapping, "x3735_sum").r
          val x3736 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3736""")
          x3736.r := Mux((0.FP(true, 10, 22) > x3735_sum), 0.FP(true, 10, 22), x3735_sum).r
          val x19556 = Wire(Bool()).suggestName("x19556_x3717_D11") 
          x19556.r := getRetimed(x3717.r, 11.toInt, io.sigsIn.backpressure)
          val x3737 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3737""")
          x3737.r := Mux((x19556), 0.FP(true, 10, 22).r, x3736.r)
          val x3738_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3738_sum""")
          x3738_sum.r := Math.add(x3715,1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x3738_sum").r
          val x3739 = Wire(Bool()).suggestName("""x3739""")
          x3739.r := Math.lte(112L.FP(true, 32, 0), x3738_sum, Some(0.4), true.B,"x3739").r
          val x19557 = Wire(Bool()).suggestName("x19557_x3714_D1") 
          x19557.r := getRetimed(x3714.r, 1.toInt, io.sigsIn.backpressure)
          val x3740 = Wire(Bool()).suggestName("""x3740""")
          x3740 := x19557 | x3739
          val x3741 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3741""")
          x3741.r := Mux((111L.FP(true, 32, 0) < x3738_sum), 111L.FP(true, 32, 0), x3738_sum).r
          val x3745 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3745""")
          x3745.r := Math.arith_left_shift(x3741, 1, Some(0.2), true.B,"x3745").r
          val x19558 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19558_x3745_D5") 
          x19558.r := getRetimed(x3745.r, 5.toInt, io.sigsIn.backpressure)
          val x3746_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3746_sum""")
          x3746_sum.r := Math.add(x3723_mul,x19558,Some(1.0), true.B, Truncate, Wrapping, "x3746_sum").r
          val x3747_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3747_sum""")
          x3747_sum.r := Math.add(x3746_sum,x19546,Some(1.0), true.B, Truncate, Wrapping, "x3747_sum").r
          val x3749_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3749_rd""")
          val x3749_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3749_rd_ofs = List[UInt](x3747_sum.r)
          val x3749_rd_en = List[Bool](true.B)
          x3749_rd.toSeq.zip(x3127_tmp0_SRAM_conv_5.connectRPort(3749, x3749_rd_banks, x3749_rd_ofs, io.sigsIn.backpressure, x3749_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.2.toInt, rr, io.sigsIn.backpressure) && x19549 & x19548 & x19550 & x19547), true)).foreach{case (a,b) => a := b}
          val x3750_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3750_elem_0""")
          x3750_elem_0.r := x3749_rd(0).r
          val x3751_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3751_sum""")
          x3751_sum.r := Math.add(x3750_elem_0,x19555,Some(1.0), true.B, Truncate, Wrapping, "x3751_sum").r
          val x3752 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3752""")
          x3752.r := Mux((0.FP(true, 10, 22) > x3751_sum), 0.FP(true, 10, 22), x3751_sum).r
          val x19559 = Wire(Bool()).suggestName("x19559_x3740_D10") 
          x19559.r := getRetimed(x3740.r, 10.toInt, io.sigsIn.backpressure)
          val x3753 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3753""")
          x3753.r := Mux((x19559), 0.FP(true, 10, 22).r, x3752.r)
          val x3754_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3754_sum""")
          x3754_sum.r := Math.add(x3715,2L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x3754_sum").r
          val x3755 = Wire(Bool()).suggestName("""x3755""")
          x3755.r := Math.lte(112L.FP(true, 32, 0), x3754_sum, Some(0.4), true.B,"x3755").r
          val x3756 = Wire(Bool()).suggestName("""x3756""")
          x3756 := x19557 | x3755
          Map[String,Any]("x3713" -> x3713, "x3716" -> x3716, "x3723_mul" -> x3723_mul, "x3724" -> x3724, "x19546" -> x19546, "x19547" -> x19547, "x19548" -> x19548, "x19549" -> x19549, "x19550" -> x19550, "x3734_elem_0" -> x3734_elem_0, "x19555" -> x19555, "x3737" -> x3737, "x3739" -> x3739, "x3745" -> x3745, "x3753" -> x3753, "x3754_sum" -> x3754_sum, "x3755" -> x3755, "x3756" -> x3756)
        }
      }
      val block1chunk0: Map[String, Any] = Block1Chunker0.gen()
      object Block1Chunker1 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x3757 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3757""")
          x3757.r := Mux((111L.FP(true, 32, 0) < block1chunk0("x3754_sum").asInstanceOf[FixedPoint]), 111L.FP(true, 32, 0), block1chunk0("x3754_sum").asInstanceOf[FixedPoint]).r
          val x3761 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3761""")
          x3761.r := Math.arith_left_shift(x3757, 1, Some(0.2), true.B,"x3761").r
          val x19560 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19560_x3761_D5") 
          x19560.r := getRetimed(x3761.r, 5.toInt, io.sigsIn.backpressure)
          val x3762_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3762_sum""")
          x3762_sum.r := Math.add(block1chunk0("x3723_mul").asInstanceOf[FixedPoint],x19560,Some(1.0), true.B, Truncate, Wrapping, "x3762_sum").r
          val x3763_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3763_sum""")
          x3763_sum.r := Math.add(x3762_sum,block1chunk0("x19546").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3763_sum").r
          val x3765_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3765_rd""")
          val x3765_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3765_rd_ofs = List[UInt](x3763_sum.r)
          val x3765_rd_en = List[Bool](true.B)
          x3765_rd.toSeq.zip(x3125_tmp0_SRAM_conv_3.connectRPort(3765, x3765_rd_banks, x3765_rd_ofs, io.sigsIn.backpressure, x3765_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.2.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19549").asInstanceOf[Bool] & block1chunk0("x19548").asInstanceOf[Bool] & block1chunk0("x19550").asInstanceOf[Bool] & block1chunk0("x19547").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3766_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3766_elem_0""")
          x3766_elem_0.r := x3765_rd(0).r
          val x3767_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3767_sum""")
          x3767_sum.r := Math.add(x3766_elem_0,block1chunk0("x19555").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3767_sum").r
          val x3768 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3768""")
          x3768.r := Mux((0.FP(true, 10, 22) > x3767_sum), 0.FP(true, 10, 22), x3767_sum).r
          val x19561 = Wire(Bool()).suggestName("x19561_x3756_D10") 
          x19561.r := getRetimed(block1chunk0("x3756").asInstanceOf[Bool].r, 10.toInt, io.sigsIn.backpressure)
          val x3769 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3769""")
          x3769.r := Mux((x19561), 0.FP(true, 10, 22).r, x3768.r)
          val x3770_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3770_sum""")
          x3770_sum.r := Math.add(block1chunk0("x3713").asInstanceOf[FixedPoint],1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x3770_sum").r
          val x3771 = Wire(Bool()).suggestName("""x3771""")
          x3771.r := Math.lte(112L.FP(true, 32, 0), x3770_sum, Some(0.4), true.B,"x3771").r
          val x19562 = Wire(Bool()).suggestName("x19562_x3716_D1") 
          x19562.r := getRetimed(block1chunk0("x3716").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x3772 = Wire(Bool()).suggestName("""x3772""")
          x3772 := x3771 | x19562
          val x3773 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3773""")
          x3773.r := Mux((111L.FP(true, 32, 0) < x3770_sum), 111L.FP(true, 32, 0), x3770_sum).r
          val x3777_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3777_mul""")
          x3777_mul.r := (Math.mul(x3773, 224L.FP(true, 32, 0), Some(6.0), true.B, Truncate, Wrapping, "x3777_mul")).r
          val x19563 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19563_x3724_D7") 
          x19563.r := getRetimed(block1chunk0("x3724").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
          val x3778_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3778_sum""")
          x3778_sum.r := Math.add(x3777_mul,x19563,Some(1.0), true.B, Truncate, Wrapping, "x3778_sum").r
          val x19564 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19564_b3703_D8") 
          x19564.r := getRetimed(b3703.r, 8.toInt, io.sigsIn.backpressure)
          val x3779_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3779_sum""")
          x3779_sum.r := Math.add(x3778_sum,x19564,Some(1.0), true.B, Truncate, Wrapping, "x3779_sum").r
          val x19565 = Wire(Bool()).suggestName("x19565_b3121_D9") 
          x19565.r := getRetimed(b3121.r, 9.toInt, io.sigsIn.backpressure)
          val x19566 = Wire(Bool()).suggestName("x19566_b3712_D9") 
          x19566.r := getRetimed(b3712.r, 9.toInt, io.sigsIn.backpressure)
          val x19567 = Wire(Bool()).suggestName("x19567_b3711_D9") 
          x19567.r := getRetimed(b3711.r, 9.toInt, io.sigsIn.backpressure)
          val x19568 = Wire(Bool()).suggestName("x19568_b3704_D9") 
          x19568.r := getRetimed(b3704.r, 9.toInt, io.sigsIn.backpressure)
          val x3781_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3781_rd""")
          val x3781_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3781_rd_ofs = List[UInt](x3779_sum.r)
          val x3781_rd_en = List[Bool](true.B)
          x3781_rd.toSeq.zip(x3124_tmp0_SRAM_conv_2.connectRPort(3781, x3781_rd_banks, x3781_rd_ofs, io.sigsIn.backpressure, x3781_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.2.toInt, rr, io.sigsIn.backpressure) && x19567 & x19566 & x19568 & x19565), true)).foreach{case (a,b) => a := b}
          val x3782_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3782_elem_0""")
          x3782_elem_0.r := x3781_rd(0).r
          val x19569 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19569_x3734_elem_0_D8") 
          x19569.r := getRetimed(block1chunk0("x3734_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
          val x3783_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3783_sum""")
          x3783_sum.r := Math.add(x3782_elem_0,x19569,Some(1.0), true.B, Truncate, Wrapping, "x3783_sum").r
          val x3784 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3784""")
          x3784.r := Mux((0.FP(true, 10, 22) > x3783_sum), 0.FP(true, 10, 22), x3783_sum).r
          val x19570 = Wire(Bool()).suggestName("x19570_x3772_D11") 
          x19570.r := getRetimed(x3772.r, 11.toInt, io.sigsIn.backpressure)
          val x3785 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3785""")
          x3785.r := Mux((x19570), 0.FP(true, 10, 22).r, x3784.r)
          val x3786 = Wire(Bool()).suggestName("""x3786""")
          x3786 := x3771 | block1chunk0("x3739").asInstanceOf[Bool]
          val x19571 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19571_x3745_D6") 
          x19571.r := getRetimed(block1chunk0("x3745").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x3790_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3790_sum""")
          x3790_sum.r := Math.add(x3777_mul,x19571,Some(1.0), true.B, Truncate, Wrapping, "x3790_sum").r
          val x3791_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3791_sum""")
          x3791_sum.r := Math.add(x3790_sum,x19564,Some(1.0), true.B, Truncate, Wrapping, "x3791_sum").r
          val x3793_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3793_rd""")
          val x3793_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3793_rd_ofs = List[UInt](x3791_sum.r)
          val x3793_rd_en = List[Bool](true.B)
          x3793_rd.toSeq.zip(x3122_tmp0_SRAM_conv_0.connectRPort(3793, x3793_rd_banks, x3793_rd_ofs, io.sigsIn.backpressure, x3793_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.2.toInt, rr, io.sigsIn.backpressure) && x19567 & x19566 & x19568 & x19565), true)).foreach{case (a,b) => a := b}
          val x3794_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3794_elem_0""")
          x3794_elem_0.r := x3793_rd(0).r
          val x3795_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3795_sum""")
          x3795_sum.r := Math.add(x3794_elem_0,x19569,Some(1.0), true.B, Truncate, Wrapping, "x3795_sum").r
          val x3796 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3796""")
          x3796.r := Mux((0.FP(true, 10, 22) > x3795_sum), 0.FP(true, 10, 22), x3795_sum).r
          val x19572 = Wire(Bool()).suggestName("x19572_x3786_D11") 
          x19572.r := getRetimed(x3786.r, 11.toInt, io.sigsIn.backpressure)
          val x3797 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3797""")
          x3797.r := Mux((x19572), 0.FP(true, 10, 22).r, x3796.r)
          val x3798 = Wire(Bool()).suggestName("""x3798""")
          x3798 := x3771 | block1chunk0("x3755").asInstanceOf[Bool]
          val x19573 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19573_x3761_D6") 
          x19573.r := getRetimed(x3761.r, 6.toInt, io.sigsIn.backpressure)
          val x3802_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3802_sum""")
          x3802_sum.r := Math.add(x3777_mul,x19573,Some(1.0), true.B, Truncate, Wrapping, "x3802_sum").r
          val x3803_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3803_sum""")
          x3803_sum.r := Math.add(x3802_sum,x19564,Some(1.0), true.B, Truncate, Wrapping, "x3803_sum").r
          val x3805_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3805_rd""")
          val x3805_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3805_rd_ofs = List[UInt](x3803_sum.r)
          val x3805_rd_en = List[Bool](true.B)
          x3805_rd.toSeq.zip(x3126_tmp0_SRAM_conv_4.connectRPort(3805, x3805_rd_banks, x3805_rd_ofs, io.sigsIn.backpressure, x3805_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.2.toInt, rr, io.sigsIn.backpressure) && x19567 & x19566 & x19568 & x19565), true)).foreach{case (a,b) => a := b}
          val x3806_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3806_elem_0""")
          x3806_elem_0.r := x3805_rd(0).r
          val x3807_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3807_sum""")
          x3807_sum.r := Math.add(x3806_elem_0,x19569,Some(1.0), true.B, Truncate, Wrapping, "x3807_sum").r
          Map[String,Any]("x3769" -> x3769, "x19562" -> x19562, "x19563" -> x19563, "x19564" -> x19564, "x19565" -> x19565, "x19566" -> x19566, "x19567" -> x19567, "x19568" -> x19568, "x19569" -> x19569, "x3785" -> x3785, "x19571" -> x19571, "x3797" -> x3797, "x3798" -> x3798, "x19573" -> x19573, "x3807_sum" -> x3807_sum)
        }
      }
      val block1chunk1: Map[String, Any] = Block1Chunker1.gen()
      object Block1Chunker2 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x3808 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3808""")
          x3808.r := Mux((0.FP(true, 10, 22) > block1chunk1("x3807_sum").asInstanceOf[FixedPoint]), 0.FP(true, 10, 22), block1chunk1("x3807_sum").asInstanceOf[FixedPoint]).r
          val x19574 = Wire(Bool()).suggestName("x19574_x3798_D11") 
          x19574.r := getRetimed(block1chunk1("x3798").asInstanceOf[Bool].r, 11.toInt, io.sigsIn.backpressure)
          val x3809 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3809""")
          x3809.r := Mux((x19574), 0.FP(true, 10, 22).r, x3808.r)
          val x3810_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3810_sum""")
          x3810_sum.r := Math.add(block1chunk0("x3713").asInstanceOf[FixedPoint],2L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x3810_sum").r
          val x3811 = Wire(Bool()).suggestName("""x3811""")
          x3811.r := Math.lte(112L.FP(true, 32, 0), x3810_sum, Some(0.4), true.B,"x3811").r
          val x3812 = Wire(Bool()).suggestName("""x3812""")
          x3812 := x3811 | block1chunk1("x19562").asInstanceOf[Bool]
          val x3813 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3813""")
          x3813.r := Mux((111L.FP(true, 32, 0) < x3810_sum), 111L.FP(true, 32, 0), x3810_sum).r
          val x3817_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3817_mul""")
          x3817_mul.r := (Math.mul(x3813, 224L.FP(true, 32, 0), Some(6.0), true.B, Truncate, Wrapping, "x3817_mul")).r
          val x3818_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3818_sum""")
          x3818_sum.r := Math.add(x3817_mul,block1chunk1("x19563").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3818_sum").r
          val x3819_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3819_sum""")
          x3819_sum.r := Math.add(x3818_sum,block1chunk1("x19564").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3819_sum").r
          val x3821_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3821_rd""")
          val x3821_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3821_rd_ofs = List[UInt](x3819_sum.r)
          val x3821_rd_en = List[Bool](true.B)
          x3821_rd.toSeq.zip(x3128_tmp0_SRAM_conv_6.connectRPort(3821, x3821_rd_banks, x3821_rd_ofs, io.sigsIn.backpressure, x3821_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.2.toInt, rr, io.sigsIn.backpressure) && block1chunk1("x19567").asInstanceOf[Bool] & block1chunk1("x19566").asInstanceOf[Bool] & block1chunk1("x19568").asInstanceOf[Bool] & block1chunk1("x19565").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3822_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3822_elem_0""")
          x3822_elem_0.r := x3821_rd(0).r
          val x3823_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3823_sum""")
          x3823_sum.r := Math.add(x3822_elem_0,block1chunk1("x19569").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3823_sum").r
          val x3824 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3824""")
          x3824.r := Mux((0.FP(true, 10, 22) > x3823_sum), 0.FP(true, 10, 22), x3823_sum).r
          val x19575 = Wire(Bool()).suggestName("x19575_x3812_D11") 
          x19575.r := getRetimed(x3812.r, 11.toInt, io.sigsIn.backpressure)
          val x3825 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3825""")
          x3825.r := Mux((x19575), 0.FP(true, 10, 22).r, x3824.r)
          val x3826 = Wire(Bool()).suggestName("""x3826""")
          x3826 := x3811 | block1chunk0("x3739").asInstanceOf[Bool]
          val x3830_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3830_sum""")
          x3830_sum.r := Math.add(x3817_mul,block1chunk1("x19571").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3830_sum").r
          val x3831_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3831_sum""")
          x3831_sum.r := Math.add(x3830_sum,block1chunk1("x19564").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3831_sum").r
          val x3833_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3833_rd""")
          val x3833_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3833_rd_ofs = List[UInt](x3831_sum.r)
          val x3833_rd_en = List[Bool](true.B)
          x3833_rd.toSeq.zip(x3130_tmp0_SRAM_conv_8.connectRPort(3833, x3833_rd_banks, x3833_rd_ofs, io.sigsIn.backpressure, x3833_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.2.toInt, rr, io.sigsIn.backpressure) && block1chunk1("x19567").asInstanceOf[Bool] & block1chunk1("x19566").asInstanceOf[Bool] & block1chunk1("x19568").asInstanceOf[Bool] & block1chunk1("x19565").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3834_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3834_elem_0""")
          x3834_elem_0.r := x3833_rd(0).r
          val x3835_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3835_sum""")
          x3835_sum.r := Math.add(x3834_elem_0,block1chunk1("x19569").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3835_sum").r
          val x3836 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3836""")
          x3836.r := Mux((0.FP(true, 10, 22) > x3835_sum), 0.FP(true, 10, 22), x3835_sum).r
          val x19576 = Wire(Bool()).suggestName("x19576_x3826_D11") 
          x19576.r := getRetimed(x3826.r, 11.toInt, io.sigsIn.backpressure)
          val x3837 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3837""")
          x3837.r := Mux((x19576), 0.FP(true, 10, 22).r, x3836.r)
          val x3838 = Wire(Bool()).suggestName("""x3838""")
          x3838 := x3811 | block1chunk0("x3755").asInstanceOf[Bool]
          val x3842_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3842_sum""")
          x3842_sum.r := Math.add(x3817_mul,block1chunk1("x19573").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3842_sum").r
          val x3843_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3843_sum""")
          x3843_sum.r := Math.add(x3842_sum,block1chunk1("x19564").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3843_sum").r
          val x3845_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3845_rd""")
          val x3845_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3845_rd_ofs = List[UInt](x3843_sum.r)
          val x3845_rd_en = List[Bool](true.B)
          x3845_rd.toSeq.zip(x3131_tmp0_SRAM_conv_9.connectRPort(3845, x3845_rd_banks, x3845_rd_ofs, io.sigsIn.backpressure, x3845_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.2.toInt, rr, io.sigsIn.backpressure) && block1chunk1("x19567").asInstanceOf[Bool] & block1chunk1("x19566").asInstanceOf[Bool] & block1chunk1("x19568").asInstanceOf[Bool] & block1chunk1("x19565").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3846_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3846_elem_0""")
          x3846_elem_0.r := x3845_rd(0).r
          val x3847_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3847_sum""")
          x3847_sum.r := Math.add(x3846_elem_0,block1chunk1("x19569").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3847_sum").r
          val x3848 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3848""")
          x3848.r := Mux((0.FP(true, 10, 22) > x3847_sum), 0.FP(true, 10, 22), x3847_sum).r
          val x19577 = Wire(Bool()).suggestName("x19577_x3838_D11") 
          x19577.r := getRetimed(x3838.r, 11.toInt, io.sigsIn.backpressure)
          val x3849 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3849""")
          x3849.r := Mux((x19577), 0.FP(true, 10, 22).r, x3848.r)
          val x18849 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18849""")
          x18849.r := Math.fma(b3709,56L.FP(true, 32, 0),b3710,Some(6.0), true.B, "x18849").toFixed(x18849, "cast_x18849").r
          val x3852 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3852""")
          x3852.r := Mux((block1chunk0("x3737").asInstanceOf[FixedPoint] > block1chunk0("x3753").asInstanceOf[FixedPoint]), block1chunk0("x3737").asInstanceOf[FixedPoint], block1chunk0("x3753").asInstanceOf[FixedPoint]).r
          val x19578 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19578_x3769_D1") 
          x19578.r := getRetimed(block1chunk1("x3769").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x3853 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3853""")
          x3853.r := Mux((x19578 > block1chunk1("x3785").asInstanceOf[FixedPoint]), x19578, block1chunk1("x3785").asInstanceOf[FixedPoint]).r
          val x3854 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3854""")
          x3854.r := Mux((block1chunk1("x3797").asInstanceOf[FixedPoint] > x3809), block1chunk1("x3797").asInstanceOf[FixedPoint], x3809).r
          val x3855 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3855""")
          x3855.r := Mux((x3825 > x3837), x3825, x3837).r
          val x19579 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19579_x3852_D1") 
          x19579.r := getRetimed(x3852.r, 1.toInt, io.sigsIn.backpressure)
          val x3856 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3856""")
          x3856.r := Mux((x19579 > x3853), x19579, x3853).r
          val x3857 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3857""")
          x3857.r := Mux((x3854 > x3855), x3854, x3855).r
          val x3858 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3858""")
          x3858.r := Mux((x3856 > x3857), x3856, x3857).r
          val x3859 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3859""")
          x3859.r := Mux((x3858 > x3849), x3858, x3849).r
          val x19580 = Wire(Bool()).suggestName("x19580_b3121_D12") 
          x19580.r := getRetimed(b3121.r, 12.toInt, io.sigsIn.backpressure)
          val x19581 = Wire(Bool()).suggestName("x19581_b3712_D12") 
          x19581.r := getRetimed(b3712.r, 12.toInt, io.sigsIn.backpressure)
          val x19582 = Wire(Bool()).suggestName("x19582_b3711_D12") 
          x19582.r := getRetimed(b3711.r, 12.toInt, io.sigsIn.backpressure)
          val x19583 = Wire(Bool()).suggestName("x19583_b3704_D12") 
          x19583.r := getRetimed(b3704.r, 12.toInt, io.sigsIn.backpressure)
          Map[String,Any]("x18849" -> x18849, "x3859" -> x3859, "x19580" -> x19580, "x19581" -> x19581, "x19582" -> x19582, "x19583" -> x19583)
        }
      }
      val block1chunk2: Map[String, Any] = Block1Chunker2.gen()
      object Block1Chunker3 { // 2 nodes, 2 weight
        def gen(): Map[String, Any] = {
          val x19584 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19584_x18849_D6") 
          x19584.r := getRetimed(block1chunk2("x18849").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x3862_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3862_wr_ofs = List[UInt](x19584.r)
          val x3862_wr_en = List[Bool](true.B)
          val x3862_wr_data = List[UInt](block1chunk2("x3859").asInstanceOf[FixedPoint].r)
          x3705_tmp0_SRAM_pool_0.connectWPort(3862, x3862_wr_banks, x3862_wr_ofs, x3862_wr_data, x3862_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(12.7.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && block1chunk2("x19582").asInstanceOf[Bool] & block1chunk2("x19581").asInstanceOf[Bool] & block1chunk2("x19583").asInstanceOf[Bool] & block1chunk2("x19580").asInstanceOf[Bool]))
          Map[String,Any]()
        }
      }
      val block1chunk3: Map[String, Any] = Block1Chunker3.gen()
      x3705_tmp0_SRAM_pool_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x3863_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3863_inr_Foreach **/
