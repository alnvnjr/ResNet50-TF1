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

/** Hierarchy: x3210 -> x3211 -> x3898 -> x1256 **/
/** BEGIN None x3210_outr_UnitPipe **/
class x3210_outr_UnitPipe_kernel(
  list_b3137: List[FixedPoint],
  list_b3121: List[Bool],
  list_x3141_fifo: List[FIFOInterface],
  list_x3132_c101_SRAM_0: List[NBufInterface],
  list_x3142: List[DecoupledIO[AppLoadData]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x3210_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3210_outr_UnitPipe_iiCtr"))
  
  abstract class x3210_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b3121 = Input(Bool())
      val in_b3137 = Input(new FixedPoint(true, 32, 0))
      val in_x3141_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x3141_fifo_p").asInstanceOf[MemParams] ))
      val in_b3138 = Input(Bool())
      val in_x3142 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3142_p").asInstanceOf[(Int, Int)] )))
      val in_b3139 = Input(Bool())
      val in_b3136 = Input(new FixedPoint(true, 32, 0))
      val in_x3132_c101_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3132_c101_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def b3121 = {io.in_b3121} 
    def b3137 = {io.in_b3137} 
    def x3141_fifo = {io.in_x3141_fifo} ; io.in_x3141_fifo := DontCare
    def b3138 = {io.in_b3138} 
    def x3142 = {io.in_x3142} 
    def b3139 = {io.in_b3139} 
    def b3136 = {io.in_b3136} 
    def x3132_c101_SRAM_0 = {io.in_x3132_c101_SRAM_0} ; io.in_x3132_c101_SRAM_0 := DontCare
  }
  def connectWires0(module: x3210_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b3121 <> b3121
    module.io.in_b3137 <> b3137
    x3141_fifo.connectLedger(module.io.in_x3141_fifo)
    module.io.in_b3138 <> b3138
    module.io.in_x3142 <> x3142
    module.io.in_b3139 <> b3139
    module.io.in_b3136 <> b3136
    x3132_c101_SRAM_0.connectLedger(module.io.in_x3132_c101_SRAM_0)
  }
  val b3137 = list_b3137(0)
  val b3136 = list_b3137(1)
  val b3121 = list_b3121(0)
  val b3138 = list_b3121(1)
  val b3139 = list_b3121(2)
  val x3141_fifo = list_x3141_fifo(0)
  val x3132_c101_SRAM_0 = list_x3132_c101_SRAM_0(0)
  val x3142 = list_x3142(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3210_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3210_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3210_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3172_reg = (new x3172_reg).m.io.asInstanceOf[StandardInterface]
      val x3173_reg = (new x3173_reg).m.io.asInstanceOf[StandardInterface]
      val x3174_reg = (new x3174_reg).m.io.asInstanceOf[StandardInterface]
      val x3183_inr_UnitPipe = new x3183_inr_UnitPipe_kernel(List(x3141_fifo), List(x3172_reg,x3173_reg,x3174_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x3183_inr_UnitPipe.sm.io.ctrDone := risingEdge(x3183_inr_UnitPipe.sm.io.ctrInc)
      x3183_inr_UnitPipe.backpressure := true.B | x3183_inr_UnitPipe.sm.io.doneLatch
      x3183_inr_UnitPipe.forwardpressure := (~x3141_fifo.empty | ~(x3141_fifo.accessActivesOut(1))) | x3183_inr_UnitPipe.sm.io.doneLatch
      x3183_inr_UnitPipe.sm.io.enableOut.zip(x3183_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x3183_inr_UnitPipe.sm.io.break := false.B
      x3183_inr_UnitPipe.mask := true.B & true.B
      x3183_inr_UnitPipe.configure("x3183_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3183_inr_UnitPipe.kernel()
      val x18764_rd_x3174 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18764_rd_x3174""")
      val x18764_rd_x3174_banks = List[UInt]()
      val x18764_rd_x3174_ofs = List[UInt]()
      val x18764_rd_x3174_en = List[Bool](true.B)
      x18764_rd_x3174.toSeq.zip(x3174_reg.connectRPort(18764, x18764_rd_x3174_banks, x18764_rd_x3174_ofs, io.sigsIn.backpressure, x18764_rd_x3174_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x3185_ctr = new CtrObject(Left(Some(0)), Right(x18764_rd_x3174), Left(Some(1)), 1, 32, false)
      val x3186_ctrchain = (new CChainObject(List[CtrObject](x3185_ctr), "x3186_ctrchain")).cchain.io 
      x3186_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x3186_ctrchain_p", (x3186_ctrchain.par, x3186_ctrchain.widths))
      val x3209_inr_Foreach = new x3209_inr_Foreach_kernel(List(b3137,b3136), List(x3142), List(x3132_c101_SRAM_0), List(x3172_reg,x3173_reg) , Some(me), List(x3186_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x3209_inr_Foreach.sm.io.ctrDone := (x3209_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x3209_inr_Foreach.backpressure := true.B | x3209_inr_Foreach.sm.io.doneLatch
      x3209_inr_Foreach.forwardpressure := x3142.valid | x3209_inr_Foreach.sm.io.doneLatch
      x3209_inr_Foreach.sm.io.enableOut.zip(x3209_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x3209_inr_Foreach.sm.io.break := false.B
      x3209_inr_Foreach.mask := ~x3209_inr_Foreach.cchain.head.output.noop & true.B
      x3209_inr_Foreach.configure("x3209_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x3209_inr_Foreach.kernel()
    }
    val module = Module(new x3210_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3210_outr_UnitPipe **/
