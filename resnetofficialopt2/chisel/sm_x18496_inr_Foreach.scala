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

/** Hierarchy: x18496 -> x18497 -> x1256 **/
/** BEGIN None x18496_inr_Foreach **/
class x18496_inr_Foreach_kernel(
  list_x18480: List[DecoupledIO[AppLoadData]],
  list_x18478_c87_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x18496_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18496_inr_Foreach_iiCtr"))
  
  abstract class x18496_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18480 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18480_p").asInstanceOf[(Int, Int)] )))
      val in_x18478_c87_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18478_c87_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18480 = {io.in_x18480} 
    def x18478_c87_SRAM_0 = {io.in_x18478_c87_SRAM_0} ; io.in_x18478_c87_SRAM_0 := DontCare
  }
  def connectWires0(module: x18496_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18480 <> x18480
    x18478_c87_SRAM_0.connectLedger(module.io.in_x18478_c87_SRAM_0)
  }
  val x18480 = list_x18480(0)
  val x18478_c87_SRAM_0 = list_x18478_c87_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18496_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x18496_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18496_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b18489 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b18489.suggestName("b18489")
      val b18490 = ~io.sigsIn.cchainOutputs.head.oobs(0); b18490.suggestName("b18490")
      val x18491 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x18491""")
      x18480.ready := b18490 & (io.sigsIn.datapathEn) 
      (0 until 1).map{ i => x18491(i).r := x18480.bits.rdata(i).r }
      val x21996 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("x21996_x18491_D1") 
      (0 until 1).foreach{i => x21996(i).r := getRetimed(x18491(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x18492_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18492_elem_0""")
      x18492_elem_0.r := x21996(0).r
      val x21997 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21997_b18489_D1") 
      x21997.r := getRetimed(b18489.r, 1.toInt, io.sigsIn.backpressure)
      val x21998 = Wire(Bool()).suggestName("x21998_b18490_D1") 
      x21998.r := getRetimed(b18490.r, 1.toInt, io.sigsIn.backpressure)
      val x18495_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x18495_wr_ofs = List[UInt](x21997.r)
      val x18495_wr_en = List[Bool](true.B)
      val x18495_wr_data = List[UInt](x18492_elem_0.r)
      x18478_c87_SRAM_0.connectWPort(18495, x18495_wr_banks, x18495_wr_ofs, x18495_wr_data, x18495_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x21998))
    }
    val module = Module(new x18496_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x18496_inr_Foreach **/
