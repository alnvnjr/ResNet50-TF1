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

/** Hierarchy: x9764 -> x9765 -> x9766 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9764_inr_Foreach **/
class x9764_inr_Foreach_kernel(
  list_b9591: List[FixedPoint],
  list_x9595: List[DecoupledIO[AppLoadData]],
  list_x9583_weight_SRAM_0: List[NBufInterface],
  list_x9626_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 3.2.toInt, myName = "x9764_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9764_inr_Foreach_iiCtr"))
  
  abstract class x9764_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9626_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9626_reg_p").asInstanceOf[MemParams] ))
      val in_x9627_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9627_reg_p").asInstanceOf[MemParams] ))
      val in_x9595 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9595_p").asInstanceOf[(Int, Int)] )))
      val in_b9591 = Input(new FixedPoint(true, 32, 0))
      val in_x9583_weight_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9583_weight_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(8), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9626_reg = {io.in_x9626_reg} ; io.in_x9626_reg := DontCare
    def x9627_reg = {io.in_x9627_reg} ; io.in_x9627_reg := DontCare
    def x9595 = {io.in_x9595} 
    def b9591 = {io.in_b9591} 
    def x9583_weight_SRAM_0 = {io.in_x9583_weight_SRAM_0} ; io.in_x9583_weight_SRAM_0 := DontCare
  }
  def connectWires0(module: x9764_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x9626_reg.connectLedger(module.io.in_x9626_reg)
    x9627_reg.connectLedger(module.io.in_x9627_reg)
    module.io.in_x9595 <> x9595
    module.io.in_b9591 <> b9591
    x9583_weight_SRAM_0.connectLedger(module.io.in_x9583_weight_SRAM_0)
  }
  val b9591 = list_b9591(0)
  val x9595 = list_x9595(0)
  val x9583_weight_SRAM_0 = list_x9583_weight_SRAM_0(0)
  val x9626_reg = list_x9626_reg(0)
  val x9627_reg = list_x9626_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9764_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x9764_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9764_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b9641 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b9641.suggestName("b9641")
      val b9642 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b9642.suggestName("b9642")
      val b9643 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b9643.suggestName("b9643")
      val b9644 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b9644.suggestName("b9644")
      val b9645 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b9645.suggestName("b9645")
      val b9646 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b9646.suggestName("b9646")
      val b9647 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b9647.suggestName("b9647")
      val b9648 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b9648.suggestName("b9648")
      val b9649 = ~io.sigsIn.cchainOutputs.head.oobs(0); b9649.suggestName("b9649")
      val b9650 = ~io.sigsIn.cchainOutputs.head.oobs(1); b9650.suggestName("b9650")
      val b9651 = ~io.sigsIn.cchainOutputs.head.oobs(2); b9651.suggestName("b9651")
      val b9652 = ~io.sigsIn.cchainOutputs.head.oobs(3); b9652.suggestName("b9652")
      val b9653 = ~io.sigsIn.cchainOutputs.head.oobs(4); b9653.suggestName("b9653")
      val b9654 = ~io.sigsIn.cchainOutputs.head.oobs(5); b9654.suggestName("b9654")
      val b9655 = ~io.sigsIn.cchainOutputs.head.oobs(6); b9655.suggestName("b9655")
      val b9656 = ~io.sigsIn.cchainOutputs.head.oobs(7); b9656.suggestName("b9656")
      object Block2Chunker0 { // 42 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x9657_rd_x9626 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9657_rd_x9626""")
          val x9657_rd_x9626_banks = List[UInt]()
          val x9657_rd_x9626_ofs = List[UInt]()
          val x9657_rd_x9626_en = List[Bool](true.B)
          x9657_rd_x9626.toSeq.zip(x9626_reg.connectRPort(9657, x9657_rd_x9626_banks, x9657_rd_x9626_ofs, io.sigsIn.backpressure, x9657_rd_x9626_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x9665 = Wire(Bool()).suggestName("""x9665""")
          x9665.r := Math.lte(x9657_rd_x9626, b9641, Some(0.4), true.B,"x9665").r
          val x9666 = Wire(Bool()).suggestName("""x9666""")
          x9666.r := Math.lte(x9657_rd_x9626, b9642, Some(0.4), true.B,"x9666").r
          val x9667 = Wire(Bool()).suggestName("""x9667""")
          x9667.r := Math.lte(x9657_rd_x9626, b9643, Some(0.4), true.B,"x9667").r
          val x9668 = Wire(Bool()).suggestName("""x9668""")
          x9668.r := Math.lte(x9657_rd_x9626, b9644, Some(0.4), true.B,"x9668").r
          val x9669 = Wire(Bool()).suggestName("""x9669""")
          x9669.r := Math.lte(x9657_rd_x9626, b9645, Some(0.4), true.B,"x9669").r
          val x9670 = Wire(Bool()).suggestName("""x9670""")
          x9670.r := Math.lte(x9657_rd_x9626, b9646, Some(0.4), true.B,"x9670").r
          val x9671 = Wire(Bool()).suggestName("""x9671""")
          x9671.r := Math.lte(x9657_rd_x9626, b9647, Some(0.4), true.B,"x9671").r
          val x9672 = Wire(Bool()).suggestName("""x9672""")
          x9672.r := Math.lte(x9657_rd_x9626, b9648, Some(0.4), true.B,"x9672").r
          val x9673_rd_x9627 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9673_rd_x9627""")
          val x9673_rd_x9627_banks = List[UInt]()
          val x9673_rd_x9627_ofs = List[UInt]()
          val x9673_rd_x9627_en = List[Bool](true.B)
          x9673_rd_x9627.toSeq.zip(x9627_reg.connectRPort(9673, x9673_rd_x9627_banks, x9673_rd_x9627_ofs, io.sigsIn.backpressure, x9673_rd_x9627_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x9681 = Wire(Bool()).suggestName("""x9681""")
          x9681.r := Math.lt(b9641, x9673_rd_x9627, Some(0.4), true.B,"x9681").r
          val x9682 = Wire(Bool()).suggestName("""x9682""")
          x9682.r := Math.lt(b9642, x9673_rd_x9627, Some(0.4), true.B,"x9682").r
          val x9683 = Wire(Bool()).suggestName("""x9683""")
          x9683.r := Math.lt(b9643, x9673_rd_x9627, Some(0.4), true.B,"x9683").r
          val x9684 = Wire(Bool()).suggestName("""x9684""")
          x9684.r := Math.lt(b9644, x9673_rd_x9627, Some(0.4), true.B,"x9684").r
          val x9685 = Wire(Bool()).suggestName("""x9685""")
          x9685.r := Math.lt(b9645, x9673_rd_x9627, Some(0.4), true.B,"x9685").r
          val x9686 = Wire(Bool()).suggestName("""x9686""")
          x9686.r := Math.lt(b9646, x9673_rd_x9627, Some(0.4), true.B,"x9686").r
          val x9687 = Wire(Bool()).suggestName("""x9687""")
          x9687.r := Math.lt(b9647, x9673_rd_x9627, Some(0.4), true.B,"x9687").r
          val x9688 = Wire(Bool()).suggestName("""x9688""")
          x9688.r := Math.lt(b9648, x9673_rd_x9627, Some(0.4), true.B,"x9688").r
          val x9689 = Wire(Bool()).suggestName("""x9689""")
          x9689 := x9665 & x9681
          val x9690 = Wire(Bool()).suggestName("""x9690""")
          x9690 := x9666 & x9682
          val x9691 = Wire(Bool()).suggestName("""x9691""")
          x9691 := x9667 & x9683
          val x9692 = Wire(Bool()).suggestName("""x9692""")
          x9692 := x9668 & x9684
          val x9693 = Wire(Bool()).suggestName("""x9693""")
          x9693 := x9669 & x9685
          val x9694 = Wire(Bool()).suggestName("""x9694""")
          x9694 := x9670 & x9686
          val x9695 = Wire(Bool()).suggestName("""x9695""")
          x9695 := x9671 & x9687
          val x9696 = Wire(Bool()).suggestName("""x9696""")
          x9696 := x9672 & x9688
          val x9697_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9697_sub""")
          x9697_sub.r := Math.sub(b9641,x9657_rd_x9626,Some(1.0), true.B, Truncate, Wrapping, "x9697_sub").r
          val x9698_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9698_sub""")
          x9698_sub.r := Math.sub(b9642,x9657_rd_x9626,Some(1.0), true.B, Truncate, Wrapping, "x9698_sub").r
          val x9699_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9699_sub""")
          x9699_sub.r := Math.sub(b9643,x9657_rd_x9626,Some(1.0), true.B, Truncate, Wrapping, "x9699_sub").r
          val x9700_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9700_sub""")
          x9700_sub.r := Math.sub(b9644,x9657_rd_x9626,Some(1.0), true.B, Truncate, Wrapping, "x9700_sub").r
          val x9701_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9701_sub""")
          x9701_sub.r := Math.sub(b9645,x9657_rd_x9626,Some(1.0), true.B, Truncate, Wrapping, "x9701_sub").r
          val x9702_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9702_sub""")
          x9702_sub.r := Math.sub(b9646,x9657_rd_x9626,Some(1.0), true.B, Truncate, Wrapping, "x9702_sub").r
          val x9703_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9703_sub""")
          x9703_sub.r := Math.sub(b9647,x9657_rd_x9626,Some(1.0), true.B, Truncate, Wrapping, "x9703_sub").r
          val x9704_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9704_sub""")
          x9704_sub.r := Math.sub(b9648,x9657_rd_x9626,Some(1.0), true.B, Truncate, Wrapping, "x9704_sub").r
          val x9705 = Wire(Vec(8, new FixedPoint(true, 10, 22))).suggestName("""x9705""")
          x9595.ready := b9654 & b9650 & b9655 & b9656 & b9649 & b9652 & b9653 & b9651 & (io.sigsIn.datapathEn) 
          (0 until 8).map{ i => x9705(i).r := x9595.bits.rdata(i).r }
          val x20660 = Wire(Vec(8, new FixedPoint(true, 10, 22))).suggestName("x20660_x9705_D1") 
          (0 until 8).foreach{i => x20660(i).r := getRetimed(x9705(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x9706_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9706_elem_0""")
          x9706_elem_0.r := x20660(0).r
          val x9707_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9707_elem_1""")
          x9707_elem_1.r := x20660(1).r
          val x9708_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9708_elem_2""")
          x9708_elem_2.r := x20660(2).r
          val x9709_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9709_elem_3""")
          x9709_elem_3.r := x20660(3).r
          val x9710_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9710_elem_4""")
          x9710_elem_4.r := x20660(4).r
          val x9711_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9711_elem_5""")
          x9711_elem_5.r := x20660(5).r
          Map[String,Any]("x9689" -> x9689, "x9690" -> x9690, "x9691" -> x9691, "x9692" -> x9692, "x9693" -> x9693, "x9694" -> x9694, "x9695" -> x9695, "x9696" -> x9696, "x9697_sub" -> x9697_sub, "x9698_sub" -> x9698_sub, "x9699_sub" -> x9699_sub, "x9700_sub" -> x9700_sub, "x9701_sub" -> x9701_sub, "x9702_sub" -> x9702_sub, "x9703_sub" -> x9703_sub, "x9704_sub" -> x9704_sub, "x20660" -> x20660, "x9706_elem_0" -> x9706_elem_0, "x9707_elem_1" -> x9707_elem_1, "x9708_elem_2" -> x9708_elem_2, "x9709_elem_3" -> x9709_elem_3, "x9710_elem_4" -> x9710_elem_4, "x9711_elem_5" -> x9711_elem_5)
        }
      }
      val block2chunk0: Map[String, Any] = Block2Chunker0.gen()
      object Block2Chunker1 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x9712_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9712_elem_6""")
          x9712_elem_6.r := block2chunk0("x20660").asInstanceOf[Vec[FixedPoint]](6).r
          val x9713_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9713_elem_7""")
          x9713_elem_7.r := block2chunk0("x20660").asInstanceOf[Vec[FixedPoint]](7).r
          val x20661 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20661_b9591_D1") 
          x20661.r := getRetimed(b9591.r, 1.toInt, io.sigsIn.backpressure)
          val x9714_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9714_sum""")
          x9714_sum.r := Math.add(x20661,block2chunk0("x9697_sub").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9714_sum").r
          val x19061 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19061""")
          x19061.r := Math.and(x9714_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19061").r
          val x9716_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9716_sum""")
          x9716_sum.r := Math.add(x20661,block2chunk0("x9698_sub").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9716_sum").r
          val x19062 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19062""")
          x19062.r := Math.and(x9716_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19062").r
          val x9718_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9718_sum""")
          x9718_sum.r := Math.add(x20661,block2chunk0("x9699_sub").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9718_sum").r
          val x19063 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19063""")
          x19063.r := Math.and(x9718_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19063").r
          val x9720_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9720_sum""")
          x9720_sum.r := Math.add(x20661,block2chunk0("x9700_sub").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9720_sum").r
          val x19064 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19064""")
          x19064.r := Math.and(x9720_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19064").r
          val x9722_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9722_sum""")
          x9722_sum.r := Math.add(x20661,block2chunk0("x9701_sub").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9722_sum").r
          val x19065 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19065""")
          x19065.r := Math.and(x9722_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19065").r
          val x9724_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9724_sum""")
          x9724_sum.r := Math.add(x20661,block2chunk0("x9702_sub").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9724_sum").r
          val x19066 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19066""")
          x19066.r := Math.and(x9724_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19066").r
          val x9726_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9726_sum""")
          x9726_sum.r := Math.add(x20661,block2chunk0("x9703_sub").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9726_sum").r
          val x19067 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19067""")
          x19067.r := Math.and(x9726_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19067").r
          val x9728_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9728_sum""")
          x9728_sum.r := Math.add(x20661,block2chunk0("x9704_sub").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x9728_sum").r
          val x19068 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19068""")
          x19068.r := Math.and(x9728_sum,7L.FP(true, 32, 0),Some(0.2), true.B,"x19068").r
          val x9730 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9730""")
          x9730.r := Math.arith_left_shift(b9591, 8, Some(0.2), true.B,"x9730").r
          val x9731 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9731""")
          x9731.r := Math.arith_right_shift(block2chunk0("x9697_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x9731").r
          val x20662 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20662_x9730_D1") 
          x20662.r := getRetimed(x9730.r, 1.toInt, io.sigsIn.backpressure)
          val x9732_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9732_sum""")
          x9732_sum.r := Math.add(x20662,x9731,Some(1.0), true.B, Truncate, Wrapping, "x9732_sum").r
          val x9735 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9735""")
          x9735.r := Math.arith_right_shift(block2chunk0("x9698_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x9735").r
          val x9736_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9736_sum""")
          x9736_sum.r := Math.add(x20662,x9735,Some(1.0), true.B, Truncate, Wrapping, "x9736_sum").r
          val x9739 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9739""")
          x9739.r := Math.arith_right_shift(block2chunk0("x9699_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x9739").r
          val x9740_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9740_sum""")
          x9740_sum.r := Math.add(x20662,x9739,Some(1.0), true.B, Truncate, Wrapping, "x9740_sum").r
          val x9743 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9743""")
          x9743.r := Math.arith_right_shift(block2chunk0("x9700_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x9743").r
          val x9744_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9744_sum""")
          x9744_sum.r := Math.add(x20662,x9743,Some(1.0), true.B, Truncate, Wrapping, "x9744_sum").r
          val x9747 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9747""")
          x9747.r := Math.arith_right_shift(block2chunk0("x9701_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x9747").r
          val x9748_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9748_sum""")
          x9748_sum.r := Math.add(x20662,x9747,Some(1.0), true.B, Truncate, Wrapping, "x9748_sum").r
          val x9751 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9751""")
          x9751.r := Math.arith_right_shift(block2chunk0("x9702_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x9751").r
          val x9752_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9752_sum""")
          x9752_sum.r := Math.add(x20662,x9751,Some(1.0), true.B, Truncate, Wrapping, "x9752_sum").r
          val x9755 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9755""")
          x9755.r := Math.arith_right_shift(block2chunk0("x9703_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x9755").r
          val x9756_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9756_sum""")
          x9756_sum.r := Math.add(x20662,x9755,Some(1.0), true.B, Truncate, Wrapping, "x9756_sum").r
          val x9759 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9759""")
          x9759.r := Math.arith_right_shift(block2chunk0("x9704_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x9759").r
          val x9760_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9760_sum""")
          x9760_sum.r := Math.add(x20662,x9759,Some(1.0), true.B, Truncate, Wrapping, "x9760_sum").r
          val x20663 = Wire(Bool()).suggestName("x20663_b9653_D2") 
          x20663.r := getRetimed(b9653.r, 2.toInt, io.sigsIn.backpressure)
          val x20664 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20664_x9708_elem_2_D1") 
          x20664.r := getRetimed(block2chunk0("x9708_elem_2").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20665 = Wire(Bool()).suggestName("x20665_x9693_D2") 
          x20665.r := getRetimed(block2chunk0("x9693").asInstanceOf[Bool].r, 2.toInt, io.sigsIn.backpressure)
          val x20666 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20666_x9712_elem_6_D1") 
          x20666.r := getRetimed(x9712_elem_6.r, 1.toInt, io.sigsIn.backpressure)
          val x20667 = Wire(Bool()).suggestName("x20667_x9694_D2") 
          x20667.r := getRetimed(block2chunk0("x9694").asInstanceOf[Bool].r, 2.toInt, io.sigsIn.backpressure)
          val x20668 = Wire(Bool()).suggestName("x20668_x9689_D2") 
          x20668.r := getRetimed(block2chunk0("x9689").asInstanceOf[Bool].r, 2.toInt, io.sigsIn.backpressure)
          val x20669 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20669_x9709_elem_3_D1") 
          x20669.r := getRetimed(block2chunk0("x9709_elem_3").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20670 = Wire(Bool()).suggestName("x20670_b9650_D2") 
          x20670.r := getRetimed(b9650.r, 2.toInt, io.sigsIn.backpressure)
          val x20671 = Wire(Bool()).suggestName("x20671_b9652_D2") 
          x20671.r := getRetimed(b9652.r, 2.toInt, io.sigsIn.backpressure)
          val x20672 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20672_x9706_elem_0_D1") 
          x20672.r := getRetimed(block2chunk0("x9706_elem_0").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20673 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20673_x9713_elem_7_D1") 
          x20673.r := getRetimed(x9713_elem_7.r, 1.toInt, io.sigsIn.backpressure)
          val x20674 = Wire(Bool()).suggestName("x20674_b9655_D2") 
          x20674.r := getRetimed(b9655.r, 2.toInt, io.sigsIn.backpressure)
          Map[String,Any]("x19061" -> x19061, "x19062" -> x19062, "x19063" -> x19063, "x19064" -> x19064, "x19065" -> x19065, "x19066" -> x19066, "x19067" -> x19067, "x19068" -> x19068, "x9732_sum" -> x9732_sum, "x9736_sum" -> x9736_sum, "x9740_sum" -> x9740_sum, "x9744_sum" -> x9744_sum, "x9748_sum" -> x9748_sum, "x9752_sum" -> x9752_sum, "x9756_sum" -> x9756_sum, "x9760_sum" -> x9760_sum, "x20663" -> x20663, "x20664" -> x20664, "x20665" -> x20665, "x20666" -> x20666, "x20667" -> x20667, "x20668" -> x20668, "x20669" -> x20669, "x20670" -> x20670, "x20671" -> x20671, "x20672" -> x20672, "x20673" -> x20673, "x20674" -> x20674)
        }
      }
      val block2chunk1: Map[String, Any] = Block2Chunker1.gen()
      object Block2Chunker2 { // 13 nodes, 20 weight
        def gen(): Map[String, Any] = {
          val x20675 = Wire(Bool()).suggestName("x20675_x9691_D2") 
          x20675.r := getRetimed(block2chunk0("x9691").asInstanceOf[Bool].r, 2.toInt, io.sigsIn.backpressure)
          val x20676 = Wire(Bool()).suggestName("x20676_b9651_D2") 
          x20676.r := getRetimed(b9651.r, 2.toInt, io.sigsIn.backpressure)
          val x20677 = Wire(Bool()).suggestName("x20677_x9695_D2") 
          x20677.r := getRetimed(block2chunk0("x9695").asInstanceOf[Bool].r, 2.toInt, io.sigsIn.backpressure)
          val x20678 = Wire(Bool()).suggestName("x20678_b9656_D2") 
          x20678.r := getRetimed(b9656.r, 2.toInt, io.sigsIn.backpressure)
          val x20679 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20679_x9710_elem_4_D1") 
          x20679.r := getRetimed(block2chunk0("x9710_elem_4").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20680 = Wire(Bool()).suggestName("x20680_b9649_D2") 
          x20680.r := getRetimed(b9649.r, 2.toInt, io.sigsIn.backpressure)
          val x20681 = Wire(Bool()).suggestName("x20681_x9690_D2") 
          x20681.r := getRetimed(block2chunk0("x9690").asInstanceOf[Bool].r, 2.toInt, io.sigsIn.backpressure)
          val x20682 = Wire(Bool()).suggestName("x20682_b9654_D2") 
          x20682.r := getRetimed(b9654.r, 2.toInt, io.sigsIn.backpressure)
          val x20683 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20683_x9707_elem_1_D1") 
          x20683.r := getRetimed(block2chunk0("x9707_elem_1").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20684 = Wire(Bool()).suggestName("x20684_x9692_D2") 
          x20684.r := getRetimed(block2chunk0("x9692").asInstanceOf[Bool].r, 2.toInt, io.sigsIn.backpressure)
          val x20685 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20685_x9711_elem_5_D1") 
          x20685.r := getRetimed(block2chunk0("x9711_elem_5").asInstanceOf[FixedPoint].r, 1.toInt, io.sigsIn.backpressure)
          val x20686 = Wire(Bool()).suggestName("x20686_x9696_D2") 
          x20686.r := getRetimed(block2chunk0("x9696").asInstanceOf[Bool].r, 2.toInt, io.sigsIn.backpressure)
          def create_x9763_wr_banks(): List[UInt] = {
            val x9763_wr_banks0 = List[UInt](block2chunk1("x19061").asInstanceOf[FixedPoint].r,block2chunk1("x19062").asInstanceOf[FixedPoint].r,block2chunk1("x19063").asInstanceOf[FixedPoint].r,block2chunk1("x19064").asInstanceOf[FixedPoint].r)
            val x9763_wr_banks1 = List[UInt](block2chunk1("x19065").asInstanceOf[FixedPoint].r,block2chunk1("x19066").asInstanceOf[FixedPoint].r,block2chunk1("x19067").asInstanceOf[FixedPoint].r,block2chunk1("x19068").asInstanceOf[FixedPoint].r)
            x9763_wr_banks0 ++ x9763_wr_banks1
          }
          val x9763_wr_banks = create_x9763_wr_banks()
          def create_x9763_wr_ofs(): List[UInt] = {
            val x9763_wr_ofs0 = List[UInt](block2chunk1("x9732_sum").asInstanceOf[FixedPoint].r,block2chunk1("x9736_sum").asInstanceOf[FixedPoint].r,block2chunk1("x9740_sum").asInstanceOf[FixedPoint].r,block2chunk1("x9744_sum").asInstanceOf[FixedPoint].r)
            val x9763_wr_ofs1 = List[UInt](block2chunk1("x9748_sum").asInstanceOf[FixedPoint].r,block2chunk1("x9752_sum").asInstanceOf[FixedPoint].r,block2chunk1("x9756_sum").asInstanceOf[FixedPoint].r,block2chunk1("x9760_sum").asInstanceOf[FixedPoint].r)
            x9763_wr_ofs0 ++ x9763_wr_ofs1
          }
          val x9763_wr_ofs = create_x9763_wr_ofs()
          def create_x9763_wr_en(): List[Bool] = {
            val x9763_wr_en0 = List[Bool](block2chunk1("x20668").asInstanceOf[Bool] & x20680,x20681 & block2chunk1("x20670").asInstanceOf[Bool],x20675 & x20676,x20684 & block2chunk1("x20671").asInstanceOf[Bool])
            val x9763_wr_en1 = List[Bool](block2chunk1("x20665").asInstanceOf[Bool] & block2chunk1("x20663").asInstanceOf[Bool],block2chunk1("x20667").asInstanceOf[Bool] & x20682,x20677 & block2chunk1("x20674").asInstanceOf[Bool],x20686 & x20678)
            x9763_wr_en0 ++ x9763_wr_en1
          }
          val x9763_wr_en = create_x9763_wr_en()
          def create_x9763_wr_data(): List[UInt] = {
            val x9763_wr_data0 = List[UInt](block2chunk1("x20672").asInstanceOf[FixedPoint].r,x20683.r,block2chunk1("x20664").asInstanceOf[FixedPoint].r,block2chunk1("x20669").asInstanceOf[FixedPoint].r,x20679.r,x20685.r,block2chunk1("x20666").asInstanceOf[FixedPoint].r,block2chunk1("x20673").asInstanceOf[FixedPoint].r)
            x9763_wr_data0
          }
          val x9763_wr_data = create_x9763_wr_data()
          x9583_weight_SRAM_0.connectWPort(9763, x9763_wr_banks, x9763_wr_ofs, x9763_wr_data, x9763_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]()
        }
      }
      val block2chunk2: Map[String, Any] = Block2Chunker2.gen()
    }
    val module = Module(new x9764_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x9764_inr_Foreach **/
