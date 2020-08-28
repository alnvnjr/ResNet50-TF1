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

/** Hierarchy: x3868 -> x3897 -> x3898 -> x1256 **/
/** BEGIN None x3868_inr_UnitPipe **/
class x3868_inr_UnitPipe_kernel(
  list_b3121: List[Bool],
  list_b3120: List[FixedPoint],
  list_x3864_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 8.0.toInt, myName = "x3868_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3868_inr_UnitPipe_iiCtr"))
  
  abstract class x3868_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b3120 = Input(new FixedPoint(true, 32, 0))
      val in_b3121 = Input(Bool())
      val in_b3704 = Input(Bool())
      val in_b3703 = Input(new FixedPoint(true, 32, 0))
      val in_x3864_reg = Flipped(new NBufInterface(ModuleParams.getParams("x3864_reg_p").asInstanceOf[NBufParams] ))
      val in_x3705_tmp0_SRAM_pool_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3705_tmp0_SRAM_pool_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b3120 = {io.in_b3120} 
    def b3121 = {io.in_b3121} 
    def b3704 = {io.in_b3704} 
    def b3703 = {io.in_b3703} 
    def x3864_reg = {io.in_x3864_reg} ; io.in_x3864_reg := DontCare
    def x3705_tmp0_SRAM_pool_0 = {io.in_x3705_tmp0_SRAM_pool_0} ; io.in_x3705_tmp0_SRAM_pool_0 := DontCare
  }
  def connectWires0(module: x3868_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b3120 <> b3120
    module.io.in_b3121 <> b3121
    module.io.in_b3704 <> b3704
    module.io.in_b3703 <> b3703
    x3864_reg.connectLedger(module.io.in_x3864_reg)
    x3705_tmp0_SRAM_pool_0.connectLedger(module.io.in_x3705_tmp0_SRAM_pool_0)
  }
  val b3121 = list_b3121(0)
  val b3704 = list_b3121(1)
  val b3120 = list_b3120(0)
  val b3703 = list_b3120(1)
  val x3864_reg = list_x3864_reg(0)
  val x3705_tmp0_SRAM_pool_0 = list_x3864_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3868_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3868_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3868_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3865_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3865_sum""")
      x3865_sum.r := Math.add(b3120,b3703,Some(1.0), true.B, Truncate, Wrapping, "x3865_sum").r
      val x3866_x33 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3866_x33""")
      x3866_x33.r := (Math.mul(x3865_sum, 3136L.FP(true, 32, 0), Some(6.0), true.B, Truncate, Wrapping, "x3866_x33")).r
      val x3867_wr_x3864_banks = List[UInt]()
      val x3867_wr_x3864_ofs = List[UInt]()
      val x3867_wr_x3864_en = List[Bool](true.B)
      val x3867_wr_x3864_data = List[UInt](x3866_x33.r)
      x3864_reg.connectWPort(3867, x3867_wr_x3864_banks, x3867_wr_x3864_ofs, x3867_wr_x3864_data, x3867_wr_x3864_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x3705_tmp0_SRAM_pool_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x3864_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x3868_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3868_inr_UnitPipe **/
