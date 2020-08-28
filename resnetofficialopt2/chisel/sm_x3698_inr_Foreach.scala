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

/** Hierarchy: x3698 -> x3699 -> x3700 -> x3898 -> x1256 **/
/** BEGIN None x3698_inr_Foreach **/
class x3698_inr_Foreach_kernel(
  list_b3121: List[Bool],
  list_b3219: List[FixedPoint],
  list_x3129_tmp0_SRAM_conv_7: List[StandardInterface],
  list_x3131_tmp0_SRAM_conv_9: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 54.2.toInt, myName = "x3698_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3698_inr_Foreach_iiCtr"))
  
  abstract class x3698_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b3121 = Input(Bool())
      val in_x3131_tmp0_SRAM_conv_9 = Flipped(new NBufInterface(ModuleParams.getParams("x3131_tmp0_SRAM_conv_9_p").asInstanceOf[NBufParams] ))
      val in_x3125_tmp0_SRAM_conv_3 = Flipped(new NBufInterface(ModuleParams.getParams("x3125_tmp0_SRAM_conv_3_p").asInstanceOf[NBufParams] ))
      val in_x3216_lb0_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3216_lb0_0_p").asInstanceOf[NBufParams] ))
      val in_x3122_tmp0_SRAM_conv_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3122_tmp0_SRAM_conv_0_p").asInstanceOf[NBufParams] ))
      val in_x3126_tmp0_SRAM_conv_4 = Flipped(new NBufInterface(ModuleParams.getParams("x3126_tmp0_SRAM_conv_4_p").asInstanceOf[NBufParams] ))
      val in_b3215 = Input(Bool())
      val in_x3130_tmp0_SRAM_conv_8 = Flipped(new NBufInterface(ModuleParams.getParams("x3130_tmp0_SRAM_conv_8_p").asInstanceOf[NBufParams] ))
      val in_x3123_tmp0_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x3123_tmp0_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_b3219 = Input(new FixedPoint(true, 32, 0))
      val in_b3214 = Input(new FixedPoint(true, 32, 0))
      val in_x3129_tmp0_SRAM_conv_7 = Flipped(new StandardInterface(ModuleParams.getParams("x3129_tmp0_SRAM_conv_7_p").asInstanceOf[MemParams] ))
      val in_x3127_tmp0_SRAM_conv_5 = Flipped(new NBufInterface(ModuleParams.getParams("x3127_tmp0_SRAM_conv_5_p").asInstanceOf[NBufParams] ))
      val in_x3124_tmp0_SRAM_conv_2 = Flipped(new NBufInterface(ModuleParams.getParams("x3124_tmp0_SRAM_conv_2_p").asInstanceOf[NBufParams] ))
      val in_b3220 = Input(Bool())
      val in_x3132_c101_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3132_c101_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x3128_tmp0_SRAM_conv_6 = Flipped(new NBufInterface(ModuleParams.getParams("x3128_tmp0_SRAM_conv_6_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1, 1), List(32, 32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b3121 = {io.in_b3121} 
    def x3131_tmp0_SRAM_conv_9 = {io.in_x3131_tmp0_SRAM_conv_9} ; io.in_x3131_tmp0_SRAM_conv_9 := DontCare
    def x3125_tmp0_SRAM_conv_3 = {io.in_x3125_tmp0_SRAM_conv_3} ; io.in_x3125_tmp0_SRAM_conv_3 := DontCare
    def x3216_lb0_0 = {io.in_x3216_lb0_0} ; io.in_x3216_lb0_0 := DontCare
    def x3122_tmp0_SRAM_conv_0 = {io.in_x3122_tmp0_SRAM_conv_0} ; io.in_x3122_tmp0_SRAM_conv_0 := DontCare
    def x3126_tmp0_SRAM_conv_4 = {io.in_x3126_tmp0_SRAM_conv_4} ; io.in_x3126_tmp0_SRAM_conv_4 := DontCare
    def b3215 = {io.in_b3215} 
    def x3130_tmp0_SRAM_conv_8 = {io.in_x3130_tmp0_SRAM_conv_8} ; io.in_x3130_tmp0_SRAM_conv_8 := DontCare
    def x3123_tmp0_SRAM_conv_1 = {io.in_x3123_tmp0_SRAM_conv_1} ; io.in_x3123_tmp0_SRAM_conv_1 := DontCare
    def b3219 = {io.in_b3219} 
    def b3214 = {io.in_b3214} 
    def x3129_tmp0_SRAM_conv_7 = {io.in_x3129_tmp0_SRAM_conv_7} ; io.in_x3129_tmp0_SRAM_conv_7 := DontCare
    def x3127_tmp0_SRAM_conv_5 = {io.in_x3127_tmp0_SRAM_conv_5} ; io.in_x3127_tmp0_SRAM_conv_5 := DontCare
    def x3124_tmp0_SRAM_conv_2 = {io.in_x3124_tmp0_SRAM_conv_2} ; io.in_x3124_tmp0_SRAM_conv_2 := DontCare
    def b3220 = {io.in_b3220} 
    def x3132_c101_SRAM_0 = {io.in_x3132_c101_SRAM_0} ; io.in_x3132_c101_SRAM_0 := DontCare
    def x3128_tmp0_SRAM_conv_6 = {io.in_x3128_tmp0_SRAM_conv_6} ; io.in_x3128_tmp0_SRAM_conv_6 := DontCare
  }
  def connectWires0(module: x3698_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b3121 <> b3121
    x3131_tmp0_SRAM_conv_9.connectLedger(module.io.in_x3131_tmp0_SRAM_conv_9)
    x3125_tmp0_SRAM_conv_3.connectLedger(module.io.in_x3125_tmp0_SRAM_conv_3)
    x3216_lb0_0.connectLedger(module.io.in_x3216_lb0_0)
    x3122_tmp0_SRAM_conv_0.connectLedger(module.io.in_x3122_tmp0_SRAM_conv_0)
    x3126_tmp0_SRAM_conv_4.connectLedger(module.io.in_x3126_tmp0_SRAM_conv_4)
    module.io.in_b3215 <> b3215
    x3130_tmp0_SRAM_conv_8.connectLedger(module.io.in_x3130_tmp0_SRAM_conv_8)
    x3123_tmp0_SRAM_conv_1.connectLedger(module.io.in_x3123_tmp0_SRAM_conv_1)
    module.io.in_b3219 <> b3219
    module.io.in_b3214 <> b3214
    x3129_tmp0_SRAM_conv_7.connectLedger(module.io.in_x3129_tmp0_SRAM_conv_7)
    x3127_tmp0_SRAM_conv_5.connectLedger(module.io.in_x3127_tmp0_SRAM_conv_5)
    x3124_tmp0_SRAM_conv_2.connectLedger(module.io.in_x3124_tmp0_SRAM_conv_2)
    module.io.in_b3220 <> b3220
    x3132_c101_SRAM_0.connectLedger(module.io.in_x3132_c101_SRAM_0)
    x3128_tmp0_SRAM_conv_6.connectLedger(module.io.in_x3128_tmp0_SRAM_conv_6)
  }
  val b3121 = list_b3121(0)
  val b3215 = list_b3121(1)
  val b3220 = list_b3121(2)
  val b3219 = list_b3219(0)
  val b3214 = list_b3219(1)
  val x3129_tmp0_SRAM_conv_7 = list_x3129_tmp0_SRAM_conv_7(0)
  val x3131_tmp0_SRAM_conv_9 = list_x3131_tmp0_SRAM_conv_9(0)
  val x3125_tmp0_SRAM_conv_3 = list_x3131_tmp0_SRAM_conv_9(1)
  val x3216_lb0_0 = list_x3131_tmp0_SRAM_conv_9(2)
  val x3122_tmp0_SRAM_conv_0 = list_x3131_tmp0_SRAM_conv_9(3)
  val x3126_tmp0_SRAM_conv_4 = list_x3131_tmp0_SRAM_conv_9(4)
  val x3130_tmp0_SRAM_conv_8 = list_x3131_tmp0_SRAM_conv_9(5)
  val x3123_tmp0_SRAM_conv_1 = list_x3131_tmp0_SRAM_conv_9(6)
  val x3127_tmp0_SRAM_conv_5 = list_x3131_tmp0_SRAM_conv_9(7)
  val x3124_tmp0_SRAM_conv_2 = list_x3131_tmp0_SRAM_conv_9(8)
  val x3132_c101_SRAM_0 = list_x3131_tmp0_SRAM_conv_9(9)
  val x3128_tmp0_SRAM_conv_6 = list_x3131_tmp0_SRAM_conv_9(10)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3698_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3698_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3698_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3304 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b3304.suggestName("b3304")
      val b3305 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b3305.suggestName("b3305")
      val b3306 = ~io.sigsIn.cchainOutputs.head.oobs(0); b3306.suggestName("b3306")
      val b3307 = ~io.sigsIn.cchainOutputs.head.oobs(1); b3307.suggestName("b3307")
      object Block1Chunker0 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x3308 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3308""")
          x3308.r := Math.arith_left_shift(b3219, 1, Some(0.2), true.B,"x3308").r
          val x3309_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3309_sub""")
          x3309_sub.r := Math.sub(6L.FP(true, 32, 0),x3308,Some(1.0), true.B, Truncate, Wrapping, "x3309_sub").r
          val x3310 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3310""")
          x3310.r := Mux((0L.FP(true, 32, 0) > x3309_sub), 0L.FP(true, 32, 0), x3309_sub).r
          val x18822 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18822""")
          x18822.r := Math.fma(b3305,3L.FP(true, 32, 0),b3214,Some(6.0), true.B, "x18822").toFixed(x18822, "cast_x18822").r
          val x19411 = Wire(Bool()).suggestName("x19411_b3121_D6") 
          x19411.r := getRetimed(b3121.r, 6.toInt, io.sigsIn.backpressure)
          val x19412 = Wire(Bool()).suggestName("x19412_b3307_D6") 
          x19412.r := getRetimed(b3307.r, 6.toInt, io.sigsIn.backpressure)
          val x19413 = Wire(Bool()).suggestName("x19413_b3215_D6") 
          x19413.r := getRetimed(b3215.r, 6.toInt, io.sigsIn.backpressure)
          val x19414 = Wire(Bool()).suggestName("x19414_b3306_D6") 
          x19414.r := getRetimed(b3306.r, 6.toInt, io.sigsIn.backpressure)
          val x19415 = Wire(Bool()).suggestName("x19415_b3220_D6") 
          x19415.r := getRetimed(b3220.r, 6.toInt, io.sigsIn.backpressure)
          val x3317_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3317_rd""")
          val x3317_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
          val x3317_rd_ofs = List[UInt](x18822.r)
          val x3317_rd_en = List[Bool](true.B)
          x3317_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3317, x3317_rd_banks, x3317_rd_ofs, io.sigsIn.backpressure, x3317_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3318_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3318_elem_0""")
          x3318_elem_0.r := x3317_rd(0).r
          val x3319_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3319_rd""")
          val x3319_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r)
          val x3319_rd_ofs = List[UInt](x18822.r)
          val x3319_rd_en = List[Bool](true.B)
          x3319_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3319, x3319_rd_banks, x3319_rd_ofs, io.sigsIn.backpressure, x3319_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3320_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3320_elem_0""")
          x3320_elem_0.r := x3319_rd(0).r
          val x3321_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3321_rd""")
          val x3321_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r)
          val x3321_rd_ofs = List[UInt](x18822.r)
          val x3321_rd_en = List[Bool](true.B)
          x3321_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3321, x3321_rd_banks, x3321_rd_ofs, io.sigsIn.backpressure, x3321_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3322_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3322_elem_0""")
          x3322_elem_0.r := x3321_rd(0).r
          val x3323_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3323_rd""")
          val x3323_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
          val x3323_rd_ofs = List[UInt](x18822.r)
          val x3323_rd_en = List[Bool](true.B)
          x3323_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3323, x3323_rd_banks, x3323_rd_ofs, io.sigsIn.backpressure, x3323_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3324_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3324_elem_0""")
          x3324_elem_0.r := x3323_rd(0).r
          val x3325_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3325_rd""")
          val x3325_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r)
          val x3325_rd_ofs = List[UInt](x18822.r)
          val x3325_rd_en = List[Bool](true.B)
          x3325_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3325, x3325_rd_banks, x3325_rd_ofs, io.sigsIn.backpressure, x3325_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3326_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3326_elem_0""")
          x3326_elem_0.r := x3325_rd(0).r
          val x3327_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3327_rd""")
          val x3327_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r)
          val x3327_rd_ofs = List[UInt](x18822.r)
          val x3327_rd_en = List[Bool](true.B)
          x3327_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3327, x3327_rd_banks, x3327_rd_ofs, io.sigsIn.backpressure, x3327_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3328_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3328_elem_0""")
          x3328_elem_0.r := x3327_rd(0).r
          val x3329_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3329_rd""")
          val x3329_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r)
          val x3329_rd_ofs = List[UInt](x18822.r)
          val x3329_rd_en = List[Bool](true.B)
          x3329_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3329, x3329_rd_banks, x3329_rd_ofs, io.sigsIn.backpressure, x3329_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3330_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3330_elem_0""")
          x3330_elem_0.r := x3329_rd(0).r
          val x3331_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3331_rd""")
          val x3331_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
          val x3331_rd_ofs = List[UInt](x18822.r)
          val x3331_rd_en = List[Bool](true.B)
          x3331_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3331, x3331_rd_banks, x3331_rd_ofs, io.sigsIn.backpressure, x3331_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3332_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3332_elem_0""")
          x3332_elem_0.r := x3331_rd(0).r
          val x3333_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3333_rd""")
          val x3333_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r)
          val x3333_rd_ofs = List[UInt](x18822.r)
          val x3333_rd_en = List[Bool](true.B)
          x3333_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3333, x3333_rd_banks, x3333_rd_ofs, io.sigsIn.backpressure, x3333_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3334_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3334_elem_0""")
          x3334_elem_0.r := x3333_rd(0).r
          val x3335_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3335_rd""")
          val x3335_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r)
          val x3335_rd_ofs = List[UInt](x18822.r)
          val x3335_rd_en = List[Bool](true.B)
          x3335_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3335, x3335_rd_banks, x3335_rd_ofs, io.sigsIn.backpressure, x3335_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3336_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3336_elem_0""")
          x3336_elem_0.r := x3335_rd(0).r
          val x3337_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3337_rd""")
          val x3337_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r)
          val x3337_rd_ofs = List[UInt](x18822.r)
          val x3337_rd_en = List[Bool](true.B)
          x3337_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3337, x3337_rd_banks, x3337_rd_ofs, io.sigsIn.backpressure, x3337_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3338_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3338_elem_0""")
          x3338_elem_0.r := x3337_rd(0).r
          val x3339_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3339_rd""")
          val x3339_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r)
          val x3339_rd_ofs = List[UInt](x18822.r)
          val x3339_rd_en = List[Bool](true.B)
          x3339_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3339, x3339_rd_banks, x3339_rd_ofs, io.sigsIn.backpressure, x3339_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3340_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3340_elem_0""")
          x3340_elem_0.r := x3339_rd(0).r
          val x3341_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3341_rd""")
          val x3341_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r)
          val x3341_rd_ofs = List[UInt](x18822.r)
          val x3341_rd_en = List[Bool](true.B)
          x3341_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3341, x3341_rd_banks, x3341_rd_ofs, io.sigsIn.backpressure, x3341_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3342_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3342_elem_0""")
          x3342_elem_0.r := x3341_rd(0).r
          val x3343_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3343_rd""")
          val x3343_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r)
          val x3343_rd_ofs = List[UInt](x18822.r)
          val x3343_rd_en = List[Bool](true.B)
          x3343_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3343, x3343_rd_banks, x3343_rd_ofs, io.sigsIn.backpressure, x3343_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3344_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3344_elem_0""")
          x3344_elem_0.r := x3343_rd(0).r
          val x3345_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3345_rd""")
          val x3345_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r)
          val x3345_rd_ofs = List[UInt](x18822.r)
          val x3345_rd_en = List[Bool](true.B)
          x3345_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3345, x3345_rd_banks, x3345_rd_ofs, io.sigsIn.backpressure, x3345_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3346_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3346_elem_0""")
          x3346_elem_0.r := x3345_rd(0).r
          val x3347_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3347_rd""")
          val x3347_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
          val x3347_rd_ofs = List[UInt](x18822.r)
          val x3347_rd_en = List[Bool](true.B)
          x3347_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3347, x3347_rd_banks, x3347_rd_ofs, io.sigsIn.backpressure, x3347_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3348_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3348_elem_0""")
          x3348_elem_0.r := x3347_rd(0).r
          val x3349_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3349_rd""")
          val x3349_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,16L.FP(true, 32, 0).r)
          val x3349_rd_ofs = List[UInt](x18822.r)
          val x3349_rd_en = List[Bool](true.B)
          x3349_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3349, x3349_rd_banks, x3349_rd_ofs, io.sigsIn.backpressure, x3349_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3350_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3350_elem_0""")
          x3350_elem_0.r := x3349_rd(0).r
          val x3351_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3351_rd""")
          val x3351_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r)
          val x3351_rd_ofs = List[UInt](x18822.r)
          val x3351_rd_en = List[Bool](true.B)
          x3351_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3351, x3351_rd_banks, x3351_rd_ofs, io.sigsIn.backpressure, x3351_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3352_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3352_elem_0""")
          x3352_elem_0.r := x3351_rd(0).r
          val x3353_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3353_rd""")
          val x3353_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r)
          val x3353_rd_ofs = List[UInt](x18822.r)
          val x3353_rd_en = List[Bool](true.B)
          x3353_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3353, x3353_rd_banks, x3353_rd_ofs, io.sigsIn.backpressure, x3353_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3354_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3354_elem_0""")
          x3354_elem_0.r := x3353_rd(0).r
          val x3355_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3355_rd""")
          val x3355_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r)
          val x3355_rd_ofs = List[UInt](x18822.r)
          val x3355_rd_en = List[Bool](true.B)
          x3355_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3355, x3355_rd_banks, x3355_rd_ofs, io.sigsIn.backpressure, x3355_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && x19411 & x19412 & x19413 & x19414 & x19415), true)).foreach{case (a,b) => a := b}
          val x3356_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3356_elem_0""")
          x3356_elem_0.r := x3355_rd(0).r
          Map[String,Any]("x3310" -> x3310, "x18822" -> x18822, "x19411" -> x19411, "x19412" -> x19412, "x19413" -> x19413, "x19414" -> x19414, "x19415" -> x19415, "x3318_elem_0" -> x3318_elem_0, "x3320_elem_0" -> x3320_elem_0, "x3322_elem_0" -> x3322_elem_0, "x3324_elem_0" -> x3324_elem_0, "x3326_elem_0" -> x3326_elem_0, "x3328_elem_0" -> x3328_elem_0, "x3330_elem_0" -> x3330_elem_0, "x3332_elem_0" -> x3332_elem_0, "x3334_elem_0" -> x3334_elem_0, "x3336_elem_0" -> x3336_elem_0, "x3338_elem_0" -> x3338_elem_0, "x3340_elem_0" -> x3340_elem_0, "x3342_elem_0" -> x3342_elem_0, "x3344_elem_0" -> x3344_elem_0, "x3346_elem_0" -> x3346_elem_0, "x3348_elem_0" -> x3348_elem_0, "x3350_elem_0" -> x3350_elem_0, "x3352_elem_0" -> x3352_elem_0, "x3354_elem_0" -> x3354_elem_0, "x3356_elem_0" -> x3356_elem_0)
        }
      }
      val block1chunk0: Map[String, Any] = Block1Chunker0.gen()
      object Block1Chunker1 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x3357_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3357_rd""")
          val x3357_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r)
          val x3357_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3357_rd_en = List[Bool](true.B)
          x3357_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3357, x3357_rd_banks, x3357_rd_ofs, io.sigsIn.backpressure, x3357_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3358_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3358_elem_0""")
          x3358_elem_0.r := x3357_rd(0).r
          val x3359_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3359_rd""")
          val x3359_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,21L.FP(true, 32, 0).r)
          val x3359_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3359_rd_en = List[Bool](true.B)
          x3359_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3359, x3359_rd_banks, x3359_rd_ofs, io.sigsIn.backpressure, x3359_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3360_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3360_elem_0""")
          x3360_elem_0.r := x3359_rd(0).r
          val x3361_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3361_rd""")
          val x3361_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r)
          val x3361_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3361_rd_en = List[Bool](true.B)
          x3361_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3361, x3361_rd_banks, x3361_rd_ofs, io.sigsIn.backpressure, x3361_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3362_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3362_elem_0""")
          x3362_elem_0.r := x3361_rd(0).r
          val x3363_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3363_rd""")
          val x3363_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r)
          val x3363_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3363_rd_en = List[Bool](true.B)
          x3363_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3363, x3363_rd_banks, x3363_rd_ofs, io.sigsIn.backpressure, x3363_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3364_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3364_elem_0""")
          x3364_elem_0.r := x3363_rd(0).r
          val x3365_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3365_rd""")
          val x3365_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,24L.FP(true, 32, 0).r)
          val x3365_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3365_rd_en = List[Bool](true.B)
          x3365_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3365, x3365_rd_banks, x3365_rd_ofs, io.sigsIn.backpressure, x3365_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3366_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3366_elem_0""")
          x3366_elem_0.r := x3365_rd(0).r
          val x3367_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3367_rd""")
          val x3367_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r)
          val x3367_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3367_rd_en = List[Bool](true.B)
          x3367_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3367, x3367_rd_banks, x3367_rd_ofs, io.sigsIn.backpressure, x3367_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3368_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3368_elem_0""")
          x3368_elem_0.r := x3367_rd(0).r
          val x3369_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3369_rd""")
          val x3369_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r)
          val x3369_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3369_rd_en = List[Bool](true.B)
          x3369_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3369, x3369_rd_banks, x3369_rd_ofs, io.sigsIn.backpressure, x3369_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3370_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3370_elem_0""")
          x3370_elem_0.r := x3369_rd(0).r
          val x3371_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3371_rd""")
          val x3371_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r)
          val x3371_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3371_rd_en = List[Bool](true.B)
          x3371_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3371, x3371_rd_banks, x3371_rd_ofs, io.sigsIn.backpressure, x3371_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3372_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3372_elem_0""")
          x3372_elem_0.r := x3371_rd(0).r
          val x3373_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3373_rd""")
          val x3373_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,28L.FP(true, 32, 0).r)
          val x3373_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3373_rd_en = List[Bool](true.B)
          x3373_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3373, x3373_rd_banks, x3373_rd_ofs, io.sigsIn.backpressure, x3373_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3374_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3374_elem_0""")
          x3374_elem_0.r := x3373_rd(0).r
          val x3375_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3375_rd""")
          val x3375_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r)
          val x3375_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3375_rd_en = List[Bool](true.B)
          x3375_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3375, x3375_rd_banks, x3375_rd_ofs, io.sigsIn.backpressure, x3375_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3376_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3376_elem_0""")
          x3376_elem_0.r := x3375_rd(0).r
          val x3377_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3377_rd""")
          val x3377_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r)
          val x3377_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3377_rd_en = List[Bool](true.B)
          x3377_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3377, x3377_rd_banks, x3377_rd_ofs, io.sigsIn.backpressure, x3377_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3378_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3378_elem_0""")
          x3378_elem_0.r := x3377_rd(0).r
          val x3379_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3379_rd""")
          val x3379_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
          val x3379_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3379_rd_en = List[Bool](true.B)
          x3379_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3379, x3379_rd_banks, x3379_rd_ofs, io.sigsIn.backpressure, x3379_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3380_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3380_elem_0""")
          x3380_elem_0.r := x3379_rd(0).r
          val x3381_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3381_rd""")
          val x3381_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,32L.FP(true, 32, 0).r)
          val x3381_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3381_rd_en = List[Bool](true.B)
          x3381_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3381, x3381_rd_banks, x3381_rd_ofs, io.sigsIn.backpressure, x3381_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3382_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3382_elem_0""")
          x3382_elem_0.r := x3381_rd(0).r
          val x3383_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3383_rd""")
          val x3383_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,33L.FP(true, 32, 0).r)
          val x3383_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3383_rd_en = List[Bool](true.B)
          x3383_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3383, x3383_rd_banks, x3383_rd_ofs, io.sigsIn.backpressure, x3383_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3384_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3384_elem_0""")
          x3384_elem_0.r := x3383_rd(0).r
          val x3385_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3385_rd""")
          val x3385_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,34L.FP(true, 32, 0).r)
          val x3385_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3385_rd_en = List[Bool](true.B)
          x3385_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3385, x3385_rd_banks, x3385_rd_ofs, io.sigsIn.backpressure, x3385_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3386_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3386_elem_0""")
          x3386_elem_0.r := x3385_rd(0).r
          val x3387_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3387_rd""")
          val x3387_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,35L.FP(true, 32, 0).r)
          val x3387_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3387_rd_en = List[Bool](true.B)
          x3387_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3387, x3387_rd_banks, x3387_rd_ofs, io.sigsIn.backpressure, x3387_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3388_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3388_elem_0""")
          x3388_elem_0.r := x3387_rd(0).r
          val x3389_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3389_rd""")
          val x3389_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,36L.FP(true, 32, 0).r)
          val x3389_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3389_rd_en = List[Bool](true.B)
          x3389_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3389, x3389_rd_banks, x3389_rd_ofs, io.sigsIn.backpressure, x3389_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3390_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3390_elem_0""")
          x3390_elem_0.r := x3389_rd(0).r
          val x3391_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3391_rd""")
          val x3391_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,37L.FP(true, 32, 0).r)
          val x3391_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3391_rd_en = List[Bool](true.B)
          x3391_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3391, x3391_rd_banks, x3391_rd_ofs, io.sigsIn.backpressure, x3391_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3392_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3392_elem_0""")
          x3392_elem_0.r := x3391_rd(0).r
          val x3393_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3393_rd""")
          val x3393_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,38L.FP(true, 32, 0).r)
          val x3393_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3393_rd_en = List[Bool](true.B)
          x3393_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3393, x3393_rd_banks, x3393_rd_ofs, io.sigsIn.backpressure, x3393_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3394_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3394_elem_0""")
          x3394_elem_0.r := x3393_rd(0).r
          val x3395_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3395_rd""")
          val x3395_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,39L.FP(true, 32, 0).r)
          val x3395_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3395_rd_en = List[Bool](true.B)
          x3395_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3395, x3395_rd_banks, x3395_rd_ofs, io.sigsIn.backpressure, x3395_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3396_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3396_elem_0""")
          x3396_elem_0.r := x3395_rd(0).r
          val x3397_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3397_rd""")
          val x3397_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,40L.FP(true, 32, 0).r)
          val x3397_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3397_rd_en = List[Bool](true.B)
          x3397_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3397, x3397_rd_banks, x3397_rd_ofs, io.sigsIn.backpressure, x3397_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3398_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3398_elem_0""")
          x3398_elem_0.r := x3397_rd(0).r
          val x3399_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3399_rd""")
          val x3399_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,41L.FP(true, 32, 0).r)
          val x3399_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3399_rd_en = List[Bool](true.B)
          x3399_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3399, x3399_rd_banks, x3399_rd_ofs, io.sigsIn.backpressure, x3399_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3400_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3400_elem_0""")
          x3400_elem_0.r := x3399_rd(0).r
          val x3401_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3401_rd""")
          val x3401_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,42L.FP(true, 32, 0).r)
          val x3401_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3401_rd_en = List[Bool](true.B)
          x3401_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3401, x3401_rd_banks, x3401_rd_ofs, io.sigsIn.backpressure, x3401_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3402_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3402_elem_0""")
          x3402_elem_0.r := x3401_rd(0).r
          val x3403_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3403_rd""")
          val x3403_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,43L.FP(true, 32, 0).r)
          val x3403_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3403_rd_en = List[Bool](true.B)
          x3403_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3403, x3403_rd_banks, x3403_rd_ofs, io.sigsIn.backpressure, x3403_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3404_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3404_elem_0""")
          x3404_elem_0.r := x3403_rd(0).r
          val x3405_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3405_rd""")
          val x3405_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,44L.FP(true, 32, 0).r)
          val x3405_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3405_rd_en = List[Bool](true.B)
          x3405_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3405, x3405_rd_banks, x3405_rd_ofs, io.sigsIn.backpressure, x3405_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          Map[String,Any]("x3358_elem_0" -> x3358_elem_0, "x3360_elem_0" -> x3360_elem_0, "x3362_elem_0" -> x3362_elem_0, "x3364_elem_0" -> x3364_elem_0, "x3366_elem_0" -> x3366_elem_0, "x3368_elem_0" -> x3368_elem_0, "x3370_elem_0" -> x3370_elem_0, "x3372_elem_0" -> x3372_elem_0, "x3374_elem_0" -> x3374_elem_0, "x3376_elem_0" -> x3376_elem_0, "x3378_elem_0" -> x3378_elem_0, "x3380_elem_0" -> x3380_elem_0, "x3382_elem_0" -> x3382_elem_0, "x3384_elem_0" -> x3384_elem_0, "x3386_elem_0" -> x3386_elem_0, "x3388_elem_0" -> x3388_elem_0, "x3390_elem_0" -> x3390_elem_0, "x3392_elem_0" -> x3392_elem_0, "x3394_elem_0" -> x3394_elem_0, "x3396_elem_0" -> x3396_elem_0, "x3398_elem_0" -> x3398_elem_0, "x3400_elem_0" -> x3400_elem_0, "x3402_elem_0" -> x3402_elem_0, "x3404_elem_0" -> x3404_elem_0, "x3405_rd" -> x3405_rd)
        }
      }
      val block1chunk1: Map[String, Any] = Block1Chunker1.gen()
      object Block1Chunker2 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x3406_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3406_elem_0""")
          x3406_elem_0.r := block1chunk1("x3405_rd").asInstanceOf[Vec[FixedPoint]](0).r
          val x3407_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3407_rd""")
          val x3407_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,45L.FP(true, 32, 0).r)
          val x3407_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3407_rd_en = List[Bool](true.B)
          x3407_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3407, x3407_rd_banks, x3407_rd_ofs, io.sigsIn.backpressure, x3407_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3408_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3408_elem_0""")
          x3408_elem_0.r := x3407_rd(0).r
          val x3409_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3409_rd""")
          val x3409_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,46L.FP(true, 32, 0).r)
          val x3409_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3409_rd_en = List[Bool](true.B)
          x3409_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3409, x3409_rd_banks, x3409_rd_ofs, io.sigsIn.backpressure, x3409_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3410_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3410_elem_0""")
          x3410_elem_0.r := x3409_rd(0).r
          val x3411_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3411_rd""")
          val x3411_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,47L.FP(true, 32, 0).r)
          val x3411_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3411_rd_en = List[Bool](true.B)
          x3411_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3411, x3411_rd_banks, x3411_rd_ofs, io.sigsIn.backpressure, x3411_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3412_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3412_elem_0""")
          x3412_elem_0.r := x3411_rd(0).r
          val x3413_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3413_rd""")
          val x3413_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,48L.FP(true, 32, 0).r)
          val x3413_rd_ofs = List[UInt](block1chunk0("x18822").asInstanceOf[FixedPoint].r)
          val x3413_rd_en = List[Bool](true.B)
          x3413_rd.toSeq.zip(x3132_c101_SRAM_0.connectRPort(3413, x3413_rd_banks, x3413_rd_ofs, io.sigsIn.backpressure, x3413_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) && block1chunk0("x19413").asInstanceOf[Bool] & block1chunk0("x19412").asInstanceOf[Bool] & block1chunk0("x19415").asInstanceOf[Bool] & block1chunk0("x19411").asInstanceOf[Bool] & block1chunk0("x19414").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3414_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3414_elem_0""")
          x3414_elem_0.r := x3413_rd(0).r
          val x3415 = Wire(Bool()).suggestName("""x3415""")
          x3415.r := Math.lt(0L.FP(true, 32, 0), block1chunk0("x3310").asInstanceOf[FixedPoint], Some(0.4), true.B,"x3415").r
          val x3416 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3416""")
          x3416.r := Math.arith_left_shift(b3304, 1, Some(0.2), true.B,"x3416").r
          val x3417 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3417""")
          x3417.r := (Math.mod(x3416, 7L.FP(true, 32, 0), Some(16.0), true.B, Truncate, Wrapping, "x3417")).r
          val x3418_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3418_div""")
          x3418_div.r := (Math.div(x3416, 7L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x3418_div")).r
          val x19416 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19416_x3417_D5") 
          x19416.r := getRetimed(x3417.r, 5.toInt, io.sigsIn.backpressure)
          val x19417 = Wire(Bool()).suggestName("x19417_b3121_D21") 
          x19417.r := getRetimed(b3121.r, 21.toInt, io.sigsIn.backpressure)
          val x19418 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19418_x3418_div_D1") 
          x19418.r := getRetimed(x3418_div.r, 1.toInt, io.sigsIn.backpressure)
          val x19419 = Wire(Bool()).suggestName("x19419_b3307_D21") 
          x19419.r := getRetimed(b3307.r, 21.toInt, io.sigsIn.backpressure)
          val x19420 = Wire(Bool()).suggestName("x19420_b3215_D21") 
          x19420.r := getRetimed(b3215.r, 21.toInt, io.sigsIn.backpressure)
          val x19421 = Wire(Bool()).suggestName("x19421_b3306_D21") 
          x19421.r := getRetimed(b3306.r, 21.toInt, io.sigsIn.backpressure)
          val x19422 = Wire(Bool()).suggestName("x19422_b3220_D21") 
          x19422.r := getRetimed(b3220.r, 21.toInt, io.sigsIn.backpressure)
          val x3421 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3421""")
          val x3421_banks = List[UInt](7L.FP(true, 32, 0).r,x19416.r)
          val x3421_ofs = List[UInt](x19418.r)
          val x3421_en = List[Bool](true.B)
          x3421.toSeq.zip(x3216_lb0_0.connectRPort(3421, x3421_banks, x3421_ofs, io.sigsIn.backpressure, x3421_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && x19422 & x19417 & x19420 & x19419 & x19421), true)).foreach{case (a,b) => a := b}
          val x3422_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3422_elem_0""")
          x3422_elem_0.r := x3421(0).r
          val x19423 = Wire(Bool()).suggestName("x19423_x3415_D22") 
          x19423.r := getRetimed(x3415.r, 22.toInt, io.sigsIn.backpressure)
          val x3423 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3423""")
          x3423.r := Mux((x19423), 0.FP(true, 10, 22).r, x3422_elem_0.r)
          val x3424_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3424_sum""")
          x3424_sum.r := Math.add(1L.FP(true, 32, 0),x3416,Some(1.0), true.B, Truncate, Wrapping, "x3424_sum").r
          val x3425 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3425""")
          x3425.r := (Math.mod(x3424_sum, 7L.FP(true, 32, 0), Some(16.0), true.B, Truncate, Wrapping, "x3425")).r
          val x3426_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3426_div""")
          x3426_div.r := (Math.div(x3424_sum, 7L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x3426_div")).r
          val x19424 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19424_x3425_D4") 
          x19424.r := getRetimed(x3425.r, 4.toInt, io.sigsIn.backpressure)
          val x3429 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3429""")
          val x3429_banks = List[UInt](7L.FP(true, 32, 0).r,x19424.r)
          val x3429_ofs = List[UInt](x3426_div.r)
          val x3429_en = List[Bool](true.B)
          x3429.toSeq.zip(x3216_lb0_0.connectRPort(3429, x3429_banks, x3429_ofs, io.sigsIn.backpressure, x3429_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && x19422 & x19417 & x19420 & x19419 & x19421), true)).foreach{case (a,b) => a := b}
          val x3430_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3430_elem_0""")
          x3430_elem_0.r := x3429(0).r
          val x3431 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3431""")
          x3431.r := Mux((x19423), 0.FP(true, 10, 22).r, x3430_elem_0.r)
          val x3432_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3432_sum""")
          x3432_sum.r := Math.add(2L.FP(true, 32, 0),x3416,Some(1.0), true.B, Truncate, Wrapping, "x3432_sum").r
          val x3433 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3433""")
          x3433.r := (Math.mod(x3432_sum, 7L.FP(true, 32, 0), Some(16.0), true.B, Truncate, Wrapping, "x3433")).r
          val x3434_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3434_div""")
          x3434_div.r := (Math.div(x3432_sum, 7L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x3434_div")).r
          val x19425 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19425_x3433_D4") 
          x19425.r := getRetimed(x3433.r, 4.toInt, io.sigsIn.backpressure)
          val x3437 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3437""")
          val x3437_banks = List[UInt](7L.FP(true, 32, 0).r,x19425.r)
          val x3437_ofs = List[UInt](x3434_div.r)
          val x3437_en = List[Bool](true.B)
          x3437.toSeq.zip(x3216_lb0_0.connectRPort(3437, x3437_banks, x3437_ofs, io.sigsIn.backpressure, x3437_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && x19422 & x19417 & x19420 & x19419 & x19421), true)).foreach{case (a,b) => a := b}
          val x3438_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3438_elem_0""")
          x3438_elem_0.r := x3437(0).r
          val x3439 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3439""")
          x3439.r := Mux((x19423), 0.FP(true, 10, 22).r, x3438_elem_0.r)
          val x3440_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3440_sum""")
          x3440_sum.r := Math.add(3L.FP(true, 32, 0),x3416,Some(1.0), true.B, Truncate, Wrapping, "x3440_sum").r
          val x3441 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3441""")
          x3441.r := (Math.mod(x3440_sum, 7L.FP(true, 32, 0), Some(16.0), true.B, Truncate, Wrapping, "x3441")).r
          val x3442_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3442_div""")
          x3442_div.r := (Math.div(x3440_sum, 7L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x3442_div")).r
          val x19426 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19426_x3441_D4") 
          x19426.r := getRetimed(x3441.r, 4.toInt, io.sigsIn.backpressure)
          val x3445 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3445""")
          val x3445_banks = List[UInt](7L.FP(true, 32, 0).r,x19426.r)
          val x3445_ofs = List[UInt](x3442_div.r)
          val x3445_en = List[Bool](true.B)
          x3445.toSeq.zip(x3216_lb0_0.connectRPort(3445, x3445_banks, x3445_ofs, io.sigsIn.backpressure, x3445_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && x19422 & x19417 & x19420 & x19419 & x19421), true)).foreach{case (a,b) => a := b}
          val x3446_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3446_elem_0""")
          x3446_elem_0.r := x3445(0).r
          val x3447 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3447""")
          x3447.r := Mux((x19423), 0.FP(true, 10, 22).r, x3446_elem_0.r)
          val x3448_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3448_sum""")
          x3448_sum.r := Math.add(4L.FP(true, 32, 0),x3416,Some(1.0), true.B, Truncate, Wrapping, "x3448_sum").r
          val x3449 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3449""")
          x3449.r := (Math.mod(x3448_sum, 7L.FP(true, 32, 0), Some(16.0), true.B, Truncate, Wrapping, "x3449")).r
          val x3450_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3450_div""")
          x3450_div.r := (Math.div(x3448_sum, 7L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x3450_div")).r
          val x19427 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19427_x3449_D4") 
          x19427.r := getRetimed(x3449.r, 4.toInt, io.sigsIn.backpressure)
          Map[String,Any]("x3406_elem_0" -> x3406_elem_0, "x3408_elem_0" -> x3408_elem_0, "x3410_elem_0" -> x3410_elem_0, "x3412_elem_0" -> x3412_elem_0, "x3414_elem_0" -> x3414_elem_0, "x3416" -> x3416, "x19416" -> x19416, "x19417" -> x19417, "x19418" -> x19418, "x19419" -> x19419, "x19420" -> x19420, "x19421" -> x19421, "x19422" -> x19422, "x19423" -> x19423, "x3423" -> x3423, "x3426_div" -> x3426_div, "x19424" -> x19424, "x3431" -> x3431, "x3434_div" -> x3434_div, "x19425" -> x19425, "x3439" -> x3439, "x3442_div" -> x3442_div, "x19426" -> x19426, "x3447" -> x3447, "x3450_div" -> x3450_div, "x19427" -> x19427)
        }
      }
      val block1chunk2: Map[String, Any] = Block1Chunker2.gen()
      object Block1Chunker3 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x3453 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3453""")
          val x3453_banks = List[UInt](7L.FP(true, 32, 0).r,block1chunk2("x19427").asInstanceOf[FixedPoint].r)
          val x3453_ofs = List[UInt](block1chunk2("x3450_div").asInstanceOf[FixedPoint].r)
          val x3453_en = List[Bool](true.B)
          x3453.toSeq.zip(x3216_lb0_0.connectRPort(3453, x3453_banks, x3453_ofs, io.sigsIn.backpressure, x3453_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3454_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3454_elem_0""")
          x3454_elem_0.r := x3453(0).r
          val x3455 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3455""")
          x3455.r := Mux((block1chunk2("x19423").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, x3454_elem_0.r)
          val x3456_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3456_sum""")
          x3456_sum.r := Math.add(5L.FP(true, 32, 0),block1chunk2("x3416").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3456_sum").r
          val x3457 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3457""")
          x3457.r := (Math.mod(x3456_sum, 7L.FP(true, 32, 0), Some(16.0), true.B, Truncate, Wrapping, "x3457")).r
          val x3458_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3458_div""")
          x3458_div.r := (Math.div(x3456_sum, 7L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x3458_div")).r
          val x19428 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19428_x3457_D4") 
          x19428.r := getRetimed(x3457.r, 4.toInt, io.sigsIn.backpressure)
          val x3461 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3461""")
          val x3461_banks = List[UInt](7L.FP(true, 32, 0).r,x19428.r)
          val x3461_ofs = List[UInt](x3458_div.r)
          val x3461_en = List[Bool](true.B)
          x3461.toSeq.zip(x3216_lb0_0.connectRPort(3461, x3461_banks, x3461_ofs, io.sigsIn.backpressure, x3461_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3462_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3462_elem_0""")
          x3462_elem_0.r := x3461(0).r
          val x3463 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3463""")
          x3463.r := Mux((block1chunk2("x19423").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, x3462_elem_0.r)
          val x3464_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3464_sum""")
          x3464_sum.r := Math.add(6L.FP(true, 32, 0),block1chunk2("x3416").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3464_sum").r
          val x3465 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3465""")
          x3465.r := (Math.mod(x3464_sum, 7L.FP(true, 32, 0), Some(16.0), true.B, Truncate, Wrapping, "x3465")).r
          val x3466_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3466_div""")
          x3466_div.r := (Math.div(x3464_sum, 7L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x3466_div")).r
          val x19429 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19429_x3465_D4") 
          x19429.r := getRetimed(x3465.r, 4.toInt, io.sigsIn.backpressure)
          val x3469 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3469""")
          val x3469_banks = List[UInt](7L.FP(true, 32, 0).r,x19429.r)
          val x3469_ofs = List[UInt](x3466_div.r)
          val x3469_en = List[Bool](true.B)
          x3469.toSeq.zip(x3216_lb0_0.connectRPort(3469, x3469_banks, x3469_ofs, io.sigsIn.backpressure, x3469_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3470_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3470_elem_0""")
          x3470_elem_0.r := x3469(0).r
          val x3471 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3471""")
          x3471.r := Mux((block1chunk2("x19423").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, x3470_elem_0.r)
          val x3472 = Wire(Bool()).suggestName("""x3472""")
          x3472.r := Math.lt(1L.FP(true, 32, 0), block1chunk0("x3310").asInstanceOf[FixedPoint], Some(0.4), true.B,"x3472").r
          val x3473 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3473""")
          val x3473_banks = List[UInt](6L.FP(true, 32, 0).r,block1chunk2("x19416").asInstanceOf[FixedPoint].r)
          val x3473_ofs = List[UInt](block1chunk2("x19418").asInstanceOf[FixedPoint].r)
          val x3473_en = List[Bool](true.B)
          x3473.toSeq.zip(x3216_lb0_0.connectRPort(3473, x3473_banks, x3473_ofs, io.sigsIn.backpressure, x3473_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3474_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3474_elem_0""")
          x3474_elem_0.r := x3473(0).r
          val x19430 = Wire(Bool()).suggestName("x19430_x3472_D22") 
          x19430.r := getRetimed(x3472.r, 22.toInt, io.sigsIn.backpressure)
          val x3475 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3475""")
          x3475.r := Mux((x19430), 0.FP(true, 10, 22).r, x3474_elem_0.r)
          val x3476 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3476""")
          val x3476_banks = List[UInt](6L.FP(true, 32, 0).r,block1chunk2("x19424").asInstanceOf[FixedPoint].r)
          val x3476_ofs = List[UInt](block1chunk2("x3426_div").asInstanceOf[FixedPoint].r)
          val x3476_en = List[Bool](true.B)
          x3476.toSeq.zip(x3216_lb0_0.connectRPort(3476, x3476_banks, x3476_ofs, io.sigsIn.backpressure, x3476_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3477_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3477_elem_0""")
          x3477_elem_0.r := x3476(0).r
          val x3478 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3478""")
          x3478.r := Mux((x19430), 0.FP(true, 10, 22).r, x3477_elem_0.r)
          val x3479 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3479""")
          val x3479_banks = List[UInt](6L.FP(true, 32, 0).r,block1chunk2("x19425").asInstanceOf[FixedPoint].r)
          val x3479_ofs = List[UInt](block1chunk2("x3434_div").asInstanceOf[FixedPoint].r)
          val x3479_en = List[Bool](true.B)
          x3479.toSeq.zip(x3216_lb0_0.connectRPort(3479, x3479_banks, x3479_ofs, io.sigsIn.backpressure, x3479_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3480_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3480_elem_0""")
          x3480_elem_0.r := x3479(0).r
          val x3481 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3481""")
          x3481.r := Mux((x19430), 0.FP(true, 10, 22).r, x3480_elem_0.r)
          val x3482 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3482""")
          val x3482_banks = List[UInt](6L.FP(true, 32, 0).r,block1chunk2("x19426").asInstanceOf[FixedPoint].r)
          val x3482_ofs = List[UInt](block1chunk2("x3442_div").asInstanceOf[FixedPoint].r)
          val x3482_en = List[Bool](true.B)
          x3482.toSeq.zip(x3216_lb0_0.connectRPort(3482, x3482_banks, x3482_ofs, io.sigsIn.backpressure, x3482_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3483_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3483_elem_0""")
          x3483_elem_0.r := x3482(0).r
          val x3484 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3484""")
          x3484.r := Mux((x19430), 0.FP(true, 10, 22).r, x3483_elem_0.r)
          val x3485 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3485""")
          val x3485_banks = List[UInt](6L.FP(true, 32, 0).r,block1chunk2("x19427").asInstanceOf[FixedPoint].r)
          val x3485_ofs = List[UInt](block1chunk2("x3450_div").asInstanceOf[FixedPoint].r)
          val x3485_en = List[Bool](true.B)
          x3485.toSeq.zip(x3216_lb0_0.connectRPort(3485, x3485_banks, x3485_ofs, io.sigsIn.backpressure, x3485_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3486_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3486_elem_0""")
          x3486_elem_0.r := x3485(0).r
          val x3487 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3487""")
          x3487.r := Mux((x19430), 0.FP(true, 10, 22).r, x3486_elem_0.r)
          val x3488 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3488""")
          val x3488_banks = List[UInt](6L.FP(true, 32, 0).r,x19428.r)
          val x3488_ofs = List[UInt](x3458_div.r)
          val x3488_en = List[Bool](true.B)
          x3488.toSeq.zip(x3216_lb0_0.connectRPort(3488, x3488_banks, x3488_ofs, io.sigsIn.backpressure, x3488_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3489_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3489_elem_0""")
          x3489_elem_0.r := x3488(0).r
          val x3490 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3490""")
          x3490.r := Mux((x19430), 0.FP(true, 10, 22).r, x3489_elem_0.r)
          val x3491 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3491""")
          val x3491_banks = List[UInt](6L.FP(true, 32, 0).r,x19429.r)
          val x3491_ofs = List[UInt](x3466_div.r)
          val x3491_en = List[Bool](true.B)
          x3491.toSeq.zip(x3216_lb0_0.connectRPort(3491, x3491_banks, x3491_ofs, io.sigsIn.backpressure, x3491_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3492_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3492_elem_0""")
          x3492_elem_0.r := x3491(0).r
          val x3493 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3493""")
          x3493.r := Mux((x19430), 0.FP(true, 10, 22).r, x3492_elem_0.r)
          val x3494 = Wire(Bool()).suggestName("""x3494""")
          x3494.r := Math.lt(2L.FP(true, 32, 0), block1chunk0("x3310").asInstanceOf[FixedPoint], Some(0.4), true.B,"x3494").r
          val x3495 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3495""")
          val x3495_banks = List[UInt](5L.FP(true, 32, 0).r,block1chunk2("x19416").asInstanceOf[FixedPoint].r)
          val x3495_ofs = List[UInt](block1chunk2("x19418").asInstanceOf[FixedPoint].r)
          val x3495_en = List[Bool](true.B)
          x3495.toSeq.zip(x3216_lb0_0.connectRPort(3495, x3495_banks, x3495_ofs, io.sigsIn.backpressure, x3495_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3496_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3496_elem_0""")
          x3496_elem_0.r := x3495(0).r
          val x19431 = Wire(Bool()).suggestName("x19431_x3494_D22") 
          x19431.r := getRetimed(x3494.r, 22.toInt, io.sigsIn.backpressure)
          val x3497 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3497""")
          x3497.r := Mux((x19431), 0.FP(true, 10, 22).r, x3496_elem_0.r)
          val x3498 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3498""")
          val x3498_banks = List[UInt](5L.FP(true, 32, 0).r,block1chunk2("x19424").asInstanceOf[FixedPoint].r)
          val x3498_ofs = List[UInt](block1chunk2("x3426_div").asInstanceOf[FixedPoint].r)
          val x3498_en = List[Bool](true.B)
          x3498.toSeq.zip(x3216_lb0_0.connectRPort(3498, x3498_banks, x3498_ofs, io.sigsIn.backpressure, x3498_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3499_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3499_elem_0""")
          x3499_elem_0.r := x3498(0).r
          val x3500 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3500""")
          x3500.r := Mux((x19431), 0.FP(true, 10, 22).r, x3499_elem_0.r)
          val x3501 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3501""")
          val x3501_banks = List[UInt](5L.FP(true, 32, 0).r,block1chunk2("x19425").asInstanceOf[FixedPoint].r)
          val x3501_ofs = List[UInt](block1chunk2("x3434_div").asInstanceOf[FixedPoint].r)
          val x3501_en = List[Bool](true.B)
          x3501.toSeq.zip(x3216_lb0_0.connectRPort(3501, x3501_banks, x3501_ofs, io.sigsIn.backpressure, x3501_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          Map[String,Any]("x3455" -> x3455, "x3458_div" -> x3458_div, "x19428" -> x19428, "x3463" -> x3463, "x3466_div" -> x3466_div, "x19429" -> x19429, "x3471" -> x3471, "x3475" -> x3475, "x3478" -> x3478, "x3481" -> x3481, "x3484" -> x3484, "x3487" -> x3487, "x3490" -> x3490, "x3493" -> x3493, "x19431" -> x19431, "x3497" -> x3497, "x3500" -> x3500, "x3501" -> x3501)
        }
      }
      val block1chunk3: Map[String, Any] = Block1Chunker3.gen()
      object Block1Chunker4 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x3502_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3502_elem_0""")
          x3502_elem_0.r := block1chunk3("x3501").asInstanceOf[Vec[FixedPoint]](0).r
          val x3503 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3503""")
          x3503.r := Mux((block1chunk3("x19431").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, x3502_elem_0.r)
          val x3504 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3504""")
          val x3504_banks = List[UInt](5L.FP(true, 32, 0).r,block1chunk2("x19426").asInstanceOf[FixedPoint].r)
          val x3504_ofs = List[UInt](block1chunk2("x3442_div").asInstanceOf[FixedPoint].r)
          val x3504_en = List[Bool](true.B)
          x3504.toSeq.zip(x3216_lb0_0.connectRPort(3504, x3504_banks, x3504_ofs, io.sigsIn.backpressure, x3504_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3505_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3505_elem_0""")
          x3505_elem_0.r := x3504(0).r
          val x3506 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3506""")
          x3506.r := Mux((block1chunk3("x19431").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, x3505_elem_0.r)
          val x3507 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3507""")
          val x3507_banks = List[UInt](5L.FP(true, 32, 0).r,block1chunk2("x19427").asInstanceOf[FixedPoint].r)
          val x3507_ofs = List[UInt](block1chunk2("x3450_div").asInstanceOf[FixedPoint].r)
          val x3507_en = List[Bool](true.B)
          x3507.toSeq.zip(x3216_lb0_0.connectRPort(3507, x3507_banks, x3507_ofs, io.sigsIn.backpressure, x3507_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3508_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3508_elem_0""")
          x3508_elem_0.r := x3507(0).r
          val x3509 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3509""")
          x3509.r := Mux((block1chunk3("x19431").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, x3508_elem_0.r)
          val x3510 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3510""")
          val x3510_banks = List[UInt](5L.FP(true, 32, 0).r,block1chunk3("x19428").asInstanceOf[FixedPoint].r)
          val x3510_ofs = List[UInt](block1chunk3("x3458_div").asInstanceOf[FixedPoint].r)
          val x3510_en = List[Bool](true.B)
          x3510.toSeq.zip(x3216_lb0_0.connectRPort(3510, x3510_banks, x3510_ofs, io.sigsIn.backpressure, x3510_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3511_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3511_elem_0""")
          x3511_elem_0.r := x3510(0).r
          val x3512 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3512""")
          x3512.r := Mux((block1chunk3("x19431").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, x3511_elem_0.r)
          val x3513 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3513""")
          val x3513_banks = List[UInt](5L.FP(true, 32, 0).r,block1chunk3("x19429").asInstanceOf[FixedPoint].r)
          val x3513_ofs = List[UInt](block1chunk3("x3466_div").asInstanceOf[FixedPoint].r)
          val x3513_en = List[Bool](true.B)
          x3513.toSeq.zip(x3216_lb0_0.connectRPort(3513, x3513_banks, x3513_ofs, io.sigsIn.backpressure, x3513_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3514_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3514_elem_0""")
          x3514_elem_0.r := x3513(0).r
          val x3515 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3515""")
          x3515.r := Mux((block1chunk3("x19431").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, x3514_elem_0.r)
          val x3516 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3516""")
          val x3516_banks = List[UInt](4L.FP(true, 32, 0).r,block1chunk2("x19416").asInstanceOf[FixedPoint].r)
          val x3516_ofs = List[UInt](block1chunk2("x19418").asInstanceOf[FixedPoint].r)
          val x3516_en = List[Bool](true.B)
          x3516.toSeq.zip(x3216_lb0_0.connectRPort(3516, x3516_banks, x3516_ofs, io.sigsIn.backpressure, x3516_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3517_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3517_elem_0""")
          x3517_elem_0.r := x3516(0).r
          val x3518 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3518""")
          val x3518_banks = List[UInt](4L.FP(true, 32, 0).r,block1chunk2("x19424").asInstanceOf[FixedPoint].r)
          val x3518_ofs = List[UInt](block1chunk2("x3426_div").asInstanceOf[FixedPoint].r)
          val x3518_en = List[Bool](true.B)
          x3518.toSeq.zip(x3216_lb0_0.connectRPort(3518, x3518_banks, x3518_ofs, io.sigsIn.backpressure, x3518_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3519_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3519_elem_0""")
          x3519_elem_0.r := x3518(0).r
          val x3520 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3520""")
          val x3520_banks = List[UInt](4L.FP(true, 32, 0).r,block1chunk2("x19425").asInstanceOf[FixedPoint].r)
          val x3520_ofs = List[UInt](block1chunk2("x3434_div").asInstanceOf[FixedPoint].r)
          val x3520_en = List[Bool](true.B)
          x3520.toSeq.zip(x3216_lb0_0.connectRPort(3520, x3520_banks, x3520_ofs, io.sigsIn.backpressure, x3520_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3521_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3521_elem_0""")
          x3521_elem_0.r := x3520(0).r
          val x3522 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3522""")
          val x3522_banks = List[UInt](4L.FP(true, 32, 0).r,block1chunk2("x19426").asInstanceOf[FixedPoint].r)
          val x3522_ofs = List[UInt](block1chunk2("x3442_div").asInstanceOf[FixedPoint].r)
          val x3522_en = List[Bool](true.B)
          x3522.toSeq.zip(x3216_lb0_0.connectRPort(3522, x3522_banks, x3522_ofs, io.sigsIn.backpressure, x3522_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3523_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3523_elem_0""")
          x3523_elem_0.r := x3522(0).r
          val x3524 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3524""")
          val x3524_banks = List[UInt](4L.FP(true, 32, 0).r,block1chunk2("x19427").asInstanceOf[FixedPoint].r)
          val x3524_ofs = List[UInt](block1chunk2("x3450_div").asInstanceOf[FixedPoint].r)
          val x3524_en = List[Bool](true.B)
          x3524.toSeq.zip(x3216_lb0_0.connectRPort(3524, x3524_banks, x3524_ofs, io.sigsIn.backpressure, x3524_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3525_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3525_elem_0""")
          x3525_elem_0.r := x3524(0).r
          val x3526 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3526""")
          val x3526_banks = List[UInt](4L.FP(true, 32, 0).r,block1chunk3("x19428").asInstanceOf[FixedPoint].r)
          val x3526_ofs = List[UInt](block1chunk3("x3458_div").asInstanceOf[FixedPoint].r)
          val x3526_en = List[Bool](true.B)
          x3526.toSeq.zip(x3216_lb0_0.connectRPort(3526, x3526_banks, x3526_ofs, io.sigsIn.backpressure, x3526_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3527_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3527_elem_0""")
          x3527_elem_0.r := x3526(0).r
          val x3528 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3528""")
          val x3528_banks = List[UInt](4L.FP(true, 32, 0).r,block1chunk3("x19429").asInstanceOf[FixedPoint].r)
          val x3528_ofs = List[UInt](block1chunk3("x3466_div").asInstanceOf[FixedPoint].r)
          val x3528_en = List[Bool](true.B)
          x3528.toSeq.zip(x3216_lb0_0.connectRPort(3528, x3528_banks, x3528_ofs, io.sigsIn.backpressure, x3528_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3529_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3529_elem_0""")
          x3529_elem_0.r := x3528(0).r
          val x3530 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3530""")
          val x3530_banks = List[UInt](3L.FP(true, 32, 0).r,block1chunk2("x19416").asInstanceOf[FixedPoint].r)
          val x3530_ofs = List[UInt](block1chunk2("x19418").asInstanceOf[FixedPoint].r)
          val x3530_en = List[Bool](true.B)
          x3530.toSeq.zip(x3216_lb0_0.connectRPort(3530, x3530_banks, x3530_ofs, io.sigsIn.backpressure, x3530_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3531_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3531_elem_0""")
          x3531_elem_0.r := x3530(0).r
          val x3532 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3532""")
          val x3532_banks = List[UInt](3L.FP(true, 32, 0).r,block1chunk2("x19424").asInstanceOf[FixedPoint].r)
          val x3532_ofs = List[UInt](block1chunk2("x3426_div").asInstanceOf[FixedPoint].r)
          val x3532_en = List[Bool](true.B)
          x3532.toSeq.zip(x3216_lb0_0.connectRPort(3532, x3532_banks, x3532_ofs, io.sigsIn.backpressure, x3532_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3533_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3533_elem_0""")
          x3533_elem_0.r := x3532(0).r
          val x3534 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3534""")
          val x3534_banks = List[UInt](3L.FP(true, 32, 0).r,block1chunk2("x19425").asInstanceOf[FixedPoint].r)
          val x3534_ofs = List[UInt](block1chunk2("x3434_div").asInstanceOf[FixedPoint].r)
          val x3534_en = List[Bool](true.B)
          x3534.toSeq.zip(x3216_lb0_0.connectRPort(3534, x3534_banks, x3534_ofs, io.sigsIn.backpressure, x3534_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3535_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3535_elem_0""")
          x3535_elem_0.r := x3534(0).r
          val x3536 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3536""")
          val x3536_banks = List[UInt](3L.FP(true, 32, 0).r,block1chunk2("x19426").asInstanceOf[FixedPoint].r)
          val x3536_ofs = List[UInt](block1chunk2("x3442_div").asInstanceOf[FixedPoint].r)
          val x3536_en = List[Bool](true.B)
          x3536.toSeq.zip(x3216_lb0_0.connectRPort(3536, x3536_banks, x3536_ofs, io.sigsIn.backpressure, x3536_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3537_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3537_elem_0""")
          x3537_elem_0.r := x3536(0).r
          val x3538 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3538""")
          val x3538_banks = List[UInt](3L.FP(true, 32, 0).r,block1chunk2("x19427").asInstanceOf[FixedPoint].r)
          val x3538_ofs = List[UInt](block1chunk2("x3450_div").asInstanceOf[FixedPoint].r)
          val x3538_en = List[Bool](true.B)
          x3538.toSeq.zip(x3216_lb0_0.connectRPort(3538, x3538_banks, x3538_ofs, io.sigsIn.backpressure, x3538_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3539_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3539_elem_0""")
          x3539_elem_0.r := x3538(0).r
          val x3540 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3540""")
          val x3540_banks = List[UInt](3L.FP(true, 32, 0).r,block1chunk3("x19428").asInstanceOf[FixedPoint].r)
          val x3540_ofs = List[UInt](block1chunk3("x3458_div").asInstanceOf[FixedPoint].r)
          val x3540_en = List[Bool](true.B)
          x3540.toSeq.zip(x3216_lb0_0.connectRPort(3540, x3540_banks, x3540_ofs, io.sigsIn.backpressure, x3540_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3541_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3541_elem_0""")
          x3541_elem_0.r := x3540(0).r
          val x3542 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3542""")
          val x3542_banks = List[UInt](3L.FP(true, 32, 0).r,block1chunk3("x19429").asInstanceOf[FixedPoint].r)
          val x3542_ofs = List[UInt](block1chunk3("x3466_div").asInstanceOf[FixedPoint].r)
          val x3542_en = List[Bool](true.B)
          x3542.toSeq.zip(x3216_lb0_0.connectRPort(3542, x3542_banks, x3542_ofs, io.sigsIn.backpressure, x3542_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3543_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3543_elem_0""")
          x3543_elem_0.r := x3542(0).r
          val x3544 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3544""")
          val x3544_banks = List[UInt](2L.FP(true, 32, 0).r,block1chunk2("x19416").asInstanceOf[FixedPoint].r)
          val x3544_ofs = List[UInt](block1chunk2("x19418").asInstanceOf[FixedPoint].r)
          val x3544_en = List[Bool](true.B)
          x3544.toSeq.zip(x3216_lb0_0.connectRPort(3544, x3544_banks, x3544_ofs, io.sigsIn.backpressure, x3544_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3545_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3545_elem_0""")
          x3545_elem_0.r := x3544(0).r
          val x3546 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3546""")
          val x3546_banks = List[UInt](2L.FP(true, 32, 0).r,block1chunk2("x19424").asInstanceOf[FixedPoint].r)
          val x3546_ofs = List[UInt](block1chunk2("x3426_div").asInstanceOf[FixedPoint].r)
          val x3546_en = List[Bool](true.B)
          x3546.toSeq.zip(x3216_lb0_0.connectRPort(3546, x3546_banks, x3546_ofs, io.sigsIn.backpressure, x3546_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3547_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3547_elem_0""")
          x3547_elem_0.r := x3546(0).r
          val x3548 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3548""")
          val x3548_banks = List[UInt](2L.FP(true, 32, 0).r,block1chunk2("x19425").asInstanceOf[FixedPoint].r)
          val x3548_ofs = List[UInt](block1chunk2("x3434_div").asInstanceOf[FixedPoint].r)
          val x3548_en = List[Bool](true.B)
          x3548.toSeq.zip(x3216_lb0_0.connectRPort(3548, x3548_banks, x3548_ofs, io.sigsIn.backpressure, x3548_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3549_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3549_elem_0""")
          x3549_elem_0.r := x3548(0).r
          val x3550 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3550""")
          val x3550_banks = List[UInt](2L.FP(true, 32, 0).r,block1chunk2("x19426").asInstanceOf[FixedPoint].r)
          val x3550_ofs = List[UInt](block1chunk2("x3442_div").asInstanceOf[FixedPoint].r)
          val x3550_en = List[Bool](true.B)
          x3550.toSeq.zip(x3216_lb0_0.connectRPort(3550, x3550_banks, x3550_ofs, io.sigsIn.backpressure, x3550_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          Map[String,Any]("x3503" -> x3503, "x3506" -> x3506, "x3509" -> x3509, "x3512" -> x3512, "x3515" -> x3515, "x3517_elem_0" -> x3517_elem_0, "x3519_elem_0" -> x3519_elem_0, "x3521_elem_0" -> x3521_elem_0, "x3523_elem_0" -> x3523_elem_0, "x3525_elem_0" -> x3525_elem_0, "x3527_elem_0" -> x3527_elem_0, "x3529_elem_0" -> x3529_elem_0, "x3531_elem_0" -> x3531_elem_0, "x3533_elem_0" -> x3533_elem_0, "x3535_elem_0" -> x3535_elem_0, "x3537_elem_0" -> x3537_elem_0, "x3539_elem_0" -> x3539_elem_0, "x3541_elem_0" -> x3541_elem_0, "x3543_elem_0" -> x3543_elem_0, "x3545_elem_0" -> x3545_elem_0, "x3547_elem_0" -> x3547_elem_0, "x3549_elem_0" -> x3549_elem_0, "x3550" -> x3550)
        }
      }
      val block1chunk4: Map[String, Any] = Block1Chunker4.gen()
      object Block1Chunker5 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x3551_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3551_elem_0""")
          x3551_elem_0.r := block1chunk4("x3550").asInstanceOf[Vec[FixedPoint]](0).r
          val x3552 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3552""")
          val x3552_banks = List[UInt](2L.FP(true, 32, 0).r,block1chunk2("x19427").asInstanceOf[FixedPoint].r)
          val x3552_ofs = List[UInt](block1chunk2("x3450_div").asInstanceOf[FixedPoint].r)
          val x3552_en = List[Bool](true.B)
          x3552.toSeq.zip(x3216_lb0_0.connectRPort(3552, x3552_banks, x3552_ofs, io.sigsIn.backpressure, x3552_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3553_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3553_elem_0""")
          x3553_elem_0.r := x3552(0).r
          val x3554 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3554""")
          val x3554_banks = List[UInt](2L.FP(true, 32, 0).r,block1chunk3("x19428").asInstanceOf[FixedPoint].r)
          val x3554_ofs = List[UInt](block1chunk3("x3458_div").asInstanceOf[FixedPoint].r)
          val x3554_en = List[Bool](true.B)
          x3554.toSeq.zip(x3216_lb0_0.connectRPort(3554, x3554_banks, x3554_ofs, io.sigsIn.backpressure, x3554_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3555_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3555_elem_0""")
          x3555_elem_0.r := x3554(0).r
          val x3556 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3556""")
          val x3556_banks = List[UInt](2L.FP(true, 32, 0).r,block1chunk3("x19429").asInstanceOf[FixedPoint].r)
          val x3556_ofs = List[UInt](block1chunk3("x3466_div").asInstanceOf[FixedPoint].r)
          val x3556_en = List[Bool](true.B)
          x3556.toSeq.zip(x3216_lb0_0.connectRPort(3556, x3556_banks, x3556_ofs, io.sigsIn.backpressure, x3556_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3557_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3557_elem_0""")
          x3557_elem_0.r := x3556(0).r
          val x3558 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3558""")
          val x3558_banks = List[UInt](1L.FP(true, 32, 0).r,block1chunk2("x19416").asInstanceOf[FixedPoint].r)
          val x3558_ofs = List[UInt](block1chunk2("x19418").asInstanceOf[FixedPoint].r)
          val x3558_en = List[Bool](true.B)
          x3558.toSeq.zip(x3216_lb0_0.connectRPort(3558, x3558_banks, x3558_ofs, io.sigsIn.backpressure, x3558_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3559_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3559_elem_0""")
          x3559_elem_0.r := x3558(0).r
          val x3560 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3560""")
          val x3560_banks = List[UInt](1L.FP(true, 32, 0).r,block1chunk2("x19424").asInstanceOf[FixedPoint].r)
          val x3560_ofs = List[UInt](block1chunk2("x3426_div").asInstanceOf[FixedPoint].r)
          val x3560_en = List[Bool](true.B)
          x3560.toSeq.zip(x3216_lb0_0.connectRPort(3560, x3560_banks, x3560_ofs, io.sigsIn.backpressure, x3560_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3561_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3561_elem_0""")
          x3561_elem_0.r := x3560(0).r
          val x3562 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3562""")
          val x3562_banks = List[UInt](1L.FP(true, 32, 0).r,block1chunk2("x19425").asInstanceOf[FixedPoint].r)
          val x3562_ofs = List[UInt](block1chunk2("x3434_div").asInstanceOf[FixedPoint].r)
          val x3562_en = List[Bool](true.B)
          x3562.toSeq.zip(x3216_lb0_0.connectRPort(3562, x3562_banks, x3562_ofs, io.sigsIn.backpressure, x3562_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3563_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3563_elem_0""")
          x3563_elem_0.r := x3562(0).r
          val x3564 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3564""")
          val x3564_banks = List[UInt](1L.FP(true, 32, 0).r,block1chunk2("x19426").asInstanceOf[FixedPoint].r)
          val x3564_ofs = List[UInt](block1chunk2("x3442_div").asInstanceOf[FixedPoint].r)
          val x3564_en = List[Bool](true.B)
          x3564.toSeq.zip(x3216_lb0_0.connectRPort(3564, x3564_banks, x3564_ofs, io.sigsIn.backpressure, x3564_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3565_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3565_elem_0""")
          x3565_elem_0.r := x3564(0).r
          val x3566 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3566""")
          val x3566_banks = List[UInt](1L.FP(true, 32, 0).r,block1chunk2("x19427").asInstanceOf[FixedPoint].r)
          val x3566_ofs = List[UInt](block1chunk2("x3450_div").asInstanceOf[FixedPoint].r)
          val x3566_en = List[Bool](true.B)
          x3566.toSeq.zip(x3216_lb0_0.connectRPort(3566, x3566_banks, x3566_ofs, io.sigsIn.backpressure, x3566_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3567_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3567_elem_0""")
          x3567_elem_0.r := x3566(0).r
          val x3568 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3568""")
          val x3568_banks = List[UInt](1L.FP(true, 32, 0).r,block1chunk3("x19428").asInstanceOf[FixedPoint].r)
          val x3568_ofs = List[UInt](block1chunk3("x3458_div").asInstanceOf[FixedPoint].r)
          val x3568_en = List[Bool](true.B)
          x3568.toSeq.zip(x3216_lb0_0.connectRPort(3568, x3568_banks, x3568_ofs, io.sigsIn.backpressure, x3568_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3569_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3569_elem_0""")
          x3569_elem_0.r := x3568(0).r
          val x3570 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3570""")
          val x3570_banks = List[UInt](1L.FP(true, 32, 0).r,block1chunk3("x19429").asInstanceOf[FixedPoint].r)
          val x3570_ofs = List[UInt](block1chunk3("x3466_div").asInstanceOf[FixedPoint].r)
          val x3570_en = List[Bool](true.B)
          x3570.toSeq.zip(x3216_lb0_0.connectRPort(3570, x3570_banks, x3570_ofs, io.sigsIn.backpressure, x3570_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.2.toInt, rr, io.sigsIn.backpressure) && block1chunk2("x19422").asInstanceOf[Bool] & block1chunk2("x19421").asInstanceOf[Bool] & block1chunk2("x19417").asInstanceOf[Bool] & block1chunk2("x19420").asInstanceOf[Bool] & block1chunk2("x19419").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x3571_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3571_elem_0""")
          x3571_elem_0.r := x3570(0).r
          val x19432 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19432_x3320_elem_0_D15") 
          x19432.r := getRetimed(block1chunk0("x3320_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3573_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3573_x30""")
          x3573_x30.r := (Math.mul(block1chunk2("x3431").asInstanceOf[FixedPoint], x19432, Some(6.0), true.B, Truncate, Wrapping, "x3573_x30")).r
          val x19433 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19433_x3324_elem_0_D15") 
          x19433.r := getRetimed(block1chunk0("x3324_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3575_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3575_x30""")
          x3575_x30.r := (Math.mul(block1chunk2("x3447").asInstanceOf[FixedPoint], x19433, Some(6.0), true.B, Truncate, Wrapping, "x3575_x30")).r
          val x19434 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19434_x3328_elem_0_D15") 
          x19434.r := getRetimed(block1chunk0("x3328_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3577_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3577_x30""")
          x3577_x30.r := (Math.mul(block1chunk3("x3463").asInstanceOf[FixedPoint], x19434, Some(6.0), true.B, Truncate, Wrapping, "x3577_x30")).r
          val x19435 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19435_x3332_elem_0_D15") 
          x19435.r := getRetimed(block1chunk0("x3332_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3579_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3579_x30""")
          x3579_x30.r := (Math.mul(block1chunk3("x3475").asInstanceOf[FixedPoint], x19435, Some(6.0), true.B, Truncate, Wrapping, "x3579_x30")).r
          val x19436 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19436_x3336_elem_0_D15") 
          x19436.r := getRetimed(block1chunk0("x3336_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3581_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3581_x30""")
          x3581_x30.r := (Math.mul(block1chunk3("x3481").asInstanceOf[FixedPoint], x19436, Some(6.0), true.B, Truncate, Wrapping, "x3581_x30")).r
          val x19437 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19437_x3340_elem_0_D15") 
          x19437.r := getRetimed(block1chunk0("x3340_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3583_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3583_x30""")
          x3583_x30.r := (Math.mul(block1chunk3("x3487").asInstanceOf[FixedPoint], x19437, Some(6.0), true.B, Truncate, Wrapping, "x3583_x30")).r
          val x19438 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19438_x3344_elem_0_D15") 
          x19438.r := getRetimed(block1chunk0("x3344_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3585_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3585_x30""")
          x3585_x30.r := (Math.mul(block1chunk3("x3493").asInstanceOf[FixedPoint], x19438, Some(6.0), true.B, Truncate, Wrapping, "x3585_x30")).r
          val x19439 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19439_x3348_elem_0_D15") 
          x19439.r := getRetimed(block1chunk0("x3348_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3587_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3587_x30""")
          x3587_x30.r := (Math.mul(block1chunk3("x3500").asInstanceOf[FixedPoint], x19439, Some(6.0), true.B, Truncate, Wrapping, "x3587_x30")).r
          val x19440 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19440_x3352_elem_0_D15") 
          x19440.r := getRetimed(block1chunk0("x3352_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3589_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3589_x30""")
          x3589_x30.r := (Math.mul(block1chunk4("x3506").asInstanceOf[FixedPoint], x19440, Some(6.0), true.B, Truncate, Wrapping, "x3589_x30")).r
          val x19441 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19441_x3356_elem_0_D15") 
          x19441.r := getRetimed(block1chunk0("x3356_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3591_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3591_x30""")
          x3591_x30.r := (Math.mul(block1chunk4("x3512").asInstanceOf[FixedPoint], x19441, Some(6.0), true.B, Truncate, Wrapping, "x3591_x30")).r
          val x19442 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19442_x3360_elem_0_D15") 
          x19442.r := getRetimed(block1chunk1("x3360_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3593_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3593_x30""")
          x3593_x30.r := (Math.mul(block1chunk4("x3517_elem_0").asInstanceOf[FixedPoint], x19442, Some(6.0), true.B, Truncate, Wrapping, "x3593_x30")).r
          val x19443 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19443_x3364_elem_0_D15") 
          x19443.r := getRetimed(block1chunk1("x3364_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3595_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3595_x30""")
          x3595_x30.r := (Math.mul(block1chunk4("x3521_elem_0").asInstanceOf[FixedPoint], x19443, Some(6.0), true.B, Truncate, Wrapping, "x3595_x30")).r
          val x19444 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19444_x3368_elem_0_D15") 
          x19444.r := getRetimed(block1chunk1("x3368_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3597_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3597_x30""")
          x3597_x30.r := (Math.mul(block1chunk4("x3525_elem_0").asInstanceOf[FixedPoint], x19444, Some(6.0), true.B, Truncate, Wrapping, "x3597_x30")).r
          val x19445 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19445_x3372_elem_0_D15") 
          x19445.r := getRetimed(block1chunk1("x3372_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3599_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3599_x30""")
          x3599_x30.r := (Math.mul(block1chunk4("x3529_elem_0").asInstanceOf[FixedPoint], x19445, Some(6.0), true.B, Truncate, Wrapping, "x3599_x30")).r
          Map[String,Any]("x3551_elem_0" -> x3551_elem_0, "x3553_elem_0" -> x3553_elem_0, "x3555_elem_0" -> x3555_elem_0, "x3557_elem_0" -> x3557_elem_0, "x3559_elem_0" -> x3559_elem_0, "x3561_elem_0" -> x3561_elem_0, "x3563_elem_0" -> x3563_elem_0, "x3565_elem_0" -> x3565_elem_0, "x3567_elem_0" -> x3567_elem_0, "x3569_elem_0" -> x3569_elem_0, "x3571_elem_0" -> x3571_elem_0, "x3573_x30" -> x3573_x30, "x3575_x30" -> x3575_x30, "x3577_x30" -> x3577_x30, "x3579_x30" -> x3579_x30, "x3581_x30" -> x3581_x30, "x3583_x30" -> x3583_x30, "x3585_x30" -> x3585_x30, "x3587_x30" -> x3587_x30, "x3589_x30" -> x3589_x30, "x3591_x30" -> x3591_x30, "x3593_x30" -> x3593_x30, "x3595_x30" -> x3595_x30, "x3597_x30" -> x3597_x30, "x3599_x30" -> x3599_x30)
        }
      }
      val block1chunk5: Map[String, Any] = Block1Chunker5.gen()
      object Block1Chunker6 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x19446 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19446_x3376_elem_0_D15") 
          x19446.r := getRetimed(block1chunk1("x3376_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3601_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3601_x30""")
          x3601_x30.r := (Math.mul(block1chunk4("x3533_elem_0").asInstanceOf[FixedPoint], x19446, Some(6.0), true.B, Truncate, Wrapping, "x3601_x30")).r
          val x19447 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19447_x3380_elem_0_D15") 
          x19447.r := getRetimed(block1chunk1("x3380_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3603_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3603_x30""")
          x3603_x30.r := (Math.mul(block1chunk4("x3537_elem_0").asInstanceOf[FixedPoint], x19447, Some(6.0), true.B, Truncate, Wrapping, "x3603_x30")).r
          val x19448 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19448_x3384_elem_0_D15") 
          x19448.r := getRetimed(block1chunk1("x3384_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3605_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3605_x30""")
          x3605_x30.r := (Math.mul(block1chunk4("x3541_elem_0").asInstanceOf[FixedPoint], x19448, Some(6.0), true.B, Truncate, Wrapping, "x3605_x30")).r
          val x19449 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19449_x3388_elem_0_D15") 
          x19449.r := getRetimed(block1chunk1("x3388_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3607_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3607_x30""")
          x3607_x30.r := (Math.mul(block1chunk4("x3545_elem_0").asInstanceOf[FixedPoint], x19449, Some(6.0), true.B, Truncate, Wrapping, "x3607_x30")).r
          val x19450 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19450_x3392_elem_0_D15") 
          x19450.r := getRetimed(block1chunk1("x3392_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3609_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3609_x30""")
          x3609_x30.r := (Math.mul(block1chunk4("x3549_elem_0").asInstanceOf[FixedPoint], x19450, Some(6.0), true.B, Truncate, Wrapping, "x3609_x30")).r
          val x19451 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19451_x3396_elem_0_D15") 
          x19451.r := getRetimed(block1chunk1("x3396_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3611_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3611_x30""")
          x3611_x30.r := (Math.mul(block1chunk5("x3553_elem_0").asInstanceOf[FixedPoint], x19451, Some(6.0), true.B, Truncate, Wrapping, "x3611_x30")).r
          val x19452 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19452_x3400_elem_0_D15") 
          x19452.r := getRetimed(block1chunk1("x3400_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3613_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3613_x30""")
          x3613_x30.r := (Math.mul(block1chunk5("x3557_elem_0").asInstanceOf[FixedPoint], x19452, Some(6.0), true.B, Truncate, Wrapping, "x3613_x30")).r
          val x19453 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19453_x3404_elem_0_D15") 
          x19453.r := getRetimed(block1chunk1("x3404_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3615_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3615_x30""")
          x3615_x30.r := (Math.mul(block1chunk5("x3561_elem_0").asInstanceOf[FixedPoint], x19453, Some(6.0), true.B, Truncate, Wrapping, "x3615_x30")).r
          val x19454 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19454_x3408_elem_0_D15") 
          x19454.r := getRetimed(block1chunk2("x3408_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3617_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3617_x30""")
          x3617_x30.r := (Math.mul(block1chunk5("x3565_elem_0").asInstanceOf[FixedPoint], x19454, Some(6.0), true.B, Truncate, Wrapping, "x3617_x30")).r
          val x19455 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19455_x3412_elem_0_D15") 
          x19455.r := getRetimed(block1chunk2("x3412_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
          val x3619_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3619_x30""")
          x3619_x30.r := (Math.mul(block1chunk5("x3569_elem_0").asInstanceOf[FixedPoint], x19455, Some(6.0), true.B, Truncate, Wrapping, "x3619_x30")).r
          val x19456 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19456_x3423_D7") 
          x19456.r := getRetimed(block1chunk2("x3423").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
          val x19457 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19457_x3573_x30_D1") 
          x19457.r := getRetimed(block1chunk5("x3573_x30").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x19458 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19458_x3318_elem_0_D22") 
          x19458.r := getRetimed(block1chunk0("x3318_elem_0").asInstanceOf[FixedPoint].r, 22.toInt, io.sigsIn.backpressure)
          val x18823 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18823""")
          x18823.r := Math.fma(x19456,x19458,x19457,Some(6.0), true.B, "x18823").toFixed(x18823, "cast_x18823").r
          val x19459 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19459_x3322_elem_0_D21") 
          x19459.r := getRetimed(block1chunk0("x3322_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x19460 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19460_x3439_D6") 
          x19460.r := getRetimed(block1chunk2("x3439").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x18824 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18824""")
          x18824.r := Math.fma(x19460,x19459,block1chunk5("x3575_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18824").toFixed(x18824, "cast_x18824").r
          val x19461 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19461_x3455_D6") 
          x19461.r := getRetimed(block1chunk3("x3455").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19462 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19462_x3326_elem_0_D21") 
          x19462.r := getRetimed(block1chunk0("x3326_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18825 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18825""")
          x18825.r := Math.fma(x19461,x19462,block1chunk5("x3577_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18825").toFixed(x18825, "cast_x18825").r
          val x19463 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19463_x3330_elem_0_D21") 
          x19463.r := getRetimed(block1chunk0("x3330_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x19464 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19464_x3471_D6") 
          x19464.r := getRetimed(block1chunk3("x3471").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x18826 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18826""")
          x18826.r := Math.fma(x19464,x19463,block1chunk5("x3579_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18826").toFixed(x18826, "cast_x18826").r
          val x19465 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19465_x3478_D6") 
          x19465.r := getRetimed(block1chunk3("x3478").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19466 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19466_x3334_elem_0_D21") 
          x19466.r := getRetimed(block1chunk0("x3334_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18827 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18827""")
          x18827.r := Math.fma(x19465,x19466,block1chunk5("x3581_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18827").toFixed(x18827, "cast_x18827").r
          val x19467 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19467_x3484_D6") 
          x19467.r := getRetimed(block1chunk3("x3484").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19468 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19468_x3338_elem_0_D21") 
          x19468.r := getRetimed(block1chunk0("x3338_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18828 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18828""")
          x18828.r := Math.fma(x19467,x19468,block1chunk5("x3583_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18828").toFixed(x18828, "cast_x18828").r
          val x19469 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19469_x3490_D6") 
          x19469.r := getRetimed(block1chunk3("x3490").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19470 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19470_x3342_elem_0_D21") 
          x19470.r := getRetimed(block1chunk0("x3342_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18829 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18829""")
          x18829.r := Math.fma(x19469,x19470,block1chunk5("x3585_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18829").toFixed(x18829, "cast_x18829").r
          val x19471 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19471_x3497_D7") 
          x19471.r := getRetimed(block1chunk3("x3497").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
          val x19472 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19472_x3346_elem_0_D22") 
          x19472.r := getRetimed(block1chunk0("x3346_elem_0").asInstanceOf[FixedPoint].r, 22.toInt, io.sigsIn.backpressure)
          val x19473 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19473_x3587_x30_D1") 
          x19473.r := getRetimed(block1chunk5("x3587_x30").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x18830 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18830""")
          x18830.r := Math.fma(x19471,x19472,x19473,Some(6.0), true.B, "x18830").toFixed(x18830, "cast_x18830").r
          val x19474 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19474_x3503_D6") 
          x19474.r := getRetimed(block1chunk4("x3503").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19475 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19475_x3350_elem_0_D21") 
          x19475.r := getRetimed(block1chunk0("x3350_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18831 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18831""")
          x18831.r := Math.fma(x19474,x19475,block1chunk5("x3589_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18831").toFixed(x18831, "cast_x18831").r
          Map[String,Any]("x3601_x30" -> x3601_x30, "x3603_x30" -> x3603_x30, "x3605_x30" -> x3605_x30, "x3607_x30" -> x3607_x30, "x3609_x30" -> x3609_x30, "x3611_x30" -> x3611_x30, "x3613_x30" -> x3613_x30, "x3615_x30" -> x3615_x30, "x3617_x30" -> x3617_x30, "x3619_x30" -> x3619_x30, "x18823" -> x18823, "x18824" -> x18824, "x18825" -> x18825, "x18826" -> x18826, "x18827" -> x18827, "x18828" -> x18828, "x18829" -> x18829, "x18830" -> x18830, "x18831" -> x18831)
        }
      }
      val block1chunk6: Map[String, Any] = Block1Chunker6.gen()
      object Block1Chunker7 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x19476 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19476_x3354_elem_0_D21") 
          x19476.r := getRetimed(block1chunk0("x3354_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x19477 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19477_x3509_D6") 
          x19477.r := getRetimed(block1chunk4("x3509").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x18832 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18832""")
          x18832.r := Math.fma(x19477,x19476,block1chunk5("x3591_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18832").toFixed(x18832, "cast_x18832").r
          val x19478 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19478_x3515_D6") 
          x19478.r := getRetimed(block1chunk4("x3515").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19479 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19479_x3358_elem_0_D21") 
          x19479.r := getRetimed(block1chunk1("x3358_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18833 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18833""")
          x18833.r := Math.fma(x19478,x19479,block1chunk5("x3593_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18833").toFixed(x18833, "cast_x18833").r
          val x19480 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19480_x3362_elem_0_D21") 
          x19480.r := getRetimed(block1chunk1("x3362_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x19481 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19481_x3519_elem_0_D6") 
          x19481.r := getRetimed(block1chunk4("x3519_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x18834 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18834""")
          x18834.r := Math.fma(x19481,x19480,block1chunk5("x3595_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18834").toFixed(x18834, "cast_x18834").r
          val x19482 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19482_x3366_elem_0_D21") 
          x19482.r := getRetimed(block1chunk1("x3366_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x19483 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19483_x3523_elem_0_D6") 
          x19483.r := getRetimed(block1chunk4("x3523_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x18835 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18835""")
          x18835.r := Math.fma(x19483,x19482,block1chunk5("x3597_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18835").toFixed(x18835, "cast_x18835").r
          val x19484 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19484_x3527_elem_0_D6") 
          x19484.r := getRetimed(block1chunk4("x3527_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19485 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19485_x3370_elem_0_D21") 
          x19485.r := getRetimed(block1chunk1("x3370_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18836 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18836""")
          x18836.r := Math.fma(x19484,x19485,block1chunk5("x3599_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18836").toFixed(x18836, "cast_x18836").r
          val x19486 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19486_x3601_x30_D1") 
          x19486.r := getRetimed(block1chunk6("x3601_x30").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x19487 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19487_x3531_elem_0_D7") 
          x19487.r := getRetimed(block1chunk4("x3531_elem_0").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
          val x19488 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19488_x3374_elem_0_D22") 
          x19488.r := getRetimed(block1chunk1("x3374_elem_0").asInstanceOf[FixedPoint].r, 22.toInt, io.sigsIn.backpressure)
          val x18837 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18837""")
          x18837.r := Math.fma(x19487,x19488,x19486,Some(6.0), true.B, "x18837").toFixed(x18837, "cast_x18837").r
          val x19489 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19489_x3535_elem_0_D6") 
          x19489.r := getRetimed(block1chunk4("x3535_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19490 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19490_x3378_elem_0_D21") 
          x19490.r := getRetimed(block1chunk1("x3378_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18838 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18838""")
          x18838.r := Math.fma(x19489,x19490,block1chunk6("x3603_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18838").toFixed(x18838, "cast_x18838").r
          val x19491 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19491_x3539_elem_0_D6") 
          x19491.r := getRetimed(block1chunk4("x3539_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19492 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19492_x3382_elem_0_D21") 
          x19492.r := getRetimed(block1chunk1("x3382_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18839 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18839""")
          x18839.r := Math.fma(x19491,x19492,block1chunk6("x3605_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18839").toFixed(x18839, "cast_x18839").r
          val x19493 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19493_x3543_elem_0_D6") 
          x19493.r := getRetimed(block1chunk4("x3543_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19494 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19494_x3386_elem_0_D21") 
          x19494.r := getRetimed(block1chunk1("x3386_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18840 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18840""")
          x18840.r := Math.fma(x19493,x19494,block1chunk6("x3607_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18840").toFixed(x18840, "cast_x18840").r
          val x19495 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19495_x3547_elem_0_D6") 
          x19495.r := getRetimed(block1chunk4("x3547_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19496 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19496_x3390_elem_0_D21") 
          x19496.r := getRetimed(block1chunk1("x3390_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18841 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18841""")
          x18841.r := Math.fma(x19495,x19496,block1chunk6("x3609_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18841").toFixed(x18841, "cast_x18841").r
          val x19497 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19497_x3394_elem_0_D21") 
          x19497.r := getRetimed(block1chunk1("x3394_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x19498 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19498_x3551_elem_0_D6") 
          x19498.r := getRetimed(block1chunk5("x3551_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x18842 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18842""")
          x18842.r := Math.fma(x19498,x19497,block1chunk6("x3611_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18842").toFixed(x18842, "cast_x18842").r
          val x19499 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19499_x3398_elem_0_D21") 
          x19499.r := getRetimed(block1chunk1("x3398_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x19500 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19500_x3555_elem_0_D6") 
          x19500.r := getRetimed(block1chunk5("x3555_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x18843 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18843""")
          x18843.r := Math.fma(x19500,x19499,block1chunk6("x3613_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18843").toFixed(x18843, "cast_x18843").r
          val x19501 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19501_x3615_x30_D1") 
          x19501.r := getRetimed(block1chunk6("x3615_x30").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x19502 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19502_x3559_elem_0_D7") 
          x19502.r := getRetimed(block1chunk5("x3559_elem_0").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
          val x19503 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19503_x3402_elem_0_D22") 
          x19503.r := getRetimed(block1chunk1("x3402_elem_0").asInstanceOf[FixedPoint].r, 22.toInt, io.sigsIn.backpressure)
          val x18844 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18844""")
          x18844.r := Math.fma(x19502,x19503,x19501,Some(6.0), true.B, "x18844").toFixed(x18844, "cast_x18844").r
          val x19504 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19504_x3563_elem_0_D6") 
          x19504.r := getRetimed(block1chunk5("x3563_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19505 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19505_x3406_elem_0_D21") 
          x19505.r := getRetimed(block1chunk2("x3406_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18845 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18845""")
          x18845.r := Math.fma(x19504,x19505,block1chunk6("x3617_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18845").toFixed(x18845, "cast_x18845").r
          val x19506 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19506_x3567_elem_0_D6") 
          x19506.r := getRetimed(block1chunk5("x3567_elem_0").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
          val x19507 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19507_x3410_elem_0_D21") 
          x19507.r := getRetimed(block1chunk2("x3410_elem_0").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x18846 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18846""")
          x18846.r := Math.fma(x19506,x19507,block1chunk6("x3619_x30").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18846").toFixed(x18846, "cast_x18846").r
          val x19508 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19508_x18824_D1") 
          x19508.r := getRetimed(block1chunk6("x18824").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x3645_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3645_x29""")
          x3645_x29.r := Math.add(block1chunk6("x18823").asInstanceOf[FixedPoint],x19508,Some(1.0), true.B, Truncate, Wrapping, "x3645_x29").r
          Map[String,Any]("x18832" -> x18832, "x18833" -> x18833, "x18834" -> x18834, "x18835" -> x18835, "x18836" -> x18836, "x18837" -> x18837, "x18838" -> x18838, "x18839" -> x18839, "x18840" -> x18840, "x18841" -> x18841, "x18842" -> x18842, "x18843" -> x18843, "x18844" -> x18844, "x18845" -> x18845, "x18846" -> x18846, "x3645_x29" -> x3645_x29)
        }
      }
      val block1chunk7: Map[String, Any] = Block1Chunker7.gen()
      object Block1Chunker8 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x19509 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19509_x18826_D1") 
          x19509.r := getRetimed(block1chunk6("x18826").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x19510 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19510_x18825_D1") 
          x19510.r := getRetimed(block1chunk6("x18825").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x3646_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3646_x30""")
          x3646_x30.r := Math.add(x19510,x19509,Some(1.0), true.B, Truncate, Wrapping, "x3646_x30").r
          val x3647_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3647_x29""")
          x3647_x29.r := Math.add(block1chunk6("x18827").asInstanceOf[FixedPoint],block1chunk6("x18828").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3647_x29").r
          val x19511 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19511_x18829_D1") 
          x19511.r := getRetimed(block1chunk6("x18829").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x3648_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3648_x30""")
          x3648_x30.r := Math.add(x19511,block1chunk6("x18830").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3648_x30").r
          val x3649_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3649_x29""")
          x3649_x29.r := Math.add(block1chunk6("x18831").asInstanceOf[FixedPoint],block1chunk7("x18832").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3649_x29").r
          val x19512 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19512_x18833_D1") 
          x19512.r := getRetimed(block1chunk7("x18833").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x19513 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19513_x18834_D1") 
          x19513.r := getRetimed(block1chunk7("x18834").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x3650_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3650_x30""")
          x3650_x30.r := Math.add(x19512,x19513,Some(1.0), true.B, Truncate, Wrapping, "x3650_x30").r
          val x3651_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3651_x29""")
          x3651_x29.r := Math.add(block1chunk7("x18835").asInstanceOf[FixedPoint],block1chunk7("x18836").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3651_x29").r
          val x19514 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19514_x18838_D1") 
          x19514.r := getRetimed(block1chunk7("x18838").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x3652_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3652_x30""")
          x3652_x30.r := Math.add(block1chunk7("x18837").asInstanceOf[FixedPoint],x19514,Some(1.0), true.B, Truncate, Wrapping, "x3652_x30").r
          val x19515 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19515_x18840_D1") 
          x19515.r := getRetimed(block1chunk7("x18840").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x19516 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19516_x18839_D1") 
          x19516.r := getRetimed(block1chunk7("x18839").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x3653_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3653_x29""")
          x3653_x29.r := Math.add(x19516,x19515,Some(1.0), true.B, Truncate, Wrapping, "x3653_x29").r
          val x3654_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3654_x30""")
          x3654_x30.r := Math.add(block1chunk7("x18841").asInstanceOf[FixedPoint],block1chunk7("x18842").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3654_x30").r
          val x19517 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19517_x18843_D1") 
          x19517.r := getRetimed(block1chunk7("x18843").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x3655_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3655_x29""")
          x3655_x29.r := Math.add(x19517,block1chunk7("x18844").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3655_x29").r
          val x3656_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3656_x30""")
          x3656_x30.r := Math.add(block1chunk7("x18845").asInstanceOf[FixedPoint],block1chunk7("x18846").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3656_x30").r
          val x19518 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19518_x3645_x29_D1") 
          x19518.r := getRetimed(block1chunk7("x3645_x29").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x19519 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19519_x3646_x30_D1") 
          x19519.r := getRetimed(x3646_x30.r, 1.toInt, io.sigsIn.backpressure)
          val x3657_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3657_x29""")
          x3657_x29.r := Math.add(x19518,x19519,Some(1.0), true.B, Truncate, Wrapping, "x3657_x29").r
          val x19520 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19520_x3647_x29_D1") 
          x19520.r := getRetimed(x3647_x29.r, 1.toInt, io.sigsIn.backpressure)
          val x3658_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3658_x30""")
          x3658_x30.r := Math.add(x19520,x3648_x30,Some(1.0), true.B, Truncate, Wrapping, "x3658_x30").r
          val x19521 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19521_x3649_x29_D1") 
          x19521.r := getRetimed(x3649_x29.r, 1.toInt, io.sigsIn.backpressure)
          val x3659_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3659_x29""")
          x3659_x29.r := Math.add(x19521,x3650_x30,Some(1.0), true.B, Truncate, Wrapping, "x3659_x29").r
          val x19522 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19522_x3651_x29_D1") 
          x19522.r := getRetimed(x3651_x29.r, 1.toInt, io.sigsIn.backpressure)
          val x3660_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3660_x30""")
          x3660_x30.r := Math.add(x19522,x3652_x30,Some(1.0), true.B, Truncate, Wrapping, "x3660_x30").r
          val x19523 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19523_x3654_x30_D1") 
          x19523.r := getRetimed(x3654_x30.r, 1.toInt, io.sigsIn.backpressure)
          val x3661_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3661_x29""")
          x3661_x29.r := Math.add(x3653_x29,x19523,Some(1.0), true.B, Truncate, Wrapping, "x3661_x29").r
          val x19524 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19524_x3656_x30_D1") 
          x19524.r := getRetimed(x3656_x30.r, 1.toInt, io.sigsIn.backpressure)
          val x3662_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3662_x30""")
          x3662_x30.r := Math.add(x3655_x29,x19524,Some(1.0), true.B, Truncate, Wrapping, "x3662_x30").r
          val x19525 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19525_x3658_x30_D2") 
          x19525.r := getRetimed(x3658_x30.r, 2.toInt, io.sigsIn.backpressure)
          val x19526 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19526_x3657_x29_D1") 
          x19526.r := getRetimed(x3657_x29.r, 1.toInt, io.sigsIn.backpressure)
          val x3663_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3663_x29""")
          x3663_x29.r := Math.add(x19526,x19525,Some(1.0), true.B, Truncate, Wrapping, "x3663_x29").r
          val x19527 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19527_x3659_x29_D1") 
          x19527.r := getRetimed(x3659_x29.r, 1.toInt, io.sigsIn.backpressure)
          val x19528 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19528_x3660_x30_D1") 
          x19528.r := getRetimed(x3660_x30.r, 1.toInt, io.sigsIn.backpressure)
          val x3664_x30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3664_x30""")
          x3664_x30.r := Math.add(x19527,x19528,Some(1.0), true.B, Truncate, Wrapping, "x3664_x30").r
          val x19529 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19529_x3662_x30_D1") 
          x19529.r := getRetimed(x3662_x30.r, 1.toInt, io.sigsIn.backpressure)
          val x19530 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19530_x3661_x29_D1") 
          x19530.r := getRetimed(x3661_x29.r, 1.toInt, io.sigsIn.backpressure)
          val x3665_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3665_x29""")
          x3665_x29.r := Math.add(x19530,x19529,Some(1.0), true.B, Truncate, Wrapping, "x3665_x29").r
          val x19531 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19531_x3663_x29_D2") 
          x19531.r := getRetimed(x3663_x29.r, 2.toInt, io.sigsIn.backpressure)
          val x19532 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19532_x3664_x30_D3") 
          x19532.r := getRetimed(x3664_x30.r, 3.toInt, io.sigsIn.backpressure)
          val x3666_x29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3666_x29""")
          x3666_x29.r := Math.add(x19531,x19532,Some(1.0), true.B, Truncate, Wrapping, "x3666_x29").r
          val x19533 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19533_x3571_elem_0_D17") 
          x19533.r := getRetimed(block1chunk5("x3571_elem_0").asInstanceOf[FixedPoint].r, 17.toInt, io.sigsIn.backpressure)
          val x19534 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19534_x3414_elem_0_D32") 
          x19534.r := getRetimed(block1chunk2("x3414_elem_0").asInstanceOf[FixedPoint].r, 32.toInt, io.sigsIn.backpressure)
          val x18847 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18847""")
          x18847.r := Math.fma(x19533,x19534,x3665_x29,Some(6.0), true.B, "x18847").toFixed(x18847, "cast_x18847").r
          val x19535 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19535_x18847_D5") 
          x19535.r := getRetimed(x18847.r, 5.toInt, io.sigsIn.backpressure)
          Map[String,Any]("x3666_x29" -> x3666_x29, "x19535" -> x19535)
        }
      }
      val block1chunk8: Map[String, Any] = Block1Chunker8.gen()
      object Block1Chunker9 { // 29 nodes, 29 weight
        def gen(): Map[String, Any] = {
          val x19536 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19536_x3666_x29_D7") 
          x19536.r := getRetimed(block1chunk8("x3666_x29").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
          val x3668_partial_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3668_partial_sum""")
          x3668_partial_sum.r := Math.add(x19536,block1chunk8("x19535").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x3668_partial_sum").r
          val x3669 = Wire(Bool()).suggestName("""x3669""")
          x3669.r := Math.lte(3L.FP(true, 32, 0), b3219, Some(0.4), true.B,"x3669").r
          val x3671_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3671_sub""")
          x3671_sub.r := Math.sub(b3219,3L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x3671_sub").r
          val x3672 = Wire(Bool()).suggestName("""x3672""")
          x3672.r := Math.eql(b3214, 0L.FP(true, 32, 0), Some(0.2), true.B,"x3672").r
          val x19537 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19537_x3416_D1") 
          x19537.r := getRetimed(block1chunk2("x3416").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x18848 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18848""")
          x18848.r := Math.fma(x3671_sub,224L.FP(true, 32, 0),x19537,Some(6.0), true.B, "x18848").toFixed(x18848, "cast_x18848").r
          val x19538 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19538_b3305_D7") 
          x19538.r := getRetimed(b3305.r, 7.toInt, io.sigsIn.backpressure)
          val x3679_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3679_sum""")
          x3679_sum.r := Math.add(x18848,x19538,Some(1.0), true.B, Truncate, Wrapping, "x3679_sum").r
          val x19539 = Wire(Bool()).suggestName("x19539_x3669_D42") 
          x19539.r := getRetimed(x3669.r, 42.toInt, io.sigsIn.backpressure)
          val x19540 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19540_x3679_sum_D34") 
          x19540.r := getRetimed(x3679_sum.r, 34.toInt, io.sigsIn.backpressure)
          val x3681_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3681_rd""")
          val x3681_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3681_rd_ofs = List[UInt](x19540.r)
          val x3681_rd_en = List[Bool](true.B)
          x3681_rd.toSeq.zip(x3129_tmp0_SRAM_conv_7.connectRPort(3681, x3681_rd_banks, x3681_rd_ofs, io.sigsIn.backpressure, x3681_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(42.7.toInt, rr, io.sigsIn.backpressure) && x19539), true)).foreach{case (a,b) => a := b}
          val x3682_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3682_elem_0""")
          x3682_elem_0.r := x3681_rd(0).r
          val x19541 = Wire(Bool()).suggestName("x19541_x3672_D44") 
          x19541.r := getRetimed(x3672.r, 44.toInt, io.sigsIn.backpressure)
          val x3683 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3683""")
          x3683.r := Mux((x19541), 0.FP(true, 10, 22).r, x3682_elem_0.r)
          val x19542 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19542_x3683_D8") 
          x19542.r := getRetimed(x3683.r, 8.toInt, io.sigsIn.backpressure)
          val x3684_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3684_sum""")
          x3684_sum.r := Math.add(x3668_partial_sum,x19542,Some(1.0), true.B, Truncate, Wrapping, "x3684_sum").r
          val x19543 = Wire(Bool()).suggestName("x19543_x3669_D53") 
          x19543.r := getRetimed(x3669.r, 53.toInt, io.sigsIn.backpressure)
          val x19544 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19544_x3679_sum_D45") 
          x19544.r := getRetimed(x3679_sum.r, 45.toInt, io.sigsIn.backpressure)
          val x3685_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3685_wr_ofs = List[UInt](x19544.r)
          val x3685_wr_en = List[Bool](true.B)
          val x3685_wr_data = List[UInt](x3684_sum.r)
          x3131_tmp0_SRAM_conv_9.connectWPort(3685, x3685_wr_banks, x3685_wr_ofs, x3685_wr_data, x3685_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(53.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19543))
          val x3686_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3686_wr_ofs = List[UInt](x19544.r)
          val x3686_wr_en = List[Bool](true.B)
          val x3686_wr_data = List[UInt](x3684_sum.r)
          x3125_tmp0_SRAM_conv_3.connectWPort(3686, x3686_wr_banks, x3686_wr_ofs, x3686_wr_data, x3686_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(53.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19543))
          val x3687_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3687_wr_ofs = List[UInt](x19544.r)
          val x3687_wr_en = List[Bool](true.B)
          val x3687_wr_data = List[UInt](x3684_sum.r)
          x3122_tmp0_SRAM_conv_0.connectWPort(3687, x3687_wr_banks, x3687_wr_ofs, x3687_wr_data, x3687_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(53.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19543))
          val x3688_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3688_wr_ofs = List[UInt](x19544.r)
          val x3688_wr_en = List[Bool](true.B)
          val x3688_wr_data = List[UInt](x3684_sum.r)
          x3126_tmp0_SRAM_conv_4.connectWPort(3688, x3688_wr_banks, x3688_wr_ofs, x3688_wr_data, x3688_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(53.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19543))
          val x3689_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3689_wr_ofs = List[UInt](x19544.r)
          val x3689_wr_en = List[Bool](true.B)
          val x3689_wr_data = List[UInt](x3684_sum.r)
          x3130_tmp0_SRAM_conv_8.connectWPort(3689, x3689_wr_banks, x3689_wr_ofs, x3689_wr_data, x3689_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(53.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19543))
          val x3690_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3690_wr_ofs = List[UInt](x19544.r)
          val x3690_wr_en = List[Bool](true.B)
          val x3690_wr_data = List[UInt](x3684_sum.r)
          x3123_tmp0_SRAM_conv_1.connectWPort(3690, x3690_wr_banks, x3690_wr_ofs, x3690_wr_data, x3690_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(53.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19543))
          val x3691_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3691_wr_ofs = List[UInt](x19544.r)
          val x3691_wr_en = List[Bool](true.B)
          val x3691_wr_data = List[UInt](x3684_sum.r)
          x3129_tmp0_SRAM_conv_7.connectWPort(3691, x3691_wr_banks, x3691_wr_ofs, x3691_wr_data, x3691_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(53.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19543))
          val x3692_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3692_wr_ofs = List[UInt](x19544.r)
          val x3692_wr_en = List[Bool](true.B)
          val x3692_wr_data = List[UInt](x3684_sum.r)
          x3127_tmp0_SRAM_conv_5.connectWPort(3692, x3692_wr_banks, x3692_wr_ofs, x3692_wr_data, x3692_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(53.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19543))
          val x3693_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3693_wr_ofs = List[UInt](x19544.r)
          val x3693_wr_en = List[Bool](true.B)
          val x3693_wr_data = List[UInt](x3684_sum.r)
          x3124_tmp0_SRAM_conv_2.connectWPort(3693, x3693_wr_banks, x3693_wr_ofs, x3693_wr_data, x3693_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(53.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19543))
          val x3694_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x3694_wr_ofs = List[UInt](x19544.r)
          val x3694_wr_en = List[Bool](true.B)
          val x3694_wr_data = List[UInt](x3684_sum.r)
          x3128_tmp0_SRAM_conv_6.connectWPort(3694, x3694_wr_banks, x3694_wr_ofs, x3694_wr_data, x3694_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(53.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19543))
          Map[String,Any]()
        }
      }
      val block1chunk9: Map[String, Any] = Block1Chunker9.gen()
      x3216_lb0_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x3698_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3698_inr_Foreach **/
