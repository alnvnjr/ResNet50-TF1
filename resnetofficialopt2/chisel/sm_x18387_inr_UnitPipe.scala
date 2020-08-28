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

/** Hierarchy: x18387 -> x18477 -> x1256 **/
/** BEGIN None x18387_inr_UnitPipe **/
class x18387_inr_UnitPipe_kernel(
  list_b18379: List[Bool],
  list_b18378: List[FixedPoint],
  list_x18381_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 7.0.toInt, myName = "x18387_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18387_inr_UnitPipe_iiCtr"))
  
  abstract class x18387_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b18379 = Input(Bool())
      val in_b18378 = Input(new FixedPoint(true, 32, 0))
      val in_x18381_reg = Flipped(new NBufInterface(ModuleParams.getParams("x18381_reg_p").asInstanceOf[NBufParams] ))
      val in_x18382_reg = Flipped(new NBufInterface(ModuleParams.getParams("x18382_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b18379 = {io.in_b18379} 
    def b18378 = {io.in_b18378} 
    def x18381_reg = {io.in_x18381_reg} ; io.in_x18381_reg := DontCare
    def x18382_reg = {io.in_x18382_reg} ; io.in_x18382_reg := DontCare
  }
  def connectWires0(module: x18387_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b18379 <> b18379
    module.io.in_b18378 <> b18378
    x18381_reg.connectLedger(module.io.in_x18381_reg)
    x18382_reg.connectLedger(module.io.in_x18382_reg)
  }
  val b18379 = list_b18379(0)
  val b18378 = list_b18378(0)
  val x18381_reg = list_x18381_reg(0)
  val x18382_reg = list_x18381_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18387_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18387_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18387_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18384_x34 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18384_x34""")
      x18384_x34.r := (Math.mul(b18378, 49L.FP(true, 32, 0), Some(6.0), true.B, Truncate, Wrapping, "x18384_x34")).r
      val x18385_wr_x18381_banks = List[UInt]()
      val x18385_wr_x18381_ofs = List[UInt]()
      val x18385_wr_x18381_en = List[Bool](true.B)
      val x18385_wr_x18381_data = List[UInt](1L.FP(true, 32, 0).r)
      x18381_reg.connectWPort(18385, x18385_wr_x18381_banks, x18385_wr_x18381_ofs, x18385_wr_x18381_data, x18385_wr_x18381_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x18386_wr_x18382_banks = List[UInt]()
      val x18386_wr_x18382_ofs = List[UInt]()
      val x18386_wr_x18382_en = List[Bool](true.B)
      val x18386_wr_x18382_data = List[UInt](x18384_x34.r)
      x18382_reg.connectWPort(18386, x18386_wr_x18382_banks, x18386_wr_x18382_ofs, x18386_wr_x18382_data, x18386_wr_x18382_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x18381_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x18382_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x18387_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18387_inr_UnitPipe **/
