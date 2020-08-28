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

/** Hierarchy: x9453 -> x9454 -> x9459 -> x9460 -> x9461 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9453_inr_Foreach **/
class x9453_inr_Foreach_kernel(
  list_x9350_out_SRAM_bias_0: List[NBufInterface],
  list_x9403_reg: List[StandardInterface],
  list_x9400: List[DecoupledIO[AppStoreData]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 3.0.toInt, myName = "x9453_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9453_inr_Foreach_iiCtr"))
  
  abstract class x9453_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9400 = Decoupled(new AppStoreData(ModuleParams.getParams("x9400_p").asInstanceOf[(Int,Int)] ))
      val in_x9403_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9403_reg_p").asInstanceOf[MemParams] ))
      val in_x9350_out_SRAM_bias_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9350_out_SRAM_bias_0_p").asInstanceOf[NBufParams] ))
      val in_x9402_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9402_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9400 = {io.in_x9400} 
    def x9403_reg = {io.in_x9403_reg} ; io.in_x9403_reg := DontCare
    def x9350_out_SRAM_bias_0 = {io.in_x9350_out_SRAM_bias_0} ; io.in_x9350_out_SRAM_bias_0 := DontCare
    def x9402_reg = {io.in_x9402_reg} ; io.in_x9402_reg := DontCare
  }
  def connectWires0(module: x9453_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x9400 <> x9400
    x9403_reg.connectLedger(module.io.in_x9403_reg)
    x9350_out_SRAM_bias_0.connectLedger(module.io.in_x9350_out_SRAM_bias_0)
    x9402_reg.connectLedger(module.io.in_x9402_reg)
  }
  val x9350_out_SRAM_bias_0 = list_x9350_out_SRAM_bias_0(0)
  val x9403_reg = list_x9403_reg(0)
  val x9402_reg = list_x9403_reg(1)
  val x9400 = list_x9400(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9453_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x9453_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9453_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b9439 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b9439.suggestName("b9439")
      val b9440 = ~io.sigsIn.cchainOutputs.head.oobs(0); b9440.suggestName("b9440")
      val x9441_rd_x9402 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9441_rd_x9402""")
      val x9441_rd_x9402_banks = List[UInt]()
      val x9441_rd_x9402_ofs = List[UInt]()
      val x9441_rd_x9402_en = List[Bool](true.B)
      x9441_rd_x9402.toSeq.zip(x9402_reg.connectRPort(9441, x9441_rd_x9402_banks, x9441_rd_x9402_ofs, io.sigsIn.backpressure, x9441_rd_x9402_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9442 = Wire(Bool()).suggestName("""x9442""")
      val ensig0 = Wire(Bool())
      ensig0 := x9400.ready
      x9442.r := Math.lte(x9441_rd_x9402, b9439, Some(0.4), ensig0,"x9442").r
      val x9443_rd_x9403 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9443_rd_x9403""")
      val x9443_rd_x9403_banks = List[UInt]()
      val x9443_rd_x9403_ofs = List[UInt]()
      val x9443_rd_x9403_en = List[Bool](true.B)
      x9443_rd_x9403.toSeq.zip(x9403_reg.connectRPort(9443, x9443_rd_x9403_banks, x9443_rd_x9403_ofs, io.sigsIn.backpressure, x9443_rd_x9403_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9444 = Wire(Bool()).suggestName("""x9444""")
      x9444.r := Math.lt(b9439, x9443_rd_x9403, Some(0.4), ensig0,"x9444").r
      val x9445 = Wire(Bool()).suggestName("""x9445""")
      x9445 := x9442 & x9444
      val x9446_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9446_sub""")
      x9446_sub.r := Math.sub(b9439,x9441_rd_x9402,Some(1.0), ensig0, Truncate, Wrapping, "x9446_sub").r
      val x20626 = Wire(Bool()).suggestName("x20626_x9445_D1") 
      x20626.r := getRetimed(x9445.r, 1.toInt, io.sigsIn.backpressure)
      val x20627 = Wire(Bool()).suggestName("x20627_b9440_D1") 
      x20627.r := getRetimed(b9440.r, 1.toInt, io.sigsIn.backpressure)
      val x9449_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x9449_rd""")
      val x9449_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x9449_rd_ofs = List[UInt](x9446_sub.r)
      val x9449_rd_en = List[Bool](true.B)
      x9449_rd.toSeq.zip(x9350_out_SRAM_bias_0.connectRPort(9449, x9449_rd_banks, x9449_rd_ofs, io.sigsIn.backpressure, x9449_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) && x20626 & x20627), true)).foreach{case (a,b) => a := b}
      val x9450_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9450_elem_0""")
      x9450_elem_0.r := x9449_rd(0).r
      val x20628 = Wire(Bool()).suggestName("x20628_x9445_D3") 
      x20628.r := getRetimed(x9445.r, 3.toInt, io.sigsIn.backpressure)
      val x9451_tuple = Wire(UInt(33.W)).suggestName("""x9451_tuple""")
      x9451_tuple.r := Cat(x20628,x9450_elem_0.r)
      val x20629 = Wire(Bool()).suggestName("x20629_b9440_D3") 
      x20629.r := getRetimed(b9440.r, 3.toInt, io.sigsIn.backpressure)
      x9400.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.0.toInt.toInt, rr, io.sigsIn.backpressure) & x20629 & io.sigsIn.backpressure
      x9400.bits.wdata(0) := x9451_tuple(31,0)
      x9400.bits.wstrb := x9451_tuple(32,32)
    }
    val module = Module(new x9453_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x9453_inr_Foreach **/
