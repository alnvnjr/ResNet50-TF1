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

/** Hierarchy: x17549 -> x17712 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17549_inr_UnitPipe **/
class x17549_inr_UnitPipe_kernel(
  list_b17303: List[Bool],
  list_b9552: List[FixedPoint],
  list_x9493_reg: List[StandardInterface],
  list_x17539_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 10.0.toInt, myName = "x17549_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17549_inr_UnitPipe_iiCtr"))
  
  abstract class x17549_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x17539_reg = Flipped(new NBufInterface(ModuleParams.getParams("x17539_reg_p").asInstanceOf[NBufParams] ))
      val in_b9552 = Input(new FixedPoint(true, 32, 0))
      val in_b17302 = Input(new FixedPoint(true, 32, 0))
      val in_b17303 = Input(Bool())
      val in_x9493_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9493_reg_p").asInstanceOf[MemParams] ))
      val in_b9553 = Input(Bool())
      val in_x17304_out_SRAM_bias_0 = Flipped(new NBufInterface(ModuleParams.getParams("x17304_out_SRAM_bias_0_p").asInstanceOf[NBufParams] ))
      val in_x17540_reg = Flipped(new NBufInterface(ModuleParams.getParams("x17540_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x17539_reg = {io.in_x17539_reg} ; io.in_x17539_reg := DontCare
    def b9552 = {io.in_b9552} 
    def b17302 = {io.in_b17302} 
    def b17303 = {io.in_b17303} 
    def x9493_reg = {io.in_x9493_reg} ; io.in_x9493_reg := DontCare
    def b9553 = {io.in_b9553} 
    def x17304_out_SRAM_bias_0 = {io.in_x17304_out_SRAM_bias_0} ; io.in_x17304_out_SRAM_bias_0 := DontCare
    def x17540_reg = {io.in_x17540_reg} ; io.in_x17540_reg := DontCare
  }
  def connectWires0(module: x17549_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x17539_reg.connectLedger(module.io.in_x17539_reg)
    module.io.in_b9552 <> b9552
    module.io.in_b17302 <> b17302
    module.io.in_b17303 <> b17303
    x9493_reg.connectLedger(module.io.in_x9493_reg)
    module.io.in_b9553 <> b9553
    x17304_out_SRAM_bias_0.connectLedger(module.io.in_x17304_out_SRAM_bias_0)
    x17540_reg.connectLedger(module.io.in_x17540_reg)
  }
  val b17303 = list_b17303(0)
  val b9553 = list_b17303(1)
  val b9552 = list_b9552(0)
  val b17302 = list_b9552(1)
  val x9493_reg = list_x9493_reg(0)
  val x17539_reg = list_x17539_reg(0)
  val x17304_out_SRAM_bias_0 = list_x17539_reg(1)
  val x17540_reg = list_x17539_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17549_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x17549_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17549_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x17541_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17541_sum""")
      x17541_sum.r := Math.add(b9552,b17302,Some(1.0), true.B, Truncate, Wrapping, "x17541_sum").r
      val x17542_rd_x9493 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17542_rd_x9493""")
      val x17542_rd_x9493_banks = List[UInt]()
      val x17542_rd_x9493_ofs = List[UInt]()
      val x17542_rd_x9493_en = List[Bool](true.B)
      x17542_rd_x9493.toSeq.zip(x9493_reg.connectRPort(17542, x17542_rd_x9493_banks, x17542_rd_x9493_ofs, io.sigsIn.backpressure, x17542_rd_x9493_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x21812 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21812_x17542_rd_x9493_D1") 
      x21812.r := getRetimed(x17542_rd_x9493.r, 1.toInt, io.sigsIn.backpressure)
      val x17543_x13 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17543_x13""")
      x17543_x13.r := (Math.mul(x17541_sum, x21812, Some(6.0), true.B, Truncate, Wrapping, "x17543_x13")).r
      val x17544_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17544_sum""")
      x17544_sum.r := Math.add(x17541_sum,1L.FP(true, 32, 0),Some(1.0), true.B, Truncate, Wrapping, "x17544_sum").r
      val x21813 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21813_x17542_rd_x9493_D2") 
      x21813.r := getRetimed(x17542_rd_x9493.r, 2.toInt, io.sigsIn.backpressure)
      val x17545_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17545_mul""")
      x17545_mul.r := (Math.mul(x17544_sum, x21813, Some(6.0), true.B, Truncate, Wrapping, "x17545_mul")).r
      val x21814 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21814_x17543_x13_D1") 
      x21814.r := getRetimed(x17543_x13.r, 1.toInt, io.sigsIn.backpressure)
      val x17546_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17546_sub""")
      x17546_sub.r := Math.sub(x17545_mul,x21814,Some(1.0), true.B, Truncate, Wrapping, "x17546_sub").r
      val x17547_wr_x17539_banks = List[UInt]()
      val x17547_wr_x17539_ofs = List[UInt]()
      val x17547_wr_x17539_en = List[Bool](true.B)
      val x17547_wr_x17539_data = List[UInt](x17543_x13.r)
      x17539_reg.connectWPort(17547, x17547_wr_x17539_banks, x17547_wr_x17539_ofs, x17547_wr_x17539_data, x17547_wr_x17539_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x17548_wr_x17540_banks = List[UInt]()
      val x17548_wr_x17540_ofs = List[UInt]()
      val x17548_wr_x17540_en = List[Bool](true.B)
      val x17548_wr_x17540_data = List[UInt](x17546_sub.r)
      x17540_reg.connectWPort(17548, x17548_wr_x17540_banks, x17548_wr_x17540_ofs, x17548_wr_x17540_data, x17548_wr_x17540_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x17304_out_SRAM_bias_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x17539_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x17540_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x17549_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x17549_inr_UnitPipe **/
