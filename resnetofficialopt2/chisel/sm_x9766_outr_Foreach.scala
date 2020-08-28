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

/** Hierarchy: x9766 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9766_outr_Foreach **/
class x9766_outr_Foreach_kernel(
  list_x9593: List[DecoupledIO[AppCommandDense]],
  list_x9584_reg: List[NBufInterface],
  list_b9553: List[Bool],
  list_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM: List[FixedPoint],
  list_x9487_reg: List[StandardInterface],
  list_x9595: List[DecoupledIO[AppLoadData]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x9766_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9766_outr_Foreach_iiCtr"))
  
  abstract class x9766_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9593 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9593_p").asInstanceOf[(Int,Int)] ))
      val in_x9584_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9584_reg_p").asInstanceOf[NBufParams] ))
      val in_x9554_bias_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9554_bias_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9487_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9487_reg_p").asInstanceOf[MemParams] ))
      val in_b9553 = Input(Bool())
      val in_x9595 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9595_p").asInstanceOf[(Int, Int)] )))
      val in_x9583_weight_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9583_weight_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x9593 = {io.in_x9593} 
    def x9584_reg = {io.in_x9584_reg} ; io.in_x9584_reg := DontCare
    def x9554_bias_SRAM_0 = {io.in_x9554_bias_SRAM_0} ; io.in_x9554_bias_SRAM_0 := DontCare
    def x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = {io.in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM} 
    def x9487_reg = {io.in_x9487_reg} ; io.in_x9487_reg := DontCare
    def b9553 = {io.in_b9553} 
    def x9595 = {io.in_x9595} 
    def x9583_weight_SRAM_0 = {io.in_x9583_weight_SRAM_0} ; io.in_x9583_weight_SRAM_0 := DontCare
  }
  def connectWires0(module: x9766_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x9593 <> x9593
    x9584_reg.connectLedger(module.io.in_x9584_reg)
    x9554_bias_SRAM_0.connectLedger(module.io.in_x9554_bias_SRAM_0)
    module.io.in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM <> x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM
    x9487_reg.connectLedger(module.io.in_x9487_reg)
    module.io.in_b9553 <> b9553
    module.io.in_x9595 <> x9595
    x9583_weight_SRAM_0.connectLedger(module.io.in_x9583_weight_SRAM_0)
  }
  val x9593 = list_x9593(0)
  val x9584_reg = list_x9584_reg(0)
  val x9554_bias_SRAM_0 = list_x9584_reg(1)
  val x9583_weight_SRAM_0 = list_x9584_reg(2)
  val b9553 = list_b9553(0)
  val x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = list_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM(0)
  val x9487_reg = list_x9487_reg(0)
  val x9595 = list_x9595(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9766_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x9766_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9766_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b9591_copyx9624_inr_UnitPipe = io.sigsIn.cchainOutputs(0).counts(0).FP(true, 32, 0)
      val b9592_copyx9624_inr_UnitPipe = ~io.sigsIn.cchainOutputs(0).oobs(0)
      val b9591_copyx9765_outr_UnitPipe = io.sigsIn.cchainOutputs(1).counts(0).FP(true, 32, 0)
      val b9592_copyx9765_outr_UnitPipe = ~io.sigsIn.cchainOutputs(1).oobs(0)
      val x9594_fifo = (new x9594_fifo).m.io.asInstanceOf[FIFOInterface]
      val x9624_inr_UnitPipe = new x9624_inr_UnitPipe_kernel(List(x9594_fifo), List(x9593), List(b9592_copyx9624_inr_UnitPipe,b9553), List(x9487_reg), List(x9584_reg), List(x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM,b9591_copyx9624_inr_UnitPipe) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x9624_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9624_inr_UnitPipe.sm.io.ctrInc)
      x9624_inr_UnitPipe.backpressure := (~x9594_fifo.full | ~(x9594_fifo.accessActivesOut(0))) & x9593.ready | x9624_inr_UnitPipe.sm.io.doneLatch
      x9624_inr_UnitPipe.forwardpressure := true.B | x9624_inr_UnitPipe.sm.io.doneLatch
      x9624_inr_UnitPipe.sm.io.enableOut.zip(x9624_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9624_inr_UnitPipe.sm.io.break := false.B
      x9624_inr_UnitPipe.mask := true.B & b9592_copyx9624_inr_UnitPipe & b9553
      x9624_inr_UnitPipe.configure("x9624_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9624_inr_UnitPipe.kernel()
      val x9765_outr_UnitPipe = new x9765_outr_UnitPipe_kernel(List(x9583_weight_SRAM_0), List(x9594_fifo), List(b9592_copyx9765_outr_UnitPipe,b9553), List(x9595), List(b9591_copyx9765_outr_UnitPipe) , Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, rr)
      x9765_outr_UnitPipe.sm.io.ctrDone := risingEdge(x9765_outr_UnitPipe.sm.io.ctrInc)
      x9765_outr_UnitPipe.backpressure := true.B | x9765_outr_UnitPipe.sm.io.doneLatch
      x9765_outr_UnitPipe.forwardpressure := true.B | x9765_outr_UnitPipe.sm.io.doneLatch
      x9765_outr_UnitPipe.sm.io.enableOut.zip(x9765_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9765_outr_UnitPipe.sm.io.break := false.B
      x9765_outr_UnitPipe.mask := true.B & b9592_copyx9765_outr_UnitPipe & b9553
      x9765_outr_UnitPipe.configure("x9765_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9765_outr_UnitPipe.kernel()
      x9554_bias_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 2)
      x9583_weight_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9584_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x9766_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x9766_outr_Foreach **/
