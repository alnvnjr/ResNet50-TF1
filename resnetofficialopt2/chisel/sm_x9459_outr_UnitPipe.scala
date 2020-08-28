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

/** Hierarchy: x9459 -> x9460 -> x9461 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9459_outr_UnitPipe **/
class x9459_outr_UnitPipe_kernel(
  list_x9401: List[DecoupledIO[Bool]],
  list_x9388_reg: List[NBufInterface],
  list_x9399: List[DecoupledIO[AppCommandDense]],
  list_x3945_reg: List[StandardInterface],
  list_x9400: List[DecoupledIO[AppStoreData]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x9459_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9459_outr_UnitPipe_iiCtr"))
  
  abstract class x9459_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9400 = Decoupled(new AppStoreData(ModuleParams.getParams("x9400_p").asInstanceOf[(Int,Int)] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9401 = Flipped(Decoupled(Bool()))
      val in_x9388_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9388_reg_p").asInstanceOf[NBufParams] ))
      val in_x3945_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3945_reg_p").asInstanceOf[MemParams] ))
      val in_x9389_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9389_reg_p").asInstanceOf[NBufParams] ))
      val in_x9350_out_SRAM_bias_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9350_out_SRAM_bias_0_p").asInstanceOf[NBufParams] ))
      val in_x9399 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9399_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x9400 = {io.in_x9400} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x9401 = {io.in_x9401} 
    def x9388_reg = {io.in_x9388_reg} ; io.in_x9388_reg := DontCare
    def x3945_reg = {io.in_x3945_reg} ; io.in_x3945_reg := DontCare
    def x9389_reg = {io.in_x9389_reg} ; io.in_x9389_reg := DontCare
    def x9350_out_SRAM_bias_0 = {io.in_x9350_out_SRAM_bias_0} ; io.in_x9350_out_SRAM_bias_0 := DontCare
    def x9399 = {io.in_x9399} 
  }
  def connectWires0(module: x9459_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x9400 <> x9400
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x9401 <> x9401
    x9388_reg.connectLedger(module.io.in_x9388_reg)
    x3945_reg.connectLedger(module.io.in_x3945_reg)
    x9389_reg.connectLedger(module.io.in_x9389_reg)
    x9350_out_SRAM_bias_0.connectLedger(module.io.in_x9350_out_SRAM_bias_0)
    module.io.in_x9399 <> x9399
  }
  val x9401 = list_x9401(0)
  val x9388_reg = list_x9388_reg(0)
  val x9389_reg = list_x9388_reg(1)
  val x9350_out_SRAM_bias_0 = list_x9388_reg(2)
  val x9399 = list_x9399(0)
  val x3945_reg = list_x3945_reg(0)
  val x9400 = list_x9400(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9459_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9459_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9459_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9454_outr_UnitPipe = new x9454_outr_UnitPipe_kernel(List(x9388_reg,x9389_reg,x9350_out_SRAM_bias_0), List(x9399), List(x3945_reg), List(x9400), List(x2682_tmp_DRAM) , Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, rr)
      x9454_outr_UnitPipe.sm.io.ctrDone := risingEdge(x9454_outr_UnitPipe.sm.io.ctrInc)
      x9454_outr_UnitPipe.backpressure := true.B | x9454_outr_UnitPipe.sm.io.doneLatch
      x9454_outr_UnitPipe.forwardpressure := true.B | x9454_outr_UnitPipe.sm.io.doneLatch
      x9454_outr_UnitPipe.sm.io.enableOut.zip(x9454_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9454_outr_UnitPipe.sm.io.break := false.B
      x9454_outr_UnitPipe.mask := true.B & true.B
      x9454_outr_UnitPipe.configure("x9454_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9454_outr_UnitPipe.kernel()
      val x9458_inr_UnitPipe = new x9458_inr_UnitPipe_kernel(List(x9401) , Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x9458_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9458_inr_UnitPipe.sm.io.ctrInc)
      x9458_inr_UnitPipe.backpressure := true.B | x9458_inr_UnitPipe.sm.io.doneLatch
      x9458_inr_UnitPipe.forwardpressure := x9401.valid | x9458_inr_UnitPipe.sm.io.doneLatch
      x9458_inr_UnitPipe.sm.io.enableOut.zip(x9458_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9458_inr_UnitPipe.sm.io.break := false.B
      x9458_inr_UnitPipe.mask := true.B & true.B
      x9458_inr_UnitPipe.configure("x9458_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9458_inr_UnitPipe.kernel()
    }
    val module = Module(new x9459_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9459_outr_UnitPipe **/
