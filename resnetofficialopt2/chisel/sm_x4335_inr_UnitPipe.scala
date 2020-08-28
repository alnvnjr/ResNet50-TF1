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

/** Hierarchy: x4335 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4335_inr_UnitPipe **/
class x4335_inr_UnitPipe_kernel(
  list_b4068: List[Bool],
  list_b4067: List[FixedPoint],
  list_x4331_reg: List[NBufInterface],
  list_x3935_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 7.0.toInt, myName = "x4335_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4335_inr_UnitPipe_iiCtr"))
  
  abstract class x4335_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3935_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3935_reg_p").asInstanceOf[MemParams] ))
      val in_b4068 = Input(Bool())
      val in_b4060 = Input(Bool())
      val in_b4067 = Input(new FixedPoint(true, 32, 0))
      val in_x4331_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4331_reg_p").asInstanceOf[NBufParams] ))
      val in_x4241_weight_SRAM_reshape_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4241_weight_SRAM_reshape_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3935_reg = {io.in_x3935_reg} ; io.in_x3935_reg := DontCare
    def b4068 = {io.in_b4068} 
    def b4060 = {io.in_b4060} 
    def b4067 = {io.in_b4067} 
    def x4331_reg = {io.in_x4331_reg} ; io.in_x4331_reg := DontCare
    def x4241_weight_SRAM_reshape_0 = {io.in_x4241_weight_SRAM_reshape_0} ; io.in_x4241_weight_SRAM_reshape_0 := DontCare
  }
  def connectWires0(module: x4335_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3935_reg.connectLedger(module.io.in_x3935_reg)
    module.io.in_b4068 <> b4068
    module.io.in_b4060 <> b4060
    module.io.in_b4067 <> b4067
    x4331_reg.connectLedger(module.io.in_x4331_reg)
    x4241_weight_SRAM_reshape_0.connectLedger(module.io.in_x4241_weight_SRAM_reshape_0)
  }
  val b4068 = list_b4068(0)
  val b4060 = list_b4068(1)
  val b4067 = list_b4067(0)
  val x4331_reg = list_x4331_reg(0)
  val x4241_weight_SRAM_reshape_0 = list_x4331_reg(1)
  val x3935_reg = list_x3935_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4335_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4335_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4335_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4332_rd_x3935 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4332_rd_x3935""")
      val x4332_rd_x3935_banks = List[UInt]()
      val x4332_rd_x3935_ofs = List[UInt]()
      val x4332_rd_x3935_en = List[Bool](true.B)
      x4332_rd_x3935.toSeq.zip(x3935_reg.connectRPort(4332, x4332_rd_x3935_banks, x4332_rd_x3935_ofs, io.sigsIn.backpressure, x4332_rd_x3935_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4333_x16 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4333_x16""")
      x4333_x16.r := (Math.mul(b4067, x4332_rd_x3935, Some(6.0), true.B, Truncate, Wrapping, "x4333_x16")).r
      val x4334_wr_x4331_banks = List[UInt]()
      val x4334_wr_x4331_ofs = List[UInt]()
      val x4334_wr_x4331_en = List[Bool](true.B)
      val x4334_wr_x4331_data = List[UInt](x4333_x16.r)
      x4331_reg.connectWPort(4334, x4334_wr_x4331_banks, x4334_wr_x4331_ofs, x4334_wr_x4331_data, x4334_wr_x4331_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x4241_weight_SRAM_reshape_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x4331_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x4335_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4335_inr_UnitPipe **/
