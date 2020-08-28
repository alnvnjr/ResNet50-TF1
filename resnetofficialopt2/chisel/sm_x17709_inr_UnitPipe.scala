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

/** Hierarchy: x17709 -> x17710 -> x17711 -> x17712 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17709_inr_UnitPipe **/
class x17709_inr_UnitPipe_kernel(
  list_x17552: List[DecoupledIO[Bool]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 1.0.toInt, myName = "x17709_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17709_inr_UnitPipe_iiCtr"))
  
  abstract class x17709_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x17552 = Flipped(Decoupled(Bool()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x17552 = {io.in_x17552} 
  }
  def connectWires0(module: x17709_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x17552 <> x17552
  }
  val x17552 = list_x17552(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17709_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x17709_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17709_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x17707 = Wire(Vec(1, Bool())).suggestName("""x17707""")
      x17552.ready := true.B & (io.sigsIn.datapathEn) 
      (0 until 1).map{ i => x17707(i) := x17552.bits }
    }
    val module = Module(new x17709_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x17709_inr_UnitPipe **/
