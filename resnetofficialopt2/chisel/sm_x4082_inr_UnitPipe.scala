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

/** Hierarchy: x4082 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4082_inr_UnitPipe **/
class x4082_inr_UnitPipe_kernel(
  list_b4068: List[Bool],
  list_b4059: List[FixedPoint],
  list_x4070_reg: List[NBufInterface],
  list_x3947_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 9.0.toInt, myName = "x4082_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4082_inr_UnitPipe_iiCtr"))
  
  abstract class x4082_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3947_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3947_reg_p").asInstanceOf[MemParams] ))
      val in_x4070_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4070_reg_p").asInstanceOf[NBufParams] ))
      val in_x4072_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4072_reg_p").asInstanceOf[NBufParams] ))
      val in_b4059 = Input(new FixedPoint(true, 32, 0))
      val in_b4068 = Input(Bool())
      val in_b4060 = Input(Bool())
      val in_b4067 = Input(new FixedPoint(true, 32, 0))
      val in_x4071_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4071_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3947_reg = {io.in_x3947_reg} ; io.in_x3947_reg := DontCare
    def x4070_reg = {io.in_x4070_reg} ; io.in_x4070_reg := DontCare
    def x4072_reg = {io.in_x4072_reg} ; io.in_x4072_reg := DontCare
    def b4059 = {io.in_b4059} 
    def b4068 = {io.in_b4068} 
    def b4060 = {io.in_b4060} 
    def b4067 = {io.in_b4067} 
    def x4071_reg = {io.in_x4071_reg} ; io.in_x4071_reg := DontCare
  }
  def connectWires0(module: x4082_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3947_reg.connectLedger(module.io.in_x3947_reg)
    x4070_reg.connectLedger(module.io.in_x4070_reg)
    x4072_reg.connectLedger(module.io.in_x4072_reg)
    module.io.in_b4059 <> b4059
    module.io.in_b4068 <> b4068
    module.io.in_b4060 <> b4060
    module.io.in_b4067 <> b4067
    x4071_reg.connectLedger(module.io.in_x4071_reg)
  }
  val b4068 = list_b4068(0)
  val b4060 = list_b4068(1)
  val b4059 = list_b4059(0)
  val b4067 = list_b4059(1)
  val x4070_reg = list_x4070_reg(0)
  val x4072_reg = list_x4070_reg(1)
  val x4071_reg = list_x4070_reg(2)
  val x3947_reg = list_x3947_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4082_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4082_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4082_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4073_rd_x3947 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4073_rd_x3947""")
      val x4073_rd_x3947_banks = List[UInt]()
      val x4073_rd_x3947_ofs = List[UInt]()
      val x4073_rd_x3947_en = List[Bool](true.B)
      x4073_rd_x3947.toSeq.zip(x3947_reg.connectRPort(4073, x4073_rd_x3947_banks, x4073_rd_x3947_ofs, io.sigsIn.backpressure, x4073_rd_x3947_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4074_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4074_sum""")
      x4074_sum.r := Math.add(x4073_rd_x3947,b4067,Some(1.0), true.B, Truncate, Wrapping, "x4074_sum").r
      val x4075_x15 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4075_x15""")
      x4075_x15.r := (Math.mul(9L.FP(true, 32, 0), b4059, Some(6.0), true.B, Truncate, Wrapping, "x4075_x15")).r
      val x4076_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4076_sum""")
      x4076_sum.r := Math.add(b4059,32L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x4076_sum").r
      val x4077_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4077_mul""")
      x4077_mul.r := (Math.mul(9L.FP(true, 32, 0), x4076_sum, Some(6.0), true.B, Truncate, Wrapping, "x4077_mul")).r
      val x19613 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19613_x4075_x15_D1") 
      x19613.r := getRetimed(x4075_x15.r, 1.toInt, io.sigsIn.backpressure)
      val x4078_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4078_sub""")
      x4078_sub.r := Math.sub(x4077_mul,x19613,Some(1.0), true.B, Truncate, Wrapping, "x4078_sub").r
      val x4079_wr_x4070_banks = List[UInt]()
      val x4079_wr_x4070_ofs = List[UInt]()
      val x4079_wr_x4070_en = List[Bool](true.B)
      val x4079_wr_x4070_data = List[UInt](x4074_sum.r)
      x4070_reg.connectWPort(4079, x4079_wr_x4070_banks, x4079_wr_x4070_ofs, x4079_wr_x4070_data, x4079_wr_x4070_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x4080_wr_x4071_banks = List[UInt]()
      val x4080_wr_x4071_ofs = List[UInt]()
      val x4080_wr_x4071_en = List[Bool](true.B)
      val x4080_wr_x4071_data = List[UInt](x4075_x15.r)
      x4071_reg.connectWPort(4080, x4080_wr_x4071_banks, x4080_wr_x4071_ofs, x4080_wr_x4071_data, x4080_wr_x4071_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x4081_wr_x4072_banks = List[UInt]()
      val x4081_wr_x4072_ofs = List[UInt]()
      val x4081_wr_x4072_en = List[Bool](true.B)
      val x4081_wr_x4072_data = List[UInt](x4078_sub.r)
      x4072_reg.connectWPort(4081, x4081_wr_x4072_banks, x4081_wr_x4072_ofs, x4081_wr_x4072_data, x4081_wr_x4072_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x4070_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4071_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4072_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x4082_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4082_inr_UnitPipe **/
