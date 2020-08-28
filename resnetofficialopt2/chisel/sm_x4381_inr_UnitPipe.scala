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

/** Hierarchy: x4381 -> x4448 -> x4449 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4381_inr_UnitPipe **/
class x4381_inr_UnitPipe_kernel(
  list_x4337_fifo: List[FIFOInterface],
  list_x4371_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.0.toInt, myName = "x4381_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4381_inr_UnitPipe_iiCtr"))
  
  abstract class x4381_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4371_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4371_reg_p").asInstanceOf[MemParams] ))
      val in_x4370_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4370_reg_p").asInstanceOf[MemParams] ))
      val in_x4337_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x4337_fifo_p").asInstanceOf[MemParams] ))
      val in_x4372_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4372_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x4371_reg = {io.in_x4371_reg} ; io.in_x4371_reg := DontCare
    def x4370_reg = {io.in_x4370_reg} ; io.in_x4370_reg := DontCare
    def x4337_fifo = {io.in_x4337_fifo} ; io.in_x4337_fifo := DontCare
    def x4372_reg = {io.in_x4372_reg} ; io.in_x4372_reg := DontCare
  }
  def connectWires0(module: x4381_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x4371_reg.connectLedger(module.io.in_x4371_reg)
    x4370_reg.connectLedger(module.io.in_x4370_reg)
    x4337_fifo.connectLedger(module.io.in_x4337_fifo)
    x4372_reg.connectLedger(module.io.in_x4372_reg)
  }
  val x4337_fifo = list_x4337_fifo(0)
  val x4371_reg = list_x4371_reg(0)
  val x4370_reg = list_x4371_reg(1)
  val x4372_reg = list_x4371_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4381_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4381_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4381_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4373_deq_x4337 = Wire(Vec(1, UInt(96.W))).suggestName("""x4373_deq_x4337""")
      val x4373_deq_x4337_banks = List[UInt]()
      val x4373_deq_x4337_ofs = List[UInt]()
      val x4373_deq_x4337_en = List[Bool](true.B)
      x4373_deq_x4337.toSeq.zip(x4337_fifo.connectRPort(4373, x4373_deq_x4337_banks, x4373_deq_x4337_ofs, io.sigsIn.backpressure, x4373_deq_x4337_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      x4337_fifo.connectAccessActivesIn(1, ((true.B)))
      val x19682 = Wire(Vec(1, UInt(96.W))).suggestName("x19682_x4373_deq_x4337_D2") 
      (0 until 1).foreach{i => x19682(i).r := getRetimed(x4373_deq_x4337(i).r, 2.toInt, io.sigsIn.backpressure)}
      val x4374_elem_0 = Wire(UInt(96.W)).suggestName("""x4374_elem_0""")
      x4374_elem_0.r := x19682(0).r
      val x4375_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4375_apply""")
      x4375_apply.r := x4374_elem_0(63, 32)
      val x4376_wr_x4370_banks = List[UInt]()
      val x4376_wr_x4370_ofs = List[UInt]()
      val x4376_wr_x4370_en = List[Bool](true.B)
      val x4376_wr_x4370_data = List[UInt](x4375_apply.r)
      x4370_reg.connectWPort(4376, x4376_wr_x4370_banks, x4376_wr_x4370_ofs, x4376_wr_x4370_data, x4376_wr_x4370_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x4377_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4377_apply""")
      x4377_apply.r := x4374_elem_0(95, 64)
      val x4378_wr_x4371_banks = List[UInt]()
      val x4378_wr_x4371_ofs = List[UInt]()
      val x4378_wr_x4371_en = List[Bool](true.B)
      val x4378_wr_x4371_data = List[UInt](x4377_apply.r)
      x4371_reg.connectWPort(4378, x4378_wr_x4371_banks, x4378_wr_x4371_ofs, x4378_wr_x4371_data, x4378_wr_x4371_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x4379_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4379_apply""")
      x4379_apply.r := x4374_elem_0(31, 0)
      val x4380_wr_x4372_banks = List[UInt]()
      val x4380_wr_x4372_ofs = List[UInt]()
      val x4380_wr_x4372_en = List[Bool](true.B)
      val x4380_wr_x4372_data = List[UInt](x4379_apply.r)
      x4372_reg.connectWPort(4380, x4380_wr_x4372_banks, x4380_wr_x4372_ofs, x4380_wr_x4372_data, x4380_wr_x4372_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x4381_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4381_inr_UnitPipe **/
