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

/** Hierarchy: x4448 -> x4449 -> x9344 -> x9462 -> x9464 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x4448_outr_UnitPipe **/
class x4448_outr_UnitPipe_kernel(
  list_x4337_fifo: List[FIFOInterface],
  list_x4338: List[DecoupledIO[AppLoadData]],
  list_x4326_img2D_4: List[NBufInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x4448_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x4448_outr_UnitPipe_iiCtr"))
  
  abstract class x4448_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x4326_img2D_4 = Flipped(new NBufInterface(ModuleParams.getParams("x4326_img2D_4_p").asInstanceOf[NBufParams] ))
      val in_x4322_img2D_0 = Flipped(new NBufInterface(ModuleParams.getParams("x4322_img2D_0_p").asInstanceOf[NBufParams] ))
      val in_x4329_img2D_7 = Flipped(new NBufInterface(ModuleParams.getParams("x4329_img2D_7_p").asInstanceOf[NBufParams] ))
      val in_x4323_img2D_1 = Flipped(new NBufInterface(ModuleParams.getParams("x4323_img2D_1_p").asInstanceOf[NBufParams] ))
      val in_x4327_img2D_5 = Flipped(new NBufInterface(ModuleParams.getParams("x4327_img2D_5_p").asInstanceOf[NBufParams] ))
      val in_x4328_img2D_6 = Flipped(new NBufInterface(ModuleParams.getParams("x4328_img2D_6_p").asInstanceOf[NBufParams] ))
      val in_x4337_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x4337_fifo_p").asInstanceOf[MemParams] ))
      val in_x4324_img2D_2 = Flipped(new NBufInterface(ModuleParams.getParams("x4324_img2D_2_p").asInstanceOf[NBufParams] ))
      val in_x4325_img2D_3 = Flipped(new NBufInterface(ModuleParams.getParams("x4325_img2D_3_p").asInstanceOf[NBufParams] ))
      val in_x4338 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x4338_p").asInstanceOf[(Int, Int)] )))
      val in_x4330_img2D_8 = Flipped(new NBufInterface(ModuleParams.getParams("x4330_img2D_8_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x4326_img2D_4 = {io.in_x4326_img2D_4} ; io.in_x4326_img2D_4 := DontCare
    def x4322_img2D_0 = {io.in_x4322_img2D_0} ; io.in_x4322_img2D_0 := DontCare
    def x4329_img2D_7 = {io.in_x4329_img2D_7} ; io.in_x4329_img2D_7 := DontCare
    def x4323_img2D_1 = {io.in_x4323_img2D_1} ; io.in_x4323_img2D_1 := DontCare
    def x4327_img2D_5 = {io.in_x4327_img2D_5} ; io.in_x4327_img2D_5 := DontCare
    def x4328_img2D_6 = {io.in_x4328_img2D_6} ; io.in_x4328_img2D_6 := DontCare
    def x4337_fifo = {io.in_x4337_fifo} ; io.in_x4337_fifo := DontCare
    def x4324_img2D_2 = {io.in_x4324_img2D_2} ; io.in_x4324_img2D_2 := DontCare
    def x4325_img2D_3 = {io.in_x4325_img2D_3} ; io.in_x4325_img2D_3 := DontCare
    def x4338 = {io.in_x4338} 
    def x4330_img2D_8 = {io.in_x4330_img2D_8} ; io.in_x4330_img2D_8 := DontCare
  }
  def connectWires0(module: x4448_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x4326_img2D_4.connectLedger(module.io.in_x4326_img2D_4)
    x4322_img2D_0.connectLedger(module.io.in_x4322_img2D_0)
    x4329_img2D_7.connectLedger(module.io.in_x4329_img2D_7)
    x4323_img2D_1.connectLedger(module.io.in_x4323_img2D_1)
    x4327_img2D_5.connectLedger(module.io.in_x4327_img2D_5)
    x4328_img2D_6.connectLedger(module.io.in_x4328_img2D_6)
    x4337_fifo.connectLedger(module.io.in_x4337_fifo)
    x4324_img2D_2.connectLedger(module.io.in_x4324_img2D_2)
    x4325_img2D_3.connectLedger(module.io.in_x4325_img2D_3)
    module.io.in_x4338 <> x4338
    x4330_img2D_8.connectLedger(module.io.in_x4330_img2D_8)
  }
  val x4337_fifo = list_x4337_fifo(0)
  val x4338 = list_x4338(0)
  val x4326_img2D_4 = list_x4326_img2D_4(0)
  val x4322_img2D_0 = list_x4326_img2D_4(1)
  val x4329_img2D_7 = list_x4326_img2D_4(2)
  val x4323_img2D_1 = list_x4326_img2D_4(3)
  val x4327_img2D_5 = list_x4326_img2D_4(4)
  val x4328_img2D_6 = list_x4326_img2D_4(5)
  val x4324_img2D_2 = list_x4326_img2D_4(6)
  val x4325_img2D_3 = list_x4326_img2D_4(7)
  val x4330_img2D_8 = list_x4326_img2D_4(8)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x4448_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x4448_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x4448_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x4370_reg = (new x4370_reg).m.io.asInstanceOf[StandardInterface]
      val x4371_reg = (new x4371_reg).m.io.asInstanceOf[StandardInterface]
      val x4372_reg = (new x4372_reg).m.io.asInstanceOf[StandardInterface]
      val x4381_inr_UnitPipe = new x4381_inr_UnitPipe_kernel(List(x4337_fifo), List(x4371_reg,x4370_reg,x4372_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x4381_inr_UnitPipe.sm.io.ctrDone := risingEdge(x4381_inr_UnitPipe.sm.io.ctrInc)
      x4381_inr_UnitPipe.backpressure := true.B | x4381_inr_UnitPipe.sm.io.doneLatch
      x4381_inr_UnitPipe.forwardpressure := (~x4337_fifo.empty | ~(x4337_fifo.accessActivesOut(1))) | x4381_inr_UnitPipe.sm.io.doneLatch
      x4381_inr_UnitPipe.sm.io.enableOut.zip(x4381_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x4381_inr_UnitPipe.sm.io.break := false.B
      x4381_inr_UnitPipe.mask := true.B & true.B
      x4381_inr_UnitPipe.configure("x4381_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4381_inr_UnitPipe.kernel()
      val x18775_rd_x4372 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18775_rd_x4372""")
      val x18775_rd_x4372_banks = List[UInt]()
      val x18775_rd_x4372_ofs = List[UInt]()
      val x18775_rd_x4372_en = List[Bool](true.B)
      x18775_rd_x4372.toSeq.zip(x4372_reg.connectRPort(18775, x18775_rd_x4372_banks, x18775_rd_x4372_ofs, io.sigsIn.backpressure, x18775_rd_x4372_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x4383_ctr = new CtrObject(Left(Some(0)), Right(x18775_rd_x4372), Left(Some(1)), 4, 32, false)
      val x4384_ctrchain = (new CChainObject(List[CtrObject](x4383_ctr), "x4384_ctrchain")).cchain.io 
      x4384_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x4384_ctrchain_p", (x4384_ctrchain.par, x4384_ctrchain.widths))
      val x4447_inr_Foreach = new x4447_inr_Foreach_kernel(List(x4338), List(x4371_reg,x4370_reg), List(x4326_img2D_4,x4322_img2D_0,x4329_img2D_7,x4323_img2D_1,x4327_img2D_5,x4328_img2D_6,x4324_img2D_2,x4325_img2D_3,x4330_img2D_8) , Some(me), List(x4384_ctrchain), 1, 1, 1, List(4), List(32), breakpoints, rr)
      x4447_inr_Foreach.sm.io.ctrDone := (x4447_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      x4447_inr_Foreach.backpressure := true.B | x4447_inr_Foreach.sm.io.doneLatch
      x4447_inr_Foreach.forwardpressure := x4338.valid | x4447_inr_Foreach.sm.io.doneLatch
      x4447_inr_Foreach.sm.io.enableOut.zip(x4447_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x4447_inr_Foreach.sm.io.break := false.B
      x4447_inr_Foreach.mask := ~x4447_inr_Foreach.cchain.head.output.noop & true.B
      x4447_inr_Foreach.configure("x4447_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x4447_inr_Foreach.kernel()
    }
    val module = Module(new x4448_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x4448_outr_UnitPipe **/
