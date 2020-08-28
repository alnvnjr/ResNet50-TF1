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

/** Hierarchy: x18228 -> x18366 -> x18367 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x18228_inr_UnitPipe **/
class x18228_inr_UnitPipe_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x18215: List[DecoupledIO[AppCommandDense]],
  list_x17719_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 8.2.toInt, myName = "x18228_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18228_inr_UnitPipe_iiCtr"))
  
  abstract class x18228_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x18215 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18215_p").asInstanceOf[(Int,Int)] ))
      val in_x17719_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17719_reg_p").asInstanceOf[MemParams] ))
      val in_b17746 = Input(new FixedPoint(true, 32, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x18215 = {io.in_x18215} 
    def x17719_reg = {io.in_x17719_reg} ; io.in_x17719_reg := DontCare
    def b17746 = {io.in_b17746} 
  }
  def connectWires0(module: x18228_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x18215 <> x18215
    x17719_reg.connectLedger(module.io.in_x17719_reg)
    module.io.in_b17746 <> b17746
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b17746 = list_x2682_tmp_DRAM(1)
  val x18215 = list_x18215(0)
  val x17719_reg = list_x17719_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18228_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18228_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18228_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18218_rd_x17719 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18218_rd_x17719""")
      val x18218_rd_x17719_banks = List[UInt]()
      val x18218_rd_x17719_ofs = List[UInt]()
      val x18218_rd_x17719_en = List[Bool](true.B)
      x18218_rd_x17719.toSeq.zip(x17719_reg.connectRPort(18218, x18218_rd_x17719_banks, x18218_rd_x17719_ofs, io.sigsIn.backpressure, x18218_rd_x17719_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19365 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19365""")
      val ensig0 = Wire(Bool())
      ensig0 := x18215.ready
      x19365.r := Math.fma(x18218_rd_x17719,802816L.FP(true, 32, 0),b17746,Some(6.0), ensig0, "x19365").toFixed(x19365, "cast_x19365").r
      val x18221 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18221""")
      x18221.r := Math.arith_left_shift(x19365, 2, Some(0.2), ensig0,"x18221").r
      val x18222 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x18222""")
      x18222.r := Math.fix2fix(x18221, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x18222").r
      val x18223 = x2682_tmp_DRAM
      val x21965 = Wire(new FixedPoint(true, 64, 0)).suggestName("x21965_x18223_D6") 
      x21965.r := getRetimed(x18223.r, 6.toInt, io.sigsIn.backpressure)
      val x18224_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x18224_sum""")
      x18224_sum.r := Math.add(x18222,x21965,Some(2.0), ensig0, Truncate, Wrapping, "x18224_sum").r
      val x18225_tuple = Wire(UInt(97.W)).suggestName("""x18225_tuple""")
      x18225_tuple.r := Cat(false.B,12544L.FP(true, 32, 0).r,x18224_sum.r)
      val x18226 = true.B
      val x21966 = Wire(Bool()).suggestName("x21966_x18226_D8") 
      x21966.r := getRetimed(x18226.r, 8.toInt, io.sigsIn.backpressure)
      x18215.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21966 & io.sigsIn.backpressure
      x18215.bits.addr := x18225_tuple(63,0)
      x18215.bits.size := x18225_tuple(95,64)
    }
    val module = Module(new x18228_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18228_inr_UnitPipe **/
