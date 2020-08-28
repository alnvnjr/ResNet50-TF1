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

/** Hierarchy: x9398 -> x9461 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9398_inr_UnitPipe **/
class x9398_inr_UnitPipe_kernel(
  list_b4060: List[Bool],
  list_b4059: List[FixedPoint],
  list_x3943_reg: List[StandardInterface],
  list_x9388_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 10.0.toInt, myName = "x9398_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9398_inr_UnitPipe_iiCtr"))
  
  abstract class x9398_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9388_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9388_reg_p").asInstanceOf[NBufParams] ))
      val in_b4059 = Input(new FixedPoint(true, 32, 0))
      val in_b9348 = Input(new FixedPoint(true, 32, 0))
      val in_b4060 = Input(Bool())
      val in_b9349 = Input(Bool())
      val in_x3943_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3943_reg_p").asInstanceOf[MemParams] ))
      val in_x9389_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9389_reg_p").asInstanceOf[NBufParams] ))
      val in_x9350_out_SRAM_bias_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9350_out_SRAM_bias_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9388_reg = {io.in_x9388_reg} ; io.in_x9388_reg := DontCare
    def b4059 = {io.in_b4059} 
    def b9348 = {io.in_b9348} 
    def b4060 = {io.in_b4060} 
    def b9349 = {io.in_b9349} 
    def x3943_reg = {io.in_x3943_reg} ; io.in_x3943_reg := DontCare
    def x9389_reg = {io.in_x9389_reg} ; io.in_x9389_reg := DontCare
    def x9350_out_SRAM_bias_0 = {io.in_x9350_out_SRAM_bias_0} ; io.in_x9350_out_SRAM_bias_0 := DontCare
  }
  def connectWires0(module: x9398_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x9388_reg.connectLedger(module.io.in_x9388_reg)
    module.io.in_b4059 <> b4059
    module.io.in_b9348 <> b9348
    module.io.in_b4060 <> b4060
    module.io.in_b9349 <> b9349
    x3943_reg.connectLedger(module.io.in_x3943_reg)
    x9389_reg.connectLedger(module.io.in_x9389_reg)
    x9350_out_SRAM_bias_0.connectLedger(module.io.in_x9350_out_SRAM_bias_0)
  }
  val b4060 = list_b4060(0)
  val b9349 = list_b4060(1)
  val b4059 = list_b4059(0)
  val b9348 = list_b4059(1)
  val x3943_reg = list_x3943_reg(0)
  val x9388_reg = list_x9388_reg(0)
  val x9389_reg = list_x9388_reg(1)
  val x9350_out_SRAM_bias_0 = list_x9388_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9398_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9398_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9398_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9390_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9390_sum""")
      x9390_sum.r := Math.add(b4059,b9348,Some(1.0), true.B, Truncate, Wrapping, "x9390_sum").r
      val x9391_rd_x3943 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9391_rd_x3943""")
      val x9391_rd_x3943_banks = List[UInt]()
      val x9391_rd_x3943_ofs = List[UInt]()
      val x9391_rd_x3943_en = List[Bool](true.B)
      x9391_rd_x3943.toSeq.zip(x3943_reg.connectRPort(9391, x9391_rd_x3943_banks, x9391_rd_x3943_ofs, io.sigsIn.backpressure, x9391_rd_x3943_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x20615 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20615_x9391_rd_x3943_D1") 
      x20615.r := getRetimed(x9391_rd_x3943.r, 1.toInt, io.sigsIn.backpressure)
      val x9392_x19 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9392_x19""")
      x9392_x19.r := (Math.mul(x9390_sum, x20615, Some(6.0), true.B, Truncate, Wrapping, "x9392_x19")).r
      val x9393_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9393_sum""")
      x9393_sum.r := Math.add(x9390_sum,1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x9393_sum").r
      val x20616 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20616_x9391_rd_x3943_D2") 
      x20616.r := getRetimed(x9391_rd_x3943.r, 2.toInt, io.sigsIn.backpressure)
      val x9394_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9394_mul""")
      x9394_mul.r := (Math.mul(x9393_sum, x20616, Some(6.0), true.B, Truncate, Wrapping, "x9394_mul")).r
      val x20617 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20617_x9392_x19_D1") 
      x20617.r := getRetimed(x9392_x19.r, 1.toInt, io.sigsIn.backpressure)
      val x9395_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9395_sub""")
      x9395_sub.r := Math.sub(x9394_mul,x20617,Some(1.0), true.B, Truncate, Wrapping, "x9395_sub").r
      val x9396_wr_x9388_banks = List[UInt]()
      val x9396_wr_x9388_ofs = List[UInt]()
      val x9396_wr_x9388_en = List[Bool](true.B)
      val x9396_wr_x9388_data = List[UInt](x9392_x19.r)
      x9388_reg.connectWPort(9396, x9396_wr_x9388_banks, x9396_wr_x9388_ofs, x9396_wr_x9388_data, x9396_wr_x9388_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x9397_wr_x9389_banks = List[UInt]()
      val x9397_wr_x9389_ofs = List[UInt]()
      val x9397_wr_x9389_en = List[Bool](true.B)
      val x9397_wr_x9389_data = List[UInt](x9395_sub.r)
      x9389_reg.connectWPort(9397, x9397_wr_x9389_banks, x9397_wr_x9389_ofs, x9397_wr_x9389_data, x9397_wr_x9389_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x9350_out_SRAM_bias_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x9388_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x9389_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x9398_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9398_inr_UnitPipe **/
