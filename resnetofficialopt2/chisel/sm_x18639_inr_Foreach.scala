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

/** Hierarchy: x18639 -> x18644 -> x1256 **/
/** BEGIN None x18639_inr_Foreach **/
class x18639_inr_Foreach_kernel(
  list_x18498_tmp76_SRAM_0: List[StandardInterface],
  list_x18622: List[DecoupledIO[AppStoreData]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x18639_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18639_inr_Foreach_iiCtr"))
  
  abstract class x18639_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18498_tmp76_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18498_tmp76_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x18622 = Decoupled(new AppStoreData(ModuleParams.getParams("x18622_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18498_tmp76_SRAM_0 = {io.in_x18498_tmp76_SRAM_0} ; io.in_x18498_tmp76_SRAM_0 := DontCare
    def x18622 = {io.in_x18622} 
  }
  def connectWires0(module: x18639_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x18498_tmp76_SRAM_0.connectLedger(module.io.in_x18498_tmp76_SRAM_0)
    module.io.in_x18622 <> x18622
  }
  val x18498_tmp76_SRAM_0 = list_x18498_tmp76_SRAM_0(0)
  val x18622 = list_x18622(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18639_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x18639_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18639_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b18631 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b18631.suggestName("b18631")
      val b18632 = ~io.sigsIn.cchainOutputs.head.oobs(0); b18632.suggestName("b18632")
      val x18635_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x18635_rd""")
      val x18635_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x18635_rd_ofs = List[UInt](b18631.r)
      val x18635_rd_en = List[Bool](true.B)
      x18635_rd.toSeq.zip(x18498_tmp76_SRAM_0.connectRPort(18635, x18635_rd_banks, x18635_rd_ofs, io.sigsIn.backpressure, x18635_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && b18632), true)).foreach{case (a,b) => a := b}
      val x18636_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18636_elem_0""")
      x18636_elem_0.r := x18635_rd(0).r
      val x18637_tuple = Wire(UInt(33.W)).suggestName("""x18637_tuple""")
      x18637_tuple.r := Cat(true.B,x18636_elem_0.r)
      val x22023 = Wire(Bool()).suggestName("x22023_b18632_D2") 
      x22023.r := getRetimed(b18632.r, 2.toInt, io.sigsIn.backpressure)
      x18622.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt.toInt, rr, io.sigsIn.backpressure) & x22023 & io.sigsIn.backpressure
      x18622.bits.wdata(0) := x18637_tuple(31,0)
      x18622.bits.wstrb := x18637_tuple(32,32)
    }
    val module = Module(new x18639_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x18639_inr_Foreach **/
