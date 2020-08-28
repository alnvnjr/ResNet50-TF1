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

/** Hierarchy: x3170 -> x3211 -> x3898 -> x1256 **/
/** BEGIN None x3170_inr_UnitPipe **/
class x3170_inr_UnitPipe_kernel(
  list_b3121: List[Bool],
  list_b3120: List[FixedPoint],
  list_x3141_fifo: List[FIFOInterface],
  list_x3140: List[DecoupledIO[AppCommandDense]],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 17.1.toInt, myName = "x3170_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3170_inr_UnitPipe_iiCtr"))
  
  abstract class x3170_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b3120 = Input(new FixedPoint(true, 32, 0))
      val in_b3121 = Input(Bool())
      val in_x3140 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3140_p").asInstanceOf[(Int,Int)] ))
      val in_b3137 = Input(new FixedPoint(true, 32, 0))
      val in_x3141_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x3141_fifo_p").asInstanceOf[MemParams] ))
      val in_b3138 = Input(Bool())
      val in_x3066_c101_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_b3139 = Input(Bool())
      val in_b3136 = Input(new FixedPoint(true, 32, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b3120 = {io.in_b3120} 
    def b3121 = {io.in_b3121} 
    def x3140 = {io.in_x3140} 
    def b3137 = {io.in_b3137} 
    def x3141_fifo = {io.in_x3141_fifo} ; io.in_x3141_fifo := DontCare
    def b3138 = {io.in_b3138} 
    def x3066_c101_DRAM = {io.in_x3066_c101_DRAM} 
    def b3139 = {io.in_b3139} 
    def b3136 = {io.in_b3136} 
  }
  def connectWires0(module: x3170_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b3120 <> b3120
    module.io.in_b3121 <> b3121
    module.io.in_x3140 <> x3140
    module.io.in_b3137 <> b3137
    x3141_fifo.connectLedger(module.io.in_x3141_fifo)
    module.io.in_b3138 <> b3138
    module.io.in_x3066_c101_DRAM <> x3066_c101_DRAM
    module.io.in_b3139 <> b3139
    module.io.in_b3136 <> b3136
  }
  val b3121 = list_b3121(0)
  val b3138 = list_b3121(1)
  val b3139 = list_b3121(2)
  val b3120 = list_b3120(0)
  val b3137 = list_b3120(1)
  val x3066_c101_DRAM = list_b3120(2)
  val b3136 = list_b3120(3)
  val x3141_fifo = list_x3141_fifo(0)
  val x3140 = list_x3140(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3170_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3170_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3170_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3143_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3143_sum""")
      val ensig0 = Wire(Bool())
      ensig0 := x3140.ready & (~x3141_fifo.full | ~(x3141_fifo.accessActivesOut(0)))
      x3143_sum.r := Math.add(b3120,b3136,Some(1.0), ensig0, Truncate, Wrapping, "x3143_sum").r
      val x3145_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3145_mul""")
      x3145_mul.r := (Math.mul(b3137, 49L.FP(true, 32, 0), Some(6.0), ensig0, Truncate, Wrapping, "x3145_mul")).r
      val x19379 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19379_x3143_sum_D5") 
      x19379.r := getRetimed(x3143_sum.r, 5.toInt, io.sigsIn.backpressure)
      val x18815 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18815""")
      x18815.r := Math.fma(x19379,147L.FP(true, 32, 0),x3145_mul,Some(6.0), ensig0, "x18815").toFixed(x18815, "cast_x18815").r
      val x3147 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3147""")
      x3147.r := Math.arith_left_shift(x18815, 2, Some(0.2), ensig0,"x3147").r
      val x18816 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18816""")
      x18816.r := Math.and(x3147,63L.FP(true, 32, 0),Some(0.2), ensig0,"x18816").r
      val x3149_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3149_sub""")
      x3149_sub.r := Math.sub(x3147,x18816,Some(1.0), ensig0, Truncate, Wrapping, "x3149_sub").r
      val x3150_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3150_sum""")
      x3150_sum.r := Math.add(x3147,196L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x3150_sum").r
      val x18817 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18817""")
      x18817.r := Math.and(x3150_sum,63L.FP(true, 32, 0),Some(0.2), ensig0,"x18817").r
      val x3152 = Wire(Bool()).suggestName("""x3152""")
      x3152.r := Math.eql(x18817, 0L.FP(true, 32, 0), Some(0.2), ensig0,"x3152").r
      val x3153_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3153_sub""")
      x3153_sub.r := Math.sub(64L.FP(true, 32, 0),x18817,Some(1.0), ensig0, Truncate, Wrapping, "x3153_sub").r
      val x19380 = Wire(Bool()).suggestName("x19380_x3152_D1") 
      x19380.r := getRetimed(x3152.r, 1.toInt, io.sigsIn.backpressure)
      val x3154 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3154""")
      x3154.r := Mux((x19380), 0L.FP(true, 32, 0).r, x3153_sub.r)
      val x3155 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3155""")
      x3155.r := Math.arith_right_shift(x18816, 2, Some(0.2), ensig0,"x3155").r
      val x3156 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3156""")
      x3156.r := Math.arith_right_shift(x3154, 2, Some(0.2 + 1.0), ensig0,"x3156").r
      val x3157_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3157_sum""")
      x3157_sum.r := Math.add(x3155,49L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x3157_sum").r
      val x3158_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3158_sum""")
      x3158_sum.r := Math.add(49L.FP(true, 32, 0),x3155,Some(1.0), ensig0, Truncate, Wrapping, "x3158_sum").r
      val x19381 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19381_x3156_D1") 
      x19381.r := getRetimed(x3156.r, 1.toInt, io.sigsIn.backpressure)
      val x19382 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19382_x3158_sum_D2") 
      x19382.r := getRetimed(x3158_sum.r, 2.toInt, io.sigsIn.backpressure)
      val x3159_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3159_sum""")
      x3159_sum.r := Math.add(x19382,x19381,Some(1.0), ensig0, Truncate, Wrapping, "x3159_sum").r
      val x3160_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3160_sum""")
      x3160_sum.r := Math.add(196L.FP(true, 32, 0),x18816,Some(1.0), ensig0, Truncate, Wrapping, "x3160_sum").r
      val x19383 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19383_x3160_sum_D1") 
      x19383.r := getRetimed(x3160_sum.r, 1.toInt, io.sigsIn.backpressure)
      val x3161_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3161_sum""")
      x3161_sum.r := Math.add(x19383,x3154,Some(1.0), ensig0, Truncate, Wrapping, "x3161_sum").r
      val x3162 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x3162""")
      x3162.r := Math.fix2fix(x3149_sub, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x3162").r
      val x3163 = x3066_c101_DRAM
      val x19384 = Wire(new FixedPoint(true, 64, 0)).suggestName("x19384_x3163_D13") 
      x19384.r := getRetimed(x3163.r, 13.toInt, io.sigsIn.backpressure)
      val x3164_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x3164_sum""")
      x3164_sum.r := Math.add(x3162,x19384,Some(2.0), ensig0, Truncate, Wrapping, "x3164_sum").r
      val x3165_tuple = Wire(UInt(97.W)).suggestName("""x3165_tuple""")
      x3165_tuple.r := Cat(true.B,x3161_sum.r,x3164_sum.r)
      val x3166 = true.B
      val x19385 = Wire(Bool()).suggestName("x19385_x3166_D15") 
      x19385.r := getRetimed(x3166.r, 15.toInt, io.sigsIn.backpressure)
      x3140.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(15.9.toInt.toInt, rr, io.sigsIn.backpressure) & x19385 & io.sigsIn.backpressure
      x3140.bits.addr := x3165_tuple(63,0)
      x3140.bits.size := x3165_tuple(95,64)
      val x19386 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19386_x3155_D4") 
      x19386.r := getRetimed(x3155.r, 4.toInt, io.sigsIn.backpressure)
      val x19387 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19387_x3157_sum_D3") 
      x19387.r := getRetimed(x3157_sum.r, 3.toInt, io.sigsIn.backpressure)
      val x3168_tuple = Wire(UInt(96.W)).suggestName("""x3168_tuple""")
      x3168_tuple.r := Cat(x19387.r,x19386.r,x3159_sum.r)
      val x3169_enq_x3141_banks = List[UInt]()
      val x3169_enq_x3141_ofs = List[UInt]()
      val x3169_enq_x3141_en = List[Bool](true.B)
      val x3169_enq_x3141_data = List[UInt](x3168_tuple.r)
      x3141_fifo.connectWPort(3169, x3169_enq_x3141_banks, x3169_enq_x3141_ofs, x3169_enq_x3141_data, x3169_enq_x3141_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(16.1.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x3141_fifo.connectAccessActivesIn(0, ((true.B)))
    }
    val module = Module(new x3170_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3170_inr_UnitPipe **/
