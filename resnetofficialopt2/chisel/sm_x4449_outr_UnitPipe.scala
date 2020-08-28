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

/** Hierarchy: x4449 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4449_outr_UnitPipe **/
class x4449_outr_UnitPipe_kernel(
  list_x4326_img2D_4: List[NBufInterface],
  list_x4336: List[DecoupledIO[AppCommandDense]],
  list_b4068: List[Bool],
  list_x4338: List[DecoupledIO[AppLoadData]],
  list_x3935_reg: List[StandardInterface],
  list_x2682_tmp_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x4449_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4449_outr_UnitPipe_iiCtr"))
  
  abstract class x4449_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4326_img2D_4 = Flipped(new NBufInterface(ModuleParams.getParams("x4326_img2D_4_p").asInstanceOf[NBufParams] ))
      val in_x4322_img2D_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4322_img2D_0_p").asInstanceOf[NBufParams] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x4329_img2D_7 = Flipped(new NBufInterface(ModuleParams.getParams("x4329_img2D_7_p").asInstanceOf[NBufParams] ))
      val in_x4323_img2D_1 = Flipped(new NBufInterface(ModuleParams.getParams("x4323_img2D_1_p").asInstanceOf[NBufParams] ))
      val in_x4327_img2D_5 = Flipped(new NBufInterface(ModuleParams.getParams("x4327_img2D_5_p").asInstanceOf[NBufParams] ))
      val in_x3935_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3935_reg_p").asInstanceOf[MemParams] ))
      val in_b4068 = Input(Bool())
      val in_x3937_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3937_reg_p").asInstanceOf[MemParams] ))
      val in_x4328_img2D_6 = Flipped(new NBufInterface(ModuleParams.getParams("x4328_img2D_6_p").asInstanceOf[NBufParams] ))
      val in_b4060 = Input(Bool())
      val in_x4331_reg = Flipped(new NBufInterface(ModuleParams.getParams("x4331_reg_p").asInstanceOf[NBufParams] ))
      val in_x4336 = Decoupled(new AppCommandDense(ModuleParams.getParams("x4336_p").asInstanceOf[(Int,Int)] ))
      val in_x4324_img2D_2 = Flipped(new NBufInterface(ModuleParams.getParams("x4324_img2D_2_p").asInstanceOf[NBufParams] ))
      val in_x4241_weight_SRAM_reshape_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4241_weight_SRAM_reshape_0_p").asInstanceOf[NBufParams] ))
      val in_x4325_img2D_3 = Flipped(new NBufInterface(ModuleParams.getParams("x4325_img2D_3_p").asInstanceOf[NBufParams] ))
      val in_x4338 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4338_p").asInstanceOf[(Int, Int)] )))
      val in_x4330_img2D_8 = Flipped(new NBufInterface(ModuleParams.getParams("x4330_img2D_8_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x4326_img2D_4 = {io.in_x4326_img2D_4} ; io.in_x4326_img2D_4 := DontCare
    def x4322_img2D_0 = {io.in_x4322_img2D_0} ; io.in_x4322_img2D_0 := DontCare
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x4329_img2D_7 = {io.in_x4329_img2D_7} ; io.in_x4329_img2D_7 := DontCare
    def x4323_img2D_1 = {io.in_x4323_img2D_1} ; io.in_x4323_img2D_1 := DontCare
    def x4327_img2D_5 = {io.in_x4327_img2D_5} ; io.in_x4327_img2D_5 := DontCare
    def x3935_reg = {io.in_x3935_reg} ; io.in_x3935_reg := DontCare
    def b4068 = {io.in_b4068} 
    def x3937_reg = {io.in_x3937_reg} ; io.in_x3937_reg := DontCare
    def x4328_img2D_6 = {io.in_x4328_img2D_6} ; io.in_x4328_img2D_6 := DontCare
    def b4060 = {io.in_b4060} 
    def x4331_reg = {io.in_x4331_reg} ; io.in_x4331_reg := DontCare
    def x4336 = {io.in_x4336} 
    def x4324_img2D_2 = {io.in_x4324_img2D_2} ; io.in_x4324_img2D_2 := DontCare
    def x4241_weight_SRAM_reshape_0 = {io.in_x4241_weight_SRAM_reshape_0} ; io.in_x4241_weight_SRAM_reshape_0 := DontCare
    def x4325_img2D_3 = {io.in_x4325_img2D_3} ; io.in_x4325_img2D_3 := DontCare
    def x4338 = {io.in_x4338} 
    def x4330_img2D_8 = {io.in_x4330_img2D_8} ; io.in_x4330_img2D_8 := DontCare
  }
  def connectWires0(module: x4449_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x4326_img2D_4.connectLedger(module.io.in_x4326_img2D_4)
    x4322_img2D_0.connectLedger(module.io.in_x4322_img2D_0)
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x4329_img2D_7.connectLedger(module.io.in_x4329_img2D_7)
    x4323_img2D_1.connectLedger(module.io.in_x4323_img2D_1)
    x4327_img2D_5.connectLedger(module.io.in_x4327_img2D_5)
    x3935_reg.connectLedger(module.io.in_x3935_reg)
    module.io.in_b4068 <> b4068
    x3937_reg.connectLedger(module.io.in_x3937_reg)
    x4328_img2D_6.connectLedger(module.io.in_x4328_img2D_6)
    module.io.in_b4060 <> b4060
    x4331_reg.connectLedger(module.io.in_x4331_reg)
    module.io.in_x4336 <> x4336
    x4324_img2D_2.connectLedger(module.io.in_x4324_img2D_2)
    x4241_weight_SRAM_reshape_0.connectLedger(module.io.in_x4241_weight_SRAM_reshape_0)
    x4325_img2D_3.connectLedger(module.io.in_x4325_img2D_3)
    module.io.in_x4338 <> x4338
    x4330_img2D_8.connectLedger(module.io.in_x4330_img2D_8)
  }
  val x4326_img2D_4 = list_x4326_img2D_4(0)
  val x4322_img2D_0 = list_x4326_img2D_4(1)
  val x4329_img2D_7 = list_x4326_img2D_4(2)
  val x4323_img2D_1 = list_x4326_img2D_4(3)
  val x4327_img2D_5 = list_x4326_img2D_4(4)
  val x4328_img2D_6 = list_x4326_img2D_4(5)
  val x4331_reg = list_x4326_img2D_4(6)
  val x4324_img2D_2 = list_x4326_img2D_4(7)
  val x4241_weight_SRAM_reshape_0 = list_x4326_img2D_4(8)
  val x4325_img2D_3 = list_x4326_img2D_4(9)
  val x4330_img2D_8 = list_x4326_img2D_4(10)
  val x4336 = list_x4336(0)
  val b4068 = list_b4068(0)
  val b4060 = list_b4068(1)
  val x4338 = list_x4338(0)
  val x3935_reg = list_x3935_reg(0)
  val x3937_reg = list_x3935_reg(1)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4449_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4449_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4449_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4337_fifo = (new x4337_fifo).m.io.asInstanceOf[FIFOInterface]
      val x4368_inr_UnitPipe = new x4368_inr_UnitPipe_kernel(List(x4331_reg), List(x4337_fifo), List(x4336), List(x3935_reg,x3937_reg), List(x2682_tmp_DRAM) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x4368_inr_UnitPipe.sm.io.ctrDone := risingEdge(x4368_inr_UnitPipe.sm.io.ctrInc)
      x4368_inr_UnitPipe.backpressure := (~x4337_fifo.full | ~(x4337_fifo.accessActivesOut(0))) & x4336.ready | x4368_inr_UnitPipe.sm.io.doneLatch
      x4368_inr_UnitPipe.forwardpressure := true.B | x4368_inr_UnitPipe.sm.io.doneLatch
      x4368_inr_UnitPipe.sm.io.enableOut.zip(x4368_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4368_inr_UnitPipe.sm.io.break := false.B
      x4368_inr_UnitPipe.mask := true.B & true.B
      x4368_inr_UnitPipe.configure("x4368_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4368_inr_UnitPipe.kernel()
      val x4448_outr_UnitPipe = new x4448_outr_UnitPipe_kernel(List(x4337_fifo), List(x4338), List(x4326_img2D_4,x4322_img2D_0,x4329_img2D_7,x4323_img2D_1,x4327_img2D_5,x4328_img2D_6,x4324_img2D_2,x4325_img2D_3,x4330_img2D_8) , Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, rr)
      x4448_outr_UnitPipe.sm.io.ctrDone := risingEdge(x4448_outr_UnitPipe.sm.io.ctrInc)
      x4448_outr_UnitPipe.backpressure := true.B | x4448_outr_UnitPipe.sm.io.doneLatch
      x4448_outr_UnitPipe.forwardpressure := true.B | x4448_outr_UnitPipe.sm.io.doneLatch
      x4448_outr_UnitPipe.sm.io.enableOut.zip(x4448_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4448_outr_UnitPipe.sm.io.break := false.B
      x4448_outr_UnitPipe.mask := true.B & true.B
      x4448_outr_UnitPipe.configure("x4448_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4448_outr_UnitPipe.kernel()
      x4241_weight_SRAM_reshape_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 2)
      x4322_img2D_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4323_img2D_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4324_img2D_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4325_img2D_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4326_img2D_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4327_img2D_5.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4328_img2D_6.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4329_img2D_7.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4330_img2D_8.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 0)
      x4331_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x4449_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4449_outr_UnitPipe **/
