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

/** Hierarchy: x9765 -> x9766 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9765_outr_UnitPipe **/
class x9765_outr_UnitPipe_kernel(
  list_x9583_weight_SRAM_0: List[NBufInterface],
  list_x9594_fifo: List[FIFOInterface],
  list_b9592: List[Bool],
  list_x9595: List[DecoupledIO[AppLoadData]],
  list_b9591: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x9765_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9765_outr_UnitPipe_iiCtr"))
  
  abstract class x9765_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9594_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x9594_fifo_p").asInstanceOf[MemParams] ))
      val in_b9592 = Input(Bool())
      val in_b9553 = Input(Bool())
      val in_x9595 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9595_p").asInstanceOf[(Int, Int)] )))
      val in_b9591 = Input(new FixedPoint(true, 32, 0))
      val in_x9583_weight_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9583_weight_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x9594_fifo = {io.in_x9594_fifo} ; io.in_x9594_fifo := DontCare
    def b9592 = {io.in_b9592} 
    def b9553 = {io.in_b9553} 
    def x9595 = {io.in_x9595} 
    def b9591 = {io.in_b9591} 
    def x9583_weight_SRAM_0 = {io.in_x9583_weight_SRAM_0} ; io.in_x9583_weight_SRAM_0 := DontCare
  }
  def connectWires0(module: x9765_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x9594_fifo.connectLedger(module.io.in_x9594_fifo)
    module.io.in_b9592 <> b9592
    module.io.in_b9553 <> b9553
    module.io.in_x9595 <> x9595
    module.io.in_b9591 <> b9591
    x9583_weight_SRAM_0.connectLedger(module.io.in_x9583_weight_SRAM_0)
  }
  val x9583_weight_SRAM_0 = list_x9583_weight_SRAM_0(0)
  val x9594_fifo = list_x9594_fifo(0)
  val b9592 = list_b9592(0)
  val b9553 = list_b9592(1)
  val x9595 = list_x9595(0)
  val b9591 = list_b9591(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9765_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9765_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9765_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9626_reg = (new x9626_reg).m.io.asInstanceOf[StandardInterface]
      val x9627_reg = (new x9627_reg).m.io.asInstanceOf[StandardInterface]
      val x9628_reg = (new x9628_reg).m.io.asInstanceOf[StandardInterface]
      val x9637_inr_UnitPipe = new x9637_inr_UnitPipe_kernel(List(x9594_fifo), List(x9626_reg,x9627_reg,x9628_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x9637_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9637_inr_UnitPipe.sm.io.ctrInc)
      x9637_inr_UnitPipe.backpressure := true.B | x9637_inr_UnitPipe.sm.io.doneLatch
      x9637_inr_UnitPipe.forwardpressure := (~x9594_fifo.empty | ~(x9594_fifo.accessActivesOut(1))) | x9637_inr_UnitPipe.sm.io.doneLatch
      x9637_inr_UnitPipe.sm.io.enableOut.zip(x9637_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9637_inr_UnitPipe.sm.io.break := false.B
      x9637_inr_UnitPipe.mask := true.B & true.B
      x9637_inr_UnitPipe.configure("x9637_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9637_inr_UnitPipe.kernel()
      val x18789_rd_x9628 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18789_rd_x9628""")
      val x18789_rd_x9628_banks = List[UInt]()
      val x18789_rd_x9628_ofs = List[UInt]()
      val x18789_rd_x9628_en = List[Bool](true.B)
      x18789_rd_x9628.toSeq.zip(x9628_reg.connectRPort(18789, x18789_rd_x9628_banks, x18789_rd_x9628_ofs, io.sigsIn.backpressure, x18789_rd_x9628_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9639_ctr = new CtrObject(Left(Some(0)), Right(x18789_rd_x9628), Left(Some(1)), 8, 32, false)
      val x9640_ctrchain = (new CChainObject(List[CtrObject](x9639_ctr), "x9640_ctrchain")).cchain.io 
      x9640_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x9640_ctrchain_p", (x9640_ctrchain.par, x9640_ctrchain.widths))
      val x9764_inr_Foreach = new x9764_inr_Foreach_kernel(List(b9591), List(x9595), List(x9583_weight_SRAM_0), List(x9626_reg,x9627_reg) , Some(me), List(x9640_ctrchain), 1, 1, 1, List(8), List(32), breakpoints, rr)
      x9764_inr_Foreach.sm.io.ctrDone := (x9764_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x9764_inr_Foreach.backpressure := true.B | x9764_inr_Foreach.sm.io.doneLatch
      x9764_inr_Foreach.forwardpressure := x9595.valid | x9764_inr_Foreach.sm.io.doneLatch
      x9764_inr_Foreach.sm.io.enableOut.zip(x9764_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x9764_inr_Foreach.sm.io.break := false.B
      x9764_inr_Foreach.mask := ~x9764_inr_Foreach.cchain.head.output.noop & true.B
      x9764_inr_Foreach.configure("x9764_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9764_inr_Foreach.kernel()
    }
    val module = Module(new x9765_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9765_outr_UnitPipe **/
