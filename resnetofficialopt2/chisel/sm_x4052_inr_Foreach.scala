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

/** Hierarchy: x4052 -> x4053 -> x4054 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4052_inr_Foreach **/
class x4052_inr_Foreach_kernel(
  list_x3995: List[DecoupledIO[AppLoadData]],
  list_x4025_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x4052_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4052_inr_Foreach_iiCtr"))
  
  abstract class x4052_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3995 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3995_p").asInstanceOf[(Int, Int)] )))
      val in_x4025_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4025_reg_p").asInstanceOf[MemParams] ))
      val in_x3992_bias_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3992_bias_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x4024_reg = Flipped(new StandardInterface(ModuleParams.getParams("x4024_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3995 = {io.in_x3995} 
    def x4025_reg = {io.in_x4025_reg} ; io.in_x4025_reg := DontCare
    def x3992_bias_SRAM_0 = {io.in_x3992_bias_SRAM_0} ; io.in_x3992_bias_SRAM_0 := DontCare
    def x4024_reg = {io.in_x4024_reg} ; io.in_x4024_reg := DontCare
  }
  def connectWires0(module: x4052_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x3995 <> x3995
    x4025_reg.connectLedger(module.io.in_x4025_reg)
    x3992_bias_SRAM_0.connectLedger(module.io.in_x3992_bias_SRAM_0)
    x4024_reg.connectLedger(module.io.in_x4024_reg)
  }
  val x3995 = list_x3995(0)
  val x4025_reg = list_x4025_reg(0)
  val x3992_bias_SRAM_0 = list_x4025_reg(1)
  val x4024_reg = list_x4025_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4052_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x4052_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4052_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b4039 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b4039.suggestName("b4039")
      val b4040 = ~io.sigsIn.cchainOutputs.head.oobs(0); b4040.suggestName("b4040")
      val x4041_rd_x4024 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4041_rd_x4024""")
      val x4041_rd_x4024_banks = List[UInt]()
      val x4041_rd_x4024_ofs = List[UInt]()
      val x4041_rd_x4024_en = List[Bool](true.B)
      x4041_rd_x4024.toSeq.zip(x4024_reg.connectRPort(4041, x4041_rd_x4024_banks, x4041_rd_x4024_ofs, io.sigsIn.backpressure, x4041_rd_x4024_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4042 = Wire(Bool()).suggestName("""x4042""")
      x4042.r := Math.lte(x4041_rd_x4024, b4039, Some(0.4), true.B,"x4042").r
      val x4043_rd_x4025 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4043_rd_x4025""")
      val x4043_rd_x4025_banks = List[UInt]()
      val x4043_rd_x4025_ofs = List[UInt]()
      val x4043_rd_x4025_en = List[Bool](true.B)
      x4043_rd_x4025.toSeq.zip(x4025_reg.connectRPort(4043, x4043_rd_x4025_banks, x4043_rd_x4025_ofs, io.sigsIn.backpressure, x4043_rd_x4025_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4044 = Wire(Bool()).suggestName("""x4044""")
      x4044.r := Math.lt(b4039, x4043_rd_x4025, Some(0.4), true.B,"x4044").r
      val x4045 = Wire(Bool()).suggestName("""x4045""")
      x4045 := x4042 & x4044
      val x4046_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4046_sub""")
      x4046_sub.r := Math.sub(b4039,x4041_rd_x4024,Some(1.0), true.B, Truncate, Wrapping, "x4046_sub").r
      val x4047 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x4047""")
      x3995.ready := b4040 & (io.sigsIn.datapathEn) 
      (0 until 1).map{ i => x4047(i).r := x3995.bits.rdata(i).r }
      val x19610 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("x19610_x4047_D1") 
      (0 until 1).foreach{i => x19610(i).r := getRetimed(x4047(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x4048_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x4048_elem_0""")
      x4048_elem_0.r := x19610(0).r
      val x19611 = Wire(Bool()).suggestName("x19611_x4045_D1") 
      x19611.r := getRetimed(x4045.r, 1.toInt, io.sigsIn.backpressure)
      val x19612 = Wire(Bool()).suggestName("x19612_b4040_D1") 
      x19612.r := getRetimed(b4040.r, 1.toInt, io.sigsIn.backpressure)
      val x4051_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x4051_wr_ofs = List[UInt](x4046_sub.r)
      val x4051_wr_en = List[Bool](true.B)
      val x4051_wr_data = List[UInt](x4048_elem_0.r)
      x3992_bias_SRAM_0.connectWPort(4051, x4051_wr_banks, x4051_wr_ofs, x4051_wr_data, x4051_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19611 & x19612))
    }
    val module = Module(new x4052_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x4052_inr_Foreach **/
