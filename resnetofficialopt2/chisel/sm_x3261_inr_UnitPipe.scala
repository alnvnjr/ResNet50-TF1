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

/** Hierarchy: x3261 -> x3300 -> x3699 -> x3700 -> x3898 -> x1256 **/
/** BEGIN None x3261_inr_UnitPipe **/
class x3261_inr_UnitPipe_kernel(
  list_x3230: List[DecoupledIO[AppCommandDense]],
  list_b3121: List[Bool],
  list_x3231_fifo: List[FIFOInterface],
  list_x2679_i0_pad_DRAM: List[FixedPoint],
  list_x3221_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 18.1.toInt, myName = "x3261_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3261_inr_UnitPipe_iiCtr"))
  
  abstract class x3261_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3230 = Decoupled(new AppCommandDense(ModuleParams.getParams("x3230_p").asInstanceOf[(Int,Int)] ))
      val in_b3121 = Input(Bool())
      val in_x3221_reg = Flipped(new NBufInterface(ModuleParams.getParams("x3221_reg_p").asInstanceOf[NBufParams] ))
      val in_x3231_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x3231_fifo_p").asInstanceOf[MemParams] ))
      val in_b3229 = Input(Bool())
      val in_b3215 = Input(Bool())
      val in_x2679_i0_pad_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_b3214 = Input(new FixedPoint(true, 32, 0))
      val in_b3228 = Input(new FixedPoint(true, 32, 0))
      val in_b3220 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3230 = {io.in_x3230} 
    def b3121 = {io.in_b3121} 
    def x3221_reg = {io.in_x3221_reg} ; io.in_x3221_reg := DontCare
    def x3231_fifo = {io.in_x3231_fifo} ; io.in_x3231_fifo := DontCare
    def b3229 = {io.in_b3229} 
    def b3215 = {io.in_b3215} 
    def x2679_i0_pad_DRAM = {io.in_x2679_i0_pad_DRAM} 
    def b3214 = {io.in_b3214} 
    def b3228 = {io.in_b3228} 
    def b3220 = {io.in_b3220} 
  }
  def connectWires0(module: x3261_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x3230 <> x3230
    module.io.in_b3121 <> b3121
    x3221_reg.connectLedger(module.io.in_x3221_reg)
    x3231_fifo.connectLedger(module.io.in_x3231_fifo)
    module.io.in_b3229 <> b3229
    module.io.in_b3215 <> b3215
    module.io.in_x2679_i0_pad_DRAM <> x2679_i0_pad_DRAM
    module.io.in_b3214 <> b3214
    module.io.in_b3228 <> b3228
    module.io.in_b3220 <> b3220
  }
  val x3230 = list_x3230(0)
  val b3121 = list_b3121(0)
  val b3229 = list_b3121(1)
  val b3215 = list_b3121(2)
  val b3220 = list_b3121(3)
  val x3231_fifo = list_x3231_fifo(0)
  val x2679_i0_pad_DRAM = list_x2679_i0_pad_DRAM(0)
  val b3214 = list_x2679_i0_pad_DRAM(1)
  val b3228 = list_x2679_i0_pad_DRAM(2)
  val x3221_reg = list_x3221_reg(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3261_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3261_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3261_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3233_rd_x3221 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3233_rd_x3221""")
      val x3233_rd_x3221_banks = List[UInt]()
      val x3233_rd_x3221_ofs = List[UInt]()
      val x3233_rd_x3221_en = List[Bool](true.B)
      x3233_rd_x3221.toSeq.zip(x3221_reg.connectRPort(3233, x3233_rd_x3221_banks, x3233_rd_x3221_ofs, io.sigsIn.backpressure, x3233_rd_x3221_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x3234_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3234_sum""")
      val ensig0 = Wire(Bool())
      ensig0 := x3230.ready & (~x3231_fifo.full | ~(x3231_fifo.accessActivesOut(0)))
      x3234_sum.r := Math.add(x3233_rd_x3221,b3228,Some(1.0), ensig0, Truncate, Wrapping, "x3234_sum").r
      val x3236_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3236_mul""")
      x3236_mul.r := (Math.mul(x3234_sum, 230L.FP(true, 32, 0), Some(6.0), ensig0, Truncate, Wrapping, "x3236_mul")).r
      val x19395 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19395_b3214_D7") 
      x19395.r := getRetimed(b3214.r, 7.toInt, io.sigsIn.backpressure)
      val x18819 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18819""")
      x18819.r := Math.fma(x19395,52900L.FP(true, 32, 0),x3236_mul,Some(6.0), ensig0, "x18819").toFixed(x18819, "cast_x18819").r
      val x3238 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3238""")
      x3238.r := Math.arith_left_shift(x18819, 2, Some(0.2), ensig0,"x3238").r
      val x18820 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18820""")
      x18820.r := Math.and(x3238,63L.FP(true, 32, 0),Some(0.2), ensig0,"x18820").r
      val x3240_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3240_sub""")
      x3240_sub.r := Math.sub(x3238,x18820,Some(1.0), ensig0, Truncate, Wrapping, "x3240_sub").r
      val x3241_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3241_sum""")
      x3241_sum.r := Math.add(x3238,920L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x3241_sum").r
      val x18821 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18821""")
      x18821.r := Math.and(x3241_sum,63L.FP(true, 32, 0),Some(0.2), ensig0,"x18821").r
      val x3243 = Wire(Bool()).suggestName("""x3243""")
      x3243.r := Math.eql(x18821, 0L.FP(true, 32, 0), Some(0.2), ensig0,"x3243").r
      val x3244_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3244_sub""")
      x3244_sub.r := Math.sub(64L.FP(true, 32, 0),x18821,Some(1.0), ensig0, Truncate, Wrapping, "x3244_sub").r
      val x19396 = Wire(Bool()).suggestName("x19396_x3243_D1") 
      x19396.r := getRetimed(x3243.r, 1.toInt, io.sigsIn.backpressure)
      val x3245 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3245""")
      x3245.r := Mux((x19396), 0L.FP(true, 32, 0).r, x3244_sub.r)
      val x3246 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3246""")
      x3246.r := Math.arith_right_shift(x18820, 2, Some(0.2), ensig0,"x3246").r
      val x3247 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3247""")
      x3247.r := Math.arith_right_shift(x3245, 2, Some(0.2 + 1.0), ensig0,"x3247").r
      val x3248_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3248_sum""")
      x3248_sum.r := Math.add(x3246,230L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x3248_sum").r
      val x3249_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3249_sum""")
      x3249_sum.r := Math.add(230L.FP(true, 32, 0),x3246,Some(1.0), ensig0, Truncate, Wrapping, "x3249_sum").r
      val x19397 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19397_x3247_D1") 
      x19397.r := getRetimed(x3247.r, 1.toInt, io.sigsIn.backpressure)
      val x19398 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19398_x3249_sum_D2") 
      x19398.r := getRetimed(x3249_sum.r, 2.toInt, io.sigsIn.backpressure)
      val x3250_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3250_sum""")
      x3250_sum.r := Math.add(x19398,x19397,Some(1.0), ensig0, Truncate, Wrapping, "x3250_sum").r
      val x3251_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3251_sum""")
      x3251_sum.r := Math.add(920L.FP(true, 32, 0),x18820,Some(1.0), ensig0, Truncate, Wrapping, "x3251_sum").r
      val x19399 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19399_x3251_sum_D1") 
      x19399.r := getRetimed(x3251_sum.r, 1.toInt, io.sigsIn.backpressure)
      val x3252_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3252_sum""")
      x3252_sum.r := Math.add(x19399,x3245,Some(1.0), ensig0, Truncate, Wrapping, "x3252_sum").r
      val x3253 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x3253""")
      x3253.r := Math.fix2fix(x3240_sub, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x3253").r
      val x3254 = x2679_i0_pad_DRAM
      val x19400 = Wire(new FixedPoint(true, 64, 0)).suggestName("x19400_x3254_D14") 
      x19400.r := getRetimed(x3254.r, 14.toInt, io.sigsIn.backpressure)
      val x3255_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x3255_sum""")
      x3255_sum.r := Math.add(x3253,x19400,Some(2.0), ensig0, Truncate, Wrapping, "x3255_sum").r
      val x3256_tuple = Wire(UInt(97.W)).suggestName("""x3256_tuple""")
      x3256_tuple.r := Cat(true.B,x3252_sum.r,x3255_sum.r)
      val x3257 = true.B
      val x19401 = Wire(Bool()).suggestName("x19401_x3257_D16") 
      x19401.r := getRetimed(x3257.r, 16.toInt, io.sigsIn.backpressure)
      x3230.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(16.9.toInt.toInt, rr, io.sigsIn.backpressure) & x19401 & io.sigsIn.backpressure
      x3230.bits.addr := x3256_tuple(63,0)
      x3230.bits.size := x3256_tuple(95,64)
      val x19402 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19402_x3246_D4") 
      x19402.r := getRetimed(x3246.r, 4.toInt, io.sigsIn.backpressure)
      val x19403 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19403_x3248_sum_D3") 
      x19403.r := getRetimed(x3248_sum.r, 3.toInt, io.sigsIn.backpressure)
      val x3259_tuple = Wire(UInt(96.W)).suggestName("""x3259_tuple""")
      x3259_tuple.r := Cat(x19403.r,x19402.r,x3250_sum.r)
      val x3260_enq_x3231_banks = List[UInt]()
      val x3260_enq_x3231_ofs = List[UInt]()
      val x3260_enq_x3231_en = List[Bool](true.B)
      val x3260_enq_x3231_data = List[UInt](x3259_tuple.r)
      x3231_fifo.connectWPort(3260, x3260_enq_x3231_banks, x3260_enq_x3231_ofs, x3260_enq_x3231_data, x3260_enq_x3231_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(17.1.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x3231_fifo.connectAccessActivesIn(0, ((true.B)))
    }
    val module = Module(new x3261_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3261_inr_UnitPipe **/
