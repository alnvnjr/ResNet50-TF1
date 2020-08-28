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

/** Hierarchy: x17586 -> x17705 -> x17710 -> x17711 -> x17712 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17586_inr_UnitPipe **/
class x17586_inr_UnitPipe_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x17550: List[DecoupledIO[AppCommandDense]],
  list_x17555_reg: List[StandardInterface],
  list_x17539_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 11.1.toInt, myName = "x17586_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17586_inr_UnitPipe_iiCtr"))
  
  abstract class x17586_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x17539_reg = Flipped(new NBufInterface(ModuleParams.getParams("x17539_reg_p").asInstanceOf[NBufParams] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x17555_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17555_reg_p").asInstanceOf[MemParams] ))
      val in_x17550 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17550_p").asInstanceOf[(Int,Int)] ))
      val in_x17554_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17554_reg_p").asInstanceOf[MemParams] ))
      val in_x9495_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9495_reg_p").asInstanceOf[MemParams] ))
      val in_x17553_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17553_reg_p").asInstanceOf[MemParams] ))
      val in_x17540_reg = Flipped(new NBufInterface(ModuleParams.getParams("x17540_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x17539_reg = {io.in_x17539_reg} ; io.in_x17539_reg := DontCare
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x17555_reg = {io.in_x17555_reg} ; io.in_x17555_reg := DontCare
    def x17550 = {io.in_x17550} 
    def x17554_reg = {io.in_x17554_reg} ; io.in_x17554_reg := DontCare
    def x9495_reg = {io.in_x9495_reg} ; io.in_x9495_reg := DontCare
    def x17553_reg = {io.in_x17553_reg} ; io.in_x17553_reg := DontCare
    def x17540_reg = {io.in_x17540_reg} ; io.in_x17540_reg := DontCare
  }
  def connectWires0(module: x17586_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x17539_reg.connectLedger(module.io.in_x17539_reg)
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x17555_reg.connectLedger(module.io.in_x17555_reg)
    module.io.in_x17550 <> x17550
    x17554_reg.connectLedger(module.io.in_x17554_reg)
    x9495_reg.connectLedger(module.io.in_x9495_reg)
    x17553_reg.connectLedger(module.io.in_x17553_reg)
    x17540_reg.connectLedger(module.io.in_x17540_reg)
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x17550 = list_x17550(0)
  val x17555_reg = list_x17555_reg(0)
  val x17554_reg = list_x17555_reg(1)
  val x9495_reg = list_x17555_reg(2)
  val x17553_reg = list_x17555_reg(3)
  val x17539_reg = list_x17539_reg(0)
  val x17540_reg = list_x17539_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17586_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x17586_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17586_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x17556_rd_x9495 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17556_rd_x9495""")
      val x17556_rd_x9495_banks = List[UInt]()
      val x17556_rd_x9495_ofs = List[UInt]()
      val x17556_rd_x9495_en = List[Bool](true.B)
      x17556_rd_x9495.toSeq.zip(x9495_reg.connectRPort(17556, x17556_rd_x9495_banks, x17556_rd_x9495_ofs, io.sigsIn.backpressure, x17556_rd_x9495_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17558_rd_x17539 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17558_rd_x17539""")
      val x17558_rd_x17539_banks = List[UInt]()
      val x17558_rd_x17539_ofs = List[UInt]()
      val x17558_rd_x17539_en = List[Bool](true.B)
      x17558_rd_x17539.toSeq.zip(x17539_reg.connectRPort(17558, x17558_rd_x17539_banks, x17558_rd_x17539_ofs, io.sigsIn.backpressure, x17558_rd_x17539_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19352 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19352""")
      val ensig0 = Wire(Bool())
      ensig0 := x17550.ready
      x19352.r := Math.fma(x17556_rd_x9495,802816L.FP(true, 32, 0),x17558_rd_x17539,Some(6.0), ensig0, "x19352").toFixed(x19352, "cast_x19352").r
      val x17560 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17560""")
      x17560.r := Math.arith_left_shift(x19352, 2, Some(0.2), ensig0,"x17560").r
      val x19353 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19353""")
      x19353.r := Math.and(x17560,63L.FP(true, 32, 0),Some(0.2), ensig0,"x19353").r
      val x17562_rd_x17540 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17562_rd_x17540""")
      val x17562_rd_x17540_banks = List[UInt]()
      val x17562_rd_x17540_ofs = List[UInt]()
      val x17562_rd_x17540_en = List[Bool](true.B)
      x17562_rd_x17540.toSeq.zip(x17540_reg.connectRPort(17562, x17562_rd_x17540_banks, x17562_rd_x17540_ofs, io.sigsIn.backpressure, x17562_rd_x17540_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17563 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17563""")
      x17563.r := Math.arith_left_shift(x17562_rd_x17540, 2, Some(0.2), ensig0,"x17563").r
      val x17564_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17564_sub""")
      x17564_sub.r := Math.sub(x17560,x19353,Some(1.0), ensig0, Truncate, Wrapping, "x17564_sub").r
      val x21815 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21815_x17563_D6") 
      x21815.r := getRetimed(x17563.r, 6.toInt, io.sigsIn.backpressure)
      val x17565_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17565_sum""")
      x17565_sum.r := Math.add(x17560,x21815,Some(1.0), ensig0, Truncate, Wrapping, "x17565_sum").r
      val x19354 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19354""")
      x19354.r := Math.and(x17565_sum,63L.FP(true, 32, 0),Some(0.2), ensig0,"x19354").r
      val x17567 = Wire(Bool()).suggestName("""x17567""")
      x17567.r := Math.eql(x19354, 0L.FP(true, 32, 0), Some(0.2), ensig0,"x17567").r
      val x17568_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17568_sub""")
      x17568_sub.r := Math.sub(64L.FP(true, 32, 0),x19354,Some(1.0), ensig0, Truncate, Wrapping, "x17568_sub").r
      val x21816 = Wire(Bool()).suggestName("x21816_x17567_D1") 
      x21816.r := getRetimed(x17567.r, 1.toInt, io.sigsIn.backpressure)
      val x17569 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17569""")
      x17569.r := Mux((x21816), 0L.FP(true, 32, 0).r, x17568_sub.r)
      val x17570 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17570""")
      x17570.r := Math.arith_right_shift(x19353, 2, Some(0.2), ensig0,"x17570").r
      val x17571 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17571""")
      x17571.r := Math.arith_right_shift(x17569, 2, Some(0.2 + 1.0), ensig0,"x17571").r
      val x21817 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21817_x17562_rd_x17540_D6") 
      x21817.r := getRetimed(x17562_rd_x17540.r, 6.toInt, io.sigsIn.backpressure)
      val x17572_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17572_sum""")
      x17572_sum.r := Math.add(x17570,x21817,Some(1.0), ensig0, Truncate, Wrapping, "x17572_sum").r
      val x17573_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17573_sum""")
      x17573_sum.r := Math.add(x21817,x17570,Some(1.0), ensig0, Truncate, Wrapping, "x17573_sum").r
      val x21818 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21818_x17573_sum_D2") 
      x21818.r := getRetimed(x17573_sum.r, 2.toInt, io.sigsIn.backpressure)
      val x21819 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21819_x17571_D1") 
      x21819.r := getRetimed(x17571.r, 1.toInt, io.sigsIn.backpressure)
      val x17574_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17574_sum""")
      x17574_sum.r := Math.add(x21818,x21819,Some(1.0), ensig0, Truncate, Wrapping, "x17574_sum").r
      val x17575_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17575_sum""")
      x17575_sum.r := Math.add(x21815,x19353,Some(1.0), ensig0, Truncate, Wrapping, "x17575_sum").r
      val x21820 = Wire(new FixedPoint(true, 32, 0)).suggestName("x21820_x17575_sum_D1") 
      x21820.r := getRetimed(x17575_sum.r, 1.toInt, io.sigsIn.backpressure)
      val x17576_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17576_sum""")
      x17576_sum.r := Math.add(x21820,x17569,Some(1.0), ensig0, Truncate, Wrapping, "x17576_sum").r
      val x17577 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x17577""")
      x17577.r := Math.fix2fix(x17564_sub, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x17577").r
      val x17578 = x2682_tmp_DRAM
      val x21821 = Wire(new FixedPoint(true, 64, 0)).suggestName("x21821_x17578_D7") 
      x21821.r := getRetimed(x17578.r, 7.toInt, io.sigsIn.backpressure)
      val x17579_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x17579_sum""")
      x17579_sum.r := Math.add(x17577,x21821,Some(2.0), ensig0, Truncate, Wrapping, "x17579_sum").r
      val x17580_tuple = Wire(UInt(97.W)).suggestName("""x17580_tuple""")
      x17580_tuple.r := Cat(false.B,x17576_sum.r,x17579_sum.r)
      val x17581 = true.B
      val x21822 = Wire(Bool()).suggestName("x21822_x17581_D9") 
      x21822.r := getRetimed(x17581.r, 9.toInt, io.sigsIn.backpressure)
      x17550.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt.toInt, rr, io.sigsIn.backpressure) & x21822 & io.sigsIn.backpressure
      x17550.bits.addr := x17580_tuple(63,0)
      x17550.bits.size := x17580_tuple(95,64)
      val x17583_wr_x17553_banks = List[UInt]()
      val x17583_wr_x17553_ofs = List[UInt]()
      val x17583_wr_x17553_en = List[Bool](true.B)
      val x17583_wr_x17553_data = List[UInt](x17570.r)
      x17553_reg.connectWPort(17583, x17583_wr_x17553_banks, x17583_wr_x17553_ofs, x17583_wr_x17553_data, x17583_wr_x17553_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.6.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x17584_wr_x17554_banks = List[UInt]()
      val x17584_wr_x17554_ofs = List[UInt]()
      val x17584_wr_x17554_en = List[Bool](true.B)
      val x17584_wr_x17554_data = List[UInt](x17572_sum.r)
      x17554_reg.connectWPort(17584, x17584_wr_x17554_banks, x17584_wr_x17554_ofs, x17584_wr_x17554_data, x17584_wr_x17554_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.6.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x17585_wr_x17555_banks = List[UInt]()
      val x17585_wr_x17555_ofs = List[UInt]()
      val x17585_wr_x17555_en = List[Bool](true.B)
      val x17585_wr_x17555_data = List[UInt](x17574_sum.r)
      x17555_reg.connectWPort(17585, x17585_wr_x17555_banks, x17585_wr_x17555_ofs, x17585_wr_x17555_data, x17585_wr_x17555_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(10.1.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x17586_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x17586_inr_UnitPipe **/
