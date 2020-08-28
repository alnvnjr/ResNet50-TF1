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

/** Hierarchy: x4054 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4054_outr_UnitPipe **/
class x4054_outr_UnitPipe_kernel(
  list_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM: List[FixedPoint],
  list_x3993: List[DecoupledIO[AppCommandDense]],
  list_x3995: List[DecoupledIO[AppLoadData]],
  list_x3944_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x4054_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4054_outr_UnitPipe_iiCtr"))
  
  abstract class x4054_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3944_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3944_reg_p").asInstanceOf[MemParams] ))
      val in_x3934_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3934_reg_p").asInstanceOf[MemParams] ))
      val in_x3995 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3995_p").asInstanceOf[(Int, Int)] )))
      val in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3993 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3993_p").asInstanceOf[(Int,Int)] ))
      val in_x3992_bias_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3992_bias_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x3944_reg = {io.in_x3944_reg} ; io.in_x3944_reg := DontCare
    def x3934_reg = {io.in_x3934_reg} ; io.in_x3934_reg := DontCare
    def x3995 = {io.in_x3995} 
    def x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = {io.in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM} 
    def x3993 = {io.in_x3993} 
    def x3992_bias_SRAM_0 = {io.in_x3992_bias_SRAM_0} ; io.in_x3992_bias_SRAM_0 := DontCare
  }
  def connectWires0(module: x4054_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3944_reg.connectLedger(module.io.in_x3944_reg)
    x3934_reg.connectLedger(module.io.in_x3934_reg)
    module.io.in_x3995 <> x3995
    module.io.in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM <> x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM
    module.io.in_x3993 <> x3993
    x3992_bias_SRAM_0.connectLedger(module.io.in_x3992_bias_SRAM_0)
  }
  val x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = list_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM(0)
  val x3993 = list_x3993(0)
  val x3995 = list_x3995(0)
  val x3944_reg = list_x3944_reg(0)
  val x3934_reg = list_x3944_reg(1)
  val x3992_bias_SRAM_0 = list_x3944_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4054_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4054_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4054_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3994_fifo = (new x3994_fifo).m.io.asInstanceOf[FIFOInterface]
      val x4022_inr_UnitPipe = new x4022_inr_UnitPipe_kernel(List(x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM), List(x3994_fifo), List(x3993), List(x3944_reg,x3934_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x4022_inr_UnitPipe.sm.io.ctrDone := risingEdge(x4022_inr_UnitPipe.sm.io.ctrInc)
      x4022_inr_UnitPipe.backpressure := x3993.ready & (~x3994_fifo.full | ~(x3994_fifo.accessActivesOut(0))) | x4022_inr_UnitPipe.sm.io.doneLatch
      x4022_inr_UnitPipe.forwardpressure := true.B | x4022_inr_UnitPipe.sm.io.doneLatch
      x4022_inr_UnitPipe.sm.io.enableOut.zip(x4022_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4022_inr_UnitPipe.sm.io.break := false.B
      x4022_inr_UnitPipe.mask := true.B & true.B
      x4022_inr_UnitPipe.configure("x4022_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4022_inr_UnitPipe.kernel()
      val x4053_outr_UnitPipe = new x4053_outr_UnitPipe_kernel(List(x3994_fifo), List(x3995), List(x3992_bias_SRAM_0) , Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, rr)
      x4053_outr_UnitPipe.sm.io.ctrDone := risingEdge(x4053_outr_UnitPipe.sm.io.ctrInc)
      x4053_outr_UnitPipe.backpressure := true.B | x4053_outr_UnitPipe.sm.io.doneLatch
      x4053_outr_UnitPipe.forwardpressure := true.B | x4053_outr_UnitPipe.sm.io.doneLatch
      x4053_outr_UnitPipe.sm.io.enableOut.zip(x4053_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4053_outr_UnitPipe.sm.io.break := false.B
      x4053_outr_UnitPipe.mask := true.B & true.B
      x4053_outr_UnitPipe.configure("x4053_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4053_outr_UnitPipe.kernel()
    }
    val module = Module(new x4054_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4054_outr_UnitPipe **/
