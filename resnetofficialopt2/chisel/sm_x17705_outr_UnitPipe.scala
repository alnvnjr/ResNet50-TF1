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

/** Hierarchy: x17705 -> x17710 -> x17711 -> x17712 -> x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17705_outr_UnitPipe **/
class x17705_outr_UnitPipe_kernel(
  list_x9495_reg: List[StandardInterface],
  list_x17550: List[DecoupledIO[AppCommandDense]],
  list_x17539_reg: List[NBufInterface],
  list_x17551: List[DecoupledIO[AppStoreData]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x17705_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17705_outr_UnitPipe_iiCtr"))
  
  abstract class x17705_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x17539_reg = Flipped(new NBufInterface(ModuleParams.getParams("x17539_reg_p").asInstanceOf[NBufParams] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x17550 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17550_p").asInstanceOf[(Int,Int)] ))
      val in_x17551 = Decoupled(new AppStoreData(ModuleParams.getParams("x17551_p").asInstanceOf[(Int,Int)] ))
      val in_x17304_out_SRAM_bias_0 = Flipped(new NBufInterface(ModuleParams.getParams("x17304_out_SRAM_bias_0_p").asInstanceOf[NBufParams] ))
      val in_x9495_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9495_reg_p").asInstanceOf[MemParams] ))
      val in_x17540_reg = Flipped(new NBufInterface(ModuleParams.getParams("x17540_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x17539_reg = {io.in_x17539_reg} ; io.in_x17539_reg := DontCare
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x17550 = {io.in_x17550} 
    def x17551 = {io.in_x17551} 
    def x17304_out_SRAM_bias_0 = {io.in_x17304_out_SRAM_bias_0} ; io.in_x17304_out_SRAM_bias_0 := DontCare
    def x9495_reg = {io.in_x9495_reg} ; io.in_x9495_reg := DontCare
    def x17540_reg = {io.in_x17540_reg} ; io.in_x17540_reg := DontCare
  }
  def connectWires0(module: x17705_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x17539_reg.connectLedger(module.io.in_x17539_reg)
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x17550 <> x17550
    module.io.in_x17551 <> x17551
    x17304_out_SRAM_bias_0.connectLedger(module.io.in_x17304_out_SRAM_bias_0)
    x9495_reg.connectLedger(module.io.in_x9495_reg)
    x17540_reg.connectLedger(module.io.in_x17540_reg)
  }
  val x9495_reg = list_x9495_reg(0)
  val x17550 = list_x17550(0)
  val x17539_reg = list_x17539_reg(0)
  val x17304_out_SRAM_bias_0 = list_x17539_reg(1)
  val x17540_reg = list_x17539_reg(2)
  val x17551 = list_x17551(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17705_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x17705_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17705_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x17553_reg = (new x17553_reg).m.io.asInstanceOf[StandardInterface]
      val x17554_reg = (new x17554_reg).m.io.asInstanceOf[StandardInterface]
      val x17555_reg = (new x17555_reg).m.io.asInstanceOf[StandardInterface]
      val x17586_inr_UnitPipe = new x17586_inr_UnitPipe_kernel(List(x2682_tmp_DRAM), List(x17550), List(x17555_reg,x17554_reg,x9495_reg,x17553_reg), List(x17539_reg,x17540_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x17586_inr_UnitPipe.sm.io.ctrDone := risingEdge(x17586_inr_UnitPipe.sm.io.ctrInc)
      x17586_inr_UnitPipe.backpressure := x17550.ready | x17586_inr_UnitPipe.sm.io.doneLatch
      x17586_inr_UnitPipe.forwardpressure := true.B | x17586_inr_UnitPipe.sm.io.doneLatch
      x17586_inr_UnitPipe.sm.io.enableOut.zip(x17586_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x17586_inr_UnitPipe.sm.io.break := false.B
      x17586_inr_UnitPipe.mask := true.B & true.B
      x17586_inr_UnitPipe.configure("x17586_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17586_inr_UnitPipe.kernel()
      val x18808_rd_x17555 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18808_rd_x17555""")
      val x18808_rd_x17555_banks = List[UInt]()
      val x18808_rd_x17555_ofs = List[UInt]()
      val x18808_rd_x17555_en = List[Bool](true.B)
      x18808_rd_x17555.toSeq.zip(x17555_reg.connectRPort(18808, x18808_rd_x17555_banks, x18808_rd_x17555_ofs, io.sigsIn.backpressure, x18808_rd_x17555_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17588_ctr = new CtrObject(Left(Some(0)), Right(x18808_rd_x17555), Left(Some(1)), 8, 32, false)
      val x17589_ctrchain = (new CChainObject(List[CtrObject](x17588_ctr), "x17589_ctrchain")).cchain.io 
      x17589_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x17589_ctrchain_p", (x17589_ctrchain.par, x17589_ctrchain.widths))
      val x17704_inr_Foreach = new x17704_inr_Foreach_kernel(List(x17304_out_SRAM_bias_0), List(x17554_reg,x17553_reg), List(x17551) , Some(me), List(x17589_ctrchain), 1, 1, 1, List(8), List(32), breakpoints, rr)
      x17704_inr_Foreach.sm.io.ctrDone := (x17704_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x17704_inr_Foreach.backpressure := x17551.ready | x17704_inr_Foreach.sm.io.doneLatch
      x17704_inr_Foreach.forwardpressure := true.B | x17704_inr_Foreach.sm.io.doneLatch
      x17704_inr_Foreach.sm.io.enableOut.zip(x17704_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x17704_inr_Foreach.sm.io.break := false.B
      x17704_inr_Foreach.mask := ~x17704_inr_Foreach.cchain.head.output.noop & true.B
      x17704_inr_Foreach.configure("x17704_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17704_inr_Foreach.kernel()
    }
    val module = Module(new x17705_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x17705_outr_UnitPipe **/
