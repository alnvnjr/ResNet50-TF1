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

/** Hierarchy: x9343 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9343_inr_Foreach **/
class x9343_inr_Foreach_kernel(
  list_x18778_rd_x3919: List[Bool],
  list_b4067: List[FixedPoint],
  list_x3938_reg: List[StandardInterface],
  list_x4062_out_SRAM_conv_1: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 33.4.toInt, myName = "x9343_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9343_inr_Foreach_iiCtr"))
  
  abstract class x9343_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4062_out_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x4062_out_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_x4326_img2D_4 = Flipped(new NBufInterface(ModuleParams.getParams("x4326_img2D_4_p").asInstanceOf[NBufParams] ))
      val in_x18778_rd_x3919 = Input(Bool())
      val in_x4322_img2D_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4322_img2D_0_p").asInstanceOf[NBufParams] ))
      val in_x3938_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3938_reg_p").asInstanceOf[MemParams] ))
      val in_x4329_img2D_7 = Flipped(new NBufInterface(ModuleParams.getParams("x4329_img2D_7_p").asInstanceOf[NBufParams] ))
      val in_x4323_img2D_1 = Flipped(new NBufInterface(ModuleParams.getParams("x4323_img2D_1_p").asInstanceOf[NBufParams] ))
      val in_x4327_img2D_5 = Flipped(new NBufInterface(ModuleParams.getParams("x4327_img2D_5_p").asInstanceOf[NBufParams] ))
      val in_b4068 = Input(Bool())
      val in_x4328_img2D_6 = Flipped(new NBufInterface(ModuleParams.getParams("x4328_img2D_6_p").asInstanceOf[NBufParams] ))
      val in_b4060 = Input(Bool())
      val in_b4067 = Input(new FixedPoint(true, 32, 0))
      val in_x4324_img2D_2 = Flipped(new NBufInterface(ModuleParams.getParams("x4324_img2D_2_p").asInstanceOf[NBufParams] ))
      val in_x4241_weight_SRAM_reshape_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4241_weight_SRAM_reshape_0_p").asInstanceOf[NBufParams] ))
      val in_x3946_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3946_reg_p").asInstanceOf[MemParams] ))
      val in_x4325_img2D_3 = Flipped(new NBufInterface(ModuleParams.getParams("x4325_img2D_3_p").asInstanceOf[NBufParams] ))
      val in_x4061_out_SRAM_conv_0 = Flipped(new StandardInterface(ModuleParams.getParams("x4061_out_SRAM_conv_0_p").asInstanceOf[MemParams] ))
      val in_x4330_img2D_8 = Flipped(new NBufInterface(ModuleParams.getParams("x4330_img2D_8_p").asInstanceOf[NBufParams] ))
      val in_x3939_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3939_reg_p").asInstanceOf[MemParams] ))
      val in_x3918_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3918_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1, 1, 32), List(32, 32, 32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x4062_out_SRAM_conv_1 = {io.in_x4062_out_SRAM_conv_1} ; io.in_x4062_out_SRAM_conv_1 := DontCare
    def x4326_img2D_4 = {io.in_x4326_img2D_4} ; io.in_x4326_img2D_4 := DontCare
    def x18778_rd_x3919 = {io.in_x18778_rd_x3919} 
    def x4322_img2D_0 = {io.in_x4322_img2D_0} ; io.in_x4322_img2D_0 := DontCare
    def x3938_reg = {io.in_x3938_reg} ; io.in_x3938_reg := DontCare
    def x4329_img2D_7 = {io.in_x4329_img2D_7} ; io.in_x4329_img2D_7 := DontCare
    def x4323_img2D_1 = {io.in_x4323_img2D_1} ; io.in_x4323_img2D_1 := DontCare
    def x4327_img2D_5 = {io.in_x4327_img2D_5} ; io.in_x4327_img2D_5 := DontCare
    def b4068 = {io.in_b4068} 
    def x4328_img2D_6 = {io.in_x4328_img2D_6} ; io.in_x4328_img2D_6 := DontCare
    def b4060 = {io.in_b4060} 
    def b4067 = {io.in_b4067} 
    def x4324_img2D_2 = {io.in_x4324_img2D_2} ; io.in_x4324_img2D_2 := DontCare
    def x4241_weight_SRAM_reshape_0 = {io.in_x4241_weight_SRAM_reshape_0} ; io.in_x4241_weight_SRAM_reshape_0 := DontCare
    def x3946_reg = {io.in_x3946_reg} ; io.in_x3946_reg := DontCare
    def x4325_img2D_3 = {io.in_x4325_img2D_3} ; io.in_x4325_img2D_3 := DontCare
    def x4061_out_SRAM_conv_0 = {io.in_x4061_out_SRAM_conv_0} ; io.in_x4061_out_SRAM_conv_0 := DontCare
    def x4330_img2D_8 = {io.in_x4330_img2D_8} ; io.in_x4330_img2D_8 := DontCare
    def x3939_reg = {io.in_x3939_reg} ; io.in_x3939_reg := DontCare
    def x3918_reg = {io.in_x3918_reg} ; io.in_x3918_reg := DontCare
  }
  def connectWires0(module: x9343_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x4062_out_SRAM_conv_1.connectLedger(module.io.in_x4062_out_SRAM_conv_1)
    x4326_img2D_4.connectLedger(module.io.in_x4326_img2D_4)
    module.io.in_x18778_rd_x3919 <> x18778_rd_x3919
    x4322_img2D_0.connectLedger(module.io.in_x4322_img2D_0)
    x3938_reg.connectLedger(module.io.in_x3938_reg)
    x4329_img2D_7.connectLedger(module.io.in_x4329_img2D_7)
    x4323_img2D_1.connectLedger(module.io.in_x4323_img2D_1)
    x4327_img2D_5.connectLedger(module.io.in_x4327_img2D_5)
    module.io.in_b4068 <> b4068
    x4328_img2D_6.connectLedger(module.io.in_x4328_img2D_6)
    module.io.in_b4060 <> b4060
    module.io.in_b4067 <> b4067
    x4324_img2D_2.connectLedger(module.io.in_x4324_img2D_2)
    x4241_weight_SRAM_reshape_0.connectLedger(module.io.in_x4241_weight_SRAM_reshape_0)
    x3946_reg.connectLedger(module.io.in_x3946_reg)
    x4325_img2D_3.connectLedger(module.io.in_x4325_img2D_3)
    x4061_out_SRAM_conv_0.connectLedger(module.io.in_x4061_out_SRAM_conv_0)
    x4330_img2D_8.connectLedger(module.io.in_x4330_img2D_8)
    x3939_reg.connectLedger(module.io.in_x3939_reg)
    x3918_reg.connectLedger(module.io.in_x3918_reg)
  }
  val x18778_rd_x3919 = list_x18778_rd_x3919(0)
  val b4068 = list_x18778_rd_x3919(1)
  val b4060 = list_x18778_rd_x3919(2)
  val b4067 = list_b4067(0)
  val x3938_reg = list_x3938_reg(0)
  val x3946_reg = list_x3938_reg(1)
  val x4061_out_SRAM_conv_0 = list_x3938_reg(2)
  val x3939_reg = list_x3938_reg(3)
  val x3918_reg = list_x3938_reg(4)
  val x4062_out_SRAM_conv_1 = list_x4062_out_SRAM_conv_1(0)
  val x4326_img2D_4 = list_x4062_out_SRAM_conv_1(1)
  val x4322_img2D_0 = list_x4062_out_SRAM_conv_1(2)
  val x4329_img2D_7 = list_x4062_out_SRAM_conv_1(3)
  val x4323_img2D_1 = list_x4062_out_SRAM_conv_1(4)
  val x4327_img2D_5 = list_x4062_out_SRAM_conv_1(5)
  val x4328_img2D_6 = list_x4062_out_SRAM_conv_1(6)
  val x4324_img2D_2 = list_x4062_out_SRAM_conv_1(7)
  val x4241_weight_SRAM_reshape_0 = list_x4062_out_SRAM_conv_1(8)
  val x4325_img2D_3 = list_x4062_out_SRAM_conv_1(9)
  val x4330_img2D_8 = list_x4062_out_SRAM_conv_1(10)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9343_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x9343_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9343_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b4457 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b4457.suggestName("b4457")
      val b4458 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b4458.suggestName("b4458")
      val b4459 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b4459.suggestName("b4459")
      val b4460 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b4460.suggestName("b4460")
      val b4461 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b4461.suggestName("b4461")
      val b4462 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b4462.suggestName("b4462")
      val b4463 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b4463.suggestName("b4463")
      val b4464 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b4464.suggestName("b4464")
      val b4465 = io.sigsIn.cchainOutputs.head.counts(8).FP(true, 32, 0); b4465.suggestName("b4465")
      val b4466 = io.sigsIn.cchainOutputs.head.counts(9).FP(true, 32, 0); b4466.suggestName("b4466")
      val b4467 = io.sigsIn.cchainOutputs.head.counts(10).FP(true, 32, 0); b4467.suggestName("b4467")
      val b4468 = io.sigsIn.cchainOutputs.head.counts(11).FP(true, 32, 0); b4468.suggestName("b4468")
      val b4469 = io.sigsIn.cchainOutputs.head.counts(12).FP(true, 32, 0); b4469.suggestName("b4469")
      val b4470 = io.sigsIn.cchainOutputs.head.counts(13).FP(true, 32, 0); b4470.suggestName("b4470")
      val b4471 = io.sigsIn.cchainOutputs.head.counts(14).FP(true, 32, 0); b4471.suggestName("b4471")
      val b4472 = io.sigsIn.cchainOutputs.head.counts(15).FP(true, 32, 0); b4472.suggestName("b4472")
      val b4473 = io.sigsIn.cchainOutputs.head.counts(16).FP(true, 32, 0); b4473.suggestName("b4473")
      val b4474 = io.sigsIn.cchainOutputs.head.counts(17).FP(true, 32, 0); b4474.suggestName("b4474")
      val b4475 = io.sigsIn.cchainOutputs.head.counts(18).FP(true, 32, 0); b4475.suggestName("b4475")
      val b4476 = io.sigsIn.cchainOutputs.head.counts(19).FP(true, 32, 0); b4476.suggestName("b4476")
      val b4477 = io.sigsIn.cchainOutputs.head.counts(20).FP(true, 32, 0); b4477.suggestName("b4477")
      val b4478 = io.sigsIn.cchainOutputs.head.counts(21).FP(true, 32, 0); b4478.suggestName("b4478")
      val b4479 = io.sigsIn.cchainOutputs.head.counts(22).FP(true, 32, 0); b4479.suggestName("b4479")
      val b4480 = io.sigsIn.cchainOutputs.head.counts(23).FP(true, 32, 0); b4480.suggestName("b4480")
      val b4481 = io.sigsIn.cchainOutputs.head.counts(24).FP(true, 32, 0); b4481.suggestName("b4481")
      val b4482 = io.sigsIn.cchainOutputs.head.counts(25).FP(true, 32, 0); b4482.suggestName("b4482")
      val b4483 = io.sigsIn.cchainOutputs.head.counts(26).FP(true, 32, 0); b4483.suggestName("b4483")
      val b4484 = io.sigsIn.cchainOutputs.head.counts(27).FP(true, 32, 0); b4484.suggestName("b4484")
      val b4485 = io.sigsIn.cchainOutputs.head.counts(28).FP(true, 32, 0); b4485.suggestName("b4485")
      val b4486 = io.sigsIn.cchainOutputs.head.counts(29).FP(true, 32, 0); b4486.suggestName("b4486")
      val b4487 = io.sigsIn.cchainOutputs.head.counts(30).FP(true, 32, 0); b4487.suggestName("b4487")
      val b4488 = io.sigsIn.cchainOutputs.head.counts(31).FP(true, 32, 0); b4488.suggestName("b4488")
      val b4489 = io.sigsIn.cchainOutputs.head.counts(32).FP(true, 32, 0); b4489.suggestName("b4489")
      val b4490 = io.sigsIn.cchainOutputs.head.counts(33).FP(true, 32, 0); b4490.suggestName("b4490")
      val b4491 = ~io.sigsIn.cchainOutputs.head.oobs(0); b4491.suggestName("b4491")
      val b4492 = ~io.sigsIn.cchainOutputs.head.oobs(1); b4492.suggestName("b4492")
      val b4493 = ~io.sigsIn.cchainOutputs.head.oobs(2); b4493.suggestName("b4493")
      val b4494 = ~io.sigsIn.cchainOutputs.head.oobs(3); b4494.suggestName("b4494")
      val b4495 = ~io.sigsIn.cchainOutputs.head.oobs(4); b4495.suggestName("b4495")
      val b4496 = ~io.sigsIn.cchainOutputs.head.oobs(5); b4496.suggestName("b4496")
      val b4497 = ~io.sigsIn.cchainOutputs.head.oobs(6); b4497.suggestName("b4497")
      val b4498 = ~io.sigsIn.cchainOutputs.head.oobs(7); b4498.suggestName("b4498")
      val b4499 = ~io.sigsIn.cchainOutputs.head.oobs(8); b4499.suggestName("b4499")
      val b4500 = ~io.sigsIn.cchainOutputs.head.oobs(9); b4500.suggestName("b4500")
      val b4501 = ~io.sigsIn.cchainOutputs.head.oobs(10); b4501.suggestName("b4501")
      val b4502 = ~io.sigsIn.cchainOutputs.head.oobs(11); b4502.suggestName("b4502")
      val b4503 = ~io.sigsIn.cchainOutputs.head.oobs(12); b4503.suggestName("b4503")
      val b4504 = ~io.sigsIn.cchainOutputs.head.oobs(13); b4504.suggestName("b4504")
      val b4505 = ~io.sigsIn.cchainOutputs.head.oobs(14); b4505.suggestName("b4505")
      val b4506 = ~io.sigsIn.cchainOutputs.head.oobs(15); b4506.suggestName("b4506")
      val b4507 = ~io.sigsIn.cchainOutputs.head.oobs(16); b4507.suggestName("b4507")
      val b4508 = ~io.sigsIn.cchainOutputs.head.oobs(17); b4508.suggestName("b4508")
      val b4509 = ~io.sigsIn.cchainOutputs.head.oobs(18); b4509.suggestName("b4509")
      val b4510 = ~io.sigsIn.cchainOutputs.head.oobs(19); b4510.suggestName("b4510")
      val b4511 = ~io.sigsIn.cchainOutputs.head.oobs(20); b4511.suggestName("b4511")
      val b4512 = ~io.sigsIn.cchainOutputs.head.oobs(21); b4512.suggestName("b4512")
      val b4513 = ~io.sigsIn.cchainOutputs.head.oobs(22); b4513.suggestName("b4513")
      val b4514 = ~io.sigsIn.cchainOutputs.head.oobs(23); b4514.suggestName("b4514")
      val b4515 = ~io.sigsIn.cchainOutputs.head.oobs(24); b4515.suggestName("b4515")
      val b4516 = ~io.sigsIn.cchainOutputs.head.oobs(25); b4516.suggestName("b4516")
      val b4517 = ~io.sigsIn.cchainOutputs.head.oobs(26); b4517.suggestName("b4517")
      val b4518 = ~io.sigsIn.cchainOutputs.head.oobs(27); b4518.suggestName("b4518")
      val b4519 = ~io.sigsIn.cchainOutputs.head.oobs(28); b4519.suggestName("b4519")
      val b4520 = ~io.sigsIn.cchainOutputs.head.oobs(29); b4520.suggestName("b4520")
      val b4521 = ~io.sigsIn.cchainOutputs.head.oobs(30); b4521.suggestName("b4521")
      val b4522 = ~io.sigsIn.cchainOutputs.head.oobs(31); b4522.suggestName("b4522")
      val b4523 = ~io.sigsIn.cchainOutputs.head.oobs(32); b4523.suggestName("b4523")
      val b4524 = ~io.sigsIn.cchainOutputs.head.oobs(33); b4524.suggestName("b4524")
      object Block2Chunker0 { // 2220 nodes, 2499 weight
        def gen(): Map[String, Any] = {
          object Block2Chunker0Sub0 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x4525_rd_x3946 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4525_rd_x3946""")
              val x4525_rd_x3946_banks = List[UInt]()
              val x4525_rd_x3946_ofs = List[UInt]()
              val x4525_rd_x3946_en = List[Bool](true.B)
              x4525_rd_x3946.toSeq.zip(x3946_reg.connectRPort(4525, x4525_rd_x3946_banks, x4525_rd_x3946_ofs, io.sigsIn.backpressure, x4525_rd_x3946_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
              val x4557_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4557_mul""")
              x4557_mul.r := (Math.mul(b4457, x4525_rd_x3946, Some(6.0), true.B, Truncate, Wrapping, "x4557_mul")).r
              val x4589_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4589_sub""")
              x4589_sub.r := Math.sub(1L.FP(true, 32, 0),x4557_mul,Some(1.0), true.B, Truncate, Wrapping, "x4589_sub").r
              val x4621 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4621""")
              x4621.r := Mux((0L.FP(true, 32, 0) > x4589_sub), 0L.FP(true, 32, 0), x4589_sub).r
              val x4653 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4653""")
              x4653.r := Mux((2L.FP(true, 32, 0) < x4621), 2L.FP(true, 32, 0), x4621).r
              val x4685_rd_x3939 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4685_rd_x3939""")
              val x4685_rd_x3939_banks = List[UInt]()
              val x4685_rd_x3939_ofs = List[UInt]()
              val x4685_rd_x3939_en = List[Bool](true.B)
              x4685_rd_x3939.toSeq.zip(x3939_reg.connectRPort(4685, x4685_rd_x3939_banks, x4685_rd_x3939_ofs, io.sigsIn.backpressure, x4685_rd_x3939_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
              val x4717_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4717_sum""")
              x4717_sum.r := Math.add(x4685_rd_x3939,1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x4717_sum").r
              val x19692 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19692_x4717_sum_D5") 
              x19692.r := getRetimed(x4717_sum.r, 5.toInt, io.sigsIn.backpressure)
              val x4749_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4749_sub""")
              x4749_sub.r := Math.sub(x19692,x4557_mul,Some(1.0), true.B, Truncate, Wrapping, "x4749_sub").r
              val x4781 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4781""")
              x4781.r := Mux((1L.FP(true, 32, 0) > x4749_sub), 1L.FP(true, 32, 0), x4749_sub).r
              val x4813 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4813""")
              x4813.r := Mux((3L.FP(true, 32, 0) < x4781), 3L.FP(true, 32, 0), x4781).r
              val x4845_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4845_mul""")
              x4845_mul.r := (Math.mul(b4458, x4525_rd_x3946, Some(6.0), true.B, Truncate, Wrapping, "x4845_mul")).r
              val x4877_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4877_sub""")
              x4877_sub.r := Math.sub(1L.FP(true, 32, 0),x4845_mul,Some(1.0), true.B, Truncate, Wrapping, "x4877_sub").r
              val x4909 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4909""")
              x4909.r := Mux((0L.FP(true, 32, 0) > x4877_sub), 0L.FP(true, 32, 0), x4877_sub).r
              val x4941 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4941""")
              x4941.r := Mux((2L.FP(true, 32, 0) < x4909), 2L.FP(true, 32, 0), x4909).r
              val x4973_rd_x3938 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4973_rd_x3938""")
              val x4973_rd_x3938_banks = List[UInt]()
              val x4973_rd_x3938_ofs = List[UInt]()
              val x4973_rd_x3938_en = List[Bool](true.B)
              x4973_rd_x3938.toSeq.zip(x3938_reg.connectRPort(4973, x4973_rd_x3938_banks, x4973_rd_x3938_ofs, io.sigsIn.backpressure, x4973_rd_x3938_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
              val x5005_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5005_sum""")
              x5005_sum.r := Math.add(x4973_rd_x3938,1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x5005_sum").r
              val x19693 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19693_x5005_sum_D5") 
              x19693.r := getRetimed(x5005_sum.r, 5.toInt, io.sigsIn.backpressure)
              val x5037_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5037_sub""")
              x5037_sub.r := Math.sub(x19693,x4845_mul,Some(1.0), true.B, Truncate, Wrapping, "x5037_sub").r
              val x5069 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5069""")
              x5069.r := Mux((1L.FP(true, 32, 0) > x5037_sub), 1L.FP(true, 32, 0), x5037_sub).r
              val x5101 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5101""")
              x5101.r := Mux((3L.FP(true, 32, 0) < x5069), 3L.FP(true, 32, 0), x5069).r
              val x5133_rd_x3918 = Wire(Bool()).suggestName("""x5133_rd_x3918""")
              val x5133_rd_x3918_banks = List[UInt]()
              val x5133_rd_x3918_ofs = List[UInt]()
              val x5133_rd_x3918_en = List[Bool](true.B)
              x5133_rd_x3918.toSeq.zip(x3918_reg.connectRPort(5133, x5133_rd_x3918_banks, x5133_rd_x3918_ofs, io.sigsIn.backpressure, x5133_rd_x3918_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
              val x5197 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5197""")
              x5197.r := Math.arith_right_shift(b4459, 5, Some(0.2), true.B,"x5197").r
              val x5200 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5200""")
              x5200.r := Math.arith_right_shift(b4460, 5, Some(0.2), true.B,"x5200").r
              val x5203 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5203""")
              x5203.r := Math.arith_right_shift(b4461, 5, Some(0.2), true.B,"x5203").r
              val x5206 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5206""")
              x5206.r := Math.arith_right_shift(b4462, 5, Some(0.2), true.B,"x5206").r
              val x5209 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5209""")
              x5209.r := Math.arith_right_shift(b4463, 5, Some(0.2), true.B,"x5209").r
              val x5212 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5212""")
              x5212.r := Math.arith_right_shift(b4464, 5, Some(0.2), true.B,"x5212").r
              val x5215 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5215""")
              x5215.r := Math.arith_right_shift(b4465, 5, Some(0.2), true.B,"x5215").r
              val x5218 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5218""")
              x5218.r := Math.arith_right_shift(b4466, 5, Some(0.2), true.B,"x5218").r
              val x5221 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5221""")
              x5221.r := Math.arith_right_shift(b4467, 5, Some(0.2), true.B,"x5221").r
              val x5224 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5224""")
              x5224.r := Math.arith_right_shift(b4468, 5, Some(0.2), true.B,"x5224").r
              val x5227 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5227""")
              x5227.r := Math.arith_right_shift(b4469, 5, Some(0.2), true.B,"x5227").r
              val x5230 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5230""")
              x5230.r := Math.arith_right_shift(b4470, 5, Some(0.2), true.B,"x5230").r
              val x5233 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5233""")
              x5233.r := Math.arith_right_shift(b4471, 5, Some(0.2), true.B,"x5233").r
              val x5236 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5236""")
              x5236.r := Math.arith_right_shift(b4472, 5, Some(0.2), true.B,"x5236").r
              val x5239 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5239""")
              x5239.r := Math.arith_right_shift(b4473, 5, Some(0.2), true.B,"x5239").r
              val x5242 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5242""")
              x5242.r := Math.arith_right_shift(b4474, 5, Some(0.2), true.B,"x5242").r
              val x5245 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5245""")
              x5245.r := Math.arith_right_shift(b4475, 5, Some(0.2), true.B,"x5245").r
              val x5248 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5248""")
              x5248.r := Math.arith_right_shift(b4476, 5, Some(0.2), true.B,"x5248").r
              val x5251 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5251""")
              x5251.r := Math.arith_right_shift(b4477, 5, Some(0.2), true.B,"x5251").r
              val x5254 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5254""")
              x5254.r := Math.arith_right_shift(b4478, 5, Some(0.2), true.B,"x5254").r
              val x5257 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5257""")
              x5257.r := Math.arith_right_shift(b4479, 5, Some(0.2), true.B,"x5257").r
              val x5260 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5260""")
              x5260.r := Math.arith_right_shift(b4480, 5, Some(0.2), true.B,"x5260").r
              val x5263 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5263""")
              x5263.r := Math.arith_right_shift(b4481, 5, Some(0.2), true.B,"x5263").r
              val x5266 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5266""")
              x5266.r := Math.arith_right_shift(b4482, 5, Some(0.2), true.B,"x5266").r
              val x5269 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5269""")
              x5269.r := Math.arith_right_shift(b4483, 5, Some(0.2), true.B,"x5269").r
              val x5272 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5272""")
              x5272.r := Math.arith_right_shift(b4484, 5, Some(0.2), true.B,"x5272").r
              val x5275 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5275""")
              x5275.r := Math.arith_right_shift(b4485, 5, Some(0.2), true.B,"x5275").r
              Map[String,Any]("x4525_rd_x3946" -> x4525_rd_x3946, "x4653" -> x4653, "x4813" -> x4813, "x4941" -> x4941, "x4973_rd_x3938" -> x4973_rd_x3938, "x5101" -> x5101, "x5133_rd_x3918" -> x5133_rd_x3918, "x5197" -> x5197, "x5200" -> x5200, "x5203" -> x5203, "x5206" -> x5206, "x5209" -> x5209, "x5212" -> x5212, "x5215" -> x5215, "x5218" -> x5218, "x5221" -> x5221, "x5224" -> x5224, "x5227" -> x5227, "x5230" -> x5230, "x5233" -> x5233, "x5236" -> x5236, "x5239" -> x5239, "x5242" -> x5242, "x5245" -> x5245, "x5248" -> x5248, "x5251" -> x5251, "x5254" -> x5254, "x5257" -> x5257, "x5260" -> x5260, "x5263" -> x5263, "x5266" -> x5266, "x5269" -> x5269, "x5272" -> x5272, "x5275" -> x5275)
            }
          }
          val block2chunk0sub0: Map[String, Any] = Block2Chunker0Sub0.gen()
          object Block2Chunker0Sub1 { // 18 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x5278 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5278""")
              x5278.r := Math.arith_right_shift(b4486, 5, Some(0.2), true.B,"x5278").r
              val x5281 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5281""")
              x5281.r := Math.arith_right_shift(b4487, 5, Some(0.2), true.B,"x5281").r
              val x5284 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5284""")
              x5284.r := Math.arith_right_shift(b4488, 5, Some(0.2), true.B,"x5284").r
              val x5287 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5287""")
              x5287.r := Math.arith_right_shift(b4489, 5, Some(0.2), true.B,"x5287").r
              val x5290 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5290""")
              x5290.r := Math.arith_right_shift(b4490, 5, Some(0.2), true.B,"x5290").r
              val x5293_rd = Wire(Vec(32, new FixedPoint(true, 10, 22))).suggestName("""x5293_rd""")
              def create_x5293_rd_banks(): List[UInt] = {
                val x5293_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5293_rd_banks1 = List[UInt](0L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
                val x5293_rd_banks2 = List[UInt](7L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r)
                val x5293_rd_banks3 = List[UInt](0L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
                val x5293_rd_banks4 = List[UInt](14L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,16L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r)
                val x5293_rd_banks5 = List[UInt](0L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
                val x5293_rd_banks6 = List[UInt](21L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,24L.FP(true, 32, 0).r)
                val x5293_rd_banks7 = List[UInt](0L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
                val x5293_rd_banks8 = List[UInt](28L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                val x5293_rd_banks9 = List[UInt](0L.FP(true, 32, 0).r)
                x5293_rd_banks0 ++ x5293_rd_banks1 ++ x5293_rd_banks2 ++ x5293_rd_banks3 ++ x5293_rd_banks4 ++ x5293_rd_banks5 ++ x5293_rd_banks6 ++ x5293_rd_banks7 ++ x5293_rd_banks8 ++ x5293_rd_banks9
              }
              val x5293_rd_banks = create_x5293_rd_banks()
              def create_x5293_rd_ofs(): List[UInt] = {
                val x5293_rd_ofs0 = List[UInt](block2chunk0sub0("x5197").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5200").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5203").asInstanceOf[FixedPoint].r)
                val x5293_rd_ofs1 = List[UInt](block2chunk0sub0("x5206").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5209").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5212").asInstanceOf[FixedPoint].r)
                val x5293_rd_ofs2 = List[UInt](block2chunk0sub0("x5215").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5218").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5221").asInstanceOf[FixedPoint].r)
                val x5293_rd_ofs3 = List[UInt](block2chunk0sub0("x5224").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5227").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5230").asInstanceOf[FixedPoint].r)
                val x5293_rd_ofs4 = List[UInt](block2chunk0sub0("x5233").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5236").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5239").asInstanceOf[FixedPoint].r)
                val x5293_rd_ofs5 = List[UInt](block2chunk0sub0("x5242").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5245").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5248").asInstanceOf[FixedPoint].r)
                val x5293_rd_ofs6 = List[UInt](block2chunk0sub0("x5251").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5254").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5257").asInstanceOf[FixedPoint].r)
                val x5293_rd_ofs7 = List[UInt](block2chunk0sub0("x5260").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5263").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5266").asInstanceOf[FixedPoint].r)
                val x5293_rd_ofs8 = List[UInt](block2chunk0sub0("x5269").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5272").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5275").asInstanceOf[FixedPoint].r)
                val x5293_rd_ofs9 = List[UInt](x5278.r,x5281.r,x5284.r)
                val x5293_rd_ofs10 = List[UInt](x5287.r,x5290.r)
                x5293_rd_ofs0 ++ x5293_rd_ofs1 ++ x5293_rd_ofs2 ++ x5293_rd_ofs3 ++ x5293_rd_ofs4 ++ x5293_rd_ofs5 ++ x5293_rd_ofs6 ++ x5293_rd_ofs7 ++ x5293_rd_ofs8 ++ x5293_rd_ofs9 ++ x5293_rd_ofs10
              }
              val x5293_rd_ofs = create_x5293_rd_ofs()
              def create_x5293_rd_en(): List[Bool] = {
                val x5293_rd_en0 = List[Bool](b4493,b4494,b4495,b4496,b4497,b4498,b4499,b4500,b4501,b4502,b4503,b4504,b4505,b4506,b4507,b4508,b4509,b4510,b4511,b4512,b4513,b4514,b4515,b4516,b4517,b4518,b4519,b4520,b4521,b4522,b4523,b4524)
                x5293_rd_en0
              }
              val x5293_rd_en = create_x5293_rd_en()
              x5293_rd.toSeq.zip(x4241_weight_SRAM_reshape_0.connectRPort(5293, x5293_rd_banks, x5293_rd_ofs, io.sigsIn.backpressure, x5293_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool] & b4491 & b4068 & b4492 & b4060), true)).foreach{case (a,b) => a := b}
              val x5294_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5294_elem_0""")
              x5294_elem_0.r := x5293_rd(0).r
              val x5295_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5295_elem_1""")
              x5295_elem_1.r := x5293_rd(1).r
              val x5296_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5296_elem_2""")
              x5296_elem_2.r := x5293_rd(2).r
              val x5297_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5297_elem_3""")
              x5297_elem_3.r := x5293_rd(3).r
              val x5298_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5298_elem_4""")
              x5298_elem_4.r := x5293_rd(4).r
              val x5299_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5299_elem_5""")
              x5299_elem_5.r := x5293_rd(5).r
              val x5300_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5300_elem_6""")
              x5300_elem_6.r := x5293_rd(6).r
              val x5301_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5301_elem_7""")
              x5301_elem_7.r := x5293_rd(7).r
              val x5302_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5302_elem_8""")
              x5302_elem_8.r := x5293_rd(8).r
              val x5303_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5303_elem_9""")
              x5303_elem_9.r := x5293_rd(9).r
              val x5304_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5304_elem_10""")
              x5304_elem_10.r := x5293_rd(10).r
              val x5305_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5305_elem_11""")
              x5305_elem_11.r := x5293_rd(11).r
              Map[String,Any]("x5278" -> x5278, "x5281" -> x5281, "x5284" -> x5284, "x5287" -> x5287, "x5290" -> x5290, "x5293_rd" -> x5293_rd, "x5294_elem_0" -> x5294_elem_0, "x5295_elem_1" -> x5295_elem_1, "x5296_elem_2" -> x5296_elem_2, "x5297_elem_3" -> x5297_elem_3, "x5298_elem_4" -> x5298_elem_4, "x5299_elem_5" -> x5299_elem_5, "x5300_elem_6" -> x5300_elem_6, "x5301_elem_7" -> x5301_elem_7, "x5302_elem_8" -> x5302_elem_8, "x5303_elem_9" -> x5303_elem_9, "x5304_elem_10" -> x5304_elem_10, "x5305_elem_11" -> x5305_elem_11)
            }
          }
          val block2chunk0sub1: Map[String, Any] = Block2Chunker0Sub1.gen()
          object Block2Chunker0Sub2 { // 20 nodes, 20 weight
            def gen(): Map[String, Any] = {
              val x5306_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5306_elem_12""")
              x5306_elem_12.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](12).r
              val x5307_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5307_elem_13""")
              x5307_elem_13.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](13).r
              val x5308_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5308_elem_14""")
              x5308_elem_14.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](14).r
              val x5309_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5309_elem_15""")
              x5309_elem_15.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](15).r
              val x5310_elem_16 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5310_elem_16""")
              x5310_elem_16.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](16).r
              val x5311_elem_17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5311_elem_17""")
              x5311_elem_17.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](17).r
              val x5312_elem_18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5312_elem_18""")
              x5312_elem_18.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](18).r
              val x5313_elem_19 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5313_elem_19""")
              x5313_elem_19.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](19).r
              val x5314_elem_20 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5314_elem_20""")
              x5314_elem_20.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](20).r
              val x5315_elem_21 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5315_elem_21""")
              x5315_elem_21.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](21).r
              val x5316_elem_22 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5316_elem_22""")
              x5316_elem_22.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](22).r
              val x5317_elem_23 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5317_elem_23""")
              x5317_elem_23.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](23).r
              val x5318_elem_24 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5318_elem_24""")
              x5318_elem_24.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](24).r
              val x5319_elem_25 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5319_elem_25""")
              x5319_elem_25.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](25).r
              val x5320_elem_26 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5320_elem_26""")
              x5320_elem_26.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](26).r
              val x5321_elem_27 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5321_elem_27""")
              x5321_elem_27.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](27).r
              val x5322_elem_28 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5322_elem_28""")
              x5322_elem_28.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](28).r
              val x5323_elem_29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5323_elem_29""")
              x5323_elem_29.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](29).r
              val x5324_elem_30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5324_elem_30""")
              x5324_elem_30.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](30).r
              val x5325_elem_31 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5325_elem_31""")
              x5325_elem_31.r := block2chunk0sub1("x5293_rd").asInstanceOf[Vec[FixedPoint]](31).r
              Map[String,Any]("x5306_elem_12" -> x5306_elem_12, "x5307_elem_13" -> x5307_elem_13, "x5308_elem_14" -> x5308_elem_14, "x5309_elem_15" -> x5309_elem_15, "x5310_elem_16" -> x5310_elem_16, "x5311_elem_17" -> x5311_elem_17, "x5312_elem_18" -> x5312_elem_18, "x5313_elem_19" -> x5313_elem_19, "x5314_elem_20" -> x5314_elem_20, "x5315_elem_21" -> x5315_elem_21, "x5316_elem_22" -> x5316_elem_22, "x5317_elem_23" -> x5317_elem_23, "x5318_elem_24" -> x5318_elem_24, "x5319_elem_25" -> x5319_elem_25, "x5320_elem_26" -> x5320_elem_26, "x5321_elem_27" -> x5321_elem_27, "x5322_elem_28" -> x5322_elem_28, "x5323_elem_29" -> x5323_elem_29, "x5324_elem_30" -> x5324_elem_30, "x5325_elem_31" -> x5325_elem_31)
            }
          }
          val block2chunk0sub2: Map[String, Any] = Block2Chunker0Sub2.gen()
          object Block2Chunker0Sub3 { // 18 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x5326_rd = Wire(Vec(32, new FixedPoint(true, 10, 22))).suggestName("""x5326_rd""")
              def create_x5326_rd_banks(): List[UInt] = {
                val x5326_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5326_rd_banks1 = List[UInt](1L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r)
                val x5326_rd_banks2 = List[UInt](7L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r)
                val x5326_rd_banks3 = List[UInt](1L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r)
                val x5326_rd_banks4 = List[UInt](14L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,16L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r)
                val x5326_rd_banks5 = List[UInt](1L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r)
                val x5326_rd_banks6 = List[UInt](21L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,24L.FP(true, 32, 0).r)
                val x5326_rd_banks7 = List[UInt](1L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r)
                val x5326_rd_banks8 = List[UInt](28L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                val x5326_rd_banks9 = List[UInt](1L.FP(true, 32, 0).r)
                x5326_rd_banks0 ++ x5326_rd_banks1 ++ x5326_rd_banks2 ++ x5326_rd_banks3 ++ x5326_rd_banks4 ++ x5326_rd_banks5 ++ x5326_rd_banks6 ++ x5326_rd_banks7 ++ x5326_rd_banks8 ++ x5326_rd_banks9
              }
              val x5326_rd_banks = create_x5326_rd_banks()
              def create_x5326_rd_ofs(): List[UInt] = {
                val x5326_rd_ofs0 = List[UInt](block2chunk0sub0("x5197").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5200").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs1 = List[UInt](block2chunk0sub0("x5203").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5206").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs2 = List[UInt](block2chunk0sub0("x5209").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5212").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs3 = List[UInt](block2chunk0sub0("x5215").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5218").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs4 = List[UInt](block2chunk0sub0("x5221").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5224").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs5 = List[UInt](block2chunk0sub0("x5227").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5230").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs6 = List[UInt](block2chunk0sub0("x5233").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5236").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs7 = List[UInt](block2chunk0sub0("x5239").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5242").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs8 = List[UInt](block2chunk0sub0("x5245").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5248").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs9 = List[UInt](block2chunk0sub0("x5251").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5254").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs10 = List[UInt](block2chunk0sub0("x5257").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5260").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs11 = List[UInt](block2chunk0sub0("x5263").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5266").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs12 = List[UInt](block2chunk0sub0("x5269").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5272").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs13 = List[UInt](block2chunk0sub0("x5275").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5278").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs14 = List[UInt](block2chunk0sub1("x5281").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5284").asInstanceOf[FixedPoint].r)
                val x5326_rd_ofs15 = List[UInt](block2chunk0sub1("x5287").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5290").asInstanceOf[FixedPoint].r)
                x5326_rd_ofs0 ++ x5326_rd_ofs1 ++ x5326_rd_ofs2 ++ x5326_rd_ofs3 ++ x5326_rd_ofs4 ++ x5326_rd_ofs5 ++ x5326_rd_ofs6 ++ x5326_rd_ofs7 ++ x5326_rd_ofs8 ++ x5326_rd_ofs9 ++ x5326_rd_ofs10 ++ x5326_rd_ofs11 ++ x5326_rd_ofs12 ++ x5326_rd_ofs13 ++ x5326_rd_ofs14 ++ x5326_rd_ofs15
              }
              val x5326_rd_ofs = create_x5326_rd_ofs()
              def create_x5326_rd_en(): List[Bool] = {
                val x5326_rd_en0 = List[Bool](b4493,b4494,b4495,b4496,b4497,b4498,b4499,b4500,b4501,b4502,b4503,b4504,b4505,b4506,b4507,b4508,b4509,b4510,b4511,b4512,b4513,b4514,b4515,b4516,b4517,b4518,b4519,b4520,b4521,b4522,b4523,b4524)
                x5326_rd_en0
              }
              val x5326_rd_en = create_x5326_rd_en()
              x5326_rd.toSeq.zip(x4241_weight_SRAM_reshape_0.connectRPort(5326, x5326_rd_banks, x5326_rd_ofs, io.sigsIn.backpressure, x5326_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool] & b4491 & b4068 & b4492 & b4060), true)).foreach{case (a,b) => a := b}
              val x5327_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5327_elem_0""")
              x5327_elem_0.r := x5326_rd(0).r
              val x5328_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5328_elem_1""")
              x5328_elem_1.r := x5326_rd(1).r
              val x5329_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5329_elem_2""")
              x5329_elem_2.r := x5326_rd(2).r
              val x5330_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5330_elem_3""")
              x5330_elem_3.r := x5326_rd(3).r
              val x5331_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5331_elem_4""")
              x5331_elem_4.r := x5326_rd(4).r
              val x5332_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5332_elem_5""")
              x5332_elem_5.r := x5326_rd(5).r
              val x5333_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5333_elem_6""")
              x5333_elem_6.r := x5326_rd(6).r
              val x5334_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5334_elem_7""")
              x5334_elem_7.r := x5326_rd(7).r
              val x5335_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5335_elem_8""")
              x5335_elem_8.r := x5326_rd(8).r
              val x5336_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5336_elem_9""")
              x5336_elem_9.r := x5326_rd(9).r
              val x5337_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5337_elem_10""")
              x5337_elem_10.r := x5326_rd(10).r
              val x5338_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5338_elem_11""")
              x5338_elem_11.r := x5326_rd(11).r
              val x5339_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5339_elem_12""")
              x5339_elem_12.r := x5326_rd(12).r
              val x5340_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5340_elem_13""")
              x5340_elem_13.r := x5326_rd(13).r
              val x5341_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5341_elem_14""")
              x5341_elem_14.r := x5326_rd(14).r
              val x5342_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5342_elem_15""")
              x5342_elem_15.r := x5326_rd(15).r
              val x5343_elem_16 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5343_elem_16""")
              x5343_elem_16.r := x5326_rd(16).r
              Map[String,Any]("x5326_rd" -> x5326_rd, "x5327_elem_0" -> x5327_elem_0, "x5328_elem_1" -> x5328_elem_1, "x5329_elem_2" -> x5329_elem_2, "x5330_elem_3" -> x5330_elem_3, "x5331_elem_4" -> x5331_elem_4, "x5332_elem_5" -> x5332_elem_5, "x5333_elem_6" -> x5333_elem_6, "x5334_elem_7" -> x5334_elem_7, "x5335_elem_8" -> x5335_elem_8, "x5336_elem_9" -> x5336_elem_9, "x5337_elem_10" -> x5337_elem_10, "x5338_elem_11" -> x5338_elem_11, "x5339_elem_12" -> x5339_elem_12, "x5340_elem_13" -> x5340_elem_13, "x5341_elem_14" -> x5341_elem_14, "x5342_elem_15" -> x5342_elem_15, "x5343_elem_16" -> x5343_elem_16)
            }
          }
          val block2chunk0sub3: Map[String, Any] = Block2Chunker0Sub3.gen()
          object Block2Chunker0Sub4 { // 18 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x5344_elem_17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5344_elem_17""")
              x5344_elem_17.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](17).r
              val x5345_elem_18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5345_elem_18""")
              x5345_elem_18.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](18).r
              val x5346_elem_19 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5346_elem_19""")
              x5346_elem_19.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](19).r
              val x5347_elem_20 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5347_elem_20""")
              x5347_elem_20.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](20).r
              val x5348_elem_21 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5348_elem_21""")
              x5348_elem_21.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](21).r
              val x5349_elem_22 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5349_elem_22""")
              x5349_elem_22.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](22).r
              val x5350_elem_23 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5350_elem_23""")
              x5350_elem_23.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](23).r
              val x5351_elem_24 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5351_elem_24""")
              x5351_elem_24.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](24).r
              val x5352_elem_25 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5352_elem_25""")
              x5352_elem_25.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](25).r
              val x5353_elem_26 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5353_elem_26""")
              x5353_elem_26.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](26).r
              val x5354_elem_27 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5354_elem_27""")
              x5354_elem_27.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](27).r
              val x5355_elem_28 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5355_elem_28""")
              x5355_elem_28.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](28).r
              val x5356_elem_29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5356_elem_29""")
              x5356_elem_29.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](29).r
              val x5357_elem_30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5357_elem_30""")
              x5357_elem_30.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](30).r
              val x5358_elem_31 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5358_elem_31""")
              x5358_elem_31.r := block2chunk0sub3("x5326_rd").asInstanceOf[Vec[FixedPoint]](31).r
              val x5359_rd = Wire(Vec(32, new FixedPoint(true, 10, 22))).suggestName("""x5359_rd""")
              def create_x5359_rd_banks(): List[UInt] = {
                val x5359_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5359_rd_banks1 = List[UInt](2L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r)
                val x5359_rd_banks2 = List[UInt](7L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r)
                val x5359_rd_banks3 = List[UInt](2L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r)
                val x5359_rd_banks4 = List[UInt](14L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,16L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r)
                val x5359_rd_banks5 = List[UInt](2L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r)
                val x5359_rd_banks6 = List[UInt](21L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,24L.FP(true, 32, 0).r)
                val x5359_rd_banks7 = List[UInt](2L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r)
                val x5359_rd_banks8 = List[UInt](28L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                val x5359_rd_banks9 = List[UInt](2L.FP(true, 32, 0).r)
                x5359_rd_banks0 ++ x5359_rd_banks1 ++ x5359_rd_banks2 ++ x5359_rd_banks3 ++ x5359_rd_banks4 ++ x5359_rd_banks5 ++ x5359_rd_banks6 ++ x5359_rd_banks7 ++ x5359_rd_banks8 ++ x5359_rd_banks9
              }
              val x5359_rd_banks = create_x5359_rd_banks()
              def create_x5359_rd_ofs(): List[UInt] = {
                val x5359_rd_ofs0 = List[UInt](block2chunk0sub0("x5197").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5200").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs1 = List[UInt](block2chunk0sub0("x5203").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5206").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs2 = List[UInt](block2chunk0sub0("x5209").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5212").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs3 = List[UInt](block2chunk0sub0("x5215").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5218").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs4 = List[UInt](block2chunk0sub0("x5221").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5224").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs5 = List[UInt](block2chunk0sub0("x5227").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5230").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs6 = List[UInt](block2chunk0sub0("x5233").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5236").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs7 = List[UInt](block2chunk0sub0("x5239").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5242").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs8 = List[UInt](block2chunk0sub0("x5245").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5248").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs9 = List[UInt](block2chunk0sub0("x5251").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5254").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs10 = List[UInt](block2chunk0sub0("x5257").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5260").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs11 = List[UInt](block2chunk0sub0("x5263").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5266").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs12 = List[UInt](block2chunk0sub0("x5269").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5272").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs13 = List[UInt](block2chunk0sub0("x5275").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5278").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs14 = List[UInt](block2chunk0sub1("x5281").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5284").asInstanceOf[FixedPoint].r)
                val x5359_rd_ofs15 = List[UInt](block2chunk0sub1("x5287").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5290").asInstanceOf[FixedPoint].r)
                x5359_rd_ofs0 ++ x5359_rd_ofs1 ++ x5359_rd_ofs2 ++ x5359_rd_ofs3 ++ x5359_rd_ofs4 ++ x5359_rd_ofs5 ++ x5359_rd_ofs6 ++ x5359_rd_ofs7 ++ x5359_rd_ofs8 ++ x5359_rd_ofs9 ++ x5359_rd_ofs10 ++ x5359_rd_ofs11 ++ x5359_rd_ofs12 ++ x5359_rd_ofs13 ++ x5359_rd_ofs14 ++ x5359_rd_ofs15
              }
              val x5359_rd_ofs = create_x5359_rd_ofs()
              def create_x5359_rd_en(): List[Bool] = {
                val x5359_rd_en0 = List[Bool](b4493,b4494,b4495,b4496,b4497,b4498,b4499,b4500,b4501,b4502,b4503,b4504,b4505,b4506,b4507,b4508,b4509,b4510,b4511,b4512,b4513,b4514,b4515,b4516,b4517,b4518,b4519,b4520,b4521,b4522,b4523,b4524)
                x5359_rd_en0
              }
              val x5359_rd_en = create_x5359_rd_en()
              x5359_rd.toSeq.zip(x4241_weight_SRAM_reshape_0.connectRPort(5359, x5359_rd_banks, x5359_rd_ofs, io.sigsIn.backpressure, x5359_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool] & b4491 & b4068 & b4492 & b4060), true)).foreach{case (a,b) => a := b}
              val x5360_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5360_elem_0""")
              x5360_elem_0.r := x5359_rd(0).r
              val x5361_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5361_elem_1""")
              x5361_elem_1.r := x5359_rd(1).r
              Map[String,Any]("x5344_elem_17" -> x5344_elem_17, "x5345_elem_18" -> x5345_elem_18, "x5346_elem_19" -> x5346_elem_19, "x5347_elem_20" -> x5347_elem_20, "x5348_elem_21" -> x5348_elem_21, "x5349_elem_22" -> x5349_elem_22, "x5350_elem_23" -> x5350_elem_23, "x5351_elem_24" -> x5351_elem_24, "x5352_elem_25" -> x5352_elem_25, "x5353_elem_26" -> x5353_elem_26, "x5354_elem_27" -> x5354_elem_27, "x5355_elem_28" -> x5355_elem_28, "x5356_elem_29" -> x5356_elem_29, "x5357_elem_30" -> x5357_elem_30, "x5358_elem_31" -> x5358_elem_31, "x5359_rd" -> x5359_rd, "x5360_elem_0" -> x5360_elem_0, "x5361_elem_1" -> x5361_elem_1)
            }
          }
          val block2chunk0sub4: Map[String, Any] = Block2Chunker0Sub4.gen()
          object Block2Chunker0Sub5 { // 30 nodes, 30 weight
            def gen(): Map[String, Any] = {
              val x5362_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5362_elem_2""")
              x5362_elem_2.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](2).r
              val x5363_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5363_elem_3""")
              x5363_elem_3.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](3).r
              val x5364_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5364_elem_4""")
              x5364_elem_4.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](4).r
              val x5365_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5365_elem_5""")
              x5365_elem_5.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](5).r
              val x5366_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5366_elem_6""")
              x5366_elem_6.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](6).r
              val x5367_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5367_elem_7""")
              x5367_elem_7.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](7).r
              val x5368_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5368_elem_8""")
              x5368_elem_8.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](8).r
              val x5369_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5369_elem_9""")
              x5369_elem_9.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](9).r
              val x5370_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5370_elem_10""")
              x5370_elem_10.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](10).r
              val x5371_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5371_elem_11""")
              x5371_elem_11.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](11).r
              val x5372_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5372_elem_12""")
              x5372_elem_12.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](12).r
              val x5373_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5373_elem_13""")
              x5373_elem_13.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](13).r
              val x5374_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5374_elem_14""")
              x5374_elem_14.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](14).r
              val x5375_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5375_elem_15""")
              x5375_elem_15.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](15).r
              val x5376_elem_16 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5376_elem_16""")
              x5376_elem_16.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](16).r
              val x5377_elem_17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5377_elem_17""")
              x5377_elem_17.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](17).r
              val x5378_elem_18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5378_elem_18""")
              x5378_elem_18.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](18).r
              val x5379_elem_19 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5379_elem_19""")
              x5379_elem_19.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](19).r
              val x5380_elem_20 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5380_elem_20""")
              x5380_elem_20.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](20).r
              val x5381_elem_21 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5381_elem_21""")
              x5381_elem_21.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](21).r
              val x5382_elem_22 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5382_elem_22""")
              x5382_elem_22.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](22).r
              val x5383_elem_23 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5383_elem_23""")
              x5383_elem_23.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](23).r
              val x5384_elem_24 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5384_elem_24""")
              x5384_elem_24.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](24).r
              val x5385_elem_25 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5385_elem_25""")
              x5385_elem_25.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](25).r
              val x5386_elem_26 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5386_elem_26""")
              x5386_elem_26.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](26).r
              val x5387_elem_27 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5387_elem_27""")
              x5387_elem_27.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](27).r
              val x5388_elem_28 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5388_elem_28""")
              x5388_elem_28.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](28).r
              val x5389_elem_29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5389_elem_29""")
              x5389_elem_29.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](29).r
              val x5390_elem_30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5390_elem_30""")
              x5390_elem_30.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](30).r
              val x5391_elem_31 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5391_elem_31""")
              x5391_elem_31.r := block2chunk0sub4("x5359_rd").asInstanceOf[Vec[FixedPoint]](31).r
              Map[String,Any]("x5362_elem_2" -> x5362_elem_2, "x5363_elem_3" -> x5363_elem_3, "x5364_elem_4" -> x5364_elem_4, "x5365_elem_5" -> x5365_elem_5, "x5366_elem_6" -> x5366_elem_6, "x5367_elem_7" -> x5367_elem_7, "x5368_elem_8" -> x5368_elem_8, "x5369_elem_9" -> x5369_elem_9, "x5370_elem_10" -> x5370_elem_10, "x5371_elem_11" -> x5371_elem_11, "x5372_elem_12" -> x5372_elem_12, "x5373_elem_13" -> x5373_elem_13, "x5374_elem_14" -> x5374_elem_14, "x5375_elem_15" -> x5375_elem_15, "x5376_elem_16" -> x5376_elem_16, "x5377_elem_17" -> x5377_elem_17, "x5378_elem_18" -> x5378_elem_18, "x5379_elem_19" -> x5379_elem_19, "x5380_elem_20" -> x5380_elem_20, "x5381_elem_21" -> x5381_elem_21, "x5382_elem_22" -> x5382_elem_22, "x5383_elem_23" -> x5383_elem_23, "x5384_elem_24" -> x5384_elem_24, "x5385_elem_25" -> x5385_elem_25, "x5386_elem_26" -> x5386_elem_26, "x5387_elem_27" -> x5387_elem_27, "x5388_elem_28" -> x5388_elem_28, "x5389_elem_29" -> x5389_elem_29, "x5390_elem_30" -> x5390_elem_30, "x5391_elem_31" -> x5391_elem_31)
            }
          }
          val block2chunk0sub5: Map[String, Any] = Block2Chunker0Sub5.gen()
          object Block2Chunker0Sub6 { // 18 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x5392_rd = Wire(Vec(32, new FixedPoint(true, 10, 22))).suggestName("""x5392_rd""")
              def create_x5392_rd_banks(): List[UInt] = {
                val x5392_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5392_rd_banks1 = List[UInt](3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5392_rd_banks2 = List[UInt](7L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r)
                val x5392_rd_banks3 = List[UInt](3L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5392_rd_banks4 = List[UInt](14L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,16L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r)
                val x5392_rd_banks5 = List[UInt](3L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5392_rd_banks6 = List[UInt](21L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,24L.FP(true, 32, 0).r)
                val x5392_rd_banks7 = List[UInt](3L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5392_rd_banks8 = List[UInt](28L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                val x5392_rd_banks9 = List[UInt](3L.FP(true, 32, 0).r)
                x5392_rd_banks0 ++ x5392_rd_banks1 ++ x5392_rd_banks2 ++ x5392_rd_banks3 ++ x5392_rd_banks4 ++ x5392_rd_banks5 ++ x5392_rd_banks6 ++ x5392_rd_banks7 ++ x5392_rd_banks8 ++ x5392_rd_banks9
              }
              val x5392_rd_banks = create_x5392_rd_banks()
              def create_x5392_rd_ofs(): List[UInt] = {
                val x5392_rd_ofs0 = List[UInt](block2chunk0sub0("x5197").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5200").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs1 = List[UInt](block2chunk0sub0("x5203").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5206").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs2 = List[UInt](block2chunk0sub0("x5209").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5212").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs3 = List[UInt](block2chunk0sub0("x5215").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5218").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs4 = List[UInt](block2chunk0sub0("x5221").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5224").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs5 = List[UInt](block2chunk0sub0("x5227").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5230").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs6 = List[UInt](block2chunk0sub0("x5233").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5236").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs7 = List[UInt](block2chunk0sub0("x5239").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5242").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs8 = List[UInt](block2chunk0sub0("x5245").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5248").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs9 = List[UInt](block2chunk0sub0("x5251").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5254").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs10 = List[UInt](block2chunk0sub0("x5257").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5260").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs11 = List[UInt](block2chunk0sub0("x5263").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5266").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs12 = List[UInt](block2chunk0sub0("x5269").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5272").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs13 = List[UInt](block2chunk0sub0("x5275").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5278").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs14 = List[UInt](block2chunk0sub1("x5281").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5284").asInstanceOf[FixedPoint].r)
                val x5392_rd_ofs15 = List[UInt](block2chunk0sub1("x5287").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5290").asInstanceOf[FixedPoint].r)
                x5392_rd_ofs0 ++ x5392_rd_ofs1 ++ x5392_rd_ofs2 ++ x5392_rd_ofs3 ++ x5392_rd_ofs4 ++ x5392_rd_ofs5 ++ x5392_rd_ofs6 ++ x5392_rd_ofs7 ++ x5392_rd_ofs8 ++ x5392_rd_ofs9 ++ x5392_rd_ofs10 ++ x5392_rd_ofs11 ++ x5392_rd_ofs12 ++ x5392_rd_ofs13 ++ x5392_rd_ofs14 ++ x5392_rd_ofs15
              }
              val x5392_rd_ofs = create_x5392_rd_ofs()
              def create_x5392_rd_en(): List[Bool] = {
                val x5392_rd_en0 = List[Bool](b4493,b4494,b4495,b4496,b4497,b4498,b4499,b4500,b4501,b4502,b4503,b4504,b4505,b4506,b4507,b4508,b4509,b4510,b4511,b4512,b4513,b4514,b4515,b4516,b4517,b4518,b4519,b4520,b4521,b4522,b4523,b4524)
                x5392_rd_en0
              }
              val x5392_rd_en = create_x5392_rd_en()
              x5392_rd.toSeq.zip(x4241_weight_SRAM_reshape_0.connectRPort(5392, x5392_rd_banks, x5392_rd_ofs, io.sigsIn.backpressure, x5392_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool] & b4491 & b4068 & b4492 & b4060), true)).foreach{case (a,b) => a := b}
              val x5393_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5393_elem_0""")
              x5393_elem_0.r := x5392_rd(0).r
              val x5394_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5394_elem_1""")
              x5394_elem_1.r := x5392_rd(1).r
              val x5395_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5395_elem_2""")
              x5395_elem_2.r := x5392_rd(2).r
              val x5396_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5396_elem_3""")
              x5396_elem_3.r := x5392_rd(3).r
              val x5397_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5397_elem_4""")
              x5397_elem_4.r := x5392_rd(4).r
              val x5398_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5398_elem_5""")
              x5398_elem_5.r := x5392_rd(5).r
              val x5399_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5399_elem_6""")
              x5399_elem_6.r := x5392_rd(6).r
              val x5400_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5400_elem_7""")
              x5400_elem_7.r := x5392_rd(7).r
              val x5401_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5401_elem_8""")
              x5401_elem_8.r := x5392_rd(8).r
              val x5402_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5402_elem_9""")
              x5402_elem_9.r := x5392_rd(9).r
              val x5403_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5403_elem_10""")
              x5403_elem_10.r := x5392_rd(10).r
              val x5404_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5404_elem_11""")
              x5404_elem_11.r := x5392_rd(11).r
              val x5405_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5405_elem_12""")
              x5405_elem_12.r := x5392_rd(12).r
              val x5406_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5406_elem_13""")
              x5406_elem_13.r := x5392_rd(13).r
              val x5407_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5407_elem_14""")
              x5407_elem_14.r := x5392_rd(14).r
              val x5408_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5408_elem_15""")
              x5408_elem_15.r := x5392_rd(15).r
              val x5409_elem_16 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5409_elem_16""")
              x5409_elem_16.r := x5392_rd(16).r
              Map[String,Any]("x5392_rd" -> x5392_rd, "x5393_elem_0" -> x5393_elem_0, "x5394_elem_1" -> x5394_elem_1, "x5395_elem_2" -> x5395_elem_2, "x5396_elem_3" -> x5396_elem_3, "x5397_elem_4" -> x5397_elem_4, "x5398_elem_5" -> x5398_elem_5, "x5399_elem_6" -> x5399_elem_6, "x5400_elem_7" -> x5400_elem_7, "x5401_elem_8" -> x5401_elem_8, "x5402_elem_9" -> x5402_elem_9, "x5403_elem_10" -> x5403_elem_10, "x5404_elem_11" -> x5404_elem_11, "x5405_elem_12" -> x5405_elem_12, "x5406_elem_13" -> x5406_elem_13, "x5407_elem_14" -> x5407_elem_14, "x5408_elem_15" -> x5408_elem_15, "x5409_elem_16" -> x5409_elem_16)
            }
          }
          val block2chunk0sub6: Map[String, Any] = Block2Chunker0Sub6.gen()
          object Block2Chunker0Sub7 { // 18 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x5410_elem_17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5410_elem_17""")
              x5410_elem_17.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](17).r
              val x5411_elem_18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5411_elem_18""")
              x5411_elem_18.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](18).r
              val x5412_elem_19 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5412_elem_19""")
              x5412_elem_19.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](19).r
              val x5413_elem_20 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5413_elem_20""")
              x5413_elem_20.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](20).r
              val x5414_elem_21 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5414_elem_21""")
              x5414_elem_21.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](21).r
              val x5415_elem_22 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5415_elem_22""")
              x5415_elem_22.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](22).r
              val x5416_elem_23 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5416_elem_23""")
              x5416_elem_23.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](23).r
              val x5417_elem_24 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5417_elem_24""")
              x5417_elem_24.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](24).r
              val x5418_elem_25 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5418_elem_25""")
              x5418_elem_25.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](25).r
              val x5419_elem_26 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5419_elem_26""")
              x5419_elem_26.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](26).r
              val x5420_elem_27 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5420_elem_27""")
              x5420_elem_27.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](27).r
              val x5421_elem_28 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5421_elem_28""")
              x5421_elem_28.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](28).r
              val x5422_elem_29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5422_elem_29""")
              x5422_elem_29.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](29).r
              val x5423_elem_30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5423_elem_30""")
              x5423_elem_30.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](30).r
              val x5424_elem_31 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5424_elem_31""")
              x5424_elem_31.r := block2chunk0sub6("x5392_rd").asInstanceOf[Vec[FixedPoint]](31).r
              val x5425_rd = Wire(Vec(32, new FixedPoint(true, 10, 22))).suggestName("""x5425_rd""")
              def create_x5425_rd_banks(): List[UInt] = {
                val x5425_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5425_rd_banks1 = List[UInt](4L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r)
                val x5425_rd_banks2 = List[UInt](7L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r)
                val x5425_rd_banks3 = List[UInt](4L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r)
                val x5425_rd_banks4 = List[UInt](14L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,16L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r)
                val x5425_rd_banks5 = List[UInt](4L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r)
                val x5425_rd_banks6 = List[UInt](21L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,24L.FP(true, 32, 0).r)
                val x5425_rd_banks7 = List[UInt](4L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r)
                val x5425_rd_banks8 = List[UInt](28L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                val x5425_rd_banks9 = List[UInt](4L.FP(true, 32, 0).r)
                x5425_rd_banks0 ++ x5425_rd_banks1 ++ x5425_rd_banks2 ++ x5425_rd_banks3 ++ x5425_rd_banks4 ++ x5425_rd_banks5 ++ x5425_rd_banks6 ++ x5425_rd_banks7 ++ x5425_rd_banks8 ++ x5425_rd_banks9
              }
              val x5425_rd_banks = create_x5425_rd_banks()
              def create_x5425_rd_ofs(): List[UInt] = {
                val x5425_rd_ofs0 = List[UInt](block2chunk0sub0("x5197").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5200").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs1 = List[UInt](block2chunk0sub0("x5203").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5206").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs2 = List[UInt](block2chunk0sub0("x5209").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5212").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs3 = List[UInt](block2chunk0sub0("x5215").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5218").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs4 = List[UInt](block2chunk0sub0("x5221").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5224").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs5 = List[UInt](block2chunk0sub0("x5227").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5230").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs6 = List[UInt](block2chunk0sub0("x5233").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5236").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs7 = List[UInt](block2chunk0sub0("x5239").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5242").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs8 = List[UInt](block2chunk0sub0("x5245").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5248").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs9 = List[UInt](block2chunk0sub0("x5251").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5254").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs10 = List[UInt](block2chunk0sub0("x5257").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5260").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs11 = List[UInt](block2chunk0sub0("x5263").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5266").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs12 = List[UInt](block2chunk0sub0("x5269").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5272").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs13 = List[UInt](block2chunk0sub0("x5275").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5278").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs14 = List[UInt](block2chunk0sub1("x5281").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5284").asInstanceOf[FixedPoint].r)
                val x5425_rd_ofs15 = List[UInt](block2chunk0sub1("x5287").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5290").asInstanceOf[FixedPoint].r)
                x5425_rd_ofs0 ++ x5425_rd_ofs1 ++ x5425_rd_ofs2 ++ x5425_rd_ofs3 ++ x5425_rd_ofs4 ++ x5425_rd_ofs5 ++ x5425_rd_ofs6 ++ x5425_rd_ofs7 ++ x5425_rd_ofs8 ++ x5425_rd_ofs9 ++ x5425_rd_ofs10 ++ x5425_rd_ofs11 ++ x5425_rd_ofs12 ++ x5425_rd_ofs13 ++ x5425_rd_ofs14 ++ x5425_rd_ofs15
              }
              val x5425_rd_ofs = create_x5425_rd_ofs()
              def create_x5425_rd_en(): List[Bool] = {
                val x5425_rd_en0 = List[Bool](b4493,b4494,b4495,b4496,b4497,b4498,b4499,b4500,b4501,b4502,b4503,b4504,b4505,b4506,b4507,b4508,b4509,b4510,b4511,b4512,b4513,b4514,b4515,b4516,b4517,b4518,b4519,b4520,b4521,b4522,b4523,b4524)
                x5425_rd_en0
              }
              val x5425_rd_en = create_x5425_rd_en()
              x5425_rd.toSeq.zip(x4241_weight_SRAM_reshape_0.connectRPort(5425, x5425_rd_banks, x5425_rd_ofs, io.sigsIn.backpressure, x5425_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool] & b4491 & b4068 & b4492 & b4060), true)).foreach{case (a,b) => a := b}
              val x5426_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5426_elem_0""")
              x5426_elem_0.r := x5425_rd(0).r
              val x5427_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5427_elem_1""")
              x5427_elem_1.r := x5425_rd(1).r
              Map[String,Any]("x5410_elem_17" -> x5410_elem_17, "x5411_elem_18" -> x5411_elem_18, "x5412_elem_19" -> x5412_elem_19, "x5413_elem_20" -> x5413_elem_20, "x5414_elem_21" -> x5414_elem_21, "x5415_elem_22" -> x5415_elem_22, "x5416_elem_23" -> x5416_elem_23, "x5417_elem_24" -> x5417_elem_24, "x5418_elem_25" -> x5418_elem_25, "x5419_elem_26" -> x5419_elem_26, "x5420_elem_27" -> x5420_elem_27, "x5421_elem_28" -> x5421_elem_28, "x5422_elem_29" -> x5422_elem_29, "x5423_elem_30" -> x5423_elem_30, "x5424_elem_31" -> x5424_elem_31, "x5425_rd" -> x5425_rd, "x5426_elem_0" -> x5426_elem_0, "x5427_elem_1" -> x5427_elem_1)
            }
          }
          val block2chunk0sub7: Map[String, Any] = Block2Chunker0Sub7.gen()
          object Block2Chunker0Sub8 { // 30 nodes, 30 weight
            def gen(): Map[String, Any] = {
              val x5428_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5428_elem_2""")
              x5428_elem_2.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](2).r
              val x5429_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5429_elem_3""")
              x5429_elem_3.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](3).r
              val x5430_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5430_elem_4""")
              x5430_elem_4.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](4).r
              val x5431_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5431_elem_5""")
              x5431_elem_5.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](5).r
              val x5432_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5432_elem_6""")
              x5432_elem_6.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](6).r
              val x5433_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5433_elem_7""")
              x5433_elem_7.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](7).r
              val x5434_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5434_elem_8""")
              x5434_elem_8.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](8).r
              val x5435_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5435_elem_9""")
              x5435_elem_9.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](9).r
              val x5436_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5436_elem_10""")
              x5436_elem_10.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](10).r
              val x5437_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5437_elem_11""")
              x5437_elem_11.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](11).r
              val x5438_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5438_elem_12""")
              x5438_elem_12.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](12).r
              val x5439_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5439_elem_13""")
              x5439_elem_13.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](13).r
              val x5440_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5440_elem_14""")
              x5440_elem_14.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](14).r
              val x5441_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5441_elem_15""")
              x5441_elem_15.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](15).r
              val x5442_elem_16 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5442_elem_16""")
              x5442_elem_16.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](16).r
              val x5443_elem_17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5443_elem_17""")
              x5443_elem_17.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](17).r
              val x5444_elem_18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5444_elem_18""")
              x5444_elem_18.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](18).r
              val x5445_elem_19 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5445_elem_19""")
              x5445_elem_19.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](19).r
              val x5446_elem_20 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5446_elem_20""")
              x5446_elem_20.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](20).r
              val x5447_elem_21 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5447_elem_21""")
              x5447_elem_21.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](21).r
              val x5448_elem_22 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5448_elem_22""")
              x5448_elem_22.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](22).r
              val x5449_elem_23 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5449_elem_23""")
              x5449_elem_23.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](23).r
              val x5450_elem_24 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5450_elem_24""")
              x5450_elem_24.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](24).r
              val x5451_elem_25 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5451_elem_25""")
              x5451_elem_25.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](25).r
              val x5452_elem_26 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5452_elem_26""")
              x5452_elem_26.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](26).r
              val x5453_elem_27 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5453_elem_27""")
              x5453_elem_27.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](27).r
              val x5454_elem_28 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5454_elem_28""")
              x5454_elem_28.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](28).r
              val x5455_elem_29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5455_elem_29""")
              x5455_elem_29.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](29).r
              val x5456_elem_30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5456_elem_30""")
              x5456_elem_30.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](30).r
              val x5457_elem_31 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5457_elem_31""")
              x5457_elem_31.r := block2chunk0sub7("x5425_rd").asInstanceOf[Vec[FixedPoint]](31).r
              Map[String,Any]("x5428_elem_2" -> x5428_elem_2, "x5429_elem_3" -> x5429_elem_3, "x5430_elem_4" -> x5430_elem_4, "x5431_elem_5" -> x5431_elem_5, "x5432_elem_6" -> x5432_elem_6, "x5433_elem_7" -> x5433_elem_7, "x5434_elem_8" -> x5434_elem_8, "x5435_elem_9" -> x5435_elem_9, "x5436_elem_10" -> x5436_elem_10, "x5437_elem_11" -> x5437_elem_11, "x5438_elem_12" -> x5438_elem_12, "x5439_elem_13" -> x5439_elem_13, "x5440_elem_14" -> x5440_elem_14, "x5441_elem_15" -> x5441_elem_15, "x5442_elem_16" -> x5442_elem_16, "x5443_elem_17" -> x5443_elem_17, "x5444_elem_18" -> x5444_elem_18, "x5445_elem_19" -> x5445_elem_19, "x5446_elem_20" -> x5446_elem_20, "x5447_elem_21" -> x5447_elem_21, "x5448_elem_22" -> x5448_elem_22, "x5449_elem_23" -> x5449_elem_23, "x5450_elem_24" -> x5450_elem_24, "x5451_elem_25" -> x5451_elem_25, "x5452_elem_26" -> x5452_elem_26, "x5453_elem_27" -> x5453_elem_27, "x5454_elem_28" -> x5454_elem_28, "x5455_elem_29" -> x5455_elem_29, "x5456_elem_30" -> x5456_elem_30, "x5457_elem_31" -> x5457_elem_31)
            }
          }
          val block2chunk0sub8: Map[String, Any] = Block2Chunker0Sub8.gen()
          object Block2Chunker0Sub9 { // 18 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x5458_rd = Wire(Vec(32, new FixedPoint(true, 10, 22))).suggestName("""x5458_rd""")
              def create_x5458_rd_banks(): List[UInt] = {
                val x5458_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5458_rd_banks1 = List[UInt](5L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r)
                val x5458_rd_banks2 = List[UInt](7L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r)
                val x5458_rd_banks3 = List[UInt](5L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r)
                val x5458_rd_banks4 = List[UInt](14L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,16L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r)
                val x5458_rd_banks5 = List[UInt](5L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r)
                val x5458_rd_banks6 = List[UInt](21L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,24L.FP(true, 32, 0).r)
                val x5458_rd_banks7 = List[UInt](5L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r)
                val x5458_rd_banks8 = List[UInt](28L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                val x5458_rd_banks9 = List[UInt](5L.FP(true, 32, 0).r)
                x5458_rd_banks0 ++ x5458_rd_banks1 ++ x5458_rd_banks2 ++ x5458_rd_banks3 ++ x5458_rd_banks4 ++ x5458_rd_banks5 ++ x5458_rd_banks6 ++ x5458_rd_banks7 ++ x5458_rd_banks8 ++ x5458_rd_banks9
              }
              val x5458_rd_banks = create_x5458_rd_banks()
              def create_x5458_rd_ofs(): List[UInt] = {
                val x5458_rd_ofs0 = List[UInt](block2chunk0sub0("x5197").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5200").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs1 = List[UInt](block2chunk0sub0("x5203").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5206").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs2 = List[UInt](block2chunk0sub0("x5209").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5212").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs3 = List[UInt](block2chunk0sub0("x5215").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5218").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs4 = List[UInt](block2chunk0sub0("x5221").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5224").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs5 = List[UInt](block2chunk0sub0("x5227").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5230").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs6 = List[UInt](block2chunk0sub0("x5233").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5236").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs7 = List[UInt](block2chunk0sub0("x5239").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5242").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs8 = List[UInt](block2chunk0sub0("x5245").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5248").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs9 = List[UInt](block2chunk0sub0("x5251").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5254").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs10 = List[UInt](block2chunk0sub0("x5257").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5260").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs11 = List[UInt](block2chunk0sub0("x5263").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5266").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs12 = List[UInt](block2chunk0sub0("x5269").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5272").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs13 = List[UInt](block2chunk0sub0("x5275").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5278").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs14 = List[UInt](block2chunk0sub1("x5281").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5284").asInstanceOf[FixedPoint].r)
                val x5458_rd_ofs15 = List[UInt](block2chunk0sub1("x5287").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5290").asInstanceOf[FixedPoint].r)
                x5458_rd_ofs0 ++ x5458_rd_ofs1 ++ x5458_rd_ofs2 ++ x5458_rd_ofs3 ++ x5458_rd_ofs4 ++ x5458_rd_ofs5 ++ x5458_rd_ofs6 ++ x5458_rd_ofs7 ++ x5458_rd_ofs8 ++ x5458_rd_ofs9 ++ x5458_rd_ofs10 ++ x5458_rd_ofs11 ++ x5458_rd_ofs12 ++ x5458_rd_ofs13 ++ x5458_rd_ofs14 ++ x5458_rd_ofs15
              }
              val x5458_rd_ofs = create_x5458_rd_ofs()
              def create_x5458_rd_en(): List[Bool] = {
                val x5458_rd_en0 = List[Bool](b4493,b4494,b4495,b4496,b4497,b4498,b4499,b4500,b4501,b4502,b4503,b4504,b4505,b4506,b4507,b4508,b4509,b4510,b4511,b4512,b4513,b4514,b4515,b4516,b4517,b4518,b4519,b4520,b4521,b4522,b4523,b4524)
                x5458_rd_en0
              }
              val x5458_rd_en = create_x5458_rd_en()
              x5458_rd.toSeq.zip(x4241_weight_SRAM_reshape_0.connectRPort(5458, x5458_rd_banks, x5458_rd_ofs, io.sigsIn.backpressure, x5458_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool] & b4491 & b4068 & b4492 & b4060), true)).foreach{case (a,b) => a := b}
              val x5459_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5459_elem_0""")
              x5459_elem_0.r := x5458_rd(0).r
              val x5460_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5460_elem_1""")
              x5460_elem_1.r := x5458_rd(1).r
              val x5461_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5461_elem_2""")
              x5461_elem_2.r := x5458_rd(2).r
              val x5462_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5462_elem_3""")
              x5462_elem_3.r := x5458_rd(3).r
              val x5463_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5463_elem_4""")
              x5463_elem_4.r := x5458_rd(4).r
              val x5464_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5464_elem_5""")
              x5464_elem_5.r := x5458_rd(5).r
              val x5465_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5465_elem_6""")
              x5465_elem_6.r := x5458_rd(6).r
              val x5466_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5466_elem_7""")
              x5466_elem_7.r := x5458_rd(7).r
              val x5467_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5467_elem_8""")
              x5467_elem_8.r := x5458_rd(8).r
              val x5468_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5468_elem_9""")
              x5468_elem_9.r := x5458_rd(9).r
              val x5469_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5469_elem_10""")
              x5469_elem_10.r := x5458_rd(10).r
              val x5470_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5470_elem_11""")
              x5470_elem_11.r := x5458_rd(11).r
              val x5471_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5471_elem_12""")
              x5471_elem_12.r := x5458_rd(12).r
              val x5472_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5472_elem_13""")
              x5472_elem_13.r := x5458_rd(13).r
              val x5473_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5473_elem_14""")
              x5473_elem_14.r := x5458_rd(14).r
              val x5474_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5474_elem_15""")
              x5474_elem_15.r := x5458_rd(15).r
              val x5475_elem_16 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5475_elem_16""")
              x5475_elem_16.r := x5458_rd(16).r
              Map[String,Any]("x5458_rd" -> x5458_rd, "x5459_elem_0" -> x5459_elem_0, "x5460_elem_1" -> x5460_elem_1, "x5461_elem_2" -> x5461_elem_2, "x5462_elem_3" -> x5462_elem_3, "x5463_elem_4" -> x5463_elem_4, "x5464_elem_5" -> x5464_elem_5, "x5465_elem_6" -> x5465_elem_6, "x5466_elem_7" -> x5466_elem_7, "x5467_elem_8" -> x5467_elem_8, "x5468_elem_9" -> x5468_elem_9, "x5469_elem_10" -> x5469_elem_10, "x5470_elem_11" -> x5470_elem_11, "x5471_elem_12" -> x5471_elem_12, "x5472_elem_13" -> x5472_elem_13, "x5473_elem_14" -> x5473_elem_14, "x5474_elem_15" -> x5474_elem_15, "x5475_elem_16" -> x5475_elem_16)
            }
          }
          val block2chunk0sub9: Map[String, Any] = Block2Chunker0Sub9.gen()
          object Block2Chunker0Sub10 { // 18 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x5476_elem_17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5476_elem_17""")
              x5476_elem_17.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](17).r
              val x5477_elem_18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5477_elem_18""")
              x5477_elem_18.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](18).r
              val x5478_elem_19 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5478_elem_19""")
              x5478_elem_19.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](19).r
              val x5479_elem_20 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5479_elem_20""")
              x5479_elem_20.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](20).r
              val x5480_elem_21 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5480_elem_21""")
              x5480_elem_21.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](21).r
              val x5481_elem_22 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5481_elem_22""")
              x5481_elem_22.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](22).r
              val x5482_elem_23 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5482_elem_23""")
              x5482_elem_23.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](23).r
              val x5483_elem_24 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5483_elem_24""")
              x5483_elem_24.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](24).r
              val x5484_elem_25 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5484_elem_25""")
              x5484_elem_25.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](25).r
              val x5485_elem_26 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5485_elem_26""")
              x5485_elem_26.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](26).r
              val x5486_elem_27 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5486_elem_27""")
              x5486_elem_27.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](27).r
              val x5487_elem_28 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5487_elem_28""")
              x5487_elem_28.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](28).r
              val x5488_elem_29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5488_elem_29""")
              x5488_elem_29.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](29).r
              val x5489_elem_30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5489_elem_30""")
              x5489_elem_30.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](30).r
              val x5490_elem_31 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5490_elem_31""")
              x5490_elem_31.r := block2chunk0sub9("x5458_rd").asInstanceOf[Vec[FixedPoint]](31).r
              val x5491_rd = Wire(Vec(32, new FixedPoint(true, 10, 22))).suggestName("""x5491_rd""")
              def create_x5491_rd_banks(): List[UInt] = {
                val x5491_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5491_rd_banks1 = List[UInt](6L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r)
                val x5491_rd_banks2 = List[UInt](7L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r)
                val x5491_rd_banks3 = List[UInt](6L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r)
                val x5491_rd_banks4 = List[UInt](14L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,16L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r)
                val x5491_rd_banks5 = List[UInt](6L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r)
                val x5491_rd_banks6 = List[UInt](21L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,24L.FP(true, 32, 0).r)
                val x5491_rd_banks7 = List[UInt](6L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r)
                val x5491_rd_banks8 = List[UInt](28L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                val x5491_rd_banks9 = List[UInt](6L.FP(true, 32, 0).r)
                x5491_rd_banks0 ++ x5491_rd_banks1 ++ x5491_rd_banks2 ++ x5491_rd_banks3 ++ x5491_rd_banks4 ++ x5491_rd_banks5 ++ x5491_rd_banks6 ++ x5491_rd_banks7 ++ x5491_rd_banks8 ++ x5491_rd_banks9
              }
              val x5491_rd_banks = create_x5491_rd_banks()
              def create_x5491_rd_ofs(): List[UInt] = {
                val x5491_rd_ofs0 = List[UInt](block2chunk0sub0("x5197").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5200").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs1 = List[UInt](block2chunk0sub0("x5203").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5206").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs2 = List[UInt](block2chunk0sub0("x5209").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5212").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs3 = List[UInt](block2chunk0sub0("x5215").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5218").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs4 = List[UInt](block2chunk0sub0("x5221").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5224").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs5 = List[UInt](block2chunk0sub0("x5227").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5230").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs6 = List[UInt](block2chunk0sub0("x5233").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5236").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs7 = List[UInt](block2chunk0sub0("x5239").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5242").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs8 = List[UInt](block2chunk0sub0("x5245").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5248").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs9 = List[UInt](block2chunk0sub0("x5251").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5254").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs10 = List[UInt](block2chunk0sub0("x5257").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5260").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs11 = List[UInt](block2chunk0sub0("x5263").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5266").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs12 = List[UInt](block2chunk0sub0("x5269").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5272").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs13 = List[UInt](block2chunk0sub0("x5275").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5278").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs14 = List[UInt](block2chunk0sub1("x5281").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5284").asInstanceOf[FixedPoint].r)
                val x5491_rd_ofs15 = List[UInt](block2chunk0sub1("x5287").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5290").asInstanceOf[FixedPoint].r)
                x5491_rd_ofs0 ++ x5491_rd_ofs1 ++ x5491_rd_ofs2 ++ x5491_rd_ofs3 ++ x5491_rd_ofs4 ++ x5491_rd_ofs5 ++ x5491_rd_ofs6 ++ x5491_rd_ofs7 ++ x5491_rd_ofs8 ++ x5491_rd_ofs9 ++ x5491_rd_ofs10 ++ x5491_rd_ofs11 ++ x5491_rd_ofs12 ++ x5491_rd_ofs13 ++ x5491_rd_ofs14 ++ x5491_rd_ofs15
              }
              val x5491_rd_ofs = create_x5491_rd_ofs()
              def create_x5491_rd_en(): List[Bool] = {
                val x5491_rd_en0 = List[Bool](b4493,b4494,b4495,b4496,b4497,b4498,b4499,b4500,b4501,b4502,b4503,b4504,b4505,b4506,b4507,b4508,b4509,b4510,b4511,b4512,b4513,b4514,b4515,b4516,b4517,b4518,b4519,b4520,b4521,b4522,b4523,b4524)
                x5491_rd_en0
              }
              val x5491_rd_en = create_x5491_rd_en()
              x5491_rd.toSeq.zip(x4241_weight_SRAM_reshape_0.connectRPort(5491, x5491_rd_banks, x5491_rd_ofs, io.sigsIn.backpressure, x5491_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool] & b4491 & b4068 & b4492 & b4060), true)).foreach{case (a,b) => a := b}
              val x5492_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5492_elem_0""")
              x5492_elem_0.r := x5491_rd(0).r
              val x5493_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5493_elem_1""")
              x5493_elem_1.r := x5491_rd(1).r
              Map[String,Any]("x5476_elem_17" -> x5476_elem_17, "x5477_elem_18" -> x5477_elem_18, "x5478_elem_19" -> x5478_elem_19, "x5479_elem_20" -> x5479_elem_20, "x5480_elem_21" -> x5480_elem_21, "x5481_elem_22" -> x5481_elem_22, "x5482_elem_23" -> x5482_elem_23, "x5483_elem_24" -> x5483_elem_24, "x5484_elem_25" -> x5484_elem_25, "x5485_elem_26" -> x5485_elem_26, "x5486_elem_27" -> x5486_elem_27, "x5487_elem_28" -> x5487_elem_28, "x5488_elem_29" -> x5488_elem_29, "x5489_elem_30" -> x5489_elem_30, "x5490_elem_31" -> x5490_elem_31, "x5491_rd" -> x5491_rd, "x5492_elem_0" -> x5492_elem_0, "x5493_elem_1" -> x5493_elem_1)
            }
          }
          val block2chunk0sub10: Map[String, Any] = Block2Chunker0Sub10.gen()
          object Block2Chunker0Sub11 { // 30 nodes, 30 weight
            def gen(): Map[String, Any] = {
              val x5494_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5494_elem_2""")
              x5494_elem_2.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](2).r
              val x5495_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5495_elem_3""")
              x5495_elem_3.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](3).r
              val x5496_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5496_elem_4""")
              x5496_elem_4.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](4).r
              val x5497_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5497_elem_5""")
              x5497_elem_5.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](5).r
              val x5498_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5498_elem_6""")
              x5498_elem_6.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](6).r
              val x5499_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5499_elem_7""")
              x5499_elem_7.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](7).r
              val x5500_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5500_elem_8""")
              x5500_elem_8.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](8).r
              val x5501_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5501_elem_9""")
              x5501_elem_9.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](9).r
              val x5502_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5502_elem_10""")
              x5502_elem_10.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](10).r
              val x5503_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5503_elem_11""")
              x5503_elem_11.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](11).r
              val x5504_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5504_elem_12""")
              x5504_elem_12.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](12).r
              val x5505_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5505_elem_13""")
              x5505_elem_13.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](13).r
              val x5506_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5506_elem_14""")
              x5506_elem_14.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](14).r
              val x5507_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5507_elem_15""")
              x5507_elem_15.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](15).r
              val x5508_elem_16 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5508_elem_16""")
              x5508_elem_16.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](16).r
              val x5509_elem_17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5509_elem_17""")
              x5509_elem_17.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](17).r
              val x5510_elem_18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5510_elem_18""")
              x5510_elem_18.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](18).r
              val x5511_elem_19 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5511_elem_19""")
              x5511_elem_19.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](19).r
              val x5512_elem_20 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5512_elem_20""")
              x5512_elem_20.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](20).r
              val x5513_elem_21 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5513_elem_21""")
              x5513_elem_21.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](21).r
              val x5514_elem_22 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5514_elem_22""")
              x5514_elem_22.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](22).r
              val x5515_elem_23 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5515_elem_23""")
              x5515_elem_23.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](23).r
              val x5516_elem_24 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5516_elem_24""")
              x5516_elem_24.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](24).r
              val x5517_elem_25 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5517_elem_25""")
              x5517_elem_25.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](25).r
              val x5518_elem_26 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5518_elem_26""")
              x5518_elem_26.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](26).r
              val x5519_elem_27 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5519_elem_27""")
              x5519_elem_27.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](27).r
              val x5520_elem_28 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5520_elem_28""")
              x5520_elem_28.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](28).r
              val x5521_elem_29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5521_elem_29""")
              x5521_elem_29.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](29).r
              val x5522_elem_30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5522_elem_30""")
              x5522_elem_30.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](30).r
              val x5523_elem_31 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5523_elem_31""")
              x5523_elem_31.r := block2chunk0sub10("x5491_rd").asInstanceOf[Vec[FixedPoint]](31).r
              Map[String,Any]("x5494_elem_2" -> x5494_elem_2, "x5495_elem_3" -> x5495_elem_3, "x5496_elem_4" -> x5496_elem_4, "x5497_elem_5" -> x5497_elem_5, "x5498_elem_6" -> x5498_elem_6, "x5499_elem_7" -> x5499_elem_7, "x5500_elem_8" -> x5500_elem_8, "x5501_elem_9" -> x5501_elem_9, "x5502_elem_10" -> x5502_elem_10, "x5503_elem_11" -> x5503_elem_11, "x5504_elem_12" -> x5504_elem_12, "x5505_elem_13" -> x5505_elem_13, "x5506_elem_14" -> x5506_elem_14, "x5507_elem_15" -> x5507_elem_15, "x5508_elem_16" -> x5508_elem_16, "x5509_elem_17" -> x5509_elem_17, "x5510_elem_18" -> x5510_elem_18, "x5511_elem_19" -> x5511_elem_19, "x5512_elem_20" -> x5512_elem_20, "x5513_elem_21" -> x5513_elem_21, "x5514_elem_22" -> x5514_elem_22, "x5515_elem_23" -> x5515_elem_23, "x5516_elem_24" -> x5516_elem_24, "x5517_elem_25" -> x5517_elem_25, "x5518_elem_26" -> x5518_elem_26, "x5519_elem_27" -> x5519_elem_27, "x5520_elem_28" -> x5520_elem_28, "x5521_elem_29" -> x5521_elem_29, "x5522_elem_30" -> x5522_elem_30, "x5523_elem_31" -> x5523_elem_31)
            }
          }
          val block2chunk0sub11: Map[String, Any] = Block2Chunker0Sub11.gen()
          object Block2Chunker0Sub12 { // 18 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x5524_rd = Wire(Vec(32, new FixedPoint(true, 10, 22))).suggestName("""x5524_rd""")
              def create_x5524_rd_banks(): List[UInt] = {
                val x5524_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5524_rd_banks1 = List[UInt](7L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
                val x5524_rd_banks2 = List[UInt](7L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r)
                val x5524_rd_banks3 = List[UInt](7L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
                val x5524_rd_banks4 = List[UInt](14L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,16L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r)
                val x5524_rd_banks5 = List[UInt](7L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
                val x5524_rd_banks6 = List[UInt](21L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,24L.FP(true, 32, 0).r)
                val x5524_rd_banks7 = List[UInt](7L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
                val x5524_rd_banks8 = List[UInt](28L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                val x5524_rd_banks9 = List[UInt](7L.FP(true, 32, 0).r)
                x5524_rd_banks0 ++ x5524_rd_banks1 ++ x5524_rd_banks2 ++ x5524_rd_banks3 ++ x5524_rd_banks4 ++ x5524_rd_banks5 ++ x5524_rd_banks6 ++ x5524_rd_banks7 ++ x5524_rd_banks8 ++ x5524_rd_banks9
              }
              val x5524_rd_banks = create_x5524_rd_banks()
              def create_x5524_rd_ofs(): List[UInt] = {
                val x5524_rd_ofs0 = List[UInt](block2chunk0sub0("x5197").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5200").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs1 = List[UInt](block2chunk0sub0("x5203").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5206").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs2 = List[UInt](block2chunk0sub0("x5209").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5212").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs3 = List[UInt](block2chunk0sub0("x5215").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5218").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs4 = List[UInt](block2chunk0sub0("x5221").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5224").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs5 = List[UInt](block2chunk0sub0("x5227").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5230").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs6 = List[UInt](block2chunk0sub0("x5233").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5236").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs7 = List[UInt](block2chunk0sub0("x5239").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5242").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs8 = List[UInt](block2chunk0sub0("x5245").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5248").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs9 = List[UInt](block2chunk0sub0("x5251").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5254").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs10 = List[UInt](block2chunk0sub0("x5257").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5260").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs11 = List[UInt](block2chunk0sub0("x5263").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5266").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs12 = List[UInt](block2chunk0sub0("x5269").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5272").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs13 = List[UInt](block2chunk0sub0("x5275").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5278").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs14 = List[UInt](block2chunk0sub1("x5281").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5284").asInstanceOf[FixedPoint].r)
                val x5524_rd_ofs15 = List[UInt](block2chunk0sub1("x5287").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5290").asInstanceOf[FixedPoint].r)
                x5524_rd_ofs0 ++ x5524_rd_ofs1 ++ x5524_rd_ofs2 ++ x5524_rd_ofs3 ++ x5524_rd_ofs4 ++ x5524_rd_ofs5 ++ x5524_rd_ofs6 ++ x5524_rd_ofs7 ++ x5524_rd_ofs8 ++ x5524_rd_ofs9 ++ x5524_rd_ofs10 ++ x5524_rd_ofs11 ++ x5524_rd_ofs12 ++ x5524_rd_ofs13 ++ x5524_rd_ofs14 ++ x5524_rd_ofs15
              }
              val x5524_rd_ofs = create_x5524_rd_ofs()
              def create_x5524_rd_en(): List[Bool] = {
                val x5524_rd_en0 = List[Bool](b4493,b4494,b4495,b4496,b4497,b4498,b4499,b4500,b4501,b4502,b4503,b4504,b4505,b4506,b4507,b4508,b4509,b4510,b4511,b4512,b4513,b4514,b4515,b4516,b4517,b4518,b4519,b4520,b4521,b4522,b4523,b4524)
                x5524_rd_en0
              }
              val x5524_rd_en = create_x5524_rd_en()
              x5524_rd.toSeq.zip(x4241_weight_SRAM_reshape_0.connectRPort(5524, x5524_rd_banks, x5524_rd_ofs, io.sigsIn.backpressure, x5524_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool] & b4491 & b4068 & b4492 & b4060), true)).foreach{case (a,b) => a := b}
              val x5525_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5525_elem_0""")
              x5525_elem_0.r := x5524_rd(0).r
              val x5526_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5526_elem_1""")
              x5526_elem_1.r := x5524_rd(1).r
              val x5527_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5527_elem_2""")
              x5527_elem_2.r := x5524_rd(2).r
              val x5528_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5528_elem_3""")
              x5528_elem_3.r := x5524_rd(3).r
              val x5529_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5529_elem_4""")
              x5529_elem_4.r := x5524_rd(4).r
              val x5530_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5530_elem_5""")
              x5530_elem_5.r := x5524_rd(5).r
              val x5531_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5531_elem_6""")
              x5531_elem_6.r := x5524_rd(6).r
              val x5532_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5532_elem_7""")
              x5532_elem_7.r := x5524_rd(7).r
              val x5533_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5533_elem_8""")
              x5533_elem_8.r := x5524_rd(8).r
              val x5534_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5534_elem_9""")
              x5534_elem_9.r := x5524_rd(9).r
              val x5535_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5535_elem_10""")
              x5535_elem_10.r := x5524_rd(10).r
              val x5536_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5536_elem_11""")
              x5536_elem_11.r := x5524_rd(11).r
              val x5537_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5537_elem_12""")
              x5537_elem_12.r := x5524_rd(12).r
              val x5538_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5538_elem_13""")
              x5538_elem_13.r := x5524_rd(13).r
              val x5539_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5539_elem_14""")
              x5539_elem_14.r := x5524_rd(14).r
              val x5540_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5540_elem_15""")
              x5540_elem_15.r := x5524_rd(15).r
              val x5541_elem_16 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5541_elem_16""")
              x5541_elem_16.r := x5524_rd(16).r
              Map[String,Any]("x5524_rd" -> x5524_rd, "x5525_elem_0" -> x5525_elem_0, "x5526_elem_1" -> x5526_elem_1, "x5527_elem_2" -> x5527_elem_2, "x5528_elem_3" -> x5528_elem_3, "x5529_elem_4" -> x5529_elem_4, "x5530_elem_5" -> x5530_elem_5, "x5531_elem_6" -> x5531_elem_6, "x5532_elem_7" -> x5532_elem_7, "x5533_elem_8" -> x5533_elem_8, "x5534_elem_9" -> x5534_elem_9, "x5535_elem_10" -> x5535_elem_10, "x5536_elem_11" -> x5536_elem_11, "x5537_elem_12" -> x5537_elem_12, "x5538_elem_13" -> x5538_elem_13, "x5539_elem_14" -> x5539_elem_14, "x5540_elem_15" -> x5540_elem_15, "x5541_elem_16" -> x5541_elem_16)
            }
          }
          val block2chunk0sub12: Map[String, Any] = Block2Chunker0Sub12.gen()
          object Block2Chunker0Sub13 { // 18 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x5542_elem_17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5542_elem_17""")
              x5542_elem_17.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](17).r
              val x5543_elem_18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5543_elem_18""")
              x5543_elem_18.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](18).r
              val x5544_elem_19 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5544_elem_19""")
              x5544_elem_19.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](19).r
              val x5545_elem_20 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5545_elem_20""")
              x5545_elem_20.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](20).r
              val x5546_elem_21 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5546_elem_21""")
              x5546_elem_21.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](21).r
              val x5547_elem_22 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5547_elem_22""")
              x5547_elem_22.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](22).r
              val x5548_elem_23 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5548_elem_23""")
              x5548_elem_23.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](23).r
              val x5549_elem_24 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5549_elem_24""")
              x5549_elem_24.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](24).r
              val x5550_elem_25 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5550_elem_25""")
              x5550_elem_25.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](25).r
              val x5551_elem_26 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5551_elem_26""")
              x5551_elem_26.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](26).r
              val x5552_elem_27 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5552_elem_27""")
              x5552_elem_27.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](27).r
              val x5553_elem_28 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5553_elem_28""")
              x5553_elem_28.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](28).r
              val x5554_elem_29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5554_elem_29""")
              x5554_elem_29.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](29).r
              val x5555_elem_30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5555_elem_30""")
              x5555_elem_30.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](30).r
              val x5556_elem_31 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5556_elem_31""")
              x5556_elem_31.r := block2chunk0sub12("x5524_rd").asInstanceOf[Vec[FixedPoint]](31).r
              val x5557_rd = Wire(Vec(32, new FixedPoint(true, 10, 22))).suggestName("""x5557_rd""")
              def create_x5557_rd_banks(): List[UInt] = {
                val x5557_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
                val x5557_rd_banks1 = List[UInt](8L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r)
                val x5557_rd_banks2 = List[UInt](7L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r)
                val x5557_rd_banks3 = List[UInt](8L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r)
                val x5557_rd_banks4 = List[UInt](14L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,16L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r)
                val x5557_rd_banks5 = List[UInt](8L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r)
                val x5557_rd_banks6 = List[UInt](21L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,24L.FP(true, 32, 0).r)
                val x5557_rd_banks7 = List[UInt](8L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r)
                val x5557_rd_banks8 = List[UInt](28L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,8L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                val x5557_rd_banks9 = List[UInt](8L.FP(true, 32, 0).r)
                x5557_rd_banks0 ++ x5557_rd_banks1 ++ x5557_rd_banks2 ++ x5557_rd_banks3 ++ x5557_rd_banks4 ++ x5557_rd_banks5 ++ x5557_rd_banks6 ++ x5557_rd_banks7 ++ x5557_rd_banks8 ++ x5557_rd_banks9
              }
              val x5557_rd_banks = create_x5557_rd_banks()
              def create_x5557_rd_ofs(): List[UInt] = {
                val x5557_rd_ofs0 = List[UInt](block2chunk0sub0("x5197").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5200").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs1 = List[UInt](block2chunk0sub0("x5203").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5206").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs2 = List[UInt](block2chunk0sub0("x5209").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5212").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs3 = List[UInt](block2chunk0sub0("x5215").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5218").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs4 = List[UInt](block2chunk0sub0("x5221").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5224").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs5 = List[UInt](block2chunk0sub0("x5227").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5230").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs6 = List[UInt](block2chunk0sub0("x5233").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5236").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs7 = List[UInt](block2chunk0sub0("x5239").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5242").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs8 = List[UInt](block2chunk0sub0("x5245").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5248").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs9 = List[UInt](block2chunk0sub0("x5251").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5254").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs10 = List[UInt](block2chunk0sub0("x5257").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5260").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs11 = List[UInt](block2chunk0sub0("x5263").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5266").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs12 = List[UInt](block2chunk0sub0("x5269").asInstanceOf[FixedPoint].r,block2chunk0sub0("x5272").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs13 = List[UInt](block2chunk0sub0("x5275").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5278").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs14 = List[UInt](block2chunk0sub1("x5281").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5284").asInstanceOf[FixedPoint].r)
                val x5557_rd_ofs15 = List[UInt](block2chunk0sub1("x5287").asInstanceOf[FixedPoint].r,block2chunk0sub1("x5290").asInstanceOf[FixedPoint].r)
                x5557_rd_ofs0 ++ x5557_rd_ofs1 ++ x5557_rd_ofs2 ++ x5557_rd_ofs3 ++ x5557_rd_ofs4 ++ x5557_rd_ofs5 ++ x5557_rd_ofs6 ++ x5557_rd_ofs7 ++ x5557_rd_ofs8 ++ x5557_rd_ofs9 ++ x5557_rd_ofs10 ++ x5557_rd_ofs11 ++ x5557_rd_ofs12 ++ x5557_rd_ofs13 ++ x5557_rd_ofs14 ++ x5557_rd_ofs15
              }
              val x5557_rd_ofs = create_x5557_rd_ofs()
              def create_x5557_rd_en(): List[Bool] = {
                val x5557_rd_en0 = List[Bool](b4493,b4494,b4495,b4496,b4497,b4498,b4499,b4500,b4501,b4502,b4503,b4504,b4505,b4506,b4507,b4508,b4509,b4510,b4511,b4512,b4513,b4514,b4515,b4516,b4517,b4518,b4519,b4520,b4521,b4522,b4523,b4524)
                x5557_rd_en0
              }
              val x5557_rd_en = create_x5557_rd_en()
              x5557_rd.toSeq.zip(x4241_weight_SRAM_reshape_0.connectRPort(5557, x5557_rd_banks, x5557_rd_ofs, io.sigsIn.backpressure, x5557_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool] & b4491 & b4068 & b4492 & b4060), true)).foreach{case (a,b) => a := b}
              val x5558_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5558_elem_0""")
              x5558_elem_0.r := x5557_rd(0).r
              val x5559_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5559_elem_1""")
              x5559_elem_1.r := x5557_rd(1).r
              Map[String,Any]("x5542_elem_17" -> x5542_elem_17, "x5543_elem_18" -> x5543_elem_18, "x5544_elem_19" -> x5544_elem_19, "x5545_elem_20" -> x5545_elem_20, "x5546_elem_21" -> x5546_elem_21, "x5547_elem_22" -> x5547_elem_22, "x5548_elem_23" -> x5548_elem_23, "x5549_elem_24" -> x5549_elem_24, "x5550_elem_25" -> x5550_elem_25, "x5551_elem_26" -> x5551_elem_26, "x5552_elem_27" -> x5552_elem_27, "x5553_elem_28" -> x5553_elem_28, "x5554_elem_29" -> x5554_elem_29, "x5555_elem_30" -> x5555_elem_30, "x5556_elem_31" -> x5556_elem_31, "x5557_rd" -> x5557_rd, "x5558_elem_0" -> x5558_elem_0, "x5559_elem_1" -> x5559_elem_1)
            }
          }
          val block2chunk0sub13: Map[String, Any] = Block2Chunker0Sub13.gen()
          object Block2Chunker0Sub14 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x5560_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5560_elem_2""")
              x5560_elem_2.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](2).r
              val x5561_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5561_elem_3""")
              x5561_elem_3.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](3).r
              val x5562_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5562_elem_4""")
              x5562_elem_4.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](4).r
              val x5563_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5563_elem_5""")
              x5563_elem_5.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](5).r
              val x5564_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5564_elem_6""")
              x5564_elem_6.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](6).r
              val x5565_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5565_elem_7""")
              x5565_elem_7.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](7).r
              val x5566_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5566_elem_8""")
              x5566_elem_8.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](8).r
              val x5567_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5567_elem_9""")
              x5567_elem_9.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](9).r
              val x5568_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5568_elem_10""")
              x5568_elem_10.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](10).r
              val x5569_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5569_elem_11""")
              x5569_elem_11.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](11).r
              val x5570_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5570_elem_12""")
              x5570_elem_12.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](12).r
              val x5571_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5571_elem_13""")
              x5571_elem_13.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](13).r
              val x5572_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5572_elem_14""")
              x5572_elem_14.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](14).r
              val x5573_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5573_elem_15""")
              x5573_elem_15.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](15).r
              val x5574_elem_16 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5574_elem_16""")
              x5574_elem_16.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](16).r
              val x5575_elem_17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5575_elem_17""")
              x5575_elem_17.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](17).r
              val x5576_elem_18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5576_elem_18""")
              x5576_elem_18.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](18).r
              val x5577_elem_19 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5577_elem_19""")
              x5577_elem_19.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](19).r
              val x5578_elem_20 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5578_elem_20""")
              x5578_elem_20.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](20).r
              val x5579_elem_21 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5579_elem_21""")
              x5579_elem_21.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](21).r
              val x5580_elem_22 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5580_elem_22""")
              x5580_elem_22.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](22).r
              val x5581_elem_23 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5581_elem_23""")
              x5581_elem_23.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](23).r
              val x5582_elem_24 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5582_elem_24""")
              x5582_elem_24.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](24).r
              val x5583_elem_25 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5583_elem_25""")
              x5583_elem_25.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](25).r
              val x5584_elem_26 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5584_elem_26""")
              x5584_elem_26.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](26).r
              val x5585_elem_27 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5585_elem_27""")
              x5585_elem_27.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](27).r
              val x5586_elem_28 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5586_elem_28""")
              x5586_elem_28.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](28).r
              val x5587_elem_29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5587_elem_29""")
              x5587_elem_29.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](29).r
              val x5588_elem_30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5588_elem_30""")
              x5588_elem_30.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](30).r
              val x5589_elem_31 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5589_elem_31""")
              x5589_elem_31.r := block2chunk0sub13("x5557_rd").asInstanceOf[Vec[FixedPoint]](31).r
              val x5590 = Wire(Bool()).suggestName("""x5590""")
              x5590.r := Math.lt(0L.FP(true, 32, 0), block2chunk0sub0("x4653").asInstanceOf[FixedPoint], Some(0.4), true.B,"x5590").r
              val x5622 = Wire(Bool()).suggestName("""x5622""")
              x5622.r := Math.lt(0L.FP(true, 32, 0), block2chunk0sub0("x4941").asInstanceOf[FixedPoint], Some(0.4), true.B,"x5622").r
              val x5654 = Wire(Bool()).suggestName("""x5654""")
              x5654 := x5590 | x5622
              val x5686 = Wire(Bool()).suggestName("""x5686""")
              x5686.r := Math.eql(block2chunk0sub0("x4525_rd_x3946").asInstanceOf[FixedPoint], 1L.FP(true, 32, 0), Some(0.2), true.B,"x5686").r
              val x5718 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5718""")
              x5718.r := Math.arith_left_shift(b4457, 1, Some(0.2), true.B,"x5718").r
              val x5719 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5719""")
              x5719.r := Mux((x5686), b4457.r, x5718.r)
              val x5751_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5751_sum""")
              x5751_sum.r := Math.add(-1L.FP(true, 32, 0),x5719,Some(1.0), true.B, Truncate, Wrapping, "x5751_sum").r
              val x19694 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19694_x4973_rd_x3938_D1") 
              x19694.r := getRetimed(block2chunk0sub0("x4973_rd_x3938").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x5783_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5783_mul""")
              x5783_mul.r := (Math.mul(x5751_sum, x19694, Some(6.0), true.B, Truncate, Wrapping, "x5783_mul")).r
              val x5815_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5815_sub""")
              x5815_sub.r := Math.sub(x5783_mul,1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x5815_sub").r
              val x5847 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5847""")
              x5847.r := Math.arith_left_shift(b4458, 1, Some(0.2), true.B,"x5847").r
              val x5848 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5848""")
              x5848.r := Mux((x5686), b4458.r, x5847.r)
              val x19695 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19695_x5848_D8") 
              x19695.r := getRetimed(x5848.r, 8.toInt, io.sigsIn.backpressure)
              val x5880_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5880_sum""")
              x5880_sum.r := Math.add(x5815_sub,x19695,Some(1.0), true.B, Truncate, Wrapping, "x5880_sum").r
              val x18882 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18882""")
              x18882.r := Math.and(x5880_sum,3L.FP(true, 32, 0),Some(0.2), true.B,"x18882").r
              val x5913 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x5913""")
              x5913.r := Math.arith_right_shift(x5880_sum, 2, Some(0.2), true.B,"x5913").r
              val x19696 = Wire(Bool()).suggestName("x19696_b4492_D9") 
              x19696.r := getRetimed(b4492.r, 9.toInt, io.sigsIn.backpressure)
              val x19697 = Wire(Bool()).suggestName("x19697_b4493_D9") 
              x19697.r := getRetimed(b4493.r, 9.toInt, io.sigsIn.backpressure)
              val x19698 = Wire(Bool()).suggestName("x19698_b4068_D9") 
              x19698.r := getRetimed(b4068.r, 9.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x5560_elem_2" -> x5560_elem_2, "x5561_elem_3" -> x5561_elem_3, "x5562_elem_4" -> x5562_elem_4, "x5563_elem_5" -> x5563_elem_5, "x5564_elem_6" -> x5564_elem_6, "x5565_elem_7" -> x5565_elem_7, "x5566_elem_8" -> x5566_elem_8, "x5567_elem_9" -> x5567_elem_9, "x5568_elem_10" -> x5568_elem_10, "x5569_elem_11" -> x5569_elem_11, "x5570_elem_12" -> x5570_elem_12, "x5571_elem_13" -> x5571_elem_13, "x5572_elem_14" -> x5572_elem_14, "x5573_elem_15" -> x5573_elem_15, "x5574_elem_16" -> x5574_elem_16, "x5575_elem_17" -> x5575_elem_17, "x5576_elem_18" -> x5576_elem_18, "x5577_elem_19" -> x5577_elem_19, "x5578_elem_20" -> x5578_elem_20, "x5579_elem_21" -> x5579_elem_21, "x5580_elem_22" -> x5580_elem_22, "x5581_elem_23" -> x5581_elem_23, "x5582_elem_24" -> x5582_elem_24, "x5583_elem_25" -> x5583_elem_25, "x5584_elem_26" -> x5584_elem_26, "x5585_elem_27" -> x5585_elem_27, "x5586_elem_28" -> x5586_elem_28, "x5587_elem_29" -> x5587_elem_29, "x5588_elem_30" -> x5588_elem_30, "x5589_elem_31" -> x5589_elem_31, "x5590" -> x5590, "x5622" -> x5622, "x5654" -> x5654, "x5719" -> x5719, "x19694" -> x19694, "x5783_mul" -> x5783_mul, "x5848" -> x5848, "x19695" -> x19695, "x18882" -> x18882, "x5913" -> x5913, "x19696" -> x19696, "x19697" -> x19697, "x19698" -> x19698)
            }
          }
          val block2chunk0sub14: Map[String, Any] = Block2Chunker0Sub14.gen()
          object Block2Chunker0Sub15 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x19699 = Wire(Bool()).suggestName("x19699_b4060_D9") 
              x19699.r := getRetimed(b4060.r, 9.toInt, io.sigsIn.backpressure)
              val x19700 = Wire(Bool()).suggestName("x19700_x5133_rd_x3918_D9") 
              x19700.r := getRetimed(block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool].r, 9.toInt, io.sigsIn.backpressure)
              val x19701 = Wire(Bool()).suggestName("x19701_b4491_D9") 
              x19701.r := getRetimed(b4491.r, 9.toInt, io.sigsIn.backpressure)
              val x5916_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5916_rd""")
              val x5916_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5916_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5916_rd_en = List[Bool](true.B)
              x5916_rd.toSeq.zip(x4326_img2D_4.connectRPort(5916, x5916_rd_banks, x5916_rd_ofs, io.sigsIn.backpressure, x5916_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & block2chunk0sub14("x19697").asInstanceOf[Bool] & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5917_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5917_elem_0""")
              x5917_elem_0.r := x5916_rd(0).r
              val x5922_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5922_rd""")
              val x5922_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5922_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5922_rd_en = List[Bool](true.B)
              x5922_rd.toSeq.zip(x4326_img2D_4.connectRPort(5922, x5922_rd_banks, x5922_rd_ofs, io.sigsIn.backpressure, x5922_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5923_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5923_elem_0""")
              x5923_elem_0.r := x5922_rd(0).r
              val x5928_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5928_rd""")
              val x5928_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5928_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5928_rd_en = List[Bool](true.B)
              x5928_rd.toSeq.zip(x4326_img2D_4.connectRPort(5928, x5928_rd_banks, x5928_rd_ofs, io.sigsIn.backpressure, x5928_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5929_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5929_elem_0""")
              x5929_elem_0.r := x5928_rd(0).r
              val x5934_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5934_rd""")
              val x5934_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5934_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5934_rd_en = List[Bool](true.B)
              x5934_rd.toSeq.zip(x4326_img2D_4.connectRPort(5934, x5934_rd_banks, x5934_rd_ofs, io.sigsIn.backpressure, x5934_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5935_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5935_elem_0""")
              x5935_elem_0.r := x5934_rd(0).r
              val x5940_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5940_rd""")
              val x5940_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5940_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5940_rd_en = List[Bool](true.B)
              x5940_rd.toSeq.zip(x4326_img2D_4.connectRPort(5940, x5940_rd_banks, x5940_rd_ofs, io.sigsIn.backpressure, x5940_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5941_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5941_elem_0""")
              x5941_elem_0.r := x5940_rd(0).r
              val x5946_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5946_rd""")
              val x5946_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5946_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5946_rd_en = List[Bool](true.B)
              x5946_rd.toSeq.zip(x4326_img2D_4.connectRPort(5946, x5946_rd_banks, x5946_rd_ofs, io.sigsIn.backpressure, x5946_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5947_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5947_elem_0""")
              x5947_elem_0.r := x5946_rd(0).r
              val x5952_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5952_rd""")
              val x5952_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5952_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5952_rd_en = List[Bool](true.B)
              x5952_rd.toSeq.zip(x4326_img2D_4.connectRPort(5952, x5952_rd_banks, x5952_rd_ofs, io.sigsIn.backpressure, x5952_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5953_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5953_elem_0""")
              x5953_elem_0.r := x5952_rd(0).r
              val x5958_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5958_rd""")
              val x5958_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5958_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5958_rd_en = List[Bool](true.B)
              x5958_rd.toSeq.zip(x4326_img2D_4.connectRPort(5958, x5958_rd_banks, x5958_rd_ofs, io.sigsIn.backpressure, x5958_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5959_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5959_elem_0""")
              x5959_elem_0.r := x5958_rd(0).r
              val x5964_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5964_rd""")
              val x5964_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5964_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5964_rd_en = List[Bool](true.B)
              x5964_rd.toSeq.zip(x4326_img2D_4.connectRPort(5964, x5964_rd_banks, x5964_rd_ofs, io.sigsIn.backpressure, x5964_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5965_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5965_elem_0""")
              x5965_elem_0.r := x5964_rd(0).r
              val x5970_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5970_rd""")
              val x5970_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5970_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5970_rd_en = List[Bool](true.B)
              x5970_rd.toSeq.zip(x4326_img2D_4.connectRPort(5970, x5970_rd_banks, x5970_rd_ofs, io.sigsIn.backpressure, x5970_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5971_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5971_elem_0""")
              x5971_elem_0.r := x5970_rd(0).r
              val x5976_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5976_rd""")
              val x5976_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5976_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5976_rd_en = List[Bool](true.B)
              x5976_rd.toSeq.zip(x4326_img2D_4.connectRPort(5976, x5976_rd_banks, x5976_rd_ofs, io.sigsIn.backpressure, x5976_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5977_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5977_elem_0""")
              x5977_elem_0.r := x5976_rd(0).r
              val x5982_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5982_rd""")
              val x5982_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5982_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5982_rd_en = List[Bool](true.B)
              x5982_rd.toSeq.zip(x4326_img2D_4.connectRPort(5982, x5982_rd_banks, x5982_rd_ofs, io.sigsIn.backpressure, x5982_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5983_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5983_elem_0""")
              x5983_elem_0.r := x5982_rd(0).r
              val x5988_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5988_rd""")
              val x5988_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5988_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5988_rd_en = List[Bool](true.B)
              x5988_rd.toSeq.zip(x4326_img2D_4.connectRPort(5988, x5988_rd_banks, x5988_rd_ofs, io.sigsIn.backpressure, x5988_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5989_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5989_elem_0""")
              x5989_elem_0.r := x5988_rd(0).r
              val x5994_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x5994_rd""")
              val x5994_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x5994_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x5994_rd_en = List[Bool](true.B)
              x5994_rd.toSeq.zip(x4326_img2D_4.connectRPort(5994, x5994_rd_banks, x5994_rd_ofs, io.sigsIn.backpressure, x5994_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x5995_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x5995_elem_0""")
              x5995_elem_0.r := x5994_rd(0).r
              val x6000_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6000_rd""")
              val x6000_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6000_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6000_rd_en = List[Bool](true.B)
              x6000_rd.toSeq.zip(x4326_img2D_4.connectRPort(6000, x6000_rd_banks, x6000_rd_ofs, io.sigsIn.backpressure, x6000_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6001_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6001_elem_0""")
              x6001_elem_0.r := x6000_rd(0).r
              val x6006_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6006_rd""")
              val x6006_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6006_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6006_rd_en = List[Bool](true.B)
              x6006_rd.toSeq.zip(x4326_img2D_4.connectRPort(6006, x6006_rd_banks, x6006_rd_ofs, io.sigsIn.backpressure, x6006_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6007_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6007_elem_0""")
              x6007_elem_0.r := x6006_rd(0).r
              val x6012_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6012_rd""")
              val x6012_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6012_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6012_rd_en = List[Bool](true.B)
              x6012_rd.toSeq.zip(x4326_img2D_4.connectRPort(6012, x6012_rd_banks, x6012_rd_ofs, io.sigsIn.backpressure, x6012_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6013_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6013_elem_0""")
              x6013_elem_0.r := x6012_rd(0).r
              val x6018_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6018_rd""")
              val x6018_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6018_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6018_rd_en = List[Bool](true.B)
              x6018_rd.toSeq.zip(x4326_img2D_4.connectRPort(6018, x6018_rd_banks, x6018_rd_ofs, io.sigsIn.backpressure, x6018_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6019_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6019_elem_0""")
              x6019_elem_0.r := x6018_rd(0).r
              val x6024_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6024_rd""")
              val x6024_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6024_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6024_rd_en = List[Bool](true.B)
              x6024_rd.toSeq.zip(x4326_img2D_4.connectRPort(6024, x6024_rd_banks, x6024_rd_ofs, io.sigsIn.backpressure, x6024_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6025_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6025_elem_0""")
              x6025_elem_0.r := x6024_rd(0).r
              val x6030_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6030_rd""")
              val x6030_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6030_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6030_rd_en = List[Bool](true.B)
              x6030_rd.toSeq.zip(x4326_img2D_4.connectRPort(6030, x6030_rd_banks, x6030_rd_ofs, io.sigsIn.backpressure, x6030_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6031_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6031_elem_0""")
              x6031_elem_0.r := x6030_rd(0).r
              val x6036_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6036_rd""")
              val x6036_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6036_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6036_rd_en = List[Bool](true.B)
              x6036_rd.toSeq.zip(x4326_img2D_4.connectRPort(6036, x6036_rd_banks, x6036_rd_ofs, io.sigsIn.backpressure, x6036_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6037_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6037_elem_0""")
              x6037_elem_0.r := x6036_rd(0).r
              val x6042_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6042_rd""")
              val x6042_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6042_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6042_rd_en = List[Bool](true.B)
              x6042_rd.toSeq.zip(x4326_img2D_4.connectRPort(6042, x6042_rd_banks, x6042_rd_ofs, io.sigsIn.backpressure, x6042_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6043_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6043_elem_0""")
              x6043_elem_0.r := x6042_rd(0).r
              val x6048_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6048_rd""")
              val x6048_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6048_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6048_rd_en = List[Bool](true.B)
              x6048_rd.toSeq.zip(x4326_img2D_4.connectRPort(6048, x6048_rd_banks, x6048_rd_ofs, io.sigsIn.backpressure, x6048_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & x19701 & x19700 & x19699 & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6049_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6049_elem_0""")
              x6049_elem_0.r := x6048_rd(0).r
              Map[String,Any]("x19699" -> x19699, "x19700" -> x19700, "x19701" -> x19701, "x5917_elem_0" -> x5917_elem_0, "x5923_elem_0" -> x5923_elem_0, "x5929_elem_0" -> x5929_elem_0, "x5935_elem_0" -> x5935_elem_0, "x5941_elem_0" -> x5941_elem_0, "x5947_elem_0" -> x5947_elem_0, "x5953_elem_0" -> x5953_elem_0, "x5959_elem_0" -> x5959_elem_0, "x5965_elem_0" -> x5965_elem_0, "x5971_elem_0" -> x5971_elem_0, "x5977_elem_0" -> x5977_elem_0, "x5983_elem_0" -> x5983_elem_0, "x5989_elem_0" -> x5989_elem_0, "x5995_elem_0" -> x5995_elem_0, "x6001_elem_0" -> x6001_elem_0, "x6007_elem_0" -> x6007_elem_0, "x6013_elem_0" -> x6013_elem_0, "x6019_elem_0" -> x6019_elem_0, "x6025_elem_0" -> x6025_elem_0, "x6031_elem_0" -> x6031_elem_0, "x6037_elem_0" -> x6037_elem_0, "x6043_elem_0" -> x6043_elem_0, "x6049_elem_0" -> x6049_elem_0)
            }
          }
          val block2chunk0sub15: Map[String, Any] = Block2Chunker0Sub15.gen()
          object Block2Chunker0Sub16 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x6054_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6054_rd""")
              val x6054_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6054_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6054_rd_en = List[Bool](true.B)
              x6054_rd.toSeq.zip(x4326_img2D_4.connectRPort(6054, x6054_rd_banks, x6054_rd_ofs, io.sigsIn.backpressure, x6054_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6055_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6055_elem_0""")
              x6055_elem_0.r := x6054_rd(0).r
              val x6060_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6060_rd""")
              val x6060_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6060_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6060_rd_en = List[Bool](true.B)
              x6060_rd.toSeq.zip(x4326_img2D_4.connectRPort(6060, x6060_rd_banks, x6060_rd_ofs, io.sigsIn.backpressure, x6060_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6061_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6061_elem_0""")
              x6061_elem_0.r := x6060_rd(0).r
              val x6066_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6066_rd""")
              val x6066_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6066_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6066_rd_en = List[Bool](true.B)
              x6066_rd.toSeq.zip(x4326_img2D_4.connectRPort(6066, x6066_rd_banks, x6066_rd_ofs, io.sigsIn.backpressure, x6066_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6067_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6067_elem_0""")
              x6067_elem_0.r := x6066_rd(0).r
              val x6072_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6072_rd""")
              val x6072_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6072_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6072_rd_en = List[Bool](true.B)
              x6072_rd.toSeq.zip(x4326_img2D_4.connectRPort(6072, x6072_rd_banks, x6072_rd_ofs, io.sigsIn.backpressure, x6072_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6073_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6073_elem_0""")
              x6073_elem_0.r := x6072_rd(0).r
              val x6078_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6078_rd""")
              val x6078_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6078_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6078_rd_en = List[Bool](true.B)
              x6078_rd.toSeq.zip(x4326_img2D_4.connectRPort(6078, x6078_rd_banks, x6078_rd_ofs, io.sigsIn.backpressure, x6078_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6079_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6079_elem_0""")
              x6079_elem_0.r := x6078_rd(0).r
              val x6084_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6084_rd""")
              val x6084_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6084_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6084_rd_en = List[Bool](true.B)
              x6084_rd.toSeq.zip(x4326_img2D_4.connectRPort(6084, x6084_rd_banks, x6084_rd_ofs, io.sigsIn.backpressure, x6084_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6085_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6085_elem_0""")
              x6085_elem_0.r := x6084_rd(0).r
              val x6090_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6090_rd""")
              val x6090_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6090_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6090_rd_en = List[Bool](true.B)
              x6090_rd.toSeq.zip(x4326_img2D_4.connectRPort(6090, x6090_rd_banks, x6090_rd_ofs, io.sigsIn.backpressure, x6090_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6091_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6091_elem_0""")
              x6091_elem_0.r := x6090_rd(0).r
              val x6096_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6096_rd""")
              val x6096_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6096_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6096_rd_en = List[Bool](true.B)
              x6096_rd.toSeq.zip(x4326_img2D_4.connectRPort(6096, x6096_rd_banks, x6096_rd_ofs, io.sigsIn.backpressure, x6096_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6097_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6097_elem_0""")
              x6097_elem_0.r := x6096_rd(0).r
              val x6102_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6102_rd""")
              val x6102_rd_banks = List[UInt](block2chunk0sub14("x18882").asInstanceOf[FixedPoint].r)
              val x6102_rd_ofs = List[UInt](block2chunk0sub14("x5913").asInstanceOf[FixedPoint].r)
              val x6102_rd_en = List[Bool](true.B)
              x6102_rd.toSeq.zip(x4326_img2D_4.connectRPort(6102, x6102_rd_banks, x6102_rd_ofs, io.sigsIn.backpressure, x6102_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6103_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6103_elem_0""")
              x6103_elem_0.r := x6102_rd(0).r
              val x19733 = Wire(Bool()).suggestName("x19733_x5654_D4") 
              x19733.r := getRetimed(block2chunk0sub14("x5654").asInstanceOf[Bool].r, 4.toInt, io.sigsIn.backpressure)
              val x6104 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6104""")
              x6104.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5917_elem_0").asInstanceOf[FixedPoint].r)
              val x6105 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6105""")
              x6105.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5923_elem_0").asInstanceOf[FixedPoint].r)
              val x6106 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6106""")
              x6106.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5929_elem_0").asInstanceOf[FixedPoint].r)
              val x6107 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6107""")
              x6107.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5935_elem_0").asInstanceOf[FixedPoint].r)
              val x6108 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6108""")
              x6108.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5941_elem_0").asInstanceOf[FixedPoint].r)
              val x6109 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6109""")
              x6109.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5947_elem_0").asInstanceOf[FixedPoint].r)
              val x6110 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6110""")
              x6110.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5953_elem_0").asInstanceOf[FixedPoint].r)
              val x6111 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6111""")
              x6111.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5959_elem_0").asInstanceOf[FixedPoint].r)
              val x6112 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6112""")
              x6112.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5965_elem_0").asInstanceOf[FixedPoint].r)
              val x6113 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6113""")
              x6113.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5971_elem_0").asInstanceOf[FixedPoint].r)
              val x6114 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6114""")
              x6114.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5977_elem_0").asInstanceOf[FixedPoint].r)
              val x6115 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6115""")
              x6115.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5983_elem_0").asInstanceOf[FixedPoint].r)
              val x6116 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6116""")
              x6116.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5989_elem_0").asInstanceOf[FixedPoint].r)
              val x6117 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6117""")
              x6117.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x5995_elem_0").asInstanceOf[FixedPoint].r)
              val x6118 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6118""")
              x6118.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x6001_elem_0").asInstanceOf[FixedPoint].r)
              val x6119 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6119""")
              x6119.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x6007_elem_0").asInstanceOf[FixedPoint].r)
              val x6120 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6120""")
              x6120.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x6013_elem_0").asInstanceOf[FixedPoint].r)
              val x6121 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6121""")
              x6121.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x6019_elem_0").asInstanceOf[FixedPoint].r)
              val x6122 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6122""")
              x6122.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x6025_elem_0").asInstanceOf[FixedPoint].r)
              val x6123 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6123""")
              x6123.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x6031_elem_0").asInstanceOf[FixedPoint].r)
              val x6124 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6124""")
              x6124.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x6037_elem_0").asInstanceOf[FixedPoint].r)
              val x6125 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6125""")
              x6125.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x6043_elem_0").asInstanceOf[FixedPoint].r)
              val x6126 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6126""")
              x6126.r := Mux((x19733), 0.FP(true, 10, 22).r, block2chunk0sub15("x6049_elem_0").asInstanceOf[FixedPoint].r)
              val x6127 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6127""")
              x6127.r := Mux((x19733), 0.FP(true, 10, 22).r, x6055_elem_0.r)
              val x6128 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6128""")
              x6128.r := Mux((x19733), 0.FP(true, 10, 22).r, x6061_elem_0.r)
              val x6129 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6129""")
              x6129.r := Mux((x19733), 0.FP(true, 10, 22).r, x6067_elem_0.r)
              val x6130 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6130""")
              x6130.r := Mux((x19733), 0.FP(true, 10, 22).r, x6073_elem_0.r)
              val x6131 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6131""")
              x6131.r := Mux((x19733), 0.FP(true, 10, 22).r, x6079_elem_0.r)
              val x6132 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6132""")
              x6132.r := Mux((x19733), 0.FP(true, 10, 22).r, x6085_elem_0.r)
              val x6133 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6133""")
              x6133.r := Mux((x19733), 0.FP(true, 10, 22).r, x6091_elem_0.r)
              Map[String,Any]("x6097_elem_0" -> x6097_elem_0, "x6103_elem_0" -> x6103_elem_0, "x19733" -> x19733, "x6104" -> x6104, "x6105" -> x6105, "x6106" -> x6106, "x6107" -> x6107, "x6108" -> x6108, "x6109" -> x6109, "x6110" -> x6110, "x6111" -> x6111, "x6112" -> x6112, "x6113" -> x6113, "x6114" -> x6114, "x6115" -> x6115, "x6116" -> x6116, "x6117" -> x6117, "x6118" -> x6118, "x6119" -> x6119, "x6120" -> x6120, "x6121" -> x6121, "x6122" -> x6122, "x6123" -> x6123, "x6124" -> x6124, "x6125" -> x6125, "x6126" -> x6126, "x6127" -> x6127, "x6128" -> x6128, "x6129" -> x6129, "x6130" -> x6130, "x6131" -> x6131, "x6132" -> x6132, "x6133" -> x6133)
            }
          }
          val block2chunk0sub16: Map[String, Any] = Block2Chunker0Sub16.gen()
          object Block2Chunker0Sub17 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x6134 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6134""")
              x6134.r := Mux((block2chunk0sub16("x19733").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub16("x6097_elem_0").asInstanceOf[FixedPoint].r)
              val x6135 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6135""")
              x6135.r := Mux((block2chunk0sub16("x19733").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub16("x6103_elem_0").asInstanceOf[FixedPoint].r)
              val x6136_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x6136_sum""")
              x6136_sum.r := Math.add(block2chunk0sub14("x5783_mul").asInstanceOf[FixedPoint],1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x6136_sum").r
              val x19734 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19734_x5848_D7") 
              x19734.r := getRetimed(block2chunk0sub14("x5848").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
              val x6168_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x6168_sum""")
              x6168_sum.r := Math.add(block2chunk0sub14("x5783_mul").asInstanceOf[FixedPoint],x19734,Some(1.0), true.B, Truncate, Wrapping, "x6168_sum").r
              val x18883 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18883""")
              x18883.r := Math.and(x6168_sum,3L.FP(true, 32, 0),Some(0.2), true.B,"x18883").r
              val x6201 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x6201""")
              x6201.r := Math.arith_right_shift(x6168_sum, 2, Some(0.2), true.B,"x6201").r
              val x19735 = Wire(Bool()).suggestName("x19735_b4492_D8") 
              x19735.r := getRetimed(b4492.r, 8.toInt, io.sigsIn.backpressure)
              val x19736 = Wire(Bool()).suggestName("x19736_b4493_D8") 
              x19736.r := getRetimed(b4493.r, 8.toInt, io.sigsIn.backpressure)
              val x19737 = Wire(Bool()).suggestName("x19737_b4068_D8") 
              x19737.r := getRetimed(b4068.r, 8.toInt, io.sigsIn.backpressure)
              val x19738 = Wire(Bool()).suggestName("x19738_b4060_D8") 
              x19738.r := getRetimed(b4060.r, 8.toInt, io.sigsIn.backpressure)
              val x19739 = Wire(Bool()).suggestName("x19739_x5133_rd_x3918_D8") 
              x19739.r := getRetimed(block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool].r, 8.toInt, io.sigsIn.backpressure)
              val x19740 = Wire(Bool()).suggestName("x19740_b4491_D8") 
              x19740.r := getRetimed(b4491.r, 8.toInt, io.sigsIn.backpressure)
              val x6204_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6204_rd""")
              val x6204_rd_banks = List[UInt](x18883.r)
              val x6204_rd_ofs = List[UInt](x6201.r)
              val x6204_rd_en = List[Bool](true.B)
              x6204_rd.toSeq.zip(x4329_img2D_7.connectRPort(6204, x6204_rd_banks, x6204_rd_ofs, io.sigsIn.backpressure, x6204_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735 & x19736), false)).foreach{case (a,b) => a := b}
              val x6205_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6205_elem_0""")
              x6205_elem_0.r := x6204_rd(0).r
              val x6210_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6210_rd""")
              val x6210_rd_banks = List[UInt](x18883.r)
              val x6210_rd_ofs = List[UInt](x6201.r)
              val x6210_rd_en = List[Bool](true.B)
              x6210_rd.toSeq.zip(x4329_img2D_7.connectRPort(6210, x6210_rd_banks, x6210_rd_ofs, io.sigsIn.backpressure, x6210_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6211_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6211_elem_0""")
              x6211_elem_0.r := x6210_rd(0).r
              val x6216_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6216_rd""")
              val x6216_rd_banks = List[UInt](x18883.r)
              val x6216_rd_ofs = List[UInt](x6201.r)
              val x6216_rd_en = List[Bool](true.B)
              x6216_rd.toSeq.zip(x4329_img2D_7.connectRPort(6216, x6216_rd_banks, x6216_rd_ofs, io.sigsIn.backpressure, x6216_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6217_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6217_elem_0""")
              x6217_elem_0.r := x6216_rd(0).r
              val x6222_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6222_rd""")
              val x6222_rd_banks = List[UInt](x18883.r)
              val x6222_rd_ofs = List[UInt](x6201.r)
              val x6222_rd_en = List[Bool](true.B)
              x6222_rd.toSeq.zip(x4329_img2D_7.connectRPort(6222, x6222_rd_banks, x6222_rd_ofs, io.sigsIn.backpressure, x6222_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6223_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6223_elem_0""")
              x6223_elem_0.r := x6222_rd(0).r
              val x6228_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6228_rd""")
              val x6228_rd_banks = List[UInt](x18883.r)
              val x6228_rd_ofs = List[UInt](x6201.r)
              val x6228_rd_en = List[Bool](true.B)
              x6228_rd.toSeq.zip(x4329_img2D_7.connectRPort(6228, x6228_rd_banks, x6228_rd_ofs, io.sigsIn.backpressure, x6228_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6229_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6229_elem_0""")
              x6229_elem_0.r := x6228_rd(0).r
              val x6234_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6234_rd""")
              val x6234_rd_banks = List[UInt](x18883.r)
              val x6234_rd_ofs = List[UInt](x6201.r)
              val x6234_rd_en = List[Bool](true.B)
              x6234_rd.toSeq.zip(x4329_img2D_7.connectRPort(6234, x6234_rd_banks, x6234_rd_ofs, io.sigsIn.backpressure, x6234_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6235_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6235_elem_0""")
              x6235_elem_0.r := x6234_rd(0).r
              val x6240_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6240_rd""")
              val x6240_rd_banks = List[UInt](x18883.r)
              val x6240_rd_ofs = List[UInt](x6201.r)
              val x6240_rd_en = List[Bool](true.B)
              x6240_rd.toSeq.zip(x4329_img2D_7.connectRPort(6240, x6240_rd_banks, x6240_rd_ofs, io.sigsIn.backpressure, x6240_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6241_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6241_elem_0""")
              x6241_elem_0.r := x6240_rd(0).r
              val x6246_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6246_rd""")
              val x6246_rd_banks = List[UInt](x18883.r)
              val x6246_rd_ofs = List[UInt](x6201.r)
              val x6246_rd_en = List[Bool](true.B)
              x6246_rd.toSeq.zip(x4329_img2D_7.connectRPort(6246, x6246_rd_banks, x6246_rd_ofs, io.sigsIn.backpressure, x6246_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6247_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6247_elem_0""")
              x6247_elem_0.r := x6246_rd(0).r
              val x6252_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6252_rd""")
              val x6252_rd_banks = List[UInt](x18883.r)
              val x6252_rd_ofs = List[UInt](x6201.r)
              val x6252_rd_en = List[Bool](true.B)
              x6252_rd.toSeq.zip(x4329_img2D_7.connectRPort(6252, x6252_rd_banks, x6252_rd_ofs, io.sigsIn.backpressure, x6252_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6253_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6253_elem_0""")
              x6253_elem_0.r := x6252_rd(0).r
              val x6258_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6258_rd""")
              val x6258_rd_banks = List[UInt](x18883.r)
              val x6258_rd_ofs = List[UInt](x6201.r)
              val x6258_rd_en = List[Bool](true.B)
              x6258_rd.toSeq.zip(x4329_img2D_7.connectRPort(6258, x6258_rd_banks, x6258_rd_ofs, io.sigsIn.backpressure, x6258_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6259_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6259_elem_0""")
              x6259_elem_0.r := x6258_rd(0).r
              val x6264_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6264_rd""")
              val x6264_rd_banks = List[UInt](x18883.r)
              val x6264_rd_ofs = List[UInt](x6201.r)
              val x6264_rd_en = List[Bool](true.B)
              x6264_rd.toSeq.zip(x4329_img2D_7.connectRPort(6264, x6264_rd_banks, x6264_rd_ofs, io.sigsIn.backpressure, x6264_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6265_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6265_elem_0""")
              x6265_elem_0.r := x6264_rd(0).r
              val x6270_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6270_rd""")
              val x6270_rd_banks = List[UInt](x18883.r)
              val x6270_rd_ofs = List[UInt](x6201.r)
              val x6270_rd_en = List[Bool](true.B)
              x6270_rd.toSeq.zip(x4329_img2D_7.connectRPort(6270, x6270_rd_banks, x6270_rd_ofs, io.sigsIn.backpressure, x6270_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6271_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6271_elem_0""")
              x6271_elem_0.r := x6270_rd(0).r
              val x6276_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6276_rd""")
              val x6276_rd_banks = List[UInt](x18883.r)
              val x6276_rd_ofs = List[UInt](x6201.r)
              val x6276_rd_en = List[Bool](true.B)
              x6276_rd.toSeq.zip(x4329_img2D_7.connectRPort(6276, x6276_rd_banks, x6276_rd_ofs, io.sigsIn.backpressure, x6276_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6277_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6277_elem_0""")
              x6277_elem_0.r := x6276_rd(0).r
              val x6282_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6282_rd""")
              val x6282_rd_banks = List[UInt](x18883.r)
              val x6282_rd_ofs = List[UInt](x6201.r)
              val x6282_rd_en = List[Bool](true.B)
              x6282_rd.toSeq.zip(x4329_img2D_7.connectRPort(6282, x6282_rd_banks, x6282_rd_ofs, io.sigsIn.backpressure, x6282_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6283_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6283_elem_0""")
              x6283_elem_0.r := x6282_rd(0).r
              val x6288_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6288_rd""")
              val x6288_rd_banks = List[UInt](x18883.r)
              val x6288_rd_ofs = List[UInt](x6201.r)
              val x6288_rd_en = List[Bool](true.B)
              x6288_rd.toSeq.zip(x4329_img2D_7.connectRPort(6288, x6288_rd_banks, x6288_rd_ofs, io.sigsIn.backpressure, x6288_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6289_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6289_elem_0""")
              x6289_elem_0.r := x6288_rd(0).r
              val x6294_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6294_rd""")
              val x6294_rd_banks = List[UInt](x18883.r)
              val x6294_rd_ofs = List[UInt](x6201.r)
              val x6294_rd_en = List[Bool](true.B)
              x6294_rd.toSeq.zip(x4329_img2D_7.connectRPort(6294, x6294_rd_banks, x6294_rd_ofs, io.sigsIn.backpressure, x6294_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6295_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6295_elem_0""")
              x6295_elem_0.r := x6294_rd(0).r
              val x6300_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6300_rd""")
              val x6300_rd_banks = List[UInt](x18883.r)
              val x6300_rd_ofs = List[UInt](x6201.r)
              val x6300_rd_en = List[Bool](true.B)
              x6300_rd.toSeq.zip(x4329_img2D_7.connectRPort(6300, x6300_rd_banks, x6300_rd_ofs, io.sigsIn.backpressure, x6300_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6301_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6301_elem_0""")
              x6301_elem_0.r := x6300_rd(0).r
              val x6306_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6306_rd""")
              val x6306_rd_banks = List[UInt](x18883.r)
              val x6306_rd_ofs = List[UInt](x6201.r)
              val x6306_rd_en = List[Bool](true.B)
              x6306_rd.toSeq.zip(x4329_img2D_7.connectRPort(6306, x6306_rd_banks, x6306_rd_ofs, io.sigsIn.backpressure, x6306_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && x19737 & x19738 & x19740 & x19739 & x19735), false)).foreach{case (a,b) => a := b}
              val x6307_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6307_elem_0""")
              x6307_elem_0.r := x6306_rd(0).r
              Map[String,Any]("x6134" -> x6134, "x6135" -> x6135, "x6136_sum" -> x6136_sum, "x19734" -> x19734, "x18883" -> x18883, "x6201" -> x6201, "x19735" -> x19735, "x19736" -> x19736, "x19737" -> x19737, "x19738" -> x19738, "x19739" -> x19739, "x19740" -> x19740, "x6205_elem_0" -> x6205_elem_0, "x6211_elem_0" -> x6211_elem_0, "x6217_elem_0" -> x6217_elem_0, "x6223_elem_0" -> x6223_elem_0, "x6229_elem_0" -> x6229_elem_0, "x6235_elem_0" -> x6235_elem_0, "x6241_elem_0" -> x6241_elem_0, "x6247_elem_0" -> x6247_elem_0, "x6253_elem_0" -> x6253_elem_0, "x6259_elem_0" -> x6259_elem_0, "x6265_elem_0" -> x6265_elem_0, "x6271_elem_0" -> x6271_elem_0, "x6277_elem_0" -> x6277_elem_0, "x6283_elem_0" -> x6283_elem_0, "x6289_elem_0" -> x6289_elem_0, "x6295_elem_0" -> x6295_elem_0, "x6301_elem_0" -> x6301_elem_0, "x6307_elem_0" -> x6307_elem_0)
            }
          }
          val block2chunk0sub17: Map[String, Any] = Block2Chunker0Sub17.gen()
          object Block2Chunker0Sub18 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x6312_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6312_rd""")
              val x6312_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6312_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6312_rd_en = List[Bool](true.B)
              x6312_rd.toSeq.zip(x4329_img2D_7.connectRPort(6312, x6312_rd_banks, x6312_rd_ofs, io.sigsIn.backpressure, x6312_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6313_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6313_elem_0""")
              x6313_elem_0.r := x6312_rd(0).r
              val x6318_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6318_rd""")
              val x6318_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6318_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6318_rd_en = List[Bool](true.B)
              x6318_rd.toSeq.zip(x4329_img2D_7.connectRPort(6318, x6318_rd_banks, x6318_rd_ofs, io.sigsIn.backpressure, x6318_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6319_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6319_elem_0""")
              x6319_elem_0.r := x6318_rd(0).r
              val x6324_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6324_rd""")
              val x6324_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6324_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6324_rd_en = List[Bool](true.B)
              x6324_rd.toSeq.zip(x4329_img2D_7.connectRPort(6324, x6324_rd_banks, x6324_rd_ofs, io.sigsIn.backpressure, x6324_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6325_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6325_elem_0""")
              x6325_elem_0.r := x6324_rd(0).r
              val x6330_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6330_rd""")
              val x6330_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6330_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6330_rd_en = List[Bool](true.B)
              x6330_rd.toSeq.zip(x4329_img2D_7.connectRPort(6330, x6330_rd_banks, x6330_rd_ofs, io.sigsIn.backpressure, x6330_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6331_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6331_elem_0""")
              x6331_elem_0.r := x6330_rd(0).r
              val x6336_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6336_rd""")
              val x6336_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6336_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6336_rd_en = List[Bool](true.B)
              x6336_rd.toSeq.zip(x4329_img2D_7.connectRPort(6336, x6336_rd_banks, x6336_rd_ofs, io.sigsIn.backpressure, x6336_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6337_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6337_elem_0""")
              x6337_elem_0.r := x6336_rd(0).r
              val x6342_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6342_rd""")
              val x6342_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6342_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6342_rd_en = List[Bool](true.B)
              x6342_rd.toSeq.zip(x4329_img2D_7.connectRPort(6342, x6342_rd_banks, x6342_rd_ofs, io.sigsIn.backpressure, x6342_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6343_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6343_elem_0""")
              x6343_elem_0.r := x6342_rd(0).r
              val x6348_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6348_rd""")
              val x6348_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6348_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6348_rd_en = List[Bool](true.B)
              x6348_rd.toSeq.zip(x4329_img2D_7.connectRPort(6348, x6348_rd_banks, x6348_rd_ofs, io.sigsIn.backpressure, x6348_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6349_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6349_elem_0""")
              x6349_elem_0.r := x6348_rd(0).r
              val x6354_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6354_rd""")
              val x6354_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6354_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6354_rd_en = List[Bool](true.B)
              x6354_rd.toSeq.zip(x4329_img2D_7.connectRPort(6354, x6354_rd_banks, x6354_rd_ofs, io.sigsIn.backpressure, x6354_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6355_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6355_elem_0""")
              x6355_elem_0.r := x6354_rd(0).r
              val x6360_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6360_rd""")
              val x6360_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6360_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6360_rd_en = List[Bool](true.B)
              x6360_rd.toSeq.zip(x4329_img2D_7.connectRPort(6360, x6360_rd_banks, x6360_rd_ofs, io.sigsIn.backpressure, x6360_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6361_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6361_elem_0""")
              x6361_elem_0.r := x6360_rd(0).r
              val x6366_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6366_rd""")
              val x6366_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6366_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6366_rd_en = List[Bool](true.B)
              x6366_rd.toSeq.zip(x4329_img2D_7.connectRPort(6366, x6366_rd_banks, x6366_rd_ofs, io.sigsIn.backpressure, x6366_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6367_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6367_elem_0""")
              x6367_elem_0.r := x6366_rd(0).r
              val x6372_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6372_rd""")
              val x6372_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6372_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6372_rd_en = List[Bool](true.B)
              x6372_rd.toSeq.zip(x4329_img2D_7.connectRPort(6372, x6372_rd_banks, x6372_rd_ofs, io.sigsIn.backpressure, x6372_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6373_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6373_elem_0""")
              x6373_elem_0.r := x6372_rd(0).r
              val x6378_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6378_rd""")
              val x6378_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6378_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6378_rd_en = List[Bool](true.B)
              x6378_rd.toSeq.zip(x4329_img2D_7.connectRPort(6378, x6378_rd_banks, x6378_rd_ofs, io.sigsIn.backpressure, x6378_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6379_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6379_elem_0""")
              x6379_elem_0.r := x6378_rd(0).r
              val x6384_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6384_rd""")
              val x6384_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6384_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6384_rd_en = List[Bool](true.B)
              x6384_rd.toSeq.zip(x4329_img2D_7.connectRPort(6384, x6384_rd_banks, x6384_rd_ofs, io.sigsIn.backpressure, x6384_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6385_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6385_elem_0""")
              x6385_elem_0.r := x6384_rd(0).r
              val x6390_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6390_rd""")
              val x6390_rd_banks = List[UInt](block2chunk0sub17("x18883").asInstanceOf[FixedPoint].r)
              val x6390_rd_ofs = List[UInt](block2chunk0sub17("x6201").asInstanceOf[FixedPoint].r)
              val x6390_rd_en = List[Bool](true.B)
              x6390_rd.toSeq.zip(x4329_img2D_7.connectRPort(6390, x6390_rd_banks, x6390_rd_ofs, io.sigsIn.backpressure, x6390_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6391_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6391_elem_0""")
              x6391_elem_0.r := x6390_rd(0).r
              val x19772 = Wire(Bool()).suggestName("x19772_x5590_D3") 
              x19772.r := getRetimed(block2chunk0sub14("x5590").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
              val x6392 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6392""")
              x6392.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6205_elem_0").asInstanceOf[FixedPoint].r)
              val x6393 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6393""")
              x6393.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6211_elem_0").asInstanceOf[FixedPoint].r)
              val x6394 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6394""")
              x6394.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6217_elem_0").asInstanceOf[FixedPoint].r)
              val x6395 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6395""")
              x6395.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6223_elem_0").asInstanceOf[FixedPoint].r)
              val x6396 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6396""")
              x6396.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6229_elem_0").asInstanceOf[FixedPoint].r)
              val x6397 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6397""")
              x6397.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6235_elem_0").asInstanceOf[FixedPoint].r)
              val x6398 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6398""")
              x6398.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6241_elem_0").asInstanceOf[FixedPoint].r)
              val x6399 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6399""")
              x6399.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6247_elem_0").asInstanceOf[FixedPoint].r)
              val x6400 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6400""")
              x6400.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6253_elem_0").asInstanceOf[FixedPoint].r)
              val x6401 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6401""")
              x6401.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6259_elem_0").asInstanceOf[FixedPoint].r)
              val x6402 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6402""")
              x6402.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6265_elem_0").asInstanceOf[FixedPoint].r)
              val x6403 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6403""")
              x6403.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6271_elem_0").asInstanceOf[FixedPoint].r)
              val x6404 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6404""")
              x6404.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6277_elem_0").asInstanceOf[FixedPoint].r)
              val x6405 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6405""")
              x6405.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6283_elem_0").asInstanceOf[FixedPoint].r)
              val x6406 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6406""")
              x6406.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6289_elem_0").asInstanceOf[FixedPoint].r)
              val x6407 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6407""")
              x6407.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6295_elem_0").asInstanceOf[FixedPoint].r)
              val x6408 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6408""")
              x6408.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6301_elem_0").asInstanceOf[FixedPoint].r)
              val x6409 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6409""")
              x6409.r := Mux((x19772), 0.FP(true, 10, 22).r, block2chunk0sub17("x6307_elem_0").asInstanceOf[FixedPoint].r)
              val x6410 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6410""")
              x6410.r := Mux((x19772), 0.FP(true, 10, 22).r, x6313_elem_0.r)
              val x6411 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6411""")
              x6411.r := Mux((x19772), 0.FP(true, 10, 22).r, x6319_elem_0.r)
              Map[String,Any]("x6325_elem_0" -> x6325_elem_0, "x6331_elem_0" -> x6331_elem_0, "x6337_elem_0" -> x6337_elem_0, "x6343_elem_0" -> x6343_elem_0, "x6349_elem_0" -> x6349_elem_0, "x6355_elem_0" -> x6355_elem_0, "x6361_elem_0" -> x6361_elem_0, "x6367_elem_0" -> x6367_elem_0, "x6373_elem_0" -> x6373_elem_0, "x6379_elem_0" -> x6379_elem_0, "x6385_elem_0" -> x6385_elem_0, "x6391_elem_0" -> x6391_elem_0, "x19772" -> x19772, "x6392" -> x6392, "x6393" -> x6393, "x6394" -> x6394, "x6395" -> x6395, "x6396" -> x6396, "x6397" -> x6397, "x6398" -> x6398, "x6399" -> x6399, "x6400" -> x6400, "x6401" -> x6401, "x6402" -> x6402, "x6403" -> x6403, "x6404" -> x6404, "x6405" -> x6405, "x6406" -> x6406, "x6407" -> x6407, "x6408" -> x6408, "x6409" -> x6409, "x6410" -> x6410, "x6411" -> x6411)
            }
          }
          val block2chunk0sub18: Map[String, Any] = Block2Chunker0Sub18.gen()
          object Block2Chunker0Sub19 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x6412 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6412""")
              x6412.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6325_elem_0").asInstanceOf[FixedPoint].r)
              val x6413 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6413""")
              x6413.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6331_elem_0").asInstanceOf[FixedPoint].r)
              val x6414 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6414""")
              x6414.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6337_elem_0").asInstanceOf[FixedPoint].r)
              val x6415 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6415""")
              x6415.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6343_elem_0").asInstanceOf[FixedPoint].r)
              val x6416 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6416""")
              x6416.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6349_elem_0").asInstanceOf[FixedPoint].r)
              val x6417 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6417""")
              x6417.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6355_elem_0").asInstanceOf[FixedPoint].r)
              val x6418 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6418""")
              x6418.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6361_elem_0").asInstanceOf[FixedPoint].r)
              val x6419 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6419""")
              x6419.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6367_elem_0").asInstanceOf[FixedPoint].r)
              val x6420 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6420""")
              x6420.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6373_elem_0").asInstanceOf[FixedPoint].r)
              val x6421 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6421""")
              x6421.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6379_elem_0").asInstanceOf[FixedPoint].r)
              val x6422 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6422""")
              x6422.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6385_elem_0").asInstanceOf[FixedPoint].r)
              val x6423 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6423""")
              x6423.r := Mux((block2chunk0sub18("x19772").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub18("x6391_elem_0").asInstanceOf[FixedPoint].r)
              val x6424 = Wire(Bool()).suggestName("""x6424""")
              x6424.r := Math.lt(block2chunk0sub0("x5101").asInstanceOf[FixedPoint], 3L.FP(true, 32, 0), Some(0.4), true.B,"x6424").r
              val x6456 = Wire(Bool()).suggestName("""x6456""")
              x6456 := block2chunk0sub14("x5590").asInstanceOf[Bool] | x6424
              val x6488_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x6488_sum""")
              x6488_sum.r := Math.add(block2chunk0sub17("x6136_sum").asInstanceOf[FixedPoint],block2chunk0sub14("x19695").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x6488_sum").r
              val x18884 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18884""")
              x18884.r := Math.and(x6488_sum,3L.FP(true, 32, 0),Some(0.2), true.B,"x18884").r
              val x6521 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x6521""")
              x6521.r := Math.arith_right_shift(x6488_sum, 2, Some(0.2), true.B,"x6521").r
              val x6524_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6524_rd""")
              val x6524_rd_banks = List[UInt](x18884.r)
              val x6524_rd_ofs = List[UInt](x6521.r)
              val x6524_rd_en = List[Bool](true.B)
              x6524_rd.toSeq.zip(x4322_img2D_0.connectRPort(6524, x6524_rd_banks, x6524_rd_ofs, io.sigsIn.backpressure, x6524_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub14("x19697").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6525_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6525_elem_0""")
              x6525_elem_0.r := x6524_rd(0).r
              val x6530_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6530_rd""")
              val x6530_rd_banks = List[UInt](x18884.r)
              val x6530_rd_ofs = List[UInt](x6521.r)
              val x6530_rd_en = List[Bool](true.B)
              x6530_rd.toSeq.zip(x4322_img2D_0.connectRPort(6530, x6530_rd_banks, x6530_rd_ofs, io.sigsIn.backpressure, x6530_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6531_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6531_elem_0""")
              x6531_elem_0.r := x6530_rd(0).r
              val x6536_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6536_rd""")
              val x6536_rd_banks = List[UInt](x18884.r)
              val x6536_rd_ofs = List[UInt](x6521.r)
              val x6536_rd_en = List[Bool](true.B)
              x6536_rd.toSeq.zip(x4322_img2D_0.connectRPort(6536, x6536_rd_banks, x6536_rd_ofs, io.sigsIn.backpressure, x6536_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6537_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6537_elem_0""")
              x6537_elem_0.r := x6536_rd(0).r
              val x6542_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6542_rd""")
              val x6542_rd_banks = List[UInt](x18884.r)
              val x6542_rd_ofs = List[UInt](x6521.r)
              val x6542_rd_en = List[Bool](true.B)
              x6542_rd.toSeq.zip(x4322_img2D_0.connectRPort(6542, x6542_rd_banks, x6542_rd_ofs, io.sigsIn.backpressure, x6542_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6543_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6543_elem_0""")
              x6543_elem_0.r := x6542_rd(0).r
              val x6548_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6548_rd""")
              val x6548_rd_banks = List[UInt](x18884.r)
              val x6548_rd_ofs = List[UInt](x6521.r)
              val x6548_rd_en = List[Bool](true.B)
              x6548_rd.toSeq.zip(x4322_img2D_0.connectRPort(6548, x6548_rd_banks, x6548_rd_ofs, io.sigsIn.backpressure, x6548_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6549_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6549_elem_0""")
              x6549_elem_0.r := x6548_rd(0).r
              val x6554_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6554_rd""")
              val x6554_rd_banks = List[UInt](x18884.r)
              val x6554_rd_ofs = List[UInt](x6521.r)
              val x6554_rd_en = List[Bool](true.B)
              x6554_rd.toSeq.zip(x4322_img2D_0.connectRPort(6554, x6554_rd_banks, x6554_rd_ofs, io.sigsIn.backpressure, x6554_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6555_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6555_elem_0""")
              x6555_elem_0.r := x6554_rd(0).r
              val x6560_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6560_rd""")
              val x6560_rd_banks = List[UInt](x18884.r)
              val x6560_rd_ofs = List[UInt](x6521.r)
              val x6560_rd_en = List[Bool](true.B)
              x6560_rd.toSeq.zip(x4322_img2D_0.connectRPort(6560, x6560_rd_banks, x6560_rd_ofs, io.sigsIn.backpressure, x6560_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6561_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6561_elem_0""")
              x6561_elem_0.r := x6560_rd(0).r
              val x6566_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6566_rd""")
              val x6566_rd_banks = List[UInt](x18884.r)
              val x6566_rd_ofs = List[UInt](x6521.r)
              val x6566_rd_en = List[Bool](true.B)
              x6566_rd.toSeq.zip(x4322_img2D_0.connectRPort(6566, x6566_rd_banks, x6566_rd_ofs, io.sigsIn.backpressure, x6566_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6567_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6567_elem_0""")
              x6567_elem_0.r := x6566_rd(0).r
              val x6572_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6572_rd""")
              val x6572_rd_banks = List[UInt](x18884.r)
              val x6572_rd_ofs = List[UInt](x6521.r)
              val x6572_rd_en = List[Bool](true.B)
              x6572_rd.toSeq.zip(x4322_img2D_0.connectRPort(6572, x6572_rd_banks, x6572_rd_ofs, io.sigsIn.backpressure, x6572_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6573_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6573_elem_0""")
              x6573_elem_0.r := x6572_rd(0).r
              val x6578_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6578_rd""")
              val x6578_rd_banks = List[UInt](x18884.r)
              val x6578_rd_ofs = List[UInt](x6521.r)
              val x6578_rd_en = List[Bool](true.B)
              x6578_rd.toSeq.zip(x4322_img2D_0.connectRPort(6578, x6578_rd_banks, x6578_rd_ofs, io.sigsIn.backpressure, x6578_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6579_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6579_elem_0""")
              x6579_elem_0.r := x6578_rd(0).r
              val x6584_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6584_rd""")
              val x6584_rd_banks = List[UInt](x18884.r)
              val x6584_rd_ofs = List[UInt](x6521.r)
              val x6584_rd_en = List[Bool](true.B)
              x6584_rd.toSeq.zip(x4322_img2D_0.connectRPort(6584, x6584_rd_banks, x6584_rd_ofs, io.sigsIn.backpressure, x6584_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6585_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6585_elem_0""")
              x6585_elem_0.r := x6584_rd(0).r
              val x6590_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6590_rd""")
              val x6590_rd_banks = List[UInt](x18884.r)
              val x6590_rd_ofs = List[UInt](x6521.r)
              val x6590_rd_en = List[Bool](true.B)
              x6590_rd.toSeq.zip(x4322_img2D_0.connectRPort(6590, x6590_rd_banks, x6590_rd_ofs, io.sigsIn.backpressure, x6590_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6591_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6591_elem_0""")
              x6591_elem_0.r := x6590_rd(0).r
              val x6596_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6596_rd""")
              val x6596_rd_banks = List[UInt](x18884.r)
              val x6596_rd_ofs = List[UInt](x6521.r)
              val x6596_rd_en = List[Bool](true.B)
              x6596_rd.toSeq.zip(x4322_img2D_0.connectRPort(6596, x6596_rd_banks, x6596_rd_ofs, io.sigsIn.backpressure, x6596_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6597_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6597_elem_0""")
              x6597_elem_0.r := x6596_rd(0).r
              val x6602_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6602_rd""")
              val x6602_rd_banks = List[UInt](x18884.r)
              val x6602_rd_ofs = List[UInt](x6521.r)
              val x6602_rd_en = List[Bool](true.B)
              x6602_rd.toSeq.zip(x4322_img2D_0.connectRPort(6602, x6602_rd_banks, x6602_rd_ofs, io.sigsIn.backpressure, x6602_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6603_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6603_elem_0""")
              x6603_elem_0.r := x6602_rd(0).r
              val x6608_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6608_rd""")
              val x6608_rd_banks = List[UInt](x18884.r)
              val x6608_rd_ofs = List[UInt](x6521.r)
              val x6608_rd_en = List[Bool](true.B)
              x6608_rd.toSeq.zip(x4322_img2D_0.connectRPort(6608, x6608_rd_banks, x6608_rd_ofs, io.sigsIn.backpressure, x6608_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6609_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6609_elem_0""")
              x6609_elem_0.r := x6608_rd(0).r
              val x6614_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6614_rd""")
              val x6614_rd_banks = List[UInt](x18884.r)
              val x6614_rd_ofs = List[UInt](x6521.r)
              val x6614_rd_en = List[Bool](true.B)
              x6614_rd.toSeq.zip(x4322_img2D_0.connectRPort(6614, x6614_rd_banks, x6614_rd_ofs, io.sigsIn.backpressure, x6614_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6615_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6615_elem_0""")
              x6615_elem_0.r := x6614_rd(0).r
              Map[String,Any]("x6412" -> x6412, "x6413" -> x6413, "x6414" -> x6414, "x6415" -> x6415, "x6416" -> x6416, "x6417" -> x6417, "x6418" -> x6418, "x6419" -> x6419, "x6420" -> x6420, "x6421" -> x6421, "x6422" -> x6422, "x6423" -> x6423, "x6424" -> x6424, "x6456" -> x6456, "x18884" -> x18884, "x6521" -> x6521, "x6525_elem_0" -> x6525_elem_0, "x6531_elem_0" -> x6531_elem_0, "x6537_elem_0" -> x6537_elem_0, "x6543_elem_0" -> x6543_elem_0, "x6549_elem_0" -> x6549_elem_0, "x6555_elem_0" -> x6555_elem_0, "x6561_elem_0" -> x6561_elem_0, "x6567_elem_0" -> x6567_elem_0, "x6573_elem_0" -> x6573_elem_0, "x6579_elem_0" -> x6579_elem_0, "x6585_elem_0" -> x6585_elem_0, "x6591_elem_0" -> x6591_elem_0, "x6597_elem_0" -> x6597_elem_0, "x6603_elem_0" -> x6603_elem_0, "x6609_elem_0" -> x6609_elem_0, "x6615_elem_0" -> x6615_elem_0)
            }
          }
          val block2chunk0sub19: Map[String, Any] = Block2Chunker0Sub19.gen()
          object Block2Chunker0Sub20 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x6620_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6620_rd""")
              val x6620_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6620_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6620_rd_en = List[Bool](true.B)
              x6620_rd.toSeq.zip(x4322_img2D_0.connectRPort(6620, x6620_rd_banks, x6620_rd_ofs, io.sigsIn.backpressure, x6620_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6621_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6621_elem_0""")
              x6621_elem_0.r := x6620_rd(0).r
              val x6626_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6626_rd""")
              val x6626_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6626_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6626_rd_en = List[Bool](true.B)
              x6626_rd.toSeq.zip(x4322_img2D_0.connectRPort(6626, x6626_rd_banks, x6626_rd_ofs, io.sigsIn.backpressure, x6626_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6627_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6627_elem_0""")
              x6627_elem_0.r := x6626_rd(0).r
              val x6632_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6632_rd""")
              val x6632_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6632_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6632_rd_en = List[Bool](true.B)
              x6632_rd.toSeq.zip(x4322_img2D_0.connectRPort(6632, x6632_rd_banks, x6632_rd_ofs, io.sigsIn.backpressure, x6632_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6633_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6633_elem_0""")
              x6633_elem_0.r := x6632_rd(0).r
              val x6638_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6638_rd""")
              val x6638_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6638_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6638_rd_en = List[Bool](true.B)
              x6638_rd.toSeq.zip(x4322_img2D_0.connectRPort(6638, x6638_rd_banks, x6638_rd_ofs, io.sigsIn.backpressure, x6638_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6639_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6639_elem_0""")
              x6639_elem_0.r := x6638_rd(0).r
              val x6644_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6644_rd""")
              val x6644_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6644_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6644_rd_en = List[Bool](true.B)
              x6644_rd.toSeq.zip(x4322_img2D_0.connectRPort(6644, x6644_rd_banks, x6644_rd_ofs, io.sigsIn.backpressure, x6644_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6645_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6645_elem_0""")
              x6645_elem_0.r := x6644_rd(0).r
              val x6650_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6650_rd""")
              val x6650_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6650_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6650_rd_en = List[Bool](true.B)
              x6650_rd.toSeq.zip(x4322_img2D_0.connectRPort(6650, x6650_rd_banks, x6650_rd_ofs, io.sigsIn.backpressure, x6650_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6651_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6651_elem_0""")
              x6651_elem_0.r := x6650_rd(0).r
              val x6656_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6656_rd""")
              val x6656_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6656_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6656_rd_en = List[Bool](true.B)
              x6656_rd.toSeq.zip(x4322_img2D_0.connectRPort(6656, x6656_rd_banks, x6656_rd_ofs, io.sigsIn.backpressure, x6656_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6657_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6657_elem_0""")
              x6657_elem_0.r := x6656_rd(0).r
              val x6662_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6662_rd""")
              val x6662_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6662_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6662_rd_en = List[Bool](true.B)
              x6662_rd.toSeq.zip(x4322_img2D_0.connectRPort(6662, x6662_rd_banks, x6662_rd_ofs, io.sigsIn.backpressure, x6662_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6663_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6663_elem_0""")
              x6663_elem_0.r := x6662_rd(0).r
              val x6668_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6668_rd""")
              val x6668_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6668_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6668_rd_en = List[Bool](true.B)
              x6668_rd.toSeq.zip(x4322_img2D_0.connectRPort(6668, x6668_rd_banks, x6668_rd_ofs, io.sigsIn.backpressure, x6668_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6669_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6669_elem_0""")
              x6669_elem_0.r := x6668_rd(0).r
              val x6674_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6674_rd""")
              val x6674_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6674_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6674_rd_en = List[Bool](true.B)
              x6674_rd.toSeq.zip(x4322_img2D_0.connectRPort(6674, x6674_rd_banks, x6674_rd_ofs, io.sigsIn.backpressure, x6674_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6675_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6675_elem_0""")
              x6675_elem_0.r := x6674_rd(0).r
              val x6680_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6680_rd""")
              val x6680_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6680_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6680_rd_en = List[Bool](true.B)
              x6680_rd.toSeq.zip(x4322_img2D_0.connectRPort(6680, x6680_rd_banks, x6680_rd_ofs, io.sigsIn.backpressure, x6680_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6681_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6681_elem_0""")
              x6681_elem_0.r := x6680_rd(0).r
              val x6686_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6686_rd""")
              val x6686_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6686_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6686_rd_en = List[Bool](true.B)
              x6686_rd.toSeq.zip(x4322_img2D_0.connectRPort(6686, x6686_rd_banks, x6686_rd_ofs, io.sigsIn.backpressure, x6686_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6687_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6687_elem_0""")
              x6687_elem_0.r := x6686_rd(0).r
              val x6692_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6692_rd""")
              val x6692_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6692_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6692_rd_en = List[Bool](true.B)
              x6692_rd.toSeq.zip(x4322_img2D_0.connectRPort(6692, x6692_rd_banks, x6692_rd_ofs, io.sigsIn.backpressure, x6692_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6693_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6693_elem_0""")
              x6693_elem_0.r := x6692_rd(0).r
              val x6698_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6698_rd""")
              val x6698_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6698_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6698_rd_en = List[Bool](true.B)
              x6698_rd.toSeq.zip(x4322_img2D_0.connectRPort(6698, x6698_rd_banks, x6698_rd_ofs, io.sigsIn.backpressure, x6698_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6699_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6699_elem_0""")
              x6699_elem_0.r := x6698_rd(0).r
              val x6704_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6704_rd""")
              val x6704_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6704_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6704_rd_en = List[Bool](true.B)
              x6704_rd.toSeq.zip(x4322_img2D_0.connectRPort(6704, x6704_rd_banks, x6704_rd_ofs, io.sigsIn.backpressure, x6704_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6705_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6705_elem_0""")
              x6705_elem_0.r := x6704_rd(0).r
              val x6710_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6710_rd""")
              val x6710_rd_banks = List[UInt](block2chunk0sub19("x18884").asInstanceOf[FixedPoint].r)
              val x6710_rd_ofs = List[UInt](block2chunk0sub19("x6521").asInstanceOf[FixedPoint].r)
              val x6710_rd_en = List[Bool](true.B)
              x6710_rd.toSeq.zip(x4322_img2D_0.connectRPort(6710, x6710_rd_banks, x6710_rd_ofs, io.sigsIn.backpressure, x6710_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6711_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6711_elem_0""")
              x6711_elem_0.r := x6710_rd(0).r
              val x19773 = Wire(Bool()).suggestName("x19773_x6456_D4") 
              x19773.r := getRetimed(block2chunk0sub19("x6456").asInstanceOf[Bool].r, 4.toInt, io.sigsIn.backpressure)
              val x6712 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6712""")
              x6712.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6525_elem_0").asInstanceOf[FixedPoint].r)
              val x6713 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6713""")
              x6713.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6531_elem_0").asInstanceOf[FixedPoint].r)
              val x6714 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6714""")
              x6714.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6537_elem_0").asInstanceOf[FixedPoint].r)
              val x6715 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6715""")
              x6715.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6543_elem_0").asInstanceOf[FixedPoint].r)
              val x6716 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6716""")
              x6716.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6549_elem_0").asInstanceOf[FixedPoint].r)
              val x6717 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6717""")
              x6717.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6555_elem_0").asInstanceOf[FixedPoint].r)
              val x6718 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6718""")
              x6718.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6561_elem_0").asInstanceOf[FixedPoint].r)
              val x6719 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6719""")
              x6719.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6567_elem_0").asInstanceOf[FixedPoint].r)
              val x6720 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6720""")
              x6720.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6573_elem_0").asInstanceOf[FixedPoint].r)
              val x6721 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6721""")
              x6721.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6579_elem_0").asInstanceOf[FixedPoint].r)
              val x6722 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6722""")
              x6722.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6585_elem_0").asInstanceOf[FixedPoint].r)
              val x6723 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6723""")
              x6723.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6591_elem_0").asInstanceOf[FixedPoint].r)
              val x6724 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6724""")
              x6724.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6597_elem_0").asInstanceOf[FixedPoint].r)
              val x6725 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6725""")
              x6725.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6603_elem_0").asInstanceOf[FixedPoint].r)
              val x6726 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6726""")
              x6726.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6609_elem_0").asInstanceOf[FixedPoint].r)
              val x6727 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6727""")
              x6727.r := Mux((x19773), 0.FP(true, 10, 22).r, block2chunk0sub19("x6615_elem_0").asInstanceOf[FixedPoint].r)
              Map[String,Any]("x6621_elem_0" -> x6621_elem_0, "x6627_elem_0" -> x6627_elem_0, "x6633_elem_0" -> x6633_elem_0, "x6639_elem_0" -> x6639_elem_0, "x6645_elem_0" -> x6645_elem_0, "x6651_elem_0" -> x6651_elem_0, "x6657_elem_0" -> x6657_elem_0, "x6663_elem_0" -> x6663_elem_0, "x6669_elem_0" -> x6669_elem_0, "x6675_elem_0" -> x6675_elem_0, "x6681_elem_0" -> x6681_elem_0, "x6687_elem_0" -> x6687_elem_0, "x6693_elem_0" -> x6693_elem_0, "x6699_elem_0" -> x6699_elem_0, "x6705_elem_0" -> x6705_elem_0, "x6711_elem_0" -> x6711_elem_0, "x19773" -> x19773, "x6712" -> x6712, "x6713" -> x6713, "x6714" -> x6714, "x6715" -> x6715, "x6716" -> x6716, "x6717" -> x6717, "x6718" -> x6718, "x6719" -> x6719, "x6720" -> x6720, "x6721" -> x6721, "x6722" -> x6722, "x6723" -> x6723, "x6724" -> x6724, "x6725" -> x6725, "x6726" -> x6726, "x6727" -> x6727)
            }
          }
          val block2chunk0sub20: Map[String, Any] = Block2Chunker0Sub20.gen()
          object Block2Chunker0Sub21 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x6728 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6728""")
              x6728.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6621_elem_0").asInstanceOf[FixedPoint].r)
              val x6729 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6729""")
              x6729.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6627_elem_0").asInstanceOf[FixedPoint].r)
              val x6730 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6730""")
              x6730.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6633_elem_0").asInstanceOf[FixedPoint].r)
              val x6731 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6731""")
              x6731.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6639_elem_0").asInstanceOf[FixedPoint].r)
              val x6732 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6732""")
              x6732.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6645_elem_0").asInstanceOf[FixedPoint].r)
              val x6733 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6733""")
              x6733.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6651_elem_0").asInstanceOf[FixedPoint].r)
              val x6734 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6734""")
              x6734.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6657_elem_0").asInstanceOf[FixedPoint].r)
              val x6735 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6735""")
              x6735.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6663_elem_0").asInstanceOf[FixedPoint].r)
              val x6736 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6736""")
              x6736.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6669_elem_0").asInstanceOf[FixedPoint].r)
              val x6737 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6737""")
              x6737.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6675_elem_0").asInstanceOf[FixedPoint].r)
              val x6738 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6738""")
              x6738.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6681_elem_0").asInstanceOf[FixedPoint].r)
              val x6739 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6739""")
              x6739.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6687_elem_0").asInstanceOf[FixedPoint].r)
              val x6740 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6740""")
              x6740.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6693_elem_0").asInstanceOf[FixedPoint].r)
              val x6741 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6741""")
              x6741.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6699_elem_0").asInstanceOf[FixedPoint].r)
              val x6742 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6742""")
              x6742.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6705_elem_0").asInstanceOf[FixedPoint].r)
              val x6743 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6743""")
              x6743.r := Mux((block2chunk0sub20("x19773").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub20("x6711_elem_0").asInstanceOf[FixedPoint].r)
              val x6744_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x6744_mul""")
              x6744_mul.r := (Math.mul(block2chunk0sub14("x5719").asInstanceOf[FixedPoint], block2chunk0sub0("x4973_rd_x3938").asInstanceOf[FixedPoint], Some(6.0), true.B, Truncate, Wrapping, "x6744_mul")).r
              val x6776_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x6776_sub""")
              x6776_sub.r := Math.sub(x6744_mul,1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x6776_sub").r
              val x6808_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x6808_sum""")
              x6808_sum.r := Math.add(x6776_sub,block2chunk0sub17("x19734").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x6808_sum").r
              val x18885 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18885""")
              x18885.r := Math.and(x6808_sum,3L.FP(true, 32, 0),Some(0.2), true.B,"x18885").r
              val x6841 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x6841""")
              x6841.r := Math.arith_right_shift(x6808_sum, 2, Some(0.2), true.B,"x6841").r
              val x6844_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6844_rd""")
              val x6844_rd_banks = List[UInt](x18885.r)
              val x6844_rd_ofs = List[UInt](x6841.r)
              val x6844_rd_en = List[Bool](true.B)
              x6844_rd.toSeq.zip(x4327_img2D_5.connectRPort(6844, x6844_rd_banks, x6844_rd_ofs, io.sigsIn.backpressure, x6844_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19736").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6845_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6845_elem_0""")
              x6845_elem_0.r := x6844_rd(0).r
              val x6850_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6850_rd""")
              val x6850_rd_banks = List[UInt](x18885.r)
              val x6850_rd_ofs = List[UInt](x6841.r)
              val x6850_rd_en = List[Bool](true.B)
              x6850_rd.toSeq.zip(x4327_img2D_5.connectRPort(6850, x6850_rd_banks, x6850_rd_ofs, io.sigsIn.backpressure, x6850_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6851_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6851_elem_0""")
              x6851_elem_0.r := x6850_rd(0).r
              val x6856_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6856_rd""")
              val x6856_rd_banks = List[UInt](x18885.r)
              val x6856_rd_ofs = List[UInt](x6841.r)
              val x6856_rd_en = List[Bool](true.B)
              x6856_rd.toSeq.zip(x4327_img2D_5.connectRPort(6856, x6856_rd_banks, x6856_rd_ofs, io.sigsIn.backpressure, x6856_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6857_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6857_elem_0""")
              x6857_elem_0.r := x6856_rd(0).r
              val x6862_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6862_rd""")
              val x6862_rd_banks = List[UInt](x18885.r)
              val x6862_rd_ofs = List[UInt](x6841.r)
              val x6862_rd_en = List[Bool](true.B)
              x6862_rd.toSeq.zip(x4327_img2D_5.connectRPort(6862, x6862_rd_banks, x6862_rd_ofs, io.sigsIn.backpressure, x6862_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6863_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6863_elem_0""")
              x6863_elem_0.r := x6862_rd(0).r
              val x6868_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6868_rd""")
              val x6868_rd_banks = List[UInt](x18885.r)
              val x6868_rd_ofs = List[UInt](x6841.r)
              val x6868_rd_en = List[Bool](true.B)
              x6868_rd.toSeq.zip(x4327_img2D_5.connectRPort(6868, x6868_rd_banks, x6868_rd_ofs, io.sigsIn.backpressure, x6868_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6869_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6869_elem_0""")
              x6869_elem_0.r := x6868_rd(0).r
              val x6874_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6874_rd""")
              val x6874_rd_banks = List[UInt](x18885.r)
              val x6874_rd_ofs = List[UInt](x6841.r)
              val x6874_rd_en = List[Bool](true.B)
              x6874_rd.toSeq.zip(x4327_img2D_5.connectRPort(6874, x6874_rd_banks, x6874_rd_ofs, io.sigsIn.backpressure, x6874_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6875_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6875_elem_0""")
              x6875_elem_0.r := x6874_rd(0).r
              val x6880_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6880_rd""")
              val x6880_rd_banks = List[UInt](x18885.r)
              val x6880_rd_ofs = List[UInt](x6841.r)
              val x6880_rd_en = List[Bool](true.B)
              x6880_rd.toSeq.zip(x4327_img2D_5.connectRPort(6880, x6880_rd_banks, x6880_rd_ofs, io.sigsIn.backpressure, x6880_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6881_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6881_elem_0""")
              x6881_elem_0.r := x6880_rd(0).r
              val x6886_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6886_rd""")
              val x6886_rd_banks = List[UInt](x18885.r)
              val x6886_rd_ofs = List[UInt](x6841.r)
              val x6886_rd_en = List[Bool](true.B)
              x6886_rd.toSeq.zip(x4327_img2D_5.connectRPort(6886, x6886_rd_banks, x6886_rd_ofs, io.sigsIn.backpressure, x6886_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6887_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6887_elem_0""")
              x6887_elem_0.r := x6886_rd(0).r
              val x6892_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6892_rd""")
              val x6892_rd_banks = List[UInt](x18885.r)
              val x6892_rd_ofs = List[UInt](x6841.r)
              val x6892_rd_en = List[Bool](true.B)
              x6892_rd.toSeq.zip(x4327_img2D_5.connectRPort(6892, x6892_rd_banks, x6892_rd_ofs, io.sigsIn.backpressure, x6892_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6893_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6893_elem_0""")
              x6893_elem_0.r := x6892_rd(0).r
              val x6898_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6898_rd""")
              val x6898_rd_banks = List[UInt](x18885.r)
              val x6898_rd_ofs = List[UInt](x6841.r)
              val x6898_rd_en = List[Bool](true.B)
              x6898_rd.toSeq.zip(x4327_img2D_5.connectRPort(6898, x6898_rd_banks, x6898_rd_ofs, io.sigsIn.backpressure, x6898_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6899_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6899_elem_0""")
              x6899_elem_0.r := x6898_rd(0).r
              val x6904_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6904_rd""")
              val x6904_rd_banks = List[UInt](x18885.r)
              val x6904_rd_ofs = List[UInt](x6841.r)
              val x6904_rd_en = List[Bool](true.B)
              x6904_rd.toSeq.zip(x4327_img2D_5.connectRPort(6904, x6904_rd_banks, x6904_rd_ofs, io.sigsIn.backpressure, x6904_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6905_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6905_elem_0""")
              x6905_elem_0.r := x6904_rd(0).r
              val x6910_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6910_rd""")
              val x6910_rd_banks = List[UInt](x18885.r)
              val x6910_rd_ofs = List[UInt](x6841.r)
              val x6910_rd_en = List[Bool](true.B)
              x6910_rd.toSeq.zip(x4327_img2D_5.connectRPort(6910, x6910_rd_banks, x6910_rd_ofs, io.sigsIn.backpressure, x6910_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6911_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6911_elem_0""")
              x6911_elem_0.r := x6910_rd(0).r
              val x6916_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6916_rd""")
              val x6916_rd_banks = List[UInt](x18885.r)
              val x6916_rd_ofs = List[UInt](x6841.r)
              val x6916_rd_en = List[Bool](true.B)
              x6916_rd.toSeq.zip(x4327_img2D_5.connectRPort(6916, x6916_rd_banks, x6916_rd_ofs, io.sigsIn.backpressure, x6916_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6917_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6917_elem_0""")
              x6917_elem_0.r := x6916_rd(0).r
              val x6922_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6922_rd""")
              val x6922_rd_banks = List[UInt](x18885.r)
              val x6922_rd_ofs = List[UInt](x6841.r)
              val x6922_rd_en = List[Bool](true.B)
              x6922_rd.toSeq.zip(x4327_img2D_5.connectRPort(6922, x6922_rd_banks, x6922_rd_ofs, io.sigsIn.backpressure, x6922_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6923_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6923_elem_0""")
              x6923_elem_0.r := x6922_rd(0).r
              Map[String,Any]("x6728" -> x6728, "x6729" -> x6729, "x6730" -> x6730, "x6731" -> x6731, "x6732" -> x6732, "x6733" -> x6733, "x6734" -> x6734, "x6735" -> x6735, "x6736" -> x6736, "x6737" -> x6737, "x6738" -> x6738, "x6739" -> x6739, "x6740" -> x6740, "x6741" -> x6741, "x6742" -> x6742, "x6743" -> x6743, "x6744_mul" -> x6744_mul, "x18885" -> x18885, "x6841" -> x6841, "x6845_elem_0" -> x6845_elem_0, "x6851_elem_0" -> x6851_elem_0, "x6857_elem_0" -> x6857_elem_0, "x6863_elem_0" -> x6863_elem_0, "x6869_elem_0" -> x6869_elem_0, "x6875_elem_0" -> x6875_elem_0, "x6881_elem_0" -> x6881_elem_0, "x6887_elem_0" -> x6887_elem_0, "x6893_elem_0" -> x6893_elem_0, "x6899_elem_0" -> x6899_elem_0, "x6905_elem_0" -> x6905_elem_0, "x6911_elem_0" -> x6911_elem_0, "x6917_elem_0" -> x6917_elem_0, "x6923_elem_0" -> x6923_elem_0)
            }
          }
          val block2chunk0sub21: Map[String, Any] = Block2Chunker0Sub21.gen()
          object Block2Chunker0Sub22 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x6928_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6928_rd""")
              val x6928_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6928_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6928_rd_en = List[Bool](true.B)
              x6928_rd.toSeq.zip(x4327_img2D_5.connectRPort(6928, x6928_rd_banks, x6928_rd_ofs, io.sigsIn.backpressure, x6928_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6929_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6929_elem_0""")
              x6929_elem_0.r := x6928_rd(0).r
              val x6934_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6934_rd""")
              val x6934_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6934_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6934_rd_en = List[Bool](true.B)
              x6934_rd.toSeq.zip(x4327_img2D_5.connectRPort(6934, x6934_rd_banks, x6934_rd_ofs, io.sigsIn.backpressure, x6934_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6935_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6935_elem_0""")
              x6935_elem_0.r := x6934_rd(0).r
              val x6940_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6940_rd""")
              val x6940_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6940_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6940_rd_en = List[Bool](true.B)
              x6940_rd.toSeq.zip(x4327_img2D_5.connectRPort(6940, x6940_rd_banks, x6940_rd_ofs, io.sigsIn.backpressure, x6940_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6941_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6941_elem_0""")
              x6941_elem_0.r := x6940_rd(0).r
              val x6946_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6946_rd""")
              val x6946_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6946_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6946_rd_en = List[Bool](true.B)
              x6946_rd.toSeq.zip(x4327_img2D_5.connectRPort(6946, x6946_rd_banks, x6946_rd_ofs, io.sigsIn.backpressure, x6946_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6947_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6947_elem_0""")
              x6947_elem_0.r := x6946_rd(0).r
              val x6952_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6952_rd""")
              val x6952_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6952_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6952_rd_en = List[Bool](true.B)
              x6952_rd.toSeq.zip(x4327_img2D_5.connectRPort(6952, x6952_rd_banks, x6952_rd_ofs, io.sigsIn.backpressure, x6952_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6953_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6953_elem_0""")
              x6953_elem_0.r := x6952_rd(0).r
              val x6958_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6958_rd""")
              val x6958_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6958_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6958_rd_en = List[Bool](true.B)
              x6958_rd.toSeq.zip(x4327_img2D_5.connectRPort(6958, x6958_rd_banks, x6958_rd_ofs, io.sigsIn.backpressure, x6958_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6959_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6959_elem_0""")
              x6959_elem_0.r := x6958_rd(0).r
              val x6964_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6964_rd""")
              val x6964_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6964_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6964_rd_en = List[Bool](true.B)
              x6964_rd.toSeq.zip(x4327_img2D_5.connectRPort(6964, x6964_rd_banks, x6964_rd_ofs, io.sigsIn.backpressure, x6964_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6965_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6965_elem_0""")
              x6965_elem_0.r := x6964_rd(0).r
              val x6970_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6970_rd""")
              val x6970_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6970_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6970_rd_en = List[Bool](true.B)
              x6970_rd.toSeq.zip(x4327_img2D_5.connectRPort(6970, x6970_rd_banks, x6970_rd_ofs, io.sigsIn.backpressure, x6970_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6971_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6971_elem_0""")
              x6971_elem_0.r := x6970_rd(0).r
              val x6976_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6976_rd""")
              val x6976_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6976_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6976_rd_en = List[Bool](true.B)
              x6976_rd.toSeq.zip(x4327_img2D_5.connectRPort(6976, x6976_rd_banks, x6976_rd_ofs, io.sigsIn.backpressure, x6976_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6977_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6977_elem_0""")
              x6977_elem_0.r := x6976_rd(0).r
              val x6982_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6982_rd""")
              val x6982_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6982_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6982_rd_en = List[Bool](true.B)
              x6982_rd.toSeq.zip(x4327_img2D_5.connectRPort(6982, x6982_rd_banks, x6982_rd_ofs, io.sigsIn.backpressure, x6982_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6983_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6983_elem_0""")
              x6983_elem_0.r := x6982_rd(0).r
              val x6988_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6988_rd""")
              val x6988_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6988_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6988_rd_en = List[Bool](true.B)
              x6988_rd.toSeq.zip(x4327_img2D_5.connectRPort(6988, x6988_rd_banks, x6988_rd_ofs, io.sigsIn.backpressure, x6988_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6989_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6989_elem_0""")
              x6989_elem_0.r := x6988_rd(0).r
              val x6994_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x6994_rd""")
              val x6994_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x6994_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x6994_rd_en = List[Bool](true.B)
              x6994_rd.toSeq.zip(x4327_img2D_5.connectRPort(6994, x6994_rd_banks, x6994_rd_ofs, io.sigsIn.backpressure, x6994_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x6995_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x6995_elem_0""")
              x6995_elem_0.r := x6994_rd(0).r
              val x7000_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7000_rd""")
              val x7000_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x7000_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x7000_rd_en = List[Bool](true.B)
              x7000_rd.toSeq.zip(x4327_img2D_5.connectRPort(7000, x7000_rd_banks, x7000_rd_ofs, io.sigsIn.backpressure, x7000_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7001_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7001_elem_0""")
              x7001_elem_0.r := x7000_rd(0).r
              val x7006_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7006_rd""")
              val x7006_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x7006_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x7006_rd_en = List[Bool](true.B)
              x7006_rd.toSeq.zip(x4327_img2D_5.connectRPort(7006, x7006_rd_banks, x7006_rd_ofs, io.sigsIn.backpressure, x7006_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7007_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7007_elem_0""")
              x7007_elem_0.r := x7006_rd(0).r
              val x7012_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7012_rd""")
              val x7012_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x7012_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x7012_rd_en = List[Bool](true.B)
              x7012_rd.toSeq.zip(x4327_img2D_5.connectRPort(7012, x7012_rd_banks, x7012_rd_ofs, io.sigsIn.backpressure, x7012_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7013_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7013_elem_0""")
              x7013_elem_0.r := x7012_rd(0).r
              val x7018_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7018_rd""")
              val x7018_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x7018_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x7018_rd_en = List[Bool](true.B)
              x7018_rd.toSeq.zip(x4327_img2D_5.connectRPort(7018, x7018_rd_banks, x7018_rd_ofs, io.sigsIn.backpressure, x7018_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7019_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7019_elem_0""")
              x7019_elem_0.r := x7018_rd(0).r
              val x7024_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7024_rd""")
              val x7024_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x7024_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x7024_rd_en = List[Bool](true.B)
              x7024_rd.toSeq.zip(x4327_img2D_5.connectRPort(7024, x7024_rd_banks, x7024_rd_ofs, io.sigsIn.backpressure, x7024_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7025_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7025_elem_0""")
              x7025_elem_0.r := x7024_rd(0).r
              val x7030_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7030_rd""")
              val x7030_rd_banks = List[UInt](block2chunk0sub21("x18885").asInstanceOf[FixedPoint].r)
              val x7030_rd_ofs = List[UInt](block2chunk0sub21("x6841").asInstanceOf[FixedPoint].r)
              val x7030_rd_en = List[Bool](true.B)
              x7030_rd.toSeq.zip(x4327_img2D_5.connectRPort(7030, x7030_rd_banks, x7030_rd_ofs, io.sigsIn.backpressure, x7030_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7031_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7031_elem_0""")
              x7031_elem_0.r := x7030_rd(0).r
              val x19774 = Wire(Bool()).suggestName("x19774_x5622_D3") 
              x19774.r := getRetimed(block2chunk0sub14("x5622").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
              val x7032 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7032""")
              x7032.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6845_elem_0").asInstanceOf[FixedPoint].r)
              val x7033 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7033""")
              x7033.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6851_elem_0").asInstanceOf[FixedPoint].r)
              val x7034 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7034""")
              x7034.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6857_elem_0").asInstanceOf[FixedPoint].r)
              val x7035 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7035""")
              x7035.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6863_elem_0").asInstanceOf[FixedPoint].r)
              val x7036 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7036""")
              x7036.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6869_elem_0").asInstanceOf[FixedPoint].r)
              val x7037 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7037""")
              x7037.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6875_elem_0").asInstanceOf[FixedPoint].r)
              val x7038 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7038""")
              x7038.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6881_elem_0").asInstanceOf[FixedPoint].r)
              val x7039 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7039""")
              x7039.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6887_elem_0").asInstanceOf[FixedPoint].r)
              val x7040 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7040""")
              x7040.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6893_elem_0").asInstanceOf[FixedPoint].r)
              val x7041 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7041""")
              x7041.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6899_elem_0").asInstanceOf[FixedPoint].r)
              val x7042 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7042""")
              x7042.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6905_elem_0").asInstanceOf[FixedPoint].r)
              val x7043 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7043""")
              x7043.r := Mux((x19774), 0.FP(true, 10, 22).r, block2chunk0sub21("x6911_elem_0").asInstanceOf[FixedPoint].r)
              Map[String,Any]("x6929_elem_0" -> x6929_elem_0, "x6935_elem_0" -> x6935_elem_0, "x6941_elem_0" -> x6941_elem_0, "x6947_elem_0" -> x6947_elem_0, "x6953_elem_0" -> x6953_elem_0, "x6959_elem_0" -> x6959_elem_0, "x6965_elem_0" -> x6965_elem_0, "x6971_elem_0" -> x6971_elem_0, "x6977_elem_0" -> x6977_elem_0, "x6983_elem_0" -> x6983_elem_0, "x6989_elem_0" -> x6989_elem_0, "x6995_elem_0" -> x6995_elem_0, "x7001_elem_0" -> x7001_elem_0, "x7007_elem_0" -> x7007_elem_0, "x7013_elem_0" -> x7013_elem_0, "x7019_elem_0" -> x7019_elem_0, "x7025_elem_0" -> x7025_elem_0, "x7031_elem_0" -> x7031_elem_0, "x19774" -> x19774, "x7032" -> x7032, "x7033" -> x7033, "x7034" -> x7034, "x7035" -> x7035, "x7036" -> x7036, "x7037" -> x7037, "x7038" -> x7038, "x7039" -> x7039, "x7040" -> x7040, "x7041" -> x7041, "x7042" -> x7042, "x7043" -> x7043)
            }
          }
          val block2chunk0sub22: Map[String, Any] = Block2Chunker0Sub22.gen()
          object Block2Chunker0Sub23 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x7044 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7044""")
              x7044.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub21("x6917_elem_0").asInstanceOf[FixedPoint].r)
              val x7045 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7045""")
              x7045.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub21("x6923_elem_0").asInstanceOf[FixedPoint].r)
              val x7046 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7046""")
              x7046.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6929_elem_0").asInstanceOf[FixedPoint].r)
              val x7047 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7047""")
              x7047.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6935_elem_0").asInstanceOf[FixedPoint].r)
              val x7048 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7048""")
              x7048.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6941_elem_0").asInstanceOf[FixedPoint].r)
              val x7049 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7049""")
              x7049.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6947_elem_0").asInstanceOf[FixedPoint].r)
              val x7050 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7050""")
              x7050.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6953_elem_0").asInstanceOf[FixedPoint].r)
              val x7051 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7051""")
              x7051.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6959_elem_0").asInstanceOf[FixedPoint].r)
              val x7052 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7052""")
              x7052.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6965_elem_0").asInstanceOf[FixedPoint].r)
              val x7053 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7053""")
              x7053.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6971_elem_0").asInstanceOf[FixedPoint].r)
              val x7054 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7054""")
              x7054.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6977_elem_0").asInstanceOf[FixedPoint].r)
              val x7055 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7055""")
              x7055.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6983_elem_0").asInstanceOf[FixedPoint].r)
              val x7056 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7056""")
              x7056.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6989_elem_0").asInstanceOf[FixedPoint].r)
              val x7057 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7057""")
              x7057.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x6995_elem_0").asInstanceOf[FixedPoint].r)
              val x7058 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7058""")
              x7058.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x7001_elem_0").asInstanceOf[FixedPoint].r)
              val x7059 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7059""")
              x7059.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x7007_elem_0").asInstanceOf[FixedPoint].r)
              val x7060 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7060""")
              x7060.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x7013_elem_0").asInstanceOf[FixedPoint].r)
              val x7061 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7061""")
              x7061.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x7019_elem_0").asInstanceOf[FixedPoint].r)
              val x7062 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7062""")
              x7062.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x7025_elem_0").asInstanceOf[FixedPoint].r)
              val x7063 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7063""")
              x7063.r := Mux((block2chunk0sub22("x19774").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub22("x7031_elem_0").asInstanceOf[FixedPoint].r)
              val x7064_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7064_sum""")
              x7064_sum.r := Math.add(block2chunk0sub21("x6744_mul").asInstanceOf[FixedPoint],1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x7064_sum").r
              val x19775 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19775_x5848_D6") 
              x19775.r := getRetimed(block2chunk0sub14("x5848").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x7096_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7096_sum""")
              x7096_sum.r := Math.add(block2chunk0sub21("x6744_mul").asInstanceOf[FixedPoint],x19775,Some(1.0), true.B, Truncate, Wrapping, "x7096_sum").r
              val x18886 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18886""")
              x18886.r := Math.and(x7096_sum,3L.FP(true, 32, 0),Some(0.2), true.B,"x18886").r
              val x7129 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7129""")
              x7129.r := Math.arith_right_shift(x7096_sum, 2, Some(0.2), true.B,"x7129").r
              val x19776 = Wire(Bool()).suggestName("x19776_b4492_D7") 
              x19776.r := getRetimed(b4492.r, 7.toInt, io.sigsIn.backpressure)
              val x19777 = Wire(Bool()).suggestName("x19777_b4493_D7") 
              x19777.r := getRetimed(b4493.r, 7.toInt, io.sigsIn.backpressure)
              val x19778 = Wire(Bool()).suggestName("x19778_b4068_D7") 
              x19778.r := getRetimed(b4068.r, 7.toInt, io.sigsIn.backpressure)
              val x19779 = Wire(Bool()).suggestName("x19779_b4060_D7") 
              x19779.r := getRetimed(b4060.r, 7.toInt, io.sigsIn.backpressure)
              val x19780 = Wire(Bool()).suggestName("x19780_x5133_rd_x3918_D7") 
              x19780.r := getRetimed(block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool].r, 7.toInt, io.sigsIn.backpressure)
              val x19781 = Wire(Bool()).suggestName("x19781_b4491_D7") 
              x19781.r := getRetimed(b4491.r, 7.toInt, io.sigsIn.backpressure)
              val x7132_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7132_rd""")
              val x7132_rd_banks = List[UInt](x18886.r)
              val x7132_rd_ofs = List[UInt](x7129.r)
              val x7132_rd_en = List[Bool](true.B)
              x7132_rd.toSeq.zip(x4328_img2D_6.connectRPort(7132, x7132_rd_banks, x7132_rd_ofs, io.sigsIn.backpressure, x7132_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && x19780 & x19777 & x19778 & x19779 & x19781 & x19776), false)).foreach{case (a,b) => a := b}
              val x7133_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7133_elem_0""")
              x7133_elem_0.r := x7132_rd(0).r
              val x7138_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7138_rd""")
              val x7138_rd_banks = List[UInt](x18886.r)
              val x7138_rd_ofs = List[UInt](x7129.r)
              val x7138_rd_en = List[Bool](true.B)
              x7138_rd.toSeq.zip(x4328_img2D_6.connectRPort(7138, x7138_rd_banks, x7138_rd_ofs, io.sigsIn.backpressure, x7138_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && x19780 & x19778 & x19779 & x19781 & x19776), false)).foreach{case (a,b) => a := b}
              val x7139_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7139_elem_0""")
              x7139_elem_0.r := x7138_rd(0).r
              val x7144_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7144_rd""")
              val x7144_rd_banks = List[UInt](x18886.r)
              val x7144_rd_ofs = List[UInt](x7129.r)
              val x7144_rd_en = List[Bool](true.B)
              x7144_rd.toSeq.zip(x4328_img2D_6.connectRPort(7144, x7144_rd_banks, x7144_rd_ofs, io.sigsIn.backpressure, x7144_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && x19780 & x19778 & x19779 & x19781 & x19776), false)).foreach{case (a,b) => a := b}
              val x7145_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7145_elem_0""")
              x7145_elem_0.r := x7144_rd(0).r
              val x7150_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7150_rd""")
              val x7150_rd_banks = List[UInt](x18886.r)
              val x7150_rd_ofs = List[UInt](x7129.r)
              val x7150_rd_en = List[Bool](true.B)
              x7150_rd.toSeq.zip(x4328_img2D_6.connectRPort(7150, x7150_rd_banks, x7150_rd_ofs, io.sigsIn.backpressure, x7150_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && x19780 & x19778 & x19779 & x19781 & x19776), false)).foreach{case (a,b) => a := b}
              val x7151_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7151_elem_0""")
              x7151_elem_0.r := x7150_rd(0).r
              val x7156_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7156_rd""")
              val x7156_rd_banks = List[UInt](x18886.r)
              val x7156_rd_ofs = List[UInt](x7129.r)
              val x7156_rd_en = List[Bool](true.B)
              x7156_rd.toSeq.zip(x4328_img2D_6.connectRPort(7156, x7156_rd_banks, x7156_rd_ofs, io.sigsIn.backpressure, x7156_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && x19780 & x19778 & x19779 & x19781 & x19776), false)).foreach{case (a,b) => a := b}
              val x7157_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7157_elem_0""")
              x7157_elem_0.r := x7156_rd(0).r
              val x7162_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7162_rd""")
              val x7162_rd_banks = List[UInt](x18886.r)
              val x7162_rd_ofs = List[UInt](x7129.r)
              val x7162_rd_en = List[Bool](true.B)
              x7162_rd.toSeq.zip(x4328_img2D_6.connectRPort(7162, x7162_rd_banks, x7162_rd_ofs, io.sigsIn.backpressure, x7162_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && x19780 & x19778 & x19779 & x19781 & x19776), false)).foreach{case (a,b) => a := b}
              val x7163_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7163_elem_0""")
              x7163_elem_0.r := x7162_rd(0).r
              val x7168_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7168_rd""")
              val x7168_rd_banks = List[UInt](x18886.r)
              val x7168_rd_ofs = List[UInt](x7129.r)
              val x7168_rd_en = List[Bool](true.B)
              x7168_rd.toSeq.zip(x4328_img2D_6.connectRPort(7168, x7168_rd_banks, x7168_rd_ofs, io.sigsIn.backpressure, x7168_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && x19780 & x19778 & x19779 & x19781 & x19776), false)).foreach{case (a,b) => a := b}
              val x7169_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7169_elem_0""")
              x7169_elem_0.r := x7168_rd(0).r
              val x7174_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7174_rd""")
              val x7174_rd_banks = List[UInt](x18886.r)
              val x7174_rd_ofs = List[UInt](x7129.r)
              val x7174_rd_en = List[Bool](true.B)
              x7174_rd.toSeq.zip(x4328_img2D_6.connectRPort(7174, x7174_rd_banks, x7174_rd_ofs, io.sigsIn.backpressure, x7174_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && x19780 & x19778 & x19779 & x19781 & x19776), false)).foreach{case (a,b) => a := b}
              val x7175_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7175_elem_0""")
              x7175_elem_0.r := x7174_rd(0).r
              val x7180_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7180_rd""")
              val x7180_rd_banks = List[UInt](x18886.r)
              val x7180_rd_ofs = List[UInt](x7129.r)
              val x7180_rd_en = List[Bool](true.B)
              x7180_rd.toSeq.zip(x4328_img2D_6.connectRPort(7180, x7180_rd_banks, x7180_rd_ofs, io.sigsIn.backpressure, x7180_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && x19780 & x19778 & x19779 & x19781 & x19776), false)).foreach{case (a,b) => a := b}
              val x7181_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7181_elem_0""")
              x7181_elem_0.r := x7180_rd(0).r
              Map[String,Any]("x7044" -> x7044, "x7045" -> x7045, "x7046" -> x7046, "x7047" -> x7047, "x7048" -> x7048, "x7049" -> x7049, "x7050" -> x7050, "x7051" -> x7051, "x7052" -> x7052, "x7053" -> x7053, "x7054" -> x7054, "x7055" -> x7055, "x7056" -> x7056, "x7057" -> x7057, "x7058" -> x7058, "x7059" -> x7059, "x7060" -> x7060, "x7061" -> x7061, "x7062" -> x7062, "x7063" -> x7063, "x7064_sum" -> x7064_sum, "x18886" -> x18886, "x7129" -> x7129, "x19776" -> x19776, "x19778" -> x19778, "x19779" -> x19779, "x19780" -> x19780, "x19781" -> x19781, "x7133_elem_0" -> x7133_elem_0, "x7139_elem_0" -> x7139_elem_0, "x7145_elem_0" -> x7145_elem_0, "x7151_elem_0" -> x7151_elem_0, "x7157_elem_0" -> x7157_elem_0, "x7163_elem_0" -> x7163_elem_0, "x7169_elem_0" -> x7169_elem_0, "x7175_elem_0" -> x7175_elem_0, "x7181_elem_0" -> x7181_elem_0)
            }
          }
          val block2chunk0sub23: Map[String, Any] = Block2Chunker0Sub23.gen()
          object Block2Chunker0Sub24 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x7186_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7186_rd""")
              val x7186_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7186_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7186_rd_en = List[Bool](true.B)
              x7186_rd.toSeq.zip(x4328_img2D_6.connectRPort(7186, x7186_rd_banks, x7186_rd_ofs, io.sigsIn.backpressure, x7186_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7187_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7187_elem_0""")
              x7187_elem_0.r := x7186_rd(0).r
              val x7192_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7192_rd""")
              val x7192_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7192_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7192_rd_en = List[Bool](true.B)
              x7192_rd.toSeq.zip(x4328_img2D_6.connectRPort(7192, x7192_rd_banks, x7192_rd_ofs, io.sigsIn.backpressure, x7192_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7193_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7193_elem_0""")
              x7193_elem_0.r := x7192_rd(0).r
              val x7198_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7198_rd""")
              val x7198_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7198_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7198_rd_en = List[Bool](true.B)
              x7198_rd.toSeq.zip(x4328_img2D_6.connectRPort(7198, x7198_rd_banks, x7198_rd_ofs, io.sigsIn.backpressure, x7198_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7199_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7199_elem_0""")
              x7199_elem_0.r := x7198_rd(0).r
              val x7204_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7204_rd""")
              val x7204_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7204_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7204_rd_en = List[Bool](true.B)
              x7204_rd.toSeq.zip(x4328_img2D_6.connectRPort(7204, x7204_rd_banks, x7204_rd_ofs, io.sigsIn.backpressure, x7204_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7205_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7205_elem_0""")
              x7205_elem_0.r := x7204_rd(0).r
              val x7210_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7210_rd""")
              val x7210_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7210_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7210_rd_en = List[Bool](true.B)
              x7210_rd.toSeq.zip(x4328_img2D_6.connectRPort(7210, x7210_rd_banks, x7210_rd_ofs, io.sigsIn.backpressure, x7210_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7211_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7211_elem_0""")
              x7211_elem_0.r := x7210_rd(0).r
              val x7216_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7216_rd""")
              val x7216_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7216_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7216_rd_en = List[Bool](true.B)
              x7216_rd.toSeq.zip(x4328_img2D_6.connectRPort(7216, x7216_rd_banks, x7216_rd_ofs, io.sigsIn.backpressure, x7216_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7217_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7217_elem_0""")
              x7217_elem_0.r := x7216_rd(0).r
              val x7222_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7222_rd""")
              val x7222_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7222_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7222_rd_en = List[Bool](true.B)
              x7222_rd.toSeq.zip(x4328_img2D_6.connectRPort(7222, x7222_rd_banks, x7222_rd_ofs, io.sigsIn.backpressure, x7222_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7223_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7223_elem_0""")
              x7223_elem_0.r := x7222_rd(0).r
              val x7228_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7228_rd""")
              val x7228_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7228_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7228_rd_en = List[Bool](true.B)
              x7228_rd.toSeq.zip(x4328_img2D_6.connectRPort(7228, x7228_rd_banks, x7228_rd_ofs, io.sigsIn.backpressure, x7228_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7229_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7229_elem_0""")
              x7229_elem_0.r := x7228_rd(0).r
              val x7234_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7234_rd""")
              val x7234_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7234_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7234_rd_en = List[Bool](true.B)
              x7234_rd.toSeq.zip(x4328_img2D_6.connectRPort(7234, x7234_rd_banks, x7234_rd_ofs, io.sigsIn.backpressure, x7234_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7235_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7235_elem_0""")
              x7235_elem_0.r := x7234_rd(0).r
              val x7240_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7240_rd""")
              val x7240_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7240_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7240_rd_en = List[Bool](true.B)
              x7240_rd.toSeq.zip(x4328_img2D_6.connectRPort(7240, x7240_rd_banks, x7240_rd_ofs, io.sigsIn.backpressure, x7240_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7241_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7241_elem_0""")
              x7241_elem_0.r := x7240_rd(0).r
              val x7246_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7246_rd""")
              val x7246_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7246_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7246_rd_en = List[Bool](true.B)
              x7246_rd.toSeq.zip(x4328_img2D_6.connectRPort(7246, x7246_rd_banks, x7246_rd_ofs, io.sigsIn.backpressure, x7246_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7247_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7247_elem_0""")
              x7247_elem_0.r := x7246_rd(0).r
              val x7252_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7252_rd""")
              val x7252_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7252_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7252_rd_en = List[Bool](true.B)
              x7252_rd.toSeq.zip(x4328_img2D_6.connectRPort(7252, x7252_rd_banks, x7252_rd_ofs, io.sigsIn.backpressure, x7252_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7253_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7253_elem_0""")
              x7253_elem_0.r := x7252_rd(0).r
              val x7258_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7258_rd""")
              val x7258_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7258_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7258_rd_en = List[Bool](true.B)
              x7258_rd.toSeq.zip(x4328_img2D_6.connectRPort(7258, x7258_rd_banks, x7258_rd_ofs, io.sigsIn.backpressure, x7258_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7259_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7259_elem_0""")
              x7259_elem_0.r := x7258_rd(0).r
              val x7264_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7264_rd""")
              val x7264_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7264_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7264_rd_en = List[Bool](true.B)
              x7264_rd.toSeq.zip(x4328_img2D_6.connectRPort(7264, x7264_rd_banks, x7264_rd_ofs, io.sigsIn.backpressure, x7264_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7265_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7265_elem_0""")
              x7265_elem_0.r := x7264_rd(0).r
              val x7270_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7270_rd""")
              val x7270_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7270_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7270_rd_en = List[Bool](true.B)
              x7270_rd.toSeq.zip(x4328_img2D_6.connectRPort(7270, x7270_rd_banks, x7270_rd_ofs, io.sigsIn.backpressure, x7270_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7271_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7271_elem_0""")
              x7271_elem_0.r := x7270_rd(0).r
              val x7276_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7276_rd""")
              val x7276_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7276_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7276_rd_en = List[Bool](true.B)
              x7276_rd.toSeq.zip(x4328_img2D_6.connectRPort(7276, x7276_rd_banks, x7276_rd_ofs, io.sigsIn.backpressure, x7276_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7277_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7277_elem_0""")
              x7277_elem_0.r := x7276_rd(0).r
              val x7282_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7282_rd""")
              val x7282_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7282_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7282_rd_en = List[Bool](true.B)
              x7282_rd.toSeq.zip(x4328_img2D_6.connectRPort(7282, x7282_rd_banks, x7282_rd_ofs, io.sigsIn.backpressure, x7282_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7283_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7283_elem_0""")
              x7283_elem_0.r := x7282_rd(0).r
              val x7288_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7288_rd""")
              val x7288_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7288_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7288_rd_en = List[Bool](true.B)
              x7288_rd.toSeq.zip(x4328_img2D_6.connectRPort(7288, x7288_rd_banks, x7288_rd_ofs, io.sigsIn.backpressure, x7288_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7289_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7289_elem_0""")
              x7289_elem_0.r := x7288_rd(0).r
              val x7294_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7294_rd""")
              val x7294_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7294_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7294_rd_en = List[Bool](true.B)
              x7294_rd.toSeq.zip(x4328_img2D_6.connectRPort(7294, x7294_rd_banks, x7294_rd_ofs, io.sigsIn.backpressure, x7294_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7295_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7295_elem_0""")
              x7295_elem_0.r := x7294_rd(0).r
              val x7300_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7300_rd""")
              val x7300_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7300_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7300_rd_en = List[Bool](true.B)
              x7300_rd.toSeq.zip(x4328_img2D_6.connectRPort(7300, x7300_rd_banks, x7300_rd_ofs, io.sigsIn.backpressure, x7300_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7301_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7301_elem_0""")
              x7301_elem_0.r := x7300_rd(0).r
              val x7306_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7306_rd""")
              val x7306_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7306_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7306_rd_en = List[Bool](true.B)
              x7306_rd.toSeq.zip(x4328_img2D_6.connectRPort(7306, x7306_rd_banks, x7306_rd_ofs, io.sigsIn.backpressure, x7306_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7307_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7307_elem_0""")
              x7307_elem_0.r := x7306_rd(0).r
              val x7312_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7312_rd""")
              val x7312_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7312_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7312_rd_en = List[Bool](true.B)
              x7312_rd.toSeq.zip(x4328_img2D_6.connectRPort(7312, x7312_rd_banks, x7312_rd_ofs, io.sigsIn.backpressure, x7312_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7313_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7313_elem_0""")
              x7313_elem_0.r := x7312_rd(0).r
              val x7318_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7318_rd""")
              val x7318_rd_banks = List[UInt](block2chunk0sub23("x18886").asInstanceOf[FixedPoint].r)
              val x7318_rd_ofs = List[UInt](block2chunk0sub23("x7129").asInstanceOf[FixedPoint].r)
              val x7318_rd_en = List[Bool](true.B)
              x7318_rd.toSeq.zip(x4328_img2D_6.connectRPort(7318, x7318_rd_banks, x7318_rd_ofs, io.sigsIn.backpressure, x7318_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub23("x19779").asInstanceOf[Bool] & block2chunk0sub23("x19778").asInstanceOf[Bool] & block2chunk0sub23("x19780").asInstanceOf[Bool] & block2chunk0sub23("x19781").asInstanceOf[Bool] & block2chunk0sub23("x19776").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7319_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7319_elem_0""")
              x7319_elem_0.r := x7318_rd(0).r
              val x7320_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7320_sum""")
              x7320_sum.r := Math.add(block2chunk0sub23("x7064_sum").asInstanceOf[FixedPoint],block2chunk0sub17("x19734").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x7320_sum").r
              val x18887 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18887""")
              x18887.r := Math.and(x7320_sum,3L.FP(true, 32, 0),Some(0.2), true.B,"x18887").r
              val x7353 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7353""")
              x7353.r := Math.arith_right_shift(x7320_sum, 2, Some(0.2), true.B,"x7353").r
              Map[String,Any]("x7187_elem_0" -> x7187_elem_0, "x7193_elem_0" -> x7193_elem_0, "x7199_elem_0" -> x7199_elem_0, "x7205_elem_0" -> x7205_elem_0, "x7211_elem_0" -> x7211_elem_0, "x7217_elem_0" -> x7217_elem_0, "x7223_elem_0" -> x7223_elem_0, "x7229_elem_0" -> x7229_elem_0, "x7235_elem_0" -> x7235_elem_0, "x7241_elem_0" -> x7241_elem_0, "x7247_elem_0" -> x7247_elem_0, "x7253_elem_0" -> x7253_elem_0, "x7259_elem_0" -> x7259_elem_0, "x7265_elem_0" -> x7265_elem_0, "x7271_elem_0" -> x7271_elem_0, "x7277_elem_0" -> x7277_elem_0, "x7283_elem_0" -> x7283_elem_0, "x7289_elem_0" -> x7289_elem_0, "x7295_elem_0" -> x7295_elem_0, "x7301_elem_0" -> x7301_elem_0, "x7307_elem_0" -> x7307_elem_0, "x7313_elem_0" -> x7313_elem_0, "x7319_elem_0" -> x7319_elem_0, "x18887" -> x18887, "x7353" -> x7353)
            }
          }
          val block2chunk0sub24: Map[String, Any] = Block2Chunker0Sub24.gen()
          object Block2Chunker0Sub25 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x7356_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7356_rd""")
              val x7356_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7356_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7356_rd_en = List[Bool](true.B)
              x7356_rd.toSeq.zip(x4324_img2D_2.connectRPort(7356, x7356_rd_banks, x7356_rd_ofs, io.sigsIn.backpressure, x7356_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19736").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7357_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7357_elem_0""")
              x7357_elem_0.r := x7356_rd(0).r
              val x7362_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7362_rd""")
              val x7362_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7362_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7362_rd_en = List[Bool](true.B)
              x7362_rd.toSeq.zip(x4324_img2D_2.connectRPort(7362, x7362_rd_banks, x7362_rd_ofs, io.sigsIn.backpressure, x7362_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7363_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7363_elem_0""")
              x7363_elem_0.r := x7362_rd(0).r
              val x7368_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7368_rd""")
              val x7368_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7368_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7368_rd_en = List[Bool](true.B)
              x7368_rd.toSeq.zip(x4324_img2D_2.connectRPort(7368, x7368_rd_banks, x7368_rd_ofs, io.sigsIn.backpressure, x7368_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7369_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7369_elem_0""")
              x7369_elem_0.r := x7368_rd(0).r
              val x7374_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7374_rd""")
              val x7374_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7374_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7374_rd_en = List[Bool](true.B)
              x7374_rd.toSeq.zip(x4324_img2D_2.connectRPort(7374, x7374_rd_banks, x7374_rd_ofs, io.sigsIn.backpressure, x7374_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7375_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7375_elem_0""")
              x7375_elem_0.r := x7374_rd(0).r
              val x7380_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7380_rd""")
              val x7380_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7380_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7380_rd_en = List[Bool](true.B)
              x7380_rd.toSeq.zip(x4324_img2D_2.connectRPort(7380, x7380_rd_banks, x7380_rd_ofs, io.sigsIn.backpressure, x7380_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7381_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7381_elem_0""")
              x7381_elem_0.r := x7380_rd(0).r
              val x7386_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7386_rd""")
              val x7386_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7386_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7386_rd_en = List[Bool](true.B)
              x7386_rd.toSeq.zip(x4324_img2D_2.connectRPort(7386, x7386_rd_banks, x7386_rd_ofs, io.sigsIn.backpressure, x7386_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7387_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7387_elem_0""")
              x7387_elem_0.r := x7386_rd(0).r
              val x7392_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7392_rd""")
              val x7392_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7392_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7392_rd_en = List[Bool](true.B)
              x7392_rd.toSeq.zip(x4324_img2D_2.connectRPort(7392, x7392_rd_banks, x7392_rd_ofs, io.sigsIn.backpressure, x7392_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7393_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7393_elem_0""")
              x7393_elem_0.r := x7392_rd(0).r
              val x7398_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7398_rd""")
              val x7398_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7398_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7398_rd_en = List[Bool](true.B)
              x7398_rd.toSeq.zip(x4324_img2D_2.connectRPort(7398, x7398_rd_banks, x7398_rd_ofs, io.sigsIn.backpressure, x7398_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7399_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7399_elem_0""")
              x7399_elem_0.r := x7398_rd(0).r
              val x7404_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7404_rd""")
              val x7404_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7404_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7404_rd_en = List[Bool](true.B)
              x7404_rd.toSeq.zip(x4324_img2D_2.connectRPort(7404, x7404_rd_banks, x7404_rd_ofs, io.sigsIn.backpressure, x7404_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7405_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7405_elem_0""")
              x7405_elem_0.r := x7404_rd(0).r
              val x7410_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7410_rd""")
              val x7410_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7410_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7410_rd_en = List[Bool](true.B)
              x7410_rd.toSeq.zip(x4324_img2D_2.connectRPort(7410, x7410_rd_banks, x7410_rd_ofs, io.sigsIn.backpressure, x7410_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7411_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7411_elem_0""")
              x7411_elem_0.r := x7410_rd(0).r
              val x7416_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7416_rd""")
              val x7416_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7416_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7416_rd_en = List[Bool](true.B)
              x7416_rd.toSeq.zip(x4324_img2D_2.connectRPort(7416, x7416_rd_banks, x7416_rd_ofs, io.sigsIn.backpressure, x7416_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7417_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7417_elem_0""")
              x7417_elem_0.r := x7416_rd(0).r
              val x7422_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7422_rd""")
              val x7422_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7422_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7422_rd_en = List[Bool](true.B)
              x7422_rd.toSeq.zip(x4324_img2D_2.connectRPort(7422, x7422_rd_banks, x7422_rd_ofs, io.sigsIn.backpressure, x7422_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7423_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7423_elem_0""")
              x7423_elem_0.r := x7422_rd(0).r
              val x7428_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7428_rd""")
              val x7428_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7428_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7428_rd_en = List[Bool](true.B)
              x7428_rd.toSeq.zip(x4324_img2D_2.connectRPort(7428, x7428_rd_banks, x7428_rd_ofs, io.sigsIn.backpressure, x7428_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7429_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7429_elem_0""")
              x7429_elem_0.r := x7428_rd(0).r
              val x7434_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7434_rd""")
              val x7434_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7434_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7434_rd_en = List[Bool](true.B)
              x7434_rd.toSeq.zip(x4324_img2D_2.connectRPort(7434, x7434_rd_banks, x7434_rd_ofs, io.sigsIn.backpressure, x7434_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7435_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7435_elem_0""")
              x7435_elem_0.r := x7434_rd(0).r
              val x7440_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7440_rd""")
              val x7440_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7440_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7440_rd_en = List[Bool](true.B)
              x7440_rd.toSeq.zip(x4324_img2D_2.connectRPort(7440, x7440_rd_banks, x7440_rd_ofs, io.sigsIn.backpressure, x7440_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7441_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7441_elem_0""")
              x7441_elem_0.r := x7440_rd(0).r
              val x7446_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7446_rd""")
              val x7446_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7446_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7446_rd_en = List[Bool](true.B)
              x7446_rd.toSeq.zip(x4324_img2D_2.connectRPort(7446, x7446_rd_banks, x7446_rd_ofs, io.sigsIn.backpressure, x7446_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7447_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7447_elem_0""")
              x7447_elem_0.r := x7446_rd(0).r
              val x7452_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7452_rd""")
              val x7452_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7452_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7452_rd_en = List[Bool](true.B)
              x7452_rd.toSeq.zip(x4324_img2D_2.connectRPort(7452, x7452_rd_banks, x7452_rd_ofs, io.sigsIn.backpressure, x7452_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7453_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7453_elem_0""")
              x7453_elem_0.r := x7452_rd(0).r
              val x7458_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7458_rd""")
              val x7458_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7458_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7458_rd_en = List[Bool](true.B)
              x7458_rd.toSeq.zip(x4324_img2D_2.connectRPort(7458, x7458_rd_banks, x7458_rd_ofs, io.sigsIn.backpressure, x7458_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7459_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7459_elem_0""")
              x7459_elem_0.r := x7458_rd(0).r
              val x7464_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7464_rd""")
              val x7464_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7464_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7464_rd_en = List[Bool](true.B)
              x7464_rd.toSeq.zip(x4324_img2D_2.connectRPort(7464, x7464_rd_banks, x7464_rd_ofs, io.sigsIn.backpressure, x7464_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7465_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7465_elem_0""")
              x7465_elem_0.r := x7464_rd(0).r
              val x7470_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7470_rd""")
              val x7470_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7470_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7470_rd_en = List[Bool](true.B)
              x7470_rd.toSeq.zip(x4324_img2D_2.connectRPort(7470, x7470_rd_banks, x7470_rd_ofs, io.sigsIn.backpressure, x7470_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7471_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7471_elem_0""")
              x7471_elem_0.r := x7470_rd(0).r
              val x7476_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7476_rd""")
              val x7476_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7476_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7476_rd_en = List[Bool](true.B)
              x7476_rd.toSeq.zip(x4324_img2D_2.connectRPort(7476, x7476_rd_banks, x7476_rd_ofs, io.sigsIn.backpressure, x7476_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7477_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7477_elem_0""")
              x7477_elem_0.r := x7476_rd(0).r
              val x7482_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7482_rd""")
              val x7482_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7482_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7482_rd_en = List[Bool](true.B)
              x7482_rd.toSeq.zip(x4324_img2D_2.connectRPort(7482, x7482_rd_banks, x7482_rd_ofs, io.sigsIn.backpressure, x7482_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7483_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7483_elem_0""")
              x7483_elem_0.r := x7482_rd(0).r
              val x7488_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7488_rd""")
              val x7488_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7488_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7488_rd_en = List[Bool](true.B)
              x7488_rd.toSeq.zip(x4324_img2D_2.connectRPort(7488, x7488_rd_banks, x7488_rd_ofs, io.sigsIn.backpressure, x7488_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7489_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7489_elem_0""")
              x7489_elem_0.r := x7488_rd(0).r
              val x7494_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7494_rd""")
              val x7494_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7494_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7494_rd_en = List[Bool](true.B)
              x7494_rd.toSeq.zip(x4324_img2D_2.connectRPort(7494, x7494_rd_banks, x7494_rd_ofs, io.sigsIn.backpressure, x7494_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7495_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7495_elem_0""")
              x7495_elem_0.r := x7494_rd(0).r
              val x7500_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7500_rd""")
              val x7500_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7500_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7500_rd_en = List[Bool](true.B)
              x7500_rd.toSeq.zip(x4324_img2D_2.connectRPort(7500, x7500_rd_banks, x7500_rd_ofs, io.sigsIn.backpressure, x7500_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              Map[String,Any]("x7357_elem_0" -> x7357_elem_0, "x7363_elem_0" -> x7363_elem_0, "x7369_elem_0" -> x7369_elem_0, "x7375_elem_0" -> x7375_elem_0, "x7381_elem_0" -> x7381_elem_0, "x7387_elem_0" -> x7387_elem_0, "x7393_elem_0" -> x7393_elem_0, "x7399_elem_0" -> x7399_elem_0, "x7405_elem_0" -> x7405_elem_0, "x7411_elem_0" -> x7411_elem_0, "x7417_elem_0" -> x7417_elem_0, "x7423_elem_0" -> x7423_elem_0, "x7429_elem_0" -> x7429_elem_0, "x7435_elem_0" -> x7435_elem_0, "x7441_elem_0" -> x7441_elem_0, "x7447_elem_0" -> x7447_elem_0, "x7453_elem_0" -> x7453_elem_0, "x7459_elem_0" -> x7459_elem_0, "x7465_elem_0" -> x7465_elem_0, "x7471_elem_0" -> x7471_elem_0, "x7477_elem_0" -> x7477_elem_0, "x7483_elem_0" -> x7483_elem_0, "x7489_elem_0" -> x7489_elem_0, "x7495_elem_0" -> x7495_elem_0, "x7500_rd" -> x7500_rd)
            }
          }
          val block2chunk0sub25: Map[String, Any] = Block2Chunker0Sub25.gen()
          object Block2Chunker0Sub26 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x7501_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7501_elem_0""")
              x7501_elem_0.r := block2chunk0sub25("x7500_rd").asInstanceOf[Vec[FixedPoint]](0).r
              val x7506_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7506_rd""")
              val x7506_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7506_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7506_rd_en = List[Bool](true.B)
              x7506_rd.toSeq.zip(x4324_img2D_2.connectRPort(7506, x7506_rd_banks, x7506_rd_ofs, io.sigsIn.backpressure, x7506_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7507_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7507_elem_0""")
              x7507_elem_0.r := x7506_rd(0).r
              val x7512_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7512_rd""")
              val x7512_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7512_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7512_rd_en = List[Bool](true.B)
              x7512_rd.toSeq.zip(x4324_img2D_2.connectRPort(7512, x7512_rd_banks, x7512_rd_ofs, io.sigsIn.backpressure, x7512_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7513_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7513_elem_0""")
              x7513_elem_0.r := x7512_rd(0).r
              val x7518_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7518_rd""")
              val x7518_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7518_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7518_rd_en = List[Bool](true.B)
              x7518_rd.toSeq.zip(x4324_img2D_2.connectRPort(7518, x7518_rd_banks, x7518_rd_ofs, io.sigsIn.backpressure, x7518_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7519_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7519_elem_0""")
              x7519_elem_0.r := x7518_rd(0).r
              val x7524_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7524_rd""")
              val x7524_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7524_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7524_rd_en = List[Bool](true.B)
              x7524_rd.toSeq.zip(x4324_img2D_2.connectRPort(7524, x7524_rd_banks, x7524_rd_ofs, io.sigsIn.backpressure, x7524_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7525_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7525_elem_0""")
              x7525_elem_0.r := x7524_rd(0).r
              val x7530_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7530_rd""")
              val x7530_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7530_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7530_rd_en = List[Bool](true.B)
              x7530_rd.toSeq.zip(x4324_img2D_2.connectRPort(7530, x7530_rd_banks, x7530_rd_ofs, io.sigsIn.backpressure, x7530_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7531_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7531_elem_0""")
              x7531_elem_0.r := x7530_rd(0).r
              val x7536_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7536_rd""")
              val x7536_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7536_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7536_rd_en = List[Bool](true.B)
              x7536_rd.toSeq.zip(x4324_img2D_2.connectRPort(7536, x7536_rd_banks, x7536_rd_ofs, io.sigsIn.backpressure, x7536_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7537_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7537_elem_0""")
              x7537_elem_0.r := x7536_rd(0).r
              val x7542_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7542_rd""")
              val x7542_rd_banks = List[UInt](block2chunk0sub24("x18887").asInstanceOf[FixedPoint].r)
              val x7542_rd_ofs = List[UInt](block2chunk0sub24("x7353").asInstanceOf[FixedPoint].r)
              val x7542_rd_en = List[Bool](true.B)
              x7542_rd.toSeq.zip(x4324_img2D_2.connectRPort(7542, x7542_rd_banks, x7542_rd_ofs, io.sigsIn.backpressure, x7542_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7543_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7543_elem_0""")
              x7543_elem_0.r := x7542_rd(0).r
              val x19813 = Wire(Bool()).suggestName("x19813_x6424_D3") 
              x19813.r := getRetimed(block2chunk0sub19("x6424").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
              val x7544 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7544""")
              x7544.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7357_elem_0").asInstanceOf[FixedPoint].r)
              val x7545 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7545""")
              x7545.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7363_elem_0").asInstanceOf[FixedPoint].r)
              val x7546 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7546""")
              x7546.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7369_elem_0").asInstanceOf[FixedPoint].r)
              val x7547 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7547""")
              x7547.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7375_elem_0").asInstanceOf[FixedPoint].r)
              val x7548 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7548""")
              x7548.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7381_elem_0").asInstanceOf[FixedPoint].r)
              val x7549 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7549""")
              x7549.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7387_elem_0").asInstanceOf[FixedPoint].r)
              val x7550 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7550""")
              x7550.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7393_elem_0").asInstanceOf[FixedPoint].r)
              val x7551 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7551""")
              x7551.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7399_elem_0").asInstanceOf[FixedPoint].r)
              val x7552 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7552""")
              x7552.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7405_elem_0").asInstanceOf[FixedPoint].r)
              val x7553 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7553""")
              x7553.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7411_elem_0").asInstanceOf[FixedPoint].r)
              val x7554 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7554""")
              x7554.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7417_elem_0").asInstanceOf[FixedPoint].r)
              val x7555 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7555""")
              x7555.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7423_elem_0").asInstanceOf[FixedPoint].r)
              val x7556 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7556""")
              x7556.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7429_elem_0").asInstanceOf[FixedPoint].r)
              val x7557 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7557""")
              x7557.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7435_elem_0").asInstanceOf[FixedPoint].r)
              val x7558 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7558""")
              x7558.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7441_elem_0").asInstanceOf[FixedPoint].r)
              val x7559 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7559""")
              x7559.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7447_elem_0").asInstanceOf[FixedPoint].r)
              val x7560 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7560""")
              x7560.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7453_elem_0").asInstanceOf[FixedPoint].r)
              val x7561 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7561""")
              x7561.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7459_elem_0").asInstanceOf[FixedPoint].r)
              val x7562 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7562""")
              x7562.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7465_elem_0").asInstanceOf[FixedPoint].r)
              val x7563 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7563""")
              x7563.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7471_elem_0").asInstanceOf[FixedPoint].r)
              val x7564 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7564""")
              x7564.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7477_elem_0").asInstanceOf[FixedPoint].r)
              val x7565 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7565""")
              x7565.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7483_elem_0").asInstanceOf[FixedPoint].r)
              val x7566 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7566""")
              x7566.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7489_elem_0").asInstanceOf[FixedPoint].r)
              val x7567 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7567""")
              x7567.r := Mux((x19813), 0.FP(true, 10, 22).r, block2chunk0sub25("x7495_elem_0").asInstanceOf[FixedPoint].r)
              val x7568 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7568""")
              x7568.r := Mux((x19813), 0.FP(true, 10, 22).r, x7501_elem_0.r)
              val x7569 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7569""")
              x7569.r := Mux((x19813), 0.FP(true, 10, 22).r, x7507_elem_0.r)
              val x7570 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7570""")
              x7570.r := Mux((x19813), 0.FP(true, 10, 22).r, x7513_elem_0.r)
              val x7571 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7571""")
              x7571.r := Mux((x19813), 0.FP(true, 10, 22).r, x7519_elem_0.r)
              val x7572 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7572""")
              x7572.r := Mux((x19813), 0.FP(true, 10, 22).r, x7525_elem_0.r)
              val x7573 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7573""")
              x7573.r := Mux((x19813), 0.FP(true, 10, 22).r, x7531_elem_0.r)
              val x7574 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7574""")
              x7574.r := Mux((x19813), 0.FP(true, 10, 22).r, x7537_elem_0.r)
              val x7575 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7575""")
              x7575.r := Mux((x19813), 0.FP(true, 10, 22).r, x7543_elem_0.r)
              val x7576 = Wire(Bool()).suggestName("""x7576""")
              x7576.r := Math.lt(block2chunk0sub0("x4813").asInstanceOf[FixedPoint], 3L.FP(true, 32, 0), Some(0.4), true.B,"x7576").r
              Map[String,Any]("x7544" -> x7544, "x7545" -> x7545, "x7546" -> x7546, "x7547" -> x7547, "x7548" -> x7548, "x7549" -> x7549, "x7550" -> x7550, "x7551" -> x7551, "x7552" -> x7552, "x7553" -> x7553, "x7554" -> x7554, "x7555" -> x7555, "x7556" -> x7556, "x7557" -> x7557, "x7558" -> x7558, "x7559" -> x7559, "x7560" -> x7560, "x7561" -> x7561, "x7562" -> x7562, "x7563" -> x7563, "x7564" -> x7564, "x7565" -> x7565, "x7566" -> x7566, "x7567" -> x7567, "x7568" -> x7568, "x7569" -> x7569, "x7570" -> x7570, "x7571" -> x7571, "x7572" -> x7572, "x7573" -> x7573, "x7574" -> x7574, "x7575" -> x7575, "x7576" -> x7576)
            }
          }
          val block2chunk0sub26: Map[String, Any] = Block2Chunker0Sub26.gen()
          object Block2Chunker0Sub27 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x7608 = Wire(Bool()).suggestName("""x7608""")
              x7608 := block2chunk0sub26("x7576").asInstanceOf[Bool] | block2chunk0sub14("x5622").asInstanceOf[Bool]
              val x7640_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7640_sum""")
              x7640_sum.r := Math.add(1L.FP(true, 32, 0),block2chunk0sub14("x5719").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x7640_sum").r
              val x7672_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7672_mul""")
              x7672_mul.r := (Math.mul(x7640_sum, block2chunk0sub14("x19694").asInstanceOf[FixedPoint], Some(6.0), true.B, Truncate, Wrapping, "x7672_mul")).r
              val x7704_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7704_sub""")
              x7704_sub.r := Math.sub(x7672_mul,1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x7704_sub").r
              val x7736_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7736_sum""")
              x7736_sum.r := Math.add(x7704_sub,block2chunk0sub14("x19695").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x7736_sum").r
              val x18888 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18888""")
              x18888.r := Math.and(x7736_sum,3L.FP(true, 32, 0),Some(0.2), true.B,"x18888").r
              val x7769 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7769""")
              x7769.r := Math.arith_right_shift(x7736_sum, 2, Some(0.2), true.B,"x7769").r
              val x7772_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7772_rd""")
              val x7772_rd_banks = List[UInt](x18888.r)
              val x7772_rd_ofs = List[UInt](x7769.r)
              val x7772_rd_en = List[Bool](true.B)
              x7772_rd.toSeq.zip(x4330_img2D_8.connectRPort(7772, x7772_rd_banks, x7772_rd_ofs, io.sigsIn.backpressure, x7772_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub14("x19697").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7773_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7773_elem_0""")
              x7773_elem_0.r := x7772_rd(0).r
              val x7778_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7778_rd""")
              val x7778_rd_banks = List[UInt](x18888.r)
              val x7778_rd_ofs = List[UInt](x7769.r)
              val x7778_rd_en = List[Bool](true.B)
              x7778_rd.toSeq.zip(x4330_img2D_8.connectRPort(7778, x7778_rd_banks, x7778_rd_ofs, io.sigsIn.backpressure, x7778_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7779_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7779_elem_0""")
              x7779_elem_0.r := x7778_rd(0).r
              val x7784_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7784_rd""")
              val x7784_rd_banks = List[UInt](x18888.r)
              val x7784_rd_ofs = List[UInt](x7769.r)
              val x7784_rd_en = List[Bool](true.B)
              x7784_rd.toSeq.zip(x4330_img2D_8.connectRPort(7784, x7784_rd_banks, x7784_rd_ofs, io.sigsIn.backpressure, x7784_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7785_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7785_elem_0""")
              x7785_elem_0.r := x7784_rd(0).r
              val x7790_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7790_rd""")
              val x7790_rd_banks = List[UInt](x18888.r)
              val x7790_rd_ofs = List[UInt](x7769.r)
              val x7790_rd_en = List[Bool](true.B)
              x7790_rd.toSeq.zip(x4330_img2D_8.connectRPort(7790, x7790_rd_banks, x7790_rd_ofs, io.sigsIn.backpressure, x7790_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7791_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7791_elem_0""")
              x7791_elem_0.r := x7790_rd(0).r
              val x7796_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7796_rd""")
              val x7796_rd_banks = List[UInt](x18888.r)
              val x7796_rd_ofs = List[UInt](x7769.r)
              val x7796_rd_en = List[Bool](true.B)
              x7796_rd.toSeq.zip(x4330_img2D_8.connectRPort(7796, x7796_rd_banks, x7796_rd_ofs, io.sigsIn.backpressure, x7796_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7797_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7797_elem_0""")
              x7797_elem_0.r := x7796_rd(0).r
              val x7802_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7802_rd""")
              val x7802_rd_banks = List[UInt](x18888.r)
              val x7802_rd_ofs = List[UInt](x7769.r)
              val x7802_rd_en = List[Bool](true.B)
              x7802_rd.toSeq.zip(x4330_img2D_8.connectRPort(7802, x7802_rd_banks, x7802_rd_ofs, io.sigsIn.backpressure, x7802_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7803_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7803_elem_0""")
              x7803_elem_0.r := x7802_rd(0).r
              val x7808_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7808_rd""")
              val x7808_rd_banks = List[UInt](x18888.r)
              val x7808_rd_ofs = List[UInt](x7769.r)
              val x7808_rd_en = List[Bool](true.B)
              x7808_rd.toSeq.zip(x4330_img2D_8.connectRPort(7808, x7808_rd_banks, x7808_rd_ofs, io.sigsIn.backpressure, x7808_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7809_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7809_elem_0""")
              x7809_elem_0.r := x7808_rd(0).r
              val x7814_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7814_rd""")
              val x7814_rd_banks = List[UInt](x18888.r)
              val x7814_rd_ofs = List[UInt](x7769.r)
              val x7814_rd_en = List[Bool](true.B)
              x7814_rd.toSeq.zip(x4330_img2D_8.connectRPort(7814, x7814_rd_banks, x7814_rd_ofs, io.sigsIn.backpressure, x7814_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7815_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7815_elem_0""")
              x7815_elem_0.r := x7814_rd(0).r
              val x7820_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7820_rd""")
              val x7820_rd_banks = List[UInt](x18888.r)
              val x7820_rd_ofs = List[UInt](x7769.r)
              val x7820_rd_en = List[Bool](true.B)
              x7820_rd.toSeq.zip(x4330_img2D_8.connectRPort(7820, x7820_rd_banks, x7820_rd_ofs, io.sigsIn.backpressure, x7820_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7821_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7821_elem_0""")
              x7821_elem_0.r := x7820_rd(0).r
              val x7826_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7826_rd""")
              val x7826_rd_banks = List[UInt](x18888.r)
              val x7826_rd_ofs = List[UInt](x7769.r)
              val x7826_rd_en = List[Bool](true.B)
              x7826_rd.toSeq.zip(x4330_img2D_8.connectRPort(7826, x7826_rd_banks, x7826_rd_ofs, io.sigsIn.backpressure, x7826_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7827_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7827_elem_0""")
              x7827_elem_0.r := x7826_rd(0).r
              val x7832_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7832_rd""")
              val x7832_rd_banks = List[UInt](x18888.r)
              val x7832_rd_ofs = List[UInt](x7769.r)
              val x7832_rd_en = List[Bool](true.B)
              x7832_rd.toSeq.zip(x4330_img2D_8.connectRPort(7832, x7832_rd_banks, x7832_rd_ofs, io.sigsIn.backpressure, x7832_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7833_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7833_elem_0""")
              x7833_elem_0.r := x7832_rd(0).r
              val x7838_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7838_rd""")
              val x7838_rd_banks = List[UInt](x18888.r)
              val x7838_rd_ofs = List[UInt](x7769.r)
              val x7838_rd_en = List[Bool](true.B)
              x7838_rd.toSeq.zip(x4330_img2D_8.connectRPort(7838, x7838_rd_banks, x7838_rd_ofs, io.sigsIn.backpressure, x7838_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7839_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7839_elem_0""")
              x7839_elem_0.r := x7838_rd(0).r
              val x7844_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7844_rd""")
              val x7844_rd_banks = List[UInt](x18888.r)
              val x7844_rd_ofs = List[UInt](x7769.r)
              val x7844_rd_en = List[Bool](true.B)
              x7844_rd.toSeq.zip(x4330_img2D_8.connectRPort(7844, x7844_rd_banks, x7844_rd_ofs, io.sigsIn.backpressure, x7844_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7845_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7845_elem_0""")
              x7845_elem_0.r := x7844_rd(0).r
              val x7850_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7850_rd""")
              val x7850_rd_banks = List[UInt](x18888.r)
              val x7850_rd_ofs = List[UInt](x7769.r)
              val x7850_rd_en = List[Bool](true.B)
              x7850_rd.toSeq.zip(x4330_img2D_8.connectRPort(7850, x7850_rd_banks, x7850_rd_ofs, io.sigsIn.backpressure, x7850_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7851_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7851_elem_0""")
              x7851_elem_0.r := x7850_rd(0).r
              val x7856_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7856_rd""")
              val x7856_rd_banks = List[UInt](x18888.r)
              val x7856_rd_ofs = List[UInt](x7769.r)
              val x7856_rd_en = List[Bool](true.B)
              x7856_rd.toSeq.zip(x4330_img2D_8.connectRPort(7856, x7856_rd_banks, x7856_rd_ofs, io.sigsIn.backpressure, x7856_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7857_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7857_elem_0""")
              x7857_elem_0.r := x7856_rd(0).r
              val x7862_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7862_rd""")
              val x7862_rd_banks = List[UInt](x18888.r)
              val x7862_rd_ofs = List[UInt](x7769.r)
              val x7862_rd_en = List[Bool](true.B)
              x7862_rd.toSeq.zip(x4330_img2D_8.connectRPort(7862, x7862_rd_banks, x7862_rd_ofs, io.sigsIn.backpressure, x7862_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7863_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7863_elem_0""")
              x7863_elem_0.r := x7862_rd(0).r
              val x7868_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7868_rd""")
              val x7868_rd_banks = List[UInt](x18888.r)
              val x7868_rd_ofs = List[UInt](x7769.r)
              val x7868_rd_en = List[Bool](true.B)
              x7868_rd.toSeq.zip(x4330_img2D_8.connectRPort(7868, x7868_rd_banks, x7868_rd_ofs, io.sigsIn.backpressure, x7868_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7869_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7869_elem_0""")
              x7869_elem_0.r := x7868_rd(0).r
              val x7874_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7874_rd""")
              val x7874_rd_banks = List[UInt](x18888.r)
              val x7874_rd_ofs = List[UInt](x7769.r)
              val x7874_rd_en = List[Bool](true.B)
              x7874_rd.toSeq.zip(x4330_img2D_8.connectRPort(7874, x7874_rd_banks, x7874_rd_ofs, io.sigsIn.backpressure, x7874_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7875_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7875_elem_0""")
              x7875_elem_0.r := x7874_rd(0).r
              val x7880_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7880_rd""")
              val x7880_rd_banks = List[UInt](x18888.r)
              val x7880_rd_ofs = List[UInt](x7769.r)
              val x7880_rd_en = List[Bool](true.B)
              x7880_rd.toSeq.zip(x4330_img2D_8.connectRPort(7880, x7880_rd_banks, x7880_rd_ofs, io.sigsIn.backpressure, x7880_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7881_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7881_elem_0""")
              x7881_elem_0.r := x7880_rd(0).r
              val x7886_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7886_rd""")
              val x7886_rd_banks = List[UInt](x18888.r)
              val x7886_rd_ofs = List[UInt](x7769.r)
              val x7886_rd_en = List[Bool](true.B)
              x7886_rd.toSeq.zip(x4330_img2D_8.connectRPort(7886, x7886_rd_banks, x7886_rd_ofs, io.sigsIn.backpressure, x7886_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7887_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7887_elem_0""")
              x7887_elem_0.r := x7886_rd(0).r
              val x7892_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7892_rd""")
              val x7892_rd_banks = List[UInt](x18888.r)
              val x7892_rd_ofs = List[UInt](x7769.r)
              val x7892_rd_en = List[Bool](true.B)
              x7892_rd.toSeq.zip(x4330_img2D_8.connectRPort(7892, x7892_rd_banks, x7892_rd_ofs, io.sigsIn.backpressure, x7892_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7893_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7893_elem_0""")
              x7893_elem_0.r := x7892_rd(0).r
              Map[String,Any]("x7608" -> x7608, "x7672_mul" -> x7672_mul, "x18888" -> x18888, "x7769" -> x7769, "x7773_elem_0" -> x7773_elem_0, "x7779_elem_0" -> x7779_elem_0, "x7785_elem_0" -> x7785_elem_0, "x7791_elem_0" -> x7791_elem_0, "x7797_elem_0" -> x7797_elem_0, "x7803_elem_0" -> x7803_elem_0, "x7809_elem_0" -> x7809_elem_0, "x7815_elem_0" -> x7815_elem_0, "x7821_elem_0" -> x7821_elem_0, "x7827_elem_0" -> x7827_elem_0, "x7833_elem_0" -> x7833_elem_0, "x7839_elem_0" -> x7839_elem_0, "x7845_elem_0" -> x7845_elem_0, "x7851_elem_0" -> x7851_elem_0, "x7857_elem_0" -> x7857_elem_0, "x7863_elem_0" -> x7863_elem_0, "x7869_elem_0" -> x7869_elem_0, "x7875_elem_0" -> x7875_elem_0, "x7881_elem_0" -> x7881_elem_0, "x7887_elem_0" -> x7887_elem_0, "x7893_elem_0" -> x7893_elem_0)
            }
          }
          val block2chunk0sub27: Map[String, Any] = Block2Chunker0Sub27.gen()
          object Block2Chunker0Sub28 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x7898_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7898_rd""")
              val x7898_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7898_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7898_rd_en = List[Bool](true.B)
              x7898_rd.toSeq.zip(x4330_img2D_8.connectRPort(7898, x7898_rd_banks, x7898_rd_ofs, io.sigsIn.backpressure, x7898_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7899_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7899_elem_0""")
              x7899_elem_0.r := x7898_rd(0).r
              val x7904_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7904_rd""")
              val x7904_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7904_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7904_rd_en = List[Bool](true.B)
              x7904_rd.toSeq.zip(x4330_img2D_8.connectRPort(7904, x7904_rd_banks, x7904_rd_ofs, io.sigsIn.backpressure, x7904_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7905_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7905_elem_0""")
              x7905_elem_0.r := x7904_rd(0).r
              val x7910_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7910_rd""")
              val x7910_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7910_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7910_rd_en = List[Bool](true.B)
              x7910_rd.toSeq.zip(x4330_img2D_8.connectRPort(7910, x7910_rd_banks, x7910_rd_ofs, io.sigsIn.backpressure, x7910_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7911_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7911_elem_0""")
              x7911_elem_0.r := x7910_rd(0).r
              val x7916_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7916_rd""")
              val x7916_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7916_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7916_rd_en = List[Bool](true.B)
              x7916_rd.toSeq.zip(x4330_img2D_8.connectRPort(7916, x7916_rd_banks, x7916_rd_ofs, io.sigsIn.backpressure, x7916_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7917_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7917_elem_0""")
              x7917_elem_0.r := x7916_rd(0).r
              val x7922_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7922_rd""")
              val x7922_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7922_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7922_rd_en = List[Bool](true.B)
              x7922_rd.toSeq.zip(x4330_img2D_8.connectRPort(7922, x7922_rd_banks, x7922_rd_ofs, io.sigsIn.backpressure, x7922_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7923_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7923_elem_0""")
              x7923_elem_0.r := x7922_rd(0).r
              val x7928_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7928_rd""")
              val x7928_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7928_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7928_rd_en = List[Bool](true.B)
              x7928_rd.toSeq.zip(x4330_img2D_8.connectRPort(7928, x7928_rd_banks, x7928_rd_ofs, io.sigsIn.backpressure, x7928_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7929_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7929_elem_0""")
              x7929_elem_0.r := x7928_rd(0).r
              val x7934_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7934_rd""")
              val x7934_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7934_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7934_rd_en = List[Bool](true.B)
              x7934_rd.toSeq.zip(x4330_img2D_8.connectRPort(7934, x7934_rd_banks, x7934_rd_ofs, io.sigsIn.backpressure, x7934_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7935_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7935_elem_0""")
              x7935_elem_0.r := x7934_rd(0).r
              val x7940_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7940_rd""")
              val x7940_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7940_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7940_rd_en = List[Bool](true.B)
              x7940_rd.toSeq.zip(x4330_img2D_8.connectRPort(7940, x7940_rd_banks, x7940_rd_ofs, io.sigsIn.backpressure, x7940_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7941_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7941_elem_0""")
              x7941_elem_0.r := x7940_rd(0).r
              val x7946_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7946_rd""")
              val x7946_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7946_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7946_rd_en = List[Bool](true.B)
              x7946_rd.toSeq.zip(x4330_img2D_8.connectRPort(7946, x7946_rd_banks, x7946_rd_ofs, io.sigsIn.backpressure, x7946_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7947_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7947_elem_0""")
              x7947_elem_0.r := x7946_rd(0).r
              val x7952_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7952_rd""")
              val x7952_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7952_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7952_rd_en = List[Bool](true.B)
              x7952_rd.toSeq.zip(x4330_img2D_8.connectRPort(7952, x7952_rd_banks, x7952_rd_ofs, io.sigsIn.backpressure, x7952_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7953_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7953_elem_0""")
              x7953_elem_0.r := x7952_rd(0).r
              val x7958_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x7958_rd""")
              val x7958_rd_banks = List[UInt](block2chunk0sub27("x18888").asInstanceOf[FixedPoint].r)
              val x7958_rd_ofs = List[UInt](block2chunk0sub27("x7769").asInstanceOf[FixedPoint].r)
              val x7958_rd_en = List[Bool](true.B)
              x7958_rd.toSeq.zip(x4330_img2D_8.connectRPort(7958, x7958_rd_banks, x7958_rd_ofs, io.sigsIn.backpressure, x7958_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x7959_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7959_elem_0""")
              x7959_elem_0.r := x7958_rd(0).r
              val x19814 = Wire(Bool()).suggestName("x19814_x7608_D4") 
              x19814.r := getRetimed(block2chunk0sub27("x7608").asInstanceOf[Bool].r, 4.toInt, io.sigsIn.backpressure)
              val x7960 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7960""")
              x7960.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7773_elem_0").asInstanceOf[FixedPoint].r)
              val x7961 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7961""")
              x7961.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7779_elem_0").asInstanceOf[FixedPoint].r)
              val x7962 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7962""")
              x7962.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7785_elem_0").asInstanceOf[FixedPoint].r)
              val x7963 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7963""")
              x7963.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7791_elem_0").asInstanceOf[FixedPoint].r)
              val x7964 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7964""")
              x7964.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7797_elem_0").asInstanceOf[FixedPoint].r)
              val x7965 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7965""")
              x7965.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7803_elem_0").asInstanceOf[FixedPoint].r)
              val x7966 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7966""")
              x7966.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7809_elem_0").asInstanceOf[FixedPoint].r)
              val x7967 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7967""")
              x7967.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7815_elem_0").asInstanceOf[FixedPoint].r)
              val x7968 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7968""")
              x7968.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7821_elem_0").asInstanceOf[FixedPoint].r)
              val x7969 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7969""")
              x7969.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7827_elem_0").asInstanceOf[FixedPoint].r)
              val x7970 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7970""")
              x7970.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7833_elem_0").asInstanceOf[FixedPoint].r)
              val x7971 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7971""")
              x7971.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7839_elem_0").asInstanceOf[FixedPoint].r)
              val x7972 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7972""")
              x7972.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7845_elem_0").asInstanceOf[FixedPoint].r)
              val x7973 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7973""")
              x7973.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7851_elem_0").asInstanceOf[FixedPoint].r)
              val x7974 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7974""")
              x7974.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7857_elem_0").asInstanceOf[FixedPoint].r)
              val x7975 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7975""")
              x7975.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7863_elem_0").asInstanceOf[FixedPoint].r)
              val x7976 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7976""")
              x7976.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7869_elem_0").asInstanceOf[FixedPoint].r)
              val x7977 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7977""")
              x7977.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7875_elem_0").asInstanceOf[FixedPoint].r)
              val x7978 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7978""")
              x7978.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7881_elem_0").asInstanceOf[FixedPoint].r)
              val x7979 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7979""")
              x7979.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7887_elem_0").asInstanceOf[FixedPoint].r)
              val x7980 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7980""")
              x7980.r := Mux((x19814), 0.FP(true, 10, 22).r, block2chunk0sub27("x7893_elem_0").asInstanceOf[FixedPoint].r)
              val x7981 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7981""")
              x7981.r := Mux((x19814), 0.FP(true, 10, 22).r, x7899_elem_0.r)
              val x7982 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7982""")
              x7982.r := Mux((x19814), 0.FP(true, 10, 22).r, x7905_elem_0.r)
              val x7983 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7983""")
              x7983.r := Mux((x19814), 0.FP(true, 10, 22).r, x7911_elem_0.r)
              val x7984 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7984""")
              x7984.r := Mux((x19814), 0.FP(true, 10, 22).r, x7917_elem_0.r)
              val x7985 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7985""")
              x7985.r := Mux((x19814), 0.FP(true, 10, 22).r, x7923_elem_0.r)
              Map[String,Any]("x7929_elem_0" -> x7929_elem_0, "x7935_elem_0" -> x7935_elem_0, "x7941_elem_0" -> x7941_elem_0, "x7947_elem_0" -> x7947_elem_0, "x7953_elem_0" -> x7953_elem_0, "x7959_elem_0" -> x7959_elem_0, "x19814" -> x19814, "x7960" -> x7960, "x7961" -> x7961, "x7962" -> x7962, "x7963" -> x7963, "x7964" -> x7964, "x7965" -> x7965, "x7966" -> x7966, "x7967" -> x7967, "x7968" -> x7968, "x7969" -> x7969, "x7970" -> x7970, "x7971" -> x7971, "x7972" -> x7972, "x7973" -> x7973, "x7974" -> x7974, "x7975" -> x7975, "x7976" -> x7976, "x7977" -> x7977, "x7978" -> x7978, "x7979" -> x7979, "x7980" -> x7980, "x7981" -> x7981, "x7982" -> x7982, "x7983" -> x7983, "x7984" -> x7984, "x7985" -> x7985)
            }
          }
          val block2chunk0sub28: Map[String, Any] = Block2Chunker0Sub28.gen()
          object Block2Chunker0Sub29 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x7986 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7986""")
              x7986.r := Mux((block2chunk0sub28("x19814").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub28("x7929_elem_0").asInstanceOf[FixedPoint].r)
              val x7987 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7987""")
              x7987.r := Mux((block2chunk0sub28("x19814").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub28("x7935_elem_0").asInstanceOf[FixedPoint].r)
              val x7988 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7988""")
              x7988.r := Mux((block2chunk0sub28("x19814").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub28("x7941_elem_0").asInstanceOf[FixedPoint].r)
              val x7989 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7989""")
              x7989.r := Mux((block2chunk0sub28("x19814").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub28("x7947_elem_0").asInstanceOf[FixedPoint].r)
              val x7990 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7990""")
              x7990.r := Mux((block2chunk0sub28("x19814").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub28("x7953_elem_0").asInstanceOf[FixedPoint].r)
              val x7991 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x7991""")
              x7991.r := Mux((block2chunk0sub28("x19814").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub28("x7959_elem_0").asInstanceOf[FixedPoint].r)
              val x7992_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x7992_sum""")
              x7992_sum.r := Math.add(block2chunk0sub27("x7672_mul").asInstanceOf[FixedPoint],1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x7992_sum").r
              val x8024_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x8024_sum""")
              x8024_sum.r := Math.add(block2chunk0sub27("x7672_mul").asInstanceOf[FixedPoint],block2chunk0sub17("x19734").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8024_sum").r
              val x18889 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18889""")
              x18889.r := Math.and(x8024_sum,3L.FP(true, 32, 0),Some(0.2), true.B,"x18889").r
              val x8057 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x8057""")
              x8057.r := Math.arith_right_shift(x8024_sum, 2, Some(0.2), true.B,"x8057").r
              val x8060_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8060_rd""")
              val x8060_rd_banks = List[UInt](x18889.r)
              val x8060_rd_ofs = List[UInt](x8057.r)
              val x8060_rd_en = List[Bool](true.B)
              x8060_rd.toSeq.zip(x4323_img2D_1.connectRPort(8060, x8060_rd_banks, x8060_rd_ofs, io.sigsIn.backpressure, x8060_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19736").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8061_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8061_elem_0""")
              x8061_elem_0.r := x8060_rd(0).r
              val x8066_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8066_rd""")
              val x8066_rd_banks = List[UInt](x18889.r)
              val x8066_rd_ofs = List[UInt](x8057.r)
              val x8066_rd_en = List[Bool](true.B)
              x8066_rd.toSeq.zip(x4323_img2D_1.connectRPort(8066, x8066_rd_banks, x8066_rd_ofs, io.sigsIn.backpressure, x8066_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8067_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8067_elem_0""")
              x8067_elem_0.r := x8066_rd(0).r
              val x8072_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8072_rd""")
              val x8072_rd_banks = List[UInt](x18889.r)
              val x8072_rd_ofs = List[UInt](x8057.r)
              val x8072_rd_en = List[Bool](true.B)
              x8072_rd.toSeq.zip(x4323_img2D_1.connectRPort(8072, x8072_rd_banks, x8072_rd_ofs, io.sigsIn.backpressure, x8072_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8073_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8073_elem_0""")
              x8073_elem_0.r := x8072_rd(0).r
              val x8078_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8078_rd""")
              val x8078_rd_banks = List[UInt](x18889.r)
              val x8078_rd_ofs = List[UInt](x8057.r)
              val x8078_rd_en = List[Bool](true.B)
              x8078_rd.toSeq.zip(x4323_img2D_1.connectRPort(8078, x8078_rd_banks, x8078_rd_ofs, io.sigsIn.backpressure, x8078_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8079_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8079_elem_0""")
              x8079_elem_0.r := x8078_rd(0).r
              val x8084_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8084_rd""")
              val x8084_rd_banks = List[UInt](x18889.r)
              val x8084_rd_ofs = List[UInt](x8057.r)
              val x8084_rd_en = List[Bool](true.B)
              x8084_rd.toSeq.zip(x4323_img2D_1.connectRPort(8084, x8084_rd_banks, x8084_rd_ofs, io.sigsIn.backpressure, x8084_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8085_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8085_elem_0""")
              x8085_elem_0.r := x8084_rd(0).r
              val x8090_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8090_rd""")
              val x8090_rd_banks = List[UInt](x18889.r)
              val x8090_rd_ofs = List[UInt](x8057.r)
              val x8090_rd_en = List[Bool](true.B)
              x8090_rd.toSeq.zip(x4323_img2D_1.connectRPort(8090, x8090_rd_banks, x8090_rd_ofs, io.sigsIn.backpressure, x8090_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8091_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8091_elem_0""")
              x8091_elem_0.r := x8090_rd(0).r
              val x8096_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8096_rd""")
              val x8096_rd_banks = List[UInt](x18889.r)
              val x8096_rd_ofs = List[UInt](x8057.r)
              val x8096_rd_en = List[Bool](true.B)
              x8096_rd.toSeq.zip(x4323_img2D_1.connectRPort(8096, x8096_rd_banks, x8096_rd_ofs, io.sigsIn.backpressure, x8096_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8097_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8097_elem_0""")
              x8097_elem_0.r := x8096_rd(0).r
              val x8102_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8102_rd""")
              val x8102_rd_banks = List[UInt](x18889.r)
              val x8102_rd_ofs = List[UInt](x8057.r)
              val x8102_rd_en = List[Bool](true.B)
              x8102_rd.toSeq.zip(x4323_img2D_1.connectRPort(8102, x8102_rd_banks, x8102_rd_ofs, io.sigsIn.backpressure, x8102_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8103_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8103_elem_0""")
              x8103_elem_0.r := x8102_rd(0).r
              val x8108_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8108_rd""")
              val x8108_rd_banks = List[UInt](x18889.r)
              val x8108_rd_ofs = List[UInt](x8057.r)
              val x8108_rd_en = List[Bool](true.B)
              x8108_rd.toSeq.zip(x4323_img2D_1.connectRPort(8108, x8108_rd_banks, x8108_rd_ofs, io.sigsIn.backpressure, x8108_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8109_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8109_elem_0""")
              x8109_elem_0.r := x8108_rd(0).r
              val x8114_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8114_rd""")
              val x8114_rd_banks = List[UInt](x18889.r)
              val x8114_rd_ofs = List[UInt](x8057.r)
              val x8114_rd_en = List[Bool](true.B)
              x8114_rd.toSeq.zip(x4323_img2D_1.connectRPort(8114, x8114_rd_banks, x8114_rd_ofs, io.sigsIn.backpressure, x8114_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8115_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8115_elem_0""")
              x8115_elem_0.r := x8114_rd(0).r
              val x8120_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8120_rd""")
              val x8120_rd_banks = List[UInt](x18889.r)
              val x8120_rd_ofs = List[UInt](x8057.r)
              val x8120_rd_en = List[Bool](true.B)
              x8120_rd.toSeq.zip(x4323_img2D_1.connectRPort(8120, x8120_rd_banks, x8120_rd_ofs, io.sigsIn.backpressure, x8120_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8121_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8121_elem_0""")
              x8121_elem_0.r := x8120_rd(0).r
              val x8126_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8126_rd""")
              val x8126_rd_banks = List[UInt](x18889.r)
              val x8126_rd_ofs = List[UInt](x8057.r)
              val x8126_rd_en = List[Bool](true.B)
              x8126_rd.toSeq.zip(x4323_img2D_1.connectRPort(8126, x8126_rd_banks, x8126_rd_ofs, io.sigsIn.backpressure, x8126_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8127_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8127_elem_0""")
              x8127_elem_0.r := x8126_rd(0).r
              val x8132_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8132_rd""")
              val x8132_rd_banks = List[UInt](x18889.r)
              val x8132_rd_ofs = List[UInt](x8057.r)
              val x8132_rd_en = List[Bool](true.B)
              x8132_rd.toSeq.zip(x4323_img2D_1.connectRPort(8132, x8132_rd_banks, x8132_rd_ofs, io.sigsIn.backpressure, x8132_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8133_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8133_elem_0""")
              x8133_elem_0.r := x8132_rd(0).r
              val x8138_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8138_rd""")
              val x8138_rd_banks = List[UInt](x18889.r)
              val x8138_rd_ofs = List[UInt](x8057.r)
              val x8138_rd_en = List[Bool](true.B)
              x8138_rd.toSeq.zip(x4323_img2D_1.connectRPort(8138, x8138_rd_banks, x8138_rd_ofs, io.sigsIn.backpressure, x8138_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8139_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8139_elem_0""")
              x8139_elem_0.r := x8138_rd(0).r
              val x8144_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8144_rd""")
              val x8144_rd_banks = List[UInt](x18889.r)
              val x8144_rd_ofs = List[UInt](x8057.r)
              val x8144_rd_en = List[Bool](true.B)
              x8144_rd.toSeq.zip(x4323_img2D_1.connectRPort(8144, x8144_rd_banks, x8144_rd_ofs, io.sigsIn.backpressure, x8144_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8145_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8145_elem_0""")
              x8145_elem_0.r := x8144_rd(0).r
              val x8150_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8150_rd""")
              val x8150_rd_banks = List[UInt](x18889.r)
              val x8150_rd_ofs = List[UInt](x8057.r)
              val x8150_rd_en = List[Bool](true.B)
              x8150_rd.toSeq.zip(x4323_img2D_1.connectRPort(8150, x8150_rd_banks, x8150_rd_ofs, io.sigsIn.backpressure, x8150_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8151_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8151_elem_0""")
              x8151_elem_0.r := x8150_rd(0).r
              val x8156_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8156_rd""")
              val x8156_rd_banks = List[UInt](x18889.r)
              val x8156_rd_ofs = List[UInt](x8057.r)
              val x8156_rd_en = List[Bool](true.B)
              x8156_rd.toSeq.zip(x4323_img2D_1.connectRPort(8156, x8156_rd_banks, x8156_rd_ofs, io.sigsIn.backpressure, x8156_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8157_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8157_elem_0""")
              x8157_elem_0.r := x8156_rd(0).r
              val x8162_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8162_rd""")
              val x8162_rd_banks = List[UInt](x18889.r)
              val x8162_rd_ofs = List[UInt](x8057.r)
              val x8162_rd_en = List[Bool](true.B)
              x8162_rd.toSeq.zip(x4323_img2D_1.connectRPort(8162, x8162_rd_banks, x8162_rd_ofs, io.sigsIn.backpressure, x8162_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8163_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8163_elem_0""")
              x8163_elem_0.r := x8162_rd(0).r
              val x8168_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8168_rd""")
              val x8168_rd_banks = List[UInt](x18889.r)
              val x8168_rd_ofs = List[UInt](x8057.r)
              val x8168_rd_en = List[Bool](true.B)
              x8168_rd.toSeq.zip(x4323_img2D_1.connectRPort(8168, x8168_rd_banks, x8168_rd_ofs, io.sigsIn.backpressure, x8168_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8169_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8169_elem_0""")
              x8169_elem_0.r := x8168_rd(0).r
              val x8174_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8174_rd""")
              val x8174_rd_banks = List[UInt](x18889.r)
              val x8174_rd_ofs = List[UInt](x8057.r)
              val x8174_rd_en = List[Bool](true.B)
              x8174_rd.toSeq.zip(x4323_img2D_1.connectRPort(8174, x8174_rd_banks, x8174_rd_ofs, io.sigsIn.backpressure, x8174_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              Map[String,Any]("x7986" -> x7986, "x7987" -> x7987, "x7988" -> x7988, "x7989" -> x7989, "x7990" -> x7990, "x7991" -> x7991, "x7992_sum" -> x7992_sum, "x18889" -> x18889, "x8057" -> x8057, "x8061_elem_0" -> x8061_elem_0, "x8067_elem_0" -> x8067_elem_0, "x8073_elem_0" -> x8073_elem_0, "x8079_elem_0" -> x8079_elem_0, "x8085_elem_0" -> x8085_elem_0, "x8091_elem_0" -> x8091_elem_0, "x8097_elem_0" -> x8097_elem_0, "x8103_elem_0" -> x8103_elem_0, "x8109_elem_0" -> x8109_elem_0, "x8115_elem_0" -> x8115_elem_0, "x8121_elem_0" -> x8121_elem_0, "x8127_elem_0" -> x8127_elem_0, "x8133_elem_0" -> x8133_elem_0, "x8139_elem_0" -> x8139_elem_0, "x8145_elem_0" -> x8145_elem_0, "x8151_elem_0" -> x8151_elem_0, "x8157_elem_0" -> x8157_elem_0, "x8163_elem_0" -> x8163_elem_0, "x8169_elem_0" -> x8169_elem_0, "x8174_rd" -> x8174_rd)
            }
          }
          val block2chunk0sub29: Map[String, Any] = Block2Chunker0Sub29.gen()
          object Block2Chunker0Sub30 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x8175_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8175_elem_0""")
              x8175_elem_0.r := block2chunk0sub29("x8174_rd").asInstanceOf[Vec[FixedPoint]](0).r
              val x8180_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8180_rd""")
              val x8180_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8180_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8180_rd_en = List[Bool](true.B)
              x8180_rd.toSeq.zip(x4323_img2D_1.connectRPort(8180, x8180_rd_banks, x8180_rd_ofs, io.sigsIn.backpressure, x8180_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8181_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8181_elem_0""")
              x8181_elem_0.r := x8180_rd(0).r
              val x8186_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8186_rd""")
              val x8186_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8186_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8186_rd_en = List[Bool](true.B)
              x8186_rd.toSeq.zip(x4323_img2D_1.connectRPort(8186, x8186_rd_banks, x8186_rd_ofs, io.sigsIn.backpressure, x8186_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8187_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8187_elem_0""")
              x8187_elem_0.r := x8186_rd(0).r
              val x8192_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8192_rd""")
              val x8192_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8192_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8192_rd_en = List[Bool](true.B)
              x8192_rd.toSeq.zip(x4323_img2D_1.connectRPort(8192, x8192_rd_banks, x8192_rd_ofs, io.sigsIn.backpressure, x8192_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8193_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8193_elem_0""")
              x8193_elem_0.r := x8192_rd(0).r
              val x8198_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8198_rd""")
              val x8198_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8198_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8198_rd_en = List[Bool](true.B)
              x8198_rd.toSeq.zip(x4323_img2D_1.connectRPort(8198, x8198_rd_banks, x8198_rd_ofs, io.sigsIn.backpressure, x8198_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8199_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8199_elem_0""")
              x8199_elem_0.r := x8198_rd(0).r
              val x8204_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8204_rd""")
              val x8204_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8204_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8204_rd_en = List[Bool](true.B)
              x8204_rd.toSeq.zip(x4323_img2D_1.connectRPort(8204, x8204_rd_banks, x8204_rd_ofs, io.sigsIn.backpressure, x8204_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8205_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8205_elem_0""")
              x8205_elem_0.r := x8204_rd(0).r
              val x8210_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8210_rd""")
              val x8210_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8210_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8210_rd_en = List[Bool](true.B)
              x8210_rd.toSeq.zip(x4323_img2D_1.connectRPort(8210, x8210_rd_banks, x8210_rd_ofs, io.sigsIn.backpressure, x8210_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8211_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8211_elem_0""")
              x8211_elem_0.r := x8210_rd(0).r
              val x8216_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8216_rd""")
              val x8216_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8216_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8216_rd_en = List[Bool](true.B)
              x8216_rd.toSeq.zip(x4323_img2D_1.connectRPort(8216, x8216_rd_banks, x8216_rd_ofs, io.sigsIn.backpressure, x8216_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8217_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8217_elem_0""")
              x8217_elem_0.r := x8216_rd(0).r
              val x8222_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8222_rd""")
              val x8222_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8222_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8222_rd_en = List[Bool](true.B)
              x8222_rd.toSeq.zip(x4323_img2D_1.connectRPort(8222, x8222_rd_banks, x8222_rd_ofs, io.sigsIn.backpressure, x8222_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8223_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8223_elem_0""")
              x8223_elem_0.r := x8222_rd(0).r
              val x8228_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8228_rd""")
              val x8228_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8228_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8228_rd_en = List[Bool](true.B)
              x8228_rd.toSeq.zip(x4323_img2D_1.connectRPort(8228, x8228_rd_banks, x8228_rd_ofs, io.sigsIn.backpressure, x8228_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8229_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8229_elem_0""")
              x8229_elem_0.r := x8228_rd(0).r
              val x8234_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8234_rd""")
              val x8234_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8234_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8234_rd_en = List[Bool](true.B)
              x8234_rd.toSeq.zip(x4323_img2D_1.connectRPort(8234, x8234_rd_banks, x8234_rd_ofs, io.sigsIn.backpressure, x8234_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8235_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8235_elem_0""")
              x8235_elem_0.r := x8234_rd(0).r
              val x8240_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8240_rd""")
              val x8240_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8240_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8240_rd_en = List[Bool](true.B)
              x8240_rd.toSeq.zip(x4323_img2D_1.connectRPort(8240, x8240_rd_banks, x8240_rd_ofs, io.sigsIn.backpressure, x8240_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8241_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8241_elem_0""")
              x8241_elem_0.r := x8240_rd(0).r
              val x8246_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8246_rd""")
              val x8246_rd_banks = List[UInt](block2chunk0sub29("x18889").asInstanceOf[FixedPoint].r)
              val x8246_rd_ofs = List[UInt](block2chunk0sub29("x8057").asInstanceOf[FixedPoint].r)
              val x8246_rd_en = List[Bool](true.B)
              x8246_rd.toSeq.zip(x4323_img2D_1.connectRPort(8246, x8246_rd_banks, x8246_rd_ofs, io.sigsIn.backpressure, x8246_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub17("x19735").asInstanceOf[Bool] & block2chunk0sub17("x19740").asInstanceOf[Bool] & block2chunk0sub17("x19738").asInstanceOf[Bool] & block2chunk0sub17("x19739").asInstanceOf[Bool] & block2chunk0sub17("x19737").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8247_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8247_elem_0""")
              x8247_elem_0.r := x8246_rd(0).r
              val x19815 = Wire(Bool()).suggestName("x19815_x7576_D3") 
              x19815.r := getRetimed(block2chunk0sub26("x7576").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
              val x8248 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8248""")
              x8248.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8061_elem_0").asInstanceOf[FixedPoint].r)
              val x8249 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8249""")
              x8249.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8067_elem_0").asInstanceOf[FixedPoint].r)
              val x8250 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8250""")
              x8250.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8073_elem_0").asInstanceOf[FixedPoint].r)
              val x8251 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8251""")
              x8251.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8079_elem_0").asInstanceOf[FixedPoint].r)
              val x8252 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8252""")
              x8252.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8085_elem_0").asInstanceOf[FixedPoint].r)
              val x8253 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8253""")
              x8253.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8091_elem_0").asInstanceOf[FixedPoint].r)
              val x8254 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8254""")
              x8254.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8097_elem_0").asInstanceOf[FixedPoint].r)
              val x8255 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8255""")
              x8255.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8103_elem_0").asInstanceOf[FixedPoint].r)
              val x8256 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8256""")
              x8256.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8109_elem_0").asInstanceOf[FixedPoint].r)
              val x8257 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8257""")
              x8257.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8115_elem_0").asInstanceOf[FixedPoint].r)
              val x8258 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8258""")
              x8258.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8121_elem_0").asInstanceOf[FixedPoint].r)
              val x8259 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8259""")
              x8259.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8127_elem_0").asInstanceOf[FixedPoint].r)
              val x8260 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8260""")
              x8260.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8133_elem_0").asInstanceOf[FixedPoint].r)
              val x8261 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8261""")
              x8261.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8139_elem_0").asInstanceOf[FixedPoint].r)
              val x8262 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8262""")
              x8262.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8145_elem_0").asInstanceOf[FixedPoint].r)
              val x8263 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8263""")
              x8263.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8151_elem_0").asInstanceOf[FixedPoint].r)
              val x8264 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8264""")
              x8264.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8157_elem_0").asInstanceOf[FixedPoint].r)
              val x8265 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8265""")
              x8265.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8163_elem_0").asInstanceOf[FixedPoint].r)
              val x8266 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8266""")
              x8266.r := Mux((x19815), 0.FP(true, 10, 22).r, block2chunk0sub29("x8169_elem_0").asInstanceOf[FixedPoint].r)
              val x8267 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8267""")
              x8267.r := Mux((x19815), 0.FP(true, 10, 22).r, x8175_elem_0.r)
              val x8268 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8268""")
              x8268.r := Mux((x19815), 0.FP(true, 10, 22).r, x8181_elem_0.r)
              val x8269 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8269""")
              x8269.r := Mux((x19815), 0.FP(true, 10, 22).r, x8187_elem_0.r)
              val x8270 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8270""")
              x8270.r := Mux((x19815), 0.FP(true, 10, 22).r, x8193_elem_0.r)
              Map[String,Any]("x8199_elem_0" -> x8199_elem_0, "x8205_elem_0" -> x8205_elem_0, "x8211_elem_0" -> x8211_elem_0, "x8217_elem_0" -> x8217_elem_0, "x8223_elem_0" -> x8223_elem_0, "x8229_elem_0" -> x8229_elem_0, "x8235_elem_0" -> x8235_elem_0, "x8241_elem_0" -> x8241_elem_0, "x8247_elem_0" -> x8247_elem_0, "x19815" -> x19815, "x8248" -> x8248, "x8249" -> x8249, "x8250" -> x8250, "x8251" -> x8251, "x8252" -> x8252, "x8253" -> x8253, "x8254" -> x8254, "x8255" -> x8255, "x8256" -> x8256, "x8257" -> x8257, "x8258" -> x8258, "x8259" -> x8259, "x8260" -> x8260, "x8261" -> x8261, "x8262" -> x8262, "x8263" -> x8263, "x8264" -> x8264, "x8265" -> x8265, "x8266" -> x8266, "x8267" -> x8267, "x8268" -> x8268, "x8269" -> x8269, "x8270" -> x8270)
            }
          }
          val block2chunk0sub30: Map[String, Any] = Block2Chunker0Sub30.gen()
          object Block2Chunker0Sub31 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x8271 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8271""")
              x8271.r := Mux((block2chunk0sub30("x19815").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub30("x8199_elem_0").asInstanceOf[FixedPoint].r)
              val x8272 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8272""")
              x8272.r := Mux((block2chunk0sub30("x19815").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub30("x8205_elem_0").asInstanceOf[FixedPoint].r)
              val x8273 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8273""")
              x8273.r := Mux((block2chunk0sub30("x19815").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub30("x8211_elem_0").asInstanceOf[FixedPoint].r)
              val x8274 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8274""")
              x8274.r := Mux((block2chunk0sub30("x19815").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub30("x8217_elem_0").asInstanceOf[FixedPoint].r)
              val x8275 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8275""")
              x8275.r := Mux((block2chunk0sub30("x19815").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub30("x8223_elem_0").asInstanceOf[FixedPoint].r)
              val x8276 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8276""")
              x8276.r := Mux((block2chunk0sub30("x19815").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub30("x8229_elem_0").asInstanceOf[FixedPoint].r)
              val x8277 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8277""")
              x8277.r := Mux((block2chunk0sub30("x19815").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub30("x8235_elem_0").asInstanceOf[FixedPoint].r)
              val x8278 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8278""")
              x8278.r := Mux((block2chunk0sub30("x19815").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub30("x8241_elem_0").asInstanceOf[FixedPoint].r)
              val x8279 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8279""")
              x8279.r := Mux((block2chunk0sub30("x19815").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub30("x8247_elem_0").asInstanceOf[FixedPoint].r)
              val x8280 = Wire(Bool()).suggestName("""x8280""")
              x8280 := block2chunk0sub26("x7576").asInstanceOf[Bool] | block2chunk0sub19("x6424").asInstanceOf[Bool]
              val x8312_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x8312_sum""")
              x8312_sum.r := Math.add(block2chunk0sub29("x7992_sum").asInstanceOf[FixedPoint],block2chunk0sub14("x19695").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8312_sum").r
              val x18890 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18890""")
              x18890.r := Math.and(x8312_sum,3L.FP(true, 32, 0),Some(0.2), true.B,"x18890").r
              val x8345 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x8345""")
              x8345.r := Math.arith_right_shift(x8312_sum, 2, Some(0.2), true.B,"x8345").r
              val x8348_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8348_rd""")
              val x8348_rd_banks = List[UInt](x18890.r)
              val x8348_rd_ofs = List[UInt](x8345.r)
              val x8348_rd_en = List[Bool](true.B)
              x8348_rd.toSeq.zip(x4325_img2D_3.connectRPort(8348, x8348_rd_banks, x8348_rd_ofs, io.sigsIn.backpressure, x8348_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub14("x19697").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8349_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8349_elem_0""")
              x8349_elem_0.r := x8348_rd(0).r
              val x8354_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8354_rd""")
              val x8354_rd_banks = List[UInt](x18890.r)
              val x8354_rd_ofs = List[UInt](x8345.r)
              val x8354_rd_en = List[Bool](true.B)
              x8354_rd.toSeq.zip(x4325_img2D_3.connectRPort(8354, x8354_rd_banks, x8354_rd_ofs, io.sigsIn.backpressure, x8354_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8355_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8355_elem_0""")
              x8355_elem_0.r := x8354_rd(0).r
              val x8360_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8360_rd""")
              val x8360_rd_banks = List[UInt](x18890.r)
              val x8360_rd_ofs = List[UInt](x8345.r)
              val x8360_rd_en = List[Bool](true.B)
              x8360_rd.toSeq.zip(x4325_img2D_3.connectRPort(8360, x8360_rd_banks, x8360_rd_ofs, io.sigsIn.backpressure, x8360_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8361_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8361_elem_0""")
              x8361_elem_0.r := x8360_rd(0).r
              val x8366_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8366_rd""")
              val x8366_rd_banks = List[UInt](x18890.r)
              val x8366_rd_ofs = List[UInt](x8345.r)
              val x8366_rd_en = List[Bool](true.B)
              x8366_rd.toSeq.zip(x4325_img2D_3.connectRPort(8366, x8366_rd_banks, x8366_rd_ofs, io.sigsIn.backpressure, x8366_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8367_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8367_elem_0""")
              x8367_elem_0.r := x8366_rd(0).r
              val x8372_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8372_rd""")
              val x8372_rd_banks = List[UInt](x18890.r)
              val x8372_rd_ofs = List[UInt](x8345.r)
              val x8372_rd_en = List[Bool](true.B)
              x8372_rd.toSeq.zip(x4325_img2D_3.connectRPort(8372, x8372_rd_banks, x8372_rd_ofs, io.sigsIn.backpressure, x8372_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8373_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8373_elem_0""")
              x8373_elem_0.r := x8372_rd(0).r
              val x8378_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8378_rd""")
              val x8378_rd_banks = List[UInt](x18890.r)
              val x8378_rd_ofs = List[UInt](x8345.r)
              val x8378_rd_en = List[Bool](true.B)
              x8378_rd.toSeq.zip(x4325_img2D_3.connectRPort(8378, x8378_rd_banks, x8378_rd_ofs, io.sigsIn.backpressure, x8378_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8379_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8379_elem_0""")
              x8379_elem_0.r := x8378_rd(0).r
              val x8384_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8384_rd""")
              val x8384_rd_banks = List[UInt](x18890.r)
              val x8384_rd_ofs = List[UInt](x8345.r)
              val x8384_rd_en = List[Bool](true.B)
              x8384_rd.toSeq.zip(x4325_img2D_3.connectRPort(8384, x8384_rd_banks, x8384_rd_ofs, io.sigsIn.backpressure, x8384_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8385_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8385_elem_0""")
              x8385_elem_0.r := x8384_rd(0).r
              val x8390_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8390_rd""")
              val x8390_rd_banks = List[UInt](x18890.r)
              val x8390_rd_ofs = List[UInt](x8345.r)
              val x8390_rd_en = List[Bool](true.B)
              x8390_rd.toSeq.zip(x4325_img2D_3.connectRPort(8390, x8390_rd_banks, x8390_rd_ofs, io.sigsIn.backpressure, x8390_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8391_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8391_elem_0""")
              x8391_elem_0.r := x8390_rd(0).r
              val x8396_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8396_rd""")
              val x8396_rd_banks = List[UInt](x18890.r)
              val x8396_rd_ofs = List[UInt](x8345.r)
              val x8396_rd_en = List[Bool](true.B)
              x8396_rd.toSeq.zip(x4325_img2D_3.connectRPort(8396, x8396_rd_banks, x8396_rd_ofs, io.sigsIn.backpressure, x8396_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8397_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8397_elem_0""")
              x8397_elem_0.r := x8396_rd(0).r
              val x8402_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8402_rd""")
              val x8402_rd_banks = List[UInt](x18890.r)
              val x8402_rd_ofs = List[UInt](x8345.r)
              val x8402_rd_en = List[Bool](true.B)
              x8402_rd.toSeq.zip(x4325_img2D_3.connectRPort(8402, x8402_rd_banks, x8402_rd_ofs, io.sigsIn.backpressure, x8402_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8403_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8403_elem_0""")
              x8403_elem_0.r := x8402_rd(0).r
              val x8408_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8408_rd""")
              val x8408_rd_banks = List[UInt](x18890.r)
              val x8408_rd_ofs = List[UInt](x8345.r)
              val x8408_rd_en = List[Bool](true.B)
              x8408_rd.toSeq.zip(x4325_img2D_3.connectRPort(8408, x8408_rd_banks, x8408_rd_ofs, io.sigsIn.backpressure, x8408_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8409_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8409_elem_0""")
              x8409_elem_0.r := x8408_rd(0).r
              val x8414_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8414_rd""")
              val x8414_rd_banks = List[UInt](x18890.r)
              val x8414_rd_ofs = List[UInt](x8345.r)
              val x8414_rd_en = List[Bool](true.B)
              x8414_rd.toSeq.zip(x4325_img2D_3.connectRPort(8414, x8414_rd_banks, x8414_rd_ofs, io.sigsIn.backpressure, x8414_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8415_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8415_elem_0""")
              x8415_elem_0.r := x8414_rd(0).r
              val x8420_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8420_rd""")
              val x8420_rd_banks = List[UInt](x18890.r)
              val x8420_rd_ofs = List[UInt](x8345.r)
              val x8420_rd_en = List[Bool](true.B)
              x8420_rd.toSeq.zip(x4325_img2D_3.connectRPort(8420, x8420_rd_banks, x8420_rd_ofs, io.sigsIn.backpressure, x8420_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8421_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8421_elem_0""")
              x8421_elem_0.r := x8420_rd(0).r
              val x8426_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8426_rd""")
              val x8426_rd_banks = List[UInt](x18890.r)
              val x8426_rd_ofs = List[UInt](x8345.r)
              val x8426_rd_en = List[Bool](true.B)
              x8426_rd.toSeq.zip(x4325_img2D_3.connectRPort(8426, x8426_rd_banks, x8426_rd_ofs, io.sigsIn.backpressure, x8426_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8427_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8427_elem_0""")
              x8427_elem_0.r := x8426_rd(0).r
              val x8432_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8432_rd""")
              val x8432_rd_banks = List[UInt](x18890.r)
              val x8432_rd_ofs = List[UInt](x8345.r)
              val x8432_rd_en = List[Bool](true.B)
              x8432_rd.toSeq.zip(x4325_img2D_3.connectRPort(8432, x8432_rd_banks, x8432_rd_ofs, io.sigsIn.backpressure, x8432_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8433_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8433_elem_0""")
              x8433_elem_0.r := x8432_rd(0).r
              val x8438_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8438_rd""")
              val x8438_rd_banks = List[UInt](x18890.r)
              val x8438_rd_ofs = List[UInt](x8345.r)
              val x8438_rd_en = List[Bool](true.B)
              x8438_rd.toSeq.zip(x4325_img2D_3.connectRPort(8438, x8438_rd_banks, x8438_rd_ofs, io.sigsIn.backpressure, x8438_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8439_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8439_elem_0""")
              x8439_elem_0.r := x8438_rd(0).r
              val x8444_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8444_rd""")
              val x8444_rd_banks = List[UInt](x18890.r)
              val x8444_rd_ofs = List[UInt](x8345.r)
              val x8444_rd_en = List[Bool](true.B)
              x8444_rd.toSeq.zip(x4325_img2D_3.connectRPort(8444, x8444_rd_banks, x8444_rd_ofs, io.sigsIn.backpressure, x8444_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8445_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8445_elem_0""")
              x8445_elem_0.r := x8444_rd(0).r
              val x8450_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8450_rd""")
              val x8450_rd_banks = List[UInt](x18890.r)
              val x8450_rd_ofs = List[UInt](x8345.r)
              val x8450_rd_en = List[Bool](true.B)
              x8450_rd.toSeq.zip(x4325_img2D_3.connectRPort(8450, x8450_rd_banks, x8450_rd_ofs, io.sigsIn.backpressure, x8450_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8451_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8451_elem_0""")
              x8451_elem_0.r := x8450_rd(0).r
              Map[String,Any]("x8271" -> x8271, "x8272" -> x8272, "x8273" -> x8273, "x8274" -> x8274, "x8275" -> x8275, "x8276" -> x8276, "x8277" -> x8277, "x8278" -> x8278, "x8279" -> x8279, "x8280" -> x8280, "x18890" -> x18890, "x8345" -> x8345, "x8349_elem_0" -> x8349_elem_0, "x8355_elem_0" -> x8355_elem_0, "x8361_elem_0" -> x8361_elem_0, "x8367_elem_0" -> x8367_elem_0, "x8373_elem_0" -> x8373_elem_0, "x8379_elem_0" -> x8379_elem_0, "x8385_elem_0" -> x8385_elem_0, "x8391_elem_0" -> x8391_elem_0, "x8397_elem_0" -> x8397_elem_0, "x8403_elem_0" -> x8403_elem_0, "x8409_elem_0" -> x8409_elem_0, "x8415_elem_0" -> x8415_elem_0, "x8421_elem_0" -> x8421_elem_0, "x8427_elem_0" -> x8427_elem_0, "x8433_elem_0" -> x8433_elem_0, "x8439_elem_0" -> x8439_elem_0, "x8445_elem_0" -> x8445_elem_0, "x8451_elem_0" -> x8451_elem_0)
            }
          }
          val block2chunk0sub31: Map[String, Any] = Block2Chunker0Sub31.gen()
          object Block2Chunker0Sub32 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x8456_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8456_rd""")
              val x8456_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8456_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8456_rd_en = List[Bool](true.B)
              x8456_rd.toSeq.zip(x4325_img2D_3.connectRPort(8456, x8456_rd_banks, x8456_rd_ofs, io.sigsIn.backpressure, x8456_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8457_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8457_elem_0""")
              x8457_elem_0.r := x8456_rd(0).r
              val x8462_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8462_rd""")
              val x8462_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8462_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8462_rd_en = List[Bool](true.B)
              x8462_rd.toSeq.zip(x4325_img2D_3.connectRPort(8462, x8462_rd_banks, x8462_rd_ofs, io.sigsIn.backpressure, x8462_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8463_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8463_elem_0""")
              x8463_elem_0.r := x8462_rd(0).r
              val x8468_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8468_rd""")
              val x8468_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8468_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8468_rd_en = List[Bool](true.B)
              x8468_rd.toSeq.zip(x4325_img2D_3.connectRPort(8468, x8468_rd_banks, x8468_rd_ofs, io.sigsIn.backpressure, x8468_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8469_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8469_elem_0""")
              x8469_elem_0.r := x8468_rd(0).r
              val x8474_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8474_rd""")
              val x8474_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8474_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8474_rd_en = List[Bool](true.B)
              x8474_rd.toSeq.zip(x4325_img2D_3.connectRPort(8474, x8474_rd_banks, x8474_rd_ofs, io.sigsIn.backpressure, x8474_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8475_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8475_elem_0""")
              x8475_elem_0.r := x8474_rd(0).r
              val x8480_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8480_rd""")
              val x8480_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8480_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8480_rd_en = List[Bool](true.B)
              x8480_rd.toSeq.zip(x4325_img2D_3.connectRPort(8480, x8480_rd_banks, x8480_rd_ofs, io.sigsIn.backpressure, x8480_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8481_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8481_elem_0""")
              x8481_elem_0.r := x8480_rd(0).r
              val x8486_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8486_rd""")
              val x8486_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8486_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8486_rd_en = List[Bool](true.B)
              x8486_rd.toSeq.zip(x4325_img2D_3.connectRPort(8486, x8486_rd_banks, x8486_rd_ofs, io.sigsIn.backpressure, x8486_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8487_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8487_elem_0""")
              x8487_elem_0.r := x8486_rd(0).r
              val x8492_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8492_rd""")
              val x8492_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8492_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8492_rd_en = List[Bool](true.B)
              x8492_rd.toSeq.zip(x4325_img2D_3.connectRPort(8492, x8492_rd_banks, x8492_rd_ofs, io.sigsIn.backpressure, x8492_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8493_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8493_elem_0""")
              x8493_elem_0.r := x8492_rd(0).r
              val x8498_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8498_rd""")
              val x8498_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8498_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8498_rd_en = List[Bool](true.B)
              x8498_rd.toSeq.zip(x4325_img2D_3.connectRPort(8498, x8498_rd_banks, x8498_rd_ofs, io.sigsIn.backpressure, x8498_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8499_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8499_elem_0""")
              x8499_elem_0.r := x8498_rd(0).r
              val x8504_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8504_rd""")
              val x8504_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8504_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8504_rd_en = List[Bool](true.B)
              x8504_rd.toSeq.zip(x4325_img2D_3.connectRPort(8504, x8504_rd_banks, x8504_rd_ofs, io.sigsIn.backpressure, x8504_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8505_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8505_elem_0""")
              x8505_elem_0.r := x8504_rd(0).r
              val x8510_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8510_rd""")
              val x8510_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8510_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8510_rd_en = List[Bool](true.B)
              x8510_rd.toSeq.zip(x4325_img2D_3.connectRPort(8510, x8510_rd_banks, x8510_rd_ofs, io.sigsIn.backpressure, x8510_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8511_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8511_elem_0""")
              x8511_elem_0.r := x8510_rd(0).r
              val x8516_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8516_rd""")
              val x8516_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8516_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8516_rd_en = List[Bool](true.B)
              x8516_rd.toSeq.zip(x4325_img2D_3.connectRPort(8516, x8516_rd_banks, x8516_rd_ofs, io.sigsIn.backpressure, x8516_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8517_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8517_elem_0""")
              x8517_elem_0.r := x8516_rd(0).r
              val x8522_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8522_rd""")
              val x8522_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8522_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8522_rd_en = List[Bool](true.B)
              x8522_rd.toSeq.zip(x4325_img2D_3.connectRPort(8522, x8522_rd_banks, x8522_rd_ofs, io.sigsIn.backpressure, x8522_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8523_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8523_elem_0""")
              x8523_elem_0.r := x8522_rd(0).r
              val x8528_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8528_rd""")
              val x8528_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8528_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8528_rd_en = List[Bool](true.B)
              x8528_rd.toSeq.zip(x4325_img2D_3.connectRPort(8528, x8528_rd_banks, x8528_rd_ofs, io.sigsIn.backpressure, x8528_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8529_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8529_elem_0""")
              x8529_elem_0.r := x8528_rd(0).r
              val x8534_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x8534_rd""")
              val x8534_rd_banks = List[UInt](block2chunk0sub31("x18890").asInstanceOf[FixedPoint].r)
              val x8534_rd_ofs = List[UInt](block2chunk0sub31("x8345").asInstanceOf[FixedPoint].r)
              val x8534_rd_en = List[Bool](true.B)
              x8534_rd.toSeq.zip(x4325_img2D_3.connectRPort(8534, x8534_rd_banks, x8534_rd_ofs, io.sigsIn.backpressure, x8534_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt, rr, io.sigsIn.backpressure) && block2chunk0sub14("x19696").asInstanceOf[Bool] & block2chunk0sub15("x19699").asInstanceOf[Bool] & block2chunk0sub15("x19701").asInstanceOf[Bool] & block2chunk0sub15("x19700").asInstanceOf[Bool] & block2chunk0sub14("x19698").asInstanceOf[Bool]), false)).foreach{case (a,b) => a := b}
              val x8535_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8535_elem_0""")
              x8535_elem_0.r := x8534_rd(0).r
              val x19816 = Wire(Bool()).suggestName("x19816_x8280_D4") 
              x19816.r := getRetimed(block2chunk0sub31("x8280").asInstanceOf[Bool].r, 4.toInt, io.sigsIn.backpressure)
              val x8536 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8536""")
              x8536.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8349_elem_0").asInstanceOf[FixedPoint].r)
              val x8537 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8537""")
              x8537.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8355_elem_0").asInstanceOf[FixedPoint].r)
              val x8538 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8538""")
              x8538.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8361_elem_0").asInstanceOf[FixedPoint].r)
              val x8539 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8539""")
              x8539.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8367_elem_0").asInstanceOf[FixedPoint].r)
              val x8540 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8540""")
              x8540.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8373_elem_0").asInstanceOf[FixedPoint].r)
              val x8541 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8541""")
              x8541.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8379_elem_0").asInstanceOf[FixedPoint].r)
              val x8542 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8542""")
              x8542.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8385_elem_0").asInstanceOf[FixedPoint].r)
              val x8543 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8543""")
              x8543.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8391_elem_0").asInstanceOf[FixedPoint].r)
              val x8544 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8544""")
              x8544.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8397_elem_0").asInstanceOf[FixedPoint].r)
              val x8545 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8545""")
              x8545.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8403_elem_0").asInstanceOf[FixedPoint].r)
              val x8546 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8546""")
              x8546.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8409_elem_0").asInstanceOf[FixedPoint].r)
              val x8547 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8547""")
              x8547.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8415_elem_0").asInstanceOf[FixedPoint].r)
              val x8548 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8548""")
              x8548.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8421_elem_0").asInstanceOf[FixedPoint].r)
              val x8549 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8549""")
              x8549.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8427_elem_0").asInstanceOf[FixedPoint].r)
              val x8550 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8550""")
              x8550.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8433_elem_0").asInstanceOf[FixedPoint].r)
              val x8551 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8551""")
              x8551.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8439_elem_0").asInstanceOf[FixedPoint].r)
              val x8552 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8552""")
              x8552.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8445_elem_0").asInstanceOf[FixedPoint].r)
              val x8553 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8553""")
              x8553.r := Mux((x19816), 0.FP(true, 10, 22).r, block2chunk0sub31("x8451_elem_0").asInstanceOf[FixedPoint].r)
              val x8554 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8554""")
              x8554.r := Mux((x19816), 0.FP(true, 10, 22).r, x8457_elem_0.r)
              val x8555 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8555""")
              x8555.r := Mux((x19816), 0.FP(true, 10, 22).r, x8463_elem_0.r)
              Map[String,Any]("x8469_elem_0" -> x8469_elem_0, "x8475_elem_0" -> x8475_elem_0, "x8481_elem_0" -> x8481_elem_0, "x8487_elem_0" -> x8487_elem_0, "x8493_elem_0" -> x8493_elem_0, "x8499_elem_0" -> x8499_elem_0, "x8505_elem_0" -> x8505_elem_0, "x8511_elem_0" -> x8511_elem_0, "x8517_elem_0" -> x8517_elem_0, "x8523_elem_0" -> x8523_elem_0, "x8529_elem_0" -> x8529_elem_0, "x8535_elem_0" -> x8535_elem_0, "x19816" -> x19816, "x8536" -> x8536, "x8537" -> x8537, "x8538" -> x8538, "x8539" -> x8539, "x8540" -> x8540, "x8541" -> x8541, "x8542" -> x8542, "x8543" -> x8543, "x8544" -> x8544, "x8545" -> x8545, "x8546" -> x8546, "x8547" -> x8547, "x8548" -> x8548, "x8549" -> x8549, "x8550" -> x8550, "x8551" -> x8551, "x8552" -> x8552, "x8553" -> x8553, "x8554" -> x8554, "x8555" -> x8555)
            }
          }
          val block2chunk0sub32: Map[String, Any] = Block2Chunker0Sub32.gen()
          object Block2Chunker0Sub33 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x8556 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8556""")
              x8556.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8469_elem_0").asInstanceOf[FixedPoint].r)
              val x8557 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8557""")
              x8557.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8475_elem_0").asInstanceOf[FixedPoint].r)
              val x8558 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8558""")
              x8558.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8481_elem_0").asInstanceOf[FixedPoint].r)
              val x8559 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8559""")
              x8559.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8487_elem_0").asInstanceOf[FixedPoint].r)
              val x8560 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8560""")
              x8560.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8493_elem_0").asInstanceOf[FixedPoint].r)
              val x8561 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8561""")
              x8561.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8499_elem_0").asInstanceOf[FixedPoint].r)
              val x8562 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8562""")
              x8562.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8505_elem_0").asInstanceOf[FixedPoint].r)
              val x8563 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8563""")
              x8563.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8511_elem_0").asInstanceOf[FixedPoint].r)
              val x8564 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8564""")
              x8564.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8517_elem_0").asInstanceOf[FixedPoint].r)
              val x8565 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8565""")
              x8565.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8523_elem_0").asInstanceOf[FixedPoint].r)
              val x8566 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8566""")
              x8566.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8529_elem_0").asInstanceOf[FixedPoint].r)
              val x8567 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8567""")
              x8567.r := Mux((block2chunk0sub32("x19816").asInstanceOf[Bool]), 0.FP(true, 10, 22).r, block2chunk0sub32("x8535_elem_0").asInstanceOf[FixedPoint].r)
              val x19817 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19817_x5327_elem_0_D9") 
              x19817.r := getRetimed(block2chunk0sub3("x5327_elem_0").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19818 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19818_x6392_D1") 
              x19818.r := getRetimed(block2chunk0sub18("x6392").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8600_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8600_x18""")
              x8600_x18.r := (Math.mul(x19818, x19817, Some(6.0), true.B, Truncate, Wrapping, "x8600_x18")).r
              val x19819 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19819_x6393_D1") 
              x19819.r := getRetimed(block2chunk0sub18("x6393").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19820 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19820_x5328_elem_1_D9") 
              x19820.r := getRetimed(block2chunk0sub3("x5328_elem_1").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8601_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8601_x18""")
              x8601_x18.r := (Math.mul(x19819, x19820, Some(6.0), true.B, Truncate, Wrapping, "x8601_x18")).r
              val x19821 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19821_x6394_D1") 
              x19821.r := getRetimed(block2chunk0sub18("x6394").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19822 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19822_x5329_elem_2_D9") 
              x19822.r := getRetimed(block2chunk0sub3("x5329_elem_2").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8602_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8602_x18""")
              x8602_x18.r := (Math.mul(x19821, x19822, Some(6.0), true.B, Truncate, Wrapping, "x8602_x18")).r
              val x19823 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19823_x6395_D1") 
              x19823.r := getRetimed(block2chunk0sub18("x6395").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19824 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19824_x5330_elem_3_D9") 
              x19824.r := getRetimed(block2chunk0sub3("x5330_elem_3").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8603_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8603_x18""")
              x8603_x18.r := (Math.mul(x19823, x19824, Some(6.0), true.B, Truncate, Wrapping, "x8603_x18")).r
              val x19825 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19825_x5331_elem_4_D9") 
              x19825.r := getRetimed(block2chunk0sub3("x5331_elem_4").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19826 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19826_x6396_D1") 
              x19826.r := getRetimed(block2chunk0sub18("x6396").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8604_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8604_x18""")
              x8604_x18.r := (Math.mul(x19826, x19825, Some(6.0), true.B, Truncate, Wrapping, "x8604_x18")).r
              val x19827 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19827_x6397_D1") 
              x19827.r := getRetimed(block2chunk0sub18("x6397").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19828 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19828_x5332_elem_5_D9") 
              x19828.r := getRetimed(block2chunk0sub3("x5332_elem_5").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8605_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8605_x18""")
              x8605_x18.r := (Math.mul(x19827, x19828, Some(6.0), true.B, Truncate, Wrapping, "x8605_x18")).r
              val x19829 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19829_x6398_D1") 
              x19829.r := getRetimed(block2chunk0sub18("x6398").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19830 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19830_x5333_elem_6_D9") 
              x19830.r := getRetimed(block2chunk0sub3("x5333_elem_6").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8606_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8606_x18""")
              x8606_x18.r := (Math.mul(x19829, x19830, Some(6.0), true.B, Truncate, Wrapping, "x8606_x18")).r
              val x19831 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19831_x6399_D1") 
              x19831.r := getRetimed(block2chunk0sub18("x6399").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19832 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19832_x5334_elem_7_D9") 
              x19832.r := getRetimed(block2chunk0sub3("x5334_elem_7").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8607_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8607_x18""")
              x8607_x18.r := (Math.mul(x19831, x19832, Some(6.0), true.B, Truncate, Wrapping, "x8607_x18")).r
              val x19833 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19833_x5335_elem_8_D9") 
              x19833.r := getRetimed(block2chunk0sub3("x5335_elem_8").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19834 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19834_x6400_D1") 
              x19834.r := getRetimed(block2chunk0sub18("x6400").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8608_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8608_x18""")
              x8608_x18.r := (Math.mul(x19834, x19833, Some(6.0), true.B, Truncate, Wrapping, "x8608_x18")).r
              val x19835 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19835_x5336_elem_9_D9") 
              x19835.r := getRetimed(block2chunk0sub3("x5336_elem_9").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19836 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19836_x6401_D1") 
              x19836.r := getRetimed(block2chunk0sub18("x6401").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8609_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8609_x18""")
              x8609_x18.r := (Math.mul(x19836, x19835, Some(6.0), true.B, Truncate, Wrapping, "x8609_x18")).r
              val x19837 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19837_x5337_elem_10_D9") 
              x19837.r := getRetimed(block2chunk0sub3("x5337_elem_10").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19838 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19838_x6402_D1") 
              x19838.r := getRetimed(block2chunk0sub18("x6402").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8610_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8610_x18""")
              x8610_x18.r := (Math.mul(x19838, x19837, Some(6.0), true.B, Truncate, Wrapping, "x8610_x18")).r
              val x19839 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19839_x6403_D1") 
              x19839.r := getRetimed(block2chunk0sub18("x6403").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19840 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19840_x5338_elem_11_D9") 
              x19840.r := getRetimed(block2chunk0sub3("x5338_elem_11").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8611_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8611_x18""")
              x8611_x18.r := (Math.mul(x19839, x19840, Some(6.0), true.B, Truncate, Wrapping, "x8611_x18")).r
              val x19841 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19841_x6404_D1") 
              x19841.r := getRetimed(block2chunk0sub18("x6404").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x8556" -> x8556, "x8557" -> x8557, "x8558" -> x8558, "x8559" -> x8559, "x8560" -> x8560, "x8561" -> x8561, "x8562" -> x8562, "x8563" -> x8563, "x8564" -> x8564, "x8565" -> x8565, "x8566" -> x8566, "x8567" -> x8567, "x8600_x18" -> x8600_x18, "x8601_x18" -> x8601_x18, "x8602_x18" -> x8602_x18, "x8603_x18" -> x8603_x18, "x8604_x18" -> x8604_x18, "x8605_x18" -> x8605_x18, "x8606_x18" -> x8606_x18, "x8607_x18" -> x8607_x18, "x8608_x18" -> x8608_x18, "x8609_x18" -> x8609_x18, "x8610_x18" -> x8610_x18, "x8611_x18" -> x8611_x18, "x19841" -> x19841)
            }
          }
          val block2chunk0sub33: Map[String, Any] = Block2Chunker0Sub33.gen()
          object Block2Chunker0Sub34 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x19842 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19842_x5339_elem_12_D9") 
              x19842.r := getRetimed(block2chunk0sub3("x5339_elem_12").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8612_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8612_x18""")
              x8612_x18.r := (Math.mul(block2chunk0sub33("x19841").asInstanceOf[FixedPoint], x19842, Some(6.0), true.B, Truncate, Wrapping, "x8612_x18")).r
              val x19843 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19843_x5340_elem_13_D9") 
              x19843.r := getRetimed(block2chunk0sub3("x5340_elem_13").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19844 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19844_x6405_D1") 
              x19844.r := getRetimed(block2chunk0sub18("x6405").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8613_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8613_x18""")
              x8613_x18.r := (Math.mul(x19844, x19843, Some(6.0), true.B, Truncate, Wrapping, "x8613_x18")).r
              val x19845 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19845_x5341_elem_14_D9") 
              x19845.r := getRetimed(block2chunk0sub3("x5341_elem_14").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19846 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19846_x6406_D1") 
              x19846.r := getRetimed(block2chunk0sub18("x6406").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8614_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8614_x18""")
              x8614_x18.r := (Math.mul(x19846, x19845, Some(6.0), true.B, Truncate, Wrapping, "x8614_x18")).r
              val x19847 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19847_x6407_D1") 
              x19847.r := getRetimed(block2chunk0sub18("x6407").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19848 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19848_x5342_elem_15_D9") 
              x19848.r := getRetimed(block2chunk0sub3("x5342_elem_15").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8615_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8615_x18""")
              x8615_x18.r := (Math.mul(x19847, x19848, Some(6.0), true.B, Truncate, Wrapping, "x8615_x18")).r
              val x19849 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19849_x6408_D1") 
              x19849.r := getRetimed(block2chunk0sub18("x6408").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19850 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19850_x5343_elem_16_D9") 
              x19850.r := getRetimed(block2chunk0sub3("x5343_elem_16").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8616_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8616_x18""")
              x8616_x18.r := (Math.mul(x19849, x19850, Some(6.0), true.B, Truncate, Wrapping, "x8616_x18")).r
              val x19851 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19851_x5344_elem_17_D9") 
              x19851.r := getRetimed(block2chunk0sub4("x5344_elem_17").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19852 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19852_x6409_D1") 
              x19852.r := getRetimed(block2chunk0sub18("x6409").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8617_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8617_x18""")
              x8617_x18.r := (Math.mul(x19852, x19851, Some(6.0), true.B, Truncate, Wrapping, "x8617_x18")).r
              val x19853 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19853_x5345_elem_18_D9") 
              x19853.r := getRetimed(block2chunk0sub4("x5345_elem_18").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19854 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19854_x6410_D1") 
              x19854.r := getRetimed(block2chunk0sub18("x6410").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8618_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8618_x18""")
              x8618_x18.r := (Math.mul(x19854, x19853, Some(6.0), true.B, Truncate, Wrapping, "x8618_x18")).r
              val x19855 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19855_x6411_D1") 
              x19855.r := getRetimed(block2chunk0sub18("x6411").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19856 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19856_x5346_elem_19_D9") 
              x19856.r := getRetimed(block2chunk0sub4("x5346_elem_19").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8619_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8619_x18""")
              x8619_x18.r := (Math.mul(x19855, x19856, Some(6.0), true.B, Truncate, Wrapping, "x8619_x18")).r
              val x19857 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19857_x6412_D1") 
              x19857.r := getRetimed(block2chunk0sub19("x6412").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19858 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19858_x5347_elem_20_D9") 
              x19858.r := getRetimed(block2chunk0sub4("x5347_elem_20").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8620_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8620_x18""")
              x8620_x18.r := (Math.mul(x19857, x19858, Some(6.0), true.B, Truncate, Wrapping, "x8620_x18")).r
              val x19859 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19859_x6413_D1") 
              x19859.r := getRetimed(block2chunk0sub19("x6413").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19860 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19860_x5348_elem_21_D9") 
              x19860.r := getRetimed(block2chunk0sub4("x5348_elem_21").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8621_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8621_x18""")
              x8621_x18.r := (Math.mul(x19859, x19860, Some(6.0), true.B, Truncate, Wrapping, "x8621_x18")).r
              val x19861 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19861_x6414_D1") 
              x19861.r := getRetimed(block2chunk0sub19("x6414").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19862 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19862_x5349_elem_22_D9") 
              x19862.r := getRetimed(block2chunk0sub4("x5349_elem_22").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8622_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8622_x18""")
              x8622_x18.r := (Math.mul(x19861, x19862, Some(6.0), true.B, Truncate, Wrapping, "x8622_x18")).r
              val x19863 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19863_x6415_D1") 
              x19863.r := getRetimed(block2chunk0sub19("x6415").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19864 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19864_x5350_elem_23_D9") 
              x19864.r := getRetimed(block2chunk0sub4("x5350_elem_23").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8623_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8623_x18""")
              x8623_x18.r := (Math.mul(x19863, x19864, Some(6.0), true.B, Truncate, Wrapping, "x8623_x18")).r
              val x19865 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19865_x5351_elem_24_D9") 
              x19865.r := getRetimed(block2chunk0sub4("x5351_elem_24").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19866 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19866_x6416_D1") 
              x19866.r := getRetimed(block2chunk0sub19("x6416").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8624_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8624_x18""")
              x8624_x18.r := (Math.mul(x19866, x19865, Some(6.0), true.B, Truncate, Wrapping, "x8624_x18")).r
              val x19867 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19867_x6417_D1") 
              x19867.r := getRetimed(block2chunk0sub19("x6417").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19868 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19868_x5352_elem_25_D9") 
              x19868.r := getRetimed(block2chunk0sub4("x5352_elem_25").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8625_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8625_x18""")
              x8625_x18.r := (Math.mul(x19867, x19868, Some(6.0), true.B, Truncate, Wrapping, "x8625_x18")).r
              val x19869 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19869_x6418_D1") 
              x19869.r := getRetimed(block2chunk0sub19("x6418").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19870 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19870_x5353_elem_26_D9") 
              x19870.r := getRetimed(block2chunk0sub4("x5353_elem_26").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8626_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8626_x18""")
              x8626_x18.r := (Math.mul(x19869, x19870, Some(6.0), true.B, Truncate, Wrapping, "x8626_x18")).r
              val x19871 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19871_x5354_elem_27_D9") 
              x19871.r := getRetimed(block2chunk0sub4("x5354_elem_27").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19872 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19872_x6419_D1") 
              x19872.r := getRetimed(block2chunk0sub19("x6419").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8627_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8627_x18""")
              x8627_x18.r := (Math.mul(x19872, x19871, Some(6.0), true.B, Truncate, Wrapping, "x8627_x18")).r
              val x19873 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19873_x6420_D1") 
              x19873.r := getRetimed(block2chunk0sub19("x6420").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19874 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19874_x5355_elem_28_D9") 
              x19874.r := getRetimed(block2chunk0sub4("x5355_elem_28").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x8612_x18" -> x8612_x18, "x8613_x18" -> x8613_x18, "x8614_x18" -> x8614_x18, "x8615_x18" -> x8615_x18, "x8616_x18" -> x8616_x18, "x8617_x18" -> x8617_x18, "x8618_x18" -> x8618_x18, "x8619_x18" -> x8619_x18, "x8620_x18" -> x8620_x18, "x8621_x18" -> x8621_x18, "x8622_x18" -> x8622_x18, "x8623_x18" -> x8623_x18, "x8624_x18" -> x8624_x18, "x8625_x18" -> x8625_x18, "x8626_x18" -> x8626_x18, "x8627_x18" -> x8627_x18, "x19873" -> x19873, "x19874" -> x19874)
            }
          }
          val block2chunk0sub34: Map[String, Any] = Block2Chunker0Sub34.gen()
          object Block2Chunker0Sub35 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x8628_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8628_x18""")
              x8628_x18.r := (Math.mul(block2chunk0sub34("x19873").asInstanceOf[FixedPoint], block2chunk0sub34("x19874").asInstanceOf[FixedPoint], Some(6.0), true.B, Truncate, Wrapping, "x8628_x18")).r
              val x19875 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19875_x5356_elem_29_D9") 
              x19875.r := getRetimed(block2chunk0sub4("x5356_elem_29").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19876 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19876_x6421_D1") 
              x19876.r := getRetimed(block2chunk0sub19("x6421").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8629_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8629_x18""")
              x8629_x18.r := (Math.mul(x19876, x19875, Some(6.0), true.B, Truncate, Wrapping, "x8629_x18")).r
              val x19877 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19877_x5357_elem_30_D9") 
              x19877.r := getRetimed(block2chunk0sub4("x5357_elem_30").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19878 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19878_x6422_D1") 
              x19878.r := getRetimed(block2chunk0sub19("x6422").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8630_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8630_x18""")
              x8630_x18.r := (Math.mul(x19878, x19877, Some(6.0), true.B, Truncate, Wrapping, "x8630_x18")).r
              val x19879 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19879_x5358_elem_31_D9") 
              x19879.r := getRetimed(block2chunk0sub4("x5358_elem_31").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19880 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19880_x6423_D1") 
              x19880.r := getRetimed(block2chunk0sub19("x6423").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8631_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8631_x18""")
              x8631_x18.r := (Math.mul(x19880, x19879, Some(6.0), true.B, Truncate, Wrapping, "x8631_x18")).r
              val x19881 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19881_x7032_D1") 
              x19881.r := getRetimed(block2chunk0sub22("x7032").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19882 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19882_x5393_elem_0_D9") 
              x19882.r := getRetimed(block2chunk0sub6("x5393_elem_0").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8664_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8664_x18""")
              x8664_x18.r := (Math.mul(x19881, x19882, Some(6.0), true.B, Truncate, Wrapping, "x8664_x18")).r
              val x19883 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19883_x5394_elem_1_D9") 
              x19883.r := getRetimed(block2chunk0sub6("x5394_elem_1").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19884 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19884_x7033_D1") 
              x19884.r := getRetimed(block2chunk0sub22("x7033").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8665_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8665_x18""")
              x8665_x18.r := (Math.mul(x19884, x19883, Some(6.0), true.B, Truncate, Wrapping, "x8665_x18")).r
              val x19885 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19885_x7034_D1") 
              x19885.r := getRetimed(block2chunk0sub22("x7034").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19886 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19886_x5395_elem_2_D9") 
              x19886.r := getRetimed(block2chunk0sub6("x5395_elem_2").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8666_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8666_x18""")
              x8666_x18.r := (Math.mul(x19885, x19886, Some(6.0), true.B, Truncate, Wrapping, "x8666_x18")).r
              val x19887 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19887_x7035_D1") 
              x19887.r := getRetimed(block2chunk0sub22("x7035").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19888 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19888_x5396_elem_3_D9") 
              x19888.r := getRetimed(block2chunk0sub6("x5396_elem_3").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8667_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8667_x18""")
              x8667_x18.r := (Math.mul(x19887, x19888, Some(6.0), true.B, Truncate, Wrapping, "x8667_x18")).r
              val x19889 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19889_x7036_D1") 
              x19889.r := getRetimed(block2chunk0sub22("x7036").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19890 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19890_x5397_elem_4_D9") 
              x19890.r := getRetimed(block2chunk0sub6("x5397_elem_4").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8668_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8668_x18""")
              x8668_x18.r := (Math.mul(x19889, x19890, Some(6.0), true.B, Truncate, Wrapping, "x8668_x18")).r
              val x19891 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19891_x5398_elem_5_D9") 
              x19891.r := getRetimed(block2chunk0sub6("x5398_elem_5").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19892 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19892_x7037_D1") 
              x19892.r := getRetimed(block2chunk0sub22("x7037").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8669_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8669_x18""")
              x8669_x18.r := (Math.mul(x19892, x19891, Some(6.0), true.B, Truncate, Wrapping, "x8669_x18")).r
              val x19893 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19893_x5399_elem_6_D9") 
              x19893.r := getRetimed(block2chunk0sub6("x5399_elem_6").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19894 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19894_x7038_D1") 
              x19894.r := getRetimed(block2chunk0sub22("x7038").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8670_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8670_x18""")
              x8670_x18.r := (Math.mul(x19894, x19893, Some(6.0), true.B, Truncate, Wrapping, "x8670_x18")).r
              val x19895 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19895_x7039_D1") 
              x19895.r := getRetimed(block2chunk0sub22("x7039").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19896 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19896_x5400_elem_7_D9") 
              x19896.r := getRetimed(block2chunk0sub6("x5400_elem_7").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8671_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8671_x18""")
              x8671_x18.r := (Math.mul(x19895, x19896, Some(6.0), true.B, Truncate, Wrapping, "x8671_x18")).r
              val x19897 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19897_x5401_elem_8_D9") 
              x19897.r := getRetimed(block2chunk0sub6("x5401_elem_8").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19898 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19898_x7040_D1") 
              x19898.r := getRetimed(block2chunk0sub22("x7040").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8672_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8672_x18""")
              x8672_x18.r := (Math.mul(x19898, x19897, Some(6.0), true.B, Truncate, Wrapping, "x8672_x18")).r
              val x19899 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19899_x7041_D1") 
              x19899.r := getRetimed(block2chunk0sub22("x7041").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19900 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19900_x5402_elem_9_D9") 
              x19900.r := getRetimed(block2chunk0sub6("x5402_elem_9").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8673_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8673_x18""")
              x8673_x18.r := (Math.mul(x19899, x19900, Some(6.0), true.B, Truncate, Wrapping, "x8673_x18")).r
              val x19901 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19901_x5403_elem_10_D9") 
              x19901.r := getRetimed(block2chunk0sub6("x5403_elem_10").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19902 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19902_x7042_D1") 
              x19902.r := getRetimed(block2chunk0sub22("x7042").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8674_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8674_x18""")
              x8674_x18.r := (Math.mul(x19902, x19901, Some(6.0), true.B, Truncate, Wrapping, "x8674_x18")).r
              val x19903 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19903_x5404_elem_11_D9") 
              x19903.r := getRetimed(block2chunk0sub6("x5404_elem_11").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19904 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19904_x7043_D1") 
              x19904.r := getRetimed(block2chunk0sub22("x7043").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8675_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8675_x18""")
              x8675_x18.r := (Math.mul(x19904, x19903, Some(6.0), true.B, Truncate, Wrapping, "x8675_x18")).r
              val x19905 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19905_x7044_D1") 
              x19905.r := getRetimed(block2chunk0sub23("x7044").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19906 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19906_x5405_elem_12_D9") 
              x19906.r := getRetimed(block2chunk0sub6("x5405_elem_12").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8676_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8676_x18""")
              x8676_x18.r := (Math.mul(x19905, x19906, Some(6.0), true.B, Truncate, Wrapping, "x8676_x18")).r
              Map[String,Any]("x8628_x18" -> x8628_x18, "x8629_x18" -> x8629_x18, "x8630_x18" -> x8630_x18, "x8631_x18" -> x8631_x18, "x8664_x18" -> x8664_x18, "x8665_x18" -> x8665_x18, "x8666_x18" -> x8666_x18, "x8667_x18" -> x8667_x18, "x8668_x18" -> x8668_x18, "x8669_x18" -> x8669_x18, "x8670_x18" -> x8670_x18, "x8671_x18" -> x8671_x18, "x8672_x18" -> x8672_x18, "x8673_x18" -> x8673_x18, "x8674_x18" -> x8674_x18, "x8675_x18" -> x8675_x18, "x8676_x18" -> x8676_x18)
            }
          }
          val block2chunk0sub35: Map[String, Any] = Block2Chunker0Sub35.gen()
          object Block2Chunker0Sub36 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x19907 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19907_x7045_D1") 
              x19907.r := getRetimed(block2chunk0sub23("x7045").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19908 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19908_x5406_elem_13_D9") 
              x19908.r := getRetimed(block2chunk0sub6("x5406_elem_13").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8677_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8677_x18""")
              x8677_x18.r := (Math.mul(x19907, x19908, Some(6.0), true.B, Truncate, Wrapping, "x8677_x18")).r
              val x19909 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19909_x5407_elem_14_D9") 
              x19909.r := getRetimed(block2chunk0sub6("x5407_elem_14").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19910 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19910_x7046_D1") 
              x19910.r := getRetimed(block2chunk0sub23("x7046").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8678_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8678_x18""")
              x8678_x18.r := (Math.mul(x19910, x19909, Some(6.0), true.B, Truncate, Wrapping, "x8678_x18")).r
              val x19911 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19911_x5408_elem_15_D9") 
              x19911.r := getRetimed(block2chunk0sub6("x5408_elem_15").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19912 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19912_x7047_D1") 
              x19912.r := getRetimed(block2chunk0sub23("x7047").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8679_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8679_x18""")
              x8679_x18.r := (Math.mul(x19912, x19911, Some(6.0), true.B, Truncate, Wrapping, "x8679_x18")).r
              val x19913 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19913_x7048_D1") 
              x19913.r := getRetimed(block2chunk0sub23("x7048").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19914 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19914_x5409_elem_16_D9") 
              x19914.r := getRetimed(block2chunk0sub6("x5409_elem_16").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8680_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8680_x18""")
              x8680_x18.r := (Math.mul(x19913, x19914, Some(6.0), true.B, Truncate, Wrapping, "x8680_x18")).r
              val x19915 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19915_x7049_D1") 
              x19915.r := getRetimed(block2chunk0sub23("x7049").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19916 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19916_x5410_elem_17_D9") 
              x19916.r := getRetimed(block2chunk0sub7("x5410_elem_17").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8681_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8681_x18""")
              x8681_x18.r := (Math.mul(x19915, x19916, Some(6.0), true.B, Truncate, Wrapping, "x8681_x18")).r
              val x19917 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19917_x7050_D1") 
              x19917.r := getRetimed(block2chunk0sub23("x7050").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19918 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19918_x5411_elem_18_D9") 
              x19918.r := getRetimed(block2chunk0sub7("x5411_elem_18").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8682_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8682_x18""")
              x8682_x18.r := (Math.mul(x19917, x19918, Some(6.0), true.B, Truncate, Wrapping, "x8682_x18")).r
              val x19919 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19919_x7051_D1") 
              x19919.r := getRetimed(block2chunk0sub23("x7051").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19920 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19920_x5412_elem_19_D9") 
              x19920.r := getRetimed(block2chunk0sub7("x5412_elem_19").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8683_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8683_x18""")
              x8683_x18.r := (Math.mul(x19919, x19920, Some(6.0), true.B, Truncate, Wrapping, "x8683_x18")).r
              val x19921 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19921_x5413_elem_20_D9") 
              x19921.r := getRetimed(block2chunk0sub7("x5413_elem_20").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19922 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19922_x7052_D1") 
              x19922.r := getRetimed(block2chunk0sub23("x7052").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8684_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8684_x18""")
              x8684_x18.r := (Math.mul(x19922, x19921, Some(6.0), true.B, Truncate, Wrapping, "x8684_x18")).r
              val x19923 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19923_x5414_elem_21_D9") 
              x19923.r := getRetimed(block2chunk0sub7("x5414_elem_21").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19924 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19924_x7053_D1") 
              x19924.r := getRetimed(block2chunk0sub23("x7053").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8685_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8685_x18""")
              x8685_x18.r := (Math.mul(x19924, x19923, Some(6.0), true.B, Truncate, Wrapping, "x8685_x18")).r
              val x19925 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19925_x5415_elem_22_D9") 
              x19925.r := getRetimed(block2chunk0sub7("x5415_elem_22").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19926 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19926_x7054_D1") 
              x19926.r := getRetimed(block2chunk0sub23("x7054").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8686_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8686_x18""")
              x8686_x18.r := (Math.mul(x19926, x19925, Some(6.0), true.B, Truncate, Wrapping, "x8686_x18")).r
              val x19927 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19927_x7055_D1") 
              x19927.r := getRetimed(block2chunk0sub23("x7055").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19928 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19928_x5416_elem_23_D9") 
              x19928.r := getRetimed(block2chunk0sub7("x5416_elem_23").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8687_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8687_x18""")
              x8687_x18.r := (Math.mul(x19927, x19928, Some(6.0), true.B, Truncate, Wrapping, "x8687_x18")).r
              val x19929 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19929_x7056_D1") 
              x19929.r := getRetimed(block2chunk0sub23("x7056").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19930 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19930_x5417_elem_24_D9") 
              x19930.r := getRetimed(block2chunk0sub7("x5417_elem_24").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8688_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8688_x18""")
              x8688_x18.r := (Math.mul(x19929, x19930, Some(6.0), true.B, Truncate, Wrapping, "x8688_x18")).r
              val x19931 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19931_x7057_D1") 
              x19931.r := getRetimed(block2chunk0sub23("x7057").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19932 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19932_x5418_elem_25_D9") 
              x19932.r := getRetimed(block2chunk0sub7("x5418_elem_25").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8689_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8689_x18""")
              x8689_x18.r := (Math.mul(x19931, x19932, Some(6.0), true.B, Truncate, Wrapping, "x8689_x18")).r
              val x19933 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19933_x7058_D1") 
              x19933.r := getRetimed(block2chunk0sub23("x7058").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19934 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19934_x5419_elem_26_D9") 
              x19934.r := getRetimed(block2chunk0sub7("x5419_elem_26").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8690_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8690_x18""")
              x8690_x18.r := (Math.mul(x19933, x19934, Some(6.0), true.B, Truncate, Wrapping, "x8690_x18")).r
              val x19935 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19935_x5420_elem_27_D9") 
              x19935.r := getRetimed(block2chunk0sub7("x5420_elem_27").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19936 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19936_x7059_D1") 
              x19936.r := getRetimed(block2chunk0sub23("x7059").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8691_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8691_x18""")
              x8691_x18.r := (Math.mul(x19936, x19935, Some(6.0), true.B, Truncate, Wrapping, "x8691_x18")).r
              val x19937 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19937_x5421_elem_28_D9") 
              x19937.r := getRetimed(block2chunk0sub7("x5421_elem_28").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19938 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19938_x7060_D1") 
              x19938.r := getRetimed(block2chunk0sub23("x7060").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8692_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8692_x18""")
              x8692_x18.r := (Math.mul(x19938, x19937, Some(6.0), true.B, Truncate, Wrapping, "x8692_x18")).r
              val x19939 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19939_x7061_D1") 
              x19939.r := getRetimed(block2chunk0sub23("x7061").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x8677_x18" -> x8677_x18, "x8678_x18" -> x8678_x18, "x8679_x18" -> x8679_x18, "x8680_x18" -> x8680_x18, "x8681_x18" -> x8681_x18, "x8682_x18" -> x8682_x18, "x8683_x18" -> x8683_x18, "x8684_x18" -> x8684_x18, "x8685_x18" -> x8685_x18, "x8686_x18" -> x8686_x18, "x8687_x18" -> x8687_x18, "x8688_x18" -> x8688_x18, "x8689_x18" -> x8689_x18, "x8690_x18" -> x8690_x18, "x8691_x18" -> x8691_x18, "x8692_x18" -> x8692_x18, "x19939" -> x19939)
            }
          }
          val block2chunk0sub36: Map[String, Any] = Block2Chunker0Sub36.gen()
          object Block2Chunker0Sub37 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x19940 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19940_x5422_elem_29_D9") 
              x19940.r := getRetimed(block2chunk0sub7("x5422_elem_29").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8693_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8693_x18""")
              x8693_x18.r := (Math.mul(block2chunk0sub36("x19939").asInstanceOf[FixedPoint], x19940, Some(6.0), true.B, Truncate, Wrapping, "x8693_x18")).r
              val x19941 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19941_x7062_D1") 
              x19941.r := getRetimed(block2chunk0sub23("x7062").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19942 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19942_x5423_elem_30_D9") 
              x19942.r := getRetimed(block2chunk0sub7("x5423_elem_30").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8694_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8694_x18""")
              x8694_x18.r := (Math.mul(x19941, x19942, Some(6.0), true.B, Truncate, Wrapping, "x8694_x18")).r
              val x19943 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19943_x5424_elem_31_D9") 
              x19943.r := getRetimed(block2chunk0sub7("x5424_elem_31").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19944 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19944_x7063_D1") 
              x19944.r := getRetimed(block2chunk0sub23("x7063").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8695_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8695_x18""")
              x8695_x18.r := (Math.mul(x19944, x19943, Some(6.0), true.B, Truncate, Wrapping, "x8695_x18")).r
              val x19945 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19945_x5459_elem_0_D9") 
              x19945.r := getRetimed(block2chunk0sub9("x5459_elem_0").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19946 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19946_x7544_D1") 
              x19946.r := getRetimed(block2chunk0sub26("x7544").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8728_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8728_x18""")
              x8728_x18.r := (Math.mul(x19946, x19945, Some(6.0), true.B, Truncate, Wrapping, "x8728_x18")).r
              val x19947 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19947_x7545_D1") 
              x19947.r := getRetimed(block2chunk0sub26("x7545").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19948 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19948_x5460_elem_1_D9") 
              x19948.r := getRetimed(block2chunk0sub9("x5460_elem_1").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8729_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8729_x18""")
              x8729_x18.r := (Math.mul(x19947, x19948, Some(6.0), true.B, Truncate, Wrapping, "x8729_x18")).r
              val x19949 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19949_x7546_D1") 
              x19949.r := getRetimed(block2chunk0sub26("x7546").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19950 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19950_x5461_elem_2_D9") 
              x19950.r := getRetimed(block2chunk0sub9("x5461_elem_2").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8730_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8730_x18""")
              x8730_x18.r := (Math.mul(x19949, x19950, Some(6.0), true.B, Truncate, Wrapping, "x8730_x18")).r
              val x19951 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19951_x5462_elem_3_D9") 
              x19951.r := getRetimed(block2chunk0sub9("x5462_elem_3").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19952 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19952_x7547_D1") 
              x19952.r := getRetimed(block2chunk0sub26("x7547").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8731_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8731_x18""")
              x8731_x18.r := (Math.mul(x19952, x19951, Some(6.0), true.B, Truncate, Wrapping, "x8731_x18")).r
              val x19953 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19953_x7548_D1") 
              x19953.r := getRetimed(block2chunk0sub26("x7548").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19954 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19954_x5463_elem_4_D9") 
              x19954.r := getRetimed(block2chunk0sub9("x5463_elem_4").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8732_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8732_x18""")
              x8732_x18.r := (Math.mul(x19953, x19954, Some(6.0), true.B, Truncate, Wrapping, "x8732_x18")).r
              val x19955 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19955_x5464_elem_5_D9") 
              x19955.r := getRetimed(block2chunk0sub9("x5464_elem_5").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19956 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19956_x7549_D1") 
              x19956.r := getRetimed(block2chunk0sub26("x7549").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8733_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8733_x18""")
              x8733_x18.r := (Math.mul(x19956, x19955, Some(6.0), true.B, Truncate, Wrapping, "x8733_x18")).r
              val x19957 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19957_x5465_elem_6_D9") 
              x19957.r := getRetimed(block2chunk0sub9("x5465_elem_6").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19958 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19958_x7550_D1") 
              x19958.r := getRetimed(block2chunk0sub26("x7550").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8734_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8734_x18""")
              x8734_x18.r := (Math.mul(x19958, x19957, Some(6.0), true.B, Truncate, Wrapping, "x8734_x18")).r
              val x19959 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19959_x5466_elem_7_D9") 
              x19959.r := getRetimed(block2chunk0sub9("x5466_elem_7").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19960 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19960_x7551_D1") 
              x19960.r := getRetimed(block2chunk0sub26("x7551").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8735_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8735_x18""")
              x8735_x18.r := (Math.mul(x19960, x19959, Some(6.0), true.B, Truncate, Wrapping, "x8735_x18")).r
              val x19961 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19961_x7552_D1") 
              x19961.r := getRetimed(block2chunk0sub26("x7552").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19962 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19962_x5467_elem_8_D9") 
              x19962.r := getRetimed(block2chunk0sub9("x5467_elem_8").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8736_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8736_x18""")
              x8736_x18.r := (Math.mul(x19961, x19962, Some(6.0), true.B, Truncate, Wrapping, "x8736_x18")).r
              val x19963 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19963_x7553_D1") 
              x19963.r := getRetimed(block2chunk0sub26("x7553").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19964 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19964_x5468_elem_9_D9") 
              x19964.r := getRetimed(block2chunk0sub9("x5468_elem_9").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8737_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8737_x18""")
              x8737_x18.r := (Math.mul(x19963, x19964, Some(6.0), true.B, Truncate, Wrapping, "x8737_x18")).r
              val x19965 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19965_x7554_D1") 
              x19965.r := getRetimed(block2chunk0sub26("x7554").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19966 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19966_x5469_elem_10_D9") 
              x19966.r := getRetimed(block2chunk0sub9("x5469_elem_10").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8738_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8738_x18""")
              x8738_x18.r := (Math.mul(x19965, x19966, Some(6.0), true.B, Truncate, Wrapping, "x8738_x18")).r
              val x19967 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19967_x7555_D1") 
              x19967.r := getRetimed(block2chunk0sub26("x7555").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19968 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19968_x5470_elem_11_D9") 
              x19968.r := getRetimed(block2chunk0sub9("x5470_elem_11").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8739_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8739_x18""")
              x8739_x18.r := (Math.mul(x19967, x19968, Some(6.0), true.B, Truncate, Wrapping, "x8739_x18")).r
              val x19969 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19969_x5471_elem_12_D9") 
              x19969.r := getRetimed(block2chunk0sub9("x5471_elem_12").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19970 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19970_x7556_D1") 
              x19970.r := getRetimed(block2chunk0sub26("x7556").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8740_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8740_x18""")
              x8740_x18.r := (Math.mul(x19970, x19969, Some(6.0), true.B, Truncate, Wrapping, "x8740_x18")).r
              val x19971 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19971_x7557_D1") 
              x19971.r := getRetimed(block2chunk0sub26("x7557").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19972 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19972_x5472_elem_13_D9") 
              x19972.r := getRetimed(block2chunk0sub9("x5472_elem_13").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x8693_x18" -> x8693_x18, "x8694_x18" -> x8694_x18, "x8695_x18" -> x8695_x18, "x8728_x18" -> x8728_x18, "x8729_x18" -> x8729_x18, "x8730_x18" -> x8730_x18, "x8731_x18" -> x8731_x18, "x8732_x18" -> x8732_x18, "x8733_x18" -> x8733_x18, "x8734_x18" -> x8734_x18, "x8735_x18" -> x8735_x18, "x8736_x18" -> x8736_x18, "x8737_x18" -> x8737_x18, "x8738_x18" -> x8738_x18, "x8739_x18" -> x8739_x18, "x8740_x18" -> x8740_x18, "x19971" -> x19971, "x19972" -> x19972)
            }
          }
          val block2chunk0sub37: Map[String, Any] = Block2Chunker0Sub37.gen()
          object Block2Chunker0Sub38 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x8741_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8741_x18""")
              x8741_x18.r := (Math.mul(block2chunk0sub37("x19971").asInstanceOf[FixedPoint], block2chunk0sub37("x19972").asInstanceOf[FixedPoint], Some(6.0), true.B, Truncate, Wrapping, "x8741_x18")).r
              val x19973 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19973_x5473_elem_14_D9") 
              x19973.r := getRetimed(block2chunk0sub9("x5473_elem_14").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19974 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19974_x7558_D1") 
              x19974.r := getRetimed(block2chunk0sub26("x7558").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8742_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8742_x18""")
              x8742_x18.r := (Math.mul(x19974, x19973, Some(6.0), true.B, Truncate, Wrapping, "x8742_x18")).r
              val x19975 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19975_x5474_elem_15_D9") 
              x19975.r := getRetimed(block2chunk0sub9("x5474_elem_15").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19976 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19976_x7559_D1") 
              x19976.r := getRetimed(block2chunk0sub26("x7559").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8743_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8743_x18""")
              x8743_x18.r := (Math.mul(x19976, x19975, Some(6.0), true.B, Truncate, Wrapping, "x8743_x18")).r
              val x19977 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19977_x5475_elem_16_D9") 
              x19977.r := getRetimed(block2chunk0sub9("x5475_elem_16").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19978 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19978_x7560_D1") 
              x19978.r := getRetimed(block2chunk0sub26("x7560").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8744_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8744_x18""")
              x8744_x18.r := (Math.mul(x19978, x19977, Some(6.0), true.B, Truncate, Wrapping, "x8744_x18")).r
              val x19979 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19979_x7561_D1") 
              x19979.r := getRetimed(block2chunk0sub26("x7561").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19980 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19980_x5476_elem_17_D9") 
              x19980.r := getRetimed(block2chunk0sub10("x5476_elem_17").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8745_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8745_x18""")
              x8745_x18.r := (Math.mul(x19979, x19980, Some(6.0), true.B, Truncate, Wrapping, "x8745_x18")).r
              val x19981 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19981_x5477_elem_18_D9") 
              x19981.r := getRetimed(block2chunk0sub10("x5477_elem_18").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19982 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19982_x7562_D1") 
              x19982.r := getRetimed(block2chunk0sub26("x7562").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8746_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8746_x18""")
              x8746_x18.r := (Math.mul(x19982, x19981, Some(6.0), true.B, Truncate, Wrapping, "x8746_x18")).r
              val x19983 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19983_x7563_D1") 
              x19983.r := getRetimed(block2chunk0sub26("x7563").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19984 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19984_x5478_elem_19_D9") 
              x19984.r := getRetimed(block2chunk0sub10("x5478_elem_19").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8747_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8747_x18""")
              x8747_x18.r := (Math.mul(x19983, x19984, Some(6.0), true.B, Truncate, Wrapping, "x8747_x18")).r
              val x19985 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19985_x5479_elem_20_D9") 
              x19985.r := getRetimed(block2chunk0sub10("x5479_elem_20").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19986 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19986_x7564_D1") 
              x19986.r := getRetimed(block2chunk0sub26("x7564").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8748_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8748_x18""")
              x8748_x18.r := (Math.mul(x19986, x19985, Some(6.0), true.B, Truncate, Wrapping, "x8748_x18")).r
              val x19987 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19987_x7565_D1") 
              x19987.r := getRetimed(block2chunk0sub26("x7565").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19988 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19988_x5480_elem_21_D9") 
              x19988.r := getRetimed(block2chunk0sub10("x5480_elem_21").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8749_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8749_x18""")
              x8749_x18.r := (Math.mul(x19987, x19988, Some(6.0), true.B, Truncate, Wrapping, "x8749_x18")).r
              val x19989 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19989_x7566_D1") 
              x19989.r := getRetimed(block2chunk0sub26("x7566").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19990 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19990_x5481_elem_22_D9") 
              x19990.r := getRetimed(block2chunk0sub10("x5481_elem_22").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8750_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8750_x18""")
              x8750_x18.r := (Math.mul(x19989, x19990, Some(6.0), true.B, Truncate, Wrapping, "x8750_x18")).r
              val x19991 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19991_x5482_elem_23_D9") 
              x19991.r := getRetimed(block2chunk0sub10("x5482_elem_23").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19992 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19992_x7567_D1") 
              x19992.r := getRetimed(block2chunk0sub26("x7567").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8751_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8751_x18""")
              x8751_x18.r := (Math.mul(x19992, x19991, Some(6.0), true.B, Truncate, Wrapping, "x8751_x18")).r
              val x19993 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19993_x7568_D1") 
              x19993.r := getRetimed(block2chunk0sub26("x7568").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19994 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19994_x5483_elem_24_D9") 
              x19994.r := getRetimed(block2chunk0sub10("x5483_elem_24").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8752_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8752_x18""")
              x8752_x18.r := (Math.mul(x19993, x19994, Some(6.0), true.B, Truncate, Wrapping, "x8752_x18")).r
              val x19995 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19995_x5484_elem_25_D9") 
              x19995.r := getRetimed(block2chunk0sub10("x5484_elem_25").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x19996 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19996_x7569_D1") 
              x19996.r := getRetimed(block2chunk0sub26("x7569").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8753_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8753_x18""")
              x8753_x18.r := (Math.mul(x19996, x19995, Some(6.0), true.B, Truncate, Wrapping, "x8753_x18")).r
              val x19997 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19997_x7570_D1") 
              x19997.r := getRetimed(block2chunk0sub26("x7570").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x19998 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19998_x5485_elem_26_D9") 
              x19998.r := getRetimed(block2chunk0sub10("x5485_elem_26").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8754_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8754_x18""")
              x8754_x18.r := (Math.mul(x19997, x19998, Some(6.0), true.B, Truncate, Wrapping, "x8754_x18")).r
              val x19999 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19999_x7571_D1") 
              x19999.r := getRetimed(block2chunk0sub26("x7571").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20000 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20000_x5486_elem_27_D9") 
              x20000.r := getRetimed(block2chunk0sub10("x5486_elem_27").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8755_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8755_x18""")
              x8755_x18.r := (Math.mul(x19999, x20000, Some(6.0), true.B, Truncate, Wrapping, "x8755_x18")).r
              val x20001 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20001_x7572_D1") 
              x20001.r := getRetimed(block2chunk0sub26("x7572").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20002 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20002_x5487_elem_28_D9") 
              x20002.r := getRetimed(block2chunk0sub10("x5487_elem_28").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8756_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8756_x18""")
              x8756_x18.r := (Math.mul(x20001, x20002, Some(6.0), true.B, Truncate, Wrapping, "x8756_x18")).r
              val x20003 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20003_x5488_elem_29_D9") 
              x20003.r := getRetimed(block2chunk0sub10("x5488_elem_29").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20004 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20004_x7573_D1") 
              x20004.r := getRetimed(block2chunk0sub26("x7573").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8757_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8757_x18""")
              x8757_x18.r := (Math.mul(x20004, x20003, Some(6.0), true.B, Truncate, Wrapping, "x8757_x18")).r
              Map[String,Any]("x8741_x18" -> x8741_x18, "x8742_x18" -> x8742_x18, "x8743_x18" -> x8743_x18, "x8744_x18" -> x8744_x18, "x8745_x18" -> x8745_x18, "x8746_x18" -> x8746_x18, "x8747_x18" -> x8747_x18, "x8748_x18" -> x8748_x18, "x8749_x18" -> x8749_x18, "x8750_x18" -> x8750_x18, "x8751_x18" -> x8751_x18, "x8752_x18" -> x8752_x18, "x8753_x18" -> x8753_x18, "x8754_x18" -> x8754_x18, "x8755_x18" -> x8755_x18, "x8756_x18" -> x8756_x18, "x8757_x18" -> x8757_x18)
            }
          }
          val block2chunk0sub38: Map[String, Any] = Block2Chunker0Sub38.gen()
          object Block2Chunker0Sub39 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x20005 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20005_x7574_D1") 
              x20005.r := getRetimed(block2chunk0sub26("x7574").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20006 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20006_x5489_elem_30_D9") 
              x20006.r := getRetimed(block2chunk0sub10("x5489_elem_30").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8758_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8758_x18""")
              x8758_x18.r := (Math.mul(x20005, x20006, Some(6.0), true.B, Truncate, Wrapping, "x8758_x18")).r
              val x20007 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20007_x5490_elem_31_D9") 
              x20007.r := getRetimed(block2chunk0sub10("x5490_elem_31").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20008 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20008_x7575_D1") 
              x20008.r := getRetimed(block2chunk0sub26("x7575").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8759_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8759_x18""")
              x8759_x18.r := (Math.mul(x20008, x20007, Some(6.0), true.B, Truncate, Wrapping, "x8759_x18")).r
              val x20009 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20009_x8248_D1") 
              x20009.r := getRetimed(block2chunk0sub30("x8248").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20010 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20010_x5525_elem_0_D9") 
              x20010.r := getRetimed(block2chunk0sub12("x5525_elem_0").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8792_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8792_x18""")
              x8792_x18.r := (Math.mul(x20009, x20010, Some(6.0), true.B, Truncate, Wrapping, "x8792_x18")).r
              val x20011 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20011_x8249_D1") 
              x20011.r := getRetimed(block2chunk0sub30("x8249").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20012 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20012_x5526_elem_1_D9") 
              x20012.r := getRetimed(block2chunk0sub12("x5526_elem_1").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8793_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8793_x18""")
              x8793_x18.r := (Math.mul(x20011, x20012, Some(6.0), true.B, Truncate, Wrapping, "x8793_x18")).r
              val x20013 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20013_x5527_elem_2_D9") 
              x20013.r := getRetimed(block2chunk0sub12("x5527_elem_2").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20014 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20014_x8250_D1") 
              x20014.r := getRetimed(block2chunk0sub30("x8250").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8794_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8794_x18""")
              x8794_x18.r := (Math.mul(x20014, x20013, Some(6.0), true.B, Truncate, Wrapping, "x8794_x18")).r
              val x20015 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20015_x5528_elem_3_D9") 
              x20015.r := getRetimed(block2chunk0sub12("x5528_elem_3").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20016 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20016_x8251_D1") 
              x20016.r := getRetimed(block2chunk0sub30("x8251").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8795_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8795_x18""")
              x8795_x18.r := (Math.mul(x20016, x20015, Some(6.0), true.B, Truncate, Wrapping, "x8795_x18")).r
              val x20017 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20017_x8252_D1") 
              x20017.r := getRetimed(block2chunk0sub30("x8252").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20018 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20018_x5529_elem_4_D9") 
              x20018.r := getRetimed(block2chunk0sub12("x5529_elem_4").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8796_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8796_x18""")
              x8796_x18.r := (Math.mul(x20017, x20018, Some(6.0), true.B, Truncate, Wrapping, "x8796_x18")).r
              val x20019 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20019_x8253_D1") 
              x20019.r := getRetimed(block2chunk0sub30("x8253").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20020 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20020_x5530_elem_5_D9") 
              x20020.r := getRetimed(block2chunk0sub12("x5530_elem_5").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8797_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8797_x18""")
              x8797_x18.r := (Math.mul(x20019, x20020, Some(6.0), true.B, Truncate, Wrapping, "x8797_x18")).r
              val x20021 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20021_x5531_elem_6_D9") 
              x20021.r := getRetimed(block2chunk0sub12("x5531_elem_6").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20022 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20022_x8254_D1") 
              x20022.r := getRetimed(block2chunk0sub30("x8254").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8798_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8798_x18""")
              x8798_x18.r := (Math.mul(x20022, x20021, Some(6.0), true.B, Truncate, Wrapping, "x8798_x18")).r
              val x20023 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20023_x5532_elem_7_D9") 
              x20023.r := getRetimed(block2chunk0sub12("x5532_elem_7").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20024 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20024_x8255_D1") 
              x20024.r := getRetimed(block2chunk0sub30("x8255").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8799_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8799_x18""")
              x8799_x18.r := (Math.mul(x20024, x20023, Some(6.0), true.B, Truncate, Wrapping, "x8799_x18")).r
              val x20025 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20025_x5533_elem_8_D9") 
              x20025.r := getRetimed(block2chunk0sub12("x5533_elem_8").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20026 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20026_x8256_D1") 
              x20026.r := getRetimed(block2chunk0sub30("x8256").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8800_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8800_x18""")
              x8800_x18.r := (Math.mul(x20026, x20025, Some(6.0), true.B, Truncate, Wrapping, "x8800_x18")).r
              val x20027 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20027_x5534_elem_9_D9") 
              x20027.r := getRetimed(block2chunk0sub12("x5534_elem_9").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20028 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20028_x8257_D1") 
              x20028.r := getRetimed(block2chunk0sub30("x8257").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8801_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8801_x18""")
              x8801_x18.r := (Math.mul(x20028, x20027, Some(6.0), true.B, Truncate, Wrapping, "x8801_x18")).r
              val x20029 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20029_x5535_elem_10_D9") 
              x20029.r := getRetimed(block2chunk0sub12("x5535_elem_10").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20030 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20030_x8258_D1") 
              x20030.r := getRetimed(block2chunk0sub30("x8258").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8802_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8802_x18""")
              x8802_x18.r := (Math.mul(x20030, x20029, Some(6.0), true.B, Truncate, Wrapping, "x8802_x18")).r
              val x20031 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20031_x5536_elem_11_D9") 
              x20031.r := getRetimed(block2chunk0sub12("x5536_elem_11").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20032 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20032_x8259_D1") 
              x20032.r := getRetimed(block2chunk0sub30("x8259").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8803_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8803_x18""")
              x8803_x18.r := (Math.mul(x20032, x20031, Some(6.0), true.B, Truncate, Wrapping, "x8803_x18")).r
              val x20033 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20033_x5537_elem_12_D9") 
              x20033.r := getRetimed(block2chunk0sub12("x5537_elem_12").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20034 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20034_x8260_D1") 
              x20034.r := getRetimed(block2chunk0sub30("x8260").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8804_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8804_x18""")
              x8804_x18.r := (Math.mul(x20034, x20033, Some(6.0), true.B, Truncate, Wrapping, "x8804_x18")).r
              val x20035 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20035_x5538_elem_13_D9") 
              x20035.r := getRetimed(block2chunk0sub12("x5538_elem_13").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20036 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20036_x8261_D1") 
              x20036.r := getRetimed(block2chunk0sub30("x8261").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8805_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8805_x18""")
              x8805_x18.r := (Math.mul(x20036, x20035, Some(6.0), true.B, Truncate, Wrapping, "x8805_x18")).r
              val x20037 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20037_x5539_elem_14_D9") 
              x20037.r := getRetimed(block2chunk0sub12("x5539_elem_14").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x8758_x18" -> x8758_x18, "x8759_x18" -> x8759_x18, "x8792_x18" -> x8792_x18, "x8793_x18" -> x8793_x18, "x8794_x18" -> x8794_x18, "x8795_x18" -> x8795_x18, "x8796_x18" -> x8796_x18, "x8797_x18" -> x8797_x18, "x8798_x18" -> x8798_x18, "x8799_x18" -> x8799_x18, "x8800_x18" -> x8800_x18, "x8801_x18" -> x8801_x18, "x8802_x18" -> x8802_x18, "x8803_x18" -> x8803_x18, "x8804_x18" -> x8804_x18, "x8805_x18" -> x8805_x18, "x20037" -> x20037)
            }
          }
          val block2chunk0sub39: Map[String, Any] = Block2Chunker0Sub39.gen()
          object Block2Chunker0Sub40 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x20038 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20038_x8262_D1") 
              x20038.r := getRetimed(block2chunk0sub30("x8262").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8806_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8806_x18""")
              x8806_x18.r := (Math.mul(x20038, block2chunk0sub39("x20037").asInstanceOf[FixedPoint], Some(6.0), true.B, Truncate, Wrapping, "x8806_x18")).r
              val x20039 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20039_x8263_D1") 
              x20039.r := getRetimed(block2chunk0sub30("x8263").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20040 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20040_x5540_elem_15_D9") 
              x20040.r := getRetimed(block2chunk0sub12("x5540_elem_15").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8807_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8807_x18""")
              x8807_x18.r := (Math.mul(x20039, x20040, Some(6.0), true.B, Truncate, Wrapping, "x8807_x18")).r
              val x20041 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20041_x8264_D1") 
              x20041.r := getRetimed(block2chunk0sub30("x8264").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20042 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20042_x5541_elem_16_D9") 
              x20042.r := getRetimed(block2chunk0sub12("x5541_elem_16").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8808_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8808_x18""")
              x8808_x18.r := (Math.mul(x20041, x20042, Some(6.0), true.B, Truncate, Wrapping, "x8808_x18")).r
              val x20043 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20043_x5542_elem_17_D9") 
              x20043.r := getRetimed(block2chunk0sub13("x5542_elem_17").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20044 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20044_x8265_D1") 
              x20044.r := getRetimed(block2chunk0sub30("x8265").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8809_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8809_x18""")
              x8809_x18.r := (Math.mul(x20044, x20043, Some(6.0), true.B, Truncate, Wrapping, "x8809_x18")).r
              val x20045 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20045_x5543_elem_18_D9") 
              x20045.r := getRetimed(block2chunk0sub13("x5543_elem_18").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20046 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20046_x8266_D1") 
              x20046.r := getRetimed(block2chunk0sub30("x8266").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8810_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8810_x18""")
              x8810_x18.r := (Math.mul(x20046, x20045, Some(6.0), true.B, Truncate, Wrapping, "x8810_x18")).r
              val x20047 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20047_x8267_D1") 
              x20047.r := getRetimed(block2chunk0sub30("x8267").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20048 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20048_x5544_elem_19_D9") 
              x20048.r := getRetimed(block2chunk0sub13("x5544_elem_19").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8811_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8811_x18""")
              x8811_x18.r := (Math.mul(x20047, x20048, Some(6.0), true.B, Truncate, Wrapping, "x8811_x18")).r
              val x20049 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20049_x8268_D1") 
              x20049.r := getRetimed(block2chunk0sub30("x8268").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20050 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20050_x5545_elem_20_D9") 
              x20050.r := getRetimed(block2chunk0sub13("x5545_elem_20").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8812_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8812_x18""")
              x8812_x18.r := (Math.mul(x20049, x20050, Some(6.0), true.B, Truncate, Wrapping, "x8812_x18")).r
              val x20051 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20051_x8269_D1") 
              x20051.r := getRetimed(block2chunk0sub30("x8269").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20052 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20052_x5546_elem_21_D9") 
              x20052.r := getRetimed(block2chunk0sub13("x5546_elem_21").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8813_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8813_x18""")
              x8813_x18.r := (Math.mul(x20051, x20052, Some(6.0), true.B, Truncate, Wrapping, "x8813_x18")).r
              val x20053 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20053_x5547_elem_22_D9") 
              x20053.r := getRetimed(block2chunk0sub13("x5547_elem_22").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20054 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20054_x8270_D1") 
              x20054.r := getRetimed(block2chunk0sub30("x8270").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8814_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8814_x18""")
              x8814_x18.r := (Math.mul(x20054, x20053, Some(6.0), true.B, Truncate, Wrapping, "x8814_x18")).r
              val x20055 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20055_x5548_elem_23_D9") 
              x20055.r := getRetimed(block2chunk0sub13("x5548_elem_23").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20056 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20056_x8271_D1") 
              x20056.r := getRetimed(block2chunk0sub31("x8271").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8815_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8815_x18""")
              x8815_x18.r := (Math.mul(x20056, x20055, Some(6.0), true.B, Truncate, Wrapping, "x8815_x18")).r
              val x20057 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20057_x5549_elem_24_D9") 
              x20057.r := getRetimed(block2chunk0sub13("x5549_elem_24").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20058 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20058_x8272_D1") 
              x20058.r := getRetimed(block2chunk0sub31("x8272").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8816_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8816_x18""")
              x8816_x18.r := (Math.mul(x20058, x20057, Some(6.0), true.B, Truncate, Wrapping, "x8816_x18")).r
              val x20059 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20059_x8273_D1") 
              x20059.r := getRetimed(block2chunk0sub31("x8273").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20060 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20060_x5550_elem_25_D9") 
              x20060.r := getRetimed(block2chunk0sub13("x5550_elem_25").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8817_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8817_x18""")
              x8817_x18.r := (Math.mul(x20059, x20060, Some(6.0), true.B, Truncate, Wrapping, "x8817_x18")).r
              val x20061 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20061_x5551_elem_26_D9") 
              x20061.r := getRetimed(block2chunk0sub13("x5551_elem_26").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20062 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20062_x8274_D1") 
              x20062.r := getRetimed(block2chunk0sub31("x8274").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8818_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8818_x18""")
              x8818_x18.r := (Math.mul(x20062, x20061, Some(6.0), true.B, Truncate, Wrapping, "x8818_x18")).r
              val x20063 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20063_x5552_elem_27_D9") 
              x20063.r := getRetimed(block2chunk0sub13("x5552_elem_27").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20064 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20064_x8275_D1") 
              x20064.r := getRetimed(block2chunk0sub31("x8275").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8819_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8819_x18""")
              x8819_x18.r := (Math.mul(x20064, x20063, Some(6.0), true.B, Truncate, Wrapping, "x8819_x18")).r
              val x20065 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20065_x8276_D1") 
              x20065.r := getRetimed(block2chunk0sub31("x8276").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20066 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20066_x5553_elem_28_D9") 
              x20066.r := getRetimed(block2chunk0sub13("x5553_elem_28").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8820_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8820_x18""")
              x8820_x18.r := (Math.mul(x20065, x20066, Some(6.0), true.B, Truncate, Wrapping, "x8820_x18")).r
              val x20067 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20067_x8277_D1") 
              x20067.r := getRetimed(block2chunk0sub31("x8277").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x20068 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20068_x5554_elem_29_D9") 
              x20068.r := getRetimed(block2chunk0sub13("x5554_elem_29").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x8821_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8821_x18""")
              x8821_x18.r := (Math.mul(x20067, x20068, Some(6.0), true.B, Truncate, Wrapping, "x8821_x18")).r
              val x20069 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20069_x5555_elem_30_D9") 
              x20069.r := getRetimed(block2chunk0sub13("x5555_elem_30").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20070 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20070_x8278_D1") 
              x20070.r := getRetimed(block2chunk0sub31("x8278").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x8806_x18" -> x8806_x18, "x8807_x18" -> x8807_x18, "x8808_x18" -> x8808_x18, "x8809_x18" -> x8809_x18, "x8810_x18" -> x8810_x18, "x8811_x18" -> x8811_x18, "x8812_x18" -> x8812_x18, "x8813_x18" -> x8813_x18, "x8814_x18" -> x8814_x18, "x8815_x18" -> x8815_x18, "x8816_x18" -> x8816_x18, "x8817_x18" -> x8817_x18, "x8818_x18" -> x8818_x18, "x8819_x18" -> x8819_x18, "x8820_x18" -> x8820_x18, "x8821_x18" -> x8821_x18, "x20069" -> x20069, "x20070" -> x20070)
            }
          }
          val block2chunk0sub40: Map[String, Any] = Block2Chunker0Sub40.gen()
          object Block2Chunker0Sub41 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x8822_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8822_x18""")
              x8822_x18.r := (Math.mul(block2chunk0sub40("x20070").asInstanceOf[FixedPoint], block2chunk0sub40("x20069").asInstanceOf[FixedPoint], Some(6.0), true.B, Truncate, Wrapping, "x8822_x18")).r
              val x20071 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20071_x5556_elem_31_D9") 
              x20071.r := getRetimed(block2chunk0sub13("x5556_elem_31").asInstanceOf[FixedPoint].r, 9.toInt, io.sigsIn.backpressure)
              val x20072 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20072_x8279_D1") 
              x20072.r := getRetimed(block2chunk0sub31("x8279").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x8823_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8823_x18""")
              x8823_x18.r := (Math.mul(x20072, x20071, Some(6.0), true.B, Truncate, Wrapping, "x8823_x18")).r
              val x20073 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20073_x6104_D6") 
              x20073.r := getRetimed(block2chunk0sub16("x6104").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20074 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20074_x5294_elem_0_D15") 
              x20074.r := getRetimed(block2chunk0sub1("x5294_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18891 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18891""")
              x18891.r := Math.fma(x20073,x20074,block2chunk0sub33("x8600_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18891").toFixed(x18891, "cast_x18891").r
              val x20075 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20075_x6105_D6") 
              x20075.r := getRetimed(block2chunk0sub16("x6105").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20076 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20076_x5295_elem_1_D15") 
              x20076.r := getRetimed(block2chunk0sub1("x5295_elem_1").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18892 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18892""")
              x18892.r := Math.fma(x20075,x20076,block2chunk0sub33("x8601_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18892").toFixed(x18892, "cast_x18892").r
              val x20077 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20077_x5296_elem_2_D15") 
              x20077.r := getRetimed(block2chunk0sub1("x5296_elem_2").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20078 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20078_x6106_D6") 
              x20078.r := getRetimed(block2chunk0sub16("x6106").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18893 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18893""")
              x18893.r := Math.fma(x20078,x20077,block2chunk0sub33("x8602_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18893").toFixed(x18893, "cast_x18893").r
              val x20079 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20079_x6107_D6") 
              x20079.r := getRetimed(block2chunk0sub16("x6107").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20080 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20080_x5297_elem_3_D15") 
              x20080.r := getRetimed(block2chunk0sub1("x5297_elem_3").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18894 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18894""")
              x18894.r := Math.fma(x20079,x20080,block2chunk0sub33("x8603_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18894").toFixed(x18894, "cast_x18894").r
              val x20081 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20081_x6108_D6") 
              x20081.r := getRetimed(block2chunk0sub16("x6108").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20082 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20082_x5298_elem_4_D15") 
              x20082.r := getRetimed(block2chunk0sub1("x5298_elem_4").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18895 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18895""")
              x18895.r := Math.fma(x20081,x20082,block2chunk0sub33("x8604_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18895").toFixed(x18895, "cast_x18895").r
              val x20083 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20083_x6109_D6") 
              x20083.r := getRetimed(block2chunk0sub16("x6109").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20084 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20084_x5299_elem_5_D15") 
              x20084.r := getRetimed(block2chunk0sub1("x5299_elem_5").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18896 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18896""")
              x18896.r := Math.fma(x20083,x20084,block2chunk0sub33("x8605_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18896").toFixed(x18896, "cast_x18896").r
              val x20085 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20085_x5300_elem_6_D15") 
              x20085.r := getRetimed(block2chunk0sub1("x5300_elem_6").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20086 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20086_x6110_D6") 
              x20086.r := getRetimed(block2chunk0sub16("x6110").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18897 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18897""")
              x18897.r := Math.fma(x20086,x20085,block2chunk0sub33("x8606_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18897").toFixed(x18897, "cast_x18897").r
              val x20087 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20087_x6111_D6") 
              x20087.r := getRetimed(block2chunk0sub16("x6111").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20088 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20088_x5301_elem_7_D15") 
              x20088.r := getRetimed(block2chunk0sub1("x5301_elem_7").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18898 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18898""")
              x18898.r := Math.fma(x20087,x20088,block2chunk0sub33("x8607_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18898").toFixed(x18898, "cast_x18898").r
              val x20089 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20089_x6112_D6") 
              x20089.r := getRetimed(block2chunk0sub16("x6112").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20090 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20090_x5302_elem_8_D15") 
              x20090.r := getRetimed(block2chunk0sub1("x5302_elem_8").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18899 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18899""")
              x18899.r := Math.fma(x20089,x20090,block2chunk0sub33("x8608_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18899").toFixed(x18899, "cast_x18899").r
              val x20091 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20091_x5303_elem_9_D15") 
              x20091.r := getRetimed(block2chunk0sub1("x5303_elem_9").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20092 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20092_x6113_D6") 
              x20092.r := getRetimed(block2chunk0sub16("x6113").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18900 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18900""")
              x18900.r := Math.fma(x20092,x20091,block2chunk0sub33("x8609_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18900").toFixed(x18900, "cast_x18900").r
              val x20093 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20093_x6114_D6") 
              x20093.r := getRetimed(block2chunk0sub16("x6114").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20094 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20094_x5304_elem_10_D15") 
              x20094.r := getRetimed(block2chunk0sub1("x5304_elem_10").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18901 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18901""")
              x18901.r := Math.fma(x20093,x20094,block2chunk0sub33("x8610_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18901").toFixed(x18901, "cast_x18901").r
              val x20095 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20095_x6115_D6") 
              x20095.r := getRetimed(block2chunk0sub16("x6115").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20096 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20096_x5305_elem_11_D15") 
              x20096.r := getRetimed(block2chunk0sub1("x5305_elem_11").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18902 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18902""")
              x18902.r := Math.fma(x20095,x20096,block2chunk0sub33("x8611_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18902").toFixed(x18902, "cast_x18902").r
              val x20097 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20097_x6116_D6") 
              x20097.r := getRetimed(block2chunk0sub16("x6116").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20098 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20098_x5306_elem_12_D15") 
              x20098.r := getRetimed(block2chunk0sub2("x5306_elem_12").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18903 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18903""")
              x18903.r := Math.fma(x20097,x20098,block2chunk0sub34("x8612_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18903").toFixed(x18903, "cast_x18903").r
              val x20099 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20099_x5307_elem_13_D15") 
              x20099.r := getRetimed(block2chunk0sub2("x5307_elem_13").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20100 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20100_x6117_D6") 
              x20100.r := getRetimed(block2chunk0sub16("x6117").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18904 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18904""")
              x18904.r := Math.fma(x20100,x20099,block2chunk0sub34("x8613_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18904").toFixed(x18904, "cast_x18904").r
              val x20101 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20101_x6118_D6") 
              x20101.r := getRetimed(block2chunk0sub16("x6118").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20102 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20102_x5308_elem_14_D15") 
              x20102.r := getRetimed(block2chunk0sub2("x5308_elem_14").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18905 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18905""")
              x18905.r := Math.fma(x20101,x20102,block2chunk0sub34("x8614_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18905").toFixed(x18905, "cast_x18905").r
              Map[String,Any]("x8822_x18" -> x8822_x18, "x8823_x18" -> x8823_x18, "x18891" -> x18891, "x18892" -> x18892, "x18893" -> x18893, "x18894" -> x18894, "x18895" -> x18895, "x18896" -> x18896, "x18897" -> x18897, "x18898" -> x18898, "x18899" -> x18899, "x18900" -> x18900, "x18901" -> x18901, "x18902" -> x18902, "x18903" -> x18903, "x18904" -> x18904, "x18905" -> x18905)
            }
          }
          val block2chunk0sub41: Map[String, Any] = Block2Chunker0Sub41.gen()
          object Block2Chunker0Sub42 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x20103 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20103_x6119_D6") 
              x20103.r := getRetimed(block2chunk0sub16("x6119").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20104 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20104_x5309_elem_15_D15") 
              x20104.r := getRetimed(block2chunk0sub2("x5309_elem_15").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18906 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18906""")
              x18906.r := Math.fma(x20103,x20104,block2chunk0sub34("x8615_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18906").toFixed(x18906, "cast_x18906").r
              val x20105 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20105_x6120_D6") 
              x20105.r := getRetimed(block2chunk0sub16("x6120").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20106 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20106_x5310_elem_16_D15") 
              x20106.r := getRetimed(block2chunk0sub2("x5310_elem_16").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18907 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18907""")
              x18907.r := Math.fma(x20105,x20106,block2chunk0sub34("x8616_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18907").toFixed(x18907, "cast_x18907").r
              val x20107 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20107_x5311_elem_17_D15") 
              x20107.r := getRetimed(block2chunk0sub2("x5311_elem_17").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20108 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20108_x6121_D6") 
              x20108.r := getRetimed(block2chunk0sub16("x6121").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18908 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18908""")
              x18908.r := Math.fma(x20108,x20107,block2chunk0sub34("x8617_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18908").toFixed(x18908, "cast_x18908").r
              val x20109 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20109_x5312_elem_18_D15") 
              x20109.r := getRetimed(block2chunk0sub2("x5312_elem_18").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20110 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20110_x6122_D6") 
              x20110.r := getRetimed(block2chunk0sub16("x6122").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18909 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18909""")
              x18909.r := Math.fma(x20110,x20109,block2chunk0sub34("x8618_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18909").toFixed(x18909, "cast_x18909").r
              val x20111 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20111_x6123_D6") 
              x20111.r := getRetimed(block2chunk0sub16("x6123").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20112 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20112_x5313_elem_19_D15") 
              x20112.r := getRetimed(block2chunk0sub2("x5313_elem_19").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18910 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18910""")
              x18910.r := Math.fma(x20111,x20112,block2chunk0sub34("x8619_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18910").toFixed(x18910, "cast_x18910").r
              val x20113 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20113_x5314_elem_20_D15") 
              x20113.r := getRetimed(block2chunk0sub2("x5314_elem_20").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20114 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20114_x6124_D6") 
              x20114.r := getRetimed(block2chunk0sub16("x6124").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18911 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18911""")
              x18911.r := Math.fma(x20114,x20113,block2chunk0sub34("x8620_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18911").toFixed(x18911, "cast_x18911").r
              val x20115 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20115_x5315_elem_21_D15") 
              x20115.r := getRetimed(block2chunk0sub2("x5315_elem_21").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20116 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20116_x6125_D6") 
              x20116.r := getRetimed(block2chunk0sub16("x6125").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18912 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18912""")
              x18912.r := Math.fma(x20116,x20115,block2chunk0sub34("x8621_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18912").toFixed(x18912, "cast_x18912").r
              val x20117 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20117_x6126_D6") 
              x20117.r := getRetimed(block2chunk0sub16("x6126").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20118 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20118_x5316_elem_22_D15") 
              x20118.r := getRetimed(block2chunk0sub2("x5316_elem_22").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18913 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18913""")
              x18913.r := Math.fma(x20117,x20118,block2chunk0sub34("x8622_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18913").toFixed(x18913, "cast_x18913").r
              val x20119 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20119_x5317_elem_23_D15") 
              x20119.r := getRetimed(block2chunk0sub2("x5317_elem_23").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20120 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20120_x6127_D6") 
              x20120.r := getRetimed(block2chunk0sub16("x6127").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18914 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18914""")
              x18914.r := Math.fma(x20120,x20119,block2chunk0sub34("x8623_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18914").toFixed(x18914, "cast_x18914").r
              val x20121 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20121_x5318_elem_24_D15") 
              x20121.r := getRetimed(block2chunk0sub2("x5318_elem_24").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20122 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20122_x6128_D6") 
              x20122.r := getRetimed(block2chunk0sub16("x6128").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18915 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18915""")
              x18915.r := Math.fma(x20122,x20121,block2chunk0sub34("x8624_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18915").toFixed(x18915, "cast_x18915").r
              val x20123 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20123_x5319_elem_25_D15") 
              x20123.r := getRetimed(block2chunk0sub2("x5319_elem_25").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20124 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20124_x6129_D6") 
              x20124.r := getRetimed(block2chunk0sub16("x6129").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18916 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18916""")
              x18916.r := Math.fma(x20124,x20123,block2chunk0sub34("x8625_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18916").toFixed(x18916, "cast_x18916").r
              val x20125 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20125_x6130_D6") 
              x20125.r := getRetimed(block2chunk0sub16("x6130").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20126 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20126_x5320_elem_26_D15") 
              x20126.r := getRetimed(block2chunk0sub2("x5320_elem_26").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18917 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18917""")
              x18917.r := Math.fma(x20125,x20126,block2chunk0sub34("x8626_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18917").toFixed(x18917, "cast_x18917").r
              val x20127 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20127_x6131_D6") 
              x20127.r := getRetimed(block2chunk0sub16("x6131").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20128 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20128_x5321_elem_27_D15") 
              x20128.r := getRetimed(block2chunk0sub2("x5321_elem_27").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18918 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18918""")
              x18918.r := Math.fma(x20127,x20128,block2chunk0sub34("x8627_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18918").toFixed(x18918, "cast_x18918").r
              val x20129 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20129_x5322_elem_28_D15") 
              x20129.r := getRetimed(block2chunk0sub2("x5322_elem_28").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20130 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20130_x6132_D6") 
              x20130.r := getRetimed(block2chunk0sub16("x6132").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18919 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18919""")
              x18919.r := Math.fma(x20130,x20129,block2chunk0sub35("x8628_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18919").toFixed(x18919, "cast_x18919").r
              val x20131 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20131_x6133_D6") 
              x20131.r := getRetimed(block2chunk0sub16("x6133").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20132 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20132_x5323_elem_29_D15") 
              x20132.r := getRetimed(block2chunk0sub2("x5323_elem_29").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18920 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18920""")
              x18920.r := Math.fma(x20131,x20132,block2chunk0sub35("x8629_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18920").toFixed(x18920, "cast_x18920").r
              val x20133 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20133_x5324_elem_30_D15") 
              x20133.r := getRetimed(block2chunk0sub2("x5324_elem_30").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20134 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20134_x6134_D6") 
              x20134.r := getRetimed(block2chunk0sub17("x6134").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18921 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18921""")
              x18921.r := Math.fma(x20134,x20133,block2chunk0sub35("x8630_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18921").toFixed(x18921, "cast_x18921").r
              val x20135 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20135_x5325_elem_31_D15") 
              x20135.r := getRetimed(block2chunk0sub2("x5325_elem_31").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x18906" -> x18906, "x18907" -> x18907, "x18908" -> x18908, "x18909" -> x18909, "x18910" -> x18910, "x18911" -> x18911, "x18912" -> x18912, "x18913" -> x18913, "x18914" -> x18914, "x18915" -> x18915, "x18916" -> x18916, "x18917" -> x18917, "x18918" -> x18918, "x18919" -> x18919, "x18920" -> x18920, "x18921" -> x18921, "x20135" -> x20135)
            }
          }
          val block2chunk0sub42: Map[String, Any] = Block2Chunker0Sub42.gen()
          object Block2Chunker0Sub43 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x20136 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20136_x6135_D6") 
              x20136.r := getRetimed(block2chunk0sub17("x6135").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18922 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18922""")
              x18922.r := Math.fma(x20136,block2chunk0sub42("x20135").asInstanceOf[FixedPoint],block2chunk0sub35("x8631_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18922").toFixed(x18922, "cast_x18922").r
              val x20137 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20137_x5360_elem_0_D15") 
              x20137.r := getRetimed(block2chunk0sub4("x5360_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20138 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20138_x6712_D6") 
              x20138.r := getRetimed(block2chunk0sub20("x6712").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18923 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18923""")
              x18923.r := Math.fma(x20138,x20137,block2chunk0sub35("x8664_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18923").toFixed(x18923, "cast_x18923").r
              val x20139 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20139_x6713_D6") 
              x20139.r := getRetimed(block2chunk0sub20("x6713").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20140 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20140_x5361_elem_1_D15") 
              x20140.r := getRetimed(block2chunk0sub4("x5361_elem_1").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18924 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18924""")
              x18924.r := Math.fma(x20139,x20140,block2chunk0sub35("x8665_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18924").toFixed(x18924, "cast_x18924").r
              val x20141 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20141_x6714_D6") 
              x20141.r := getRetimed(block2chunk0sub20("x6714").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20142 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20142_x5362_elem_2_D15") 
              x20142.r := getRetimed(block2chunk0sub5("x5362_elem_2").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18925 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18925""")
              x18925.r := Math.fma(x20141,x20142,block2chunk0sub35("x8666_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18925").toFixed(x18925, "cast_x18925").r
              val x20143 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20143_x6715_D6") 
              x20143.r := getRetimed(block2chunk0sub20("x6715").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20144 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20144_x5363_elem_3_D15") 
              x20144.r := getRetimed(block2chunk0sub5("x5363_elem_3").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18926 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18926""")
              x18926.r := Math.fma(x20143,x20144,block2chunk0sub35("x8667_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18926").toFixed(x18926, "cast_x18926").r
              val x20145 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20145_x5364_elem_4_D15") 
              x20145.r := getRetimed(block2chunk0sub5("x5364_elem_4").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20146 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20146_x6716_D6") 
              x20146.r := getRetimed(block2chunk0sub20("x6716").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18927 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18927""")
              x18927.r := Math.fma(x20146,x20145,block2chunk0sub35("x8668_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18927").toFixed(x18927, "cast_x18927").r
              val x20147 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20147_x6717_D6") 
              x20147.r := getRetimed(block2chunk0sub20("x6717").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20148 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20148_x5365_elem_5_D15") 
              x20148.r := getRetimed(block2chunk0sub5("x5365_elem_5").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18928 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18928""")
              x18928.r := Math.fma(x20147,x20148,block2chunk0sub35("x8669_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18928").toFixed(x18928, "cast_x18928").r
              val x20149 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20149_x6718_D6") 
              x20149.r := getRetimed(block2chunk0sub20("x6718").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20150 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20150_x5366_elem_6_D15") 
              x20150.r := getRetimed(block2chunk0sub5("x5366_elem_6").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18929 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18929""")
              x18929.r := Math.fma(x20149,x20150,block2chunk0sub35("x8670_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18929").toFixed(x18929, "cast_x18929").r
              val x20151 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20151_x6719_D6") 
              x20151.r := getRetimed(block2chunk0sub20("x6719").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20152 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20152_x5367_elem_7_D15") 
              x20152.r := getRetimed(block2chunk0sub5("x5367_elem_7").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18930 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18930""")
              x18930.r := Math.fma(x20151,x20152,block2chunk0sub35("x8671_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18930").toFixed(x18930, "cast_x18930").r
              val x20153 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20153_x5368_elem_8_D15") 
              x20153.r := getRetimed(block2chunk0sub5("x5368_elem_8").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20154 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20154_x6720_D6") 
              x20154.r := getRetimed(block2chunk0sub20("x6720").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18931 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18931""")
              x18931.r := Math.fma(x20154,x20153,block2chunk0sub35("x8672_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18931").toFixed(x18931, "cast_x18931").r
              val x20155 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20155_x6721_D6") 
              x20155.r := getRetimed(block2chunk0sub20("x6721").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20156 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20156_x5369_elem_9_D15") 
              x20156.r := getRetimed(block2chunk0sub5("x5369_elem_9").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18932 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18932""")
              x18932.r := Math.fma(x20155,x20156,block2chunk0sub35("x8673_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18932").toFixed(x18932, "cast_x18932").r
              val x20157 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20157_x6722_D6") 
              x20157.r := getRetimed(block2chunk0sub20("x6722").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20158 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20158_x5370_elem_10_D15") 
              x20158.r := getRetimed(block2chunk0sub5("x5370_elem_10").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18933 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18933""")
              x18933.r := Math.fma(x20157,x20158,block2chunk0sub35("x8674_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18933").toFixed(x18933, "cast_x18933").r
              val x20159 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20159_x5371_elem_11_D15") 
              x20159.r := getRetimed(block2chunk0sub5("x5371_elem_11").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20160 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20160_x6723_D6") 
              x20160.r := getRetimed(block2chunk0sub20("x6723").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18934 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18934""")
              x18934.r := Math.fma(x20160,x20159,block2chunk0sub35("x8675_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18934").toFixed(x18934, "cast_x18934").r
              val x20161 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20161_x5372_elem_12_D15") 
              x20161.r := getRetimed(block2chunk0sub5("x5372_elem_12").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20162 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20162_x6724_D6") 
              x20162.r := getRetimed(block2chunk0sub20("x6724").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18935 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18935""")
              x18935.r := Math.fma(x20162,x20161,block2chunk0sub35("x8676_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18935").toFixed(x18935, "cast_x18935").r
              val x20163 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20163_x6725_D6") 
              x20163.r := getRetimed(block2chunk0sub20("x6725").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20164 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20164_x5373_elem_13_D15") 
              x20164.r := getRetimed(block2chunk0sub5("x5373_elem_13").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18936 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18936""")
              x18936.r := Math.fma(x20163,x20164,block2chunk0sub36("x8677_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18936").toFixed(x18936, "cast_x18936").r
              val x20165 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20165_x6726_D6") 
              x20165.r := getRetimed(block2chunk0sub20("x6726").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20166 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20166_x5374_elem_14_D15") 
              x20166.r := getRetimed(block2chunk0sub5("x5374_elem_14").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18937 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18937""")
              x18937.r := Math.fma(x20165,x20166,block2chunk0sub36("x8678_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18937").toFixed(x18937, "cast_x18937").r
              val x20167 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20167_x5375_elem_15_D15") 
              x20167.r := getRetimed(block2chunk0sub5("x5375_elem_15").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20168 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20168_x6727_D6") 
              x20168.r := getRetimed(block2chunk0sub20("x6727").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x18922" -> x18922, "x18923" -> x18923, "x18924" -> x18924, "x18925" -> x18925, "x18926" -> x18926, "x18927" -> x18927, "x18928" -> x18928, "x18929" -> x18929, "x18930" -> x18930, "x18931" -> x18931, "x18932" -> x18932, "x18933" -> x18933, "x18934" -> x18934, "x18935" -> x18935, "x18936" -> x18936, "x18937" -> x18937, "x20167" -> x20167, "x20168" -> x20168)
            }
          }
          val block2chunk0sub43: Map[String, Any] = Block2Chunker0Sub43.gen()
          object Block2Chunker0Sub44 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x18938 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18938""")
              x18938.r := Math.fma(block2chunk0sub43("x20168").asInstanceOf[FixedPoint],block2chunk0sub43("x20167").asInstanceOf[FixedPoint],block2chunk0sub36("x8679_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18938").toFixed(x18938, "cast_x18938").r
              val x20169 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20169_x5376_elem_16_D15") 
              x20169.r := getRetimed(block2chunk0sub5("x5376_elem_16").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20170 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20170_x6728_D6") 
              x20170.r := getRetimed(block2chunk0sub21("x6728").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18939 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18939""")
              x18939.r := Math.fma(x20170,x20169,block2chunk0sub36("x8680_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18939").toFixed(x18939, "cast_x18939").r
              val x20171 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20171_x6729_D6") 
              x20171.r := getRetimed(block2chunk0sub21("x6729").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20172 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20172_x5377_elem_17_D15") 
              x20172.r := getRetimed(block2chunk0sub5("x5377_elem_17").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18940 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18940""")
              x18940.r := Math.fma(x20171,x20172,block2chunk0sub36("x8681_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18940").toFixed(x18940, "cast_x18940").r
              val x20173 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20173_x5378_elem_18_D15") 
              x20173.r := getRetimed(block2chunk0sub5("x5378_elem_18").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20174 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20174_x6730_D6") 
              x20174.r := getRetimed(block2chunk0sub21("x6730").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18941 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18941""")
              x18941.r := Math.fma(x20174,x20173,block2chunk0sub36("x8682_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18941").toFixed(x18941, "cast_x18941").r
              val x20175 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20175_x6731_D6") 
              x20175.r := getRetimed(block2chunk0sub21("x6731").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20176 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20176_x5379_elem_19_D15") 
              x20176.r := getRetimed(block2chunk0sub5("x5379_elem_19").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18942 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18942""")
              x18942.r := Math.fma(x20175,x20176,block2chunk0sub36("x8683_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18942").toFixed(x18942, "cast_x18942").r
              val x20177 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20177_x5380_elem_20_D15") 
              x20177.r := getRetimed(block2chunk0sub5("x5380_elem_20").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20178 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20178_x6732_D6") 
              x20178.r := getRetimed(block2chunk0sub21("x6732").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18943 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18943""")
              x18943.r := Math.fma(x20178,x20177,block2chunk0sub36("x8684_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18943").toFixed(x18943, "cast_x18943").r
              val x20179 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20179_x6733_D6") 
              x20179.r := getRetimed(block2chunk0sub21("x6733").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20180 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20180_x5381_elem_21_D15") 
              x20180.r := getRetimed(block2chunk0sub5("x5381_elem_21").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18944 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18944""")
              x18944.r := Math.fma(x20179,x20180,block2chunk0sub36("x8685_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18944").toFixed(x18944, "cast_x18944").r
              val x20181 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20181_x5382_elem_22_D15") 
              x20181.r := getRetimed(block2chunk0sub5("x5382_elem_22").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20182 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20182_x6734_D6") 
              x20182.r := getRetimed(block2chunk0sub21("x6734").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18945 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18945""")
              x18945.r := Math.fma(x20182,x20181,block2chunk0sub36("x8686_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18945").toFixed(x18945, "cast_x18945").r
              val x20183 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20183_x6735_D6") 
              x20183.r := getRetimed(block2chunk0sub21("x6735").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20184 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20184_x5383_elem_23_D15") 
              x20184.r := getRetimed(block2chunk0sub5("x5383_elem_23").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18946 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18946""")
              x18946.r := Math.fma(x20183,x20184,block2chunk0sub36("x8687_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18946").toFixed(x18946, "cast_x18946").r
              val x20185 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20185_x6736_D6") 
              x20185.r := getRetimed(block2chunk0sub21("x6736").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20186 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20186_x5384_elem_24_D15") 
              x20186.r := getRetimed(block2chunk0sub5("x5384_elem_24").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18947 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18947""")
              x18947.r := Math.fma(x20185,x20186,block2chunk0sub36("x8688_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18947").toFixed(x18947, "cast_x18947").r
              val x20187 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20187_x6737_D6") 
              x20187.r := getRetimed(block2chunk0sub21("x6737").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20188 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20188_x5385_elem_25_D15") 
              x20188.r := getRetimed(block2chunk0sub5("x5385_elem_25").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18948 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18948""")
              x18948.r := Math.fma(x20187,x20188,block2chunk0sub36("x8689_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18948").toFixed(x18948, "cast_x18948").r
              val x20189 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20189_x5386_elem_26_D15") 
              x20189.r := getRetimed(block2chunk0sub5("x5386_elem_26").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20190 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20190_x6738_D6") 
              x20190.r := getRetimed(block2chunk0sub21("x6738").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18949 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18949""")
              x18949.r := Math.fma(x20190,x20189,block2chunk0sub36("x8690_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18949").toFixed(x18949, "cast_x18949").r
              val x20191 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20191_x6739_D6") 
              x20191.r := getRetimed(block2chunk0sub21("x6739").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20192 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20192_x5387_elem_27_D15") 
              x20192.r := getRetimed(block2chunk0sub5("x5387_elem_27").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18950 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18950""")
              x18950.r := Math.fma(x20191,x20192,block2chunk0sub36("x8691_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18950").toFixed(x18950, "cast_x18950").r
              val x20193 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20193_x5388_elem_28_D15") 
              x20193.r := getRetimed(block2chunk0sub5("x5388_elem_28").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20194 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20194_x6740_D6") 
              x20194.r := getRetimed(block2chunk0sub21("x6740").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18951 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18951""")
              x18951.r := Math.fma(x20194,x20193,block2chunk0sub36("x8692_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18951").toFixed(x18951, "cast_x18951").r
              val x20195 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20195_x5389_elem_29_D15") 
              x20195.r := getRetimed(block2chunk0sub5("x5389_elem_29").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20196 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20196_x6741_D6") 
              x20196.r := getRetimed(block2chunk0sub21("x6741").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18952 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18952""")
              x18952.r := Math.fma(x20196,x20195,block2chunk0sub37("x8693_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18952").toFixed(x18952, "cast_x18952").r
              val x20197 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20197_x6742_D6") 
              x20197.r := getRetimed(block2chunk0sub21("x6742").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20198 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20198_x5390_elem_30_D15") 
              x20198.r := getRetimed(block2chunk0sub5("x5390_elem_30").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18953 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18953""")
              x18953.r := Math.fma(x20197,x20198,block2chunk0sub37("x8694_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18953").toFixed(x18953, "cast_x18953").r
              val x20199 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20199_x6743_D6") 
              x20199.r := getRetimed(block2chunk0sub21("x6743").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20200 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20200_x5391_elem_31_D15") 
              x20200.r := getRetimed(block2chunk0sub5("x5391_elem_31").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18954 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18954""")
              x18954.r := Math.fma(x20199,x20200,block2chunk0sub37("x8695_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18954").toFixed(x18954, "cast_x18954").r
              Map[String,Any]("x18938" -> x18938, "x18939" -> x18939, "x18940" -> x18940, "x18941" -> x18941, "x18942" -> x18942, "x18943" -> x18943, "x18944" -> x18944, "x18945" -> x18945, "x18946" -> x18946, "x18947" -> x18947, "x18948" -> x18948, "x18949" -> x18949, "x18950" -> x18950, "x18951" -> x18951, "x18952" -> x18952, "x18953" -> x18953, "x18954" -> x18954)
            }
          }
          val block2chunk0sub44: Map[String, Any] = Block2Chunker0Sub44.gen()
          object Block2Chunker0Sub45 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x20201 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20201_x5426_elem_0_D15") 
              x20201.r := getRetimed(block2chunk0sub7("x5426_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20202 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20202_x7133_elem_0_D8") 
              x20202.r := getRetimed(block2chunk0sub23("x7133_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18955 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18955""")
              x18955.r := Math.fma(x20202,x20201,block2chunk0sub37("x8728_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18955").toFixed(x18955, "cast_x18955").r
              val x20203 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20203_x5427_elem_1_D15") 
              x20203.r := getRetimed(block2chunk0sub7("x5427_elem_1").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20204 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20204_x7139_elem_0_D8") 
              x20204.r := getRetimed(block2chunk0sub23("x7139_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18956 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18956""")
              x18956.r := Math.fma(x20204,x20203,block2chunk0sub37("x8729_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18956").toFixed(x18956, "cast_x18956").r
              val x20205 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20205_x7145_elem_0_D8") 
              x20205.r := getRetimed(block2chunk0sub23("x7145_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20206 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20206_x5428_elem_2_D15") 
              x20206.r := getRetimed(block2chunk0sub8("x5428_elem_2").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18957 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18957""")
              x18957.r := Math.fma(x20205,x20206,block2chunk0sub37("x8730_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18957").toFixed(x18957, "cast_x18957").r
              val x20207 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20207_x7151_elem_0_D8") 
              x20207.r := getRetimed(block2chunk0sub23("x7151_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20208 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20208_x5429_elem_3_D15") 
              x20208.r := getRetimed(block2chunk0sub8("x5429_elem_3").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18958 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18958""")
              x18958.r := Math.fma(x20207,x20208,block2chunk0sub37("x8731_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18958").toFixed(x18958, "cast_x18958").r
              val x20209 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20209_x5430_elem_4_D15") 
              x20209.r := getRetimed(block2chunk0sub8("x5430_elem_4").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20210 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20210_x7157_elem_0_D8") 
              x20210.r := getRetimed(block2chunk0sub23("x7157_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18959 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18959""")
              x18959.r := Math.fma(x20210,x20209,block2chunk0sub37("x8732_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18959").toFixed(x18959, "cast_x18959").r
              val x20211 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20211_x7163_elem_0_D8") 
              x20211.r := getRetimed(block2chunk0sub23("x7163_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20212 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20212_x5431_elem_5_D15") 
              x20212.r := getRetimed(block2chunk0sub8("x5431_elem_5").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18960 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18960""")
              x18960.r := Math.fma(x20211,x20212,block2chunk0sub37("x8733_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18960").toFixed(x18960, "cast_x18960").r
              val x20213 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20213_x5432_elem_6_D15") 
              x20213.r := getRetimed(block2chunk0sub8("x5432_elem_6").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20214 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20214_x7169_elem_0_D8") 
              x20214.r := getRetimed(block2chunk0sub23("x7169_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18961 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18961""")
              x18961.r := Math.fma(x20214,x20213,block2chunk0sub37("x8734_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18961").toFixed(x18961, "cast_x18961").r
              val x20215 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20215_x7175_elem_0_D8") 
              x20215.r := getRetimed(block2chunk0sub23("x7175_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20216 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20216_x5433_elem_7_D15") 
              x20216.r := getRetimed(block2chunk0sub8("x5433_elem_7").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18962 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18962""")
              x18962.r := Math.fma(x20215,x20216,block2chunk0sub37("x8735_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18962").toFixed(x18962, "cast_x18962").r
              val x20217 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20217_x7181_elem_0_D8") 
              x20217.r := getRetimed(block2chunk0sub23("x7181_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20218 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20218_x5434_elem_8_D15") 
              x20218.r := getRetimed(block2chunk0sub8("x5434_elem_8").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18963 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18963""")
              x18963.r := Math.fma(x20217,x20218,block2chunk0sub37("x8736_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18963").toFixed(x18963, "cast_x18963").r
              val x20219 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20219_x7187_elem_0_D8") 
              x20219.r := getRetimed(block2chunk0sub24("x7187_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20220 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20220_x5435_elem_9_D15") 
              x20220.r := getRetimed(block2chunk0sub8("x5435_elem_9").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18964 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18964""")
              x18964.r := Math.fma(x20219,x20220,block2chunk0sub37("x8737_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18964").toFixed(x18964, "cast_x18964").r
              val x20221 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20221_x5436_elem_10_D15") 
              x20221.r := getRetimed(block2chunk0sub8("x5436_elem_10").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20222 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20222_x7193_elem_0_D8") 
              x20222.r := getRetimed(block2chunk0sub24("x7193_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18965 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18965""")
              x18965.r := Math.fma(x20222,x20221,block2chunk0sub37("x8738_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18965").toFixed(x18965, "cast_x18965").r
              val x20223 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20223_x7199_elem_0_D8") 
              x20223.r := getRetimed(block2chunk0sub24("x7199_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20224 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20224_x5437_elem_11_D15") 
              x20224.r := getRetimed(block2chunk0sub8("x5437_elem_11").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18966 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18966""")
              x18966.r := Math.fma(x20223,x20224,block2chunk0sub37("x8739_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18966").toFixed(x18966, "cast_x18966").r
              val x20225 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20225_x7205_elem_0_D8") 
              x20225.r := getRetimed(block2chunk0sub24("x7205_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20226 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20226_x5438_elem_12_D15") 
              x20226.r := getRetimed(block2chunk0sub8("x5438_elem_12").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18967 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18967""")
              x18967.r := Math.fma(x20225,x20226,block2chunk0sub37("x8740_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18967").toFixed(x18967, "cast_x18967").r
              val x20227 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20227_x7211_elem_0_D8") 
              x20227.r := getRetimed(block2chunk0sub24("x7211_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20228 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20228_x5439_elem_13_D15") 
              x20228.r := getRetimed(block2chunk0sub8("x5439_elem_13").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18968 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18968""")
              x18968.r := Math.fma(x20227,x20228,block2chunk0sub38("x8741_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18968").toFixed(x18968, "cast_x18968").r
              val x20229 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20229_x5440_elem_14_D15") 
              x20229.r := getRetimed(block2chunk0sub8("x5440_elem_14").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20230 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20230_x7217_elem_0_D8") 
              x20230.r := getRetimed(block2chunk0sub24("x7217_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18969 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18969""")
              x18969.r := Math.fma(x20230,x20229,block2chunk0sub38("x8742_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18969").toFixed(x18969, "cast_x18969").r
              val x20231 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20231_x5441_elem_15_D15") 
              x20231.r := getRetimed(block2chunk0sub8("x5441_elem_15").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20232 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20232_x7223_elem_0_D8") 
              x20232.r := getRetimed(block2chunk0sub24("x7223_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18970 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18970""")
              x18970.r := Math.fma(x20232,x20231,block2chunk0sub38("x8743_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18970").toFixed(x18970, "cast_x18970").r
              val x20233 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20233_x5442_elem_16_D15") 
              x20233.r := getRetimed(block2chunk0sub8("x5442_elem_16").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x18955" -> x18955, "x18956" -> x18956, "x18957" -> x18957, "x18958" -> x18958, "x18959" -> x18959, "x18960" -> x18960, "x18961" -> x18961, "x18962" -> x18962, "x18963" -> x18963, "x18964" -> x18964, "x18965" -> x18965, "x18966" -> x18966, "x18967" -> x18967, "x18968" -> x18968, "x18969" -> x18969, "x18970" -> x18970, "x20233" -> x20233)
            }
          }
          val block2chunk0sub45: Map[String, Any] = Block2Chunker0Sub45.gen()
          object Block2Chunker0Sub46 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x20234 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20234_x7229_elem_0_D8") 
              x20234.r := getRetimed(block2chunk0sub24("x7229_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18971 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18971""")
              x18971.r := Math.fma(x20234,block2chunk0sub45("x20233").asInstanceOf[FixedPoint],block2chunk0sub38("x8744_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18971").toFixed(x18971, "cast_x18971").r
              val x20235 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20235_x5443_elem_17_D15") 
              x20235.r := getRetimed(block2chunk0sub8("x5443_elem_17").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20236 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20236_x7235_elem_0_D8") 
              x20236.r := getRetimed(block2chunk0sub24("x7235_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18972 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18972""")
              x18972.r := Math.fma(x20236,x20235,block2chunk0sub38("x8745_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18972").toFixed(x18972, "cast_x18972").r
              val x20237 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20237_x7241_elem_0_D8") 
              x20237.r := getRetimed(block2chunk0sub24("x7241_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20238 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20238_x5444_elem_18_D15") 
              x20238.r := getRetimed(block2chunk0sub8("x5444_elem_18").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18973 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18973""")
              x18973.r := Math.fma(x20237,x20238,block2chunk0sub38("x8746_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18973").toFixed(x18973, "cast_x18973").r
              val x20239 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20239_x5445_elem_19_D15") 
              x20239.r := getRetimed(block2chunk0sub8("x5445_elem_19").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20240 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20240_x7247_elem_0_D8") 
              x20240.r := getRetimed(block2chunk0sub24("x7247_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18974 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18974""")
              x18974.r := Math.fma(x20240,x20239,block2chunk0sub38("x8747_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18974").toFixed(x18974, "cast_x18974").r
              val x20241 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20241_x5446_elem_20_D15") 
              x20241.r := getRetimed(block2chunk0sub8("x5446_elem_20").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20242 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20242_x7253_elem_0_D8") 
              x20242.r := getRetimed(block2chunk0sub24("x7253_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18975 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18975""")
              x18975.r := Math.fma(x20242,x20241,block2chunk0sub38("x8748_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18975").toFixed(x18975, "cast_x18975").r
              val x20243 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20243_x7259_elem_0_D8") 
              x20243.r := getRetimed(block2chunk0sub24("x7259_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20244 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20244_x5447_elem_21_D15") 
              x20244.r := getRetimed(block2chunk0sub8("x5447_elem_21").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18976 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18976""")
              x18976.r := Math.fma(x20243,x20244,block2chunk0sub38("x8749_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18976").toFixed(x18976, "cast_x18976").r
              val x20245 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20245_x7265_elem_0_D8") 
              x20245.r := getRetimed(block2chunk0sub24("x7265_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20246 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20246_x5448_elem_22_D15") 
              x20246.r := getRetimed(block2chunk0sub8("x5448_elem_22").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18977 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18977""")
              x18977.r := Math.fma(x20245,x20246,block2chunk0sub38("x8750_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18977").toFixed(x18977, "cast_x18977").r
              val x20247 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20247_x7271_elem_0_D8") 
              x20247.r := getRetimed(block2chunk0sub24("x7271_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20248 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20248_x5449_elem_23_D15") 
              x20248.r := getRetimed(block2chunk0sub8("x5449_elem_23").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18978 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18978""")
              x18978.r := Math.fma(x20247,x20248,block2chunk0sub38("x8751_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18978").toFixed(x18978, "cast_x18978").r
              val x20249 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20249_x5450_elem_24_D15") 
              x20249.r := getRetimed(block2chunk0sub8("x5450_elem_24").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20250 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20250_x7277_elem_0_D8") 
              x20250.r := getRetimed(block2chunk0sub24("x7277_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18979 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18979""")
              x18979.r := Math.fma(x20250,x20249,block2chunk0sub38("x8752_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18979").toFixed(x18979, "cast_x18979").r
              val x20251 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20251_x7283_elem_0_D8") 
              x20251.r := getRetimed(block2chunk0sub24("x7283_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20252 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20252_x5451_elem_25_D15") 
              x20252.r := getRetimed(block2chunk0sub8("x5451_elem_25").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18980 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18980""")
              x18980.r := Math.fma(x20251,x20252,block2chunk0sub38("x8753_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18980").toFixed(x18980, "cast_x18980").r
              val x20253 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20253_x5452_elem_26_D15") 
              x20253.r := getRetimed(block2chunk0sub8("x5452_elem_26").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20254 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20254_x7289_elem_0_D8") 
              x20254.r := getRetimed(block2chunk0sub24("x7289_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18981 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18981""")
              x18981.r := Math.fma(x20254,x20253,block2chunk0sub38("x8754_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18981").toFixed(x18981, "cast_x18981").r
              val x20255 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20255_x7295_elem_0_D8") 
              x20255.r := getRetimed(block2chunk0sub24("x7295_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20256 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20256_x5453_elem_27_D15") 
              x20256.r := getRetimed(block2chunk0sub8("x5453_elem_27").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18982 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18982""")
              x18982.r := Math.fma(x20255,x20256,block2chunk0sub38("x8755_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18982").toFixed(x18982, "cast_x18982").r
              val x20257 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20257_x7301_elem_0_D8") 
              x20257.r := getRetimed(block2chunk0sub24("x7301_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20258 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20258_x5454_elem_28_D15") 
              x20258.r := getRetimed(block2chunk0sub8("x5454_elem_28").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18983 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18983""")
              x18983.r := Math.fma(x20257,x20258,block2chunk0sub38("x8756_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18983").toFixed(x18983, "cast_x18983").r
              val x20259 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20259_x7307_elem_0_D8") 
              x20259.r := getRetimed(block2chunk0sub24("x7307_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20260 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20260_x5455_elem_29_D15") 
              x20260.r := getRetimed(block2chunk0sub8("x5455_elem_29").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18984 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18984""")
              x18984.r := Math.fma(x20259,x20260,block2chunk0sub38("x8757_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18984").toFixed(x18984, "cast_x18984").r
              val x20261 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20261_x5456_elem_30_D15") 
              x20261.r := getRetimed(block2chunk0sub8("x5456_elem_30").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20262 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20262_x7313_elem_0_D8") 
              x20262.r := getRetimed(block2chunk0sub24("x7313_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x18985 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18985""")
              x18985.r := Math.fma(x20262,x20261,block2chunk0sub39("x8758_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18985").toFixed(x18985, "cast_x18985").r
              val x20263 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20263_x7319_elem_0_D8") 
              x20263.r := getRetimed(block2chunk0sub24("x7319_elem_0").asInstanceOf[FixedPoint].r, 8.toInt, io.sigsIn.backpressure)
              val x20264 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20264_x5457_elem_31_D15") 
              x20264.r := getRetimed(block2chunk0sub8("x5457_elem_31").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18986 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18986""")
              x18986.r := Math.fma(x20263,x20264,block2chunk0sub39("x8759_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18986").toFixed(x18986, "cast_x18986").r
              val x20265 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20265_x7960_D6") 
              x20265.r := getRetimed(block2chunk0sub28("x7960").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20266 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20266_x5492_elem_0_D15") 
              x20266.r := getRetimed(block2chunk0sub10("x5492_elem_0").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x18971" -> x18971, "x18972" -> x18972, "x18973" -> x18973, "x18974" -> x18974, "x18975" -> x18975, "x18976" -> x18976, "x18977" -> x18977, "x18978" -> x18978, "x18979" -> x18979, "x18980" -> x18980, "x18981" -> x18981, "x18982" -> x18982, "x18983" -> x18983, "x18984" -> x18984, "x18985" -> x18985, "x18986" -> x18986, "x20265" -> x20265, "x20266" -> x20266)
            }
          }
          val block2chunk0sub46: Map[String, Any] = Block2Chunker0Sub46.gen()
          object Block2Chunker0Sub47 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x18987 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18987""")
              x18987.r := Math.fma(block2chunk0sub46("x20265").asInstanceOf[FixedPoint],block2chunk0sub46("x20266").asInstanceOf[FixedPoint],block2chunk0sub39("x8792_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18987").toFixed(x18987, "cast_x18987").r
              val x20267 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20267_x5493_elem_1_D15") 
              x20267.r := getRetimed(block2chunk0sub10("x5493_elem_1").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20268 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20268_x7961_D6") 
              x20268.r := getRetimed(block2chunk0sub28("x7961").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18988 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18988""")
              x18988.r := Math.fma(x20268,x20267,block2chunk0sub39("x8793_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18988").toFixed(x18988, "cast_x18988").r
              val x20269 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20269_x5494_elem_2_D15") 
              x20269.r := getRetimed(block2chunk0sub11("x5494_elem_2").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20270 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20270_x7962_D6") 
              x20270.r := getRetimed(block2chunk0sub28("x7962").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18989 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18989""")
              x18989.r := Math.fma(x20270,x20269,block2chunk0sub39("x8794_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18989").toFixed(x18989, "cast_x18989").r
              val x20271 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20271_x5495_elem_3_D15") 
              x20271.r := getRetimed(block2chunk0sub11("x5495_elem_3").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20272 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20272_x7963_D6") 
              x20272.r := getRetimed(block2chunk0sub28("x7963").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18990 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18990""")
              x18990.r := Math.fma(x20272,x20271,block2chunk0sub39("x8795_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18990").toFixed(x18990, "cast_x18990").r
              val x20273 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20273_x7964_D6") 
              x20273.r := getRetimed(block2chunk0sub28("x7964").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20274 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20274_x5496_elem_4_D15") 
              x20274.r := getRetimed(block2chunk0sub11("x5496_elem_4").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18991 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18991""")
              x18991.r := Math.fma(x20273,x20274,block2chunk0sub39("x8796_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18991").toFixed(x18991, "cast_x18991").r
              val x20275 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20275_x5497_elem_5_D15") 
              x20275.r := getRetimed(block2chunk0sub11("x5497_elem_5").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20276 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20276_x7965_D6") 
              x20276.r := getRetimed(block2chunk0sub28("x7965").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18992 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18992""")
              x18992.r := Math.fma(x20276,x20275,block2chunk0sub39("x8797_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18992").toFixed(x18992, "cast_x18992").r
              val x20277 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20277_x5498_elem_6_D15") 
              x20277.r := getRetimed(block2chunk0sub11("x5498_elem_6").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20278 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20278_x7966_D6") 
              x20278.r := getRetimed(block2chunk0sub28("x7966").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18993 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18993""")
              x18993.r := Math.fma(x20278,x20277,block2chunk0sub39("x8798_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18993").toFixed(x18993, "cast_x18993").r
              val x20279 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20279_x7967_D6") 
              x20279.r := getRetimed(block2chunk0sub28("x7967").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20280 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20280_x5499_elem_7_D15") 
              x20280.r := getRetimed(block2chunk0sub11("x5499_elem_7").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18994 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18994""")
              x18994.r := Math.fma(x20279,x20280,block2chunk0sub39("x8799_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18994").toFixed(x18994, "cast_x18994").r
              val x20281 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20281_x5500_elem_8_D15") 
              x20281.r := getRetimed(block2chunk0sub11("x5500_elem_8").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20282 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20282_x7968_D6") 
              x20282.r := getRetimed(block2chunk0sub28("x7968").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18995 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18995""")
              x18995.r := Math.fma(x20282,x20281,block2chunk0sub39("x8800_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18995").toFixed(x18995, "cast_x18995").r
              val x20283 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20283_x7969_D6") 
              x20283.r := getRetimed(block2chunk0sub28("x7969").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20284 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20284_x5501_elem_9_D15") 
              x20284.r := getRetimed(block2chunk0sub11("x5501_elem_9").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18996 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18996""")
              x18996.r := Math.fma(x20283,x20284,block2chunk0sub39("x8801_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18996").toFixed(x18996, "cast_x18996").r
              val x20285 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20285_x7970_D6") 
              x20285.r := getRetimed(block2chunk0sub28("x7970").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20286 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20286_x5502_elem_10_D15") 
              x20286.r := getRetimed(block2chunk0sub11("x5502_elem_10").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18997 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18997""")
              x18997.r := Math.fma(x20285,x20286,block2chunk0sub39("x8802_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18997").toFixed(x18997, "cast_x18997").r
              val x20287 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20287_x7971_D6") 
              x20287.r := getRetimed(block2chunk0sub28("x7971").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20288 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20288_x5503_elem_11_D15") 
              x20288.r := getRetimed(block2chunk0sub11("x5503_elem_11").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x18998 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18998""")
              x18998.r := Math.fma(x20287,x20288,block2chunk0sub39("x8803_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18998").toFixed(x18998, "cast_x18998").r
              val x20289 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20289_x5504_elem_12_D15") 
              x20289.r := getRetimed(block2chunk0sub11("x5504_elem_12").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20290 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20290_x7972_D6") 
              x20290.r := getRetimed(block2chunk0sub28("x7972").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x18999 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18999""")
              x18999.r := Math.fma(x20290,x20289,block2chunk0sub39("x8804_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x18999").toFixed(x18999, "cast_x18999").r
              val x20291 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20291_x5505_elem_13_D15") 
              x20291.r := getRetimed(block2chunk0sub11("x5505_elem_13").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20292 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20292_x7973_D6") 
              x20292.r := getRetimed(block2chunk0sub28("x7973").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x19000 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19000""")
              x19000.r := Math.fma(x20292,x20291,block2chunk0sub39("x8805_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19000").toFixed(x19000, "cast_x19000").r
              val x20293 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20293_x7974_D6") 
              x20293.r := getRetimed(block2chunk0sub28("x7974").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20294 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20294_x5506_elem_14_D15") 
              x20294.r := getRetimed(block2chunk0sub11("x5506_elem_14").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x19001 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19001""")
              x19001.r := Math.fma(x20293,x20294,block2chunk0sub40("x8806_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19001").toFixed(x19001, "cast_x19001").r
              val x20295 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20295_x7975_D6") 
              x20295.r := getRetimed(block2chunk0sub28("x7975").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20296 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20296_x5507_elem_15_D15") 
              x20296.r := getRetimed(block2chunk0sub11("x5507_elem_15").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x19002 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19002""")
              x19002.r := Math.fma(x20295,x20296,block2chunk0sub40("x8807_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19002").toFixed(x19002, "cast_x19002").r
              val x20297 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20297_x5508_elem_16_D15") 
              x20297.r := getRetimed(block2chunk0sub11("x5508_elem_16").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20298 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20298_x7976_D6") 
              x20298.r := getRetimed(block2chunk0sub28("x7976").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x19003 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19003""")
              x19003.r := Math.fma(x20298,x20297,block2chunk0sub40("x8808_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19003").toFixed(x19003, "cast_x19003").r
              Map[String,Any]("x18987" -> x18987, "x18988" -> x18988, "x18989" -> x18989, "x18990" -> x18990, "x18991" -> x18991, "x18992" -> x18992, "x18993" -> x18993, "x18994" -> x18994, "x18995" -> x18995, "x18996" -> x18996, "x18997" -> x18997, "x18998" -> x18998, "x18999" -> x18999, "x19000" -> x19000, "x19001" -> x19001, "x19002" -> x19002, "x19003" -> x19003)
            }
          }
          val block2chunk0sub47: Map[String, Any] = Block2Chunker0Sub47.gen()
          object Block2Chunker0Sub48 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x20299 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20299_x7977_D6") 
              x20299.r := getRetimed(block2chunk0sub28("x7977").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20300 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20300_x5509_elem_17_D15") 
              x20300.r := getRetimed(block2chunk0sub11("x5509_elem_17").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x19004 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19004""")
              x19004.r := Math.fma(x20299,x20300,block2chunk0sub40("x8809_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19004").toFixed(x19004, "cast_x19004").r
              val x20301 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20301_x5510_elem_18_D15") 
              x20301.r := getRetimed(block2chunk0sub11("x5510_elem_18").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20302 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20302_x7978_D6") 
              x20302.r := getRetimed(block2chunk0sub28("x7978").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x19005 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19005""")
              x19005.r := Math.fma(x20302,x20301,block2chunk0sub40("x8810_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19005").toFixed(x19005, "cast_x19005").r
              val x20303 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20303_x7979_D6") 
              x20303.r := getRetimed(block2chunk0sub28("x7979").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20304 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20304_x5511_elem_19_D15") 
              x20304.r := getRetimed(block2chunk0sub11("x5511_elem_19").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x19006 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19006""")
              x19006.r := Math.fma(x20303,x20304,block2chunk0sub40("x8811_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19006").toFixed(x19006, "cast_x19006").r
              val x20305 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20305_x5512_elem_20_D15") 
              x20305.r := getRetimed(block2chunk0sub11("x5512_elem_20").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20306 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20306_x7980_D6") 
              x20306.r := getRetimed(block2chunk0sub28("x7980").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x19007 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19007""")
              x19007.r := Math.fma(x20306,x20305,block2chunk0sub40("x8812_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19007").toFixed(x19007, "cast_x19007").r
              val x20307 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20307_x5513_elem_21_D15") 
              x20307.r := getRetimed(block2chunk0sub11("x5513_elem_21").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20308 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20308_x7981_D6") 
              x20308.r := getRetimed(block2chunk0sub28("x7981").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x19008 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19008""")
              x19008.r := Math.fma(x20308,x20307,block2chunk0sub40("x8813_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19008").toFixed(x19008, "cast_x19008").r
              val x20309 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20309_x5514_elem_22_D15") 
              x20309.r := getRetimed(block2chunk0sub11("x5514_elem_22").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20310 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20310_x7982_D6") 
              x20310.r := getRetimed(block2chunk0sub28("x7982").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x19009 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19009""")
              x19009.r := Math.fma(x20310,x20309,block2chunk0sub40("x8814_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19009").toFixed(x19009, "cast_x19009").r
              val x20311 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20311_x7983_D6") 
              x20311.r := getRetimed(block2chunk0sub28("x7983").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20312 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20312_x5515_elem_23_D15") 
              x20312.r := getRetimed(block2chunk0sub11("x5515_elem_23").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x19010 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19010""")
              x19010.r := Math.fma(x20311,x20312,block2chunk0sub40("x8815_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19010").toFixed(x19010, "cast_x19010").r
              val x20313 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20313_x5516_elem_24_D15") 
              x20313.r := getRetimed(block2chunk0sub11("x5516_elem_24").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20314 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20314_x7984_D6") 
              x20314.r := getRetimed(block2chunk0sub28("x7984").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x19011 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19011""")
              x19011.r := Math.fma(x20314,x20313,block2chunk0sub40("x8816_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19011").toFixed(x19011, "cast_x19011").r
              val x20315 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20315_x5517_elem_25_D15") 
              x20315.r := getRetimed(block2chunk0sub11("x5517_elem_25").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20316 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20316_x7985_D6") 
              x20316.r := getRetimed(block2chunk0sub28("x7985").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x19012 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19012""")
              x19012.r := Math.fma(x20316,x20315,block2chunk0sub40("x8817_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19012").toFixed(x19012, "cast_x19012").r
              val x20317 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20317_x7986_D6") 
              x20317.r := getRetimed(block2chunk0sub29("x7986").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20318 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20318_x5518_elem_26_D15") 
              x20318.r := getRetimed(block2chunk0sub11("x5518_elem_26").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x19013 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19013""")
              x19013.r := Math.fma(x20317,x20318,block2chunk0sub40("x8818_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19013").toFixed(x19013, "cast_x19013").r
              val x20319 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20319_x7987_D6") 
              x20319.r := getRetimed(block2chunk0sub29("x7987").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20320 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20320_x5519_elem_27_D15") 
              x20320.r := getRetimed(block2chunk0sub11("x5519_elem_27").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x19014 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19014""")
              x19014.r := Math.fma(x20319,x20320,block2chunk0sub40("x8819_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19014").toFixed(x19014, "cast_x19014").r
              val x20321 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20321_x7988_D6") 
              x20321.r := getRetimed(block2chunk0sub29("x7988").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20322 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20322_x5520_elem_28_D15") 
              x20322.r := getRetimed(block2chunk0sub11("x5520_elem_28").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x19015 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19015""")
              x19015.r := Math.fma(x20321,x20322,block2chunk0sub40("x8820_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19015").toFixed(x19015, "cast_x19015").r
              val x20323 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20323_x7989_D6") 
              x20323.r := getRetimed(block2chunk0sub29("x7989").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20324 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20324_x5521_elem_29_D15") 
              x20324.r := getRetimed(block2chunk0sub11("x5521_elem_29").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x19016 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19016""")
              x19016.r := Math.fma(x20323,x20324,block2chunk0sub40("x8821_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19016").toFixed(x19016, "cast_x19016").r
              val x20325 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20325_x5522_elem_30_D15") 
              x20325.r := getRetimed(block2chunk0sub11("x5522_elem_30").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x20326 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20326_x7990_D6") 
              x20326.r := getRetimed(block2chunk0sub29("x7990").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x19017 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19017""")
              x19017.r := Math.fma(x20326,x20325,block2chunk0sub41("x8822_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19017").toFixed(x19017, "cast_x19017").r
              val x20327 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20327_x7991_D6") 
              x20327.r := getRetimed(block2chunk0sub29("x7991").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x20328 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20328_x5523_elem_31_D15") 
              x20328.r := getRetimed(block2chunk0sub11("x5523_elem_31").asInstanceOf[FixedPoint].r, 15.toInt, io.sigsIn.backpressure)
              val x19018 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19018""")
              x19018.r := Math.fma(x20327,x20328,block2chunk0sub41("x8823_x18").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19018").toFixed(x19018, "cast_x19018").r
              val x8984_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8984_x17""")
              x8984_x17.r := Math.add(block2chunk0sub41("x18891").asInstanceOf[FixedPoint],block2chunk0sub43("x18923").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8984_x17").r
              val x8985_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8985_x17""")
              x8985_x17.r := Math.add(block2chunk0sub41("x18892").asInstanceOf[FixedPoint],block2chunk0sub43("x18924").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8985_x17").r
              val x8986_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8986_x17""")
              x8986_x17.r := Math.add(block2chunk0sub41("x18893").asInstanceOf[FixedPoint],block2chunk0sub43("x18925").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8986_x17").r
              val x8987_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8987_x17""")
              x8987_x17.r := Math.add(block2chunk0sub41("x18894").asInstanceOf[FixedPoint],block2chunk0sub43("x18926").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8987_x17").r
              Map[String,Any]("x19004" -> x19004, "x19005" -> x19005, "x19006" -> x19006, "x19007" -> x19007, "x19008" -> x19008, "x19009" -> x19009, "x19010" -> x19010, "x19011" -> x19011, "x19012" -> x19012, "x19013" -> x19013, "x19014" -> x19014, "x19015" -> x19015, "x19016" -> x19016, "x19017" -> x19017, "x19018" -> x19018, "x8984_x17" -> x8984_x17, "x8985_x17" -> x8985_x17, "x8986_x17" -> x8986_x17, "x8987_x17" -> x8987_x17)
            }
          }
          val block2chunk0sub48: Map[String, Any] = Block2Chunker0Sub48.gen()
          object Block2Chunker0Sub49 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x8988_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8988_x17""")
              x8988_x17.r := Math.add(block2chunk0sub41("x18895").asInstanceOf[FixedPoint],block2chunk0sub43("x18927").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8988_x17").r
              val x8989_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8989_x17""")
              x8989_x17.r := Math.add(block2chunk0sub41("x18896").asInstanceOf[FixedPoint],block2chunk0sub43("x18928").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8989_x17").r
              val x8990_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8990_x17""")
              x8990_x17.r := Math.add(block2chunk0sub41("x18897").asInstanceOf[FixedPoint],block2chunk0sub43("x18929").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8990_x17").r
              val x8991_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8991_x17""")
              x8991_x17.r := Math.add(block2chunk0sub41("x18898").asInstanceOf[FixedPoint],block2chunk0sub43("x18930").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8991_x17").r
              val x8992_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8992_x17""")
              x8992_x17.r := Math.add(block2chunk0sub41("x18899").asInstanceOf[FixedPoint],block2chunk0sub43("x18931").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8992_x17").r
              val x8993_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8993_x17""")
              x8993_x17.r := Math.add(block2chunk0sub41("x18900").asInstanceOf[FixedPoint],block2chunk0sub43("x18932").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8993_x17").r
              val x8994_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8994_x17""")
              x8994_x17.r := Math.add(block2chunk0sub41("x18901").asInstanceOf[FixedPoint],block2chunk0sub43("x18933").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8994_x17").r
              val x8995_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8995_x17""")
              x8995_x17.r := Math.add(block2chunk0sub41("x18902").asInstanceOf[FixedPoint],block2chunk0sub43("x18934").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8995_x17").r
              val x8996_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8996_x17""")
              x8996_x17.r := Math.add(block2chunk0sub41("x18903").asInstanceOf[FixedPoint],block2chunk0sub43("x18935").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8996_x17").r
              val x8997_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8997_x17""")
              x8997_x17.r := Math.add(block2chunk0sub41("x18904").asInstanceOf[FixedPoint],block2chunk0sub43("x18936").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8997_x17").r
              val x8998_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8998_x17""")
              x8998_x17.r := Math.add(block2chunk0sub41("x18905").asInstanceOf[FixedPoint],block2chunk0sub43("x18937").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8998_x17").r
              val x8999_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x8999_x17""")
              x8999_x17.r := Math.add(block2chunk0sub42("x18906").asInstanceOf[FixedPoint],block2chunk0sub44("x18938").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x8999_x17").r
              val x9000_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9000_x17""")
              x9000_x17.r := Math.add(block2chunk0sub42("x18907").asInstanceOf[FixedPoint],block2chunk0sub44("x18939").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9000_x17").r
              val x9001_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9001_x17""")
              x9001_x17.r := Math.add(block2chunk0sub42("x18908").asInstanceOf[FixedPoint],block2chunk0sub44("x18940").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9001_x17").r
              val x9002_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9002_x17""")
              x9002_x17.r := Math.add(block2chunk0sub42("x18909").asInstanceOf[FixedPoint],block2chunk0sub44("x18941").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9002_x17").r
              val x9003_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9003_x17""")
              x9003_x17.r := Math.add(block2chunk0sub42("x18910").asInstanceOf[FixedPoint],block2chunk0sub44("x18942").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9003_x17").r
              val x9004_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9004_x17""")
              x9004_x17.r := Math.add(block2chunk0sub42("x18911").asInstanceOf[FixedPoint],block2chunk0sub44("x18943").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9004_x17").r
              val x9005_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9005_x17""")
              x9005_x17.r := Math.add(block2chunk0sub42("x18912").asInstanceOf[FixedPoint],block2chunk0sub44("x18944").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9005_x17").r
              val x9006_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9006_x17""")
              x9006_x17.r := Math.add(block2chunk0sub42("x18913").asInstanceOf[FixedPoint],block2chunk0sub44("x18945").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9006_x17").r
              val x9007_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9007_x17""")
              x9007_x17.r := Math.add(block2chunk0sub42("x18914").asInstanceOf[FixedPoint],block2chunk0sub44("x18946").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9007_x17").r
              val x9008_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9008_x17""")
              x9008_x17.r := Math.add(block2chunk0sub42("x18915").asInstanceOf[FixedPoint],block2chunk0sub44("x18947").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9008_x17").r
              val x9009_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9009_x17""")
              x9009_x17.r := Math.add(block2chunk0sub42("x18916").asInstanceOf[FixedPoint],block2chunk0sub44("x18948").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9009_x17").r
              val x9010_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9010_x17""")
              x9010_x17.r := Math.add(block2chunk0sub42("x18917").asInstanceOf[FixedPoint],block2chunk0sub44("x18949").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9010_x17").r
              val x9011_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9011_x17""")
              x9011_x17.r := Math.add(block2chunk0sub42("x18918").asInstanceOf[FixedPoint],block2chunk0sub44("x18950").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9011_x17").r
              val x9012_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9012_x17""")
              x9012_x17.r := Math.add(block2chunk0sub42("x18919").asInstanceOf[FixedPoint],block2chunk0sub44("x18951").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9012_x17").r
              val x9013_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9013_x17""")
              x9013_x17.r := Math.add(block2chunk0sub42("x18920").asInstanceOf[FixedPoint],block2chunk0sub44("x18952").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9013_x17").r
              val x9014_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9014_x17""")
              x9014_x17.r := Math.add(block2chunk0sub42("x18921").asInstanceOf[FixedPoint],block2chunk0sub44("x18953").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9014_x17").r
              val x9015_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9015_x17""")
              x9015_x17.r := Math.add(block2chunk0sub43("x18922").asInstanceOf[FixedPoint],block2chunk0sub44("x18954").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9015_x17").r
              val x9016_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9016_x18""")
              x9016_x18.r := Math.add(block2chunk0sub45("x18955").asInstanceOf[FixedPoint],block2chunk0sub47("x18987").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9016_x18").r
              val x9017_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9017_x18""")
              x9017_x18.r := Math.add(block2chunk0sub45("x18956").asInstanceOf[FixedPoint],block2chunk0sub47("x18988").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9017_x18").r
              val x9018_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9018_x18""")
              x9018_x18.r := Math.add(block2chunk0sub45("x18957").asInstanceOf[FixedPoint],block2chunk0sub47("x18989").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9018_x18").r
              val x9019_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9019_x18""")
              x9019_x18.r := Math.add(block2chunk0sub45("x18958").asInstanceOf[FixedPoint],block2chunk0sub47("x18990").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9019_x18").r
              val x9020_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9020_x18""")
              x9020_x18.r := Math.add(block2chunk0sub45("x18959").asInstanceOf[FixedPoint],block2chunk0sub47("x18991").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9020_x18").r
              val x9021_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9021_x18""")
              x9021_x18.r := Math.add(block2chunk0sub45("x18960").asInstanceOf[FixedPoint],block2chunk0sub47("x18992").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9021_x18").r
              val x9022_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9022_x18""")
              x9022_x18.r := Math.add(block2chunk0sub45("x18961").asInstanceOf[FixedPoint],block2chunk0sub47("x18993").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9022_x18").r
              val x9023_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9023_x18""")
              x9023_x18.r := Math.add(block2chunk0sub45("x18962").asInstanceOf[FixedPoint],block2chunk0sub47("x18994").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9023_x18").r
              val x9024_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9024_x18""")
              x9024_x18.r := Math.add(block2chunk0sub45("x18963").asInstanceOf[FixedPoint],block2chunk0sub47("x18995").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9024_x18").r
              val x9025_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9025_x18""")
              x9025_x18.r := Math.add(block2chunk0sub45("x18964").asInstanceOf[FixedPoint],block2chunk0sub47("x18996").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9025_x18").r
              val x9026_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9026_x18""")
              x9026_x18.r := Math.add(block2chunk0sub45("x18965").asInstanceOf[FixedPoint],block2chunk0sub47("x18997").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9026_x18").r
              val x9027_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9027_x18""")
              x9027_x18.r := Math.add(block2chunk0sub45("x18966").asInstanceOf[FixedPoint],block2chunk0sub47("x18998").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9027_x18").r
              val x9028_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9028_x18""")
              x9028_x18.r := Math.add(block2chunk0sub45("x18967").asInstanceOf[FixedPoint],block2chunk0sub47("x18999").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9028_x18").r
              val x9029_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9029_x18""")
              x9029_x18.r := Math.add(block2chunk0sub45("x18968").asInstanceOf[FixedPoint],block2chunk0sub47("x19000").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9029_x18").r
              val x9030_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9030_x18""")
              x9030_x18.r := Math.add(block2chunk0sub45("x18969").asInstanceOf[FixedPoint],block2chunk0sub47("x19001").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9030_x18").r
              val x9031_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9031_x18""")
              x9031_x18.r := Math.add(block2chunk0sub45("x18970").asInstanceOf[FixedPoint],block2chunk0sub47("x19002").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9031_x18").r
              val x9032_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9032_x18""")
              x9032_x18.r := Math.add(block2chunk0sub46("x18971").asInstanceOf[FixedPoint],block2chunk0sub47("x19003").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9032_x18").r
              val x9033_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9033_x18""")
              x9033_x18.r := Math.add(block2chunk0sub46("x18972").asInstanceOf[FixedPoint],block2chunk0sub48("x19004").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9033_x18").r
              val x9034_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9034_x18""")
              x9034_x18.r := Math.add(block2chunk0sub46("x18973").asInstanceOf[FixedPoint],block2chunk0sub48("x19005").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9034_x18").r
              val x9035_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9035_x18""")
              x9035_x18.r := Math.add(block2chunk0sub46("x18974").asInstanceOf[FixedPoint],block2chunk0sub48("x19006").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9035_x18").r
              val x9036_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9036_x18""")
              x9036_x18.r := Math.add(block2chunk0sub46("x18975").asInstanceOf[FixedPoint],block2chunk0sub48("x19007").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9036_x18").r
              Map[String,Any]("x8988_x17" -> x8988_x17, "x8989_x17" -> x8989_x17, "x8990_x17" -> x8990_x17, "x8991_x17" -> x8991_x17, "x8992_x17" -> x8992_x17, "x8993_x17" -> x8993_x17, "x8994_x17" -> x8994_x17, "x8995_x17" -> x8995_x17, "x8996_x17" -> x8996_x17, "x8997_x17" -> x8997_x17, "x8998_x17" -> x8998_x17, "x8999_x17" -> x8999_x17, "x9000_x17" -> x9000_x17, "x9001_x17" -> x9001_x17, "x9002_x17" -> x9002_x17, "x9003_x17" -> x9003_x17, "x9004_x17" -> x9004_x17, "x9005_x17" -> x9005_x17, "x9006_x17" -> x9006_x17, "x9007_x17" -> x9007_x17, "x9008_x17" -> x9008_x17, "x9009_x17" -> x9009_x17, "x9010_x17" -> x9010_x17, "x9011_x17" -> x9011_x17, "x9012_x17" -> x9012_x17, "x9013_x17" -> x9013_x17, "x9014_x17" -> x9014_x17, "x9015_x17" -> x9015_x17, "x9016_x18" -> x9016_x18, "x9017_x18" -> x9017_x18, "x9018_x18" -> x9018_x18, "x9019_x18" -> x9019_x18, "x9020_x18" -> x9020_x18, "x9021_x18" -> x9021_x18, "x9022_x18" -> x9022_x18, "x9023_x18" -> x9023_x18, "x9024_x18" -> x9024_x18, "x9025_x18" -> x9025_x18, "x9026_x18" -> x9026_x18, "x9027_x18" -> x9027_x18, "x9028_x18" -> x9028_x18, "x9029_x18" -> x9029_x18, "x9030_x18" -> x9030_x18, "x9031_x18" -> x9031_x18, "x9032_x18" -> x9032_x18, "x9033_x18" -> x9033_x18, "x9034_x18" -> x9034_x18, "x9035_x18" -> x9035_x18, "x9036_x18" -> x9036_x18)
            }
          }
          val block2chunk0sub49: Map[String, Any] = Block2Chunker0Sub49.gen()
          object Block2Chunker0Sub50 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x9037_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9037_x18""")
              x9037_x18.r := Math.add(block2chunk0sub46("x18976").asInstanceOf[FixedPoint],block2chunk0sub48("x19008").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9037_x18").r
              val x9038_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9038_x18""")
              x9038_x18.r := Math.add(block2chunk0sub46("x18977").asInstanceOf[FixedPoint],block2chunk0sub48("x19009").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9038_x18").r
              val x9039_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9039_x18""")
              x9039_x18.r := Math.add(block2chunk0sub46("x18978").asInstanceOf[FixedPoint],block2chunk0sub48("x19010").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9039_x18").r
              val x9040_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9040_x18""")
              x9040_x18.r := Math.add(block2chunk0sub46("x18979").asInstanceOf[FixedPoint],block2chunk0sub48("x19011").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9040_x18").r
              val x9041_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9041_x18""")
              x9041_x18.r := Math.add(block2chunk0sub46("x18980").asInstanceOf[FixedPoint],block2chunk0sub48("x19012").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9041_x18").r
              val x9042_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9042_x18""")
              x9042_x18.r := Math.add(block2chunk0sub46("x18981").asInstanceOf[FixedPoint],block2chunk0sub48("x19013").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9042_x18").r
              val x9043_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9043_x18""")
              x9043_x18.r := Math.add(block2chunk0sub46("x18982").asInstanceOf[FixedPoint],block2chunk0sub48("x19014").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9043_x18").r
              val x9044_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9044_x18""")
              x9044_x18.r := Math.add(block2chunk0sub46("x18983").asInstanceOf[FixedPoint],block2chunk0sub48("x19015").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9044_x18").r
              val x9045_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9045_x18""")
              x9045_x18.r := Math.add(block2chunk0sub46("x18984").asInstanceOf[FixedPoint],block2chunk0sub48("x19016").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9045_x18").r
              val x9046_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9046_x18""")
              x9046_x18.r := Math.add(block2chunk0sub46("x18985").asInstanceOf[FixedPoint],block2chunk0sub48("x19017").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9046_x18").r
              val x9047_x18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9047_x18""")
              x9047_x18.r := Math.add(block2chunk0sub46("x18986").asInstanceOf[FixedPoint],block2chunk0sub48("x19018").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9047_x18").r
              val x9048_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9048_x17""")
              x9048_x17.r := Math.add(block2chunk0sub48("x8984_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9016_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9048_x17").r
              val x9049_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9049_x17""")
              x9049_x17.r := Math.add(block2chunk0sub48("x8985_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9017_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9049_x17").r
              val x9050_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9050_x17""")
              x9050_x17.r := Math.add(block2chunk0sub48("x8986_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9018_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9050_x17").r
              val x9051_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9051_x17""")
              x9051_x17.r := Math.add(block2chunk0sub48("x8987_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9019_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9051_x17").r
              val x9052_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9052_x17""")
              x9052_x17.r := Math.add(block2chunk0sub49("x8988_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9020_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9052_x17").r
              val x9053_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9053_x17""")
              x9053_x17.r := Math.add(block2chunk0sub49("x8989_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9021_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9053_x17").r
              val x9054_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9054_x17""")
              x9054_x17.r := Math.add(block2chunk0sub49("x8990_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9022_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9054_x17").r
              val x9055_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9055_x17""")
              x9055_x17.r := Math.add(block2chunk0sub49("x8991_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9023_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9055_x17").r
              val x9056_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9056_x17""")
              x9056_x17.r := Math.add(block2chunk0sub49("x8992_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9024_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9056_x17").r
              val x9057_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9057_x17""")
              x9057_x17.r := Math.add(block2chunk0sub49("x8993_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9025_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9057_x17").r
              val x9058_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9058_x17""")
              x9058_x17.r := Math.add(block2chunk0sub49("x8994_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9026_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9058_x17").r
              val x9059_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9059_x17""")
              x9059_x17.r := Math.add(block2chunk0sub49("x8995_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9027_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9059_x17").r
              val x9060_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9060_x17""")
              x9060_x17.r := Math.add(block2chunk0sub49("x8996_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9028_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9060_x17").r
              val x9061_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9061_x17""")
              x9061_x17.r := Math.add(block2chunk0sub49("x8997_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9029_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9061_x17").r
              val x9062_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9062_x17""")
              x9062_x17.r := Math.add(block2chunk0sub49("x8998_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9030_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9062_x17").r
              val x9063_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9063_x17""")
              x9063_x17.r := Math.add(block2chunk0sub49("x8999_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9031_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9063_x17").r
              val x9064_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9064_x17""")
              x9064_x17.r := Math.add(block2chunk0sub49("x9000_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9032_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9064_x17").r
              val x9065_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9065_x17""")
              x9065_x17.r := Math.add(block2chunk0sub49("x9001_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9033_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9065_x17").r
              val x9066_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9066_x17""")
              x9066_x17.r := Math.add(block2chunk0sub49("x9002_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9034_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9066_x17").r
              val x9067_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9067_x17""")
              x9067_x17.r := Math.add(block2chunk0sub49("x9003_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9035_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9067_x17").r
              val x9068_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9068_x17""")
              x9068_x17.r := Math.add(block2chunk0sub49("x9004_x17").asInstanceOf[FixedPoint],block2chunk0sub49("x9036_x18").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9068_x17").r
              val x9069_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9069_x17""")
              x9069_x17.r := Math.add(block2chunk0sub49("x9005_x17").asInstanceOf[FixedPoint],x9037_x18,Some(1.0), true.B, Truncate, Wrapping, "x9069_x17").r
              val x9070_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9070_x17""")
              x9070_x17.r := Math.add(block2chunk0sub49("x9006_x17").asInstanceOf[FixedPoint],x9038_x18,Some(1.0), true.B, Truncate, Wrapping, "x9070_x17").r
              val x9071_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9071_x17""")
              x9071_x17.r := Math.add(block2chunk0sub49("x9007_x17").asInstanceOf[FixedPoint],x9039_x18,Some(1.0), true.B, Truncate, Wrapping, "x9071_x17").r
              val x9072_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9072_x17""")
              x9072_x17.r := Math.add(block2chunk0sub49("x9008_x17").asInstanceOf[FixedPoint],x9040_x18,Some(1.0), true.B, Truncate, Wrapping, "x9072_x17").r
              val x9073_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9073_x17""")
              x9073_x17.r := Math.add(block2chunk0sub49("x9009_x17").asInstanceOf[FixedPoint],x9041_x18,Some(1.0), true.B, Truncate, Wrapping, "x9073_x17").r
              val x9074_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9074_x17""")
              x9074_x17.r := Math.add(block2chunk0sub49("x9010_x17").asInstanceOf[FixedPoint],x9042_x18,Some(1.0), true.B, Truncate, Wrapping, "x9074_x17").r
              val x9075_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9075_x17""")
              x9075_x17.r := Math.add(block2chunk0sub49("x9011_x17").asInstanceOf[FixedPoint],x9043_x18,Some(1.0), true.B, Truncate, Wrapping, "x9075_x17").r
              val x9076_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9076_x17""")
              x9076_x17.r := Math.add(block2chunk0sub49("x9012_x17").asInstanceOf[FixedPoint],x9044_x18,Some(1.0), true.B, Truncate, Wrapping, "x9076_x17").r
              val x9077_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9077_x17""")
              x9077_x17.r := Math.add(block2chunk0sub49("x9013_x17").asInstanceOf[FixedPoint],x9045_x18,Some(1.0), true.B, Truncate, Wrapping, "x9077_x17").r
              val x9078_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9078_x17""")
              x9078_x17.r := Math.add(block2chunk0sub49("x9014_x17").asInstanceOf[FixedPoint],x9046_x18,Some(1.0), true.B, Truncate, Wrapping, "x9078_x17").r
              val x9079_x17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9079_x17""")
              x9079_x17.r := Math.add(block2chunk0sub49("x9015_x17").asInstanceOf[FixedPoint],x9047_x18,Some(1.0), true.B, Truncate, Wrapping, "x9079_x17").r
              val x20329 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20329_x5558_elem_0_D23") 
              x20329.r := getRetimed(block2chunk0sub13("x5558_elem_0").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20330 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20330_x8536_D14") 
              x20330.r := getRetimed(block2chunk0sub32("x8536").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19019 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19019""")
              x19019.r := Math.fma(x20330,x20329,x9048_x17,Some(6.0), true.B, "x19019").toFixed(x19019, "cast_x19019").r
              val x20331 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20331_x5559_elem_1_D23") 
              x20331.r := getRetimed(block2chunk0sub13("x5559_elem_1").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20332 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20332_x8537_D14") 
              x20332.r := getRetimed(block2chunk0sub32("x8537").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19020 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19020""")
              x19020.r := Math.fma(x20332,x20331,x9049_x17,Some(6.0), true.B, "x19020").toFixed(x19020, "cast_x19020").r
              Map[String,Any]("x9050_x17" -> x9050_x17, "x9051_x17" -> x9051_x17, "x9052_x17" -> x9052_x17, "x9053_x17" -> x9053_x17, "x9054_x17" -> x9054_x17, "x9055_x17" -> x9055_x17, "x9056_x17" -> x9056_x17, "x9057_x17" -> x9057_x17, "x9058_x17" -> x9058_x17, "x9059_x17" -> x9059_x17, "x9060_x17" -> x9060_x17, "x9061_x17" -> x9061_x17, "x9062_x17" -> x9062_x17, "x9063_x17" -> x9063_x17, "x9064_x17" -> x9064_x17, "x9065_x17" -> x9065_x17, "x9066_x17" -> x9066_x17, "x9067_x17" -> x9067_x17, "x9068_x17" -> x9068_x17, "x9069_x17" -> x9069_x17, "x9070_x17" -> x9070_x17, "x9071_x17" -> x9071_x17, "x9072_x17" -> x9072_x17, "x9073_x17" -> x9073_x17, "x9074_x17" -> x9074_x17, "x9075_x17" -> x9075_x17, "x9076_x17" -> x9076_x17, "x9077_x17" -> x9077_x17, "x9078_x17" -> x9078_x17, "x9079_x17" -> x9079_x17, "x19019" -> x19019, "x19020" -> x19020)
            }
          }
          val block2chunk0sub50: Map[String, Any] = Block2Chunker0Sub50.gen()
          object Block2Chunker0Sub51 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x20333 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20333_x8538_D14") 
              x20333.r := getRetimed(block2chunk0sub32("x8538").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20334 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20334_x5560_elem_2_D23") 
              x20334.r := getRetimed(block2chunk0sub14("x5560_elem_2").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19021 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19021""")
              x19021.r := Math.fma(x20333,x20334,block2chunk0sub50("x9050_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19021").toFixed(x19021, "cast_x19021").r
              val x20335 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20335_x8539_D14") 
              x20335.r := getRetimed(block2chunk0sub32("x8539").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20336 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20336_x5561_elem_3_D23") 
              x20336.r := getRetimed(block2chunk0sub14("x5561_elem_3").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19022 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19022""")
              x19022.r := Math.fma(x20335,x20336,block2chunk0sub50("x9051_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19022").toFixed(x19022, "cast_x19022").r
              val x20337 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20337_x8540_D14") 
              x20337.r := getRetimed(block2chunk0sub32("x8540").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20338 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20338_x5562_elem_4_D23") 
              x20338.r := getRetimed(block2chunk0sub14("x5562_elem_4").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19023 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19023""")
              x19023.r := Math.fma(x20337,x20338,block2chunk0sub50("x9052_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19023").toFixed(x19023, "cast_x19023").r
              val x20339 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20339_x8541_D14") 
              x20339.r := getRetimed(block2chunk0sub32("x8541").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20340 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20340_x5563_elem_5_D23") 
              x20340.r := getRetimed(block2chunk0sub14("x5563_elem_5").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19024 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19024""")
              x19024.r := Math.fma(x20339,x20340,block2chunk0sub50("x9053_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19024").toFixed(x19024, "cast_x19024").r
              val x20341 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20341_x5564_elem_6_D23") 
              x20341.r := getRetimed(block2chunk0sub14("x5564_elem_6").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20342 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20342_x8542_D14") 
              x20342.r := getRetimed(block2chunk0sub32("x8542").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19025 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19025""")
              x19025.r := Math.fma(x20342,x20341,block2chunk0sub50("x9054_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19025").toFixed(x19025, "cast_x19025").r
              val x20343 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20343_x8543_D14") 
              x20343.r := getRetimed(block2chunk0sub32("x8543").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20344 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20344_x5565_elem_7_D23") 
              x20344.r := getRetimed(block2chunk0sub14("x5565_elem_7").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19026 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19026""")
              x19026.r := Math.fma(x20343,x20344,block2chunk0sub50("x9055_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19026").toFixed(x19026, "cast_x19026").r
              val x20345 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20345_x8544_D14") 
              x20345.r := getRetimed(block2chunk0sub32("x8544").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20346 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20346_x5566_elem_8_D23") 
              x20346.r := getRetimed(block2chunk0sub14("x5566_elem_8").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19027 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19027""")
              x19027.r := Math.fma(x20345,x20346,block2chunk0sub50("x9056_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19027").toFixed(x19027, "cast_x19027").r
              val x20347 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20347_x5567_elem_9_D23") 
              x20347.r := getRetimed(block2chunk0sub14("x5567_elem_9").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20348 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20348_x8545_D14") 
              x20348.r := getRetimed(block2chunk0sub32("x8545").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19028 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19028""")
              x19028.r := Math.fma(x20348,x20347,block2chunk0sub50("x9057_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19028").toFixed(x19028, "cast_x19028").r
              val x20349 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20349_x5568_elem_10_D23") 
              x20349.r := getRetimed(block2chunk0sub14("x5568_elem_10").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20350 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20350_x8546_D14") 
              x20350.r := getRetimed(block2chunk0sub32("x8546").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19029 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19029""")
              x19029.r := Math.fma(x20350,x20349,block2chunk0sub50("x9058_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19029").toFixed(x19029, "cast_x19029").r
              val x20351 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20351_x5569_elem_11_D23") 
              x20351.r := getRetimed(block2chunk0sub14("x5569_elem_11").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20352 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20352_x8547_D14") 
              x20352.r := getRetimed(block2chunk0sub32("x8547").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19030 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19030""")
              x19030.r := Math.fma(x20352,x20351,block2chunk0sub50("x9059_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19030").toFixed(x19030, "cast_x19030").r
              val x20353 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20353_x8548_D14") 
              x20353.r := getRetimed(block2chunk0sub32("x8548").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20354 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20354_x5570_elem_12_D23") 
              x20354.r := getRetimed(block2chunk0sub14("x5570_elem_12").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19031 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19031""")
              x19031.r := Math.fma(x20353,x20354,block2chunk0sub50("x9060_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19031").toFixed(x19031, "cast_x19031").r
              val x20355 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20355_x8549_D14") 
              x20355.r := getRetimed(block2chunk0sub32("x8549").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20356 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20356_x5571_elem_13_D23") 
              x20356.r := getRetimed(block2chunk0sub14("x5571_elem_13").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19032 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19032""")
              x19032.r := Math.fma(x20355,x20356,block2chunk0sub50("x9061_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19032").toFixed(x19032, "cast_x19032").r
              val x20357 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20357_x8550_D14") 
              x20357.r := getRetimed(block2chunk0sub32("x8550").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20358 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20358_x5572_elem_14_D23") 
              x20358.r := getRetimed(block2chunk0sub14("x5572_elem_14").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19033 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19033""")
              x19033.r := Math.fma(x20357,x20358,block2chunk0sub50("x9062_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19033").toFixed(x19033, "cast_x19033").r
              val x20359 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20359_x5573_elem_15_D23") 
              x20359.r := getRetimed(block2chunk0sub14("x5573_elem_15").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20360 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20360_x8551_D14") 
              x20360.r := getRetimed(block2chunk0sub32("x8551").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19034 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19034""")
              x19034.r := Math.fma(x20360,x20359,block2chunk0sub50("x9063_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19034").toFixed(x19034, "cast_x19034").r
              val x20361 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20361_x5574_elem_16_D23") 
              x20361.r := getRetimed(block2chunk0sub14("x5574_elem_16").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20362 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20362_x8552_D14") 
              x20362.r := getRetimed(block2chunk0sub32("x8552").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19035 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19035""")
              x19035.r := Math.fma(x20362,x20361,block2chunk0sub50("x9064_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19035").toFixed(x19035, "cast_x19035").r
              val x20363 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20363_x8553_D14") 
              x20363.r := getRetimed(block2chunk0sub32("x8553").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20364 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20364_x5575_elem_17_D23") 
              x20364.r := getRetimed(block2chunk0sub14("x5575_elem_17").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19036 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19036""")
              x19036.r := Math.fma(x20363,x20364,block2chunk0sub50("x9065_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19036").toFixed(x19036, "cast_x19036").r
              val x20365 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20365_x5576_elem_18_D23") 
              x20365.r := getRetimed(block2chunk0sub14("x5576_elem_18").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x19021" -> x19021, "x19022" -> x19022, "x19023" -> x19023, "x19024" -> x19024, "x19025" -> x19025, "x19026" -> x19026, "x19027" -> x19027, "x19028" -> x19028, "x19029" -> x19029, "x19030" -> x19030, "x19031" -> x19031, "x19032" -> x19032, "x19033" -> x19033, "x19034" -> x19034, "x19035" -> x19035, "x19036" -> x19036, "x20365" -> x20365)
            }
          }
          val block2chunk0sub51: Map[String, Any] = Block2Chunker0Sub51.gen()
          object Block2Chunker0Sub52 { // 37 nodes, 37 weight
            def gen(): Map[String, Any] = {
              val x20366 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20366_x8554_D14") 
              x20366.r := getRetimed(block2chunk0sub32("x8554").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19037 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19037""")
              x19037.r := Math.fma(x20366,block2chunk0sub51("x20365").asInstanceOf[FixedPoint],block2chunk0sub50("x9066_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19037").toFixed(x19037, "cast_x19037").r
              val x20367 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20367_x8555_D14") 
              x20367.r := getRetimed(block2chunk0sub32("x8555").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20368 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20368_x5577_elem_19_D23") 
              x20368.r := getRetimed(block2chunk0sub14("x5577_elem_19").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19038 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19038""")
              x19038.r := Math.fma(x20367,x20368,block2chunk0sub50("x9067_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19038").toFixed(x19038, "cast_x19038").r
              val x20369 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20369_x8556_D14") 
              x20369.r := getRetimed(block2chunk0sub33("x8556").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20370 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20370_x5578_elem_20_D23") 
              x20370.r := getRetimed(block2chunk0sub14("x5578_elem_20").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19039 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19039""")
              x19039.r := Math.fma(x20369,x20370,block2chunk0sub50("x9068_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19039").toFixed(x19039, "cast_x19039").r
              val x20371 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20371_x8557_D14") 
              x20371.r := getRetimed(block2chunk0sub33("x8557").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20372 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20372_x5579_elem_21_D23") 
              x20372.r := getRetimed(block2chunk0sub14("x5579_elem_21").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19040 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19040""")
              x19040.r := Math.fma(x20371,x20372,block2chunk0sub50("x9069_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19040").toFixed(x19040, "cast_x19040").r
              val x20373 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20373_x5580_elem_22_D23") 
              x20373.r := getRetimed(block2chunk0sub14("x5580_elem_22").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20374 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20374_x8558_D14") 
              x20374.r := getRetimed(block2chunk0sub33("x8558").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19041 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19041""")
              x19041.r := Math.fma(x20374,x20373,block2chunk0sub50("x9070_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19041").toFixed(x19041, "cast_x19041").r
              val x20375 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20375_x5581_elem_23_D23") 
              x20375.r := getRetimed(block2chunk0sub14("x5581_elem_23").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20376 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20376_x8559_D14") 
              x20376.r := getRetimed(block2chunk0sub33("x8559").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19042 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19042""")
              x19042.r := Math.fma(x20376,x20375,block2chunk0sub50("x9071_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19042").toFixed(x19042, "cast_x19042").r
              val x20377 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20377_x8560_D14") 
              x20377.r := getRetimed(block2chunk0sub33("x8560").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20378 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20378_x5582_elem_24_D23") 
              x20378.r := getRetimed(block2chunk0sub14("x5582_elem_24").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19043 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19043""")
              x19043.r := Math.fma(x20377,x20378,block2chunk0sub50("x9072_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19043").toFixed(x19043, "cast_x19043").r
              val x20379 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20379_x8561_D14") 
              x20379.r := getRetimed(block2chunk0sub33("x8561").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20380 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20380_x5583_elem_25_D23") 
              x20380.r := getRetimed(block2chunk0sub14("x5583_elem_25").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19044 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19044""")
              x19044.r := Math.fma(x20379,x20380,block2chunk0sub50("x9073_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19044").toFixed(x19044, "cast_x19044").r
              val x20381 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20381_x5584_elem_26_D23") 
              x20381.r := getRetimed(block2chunk0sub14("x5584_elem_26").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20382 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20382_x8562_D14") 
              x20382.r := getRetimed(block2chunk0sub33("x8562").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19045 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19045""")
              x19045.r := Math.fma(x20382,x20381,block2chunk0sub50("x9074_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19045").toFixed(x19045, "cast_x19045").r
              val x20383 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20383_x5585_elem_27_D23") 
              x20383.r := getRetimed(block2chunk0sub14("x5585_elem_27").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20384 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20384_x8563_D14") 
              x20384.r := getRetimed(block2chunk0sub33("x8563").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19046 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19046""")
              x19046.r := Math.fma(x20384,x20383,block2chunk0sub50("x9075_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19046").toFixed(x19046, "cast_x19046").r
              val x20385 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20385_x5586_elem_28_D23") 
              x20385.r := getRetimed(block2chunk0sub14("x5586_elem_28").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x20386 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20386_x8564_D14") 
              x20386.r := getRetimed(block2chunk0sub33("x8564").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x19047 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19047""")
              x19047.r := Math.fma(x20386,x20385,block2chunk0sub50("x9076_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19047").toFixed(x19047, "cast_x19047").r
              val x20387 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20387_x8565_D14") 
              x20387.r := getRetimed(block2chunk0sub33("x8565").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20388 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20388_x5587_elem_29_D23") 
              x20388.r := getRetimed(block2chunk0sub14("x5587_elem_29").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19048 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19048""")
              x19048.r := Math.fma(x20387,x20388,block2chunk0sub50("x9077_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19048").toFixed(x19048, "cast_x19048").r
              val x20389 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20389_x8566_D14") 
              x20389.r := getRetimed(block2chunk0sub33("x8566").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20390 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20390_x5588_elem_30_D23") 
              x20390.r := getRetimed(block2chunk0sub14("x5588_elem_30").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x19037" -> x19037, "x19038" -> x19038, "x19039" -> x19039, "x19040" -> x19040, "x19041" -> x19041, "x19042" -> x19042, "x19043" -> x19043, "x19044" -> x19044, "x19045" -> x19045, "x19046" -> x19046, "x19047" -> x19047, "x19048" -> x19048, "x20389" -> x20389, "x20390" -> x20390)
            }
          }
          val block2chunk0sub52: Map[String, Any] = Block2Chunker0Sub52.gen()
          Map[String,Any]("x5133_rd_x3918" -> block2chunk0sub0("x5133_rd_x3918").asInstanceOf[Bool], "x5197" -> block2chunk0sub0("x5197").asInstanceOf[FixedPoint], "x5200" -> block2chunk0sub0("x5200").asInstanceOf[FixedPoint], "x5203" -> block2chunk0sub0("x5203").asInstanceOf[FixedPoint], "x5206" -> block2chunk0sub0("x5206").asInstanceOf[FixedPoint], "x5209" -> block2chunk0sub0("x5209").asInstanceOf[FixedPoint], "x5212" -> block2chunk0sub0("x5212").asInstanceOf[FixedPoint], "x5215" -> block2chunk0sub0("x5215").asInstanceOf[FixedPoint], "x5218" -> block2chunk0sub0("x5218").asInstanceOf[FixedPoint], "x5221" -> block2chunk0sub0("x5221").asInstanceOf[FixedPoint], "x5224" -> block2chunk0sub0("x5224").asInstanceOf[FixedPoint], "x5227" -> block2chunk0sub0("x5227").asInstanceOf[FixedPoint], "x5230" -> block2chunk0sub0("x5230").asInstanceOf[FixedPoint], "x5233" -> block2chunk0sub0("x5233").asInstanceOf[FixedPoint], "x5236" -> block2chunk0sub0("x5236").asInstanceOf[FixedPoint], "x5239" -> block2chunk0sub0("x5239").asInstanceOf[FixedPoint], "x5242" -> block2chunk0sub0("x5242").asInstanceOf[FixedPoint], "x5245" -> block2chunk0sub0("x5245").asInstanceOf[FixedPoint], "x5248" -> block2chunk0sub0("x5248").asInstanceOf[FixedPoint], "x5251" -> block2chunk0sub0("x5251").asInstanceOf[FixedPoint], "x5254" -> block2chunk0sub0("x5254").asInstanceOf[FixedPoint], "x5257" -> block2chunk0sub0("x5257").asInstanceOf[FixedPoint], "x5260" -> block2chunk0sub0("x5260").asInstanceOf[FixedPoint], "x5263" -> block2chunk0sub0("x5263").asInstanceOf[FixedPoint], "x5266" -> block2chunk0sub0("x5266").asInstanceOf[FixedPoint], "x5269" -> block2chunk0sub0("x5269").asInstanceOf[FixedPoint], "x5272" -> block2chunk0sub0("x5272").asInstanceOf[FixedPoint], "x5275" -> block2chunk0sub0("x5275").asInstanceOf[FixedPoint], "x5278" -> block2chunk0sub1("x5278").asInstanceOf[FixedPoint], "x5281" -> block2chunk0sub1("x5281").asInstanceOf[FixedPoint], "x5284" -> block2chunk0sub1("x5284").asInstanceOf[FixedPoint], "x5287" -> block2chunk0sub1("x5287").asInstanceOf[FixedPoint], "x5290" -> block2chunk0sub1("x5290").asInstanceOf[FixedPoint], "x5589_elem_31" -> block2chunk0sub14("x5589_elem_31").asInstanceOf[FixedPoint], "x8567" -> block2chunk0sub33("x8567").asInstanceOf[FixedPoint], "x9078_x17" -> block2chunk0sub50("x9078_x17").asInstanceOf[FixedPoint], "x9079_x17" -> block2chunk0sub50("x9079_x17").asInstanceOf[FixedPoint], "x19019" -> block2chunk0sub50("x19019").asInstanceOf[FixedPoint], "x19020" -> block2chunk0sub50("x19020").asInstanceOf[FixedPoint], "x19021" -> block2chunk0sub51("x19021").asInstanceOf[FixedPoint], "x19022" -> block2chunk0sub51("x19022").asInstanceOf[FixedPoint], "x19023" -> block2chunk0sub51("x19023").asInstanceOf[FixedPoint], "x19024" -> block2chunk0sub51("x19024").asInstanceOf[FixedPoint], "x19025" -> block2chunk0sub51("x19025").asInstanceOf[FixedPoint], "x19026" -> block2chunk0sub51("x19026").asInstanceOf[FixedPoint], "x19027" -> block2chunk0sub51("x19027").asInstanceOf[FixedPoint], "x19028" -> block2chunk0sub51("x19028").asInstanceOf[FixedPoint], "x19029" -> block2chunk0sub51("x19029").asInstanceOf[FixedPoint], "x19030" -> block2chunk0sub51("x19030").asInstanceOf[FixedPoint], "x19031" -> block2chunk0sub51("x19031").asInstanceOf[FixedPoint], "x19032" -> block2chunk0sub51("x19032").asInstanceOf[FixedPoint], "x19033" -> block2chunk0sub51("x19033").asInstanceOf[FixedPoint], "x19034" -> block2chunk0sub51("x19034").asInstanceOf[FixedPoint], "x19035" -> block2chunk0sub51("x19035").asInstanceOf[FixedPoint], "x19036" -> block2chunk0sub51("x19036").asInstanceOf[FixedPoint], "x19037" -> block2chunk0sub52("x19037").asInstanceOf[FixedPoint], "x19038" -> block2chunk0sub52("x19038").asInstanceOf[FixedPoint], "x19039" -> block2chunk0sub52("x19039").asInstanceOf[FixedPoint], "x19040" -> block2chunk0sub52("x19040").asInstanceOf[FixedPoint], "x19041" -> block2chunk0sub52("x19041").asInstanceOf[FixedPoint], "x19042" -> block2chunk0sub52("x19042").asInstanceOf[FixedPoint], "x19043" -> block2chunk0sub52("x19043").asInstanceOf[FixedPoint], "x19044" -> block2chunk0sub52("x19044").asInstanceOf[FixedPoint], "x19045" -> block2chunk0sub52("x19045").asInstanceOf[FixedPoint], "x19046" -> block2chunk0sub52("x19046").asInstanceOf[FixedPoint], "x19047" -> block2chunk0sub52("x19047").asInstanceOf[FixedPoint], "x19048" -> block2chunk0sub52("x19048").asInstanceOf[FixedPoint], "x20389" -> block2chunk0sub52("x20389").asInstanceOf[FixedPoint], "x20390" -> block2chunk0sub52("x20390").asInstanceOf[FixedPoint])
        }
      }
      val block2chunk0: Map[String, Any] = Block2Chunker0.gen()
      object Block2Chunker1 { // 340 nodes, 433 weight
        def gen(): Map[String, Any] = {
          object Block2Chunker1Sub0 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x19049 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19049""")
              x19049.r := Math.fma(block2chunk0("x20389").asInstanceOf[FixedPoint],block2chunk0("x20390").asInstanceOf[FixedPoint],block2chunk0("x9078_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19049").toFixed(x19049, "cast_x19049").r
              val x20391 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20391_x8567_D14") 
              x20391.r := getRetimed(block2chunk0("x8567").asInstanceOf[FixedPoint].r, 14.toInt, io.sigsIn.backpressure)
              val x20392 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20392_x5589_elem_31_D23") 
              x20392.r := getRetimed(block2chunk0("x5589_elem_31").asInstanceOf[FixedPoint].r, 23.toInt, io.sigsIn.backpressure)
              val x19050 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19050""")
              x19050.r := Math.fma(x20391,x20392,block2chunk0("x9079_x17").asInstanceOf[FixedPoint],Some(6.0), true.B, "x19050").toFixed(x19050, "cast_x19050").r
              val x9112 = Wire(Bool()).suggestName("""x9112""")
              x9112.r := Math.eql(b4067, 0L.FP(true, 32, 0), Some(0.2), true.B,"x9112").r
              val x19051 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19051""")
              x19051.r := Math.fma(b4457,56L.FP(true, 32, 0),b4458,Some(6.0), true.B, "x19051").toFixed(x19051, "cast_x19051").r
              val x20393 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20393_x5197_D6") 
              x20393.r := getRetimed(block2chunk0("x5197").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9115_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9115_sum""")
              x9115_sum.r := Math.add(x19051,x20393,Some(1.0), true.B, Truncate, Wrapping, "x9115_sum").r
              val x20394 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20394_x5200_D6") 
              x20394.r := getRetimed(block2chunk0("x5200").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9120_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9120_sum""")
              x9120_sum.r := Math.add(x19051,x20394,Some(1.0), true.B, Truncate, Wrapping, "x9120_sum").r
              val x20395 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20395_x5203_D6") 
              x20395.r := getRetimed(block2chunk0("x5203").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9124_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9124_sum""")
              x9124_sum.r := Math.add(x19051,x20395,Some(1.0), true.B, Truncate, Wrapping, "x9124_sum").r
              val x20396 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20396_x5206_D6") 
              x20396.r := getRetimed(block2chunk0("x5206").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9128_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9128_sum""")
              x9128_sum.r := Math.add(x19051,x20396,Some(1.0), true.B, Truncate, Wrapping, "x9128_sum").r
              val x20397 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20397_x5209_D6") 
              x20397.r := getRetimed(block2chunk0("x5209").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9132_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9132_sum""")
              x9132_sum.r := Math.add(x19051,x20397,Some(1.0), true.B, Truncate, Wrapping, "x9132_sum").r
              val x20398 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20398_x5212_D6") 
              x20398.r := getRetimed(block2chunk0("x5212").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9136_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9136_sum""")
              x9136_sum.r := Math.add(x19051,x20398,Some(1.0), true.B, Truncate, Wrapping, "x9136_sum").r
              val x20399 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20399_x5215_D6") 
              x20399.r := getRetimed(block2chunk0("x5215").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9140_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9140_sum""")
              x9140_sum.r := Math.add(x19051,x20399,Some(1.0), true.B, Truncate, Wrapping, "x9140_sum").r
              val x20400 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20400_x5218_D6") 
              x20400.r := getRetimed(block2chunk0("x5218").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9144_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9144_sum""")
              x9144_sum.r := Math.add(x19051,x20400,Some(1.0), true.B, Truncate, Wrapping, "x9144_sum").r
              val x20401 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20401_x5221_D6") 
              x20401.r := getRetimed(block2chunk0("x5221").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9148_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9148_sum""")
              x9148_sum.r := Math.add(x19051,x20401,Some(1.0), true.B, Truncate, Wrapping, "x9148_sum").r
              val x20402 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20402_x5224_D6") 
              x20402.r := getRetimed(block2chunk0("x5224").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9152_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9152_sum""")
              x9152_sum.r := Math.add(x19051,x20402,Some(1.0), true.B, Truncate, Wrapping, "x9152_sum").r
              val x20403 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20403_x5227_D6") 
              x20403.r := getRetimed(block2chunk0("x5227").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9156_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9156_sum""")
              x9156_sum.r := Math.add(x19051,x20403,Some(1.0), true.B, Truncate, Wrapping, "x9156_sum").r
              val x20404 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20404_x5230_D6") 
              x20404.r := getRetimed(block2chunk0("x5230").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9160_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9160_sum""")
              x9160_sum.r := Math.add(x19051,x20404,Some(1.0), true.B, Truncate, Wrapping, "x9160_sum").r
              val x20405 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20405_x5233_D6") 
              x20405.r := getRetimed(block2chunk0("x5233").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9164_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9164_sum""")
              x9164_sum.r := Math.add(x19051,x20405,Some(1.0), true.B, Truncate, Wrapping, "x9164_sum").r
              val x20406 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20406_x5236_D6") 
              x20406.r := getRetimed(block2chunk0("x5236").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9168_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9168_sum""")
              x9168_sum.r := Math.add(x19051,x20406,Some(1.0), true.B, Truncate, Wrapping, "x9168_sum").r
              val x20407 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20407_x5239_D6") 
              x20407.r := getRetimed(block2chunk0("x5239").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9172_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9172_sum""")
              x9172_sum.r := Math.add(x19051,x20407,Some(1.0), true.B, Truncate, Wrapping, "x9172_sum").r
              val x20408 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20408_x5242_D6") 
              x20408.r := getRetimed(block2chunk0("x5242").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9176_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9176_sum""")
              x9176_sum.r := Math.add(x19051,x20408,Some(1.0), true.B, Truncate, Wrapping, "x9176_sum").r
              val x20409 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20409_x5245_D6") 
              x20409.r := getRetimed(block2chunk0("x5245").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9180_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9180_sum""")
              x9180_sum.r := Math.add(x19051,x20409,Some(1.0), true.B, Truncate, Wrapping, "x9180_sum").r
              val x20410 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20410_x5248_D6") 
              x20410.r := getRetimed(block2chunk0("x5248").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9184_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9184_sum""")
              x9184_sum.r := Math.add(x19051,x20410,Some(1.0), true.B, Truncate, Wrapping, "x9184_sum").r
              val x20411 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20411_x5251_D6") 
              x20411.r := getRetimed(block2chunk0("x5251").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9188_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9188_sum""")
              x9188_sum.r := Math.add(x19051,x20411,Some(1.0), true.B, Truncate, Wrapping, "x9188_sum").r
              val x20412 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20412_x5254_D6") 
              x20412.r := getRetimed(block2chunk0("x5254").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9192_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9192_sum""")
              x9192_sum.r := Math.add(x19051,x20412,Some(1.0), true.B, Truncate, Wrapping, "x9192_sum").r
              val x20413 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20413_x5257_D6") 
              x20413.r := getRetimed(block2chunk0("x5257").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9196_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9196_sum""")
              x9196_sum.r := Math.add(x19051,x20413,Some(1.0), true.B, Truncate, Wrapping, "x9196_sum").r
              val x20414 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20414_x5260_D6") 
              x20414.r := getRetimed(block2chunk0("x5260").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x19049" -> x19049, "x19050" -> x19050, "x9112" -> x9112, "x19051" -> x19051, "x9115_sum" -> x9115_sum, "x9120_sum" -> x9120_sum, "x9124_sum" -> x9124_sum, "x9128_sum" -> x9128_sum, "x9132_sum" -> x9132_sum, "x9136_sum" -> x9136_sum, "x9140_sum" -> x9140_sum, "x9144_sum" -> x9144_sum, "x9148_sum" -> x9148_sum, "x9152_sum" -> x9152_sum, "x9156_sum" -> x9156_sum, "x9160_sum" -> x9160_sum, "x9164_sum" -> x9164_sum, "x9168_sum" -> x9168_sum, "x9172_sum" -> x9172_sum, "x9176_sum" -> x9176_sum, "x9180_sum" -> x9180_sum, "x9184_sum" -> x9184_sum, "x9188_sum" -> x9188_sum, "x9192_sum" -> x9192_sum, "x9196_sum" -> x9196_sum, "x20414" -> x20414)
            }
          }
          val block2chunk1sub0: Map[String, Any] = Block2Chunker1Sub0.gen()
          object Block2Chunker1Sub1 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x9200_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9200_sum""")
              x9200_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],block2chunk1sub0("x20414").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9200_sum").r
              val x20415 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20415_x5263_D6") 
              x20415.r := getRetimed(block2chunk0("x5263").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9204_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9204_sum""")
              x9204_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],x20415,Some(1.0), true.B, Truncate, Wrapping, "x9204_sum").r
              val x20416 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20416_x5266_D6") 
              x20416.r := getRetimed(block2chunk0("x5266").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9208_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9208_sum""")
              x9208_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],x20416,Some(1.0), true.B, Truncate, Wrapping, "x9208_sum").r
              val x20417 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20417_x5269_D6") 
              x20417.r := getRetimed(block2chunk0("x5269").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9212_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9212_sum""")
              x9212_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],x20417,Some(1.0), true.B, Truncate, Wrapping, "x9212_sum").r
              val x20418 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20418_x5272_D6") 
              x20418.r := getRetimed(block2chunk0("x5272").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9216_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9216_sum""")
              x9216_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],x20418,Some(1.0), true.B, Truncate, Wrapping, "x9216_sum").r
              val x20419 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20419_x5275_D6") 
              x20419.r := getRetimed(block2chunk0("x5275").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9220_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9220_sum""")
              x9220_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],x20419,Some(1.0), true.B, Truncate, Wrapping, "x9220_sum").r
              val x20420 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20420_x5278_D6") 
              x20420.r := getRetimed(block2chunk0("x5278").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9224_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9224_sum""")
              x9224_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],x20420,Some(1.0), true.B, Truncate, Wrapping, "x9224_sum").r
              val x20421 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20421_x5281_D6") 
              x20421.r := getRetimed(block2chunk0("x5281").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9228_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9228_sum""")
              x9228_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],x20421,Some(1.0), true.B, Truncate, Wrapping, "x9228_sum").r
              val x20422 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20422_x5284_D6") 
              x20422.r := getRetimed(block2chunk0("x5284").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9232_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9232_sum""")
              x9232_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],x20422,Some(1.0), true.B, Truncate, Wrapping, "x9232_sum").r
              val x20423 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20423_x5287_D6") 
              x20423.r := getRetimed(block2chunk0("x5287").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9236_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9236_sum""")
              x9236_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],x20423,Some(1.0), true.B, Truncate, Wrapping, "x9236_sum").r
              val x20424 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20424_x5290_D6") 
              x20424.r := getRetimed(block2chunk0("x5290").asInstanceOf[FixedPoint].r, 6.toInt, io.sigsIn.backpressure)
              val x9240_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9240_sum""")
              x9240_sum.r := Math.add(block2chunk1sub0("x19051").asInstanceOf[FixedPoint],x20424,Some(1.0), true.B, Truncate, Wrapping, "x9240_sum").r
              val x20425 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20425_x9208_sum_D21") 
              x20425.r := getRetimed(x9208_sum.r, 21.toInt, io.sigsIn.backpressure)
              val x20426 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20426_x9180_sum_D21") 
              x20426.r := getRetimed(block2chunk1sub0("x9180_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20427 = Wire(Bool()).suggestName("x20427_b4500_D28") 
              x20427.r := getRetimed(b4500.r, 28.toInt, io.sigsIn.backpressure)
              val x20428 = Wire(Bool()).suggestName("x20428_b4515_D28") 
              x20428.r := getRetimed(b4515.r, 28.toInt, io.sigsIn.backpressure)
              val x20429 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20429_x9120_sum_D21") 
              x20429.r := getRetimed(block2chunk1sub0("x9120_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20430 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20430_x9152_sum_D21") 
              x20430.r := getRetimed(block2chunk1sub0("x9152_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20431 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20431_x9184_sum_D21") 
              x20431.r := getRetimed(block2chunk1sub0("x9184_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20432 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20432_x9212_sum_D21") 
              x20432.r := getRetimed(x9212_sum.r, 21.toInt, io.sigsIn.backpressure)
              val x20433 = Wire(Bool()).suggestName("x20433_b4496_D28") 
              x20433.r := getRetimed(b4496.r, 28.toInt, io.sigsIn.backpressure)
              val x20434 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20434_x9148_sum_D21") 
              x20434.r := getRetimed(block2chunk1sub0("x9148_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20435 = Wire(Bool()).suggestName("x20435_b4511_D28") 
              x20435.r := getRetimed(b4511.r, 28.toInt, io.sigsIn.backpressure)
              val x20436 = Wire(Bool()).suggestName("x20436_b4524_D28") 
              x20436.r := getRetimed(b4524.r, 28.toInt, io.sigsIn.backpressure)
              val x20437 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20437_x9172_sum_D21") 
              x20437.r := getRetimed(block2chunk1sub0("x9172_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20438 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20438_x9216_sum_D21") 
              x20438.r := getRetimed(x9216_sum.r, 21.toInt, io.sigsIn.backpressure)
              val x20439 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20439_x9128_sum_D21") 
              x20439.r := getRetimed(block2chunk1sub0("x9128_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20440 = Wire(Bool()).suggestName("x20440_b4492_D28") 
              x20440.r := getRetimed(b4492.r, 28.toInt, io.sigsIn.backpressure)
              val x20441 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20441_x9240_sum_D21") 
              x20441.r := getRetimed(x9240_sum.r, 21.toInt, io.sigsIn.backpressure)
              val x20442 = Wire(Bool()).suggestName("x20442_b4507_D28") 
              x20442.r := getRetimed(b4507.r, 28.toInt, io.sigsIn.backpressure)
              val x20443 = Wire(Bool()).suggestName("x20443_b4514_D28") 
              x20443.r := getRetimed(b4514.r, 28.toInt, io.sigsIn.backpressure)
              val x20444 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20444_x9204_sum_D21") 
              x20444.r := getRetimed(x9204_sum.r, 21.toInt, io.sigsIn.backpressure)
              val x20445 = Wire(Bool()).suggestName("x20445_b4504_D28") 
              x20445.r := getRetimed(b4504.r, 28.toInt, io.sigsIn.backpressure)
              val x20446 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20446_x9140_sum_D21") 
              x20446.r := getRetimed(block2chunk1sub0("x9140_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20447 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20447_x9236_sum_D21") 
              x20447.r := getRetimed(x9236_sum.r, 21.toInt, io.sigsIn.backpressure)
              val x20448 = Wire(Bool()).suggestName("x20448_b4519_D28") 
              x20448.r := getRetimed(b4519.r, 28.toInt, io.sigsIn.backpressure)
              val x20449 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20449_x9136_sum_D21") 
              x20449.r := getRetimed(block2chunk1sub0("x9136_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20450 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20450_x9164_sum_D21") 
              x20450.r := getRetimed(block2chunk1sub0("x9164_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20451 = Wire(Bool()).suggestName("x20451_b4521_D28") 
              x20451.r := getRetimed(b4521.r, 28.toInt, io.sigsIn.backpressure)
              val x20452 = Wire(Bool()).suggestName("x20452_b4499_D28") 
              x20452.r := getRetimed(b4499.r, 28.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x9200_sum" -> x9200_sum, "x9204_sum" -> x9204_sum, "x9208_sum" -> x9208_sum, "x9212_sum" -> x9212_sum, "x9216_sum" -> x9216_sum, "x9220_sum" -> x9220_sum, "x9224_sum" -> x9224_sum, "x9228_sum" -> x9228_sum, "x9232_sum" -> x9232_sum, "x9236_sum" -> x9236_sum, "x9240_sum" -> x9240_sum, "x20425" -> x20425, "x20426" -> x20426, "x20427" -> x20427, "x20428" -> x20428, "x20429" -> x20429, "x20430" -> x20430, "x20431" -> x20431, "x20432" -> x20432, "x20433" -> x20433, "x20434" -> x20434, "x20435" -> x20435, "x20436" -> x20436, "x20437" -> x20437, "x20438" -> x20438, "x20439" -> x20439, "x20440" -> x20440, "x20441" -> x20441, "x20442" -> x20442, "x20443" -> x20443, "x20444" -> x20444, "x20445" -> x20445, "x20446" -> x20446, "x20447" -> x20447, "x20448" -> x20448, "x20449" -> x20449, "x20450" -> x20450, "x20451" -> x20451, "x20452" -> x20452)
            }
          }
          val block2chunk1sub1: Map[String, Any] = Block2Chunker1Sub1.gen()
          object Block2Chunker1Sub2 { // 41 nodes, 41 weight
            def gen(): Map[String, Any] = {
              val x20453 = Wire(Bool()).suggestName("x20453_b4493_D28") 
              x20453.r := getRetimed(b4493.r, 28.toInt, io.sigsIn.backpressure)
              val x20454 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20454_x9132_sum_D21") 
              x20454.r := getRetimed(block2chunk1sub0("x9132_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20455 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20455_x9196_sum_D21") 
              x20455.r := getRetimed(block2chunk1sub0("x9196_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20456 = Wire(Bool()).suggestName("x20456_b4512_D28") 
              x20456.r := getRetimed(b4512.r, 28.toInt, io.sigsIn.backpressure)
              val x20457 = Wire(Bool()).suggestName("x20457_b4518_D28") 
              x20457.r := getRetimed(b4518.r, 28.toInt, io.sigsIn.backpressure)
              val x20458 = Wire(Bool()).suggestName("x20458_b4513_D28") 
              x20458.r := getRetimed(b4513.r, 28.toInt, io.sigsIn.backpressure)
              val x20459 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20459_x9200_sum_D21") 
              x20459.r := getRetimed(block2chunk1sub1("x9200_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20460 = Wire(Bool()).suggestName("x20460_b4508_D28") 
              x20460.r := getRetimed(b4508.r, 28.toInt, io.sigsIn.backpressure)
              val x20461 = Wire(Bool()).suggestName("x20461_b4068_D28") 
              x20461.r := getRetimed(b4068.r, 28.toInt, io.sigsIn.backpressure)
              val x20462 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20462_x9144_sum_D21") 
              x20462.r := getRetimed(block2chunk1sub0("x9144_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20463 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20463_x9176_sum_D21") 
              x20463.r := getRetimed(block2chunk1sub0("x9176_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20464 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20464_x9168_sum_D21") 
              x20464.r := getRetimed(block2chunk1sub0("x9168_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20465 = Wire(Bool()).suggestName("x20465_b4503_D28") 
              x20465.r := getRetimed(b4503.r, 28.toInt, io.sigsIn.backpressure)
              val x20466 = Wire(Bool()).suggestName("x20466_b4494_D28") 
              x20466.r := getRetimed(b4494.r, 28.toInt, io.sigsIn.backpressure)
              val x20467 = Wire(Bool()).suggestName("x20467_b4505_D28") 
              x20467.r := getRetimed(b4505.r, 28.toInt, io.sigsIn.backpressure)
              val x20468 = Wire(Bool()).suggestName("x20468_b4060_D28") 
              x20468.r := getRetimed(b4060.r, 28.toInt, io.sigsIn.backpressure)
              val x20469 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20469_x9224_sum_D21") 
              x20469.r := getRetimed(block2chunk1sub1("x9224_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20470 = Wire(Bool()).suggestName("x20470_b4498_D28") 
              x20470.r := getRetimed(b4498.r, 28.toInt, io.sigsIn.backpressure)
              val x20471 = Wire(Bool()).suggestName("x20471_b4509_D28") 
              x20471.r := getRetimed(b4509.r, 28.toInt, io.sigsIn.backpressure)
              val x20472 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20472_x9228_sum_D21") 
              x20472.r := getRetimed(block2chunk1sub1("x9228_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20473 = Wire(Bool()).suggestName("x20473_b4502_D28") 
              x20473.r := getRetimed(b4502.r, 28.toInt, io.sigsIn.backpressure)
              val x20474 = Wire(Bool()).suggestName("x20474_b4497_D28") 
              x20474.r := getRetimed(b4497.r, 28.toInt, io.sigsIn.backpressure)
              val x20475 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20475_x9232_sum_D21") 
              x20475.r := getRetimed(block2chunk1sub1("x9232_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20476 = Wire(Bool()).suggestName("x20476_x5133_rd_x3918_D28") 
              x20476.r := getRetimed(block2chunk0("x5133_rd_x3918").asInstanceOf[Bool].r, 28.toInt, io.sigsIn.backpressure)
              val x20477 = Wire(Bool()).suggestName("x20477_b4517_D28") 
              x20477.r := getRetimed(b4517.r, 28.toInt, io.sigsIn.backpressure)
              val x20478 = Wire(Bool()).suggestName("x20478_b4522_D28") 
              x20478.r := getRetimed(b4522.r, 28.toInt, io.sigsIn.backpressure)
              val x20479 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20479_x9220_sum_D21") 
              x20479.r := getRetimed(block2chunk1sub1("x9220_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20480 = Wire(Bool()).suggestName("x20480_b4510_D28") 
              x20480.r := getRetimed(b4510.r, 28.toInt, io.sigsIn.backpressure)
              val x20481 = Wire(Bool()).suggestName("x20481_b4516_D28") 
              x20481.r := getRetimed(b4516.r, 28.toInt, io.sigsIn.backpressure)
              val x20482 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20482_x9192_sum_D21") 
              x20482.r := getRetimed(block2chunk1sub0("x9192_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20483 = Wire(Bool()).suggestName("x20483_b4495_D28") 
              x20483.r := getRetimed(b4495.r, 28.toInt, io.sigsIn.backpressure)
              val x20484 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20484_x9160_sum_D21") 
              x20484.r := getRetimed(block2chunk1sub0("x9160_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20485 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20485_x9115_sum_D21") 
              x20485.r := getRetimed(block2chunk1sub0("x9115_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20486 = Wire(Bool()).suggestName("x20486_b4523_D28") 
              x20486.r := getRetimed(b4523.r, 28.toInt, io.sigsIn.backpressure)
              val x20487 = Wire(Bool()).suggestName("x20487_b4491_D28") 
              x20487.r := getRetimed(b4491.r, 28.toInt, io.sigsIn.backpressure)
              val x20488 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20488_x9156_sum_D21") 
              x20488.r := getRetimed(block2chunk1sub0("x9156_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20489 = Wire(Bool()).suggestName("x20489_b4506_D28") 
              x20489.r := getRetimed(b4506.r, 28.toInt, io.sigsIn.backpressure)
              val x20490 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20490_x9124_sum_D21") 
              x20490.r := getRetimed(block2chunk1sub0("x9124_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20491 = Wire(Bool()).suggestName("x20491_b4501_D28") 
              x20491.r := getRetimed(b4501.r, 28.toInt, io.sigsIn.backpressure)
              val x20492 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20492_x9188_sum_D21") 
              x20492.r := getRetimed(block2chunk1sub0("x9188_sum").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
              val x20493 = Wire(Bool()).suggestName("x20493_b4520_D28") 
              x20493.r := getRetimed(b4520.r, 28.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x20453" -> x20453, "x20454" -> x20454, "x20455" -> x20455, "x20456" -> x20456, "x20457" -> x20457, "x20458" -> x20458, "x20459" -> x20459, "x20460" -> x20460, "x20461" -> x20461, "x20462" -> x20462, "x20463" -> x20463, "x20464" -> x20464, "x20465" -> x20465, "x20466" -> x20466, "x20467" -> x20467, "x20468" -> x20468, "x20469" -> x20469, "x20470" -> x20470, "x20471" -> x20471, "x20472" -> x20472, "x20473" -> x20473, "x20474" -> x20474, "x20475" -> x20475, "x20476" -> x20476, "x20477" -> x20477, "x20478" -> x20478, "x20479" -> x20479, "x20480" -> x20480, "x20481" -> x20481, "x20482" -> x20482, "x20483" -> x20483, "x20484" -> x20484, "x20485" -> x20485, "x20486" -> x20486, "x20487" -> x20487, "x20488" -> x20488, "x20489" -> x20489, "x20490" -> x20490, "x20491" -> x20491, "x20492" -> x20492, "x20493" -> x20493)
            }
          }
          val block2chunk1sub2: Map[String, Any] = Block2Chunker1Sub2.gen()
          object Block2Chunker1Sub3 { // 18 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x9244_rd = Wire(Vec(32, new FixedPoint(true, 10, 22))).suggestName("""x9244_rd""")
              def create_x9244_rd_banks(): List[UInt] = {
                val x9244_rd_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
                val x9244_rd_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
                val x9244_rd_banks2 = List[UInt](16L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,21L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r)
                val x9244_rd_banks3 = List[UInt](24L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,28L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                x9244_rd_banks0 ++ x9244_rd_banks1 ++ x9244_rd_banks2 ++ x9244_rd_banks3
              }
              val x9244_rd_banks = create_x9244_rd_banks()
              def create_x9244_rd_ofs(): List[UInt] = {
                val x9244_rd_ofs0 = List[UInt](block2chunk1sub2("x20485").asInstanceOf[FixedPoint].r,block2chunk1sub1("x20429").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs1 = List[UInt](block2chunk1sub2("x20490").asInstanceOf[FixedPoint].r,block2chunk1sub1("x20439").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs2 = List[UInt](block2chunk1sub2("x20454").asInstanceOf[FixedPoint].r,block2chunk1sub1("x20449").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs3 = List[UInt](block2chunk1sub1("x20446").asInstanceOf[FixedPoint].r,block2chunk1sub2("x20462").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs4 = List[UInt](block2chunk1sub1("x20434").asInstanceOf[FixedPoint].r,block2chunk1sub1("x20430").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs5 = List[UInt](block2chunk1sub2("x20488").asInstanceOf[FixedPoint].r,block2chunk1sub2("x20484").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs6 = List[UInt](block2chunk1sub1("x20450").asInstanceOf[FixedPoint].r,block2chunk1sub2("x20464").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs7 = List[UInt](block2chunk1sub1("x20437").asInstanceOf[FixedPoint].r,block2chunk1sub2("x20463").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs8 = List[UInt](block2chunk1sub1("x20426").asInstanceOf[FixedPoint].r,block2chunk1sub1("x20431").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs9 = List[UInt](block2chunk1sub2("x20492").asInstanceOf[FixedPoint].r,block2chunk1sub2("x20482").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs10 = List[UInt](block2chunk1sub2("x20455").asInstanceOf[FixedPoint].r,block2chunk1sub2("x20459").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs11 = List[UInt](block2chunk1sub1("x20444").asInstanceOf[FixedPoint].r,block2chunk1sub1("x20425").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs12 = List[UInt](block2chunk1sub1("x20432").asInstanceOf[FixedPoint].r,block2chunk1sub1("x20438").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs13 = List[UInt](block2chunk1sub2("x20479").asInstanceOf[FixedPoint].r,block2chunk1sub2("x20469").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs14 = List[UInt](block2chunk1sub2("x20472").asInstanceOf[FixedPoint].r,block2chunk1sub2("x20475").asInstanceOf[FixedPoint].r)
                val x9244_rd_ofs15 = List[UInt](block2chunk1sub1("x20447").asInstanceOf[FixedPoint].r,block2chunk1sub1("x20441").asInstanceOf[FixedPoint].r)
                x9244_rd_ofs0 ++ x9244_rd_ofs1 ++ x9244_rd_ofs2 ++ x9244_rd_ofs3 ++ x9244_rd_ofs4 ++ x9244_rd_ofs5 ++ x9244_rd_ofs6 ++ x9244_rd_ofs7 ++ x9244_rd_ofs8 ++ x9244_rd_ofs9 ++ x9244_rd_ofs10 ++ x9244_rd_ofs11 ++ x9244_rd_ofs12 ++ x9244_rd_ofs13 ++ x9244_rd_ofs14 ++ x9244_rd_ofs15
              }
              val x9244_rd_ofs = create_x9244_rd_ofs()
              def create_x9244_rd_en(): List[Bool] = {
                val x9244_rd_en0 = List[Bool](block2chunk1sub2("x20453").asInstanceOf[Bool],block2chunk1sub2("x20466").asInstanceOf[Bool],block2chunk1sub2("x20483").asInstanceOf[Bool])
                val x9244_rd_en1 = List[Bool](block2chunk1sub1("x20433").asInstanceOf[Bool],block2chunk1sub2("x20474").asInstanceOf[Bool],block2chunk1sub2("x20470").asInstanceOf[Bool])
                val x9244_rd_en2 = List[Bool](block2chunk1sub1("x20452").asInstanceOf[Bool],block2chunk1sub1("x20427").asInstanceOf[Bool],block2chunk1sub2("x20491").asInstanceOf[Bool])
                val x9244_rd_en3 = List[Bool](block2chunk1sub2("x20473").asInstanceOf[Bool],block2chunk1sub2("x20465").asInstanceOf[Bool],block2chunk1sub1("x20445").asInstanceOf[Bool])
                val x9244_rd_en4 = List[Bool](block2chunk1sub2("x20467").asInstanceOf[Bool],block2chunk1sub2("x20489").asInstanceOf[Bool],block2chunk1sub1("x20442").asInstanceOf[Bool])
                val x9244_rd_en5 = List[Bool](block2chunk1sub2("x20460").asInstanceOf[Bool],block2chunk1sub2("x20471").asInstanceOf[Bool],block2chunk1sub2("x20480").asInstanceOf[Bool])
                val x9244_rd_en6 = List[Bool](block2chunk1sub1("x20435").asInstanceOf[Bool],block2chunk1sub2("x20456").asInstanceOf[Bool],block2chunk1sub2("x20458").asInstanceOf[Bool])
                val x9244_rd_en7 = List[Bool](block2chunk1sub1("x20443").asInstanceOf[Bool],block2chunk1sub1("x20428").asInstanceOf[Bool],block2chunk1sub2("x20481").asInstanceOf[Bool])
                val x9244_rd_en8 = List[Bool](block2chunk1sub2("x20477").asInstanceOf[Bool],block2chunk1sub2("x20457").asInstanceOf[Bool],block2chunk1sub1("x20448").asInstanceOf[Bool])
                val x9244_rd_en9 = List[Bool](block2chunk1sub2("x20493").asInstanceOf[Bool],block2chunk1sub1("x20451").asInstanceOf[Bool],block2chunk1sub2("x20478").asInstanceOf[Bool])
                val x9244_rd_en10 = List[Bool](block2chunk1sub2("x20486").asInstanceOf[Bool],block2chunk1sub1("x20436").asInstanceOf[Bool])
                x9244_rd_en0 ++ x9244_rd_en1 ++ x9244_rd_en2 ++ x9244_rd_en3 ++ x9244_rd_en4 ++ x9244_rd_en5 ++ x9244_rd_en6 ++ x9244_rd_en7 ++ x9244_rd_en8 ++ x9244_rd_en9 ++ x9244_rd_en10
              }
              val x9244_rd_en = create_x9244_rd_en()
              x9244_rd.toSeq.zip(x4061_out_SRAM_conv_0.connectRPort(9244, x9244_rd_banks, x9244_rd_ofs, io.sigsIn.backpressure, x9244_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(28.9.toInt, rr, io.sigsIn.backpressure) && block2chunk1sub2("x20461").asInstanceOf[Bool] & block2chunk1sub2("x20468").asInstanceOf[Bool] & block2chunk1sub1("x20440").asInstanceOf[Bool] & block2chunk1sub2("x20476").asInstanceOf[Bool] & block2chunk1sub2("x20487").asInstanceOf[Bool]), true)).foreach{case (a,b) => a := b}
              val x9245_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9245_elem_0""")
              x9245_elem_0.r := x9244_rd(0).r
              val x9246_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9246_elem_1""")
              x9246_elem_1.r := x9244_rd(1).r
              val x9247_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9247_elem_2""")
              x9247_elem_2.r := x9244_rd(2).r
              val x9248_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9248_elem_3""")
              x9248_elem_3.r := x9244_rd(3).r
              val x9249_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9249_elem_4""")
              x9249_elem_4.r := x9244_rd(4).r
              val x9250_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9250_elem_5""")
              x9250_elem_5.r := x9244_rd(5).r
              val x9251_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9251_elem_6""")
              x9251_elem_6.r := x9244_rd(6).r
              val x9252_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9252_elem_7""")
              x9252_elem_7.r := x9244_rd(7).r
              val x9253_elem_8 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9253_elem_8""")
              x9253_elem_8.r := x9244_rd(8).r
              val x9254_elem_9 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9254_elem_9""")
              x9254_elem_9.r := x9244_rd(9).r
              val x9255_elem_10 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9255_elem_10""")
              x9255_elem_10.r := x9244_rd(10).r
              val x9256_elem_11 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9256_elem_11""")
              x9256_elem_11.r := x9244_rd(11).r
              val x9257_elem_12 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9257_elem_12""")
              x9257_elem_12.r := x9244_rd(12).r
              val x9258_elem_13 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9258_elem_13""")
              x9258_elem_13.r := x9244_rd(13).r
              val x9259_elem_14 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9259_elem_14""")
              x9259_elem_14.r := x9244_rd(14).r
              val x9260_elem_15 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9260_elem_15""")
              x9260_elem_15.r := x9244_rd(15).r
              val x9261_elem_16 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9261_elem_16""")
              x9261_elem_16.r := x9244_rd(16).r
              Map[String,Any]("x9244_rd" -> x9244_rd, "x9245_elem_0" -> x9245_elem_0, "x9246_elem_1" -> x9246_elem_1, "x9247_elem_2" -> x9247_elem_2, "x9248_elem_3" -> x9248_elem_3, "x9249_elem_4" -> x9249_elem_4, "x9250_elem_5" -> x9250_elem_5, "x9251_elem_6" -> x9251_elem_6, "x9252_elem_7" -> x9252_elem_7, "x9253_elem_8" -> x9253_elem_8, "x9254_elem_9" -> x9254_elem_9, "x9255_elem_10" -> x9255_elem_10, "x9256_elem_11" -> x9256_elem_11, "x9257_elem_12" -> x9257_elem_12, "x9258_elem_13" -> x9258_elem_13, "x9259_elem_14" -> x9259_elem_14, "x9260_elem_15" -> x9260_elem_15, "x9261_elem_16" -> x9261_elem_16)
            }
          }
          val block2chunk1sub3: Map[String, Any] = Block2Chunker1Sub3.gen()
          object Block2Chunker1Sub4 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x9262_elem_17 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9262_elem_17""")
              x9262_elem_17.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](17).r
              val x9263_elem_18 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9263_elem_18""")
              x9263_elem_18.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](18).r
              val x9264_elem_19 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9264_elem_19""")
              x9264_elem_19.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](19).r
              val x9265_elem_20 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9265_elem_20""")
              x9265_elem_20.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](20).r
              val x9266_elem_21 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9266_elem_21""")
              x9266_elem_21.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](21).r
              val x9267_elem_22 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9267_elem_22""")
              x9267_elem_22.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](22).r
              val x9268_elem_23 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9268_elem_23""")
              x9268_elem_23.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](23).r
              val x9269_elem_24 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9269_elem_24""")
              x9269_elem_24.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](24).r
              val x9270_elem_25 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9270_elem_25""")
              x9270_elem_25.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](25).r
              val x9271_elem_26 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9271_elem_26""")
              x9271_elem_26.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](26).r
              val x9272_elem_27 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9272_elem_27""")
              x9272_elem_27.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](27).r
              val x9273_elem_28 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9273_elem_28""")
              x9273_elem_28.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](28).r
              val x9274_elem_29 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9274_elem_29""")
              x9274_elem_29.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](29).r
              val x9275_elem_30 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9275_elem_30""")
              x9275_elem_30.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](30).r
              val x9276_elem_31 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9276_elem_31""")
              x9276_elem_31.r := block2chunk1sub3("x9244_rd").asInstanceOf[Vec[FixedPoint]](31).r
              val x20494 = Wire(Bool()).suggestName("x20494_x9112_D30") 
              x20494.r := getRetimed(block2chunk1sub0("x9112").asInstanceOf[Bool].r, 30.toInt, io.sigsIn.backpressure)
              val x9277 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9277""")
              x9277.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9245_elem_0").asInstanceOf[FixedPoint].r)
              val x9278 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9278""")
              x9278.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9246_elem_1").asInstanceOf[FixedPoint].r)
              val x9279 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9279""")
              x9279.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9247_elem_2").asInstanceOf[FixedPoint].r)
              val x9280 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9280""")
              x9280.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9248_elem_3").asInstanceOf[FixedPoint].r)
              val x9281 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9281""")
              x9281.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9249_elem_4").asInstanceOf[FixedPoint].r)
              val x9282 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9282""")
              x9282.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9250_elem_5").asInstanceOf[FixedPoint].r)
              val x9283 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9283""")
              x9283.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9251_elem_6").asInstanceOf[FixedPoint].r)
              val x9284 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9284""")
              x9284.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9252_elem_7").asInstanceOf[FixedPoint].r)
              val x9285 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9285""")
              x9285.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9253_elem_8").asInstanceOf[FixedPoint].r)
              val x9286 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9286""")
              x9286.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9254_elem_9").asInstanceOf[FixedPoint].r)
              val x9287 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9287""")
              x9287.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9255_elem_10").asInstanceOf[FixedPoint].r)
              val x9288 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9288""")
              x9288.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9256_elem_11").asInstanceOf[FixedPoint].r)
              val x9289 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9289""")
              x9289.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9257_elem_12").asInstanceOf[FixedPoint].r)
              val x9290 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9290""")
              x9290.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9258_elem_13").asInstanceOf[FixedPoint].r)
              val x9291 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9291""")
              x9291.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9259_elem_14").asInstanceOf[FixedPoint].r)
              val x9292 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9292""")
              x9292.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9260_elem_15").asInstanceOf[FixedPoint].r)
              val x9293 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9293""")
              x9293.r := Mux((x20494), 0.FP(true, 10, 22).r, block2chunk1sub3("x9261_elem_16").asInstanceOf[FixedPoint].r)
              val x9294 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9294""")
              x9294.r := Mux((x20494), 0.FP(true, 10, 22).r, x9262_elem_17.r)
              val x9295 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9295""")
              x9295.r := Mux((x20494), 0.FP(true, 10, 22).r, x9263_elem_18.r)
              val x9296 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9296""")
              x9296.r := Mux((x20494), 0.FP(true, 10, 22).r, x9264_elem_19.r)
              val x9297 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9297""")
              x9297.r := Mux((x20494), 0.FP(true, 10, 22).r, x9265_elem_20.r)
              val x9298 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9298""")
              x9298.r := Mux((x20494), 0.FP(true, 10, 22).r, x9266_elem_21.r)
              val x9299 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9299""")
              x9299.r := Mux((x20494), 0.FP(true, 10, 22).r, x9267_elem_22.r)
              val x9300 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9300""")
              x9300.r := Mux((x20494), 0.FP(true, 10, 22).r, x9268_elem_23.r)
              val x9301 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9301""")
              x9301.r := Mux((x20494), 0.FP(true, 10, 22).r, x9269_elem_24.r)
              val x9302 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9302""")
              x9302.r := Mux((x20494), 0.FP(true, 10, 22).r, x9270_elem_25.r)
              val x9303 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9303""")
              x9303.r := Mux((x20494), 0.FP(true, 10, 22).r, x9271_elem_26.r)
              val x9304 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9304""")
              x9304.r := Mux((x20494), 0.FP(true, 10, 22).r, x9272_elem_27.r)
              val x9305 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9305""")
              x9305.r := Mux((x20494), 0.FP(true, 10, 22).r, x9273_elem_28.r)
              val x9306 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9306""")
              x9306.r := Mux((x20494), 0.FP(true, 10, 22).r, x9274_elem_29.r)
              val x9307 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9307""")
              x9307.r := Mux((x20494), 0.FP(true, 10, 22).r, x9275_elem_30.r)
              val x9308 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9308""")
              x9308.r := Mux((x20494), 0.FP(true, 10, 22).r, x9276_elem_31.r)
              val x20495 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20495_x9277_D1") 
              x20495.r := getRetimed(x9277.r, 1.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x9278" -> x9278, "x9279" -> x9279, "x9280" -> x9280, "x9281" -> x9281, "x9282" -> x9282, "x9283" -> x9283, "x9284" -> x9284, "x9285" -> x9285, "x9286" -> x9286, "x9287" -> x9287, "x9288" -> x9288, "x9289" -> x9289, "x9290" -> x9290, "x9291" -> x9291, "x9292" -> x9292, "x9293" -> x9293, "x9294" -> x9294, "x9295" -> x9295, "x9296" -> x9296, "x9297" -> x9297, "x9298" -> x9298, "x9299" -> x9299, "x9300" -> x9300, "x9301" -> x9301, "x9302" -> x9302, "x9303" -> x9303, "x9304" -> x9304, "x9305" -> x9305, "x9306" -> x9306, "x9307" -> x9307, "x9308" -> x9308, "x20495" -> x20495)
            }
          }
          val block2chunk1sub4: Map[String, Any] = Block2Chunker1Sub4.gen()
          object Block2Chunker1Sub5 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x9309_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9309_sum""")
              x9309_sum.r := Math.add(block2chunk0("x19019").asInstanceOf[FixedPoint],block2chunk1sub4("x20495").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9309_sum").r
              val x20496 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20496_x9278_D1") 
              x20496.r := getRetimed(block2chunk1sub4("x9278").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9310_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9310_sum""")
              x9310_sum.r := Math.add(block2chunk0("x19020").asInstanceOf[FixedPoint],x20496,Some(1.0), true.B, Truncate, Wrapping, "x9310_sum").r
              val x20497 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20497_x9279_D1") 
              x20497.r := getRetimed(block2chunk1sub4("x9279").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9311_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9311_sum""")
              x9311_sum.r := Math.add(block2chunk0("x19021").asInstanceOf[FixedPoint],x20497,Some(1.0), true.B, Truncate, Wrapping, "x9311_sum").r
              val x20498 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20498_x9280_D1") 
              x20498.r := getRetimed(block2chunk1sub4("x9280").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9312_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9312_sum""")
              x9312_sum.r := Math.add(block2chunk0("x19022").asInstanceOf[FixedPoint],x20498,Some(1.0), true.B, Truncate, Wrapping, "x9312_sum").r
              val x20499 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20499_x9281_D1") 
              x20499.r := getRetimed(block2chunk1sub4("x9281").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9313_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9313_sum""")
              x9313_sum.r := Math.add(block2chunk0("x19023").asInstanceOf[FixedPoint],x20499,Some(1.0), true.B, Truncate, Wrapping, "x9313_sum").r
              val x20500 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20500_x9282_D1") 
              x20500.r := getRetimed(block2chunk1sub4("x9282").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9314_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9314_sum""")
              x9314_sum.r := Math.add(block2chunk0("x19024").asInstanceOf[FixedPoint],x20500,Some(1.0), true.B, Truncate, Wrapping, "x9314_sum").r
              val x20501 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20501_x9283_D1") 
              x20501.r := getRetimed(block2chunk1sub4("x9283").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9315_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9315_sum""")
              x9315_sum.r := Math.add(block2chunk0("x19025").asInstanceOf[FixedPoint],x20501,Some(1.0), true.B, Truncate, Wrapping, "x9315_sum").r
              val x20502 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20502_x9284_D1") 
              x20502.r := getRetimed(block2chunk1sub4("x9284").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9316_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9316_sum""")
              x9316_sum.r := Math.add(block2chunk0("x19026").asInstanceOf[FixedPoint],x20502,Some(1.0), true.B, Truncate, Wrapping, "x9316_sum").r
              val x20503 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20503_x9285_D1") 
              x20503.r := getRetimed(block2chunk1sub4("x9285").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9317_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9317_sum""")
              x9317_sum.r := Math.add(block2chunk0("x19027").asInstanceOf[FixedPoint],x20503,Some(1.0), true.B, Truncate, Wrapping, "x9317_sum").r
              val x20504 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20504_x9286_D1") 
              x20504.r := getRetimed(block2chunk1sub4("x9286").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9318_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9318_sum""")
              x9318_sum.r := Math.add(block2chunk0("x19028").asInstanceOf[FixedPoint],x20504,Some(1.0), true.B, Truncate, Wrapping, "x9318_sum").r
              val x20505 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20505_x9287_D1") 
              x20505.r := getRetimed(block2chunk1sub4("x9287").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9319_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9319_sum""")
              x9319_sum.r := Math.add(block2chunk0("x19029").asInstanceOf[FixedPoint],x20505,Some(1.0), true.B, Truncate, Wrapping, "x9319_sum").r
              val x20506 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20506_x9288_D1") 
              x20506.r := getRetimed(block2chunk1sub4("x9288").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9320_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9320_sum""")
              x9320_sum.r := Math.add(block2chunk0("x19030").asInstanceOf[FixedPoint],x20506,Some(1.0), true.B, Truncate, Wrapping, "x9320_sum").r
              val x20507 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20507_x9289_D1") 
              x20507.r := getRetimed(block2chunk1sub4("x9289").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9321_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9321_sum""")
              x9321_sum.r := Math.add(block2chunk0("x19031").asInstanceOf[FixedPoint],x20507,Some(1.0), true.B, Truncate, Wrapping, "x9321_sum").r
              val x20508 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20508_x9290_D1") 
              x20508.r := getRetimed(block2chunk1sub4("x9290").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9322_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9322_sum""")
              x9322_sum.r := Math.add(block2chunk0("x19032").asInstanceOf[FixedPoint],x20508,Some(1.0), true.B, Truncate, Wrapping, "x9322_sum").r
              val x20509 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20509_x9291_D1") 
              x20509.r := getRetimed(block2chunk1sub4("x9291").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9323_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9323_sum""")
              x9323_sum.r := Math.add(block2chunk0("x19033").asInstanceOf[FixedPoint],x20509,Some(1.0), true.B, Truncate, Wrapping, "x9323_sum").r
              val x20510 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20510_x9292_D1") 
              x20510.r := getRetimed(block2chunk1sub4("x9292").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9324_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9324_sum""")
              x9324_sum.r := Math.add(block2chunk0("x19034").asInstanceOf[FixedPoint],x20510,Some(1.0), true.B, Truncate, Wrapping, "x9324_sum").r
              val x20511 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20511_x9293_D1") 
              x20511.r := getRetimed(block2chunk1sub4("x9293").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9325_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9325_sum""")
              x9325_sum.r := Math.add(block2chunk0("x19035").asInstanceOf[FixedPoint],x20511,Some(1.0), true.B, Truncate, Wrapping, "x9325_sum").r
              val x20512 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20512_x9294_D1") 
              x20512.r := getRetimed(block2chunk1sub4("x9294").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9326_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9326_sum""")
              x9326_sum.r := Math.add(block2chunk0("x19036").asInstanceOf[FixedPoint],x20512,Some(1.0), true.B, Truncate, Wrapping, "x9326_sum").r
              val x20513 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20513_x9295_D1") 
              x20513.r := getRetimed(block2chunk1sub4("x9295").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9327_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9327_sum""")
              x9327_sum.r := Math.add(block2chunk0("x19037").asInstanceOf[FixedPoint],x20513,Some(1.0), true.B, Truncate, Wrapping, "x9327_sum").r
              val x20514 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20514_x9296_D1") 
              x20514.r := getRetimed(block2chunk1sub4("x9296").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9328_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9328_sum""")
              x9328_sum.r := Math.add(block2chunk0("x19038").asInstanceOf[FixedPoint],x20514,Some(1.0), true.B, Truncate, Wrapping, "x9328_sum").r
              val x20515 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20515_x9297_D1") 
              x20515.r := getRetimed(block2chunk1sub4("x9297").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9329_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9329_sum""")
              x9329_sum.r := Math.add(block2chunk0("x19039").asInstanceOf[FixedPoint],x20515,Some(1.0), true.B, Truncate, Wrapping, "x9329_sum").r
              val x20516 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20516_x9298_D1") 
              x20516.r := getRetimed(block2chunk1sub4("x9298").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9330_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9330_sum""")
              x9330_sum.r := Math.add(block2chunk0("x19040").asInstanceOf[FixedPoint],x20516,Some(1.0), true.B, Truncate, Wrapping, "x9330_sum").r
              val x20517 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20517_x9299_D1") 
              x20517.r := getRetimed(block2chunk1sub4("x9299").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9331_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9331_sum""")
              x9331_sum.r := Math.add(block2chunk0("x19041").asInstanceOf[FixedPoint],x20517,Some(1.0), true.B, Truncate, Wrapping, "x9331_sum").r
              val x20518 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20518_x9300_D1") 
              x20518.r := getRetimed(block2chunk1sub4("x9300").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9332_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9332_sum""")
              x9332_sum.r := Math.add(block2chunk0("x19042").asInstanceOf[FixedPoint],x20518,Some(1.0), true.B, Truncate, Wrapping, "x9332_sum").r
              val x20519 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20519_x9301_D1") 
              x20519.r := getRetimed(block2chunk1sub4("x9301").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9333_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9333_sum""")
              x9333_sum.r := Math.add(block2chunk0("x19043").asInstanceOf[FixedPoint],x20519,Some(1.0), true.B, Truncate, Wrapping, "x9333_sum").r
              Map[String,Any]("x9309_sum" -> x9309_sum, "x9310_sum" -> x9310_sum, "x9311_sum" -> x9311_sum, "x9312_sum" -> x9312_sum, "x9313_sum" -> x9313_sum, "x9314_sum" -> x9314_sum, "x9315_sum" -> x9315_sum, "x9316_sum" -> x9316_sum, "x9317_sum" -> x9317_sum, "x9318_sum" -> x9318_sum, "x9319_sum" -> x9319_sum, "x9320_sum" -> x9320_sum, "x9321_sum" -> x9321_sum, "x9322_sum" -> x9322_sum, "x9323_sum" -> x9323_sum, "x9324_sum" -> x9324_sum, "x9325_sum" -> x9325_sum, "x9326_sum" -> x9326_sum, "x9327_sum" -> x9327_sum, "x9328_sum" -> x9328_sum, "x9329_sum" -> x9329_sum, "x9330_sum" -> x9330_sum, "x9331_sum" -> x9331_sum, "x9332_sum" -> x9332_sum, "x9333_sum" -> x9333_sum)
            }
          }
          val block2chunk1sub5: Map[String, Any] = Block2Chunker1Sub5.gen()
          object Block2Chunker1Sub6 { // 49 nodes, 49 weight
            def gen(): Map[String, Any] = {
              val x20520 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20520_x9302_D1") 
              x20520.r := getRetimed(block2chunk1sub4("x9302").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9334_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9334_sum""")
              x9334_sum.r := Math.add(block2chunk0("x19044").asInstanceOf[FixedPoint],x20520,Some(1.0), true.B, Truncate, Wrapping, "x9334_sum").r
              val x20521 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20521_x9303_D1") 
              x20521.r := getRetimed(block2chunk1sub4("x9303").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9335_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9335_sum""")
              x9335_sum.r := Math.add(block2chunk0("x19045").asInstanceOf[FixedPoint],x20521,Some(1.0), true.B, Truncate, Wrapping, "x9335_sum").r
              val x20522 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20522_x9304_D1") 
              x20522.r := getRetimed(block2chunk1sub4("x9304").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9336_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9336_sum""")
              x9336_sum.r := Math.add(block2chunk0("x19046").asInstanceOf[FixedPoint],x20522,Some(1.0), true.B, Truncate, Wrapping, "x9336_sum").r
              val x20523 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20523_x9305_D1") 
              x20523.r := getRetimed(block2chunk1sub4("x9305").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9337_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9337_sum""")
              x9337_sum.r := Math.add(block2chunk0("x19047").asInstanceOf[FixedPoint],x20523,Some(1.0), true.B, Truncate, Wrapping, "x9337_sum").r
              val x20524 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20524_x9306_D1") 
              x20524.r := getRetimed(block2chunk1sub4("x9306").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9338_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9338_sum""")
              x9338_sum.r := Math.add(block2chunk0("x19048").asInstanceOf[FixedPoint],x20524,Some(1.0), true.B, Truncate, Wrapping, "x9338_sum").r
              val x20525 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20525_x9307_D1") 
              x20525.r := getRetimed(block2chunk1sub4("x9307").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9339_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9339_sum""")
              x9339_sum.r := Math.add(block2chunk1sub0("x19049").asInstanceOf[FixedPoint],x20525,Some(1.0), true.B, Truncate, Wrapping, "x9339_sum").r
              val x20526 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20526_x9308_D1") 
              x20526.r := getRetimed(block2chunk1sub4("x9308").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
              val x9340_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9340_sum""")
              x9340_sum.r := Math.add(block2chunk1sub0("x19050").asInstanceOf[FixedPoint],x20526,Some(1.0), true.B, Truncate, Wrapping, "x9340_sum").r
              val x20527 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20527_x9208_sum_D25") 
              x20527.r := getRetimed(block2chunk1sub1("x9208_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20528 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20528_x9180_sum_D25") 
              x20528.r := getRetimed(block2chunk1sub0("x9180_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20529 = Wire(Bool()).suggestName("x20529_b4500_D32") 
              x20529.r := getRetimed(b4500.r, 32.toInt, io.sigsIn.backpressure)
              val x20530 = Wire(Bool()).suggestName("x20530_b4515_D32") 
              x20530.r := getRetimed(b4515.r, 32.toInt, io.sigsIn.backpressure)
              val x20531 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20531_x9120_sum_D25") 
              x20531.r := getRetimed(block2chunk1sub0("x9120_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20532 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20532_x9152_sum_D25") 
              x20532.r := getRetimed(block2chunk1sub0("x9152_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20533 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20533_x9184_sum_D25") 
              x20533.r := getRetimed(block2chunk1sub0("x9184_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20534 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20534_x9212_sum_D25") 
              x20534.r := getRetimed(block2chunk1sub1("x9212_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20535 = Wire(Bool()).suggestName("x20535_b4496_D32") 
              x20535.r := getRetimed(b4496.r, 32.toInt, io.sigsIn.backpressure)
              val x20536 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20536_x9148_sum_D25") 
              x20536.r := getRetimed(block2chunk1sub0("x9148_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20537 = Wire(Bool()).suggestName("x20537_b4511_D32") 
              x20537.r := getRetimed(b4511.r, 32.toInt, io.sigsIn.backpressure)
              val x20538 = Wire(Bool()).suggestName("x20538_b4524_D32") 
              x20538.r := getRetimed(b4524.r, 32.toInt, io.sigsIn.backpressure)
              val x20539 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20539_x9172_sum_D25") 
              x20539.r := getRetimed(block2chunk1sub0("x9172_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20540 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20540_x9216_sum_D25") 
              x20540.r := getRetimed(block2chunk1sub1("x9216_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20541 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20541_x9128_sum_D25") 
              x20541.r := getRetimed(block2chunk1sub0("x9128_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20542 = Wire(Bool()).suggestName("x20542_b4492_D32") 
              x20542.r := getRetimed(b4492.r, 32.toInt, io.sigsIn.backpressure)
              val x20543 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20543_x9240_sum_D25") 
              x20543.r := getRetimed(block2chunk1sub1("x9240_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20544 = Wire(Bool()).suggestName("x20544_b4507_D32") 
              x20544.r := getRetimed(b4507.r, 32.toInt, io.sigsIn.backpressure)
              val x20545 = Wire(Bool()).suggestName("x20545_b4514_D32") 
              x20545.r := getRetimed(b4514.r, 32.toInt, io.sigsIn.backpressure)
              val x20546 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20546_x9204_sum_D25") 
              x20546.r := getRetimed(block2chunk1sub1("x9204_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20547 = Wire(Bool()).suggestName("x20547_b4504_D32") 
              x20547.r := getRetimed(b4504.r, 32.toInt, io.sigsIn.backpressure)
              val x20548 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20548_x9140_sum_D25") 
              x20548.r := getRetimed(block2chunk1sub0("x9140_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20549 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20549_x9236_sum_D25") 
              x20549.r := getRetimed(block2chunk1sub1("x9236_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20550 = Wire(Bool()).suggestName("x20550_b4519_D32") 
              x20550.r := getRetimed(b4519.r, 32.toInt, io.sigsIn.backpressure)
              val x20551 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20551_x9136_sum_D25") 
              x20551.r := getRetimed(block2chunk1sub0("x9136_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20552 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20552_x9164_sum_D25") 
              x20552.r := getRetimed(block2chunk1sub0("x9164_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20553 = Wire(Bool()).suggestName("x20553_b4521_D32") 
              x20553.r := getRetimed(b4521.r, 32.toInt, io.sigsIn.backpressure)
              val x20554 = Wire(Bool()).suggestName("x20554_b4499_D32") 
              x20554.r := getRetimed(b4499.r, 32.toInt, io.sigsIn.backpressure)
              val x20555 = Wire(Bool()).suggestName("x20555_b4493_D32") 
              x20555.r := getRetimed(b4493.r, 32.toInt, io.sigsIn.backpressure)
              val x20556 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20556_x9132_sum_D25") 
              x20556.r := getRetimed(block2chunk1sub0("x9132_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20557 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20557_x9196_sum_D25") 
              x20557.r := getRetimed(block2chunk1sub0("x9196_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20558 = Wire(Bool()).suggestName("x20558_b4512_D32") 
              x20558.r := getRetimed(b4512.r, 32.toInt, io.sigsIn.backpressure)
              val x20559 = Wire(Bool()).suggestName("x20559_b4518_D32") 
              x20559.r := getRetimed(b4518.r, 32.toInt, io.sigsIn.backpressure)
              val x20560 = Wire(Bool()).suggestName("x20560_b4513_D32") 
              x20560.r := getRetimed(b4513.r, 32.toInt, io.sigsIn.backpressure)
              val x20561 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20561_x9200_sum_D25") 
              x20561.r := getRetimed(block2chunk1sub1("x9200_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x9334_sum" -> x9334_sum, "x9335_sum" -> x9335_sum, "x9336_sum" -> x9336_sum, "x9337_sum" -> x9337_sum, "x9338_sum" -> x9338_sum, "x9339_sum" -> x9339_sum, "x9340_sum" -> x9340_sum, "x20527" -> x20527, "x20528" -> x20528, "x20529" -> x20529, "x20530" -> x20530, "x20531" -> x20531, "x20532" -> x20532, "x20533" -> x20533, "x20534" -> x20534, "x20535" -> x20535, "x20536" -> x20536, "x20537" -> x20537, "x20538" -> x20538, "x20539" -> x20539, "x20540" -> x20540, "x20541" -> x20541, "x20542" -> x20542, "x20543" -> x20543, "x20544" -> x20544, "x20545" -> x20545, "x20546" -> x20546, "x20547" -> x20547, "x20548" -> x20548, "x20549" -> x20549, "x20550" -> x20550, "x20551" -> x20551, "x20552" -> x20552, "x20553" -> x20553, "x20554" -> x20554, "x20555" -> x20555, "x20556" -> x20556, "x20557" -> x20557, "x20558" -> x20558, "x20559" -> x20559, "x20560" -> x20560, "x20561" -> x20561)
            }
          }
          val block2chunk1sub6: Map[String, Any] = Block2Chunker1Sub6.gen()
          object Block2Chunker1Sub7 { // 34 nodes, 34 weight
            def gen(): Map[String, Any] = {
              val x20562 = Wire(Bool()).suggestName("x20562_b4508_D32") 
              x20562.r := getRetimed(b4508.r, 32.toInt, io.sigsIn.backpressure)
              val x20563 = Wire(Bool()).suggestName("x20563_b4068_D32") 
              x20563.r := getRetimed(b4068.r, 32.toInt, io.sigsIn.backpressure)
              val x20564 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20564_x9144_sum_D25") 
              x20564.r := getRetimed(block2chunk1sub0("x9144_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20565 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20565_x9176_sum_D25") 
              x20565.r := getRetimed(block2chunk1sub0("x9176_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20566 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20566_x9168_sum_D25") 
              x20566.r := getRetimed(block2chunk1sub0("x9168_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20567 = Wire(Bool()).suggestName("x20567_b4503_D32") 
              x20567.r := getRetimed(b4503.r, 32.toInt, io.sigsIn.backpressure)
              val x20568 = Wire(Bool()).suggestName("x20568_b4494_D32") 
              x20568.r := getRetimed(b4494.r, 32.toInt, io.sigsIn.backpressure)
              val x20569 = Wire(Bool()).suggestName("x20569_b4505_D32") 
              x20569.r := getRetimed(b4505.r, 32.toInt, io.sigsIn.backpressure)
              val x20570 = Wire(Bool()).suggestName("x20570_b4060_D32") 
              x20570.r := getRetimed(b4060.r, 32.toInt, io.sigsIn.backpressure)
              val x20571 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20571_x9224_sum_D25") 
              x20571.r := getRetimed(block2chunk1sub1("x9224_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20572 = Wire(Bool()).suggestName("x20572_b4498_D32") 
              x20572.r := getRetimed(b4498.r, 32.toInt, io.sigsIn.backpressure)
              val x20573 = Wire(Bool()).suggestName("x20573_b4509_D32") 
              x20573.r := getRetimed(b4509.r, 32.toInt, io.sigsIn.backpressure)
              val x20574 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20574_x9228_sum_D25") 
              x20574.r := getRetimed(block2chunk1sub1("x9228_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20575 = Wire(Bool()).suggestName("x20575_b4502_D32") 
              x20575.r := getRetimed(b4502.r, 32.toInt, io.sigsIn.backpressure)
              val x20576 = Wire(Bool()).suggestName("x20576_b4497_D32") 
              x20576.r := getRetimed(b4497.r, 32.toInt, io.sigsIn.backpressure)
              val x20577 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20577_x9232_sum_D25") 
              x20577.r := getRetimed(block2chunk1sub1("x9232_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20578 = Wire(Bool()).suggestName("x20578_x5133_rd_x3918_D32") 
              x20578.r := getRetimed(block2chunk0("x5133_rd_x3918").asInstanceOf[Bool].r, 32.toInt, io.sigsIn.backpressure)
              val x20579 = Wire(Bool()).suggestName("x20579_b4517_D32") 
              x20579.r := getRetimed(b4517.r, 32.toInt, io.sigsIn.backpressure)
              val x20580 = Wire(Bool()).suggestName("x20580_b4522_D32") 
              x20580.r := getRetimed(b4522.r, 32.toInt, io.sigsIn.backpressure)
              val x20581 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20581_x9220_sum_D25") 
              x20581.r := getRetimed(block2chunk1sub1("x9220_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20582 = Wire(Bool()).suggestName("x20582_b4510_D32") 
              x20582.r := getRetimed(b4510.r, 32.toInt, io.sigsIn.backpressure)
              val x20583 = Wire(Bool()).suggestName("x20583_b4516_D32") 
              x20583.r := getRetimed(b4516.r, 32.toInt, io.sigsIn.backpressure)
              val x20584 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20584_x9192_sum_D25") 
              x20584.r := getRetimed(block2chunk1sub0("x9192_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20585 = Wire(Bool()).suggestName("x20585_b4495_D32") 
              x20585.r := getRetimed(b4495.r, 32.toInt, io.sigsIn.backpressure)
              val x20586 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20586_x9160_sum_D25") 
              x20586.r := getRetimed(block2chunk1sub0("x9160_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20587 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20587_x9115_sum_D25") 
              x20587.r := getRetimed(block2chunk1sub0("x9115_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20588 = Wire(Bool()).suggestName("x20588_b4523_D32") 
              x20588.r := getRetimed(b4523.r, 32.toInt, io.sigsIn.backpressure)
              val x20589 = Wire(Bool()).suggestName("x20589_b4491_D32") 
              x20589.r := getRetimed(b4491.r, 32.toInt, io.sigsIn.backpressure)
              val x20590 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20590_x9156_sum_D25") 
              x20590.r := getRetimed(block2chunk1sub0("x9156_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20591 = Wire(Bool()).suggestName("x20591_b4506_D32") 
              x20591.r := getRetimed(b4506.r, 32.toInt, io.sigsIn.backpressure)
              val x20592 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20592_x9124_sum_D25") 
              x20592.r := getRetimed(block2chunk1sub0("x9124_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20593 = Wire(Bool()).suggestName("x20593_b4501_D32") 
              x20593.r := getRetimed(b4501.r, 32.toInt, io.sigsIn.backpressure)
              val x20594 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20594_x9188_sum_D25") 
              x20594.r := getRetimed(block2chunk1sub0("x9188_sum").asInstanceOf[FixedPoint].r, 25.toInt, io.sigsIn.backpressure)
              val x20595 = Wire(Bool()).suggestName("x20595_b4520_D32") 
              x20595.r := getRetimed(b4520.r, 32.toInt, io.sigsIn.backpressure)
              Map[String,Any]("x20562" -> x20562, "x20563" -> x20563, "x20564" -> x20564, "x20565" -> x20565, "x20566" -> x20566, "x20567" -> x20567, "x20568" -> x20568, "x20569" -> x20569, "x20570" -> x20570, "x20571" -> x20571, "x20572" -> x20572, "x20573" -> x20573, "x20574" -> x20574, "x20575" -> x20575, "x20576" -> x20576, "x20577" -> x20577, "x20578" -> x20578, "x20579" -> x20579, "x20580" -> x20580, "x20581" -> x20581, "x20582" -> x20582, "x20583" -> x20583, "x20584" -> x20584, "x20585" -> x20585, "x20586" -> x20586, "x20587" -> x20587, "x20588" -> x20588, "x20589" -> x20589, "x20590" -> x20590, "x20591" -> x20591, "x20592" -> x20592, "x20593" -> x20593, "x20594" -> x20594, "x20595" -> x20595)
            }
          }
          val block2chunk1sub7: Map[String, Any] = Block2Chunker1Sub7.gen()
          object Block2Chunker1Sub8 { // 1 nodes, 32 weight
            def gen(): Map[String, Any] = {
              def create_x9341_wr_banks(): List[UInt] = {
                val x9341_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
                val x9341_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
                val x9341_wr_banks2 = List[UInt](16L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,21L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r)
                val x9341_wr_banks3 = List[UInt](24L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,28L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                x9341_wr_banks0 ++ x9341_wr_banks1 ++ x9341_wr_banks2 ++ x9341_wr_banks3
              }
              val x9341_wr_banks = create_x9341_wr_banks()
              def create_x9341_wr_ofs(): List[UInt] = {
                val x9341_wr_ofs0 = List[UInt](block2chunk1sub7("x20587").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20531").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs1 = List[UInt](block2chunk1sub7("x20592").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20541").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs2 = List[UInt](block2chunk1sub6("x20556").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20551").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs3 = List[UInt](block2chunk1sub6("x20548").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20564").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs4 = List[UInt](block2chunk1sub6("x20536").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20532").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs5 = List[UInt](block2chunk1sub7("x20590").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20586").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs6 = List[UInt](block2chunk1sub6("x20552").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20566").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs7 = List[UInt](block2chunk1sub6("x20539").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20565").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs8 = List[UInt](block2chunk1sub6("x20528").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20533").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs9 = List[UInt](block2chunk1sub7("x20594").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20584").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs10 = List[UInt](block2chunk1sub6("x20557").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20561").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs11 = List[UInt](block2chunk1sub6("x20546").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20527").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs12 = List[UInt](block2chunk1sub6("x20534").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20540").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs13 = List[UInt](block2chunk1sub7("x20581").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20571").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs14 = List[UInt](block2chunk1sub7("x20574").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20577").asInstanceOf[FixedPoint].r)
                val x9341_wr_ofs15 = List[UInt](block2chunk1sub6("x20549").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20543").asInstanceOf[FixedPoint].r)
                x9341_wr_ofs0 ++ x9341_wr_ofs1 ++ x9341_wr_ofs2 ++ x9341_wr_ofs3 ++ x9341_wr_ofs4 ++ x9341_wr_ofs5 ++ x9341_wr_ofs6 ++ x9341_wr_ofs7 ++ x9341_wr_ofs8 ++ x9341_wr_ofs9 ++ x9341_wr_ofs10 ++ x9341_wr_ofs11 ++ x9341_wr_ofs12 ++ x9341_wr_ofs13 ++ x9341_wr_ofs14 ++ x9341_wr_ofs15
              }
              val x9341_wr_ofs = create_x9341_wr_ofs()
              def create_x9341_wr_en(): List[Bool] = {
                val x9341_wr_en0 = List[Bool](block2chunk1sub6("x20555").asInstanceOf[Bool],block2chunk1sub7("x20568").asInstanceOf[Bool],block2chunk1sub7("x20585").asInstanceOf[Bool])
                val x9341_wr_en1 = List[Bool](block2chunk1sub6("x20535").asInstanceOf[Bool],block2chunk1sub7("x20576").asInstanceOf[Bool],block2chunk1sub7("x20572").asInstanceOf[Bool])
                val x9341_wr_en2 = List[Bool](block2chunk1sub6("x20554").asInstanceOf[Bool],block2chunk1sub6("x20529").asInstanceOf[Bool],block2chunk1sub7("x20593").asInstanceOf[Bool])
                val x9341_wr_en3 = List[Bool](block2chunk1sub7("x20575").asInstanceOf[Bool],block2chunk1sub7("x20567").asInstanceOf[Bool],block2chunk1sub6("x20547").asInstanceOf[Bool])
                val x9341_wr_en4 = List[Bool](block2chunk1sub7("x20569").asInstanceOf[Bool],block2chunk1sub7("x20591").asInstanceOf[Bool],block2chunk1sub6("x20544").asInstanceOf[Bool])
                val x9341_wr_en5 = List[Bool](block2chunk1sub7("x20562").asInstanceOf[Bool],block2chunk1sub7("x20573").asInstanceOf[Bool],block2chunk1sub7("x20582").asInstanceOf[Bool])
                val x9341_wr_en6 = List[Bool](block2chunk1sub6("x20537").asInstanceOf[Bool],block2chunk1sub6("x20558").asInstanceOf[Bool],block2chunk1sub6("x20560").asInstanceOf[Bool])
                val x9341_wr_en7 = List[Bool](block2chunk1sub6("x20545").asInstanceOf[Bool],block2chunk1sub6("x20530").asInstanceOf[Bool],block2chunk1sub7("x20583").asInstanceOf[Bool])
                val x9341_wr_en8 = List[Bool](block2chunk1sub7("x20579").asInstanceOf[Bool],block2chunk1sub6("x20559").asInstanceOf[Bool],block2chunk1sub6("x20550").asInstanceOf[Bool])
                val x9341_wr_en9 = List[Bool](block2chunk1sub7("x20595").asInstanceOf[Bool],block2chunk1sub6("x20553").asInstanceOf[Bool],block2chunk1sub7("x20580").asInstanceOf[Bool])
                val x9341_wr_en10 = List[Bool](block2chunk1sub7("x20588").asInstanceOf[Bool],block2chunk1sub6("x20538").asInstanceOf[Bool])
                x9341_wr_en0 ++ x9341_wr_en1 ++ x9341_wr_en2 ++ x9341_wr_en3 ++ x9341_wr_en4 ++ x9341_wr_en5 ++ x9341_wr_en6 ++ x9341_wr_en7 ++ x9341_wr_en8 ++ x9341_wr_en9 ++ x9341_wr_en10
              }
              val x9341_wr_en = create_x9341_wr_en()
              def create_x9341_wr_data(): List[UInt] = {
                val x9341_wr_data0 = List[UInt](block2chunk1sub5("x9309_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9310_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data1 = List[UInt](block2chunk1sub5("x9311_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9312_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data2 = List[UInt](block2chunk1sub5("x9313_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9314_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data3 = List[UInt](block2chunk1sub5("x9315_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9316_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data4 = List[UInt](block2chunk1sub5("x9317_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9318_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data5 = List[UInt](block2chunk1sub5("x9319_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9320_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data6 = List[UInt](block2chunk1sub5("x9321_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9322_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data7 = List[UInt](block2chunk1sub5("x9323_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9324_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data8 = List[UInt](block2chunk1sub5("x9325_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9326_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data9 = List[UInt](block2chunk1sub5("x9327_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9328_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data10 = List[UInt](block2chunk1sub5("x9329_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9330_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data11 = List[UInt](block2chunk1sub5("x9331_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9332_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data12 = List[UInt](block2chunk1sub5("x9333_sum").asInstanceOf[FixedPoint].r,block2chunk1sub6("x9334_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data13 = List[UInt](block2chunk1sub6("x9335_sum").asInstanceOf[FixedPoint].r,block2chunk1sub6("x9336_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data14 = List[UInt](block2chunk1sub6("x9337_sum").asInstanceOf[FixedPoint].r,block2chunk1sub6("x9338_sum").asInstanceOf[FixedPoint].r)
                val x9341_wr_data15 = List[UInt](block2chunk1sub6("x9339_sum").asInstanceOf[FixedPoint].r,block2chunk1sub6("x9340_sum").asInstanceOf[FixedPoint].r)
                x9341_wr_data0 ++ x9341_wr_data1 ++ x9341_wr_data2 ++ x9341_wr_data3 ++ x9341_wr_data4 ++ x9341_wr_data5 ++ x9341_wr_data6 ++ x9341_wr_data7 ++ x9341_wr_data8 ++ x9341_wr_data9 ++ x9341_wr_data10 ++ x9341_wr_data11 ++ x9341_wr_data12 ++ x9341_wr_data13 ++ x9341_wr_data14 ++ x9341_wr_data15
              }
              val x9341_wr_data = create_x9341_wr_data()
              x4062_out_SRAM_conv_1.connectWPort(9341, x9341_wr_banks, x9341_wr_ofs, x9341_wr_data, x9341_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(32.4.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && block2chunk1sub7("x20570").asInstanceOf[Bool] & block2chunk1sub6("x20542").asInstanceOf[Bool] & block2chunk1sub7("x20563").asInstanceOf[Bool] & block2chunk1sub7("x20589").asInstanceOf[Bool] & block2chunk1sub7("x20578").asInstanceOf[Bool]))
              Map[String,Any]()
            }
          }
          val block2chunk1sub8: Map[String, Any] = Block2Chunker1Sub8.gen()
          object Block2Chunker1Sub9 { // 1 nodes, 32 weight
            def gen(): Map[String, Any] = {
              def create_x9342_wr_banks(): List[UInt] = {
                val x9342_wr_banks0 = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r,4L.FP(true, 32, 0).r,5L.FP(true, 32, 0).r,6L.FP(true, 32, 0).r,7L.FP(true, 32, 0).r)
                val x9342_wr_banks1 = List[UInt](8L.FP(true, 32, 0).r,9L.FP(true, 32, 0).r,10L.FP(true, 32, 0).r,11L.FP(true, 32, 0).r,12L.FP(true, 32, 0).r,13L.FP(true, 32, 0).r,14L.FP(true, 32, 0).r,15L.FP(true, 32, 0).r)
                val x9342_wr_banks2 = List[UInt](16L.FP(true, 32, 0).r,17L.FP(true, 32, 0).r,18L.FP(true, 32, 0).r,19L.FP(true, 32, 0).r,20L.FP(true, 32, 0).r,21L.FP(true, 32, 0).r,22L.FP(true, 32, 0).r,23L.FP(true, 32, 0).r)
                val x9342_wr_banks3 = List[UInt](24L.FP(true, 32, 0).r,25L.FP(true, 32, 0).r,26L.FP(true, 32, 0).r,27L.FP(true, 32, 0).r,28L.FP(true, 32, 0).r,29L.FP(true, 32, 0).r,30L.FP(true, 32, 0).r,31L.FP(true, 32, 0).r)
                x9342_wr_banks0 ++ x9342_wr_banks1 ++ x9342_wr_banks2 ++ x9342_wr_banks3
              }
              val x9342_wr_banks = create_x9342_wr_banks()
              def create_x9342_wr_ofs(): List[UInt] = {
                val x9342_wr_ofs0 = List[UInt](block2chunk1sub7("x20587").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20531").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs1 = List[UInt](block2chunk1sub7("x20592").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20541").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs2 = List[UInt](block2chunk1sub6("x20556").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20551").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs3 = List[UInt](block2chunk1sub6("x20548").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20564").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs4 = List[UInt](block2chunk1sub6("x20536").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20532").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs5 = List[UInt](block2chunk1sub7("x20590").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20586").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs6 = List[UInt](block2chunk1sub6("x20552").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20566").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs7 = List[UInt](block2chunk1sub6("x20539").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20565").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs8 = List[UInt](block2chunk1sub6("x20528").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20533").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs9 = List[UInt](block2chunk1sub7("x20594").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20584").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs10 = List[UInt](block2chunk1sub6("x20557").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20561").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs11 = List[UInt](block2chunk1sub6("x20546").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20527").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs12 = List[UInt](block2chunk1sub6("x20534").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20540").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs13 = List[UInt](block2chunk1sub7("x20581").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20571").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs14 = List[UInt](block2chunk1sub7("x20574").asInstanceOf[FixedPoint].r,block2chunk1sub7("x20577").asInstanceOf[FixedPoint].r)
                val x9342_wr_ofs15 = List[UInt](block2chunk1sub6("x20549").asInstanceOf[FixedPoint].r,block2chunk1sub6("x20543").asInstanceOf[FixedPoint].r)
                x9342_wr_ofs0 ++ x9342_wr_ofs1 ++ x9342_wr_ofs2 ++ x9342_wr_ofs3 ++ x9342_wr_ofs4 ++ x9342_wr_ofs5 ++ x9342_wr_ofs6 ++ x9342_wr_ofs7 ++ x9342_wr_ofs8 ++ x9342_wr_ofs9 ++ x9342_wr_ofs10 ++ x9342_wr_ofs11 ++ x9342_wr_ofs12 ++ x9342_wr_ofs13 ++ x9342_wr_ofs14 ++ x9342_wr_ofs15
              }
              val x9342_wr_ofs = create_x9342_wr_ofs()
              def create_x9342_wr_en(): List[Bool] = {
                val x9342_wr_en0 = List[Bool](block2chunk1sub6("x20555").asInstanceOf[Bool],block2chunk1sub7("x20568").asInstanceOf[Bool],block2chunk1sub7("x20585").asInstanceOf[Bool])
                val x9342_wr_en1 = List[Bool](block2chunk1sub6("x20535").asInstanceOf[Bool],block2chunk1sub7("x20576").asInstanceOf[Bool],block2chunk1sub7("x20572").asInstanceOf[Bool])
                val x9342_wr_en2 = List[Bool](block2chunk1sub6("x20554").asInstanceOf[Bool],block2chunk1sub6("x20529").asInstanceOf[Bool],block2chunk1sub7("x20593").asInstanceOf[Bool])
                val x9342_wr_en3 = List[Bool](block2chunk1sub7("x20575").asInstanceOf[Bool],block2chunk1sub7("x20567").asInstanceOf[Bool],block2chunk1sub6("x20547").asInstanceOf[Bool])
                val x9342_wr_en4 = List[Bool](block2chunk1sub7("x20569").asInstanceOf[Bool],block2chunk1sub7("x20591").asInstanceOf[Bool],block2chunk1sub6("x20544").asInstanceOf[Bool])
                val x9342_wr_en5 = List[Bool](block2chunk1sub7("x20562").asInstanceOf[Bool],block2chunk1sub7("x20573").asInstanceOf[Bool],block2chunk1sub7("x20582").asInstanceOf[Bool])
                val x9342_wr_en6 = List[Bool](block2chunk1sub6("x20537").asInstanceOf[Bool],block2chunk1sub6("x20558").asInstanceOf[Bool],block2chunk1sub6("x20560").asInstanceOf[Bool])
                val x9342_wr_en7 = List[Bool](block2chunk1sub6("x20545").asInstanceOf[Bool],block2chunk1sub6("x20530").asInstanceOf[Bool],block2chunk1sub7("x20583").asInstanceOf[Bool])
                val x9342_wr_en8 = List[Bool](block2chunk1sub7("x20579").asInstanceOf[Bool],block2chunk1sub6("x20559").asInstanceOf[Bool],block2chunk1sub6("x20550").asInstanceOf[Bool])
                val x9342_wr_en9 = List[Bool](block2chunk1sub7("x20595").asInstanceOf[Bool],block2chunk1sub6("x20553").asInstanceOf[Bool],block2chunk1sub7("x20580").asInstanceOf[Bool])
                val x9342_wr_en10 = List[Bool](block2chunk1sub7("x20588").asInstanceOf[Bool],block2chunk1sub6("x20538").asInstanceOf[Bool])
                x9342_wr_en0 ++ x9342_wr_en1 ++ x9342_wr_en2 ++ x9342_wr_en3 ++ x9342_wr_en4 ++ x9342_wr_en5 ++ x9342_wr_en6 ++ x9342_wr_en7 ++ x9342_wr_en8 ++ x9342_wr_en9 ++ x9342_wr_en10
              }
              val x9342_wr_en = create_x9342_wr_en()
              def create_x9342_wr_data(): List[UInt] = {
                val x9342_wr_data0 = List[UInt](block2chunk1sub5("x9309_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9310_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data1 = List[UInt](block2chunk1sub5("x9311_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9312_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data2 = List[UInt](block2chunk1sub5("x9313_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9314_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data3 = List[UInt](block2chunk1sub5("x9315_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9316_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data4 = List[UInt](block2chunk1sub5("x9317_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9318_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data5 = List[UInt](block2chunk1sub5("x9319_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9320_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data6 = List[UInt](block2chunk1sub5("x9321_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9322_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data7 = List[UInt](block2chunk1sub5("x9323_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9324_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data8 = List[UInt](block2chunk1sub5("x9325_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9326_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data9 = List[UInt](block2chunk1sub5("x9327_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9328_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data10 = List[UInt](block2chunk1sub5("x9329_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9330_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data11 = List[UInt](block2chunk1sub5("x9331_sum").asInstanceOf[FixedPoint].r,block2chunk1sub5("x9332_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data12 = List[UInt](block2chunk1sub5("x9333_sum").asInstanceOf[FixedPoint].r,block2chunk1sub6("x9334_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data13 = List[UInt](block2chunk1sub6("x9335_sum").asInstanceOf[FixedPoint].r,block2chunk1sub6("x9336_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data14 = List[UInt](block2chunk1sub6("x9337_sum").asInstanceOf[FixedPoint].r,block2chunk1sub6("x9338_sum").asInstanceOf[FixedPoint].r)
                val x9342_wr_data15 = List[UInt](block2chunk1sub6("x9339_sum").asInstanceOf[FixedPoint].r,block2chunk1sub6("x9340_sum").asInstanceOf[FixedPoint].r)
                x9342_wr_data0 ++ x9342_wr_data1 ++ x9342_wr_data2 ++ x9342_wr_data3 ++ x9342_wr_data4 ++ x9342_wr_data5 ++ x9342_wr_data6 ++ x9342_wr_data7 ++ x9342_wr_data8 ++ x9342_wr_data9 ++ x9342_wr_data10 ++ x9342_wr_data11 ++ x9342_wr_data12 ++ x9342_wr_data13 ++ x9342_wr_data14 ++ x9342_wr_data15
              }
              val x9342_wr_data = create_x9342_wr_data()
              x4061_out_SRAM_conv_0.connectWPort(9342, x9342_wr_banks, x9342_wr_ofs, x9342_wr_data, x9342_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(32.4.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && block2chunk1sub7("x20570").asInstanceOf[Bool] & block2chunk1sub6("x20542").asInstanceOf[Bool] & block2chunk1sub7("x20563").asInstanceOf[Bool] & block2chunk1sub7("x20589").asInstanceOf[Bool] & block2chunk1sub7("x20578").asInstanceOf[Bool]))
              Map[String,Any]()
            }
          }
          val block2chunk1sub9: Map[String, Any] = Block2Chunker1Sub9.gen()
          Map[String,Any]()
        }
      }
      val block2chunk1: Map[String, Any] = Block2Chunker1.gen()
      x4241_weight_SRAM_reshape_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 3)
      x4322_img2D_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4323_img2D_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4324_img2D_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4325_img2D_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4326_img2D_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4327_img2D_5.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4328_img2D_6.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4329_img2D_7.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4330_img2D_8.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x9343_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x9343_inr_Foreach **/
