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

/** Hierarchy: x17704 -> x17705 -> x17710 -> x17711 -> x17712 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17704_inr_Foreach **/
class x17704_inr_Foreach_kernel(
  list_x17304_out_SRAM_bias_0: List[NBufInterface],
  list_x17554_reg: List[StandardInterface],
  list_x17551: List[DecoupledIO[AppStoreData]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 3.2.toInt, myName = "x17704_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17704_inr_Foreach_iiCtr"))
  
  abstract class x17704_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x17554_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17554_reg_p").asInstanceOf[MemParams] ))
      val in_x17551 = Decoupled(new AppStoreData(ModuleParams.getParams("x17551_p").asInstanceOf[(Int,Int)] ))
      val in_x17304_out_SRAM_bias_0 = Flipped(new NBufInterface(ModuleParams.getParams("x17304_out_SRAM_bias_0_p").asInstanceOf[NBufParams] ))
      val in_x17553_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17553_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(8), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x17554_reg = {io.in_x17554_reg} ; io.in_x17554_reg := DontCare
    def x17551 = {io.in_x17551} 
    def x17304_out_SRAM_bias_0 = {io.in_x17304_out_SRAM_bias_0} ; io.in_x17304_out_SRAM_bias_0 := DontCare
    def x17553_reg = {io.in_x17553_reg} ; io.in_x17553_reg := DontCare
  }
  def connectWires0(module: x17704_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x17554_reg.connectLedger(module.io.in_x17554_reg)
    module.io.in_x17551 <> x17551
    x17304_out_SRAM_bias_0.connectLedger(module.io.in_x17304_out_SRAM_bias_0)
    x17553_reg.connectLedger(module.io.in_x17553_reg)
  }
  val x17304_out_SRAM_bias_0 = list_x17304_out_SRAM_bias_0(0)
  val x17554_reg = list_x17554_reg(0)
  val x17553_reg = list_x17554_reg(1)
  val x17551 = list_x17551(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17704_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x17704_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17704_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b17590 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b17590.suggestName("b17590")
      val b17591 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b17591.suggestName("b17591")
      val b17592 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b17592.suggestName("b17592")
      val b17593 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b17593.suggestName("b17593")
      val b17594 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b17594.suggestName("b17594")
      val b17595 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b17595.suggestName("b17595")
      val b17596 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b17596.suggestName("b17596")
      val b17597 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b17597.suggestName("b17597")
      val b17598 = ~io.sigsIn.cchainOutputs.head.oobs(0); b17598.suggestName("b17598")
      val b17599 = ~io.sigsIn.cchainOutputs.head.oobs(1); b17599.suggestName("b17599")
      val b17600 = ~io.sigsIn.cchainOutputs.head.oobs(2); b17600.suggestName("b17600")
      val b17601 = ~io.sigsIn.cchainOutputs.head.oobs(3); b17601.suggestName("b17601")
      val b17602 = ~io.sigsIn.cchainOutputs.head.oobs(4); b17602.suggestName("b17602")
      val b17603 = ~io.sigsIn.cchainOutputs.head.oobs(5); b17603.suggestName("b17603")
      val b17604 = ~io.sigsIn.cchainOutputs.head.oobs(6); b17604.suggestName("b17604")
      val b17605 = ~io.sigsIn.cchainOutputs.head.oobs(7); b17605.suggestName("b17605")
      object Block4Chunker0 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x17606_rd_x17553 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17606_rd_x17553""")
          val x17606_rd_x17553_banks = List[UInt]()
          val x17606_rd_x17553_ofs = List[UInt]()
          val x17606_rd_x17553_en = List[Bool](true.B)
          x17606_rd_x17553.toSeq.zip(x17553_reg.connectRPort(17606, x17606_rd_x17553_banks, x17606_rd_x17553_ofs, io.sigsIn.backpressure, x17606_rd_x17553_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x17614 = Wire(Bool()).suggestName("""x17614""")
          val ensig0 = Wire(Bool())
          ensig0 := x17551.ready
          x17614.r := Math.lte(x17606_rd_x17553, b17590, Some(0.4), ensig0,"x17614").r
          val x17615 = Wire(Bool()).suggestName("""x17615""")
          x17615.r := Math.lte(x17606_rd_x17553, b17591, Some(0.4), ensig0,"x17615").r
          val x17616 = Wire(Bool()).suggestName("""x17616""")
          x17616.r := Math.lte(x17606_rd_x17553, b17592, Some(0.4), ensig0,"x17616").r
          val x17617 = Wire(Bool()).suggestName("""x17617""")
          x17617.r := Math.lte(x17606_rd_x17553, b17593, Some(0.4), ensig0,"x17617").r
          val x17618 = Wire(Bool()).suggestName("""x17618""")
          x17618.r := Math.lte(x17606_rd_x17553, b17594, Some(0.4), ensig0,"x17618").r
          val x17619 = Wire(Bool()).suggestName("""x17619""")
          x17619.r := Math.lte(x17606_rd_x17553, b17595, Some(0.4), ensig0,"x17619").r
          val x17620 = Wire(Bool()).suggestName("""x17620""")
          x17620.r := Math.lte(x17606_rd_x17553, b17596, Some(0.4), ensig0,"x17620").r
          val x17621 = Wire(Bool()).suggestName("""x17621""")
          x17621.r := Math.lte(x17606_rd_x17553, b17597, Some(0.4), ensig0,"x17621").r
          val x17622_rd_x17554 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17622_rd_x17554""")
          val x17622_rd_x17554_banks = List[UInt]()
          val x17622_rd_x17554_ofs = List[UInt]()
          val x17622_rd_x17554_en = List[Bool](true.B)
          x17622_rd_x17554.toSeq.zip(x17554_reg.connectRPort(17622, x17622_rd_x17554_banks, x17622_rd_x17554_ofs, io.sigsIn.backpressure, x17622_rd_x17554_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x17630 = Wire(Bool()).suggestName("""x17630""")
          x17630.r := Math.lt(b17590, x17622_rd_x17554, Some(0.4), ensig0,"x17630").r
          val x17631 = Wire(Bool()).suggestName("""x17631""")
          x17631.r := Math.lt(b17591, x17622_rd_x17554, Some(0.4), ensig0,"x17631").r
          val x17632 = Wire(Bool()).suggestName("""x17632""")
          x17632.r := Math.lt(b17592, x17622_rd_x17554, Some(0.4), ensig0,"x17632").r
          val x17633 = Wire(Bool()).suggestName("""x17633""")
          x17633.r := Math.lt(b17593, x17622_rd_x17554, Some(0.4), ensig0,"x17633").r
          val x17634 = Wire(Bool()).suggestName("""x17634""")
          x17634.r := Math.lt(b17594, x17622_rd_x17554, Some(0.4), ensig0,"x17634").r
          val x17635 = Wire(Bool()).suggestName("""x17635""")
          x17635.r := Math.lt(b17595, x17622_rd_x17554, Some(0.4), ensig0,"x17635").r
          val x17636 = Wire(Bool()).suggestName("""x17636""")
          x17636.r := Math.lt(b17596, x17622_rd_x17554, Some(0.4), ensig0,"x17636").r
          val x17637 = Wire(Bool()).suggestName("""x17637""")
          x17637.r := Math.lt(b17597, x17622_rd_x17554, Some(0.4), ensig0,"x17637").r
          val x17638 = Wire(Bool()).suggestName("""x17638""")
          x17638 := x17614 & x17630
          val x17639 = Wire(Bool()).suggestName("""x17639""")
          x17639 := x17615 & x17631
          val x17640 = Wire(Bool()).suggestName("""x17640""")
          x17640 := x17616 & x17632
          val x17641 = Wire(Bool()).suggestName("""x17641""")
          x17641 := x17617 & x17633
          val x17642 = Wire(Bool()).suggestName("""x17642""")
          x17642 := x17618 & x17634
          val x17643 = Wire(Bool()).suggestName("""x17643""")
          x17643 := x17619 & x17635
          val x17644 = Wire(Bool()).suggestName("""x17644""")
          x17644 := x17620 & x17636
          val x17645 = Wire(Bool()).suggestName("""x17645""")
          x17645 := x17621 & x17637
          val x17646_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17646_sub""")
          x17646_sub.r := Math.sub(b17590,x17606_rd_x17553,Some(1.0), ensig0, Truncate, Wrapping, "x17646_sub").r
          val x17647_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17647_sub""")
          x17647_sub.r := Math.sub(b17591,x17606_rd_x17553,Some(1.0), ensig0, Truncate, Wrapping, "x17647_sub").r
          val x17648_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17648_sub""")
          x17648_sub.r := Math.sub(b17592,x17606_rd_x17553,Some(1.0), ensig0, Truncate, Wrapping, "x17648_sub").r
          val x17649_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17649_sub""")
          x17649_sub.r := Math.sub(b17593,x17606_rd_x17553,Some(1.0), ensig0, Truncate, Wrapping, "x17649_sub").r
          val x17650_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17650_sub""")
          x17650_sub.r := Math.sub(b17594,x17606_rd_x17553,Some(1.0), ensig0, Truncate, Wrapping, "x17650_sub").r
          val x17651_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17651_sub""")
          x17651_sub.r := Math.sub(b17595,x17606_rd_x17553,Some(1.0), ensig0, Truncate, Wrapping, "x17651_sub").r
          val x17652_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17652_sub""")
          x17652_sub.r := Math.sub(b17596,x17606_rd_x17553,Some(1.0), ensig0, Truncate, Wrapping, "x17652_sub").r
          val x17653_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17653_sub""")
          x17653_sub.r := Math.sub(b17597,x17606_rd_x17553,Some(1.0), ensig0, Truncate, Wrapping, "x17653_sub").r
          val x19355 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19355""")
          x19355.r := Math.and(x17646_sub,7L.FP(true, 32, 0),Some(0.2), ensig0,"x19355").r
          val x19356 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19356""")
          x19356.r := Math.and(x17647_sub,7L.FP(true, 32, 0),Some(0.2), ensig0,"x19356").r
          val x19357 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19357""")
          x19357.r := Math.and(x17648_sub,7L.FP(true, 32, 0),Some(0.2), ensig0,"x19357").r
          val x19358 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19358""")
          x19358.r := Math.and(x17649_sub,7L.FP(true, 32, 0),Some(0.2), ensig0,"x19358").r
          val x19359 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19359""")
          x19359.r := Math.and(x17650_sub,7L.FP(true, 32, 0),Some(0.2), ensig0,"x19359").r
          val x19360 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19360""")
          x19360.r := Math.and(x17651_sub,7L.FP(true, 32, 0),Some(0.2), ensig0,"x19360").r
          val x19361 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19361""")
          x19361.r := Math.and(x17652_sub,7L.FP(true, 32, 0),Some(0.2), ensig0,"x19361").r
          val x19362 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19362""")
          x19362.r := Math.and(x17653_sub,7L.FP(true, 32, 0),Some(0.2), ensig0,"x19362").r
          val x17662 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17662""")
          x17662.r := Math.arith_right_shift(x17646_sub, 3, Some(0.2), ensig0,"x17662").r
          val x17665 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17665""")
          x17665.r := Math.arith_right_shift(x17647_sub, 3, Some(0.2), ensig0,"x17665").r
          val x17668 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17668""")
          x17668.r := Math.arith_right_shift(x17648_sub, 3, Some(0.2), ensig0,"x17668").r
          val x17671 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17671""")
          x17671.r := Math.arith_right_shift(x17649_sub, 3, Some(0.2), ensig0,"x17671").r
          val x17674 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17674""")
          x17674.r := Math.arith_right_shift(x17650_sub, 3, Some(0.2), ensig0,"x17674").r
          val x17677 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17677""")
          x17677.r := Math.arith_right_shift(x17651_sub, 3, Some(0.2), ensig0,"x17677").r
          val x17680 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17680""")
          x17680.r := Math.arith_right_shift(x17652_sub, 3, Some(0.2), ensig0,"x17680").r
          Map[String,Any]("x17638" -> x17638, "x17639" -> x17639, "x17640" -> x17640, "x17641" -> x17641, "x17642" -> x17642, "x17643" -> x17643, "x17644" -> x17644, "x17645" -> x17645, "x17653_sub" -> x17653_sub, "x19355" -> x19355, "x19356" -> x19356, "x19357" -> x19357, "x19358" -> x19358, "x19359" -> x19359, "x19360" -> x19360, "x19361" -> x19361, "x19362" -> x19362, "x17662" -> x17662, "x17665" -> x17665, "x17668" -> x17668, "x17671" -> x17671, "x17674" -> x17674, "x17677" -> x17677, "x17680" -> x17680)
        }
      }
      val block4chunk0: Map[String, Any] = Block4Chunker0.gen()
      object Block4Chunker1 { // 42 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x17683 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17683""")
          val ensig0 = Wire(Bool())
          ensig0 := x17551.ready
          x17683.r := Math.arith_right_shift(block4chunk0("x17653_sub").asInstanceOf[FixedPoint], 3, Some(0.2), ensig0,"x17683").r
          val x21823 = Wire(Bool()).suggestName("x21823_x17639_D1") 
          x21823.r := getRetimed(block4chunk0("x17639").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x21824 = Wire(Bool()).suggestName("x21824_x17641_D1") 
          x21824.r := getRetimed(block4chunk0("x17641").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x21825 = Wire(Bool()).suggestName("x21825_b17598_D1") 
          x21825.r := getRetimed(b17598.r, 1.toInt, io.sigsIn.backpressure)
          val x21826 = Wire(Bool()).suggestName("x21826_b17603_D1") 
          x21826.r := getRetimed(b17603.r, 1.toInt, io.sigsIn.backpressure)
          val x21827 = Wire(Bool()).suggestName("x21827_x17645_D1") 
          x21827.r := getRetimed(block4chunk0("x17645").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x21828 = Wire(Bool()).suggestName("x21828_b17601_D1") 
          x21828.r := getRetimed(b17601.r, 1.toInt, io.sigsIn.backpressure)
          val x21829 = Wire(Bool()).suggestName("x21829_x17642_D1") 
          x21829.r := getRetimed(block4chunk0("x17642").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x21830 = Wire(Bool()).suggestName("x21830_b17599_D1") 
          x21830.r := getRetimed(b17599.r, 1.toInt, io.sigsIn.backpressure)
          val x21831 = Wire(Bool()).suggestName("x21831_x17638_D1") 
          x21831.r := getRetimed(block4chunk0("x17638").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x21832 = Wire(Bool()).suggestName("x21832_b17605_D1") 
          x21832.r := getRetimed(b17605.r, 1.toInt, io.sigsIn.backpressure)
          val x21833 = Wire(Bool()).suggestName("x21833_x17643_D1") 
          x21833.r := getRetimed(block4chunk0("x17643").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x21834 = Wire(Bool()).suggestName("x21834_b17600_D1") 
          x21834.r := getRetimed(b17600.r, 1.toInt, io.sigsIn.backpressure)
          val x21835 = Wire(Bool()).suggestName("x21835_b17602_D1") 
          x21835.r := getRetimed(b17602.r, 1.toInt, io.sigsIn.backpressure)
          val x21836 = Wire(Bool()).suggestName("x21836_x17640_D1") 
          x21836.r := getRetimed(block4chunk0("x17640").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x21837 = Wire(Bool()).suggestName("x21837_x17644_D1") 
          x21837.r := getRetimed(block4chunk0("x17644").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x21838 = Wire(Bool()).suggestName("x21838_b17604_D1") 
          x21838.r := getRetimed(b17604.r, 1.toInt, io.sigsIn.backpressure)
          val x17686_rd = Wire(Vec(8, new FixedPoint(true, 10, 22))).suggestName("""x17686_rd""")
          def create_x17686_rd_banks(): List[UInt] = {
            val x17686_rd_banks0 = List[UInt](block4chunk0("x19355").asInstanceOf[FixedPoint].r,block4chunk0("x19356").asInstanceOf[FixedPoint].r,block4chunk0("x19357").asInstanceOf[FixedPoint].r,block4chunk0("x19358").asInstanceOf[FixedPoint].r)
            val x17686_rd_banks1 = List[UInt](block4chunk0("x19359").asInstanceOf[FixedPoint].r,block4chunk0("x19360").asInstanceOf[FixedPoint].r,block4chunk0("x19361").asInstanceOf[FixedPoint].r,block4chunk0("x19362").asInstanceOf[FixedPoint].r)
            x17686_rd_banks0 ++ x17686_rd_banks1
          }
          val x17686_rd_banks = create_x17686_rd_banks()
          def create_x17686_rd_ofs(): List[UInt] = {
            val x17686_rd_ofs0 = List[UInt](block4chunk0("x17662").asInstanceOf[FixedPoint].r,block4chunk0("x17665").asInstanceOf[FixedPoint].r,block4chunk0("x17668").asInstanceOf[FixedPoint].r,block4chunk0("x17671").asInstanceOf[FixedPoint].r)
            val x17686_rd_ofs1 = List[UInt](block4chunk0("x17674").asInstanceOf[FixedPoint].r,block4chunk0("x17677").asInstanceOf[FixedPoint].r,block4chunk0("x17680").asInstanceOf[FixedPoint].r,x17683.r)
            x17686_rd_ofs0 ++ x17686_rd_ofs1
          }
          val x17686_rd_ofs = create_x17686_rd_ofs()
          val x17686_rd_en = List[Bool](x21831 & x21825,x21823 & x21830,x21836 & x21834,x21824 & x21828,x21829 & x21835,x21833 & x21826,x21837 & x21838,x21827 & x21832)
          x17686_rd.toSeq.zip(x17304_out_SRAM_bias_0.connectRPort(17686, x17686_rd_banks, x17686_rd_ofs, io.sigsIn.backpressure, x17686_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x17687_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17687_elem_0""")
          x17687_elem_0.r := x17686_rd(0).r
          val x17688_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17688_elem_1""")
          x17688_elem_1.r := x17686_rd(1).r
          val x17689_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17689_elem_2""")
          x17689_elem_2.r := x17686_rd(2).r
          val x17690_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17690_elem_3""")
          x17690_elem_3.r := x17686_rd(3).r
          val x17691_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17691_elem_4""")
          x17691_elem_4.r := x17686_rd(4).r
          val x17692_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17692_elem_5""")
          x17692_elem_5.r := x17686_rd(5).r
          val x17693_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17693_elem_6""")
          x17693_elem_6.r := x17686_rd(6).r
          val x17694_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x17694_elem_7""")
          x17694_elem_7.r := x17686_rd(7).r
          val x21839 = Wire(Bool()).suggestName("x21839_x17638_D3") 
          x21839.r := getRetimed(block4chunk0("x17638").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x17695_tuple = Wire(UInt(33.W)).suggestName("""x17695_tuple""")
          x17695_tuple.r := Cat(x21839,x17687_elem_0.r)
          val x21840 = Wire(Bool()).suggestName("x21840_x17639_D3") 
          x21840.r := getRetimed(block4chunk0("x17639").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x17696_tuple = Wire(UInt(33.W)).suggestName("""x17696_tuple""")
          x17696_tuple.r := Cat(x21840,x17688_elem_1.r)
          val x21841 = Wire(Bool()).suggestName("x21841_x17640_D3") 
          x21841.r := getRetimed(block4chunk0("x17640").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x17697_tuple = Wire(UInt(33.W)).suggestName("""x17697_tuple""")
          x17697_tuple.r := Cat(x21841,x17689_elem_2.r)
          val x21842 = Wire(Bool()).suggestName("x21842_x17641_D3") 
          x21842.r := getRetimed(block4chunk0("x17641").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x17698_tuple = Wire(UInt(33.W)).suggestName("""x17698_tuple""")
          x17698_tuple.r := Cat(x21842,x17690_elem_3.r)
          val x21843 = Wire(Bool()).suggestName("x21843_x17642_D3") 
          x21843.r := getRetimed(block4chunk0("x17642").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x17699_tuple = Wire(UInt(33.W)).suggestName("""x17699_tuple""")
          x17699_tuple.r := Cat(x21843,x17691_elem_4.r)
          val x21844 = Wire(Bool()).suggestName("x21844_x17643_D3") 
          x21844.r := getRetimed(block4chunk0("x17643").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x17700_tuple = Wire(UInt(33.W)).suggestName("""x17700_tuple""")
          x17700_tuple.r := Cat(x21844,x17692_elem_5.r)
          val x21845 = Wire(Bool()).suggestName("x21845_x17644_D3") 
          x21845.r := getRetimed(block4chunk0("x17644").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x17701_tuple = Wire(UInt(33.W)).suggestName("""x17701_tuple""")
          x17701_tuple.r := Cat(x21845,x17693_elem_6.r)
          val x21846 = Wire(Bool()).suggestName("x21846_x17645_D3") 
          x21846.r := getRetimed(block4chunk0("x17645").asInstanceOf[Bool].r, 3.toInt, io.sigsIn.backpressure)
          val x17702_tuple = Wire(UInt(33.W)).suggestName("""x17702_tuple""")
          x17702_tuple.r := Cat(x21846,x17694_elem_7.r)
          Map[String,Any]("x17695_tuple" -> x17695_tuple, "x17696_tuple" -> x17696_tuple, "x17697_tuple" -> x17697_tuple, "x17698_tuple" -> x17698_tuple, "x17699_tuple" -> x17699_tuple, "x17700_tuple" -> x17700_tuple, "x17701_tuple" -> x17701_tuple, "x17702_tuple" -> x17702_tuple)
        }
      }
      val block4chunk1: Map[String, Any] = Block4Chunker1.gen()
      object Block4Chunker2 { // 9 nodes, 16 weight
        def gen(): Map[String, Any] = {
          val x21847 = Wire(Bool()).suggestName("x21847_b17598_D3") 
          x21847.r := getRetimed(b17598.r, 3.toInt, io.sigsIn.backpressure)
          val x21848 = Wire(Bool()).suggestName("x21848_b17603_D3") 
          x21848.r := getRetimed(b17603.r, 3.toInt, io.sigsIn.backpressure)
          val x21849 = Wire(Bool()).suggestName("x21849_b17601_D3") 
          x21849.r := getRetimed(b17601.r, 3.toInt, io.sigsIn.backpressure)
          val x21850 = Wire(Bool()).suggestName("x21850_b17599_D3") 
          x21850.r := getRetimed(b17599.r, 3.toInt, io.sigsIn.backpressure)
          val x21851 = Wire(Bool()).suggestName("x21851_b17605_D3") 
          x21851.r := getRetimed(b17605.r, 3.toInt, io.sigsIn.backpressure)
          val x21852 = Wire(Bool()).suggestName("x21852_b17600_D3") 
          x21852.r := getRetimed(b17600.r, 3.toInt, io.sigsIn.backpressure)
          val x21853 = Wire(Bool()).suggestName("x21853_b17602_D3") 
          x21853.r := getRetimed(b17602.r, 3.toInt, io.sigsIn.backpressure)
          val x21854 = Wire(Bool()).suggestName("x21854_b17604_D3") 
          x21854.r := getRetimed(b17604.r, 3.toInt, io.sigsIn.backpressure)
          x17551.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21847 & io.sigsIn.backpressure
          x17551.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21850 & io.sigsIn.backpressure
          x17551.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21852 & io.sigsIn.backpressure
          x17551.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21849 & io.sigsIn.backpressure
          x17551.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21853 & io.sigsIn.backpressure
          x17551.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21848 & io.sigsIn.backpressure
          x17551.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21854 & io.sigsIn.backpressure
          x17551.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21851 & io.sigsIn.backpressure
          x17551.bits.wdata(0) := block4chunk1("x17695_tuple").asInstanceOf[UInt](31,0)
          x17551.bits.wdata(1) := block4chunk1("x17696_tuple").asInstanceOf[UInt](31,0)
          x17551.bits.wdata(2) := block4chunk1("x17697_tuple").asInstanceOf[UInt](31,0)
          x17551.bits.wdata(3) := block4chunk1("x17698_tuple").asInstanceOf[UInt](31,0)
          x17551.bits.wdata(4) := block4chunk1("x17699_tuple").asInstanceOf[UInt](31,0)
          x17551.bits.wdata(5) := block4chunk1("x17700_tuple").asInstanceOf[UInt](31,0)
          x17551.bits.wdata(6) := block4chunk1("x17701_tuple").asInstanceOf[UInt](31,0)
          x17551.bits.wdata(7) := block4chunk1("x17702_tuple").asInstanceOf[UInt](31,0)
          x17551.bits.wstrb := List(block4chunk1("x17695_tuple").asInstanceOf[UInt], block4chunk1("x17696_tuple").asInstanceOf[UInt], block4chunk1("x17697_tuple").asInstanceOf[UInt], block4chunk1("x17698_tuple").asInstanceOf[UInt], block4chunk1("x17699_tuple").asInstanceOf[UInt], block4chunk1("x17700_tuple").asInstanceOf[UInt], block4chunk1("x17701_tuple").asInstanceOf[UInt], block4chunk1("x17702_tuple").asInstanceOf[UInt]).map{_(32,32)}.reduce(Cat(_,_))
          Map[String,Any]()
        }
      }
      val block4chunk2: Map[String, Any] = Block4Chunker2.gen()
    }
    val module = Module(new x17704_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x17704_inr_Foreach **/
