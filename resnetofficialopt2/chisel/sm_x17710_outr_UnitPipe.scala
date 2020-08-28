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

/** Hierarchy: x17710 -> x17711 -> x17712 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17710_outr_UnitPipe **/
class x17710_outr_UnitPipe_kernel(
  list_x9495_reg: List[StandardInterface],
  list_x17552: List[DecoupledIO[Bool]],
  list_x17550: List[DecoupledIO[AppCommandDense]],
  list_x17539_reg: List[NBufInterface],
  list_x17551: List[DecoupledIO[AppStoreData]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x17710_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17710_outr_UnitPipe_iiCtr"))
  
  abstract class x17710_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x17539_reg = Flipped(new NBufInterface(ModuleParams.getParams("x17539_reg_p").asInstanceOf[NBufParams] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x17550 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17550_p").asInstanceOf[(Int,Int)] ))
      val in_x17551 = Decoupled(new AppStoreData(ModuleParams.getParams("x17551_p").asInstanceOf[(Int,Int)] ))
      val in_x17304_out_SRAM_bias_0 = Flipped(new NBufInterface(ModuleParams.getParams("x17304_out_SRAM_bias_0_p").asInstanceOf[NBufParams] ))
      val in_x9495_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9495_reg_p").asInstanceOf[MemParams] ))
      val in_x17552 = Flipped(Decoupled(Bool()))
      val in_x17540_reg = Flipped(new NBufInterface(ModuleParams.getParams("x17540_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x17539_reg = {io.in_x17539_reg} ; io.in_x17539_reg := DontCare
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x17550 = {io.in_x17550} 
    def x17551 = {io.in_x17551} 
    def x17304_out_SRAM_bias_0 = {io.in_x17304_out_SRAM_bias_0} ; io.in_x17304_out_SRAM_bias_0 := DontCare
    def x9495_reg = {io.in_x9495_reg} ; io.in_x9495_reg := DontCare
    def x17552 = {io.in_x17552} 
    def x17540_reg = {io.in_x17540_reg} ; io.in_x17540_reg := DontCare
  }
  def connectWires0(module: x17710_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x17539_reg.connectLedger(module.io.in_x17539_reg)
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x17550 <> x17550
    module.io.in_x17551 <> x17551
    x17304_out_SRAM_bias_0.connectLedger(module.io.in_x17304_out_SRAM_bias_0)
    x9495_reg.connectLedger(module.io.in_x9495_reg)
    module.io.in_x17552 <> x17552
    x17540_reg.connectLedger(module.io.in_x17540_reg)
  }
  val x9495_reg = list_x9495_reg(0)
  val x17552 = list_x17552(0)
  val x17550 = list_x17550(0)
  val x17539_reg = list_x17539_reg(0)
  val x17304_out_SRAM_bias_0 = list_x17539_reg(1)
  val x17540_reg = list_x17539_reg(2)
  val x17551 = list_x17551(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17710_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x17710_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17710_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x17705_outr_UnitPipe = new x17705_outr_UnitPipe_kernel(List(x9495_reg), List(x17550), List(x17539_reg,x17304_out_SRAM_bias_0,x17540_reg), List(x17551), List(x2682_tmp_DRAM) , Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, rr)
      x17705_outr_UnitPipe.sm.io.ctrDone := risingEdge(x17705_outr_UnitPipe.sm.io.ctrInc)
      x17705_outr_UnitPipe.backpressure := true.B | x17705_outr_UnitPipe.sm.io.doneLatch
      x17705_outr_UnitPipe.forwardpressure := true.B | x17705_outr_UnitPipe.sm.io.doneLatch
      x17705_outr_UnitPipe.sm.io.enableOut.zip(x17705_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x17705_outr_UnitPipe.sm.io.break := false.B
      x17705_outr_UnitPipe.mask := true.B & true.B
      x17705_outr_UnitPipe.configure("x17705_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17705_outr_UnitPipe.kernel()
      val x17709_inr_UnitPipe = new x17709_inr_UnitPipe_kernel(List(x17552) , Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x17709_inr_UnitPipe.sm.io.ctrDone := risingEdge(x17709_inr_UnitPipe.sm.io.ctrInc)
      x17709_inr_UnitPipe.backpressure := true.B | x17709_inr_UnitPipe.sm.io.doneLatch
      x17709_inr_UnitPipe.forwardpressure := x17552.valid | x17709_inr_UnitPipe.sm.io.doneLatch
      x17709_inr_UnitPipe.sm.io.enableOut.zip(x17709_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x17709_inr_UnitPipe.sm.io.break := false.B
      x17709_inr_UnitPipe.mask := true.B & true.B
      x17709_inr_UnitPipe.configure("x17709_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17709_inr_UnitPipe.kernel()
    }
    val module = Module(new x17710_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x17710_outr_UnitPipe **/
