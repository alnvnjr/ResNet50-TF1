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

/** Hierarchy: x17538 -> x17712 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17538_inr_Foreach **/
class x17538_inr_Foreach_kernel(
  list_b17303: List[Bool],
  list_b17302: List[FixedPoint],
  list_x9465_reg: List[StandardInterface],
  list_x9845_out_SRAM_conv_1: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 13.1.toInt, myName = "x17538_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17538_inr_Foreach_iiCtr"))
  
  abstract class x17538_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9845_out_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x9845_out_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_x9465_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9465_reg_p").asInstanceOf[MemParams] ))
      val in_x9497_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9497_reg_p").asInstanceOf[MemParams] ))
      val in_b17302 = Input(new FixedPoint(true, 32, 0))
      val in_b17303 = Input(Bool())
      val in_x9554_bias_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9554_bias_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x18806_rd_x3921 = Input(Bool())
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x9491_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9491_reg_p").asInstanceOf[MemParams] ))
      val in_b9553 = Input(Bool())
      val in_x17304_out_SRAM_bias_0 = Flipped(new NBufInterface(ModuleParams.getParams("x17304_out_SRAM_bias_0_p").asInstanceOf[NBufParams] ))
      val in_x18807_rd_x9466 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1, 8), List(32, 32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9845_out_SRAM_conv_1 = {io.in_x9845_out_SRAM_conv_1} ; io.in_x9845_out_SRAM_conv_1 := DontCare
    def x9465_reg = {io.in_x9465_reg} ; io.in_x9465_reg := DontCare
    def x9497_reg = {io.in_x9497_reg} ; io.in_x9497_reg := DontCare
    def b17302 = {io.in_b17302} 
    def b17303 = {io.in_b17303} 
    def x9554_bias_SRAM_0 = {io.in_x9554_bias_SRAM_0} ; io.in_x9554_bias_SRAM_0 := DontCare
    def x18806_rd_x3921 = {io.in_x18806_rd_x3921} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x9491_reg = {io.in_x9491_reg} ; io.in_x9491_reg := DontCare
    def b9553 = {io.in_b9553} 
    def x17304_out_SRAM_bias_0 = {io.in_x17304_out_SRAM_bias_0} ; io.in_x17304_out_SRAM_bias_0 := DontCare
    def x18807_rd_x9466 = {io.in_x18807_rd_x9466} 
  }
  def connectWires0(module: x17538_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x9845_out_SRAM_conv_1.connectLedger(module.io.in_x9845_out_SRAM_conv_1)
    x9465_reg.connectLedger(module.io.in_x9465_reg)
    x9497_reg.connectLedger(module.io.in_x9497_reg)
    module.io.in_b17302 <> b17302
    module.io.in_b17303 <> b17303
    x9554_bias_SRAM_0.connectLedger(module.io.in_x9554_bias_SRAM_0)
    module.io.in_x18806_rd_x3921 <> x18806_rd_x3921
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    x9491_reg.connectLedger(module.io.in_x9491_reg)
    module.io.in_b9553 <> b9553
    x17304_out_SRAM_bias_0.connectLedger(module.io.in_x17304_out_SRAM_bias_0)
    module.io.in_x18807_rd_x9466 <> x18807_rd_x9466
  }
  val b17303 = list_b17303(0)
  val x18806_rd_x3921 = list_b17303(1)
  val b9553 = list_b17303(2)
  val x18807_rd_x9466 = list_b17303(3)
  val b17302 = list_b17302(0)
  val x9465_reg = list_x9465_reg(0)
  val x9497_reg = list_x9465_reg(1)
  val x3920_reg = list_x9465_reg(2)
  val x9491_reg = list_x9465_reg(3)
  val x9845_out_SRAM_conv_1 = list_x9845_out_SRAM_conv_1(0)
  val x9554_bias_SRAM_0 = list_x9845_out_SRAM_conv_1(1)
  val x17304_out_SRAM_bias_0 = list_x9845_out_SRAM_conv_1(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17538_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x17538_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17538_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b17312 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b17312.suggestName("b17312")
      val b17313 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b17313.suggestName("b17313")
      val b17314 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b17314.suggestName("b17314")
      val b17315 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b17315.suggestName("b17315")
      val b17316 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b17316.suggestName("b17316")
      val b17317 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b17317.suggestName("b17317")
      val b17318 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b17318.suggestName("b17318")
      val b17319 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b17319.suggestName("b17319")
      val b17320 = io.sigsIn.cchainOutputs.head.counts(8).FP(true, 32, 0); b17320.suggestName("b17320")
      val b17321 = ~io.sigsIn.cchainOutputs.head.oobs(0); b17321.suggestName("b17321")
      val b17322 = ~io.sigsIn.cchainOutputs.head.oobs(1); b17322.suggestName("b17322")
      val b17323 = ~io.sigsIn.cchainOutputs.head.oobs(2); b17323.suggestName("b17323")
      val b17324 = ~io.sigsIn.cchainOutputs.head.oobs(3); b17324.suggestName("b17324")
      val b17325 = ~io.sigsIn.cchainOutputs.head.oobs(4); b17325.suggestName("b17325")
      val b17326 = ~io.sigsIn.cchainOutputs.head.oobs(5); b17326.suggestName("b17326")
      val b17327 = ~io.sigsIn.cchainOutputs.head.oobs(6); b17327.suggestName("b17327")
      val b17328 = ~io.sigsIn.cchainOutputs.head.oobs(7); b17328.suggestName("b17328")
      val b17329 = ~io.sigsIn.cchainOutputs.head.oobs(8); b17329.suggestName("b17329")
      object Block3Chunker0 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x17330_rd_x9465 = Wire(Bool()).suggestName("""x17330_rd_x9465""")
          val x17330_rd_x9465_banks = List[UInt]()
          val x17330_rd_x9465_ofs = List[UInt]()
          val x17330_rd_x9465_en = List[Bool](true.B)
          x17330_rd_x9465.toSeq.zip(x9465_reg.connectRPort(17330, x17330_rd_x9465_banks, x17330_rd_x9465_ofs, io.sigsIn.backpressure, x17330_rd_x9465_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x17338_rd_x3920 = Wire(Bool()).suggestName("""x17338_rd_x3920""")
          val x17338_rd_x3920_banks = List[UInt]()
          val x17338_rd_x3920_ofs = List[UInt]()
          val x17338_rd_x3920_en = List[Bool](true.B)
          x17338_rd_x3920.toSeq.zip(x3920_reg.connectRPort(17338, x17338_rd_x3920_banks, x17338_rd_x3920_ofs, io.sigsIn.backpressure, x17338_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x19343 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19343""")
          x19343.r := Math.and(b17302,31L.FP(true, 32, 0),Some(0.2), true.B,"x19343").r
          val x17356_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17356_mul""")
          x17356_mul.r := (Math.mul(b17312, 7L.FP(true, 32, 0), Some(6.0), true.B, Truncate, Wrapping, "x17356_mul")).r
          val x17357 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17357""")
          x17357.r := Math.arith_right_shift(b17313, 3, Some(0.2), true.B,"x17357").r
          val x17358 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17358""")
          x17358.r := Math.arith_right_shift(b17302, 5, Some(0.2), true.B,"x17358").r
          val x21735 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21735_x17357_D6") 
          x21735.r := getRetimed(x17357.r, 6.toInt, io.sigsIn.backpressure)
          val x17359_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17359_sum""")
          x17359_sum.r := Math.add(x17356_mul,x21735,Some(1.0), true.B, Truncate, Wrapping, "x17359_sum").r
          val x21736 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21736_x17358_D7") 
          x21736.r := getRetimed(x17358.r, 7.toInt, io.sigsIn.backpressure)
          val x17360_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17360_sum""")
          x17360_sum.r := Math.add(x17359_sum,x21736,Some(1.0), true.B, Truncate, Wrapping, "x17360_sum").r
          val x17366 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17366""")
          x17366.r := Math.arith_right_shift(b17314, 3, Some(0.2), true.B,"x17366").r
          val x21737 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21737_x17366_D6") 
          x21737.r := getRetimed(x17366.r, 6.toInt, io.sigsIn.backpressure)
          val x17367_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17367_sum""")
          x17367_sum.r := Math.add(x17356_mul,x21737,Some(1.0), true.B, Truncate, Wrapping, "x17367_sum").r
          val x17368_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17368_sum""")
          x17368_sum.r := Math.add(x17367_sum,x21736,Some(1.0), true.B, Truncate, Wrapping, "x17368_sum").r
          val x17373 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17373""")
          x17373.r := Math.arith_right_shift(b17315, 3, Some(0.2), true.B,"x17373").r
          val x21738 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21738_x17373_D6") 
          x21738.r := getRetimed(x17373.r, 6.toInt, io.sigsIn.backpressure)
          val x17374_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17374_sum""")
          x17374_sum.r := Math.add(x17356_mul,x21738,Some(1.0), true.B, Truncate, Wrapping, "x17374_sum").r
          val x17375_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17375_sum""")
          x17375_sum.r := Math.add(x17374_sum,x21736,Some(1.0), true.B, Truncate, Wrapping, "x17375_sum").r
          val x17380 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17380""")
          x17380.r := Math.arith_right_shift(b17316, 3, Some(0.2), true.B,"x17380").r
          val x21739 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21739_x17380_D6") 
          x21739.r := getRetimed(x17380.r, 6.toInt, io.sigsIn.backpressure)
          val x17381_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17381_sum""")
          x17381_sum.r := Math.add(x17356_mul,x21739,Some(1.0), true.B, Truncate, Wrapping, "x17381_sum").r
          val x17382_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17382_sum""")
          x17382_sum.r := Math.add(x17381_sum,x21736,Some(1.0), true.B, Truncate, Wrapping, "x17382_sum").r
          val x17387 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17387""")
          x17387.r := Math.arith_right_shift(b17317, 3, Some(0.2), true.B,"x17387").r
          val x21740 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21740_x17387_D6") 
          x21740.r := getRetimed(x17387.r, 6.toInt, io.sigsIn.backpressure)
          val x17388_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17388_sum""")
          x17388_sum.r := Math.add(x17356_mul,x21740,Some(1.0), true.B, Truncate, Wrapping, "x17388_sum").r
          val x17389_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17389_sum""")
          x17389_sum.r := Math.add(x17388_sum,x21736,Some(1.0), true.B, Truncate, Wrapping, "x17389_sum").r
          val x17394 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17394""")
          x17394.r := Math.arith_right_shift(b17318, 3, Some(0.2), true.B,"x17394").r
          val x21741 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21741_x17394_D6") 
          x21741.r := getRetimed(x17394.r, 6.toInt, io.sigsIn.backpressure)
          val x17395_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17395_sum""")
          x17395_sum.r := Math.add(x17356_mul,x21741,Some(1.0), true.B, Truncate, Wrapping, "x17395_sum").r
          val x17396_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17396_sum""")
          x17396_sum.r := Math.add(x17395_sum,x21736,Some(1.0), true.B, Truncate, Wrapping, "x17396_sum").r
          val x17401 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17401""")
          x17401.r := Math.arith_right_shift(b17319, 3, Some(0.2), true.B,"x17401").r
          val x21742 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21742_x17401_D6") 
          x21742.r := getRetimed(x17401.r, 6.toInt, io.sigsIn.backpressure)
          val x17402_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17402_sum""")
          x17402_sum.r := Math.add(x17356_mul,x21742,Some(1.0), true.B, Truncate, Wrapping, "x17402_sum").r
          val x17403_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17403_sum""")
          x17403_sum.r := Math.add(x17402_sum,x21736,Some(1.0), true.B, Truncate, Wrapping, "x17403_sum").r
          val x17408 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17408""")
          x17408.r := Math.arith_right_shift(b17320, 3, Some(0.2), true.B,"x17408").r
          val x21743 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21743_x17408_D6") 
          x21743.r := getRetimed(x17408.r, 6.toInt, io.sigsIn.backpressure)
          val x17409_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17409_sum""")
          x17409_sum.r := Math.add(x17356_mul,x21743,Some(1.0), true.B, Truncate, Wrapping, "x17409_sum").r
          val x17410_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17410_sum""")
          x17410_sum.r := Math.add(x17409_sum,x21736,Some(1.0), true.B, Truncate, Wrapping, "x17410_sum").r
          val x21744 = Wire(Bool()).suggestName("x21744_b17326_D8") 
          x21744.r := getRetimed(b17326.r, 8.toInt, io.sigsIn.backpressure)
          val x21745 = Wire(Bool()).suggestName("x21745_x17330_rd_x9465_D8") 
          x21745.r := getRetimed(x17330_rd_x9465.r, 8.toInt, io.sigsIn.backpressure)
          val x21746 = Wire(Bool()).suggestName("x21746_b17322_D8") 
          x21746.r := getRetimed(b17322.r, 8.toInt, io.sigsIn.backpressure)
          val x21747 = Wire(Bool()).suggestName("x21747_b17303_D8") 
          x21747.r := getRetimed(b17303.r, 8.toInt, io.sigsIn.backpressure)
          val x21748 = Wire(Bool()).suggestName("x21748_b17325_D8") 
          x21748.r := getRetimed(b17325.r, 8.toInt, io.sigsIn.backpressure)
          val x21749 = Wire(Bool()).suggestName("x21749_b17328_D8") 
          x21749.r := getRetimed(b17328.r, 8.toInt, io.sigsIn.backpressure)
          val x21750 = Wire(Bool()).suggestName("x21750_x17338_rd_x3920_D8") 
          x21750.r := getRetimed(x17338_rd_x3920.r, 8.toInt, io.sigsIn.backpressure)
          val x21751 = Wire(Bool()).suggestName("x21751_b17321_D8") 
          x21751.r := getRetimed(b17321.r, 8.toInt, io.sigsIn.backpressure)
          val x21752 = Wire(Bool()).suggestName("x21752_b9553_D8") 
          x21752.r := getRetimed(b9553.r, 8.toInt, io.sigsIn.backpressure)
          val x21753 = Wire(Bool()).suggestName("x21753_b17324_D8") 
          x21753.r := getRetimed(b17324.r, 8.toInt, io.sigsIn.backpressure)
          val x21754 = Wire(Bool()).suggestName("x21754_b17327_D8") 
          x21754.r := getRetimed(b17327.r, 8.toInt, io.sigsIn.backpressure)
          Map[String,Any]("x17330_rd_x9465" -> x17330_rd_x9465, "x17338_rd_x3920" -> x17338_rd_x3920, "x19343" -> x19343, "x17360_sum" -> x17360_sum, "x17368_sum" -> x17368_sum, "x17375_sum" -> x17375_sum, "x17382_sum" -> x17382_sum, "x17389_sum" -> x17389_sum, "x17396_sum" -> x17396_sum, "x17403_sum" -> x17403_sum, "x17410_sum" -> x17410_sum, "x21744" -> x21744, "x21745" -> x21745, "x21746" -> x21746, "x21747" -> x21747, "x21748" -> x21748, "x21749" -> x21749, "x21750" -> x21750, "x21751" -> x21751, "x21752" -> x21752, "x21753" -> x21753, "x21754" -> x21754)
        }
      }
      val block3chunk0: Map[String, Any] = Block3Chunker0.gen()
      object Block3Chunker1 { // 42 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x21755 = Wire(Bool()).suggestName("x21755_b17329_D8") 
          x21755.r := getRetimed(b17329.r, 8.toInt, io.sigsIn.backpressure)
          val x21756 = Wire(Bool()).suggestName("x21756_b17323_D8") 
          x21756.r := getRetimed(b17323.r, 8.toInt, io.sigsIn.backpressure)
          val x21757 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21757_x19343_D8") 
          x21757.r := getRetimed(block3chunk0("x19343").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
          val x17415_rd = Wire(Vec(8, new FixedPoint(true, 10, 22))).suggestName("""x17415_rd""")
          def create_x17415_rd_banks(): List[UInt] = {
            val x17415_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,x21757.r,0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,x21757.r,0L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,x21757.r,0L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,x21757.r)
            val x17415_rd_banks1 = List[UInt](0L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,x21757.r,0L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,x21757.r,0L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,x21757.r,0L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,x21757.r)
            x17415_rd_banks0 ++ x17415_rd_banks1
          }
          val x17415_rd_banks = create_x17415_rd_banks()
          def create_x17415_rd_ofs(): List[UInt] = {
            val x17415_rd_ofs0 = List[UInt](block3chunk0("x17360_sum").asInstanceOf[FixedPoint].r,block3chunk0("x17368_sum").asInstanceOf[FixedPoint].r,block3chunk0("x17375_sum").asInstanceOf[FixedPoint].r,block3chunk0("x17382_sum").asInstanceOf[FixedPoint].r)
            val x17415_rd_ofs1 = List[UInt](block3chunk0("x17389_sum").asInstanceOf[FixedPoint].r,block3chunk0("x17396_sum").asInstanceOf[FixedPoint].r,block3chunk0("x17403_sum").asInstanceOf[FixedPoint].r,block3chunk0("x17410_sum").asInstanceOf[FixedPoint].r)
            x17415_rd_ofs0 ++ x17415_rd_ofs1
          }
          val x17415_rd_ofs = create_x17415_rd_ofs()
          def create_x17415_rd_en(): List[Bool] = {
            val x17415_rd_en0 = List[Bool](block3chunk0("x21746").asInstanceOf[Bool],x21756,block3chunk0("x21753").asInstanceOf[Bool],block3chunk0("x21748").asInstanceOf[Bool],block3chunk0("x21744").asInstanceOf[Bool],block3chunk0("x21754").asInstanceOf[Bool],block3chunk0("x21749").asInstanceOf[Bool],x21755)
            x17415_rd_en0
          }
          val x17415_rd_en = create_x17415_rd_en()
          x17415_rd.toSeq.zip(x9845_out_SRAM_conv_1.connectRPort(17415, x17415_rd_banks, x17415_rd_ofs, io.sigsIn.backpressure, x17415_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.0.toInt, rr, io.sigsIn.backpressure) && block3chunk0("x21747").asInstanceOf[Bool] & block3chunk0("x21752").asInstanceOf[Bool] & block3chunk0("x21745").asInstanceOf[Bool] & block3chunk0("x21751").asInstanceOf[Bool] & block3chunk0("x21750").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
          val x17416_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17416_elem_0""")
          x17416_elem_0.r := x17415_rd(0).r
          val x17417_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17417_elem_1""")
          x17417_elem_1.r := x17415_rd(1).r
          val x17418_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17418_elem_2""")
          x17418_elem_2.r := x17415_rd(2).r
          val x17419_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17419_elem_3""")
          x17419_elem_3.r := x17415_rd(3).r
          val x17420_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17420_elem_4""")
          x17420_elem_4.r := x17415_rd(4).r
          val x17421_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17421_elem_5""")
          x17421_elem_5.r := x17415_rd(5).r
          val x17422_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17422_elem_6""")
          x17422_elem_6.r := x17415_rd(6).r
          val x17423_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17423_elem_7""")
          x17423_elem_7.r := x17415_rd(7).r
          val x17425_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x17425_rd""")
          val x17425_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x17425_rd_ofs = List[UInt](b17302.r)
          val x17425_rd_en = List[Bool](true.B)
          x17425_rd.toSeq.zip(x9554_bias_SRAM_0.connectRPort(17425, x17425_rd_banks, x17425_rd_ofs, io.sigsIn.backpressure, x17425_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && block3chunk0("x17338_rd_x3920").asInstanceOf[Bool] & b17321 & b9553 & block3chunk0("x17330_rd_x9465").asInstanceOf[Bool] & b17322 & b17303), false)).foreach{case (a,b) => a := b}
          val x17426_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17426_elem_0""")
          x17426_elem_0.r := x17425_rd(0).r
          val x17427_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x17427_rd""")
          val x17427_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x17427_rd_ofs = List[UInt](b17302.r)
          val x17427_rd_en = List[Bool](true.B)
          x17427_rd.toSeq.zip(x9554_bias_SRAM_0.connectRPort(17427, x17427_rd_banks, x17427_rd_ofs, io.sigsIn.backpressure, x17427_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && block3chunk0("x17338_rd_x3920").asInstanceOf[Bool] & b17321 & b9553 & block3chunk0("x17330_rd_x9465").asInstanceOf[Bool] & b17323 & b17303), false)).foreach{case (a,b) => a := b}
          val x17428_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17428_elem_0""")
          x17428_elem_0.r := x17427_rd(0).r
          val x17429_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x17429_rd""")
          val x17429_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x17429_rd_ofs = List[UInt](b17302.r)
          val x17429_rd_en = List[Bool](true.B)
          x17429_rd.toSeq.zip(x9554_bias_SRAM_0.connectRPort(17429, x17429_rd_banks, x17429_rd_ofs, io.sigsIn.backpressure, x17429_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && block3chunk0("x17338_rd_x3920").asInstanceOf[Bool] & b17321 & b9553 & block3chunk0("x17330_rd_x9465").asInstanceOf[Bool] & b17303 & b17324), false)).foreach{case (a,b) => a := b}
          val x17430_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17430_elem_0""")
          x17430_elem_0.r := x17429_rd(0).r
          val x17431_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x17431_rd""")
          val x17431_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x17431_rd_ofs = List[UInt](b17302.r)
          val x17431_rd_en = List[Bool](true.B)
          x17431_rd.toSeq.zip(x9554_bias_SRAM_0.connectRPort(17431, x17431_rd_banks, x17431_rd_ofs, io.sigsIn.backpressure, x17431_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && block3chunk0("x17338_rd_x3920").asInstanceOf[Bool] & b17321 & b17325 & b9553 & block3chunk0("x17330_rd_x9465").asInstanceOf[Bool] & b17303), false)).foreach{case (a,b) => a := b}
          val x17432_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17432_elem_0""")
          x17432_elem_0.r := x17431_rd(0).r
          val x17433_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x17433_rd""")
          val x17433_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x17433_rd_ofs = List[UInt](b17302.r)
          val x17433_rd_en = List[Bool](true.B)
          x17433_rd.toSeq.zip(x9554_bias_SRAM_0.connectRPort(17433, x17433_rd_banks, x17433_rd_ofs, io.sigsIn.backpressure, x17433_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && block3chunk0("x17338_rd_x3920").asInstanceOf[Bool] & b17321 & b9553 & block3chunk0("x17330_rd_x9465").asInstanceOf[Bool] & b17326 & b17303), false)).foreach{case (a,b) => a := b}
          val x17434_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17434_elem_0""")
          x17434_elem_0.r := x17433_rd(0).r
          val x17435_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x17435_rd""")
          val x17435_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x17435_rd_ofs = List[UInt](b17302.r)
          val x17435_rd_en = List[Bool](true.B)
          x17435_rd.toSeq.zip(x9554_bias_SRAM_0.connectRPort(17435, x17435_rd_banks, x17435_rd_ofs, io.sigsIn.backpressure, x17435_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && block3chunk0("x17338_rd_x3920").asInstanceOf[Bool] & b17321 & b9553 & block3chunk0("x17330_rd_x9465").asInstanceOf[Bool] & b17303 & b17327), false)).foreach{case (a,b) => a := b}
          val x17436_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17436_elem_0""")
          x17436_elem_0.r := x17435_rd(0).r
          val x17437_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x17437_rd""")
          val x17437_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x17437_rd_ofs = List[UInt](b17302.r)
          val x17437_rd_en = List[Bool](true.B)
          x17437_rd.toSeq.zip(x9554_bias_SRAM_0.connectRPort(17437, x17437_rd_banks, x17437_rd_ofs, io.sigsIn.backpressure, x17437_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && block3chunk0("x17338_rd_x3920").asInstanceOf[Bool] & b17321 & b9553 & block3chunk0("x17330_rd_x9465").asInstanceOf[Bool] & b17328 & b17303), false)).foreach{case (a,b) => a := b}
          val x17438_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17438_elem_0""")
          x17438_elem_0.r := x17437_rd(0).r
          val x17439_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x17439_rd""")
          val x17439_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
          val x17439_rd_ofs = List[UInt](b17302.r)
          val x17439_rd_en = List[Bool](true.B)
          x17439_rd.toSeq.zip(x9554_bias_SRAM_0.connectRPort(17439, x17439_rd_banks, x17439_rd_ofs, io.sigsIn.backpressure, x17439_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && block3chunk0("x17338_rd_x3920").asInstanceOf[Bool] & b17321 & b9553 & block3chunk0("x17330_rd_x9465").asInstanceOf[Bool] & b17303 & b17329), false)).foreach{case (a,b) => a := b}
          val x17440_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17440_elem_0""")
          x17440_elem_0.r := x17439_rd(0).r
          val x21758 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21758_x17426_elem_0_D8") 
          x21758.r := getRetimed(x17426_elem_0.r, 8.toInt, io.sigsIn.backpressure)
          val x17441_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17441_sum""")
          x17441_sum.r := Math.add(x17416_elem_0,x21758,Some(1.0), true.B, Truncate, Wrapping, "x17441_sum").r
          val x21759 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21759_x17428_elem_0_D8") 
          x21759.r := getRetimed(x17428_elem_0.r, 8.toInt, io.sigsIn.backpressure)
          val x17442_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17442_sum""")
          x17442_sum.r := Math.add(x17417_elem_1,x21759,Some(1.0), true.B, Truncate, Wrapping, "x17442_sum").r
          val x21760 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21760_x17430_elem_0_D8") 
          x21760.r := getRetimed(x17430_elem_0.r, 8.toInt, io.sigsIn.backpressure)
          val x17443_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17443_sum""")
          x17443_sum.r := Math.add(x17418_elem_2,x21760,Some(1.0), true.B, Truncate, Wrapping, "x17443_sum").r
          val x21761 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21761_x17432_elem_0_D8") 
          x21761.r := getRetimed(x17432_elem_0.r, 8.toInt, io.sigsIn.backpressure)
          val x17444_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17444_sum""")
          x17444_sum.r := Math.add(x17419_elem_3,x21761,Some(1.0), true.B, Truncate, Wrapping, "x17444_sum").r
          val x21762 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21762_x17434_elem_0_D8") 
          x21762.r := getRetimed(x17434_elem_0.r, 8.toInt, io.sigsIn.backpressure)
          val x17445_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17445_sum""")
          x17445_sum.r := Math.add(x17420_elem_4,x21762,Some(1.0), true.B, Truncate, Wrapping, "x17445_sum").r
          val x21763 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21763_x17436_elem_0_D8") 
          x21763.r := getRetimed(x17436_elem_0.r, 8.toInt, io.sigsIn.backpressure)
          val x17446_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17446_sum""")
          x17446_sum.r := Math.add(x17421_elem_5,x21763,Some(1.0), true.B, Truncate, Wrapping, "x17446_sum").r
          val x21764 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21764_x17438_elem_0_D8") 
          x21764.r := getRetimed(x17438_elem_0.r, 8.toInt, io.sigsIn.backpressure)
          val x17447_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17447_sum""")
          x17447_sum.r := Math.add(x17422_elem_6,x21764,Some(1.0), true.B, Truncate, Wrapping, "x17447_sum").r
          Map[String,Any]("x17423_elem_7" -> x17423_elem_7, "x17440_elem_0" -> x17440_elem_0, "x17441_sum" -> x17441_sum, "x17442_sum" -> x17442_sum, "x17443_sum" -> x17443_sum, "x17444_sum" -> x17444_sum, "x17445_sum" -> x17445_sum, "x17446_sum" -> x17446_sum, "x17447_sum" -> x17447_sum)
        }
      }
      val block3chunk1: Map[String, Any] = Block3Chunker1.gen()
      object Block3Chunker2 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x21765 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21765_x17440_elem_0_D8") 
          x21765.r := getRetimed(block3chunk1("x17440_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
          val x17448_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17448_sum""")
          x17448_sum.r := Math.add(block3chunk1("x17423_elem_7").asInstanceOf[FixedPoint],x21765,Some(1.0), true.B, Truncate, Wrapping, "x17448_sum").r
          val x17449_rd_x9491 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17449_rd_x9491""")
          val x17449_rd_x9491_banks = List[UInt]()
          val x17449_rd_x9491_ofs = List[UInt]()
          val x17449_rd_x9491_en = List[Bool](true.B)
          x17449_rd_x9491.toSeq.zip(x9491_reg.connectRPort(17449, x17449_rd_x9491_banks, x17449_rd_x9491_ofs, io.sigsIn.backpressure, x17449_rd_x9491_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x17457_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17457_mul""")
          x17457_mul.r := (Math.mul(b17312, x17449_rd_x9491, Some(6.0), true.B, Truncate, Wrapping, "x17457_mul")).r
          val x21766 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21766_b17313_D6") 
          x21766.r := getRetimed(b17313.r, 6.toInt, io.sigsIn.backpressure)
          val x17465_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17465_sum""")
          x17465_sum.r := Math.add(x17457_mul,x21766,Some(1.0), true.B, Truncate, Wrapping, "x17465_sum").r
          val x21767 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21767_b17314_D6") 
          x21767.r := getRetimed(b17314.r, 6.toInt, io.sigsIn.backpressure)
          val x17466_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17466_sum""")
          x17466_sum.r := Math.add(x17457_mul,x21767,Some(1.0), true.B, Truncate, Wrapping, "x17466_sum").r
          val x21768 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21768_b17315_D6") 
          x21768.r := getRetimed(b17315.r, 6.toInt, io.sigsIn.backpressure)
          val x17467_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17467_sum""")
          x17467_sum.r := Math.add(x17457_mul,x21768,Some(1.0), true.B, Truncate, Wrapping, "x17467_sum").r
          val x21769 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21769_b17316_D6") 
          x21769.r := getRetimed(b17316.r, 6.toInt, io.sigsIn.backpressure)
          val x17468_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17468_sum""")
          x17468_sum.r := Math.add(x17457_mul,x21769,Some(1.0), true.B, Truncate, Wrapping, "x17468_sum").r
          val x21770 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21770_b17317_D6") 
          x21770.r := getRetimed(b17317.r, 6.toInt, io.sigsIn.backpressure)
          val x17469_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17469_sum""")
          x17469_sum.r := Math.add(x17457_mul,x21770,Some(1.0), true.B, Truncate, Wrapping, "x17469_sum").r
          val x21771 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21771_b17318_D6") 
          x21771.r := getRetimed(b17318.r, 6.toInt, io.sigsIn.backpressure)
          val x17470_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17470_sum""")
          x17470_sum.r := Math.add(x17457_mul,x21771,Some(1.0), true.B, Truncate, Wrapping, "x17470_sum").r
          val x21772 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21772_b17319_D6") 
          x21772.r := getRetimed(b17319.r, 6.toInt, io.sigsIn.backpressure)
          val x17471_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17471_sum""")
          x17471_sum.r := Math.add(x17457_mul,x21772,Some(1.0), true.B, Truncate, Wrapping, "x17471_sum").r
          val x21773 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21773_b17320_D6") 
          x21773.r := getRetimed(b17320.r, 6.toInt, io.sigsIn.backpressure)
          val x17472_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17472_sum""")
          x17472_sum.r := Math.add(x17457_mul,x21773,Some(1.0), true.B, Truncate, Wrapping, "x17472_sum").r
          val x17473 = Wire(Bool()).suggestName("""x17473""")
          x17473.r := Math.lt(block3chunk1("x17441_sum").asInstanceOf[FixedPoint], 0.FP(true, 10, 22), Some(0.4), true.B,"x17473").r
          val x17474 = Wire(Bool()).suggestName("""x17474""")
          x17474.r := Math.lt(block3chunk1("x17442_sum").asInstanceOf[FixedPoint], 0.FP(true, 10, 22), Some(0.4), true.B,"x17474").r
          val x17475 = Wire(Bool()).suggestName("""x17475""")
          x17475.r := Math.lt(block3chunk1("x17443_sum").asInstanceOf[FixedPoint], 0.FP(true, 10, 22), Some(0.4), true.B,"x17475").r
          val x17476 = Wire(Bool()).suggestName("""x17476""")
          x17476.r := Math.lt(block3chunk1("x17444_sum").asInstanceOf[FixedPoint], 0.FP(true, 10, 22), Some(0.4), true.B,"x17476").r
          val x17477 = Wire(Bool()).suggestName("""x17477""")
          x17477.r := Math.lt(block3chunk1("x17445_sum").asInstanceOf[FixedPoint], 0.FP(true, 10, 22), Some(0.4), true.B,"x17477").r
          val x17478 = Wire(Bool()).suggestName("""x17478""")
          x17478.r := Math.lt(block3chunk1("x17446_sum").asInstanceOf[FixedPoint], 0.FP(true, 10, 22), Some(0.4), true.B,"x17478").r
          val x17479 = Wire(Bool()).suggestName("""x17479""")
          x17479.r := Math.lt(block3chunk1("x17447_sum").asInstanceOf[FixedPoint], 0.FP(true, 10, 22), Some(0.4), true.B,"x17479").r
          val x17480 = Wire(Bool()).suggestName("""x17480""")
          x17480.r := Math.lt(x17448_sum, 0.FP(true, 10, 22), Some(0.4), true.B,"x17480").r
          val x17481_rd_x9497 = Wire(Bool()).suggestName("""x17481_rd_x9497""")
          val x17481_rd_x9497_banks = List[UInt]()
          val x17481_rd_x9497_ofs = List[UInt]()
          val x17481_rd_x9497_en = List[Bool](true.B)
          x17481_rd_x9497.toSeq.zip(x9497_reg.connectRPort(17481, x17481_rd_x9497_banks, x17481_rd_x9497_ofs, io.sigsIn.backpressure, x17481_rd_x9497_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x21774 = Wire(Bool()).suggestName("x21774_x17481_rd_x9497_D11") 
          x21774.r := getRetimed(x17481_rd_x9497.r, 11.toInt, io.sigsIn.backpressure)
          val x17489 = Wire(Bool()).suggestName("""x17489""")
          x17489 := x21774 & x17473
          val x17490 = Wire(Bool()).suggestName("""x17490""")
          x17490 := x21774 & x17474
          val x17491 = Wire(Bool()).suggestName("""x17491""")
          x17491 := x21774 & x17475
          val x17492 = Wire(Bool()).suggestName("""x17492""")
          x17492 := x21774 & x17476
          val x17493 = Wire(Bool()).suggestName("""x17493""")
          x17493 := x21774 & x17477
          val x17494 = Wire(Bool()).suggestName("""x17494""")
          x17494 := x21774 & x17478
          val x17495 = Wire(Bool()).suggestName("""x17495""")
          x17495 := x21774 & x17479
          val x17496 = Wire(Bool()).suggestName("""x17496""")
          x17496 := x21774 & x17480
          val x17497 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17497""")
          x17497.r := Mux((x17489), 0.FP(true, 10, 22).r, block3chunk1("x17441_sum").asInstanceOf[FixedPoint].r)
          val x17498 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17498""")
          x17498.r := Mux((x17490), 0.FP(true, 10, 22).r, block3chunk1("x17442_sum").asInstanceOf[FixedPoint].r)
          val x17499 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17499""")
          x17499.r := Mux((x17491), 0.FP(true, 10, 22).r, block3chunk1("x17443_sum").asInstanceOf[FixedPoint].r)
          val x17500 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17500""")
          x17500.r := Mux((x17492), 0.FP(true, 10, 22).r, block3chunk1("x17444_sum").asInstanceOf[FixedPoint].r)
          val x17501 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17501""")
          x17501.r := Mux((x17493), 0.FP(true, 10, 22).r, block3chunk1("x17445_sum").asInstanceOf[FixedPoint].r)
          val x17502 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17502""")
          x17502.r := Mux((x17494), 0.FP(true, 10, 22).r, block3chunk1("x17446_sum").asInstanceOf[FixedPoint].r)
          val x17503 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17503""")
          x17503.r := Mux((x17495), 0.FP(true, 10, 22).r, block3chunk1("x17447_sum").asInstanceOf[FixedPoint].r)
          val x17504 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17504""")
          x17504.r := Mux((x17496), 0.FP(true, 10, 22).r, x17448_sum.r)
          val x19344 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19344""")
          x19344.r := Math.and(x17465_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19344").r
          val x19345 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19345""")
          x19345.r := Math.and(x17466_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19345").r
          val x19346 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19346""")
          x19346.r := Math.and(x17467_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19346").r
          Map[String,Any]("x17465_sum" -> x17465_sum, "x17466_sum" -> x17466_sum, "x17467_sum" -> x17467_sum, "x17468_sum" -> x17468_sum, "x17469_sum" -> x17469_sum, "x17470_sum" -> x17470_sum, "x17471_sum" -> x17471_sum, "x17472_sum" -> x17472_sum, "x17497" -> x17497, "x17498" -> x17498, "x17499" -> x17499, "x17500" -> x17500, "x17501" -> x17501, "x17502" -> x17502, "x17503" -> x17503, "x17504" -> x17504, "x19344" -> x19344, "x19345" -> x19345, "x19346" -> x19346)
        }
      }
      val block3chunk2: Map[String, Any] = Block3Chunker2.gen()
      object Block3Chunker3 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x19347 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19347""")
          x19347.r := Math.and(block3chunk2("x17468_sum").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x19347").r
          val x19348 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19348""")
          x19348.r := Math.and(block3chunk2("x17469_sum").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x19348").r
          val x19349 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19349""")
          x19349.r := Math.and(block3chunk2("x17470_sum").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x19349").r
          val x19350 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19350""")
          x19350.r := Math.and(block3chunk2("x17471_sum").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x19350").r
          val x19351 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19351""")
          x19351.r := Math.and(block3chunk2("x17472_sum").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x19351").r
          val x17513 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17513""")
          x17513.r := Math.arith_right_shift(block3chunk2("x17465_sum").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x17513").r
          val x17516 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17516""")
          x17516.r := Math.arith_right_shift(block3chunk2("x17466_sum").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x17516").r
          val x17519 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17519""")
          x17519.r := Math.arith_right_shift(block3chunk2("x17467_sum").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x17519").r
          val x17522 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17522""")
          x17522.r := Math.arith_right_shift(block3chunk2("x17468_sum").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x17522").r
          val x17525 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17525""")
          x17525.r := Math.arith_right_shift(block3chunk2("x17469_sum").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x17525").r
          val x17528 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17528""")
          x17528.r := Math.arith_right_shift(block3chunk2("x17470_sum").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x17528").r
          val x17531 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17531""")
          x17531.r := Math.arith_right_shift(block3chunk2("x17471_sum").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x17531").r
          val x17534 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17534""")
          x17534.r := Math.arith_right_shift(block3chunk2("x17472_sum").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x17534").r
          val x21775 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21775_x19347_D5") 
          x21775.r := getRetimed(x19347.r, 5.toInt, io.sigsIn.backpressure)
          val x21776 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21776_x19350_D5") 
          x21776.r := getRetimed(x19350.r, 5.toInt, io.sigsIn.backpressure)
          val x21777 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21777_x17502_D1") 
          x21777.r := getRetimed(block3chunk2("x17502").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21778 = Wire(Bool()).suggestName("x21778_b17326_D12") 
          x21778.r := getRetimed(b17326.r, 12.toInt, io.sigsIn.backpressure)
          val x21779 = Wire(Bool()).suggestName("x21779_x17330_rd_x9465_D12") 
          x21779.r := getRetimed(block3chunk0("x17330_rd_x9465").asInstanceOf[Bool].r, 12.toInt, io.sigsIn.backpressure)
          val x21780 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21780_x17534_D5") 
          x21780.r := getRetimed(x17534.r, 5.toInt, io.sigsIn.backpressure)
          val x21781 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21781_x17498_D1") 
          x21781.r := getRetimed(block3chunk2("x17498").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21782 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21782_x17513_D5") 
          x21782.r := getRetimed(x17513.r, 5.toInt, io.sigsIn.backpressure)
          val x21783 = Wire(Bool()).suggestName("x21783_b17322_D12") 
          x21783.r := getRetimed(b17322.r, 12.toInt, io.sigsIn.backpressure)
          val x21784 = Wire(Bool()).suggestName("x21784_b17303_D12") 
          x21784.r := getRetimed(b17303.r, 12.toInt, io.sigsIn.backpressure)
          val x21785 = Wire(Bool()).suggestName("x21785_b17325_D12") 
          x21785.r := getRetimed(b17325.r, 12.toInt, io.sigsIn.backpressure)
          val x21786 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21786_x19351_D5") 
          x21786.r := getRetimed(x19351.r, 5.toInt, io.sigsIn.backpressure)
          val x21787 = Wire(Bool()).suggestName("x21787_b17328_D12") 
          x21787.r := getRetimed(b17328.r, 12.toInt, io.sigsIn.backpressure)
          val x21788 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21788_x17503_D1") 
          x21788.r := getRetimed(block3chunk2("x17503").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21789 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21789_x17531_D5") 
          x21789.r := getRetimed(x17531.r, 5.toInt, io.sigsIn.backpressure)
          val x21790 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21790_x17499_D1") 
          x21790.r := getRetimed(block3chunk2("x17499").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21791 = Wire(Bool()).suggestName("x21791_x17338_rd_x3920_D12") 
          x21791.r := getRetimed(block3chunk0("x17338_rd_x3920").asInstanceOf[Bool].r, 12.toInt, io.sigsIn.backpressure)
          val x21792 = Wire(Bool()).suggestName("x21792_b17321_D12") 
          x21792.r := getRetimed(b17321.r, 12.toInt, io.sigsIn.backpressure)
          val x21793 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21793_x19345_D5") 
          x21793.r := getRetimed(block3chunk2("x19345").asInstanceOf[FixedPoint].r, 5.toInt, io.sigsIn.backpressure)
          val x21794 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21794_x17525_D5") 
          x21794.r := getRetimed(x17525.r, 5.toInt, io.sigsIn.backpressure)
          val x21795 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21795_x17522_D5") 
          x21795.r := getRetimed(x17522.r, 5.toInt, io.sigsIn.backpressure)
          val x21796 = Wire(Bool()).suggestName("x21796_b9553_D12") 
          x21796.r := getRetimed(b9553.r, 12.toInt, io.sigsIn.backpressure)
          val x21797 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21797_x17504_D1") 
          x21797.r := getRetimed(block3chunk2("x17504").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21798 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21798_x19344_D5") 
          x21798.r := getRetimed(block3chunk2("x19344").asInstanceOf[FixedPoint].r, 5.toInt, io.sigsIn.backpressure)
          val x21799 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21799_x17519_D5") 
          x21799.r := getRetimed(x17519.r, 5.toInt, io.sigsIn.backpressure)
          val x21800 = Wire(Bool()).suggestName("x21800_b17324_D12") 
          x21800.r := getRetimed(b17324.r, 12.toInt, io.sigsIn.backpressure)
          val x21801 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21801_x19349_D5") 
          x21801.r := getRetimed(x19349.r, 5.toInt, io.sigsIn.backpressure)
          val x21802 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21802_x17500_D1") 
          x21802.r := getRetimed(block3chunk2("x17500").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21803 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21803_x19348_D5") 
          x21803.r := getRetimed(x19348.r, 5.toInt, io.sigsIn.backpressure)
          val x21804 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21804_x17501_D1") 
          x21804.r := getRetimed(block3chunk2("x17501").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x21805 = Wire(Bool()).suggestName("x21805_b17327_D12") 
          x21805.r := getRetimed(b17327.r, 12.toInt, io.sigsIn.backpressure)
          val x21806 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21806_x19346_D5") 
          x21806.r := getRetimed(block3chunk2("x19346").asInstanceOf[FixedPoint].r, 5.toInt, io.sigsIn.backpressure)
          val x21807 = Wire(Bool()).suggestName("x21807_b17329_D12") 
          x21807.r := getRetimed(b17329.r, 12.toInt, io.sigsIn.backpressure)
          val x21808 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21808_x17528_D5") 
          x21808.r := getRetimed(x17528.r, 5.toInt, io.sigsIn.backpressure)
          val x21809 = Wire(Bool()).suggestName("x21809_b17323_D12") 
          x21809.r := getRetimed(b17323.r, 12.toInt, io.sigsIn.backpressure)
          val x21810 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21810_x17516_D5") 
          x21810.r := getRetimed(x17516.r, 5.toInt, io.sigsIn.backpressure)
          Map[String,Any]("x21775" -> x21775, "x21776" -> x21776, "x21777" -> x21777, "x21778" -> x21778, "x21779" -> x21779, "x21780" -> x21780, "x21781" -> x21781, "x21782" -> x21782, "x21783" -> x21783, "x21784" -> x21784, "x21785" -> x21785, "x21786" -> x21786, "x21787" -> x21787, "x21788" -> x21788, "x21789" -> x21789, "x21790" -> x21790, "x21791" -> x21791, "x21792" -> x21792, "x21793" -> x21793, "x21794" -> x21794, "x21795" -> x21795, "x21796" -> x21796, "x21797" -> x21797, "x21798" -> x21798, "x21799" -> x21799, "x21800" -> x21800, "x21801" -> x21801, "x21802" -> x21802, "x21803" -> x21803, "x21804" -> x21804, "x21805" -> x21805, "x21806" -> x21806, "x21807" -> x21807, "x21808" -> x21808, "x21809" -> x21809, "x21810" -> x21810)
        }
      }
      val block3chunk3: Map[String, Any] = Block3Chunker3.gen()
      object Block3Chunker4 { // 2 nodes, 9 weight
        def gen(): Map[String, Any] = {
          val x21811 = Wire(new FixedPoint(true, 10, 22)).suggestName("x21811_x17497_D1") 
          x21811.r := getRetimed(block3chunk2("x17497").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          def create_x17537_wr_banks(): List[UInt] = {
            val x17537_wr_banks0 = List[UInt](block3chunk3("x21798").asInstanceOf[FixedPoint].r,block3chunk3("x21793").asInstanceOf[FixedPoint].r,block3chunk3("x21806").asInstanceOf[FixedPoint].r,block3chunk3("x21775").asInstanceOf[FixedPoint].r)
            val x17537_wr_banks1 = List[UInt](block3chunk3("x21803").asInstanceOf[FixedPoint].r,block3chunk3("x21801").asInstanceOf[FixedPoint].r,block3chunk3("x21776").asInstanceOf[FixedPoint].r,block3chunk3("x21786").asInstanceOf[FixedPoint].r)
            x17537_wr_banks0 ++ x17537_wr_banks1
          }
          val x17537_wr_banks = create_x17537_wr_banks()
          def create_x17537_wr_ofs(): List[UInt] = {
            val x17537_wr_ofs0 = List[UInt](block3chunk3("x21782").asInstanceOf[FixedPoint].r,block3chunk3("x21810").asInstanceOf[FixedPoint].r,block3chunk3("x21799").asInstanceOf[FixedPoint].r,block3chunk3("x21795").asInstanceOf[FixedPoint].r)
            val x17537_wr_ofs1 = List[UInt](block3chunk3("x21794").asInstanceOf[FixedPoint].r,block3chunk3("x21808").asInstanceOf[FixedPoint].r,block3chunk3("x21789").asInstanceOf[FixedPoint].r,block3chunk3("x21780").asInstanceOf[FixedPoint].r)
            x17537_wr_ofs0 ++ x17537_wr_ofs1
          }
          val x17537_wr_ofs = create_x17537_wr_ofs()
          def create_x17537_wr_en(): List[Bool] = {
            val x17537_wr_en0 = List[Bool](block3chunk3("x21783").asInstanceOf[Bool],block3chunk3("x21809").asInstanceOf[Bool],block3chunk3("x21800").asInstanceOf[Bool],block3chunk3("x21785").asInstanceOf[Bool])
            val x17537_wr_en1 = List[Bool](block3chunk3("x21778").asInstanceOf[Bool],block3chunk3("x21805").asInstanceOf[Bool],block3chunk3("x21787").asInstanceOf[Bool],block3chunk3("x21807").asInstanceOf[Bool])
            x17537_wr_en0 ++ x17537_wr_en1
          }
          val x17537_wr_en = create_x17537_wr_en()
          def create_x17537_wr_data(): List[UInt] = {
            val x17537_wr_data0 = List[UInt](x21811.r,block3chunk3("x21781").asInstanceOf[FixedPoint].r,block3chunk3("x21790").asInstanceOf[FixedPoint].r,block3chunk3("x21802").asInstanceOf[FixedPoint].r)
            val x17537_wr_data1 = List[UInt](block3chunk3("x21804").asInstanceOf[FixedPoint].r,block3chunk3("x21777").asInstanceOf[FixedPoint].r,block3chunk3("x21788").asInstanceOf[FixedPoint].r,block3chunk3("x21797").asInstanceOf[FixedPoint].r)
            x17537_wr_data0 ++ x17537_wr_data1
          }
          val x17537_wr_data = create_x17537_wr_data()
          x17304_out_SRAM_bias_0.connectWPort(17537, x17537_wr_banks, x17537_wr_ofs, x17537_wr_data, x17537_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(12.1.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && block3chunk3("x21796").asInstanceOf[Bool] & block3chunk3("x21791").asInstanceOf[Bool] & block3chunk3("x21784").asInstanceOf[Bool] & block3chunk3("x21792").asInstanceOf[Bool] & block3chunk3("x21779").asInstanceOf[Bool]))
          Map[String,Any]()
        }
      }
      val block3chunk4: Map[String, Any] = Block3Chunker4.gen()
      x17304_out_SRAM_bias_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x17538_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x17538_inr_Foreach **/
