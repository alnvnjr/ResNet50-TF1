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

/** Hierarchy: x9570 -> x9582 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9570_inr_UnitPipe **/
class x9570_inr_UnitPipe_kernel(
  list_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM: List[FixedPoint],
  list_x9560: List[DecoupledIO[AppCommandDense]],
  list_x9555_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 2.2.toInt, myName = "x9570_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9570_inr_UnitPipe_iiCtr"))
  
  abstract class x9570_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9555_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9555_reg_p").asInstanceOf[NBufParams] ))
      val in_x9560 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9560_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = {io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM} 
    def x9555_reg = {io.in_x9555_reg} ; io.in_x9555_reg := DontCare
    def x9560 = {io.in_x9560} 
  }
  def connectWires0(module: x9570_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM <> x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM
    x9555_reg.connectLedger(module.io.in_x9555_reg)
    module.io.in_x9560 <> x9560
  }
  val x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = list_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM(0)
  val x9560 = list_x9560(0)
  val x9555_reg = list_x9555_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9570_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9570_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9570_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9562_rd_x9555 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9562_rd_x9555""")
      val x9562_rd_x9555_banks = List[UInt]()
      val x9562_rd_x9555_ofs = List[UInt]()
      val x9562_rd_x9555_en = List[Bool](true.B)
      x9562_rd_x9555.toSeq.zip(x9555_reg.connectRPort(9562, x9562_rd_x9555_banks, x9562_rd_x9555_ofs, io.sigsIn.backpressure, x9562_rd_x9555_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9563 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9563""")
      val ensig0 = Wire(Bool())
      ensig0 := x9560.ready
      x9563.r := Math.arith_left_shift(x9562_rd_x9555, 2, Some(0.2), ensig0,"x9563").r
      val x9564 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x9564""")
      x9564.r := Math.fix2fix(x9563, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x9564").r
      val x9565 = x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM
      val x9566_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x9566_sum""")
      x9566_sum.r := Math.add(x9564,x9565,Some(2.0), ensig0, Truncate, Wrapping, "x9566_sum").r
      val x9567_tuple = Wire(UInt(97.W)).suggestName("""x9567_tuple""")
      x9567_tuple.r := Cat(true.B,128L.FP(true, 32, 0).r,x9566_sum.r)
      val x9568 = true.B
      val x20645 = Wire(Bool()).suggestName("x20645_x9568_D2") 
      x20645.r := getRetimed(x9568.r, 2.toInt, io.sigsIn.backpressure)
      x9560.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x20645 & io.sigsIn.backpressure
      x9560.bits.addr := x9567_tuple(63,0)
      x9560.bits.size := x9567_tuple(95,64)
    }
    val module = Module(new x9570_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9570_inr_UnitPipe **/
