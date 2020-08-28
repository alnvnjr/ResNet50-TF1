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

/** Hierarchy: x4368 -> x4449 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4368_inr_UnitPipe **/
class x4368_inr_UnitPipe_kernel(
  list_x4331_reg: List[NBufInterface],
  list_x4337_fifo: List[FIFOInterface],
  list_x4336: List[DecoupledIO[AppCommandDense]],
  list_x3935_reg: List[StandardInterface],
  list_x2682_tmp_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 11.1.toInt, myName = "x4368_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4368_inr_UnitPipe_iiCtr"))
  
  abstract class x4368_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3935_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3935_reg_p").asInstanceOf[MemParams] ))
      val in_x3937_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3937_reg_p").asInstanceOf[MemParams] ))
      val in_x4337_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x4337_fifo_p").asInstanceOf[MemParams] ))
      val in_x4331_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4331_reg_p").asInstanceOf[NBufParams] ))
      val in_x4336 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4336_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x3935_reg = {io.in_x3935_reg} ; io.in_x3935_reg := DontCare
    def x3937_reg = {io.in_x3937_reg} ; io.in_x3937_reg := DontCare
    def x4337_fifo = {io.in_x4337_fifo} ; io.in_x4337_fifo := DontCare
    def x4331_reg = {io.in_x4331_reg} ; io.in_x4331_reg := DontCare
    def x4336 = {io.in_x4336} 
  }
  def connectWires0(module: x4368_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x3935_reg.connectLedger(module.io.in_x3935_reg)
    x3937_reg.connectLedger(module.io.in_x3937_reg)
    x4337_fifo.connectLedger(module.io.in_x4337_fifo)
    x4331_reg.connectLedger(module.io.in_x4331_reg)
    module.io.in_x4336 <> x4336
  }
  val x4331_reg = list_x4331_reg(0)
  val x4337_fifo = list_x4337_fifo(0)
  val x4336 = list_x4336(0)
  val x3935_reg = list_x3935_reg(0)
  val x3937_reg = list_x3935_reg(1)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4368_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4368_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4368_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4339_rd_x3937 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4339_rd_x3937""")
      val x4339_rd_x3937_banks = List[UInt]()
      val x4339_rd_x3937_ofs = List[UInt]()
      val x4339_rd_x3937_en = List[Bool](true.B)
      x4339_rd_x3937.toSeq.zip(x3937_reg.connectRPort(4339, x4339_rd_x3937_banks, x4339_rd_x3937_ofs, io.sigsIn.backpressure, x4339_rd_x3937_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4341_rd_x4331 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4341_rd_x4331""")
      val x4341_rd_x4331_banks = List[UInt]()
      val x4341_rd_x4331_ofs = List[UInt]()
      val x4341_rd_x4331_en = List[Bool](true.B)
      x4341_rd_x4331.toSeq.zip(x4331_reg.connectRPort(4341, x4341_rd_x4331_banks, x4341_rd_x4331_ofs, io.sigsIn.backpressure, x4341_rd_x4331_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18875 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18875""")
      val ensig0 = Wire(Bool())
      ensig0 := (~x4337_fifo.full | ~(x4337_fifo.accessActivesOut(0))) & x4336.ready
      x18875.r := Math.fma(x4339_rd_x3937,802816L.FP(true, 32, 0),x4341_rd_x4331,Some(6.0), ensig0, "x18875").toFixed(x18875, "cast_x18875").r
      val x4343 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4343""")
      x4343.r := Math.arith_left_shift(x18875, 2, Some(0.2), ensig0,"x4343").r
      val x18876 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18876""")
      x18876.r := Math.and(x4343,63L.FP(true, 32, 0),Some(0.2), ensig0,"x18876").r
      val x4345_rd_x3935 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4345_rd_x3935""")
      val x4345_rd_x3935_banks = List[UInt]()
      val x4345_rd_x3935_ofs = List[UInt]()
      val x4345_rd_x3935_en = List[Bool](true.B)
      x4345_rd_x3935.toSeq.zip(x3935_reg.connectRPort(4345, x4345_rd_x3935_banks, x4345_rd_x3935_ofs, io.sigsIn.backpressure, x4345_rd_x3935_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4346 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4346""")
      x4346.r := Math.arith_left_shift(x4345_rd_x3935, 2, Some(0.2), ensig0,"x4346").r
      val x4347_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4347_sub""")
      x4347_sub.r := Math.sub(x4343,x18876,Some(1.0), ensig0, Truncate, Wrapping, "x4347_sub").r
      val x19672 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19672_x4346_D6") 
      x19672.r := getRetimed(x4346.r, 6.toInt, io.sigsIn.backpressure)
      val x4348_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4348_sum""")
      x4348_sum.r := Math.add(x4343,x19672,Some(1.0), ensig0, Truncate, Wrapping, "x4348_sum").r
      val x18877 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18877""")
      x18877.r := Math.and(x4348_sum,63L.FP(true, 32, 0),Some(0.2), ensig0,"x18877").r
      val x4350 = Wire(Bool()).suggestName("""x4350""")
      x4350.r := Math.eql(x18877, 0L.FP(true, 32, 0), Some(0.2), ensig0,"x4350").r
      val x4351_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4351_sub""")
      x4351_sub.r := Math.sub(64L.FP(true, 32, 0),x18877,Some(1.0), ensig0, Truncate, Wrapping, "x4351_sub").r
      val x19673 = Wire(Bool()).suggestName("x19673_x4350_D1") 
      x19673.r := getRetimed(x4350.r, 1.toInt, io.sigsIn.backpressure)
      val x4352 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4352""")
      x4352.r := Mux((x19673), 0L.FP(true, 32, 0).r, x4351_sub.r)
      val x4353 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4353""")
      x4353.r := Math.arith_right_shift(x18876, 2, Some(0.2), ensig0,"x4353").r
      val x4354 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4354""")
      x4354.r := Math.arith_right_shift(x4352, 2, Some(0.2 + 1.0), ensig0,"x4354").r
      val x19674 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19674_x4345_rd_x3935_D6") 
      x19674.r := getRetimed(x4345_rd_x3935.r, 6.toInt, io.sigsIn.backpressure)
      val x4355_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4355_sum""")
      x4355_sum.r := Math.add(x4353,x19674,Some(1.0), ensig0, Truncate, Wrapping, "x4355_sum").r
      val x4356_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4356_sum""")
      x4356_sum.r := Math.add(x19674,x4353,Some(1.0), ensig0, Truncate, Wrapping, "x4356_sum").r
      val x19675 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19675_x4356_sum_D2") 
      x19675.r := getRetimed(x4356_sum.r, 2.toInt, io.sigsIn.backpressure)
      val x19676 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19676_x4354_D1") 
      x19676.r := getRetimed(x4354.r, 1.toInt, io.sigsIn.backpressure)
      val x4357_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4357_sum""")
      x4357_sum.r := Math.add(x19675,x19676,Some(1.0), ensig0, Truncate, Wrapping, "x4357_sum").r
      val x4358_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4358_sum""")
      x4358_sum.r := Math.add(x19672,x18876,Some(1.0), ensig0, Truncate, Wrapping, "x4358_sum").r
      val x19677 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19677_x4358_sum_D1") 
      x19677.r := getRetimed(x4358_sum.r, 1.toInt, io.sigsIn.backpressure)
      val x4359_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4359_sum""")
      x4359_sum.r := Math.add(x19677,x4352,Some(1.0), ensig0, Truncate, Wrapping, "x4359_sum").r
      val x4360 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x4360""")
      x4360.r := Math.fix2fix(x4347_sub, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x4360").r
      val x4361 = x2682_tmp_DRAM
      val x19678 = Wire(new FixedPoint(true, 64, 0)).suggestName("x19678_x4361_D7") 
      x19678.r := getRetimed(x4361.r, 7.toInt, io.sigsIn.backpressure)
      val x4362_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x4362_sum""")
      x4362_sum.r := Math.add(x4360,x19678,Some(2.0), ensig0, Truncate, Wrapping, "x4362_sum").r
      val x4363_tuple = Wire(UInt(97.W)).suggestName("""x4363_tuple""")
      x4363_tuple.r := Cat(true.B,x4359_sum.r,x4362_sum.r)
      val x4364 = true.B
      val x19679 = Wire(Bool()).suggestName("x19679_x4364_D9") 
      x19679.r := getRetimed(x4364.r, 9.toInt, io.sigsIn.backpressure)
      x4336.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt.toInt, rr, io.sigsIn.backpressure) & x19679 & io.sigsIn.backpressure
      x4336.bits.addr := x4363_tuple(63,0)
      x4336.bits.size := x4363_tuple(95,64)
      val x19680 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19680_x4355_sum_D3") 
      x19680.r := getRetimed(x4355_sum.r, 3.toInt, io.sigsIn.backpressure)
      val x19681 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19681_x4353_D4") 
      x19681.r := getRetimed(x4353.r, 4.toInt, io.sigsIn.backpressure)
      val x4366_tuple = Wire(UInt(96.W)).suggestName("""x4366_tuple""")
      x4366_tuple.r := Cat(x19680.r,x19681.r,x4357_sum.r)
      val x4367_enq_x4337_banks = List[UInt]()
      val x4367_enq_x4337_ofs = List[UInt]()
      val x4367_enq_x4337_en = List[Bool](true.B)
      val x4367_enq_x4337_data = List[UInt](x4366_tuple.r)
      x4337_fifo.connectWPort(4367, x4367_enq_x4337_banks, x4367_enq_x4337_ofs, x4367_enq_x4337_data, x4367_enq_x4337_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(10.1.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x4337_fifo.connectAccessActivesIn(0, ((true.B)))
    }
    val module = Module(new x4368_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4368_inr_UnitPipe **/
