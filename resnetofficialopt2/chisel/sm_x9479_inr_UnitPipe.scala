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

/** Hierarchy: x9479 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x9479_inr_UnitPipe **/
class x9479_inr_UnitPipe_kernel(
  list_b3916: List[FixedPoint],
  list_x9465_reg: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 2.2.toInt, myName = "x9479_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x9479_inr_UnitPipe_iiCtr"))
  
  abstract class x9479_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9465_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9465_reg_p").asInstanceOf[MemParams] ))
      val in_b3916 = Input(new FixedPoint(true, 32, 0))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x9468_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9468_reg_p").asInstanceOf[MemParams] ))
      val in_x3900_check_Fused_Conv2D_BiasAdd_k1_0 = Flipped(new StandardInterface(ModuleParams.getParams("x3900_check_Fused_Conv2D_BiasAdd_k1_0_p").asInstanceOf[MemParams] ))
      val in_x9467_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9467_reg_p").asInstanceOf[MemParams] ))
      val in_x9466_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9466_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x9465_reg = {io.in_x9465_reg} ; io.in_x9465_reg := DontCare
    def b3916 = {io.in_b3916} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x9468_reg = {io.in_x9468_reg} ; io.in_x9468_reg := DontCare
    def x3900_check_Fused_Conv2D_BiasAdd_k1_0 = {io.in_x3900_check_Fused_Conv2D_BiasAdd_k1_0} ; io.in_x3900_check_Fused_Conv2D_BiasAdd_k1_0 := DontCare
    def x9467_reg = {io.in_x9467_reg} ; io.in_x9467_reg := DontCare
    def x9466_reg = {io.in_x9466_reg} ; io.in_x9466_reg := DontCare
  }
  def connectWires0(module: x9479_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x9465_reg.connectLedger(module.io.in_x9465_reg)
    module.io.in_b3916 <> b3916
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    x9468_reg.connectLedger(module.io.in_x9468_reg)
    x3900_check_Fused_Conv2D_BiasAdd_k1_0.connectLedger(module.io.in_x3900_check_Fused_Conv2D_BiasAdd_k1_0)
    x9467_reg.connectLedger(module.io.in_x9467_reg)
    x9466_reg.connectLedger(module.io.in_x9466_reg)
  }
  val b3916 = list_b3916(0)
  val x9465_reg = list_x9465_reg(0)
  val x3920_reg = list_x9465_reg(1)
  val x9468_reg = list_x9465_reg(2)
  val x3900_check_Fused_Conv2D_BiasAdd_k1_0 = list_x9465_reg(3)
  val x9467_reg = list_x9465_reg(4)
  val x9466_reg = list_x9465_reg(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x9479_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x9479_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x9479_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x9469_rd_x3920 = Wire(Bool()).suggestName("""x9469_rd_x3920""")
      val x9469_rd_x3920_banks = List[UInt]()
      val x9469_rd_x3920_ofs = List[UInt]()
      val x9469_rd_x3920_en = List[Bool](true.B)
      x9469_rd_x3920.toSeq.zip(x3920_reg.connectRPort(9469, x9469_rd_x3920_banks, x9469_rd_x3920_ofs, io.sigsIn.backpressure, x9469_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9472 = Wire(Vec(1, Bool())).suggestName("""x9472""")
      val x9472_banks = List[UInt](b3916.r)
      val x9472_ofs = List[UInt](b3916.r)
      val x9472_en = List[Bool](true.B)
      x9472.toSeq.zip(x3900_check_Fused_Conv2D_BiasAdd_k1_0.connectRPort(9472, x9472_banks, x9472_ofs, io.sigsIn.backpressure, x9472_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && x9469_rd_x3920), true)).foreach{case (a,b) => a := b}
      val x20630 = Wire(Vec(1, Bool())).suggestName("x20630_x9472_D1") 
      (0 until 1).foreach{i => x20630(i).r := getRetimed(x9472(i).r, 1.toInt, io.sigsIn.backpressure)}
      val x9473_elem_0 = Wire(Bool()).suggestName("""x9473_elem_0""")
      x9473_elem_0.r := x20630(0).r
      val x9474 = Wire(Bool()).suggestName("""x9474""")
      x9474 := ~x9473_elem_0
      val x9475_wr_x9466_banks = List[UInt]()
      val x9475_wr_x9466_ofs = List[UInt]()
      val x9475_wr_x9466_en = List[Bool](true.B)
      val x9475_wr_x9466_data = List[UInt](x9473_elem_0.r)
      x9466_reg.connectWPort(9475, x9475_wr_x9466_banks, x9475_wr_x9466_ofs, x9475_wr_x9466_data, x9475_wr_x9466_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x9476_wr_x9465_banks = List[UInt]()
      val x9476_wr_x9465_ofs = List[UInt]()
      val x9476_wr_x9465_en = List[Bool](true.B)
      val x9476_wr_x9465_data = List[UInt](x9473_elem_0.r)
      x9465_reg.connectWPort(9476, x9476_wr_x9465_banks, x9476_wr_x9465_ofs, x9476_wr_x9465_data, x9476_wr_x9465_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.0.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x9477_wr_x9468_banks = List[UInt]()
      val x9477_wr_x9468_ofs = List[UInt]()
      val x9477_wr_x9468_en = List[Bool](true.B)
      val x9477_wr_x9468_data = List[UInt](x9474.r)
      x9468_reg.connectWPort(9477, x9477_wr_x9468_banks, x9477_wr_x9468_ofs, x9477_wr_x9468_data, x9477_wr_x9468_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x9478_wr_x9467_banks = List[UInt]()
      val x9478_wr_x9467_ofs = List[UInt]()
      val x9478_wr_x9467_en = List[Bool](true.B)
      val x9478_wr_x9467_data = List[UInt](x9474.r)
      x9467_reg.connectWPort(9478, x9478_wr_x9467_banks, x9478_wr_x9467_ofs, x9478_wr_x9467_data, x9478_wr_x9467_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(1.2.toInt, rr, io.sigsIn.backpressure) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x9479_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x9479_inr_UnitPipe **/
