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

/** Hierarchy: x18611 -> x18620 -> x1256 **/
/** BEGIN None x18611_inr_Reduce **/
class x18611_inr_Reduce_kernel(
  list_b18502: List[Bool],
  list_x18550_prod_0: List[FixOpAccumBundle],
  list_x18503_c90_row_SRAM_0: List[NBufInterface],
  list_x18375_tmp75_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 21.2.toInt, myName = "x18611_inr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18611_inr_Reduce_iiCtr"))
  
  abstract class x18611_inr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18375_tmp75_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18375_tmp75_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x18550_prod_0 = Flipped(new FixOpAccumBundle(1, 10, 22))
      val in_x18503_c90_row_SRAM_0 = Flipped(new NBufInterface(ModuleParams.getParams("x18503_c90_row_SRAM_0_p").asInstanceOf[NBufParams] ))
      val in_x18551_prod_1 = Flipped(new NBufInterface(ModuleParams.getParams("x18551_prod_1_p").asInstanceOf[NBufParams] ))
      val in_b18502 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(4), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x18375_tmp75_SRAM_0 = {io.in_x18375_tmp75_SRAM_0} ; io.in_x18375_tmp75_SRAM_0 := DontCare
    def x18550_prod_0 = {io.in_x18550_prod_0} ; io.in_x18550_prod_0 := DontCare
    def x18503_c90_row_SRAM_0 = {io.in_x18503_c90_row_SRAM_0} ; io.in_x18503_c90_row_SRAM_0 := DontCare
    def x18551_prod_1 = {io.in_x18551_prod_1} ; io.in_x18551_prod_1 := DontCare
    def b18502 = {io.in_b18502} 
  }
  def connectWires0(module: x18611_inr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x18375_tmp75_SRAM_0.connectLedger(module.io.in_x18375_tmp75_SRAM_0)
    x18550_prod_0.connectLedger(module.io.in_x18550_prod_0)
    x18503_c90_row_SRAM_0.connectLedger(module.io.in_x18503_c90_row_SRAM_0)
    x18551_prod_1.connectLedger(module.io.in_x18551_prod_1)
    module.io.in_b18502 <> b18502
  }
  val b18502 = list_b18502(0)
  val x18550_prod_0 = list_x18550_prod_0(0)
  val x18503_c90_row_SRAM_0 = list_x18503_c90_row_SRAM_0(0)
  val x18551_prod_1 = list_x18503_c90_row_SRAM_0(1)
  val x18375_tmp75_SRAM_0 = list_x18375_tmp75_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18611_inr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x18611_inr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18611_inr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b18554 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b18554.suggestName("b18554")
      val b18555 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b18555.suggestName("b18555")
      val b18556 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b18556.suggestName("b18556")
      val b18557 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b18557.suggestName("b18557")
      val b18558 = ~io.sigsIn.cchainOutputs.head.oobs(0); b18558.suggestName("b18558")
      val b18559 = ~io.sigsIn.cchainOutputs.head.oobs(1); b18559.suggestName("b18559")
      val b18560 = ~io.sigsIn.cchainOutputs.head.oobs(2); b18560.suggestName("b18560")
      val b18561 = ~io.sigsIn.cchainOutputs.head.oobs(3); b18561.suggestName("b18561")
      val x18566 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18566""")
      x18566.r := Math.arith_right_shift(b18554, 2, Some(0.2), true.B,"x18566").r
      val x18569 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18569""")
      x18569.r := Math.arith_right_shift(b18555, 2, Some(0.2), true.B,"x18569").r
      val x18572 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18572""")
      x18572.r := Math.arith_right_shift(b18556, 2, Some(0.2), true.B,"x18572").r
      val x18575 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18575""")
      x18575.r := Math.arith_right_shift(b18557, 2, Some(0.2), true.B,"x18575").r
      val x18578_rd = Wire(Vec(4, new FixedPoint(true, 10, 22))).suggestName("""x18578_rd""")
      val x18578_rd_banks = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
      val x18578_rd_ofs = List[UInt](x18566.r,x18569.r,x18572.r,x18575.r)
      val x18578_rd_en = List[Bool](b18558,b18559,b18560,b18561)
      x18578_rd.toSeq.zip(x18375_tmp75_SRAM_0.connectRPort(18578, x18578_rd_banks, x18578_rd_ofs, io.sigsIn.backpressure, x18578_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && b18502), true)).foreach{case (a,b) => a := b}
      val x18579_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18579_elem_0""")
      x18579_elem_0.r := x18578_rd(0).r
      val x18580_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18580_elem_1""")
      x18580_elem_1.r := x18578_rd(1).r
      val x18581_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18581_elem_2""")
      x18581_elem_2.r := x18578_rd(2).r
      val x18582_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18582_elem_3""")
      x18582_elem_3.r := x18578_rd(3).r
      val x18583_rd = Wire(Vec(4, new FixedPoint(true, 10, 22))).suggestName("""x18583_rd""")
      val x18583_rd_banks = List[UInt](0L.FP(true, 32, 0).r,1L.FP(true, 32, 0).r,2L.FP(true, 32, 0).r,3L.FP(true, 32, 0).r)
      val x18583_rd_ofs = List[UInt](x18566.r,x18569.r,x18572.r,x18575.r)
      val x18583_rd_en = List[Bool](b18558,b18559,b18560,b18561)
      x18583_rd.toSeq.zip(x18503_c90_row_SRAM_0.connectRPort(18583, x18583_rd_banks, x18583_rd_ofs, io.sigsIn.backpressure, x18583_rd_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.2.toInt, rr, io.sigsIn.backpressure) && b18502), true)).foreach{case (a,b) => a := b}
      val x18584_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18584_elem_0""")
      x18584_elem_0.r := x18583_rd(0).r
      val x18585_elem_1 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18585_elem_1""")
      x18585_elem_1.r := x18583_rd(1).r
      val x18586_elem_2 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18586_elem_2""")
      x18586_elem_2.r := x18583_rd(2).r
      val x18587_elem_3 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18587_elem_3""")
      x18587_elem_3.r := x18583_rd(3).r
      val x18588_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18588_mul""")
      x18588_mul.r := (Math.mul(x18579_elem_0, x18584_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x18588_mul")).r
      val x18589_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18589_mul""")
      x18589_mul.r := (Math.mul(x18580_elem_1, x18585_elem_1, Some(6.0), true.B, Truncate, Wrapping, "x18589_mul")).r
      val x18590_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18590_mul""")
      x18590_mul.r := (Math.mul(x18581_elem_2, x18586_elem_2, Some(6.0), true.B, Truncate, Wrapping, "x18590_mul")).r
      val x18591_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18591_mul""")
      x18591_mul.r := (Math.mul(x18582_elem_3, x18587_elem_3, Some(6.0), true.B, Truncate, Wrapping, "x18591_mul")).r
      val x18593 = Wire(Bool()).suggestName("""x18593""")
      x18593 := b18559 & b18502
      val x18594 = Wire(Bool()).suggestName("""x18594""")
      x18594 := b18560 & b18502
      val x18595 = Wire(Bool()).suggestName("""x18595""")
      x18595 := b18561 & b18502
      val x22009 = Wire(new FixedPoint(true, 10, 22)).suggestName("x22009_x18579_elem_0_D6") 
      x22009.r := getRetimed(x18579_elem_0.r, 6.toInt, io.sigsIn.backpressure)
      val x22010 = Wire(new FixedPoint(true, 10, 22)).suggestName("x22010_x18584_elem_0_D6") 
      x22010.r := getRetimed(x18584_elem_0.r, 6.toInt, io.sigsIn.backpressure)
      val x19372 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19372""")
      x19372.r := Math.fma(x22009,x22010,x18589_mul,Some(6.0), true.B, "x19372").toFixed(x19372, "cast_x19372").r
      val x22011 = Wire(new FixedPoint(true, 10, 22)).suggestName("x22011_x18588_mul_D6") 
      x22011.r := getRetimed(x18588_mul.r, 6.toInt, io.sigsIn.backpressure)
      val x22012 = Wire(Bool()).suggestName("x22012_x18593_D14") 
      x22012.r := getRetimed(x18593.r, 14.toInt, io.sigsIn.backpressure)
      val x18597 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18597""")
      x18597.r := Mux((x22012), x19372.r, x22011.r)
      val x22013 = Wire(new FixedPoint(true, 10, 22)).suggestName("x22013_x18581_elem_2_D6") 
      x22013.r := getRetimed(x18581_elem_2.r, 6.toInt, io.sigsIn.backpressure)
      val x22014 = Wire(new FixedPoint(true, 10, 22)).suggestName("x22014_x18586_elem_2_D6") 
      x22014.r := getRetimed(x18586_elem_2.r, 6.toInt, io.sigsIn.backpressure)
      val x19373 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19373""")
      x19373.r := Math.fma(x22013,x22014,x18591_mul,Some(6.0), true.B, "x19373").toFixed(x19373, "cast_x19373").r
      val x22015 = Wire(new FixedPoint(true, 10, 22)).suggestName("x22015_x18590_mul_D6") 
      x22015.r := getRetimed(x18590_mul.r, 6.toInt, io.sigsIn.backpressure)
      val x22016 = Wire(Bool()).suggestName("x22016_x18595_D14") 
      x22016.r := getRetimed(x18595.r, 14.toInt, io.sigsIn.backpressure)
      val x18600 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18600""")
      x18600.r := Mux((x22016), x19373.r, x22015.r)
      val x18601 = Wire(Bool()).suggestName("""x18601""")
      x18601 := x18594 | x18595
      val x18602_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18602_sum""")
      x18602_sum.r := Math.add(x18597,x18600,Some(1.0), true.B, Truncate, Wrapping, "x18602_sum").r
      val x22017 = Wire(Bool()).suggestName("x22017_x18601_D15") 
      x22017.r := getRetimed(x18601.r, 15.toInt, io.sigsIn.backpressure)
      val x22018 = Wire(new FixedPoint(true, 10, 22)).suggestName("x22018_x18597_D1") 
      x22018.r := getRetimed(x18597.r, 1.toInt, io.sigsIn.backpressure)
      val x18603 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x18603""")
      x18603.r := Mux((x22017), x18602_sum.r, x22018.r)
      val x18606 = Wire(Bool()).suggestName("""x18606""")
      x18606.r := Math.eql(b18554, 0L.FP(true, 32, 0), Some(0.2), true.B,"x18606").r
      val x22019 = Wire(Bool()).suggestName("x22019_x18606_D16") 
      x22019.r := getRetimed(x18606.r, 16.toInt, io.sigsIn.backpressure)
      val x22020 = Wire(new FixedPoint(true, 10, 22)).suggestName("x22020_x18603_D1") 
      x22020.r := getRetimed(x18603.r, 1.toInt, io.sigsIn.backpressure)
      x18550_prod_0.connectWPort(0, x22020.r, true.B && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(16.2.toInt, rr, io.sigsIn.backpressure), (io.sigsIn.ctrDone).DS(16.2.toInt, rr, io.sigsIn.backpressure), x22019)
      val x19375 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x19375""")
      x19375.r := x18550_prod_0.output
      val x18610_wr_x18551_banks = List[UInt]()
      val x18610_wr_x18551_ofs = List[UInt]()
      val x18610_wr_x18551_en = List[Bool](true.B)
      val x18610_wr_x18551_data = List[UInt](x19375.r)
      x18551_prod_1.connectWPort(18610, x18610_wr_x18551_banks, x18610_wr_x18551_ofs, x18610_wr_x18551_data, x18610_wr_x18551_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(20.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x18503_c90_row_SRAM_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
      x18551_prod_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x18611_inr_Reduce_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledReduce x18611_inr_Reduce **/
