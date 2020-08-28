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

/** Hierarchy: x4115 -> x4240 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4115_inr_UnitPipe **/
class x4115_inr_UnitPipe_kernel(
  list_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM: List[FixedPoint],
  list_x4084_fifo: List[FIFOInterface],
  list_x4083: List[DecoupledIO[AppCommandDense]],
  list_x4070_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 11.1.toInt, myName = "x4115_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4115_inr_UnitPipe_iiCtr"))
  
  abstract class x4115_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4070_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4070_reg_p").asInstanceOf[NBufParams] ))
      val in_x4072_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4072_reg_p").asInstanceOf[NBufParams] ))
      val in_x4084_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x4084_fifo_p").asInstanceOf[MemParams] ))
      val in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x4083 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4083_p").asInstanceOf[(Int,Int)] ))
      val in_x4071_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4071_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x4070_reg = {io.in_x4070_reg} ; io.in_x4070_reg := DontCare
    def x4072_reg = {io.in_x4072_reg} ; io.in_x4072_reg := DontCare
    def x4084_fifo = {io.in_x4084_fifo} ; io.in_x4084_fifo := DontCare
    def x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = {io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM} 
    def x4083 = {io.in_x4083} 
    def x4071_reg = {io.in_x4071_reg} ; io.in_x4071_reg := DontCare
  }
  def connectWires0(module: x4115_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x4070_reg.connectLedger(module.io.in_x4070_reg)
    x4072_reg.connectLedger(module.io.in_x4072_reg)
    x4084_fifo.connectLedger(module.io.in_x4084_fifo)
    module.io.in_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM <> x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM
    module.io.in_x4083 <> x4083
    x4071_reg.connectLedger(module.io.in_x4071_reg)
  }
  val x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = list_x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM(0)
  val x4084_fifo = list_x4084_fifo(0)
  val x4083 = list_x4083(0)
  val x4070_reg = list_x4070_reg(0)
  val x4072_reg = list_x4070_reg(1)
  val x4071_reg = list_x4070_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4115_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4115_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4115_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4086_rd_x4070 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4086_rd_x4070""")
      val x4086_rd_x4070_banks = List[UInt]()
      val x4086_rd_x4070_ofs = List[UInt]()
      val x4086_rd_x4070_en = List[Bool](true.B)
      x4086_rd_x4070.toSeq.zip(x4070_reg.connectRPort(4086, x4086_rd_x4070_banks, x4086_rd_x4070_ofs, io.sigsIn.backpressure, x4086_rd_x4070_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4088_rd_x4071 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4088_rd_x4071""")
      val x4088_rd_x4071_banks = List[UInt]()
      val x4088_rd_x4071_ofs = List[UInt]()
      val x4088_rd_x4071_en = List[Bool](true.B)
      x4088_rd_x4071.toSeq.zip(x4071_reg.connectRPort(4088, x4088_rd_x4071_banks, x4088_rd_x4071_ofs, io.sigsIn.backpressure, x4088_rd_x4071_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18852 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18852""")
      val ensig0 = Wire(Bool())
      ensig0 := x4083.ready & (~x4084_fifo.full | ~(x4084_fifo.accessActivesOut(0)))
      x18852.r := Math.fma(x4086_rd_x4070,4608L.FP(true, 32, 0),x4088_rd_x4071,Some(6.0), ensig0, "x18852").toFixed(x18852, "cast_x18852").r
      val x4090 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4090""")
      x4090.r := Math.arith_left_shift(x18852, 2, Some(0.2), ensig0,"x4090").r
      val x18853 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18853""")
      x18853.r := Math.and(x4090,63L.FP(true, 32, 0),Some(0.2), ensig0,"x18853").r
      val x4092_rd_x4072 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4092_rd_x4072""")
      val x4092_rd_x4072_banks = List[UInt]()
      val x4092_rd_x4072_ofs = List[UInt]()
      val x4092_rd_x4072_en = List[Bool](true.B)
      x4092_rd_x4072.toSeq.zip(x4072_reg.connectRPort(4092, x4092_rd_x4072_banks, x4092_rd_x4072_ofs, io.sigsIn.backpressure, x4092_rd_x4072_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4093 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4093""")
      x4093.r := Math.arith_left_shift(x4092_rd_x4072, 2, Some(0.2), ensig0,"x4093").r
      val x4094_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4094_sub""")
      x4094_sub.r := Math.sub(x4090,x18853,Some(1.0), ensig0, Truncate, Wrapping, "x4094_sub").r
      val x19614 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19614_x4093_D6") 
      x19614.r := getRetimed(x4093.r, 6.toInt, io.sigsIn.backpressure)
      val x4095_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4095_sum""")
      x4095_sum.r := Math.add(x4090,x19614,Some(1.0), ensig0, Truncate, Wrapping, "x4095_sum").r
      val x18854 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18854""")
      x18854.r := Math.and(x4095_sum,63L.FP(true, 32, 0),Some(0.2), ensig0,"x18854").r
      val x4097 = Wire(Bool()).suggestName("""x4097""")
      x4097.r := Math.eql(x18854, 0L.FP(true, 32, 0), Some(0.2), ensig0,"x4097").r
      val x4098_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4098_sub""")
      x4098_sub.r := Math.sub(64L.FP(true, 32, 0),x18854,Some(1.0), ensig0, Truncate, Wrapping, "x4098_sub").r
      val x19615 = Wire(Bool()).suggestName("x19615_x4097_D1") 
      x19615.r := getRetimed(x4097.r, 1.toInt, io.sigsIn.backpressure)
      val x4099 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4099""")
      x4099.r := Mux((x19615), 0L.FP(true, 32, 0).r, x4098_sub.r)
      val x4100 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4100""")
      x4100.r := Math.arith_right_shift(x18853, 2, Some(0.2), ensig0,"x4100").r
      val x4101 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4101""")
      x4101.r := Math.arith_right_shift(x4099, 2, Some(0.2 + 1.0), ensig0,"x4101").r
      val x19616 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19616_x4092_rd_x4072_D6") 
      x19616.r := getRetimed(x4092_rd_x4072.r, 6.toInt, io.sigsIn.backpressure)
      val x4102_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4102_sum""")
      x4102_sum.r := Math.add(x4100,x19616,Some(1.0), ensig0, Truncate, Wrapping, "x4102_sum").r
      val x4103_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4103_sum""")
      x4103_sum.r := Math.add(x19616,x4100,Some(1.0), ensig0, Truncate, Wrapping, "x4103_sum").r
      val x19617 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19617_x4103_sum_D2") 
      x19617.r := getRetimed(x4103_sum.r, 2.toInt, io.sigsIn.backpressure)
      val x19618 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19618_x4101_D1") 
      x19618.r := getRetimed(x4101.r, 1.toInt, io.sigsIn.backpressure)
      val x4104_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4104_sum""")
      x4104_sum.r := Math.add(x19617,x19618,Some(1.0), ensig0, Truncate, Wrapping, "x4104_sum").r
      val x4105_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4105_sum""")
      x4105_sum.r := Math.add(x19614,x18853,Some(1.0), ensig0, Truncate, Wrapping, "x4105_sum").r
      val x19619 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19619_x4105_sum_D1") 
      x19619.r := getRetimed(x4105_sum.r, 1.toInt, io.sigsIn.backpressure)
      val x4106_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x4106_sum""")
      x4106_sum.r := Math.add(x19619,x4099,Some(1.0), ensig0, Truncate, Wrapping, "x4106_sum").r
      val x4107 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x4107""")
      x4107.r := Math.fix2fix(x4094_sub, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x4107").r
      val x4108 = x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM
      val x19620 = Wire(new FixedPoint(true, 64, 0)).suggestName("x19620_x4108_D7") 
      x19620.r := getRetimed(x4108.r, 7.toInt, io.sigsIn.backpressure)
      val x4109_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x4109_sum""")
      x4109_sum.r := Math.add(x4107,x19620,Some(2.0), ensig0, Truncate, Wrapping, "x4109_sum").r
      val x4110_tuple = Wire(UInt(97.W)).suggestName("""x4110_tuple""")
      x4110_tuple.r := Cat(true.B,x4106_sum.r,x4109_sum.r)
      val x4111 = true.B
      val x19621 = Wire(Bool()).suggestName("x19621_x4111_D9") 
      x19621.r := getRetimed(x4111.r, 9.toInt, io.sigsIn.backpressure)
      x4083.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt.toInt, rr, io.sigsIn.backpressure) & x19621 & io.sigsIn.backpressure
      x4083.bits.addr := x4110_tuple(63,0)
      x4083.bits.size := x4110_tuple(95,64)
      val x19622 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19622_x4102_sum_D3") 
      x19622.r := getRetimed(x4102_sum.r, 3.toInt, io.sigsIn.backpressure)
      val x19623 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19623_x4100_D4") 
      x19623.r := getRetimed(x4100.r, 4.toInt, io.sigsIn.backpressure)
      val x4113_tuple = Wire(UInt(96.W)).suggestName("""x4113_tuple""")
      x4113_tuple.r := Cat(x19622.r,x19623.r,x4104_sum.r)
      val x4114_enq_x4084_banks = List[UInt]()
      val x4114_enq_x4084_ofs = List[UInt]()
      val x4114_enq_x4084_en = List[Bool](true.B)
      val x4114_enq_x4084_data = List[UInt](x4113_tuple.r)
      x4084_fifo.connectWPort(4114, x4114_enq_x4084_banks, x4114_enq_x4084_ofs, x4114_enq_x4084_data, x4114_enq_x4084_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(10.1.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x4084_fifo.connectAccessActivesIn(0, ((true.B)))
    }
    val module = Module(new x4115_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4115_inr_UnitPipe **/
