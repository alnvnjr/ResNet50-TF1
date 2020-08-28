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

/** Hierarchy: x9588 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9588_inr_UnitPipe **/
class x9588_inr_UnitPipe_kernel(
  list_b9553: List[Bool],
  list_b9552: List[FixedPoint],
  list_x9498_reg: List[StandardInterface],
  list_x9584_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 2.0.toInt, myName = "x9588_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9588_inr_UnitPipe_iiCtr"))
  
  abstract class x9588_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b9552 = Input(new FixedPoint(true, 32, 0))
      val in_x9584_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9584_reg_p").asInstanceOf[NBufParams] ))
      val in_x9554_bias_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9554_bias_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x9498_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9498_reg_p").asInstanceOf[MemParams] ))
      val in_b9553 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b9552 = {io.in_b9552} 
    def x9584_reg = {io.in_x9584_reg} ; io.in_x9584_reg := DontCare
    def x9554_bias_SRAM_0 = {io.in_x9554_bias_SRAM_0} ; io.in_x9554_bias_SRAM_0 := DontCare
    def x9498_reg = {io.in_x9498_reg} ; io.in_x9498_reg := DontCare
    def b9553 = {io.in_b9553} 
  }
  def connectWires0(module: x9588_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b9552 <> b9552
    x9584_reg.connectLedger(module.io.in_x9584_reg)
    x9554_bias_SRAM_0.connectLedger(module.io.in_x9554_bias_SRAM_0)
    x9498_reg.connectLedger(module.io.in_x9498_reg)
    module.io.in_b9553 <> b9553
  }
  val b9553 = list_b9553(0)
  val b9552 = list_b9552(0)
  val x9498_reg = list_x9498_reg(0)
  val x9584_reg = list_x9584_reg(0)
  val x9554_bias_SRAM_0 = list_x9584_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9588_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9588_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9588_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9585_rd_x9498 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9585_rd_x9498""")
      val x9585_rd_x9498_banks = List[UInt]()
      val x9585_rd_x9498_ofs = List[UInt]()
      val x9585_rd_x9498_en = List[Bool](true.B)
      x9585_rd_x9498.toSeq.zip(x9498_reg.connectRPort(9585, x9585_rd_x9498_banks, x9585_rd_x9498_ofs, io.sigsIn.backpressure, x9585_rd_x9498_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9586_x9 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9586_x9""")
      x9586_x9.r := Math.add(x9585_rd_x9498,b9552,Some(1.0), true.B, Truncate, Wrapping, "x9586_x9").r
      val x9587_wr_x9584_banks = List[UInt]()
      val x9587_wr_x9584_ofs = List[UInt]()
      val x9587_wr_x9584_en = List[Bool](true.B)
      val x9587_wr_x9584_data = List[UInt](x9586_x9.r)
      x9584_reg.connectWPort(9587, x9587_wr_x9584_banks, x9587_wr_x9584_ofs, x9587_wr_x9584_data, x9587_wr_x9584_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x9554_bias_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x9584_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x9588_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9588_inr_UnitPipe **/
