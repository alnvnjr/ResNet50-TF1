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

/** Hierarchy: x3931 -> x18374 -> x1256 **/
/** BEGIN None x3931_inr_UnitPipe **/
class x3931_inr_UnitPipe_kernel(
  list_b3917: List[Bool],
  list_b3916: List[FixedPoint],
  list_x3919_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 2.2.toInt, myName = "x3931_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x3931_inr_UnitPipe_iiCtr"))
  
  abstract class x3931_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x3919_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3919_reg_p").asInstanceOf[MemParams] ))
      val in_x3899_check_Fused_Conv2D_BiasAdd_k3_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3899_check_Fused_Conv2D_BiasAdd_k3_0_p").asInstanceOf[MemParams] ))
      val in_b3916 = Input(new FixedPoint(true, 32, 0))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_b3917 = Input(Bool())
      val in_x3921_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3921_reg_p").asInstanceOf[MemParams] ))
      val in_x3918_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3918_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x3919_reg = {io.in_x3919_reg} ; io.in_x3919_reg := DontCare
    def x3899_check_Fused_Conv2D_BiasAdd_k3_0 = {io.in_x3899_check_Fused_Conv2D_BiasAdd_k3_0} ; io.in_x3899_check_Fused_Conv2D_BiasAdd_k3_0 := DontCare
    def b3916 = {io.in_b3916} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def b3917 = {io.in_b3917} 
    def x3921_reg = {io.in_x3921_reg} ; io.in_x3921_reg := DontCare
    def x3918_reg = {io.in_x3918_reg} ; io.in_x3918_reg := DontCare
  }
  def connectWires0(module: x3931_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x3919_reg.connectLedger(module.io.in_x3919_reg)
    x3899_check_Fused_Conv2D_BiasAdd_k3_0.connectLedger(module.io.in_x3899_check_Fused_Conv2D_BiasAdd_k3_0)
    module.io.in_b3916 <> b3916
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    module.io.in_b3917 <> b3917
    x3921_reg.connectLedger(module.io.in_x3921_reg)
    x3918_reg.connectLedger(module.io.in_x3918_reg)
  }
  val b3917 = list_b3917(0)
  val b3916 = list_b3916(0)
  val x3919_reg = list_x3919_reg(0)
  val x3899_check_Fused_Conv2D_BiasAdd_k3_0 = list_x3919_reg(1)
  val x3920_reg = list_x3919_reg(2)
  val x3921_reg = list_x3919_reg(3)
  val x3918_reg = list_x3919_reg(4)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x3931_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x3931_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x3931_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x3924 = Wire(Vec(1, Bool())).suggestName("""x3924""")
      val x3924_banks = List[UInt](b3916.r)
      val x3924_ofs = List[UInt](b3916.r)
      val x3924_en = List[Bool](true.B)
      x3924.toSeq.zip(x3899_check_Fused_Conv2D_BiasAdd_k3_0.connectRPort(3924, x3924_banks, x3924_ofs, io.sigsIn.backpressure, x3924_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x19587 = Wire(Vec(1, Bool())).suggestName("x19587_x3924_D1") 
      (0 until 1).foreach{i => x19587(i).r := getRetimed(x3924(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x3925_elem_0 = Wire(Bool()).suggestName("""x3925_elem_0""")
      x3925_elem_0.r := x19587(0).r
      val x3926 = Wire(Bool()).suggestName("""x3926""")
      x3926 := ~x3925_elem_0
      val x3927_wr_x3919_banks = List[UInt]()
      val x3927_wr_x3919_ofs = List[UInt]()
      val x3927_wr_x3919_en = List[Bool](true.B)
      val x3927_wr_x3919_data = List[UInt](x3925_elem_0.r)
      x3919_reg.connectWPort(3927, x3927_wr_x3919_banks, x3927_wr_x3919_ofs, x3927_wr_x3919_data, x3927_wr_x3919_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x3928_wr_x3918_banks = List[UInt]()
      val x3928_wr_x3918_ofs = List[UInt]()
      val x3928_wr_x3918_en = List[Bool](true.B)
      val x3928_wr_x3918_data = List[UInt](x3925_elem_0.r)
      x3918_reg.connectWPort(3928, x3928_wr_x3918_banks, x3928_wr_x3918_ofs, x3928_wr_x3918_data, x3928_wr_x3918_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x3929_wr_x3920_banks = List[UInt]()
      val x3929_wr_x3920_ofs = List[UInt]()
      val x3929_wr_x3920_en = List[Bool](true.B)
      val x3929_wr_x3920_data = List[UInt](x3926.r)
      x3920_reg.connectWPort(3929, x3929_wr_x3920_banks, x3929_wr_x3920_ofs, x3929_wr_x3920_data, x3929_wr_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x3930_wr_x3921_banks = List[UInt]()
      val x3930_wr_x3921_ofs = List[UInt]()
      val x3930_wr_x3921_en = List[Bool](true.B)
      val x3930_wr_x3921_data = List[UInt](x3926.r)
      x3921_reg.connectWPort(3930, x3930_wr_x3921_banks, x3930_wr_x3921_ofs, x3930_wr_x3921_data, x3930_wr_x3921_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x3931_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x3931_inr_UnitPipe **/
