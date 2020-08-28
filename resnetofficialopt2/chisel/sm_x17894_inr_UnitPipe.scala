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

/** Hierarchy: x17894 -> x18013 -> x18367 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17894_inr_UnitPipe **/
class x17894_inr_UnitPipe_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x17882: List[DecoupledIO[AppCommandDense]],
  list_x17718_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 8.2.toInt, myName = "x17894_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17894_inr_UnitPipe_iiCtr"))
  
  abstract class x17894_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x17882 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17882_p").asInstanceOf[(Int,Int)] ))
      val in_x17718_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17718_reg_p").asInstanceOf[MemParams] ))
      val in_b17746 = Input(new FixedPoint(true, 32, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x17882 = {io.in_x17882} 
    def x17718_reg = {io.in_x17718_reg} ; io.in_x17718_reg := DontCare
    def b17746 = {io.in_b17746} 
  }
  def connectWires0(module: x17894_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x17882 <> x17882
    x17718_reg.connectLedger(module.io.in_x17718_reg)
    module.io.in_b17746 <> b17746
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val b17746 = list_x2682_tmp_DRAM(1)
  val x17882 = list_x17882(0)
  val x17718_reg = list_x17718_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17894_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x17894_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17894_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x17884_rd_x17718 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17884_rd_x17718""")
      val x17884_rd_x17718_banks = List[UInt]()
      val x17884_rd_x17718_ofs = List[UInt]()
      val x17884_rd_x17718_en = List[Bool](true.B)
      x17884_rd_x17718.toSeq.zip(x17718_reg.connectRPort(17884, x17884_rd_x17718_banks, x17884_rd_x17718_ofs, io.sigsIn.backpressure, x17884_rd_x17718_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19364 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19364""")
      val ensig0 = Wire(Bool())
      ensig0 := x17882.ready
      x19364.r := Math.fma(x17884_rd_x17718,802816L.FP(true, 32, 0),b17746,Some(6.0), ensig0, "x19364").toFixed(x19364, "cast_x19364").r
      val x17887 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17887""")
      x17887.r := Math.arith_left_shift(x19364, 2, Some(0.2), ensig0,"x17887").r
      val x17888 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x17888""")
      x17888.r := Math.fix2fix(x17887, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x17888").r
      val x17889 = x2682_tmp_DRAM
      val x21895 = Wire(new FixedPoint(true, 64, 0)).suggestName("x21895_x17889_D6") 
      x21895.r := getRetimed(x17889.r, 6.toInt, io.sigsIn.backpressure)
      val x17890_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x17890_sum""")
      x17890_sum.r := Math.add(x17888,x21895,Some(2.0), ensig0, Truncate, Wrapping, "x17890_sum").r
      val x17891_tuple = Wire(UInt(97.W)).suggestName("""x17891_tuple""")
      x17891_tuple.r := Cat(true.B,12544L.FP(true, 32, 0).r,x17890_sum.r)
      val x17892 = true.B
      val x21896 = Wire(Bool()).suggestName("x21896_x17892_D8") 
      x21896.r := getRetimed(x17892.r, 8.toInt, io.sigsIn.backpressure)
      x17882.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(8.2.toInt.toInt, rr, io.sigsIn.backpressure) & x21896 & io.sigsIn.backpressure
      x17882.bits.addr := x17891_tuple(63,0)
      x17882.bits.size := x17891_tuple(95,64)
    }
    val module = Module(new x17894_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x17894_inr_UnitPipe **/
