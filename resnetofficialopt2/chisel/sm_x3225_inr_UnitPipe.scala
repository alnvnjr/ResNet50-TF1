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

/** Hierarchy: x3225 -> x3699 -> x3700 -> x3898 -> x1256 **/
/** BEGIN None x3225_inr_UnitPipe **/
class x3225_inr_UnitPipe_kernel(
  list_b3121: List[Bool],
  list_b3219: List[FixedPoint],
  list_x3221_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 1.2.toInt, myName = "x3225_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3225_inr_UnitPipe_iiCtr"))
  
  abstract class x3225_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b3121 = Input(Bool())
      val in_x3221_reg = Flipped(new NBufInterface(ModuleParams.getParams("x3221_reg_p").asInstanceOf[NBufParams] ))
      val in_b3215 = Input(Bool())
      val in_b3219 = Input(new FixedPoint(true, 32, 0))
      val in_b3220 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b3121 = {io.in_b3121} 
    def x3221_reg = {io.in_x3221_reg} ; io.in_x3221_reg := DontCare
    def b3215 = {io.in_b3215} 
    def b3219 = {io.in_b3219} 
    def b3220 = {io.in_b3220} 
  }
  def connectWires0(module: x3225_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b3121 <> b3121
    x3221_reg.connectLedger(module.io.in_x3221_reg)
    module.io.in_b3215 <> b3215
    module.io.in_b3219 <> b3219
    module.io.in_b3220 <> b3220
  }
  val b3121 = list_b3121(0)
  val b3215 = list_b3121(1)
  val b3220 = list_b3121(2)
  val b3219 = list_b3219(0)
  val x3221_reg = list_x3221_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3225_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3225_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3225_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3222 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3222""")
      x3222.r := Math.arith_left_shift(b3219, 1, Some(0.2), true.B,"x3222").r
      val x3223 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3223""")
      x3223.r := Mux((x3222 < 228L.FP(true, 32, 0)), x3222, 228L.FP(true, 32, 0)).r
      val x3224_wr_x3221_banks = List[UInt]()
      val x3224_wr_x3221_ofs = List[UInt]()
      val x3224_wr_x3221_en = List[Bool](true.B)
      val x3224_wr_x3221_data = List[UInt](x3223.r)
      x3221_reg.connectWPort(3224, x3224_wr_x3221_banks, x3224_wr_x3221_ofs, x3224_wr_x3221_data, x3224_wr_x3221_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x3221_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x3225_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3225_inr_UnitPipe **/
