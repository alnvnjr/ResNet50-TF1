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

/** Hierarchy: x3209 -> x3210 -> x3211 -> x3898 -> x1256 **/
/** BEGIN None x3209_inr_Foreach **/
class x3209_inr_Foreach_kernel(
  list_b3137: List[FixedPoint],
  list_x3142: List[DecoupledIO[AppLoadData]],
  list_x3132_c101_SRAM_0: List[NBufInterface],
  list_x3172_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 23.0.toInt, myName = "x3209_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3209_inr_Foreach_iiCtr"))
  
  abstract class x3209_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3172_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3172_reg_p").asInstanceOf[MemParams] ))
      val in_b3137 = Input(new FixedPoint(true, 32, 0))
      val in_x3173_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3173_reg_p").asInstanceOf[MemParams] ))
      val in_x3142 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x3142_p").asInstanceOf[(Int, Int)] )))
      val in_b3136 = Input(new FixedPoint(true, 32, 0))
      val in_x3132_c101_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x3132_c101_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3172_reg = {io.in_x3172_reg} ; io.in_x3172_reg := DontCare
    def b3137 = {io.in_b3137} 
    def x3173_reg = {io.in_x3173_reg} ; io.in_x3173_reg := DontCare
    def x3142 = {io.in_x3142} 
    def b3136 = {io.in_b3136} 
    def x3132_c101_SRAM_0 = {io.in_x3132_c101_SRAM_0} ; io.in_x3132_c101_SRAM_0 := DontCare
  }
  def connectWires0(module: x3209_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x3172_reg.connectLedger(module.io.in_x3172_reg)
    module.io.in_b3137 <> b3137
    x3173_reg.connectLedger(module.io.in_x3173_reg)
    module.io.in_x3142 <> x3142
    module.io.in_b3136 <> b3136
    x3132_c101_SRAM_0.connectLedger(module.io.in_x3132_c101_SRAM_0)
  }
  val b3137 = list_b3137(0)
  val b3136 = list_b3137(1)
  val x3142 = list_x3142(0)
  val x3132_c101_SRAM_0 = list_x3132_c101_SRAM_0(0)
  val x3172_reg = list_x3172_reg(0)
  val x3173_reg = list_x3172_reg(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3209_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x3209_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3209_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b3187 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b3187.suggestName("b3187")
      val b3188 = ~io.sigsIn.cchainOutputs.head.oobs(0); b3188.suggestName("b3188")
      val x3189_rd_x3172 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3189_rd_x3172""")
      val x3189_rd_x3172_banks = List[UInt]()
      val x3189_rd_x3172_ofs = List[UInt]()
      val x3189_rd_x3172_en = List[Bool](true.B)
      x3189_rd_x3172.toSeq.zip(x3172_reg.connectRPort(3189, x3189_rd_x3172_banks, x3189_rd_x3172_ofs, io.sigsIn.backpressure, x3189_rd_x3172_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x3190 = Wire(Bool()).suggestName("""x3190""")
      x3190.r := Math.lte(x3189_rd_x3172, b3187, Some(0.4), true.B,"x3190").r
      val x3191_rd_x3173 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3191_rd_x3173""")
      val x3191_rd_x3173_banks = List[UInt]()
      val x3191_rd_x3173_ofs = List[UInt]()
      val x3191_rd_x3173_en = List[Bool](true.B)
      x3191_rd_x3173.toSeq.zip(x3173_reg.connectRPort(3191, x3191_rd_x3173_banks, x3191_rd_x3173_ofs, io.sigsIn.backpressure, x3191_rd_x3173_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x3192 = Wire(Bool()).suggestName("""x3192""")
      x3192.r := Math.lt(b3187, x3191_rd_x3173, Some(0.4), true.B,"x3192").r
      val x3193 = Wire(Bool()).suggestName("""x3193""")
      x3193 := x3190 & x3192
      val x3194_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3194_sub""")
      x3194_sub.r := Math.sub(b3187,x3189_rd_x3172,Some(1.0), true.B, Truncate, Wrapping, "x3194_sub").r
      val x3195 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x3195""")
      x3142.ready := b3188 & (io.sigsIn.datapathEn) 
      (0 until 1).map{ i => x3195(i).r := x3142.bits.rdata(i).r }
      val x19389 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("x19389_x3195_D1") 
      (0 until 1).foreach{i => x19389(i).r := getRetimed(x3195(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x3196_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3196_elem_0""")
      x3196_elem_0.r := x19389(0).r
      val x3199 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3199""")
      x3199.r := (Math.mod(x3194_sub, 49L.FP(true, 32, 0), Some(16.0), true.B, Truncate, Wrapping, "x3199")).r
      val x3201_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3201_div""")
      x3201_div.r := (Math.div(x3194_sub, 49L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x3201_div")).r
      val x18818 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18818""")
      x18818.r := Math.fma(b3136,3L.FP(true, 32, 0),b3137,Some(6.0), true.B, "x18818").toFixed(x18818, "cast_x18818").r
      val x19390 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19390_x18818_D15") 
      x19390.r := getRetimed(x18818.r, 15.toInt, io.sigsIn.backpressure)
      val x3203_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3203_sum""")
      x3203_sum.r := Math.add(x19390,x3201_div,Some(1.0), true.B, Truncate, Wrapping, "x3203_sum").r
      val x19391 = Wire(new FixedPoint(true, 32, 0)).suggestName("x19391_x3199_D5") 
      x19391.r := getRetimed(x3199.r, 5.toInt, io.sigsIn.backpressure)
      val x19392 = Wire(Bool()).suggestName("x19392_x3193_D22") 
      x19392.r := getRetimed(x3193.r, 22.toInt, io.sigsIn.backpressure)
      val x19393 = Wire(Bool()).suggestName("x19393_b3188_D22") 
      x19393.r := getRetimed(b3188.r, 22.toInt, io.sigsIn.backpressure)
      val x19394 = Wire(new FixedPoint(true, 10, 22)).suggestName("x19394_x3196_elem_0_D21") 
      x19394.r := getRetimed(x3196_elem_0.r, 21.toInt, io.sigsIn.backpressure)
      val x3208_wr_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r,x19391.r)
      val x3208_wr_ofs = List[UInt](x3203_sum.r)
      val x3208_wr_en = List[Bool](true.B)
      val x3208_wr_data = List[UInt](x19394.r)
      x3132_c101_SRAM_0.connectWPort(3208, x3208_wr_banks, x3208_wr_ofs, x3208_wr_data, x3208_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(22.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && x19392 & x19393))
    }
    val module = Module(new x3209_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x3209_inr_Foreach **/
