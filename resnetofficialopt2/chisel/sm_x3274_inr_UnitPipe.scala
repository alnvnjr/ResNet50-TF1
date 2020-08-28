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

/** Hierarchy: x3274 -> x3299 -> x3300 -> x3699 -> x3700 -> x3898 -> x1256 **/
/** BEGIN None x3274_inr_UnitPipe **/
class x3274_inr_UnitPipe_kernel(
  list_x3231_fifo: List[FIFOInterface],
  list_x3263_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.0.toInt, myName = "x3274_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3274_inr_UnitPipe_iiCtr"))
  
  abstract class x3274_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3263_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3263_reg_p").asInstanceOf[MemParams] ))
      val in_x3231_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x3231_fifo_p").asInstanceOf[MemParams] ))
      val in_x3265_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3265_reg_p").asInstanceOf[MemParams] ))
      val in_x3264_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3264_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3263_reg = {io.in_x3263_reg} ; io.in_x3263_reg := DontCare
    def x3231_fifo = {io.in_x3231_fifo} ; io.in_x3231_fifo := DontCare
    def x3265_reg = {io.in_x3265_reg} ; io.in_x3265_reg := DontCare
    def x3264_reg = {io.in_x3264_reg} ; io.in_x3264_reg := DontCare
  }
  def connectWires0(module: x3274_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3263_reg.connectLedger(module.io.in_x3263_reg)
    x3231_fifo.connectLedger(module.io.in_x3231_fifo)
    x3265_reg.connectLedger(module.io.in_x3265_reg)
    x3264_reg.connectLedger(module.io.in_x3264_reg)
  }
  val x3231_fifo = list_x3231_fifo(0)
  val x3263_reg = list_x3263_reg(0)
  val x3265_reg = list_x3263_reg(1)
  val x3264_reg = list_x3263_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3274_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3274_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3274_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3266_deq_x3231 = Wire(Vec(1, UInt(96.W))).suggestName("""x3266_deq_x3231""")
      val x3266_deq_x3231_banks = List[UInt]()
      val x3266_deq_x3231_ofs = List[UInt]()
      val x3266_deq_x3231_en = List[Bool](true.B)
      x3266_deq_x3231.toSeq.zip(x3231_fifo.connectRPort(3266, x3266_deq_x3231_banks, x3266_deq_x3231_ofs, io.sigsIn.backpressure, x3266_deq_x3231_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      x3231_fifo.connectAccessActivesIn(1, ((true.B)))
      val x19404 = Wire(Vec(1, UInt(96.W))).suggestName("x19404_x3266_deq_x3231_D2") 
      (0 until 1).foreach{i => x19404(i).r := getRetimed(x3266_deq_x3231(i).r, 2.toInt, io.sigsIn.backpressure)}
      val x3267_elem_0 = Wire(UInt(96.W)).suggestName("""x3267_elem_0""")
      x3267_elem_0.r := x19404(0).r
      val x3268_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3268_apply""")
      x3268_apply.r := x3267_elem_0(63, 32)
      val x3269_wr_x3263_banks = List[UInt]()
      val x3269_wr_x3263_ofs = List[UInt]()
      val x3269_wr_x3263_en = List[Bool](true.B)
      val x3269_wr_x3263_data = List[UInt](x3268_apply.r)
      x3263_reg.connectWPort(3269, x3269_wr_x3263_banks, x3269_wr_x3263_ofs, x3269_wr_x3263_data, x3269_wr_x3263_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x3270_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3270_apply""")
      x3270_apply.r := x3267_elem_0(95, 64)
      val x3271_wr_x3264_banks = List[UInt]()
      val x3271_wr_x3264_ofs = List[UInt]()
      val x3271_wr_x3264_en = List[Bool](true.B)
      val x3271_wr_x3264_data = List[UInt](x3270_apply.r)
      x3264_reg.connectWPort(3271, x3271_wr_x3264_banks, x3271_wr_x3264_ofs, x3271_wr_x3264_data, x3271_wr_x3264_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x3272_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3272_apply""")
      x3272_apply.r := x3267_elem_0(31, 0)
      val x3273_wr_x3265_banks = List[UInt]()
      val x3273_wr_x3265_ofs = List[UInt]()
      val x3273_wr_x3265_en = List[Bool](true.B)
      val x3273_wr_x3265_data = List[UInt](x3272_apply.r)
      x3265_reg.connectWPort(3273, x3273_wr_x3265_banks, x3273_wr_x3265_ofs, x3273_wr_x3265_data, x3273_wr_x3265_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x3274_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3274_inr_UnitPipe **/
