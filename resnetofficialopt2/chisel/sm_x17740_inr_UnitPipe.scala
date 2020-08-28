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

/** Hierarchy: x17740 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17740_inr_UnitPipe **/
class x17740_inr_UnitPipe_kernel(
  list_b3916: List[FixedPoint],
  list_x3902_in2D_args_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 8.0.toInt, myName = "x17740_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17740_inr_UnitPipe_iiCtr"))
  
  abstract class x17740_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3902_in2D_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3902_in2D_args_0_p").asInstanceOf[MemParams] ))
      val in_x17719_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17719_reg_p").asInstanceOf[MemParams] ))
      val in_x3906_load_idx_0_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3906_load_idx_0_args_0_p").asInstanceOf[MemParams] ))
      val in_b3916 = Input(new FixedPoint(true, 32, 0))
      val in_x17720_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17720_reg_p").asInstanceOf[MemParams] ))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x3903_in_channels_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3903_in_channels_args_0_p").asInstanceOf[MemParams] ))
      val in_x17716_load_idx_1_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x17716_load_idx_1_args_0_p").asInstanceOf[MemParams] ))
      val in_x9467_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9467_reg_p").asInstanceOf[MemParams] ))
      val in_x17717_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17717_reg_p").asInstanceOf[MemParams] ))
      val in_x3907_store_idx_args_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3907_store_idx_args_0_p").asInstanceOf[MemParams] ))
      val in_x17718_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17718_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3902_in2D_args_0 = {io.in_x3902_in2D_args_0} ; io.in_x3902_in2D_args_0 := DontCare
    def x17719_reg = {io.in_x17719_reg} ; io.in_x17719_reg := DontCare
    def x3906_load_idx_0_args_0 = {io.in_x3906_load_idx_0_args_0} ; io.in_x3906_load_idx_0_args_0 := DontCare
    def b3916 = {io.in_b3916} 
    def x17720_reg = {io.in_x17720_reg} ; io.in_x17720_reg := DontCare
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x3903_in_channels_args_0 = {io.in_x3903_in_channels_args_0} ; io.in_x3903_in_channels_args_0 := DontCare
    def x17716_load_idx_1_args_0 = {io.in_x17716_load_idx_1_args_0} ; io.in_x17716_load_idx_1_args_0 := DontCare
    def x9467_reg = {io.in_x9467_reg} ; io.in_x9467_reg := DontCare
    def x17717_reg = {io.in_x17717_reg} ; io.in_x17717_reg := DontCare
    def x3907_store_idx_args_0 = {io.in_x3907_store_idx_args_0} ; io.in_x3907_store_idx_args_0 := DontCare
    def x17718_reg = {io.in_x17718_reg} ; io.in_x17718_reg := DontCare
  }
  def connectWires0(module: x17740_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3902_in2D_args_0.connectLedger(module.io.in_x3902_in2D_args_0)
    x17719_reg.connectLedger(module.io.in_x17719_reg)
    x3906_load_idx_0_args_0.connectLedger(module.io.in_x3906_load_idx_0_args_0)
    module.io.in_b3916 <> b3916
    x17720_reg.connectLedger(module.io.in_x17720_reg)
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    x3903_in_channels_args_0.connectLedger(module.io.in_x3903_in_channels_args_0)
    x17716_load_idx_1_args_0.connectLedger(module.io.in_x17716_load_idx_1_args_0)
    x9467_reg.connectLedger(module.io.in_x9467_reg)
    x17717_reg.connectLedger(module.io.in_x17717_reg)
    x3907_store_idx_args_0.connectLedger(module.io.in_x3907_store_idx_args_0)
    x17718_reg.connectLedger(module.io.in_x17718_reg)
  }
  val b3916 = list_b3916(0)
  val x3902_in2D_args_0 = list_x3902_in2D_args_0(0)
  val x17719_reg = list_x3902_in2D_args_0(1)
  val x3906_load_idx_0_args_0 = list_x3902_in2D_args_0(2)
  val x17720_reg = list_x3902_in2D_args_0(3)
  val x3920_reg = list_x3902_in2D_args_0(4)
  val x3903_in_channels_args_0 = list_x3902_in2D_args_0(5)
  val x17716_load_idx_1_args_0 = list_x3902_in2D_args_0(6)
  val x9467_reg = list_x3902_in2D_args_0(7)
  val x17717_reg = list_x3902_in2D_args_0(8)
  val x3907_store_idx_args_0 = list_x3902_in2D_args_0(9)
  val x17718_reg = list_x3902_in2D_args_0(10)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17740_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x17740_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17740_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x17721_rd_x9467 = Wire(Bool()).suggestName("""x17721_rd_x9467""")
      val x17721_rd_x9467_banks = List[UInt]()
      val x17721_rd_x9467_ofs = List[UInt]()
      val x17721_rd_x9467_en = List[Bool](true.B)
      x17721_rd_x9467.toSeq.zip(x9467_reg.connectRPort(17721, x17721_rd_x9467_banks, x17721_rd_x9467_ofs, io.sigsIn.backpressure, x17721_rd_x9467_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17722_rd_x3920 = Wire(Bool()).suggestName("""x17722_rd_x3920""")
      val x17722_rd_x3920_banks = List[UInt]()
      val x17722_rd_x3920_ofs = List[UInt]()
      val x17722_rd_x3920_en = List[Bool](true.B)
      x17722_rd_x3920.toSeq.zip(x3920_reg.connectRPort(17722, x17722_rd_x3920_banks, x17722_rd_x3920_ofs, io.sigsIn.backpressure, x17722_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17725 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x17725""")
      val x17725_banks = List[UInt](b3916.r)
      val x17725_ofs = List[UInt](b3916.r)
      val x17725_en = List[Bool](true.B)
      x17725.toSeq.zip(x3902_in2D_args_0.connectRPort(17725, x17725_banks, x17725_ofs, io.sigsIn.backpressure, x17725_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x17722_rd_x3920 & x17721_rd_x9467), true)).foreach{case (a,b) => a := b}
      val x21855 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x21855_x17725_D1") 
      (0 until 1).foreach{i => x21855(i).r := getRetimed(x17725(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x17726_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17726_elem_0""")
      x17726_elem_0.r := x21855(0).r
      val x17727 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x17727""")
      val x17727_banks = List[UInt](b3916.r)
      val x17727_ofs = List[UInt](b3916.r)
      val x17727_en = List[Bool](true.B)
      x17727.toSeq.zip(x3903_in_channels_args_0.connectRPort(17727, x17727_banks, x17727_ofs, io.sigsIn.backpressure, x17727_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x17722_rd_x3920 & x17721_rd_x9467), true)).foreach{case (a,b) => a := b}
      val x21856 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x21856_x17727_D1") 
      (0 until 1).foreach{i => x21856(i).r := getRetimed(x17727(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x17728_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17728_elem_0""")
      x17728_elem_0.r := x21856(0).r
      val x17729 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x17729""")
      val x17729_banks = List[UInt](b3916.r)
      val x17729_ofs = List[UInt](b3916.r)
      val x17729_en = List[Bool](true.B)
      x17729.toSeq.zip(x3906_load_idx_0_args_0.connectRPort(17729, x17729_banks, x17729_ofs, io.sigsIn.backpressure, x17729_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x17722_rd_x3920 & x17721_rd_x9467), true)).foreach{case (a,b) => a := b}
      val x21857 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x21857_x17729_D1") 
      (0 until 1).foreach{i => x21857(i).r := getRetimed(x17729(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x17730_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17730_elem_0""")
      x17730_elem_0.r := x21857(0).r
      val x17731 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x17731""")
      val x17731_banks = List[UInt](b3916.r)
      val x17731_ofs = List[UInt](b3916.r)
      val x17731_en = List[Bool](true.B)
      x17731.toSeq.zip(x17716_load_idx_1_args_0.connectRPort(17731, x17731_banks, x17731_ofs, io.sigsIn.backpressure, x17731_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x17722_rd_x3920 & x17721_rd_x9467), true)).foreach{case (a,b) => a := b}
      val x21858 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x21858_x17731_D1") 
      (0 until 1).foreach{i => x21858(i).r := getRetimed(x17731(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x17732_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17732_elem_0""")
      x17732_elem_0.r := x21858(0).r
      val x17733 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("""x17733""")
      val x17733_banks = List[UInt](b3916.r)
      val x17733_ofs = List[UInt](b3916.r)
      val x17733_en = List[Bool](true.B)
      x17733.toSeq.zip(x3907_store_idx_args_0.connectRPort(17733, x17733_banks, x17733_ofs, io.sigsIn.backpressure, x17733_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x17722_rd_x3920 & x17721_rd_x9467), true)).foreach{case (a,b) => a := b}
      val x21859 = Wire(Vec(1, new FixedPoint(true, 32, 0))).suggestName("x21859_x17733_D1") 
      (0 until 1).foreach{i => x21859(i).r := getRetimed(x17733(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x17734_elem_0 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17734_elem_0""")
      x17734_elem_0.r := x21859(0).r
      val x17735_mul = Wire(new FixedPoint(true, 32, 0)).suggestName("""x17735_mul""")
      x17735_mul.r := (Math.mul(x17728_elem_0, x17726_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x17735_mul")).r
      val x17736_wr_x17717_banks = List[UInt]()
      val x17736_wr_x17717_ofs = List[UInt]()
      val x17736_wr_x17717_en = List[Bool](true.B)
      val x17736_wr_x17717_data = List[UInt](x17730_elem_0.r)
      x17717_reg.connectWPort(17736, x17736_wr_x17717_banks, x17736_wr_x17717_ofs, x17736_wr_x17717_data, x17736_wr_x17717_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x17737_wr_x17718_banks = List[UInt]()
      val x17737_wr_x17718_ofs = List[UInt]()
      val x17737_wr_x17718_en = List[Bool](true.B)
      val x17737_wr_x17718_data = List[UInt](x17732_elem_0.r)
      x17718_reg.connectWPort(17737, x17737_wr_x17718_banks, x17737_wr_x17718_ofs, x17737_wr_x17718_data, x17737_wr_x17718_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x17738_wr_x17719_banks = List[UInt]()
      val x17738_wr_x17719_ofs = List[UInt]()
      val x17738_wr_x17719_en = List[Bool](true.B)
      val x17738_wr_x17719_data = List[UInt](x17734_elem_0.r)
      x17719_reg.connectWPort(17738, x17738_wr_x17719_banks, x17738_wr_x17719_ofs, x17738_wr_x17719_data, x17738_wr_x17719_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x17739_wr_x17720_banks = List[UInt]()
      val x17739_wr_x17720_ofs = List[UInt]()
      val x17739_wr_x17720_en = List[Bool](true.B)
      val x17739_wr_x17720_data = List[UInt](x17735_mul.r)
      x17720_reg.connectWPort(17739, x17739_wr_x17720_banks, x17739_wr_x17720_ofs, x17739_wr_x17720_data, x17739_wr_x17720_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(7.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x17740_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x17740_inr_UnitPipe **/
