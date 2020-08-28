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

/** Hierarchy: x4240 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4240_outr_UnitPipe **/
class x4240_outr_UnitPipe_kernel(
  list_x4085: List[DecoupledIO[AppLoadData]],
  list_x4083: List[DecoupledIO[AppCommandDense]],
  list_b4068: List[Bool],
  list_x4070_reg: List[NBufInterface],
  list_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x4240_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4240_outr_UnitPipe_iiCtr"))
  
  abstract class x4240_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4070_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4070_reg_p").asInstanceOf[NBufParams] ))
      val in_x4072_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4072_reg_p").asInstanceOf[NBufParams] ))
      val in_b4068 = Input(Bool())
      val in_x4069_weight_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4069_weight_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_b4060 = Input(Bool())
      val in_x4085 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4085_p").asInstanceOf[(Int, Int)] )))
      val in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x4083 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4083_p").asInstanceOf[(Int,Int)] ))
      val in_x4071_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4071_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x4070_reg = {io.in_x4070_reg} ; io.in_x4070_reg := DontCare
    def x4072_reg = {io.in_x4072_reg} ; io.in_x4072_reg := DontCare
    def b4068 = {io.in_b4068} 
    def x4069_weight_SRAM_0 = {io.in_x4069_weight_SRAM_0} ; io.in_x4069_weight_SRAM_0 := DontCare
    def b4060 = {io.in_b4060} 
    def x4085 = {io.in_x4085} 
    def x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = {io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM} 
    def x4083 = {io.in_x4083} 
    def x4071_reg = {io.in_x4071_reg} ; io.in_x4071_reg := DontCare
  }
  def connectWires0(module: x4240_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x4070_reg.connectLedger(module.io.in_x4070_reg)
    x4072_reg.connectLedger(module.io.in_x4072_reg)
    module.io.in_b4068 <> b4068
    x4069_weight_SRAM_0.connectLedger(module.io.in_x4069_weight_SRAM_0)
    module.io.in_b4060 <> b4060
    module.io.in_x4085 <> x4085
    module.io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM <> x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM
    module.io.in_x4083 <> x4083
    x4071_reg.connectLedger(module.io.in_x4071_reg)
  }
  val x4085 = list_x4085(0)
  val x4083 = list_x4083(0)
  val b4068 = list_b4068(0)
  val b4060 = list_b4068(1)
  val x4070_reg = list_x4070_reg(0)
  val x4072_reg = list_x4070_reg(1)
  val x4069_weight_SRAM_0 = list_x4070_reg(2)
  val x4071_reg = list_x4070_reg(3)
  val x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = list_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4240_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4240_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4240_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4084_fifo = (new x4084_fifo).m.io.asInstanceOf[FIFOInterface]
      val x4115_inr_UnitPipe = new x4115_inr_UnitPipe_kernel(List(x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM), List(x4084_fifo), List(x4083), List(x4070_reg,x4072_reg,x4071_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x4115_inr_UnitPipe.sm.io.ctrDone := risingEdge(x4115_inr_UnitPipe.sm.io.ctrInc)
      x4115_inr_UnitPipe.backpressure := x4083.ready & (~x4084_fifo.full | ~(x4084_fifo.accessActivesOut(0))) | x4115_inr_UnitPipe.sm.io.doneLatch
      x4115_inr_UnitPipe.forwardpressure := true.B | x4115_inr_UnitPipe.sm.io.doneLatch
      x4115_inr_UnitPipe.sm.io.enableOut.zip(x4115_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4115_inr_UnitPipe.sm.io.break := false.B
      x4115_inr_UnitPipe.mask := true.B & true.B
      x4115_inr_UnitPipe.configure("x4115_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4115_inr_UnitPipe.kernel()
      val x4239_outr_UnitPipe = new x4239_outr_UnitPipe_kernel(List(x4084_fifo), List(x4085), List(x4069_weight_SRAM_0) , Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, rr)
      x4239_outr_UnitPipe.sm.io.ctrDone := risingEdge(x4239_outr_UnitPipe.sm.io.ctrInc)
      x4239_outr_UnitPipe.backpressure := true.B | x4239_outr_UnitPipe.sm.io.doneLatch
      x4239_outr_UnitPipe.forwardpressure := true.B | x4239_outr_UnitPipe.sm.io.doneLatch
      x4239_outr_UnitPipe.sm.io.enableOut.zip(x4239_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4239_outr_UnitPipe.sm.io.break := false.B
      x4239_outr_UnitPipe.mask := true.B & true.B
      x4239_outr_UnitPipe.configure("x4239_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4239_outr_UnitPipe.kernel()
      x4069_weight_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4070_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4071_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4072_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x4240_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4240_outr_UnitPipe **/
