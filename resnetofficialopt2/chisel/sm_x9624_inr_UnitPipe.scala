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

/** Hierarchy: x9624 -> x9766 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9624_inr_UnitPipe **/
class x9624_inr_UnitPipe_kernel(
  list_x9594_fifo: List[FIFOInterface],
  list_x9593: List[DecoupledIO[AppCommandDense]],
  list_b9592: List[Bool],
  list_x9487_reg: List[StandardInterface],
  list_x9584_reg: List[NBufInterface],
  list_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 6.1.toInt, myName = "x9624_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9624_inr_UnitPipe_iiCtr"))
  
  abstract class x9624_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9593 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9593_p").asInstanceOf[(Int,Int)] ))
      val in_x9584_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9584_reg_p").asInstanceOf[NBufParams] ))
      val in_x9594_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x9594_fifo_p").asInstanceOf[MemParams] ))
      val in_b9592 = Input(Bool())
      val in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9487_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9487_reg_p").asInstanceOf[MemParams] ))
      val in_b9553 = Input(Bool())
      val in_b9591 = Input(new FixedPoint(true, 32, 0))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9593 = {io.in_x9593} 
    def x9584_reg = {io.in_x9584_reg} ; io.in_x9584_reg := DontCare
    def x9594_fifo = {io.in_x9594_fifo} ; io.in_x9594_fifo := DontCare
    def b9592 = {io.in_b9592} 
    def x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = {io.in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM} 
    def x9487_reg = {io.in_x9487_reg} ; io.in_x9487_reg := DontCare
    def b9553 = {io.in_b9553} 
    def b9591 = {io.in_b9591} 
  }
  def connectWires0(module: x9624_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x9593 <> x9593
    x9584_reg.connectLedger(module.io.in_x9584_reg)
    x9594_fifo.connectLedger(module.io.in_x9594_fifo)
    module.io.in_b9592 <> b9592
    module.io.in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM <> x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM
    x9487_reg.connectLedger(module.io.in_x9487_reg)
    module.io.in_b9553 <> b9553
    module.io.in_b9591 <> b9591
  }
  val x9594_fifo = list_x9594_fifo(0)
  val x9593 = list_x9593(0)
  val b9592 = list_b9592(0)
  val b9553 = list_b9592(1)
  val x9487_reg = list_x9487_reg(0)
  val x9584_reg = list_x9584_reg(0)
  val x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = list_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM(0)
  val b9591 = list_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9624_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9624_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9624_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9596_rd_x9584 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9596_rd_x9584""")
      val x9596_rd_x9584_banks = List[UInt]()
      val x9596_rd_x9584_ofs = List[UInt]()
      val x9596_rd_x9584_en = List[Bool](true.B)
      x9596_rd_x9584.toSeq.zip(x9584_reg.connectRPort(9596, x9596_rd_x9584_banks, x9596_rd_x9584_ofs, io.sigsIn.backpressure, x9596_rd_x9584_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9597_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9597_sum""")
      val ensig0 = Wire(Bool())
      ensig0 := (~x9594_fifo.full | ~(x9594_fifo.accessActivesOut(0))) & x9593.ready
      x9597_sum.r := Math.add(x9596_rd_x9584,b9591,Some(1.0), ensig0, Truncate, Wrapping, "x9597_sum").r
      val x19058 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19058""")
      x19058.r := Math.arith_left_shift(x9597_sum, 13, Some(0.2), ensig0,"x19058").r
      val x19059 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19059""")
      x19059.r := Math.and(x19058,63L.FP(true, 32, 0),Some(0.2), ensig0,"x19059").r
      val x9601_rd_x9487 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9601_rd_x9487""")
      val x9601_rd_x9487_banks = List[UInt]()
      val x9601_rd_x9487_ofs = List[UInt]()
      val x9601_rd_x9487_en = List[Bool](true.B)
      x9601_rd_x9487.toSeq.zip(x9487_reg.connectRPort(9601, x9601_rd_x9487_banks, x9601_rd_x9487_ofs, io.sigsIn.backpressure, x9601_rd_x9487_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9602 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9602""")
      x9602.r := Math.arith_left_shift(x9601_rd_x9487, 2, Some(0.2), ensig0,"x9602").r
      val x9603_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9603_sub""")
      x9603_sub.r := Math.sub(x19058,x19059,Some(1.0), ensig0, Truncate, Wrapping, "x9603_sub").r
      val x20649 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20649_x9602_D1") 
      x20649.r := getRetimed(x9602.r, 1.toInt, io.sigsIn.backpressure)
      val x9604_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9604_sum""")
      x9604_sum.r := Math.add(x19058,x20649,Some(1.0), ensig0, Truncate, Wrapping, "x9604_sum").r
      val x19060 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19060""")
      x19060.r := Math.and(x9604_sum,63L.FP(true, 32, 0),Some(0.2), ensig0,"x19060").r
      val x9606 = Wire(Bool()).suggestName("""x9606""")
      x9606.r := Math.eql(x19060, 0L.FP(true, 32, 0), Some(0.2), ensig0,"x9606").r
      val x9607_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9607_sub""")
      x9607_sub.r := Math.sub(64L.FP(true, 32, 0),x19060,Some(1.0), ensig0, Truncate, Wrapping, "x9607_sub").r
      val x20650 = Wire(Bool()).suggestName("x20650_x9606_D1") 
      x20650.r := getRetimed(x9606.r, 1.toInt, io.sigsIn.backpressure)
      val x9608 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9608""")
      x9608.r := Mux((x20650), 0L.FP(true, 32, 0).r, x9607_sub.r)
      val x9609 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9609""")
      x9609.r := Math.arith_right_shift(x19059, 2, Some(0.2), ensig0,"x9609").r
      val x9610 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9610""")
      x9610.r := Math.arith_right_shift(x9608, 2, Some(0.2 + 1.0), ensig0,"x9610").r
      val x20651 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20651_x9601_rd_x9487_D1") 
      x20651.r := getRetimed(x9601_rd_x9487.r, 1.toInt, io.sigsIn.backpressure)
      val x9611_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9611_sum""")
      x9611_sum.r := Math.add(x9609,x20651,Some(1.0), ensig0, Truncate, Wrapping, "x9611_sum").r
      val x9612_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9612_sum""")
      x9612_sum.r := Math.add(x20651,x9609,Some(1.0), ensig0, Truncate, Wrapping, "x9612_sum").r
      val x20652 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20652_x9610_D1") 
      x20652.r := getRetimed(x9610.r, 1.toInt, io.sigsIn.backpressure)
      val x20653 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20653_x9612_sum_D2") 
      x20653.r := getRetimed(x9612_sum.r, 2.toInt, io.sigsIn.backpressure)
      val x9613_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9613_sum""")
      x9613_sum.r := Math.add(x20653,x20652,Some(1.0), ensig0, Truncate, Wrapping, "x9613_sum").r
      val x9614_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9614_sum""")
      x9614_sum.r := Math.add(x20649,x19059,Some(1.0), ensig0, Truncate, Wrapping, "x9614_sum").r
      val x20654 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20654_x9614_sum_D1") 
      x20654.r := getRetimed(x9614_sum.r, 1.toInt, io.sigsIn.backpressure)
      val x9615_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9615_sum""")
      x9615_sum.r := Math.add(x20654,x9608,Some(1.0), ensig0, Truncate, Wrapping, "x9615_sum").r
      val x9616 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x9616""")
      x9616.r := Math.fix2fix(x9603_sub, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x9616").r
      val x9617 = x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM
      val x20655 = Wire(new FixedPoint(true, 64, 0)).suggestName("x20655_x9617_D2") 
      x20655.r := getRetimed(x9617.r, 2.toInt, io.sigsIn.backpressure)
      val x9618_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x9618_sum""")
      x9618_sum.r := Math.add(x9616,x20655,Some(2.0), ensig0, Truncate, Wrapping, "x9618_sum").r
      val x9619_tuple = Wire(UInt(97.W)).suggestName("""x9619_tuple""")
      x9619_tuple.r := Cat(true.B,x9615_sum.r,x9618_sum.r)
      val x9620 = true.B
      val x20656 = Wire(Bool()).suggestName("x20656_x9620_D4") 
      x20656.r := getRetimed(x9620.r, 4.toInt, io.sigsIn.backpressure)
      x9593.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(4.9.toInt.toInt, rr, io.sigsIn.backpressure) & x20656 & io.sigsIn.backpressure
      x9593.bits.addr := x9619_tuple(63,0)
      x9593.bits.size := x9619_tuple(95,64)
      val x20657 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20657_x9611_sum_D3") 
      x20657.r := getRetimed(x9611_sum.r, 3.toInt, io.sigsIn.backpressure)
      val x20658 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20658_x9609_D4") 
      x20658.r := getRetimed(x9609.r, 4.toInt, io.sigsIn.backpressure)
      val x9622_tuple = Wire(UInt(96.W)).suggestName("""x9622_tuple""")
      x9622_tuple.r := Cat(x20657.r,x20658.r,x9613_sum.r)
      val x9623_enq_x9594_banks = List[UInt]()
      val x9623_enq_x9594_ofs = List[UInt]()
      val x9623_enq_x9594_en = List[Bool](true.B)
      val x9623_enq_x9594_data = List[UInt](x9622_tuple.r)
      x9594_fifo.connectWPort(9623, x9623_enq_x9594_banks, x9623_enq_x9594_ofs, x9623_enq_x9594_data, x9623_enq_x9594_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(5.1.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x9594_fifo.connectAccessActivesIn(0, ((true.B)))
    }
    val module = Module(new x9624_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9624_inr_UnitPipe **/
