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

/** Hierarchy: x18431 -> x18449 -> x18450 -> x18477 -> x1256 **/
/** BEGIN None x18431_inr_UnitPipe **/
class x18431_inr_UnitPipe_kernel(
  list_x18389_fifo: List[FIFOInterface],
  list_x18420_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.0.toInt, myName = "x18431_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18431_inr_UnitPipe_iiCtr"))
  
  abstract class x18431_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18420_reg = Flipped(new StandardInterface(ModuleParams.getParams("x18420_reg_p").asInstanceOf[MemParams] ))
      val in_x18421_reg = Flipped(new StandardInterface(ModuleParams.getParams("x18421_reg_p").asInstanceOf[MemParams] ))
      val in_x18389_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x18389_fifo_p").asInstanceOf[MemParams] ))
      val in_x18422_reg = Flipped(new StandardInterface(ModuleParams.getParams("x18422_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18420_reg = {io.in_x18420_reg} ; io.in_x18420_reg := DontCare
    def x18421_reg = {io.in_x18421_reg} ; io.in_x18421_reg := DontCare
    def x18389_fifo = {io.in_x18389_fifo} ; io.in_x18389_fifo := DontCare
    def x18422_reg = {io.in_x18422_reg} ; io.in_x18422_reg := DontCare
  }
  def connectWires0(module: x18431_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x18420_reg.connectLedger(module.io.in_x18420_reg)
    x18421_reg.connectLedger(module.io.in_x18421_reg)
    x18389_fifo.connectLedger(module.io.in_x18389_fifo)
    x18422_reg.connectLedger(module.io.in_x18422_reg)
  }
  val x18389_fifo = list_x18389_fifo(0)
  val x18420_reg = list_x18420_reg(0)
  val x18421_reg = list_x18420_reg(1)
  val x18422_reg = list_x18420_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18431_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18431_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18431_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18423_deq_x18389 = Wire(Vec(1, UInt(96.W))).suggestName("""x18423_deq_x18389""")
      val x18423_deq_x18389_banks = List[UInt]()
      val x18423_deq_x18389_ofs = List[UInt]()
      val x18423_deq_x18389_en = List[Bool](true.B)
      x18423_deq_x18389.toSeq.zip(x18389_fifo.connectRPort(18423, x18423_deq_x18389_banks, x18423_deq_x18389_ofs, io.sigsIn.backpressure, x18423_deq_x18389_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      x18389_fifo.connectAccessActivesIn(1, ((true.B)))
      val x21991 = Wire(Vec(1, UInt(96.W))).suggestName("x21991_x18423_deq_x18389_D2") 
      (0 until 1).foreach{i => x21991(i).r := getRetimed(x18423_deq_x18389(i).r, 2.toInt, io.sigsIn.backpressure)}
      val x18424_elem_0 = Wire(UInt(96.W)).suggestName("""x18424_elem_0""")
      x18424_elem_0.r := x21991(0).r
      val x18425_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18425_apply""")
      x18425_apply.r := x18424_elem_0(63, 32)
      val x18426_wr_x18420_banks = List[UInt]()
      val x18426_wr_x18420_ofs = List[UInt]()
      val x18426_wr_x18420_en = List[Bool](true.B)
      val x18426_wr_x18420_data = List[UInt](x18425_apply.r)
      x18420_reg.connectWPort(18426, x18426_wr_x18420_banks, x18426_wr_x18420_ofs, x18426_wr_x18420_data, x18426_wr_x18420_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x18427_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18427_apply""")
      x18427_apply.r := x18424_elem_0(95, 64)
      val x18428_wr_x18421_banks = List[UInt]()
      val x18428_wr_x18421_ofs = List[UInt]()
      val x18428_wr_x18421_en = List[Bool](true.B)
      val x18428_wr_x18421_data = List[UInt](x18427_apply.r)
      x18421_reg.connectWPort(18428, x18428_wr_x18421_banks, x18428_wr_x18421_ofs, x18428_wr_x18421_data, x18428_wr_x18421_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x18429_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18429_apply""")
      x18429_apply.r := x18424_elem_0(31, 0)
      val x18430_wr_x18422_banks = List[UInt]()
      val x18430_wr_x18422_ofs = List[UInt]()
      val x18430_wr_x18422_en = List[Bool](true.B)
      val x18430_wr_x18422_data = List[UInt](x18429_apply.r)
      x18422_reg.connectWPort(18430, x18430_wr_x18422_banks, x18430_wr_x18422_ofs, x18430_wr_x18422_data, x18430_wr_x18422_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x18431_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18431_inr_UnitPipe **/
