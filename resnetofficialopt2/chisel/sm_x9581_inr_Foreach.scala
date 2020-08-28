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

/** Hierarchy: x9581 -> x9582 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9581_inr_Foreach **/
class x9581_inr_Foreach_kernel(
  list_x9561: List[DecoupledIO[AppLoadData]],
  list_x9554_bias_SRAM_0: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x9581_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9581_inr_Foreach_iiCtr"))
  
  abstract class x9581_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9561 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9561_p").asInstanceOf[(Int, Int)] )))
      val in_x9554_bias_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9554_bias_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9561 = {io.in_x9561} 
    def x9554_bias_SRAM_0 = {io.in_x9554_bias_SRAM_0} ; io.in_x9554_bias_SRAM_0 := DontCare
  }
  def connectWires0(module: x9581_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x9561 <> x9561
    x9554_bias_SRAM_0.connectLedger(module.io.in_x9554_bias_SRAM_0)
  }
  val x9561 = list_x9561(0)
  val x9554_bias_SRAM_0 = list_x9554_bias_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9581_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x9581_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9581_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b9574 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b9574.suggestName("b9574")
      val b9575 = ~io.sigsIn.cchainOutputs.head.oobs(0); b9575.suggestName("b9575")
      val x9576 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x9576""")
      x9561.ready := b9575 & (io.sigsIn.datapathEn) 
      (0 until 1).map{ i => x9576(i).r := x9561.bits.rdata(i).r }
      val x20646 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("x20646_x9576_D1") 
      (0 until 1).foreach{i => x20646(i).r := getRetimed(x9576(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x9577_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9577_elem_0""")
      x9577_elem_0.r := x20646(0).r
      val x20647 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20647_b9574_D1") 
      x20647.r := getRetimed(b9574.r, 1.toInt, io.sigsIn.backpressure)
      val x20648 = Wire(Bool()).suggestName("x20648_b9575_D1") 
      x20648.r := getRetimed(b9575.r, 1.toInt, io.sigsIn.backpressure)
      val x9580_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x9580_wr_ofs = List[UInt](x20647.r)
      val x9580_wr_en = List[Bool](true.B)
      val x9580_wr_data = List[UInt](x9577_elem_0.r)
      x9554_bias_SRAM_0.connectWPort(9580, x9580_wr_banks, x9580_wr_ofs, x9580_wr_data, x9580_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x20648))
    }
    val module = Module(new x9581_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x9581_inr_Foreach **/
