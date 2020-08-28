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

/** Hierarchy: x4035 -> x4053 -> x4054 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4035_inr_UnitPipe **/
class x4035_inr_UnitPipe_kernel(
  list_x3994_fifo: List[FIFOInterface],
  list_x4026_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.0.toInt, myName = "x4035_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4035_inr_UnitPipe_iiCtr"))
  
  abstract class x4035_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4026_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4026_reg_p").asInstanceOf[MemParams] ))
      val in_x3994_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x3994_fifo_p").asInstanceOf[MemParams] ))
      val in_x4025_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4025_reg_p").asInstanceOf[MemParams] ))
      val in_x4024_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4024_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x4026_reg = {io.in_x4026_reg} ; io.in_x4026_reg := DontCare
    def x3994_fifo = {io.in_x3994_fifo} ; io.in_x3994_fifo := DontCare
    def x4025_reg = {io.in_x4025_reg} ; io.in_x4025_reg := DontCare
    def x4024_reg = {io.in_x4024_reg} ; io.in_x4024_reg := DontCare
  }
  def connectWires0(module: x4035_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x4026_reg.connectLedger(module.io.in_x4026_reg)
    x3994_fifo.connectLedger(module.io.in_x3994_fifo)
    x4025_reg.connectLedger(module.io.in_x4025_reg)
    x4024_reg.connectLedger(module.io.in_x4024_reg)
  }
  val x3994_fifo = list_x3994_fifo(0)
  val x4026_reg = list_x4026_reg(0)
  val x4025_reg = list_x4026_reg(1)
  val x4024_reg = list_x4026_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4035_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4035_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4035_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4027_deq_x3994 = Wire(Vec(1, UInt(96.W))).suggestName("""x4027_deq_x3994""")
      val x4027_deq_x3994_banks = List[UInt]()
      val x4027_deq_x3994_ofs = List[UInt]()
      val x4027_deq_x3994_en = List[Bool](true.B)
      x4027_deq_x3994.toSeq.zip(x3994_fifo.connectRPort(4027, x4027_deq_x3994_banks, x4027_deq_x3994_ofs, io.sigsIn.backpressure, x4027_deq_x3994_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      x3994_fifo.connectAccessActivesIn(1, ((true.B)))
      val x19609 = Wire(Vec(1, UInt(96.W))).suggestName("x19609_x4027_deq_x3994_D2") 
      (0 until 1).foreach{i => x19609(i).r := getRetimed(x4027_deq_x3994(i).r, 2.toInt, io.sigsIn.backpressure)}
      val x4028_elem_0 = Wire(UInt(96.W)).suggestName("""x4028_elem_0""")
      x4028_elem_0.r := x19609(0).r
      val x4029_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4029_apply""")
      x4029_apply.r := x4028_elem_0(63, 32)
      val x4030_wr_x4024_banks = List[UInt]()
      val x4030_wr_x4024_ofs = List[UInt]()
      val x4030_wr_x4024_en = List[Bool](true.B)
      val x4030_wr_x4024_data = List[UInt](x4029_apply.r)
      x4024_reg.connectWPort(4030, x4030_wr_x4024_banks, x4030_wr_x4024_ofs, x4030_wr_x4024_data, x4030_wr_x4024_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x4031_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4031_apply""")
      x4031_apply.r := x4028_elem_0(95, 64)
      val x4032_wr_x4025_banks = List[UInt]()
      val x4032_wr_x4025_ofs = List[UInt]()
      val x4032_wr_x4025_en = List[Bool](true.B)
      val x4032_wr_x4025_data = List[UInt](x4031_apply.r)
      x4025_reg.connectWPort(4032, x4032_wr_x4025_banks, x4032_wr_x4025_ofs, x4032_wr_x4025_data, x4032_wr_x4025_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x4033_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4033_apply""")
      x4033_apply.r := x4028_elem_0(31, 0)
      val x4034_wr_x4026_banks = List[UInt]()
      val x4034_wr_x4026_ofs = List[UInt]()
      val x4034_wr_x4026_en = List[Bool](true.B)
      val x4034_wr_x4026_data = List[UInt](x4033_apply.r)
      x4026_reg.connectWPort(4034, x4034_wr_x4026_banks, x4034_wr_x4026_ofs, x4034_wr_x4026_data, x4034_wr_x4026_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x4035_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4035_inr_UnitPipe **/
