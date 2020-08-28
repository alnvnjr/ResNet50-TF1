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

/** Hierarchy: x4022 -> x4054 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4022_inr_UnitPipe **/
class x4022_inr_UnitPipe_kernel(
  list_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM: List[FixedPoint],
  list_x3994_fifo: List[FIFOInterface],
  list_x3993: List[DecoupledIO[AppCommandDense]],
  list_x3944_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 5.1.toInt, myName = "x4022_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4022_inr_UnitPipe_iiCtr"))
  
  abstract class x4022_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3944_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3944_reg_p").asInstanceOf[MemParams] ))
      val in_x3994_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x3994_fifo_p").asInstanceOf[MemParams] ))
      val in_x3934_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3934_reg_p").asInstanceOf[MemParams] ))
      val in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3993 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3993_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3944_reg = {io.in_x3944_reg} ; io.in_x3944_reg := DontCare
    def x3994_fifo = {io.in_x3994_fifo} ; io.in_x3994_fifo := DontCare
    def x3934_reg = {io.in_x3934_reg} ; io.in_x3934_reg := DontCare
    def x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = {io.in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM} 
    def x3993 = {io.in_x3993} 
  }
  def connectWires0(module: x4022_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3944_reg.connectLedger(module.io.in_x3944_reg)
    x3994_fifo.connectLedger(module.io.in_x3994_fifo)
    x3934_reg.connectLedger(module.io.in_x3934_reg)
    module.io.in_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM <> x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM
    module.io.in_x3993 <> x3993
  }
  val x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = list_x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM(0)
  val x3994_fifo = list_x3994_fifo(0)
  val x3993 = list_x3993(0)
  val x3944_reg = list_x3944_reg(0)
  val x3934_reg = list_x3944_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4022_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4022_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4022_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3996_rd_x3934 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3996_rd_x3934""")
      val x3996_rd_x3934_banks = List[UInt]()
      val x3996_rd_x3934_ofs = List[UInt]()
      val x3996_rd_x3934_en = List[Bool](true.B)
      x3996_rd_x3934.toSeq.zip(x3934_reg.connectRPort(3996, x3996_rd_x3934_banks, x3996_rd_x3934_ofs, io.sigsIn.backpressure, x3996_rd_x3934_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x3997 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3997""")
      val ensig0 = Wire(Bool())
      ensig0 := x3993.ready & (~x3994_fifo.full | ~(x3994_fifo.accessActivesOut(0)))
      x3997.r := Math.arith_left_shift(x3996_rd_x3934, 2, Some(0.2), ensig0,"x3997").r
      val x18850 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18850""")
      x18850.r := Math.and(x3997,63L.FP(true, 32, 0),Some(0.2), ensig0,"x18850").r
      val x3999_rd_x3944 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3999_rd_x3944""")
      val x3999_rd_x3944_banks = List[UInt]()
      val x3999_rd_x3944_ofs = List[UInt]()
      val x3999_rd_x3944_en = List[Bool](true.B)
      x3999_rd_x3944.toSeq.zip(x3944_reg.connectRPort(3999, x3999_rd_x3944_banks, x3999_rd_x3944_ofs, io.sigsIn.backpressure, x3999_rd_x3944_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4000 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4000""")
      x4000.r := Math.arith_left_shift(x3999_rd_x3944, 2, Some(0.2), ensig0,"x4000").r
      val x4001_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4001_sub""")
      x4001_sub.r := Math.sub(x3997,x18850,Some(1.0), ensig0, Truncate, Wrapping, "x4001_sub").r
      val x4002_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4002_sum""")
      x4002_sum.r := Math.add(x3997,x4000,Some(1.0), ensig0, Truncate, Wrapping, "x4002_sum").r
      val x18851 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18851""")
      x18851.r := Math.and(x4002_sum,63L.FP(true, 32, 0),Some(0.2), ensig0,"x18851").r
      val x4004 = Wire(Bool()).suggestName("""x4004""")
      x4004.r := Math.eql(x18851, 0L.FP(true, 32, 0), Some(0.2), ensig0,"x4004").r
      val x4005_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4005_sub""")
      x4005_sub.r := Math.sub(64L.FP(true, 32, 0),x18851,Some(1.0), ensig0, Truncate, Wrapping, "x4005_sub").r
      val x19601 = Wire(Bool()).suggestName("x19601_x4004_D1") 
      x19601.r := getRetimed(x4004.r, 1.toInt, io.sigsIn.backpressure)
      val x4006 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4006""")
      x4006.r := Mux((x19601), 0L.FP(true, 32, 0).r, x4005_sub.r)
      val x4007 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4007""")
      x4007.r := Math.arith_right_shift(x18850, 2, Some(0.2), ensig0,"x4007").r
      val x4008 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4008""")
      x4008.r := Math.arith_right_shift(x4006, 2, Some(0.2 + 1.0), ensig0,"x4008").r
      val x4009_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4009_sum""")
      x4009_sum.r := Math.add(x4007,x3999_rd_x3944,Some(1.0), ensig0, Truncate, Wrapping, "x4009_sum").r
      val x4010_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4010_sum""")
      x4010_sum.r := Math.add(x3999_rd_x3944,x4007,Some(1.0), ensig0, Truncate, Wrapping, "x4010_sum").r
      val x19602 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19602_x4010_sum_D2") 
      x19602.r := getRetimed(x4010_sum.r, 2.toInt, io.sigsIn.backpressure)
      val x19603 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19603_x4008_D1") 
      x19603.r := getRetimed(x4008.r, 1.toInt, io.sigsIn.backpressure)
      val x4011_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4011_sum""")
      x4011_sum.r := Math.add(x19602,x19603,Some(1.0), ensig0, Truncate, Wrapping, "x4011_sum").r
      val x4012_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4012_sum""")
      x4012_sum.r := Math.add(x4000,x18850,Some(1.0), ensig0, Truncate, Wrapping, "x4012_sum").r
      val x19604 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19604_x4012_sum_D1") 
      x19604.r := getRetimed(x4012_sum.r, 1.toInt, io.sigsIn.backpressure)
      val x4013_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4013_sum""")
      x4013_sum.r := Math.add(x19604,x4006,Some(1.0), ensig0, Truncate, Wrapping, "x4013_sum").r
      val x4014 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x4014""")
      x4014.r := Math.fix2fix(x4001_sub, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x4014").r
      val x4015 = x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM
      val x19605 = Wire(new FixedPoint(true, 64, 0)).suggestName("x19605_x4015_D1") 
      x19605.r := getRetimed(x4015.r, 1.toInt, io.sigsIn.backpressure)
      val x4016_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x4016_sum""")
      x4016_sum.r := Math.add(x4014,x19605,Some(2.0), ensig0, Truncate, Wrapping, "x4016_sum").r
      val x4017_tuple = Wire(UInt(97.W)).suggestName("""x4017_tuple""")
      x4017_tuple.r := Cat(true.B,x4013_sum.r,x4016_sum.r)
      val x4018 = true.B
      val x19606 = Wire(Bool()).suggestName("x19606_x4018_D3") 
      x19606.r := getRetimed(x4018.r, 3.toInt, io.sigsIn.backpressure)
      x3993.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(3.9.toInt.toInt, rr, io.sigsIn.backpressure) & x19606 & io.sigsIn.backpressure
      x3993.bits.addr := x4017_tuple(63,0)
      x3993.bits.size := x4017_tuple(95,64)
      val x19607 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19607_x4007_D4") 
      x19607.r := getRetimed(x4007.r, 4.toInt, io.sigsIn.backpressure)
      val x19608 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19608_x4009_sum_D3") 
      x19608.r := getRetimed(x4009_sum.r, 3.toInt, io.sigsIn.backpressure)
      val x4020_tuple = Wire(UInt(96.W)).suggestName("""x4020_tuple""")
      x4020_tuple.r := Cat(x19608.r,x19607.r,x4011_sum.r)
      val x4021_enq_x3994_banks = List[UInt]()
      val x4021_enq_x3994_ofs = List[UInt]()
      val x4021_enq_x3994_en = List[Bool](true.B)
      val x4021_enq_x3994_data = List[UInt](x4020_tuple.r)
      x3994_fifo.connectWPort(4021, x4021_enq_x3994_banks, x4021_enq_x3994_ofs, x4021_enq_x3994_data, x4021_enq_x3994_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(4.1.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x3994_fifo.connectAccessActivesIn(0, ((true.B)))
    }
    val module = Module(new x4022_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4022_inr_UnitPipe **/
