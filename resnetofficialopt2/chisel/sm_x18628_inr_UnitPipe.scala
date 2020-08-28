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

/** Hierarchy: x18628 -> x18644 -> x1256 **/
/** BEGIN None x18628_inr_UnitPipe **/
class x18628_inr_UnitPipe_kernel(
  list_x2680_tmp76_DRAM: List[FixedPoint],
  list_x18621: List[DecoupledIO[AppCommandDense]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 0.0.toInt, myName = "x18628_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18628_inr_UnitPipe_iiCtr"))
  
  abstract class x18628_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18621 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18621_p").asInstanceOf[(Int,Int)] ))
      val in_x2680_tmp76_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18621 = {io.in_x18621} 
    def x2680_tmp76_DRAM = {io.in_x2680_tmp76_DRAM} 
  }
  def connectWires0(module: x18628_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18621 <> x18621
    module.io.in_x2680_tmp76_DRAM <> x2680_tmp76_DRAM
  }
  val x2680_tmp76_DRAM = list_x2680_tmp76_DRAM(0)
  val x18621 = list_x18621(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18628_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18628_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18628_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18624 = x2680_tmp76_DRAM
      val x18625_tuple = Wire(UInt(97.W)).suggestName("""x18625_tuple""")
      x18625_tuple.r := Cat(false.B,4032L.FP(true, 32, 0).r,x18624.r)
      val x18626 = true.B
      x18621.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt.toInt, rr, io.sigsIn.backpressure) & x18626 & io.sigsIn.backpressure
      x18621.bits.addr := x18625_tuple(63,0)
      x18621.bits.size := x18625_tuple(95,64)
    }
    val module = Module(new x18628_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18628_inr_UnitPipe **/
