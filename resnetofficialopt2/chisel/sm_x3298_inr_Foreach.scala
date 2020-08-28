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

/** Hierarchy: x3298 -> x3299 -> x3300 -> x3699 -> x3700 -> x3898 -> x1256 **/
/** BEGIN None x3298_inr_Foreach **/
class x3298_inr_Foreach_kernel(
  list_b3228: List[FixedPoint],
  list_x3232: List[DecoupledIO[AppLoadData]],
  list_x3216_lb0_0: List[NBufInterface],
  list_x3263_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x3298_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3298_inr_Foreach_iiCtr"))
  
  abstract class x3298_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3263_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3263_reg_p").asInstanceOf[MemParams] ))
      val in_x3216_lb0_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3216_lb0_0_p").asInstanceOf[NBufParams] ))
      val in_b3228 = Input(new FixedPoint(true, 32, 0))
      val in_x3232 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3232_p").asInstanceOf[(Int, Int)] )))
      val in_x3264_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3264_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3263_reg = {io.in_x3263_reg} ; io.in_x3263_reg := DontCare
    def x3216_lb0_0 = {io.in_x3216_lb0_0} ; io.in_x3216_lb0_0 := DontCare
    def b3228 = {io.in_b3228} 
    def x3232 = {io.in_x3232} 
    def x3264_reg = {io.in_x3264_reg} ; io.in_x3264_reg := DontCare
  }
  def connectWires0(module: x3298_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x3263_reg.connectLedger(module.io.in_x3263_reg)
    x3216_lb0_0.connectLedger(module.io.in_x3216_lb0_0)
    module.io.in_b3228 <> b3228
    module.io.in_x3232 <> x3232
    x3264_reg.connectLedger(module.io.in_x3264_reg)
  }
  val b3228 = list_b3228(0)
  val x3232 = list_x3232(0)
  val x3216_lb0_0 = list_x3216_lb0_0(0)
  val x3263_reg = list_x3263_reg(0)
  val x3264_reg = list_x3263_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3298_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3298_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3298_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3278 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b3278.suggestName("b3278")
      val b3279 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b3279.suggestName("b3279")
      val b3280 = ~io.sigsIn.cchainOutputs.head.oobs(0); b3280.suggestName("b3280")
      val b3281 = ~io.sigsIn.cchainOutputs.head.oobs(1); b3281.suggestName("b3281")
      val x3282_rd_x3263 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3282_rd_x3263""")
      val x3282_rd_x3263_banks = List[UInt]()
      val x3282_rd_x3263_ofs = List[UInt]()
      val x3282_rd_x3263_en = List[Bool](true.B)
      x3282_rd_x3263.toSeq.zip(x3263_reg.connectRPort(3282, x3282_rd_x3263_banks, x3282_rd_x3263_ofs, io.sigsIn.backpressure, x3282_rd_x3263_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x3284 = Wire(Bool()).suggestName("""x3284""")
      x3284.r := Math.lte(x3282_rd_x3263, b3278, Some(0.4), true.B,"x3284").r
      val x3285 = Wire(Bool()).suggestName("""x3285""")
      x3285.r := Math.lte(x3282_rd_x3263, b3279, Some(0.4), true.B,"x3285").r
      val x3286_rd_x3264 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3286_rd_x3264""")
      val x3286_rd_x3264_banks = List[UInt]()
      val x3286_rd_x3264_ofs = List[UInt]()
      val x3286_rd_x3264_en = List[Bool](true.B)
      x3286_rd_x3264.toSeq.zip(x3264_reg.connectRPort(3286, x3286_rd_x3264_banks, x3286_rd_x3264_ofs, io.sigsIn.backpressure, x3286_rd_x3264_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x3288 = Wire(Bool()).suggestName("""x3288""")
      x3288.r := Math.lt(b3278, x3286_rd_x3264, Some(0.4), true.B,"x3288").r
      val x3289 = Wire(Bool()).suggestName("""x3289""")
      x3289.r := Math.lt(b3279, x3286_rd_x3264, Some(0.4), true.B,"x3289").r
      val x3290 = Wire(Bool()).suggestName("""x3290""")
      x3290 := x3284 & x3288
      val x3291 = Wire(Bool()).suggestName("""x3291""")
      x3291 := x3285 & x3289
      val x3294 = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x3294""")
      x3232.ready := b3280 & b3281 & (io.sigsIn.datapathEn) 
      (0 until 2).map{ i => x3294(i).r := x3232.bits.rdata(i).r }
      val x19405 = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("x19405_x3294_D1") 
      (0 until 2).foreach{i => x19405(i).r := getRetimed(x3294(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x3295_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3295_elem_0""")
      x3295_elem_0.r := x19405(0).r
      val x3296_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3296_elem_1""")
      x3296_elem_1.r := x19405(1).r
      val x19406 = Wire(Bool()).suggestName("x19406_b3281_D1") 
      x19406.r := getRetimed(b3281.r, 1.toInt, io.sigsIn.backpressure)
      val x19407 = Wire(Bool()).suggestName("x19407_b3280_D1") 
      x19407.r := getRetimed(b3280.r, 1.toInt, io.sigsIn.backpressure)
      val x19408 = Wire(Bool()).suggestName("x19408_x3290_D1") 
      x19408.r := getRetimed(x3290.r, 1.toInt, io.sigsIn.backpressure)
      val x19409 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19409_b3228_D1") 
      x19409.r := getRetimed(b3228.r, 1.toInt, io.sigsIn.backpressure)
      val x19410 = Wire(Bool()).suggestName("x19410_x3291_D1") 
      x19410.r := getRetimed(x3291.r, 1.toInt, io.sigsIn.backpressure)
      val x3297_banks = List[UInt](x19409.r)
      val x3297_ofs = List[UInt]()
      val x3297_en = List[Bool](x19408 & x19407,x19410 & x19406)
      val x3297_data = List[UInt](x3295_elem_0.r,x3296_elem_1.r)
      x3216_lb0_0.connectWPort(3297, x3297_banks, x3297_ofs, x3297_data, x3297_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x3298_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3298_inr_Foreach **/
