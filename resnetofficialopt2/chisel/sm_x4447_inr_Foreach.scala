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

/** Hierarchy: x4447 -> x4448 -> x4449 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4447_inr_Foreach **/
class x4447_inr_Foreach_kernel(
  list_x4338: List[DecoupledIO[AppLoadData]],
  list_x4371_reg: List[StandardInterface],
  list_x4326_img2D_4: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.2.toInt, myName = "x4447_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4447_inr_Foreach_iiCtr"))
  
  abstract class x4447_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4326_img2D_4 = Flipped(new NBufInterface(ModuleParams.getParams("x4326_img2D_4_p").asInstanceOf[NBufParams] ))
      val in_x4371_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4371_reg_p").asInstanceOf[MemParams] ))
      val in_x4322_img2D_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4322_img2D_0_p").asInstanceOf[NBufParams] ))
      val in_x4329_img2D_7 = Flipped(new NBufInterface(ModuleParams.getParams("x4329_img2D_7_p").asInstanceOf[NBufParams] ))
      val in_x4323_img2D_1 = Flipped(new NBufInterface(ModuleParams.getParams("x4323_img2D_1_p").asInstanceOf[NBufParams] ))
      val in_x4370_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4370_reg_p").asInstanceOf[MemParams] ))
      val in_x4327_img2D_5 = Flipped(new NBufInterface(ModuleParams.getParams("x4327_img2D_5_p").asInstanceOf[NBufParams] ))
      val in_x4328_img2D_6 = Flipped(new NBufInterface(ModuleParams.getParams("x4328_img2D_6_p").asInstanceOf[NBufParams] ))
      val in_x4324_img2D_2 = Flipped(new NBufInterface(ModuleParams.getParams("x4324_img2D_2_p").asInstanceOf[NBufParams] ))
      val in_x4325_img2D_3 = Flipped(new NBufInterface(ModuleParams.getParams("x4325_img2D_3_p").asInstanceOf[NBufParams] ))
      val in_x4338 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4338_p").asInstanceOf[(Int, Int)] )))
      val in_x4330_img2D_8 = Flipped(new NBufInterface(ModuleParams.getParams("x4330_img2D_8_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(4), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x4326_img2D_4 = {io.in_x4326_img2D_4} ; io.in_x4326_img2D_4 := DontCare
    def x4371_reg = {io.in_x4371_reg} ; io.in_x4371_reg := DontCare
    def x4322_img2D_0 = {io.in_x4322_img2D_0} ; io.in_x4322_img2D_0 := DontCare
    def x4329_img2D_7 = {io.in_x4329_img2D_7} ; io.in_x4329_img2D_7 := DontCare
    def x4323_img2D_1 = {io.in_x4323_img2D_1} ; io.in_x4323_img2D_1 := DontCare
    def x4370_reg = {io.in_x4370_reg} ; io.in_x4370_reg := DontCare
    def x4327_img2D_5 = {io.in_x4327_img2D_5} ; io.in_x4327_img2D_5 := DontCare
    def x4328_img2D_6 = {io.in_x4328_img2D_6} ; io.in_x4328_img2D_6 := DontCare
    def x4324_img2D_2 = {io.in_x4324_img2D_2} ; io.in_x4324_img2D_2 := DontCare
    def x4325_img2D_3 = {io.in_x4325_img2D_3} ; io.in_x4325_img2D_3 := DontCare
    def x4338 = {io.in_x4338} 
    def x4330_img2D_8 = {io.in_x4330_img2D_8} ; io.in_x4330_img2D_8 := DontCare
  }
  def connectWires0(module: x4447_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x4326_img2D_4.connectLedger(module.io.in_x4326_img2D_4)
    x4371_reg.connectLedger(module.io.in_x4371_reg)
    x4322_img2D_0.connectLedger(module.io.in_x4322_img2D_0)
    x4329_img2D_7.connectLedger(module.io.in_x4329_img2D_7)
    x4323_img2D_1.connectLedger(module.io.in_x4323_img2D_1)
    x4370_reg.connectLedger(module.io.in_x4370_reg)
    x4327_img2D_5.connectLedger(module.io.in_x4327_img2D_5)
    x4328_img2D_6.connectLedger(module.io.in_x4328_img2D_6)
    x4324_img2D_2.connectLedger(module.io.in_x4324_img2D_2)
    x4325_img2D_3.connectLedger(module.io.in_x4325_img2D_3)
    module.io.in_x4338 <> x4338
    x4330_img2D_8.connectLedger(module.io.in_x4330_img2D_8)
  }
  val x4338 = list_x4338(0)
  val x4371_reg = list_x4371_reg(0)
  val x4370_reg = list_x4371_reg(1)
  val x4326_img2D_4 = list_x4326_img2D_4(0)
  val x4322_img2D_0 = list_x4326_img2D_4(1)
  val x4329_img2D_7 = list_x4326_img2D_4(2)
  val x4323_img2D_1 = list_x4326_img2D_4(3)
  val x4327_img2D_5 = list_x4326_img2D_4(4)
  val x4328_img2D_6 = list_x4326_img2D_4(5)
  val x4324_img2D_2 = list_x4326_img2D_4(6)
  val x4325_img2D_3 = list_x4326_img2D_4(7)
  val x4330_img2D_8 = list_x4326_img2D_4(8)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4447_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x4447_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4447_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b4385 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b4385.suggestName("b4385")
      val b4386 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b4386.suggestName("b4386")
      val b4387 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b4387.suggestName("b4387")
      val b4388 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b4388.suggestName("b4388")
      val b4389 = ~io.sigsIn.cchainOutputs.head.oobs(0); b4389.suggestName("b4389")
      val b4390 = ~io.sigsIn.cchainOutputs.head.oobs(1); b4390.suggestName("b4390")
      val b4391 = ~io.sigsIn.cchainOutputs.head.oobs(2); b4391.suggestName("b4391")
      val b4392 = ~io.sigsIn.cchainOutputs.head.oobs(3); b4392.suggestName("b4392")
      object Block3Chunker0 { // 41 nodes, 47 weight
        def gen(): Map[String, Any] = {
          val x4393_rd_x4370 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4393_rd_x4370""")
          val x4393_rd_x4370_banks = List[UInt]()
          val x4393_rd_x4370_ofs = List[UInt]()
          val x4393_rd_x4370_en = List[Bool](true.B)
          x4393_rd_x4370.toSeq.zip(x4370_reg.connectRPort(4393, x4393_rd_x4370_banks, x4393_rd_x4370_ofs, io.sigsIn.backpressure, x4393_rd_x4370_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x4397 = Wire(Bool()).suggestName("""x4397""")
          x4397.r := Math.lte(x4393_rd_x4370, b4385, Some(0.4), true.B,"x4397").r
          val x4398 = Wire(Bool()).suggestName("""x4398""")
          x4398.r := Math.lte(x4393_rd_x4370, b4386, Some(0.4), true.B,"x4398").r
          val x4399 = Wire(Bool()).suggestName("""x4399""")
          x4399.r := Math.lte(x4393_rd_x4370, b4387, Some(0.4), true.B,"x4399").r
          val x4400 = Wire(Bool()).suggestName("""x4400""")
          x4400.r := Math.lte(x4393_rd_x4370, b4388, Some(0.4), true.B,"x4400").r
          val x4401_rd_x4371 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4401_rd_x4371""")
          val x4401_rd_x4371_banks = List[UInt]()
          val x4401_rd_x4371_ofs = List[UInt]()
          val x4401_rd_x4371_en = List[Bool](true.B)
          x4401_rd_x4371.toSeq.zip(x4371_reg.connectRPort(4401, x4401_rd_x4371_banks, x4401_rd_x4371_ofs, io.sigsIn.backpressure, x4401_rd_x4371_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
          val x4405 = Wire(Bool()).suggestName("""x4405""")
          x4405.r := Math.lt(b4385, x4401_rd_x4371, Some(0.4), true.B,"x4405").r
          val x4406 = Wire(Bool()).suggestName("""x4406""")
          x4406.r := Math.lt(b4386, x4401_rd_x4371, Some(0.4), true.B,"x4406").r
          val x4407 = Wire(Bool()).suggestName("""x4407""")
          x4407.r := Math.lt(b4387, x4401_rd_x4371, Some(0.4), true.B,"x4407").r
          val x4408 = Wire(Bool()).suggestName("""x4408""")
          x4408.r := Math.lt(b4388, x4401_rd_x4371, Some(0.4), true.B,"x4408").r
          val x4409 = Wire(Bool()).suggestName("""x4409""")
          x4409 := x4397 & x4405
          val x4410 = Wire(Bool()).suggestName("""x4410""")
          x4410 := x4398 & x4406
          val x4411 = Wire(Bool()).suggestName("""x4411""")
          x4411 := x4399 & x4407
          val x4412 = Wire(Bool()).suggestName("""x4412""")
          x4412 := x4400 & x4408
          val x4413_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4413_sub""")
          x4413_sub.r := Math.sub(b4385,x4393_rd_x4370,Some(1.0), true.B, Truncate, Wrapping, "x4413_sub").r
          val x4414_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4414_sub""")
          x4414_sub.r := Math.sub(b4386,x4393_rd_x4370,Some(1.0), true.B, Truncate, Wrapping, "x4414_sub").r
          val x4415_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4415_sub""")
          x4415_sub.r := Math.sub(b4387,x4393_rd_x4370,Some(1.0), true.B, Truncate, Wrapping, "x4415_sub").r
          val x4416_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4416_sub""")
          x4416_sub.r := Math.sub(b4388,x4393_rd_x4370,Some(1.0), true.B, Truncate, Wrapping, "x4416_sub").r
          val x4417 = Wire(Vec(4, new FixedPoint(true, 10, 22))).suggestName("""x4417""")
          x4338.ready := b4389 & b4390 & b4391 & b4392 & (io.sigsIn.datapathEn) 
          (0 until 4).map{ i => x4417(i).r := x4338.bits.rdata(i).r }
          val x19683 = Wire(Vec(4, new FixedPoint(true, 10, 22))).suggestName("x19683_x4417_D1") 
          (0 until 4).foreach{i => x19683(i).r := getRetimed(x4417(i).r, 1.toInt, io.sigsIn.backpressure)}
          val x4418_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4418_elem_0""")
          x4418_elem_0.r := x19683(0).r
          val x4419_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4419_elem_1""")
          x4419_elem_1.r := x19683(1).r
          val x4420_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4420_elem_2""")
          x4420_elem_2.r := x19683(2).r
          val x4421_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4421_elem_3""")
          x4421_elem_3.r := x19683(3).r
          val x18878 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18878""")
          x18878.r := Math.and(x4413_sub,3L.FP(true, 32, 0),Some(0.2), true.B,"x18878").r
          val x18879 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18879""")
          x18879.r := Math.and(x4414_sub,3L.FP(true, 32, 0),Some(0.2), true.B,"x18879").r
          val x18880 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18880""")
          x18880.r := Math.and(x4415_sub,3L.FP(true, 32, 0),Some(0.2), true.B,"x18880").r
          val x18881 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18881""")
          x18881.r := Math.and(x4416_sub,3L.FP(true, 32, 0),Some(0.2), true.B,"x18881").r
          val x4426 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4426""")
          x4426.r := Math.arith_right_shift(x4413_sub, 2, Some(0.2), true.B,"x4426").r
          val x4429 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4429""")
          x4429.r := Math.arith_right_shift(x4414_sub, 2, Some(0.2), true.B,"x4429").r
          val x4432 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4432""")
          x4432.r := Math.arith_right_shift(x4415_sub, 2, Some(0.2), true.B,"x4432").r
          val x4435 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4435""")
          x4435.r := Math.arith_right_shift(x4416_sub, 2, Some(0.2), true.B,"x4435").r
          val x19684 = Wire(Bool()).suggestName("x19684_b4391_D1") 
          x19684.r := getRetimed(b4391.r, 1.toInt, io.sigsIn.backpressure)
          val x19685 = Wire(Bool()).suggestName("x19685_b4390_D1") 
          x19685.r := getRetimed(b4390.r, 1.toInt, io.sigsIn.backpressure)
          val x19686 = Wire(Bool()).suggestName("x19686_x4411_D1") 
          x19686.r := getRetimed(x4411.r, 1.toInt, io.sigsIn.backpressure)
          val x19687 = Wire(Bool()).suggestName("x19687_b4389_D1") 
          x19687.r := getRetimed(b4389.r, 1.toInt, io.sigsIn.backpressure)
          val x19688 = Wire(Bool()).suggestName("x19688_x4412_D1") 
          x19688.r := getRetimed(x4412.r, 1.toInt, io.sigsIn.backpressure)
          val x19689 = Wire(Bool()).suggestName("x19689_x4409_D1") 
          x19689.r := getRetimed(x4409.r, 1.toInt, io.sigsIn.backpressure)
          val x19690 = Wire(Bool()).suggestName("x19690_b4392_D1") 
          x19690.r := getRetimed(b4392.r, 1.toInt, io.sigsIn.backpressure)
          val x19691 = Wire(Bool()).suggestName("x19691_x4410_D1") 
          x19691.r := getRetimed(x4410.r, 1.toInt, io.sigsIn.backpressure)
          val x4438_wr_banks = List[UInt](x18878.r,x18879.r,x18880.r,x18881.r)
          val x4438_wr_ofs = List[UInt](x4426.r,x4429.r,x4432.r,x4435.r)
          val x4438_wr_en = List[Bool](x19689 & x19687,x19691 & x19685,x19686 & x19684,x19688 & x19690)
          val x4438_wr_data = List[UInt](x4418_elem_0.r,x4419_elem_1.r,x4420_elem_2.r,x4421_elem_3.r)
          x4326_img2D_4.connectWPort(4438, x4438_wr_banks, x4438_wr_ofs, x4438_wr_data, x4438_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]("x4418_elem_0" -> x4418_elem_0, "x4419_elem_1" -> x4419_elem_1, "x4420_elem_2" -> x4420_elem_2, "x4421_elem_3" -> x4421_elem_3, "x18878" -> x18878, "x18879" -> x18879, "x18880" -> x18880, "x18881" -> x18881, "x4426" -> x4426, "x4429" -> x4429, "x4432" -> x4432, "x4435" -> x4435, "x19684" -> x19684, "x19685" -> x19685, "x19686" -> x19686, "x19687" -> x19687, "x19688" -> x19688, "x19689" -> x19689, "x19690" -> x19690, "x19691" -> x19691)
        }
      }
      val block3chunk0: Map[String, Any] = Block3Chunker0.gen()
      object Block3Chunker1 { // 8 nodes, 32 weight
        def gen(): Map[String, Any] = {
          def create_x4439_wr_banks(): List[UInt] = {
            val x4439_wr_banks0 = List[UInt](block3chunk0("x18878").asInstanceOf[FixedPoint].r,block3chunk0("x18879").asInstanceOf[FixedPoint].r,block3chunk0("x18880").asInstanceOf[FixedPoint].r,block3chunk0("x18881").asInstanceOf[FixedPoint].r)
            x4439_wr_banks0
          }
          val x4439_wr_banks = create_x4439_wr_banks()
          def create_x4439_wr_ofs(): List[UInt] = {
            val x4439_wr_ofs0 = List[UInt](block3chunk0("x4426").asInstanceOf[FixedPoint].r,block3chunk0("x4429").asInstanceOf[FixedPoint].r,block3chunk0("x4432").asInstanceOf[FixedPoint].r,block3chunk0("x4435").asInstanceOf[FixedPoint].r)
            x4439_wr_ofs0
          }
          val x4439_wr_ofs = create_x4439_wr_ofs()
          def create_x4439_wr_en(): List[Bool] = {
            val x4439_wr_en0 = List[Bool](block3chunk0("x19689").asInstanceOf[Bool] & block3chunk0("x19687").asInstanceOf[Bool],block3chunk0("x19691").asInstanceOf[Bool] & block3chunk0("x19685").asInstanceOf[Bool])
            val x4439_wr_en1 = List[Bool](block3chunk0("x19686").asInstanceOf[Bool] & block3chunk0("x19684").asInstanceOf[Bool],block3chunk0("x19688").asInstanceOf[Bool] & block3chunk0("x19690").asInstanceOf[Bool])
            x4439_wr_en0 ++ x4439_wr_en1
          }
          val x4439_wr_en = create_x4439_wr_en()
          def create_x4439_wr_data(): List[UInt] = {
            val x4439_wr_data0 = List[UInt](block3chunk0("x4418_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x4419_elem_1").asInstanceOf[FixedPoint].r,block3chunk0("x4420_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x4421_elem_3").asInstanceOf[FixedPoint].r)
            x4439_wr_data0
          }
          val x4439_wr_data = create_x4439_wr_data()
          x4322_img2D_0.connectWPort(4439, x4439_wr_banks, x4439_wr_ofs, x4439_wr_data, x4439_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x4440_wr_banks(): List[UInt] = {
            val x4440_wr_banks0 = List[UInt](block3chunk0("x18878").asInstanceOf[FixedPoint].r,block3chunk0("x18879").asInstanceOf[FixedPoint].r,block3chunk0("x18880").asInstanceOf[FixedPoint].r,block3chunk0("x18881").asInstanceOf[FixedPoint].r)
            x4440_wr_banks0
          }
          val x4440_wr_banks = create_x4440_wr_banks()
          def create_x4440_wr_ofs(): List[UInt] = {
            val x4440_wr_ofs0 = List[UInt](block3chunk0("x4426").asInstanceOf[FixedPoint].r,block3chunk0("x4429").asInstanceOf[FixedPoint].r,block3chunk0("x4432").asInstanceOf[FixedPoint].r,block3chunk0("x4435").asInstanceOf[FixedPoint].r)
            x4440_wr_ofs0
          }
          val x4440_wr_ofs = create_x4440_wr_ofs()
          def create_x4440_wr_en(): List[Bool] = {
            val x4440_wr_en0 = List[Bool](block3chunk0("x19689").asInstanceOf[Bool] & block3chunk0("x19687").asInstanceOf[Bool],block3chunk0("x19691").asInstanceOf[Bool] & block3chunk0("x19685").asInstanceOf[Bool])
            val x4440_wr_en1 = List[Bool](block3chunk0("x19686").asInstanceOf[Bool] & block3chunk0("x19684").asInstanceOf[Bool],block3chunk0("x19688").asInstanceOf[Bool] & block3chunk0("x19690").asInstanceOf[Bool])
            x4440_wr_en0 ++ x4440_wr_en1
          }
          val x4440_wr_en = create_x4440_wr_en()
          def create_x4440_wr_data(): List[UInt] = {
            val x4440_wr_data0 = List[UInt](block3chunk0("x4418_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x4419_elem_1").asInstanceOf[FixedPoint].r,block3chunk0("x4420_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x4421_elem_3").asInstanceOf[FixedPoint].r)
            x4440_wr_data0
          }
          val x4440_wr_data = create_x4440_wr_data()
          x4329_img2D_7.connectWPort(4440, x4440_wr_banks, x4440_wr_ofs, x4440_wr_data, x4440_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x4441_wr_banks(): List[UInt] = {
            val x4441_wr_banks0 = List[UInt](block3chunk0("x18878").asInstanceOf[FixedPoint].r,block3chunk0("x18879").asInstanceOf[FixedPoint].r,block3chunk0("x18880").asInstanceOf[FixedPoint].r,block3chunk0("x18881").asInstanceOf[FixedPoint].r)
            x4441_wr_banks0
          }
          val x4441_wr_banks = create_x4441_wr_banks()
          def create_x4441_wr_ofs(): List[UInt] = {
            val x4441_wr_ofs0 = List[UInt](block3chunk0("x4426").asInstanceOf[FixedPoint].r,block3chunk0("x4429").asInstanceOf[FixedPoint].r,block3chunk0("x4432").asInstanceOf[FixedPoint].r,block3chunk0("x4435").asInstanceOf[FixedPoint].r)
            x4441_wr_ofs0
          }
          val x4441_wr_ofs = create_x4441_wr_ofs()
          def create_x4441_wr_en(): List[Bool] = {
            val x4441_wr_en0 = List[Bool](block3chunk0("x19689").asInstanceOf[Bool] & block3chunk0("x19687").asInstanceOf[Bool],block3chunk0("x19691").asInstanceOf[Bool] & block3chunk0("x19685").asInstanceOf[Bool])
            val x4441_wr_en1 = List[Bool](block3chunk0("x19686").asInstanceOf[Bool] & block3chunk0("x19684").asInstanceOf[Bool],block3chunk0("x19688").asInstanceOf[Bool] & block3chunk0("x19690").asInstanceOf[Bool])
            x4441_wr_en0 ++ x4441_wr_en1
          }
          val x4441_wr_en = create_x4441_wr_en()
          def create_x4441_wr_data(): List[UInt] = {
            val x4441_wr_data0 = List[UInt](block3chunk0("x4418_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x4419_elem_1").asInstanceOf[FixedPoint].r,block3chunk0("x4420_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x4421_elem_3").asInstanceOf[FixedPoint].r)
            x4441_wr_data0
          }
          val x4441_wr_data = create_x4441_wr_data()
          x4323_img2D_1.connectWPort(4441, x4441_wr_banks, x4441_wr_ofs, x4441_wr_data, x4441_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x4442_wr_banks(): List[UInt] = {
            val x4442_wr_banks0 = List[UInt](block3chunk0("x18878").asInstanceOf[FixedPoint].r,block3chunk0("x18879").asInstanceOf[FixedPoint].r,block3chunk0("x18880").asInstanceOf[FixedPoint].r,block3chunk0("x18881").asInstanceOf[FixedPoint].r)
            x4442_wr_banks0
          }
          val x4442_wr_banks = create_x4442_wr_banks()
          def create_x4442_wr_ofs(): List[UInt] = {
            val x4442_wr_ofs0 = List[UInt](block3chunk0("x4426").asInstanceOf[FixedPoint].r,block3chunk0("x4429").asInstanceOf[FixedPoint].r,block3chunk0("x4432").asInstanceOf[FixedPoint].r,block3chunk0("x4435").asInstanceOf[FixedPoint].r)
            x4442_wr_ofs0
          }
          val x4442_wr_ofs = create_x4442_wr_ofs()
          def create_x4442_wr_en(): List[Bool] = {
            val x4442_wr_en0 = List[Bool](block3chunk0("x19689").asInstanceOf[Bool] & block3chunk0("x19687").asInstanceOf[Bool],block3chunk0("x19691").asInstanceOf[Bool] & block3chunk0("x19685").asInstanceOf[Bool])
            val x4442_wr_en1 = List[Bool](block3chunk0("x19686").asInstanceOf[Bool] & block3chunk0("x19684").asInstanceOf[Bool],block3chunk0("x19688").asInstanceOf[Bool] & block3chunk0("x19690").asInstanceOf[Bool])
            x4442_wr_en0 ++ x4442_wr_en1
          }
          val x4442_wr_en = create_x4442_wr_en()
          def create_x4442_wr_data(): List[UInt] = {
            val x4442_wr_data0 = List[UInt](block3chunk0("x4418_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x4419_elem_1").asInstanceOf[FixedPoint].r,block3chunk0("x4420_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x4421_elem_3").asInstanceOf[FixedPoint].r)
            x4442_wr_data0
          }
          val x4442_wr_data = create_x4442_wr_data()
          x4327_img2D_5.connectWPort(4442, x4442_wr_banks, x4442_wr_ofs, x4442_wr_data, x4442_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x4443_wr_banks(): List[UInt] = {
            val x4443_wr_banks0 = List[UInt](block3chunk0("x18878").asInstanceOf[FixedPoint].r,block3chunk0("x18879").asInstanceOf[FixedPoint].r,block3chunk0("x18880").asInstanceOf[FixedPoint].r,block3chunk0("x18881").asInstanceOf[FixedPoint].r)
            x4443_wr_banks0
          }
          val x4443_wr_banks = create_x4443_wr_banks()
          def create_x4443_wr_ofs(): List[UInt] = {
            val x4443_wr_ofs0 = List[UInt](block3chunk0("x4426").asInstanceOf[FixedPoint].r,block3chunk0("x4429").asInstanceOf[FixedPoint].r,block3chunk0("x4432").asInstanceOf[FixedPoint].r,block3chunk0("x4435").asInstanceOf[FixedPoint].r)
            x4443_wr_ofs0
          }
          val x4443_wr_ofs = create_x4443_wr_ofs()
          def create_x4443_wr_en(): List[Bool] = {
            val x4443_wr_en0 = List[Bool](block3chunk0("x19689").asInstanceOf[Bool] & block3chunk0("x19687").asInstanceOf[Bool],block3chunk0("x19691").asInstanceOf[Bool] & block3chunk0("x19685").asInstanceOf[Bool])
            val x4443_wr_en1 = List[Bool](block3chunk0("x19686").asInstanceOf[Bool] & block3chunk0("x19684").asInstanceOf[Bool],block3chunk0("x19688").asInstanceOf[Bool] & block3chunk0("x19690").asInstanceOf[Bool])
            x4443_wr_en0 ++ x4443_wr_en1
          }
          val x4443_wr_en = create_x4443_wr_en()
          def create_x4443_wr_data(): List[UInt] = {
            val x4443_wr_data0 = List[UInt](block3chunk0("x4418_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x4419_elem_1").asInstanceOf[FixedPoint].r,block3chunk0("x4420_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x4421_elem_3").asInstanceOf[FixedPoint].r)
            x4443_wr_data0
          }
          val x4443_wr_data = create_x4443_wr_data()
          x4328_img2D_6.connectWPort(4443, x4443_wr_banks, x4443_wr_ofs, x4443_wr_data, x4443_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x4444_wr_banks(): List[UInt] = {
            val x4444_wr_banks0 = List[UInt](block3chunk0("x18878").asInstanceOf[FixedPoint].r,block3chunk0("x18879").asInstanceOf[FixedPoint].r,block3chunk0("x18880").asInstanceOf[FixedPoint].r,block3chunk0("x18881").asInstanceOf[FixedPoint].r)
            x4444_wr_banks0
          }
          val x4444_wr_banks = create_x4444_wr_banks()
          def create_x4444_wr_ofs(): List[UInt] = {
            val x4444_wr_ofs0 = List[UInt](block3chunk0("x4426").asInstanceOf[FixedPoint].r,block3chunk0("x4429").asInstanceOf[FixedPoint].r,block3chunk0("x4432").asInstanceOf[FixedPoint].r,block3chunk0("x4435").asInstanceOf[FixedPoint].r)
            x4444_wr_ofs0
          }
          val x4444_wr_ofs = create_x4444_wr_ofs()
          def create_x4444_wr_en(): List[Bool] = {
            val x4444_wr_en0 = List[Bool](block3chunk0("x19689").asInstanceOf[Bool] & block3chunk0("x19687").asInstanceOf[Bool],block3chunk0("x19691").asInstanceOf[Bool] & block3chunk0("x19685").asInstanceOf[Bool])
            val x4444_wr_en1 = List[Bool](block3chunk0("x19686").asInstanceOf[Bool] & block3chunk0("x19684").asInstanceOf[Bool],block3chunk0("x19688").asInstanceOf[Bool] & block3chunk0("x19690").asInstanceOf[Bool])
            x4444_wr_en0 ++ x4444_wr_en1
          }
          val x4444_wr_en = create_x4444_wr_en()
          def create_x4444_wr_data(): List[UInt] = {
            val x4444_wr_data0 = List[UInt](block3chunk0("x4418_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x4419_elem_1").asInstanceOf[FixedPoint].r,block3chunk0("x4420_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x4421_elem_3").asInstanceOf[FixedPoint].r)
            x4444_wr_data0
          }
          val x4444_wr_data = create_x4444_wr_data()
          x4324_img2D_2.connectWPort(4444, x4444_wr_banks, x4444_wr_ofs, x4444_wr_data, x4444_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x4445_wr_banks(): List[UInt] = {
            val x4445_wr_banks0 = List[UInt](block3chunk0("x18878").asInstanceOf[FixedPoint].r,block3chunk0("x18879").asInstanceOf[FixedPoint].r,block3chunk0("x18880").asInstanceOf[FixedPoint].r,block3chunk0("x18881").asInstanceOf[FixedPoint].r)
            x4445_wr_banks0
          }
          val x4445_wr_banks = create_x4445_wr_banks()
          def create_x4445_wr_ofs(): List[UInt] = {
            val x4445_wr_ofs0 = List[UInt](block3chunk0("x4426").asInstanceOf[FixedPoint].r,block3chunk0("x4429").asInstanceOf[FixedPoint].r,block3chunk0("x4432").asInstanceOf[FixedPoint].r,block3chunk0("x4435").asInstanceOf[FixedPoint].r)
            x4445_wr_ofs0
          }
          val x4445_wr_ofs = create_x4445_wr_ofs()
          def create_x4445_wr_en(): List[Bool] = {
            val x4445_wr_en0 = List[Bool](block3chunk0("x19689").asInstanceOf[Bool] & block3chunk0("x19687").asInstanceOf[Bool],block3chunk0("x19691").asInstanceOf[Bool] & block3chunk0("x19685").asInstanceOf[Bool])
            val x4445_wr_en1 = List[Bool](block3chunk0("x19686").asInstanceOf[Bool] & block3chunk0("x19684").asInstanceOf[Bool],block3chunk0("x19688").asInstanceOf[Bool] & block3chunk0("x19690").asInstanceOf[Bool])
            x4445_wr_en0 ++ x4445_wr_en1
          }
          val x4445_wr_en = create_x4445_wr_en()
          def create_x4445_wr_data(): List[UInt] = {
            val x4445_wr_data0 = List[UInt](block3chunk0("x4418_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x4419_elem_1").asInstanceOf[FixedPoint].r,block3chunk0("x4420_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x4421_elem_3").asInstanceOf[FixedPoint].r)
            x4445_wr_data0
          }
          val x4445_wr_data = create_x4445_wr_data()
          x4325_img2D_3.connectWPort(4445, x4445_wr_banks, x4445_wr_ofs, x4445_wr_data, x4445_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          def create_x4446_wr_banks(): List[UInt] = {
            val x4446_wr_banks0 = List[UInt](block3chunk0("x18878").asInstanceOf[FixedPoint].r,block3chunk0("x18879").asInstanceOf[FixedPoint].r,block3chunk0("x18880").asInstanceOf[FixedPoint].r,block3chunk0("x18881").asInstanceOf[FixedPoint].r)
            x4446_wr_banks0
          }
          val x4446_wr_banks = create_x4446_wr_banks()
          def create_x4446_wr_ofs(): List[UInt] = {
            val x4446_wr_ofs0 = List[UInt](block3chunk0("x4426").asInstanceOf[FixedPoint].r,block3chunk0("x4429").asInstanceOf[FixedPoint].r,block3chunk0("x4432").asInstanceOf[FixedPoint].r,block3chunk0("x4435").asInstanceOf[FixedPoint].r)
            x4446_wr_ofs0
          }
          val x4446_wr_ofs = create_x4446_wr_ofs()
          def create_x4446_wr_en(): List[Bool] = {
            val x4446_wr_en0 = List[Bool](block3chunk0("x19689").asInstanceOf[Bool] & block3chunk0("x19687").asInstanceOf[Bool],block3chunk0("x19691").asInstanceOf[Bool] & block3chunk0("x19685").asInstanceOf[Bool])
            val x4446_wr_en1 = List[Bool](block3chunk0("x19686").asInstanceOf[Bool] & block3chunk0("x19684").asInstanceOf[Bool],block3chunk0("x19688").asInstanceOf[Bool] & block3chunk0("x19690").asInstanceOf[Bool])
            x4446_wr_en0 ++ x4446_wr_en1
          }
          val x4446_wr_en = create_x4446_wr_en()
          def create_x4446_wr_data(): List[UInt] = {
            val x4446_wr_data0 = List[UInt](block3chunk0("x4418_elem_0").asInstanceOf[FixedPoint].r,block3chunk0("x4419_elem_1").asInstanceOf[FixedPoint].r,block3chunk0("x4420_elem_2").asInstanceOf[FixedPoint].r,block3chunk0("x4421_elem_3").asInstanceOf[FixedPoint].r)
            x4446_wr_data0
          }
          val x4446_wr_data = create_x4446_wr_data()
          x4330_img2D_8.connectWPort(4446, x4446_wr_banks, x4446_wr_ofs, x4446_wr_data, x4446_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
          Map[String,Any]()
        }
      }
      val block3chunk1: Map[String, Any] = Block3Chunker1.gen()
    }
    val module = Module(new x4447_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x4447_inr_Foreach **/
