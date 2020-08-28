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

/** Hierarchy: x3880 -> x3896 -> x3897 -> x3898 -> x1256 **/
/** BEGIN None x3880_inr_UnitPipe **/
class x3880_inr_UnitPipe_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x3869: List[DecoupledIO[AppCommandDense]],
  list_x3864_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 2.2.toInt, myName = "x3880_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3880_inr_UnitPipe_iiCtr"))
  
  abstract class x3880_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3864_reg = Flipped(new NBufInterface(ModuleParams.getParams("x3864_reg_p").asInstanceOf[NBufParams] ))
      val in_x3869 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3869_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3864_reg = {io.in_x3864_reg} ; io.in_x3864_reg := DontCare
    def x3869 = {io.in_x3869} 
  }
  def connectWires0(module: x3880_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3864_reg.connectLedger(module.io.in_x3864_reg)
    module.io.in_x3869 <> x3869
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x3869 = list_x3869(0)
  val x3864_reg = list_x3864_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3880_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3880_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3880_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3872_rd_x3864 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3872_rd_x3864""")
      val x3872_rd_x3864_banks = List[UInt]()
      val x3872_rd_x3864_ofs = List[UInt]()
      val x3872_rd_x3864_en = List[Bool](true.B)
      x3872_rd_x3864.toSeq.zip(x3864_reg.connectRPort(3872, x3872_rd_x3864_banks, x3872_rd_x3864_ofs, io.sigsIn.backpressure, x3872_rd_x3864_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x3873 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3873""")
      val ensig0 = Wire(Bool())
      ensig0 := x3869.ready
      x3873.r := Math.arith_left_shift(x3872_rd_x3864, 2, Some(0.2), ensig0,"x3873").r
      val x3874 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x3874""")
      x3874.r := Math.fix2fix(x3873, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x3874").r
      val x3875 = x2682_tmp_DRAM
      val x3876_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x3876_sum""")
      x3876_sum.r := Math.add(x3874,x3875,Some(2.0), ensig0, Truncate, Wrapping, "x3876_sum").r
      val x3877_tuple = Wire(UInt(97.W)).suggestName("""x3877_tuple""")
      x3877_tuple.r := Cat(false.B,12544L.FP(true, 32, 0).r,x3876_sum.r)
      val x3878 = true.B
      val x19585 = Wire(Bool()).suggestName("x19585_x3878_D2") 
      x19585.r := getRetimed(x3878.r, 2.toInt, io.sigsIn.backpressure)
      x3869.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(2.2.toInt.toInt, rr, io.sigsIn.backpressure) & x19585 & io.sigsIn.backpressure
      x3869.bits.addr := x3877_tuple(63,0)
      x3869.bits.size := x3877_tuple(95,64)
    }
    val module = Module(new x3880_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3880_inr_UnitPipe **/
