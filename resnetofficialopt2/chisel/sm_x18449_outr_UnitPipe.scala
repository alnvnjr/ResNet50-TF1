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

/** Hierarchy: x18449 -> x18450 -> x18477 -> x1256 **/
/** BEGIN None x18449_outr_UnitPipe **/
class x18449_outr_UnitPipe_kernel(
  list_x18389_fifo: List[FIFOInterface],
  list_x18390: List[DecoupledIO[AppLoadData]],
  list_x18380_feature_map_0: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x18449_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18449_outr_UnitPipe_iiCtr"))
  
  abstract class x18449_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18380_feature_map_0 = Flipped(new NBufInterface(ModuleParams.getParams("x18380_feature_map_0_p").asInstanceOf[NBufParams] ))
      val in_x18389_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x18389_fifo_p").asInstanceOf[MemParams] ))
      val in_x18390 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18390_p").asInstanceOf[(Int, Int)] )))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x18380_feature_map_0 = {io.in_x18380_feature_map_0} ; io.in_x18380_feature_map_0 := DontCare
    def x18389_fifo = {io.in_x18389_fifo} ; io.in_x18389_fifo := DontCare
    def x18390 = {io.in_x18390} 
  }
  def connectWires0(module: x18449_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x18380_feature_map_0.connectLedger(module.io.in_x18380_feature_map_0)
    x18389_fifo.connectLedger(module.io.in_x18389_fifo)
    module.io.in_x18390 <> x18390
  }
  val x18389_fifo = list_x18389_fifo(0)
  val x18390 = list_x18390(0)
  val x18380_feature_map_0 = list_x18380_feature_map_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18449_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18449_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18449_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18420_reg = (new x18420_reg).m.io.asInstanceOf[StandardInterface]
      val x18421_reg = (new x18421_reg).m.io.asInstanceOf[StandardInterface]
      val x18422_reg = (new x18422_reg).m.io.asInstanceOf[StandardInterface]
      val x18431_inr_UnitPipe = new x18431_inr_UnitPipe_kernel(List(x18389_fifo), List(x18420_reg,x18421_reg,x18422_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x18431_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18431_inr_UnitPipe.sm.io.ctrInc)
      x18431_inr_UnitPipe.backpressure := true.B | x18431_inr_UnitPipe.sm.io.doneLatch
      x18431_inr_UnitPipe.forwardpressure := (~x18389_fifo.empty | ~(x18389_fifo.accessActivesOut(1))) | x18431_inr_UnitPipe.sm.io.doneLatch
      x18431_inr_UnitPipe.sm.io.enableOut.zip(x18431_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18431_inr_UnitPipe.sm.io.break := false.B
      x18431_inr_UnitPipe.mask := true.B & true.B
      x18431_inr_UnitPipe.configure("x18431_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18431_inr_UnitPipe.kernel()
      val x18814_rd_x18422 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18814_rd_x18422""")
      val x18814_rd_x18422_banks = List[UInt]()
      val x18814_rd_x18422_ofs = List[UInt]()
      val x18814_rd_x18422_en = List[Bool](true.B)
      x18814_rd_x18422.toSeq.zip(x18422_reg.connectRPort(18814, x18814_rd_x18422_banks, x18814_rd_x18422_ofs, io.sigsIn.backpressure, x18814_rd_x18422_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18433_ctr = new CtrObject(Left(Some(0)), Right(x18814_rd_x18422), Left(Some(1)), 1, 32, false)
      val x18434_ctrchain = (new CChainObject(List[CtrObject](x18433_ctr), "x18434_ctrchain")).cchain.io 
      x18434_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x18434_ctrchain_p", (x18434_ctrchain.par, x18434_ctrchain.widths))
      val x18448_inr_Foreach = new x18448_inr_Foreach_kernel(List(x18390), List(x18380_feature_map_0), List(x18420_reg,x18421_reg) , Some(me), List(x18434_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x18448_inr_Foreach.sm.io.ctrDone := (x18448_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x18448_inr_Foreach.backpressure := true.B | x18448_inr_Foreach.sm.io.doneLatch
      x18448_inr_Foreach.forwardpressure := x18390.valid | x18448_inr_Foreach.sm.io.doneLatch
      x18448_inr_Foreach.sm.io.enableOut.zip(x18448_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x18448_inr_Foreach.sm.io.break := false.B
      x18448_inr_Foreach.mask := ~x18448_inr_Foreach.cchain.head.output.noop & true.B
      x18448_inr_Foreach.configure("x18448_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18448_inr_Foreach.kernel()
    }
    val module = Module(new x18449_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18449_outr_UnitPipe **/
