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

/** Hierarchy: x18644 -> x1256 **/
/** BEGIN None x18644_outr_UnitPipe **/
class x18644_outr_UnitPipe_kernel(
  list_x18622: List[DecoupledIO[AppStoreData]],
  list_x18623: List[DecoupledIO[Bool]],
  list_x2680_tmp76_DRAM: List[FixedPoint],
  list_x18621: List[DecoupledIO[AppCommandDense]],
  list_x18498_tmp76_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 3, isFSM = false   , latency = 0.0.toInt, myName = "x18644_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18644_outr_UnitPipe_iiCtr"))
  
  abstract class x18644_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18498_tmp76_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18498_tmp76_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x18621 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18621_p").asInstanceOf[(Int,Int)] ))
      val in_x18622 = Decoupled(new AppStoreData(ModuleParams.getParams("x18622_p").asInstanceOf[(Int,Int)] ))
      val in_x2680_tmp76_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x18623 = Flipped(Decoupled(Bool()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 3, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 3))
      val rr = Input(Bool())
    })
    def x18498_tmp76_SRAM_0 = {io.in_x18498_tmp76_SRAM_0} ; io.in_x18498_tmp76_SRAM_0 := DontCare
    def x18621 = {io.in_x18621} 
    def x18622 = {io.in_x18622} 
    def x2680_tmp76_DRAM = {io.in_x2680_tmp76_DRAM} 
    def x18623 = {io.in_x18623} 
  }
  def connectWires0(module: x18644_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x18498_tmp76_SRAM_0.connectLedger(module.io.in_x18498_tmp76_SRAM_0)
    module.io.in_x18621 <> x18621
    module.io.in_x18622 <> x18622
    module.io.in_x2680_tmp76_DRAM <> x2680_tmp76_DRAM
    module.io.in_x18623 <> x18623
  }
  val x18622 = list_x18622(0)
  val x18623 = list_x18623(0)
  val x2680_tmp76_DRAM = list_x2680_tmp76_DRAM(0)
  val x18621 = list_x18621(0)
  val x18498_tmp76_SRAM_0 = list_x18498_tmp76_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18644_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18644_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18644_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18628_inr_UnitPipe = new x18628_inr_UnitPipe_kernel(List(x2680_tmp76_DRAM), List(x18621) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x18628_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18628_inr_UnitPipe.sm.io.ctrInc)
      x18628_inr_UnitPipe.backpressure := x18621.ready | x18628_inr_UnitPipe.sm.io.doneLatch
      x18628_inr_UnitPipe.forwardpressure := true.B | x18628_inr_UnitPipe.sm.io.doneLatch
      x18628_inr_UnitPipe.sm.io.enableOut.zip(x18628_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18628_inr_UnitPipe.sm.io.break := false.B
      x18628_inr_UnitPipe.mask := true.B & true.B
      x18628_inr_UnitPipe.configure("x18628_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18628_inr_UnitPipe.kernel()
      val x18629_ctr = new CtrObject(Left(Some(0)), Left(Some(1008)), Left(Some(1)), 1, 32, false)
      val x18630_ctrchain = (new CChainObject(List[CtrObject](x18629_ctr), "x18630_ctrchain")).cchain.io 
      x18630_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x18630_ctrchain_p", (x18630_ctrchain.par, x18630_ctrchain.widths))
      val x18639_inr_Foreach = new x18639_inr_Foreach_kernel(List(x18498_tmp76_SRAM_0), List(x18622) , Some(me), List(x18630_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x18639_inr_Foreach.sm.io.ctrDone := (x18639_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x18639_inr_Foreach.backpressure := x18622.ready | x18639_inr_Foreach.sm.io.doneLatch
      x18639_inr_Foreach.forwardpressure := true.B | x18639_inr_Foreach.sm.io.doneLatch
      x18639_inr_Foreach.sm.io.enableOut.zip(x18639_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x18639_inr_Foreach.sm.io.break := false.B
      x18639_inr_Foreach.mask := ~x18639_inr_Foreach.cchain.head.output.noop & true.B
      x18639_inr_Foreach.configure("x18639_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18639_inr_Foreach.kernel()
      val x18643_inr_UnitPipe = new x18643_inr_UnitPipe_kernel(List(x18623) , Some(me), List(), 2, 1, 1, List(1), List(32), breakpoints, rr)
      x18643_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18643_inr_UnitPipe.sm.io.ctrInc)
      x18643_inr_UnitPipe.backpressure := true.B | x18643_inr_UnitPipe.sm.io.doneLatch
      x18643_inr_UnitPipe.forwardpressure := x18623.valid | x18643_inr_UnitPipe.sm.io.doneLatch
      x18643_inr_UnitPipe.sm.io.enableOut.zip(x18643_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18643_inr_UnitPipe.sm.io.break := false.B
      x18643_inr_UnitPipe.mask := true.B & true.B
      x18643_inr_UnitPipe.configure("x18643_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18643_inr_UnitPipe.kernel()
    }
    val module = Module(new x18644_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18644_outr_UnitPipe **/
