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

/** Hierarchy: x18497 -> x1256 **/
/** BEGIN None x18497_outr_UnitPipe **/
class x18497_outr_UnitPipe_kernel(
  list_x3096_c87_DRAM: List[FixedPoint],
  list_x18479: List[DecoupledIO[AppCommandDense]],
  list_x18480: List[DecoupledIO[AppLoadData]],
  list_x18478_c87_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x18497_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18497_outr_UnitPipe_iiCtr"))
  
  abstract class x18497_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18478_c87_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18478_c87_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x3096_c87_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x18479 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18479_p").asInstanceOf[(Int,Int)] ))
      val in_x18480 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18480_p").asInstanceOf[(Int, Int)] )))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x18478_c87_SRAM_0 = {io.in_x18478_c87_SRAM_0} ; io.in_x18478_c87_SRAM_0 := DontCare
    def x3096_c87_DRAM = {io.in_x3096_c87_DRAM} 
    def x18479 = {io.in_x18479} 
    def x18480 = {io.in_x18480} 
  }
  def connectWires0(module: x18497_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x18478_c87_SRAM_0.connectLedger(module.io.in_x18478_c87_SRAM_0)
    module.io.in_x3096_c87_DRAM <> x3096_c87_DRAM
    module.io.in_x18479 <> x18479
    module.io.in_x18480 <> x18480
  }
  val x3096_c87_DRAM = list_x3096_c87_DRAM(0)
  val x18479 = list_x18479(0)
  val x18480 = list_x18480(0)
  val x18478_c87_SRAM_0 = list_x18478_c87_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18497_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18497_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18497_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18485_inr_UnitPipe = new x18485_inr_UnitPipe_kernel(List(x3096_c87_DRAM), List(x18479) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x18485_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18485_inr_UnitPipe.sm.io.ctrInc)
      x18485_inr_UnitPipe.backpressure := x18479.ready | x18485_inr_UnitPipe.sm.io.doneLatch
      x18485_inr_UnitPipe.forwardpressure := true.B | x18485_inr_UnitPipe.sm.io.doneLatch
      x18485_inr_UnitPipe.sm.io.enableOut.zip(x18485_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18485_inr_UnitPipe.sm.io.break := false.B
      x18485_inr_UnitPipe.mask := true.B & true.B
      x18485_inr_UnitPipe.configure("x18485_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18485_inr_UnitPipe.kernel()
      val x18487_ctr = new CtrObject(Left(Some(0)), Left(Some(1008)), Left(Some(1)), 1, 32, false)
      val x18488_ctrchain = (new CChainObject(List[CtrObject](x18487_ctr), "x18488_ctrchain")).cchain.io 
      x18488_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x18488_ctrchain_p", (x18488_ctrchain.par, x18488_ctrchain.widths))
      val x18496_inr_Foreach = new x18496_inr_Foreach_kernel(List(x18480), List(x18478_c87_SRAM_0) , Some(me), List(x18488_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x18496_inr_Foreach.sm.io.ctrDone := (x18496_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x18496_inr_Foreach.backpressure := true.B | x18496_inr_Foreach.sm.io.doneLatch
      x18496_inr_Foreach.forwardpressure := x18480.valid | x18496_inr_Foreach.sm.io.doneLatch
      x18496_inr_Foreach.sm.io.enableOut.zip(x18496_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x18496_inr_Foreach.sm.io.break := false.B
      x18496_inr_Foreach.mask := ~x18496_inr_Foreach.cchain.head.output.noop & true.B
      x18496_inr_Foreach.configure("x18496_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18496_inr_Foreach.kernel()
    }
    val module = Module(new x18497_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18497_outr_UnitPipe **/
