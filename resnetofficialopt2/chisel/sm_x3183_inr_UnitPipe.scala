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

/** Hierarchy: x3183 -> x3210 -> x3211 -> x3898 -> x1256 **/
/** BEGIN None x3183_inr_UnitPipe **/
class x3183_inr_UnitPipe_kernel(
  list_x3141_fifo: List[FIFOInterface],
  list_x3172_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.0.toInt, myName = "x3183_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3183_inr_UnitPipe_iiCtr"))
  
  abstract class x3183_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3172_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3172_reg_p").asInstanceOf[MemParams] ))
      val in_x3141_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x3141_fifo_p").asInstanceOf[MemParams] ))
      val in_x3173_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3173_reg_p").asInstanceOf[MemParams] ))
      val in_x3174_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3174_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3172_reg = {io.in_x3172_reg} ; io.in_x3172_reg := DontCare
    def x3141_fifo = {io.in_x3141_fifo} ; io.in_x3141_fifo := DontCare
    def x3173_reg = {io.in_x3173_reg} ; io.in_x3173_reg := DontCare
    def x3174_reg = {io.in_x3174_reg} ; io.in_x3174_reg := DontCare
  }
  def connectWires0(module: x3183_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3172_reg.connectLedger(module.io.in_x3172_reg)
    x3141_fifo.connectLedger(module.io.in_x3141_fifo)
    x3173_reg.connectLedger(module.io.in_x3173_reg)
    x3174_reg.connectLedger(module.io.in_x3174_reg)
  }
  val x3141_fifo = list_x3141_fifo(0)
  val x3172_reg = list_x3172_reg(0)
  val x3173_reg = list_x3172_reg(1)
  val x3174_reg = list_x3172_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3183_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3183_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3183_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3175_deq_x3141 = Wire(Vec(1, UInt(96.W))).suggestName("""x3175_deq_x3141""")
      val x3175_deq_x3141_banks = List[UInt]()
      val x3175_deq_x3141_ofs = List[UInt]()
      val x3175_deq_x3141_en = List[Bool](true.B)
      x3175_deq_x3141.toSeq.zip(x3141_fifo.connectRPort(3175, x3175_deq_x3141_banks, x3175_deq_x3141_ofs, io.sigsIn.backpressure, x3175_deq_x3141_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      x3141_fifo.connectAccessActivesIn(1, ((true.B)))
      val x19388 = Wire(Vec(1, UInt(96.W))).suggestName("x19388_x3175_deq_x3141_D2") 
      (0 until 1).foreach{i => x19388(i).r := getRetimed(x3175_deq_x3141(i).r, 2.toInt, io.sigsIn.backpressure)}
      val x3176_elem_0 = Wire(UInt(96.W)).suggestName("""x3176_elem_0""")
      x3176_elem_0.r := x19388(0).r
      val x3177_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3177_apply""")
      x3177_apply.r := x3176_elem_0(63, 32)
      val x3178_wr_x3172_banks = List[UInt]()
      val x3178_wr_x3172_ofs = List[UInt]()
      val x3178_wr_x3172_en = List[Bool](true.B)
      val x3178_wr_x3172_data = List[UInt](x3177_apply.r)
      x3172_reg.connectWPort(3178, x3178_wr_x3172_banks, x3178_wr_x3172_ofs, x3178_wr_x3172_data, x3178_wr_x3172_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x3179_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3179_apply""")
      x3179_apply.r := x3176_elem_0(95, 64)
      val x3180_wr_x3173_banks = List[UInt]()
      val x3180_wr_x3173_ofs = List[UInt]()
      val x3180_wr_x3173_en = List[Bool](true.B)
      val x3180_wr_x3173_data = List[UInt](x3179_apply.r)
      x3173_reg.connectWPort(3180, x3180_wr_x3173_banks, x3180_wr_x3173_ofs, x3180_wr_x3173_data, x3180_wr_x3173_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x3181_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3181_apply""")
      x3181_apply.r := x3176_elem_0(31, 0)
      val x3182_wr_x3174_banks = List[UInt]()
      val x3182_wr_x3174_ofs = List[UInt]()
      val x3182_wr_x3174_en = List[Bool](true.B)
      val x3182_wr_x3174_data = List[UInt](x3181_apply.r)
      x3174_reg.connectWPort(3182, x3182_wr_x3174_banks, x3182_wr_x3174_ofs, x3182_wr_x3174_data, x3182_wr_x3174_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x3183_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3183_inr_UnitPipe **/
