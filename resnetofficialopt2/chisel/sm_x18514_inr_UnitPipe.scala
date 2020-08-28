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

/** Hierarchy: x18514 -> x18549 -> x18620 -> x1256 **/
/** BEGIN None x18514_inr_UnitPipe **/
class x18514_inr_UnitPipe_kernel(
  list_x3083_c90_DRAM: List[FixedPoint],
  list_x18504: List[DecoupledIO[AppCommandDense]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 2.2.toInt, myName = "x18514_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18514_inr_UnitPipe_iiCtr"))
  
  abstract class x18514_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18504 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18504_p").asInstanceOf[(Int,Int)] ))
      val in_x3083_c90_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_b18501 = Input(new FixedPoint(true, 32, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18504 = {io.in_x18504} 
    def x3083_c90_DRAM = {io.in_x3083_c90_DRAM} 
    def b18501 = {io.in_b18501} 
  }
  def connectWires0(module: x18514_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18504 <> x18504
    module.io.in_x3083_c90_DRAM <> x3083_c90_DRAM
    module.io.in_b18501 <> b18501
  }
  val x3083_c90_DRAM = list_x3083_c90_DRAM(0)
  val b18501 = list_x3083_c90_DRAM(1)
  val x18504 = list_x18504(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18514_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18514_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18514_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x19371 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19371""")
      val ensig0 = Wire(Bool())
      ensig0 := x18504.ready
      x19371.r := Math.arith_left_shift(b18501, 13, Some(0.2), ensig0,"x19371").r
      val x18508 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x18508""")
      x18508.r := Math.fix2fix(x19371, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x18508").r
      val x18509 = x3083_c90_DRAM
      val x18510_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x18510_sum""")
      x18510_sum.r := Math.add(x18508,x18509,Some(2.0), ensig0, Truncate, Wrapping, "x18510_sum").r
      val x18511_tuple = Wire(UInt(97.W)).suggestName("""x18511_tuple""")
      x18511_tuple.r := Cat(true.B,8192L.FP(true, 32, 0).r,x18510_sum.r)
      val x18512 = true.B
      val x21999 = Wire(Bool()).suggestName("x21999_x18512_D2") 
      x21999.r := getRetimed(x18512.r, 2.toInt, io.sigsIn.backpressure)
      x18504.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21999 & io.sigsIn.backpressure
      x18504.bits.addr := x18511_tuple(63,0)
      x18504.bits.size := x18511_tuple(95,64)
    }
    val module = Module(new x18514_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18514_inr_UnitPipe **/
