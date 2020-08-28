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

/** Hierarchy: x9880 -> x10006 -> x17297 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9880_inr_UnitPipe **/
class x9880_inr_UnitPipe_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x9867: List[DecoupledIO[AppCommandDense]],
  list_x9862_reg: List[NBufInterface],
  list_x9488_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 8.2.toInt, myName = "x9880_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9880_inr_UnitPipe_iiCtr"))
  
  abstract class x9880_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9488_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9488_reg_p").asInstanceOf[MemParams] ))
      val in_x9867 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9867_p").asInstanceOf[(Int,Int)] ))
      val in_x9862_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9862_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x9488_reg = {io.in_x9488_reg} ; io.in_x9488_reg := DontCare
    def x9867 = {io.in_x9867} 
    def x9862_reg = {io.in_x9862_reg} ; io.in_x9862_reg := DontCare
  }
  def connectWires0(module: x9880_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x9488_reg.connectLedger(module.io.in_x9488_reg)
    module.io.in_x9867 <> x9867
    x9862_reg.connectLedger(module.io.in_x9862_reg)
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x9867 = list_x9867(0)
  val x9862_reg = list_x9862_reg(0)
  val x9488_reg = list_x9488_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9880_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9880_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9880_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9869_rd_x9488 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9869_rd_x9488""")
      val x9869_rd_x9488_banks = List[UInt]()
      val x9869_rd_x9488_ofs = List[UInt]()
      val x9869_rd_x9488_en = List[Bool](true.B)
      x9869_rd_x9488.toSeq.zip(x9488_reg.connectRPort(9869, x9869_rd_x9488_banks, x9869_rd_x9488_ofs, io.sigsIn.backpressure, x9869_rd_x9488_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9871_rd_x9862 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9871_rd_x9862""")
      val x9871_rd_x9862_banks = List[UInt]()
      val x9871_rd_x9862_ofs = List[UInt]()
      val x9871_rd_x9862_en = List[Bool](true.B)
      x9871_rd_x9862.toSeq.zip(x9862_reg.connectRPort(9871, x9871_rd_x9862_banks, x9871_rd_x9862_ofs, io.sigsIn.backpressure, x9871_rd_x9862_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19077 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19077""")
      val ensig0 = Wire(Bool())
      ensig0 := x9867.ready
      x19077.r := Math.fma(x9869_rd_x9488,802816L.FP(true, 32, 0),x9871_rd_x9862,Some(6.0), ensig0, "x19077").toFixed(x19077, "cast_x19077").r
      val x9873 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9873""")
      x9873.r := Math.arith_left_shift(x19077, 2, Some(0.2), ensig0,"x9873").r
      val x9874 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x9874""")
      x9874.r := Math.fix2fix(x9873, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x9874").r
      val x9875 = x2682_tmp_DRAM
      val x20711 = Wire(new FixedPoint(true, 64, 0)).suggestName("x20711_x9875_D6") 
      x20711.r := getRetimed(x9875.r, 6.toInt, io.sigsIn.backpressure)
      val x9876_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x9876_sum""")
      x9876_sum.r := Math.add(x9874,x20711,Some(2.0), ensig0, Truncate, Wrapping, "x9876_sum").r
      val x9877_tuple = Wire(UInt(97.W)).suggestName("""x9877_tuple""")
      x9877_tuple.r := Cat(true.B,12544L.FP(true, 32, 0).r,x9876_sum.r)
      val x9878 = true.B
      val x20712 = Wire(Bool()).suggestName("x20712_x9878_D8") 
      x20712.r := getRetimed(x9878.r, 8.toInt, io.sigsIn.backpressure)
      x9867.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.2.toInt.toInt, rr, io.sigsIn.backpressure) & x20712 & io.sigsIn.backpressure
      x9867.bits.addr := x9877_tuple(63,0)
      x9867.bits.size := x9877_tuple(95,64)
    }
    val module = Module(new x9880_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9880_inr_UnitPipe **/
