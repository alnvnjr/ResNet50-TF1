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

/** Hierarchy: x4128 -> x4239 -> x4240 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4128_inr_UnitPipe **/
class x4128_inr_UnitPipe_kernel(
  list_x4084_fifo: List[FIFOInterface],
  list_x4119_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.0.toInt, myName = "x4128_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4128_inr_UnitPipe_iiCtr"))
  
  abstract class x4128_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4119_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4119_reg_p").asInstanceOf[MemParams] ))
      val in_x4084_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x4084_fifo_p").asInstanceOf[MemParams] ))
      val in_x4117_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4117_reg_p").asInstanceOf[MemParams] ))
      val in_x4118_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4118_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x4119_reg = {io.in_x4119_reg} ; io.in_x4119_reg := DontCare
    def x4084_fifo = {io.in_x4084_fifo} ; io.in_x4084_fifo := DontCare
    def x4117_reg = {io.in_x4117_reg} ; io.in_x4117_reg := DontCare
    def x4118_reg = {io.in_x4118_reg} ; io.in_x4118_reg := DontCare
  }
  def connectWires0(module: x4128_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x4119_reg.connectLedger(module.io.in_x4119_reg)
    x4084_fifo.connectLedger(module.io.in_x4084_fifo)
    x4117_reg.connectLedger(module.io.in_x4117_reg)
    x4118_reg.connectLedger(module.io.in_x4118_reg)
  }
  val x4084_fifo = list_x4084_fifo(0)
  val x4119_reg = list_x4119_reg(0)
  val x4117_reg = list_x4119_reg(1)
  val x4118_reg = list_x4119_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4128_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4128_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4128_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4120_deq_x4084 = Wire(Vec(1, UInt(96.W))).suggestName("""x4120_deq_x4084""")
      val x4120_deq_x4084_banks = List[UInt]()
      val x4120_deq_x4084_ofs = List[UInt]()
      val x4120_deq_x4084_en = List[Bool](true.B)
      x4120_deq_x4084.toSeq.zip(x4084_fifo.connectRPort(4120, x4120_deq_x4084_banks, x4120_deq_x4084_ofs, io.sigsIn.backpressure, x4120_deq_x4084_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      x4084_fifo.connectAccessActivesIn(1, ((true.B)))
      val x19624 = Wire(Vec(1, UInt(96.W))).suggestName("x19624_x4120_deq_x4084_D2") 
      (0 until 1).foreach{i => x19624(i).r := getRetimed(x4120_deq_x4084(i).r, 2.toInt, io.sigsIn.backpressure)}
      val x4121_elem_0 = Wire(UInt(96.W)).suggestName("""x4121_elem_0""")
      x4121_elem_0.r := x19624(0).r
      val x4122_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4122_apply""")
      x4122_apply.r := x4121_elem_0(63, 32)
      val x4123_wr_x4117_banks = List[UInt]()
      val x4123_wr_x4117_ofs = List[UInt]()
      val x4123_wr_x4117_en = List[Bool](true.B)
      val x4123_wr_x4117_data = List[UInt](x4122_apply.r)
      x4117_reg.connectWPort(4123, x4123_wr_x4117_banks, x4123_wr_x4117_ofs, x4123_wr_x4117_data, x4123_wr_x4117_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x4124_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4124_apply""")
      x4124_apply.r := x4121_elem_0(95, 64)
      val x4125_wr_x4118_banks = List[UInt]()
      val x4125_wr_x4118_ofs = List[UInt]()
      val x4125_wr_x4118_en = List[Bool](true.B)
      val x4125_wr_x4118_data = List[UInt](x4124_apply.r)
      x4118_reg.connectWPort(4125, x4125_wr_x4118_banks, x4125_wr_x4118_ofs, x4125_wr_x4118_data, x4125_wr_x4118_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x4126_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4126_apply""")
      x4126_apply.r := x4121_elem_0(31, 0)
      val x4127_wr_x4119_banks = List[UInt]()
      val x4127_wr_x4119_ofs = List[UInt]()
      val x4127_wr_x4119_en = List[Bool](true.B)
      val x4127_wr_x4119_data = List[UInt](x4126_apply.r)
      x4119_reg.connectWPort(4127, x4127_wr_x4119_banks, x4127_wr_x4119_ofs, x4127_wr_x4119_data, x4127_wr_x4119_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x4128_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4128_inr_UnitPipe **/
