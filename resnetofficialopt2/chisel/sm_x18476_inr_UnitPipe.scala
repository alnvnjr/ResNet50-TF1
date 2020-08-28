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

/** Hierarchy: x18476 -> x18477 -> x1256 **/
/** BEGIN None x18476_inr_UnitPipe **/
class x18476_inr_UnitPipe_kernel(
  list_b18379: List[Bool],
  list_b18378: List[FixedPoint],
  list_x18452_sum_1: List[NBufInterface],
  list_x18375_tmp75_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 1.2.toInt, myName = "x18476_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18476_inr_UnitPipe_iiCtr"))
  
  abstract class x18476_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b18379 = Input(Bool())
      val in_x18375_tmp75_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18375_tmp75_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x18452_sum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x18452_sum_1_p").asInstanceOf[NBufParams] ))
      val in_b18378 = Input(new FixedPoint(true, 32, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b18379 = {io.in_b18379} 
    def x18375_tmp75_SRAM_0 = {io.in_x18375_tmp75_SRAM_0} ; io.in_x18375_tmp75_SRAM_0 := DontCare
    def x18452_sum_1 = {io.in_x18452_sum_1} ; io.in_x18452_sum_1 := DontCare
    def b18378 = {io.in_b18378} 
  }
  def connectWires0(module: x18476_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b18379 <> b18379
    x18375_tmp75_SRAM_0.connectLedger(module.io.in_x18375_tmp75_SRAM_0)
    x18452_sum_1.connectLedger(module.io.in_x18452_sum_1)
    module.io.in_b18378 <> b18378
  }
  val b18379 = list_b18379(0)
  val b18378 = list_b18378(0)
  val x18452_sum_1 = list_x18452_sum_1(0)
  val x18375_tmp75_SRAM_0 = list_x18375_tmp75_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18476_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18476_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18476_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18470_rd_x18452 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18470_rd_x18452""")
      val x18470_rd_x18452_banks = List[UInt]()
      val x18470_rd_x18452_ofs = List[UInt]()
      val x18470_rd_x18452_en = List[Bool](true.B)
      x18470_rd_x18452.toSeq.zip(x18452_sum_1.connectRPort(18470, x18470_rd_x18452_banks, x18470_rd_x18452_ofs, io.sigsIn.backpressure, x18470_rd_x18452_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19370 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19370""")
      x19370.r := Math.and(b18378,3L.FP(true, 32, 0),Some(0.2), true.B,"x19370").r
      val x18472 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18472""")
      x18472.r := Math.arith_right_shift(b18378, 2, Some(0.2), true.B,"x18472").r
      val x18475_wr_banks = List[UInt](x19370.r)
      val x18475_wr_ofs = List[UInt](x18472.r)
      val x18475_wr_en = List[Bool](true.B)
      val x18475_wr_data = List[UInt](x18470_rd_x18452.r)
      x18375_tmp75_SRAM_0.connectWPort(18475, x18475_wr_banks, x18475_wr_ofs, x18475_wr_data, x18475_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x18452_sum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x18476_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18476_inr_UnitPipe **/
