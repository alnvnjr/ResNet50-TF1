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

/** Hierarchy: x9866 -> x17297 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9866_inr_UnitPipe **/
class x9866_inr_UnitPipe_kernel(
  list_b9853: List[Bool],
  list_b9852: List[FixedPoint],
  list_x9862_reg: List[NBufInterface],
  list_x9485_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 7.0.toInt, myName = "x9866_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9866_inr_UnitPipe_iiCtr"))
  
  abstract class x9866_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9485_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9485_reg_p").asInstanceOf[MemParams] ))
      val in_b9853 = Input(Bool())
      val in_b9852 = Input(new FixedPoint(true, 32, 0))
      val in_b9553 = Input(Bool())
      val in_x9862_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9862_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9485_reg = {io.in_x9485_reg} ; io.in_x9485_reg := DontCare
    def b9853 = {io.in_b9853} 
    def b9852 = {io.in_b9852} 
    def b9553 = {io.in_b9553} 
    def x9862_reg = {io.in_x9862_reg} ; io.in_x9862_reg := DontCare
  }
  def connectWires0(module: x9866_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x9485_reg.connectLedger(module.io.in_x9485_reg)
    module.io.in_b9853 <> b9853
    module.io.in_b9852 <> b9852
    module.io.in_b9553 <> b9553
    x9862_reg.connectLedger(module.io.in_x9862_reg)
  }
  val b9853 = list_b9853(0)
  val b9553 = list_b9853(1)
  val b9852 = list_b9852(0)
  val x9862_reg = list_x9862_reg(0)
  val x9485_reg = list_x9485_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9866_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9866_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9866_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9863_rd_x9485 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9863_rd_x9485""")
      val x9863_rd_x9485_banks = List[UInt]()
      val x9863_rd_x9485_ofs = List[UInt]()
      val x9863_rd_x9485_en = List[Bool](true.B)
      x9863_rd_x9485.toSeq.zip(x9485_reg.connectRPort(9863, x9863_rd_x9485_banks, x9863_rd_x9485_ofs, io.sigsIn.backpressure, x9863_rd_x9485_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9864_x11 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9864_x11""")
      x9864_x11.r := (Math.mul(b9852, x9863_rd_x9485, Some(6.0), true.B, Truncate, Wrapping, "x9864_x11")).r
      val x9865_wr_x9862_banks = List[UInt]()
      val x9865_wr_x9862_ofs = List[UInt]()
      val x9865_wr_x9862_en = List[Bool](true.B)
      val x9865_wr_x9862_data = List[UInt](x9864_x11.r)
      x9862_reg.connectWPort(9865, x9865_wr_x9862_banks, x9865_wr_x9862_ofs, x9865_wr_x9862_data, x9865_wr_x9862_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x9862_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x9866_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9866_inr_UnitPipe **/
