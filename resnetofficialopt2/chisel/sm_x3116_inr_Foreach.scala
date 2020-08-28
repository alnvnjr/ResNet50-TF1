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

/** Hierarchy: x3116 -> x3117 -> x1256 **/
/** BEGIN None x3116_inr_Foreach **/
class x3116_inr_Foreach_kernel(
  list_x3100: List[DecoupledIO[AppLoadData]],
  list_x3098_c27_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x3116_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3116_inr_Foreach_iiCtr"))
  
  abstract class x3116_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3098_c27_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3098_c27_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x3100 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3100_p").asInstanceOf[(Int, Int)] )))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3098_c27_SRAM_0 = {io.in_x3098_c27_SRAM_0} ; io.in_x3098_c27_SRAM_0 := DontCare
    def x3100 = {io.in_x3100} 
  }
  def connectWires0(module: x3116_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x3098_c27_SRAM_0.connectLedger(module.io.in_x3098_c27_SRAM_0)
    module.io.in_x3100 <> x3100
  }
  val x3100 = list_x3100(0)
  val x3098_c27_SRAM_0 = list_x3098_c27_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3116_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3116_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3116_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3109 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b3109.suggestName("b3109")
      val b3110 = ~io.sigsIn.cchainOutputs.head.oobs(0); b3110.suggestName("b3110")
      val x3111 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3111""")
      x3100.ready := b3110 & (io.sigsIn.datapathEn) 
      (0 until 1).map{ i => x3111(i).r := x3100.bits.rdata(i).r }
      val x19376 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("x19376_x3111_D1") 
      (0 until 1).foreach{i => x19376(i).r := getRetimed(x3111(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x3112_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3112_elem_0""")
      x3112_elem_0.r := x19376(0).r
      val x19377 = Wire(Bool()).suggestName("x19377_b3110_D1") 
      x19377.r := getRetimed(b3110.r, 1.toInt, io.sigsIn.backpressure)
      val x19378 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19378_b3109_D1") 
      x19378.r := getRetimed(b3109.r, 1.toInt, io.sigsIn.backpressure)
      val x3115_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x3115_wr_ofs = List[UInt](x19378.r)
      val x3115_wr_en = List[Bool](true.B)
      val x3115_wr_data = List[UInt](x3112_elem_0.r)
      x3098_c27_SRAM_0.connectWPort(3115, x3115_wr_banks, x3115_wr_ofs, x3115_wr_data, x3115_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19377))
    }
    val module = Module(new x3116_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3116_inr_Foreach **/
