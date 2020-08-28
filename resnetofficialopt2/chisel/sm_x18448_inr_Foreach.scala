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

/** Hierarchy: x18448 -> x18449 -> x18450 -> x18477 -> x1256 **/
/** BEGIN None x18448_inr_Foreach **/
class x18448_inr_Foreach_kernel(
  list_x18390: List[DecoupledIO[AppLoadData]],
  list_x18380_feature_map_0: List[NBufInterface],
  list_x18420_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x18448_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18448_inr_Foreach_iiCtr"))
  
  abstract class x18448_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18420_reg = Flipped(new StandardInterface(ModuleParams.getParams("x18420_reg_p").asInstanceOf[MemParams] ))
      val in_x18380_feature_map_0 = Flipped(new NBufInterface(ModuleParams.getParams("x18380_feature_map_0_p").asInstanceOf[NBufParams] ))
      val in_x18421_reg = Flipped(new StandardInterface(ModuleParams.getParams("x18421_reg_p").asInstanceOf[MemParams] ))
      val in_x18390 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18390_p").asInstanceOf[(Int, Int)] )))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18420_reg = {io.in_x18420_reg} ; io.in_x18420_reg := DontCare
    def x18380_feature_map_0 = {io.in_x18380_feature_map_0} ; io.in_x18380_feature_map_0 := DontCare
    def x18421_reg = {io.in_x18421_reg} ; io.in_x18421_reg := DontCare
    def x18390 = {io.in_x18390} 
  }
  def connectWires0(module: x18448_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x18420_reg.connectLedger(module.io.in_x18420_reg)
    x18380_feature_map_0.connectLedger(module.io.in_x18380_feature_map_0)
    x18421_reg.connectLedger(module.io.in_x18421_reg)
    module.io.in_x18390 <> x18390
  }
  val x18390 = list_x18390(0)
  val x18380_feature_map_0 = list_x18380_feature_map_0(0)
  val x18420_reg = list_x18420_reg(0)
  val x18421_reg = list_x18420_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18448_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x18448_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18448_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b18435 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b18435.suggestName("b18435")
      val b18436 = ~io.sigsIn.cchainOutputs.head.oobs(0); b18436.suggestName("b18436")
      val x18437_rd_x18420 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18437_rd_x18420""")
      val x18437_rd_x18420_banks = List[UInt]()
      val x18437_rd_x18420_ofs = List[UInt]()
      val x18437_rd_x18420_en = List[Bool](true.B)
      x18437_rd_x18420.toSeq.zip(x18420_reg.connectRPort(18437, x18437_rd_x18420_banks, x18437_rd_x18420_ofs, io.sigsIn.backpressure, x18437_rd_x18420_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18438 = Wire(Bool()).suggestName("""x18438""")
      x18438.r := Math.lte(x18437_rd_x18420, b18435, Some(0.4), true.B,"x18438").r
      val x18439_rd_x18421 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18439_rd_x18421""")
      val x18439_rd_x18421_banks = List[UInt]()
      val x18439_rd_x18421_ofs = List[UInt]()
      val x18439_rd_x18421_en = List[Bool](true.B)
      x18439_rd_x18421.toSeq.zip(x18421_reg.connectRPort(18439, x18439_rd_x18421_banks, x18439_rd_x18421_ofs, io.sigsIn.backpressure, x18439_rd_x18421_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18440 = Wire(Bool()).suggestName("""x18440""")
      x18440.r := Math.lt(b18435, x18439_rd_x18421, Some(0.4), true.B,"x18440").r
      val x18441 = Wire(Bool()).suggestName("""x18441""")
      x18441 := x18438 & x18440
      val x18442_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18442_sub""")
      x18442_sub.r := Math.sub(b18435,x18437_rd_x18420,Some(1.0), true.B, Truncate, Wrapping, "x18442_sub").r
      val x18443 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x18443""")
      x18390.ready := b18436 & (io.sigsIn.datapathEn) 
      (0 until 1).map{ i => x18443(i).r := x18390.bits.rdata(i).r }
      val x21992 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("x21992_x18443_D1") 
      (0 until 1).foreach{i => x21992(i).r := getRetimed(x18443(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x18444_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18444_elem_0""")
      x18444_elem_0.r := x21992(0).r
      val x21993 = Wire(Bool()).suggestName("x21993_x18441_D1") 
      x21993.r := getRetimed(x18441.r, 1.toInt, io.sigsIn.backpressure)
      val x21994 = Wire(Bool()).suggestName("x21994_b18436_D1") 
      x21994.r := getRetimed(b18436.r, 1.toInt, io.sigsIn.backpressure)
      val x18447_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x18447_wr_ofs = List[UInt](x18442_sub.r)
      val x18447_wr_en = List[Bool](true.B)
      val x18447_wr_data = List[UInt](x18444_elem_0.r)
      x18380_feature_map_0.connectWPort(18447, x18447_wr_banks, x18447_wr_ofs, x18447_wr_data, x18447_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x21993 & x21994))
    }
    val module = Module(new x18448_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x18448_inr_Foreach **/
