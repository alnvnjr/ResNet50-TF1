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

/** Hierarchy: x18469 -> x18477 -> x1256 **/
/** BEGIN None x18469_inr_Reduce **/
class x18469_inr_Reduce_kernel(
  list_b18379: List[Bool],
  list_x18451_sum_0: List[FixFMAAccumBundle],
  list_x18380_feature_map_0: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 12.807.toInt, myName = "x18469_inr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18469_inr_Reduce_iiCtr"))
  
  abstract class x18469_inr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18380_feature_map_0 = Flipped(new NBufInterface(ModuleParams.getParams("x18380_feature_map_0_p").asInstanceOf[NBufParams] ))
      val in_x18451_sum_0 = Flipped(new FixFMAAccumBundle(1, 10, 22))
      val in_b18379 = Input(Bool())
      val in_x18452_sum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x18452_sum_1_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18380_feature_map_0 = {io.in_x18380_feature_map_0} ; io.in_x18380_feature_map_0 := DontCare
    def x18451_sum_0 = {io.in_x18451_sum_0} ; io.in_x18451_sum_0 := DontCare
    def b18379 = {io.in_b18379} 
    def x18452_sum_1 = {io.in_x18452_sum_1} ; io.in_x18452_sum_1 := DontCare
  }
  def connectWires0(module: x18469_inr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x18380_feature_map_0.connectLedger(module.io.in_x18380_feature_map_0)
    x18451_sum_0.connectLedger(module.io.in_x18451_sum_0)
    module.io.in_b18379 <> b18379
    x18452_sum_1.connectLedger(module.io.in_x18452_sum_1)
  }
  val b18379 = list_b18379(0)
  val x18451_sum_0 = list_x18451_sum_0(0)
  val x18380_feature_map_0 = list_x18380_feature_map_0(0)
  val x18452_sum_1 = list_x18380_feature_map_0(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18469_inr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x18469_inr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18469_inr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b18455 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b18455.suggestName("b18455")
      val b18456 = ~io.sigsIn.cchainOutputs.head.oobs(0); b18456.suggestName("b18456")
      val x18459_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x18459_rd""")
      val x18459_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x18459_rd_ofs = List[UInt](b18455.r)
      val x18459_rd_en = List[Bool](true.B)
      x18459_rd.toSeq.zip(x18380_feature_map_0.connectRPort(18459, x18459_rd_banks, x18459_rd_ofs, io.sigsIn.backpressure, x18459_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && b18456 & b18379), true)).foreach{case (a,b) => a := b}
      val x18460_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18460_elem_0""")
      x18460_elem_0.r := x18459_rd(0).r
      val x18464 = Wire(Bool()).suggestName("""x18464""")
      x18464.r := Math.eql(b18455, 0L.FP(true, 32, 0), Some(0.2), true.B,"x18464").r
      val x21995 = Wire(Bool()).suggestName("x21995_x18464_D2") 
      x21995.r := getRetimed(x18464.r, 2.toInt, io.sigsIn.backpressure)
      x18451_sum_0.connectWPort(0, x18460_elem_0.r, 0.020408153533935546875.FP(true, 10, 22).r, true.B && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt, rr, io.sigsIn.backpressure), (io.sigsIn.ctrDone).DS(2.0.toInt, rr, io.sigsIn.backpressure), x21995)
      val x19374 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19374""")
      x19374.r := x18451_sum_0.output
      val x18468_wr_x18452_banks = List[UInt]()
      val x18468_wr_x18452_ofs = List[UInt]()
      val x18468_wr_x18452_en = List[Bool](true.B)
      val x18468_wr_x18452_data = List[UInt](x19374.r)
      x18452_sum_1.connectWPort(18468, x18468_wr_x18452_banks, x18468_wr_x18452_ofs, x18468_wr_x18452_data, x18468_wr_x18452_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(11.807.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x18380_feature_map_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x18452_sum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x18469_inr_Reduce_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledReduce x18469_inr_Reduce **/
