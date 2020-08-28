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

/** Hierarchy: x3891 -> x3896 -> x3897 -> x3898 -> x1256 **/
/** BEGIN None x3891_inr_Foreach **/
class x3891_inr_Foreach_kernel(
  list_x3705_tmp0_SRAM_pool_0: List[NBufInterface],
  list_x3870: List[DecoupledIO[AppStoreData]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 2.0.toInt, myName = "x3891_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3891_inr_Foreach_iiCtr"))
  
  abstract class x3891_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3870 = Decoupled(new AppStoreData(ModuleParams.getParams("x3870_p").asInstanceOf[(Int,Int)] ))
      val in_x3705_tmp0_SRAM_pool_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3705_tmp0_SRAM_pool_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3870 = {io.in_x3870} 
    def x3705_tmp0_SRAM_pool_0 = {io.in_x3705_tmp0_SRAM_pool_0} ; io.in_x3705_tmp0_SRAM_pool_0 := DontCare
  }
  def connectWires0(module: x3891_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x3870 <> x3870
    x3705_tmp0_SRAM_pool_0.connectLedger(module.io.in_x3705_tmp0_SRAM_pool_0)
  }
  val x3705_tmp0_SRAM_pool_0 = list_x3705_tmp0_SRAM_pool_0(0)
  val x3870 = list_x3870(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3891_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3891_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3891_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3883 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b3883.suggestName("b3883")
      val b3884 = ~io.sigsIn.cchainOutputs.head.oobs(0); b3884.suggestName("b3884")
      val x3887_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3887_rd""")
      val x3887_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x3887_rd_ofs = List[UInt](b3883.r)
      val x3887_rd_en = List[Bool](true.B)
      x3887_rd.toSeq.zip(x3705_tmp0_SRAM_pool_0.connectRPort(3887, x3887_rd_banks, x3887_rd_ofs, io.sigsIn.backpressure, x3887_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && b3884), true)).foreach{case (a,b) => a := b}
      val x3888_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3888_elem_0""")
      x3888_elem_0.r := x3887_rd(0).r
      val x3889_tuple = Wire(UInt(33.W)).suggestName("""x3889_tuple""")
      x3889_tuple.r := Cat(true.B,x3888_elem_0.r)
      val x19586 = Wire(Bool()).suggestName("x19586_b3884_D2") 
      x19586.r := getRetimed(b3884.r, 2.toInt, io.sigsIn.backpressure)
      x3870.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.0.toInt.toInt, rr, io.sigsIn.backpressure) & x19586 & io.sigsIn.backpressure
      x3870.bits.wdata(0) := x3889_tuple(31,0)
      x3870.bits.wstrb := x3889_tuple(32,32)
    }
    val module = Module(new x3891_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3891_inr_Foreach **/
