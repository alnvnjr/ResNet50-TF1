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

/** Hierarchy: x9387 -> x9461 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9387_inr_Foreach **/
class x9387_inr_Foreach_kernel(
  list_x18782_rd_x3918: List[Bool],
  list_b4059: List[FixedPoint],
  list_x3919_reg: List[StandardInterface],
  list_x4062_out_SRAM_conv_1: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 11.9.toInt, myName = "x9387_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9387_inr_Foreach_iiCtr"))
  
  abstract class x9387_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4062_out_SRAM_conv_1 = Flipped(new NBufInterface(ModuleParams.getParams("x4062_out_SRAM_conv_1_p").asInstanceOf[NBufParams] ))
      val in_x18782_rd_x3918 = Input(Bool())
      val in_x3919_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3919_reg_p").asInstanceOf[MemParams] ))
      val in_b4059 = Input(new FixedPoint(true, 32, 0))
      val in_x3941_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3941_reg_p").asInstanceOf[MemParams] ))
      val in_b9348 = Input(new FixedPoint(true, 32, 0))
      val in_b4060 = Input(Bool())
      val in_b9349 = Input(Bool())
      val in_x9350_out_SRAM_bias_0 = Flipped(new NBufInterface(ModuleParams.getParams("x9350_out_SRAM_bias_0_p").asInstanceOf[NBufParams] ))
      val in_x3992_bias_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3992_bias_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1, 1), List(32, 32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x4062_out_SRAM_conv_1 = {io.in_x4062_out_SRAM_conv_1} ; io.in_x4062_out_SRAM_conv_1 := DontCare
    def x18782_rd_x3918 = {io.in_x18782_rd_x3918} 
    def x3919_reg = {io.in_x3919_reg} ; io.in_x3919_reg := DontCare
    def b4059 = {io.in_b4059} 
    def x3941_reg = {io.in_x3941_reg} ; io.in_x3941_reg := DontCare
    def b9348 = {io.in_b9348} 
    def b4060 = {io.in_b4060} 
    def b9349 = {io.in_b9349} 
    def x9350_out_SRAM_bias_0 = {io.in_x9350_out_SRAM_bias_0} ; io.in_x9350_out_SRAM_bias_0 := DontCare
    def x3992_bias_SRAM_0 = {io.in_x3992_bias_SRAM_0} ; io.in_x3992_bias_SRAM_0 := DontCare
  }
  def connectWires0(module: x9387_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x4062_out_SRAM_conv_1.connectLedger(module.io.in_x4062_out_SRAM_conv_1)
    module.io.in_x18782_rd_x3918 <> x18782_rd_x3918
    x3919_reg.connectLedger(module.io.in_x3919_reg)
    module.io.in_b4059 <> b4059
    x3941_reg.connectLedger(module.io.in_x3941_reg)
    module.io.in_b9348 <> b9348
    module.io.in_b4060 <> b4060
    module.io.in_b9349 <> b9349
    x9350_out_SRAM_bias_0.connectLedger(module.io.in_x9350_out_SRAM_bias_0)
    x3992_bias_SRAM_0.connectLedger(module.io.in_x3992_bias_SRAM_0)
  }
  val x18782_rd_x3918 = list_x18782_rd_x3918(0)
  val b4060 = list_x18782_rd_x3918(1)
  val b9349 = list_x18782_rd_x3918(2)
  val b4059 = list_b4059(0)
  val b9348 = list_b4059(1)
  val x3919_reg = list_x3919_reg(0)
  val x3941_reg = list_x3919_reg(1)
  val x3992_bias_SRAM_0 = list_x3919_reg(2)
  val x4062_out_SRAM_conv_1 = list_x4062_out_SRAM_conv_1(0)
  val x9350_out_SRAM_bias_0 = list_x4062_out_SRAM_conv_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9387_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x9387_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9387_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b9357 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b9357.suggestName("b9357")
      val b9358 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b9358.suggestName("b9358")
      val b9359 = ~io.sigsIn.cchainOutputs.head.oobs(0); b9359.suggestName("b9359")
      val b9360 = ~io.sigsIn.cchainOutputs.head.oobs(1); b9360.suggestName("b9360")
      val x9361_rd_x3919 = Wire(Bool()).suggestName("""x9361_rd_x3919""")
      val x9361_rd_x3919_banks = List[UInt]()
      val x9361_rd_x3919_ofs = List[UInt]()
      val x9361_rd_x3919_en = List[Bool](true.B)
      x9361_rd_x3919.toSeq.zip(x3919_reg.connectRPort(9361, x9361_rd_x3919_banks, x9361_rd_x3919_ofs, io.sigsIn.backpressure, x9361_rd_x3919_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19052 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19052""")
      x19052.r := Math.and(b9348,31L.FP(true, 32, 0),Some(0.2), true.B,"x19052").r
      val x9364 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9364""")
      x9364.r := Math.arith_right_shift(b9348, 5, Some(0.2), true.B,"x9364").r
      val x19053 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19053""")
      x19053.r := Math.fma(b9357,56L.FP(true, 32, 0),b9358,Some(6.0), true.B, "x19053").toFixed(x19053, "cast_x19053").r
      val x20596 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20596_x9364_D6") 
      x20596.r := getRetimed(x9364.r, 6.toInt, io.sigsIn.backpressure)
      val x9366_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9366_sum""")
      x9366_sum.r := Math.add(x19053,x20596,Some(1.0), true.B, Truncate, Wrapping, "x9366_sum").r
      val x20597 = Wire(Bool()).suggestName("x20597_b9360_D7") 
      x20597.r := getRetimed(b9360.r, 7.toInt, io.sigsIn.backpressure)
      val x20598 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20598_x19052_D7") 
      x20598.r := getRetimed(x19052.r, 7.toInt, io.sigsIn.backpressure)
      val x20599 = Wire(Bool()).suggestName("x20599_b9359_D7") 
      x20599.r := getRetimed(b9359.r, 7.toInt, io.sigsIn.backpressure)
      val x20600 = Wire(Bool()).suggestName("x20600_b4060_D7") 
      x20600.r := getRetimed(b4060.r, 7.toInt, io.sigsIn.backpressure)
      val x20601 = Wire(Bool()).suggestName("x20601_b9349_D7") 
      x20601.r := getRetimed(b9349.r, 7.toInt, io.sigsIn.backpressure)
      val x20602 = Wire(Bool()).suggestName("x20602_x9361_rd_x3919_D7") 
      x20602.r := getRetimed(x9361_rd_x3919.r, 7.toInt, io.sigsIn.backpressure)
      val x9371_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x9371_rd""")
      val x9371_rd_banks = List[UInt](x20598.r)
      val x9371_rd_ofs = List[UInt](x9366_sum.r)
      val x9371_rd_en = List[Bool](true.B)
      x9371_rd.toSeq.zip(x4062_out_SRAM_conv_1.connectRPort(9371, x9371_rd_banks, x9371_rd_ofs, io.sigsIn.backpressure, x9371_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.0.toInt, rr, io.sigsIn.backpressure) && x20597 & x20601 & x20602 & x20600 & x20599), true)).foreach{case (a,b) => a := b}
      val x9372_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9372_elem_0""")
      x9372_elem_0.r := x9371_rd(0).r
      val x9373_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9373_sum""")
      x9373_sum.r := Math.add(b4059,b9348,Some(1.0), true.B, Truncate, Wrapping, "x9373_sum").r
      val x20603 = Wire(Bool()).suggestName("x20603_b9360_D1") 
      x20603.r := getRetimed(b9360.r, 1.toInt, io.sigsIn.backpressure)
      val x20604 = Wire(Bool()).suggestName("x20604_b9359_D1") 
      x20604.r := getRetimed(b9359.r, 1.toInt, io.sigsIn.backpressure)
      val x20605 = Wire(Bool()).suggestName("x20605_b4060_D1") 
      x20605.r := getRetimed(b4060.r, 1.toInt, io.sigsIn.backpressure)
      val x20606 = Wire(Bool()).suggestName("x20606_b9349_D1") 
      x20606.r := getRetimed(b9349.r, 1.toInt, io.sigsIn.backpressure)
      val x20607 = Wire(Bool()).suggestName("x20607_x9361_rd_x3919_D1") 
      x20607.r := getRetimed(x9361_rd_x3919.r, 1.toInt, io.sigsIn.backpressure)
      val x9376_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x9376_rd""")
      val x9376_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x9376_rd_ofs = List[UInt](x9373_sum.r)
      val x9376_rd_en = List[Bool](true.B)
      x9376_rd.toSeq.zip(x3992_bias_SRAM_0.connectRPort(9376, x9376_rd_banks, x9376_rd_ofs, io.sigsIn.backpressure, x9376_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) && x20603 & x20607 & x20604 & x20605 & x20606), true)).foreach{case (a,b) => a := b}
      val x9377_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9377_elem_0""")
      x9377_elem_0.r := x9376_rd(0).r
      val x20608 = Wire(new FixedPoint(true, 10, 22)).suggestName("x20608_x9377_elem_0_D6") 
      x20608.r := getRetimed(x9377_elem_0.r, 6.toInt, io.sigsIn.backpressure)
      val x9378_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9378_sum""")
      x9378_sum.r := Math.add(x9372_elem_0,x20608,Some(1.0), true.B, Truncate, Wrapping, "x9378_sum").r
      val x9379_rd_x3941 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x9379_rd_x3941""")
      val x9379_rd_x3941_banks = List[UInt]()
      val x9379_rd_x3941_ofs = List[UInt]()
      val x9379_rd_x3941_en = List[Bool](true.B)
      x9379_rd_x3941.toSeq.zip(x3941_reg.connectRPort(9379, x9379_rd_x3941_banks, x9379_rd_x3941_ofs, io.sigsIn.backpressure, x9379_rd_x3941_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19054 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x19054""")
      x19054.r := Math.fma(b9357,x9379_rd_x3941,b9358,Some(6.0), true.B, "x19054").toFixed(x19054, "cast_x19054").r
      val x9382 = Wire(Bool()).suggestName("""x9382""")
      x9382.r := Math.lt(x9378_sum, 0.FP(true, 10, 22), Some(0.4), true.B,"x9382").r
      val x9383 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x9383""")
      x9383.r := Mux((x9382), 0.FP(true, 10, 22).r, x9378_sum.r)
      val x20609 = Wire(Bool()).suggestName("x20609_b9360_D10") 
      x20609.r := getRetimed(b9360.r, 10.toInt, io.sigsIn.backpressure)
      val x20610 = Wire(Bool()).suggestName("x20610_b9359_D10") 
      x20610.r := getRetimed(b9359.r, 10.toInt, io.sigsIn.backpressure)
      val x20611 = Wire(Bool()).suggestName("x20611_b4060_D10") 
      x20611.r := getRetimed(b4060.r, 10.toInt, io.sigsIn.backpressure)
      val x20612 = Wire(Bool()).suggestName("x20612_b9349_D10") 
      x20612.r := getRetimed(b9349.r, 10.toInt, io.sigsIn.backpressure)
      val x20613 = Wire(new FixedPoint(true, 32, 0)).suggestName("x20613_x19054_D4") 
      x20613.r := getRetimed(x19054.r, 4.toInt, io.sigsIn.backpressure)
      val x20614 = Wire(Bool()).suggestName("x20614_x9361_rd_x3919_D10") 
      x20614.r := getRetimed(x9361_rd_x3919.r, 10.toInt, io.sigsIn.backpressure)
      val x9386_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x9386_wr_ofs = List[UInt](x20613.r)
      val x9386_wr_en = List[Bool](true.B)
      val x9386_wr_data = List[UInt](x9383.r)
      x9350_out_SRAM_bias_0.connectWPort(9386, x9386_wr_banks, x9386_wr_ofs, x9386_wr_data, x9386_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(10.9.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x20610 & x20612 & x20611 & x20609 & x20614))
      x9350_out_SRAM_bias_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x9387_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x9387_inr_Foreach **/
