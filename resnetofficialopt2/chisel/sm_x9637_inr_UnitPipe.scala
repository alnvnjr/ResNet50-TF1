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

/** Hierarchy: x9637 -> x9765 -> x9766 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9637_inr_UnitPipe **/
class x9637_inr_UnitPipe_kernel(
  list_x9594_fifo: List[FIFOInterface],
  list_x9626_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.0.toInt, myName = "x9637_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9637_inr_UnitPipe_iiCtr"))
  
  abstract class x9637_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9626_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9626_reg_p").asInstanceOf[MemParams] ))
      val in_x9594_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x9594_fifo_p").asInstanceOf[MemParams] ))
      val in_x9627_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9627_reg_p").asInstanceOf[MemParams] ))
      val in_x9628_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9628_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9626_reg = {io.in_x9626_reg} ; io.in_x9626_reg := DontCare
    def x9594_fifo = {io.in_x9594_fifo} ; io.in_x9594_fifo := DontCare
    def x9627_reg = {io.in_x9627_reg} ; io.in_x9627_reg := DontCare
    def x9628_reg = {io.in_x9628_reg} ; io.in_x9628_reg := DontCare
  }
  def connectWires0(module: x9637_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x9626_reg.connectLedger(module.io.in_x9626_reg)
    x9594_fifo.connectLedger(module.io.in_x9594_fifo)
    x9627_reg.connectLedger(module.io.in_x9627_reg)
    x9628_reg.connectLedger(module.io.in_x9628_reg)
  }
  val x9594_fifo = list_x9594_fifo(0)
  val x9626_reg = list_x9626_reg(0)
  val x9627_reg = list_x9626_reg(1)
  val x9628_reg = list_x9626_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9637_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9637_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9637_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9629_deq_x9594 = Wire(Vec(1, UInt(96.W))).suggestName("""x9629_deq_x9594""")
      val x9629_deq_x9594_banks = List[UInt]()
      val x9629_deq_x9594_ofs = List[UInt]()
      val x9629_deq_x9594_en = List[Bool](true.B)
      x9629_deq_x9594.toSeq.zip(x9594_fifo.connectRPort(9629, x9629_deq_x9594_banks, x9629_deq_x9594_ofs, io.sigsIn.backpressure, x9629_deq_x9594_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      x9594_fifo.connectAccessActivesIn(1, ((true.B)))
      val x20659 = Wire(Vec(1, UInt(96.W))).suggestName("x20659_x9629_deq_x9594_D2") 
      (0 until 1).foreach{i => x20659(i).r := getRetimed(x9629_deq_x9594(i).r, 2.toInt, io.sigsIn.backpressure)}
      val x9630_elem_0 = Wire(UInt(96.W)).suggestName("""x9630_elem_0""")
      x9630_elem_0.r := x20659(0).r
      val x9631_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9631_apply""")
      x9631_apply.r := x9630_elem_0(63, 32)
      val x9632_wr_x9626_banks = List[UInt]()
      val x9632_wr_x9626_ofs = List[UInt]()
      val x9632_wr_x9626_en = List[Bool](true.B)
      val x9632_wr_x9626_data = List[UInt](x9631_apply.r)
      x9626_reg.connectWPort(9632, x9632_wr_x9626_banks, x9632_wr_x9626_ofs, x9632_wr_x9626_data, x9632_wr_x9626_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x9633_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9633_apply""")
      x9633_apply.r := x9630_elem_0(95, 64)
      val x9634_wr_x9627_banks = List[UInt]()
      val x9634_wr_x9627_ofs = List[UInt]()
      val x9634_wr_x9627_en = List[Bool](true.B)
      val x9634_wr_x9627_data = List[UInt](x9633_apply.r)
      x9627_reg.connectWPort(9634, x9634_wr_x9627_banks, x9634_wr_x9627_ofs, x9634_wr_x9627_data, x9634_wr_x9627_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x9635_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9635_apply""")
      x9635_apply.r := x9630_elem_0(31, 0)
      val x9636_wr_x9628_banks = List[UInt]()
      val x9636_wr_x9628_ofs = List[UInt]()
      val x9636_wr_x9628_en = List[Bool](true.B)
      val x9636_wr_x9628_data = List[UInt](x9635_apply.r)
      x9628_reg.connectWPort(9636, x9636_wr_x9628_banks, x9636_wr_x9628_ofs, x9636_wr_x9628_data, x9636_wr_x9628_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x9637_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9637_inr_UnitPipe **/
