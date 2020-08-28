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

/** Hierarchy: x9435 -> x9454 -> x9459 -> x9460 -> x9461 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9435_inr_UnitPipe **/
class x9435_inr_UnitPipe_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x9399: List[DecoupledIO[AppCommandDense]],
  list_x9404_reg: List[StandardInterface],
  list_x9388_reg: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 11.1.toInt, myName = "x9435_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9435_inr_UnitPipe_iiCtr"))
  
  abstract class x9435_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9388_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9388_reg_p").asInstanceOf[NBufParams] ))
      val in_x9404_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9404_reg_p").asInstanceOf[MemParams] ))
      val in_x3945_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3945_reg_p").asInstanceOf[MemParams] ))
      val in_x9403_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9403_reg_p").asInstanceOf[MemParams] ))
      val in_x9389_reg = Flipped(new NBufInterface(ModuleParams.getParams("x9389_reg_p").asInstanceOf[NBufParams] ))
      val in_x9402_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9402_reg_p").asInstanceOf[MemParams] ))
      val in_x9399 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9399_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x9388_reg = {io.in_x9388_reg} ; io.in_x9388_reg := DontCare
    def x9404_reg = {io.in_x9404_reg} ; io.in_x9404_reg := DontCare
    def x3945_reg = {io.in_x3945_reg} ; io.in_x3945_reg := DontCare
    def x9403_reg = {io.in_x9403_reg} ; io.in_x9403_reg := DontCare
    def x9389_reg = {io.in_x9389_reg} ; io.in_x9389_reg := DontCare
    def x9402_reg = {io.in_x9402_reg} ; io.in_x9402_reg := DontCare
    def x9399 = {io.in_x9399} 
  }
  def connectWires0(module: x9435_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x9388_reg.connectLedger(module.io.in_x9388_reg)
    x9404_reg.connectLedger(module.io.in_x9404_reg)
    x3945_reg.connectLedger(module.io.in_x3945_reg)
    x9403_reg.connectLedger(module.io.in_x9403_reg)
    x9389_reg.connectLedger(module.io.in_x9389_reg)
    x9402_reg.connectLedger(module.io.in_x9402_reg)
    module.io.in_x9399 <> x9399
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x9399 = list_x9399(0)
  val x9404_reg = list_x9404_reg(0)
  val x3945_reg = list_x9404_reg(1)
  val x9403_reg = list_x9404_reg(2)
  val x9402_reg = list_x9404_reg(3)
  val x9388_reg = list_x9388_reg(0)
  val x9389_reg = list_x9388_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9435_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9435_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9435_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9405_rd_x3945 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9405_rd_x3945""")
      val x9405_rd_x3945_banks = List[UInt]()
      val x9405_rd_x3945_ofs = List[UInt]()
      val x9405_rd_x3945_en = List[Bool](true.B)
      x9405_rd_x3945.toSeq.zip(x3945_reg.connectRPort(9405, x9405_rd_x3945_banks, x9405_rd_x3945_ofs, io.sigsIn.backpressure, x9405_rd_x3945_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9407_rd_x9388 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9407_rd_x9388""")
      val x9407_rd_x9388_banks = List[UInt]()
      val x9407_rd_x9388_ofs = List[UInt]()
      val x9407_rd_x9388_en = List[Bool](true.B)
      x9407_rd_x9388.toSeq.zip(x9388_reg.connectRPort(9407, x9407_rd_x9388_banks, x9407_rd_x9388_ofs, io.sigsIn.backpressure, x9407_rd_x9388_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19055 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19055""")
      val ensig0 = Wire(Bool())
      ensig0 := x9399.ready
      x19055.r := Math.fma(x9405_rd_x3945,802816L.FP(true, 32, 0),x9407_rd_x9388,Some(6.0), ensig0, "x19055").toFixed(x19055, "cast_x19055").r
      val x9409 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9409""")
      x9409.r := Math.arith_left_shift(x19055, 2, Some(0.2), ensig0,"x9409").r
      val x19056 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19056""")
      x19056.r := Math.and(x9409,63L.FP(true, 32, 0),Some(0.2), ensig0,"x19056").r
      val x9411_rd_x9389 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9411_rd_x9389""")
      val x9411_rd_x9389_banks = List[UInt]()
      val x9411_rd_x9389_ofs = List[UInt]()
      val x9411_rd_x9389_en = List[Bool](true.B)
      x9411_rd_x9389.toSeq.zip(x9389_reg.connectRPort(9411, x9411_rd_x9389_banks, x9411_rd_x9389_ofs, io.sigsIn.backpressure, x9411_rd_x9389_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9412 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9412""")
      x9412.r := Math.arith_left_shift(x9411_rd_x9389, 2, Some(0.2), ensig0,"x9412").r
      val x9413_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9413_sub""")
      x9413_sub.r := Math.sub(x9409,x19056,Some(1.0), ensig0, Truncate, Wrapping, "x9413_sub").r
      val x20618 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20618_x9412_D6") 
      x20618.r := getRetimed(x9412.r, 6.toInt, io.sigsIn.backpressure)
      val x9414_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9414_sum""")
      x9414_sum.r := Math.add(x9409,x20618,Some(1.0), ensig0, Truncate, Wrapping, "x9414_sum").r
      val x19057 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19057""")
      x19057.r := Math.and(x9414_sum,63L.FP(true, 32, 0),Some(0.2), ensig0,"x19057").r
      val x9416 = Wire(Bool()).suggestName("""x9416""")
      x9416.r := Math.eql(x19057, 0L.FP(true, 32, 0), Some(0.2), ensig0,"x9416").r
      val x9417_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9417_sub""")
      x9417_sub.r := Math.sub(64L.FP(true, 32, 0),x19057,Some(1.0), ensig0, Truncate, Wrapping, "x9417_sub").r
      val x20619 = Wire(Bool()).suggestName("x20619_x9416_D1") 
      x20619.r := getRetimed(x9416.r, 1.toInt, io.sigsIn.backpressure)
      val x9418 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9418""")
      x9418.r := Mux((x20619), 0L.FP(true, 32, 0).r, x9417_sub.r)
      val x9419 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9419""")
      x9419.r := Math.arith_right_shift(x19056, 2, Some(0.2), ensig0,"x9419").r
      val x9420 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9420""")
      x9420.r := Math.arith_right_shift(x9418, 2, Some(0.2 + 1.0), ensig0,"x9420").r
      val x20620 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20620_x9411_rd_x9389_D6") 
      x20620.r := getRetimed(x9411_rd_x9389.r, 6.toInt, io.sigsIn.backpressure)
      val x9421_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9421_sum""")
      x9421_sum.r := Math.add(x9419,x20620,Some(1.0), ensig0, Truncate, Wrapping, "x9421_sum").r
      val x9422_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9422_sum""")
      x9422_sum.r := Math.add(x20620,x9419,Some(1.0), ensig0, Truncate, Wrapping, "x9422_sum").r
      val x20621 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20621_x9422_sum_D2") 
      x20621.r := getRetimed(x9422_sum.r, 2.toInt, io.sigsIn.backpressure)
      val x20622 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20622_x9420_D1") 
      x20622.r := getRetimed(x9420.r, 1.toInt, io.sigsIn.backpressure)
      val x9423_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9423_sum""")
      x9423_sum.r := Math.add(x20621,x20622,Some(1.0), ensig0, Truncate, Wrapping, "x9423_sum").r
      val x9424_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9424_sum""")
      x9424_sum.r := Math.add(x20618,x19056,Some(1.0), ensig0, Truncate, Wrapping, "x9424_sum").r
      val x20623 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20623_x9424_sum_D1") 
      x20623.r := getRetimed(x9424_sum.r, 1.toInt, io.sigsIn.backpressure)
      val x9425_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9425_sum""")
      x9425_sum.r := Math.add(x20623,x9418,Some(1.0), ensig0, Truncate, Wrapping, "x9425_sum").r
      val x9426 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x9426""")
      x9426.r := Math.fix2fix(x9413_sub, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x9426").r
      val x9427 = x2682_tmp_DRAM
      val x20624 = Wire(new FixedPoint(true, 64, 0)).suggestName("x20624_x9427_D7") 
      x20624.r := getRetimed(x9427.r, 7.toInt, io.sigsIn.backpressure)
      val x9428_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x9428_sum""")
      x9428_sum.r := Math.add(x9426,x20624,Some(2.0), ensig0, Truncate, Wrapping, "x9428_sum").r
      val x9429_tuple = Wire(UInt(97.W)).suggestName("""x9429_tuple""")
      x9429_tuple.r := Cat(false.B,x9425_sum.r,x9428_sum.r)
      val x9430 = true.B
      val x20625 = Wire(Bool()).suggestName("x20625_x9430_D9") 
      x20625.r := getRetimed(x9430.r, 9.toInt, io.sigsIn.backpressure)
      x9399.valid := (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(9.9.toInt.toInt, rr, io.sigsIn.backpressure) & x20625 & io.sigsIn.backpressure
      x9399.bits.addr := x9429_tuple(63,0)
      x9399.bits.size := x9429_tuple(95,64)
      val x9432_wr_x9402_banks = List[UInt]()
      val x9432_wr_x9402_ofs = List[UInt]()
      val x9432_wr_x9402_en = List[Bool](true.B)
      val x9432_wr_x9402_data = List[UInt](x9419.r)
      x9402_reg.connectWPort(9432, x9432_wr_x9402_banks, x9432_wr_x9402_ofs, x9432_wr_x9402_data, x9432_wr_x9402_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(6.6.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x9433_wr_x9403_banks = List[UInt]()
      val x9433_wr_x9403_ofs = List[UInt]()
      val x9433_wr_x9403_en = List[Bool](true.B)
      val x9433_wr_x9403_data = List[UInt](x9421_sum.r)
      x9403_reg.connectWPort(9433, x9433_wr_x9403_banks, x9433_wr_x9403_ofs, x9433_wr_x9403_data, x9433_wr_x9403_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.6.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x9434_wr_x9404_banks = List[UInt]()
      val x9434_wr_x9404_ofs = List[UInt]()
      val x9434_wr_x9404_en = List[Bool](true.B)
      val x9434_wr_x9404_data = List[UInt](x9423_sum.r)
      x9404_reg.connectWPort(9434, x9434_wr_x9404_banks, x9434_wr_x9404_ofs, x9434_wr_x9404_data, x9434_wr_x9404_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(10.1.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x9435_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9435_inr_UnitPipe **/
