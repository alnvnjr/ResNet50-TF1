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

/** Hierarchy: x3300 -> x3699 -> x3700 -> x3898 -> x1256 **/
/** BEGIN None x3300_outr_Foreach **/
class x3300_outr_Foreach_kernel(
  list_x3230: List[DecoupledIO[AppCommandDense]],
  list_x3232: List[DecoupledIO[AppLoadData]],
  list_x3221_reg: List[NBufInterface],
  list_x2679_i0_pad_DRAM: List[FixedPoint],
  list_b3121: List[Bool],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x3300_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3300_outr_Foreach_iiCtr"))
  
  abstract class x3300_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3230 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3230_p").asInstanceOf[(Int,Int)] ))
      val in_b3121 = Input(Bool())
      val in_x3221_reg = Flipped(new NBufInterface(ModuleParams.getParams("x3221_reg_p").asInstanceOf[NBufParams] ))
      val in_x3216_lb0_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3216_lb0_0_p").asInstanceOf[NBufParams] ))
      val in_b3215 = Input(Bool())
      val in_x2679_i0_pad_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_b3214 = Input(new FixedPoint(true, 32, 0))
      val in_b3220 = Input(Bool())
      val in_x3232 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3232_p").asInstanceOf[(Int, Int)] )))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x3230 = {io.in_x3230} 
    def b3121 = {io.in_b3121} 
    def x3221_reg = {io.in_x3221_reg} ; io.in_x3221_reg := DontCare
    def x3216_lb0_0 = {io.in_x3216_lb0_0} ; io.in_x3216_lb0_0 := DontCare
    def b3215 = {io.in_b3215} 
    def x2679_i0_pad_DRAM = {io.in_x2679_i0_pad_DRAM} 
    def b3214 = {io.in_b3214} 
    def b3220 = {io.in_b3220} 
    def x3232 = {io.in_x3232} 
  }
  def connectWires0(module: x3300_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x3230 <> x3230
    module.io.in_b3121 <> b3121
    x3221_reg.connectLedger(module.io.in_x3221_reg)
    x3216_lb0_0.connectLedger(module.io.in_x3216_lb0_0)
    module.io.in_b3215 <> b3215
    module.io.in_x2679_i0_pad_DRAM <> x2679_i0_pad_DRAM
    module.io.in_b3214 <> b3214
    module.io.in_b3220 <> b3220
    module.io.in_x3232 <> x3232
  }
  val x3230 = list_x3230(0)
  val x3232 = list_x3232(0)
  val x3221_reg = list_x3221_reg(0)
  val x3216_lb0_0 = list_x3221_reg(1)
  val x2679_i0_pad_DRAM = list_x2679_i0_pad_DRAM(0)
  val b3214 = list_x2679_i0_pad_DRAM(1)
  val b3121 = list_b3121(0)
  val b3215 = list_b3121(1)
  val b3220 = list_b3121(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3300_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3300_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3300_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3228_copyx3261_inr_UnitPipe = io.sigsIn.cchainOutputs(0).counts(0).FP(true, 32, 0)
      val b3229_copyx3261_inr_UnitPipe = ~io.sigsIn.cchainOutputs(0).oobs(0)
      val b3228_copyx3299_outr_UnitPipe = io.sigsIn.cchainOutputs(1).counts(0).FP(true, 32, 0)
      val b3229_copyx3299_outr_UnitPipe = ~io.sigsIn.cchainOutputs(1).oobs(0)
      val x3231_fifo = (new x3231_fifo).m.io.asInstanceOf[FIFOInterface]
      val x3261_inr_UnitPipe = new x3261_inr_UnitPipe_kernel(List(x3230), List(b3121,b3229_copyx3261_inr_UnitPipe,b3215,b3220), List(x3231_fifo), List(x2679_i0_pad_DRAM,b3214,b3228_copyx3261_inr_UnitPipe), List(x3221_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x3261_inr_UnitPipe.sm.io.ctrDone := risingEdge(x3261_inr_UnitPipe.sm.io.ctrInc)
      x3261_inr_UnitPipe.backpressure := x3230.ready & (~x3231_fifo.full | ~(x3231_fifo.accessActivesOut(0))) | x3261_inr_UnitPipe.sm.io.doneLatch
      x3261_inr_UnitPipe.forwardpressure := true.B | x3261_inr_UnitPipe.sm.io.doneLatch
      x3261_inr_UnitPipe.sm.io.enableOut.zip(x3261_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3261_inr_UnitPipe.sm.io.break := false.B
      x3261_inr_UnitPipe.mask := true.B & b3229_copyx3261_inr_UnitPipe & b3220 & b3215 & b3121
      x3261_inr_UnitPipe.configure("x3261_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3261_inr_UnitPipe.kernel()
      val x3299_outr_UnitPipe = new x3299_outr_UnitPipe_kernel(List(x3216_lb0_0), List(x3232), List(b3228_copyx3299_outr_UnitPipe), List(b3121,b3229_copyx3299_outr_UnitPipe,b3215,b3220), List(x3231_fifo) , Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, rr)
      x3299_outr_UnitPipe.sm.io.ctrDone := risingEdge(x3299_outr_UnitPipe.sm.io.ctrInc)
      x3299_outr_UnitPipe.backpressure := true.B | x3299_outr_UnitPipe.sm.io.doneLatch
      x3299_outr_UnitPipe.forwardpressure := true.B | x3299_outr_UnitPipe.sm.io.doneLatch
      x3299_outr_UnitPipe.sm.io.enableOut.zip(x3299_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3299_outr_UnitPipe.sm.io.break := false.B
      x3299_outr_UnitPipe.mask := true.B & b3229_copyx3299_outr_UnitPipe & b3220 & b3215 & b3121
      x3299_outr_UnitPipe.configure("x3299_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3299_outr_UnitPipe.kernel()
      x3216_lb0_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x3221_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x3300_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3300_outr_Foreach **/
