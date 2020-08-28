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

/** Hierarchy: x4321 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4321_inr_Foreach **/
class x4321_inr_Foreach_kernel(
  list_x18774_rd_x3918: List[Bool],
  list_x4069_weight_SRAM_0: List[NBufInterface],
  list_x3919_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 22.0.toInt, myName = "x4321_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4321_inr_Foreach_iiCtr"))
  
  abstract class x4321_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3919_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3919_reg_p").asInstanceOf[MemParams] ))
      val in_x18774_rd_x3918 = Input(Bool())
      val in_b4068 = Input(Bool())
      val in_x4069_weight_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4069_weight_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_b4060 = Input(Bool())
      val in_x4241_weight_SRAM_reshape_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4241_weight_SRAM_reshape_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1, 4), List(32, 32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3919_reg = {io.in_x3919_reg} ; io.in_x3919_reg := DontCare
    def x18774_rd_x3918 = {io.in_x18774_rd_x3918} 
    def b4068 = {io.in_b4068} 
    def x4069_weight_SRAM_0 = {io.in_x4069_weight_SRAM_0} ; io.in_x4069_weight_SRAM_0 := DontCare
    def b4060 = {io.in_b4060} 
    def x4241_weight_SRAM_reshape_0 = {io.in_x4241_weight_SRAM_reshape_0} ; io.in_x4241_weight_SRAM_reshape_0 := DontCare
  }
  def connectWires0(module: x4321_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x3919_reg.connectLedger(module.io.in_x3919_reg)
    module.io.in_x18774_rd_x3918 <> x18774_rd_x3918
    module.io.in_b4068 <> b4068
    x4069_weight_SRAM_0.connectLedger(module.io.in_x4069_weight_SRAM_0)
    module.io.in_b4060 <> b4060
    x4241_weight_SRAM_reshape_0.connectLedger(module.io.in_x4241_weight_SRAM_reshape_0)
  }
  val x18774_rd_x3918 = list_x18774_rd_x3918(0)
  val b4068 = list_x18774_rd_x3918(1)
  val b4060 = list_x18774_rd_x3918(2)
  val x4069_weight_SRAM_0 = list_x4069_weight_SRAM_0(0)
  val x4241_weight_SRAM_reshape_0 = list_x4069_weight_SRAM_0(1)
  val x3919_reg = list_x3919_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4321_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x4321_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4321_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b4246 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b4246.suggestName("b4246")
      val b4247 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b4247.suggestName("b4247")
      val b4248 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b4248.suggestName("b4248")
      val b4249 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b4249.suggestName("b4249")
      val b4250 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b4250.suggestName("b4250")
      val b4251 = ~io.sigsIn.cchainOutputs.head.oobs(0); b4251.suggestName("b4251")
      val b4252 = ~io.sigsIn.cchainOutputs.head.oobs(1); b4252.suggestName("b4252")
      val b4253 = ~io.sigsIn.cchainOutputs.head.oobs(2); b4253.suggestName("b4253")
      val b4254 = ~io.sigsIn.cchainOutputs.head.oobs(3); b4254.suggestName("b4254")
      val b4255 = ~io.sigsIn.cchainOutputs.head.oobs(4); b4255.suggestName("b4255")
      object Block2Chunker0 { // 46 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x4256_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4256_mul""")
          x4256_mul.r := (Math.mul(b4247, 3L.FP(true, 32, 0), Some(6.0), true.B, Truncate, Wrapping, "x4256_mul")).r
          val x4257_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4257_mul""")
          x4257_mul.r := (Math.mul(b4248, 3L.FP(true, 32, 0), Some(6.0), true.B, Truncate, Wrapping, "x4257_mul")).r
          val x4258_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4258_mul""")
          x4258_mul.r := (Math.mul(b4249, 3L.FP(true, 32, 0), Some(6.0), true.B, Truncate, Wrapping, "x4258_mul")).r
          val x4259_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4259_mul""")
          x4259_mul.r := (Math.mul(b4250, 3L.FP(true, 32, 0), Some(6.0), true.B, Truncate, Wrapping, "x4259_mul")).r
          val x19642 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19642_b4246_D6") 
          x19642.r := getRetimed(b4246.r, 6.toInt, io.sigsIn.backpressure)
          val x18863 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18863""")
          x18863.r := Math.fma(x4256_mul,3L.FP(true, 32, 0),x19642,Some(6.0), true.B, "x18863").toFixed(x18863, "cast_x18863").r
          val x18864 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18864""")
          x18864.r := Math.fma(x4257_mul,3L.FP(true, 32, 0),x19642,Some(6.0), true.B, "x18864").toFixed(x18864, "cast_x18864").r
          val x18865 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18865""")
          x18865.r := Math.fma(x4258_mul,3L.FP(true, 32, 0),x19642,Some(6.0), true.B, "x18865").toFixed(x18865, "cast_x18865").r
          val x18866 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18866""")
          x18866.r := Math.fma(x4259_mul,3L.FP(true, 32, 0),x19642,Some(6.0), true.B, "x18866").toFixed(x18866, "cast_x18866").r
          val x4268_rd_x3919 = Wire(Bool()).suggestName("""x4268_rd_x3919""")
          val x4268_rd_x3919_banks = List[UInt]()
          val x4268_rd_x3919_ofs = List[UInt]()
          val x4268_rd_x3919_en = List[Bool](true.B)
          x4268_rd_x3919.toSeq.zip(x3919_reg.connectRPort(4268, x4268_rd_x3919_banks, x4268_rd_x3919_ofs, io.sigsIn.backpressure, x4268_rd_x3919_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x18867 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18867""")
          x18867.r := Math.and(x18863,7L.FP(true, 32, 0),Some(0.2), true.B,"x18867").r
          val x18868 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18868""")
          x18868.r := Math.and(x18864,7L.FP(true, 32, 0),Some(0.2), true.B,"x18868").r
          val x18869 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18869""")
          x18869.r := Math.and(x18865,7L.FP(true, 32, 0),Some(0.2), true.B,"x18869").r
          val x18870 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18870""")
          x18870.r := Math.and(x18866,7L.FP(true, 32, 0),Some(0.2), true.B,"x18870").r
          val x4276 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4276""")
          x4276.r := Math.arith_right_shift(x18863, 3, Some(0.2), true.B,"x4276").r
          val x4279 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4279""")
          x4279.r := Math.arith_right_shift(x18864, 3, Some(0.2), true.B,"x4279").r
          val x4282 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4282""")
          x4282.r := Math.arith_right_shift(x18865, 3, Some(0.2), true.B,"x4282").r
          val x4285 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4285""")
          x4285.r := Math.arith_right_shift(x18866, 3, Some(0.2), true.B,"x4285").r
          val x19643 = Wire(Bool()).suggestName("x19643_b4253_D12") 
          x19643.r := getRetimed(b4253.r, 12.toInt, io.sigsIn.backpressure)
          val x19644 = Wire(Bool()).suggestName("x19644_b4252_D12") 
          x19644.r := getRetimed(b4252.r, 12.toInt, io.sigsIn.backpressure)
          val x19645 = Wire(Bool()).suggestName("x19645_b4068_D12") 
          x19645.r := getRetimed(b4068.r, 12.toInt, io.sigsIn.backpressure)
          val x19646 = Wire(Bool()).suggestName("x19646_x4268_rd_x3919_D12") 
          x19646.r := getRetimed(x4268_rd_x3919.r, 12.toInt, io.sigsIn.backpressure)
          val x19647 = Wire(Bool()).suggestName("x19647_b4251_D12") 
          x19647.r := getRetimed(b4251.r, 12.toInt, io.sigsIn.backpressure)
          val x19648 = Wire(Bool()).suggestName("x19648_b4060_D12") 
          x19648.r := getRetimed(b4060.r, 12.toInt, io.sigsIn.backpressure)
          val x19649 = Wire(Bool()).suggestName("x19649_b4255_D12") 
          x19649.r := getRetimed(b4255.r, 12.toInt, io.sigsIn.backpressure)
          val x19650 = Wire(Bool()).suggestName("x19650_b4254_D12") 
          x19650.r := getRetimed(b4254.r, 12.toInt, io.sigsIn.backpressure)
          val x4288_rd = Wire(Vec(4, new FixedPoint(true, 10, 22))).suggestName("""x4288_rd""")
          val x4288_rd_banks = List[UInt](x18867.r,x18868.r,x18869.r,x18870.r)
          val x4288_rd_ofs = List[UInt](x4276.r,x4279.r,x4282.r,x4285.r)
          val x4288_rd_en = List[Bool](x19644,x19643,x19650,x19649)
          x4288_rd.toSeq.zip(x4069_weight_SRAM_0.connectRPort(4288, x4288_rd_banks, x4288_rd_ofs, io.sigsIn.backpressure, x4288_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(12.2.toInt, rr, io.sigsIn.backpressure) && x19646 & x19647 & x19645 & x19648), true)).foreach{case (a,b) => a := b}
          val x4289_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4289_elem_0""")
          x4289_elem_0.r := x4288_rd(0).r
          val x4290_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4290_elem_1""")
          x4290_elem_1.r := x4288_rd(1).r
          val x4291_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4291_elem_2""")
          x4291_elem_2.r := x4288_rd(2).r
          val x4292_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4292_elem_3""")
          x4292_elem_3.r := x4288_rd(3).r
          val x18871 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18871""")
          x18871.r := Math.and(b4247,31L.FP(true, 32, 0),Some(0.2), true.B,"x18871").r
          val x4294 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4294""")
          x4294.r := (Math.mod(b4246, 9L.FP(true, 32, 0), Some(16.0), true.B, Truncate, Wrapping, "x4294")).r
          val x18872 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18872""")
          x18872.r := Math.and(b4248,31L.FP(true, 32, 0),Some(0.2), true.B,"x18872").r
          val x18873 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18873""")
          x18873.r := Math.and(b4249,31L.FP(true, 32, 0),Some(0.2), true.B,"x18873").r
          val x18874 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18874""")
          x18874.r := Math.and(b4250,31L.FP(true, 32, 0),Some(0.2), true.B,"x18874").r
          val x4298 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4298""")
          x4298.r := Math.arith_right_shift(b4247, 5, Some(0.2), true.B,"x4298").r
          val x4299_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4299_div""")
          x4299_div.r := (Math.div(b4246, 9L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x4299_div")).r
          val x19651 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19651_x4298_D20") 
          x19651.r := getRetimed(x4298.r, 20.toInt, io.sigsIn.backpressure)
          val x4300_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4300_sum""")
          x4300_sum.r := Math.add(x19651,x4299_div,Some(1.0), true.B, Truncate, Wrapping, "x4300_sum").r
          val x4305 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4305""")
          x4305.r := Math.arith_right_shift(b4248, 5, Some(0.2), true.B,"x4305").r
          val x19652 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19652_x4305_D20") 
          x19652.r := getRetimed(x4305.r, 20.toInt, io.sigsIn.backpressure)
          val x4306_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4306_sum""")
          x4306_sum.r := Math.add(x19652,x4299_div,Some(1.0), true.B, Truncate, Wrapping, "x4306_sum").r
          val x4310 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4310""")
          x4310.r := Math.arith_right_shift(b4249, 5, Some(0.2), true.B,"x4310").r
          val x19653 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19653_x4310_D20") 
          x19653.r := getRetimed(x4310.r, 20.toInt, io.sigsIn.backpressure)
          val x4311_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4311_sum""")
          x4311_sum.r := Math.add(x19653,x4299_div,Some(1.0), true.B, Truncate, Wrapping, "x4311_sum").r
          Map[String,Any]("x4268_rd_x3919" -> x4268_rd_x3919, "x4289_elem_0" -> x4289_elem_0, "x4290_elem_1" -> x4290_elem_1, "x4291_elem_2" -> x4291_elem_2, "x4292_elem_3" -> x4292_elem_3, "x18871" -> x18871, "x4294" -> x4294, "x18872" -> x18872, "x18873" -> x18873, "x18874" -> x18874, "x4299_div" -> x4299_div, "x4300_sum" -> x4300_sum, "x4306_sum" -> x4306_sum, "x4311_sum" -> x4311_sum)
        }
      }
      val block2chunk0: Map[String, Any] = Block2Chunker0.gen()
      object Block2Chunker1 { // 21 nodes, 24 weight
        def gen(): Map[String, Any] = {
          val x4315 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4315""")
          x4315.r := Math.arith_right_shift(b4250, 5, Some(0.2), true.B,"x4315").r
          val x19654 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19654_x4315_D20") 
          x19654.r := getRetimed(x4315.r, 20.toInt, io.sigsIn.backpressure)
          val x4316_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4316_sum""")
          x4316_sum.r := Math.add(x19654,block2chunk0("x4299_div").asInstanceOf[FixedPoint],Some(1.0), true.B, Truncate, Wrapping, "x4316_sum").r
          val x19655 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19655_x18874_D21") 
          x19655.r := getRetimed(block2chunk0("x18874").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x19656 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19656_x4290_elem_1_D7") 
          x19656.r := getRetimed(block2chunk0("x4290_elem_1").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
          val x19657 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19657_x4294_D5") 
          x19657.r := getRetimed(block2chunk0("x4294").asInstanceOf[FixedPoint].r, 5.toInt, io.sigsIn.backpressure)
          val x19658 = Wire(Bool()).suggestName("x19658_b4253_D21") 
          x19658.r := getRetimed(b4253.r, 21.toInt, io.sigsIn.backpressure)
          val x19659 = Wire(Bool()).suggestName("x19659_b4252_D21") 
          x19659.r := getRetimed(b4252.r, 21.toInt, io.sigsIn.backpressure)
          val x19660 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19660_x18873_D21") 
          x19660.r := getRetimed(block2chunk0("x18873").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x19661 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19661_x4291_elem_2_D7") 
          x19661.r := getRetimed(block2chunk0("x4291_elem_2").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
          val x19662 = Wire(Bool()).suggestName("x19662_b4068_D21") 
          x19662.r := getRetimed(b4068.r, 21.toInt, io.sigsIn.backpressure)
          val x19663 = Wire(Bool()).suggestName("x19663_x4268_rd_x3919_D21") 
          x19663.r := getRetimed(block2chunk0("x4268_rd_x3919").asInstanceOf[Bool].r, 21.toInt, io.sigsIn.backpressure)
          val x19664 = Wire(Bool()).suggestName("x19664_b4251_D21") 
          x19664.r := getRetimed(b4251.r, 21.toInt, io.sigsIn.backpressure)
          val x19665 = Wire(Bool()).suggestName("x19665_b4060_D21") 
          x19665.r := getRetimed(b4060.r, 21.toInt, io.sigsIn.backpressure)
          val x19666 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19666_x18871_D21") 
          x19666.r := getRetimed(block2chunk0("x18871").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x19667 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19667_x4292_elem_3_D7") 
          x19667.r := getRetimed(block2chunk0("x4292_elem_3").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
          val x19668 = Wire(Bool()).suggestName("x19668_b4255_D21") 
          x19668.r := getRetimed(b4255.r, 21.toInt, io.sigsIn.backpressure)
          val x19669 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19669_x4289_elem_0_D7") 
          x19669.r := getRetimed(block2chunk0("x4289_elem_0").asInstanceOf[FixedPoint].r, 7.toInt, io.sigsIn.backpressure)
          val x19670 = Wire(Bool()).suggestName("x19670_b4254_D21") 
          x19670.r := getRetimed(b4254.r, 21.toInt, io.sigsIn.backpressure)
          val x19671 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19671_x18872_D21") 
          x19671.r := getRetimed(block2chunk0("x18872").asInstanceOf[FixedPoint].r, 21.toInt, io.sigsIn.backpressure)
          val x4320_wr_banks = List[UInt](x19666.r,x19657.r,x19671.r,x19657.r,x19660.r,x19657.r,x19655.r,x19657.r)
          def create_x4320_wr_ofs(): List[UInt] = {
            val x4320_wr_ofs0 = List[UInt](block2chunk0("x4300_sum").asInstanceOf[FixedPoint].r,block2chunk0("x4306_sum").asInstanceOf[FixedPoint].r,block2chunk0("x4311_sum").asInstanceOf[FixedPoint].r,x4316_sum.r)
            x4320_wr_ofs0
          }
          val x4320_wr_ofs = create_x4320_wr_ofs()
          val x4320_wr_en = List[Bool](x19659,x19658,x19670,x19668)
          val x4320_wr_data = List[UInt](x19669.r,x19656.r,x19661.r,x19667.r)
          x4241_weight_SRAM_reshape_0.connectWPort(4320, x4320_wr_banks, x4320_wr_ofs, x4320_wr_data, x4320_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(21.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19662 & x19664 & x19665 & x19663))
          Map[String,Any]()
        }
      }
      val block2chunk1: Map[String, Any] = Block2Chunker1.gen()
      x4069_weight_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4241_weight_SRAM_reshape_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x4321_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x4321_inr_Foreach **/
