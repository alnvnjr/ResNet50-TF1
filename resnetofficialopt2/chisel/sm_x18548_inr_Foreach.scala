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

/** Hierarchy: x18548 -> x18549 -> x18620 -> x1256 **/
/** BEGIN None x18548_inr_Foreach **/
class x18548_inr_Foreach_kernel(
  list_x18505: List[DecoupledIO[AppLoadData]],
  list_x18503_c90_row_SRAM_0: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x18548_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18548_inr_Foreach_iiCtr"))
  
  abstract class x18548_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18503_c90_row_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x18503_c90_row_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x18505 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18505_p").asInstanceOf[(Int, Int)] )))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(4), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18503_c90_row_SRAM_0 = {io.in_x18503_c90_row_SRAM_0} ; io.in_x18503_c90_row_SRAM_0 := DontCare
    def x18505 = {io.in_x18505} 
  }
  def connectWires0(module: x18548_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x18503_c90_row_SRAM_0.connectLedger(module.io.in_x18503_c90_row_SRAM_0)
    module.io.in_x18505 <> x18505
  }
  val x18505 = list_x18505(0)
  val x18503_c90_row_SRAM_0 = list_x18503_c90_row_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18548_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x18548_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18548_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b18518 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b18518.suggestName("b18518")
      val b18519 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b18519.suggestName("b18519")
      val b18520 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b18520.suggestName("b18520")
      val b18521 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b18521.suggestName("b18521")
      val b18522 = ~io.sigsIn.cchainOutputs.head.oobs(0); b18522.suggestName("b18522")
      val b18523 = ~io.sigsIn.cchainOutputs.head.oobs(1); b18523.suggestName("b18523")
      val b18524 = ~io.sigsIn.cchainOutputs.head.oobs(2); b18524.suggestName("b18524")
      val b18525 = ~io.sigsIn.cchainOutputs.head.oobs(3); b18525.suggestName("b18525")
      val x18526 = Wire(Vec(4, new FixedPoint(true, 10, 22))).suggestName("""x18526""")
      x18505.ready := b18522 & b18523 & b18524 & b18525 & (io.sigsIn.datapathEn) 
      (0 until 4).map{ i => x18526(i).r := x18505.bits.rdata(i).r }
      val x22000 = Wire(Vec(4, new FixedPoint(true, 10, 22))).suggestName("x22000_x18526_D1") 
      (0 until 4).foreach{i => x22000(i).r := getRetimed(x18526(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x18527_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18527_elem_0""")
      x18527_elem_0.r := x22000(0).r
      val x18528_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18528_elem_1""")
      x18528_elem_1.r := x22000(1).r
      val x18529_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18529_elem_2""")
      x18529_elem_2.r := x22000(2).r
      val x18530_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18530_elem_3""")
      x18530_elem_3.r := x22000(3).r
      val x18535 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18535""")
      x18535.r := Math.arith_right_shift(b18518, 2, Some(0.2), true.B,"x18535").r
      val x18538 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18538""")
      x18538.r := Math.arith_right_shift(b18519, 2, Some(0.2), true.B,"x18538").r
      val x18541 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18541""")
      x18541.r := Math.arith_right_shift(b18520, 2, Some(0.2), true.B,"x18541").r
      val x18544 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18544""")
      x18544.r := Math.arith_right_shift(b18521, 2, Some(0.2), true.B,"x18544").r
      val x22001 = Wire(Bool()).suggestName("x22001_b18524_D1") 
      x22001.r := getRetimed(b18524.r, 1.toInt, io.sigsIn.backpressure)
      val x22002 = Wire(new FixedPoint(true, 32, 0)).suggestName("x22002_x18535_D1") 
      x22002.r := getRetimed(x18535.r, 1.toInt, io.sigsIn.backpressure)
      val x22003 = Wire(Bool()).suggestName("x22003_b18525_D1") 
      x22003.r := getRetimed(b18525.r, 1.toInt, io.sigsIn.backpressure)
      val x22004 = Wire(new FixedPoint(true, 32, 0)).suggestName("x22004_x18544_D1") 
      x22004.r := getRetimed(x18544.r, 1.toInt, io.sigsIn.backpressure)
      val x22005 = Wire(Bool()).suggestName("x22005_b18522_D1") 
      x22005.r := getRetimed(b18522.r, 1.toInt, io.sigsIn.backpressure)
      val x22006 = Wire(new FixedPoint(true, 32, 0)).suggestName("x22006_x18541_D1") 
      x22006.r := getRetimed(x18541.r, 1.toInt, io.sigsIn.backpressure)
      val x22007 = Wire(new FixedPoint(true, 32, 0)).suggestName("x22007_x18538_D1") 
      x22007.r := getRetimed(x18538.r, 1.toInt, io.sigsIn.backpressure)
      val x22008 = Wire(Bool()).suggestName("x22008_b18523_D1") 
      x22008.r := getRetimed(b18523.r, 1.toInt, io.sigsIn.backpressure)
      val x18547_wr_banks = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
      val x18547_wr_ofs = List[UInt](x22002.r,x22007.r,x22006.r,x22004.r)
      val x18547_wr_en = List[Bool](x22005,x22008,x22001,x22003)
      val x18547_wr_data = List[UInt](x18527_elem_0.r,x18528_elem_1.r,x18529_elem_2.r,x18530_elem_3.r)
      x18503_c90_row_SRAM_0.connectWPort(18547, x18547_wr_banks, x18547_wr_ofs, x18547_wr_data, x18547_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x18548_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x18548_inr_Foreach **/
