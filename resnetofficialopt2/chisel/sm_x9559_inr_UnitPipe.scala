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

/** Hierarchy: x9559 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9559_inr_UnitPipe **/
class x9559_inr_UnitPipe_kernel(
  list_b9553: List[Bool],
  list_b9552: List[FixedPoint],
  list_x9555_reg: List[NBufInterface],
  list_x9484_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 2.0.toInt, myName = "x9559_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9559_inr_UnitPipe_iiCtr"))
  
  abstract class x9559_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b9553 = Input(Bool())
      val in_b9552 = Input(new FixedPoint(true, 32, 0))
      val in_x9484_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9484_reg_p").asInstanceOf[MemParams] ))
      val in_x9555_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9555_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b9553 = {io.in_b9553} 
    def b9552 = {io.in_b9552} 
    def x9484_reg = {io.in_x9484_reg} ; io.in_x9484_reg := DontCare
    def x9555_reg = {io.in_x9555_reg} ; io.in_x9555_reg := DontCare
  }
  def connectWires0(module: x9559_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b9553 <> b9553
    module.io.in_b9552 <> b9552
    x9484_reg.connectLedger(module.io.in_x9484_reg)
    x9555_reg.connectLedger(module.io.in_x9555_reg)
  }
  val b9553 = list_b9553(0)
  val b9552 = list_b9552(0)
  val x9555_reg = list_x9555_reg(0)
  val x9484_reg = list_x9484_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9559_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9559_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9559_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9556_rd_x9484 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9556_rd_x9484""")
      val x9556_rd_x9484_banks = List[UInt]()
      val x9556_rd_x9484_ofs = List[UInt]()
      val x9556_rd_x9484_en = List[Bool](true.B)
      x9556_rd_x9484.toSeq.zip(x9484_reg.connectRPort(9556, x9556_rd_x9484_banks, x9556_rd_x9484_ofs, io.sigsIn.backpressure, x9556_rd_x9484_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9557_x8 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9557_x8""")
      x9557_x8.r := Math.add(x9556_rd_x9484,b9552,Some(1.0), true.B, Truncate, Wrapping, "x9557_x8").r
      val x9558_wr_x9555_banks = List[UInt]()
      val x9558_wr_x9555_ofs = List[UInt]()
      val x9558_wr_x9555_en = List[Bool](true.B)
      val x9558_wr_x9555_data = List[UInt](x9557_x8.r)
      x9555_reg.connectWPort(9558, x9558_wr_x9555_banks, x9558_wr_x9555_ofs, x9558_wr_x9555_data, x9558_wr_x9555_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x9555_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x9559_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9559_inr_UnitPipe **/
