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

/** Hierarchy: x18418 -> x18450 -> x18477 -> x1256 **/
/** BEGIN None x18418_inr_UnitPipe **/
class x18418_inr_UnitPipe_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x18389_fifo: List[FIFOInterface],
  list_x18388: List[DecoupledIO[AppCommandDense]],
  list_x18382_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 11.1.toInt, myName = "x18418_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18418_inr_UnitPipe_iiCtr"))
  
  abstract class x18418_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18388 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18388_p").asInstanceOf[(Int,Int)] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x18389_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x18389_fifo_p").asInstanceOf[MemParams] ))
      val in_x18382_reg = Flipped(new NBufInterface(ModuleParams.getParams("x18382_reg_p").asInstanceOf[NBufParams] ))
      val in_x18381_reg = Flipped(new NBufInterface(ModuleParams.getParams("x18381_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18388 = {io.in_x18388} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x18389_fifo = {io.in_x18389_fifo} ; io.in_x18389_fifo := DontCare
    def x18382_reg = {io.in_x18382_reg} ; io.in_x18382_reg := DontCare
    def x18381_reg = {io.in_x18381_reg} ; io.in_x18381_reg := DontCare
  }
  def connectWires0(module: x18418_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18388 <> x18388
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x18389_fifo.connectLedger(module.io.in_x18389_fifo)
    x18382_reg.connectLedger(module.io.in_x18382_reg)
    x18381_reg.connectLedger(module.io.in_x18381_reg)
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x18389_fifo = list_x18389_fifo(0)
  val x18388 = list_x18388(0)
  val x18382_reg = list_x18382_reg(0)
  val x18381_reg = list_x18382_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18418_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x18418_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18418_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x18391_rd_x18381 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18391_rd_x18381""")
      val x18391_rd_x18381_banks = List[UInt]()
      val x18391_rd_x18381_ofs = List[UInt]()
      val x18391_rd_x18381_en = List[Bool](true.B)
      x18391_rd_x18381.toSeq.zip(x18381_reg.connectRPort(18391, x18391_rd_x18381_banks, x18391_rd_x18381_ofs, io.sigsIn.backpressure, x18391_rd_x18381_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18393_rd_x18382 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18393_rd_x18382""")
      val x18393_rd_x18382_banks = List[UInt]()
      val x18393_rd_x18382_ofs = List[UInt]()
      val x18393_rd_x18382_en = List[Bool](true.B)
      x18393_rd_x18382.toSeq.zip(x18382_reg.connectRPort(18393, x18393_rd_x18382_banks, x18393_rd_x18382_ofs, io.sigsIn.backpressure, x18393_rd_x18382_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19366 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19366""")
      val ensig0 = Wire(Bool())
      ensig0 := x18388.ready & (~x18389_fifo.full | ~(x18389_fifo.accessActivesOut(0)))
      x19366.r := Math.fma(x18391_rd_x18381,802816L.FP(true, 32, 0),x18393_rd_x18382,Some(6.0), ensig0, "x19366").toFixed(x19366, "cast_x19366").r
      val x18395 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18395""")
      x18395.r := Math.arith_left_shift(x19366, 2, Some(0.2), ensig0,"x18395").r
      val x19367 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19367""")
      x19367.r := Math.and(x18395,63L.FP(true, 32, 0),Some(0.2), ensig0,"x19367").r
      val x18397_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18397_sub""")
      x18397_sub.r := Math.sub(x18395,x19367,Some(1.0), ensig0, Truncate, Wrapping, "x18397_sub").r
      val x18398_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18398_sum""")
      x18398_sum.r := Math.add(x18395,196L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x18398_sum").r
      val x19368 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19368""")
      x19368.r := Math.and(x18398_sum,63L.FP(true, 32, 0),Some(0.2), ensig0,"x19368").r
      val x18400 = Wire(Bool()).suggestName("""x18400""")
      x18400.r := Math.eql(x19368, 0L.FP(true, 32, 0), Some(0.2), ensig0,"x18400").r
      val x18401_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18401_sub""")
      x18401_sub.r := Math.sub(64L.FP(true, 32, 0),x19368,Some(1.0), ensig0, Truncate, Wrapping, "x18401_sub").r
      val x21983 = Wire(Bool()).suggestName("x21983_x18400_D1") 
      x21983.r := getRetimed(x18400.r, 1.toInt, io.sigsIn.backpressure)
      val x18402 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18402""")
      x18402.r := Mux((x21983), 0L.FP(true, 32, 0).r, x18401_sub.r)
      val x18403 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18403""")
      x18403.r := Math.arith_right_shift(x19367, 2, Some(0.2), ensig0,"x18403").r
      val x18404 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18404""")
      x18404.r := Math.arith_right_shift(x18402, 2, Some(0.2 + 1.0), ensig0,"x18404").r
      val x18405_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18405_sum""")
      x18405_sum.r := Math.add(x18403,49L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x18405_sum").r
      val x18406_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18406_sum""")
      x18406_sum.r := Math.add(49L.FP(true, 32, 0),x18403,Some(1.0), ensig0, Truncate, Wrapping, "x18406_sum").r
      val x21984 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21984_x18406_sum_D2") 
      x21984.r := getRetimed(x18406_sum.r, 2.toInt, io.sigsIn.backpressure)
      val x21985 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21985_x18404_D1") 
      x21985.r := getRetimed(x18404.r, 1.toInt, io.sigsIn.backpressure)
      val x18407_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18407_sum""")
      x18407_sum.r := Math.add(x21984,x21985,Some(1.0), ensig0, Truncate, Wrapping, "x18407_sum").r
      val x18408_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18408_sum""")
      x18408_sum.r := Math.add(196L.FP(true, 32, 0),x19367,Some(1.0), ensig0, Truncate, Wrapping, "x18408_sum").r
      val x21986 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21986_x18408_sum_D1") 
      x21986.r := getRetimed(x18408_sum.r, 1.toInt, io.sigsIn.backpressure)
      val x18409_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18409_sum""")
      x18409_sum.r := Math.add(x21986,x18402,Some(1.0), ensig0, Truncate, Wrapping, "x18409_sum").r
      val x18410 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x18410""")
      x18410.r := Math.fix2fix(x18397_sub, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x18410").r
      val x18411 = x2682_tmp_DRAM
      val x21987 = Wire(new FixedPoint(true, 64, 0)).suggestName("x21987_x18411_D7") 
      x21987.r := getRetimed(x18411.r, 7.toInt, io.sigsIn.backpressure)
      val x18412_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x18412_sum""")
      x18412_sum.r := Math.add(x18410,x21987,Some(2.0), ensig0, Truncate, Wrapping, "x18412_sum").r
      val x18413_tuple = Wire(UInt(97.W)).suggestName("""x18413_tuple""")
      x18413_tuple.r := Cat(true.B,x18409_sum.r,x18412_sum.r)
      val x18414 = true.B
      val x21988 = Wire(Bool()).suggestName("x21988_x18414_D9") 
      x21988.r := getRetimed(x18414.r, 9.toInt, io.sigsIn.backpressure)
      x18388.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt.toInt, rr, io.sigsIn.backpressure) & x21988 & io.sigsIn.backpressure
      x18388.bits.addr := x18413_tuple(63,0)
      x18388.bits.size := x18413_tuple(95,64)
      val x21989 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21989_x18405_sum_D3") 
      x21989.r := getRetimed(x18405_sum.r, 3.toInt, io.sigsIn.backpressure)
      val x21990 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21990_x18403_D4") 
      x21990.r := getRetimed(x18403.r, 4.toInt, io.sigsIn.backpressure)
      val x18416_tuple = Wire(UInt(96.W)).suggestName("""x18416_tuple""")
      x18416_tuple.r := Cat(x21989.r,x21990.r,x18407_sum.r)
      val x18417_enq_x18389_banks = List[UInt]()
      val x18417_enq_x18389_ofs = List[UInt]()
      val x18417_enq_x18389_en = List[Bool](true.B)
      val x18417_enq_x18389_data = List[UInt](x18416_tuple.r)
      x18389_fifo.connectWPort(18417, x18417_enq_x18389_banks, x18417_enq_x18389_ofs, x18417_enq_x18389_data, x18417_enq_x18389_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(10.1.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x18389_fifo.connectAccessActivesIn(0, ((true.B)))
    }
    val module = Module(new x18418_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x18418_inr_UnitPipe **/
