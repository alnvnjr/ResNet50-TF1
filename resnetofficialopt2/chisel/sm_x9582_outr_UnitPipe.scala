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

/** Hierarchy: x9582 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9582_outr_UnitPipe **/
class x9582_outr_UnitPipe_kernel(
  list_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM: List[FixedPoint],
  list_b9553: List[Bool],
  list_x9554_bias_SRAM_0: List[NBufInterface],
  list_x9561: List[DecoupledIO[AppLoadData]],
  list_x9560: List[DecoupledIO[AppCommandDense]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x9582_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9582_outr_UnitPipe_iiCtr"))
  
  abstract class x9582_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9561 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9561_p").asInstanceOf[(Int, Int)] )))
      val in_x9554_bias_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9554_bias_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9555_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9555_reg_p").asInstanceOf[NBufParams] ))
      val in_x9560 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9560_p").asInstanceOf[(Int,Int)] ))
      val in_b9553 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x9561 = {io.in_x9561} 
    def x9554_bias_SRAM_0 = {io.in_x9554_bias_SRAM_0} ; io.in_x9554_bias_SRAM_0 := DontCare
    def x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = {io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM} 
    def x9555_reg = {io.in_x9555_reg} ; io.in_x9555_reg := DontCare
    def x9560 = {io.in_x9560} 
    def b9553 = {io.in_b9553} 
  }
  def connectWires0(module: x9582_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x9561 <> x9561
    x9554_bias_SRAM_0.connectLedger(module.io.in_x9554_bias_SRAM_0)
    module.io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM <> x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM
    x9555_reg.connectLedger(module.io.in_x9555_reg)
    module.io.in_x9560 <> x9560
    module.io.in_b9553 <> b9553
  }
  val x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = list_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM(0)
  val b9553 = list_b9553(0)
  val x9554_bias_SRAM_0 = list_x9554_bias_SRAM_0(0)
  val x9555_reg = list_x9554_bias_SRAM_0(1)
  val x9561 = list_x9561(0)
  val x9560 = list_x9560(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9582_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9582_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9582_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9570_inr_UnitPipe = new x9570_inr_UnitPipe_kernel(List(x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM), List(x9560), List(x9555_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x9570_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9570_inr_UnitPipe.sm.io.ctrInc)
      x9570_inr_UnitPipe.backpressure := x9560.ready | x9570_inr_UnitPipe.sm.io.doneLatch
      x9570_inr_UnitPipe.forwardpressure := true.B | x9570_inr_UnitPipe.sm.io.doneLatch
      x9570_inr_UnitPipe.sm.io.enableOut.zip(x9570_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9570_inr_UnitPipe.sm.io.break := false.B
      x9570_inr_UnitPipe.mask := true.B & true.B
      x9570_inr_UnitPipe.configure("x9570_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9570_inr_UnitPipe.kernel()
      val x9572_ctr = new CtrObject(Left(Some(0)), Left(Some(32)), Left(Some(1)), 1, 32, false)
      val x9573_ctrchain = (new CChainObject(List[CtrObject](x9572_ctr), "x9573_ctrchain")).cchain.io 
      x9573_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x9573_ctrchain_p", (x9573_ctrchain.par, x9573_ctrchain.widths))
      val x9581_inr_Foreach = new x9581_inr_Foreach_kernel(List(x9561), List(x9554_bias_SRAM_0) , Some(me), List(x9573_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x9581_inr_Foreach.sm.io.ctrDone := (x9581_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x9581_inr_Foreach.backpressure := true.B | x9581_inr_Foreach.sm.io.doneLatch
      x9581_inr_Foreach.forwardpressure := x9561.valid | x9581_inr_Foreach.sm.io.doneLatch
      x9581_inr_Foreach.sm.io.enableOut.zip(x9581_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x9581_inr_Foreach.sm.io.break := false.B
      x9581_inr_Foreach.mask := ~x9581_inr_Foreach.cchain.head.output.noop & true.B
      x9581_inr_Foreach.configure("x9581_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9581_inr_Foreach.kernel()
      x9554_bias_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9555_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x9582_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9582_outr_UnitPipe **/
