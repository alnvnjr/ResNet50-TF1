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

/** Hierarchy: x4238 -> x4239 -> x4240 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4238_inr_Foreach **/
class x4238_inr_Foreach_kernel(
  list_x4085: List[DecoupledIO[AppLoadData]],
  list_x4117_reg: List[StandardInterface],
  list_x4069_weight_SRAM_0: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.2.toInt, myName = "x4238_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4238_inr_Foreach_iiCtr"))
  
  abstract class x4238_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4069_weight_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4069_weight_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x4085 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4085_p").asInstanceOf[(Int, Int)] )))
      val in_x4117_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4117_reg_p").asInstanceOf[MemParams] ))
      val in_x4118_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4118_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(8), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x4069_weight_SRAM_0 = {io.in_x4069_weight_SRAM_0} ; io.in_x4069_weight_SRAM_0 := DontCare
    def x4085 = {io.in_x4085} 
    def x4117_reg = {io.in_x4117_reg} ; io.in_x4117_reg := DontCare
    def x4118_reg = {io.in_x4118_reg} ; io.in_x4118_reg := DontCare
  }
  def connectWires0(module: x4238_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x4069_weight_SRAM_0.connectLedger(module.io.in_x4069_weight_SRAM_0)
    module.io.in_x4085 <> x4085
    x4117_reg.connectLedger(module.io.in_x4117_reg)
    x4118_reg.connectLedger(module.io.in_x4118_reg)
  }
  val x4085 = list_x4085(0)
  val x4117_reg = list_x4117_reg(0)
  val x4118_reg = list_x4117_reg(1)
  val x4069_weight_SRAM_0 = list_x4069_weight_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4238_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x4238_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4238_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b4132 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b4132.suggestName("b4132")
      val b4133 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b4133.suggestName("b4133")
      val b4134 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b4134.suggestName("b4134")
      val b4135 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b4135.suggestName("b4135")
      val b4136 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b4136.suggestName("b4136")
      val b4137 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b4137.suggestName("b4137")
      val b4138 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b4138.suggestName("b4138")
      val b4139 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b4139.suggestName("b4139")
      val b4140 = ~io.sigsIn.cchainOutputs.head.oobs(0); b4140.suggestName("b4140")
      val b4141 = ~io.sigsIn.cchainOutputs.head.oobs(1); b4141.suggestName("b4141")
      val b4142 = ~io.sigsIn.cchainOutputs.head.oobs(2); b4142.suggestName("b4142")
      val b4143 = ~io.sigsIn.cchainOutputs.head.oobs(3); b4143.suggestName("b4143")
      val b4144 = ~io.sigsIn.cchainOutputs.head.oobs(4); b4144.suggestName("b4144")
      val b4145 = ~io.sigsIn.cchainOutputs.head.oobs(5); b4145.suggestName("b4145")
      val b4146 = ~io.sigsIn.cchainOutputs.head.oobs(6); b4146.suggestName("b4146")
      val b4147 = ~io.sigsIn.cchainOutputs.head.oobs(7); b4147.suggestName("b4147")
      object Block2Chunker0 { // 42 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x4148_rd_x4117 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4148_rd_x4117""")
          val x4148_rd_x4117_banks = List[UInt]()
          val x4148_rd_x4117_ofs = List[UInt]()
          val x4148_rd_x4117_en = List[Bool](true.B)
          x4148_rd_x4117.toSeq.zip(x4117_reg.connectRPort(4148, x4148_rd_x4117_banks, x4148_rd_x4117_ofs, io.sigsIn.backpressure, x4148_rd_x4117_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x4156 = Wire(Bool()).suggestName("""x4156""")
          x4156.r := Math.lte(x4148_rd_x4117, b4132, Some(0.4), true.B,"x4156").r
          val x4157 = Wire(Bool()).suggestName("""x4157""")
          x4157.r := Math.lte(x4148_rd_x4117, b4133, Some(0.4), true.B,"x4157").r
          val x4158 = Wire(Bool()).suggestName("""x4158""")
          x4158.r := Math.lte(x4148_rd_x4117, b4134, Some(0.4), true.B,"x4158").r
          val x4159 = Wire(Bool()).suggestName("""x4159""")
          x4159.r := Math.lte(x4148_rd_x4117, b4135, Some(0.4), true.B,"x4159").r
          val x4160 = Wire(Bool()).suggestName("""x4160""")
          x4160.r := Math.lte(x4148_rd_x4117, b4136, Some(0.4), true.B,"x4160").r
          val x4161 = Wire(Bool()).suggestName("""x4161""")
          x4161.r := Math.lte(x4148_rd_x4117, b4137, Some(0.4), true.B,"x4161").r
          val x4162 = Wire(Bool()).suggestName("""x4162""")
          x4162.r := Math.lte(x4148_rd_x4117, b4138, Some(0.4), true.B,"x4162").r
          val x4163 = Wire(Bool()).suggestName("""x4163""")
          x4163.r := Math.lte(x4148_rd_x4117, b4139, Some(0.4), true.B,"x4163").r
          val x4164_rd_x4118 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4164_rd_x4118""")
          val x4164_rd_x4118_banks = List[UInt]()
          val x4164_rd_x4118_ofs = List[UInt]()
          val x4164_rd_x4118_en = List[Bool](true.B)
          x4164_rd_x4118.toSeq.zip(x4118_reg.connectRPort(4164, x4164_rd_x4118_banks, x4164_rd_x4118_ofs, io.sigsIn.backpressure, x4164_rd_x4118_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x4172 = Wire(Bool()).suggestName("""x4172""")
          x4172.r := Math.lt(b4132, x4164_rd_x4118, Some(0.4), true.B,"x4172").r
          val x4173 = Wire(Bool()).suggestName("""x4173""")
          x4173.r := Math.lt(b4133, x4164_rd_x4118, Some(0.4), true.B,"x4173").r
          val x4174 = Wire(Bool()).suggestName("""x4174""")
          x4174.r := Math.lt(b4134, x4164_rd_x4118, Some(0.4), true.B,"x4174").r
          val x4175 = Wire(Bool()).suggestName("""x4175""")
          x4175.r := Math.lt(b4135, x4164_rd_x4118, Some(0.4), true.B,"x4175").r
          val x4176 = Wire(Bool()).suggestName("""x4176""")
          x4176.r := Math.lt(b4136, x4164_rd_x4118, Some(0.4), true.B,"x4176").r
          val x4177 = Wire(Bool()).suggestName("""x4177""")
          x4177.r := Math.lt(b4137, x4164_rd_x4118, Some(0.4), true.B,"x4177").r
          val x4178 = Wire(Bool()).suggestName("""x4178""")
          x4178.r := Math.lt(b4138, x4164_rd_x4118, Some(0.4), true.B,"x4178").r
          val x4179 = Wire(Bool()).suggestName("""x4179""")
          x4179.r := Math.lt(b4139, x4164_rd_x4118, Some(0.4), true.B,"x4179").r
          val x4180 = Wire(Bool()).suggestName("""x4180""")
          x4180 := x4156 & x4172
          val x4181 = Wire(Bool()).suggestName("""x4181""")
          x4181 := x4157 & x4173
          val x4182 = Wire(Bool()).suggestName("""x4182""")
          x4182 := x4158 & x4174
          val x4183 = Wire(Bool()).suggestName("""x4183""")
          x4183 := x4159 & x4175
          val x4184 = Wire(Bool()).suggestName("""x4184""")
          x4184 := x4160 & x4176
          val x4185 = Wire(Bool()).suggestName("""x4185""")
          x4185 := x4161 & x4177
          val x4186 = Wire(Bool()).suggestName("""x4186""")
          x4186 := x4162 & x4178
          val x4187 = Wire(Bool()).suggestName("""x4187""")
          x4187 := x4163 & x4179
          val x4188_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4188_sub""")
          x4188_sub.r := Math.sub(b4132,x4148_rd_x4117,Some(1.0), true.B, Truncate, Wrapping, "x4188_sub").r
          val x4189_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4189_sub""")
          x4189_sub.r := Math.sub(b4133,x4148_rd_x4117,Some(1.0), true.B, Truncate, Wrapping, "x4189_sub").r
          val x4190_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4190_sub""")
          x4190_sub.r := Math.sub(b4134,x4148_rd_x4117,Some(1.0), true.B, Truncate, Wrapping, "x4190_sub").r
          val x4191_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4191_sub""")
          x4191_sub.r := Math.sub(b4135,x4148_rd_x4117,Some(1.0), true.B, Truncate, Wrapping, "x4191_sub").r
          val x4192_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4192_sub""")
          x4192_sub.r := Math.sub(b4136,x4148_rd_x4117,Some(1.0), true.B, Truncate, Wrapping, "x4192_sub").r
          val x4193_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4193_sub""")
          x4193_sub.r := Math.sub(b4137,x4148_rd_x4117,Some(1.0), true.B, Truncate, Wrapping, "x4193_sub").r
          val x4194_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4194_sub""")
          x4194_sub.r := Math.sub(b4138,x4148_rd_x4117,Some(1.0), true.B, Truncate, Wrapping, "x4194_sub").r
          val x4195_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4195_sub""")
          x4195_sub.r := Math.sub(b4139,x4148_rd_x4117,Some(1.0), true.B, Truncate, Wrapping, "x4195_sub").r
          val x4196 = Wire(Vec(8, new FixedPoint(true, 10, 22))).suggestName("""x4196""")
          x4085.ready := b4143 & b4146 & b4142 & b4147 & b4145 & b4141 & b4144 & b4140 & (io.sigsIn.datapathEn) 
          (0 until 8).map{ i => x4196(i).r := x4085.bits.rdata(i).r }
          val x19625 = Wire(Vec(8, new FixedPoint(true, 10, 22))).suggestName("x19625_x4196_D1") 
          (0 until 8).foreach{i => x19625(i).r := getRetimed(x4196(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x4197_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4197_elem_0""")
          x4197_elem_0.r := x19625(0).r
          val x4198_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4198_elem_1""")
          x4198_elem_1.r := x19625(1).r
          val x4199_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4199_elem_2""")
          x4199_elem_2.r := x19625(2).r
          val x4200_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4200_elem_3""")
          x4200_elem_3.r := x19625(3).r
          val x4201_elem_4 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4201_elem_4""")
          x4201_elem_4.r := x19625(4).r
          val x4202_elem_5 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4202_elem_5""")
          x4202_elem_5.r := x19625(5).r
          Map[String,Any]("x4180" -> x4180, "x4181" -> x4181, "x4182" -> x4182, "x4183" -> x4183, "x4184" -> x4184, "x4185" -> x4185, "x4186" -> x4186, "x4187" -> x4187, "x4188_sub" -> x4188_sub, "x4189_sub" -> x4189_sub, "x4190_sub" -> x4190_sub, "x4191_sub" -> x4191_sub, "x4192_sub" -> x4192_sub, "x4193_sub" -> x4193_sub, "x4194_sub" -> x4194_sub, "x4195_sub" -> x4195_sub, "x19625" -> x19625, "x4197_elem_0" -> x4197_elem_0, "x4198_elem_1" -> x4198_elem_1, "x4199_elem_2" -> x4199_elem_2, "x4200_elem_3" -> x4200_elem_3, "x4201_elem_4" -> x4201_elem_4, "x4202_elem_5" -> x4202_elem_5)
        }
      }
      val block2chunk0: Map[String, Any] = Block2Chunker0.gen()
      object Block2Chunker1 { // 35 nodes, 42 weight
        def gen(): Map[String, Any] = {
          val x4203_elem_6 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4203_elem_6""")
          x4203_elem_6.r := block2chunk0("x19625").asInstanceOf[Vec[FixedPoint]](6).r
          val x4204_elem_7 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4204_elem_7""")
          x4204_elem_7.r := block2chunk0("x19625").asInstanceOf[Vec[FixedPoint]](7).r
          val x18855 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18855""")
          x18855.r := Math.and(block2chunk0("x4188_sub").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x18855").r
          val x18856 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18856""")
          x18856.r := Math.and(block2chunk0("x4189_sub").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x18856").r
          val x18857 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18857""")
          x18857.r := Math.and(block2chunk0("x4190_sub").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x18857").r
          val x18858 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18858""")
          x18858.r := Math.and(block2chunk0("x4191_sub").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x18858").r
          val x18859 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18859""")
          x18859.r := Math.and(block2chunk0("x4192_sub").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x18859").r
          val x18860 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18860""")
          x18860.r := Math.and(block2chunk0("x4193_sub").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x18860").r
          val x18861 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18861""")
          x18861.r := Math.and(block2chunk0("x4194_sub").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x18861").r
          val x18862 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18862""")
          x18862.r := Math.and(block2chunk0("x4195_sub").asInstanceOf[FixedPoint],7L.FP(true, 32, 0),Some(0.2), true.B,"x18862").r
          val x4213 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4213""")
          x4213.r := Math.arith_right_shift(block2chunk0("x4188_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x4213").r
          val x4216 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4216""")
          x4216.r := Math.arith_right_shift(block2chunk0("x4189_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x4216").r
          val x4219 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4219""")
          x4219.r := Math.arith_right_shift(block2chunk0("x4190_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x4219").r
          val x4222 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4222""")
          x4222.r := Math.arith_right_shift(block2chunk0("x4191_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x4222").r
          val x4225 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4225""")
          x4225.r := Math.arith_right_shift(block2chunk0("x4192_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x4225").r
          val x4228 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4228""")
          x4228.r := Math.arith_right_shift(block2chunk0("x4193_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x4228").r
          val x4231 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4231""")
          x4231.r := Math.arith_right_shift(block2chunk0("x4194_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x4231").r
          val x4234 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4234""")
          x4234.r := Math.arith_right_shift(block2chunk0("x4195_sub").asInstanceOf[FixedPoint], 3, Some(0.2), true.B,"x4234").r
          val x19626 = Wire(Bool()).suggestName("x19626_x4183_D1") 
          x19626.r := getRetimed(block2chunk0("x4183").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x19627 = Wire(Bool()).suggestName("x19627_b4142_D1") 
          x19627.r := getRetimed(b4142.r, 1.toInt, io.sigsIn.backpressure)
          val x19628 = Wire(Bool()).suggestName("x19628_b4141_D1") 
          x19628.r := getRetimed(b4141.r, 1.toInt, io.sigsIn.backpressure)
          val x19629 = Wire(Bool()).suggestName("x19629_b4147_D1") 
          x19629.r := getRetimed(b4147.r, 1.toInt, io.sigsIn.backpressure)
          val x19630 = Wire(Bool()).suggestName("x19630_b4140_D1") 
          x19630.r := getRetimed(b4140.r, 1.toInt, io.sigsIn.backpressure)
          val x19631 = Wire(Bool()).suggestName("x19631_x4187_D1") 
          x19631.r := getRetimed(block2chunk0("x4187").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x19632 = Wire(Bool()).suggestName("x19632_x4180_D1") 
          x19632.r := getRetimed(block2chunk0("x4180").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x19633 = Wire(Bool()).suggestName("x19633_x4184_D1") 
          x19633.r := getRetimed(block2chunk0("x4184").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x19634 = Wire(Bool()).suggestName("x19634_b4144_D1") 
          x19634.r := getRetimed(b4144.r, 1.toInt, io.sigsIn.backpressure)
          val x19635 = Wire(Bool()).suggestName("x19635_x4186_D1") 
          x19635.r := getRetimed(block2chunk0("x4186").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x19636 = Wire(Bool()).suggestName("x19636_x4181_D1") 
          x19636.r := getRetimed(block2chunk0("x4181").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x19637 = Wire(Bool()).suggestName("x19637_b4145_D1") 
          x19637.r := getRetimed(b4145.r, 1.toInt, io.sigsIn.backpressure)
          val x19638 = Wire(Bool()).suggestName("x19638_b4143_D1") 
          x19638.r := getRetimed(b4143.r, 1.toInt, io.sigsIn.backpressure)
          val x19639 = Wire(Bool()).suggestName("x19639_x4185_D1") 
          x19639.r := getRetimed(block2chunk0("x4185").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x19640 = Wire(Bool()).suggestName("x19640_x4182_D1") 
          x19640.r := getRetimed(block2chunk0("x4182").asInstanceOf[Bool].r, 1.toInt, io.sigsIn.backpressure)
          val x19641 = Wire(Bool()).suggestName("x19641_b4146_D1") 
          x19641.r := getRetimed(b4146.r, 1.toInt, io.sigsIn.backpressure)
          val x4237_wr_banks = List[UInt](x18855.r,x18856.r,x18857.r,x18858.r,x18859.r,x18860.r,x18861.r,x18862.r)
          val x4237_wr_ofs = List[UInt](x4213.r,x4216.r,x4219.r,x4222.r,x4225.r,x4228.r,x4231.r,x4234.r)
          val x4237_wr_en = List[Bool](x19632 & x19630,x19636 & x19628,x19640 & x19627,x19626 & x19638,x19633 & x19634,x19639 & x19637,x19635 & x19641,x19631 & x19629)
          def create_x4237_wr_data(): List[UInt] = {
            val x4237_wr_data0 = List[UInt](block2chunk0("x4197_elem_0").asInstanceOf[FixedPoint].r,block2chunk0("x4198_elem_1").asInstanceOf[FixedPoint].r,block2chunk0("x4199_elem_2").asInstanceOf[FixedPoint].r,block2chunk0("x4200_elem_3").asInstanceOf[FixedPoint].r)
            val x4237_wr_data1 = List[UInt](block2chunk0("x4201_elem_4").asInstanceOf[FixedPoint].r,block2chunk0("x4202_elem_5").asInstanceOf[FixedPoint].r,x4203_elem_6.r,x4204_elem_7.r)
            x4237_wr_data0 ++ x4237_wr_data1
          }
          val x4237_wr_data = create_x4237_wr_data()
          x4069_weight_SRAM_0.connectWPort(4237, x4237_wr_banks, x4237_wr_ofs, x4237_wr_data, x4237_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]()
        }
      }
      val block2chunk1: Map[String, Any] = Block2Chunker1.gen()
    }
    val module = Module(new x4238_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x4238_inr_Foreach **/
