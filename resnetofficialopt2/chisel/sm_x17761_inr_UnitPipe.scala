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

/** Hierarchy: x17761 -> x17880 -> x18367 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17761_inr_UnitPipe **/
class x17761_inr_UnitPipe_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x17749: List[DecoupledIO[AppCommandDense]],
  list_x17717_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 8.2.toInt, myName = "x17761_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17761_inr_UnitPipe_iiCtr"))
  
  abstract class x17761_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x17749 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17749_p").asInstanceOf[(Int,Int)] ))
      val in_x17717_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17717_reg_p").asInstanceOf[MemParams] ))
      val in_b17746 = Input(new FixedPoint(true, 32, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x17749 = {io.in_x17749} 
    def x17717_reg = {io.in_x17717_reg} ; io.in_x17717_reg := DontCare
    def b17746 = {io.in_b17746} 
  }
  def connectWires0(module: x17761_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x17749 <> x17749
    x17717_reg.connectLedger(module.io.in_x17717_reg)
    module.io.in_b17746 <> b17746
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b17746 = list_x2682_tmp_DRAM(1)
  val x17749 = list_x17749(0)
  val x17717_reg = list_x17717_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17761_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x17761_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17761_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x17751_rd_x17717 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17751_rd_x17717""")
      val x17751_rd_x17717_banks = List[UInt]()
      val x17751_rd_x17717_ofs = List[UInt]()
      val x17751_rd_x17717_en = List[Bool](true.B)
      x17751_rd_x17717.toSeq.zip(x17717_reg.connectRPort(17751, x17751_rd_x17717_banks, x17751_rd_x17717_ofs, io.sigsIn.backpressure, x17751_rd_x17717_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19363 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19363""")
      val ensig0 = Wire(Bool())
      ensig0 := x17749.ready
      x19363.r := Math.fma(x17751_rd_x17717,802816L.FP(true, 32, 0),b17746,Some(6.0), ensig0, "x19363").toFixed(x19363, "cast_x19363").r
      val x17754 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17754""")
      x17754.r := Math.arith_left_shift(x19363, 2, Some(0.2), ensig0,"x17754").r
      val x17755 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x17755""")
      x17755.r := Math.fix2fix(x17754, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x17755").r
      val x17756 = x2682_tmp_DRAM
      val x21860 = Wire(new FixedPoint(true, 64, 0)).suggestName("x21860_x17756_D6") 
      x21860.r := getRetimed(x17756.r, 6.toInt, io.sigsIn.backpressure)
      val x17757_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x17757_sum""")
      x17757_sum.r := Math.add(x17755,x21860,Some(2.0), ensig0, Truncate, Wrapping, "x17757_sum").r
      val x17758_tuple = Wire(UInt(97.W)).suggestName("""x17758_tuple""")
      x17758_tuple.r := Cat(true.B,12544L.FP(true, 32, 0).r,x17757_sum.r)
      val x17759 = true.B
      val x21861 = Wire(Bool()).suggestName("x21861_x17759_D8") 
      x21861.r := getRetimed(x17759.r, 8.toInt, io.sigsIn.backpressure)
      x17749.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21861 & io.sigsIn.backpressure
      x17749.bits.addr := x17758_tuple(63,0)
      x17749.bits.size := x17758_tuple(95,64)
    }
    val module = Module(new x17761_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x17761_inr_UnitPipe **/
