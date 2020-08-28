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

/** Hierarchy: x18619 -> x18620 -> x1256 **/
/** BEGIN None x18619_inr_UnitPipe **/
class x18619_inr_UnitPipe_kernel(
  list_b18502: List[Bool],
  list_b18501: List[FixedPoint],
  list_x18551_prod_1: List[NBufInterface],
  list_x18498_tmp76_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 4.0.toInt, myName = "x18619_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18619_inr_UnitPipe_iiCtr"))
  
  abstract class x18619_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18498_tmp76_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18498_tmp76_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x18551_prod_1 = Flipped(new NBufInterface(ModuleParams.getParams("x18551_prod_1_p").asInstanceOf[NBufParams] ))
      val in_b18502 = Input(Bool())
      val in_x18478_c87_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18478_c87_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_b18501 = Input(new FixedPoint(true, 32, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18498_tmp76_SRAM_0 = {io.in_x18498_tmp76_SRAM_0} ; io.in_x18498_tmp76_SRAM_0 := DontCare
    def x18551_prod_1 = {io.in_x18551_prod_1} ; io.in_x18551_prod_1 := DontCare
    def b18502 = {io.in_b18502} 
    def x18478_c87_SRAM_0 = {io.in_x18478_c87_SRAM_0} ; io.in_x18478_c87_SRAM_0 := DontCare
    def b18501 = {io.in_b18501} 
  }
  def connectWires0(module: x18619_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x18498_tmp76_SRAM_0.connectLedger(module.io.in_x18498_tmp76_SRAM_0)
    x18551_prod_1.connectLedger(module.io.in_x18551_prod_1)
    module.io.in_b18502 <> b18502
    x18478_c87_SRAM_0.connectLedger(module.io.in_x18478_c87_SRAM_0)
    module.io.in_b18501 <> b18501
  }
  val b18502 = list_b18502(0)
  val b18501 = list_b18501(0)
  val x18551_prod_1 = list_x18551_prod_1(0)
  val x18498_tmp76_SRAM_0 = list_x18498_tmp76_SRAM_0(0)
  val x18478_c87_SRAM_0 = list_x18498_tmp76_SRAM_0(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18619_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18619_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18619_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18614_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x18614_rd""")
      val x18614_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x18614_rd_ofs = List[UInt](b18501.r)
      val x18614_rd_en = List[Bool](true.B)
      x18614_rd.toSeq.zip(x18478_c87_SRAM_0.connectRPort(18614, x18614_rd_banks, x18614_rd_ofs, io.sigsIn.backpressure, x18614_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18615_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18615_elem_0""")
      x18615_elem_0.r := x18614_rd(0).r
      val x18616_rd_x18551 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18616_rd_x18551""")
      val x18616_rd_x18551_banks = List[UInt]()
      val x18616_rd_x18551_ofs = List[UInt]()
      val x18616_rd_x18551_en = List[Bool](true.B)
      x18616_rd_x18551.toSeq.zip(x18551_prod_1.connectRPort(18616, x18616_rd_x18551_banks, x18616_rd_x18551_ofs, io.sigsIn.backpressure, x18616_rd_x18551_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x22021 = Wire(new FixedPoint(true, 10, 22)).suggestName("x22021_x18616_rd_x18551_D2") 
      x22021.r := getRetimed(x18616_rd_x18551.r, 2.toInt, io.sigsIn.backpressure)
      val x18617_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18617_sum""")
      x18617_sum.r := Math.add(x22021,x18615_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x18617_sum").r
      val x22022 = Wire(new FixedPoint(true, 32, 0)).suggestName("x22022_b18501_D3") 
      x22022.r := getRetimed(b18501.r, 3.toInt, io.sigsIn.backpressure)
      val x18618_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x18618_wr_ofs = List[UInt](x22022.r)
      val x18618_wr_en = List[Bool](true.B)
      val x18618_wr_data = List[UInt](x18617_sum.r)
      x18498_tmp76_SRAM_0.connectWPort(18618, x18618_wr_banks, x18618_wr_ofs, x18618_wr_data, x18618_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x18551_prod_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x18619_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18619_inr_UnitPipe **/
