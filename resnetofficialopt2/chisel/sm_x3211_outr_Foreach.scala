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

/** Hierarchy: x3211 -> x3898 -> x1256 **/
/** BEGIN None x3211_outr_Foreach **/
class x3211_outr_Foreach_kernel(
  list_x3140: List[DecoupledIO[AppCommandDense]],
  list_x3132_c101_SRAM_0: List[NBufInterface],
  list_b3120: List[FixedPoint],
  list_x3142: List[DecoupledIO[AppLoadData]],
  list_b3121: List[Bool],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x3211_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3211_outr_Foreach_iiCtr"))
  
  abstract class x3211_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b3120 = Input(new FixedPoint(true, 32, 0))
      val in_b3121 = Input(Bool())
      val in_x3140 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3140_p").asInstanceOf[(Int,Int)] ))
      val in_x3066_c101_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3142 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3142_p").asInstanceOf[(Int, Int)] )))
      val in_x3132_c101_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3132_c101_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1, 1), List(32, 32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def b3120 = {io.in_b3120} 
    def b3121 = {io.in_b3121} 
    def x3140 = {io.in_x3140} 
    def x3066_c101_DRAM = {io.in_x3066_c101_DRAM} 
    def x3142 = {io.in_x3142} 
    def x3132_c101_SRAM_0 = {io.in_x3132_c101_SRAM_0} ; io.in_x3132_c101_SRAM_0 := DontCare
  }
  def connectWires0(module: x3211_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b3120 <> b3120
    module.io.in_b3121 <> b3121
    module.io.in_x3140 <> x3140
    module.io.in_x3066_c101_DRAM <> x3066_c101_DRAM
    module.io.in_x3142 <> x3142
    x3132_c101_SRAM_0.connectLedger(module.io.in_x3132_c101_SRAM_0)
  }
  val x3140 = list_x3140(0)
  val x3132_c101_SRAM_0 = list_x3132_c101_SRAM_0(0)
  val b3120 = list_b3120(0)
  val x3066_c101_DRAM = list_b3120(1)
  val x3142 = list_x3142(0)
  val b3121 = list_b3121(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3211_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3211_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3211_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3136_copyx3170_inr_UnitPipe = io.sigsIn.cchainOutputs(0).counts(0).FP(true, 32, 0)
      val b3137_copyx3170_inr_UnitPipe = io.sigsIn.cchainOutputs(0).counts(1).FP(true, 32, 0)
      val b3138_copyx3170_inr_UnitPipe = ~io.sigsIn.cchainOutputs(0).oobs(0)
      val b3139_copyx3170_inr_UnitPipe = ~io.sigsIn.cchainOutputs(0).oobs(1)
      val b3136_copyx3210_outr_UnitPipe = io.sigsIn.cchainOutputs(1).counts(0).FP(true, 32, 0)
      val b3137_copyx3210_outr_UnitPipe = io.sigsIn.cchainOutputs(1).counts(1).FP(true, 32, 0)
      val b3138_copyx3210_outr_UnitPipe = ~io.sigsIn.cchainOutputs(1).oobs(0)
      val b3139_copyx3210_outr_UnitPipe = ~io.sigsIn.cchainOutputs(1).oobs(1)
      val x3141_fifo = (new x3141_fifo).m.io.asInstanceOf[FIFOInterface]
      val x3170_inr_UnitPipe = new x3170_inr_UnitPipe_kernel(List(b3121,b3138_copyx3170_inr_UnitPipe,b3139_copyx3170_inr_UnitPipe), List(b3120,b3137_copyx3170_inr_UnitPipe,x3066_c101_DRAM,b3136_copyx3170_inr_UnitPipe), List(x3141_fifo), List(x3140) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x3170_inr_UnitPipe.sm.io.ctrDone := risingEdge(x3170_inr_UnitPipe.sm.io.ctrInc)
      x3170_inr_UnitPipe.backpressure := x3140.ready & (~x3141_fifo.full | ~(x3141_fifo.accessActivesOut(0))) | x3170_inr_UnitPipe.sm.io.doneLatch
      x3170_inr_UnitPipe.forwardpressure := true.B | x3170_inr_UnitPipe.sm.io.doneLatch
      x3170_inr_UnitPipe.sm.io.enableOut.zip(x3170_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3170_inr_UnitPipe.sm.io.break := false.B
      x3170_inr_UnitPipe.mask := true.B & b3138_copyx3170_inr_UnitPipe & b3139_copyx3170_inr_UnitPipe & b3121
      x3170_inr_UnitPipe.configure("x3170_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3170_inr_UnitPipe.kernel()
      val x3210_outr_UnitPipe = new x3210_outr_UnitPipe_kernel(List(b3137_copyx3210_outr_UnitPipe,b3136_copyx3210_outr_UnitPipe), List(b3121,b3138_copyx3210_outr_UnitPipe,b3139_copyx3210_outr_UnitPipe), List(x3141_fifo), List(x3132_c101_SRAM_0), List(x3142) , Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, rr)
      x3210_outr_UnitPipe.sm.io.ctrDone := risingEdge(x3210_outr_UnitPipe.sm.io.ctrInc)
      x3210_outr_UnitPipe.backpressure := true.B | x3210_outr_UnitPipe.sm.io.doneLatch
      x3210_outr_UnitPipe.forwardpressure := true.B | x3210_outr_UnitPipe.sm.io.doneLatch
      x3210_outr_UnitPipe.sm.io.enableOut.zip(x3210_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3210_outr_UnitPipe.sm.io.break := false.B
      x3210_outr_UnitPipe.mask := true.B & b3138_copyx3210_outr_UnitPipe & b3139_copyx3210_outr_UnitPipe & b3121
      x3210_outr_UnitPipe.configure("x3210_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3210_outr_UnitPipe.kernel()
      x3132_c101_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x3211_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3211_outr_Foreach **/
