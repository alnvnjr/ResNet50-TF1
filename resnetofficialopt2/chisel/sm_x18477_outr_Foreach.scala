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

/** Hierarchy: x18477 -> x1256 **/
/** BEGIN None x18477_outr_Foreach **/
class x18477_outr_Foreach_kernel(
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x18388: List[DecoupledIO[AppCommandDense]],
  list_x18390: List[DecoupledIO[AppLoadData]],
  list_x18375_tmp75_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 4, isFSM = false   , latency = 0.0.toInt, myName = "x18477_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18477_outr_Foreach_iiCtr"))
  
  abstract class x18477_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18388 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18388_p").asInstanceOf[(Int,Int)] ))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x18375_tmp75_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18375_tmp75_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x18390 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18390_p").asInstanceOf[(Int, Int)] )))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(4, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(4, 1))
      val rr = Input(Bool())
    })
    def x18388 = {io.in_x18388} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x18375_tmp75_SRAM_0 = {io.in_x18375_tmp75_SRAM_0} ; io.in_x18375_tmp75_SRAM_0 := DontCare
    def x18390 = {io.in_x18390} 
  }
  def connectWires0(module: x18477_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18388 <> x18388
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x18375_tmp75_SRAM_0.connectLedger(module.io.in_x18375_tmp75_SRAM_0)
    module.io.in_x18390 <> x18390
  }
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x18388 = list_x18388(0)
  val x18390 = list_x18390(0)
  val x18375_tmp75_SRAM_0 = list_x18375_tmp75_SRAM_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18477_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x18477_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18477_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b18378 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b18378.suggestName("b18378")
      val b18378_chain = Module(new RegChainPass(4, 32, myName = "b18378_chain")); b18378_chain.io <> DontCare
      b18378_chain.chain_pass(b18378, io.sigsOut.smDoneIn.head)
      val b18378_chain_read_1 = b18378_chain.read(1).FP(true,32,0)
      val b18378_chain_read_2 = b18378_chain.read(2).FP(true,32,0)
      val b18378_chain_read_3 = b18378_chain.read(3).FP(true,32,0)
      val b18379 = ~io.sigsIn.cchainOutputs.head.oobs(0); b18379.suggestName("b18379")
      val b18379_chain = Module(new RegChainPass(4, 1, myName = "b18379_chain")); b18379_chain.io <> DontCare
      b18379_chain.chain_pass(b18379, io.sigsOut.smDoneIn.head)
      val b18379_chain_read_1: Bool = b18379_chain.read(1).apply(0)
      val b18379_chain_read_2: Bool = b18379_chain.read(2).apply(0)
      val b18379_chain_read_3: Bool = b18379_chain.read(3).apply(0)
      val x18380_feature_map_0 = (new x18380_feature_map_0).m.io.asInstanceOf[NBufInterface]
      val x18381_reg = (new x18381_reg).m.io.asInstanceOf[NBufInterface]
      val x18382_reg = (new x18382_reg).m.io.asInstanceOf[NBufInterface]
      val x18387_inr_UnitPipe = new x18387_inr_UnitPipe_kernel(List(b18379), List(b18378), List(x18381_reg,x18382_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x18387_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18387_inr_UnitPipe.sm.io.ctrInc)
      b18378_chain.connectStageCtrl((x18387_inr_UnitPipe.done).DS(1.toInt, rr, x18387_inr_UnitPipe.sm.io.backpressure), x18387_inr_UnitPipe.baseEn, 0)
      b18379_chain.connectStageCtrl((x18387_inr_UnitPipe.done).DS(1.toInt, rr, x18387_inr_UnitPipe.sm.io.backpressure), x18387_inr_UnitPipe.baseEn, 0)
      x18387_inr_UnitPipe.backpressure := true.B | x18387_inr_UnitPipe.sm.io.doneLatch
      x18387_inr_UnitPipe.forwardpressure := true.B | x18387_inr_UnitPipe.sm.io.doneLatch
      x18387_inr_UnitPipe.sm.io.enableOut.zip(x18387_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18387_inr_UnitPipe.sm.io.break := false.B
      x18387_inr_UnitPipe.mask := true.B & b18379
      x18387_inr_UnitPipe.configure("x18387_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18387_inr_UnitPipe.kernel()
      val x18450_outr_UnitPipe = new x18450_outr_UnitPipe_kernel(List(b18379_chain_read_1), List(x18380_feature_map_0,x18382_reg,x18381_reg), List(x18390), List(x18388), List(x2682_tmp_DRAM) , Some(me), List(), 1, 2, 2, List(1), List(32), breakpoints, rr)
      b18378_chain.connectStageCtrl((x18450_outr_UnitPipe.done).DS(1.toInt, rr, x18450_outr_UnitPipe.sm.io.backpressure), x18450_outr_UnitPipe.baseEn, 1)
      b18379_chain.connectStageCtrl((x18450_outr_UnitPipe.done).DS(1.toInt, rr, x18450_outr_UnitPipe.sm.io.backpressure), x18450_outr_UnitPipe.baseEn, 1)
      x18450_outr_UnitPipe.backpressure := true.B | x18450_outr_UnitPipe.sm.io.doneLatch
      x18450_outr_UnitPipe.forwardpressure := true.B | x18450_outr_UnitPipe.sm.io.doneLatch
      x18450_outr_UnitPipe.sm.io.enableOut.zip(x18450_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18450_outr_UnitPipe.sm.io.break := false.B
      x18450_outr_UnitPipe.mask := true.B & b18379_chain_read_1
      x18450_outr_UnitPipe.configure("x18450_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18450_outr_UnitPipe.kernel()
      val x18451_sum_0 = (new x18451_sum_0).m.io.asInstanceOf[FixFMAAccumBundle]
      val x18452_sum_1 = (new x18452_sum_1).m.io.asInstanceOf[NBufInterface]
      val x18453_ctr = new CtrObject(Left(Some(0)), Left(Some(49)), Left(Some(1)), 1, 32, false)
      val x18454_ctrchain = (new CChainObject(List[CtrObject](x18453_ctr), "x18454_ctrchain")).cchain.io 
      x18454_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x18454_ctrchain_p", (x18454_ctrchain.par, x18454_ctrchain.widths))
      val x18469_inr_Reduce = new x18469_inr_Reduce_kernel(List(b18379_chain_read_2), List(x18451_sum_0), List(x18380_feature_map_0,x18452_sum_1) , Some(me), List(x18454_ctrchain), 2, 1, 1, List(1), List(32), breakpoints, rr)
      x18469_inr_Reduce.sm.io.ctrDone := (x18469_inr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b18378_chain.connectStageCtrl((x18469_inr_Reduce.done).DS(1.toInt, rr, x18469_inr_Reduce.sm.io.backpressure), x18469_inr_Reduce.baseEn, 2)
      b18379_chain.connectStageCtrl((x18469_inr_Reduce.done).DS(1.toInt, rr, x18469_inr_Reduce.sm.io.backpressure), x18469_inr_Reduce.baseEn, 2)
      x18469_inr_Reduce.backpressure := true.B | x18469_inr_Reduce.sm.io.doneLatch
      x18469_inr_Reduce.forwardpressure := true.B | x18469_inr_Reduce.sm.io.doneLatch
      x18469_inr_Reduce.sm.io.enableOut.zip(x18469_inr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x18469_inr_Reduce.sm.io.break := false.B
      x18469_inr_Reduce.mask := ~x18469_inr_Reduce.cchain.head.output.noop & b18379_chain_read_2
      x18469_inr_Reduce.configure("x18469_inr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18469_inr_Reduce.kernel()
      val x18476_inr_UnitPipe = new x18476_inr_UnitPipe_kernel(List(b18379_chain_read_3), List(b18378_chain_read_3), List(x18452_sum_1), List(x18375_tmp75_SRAM_0) , Some(me), List(), 3, 1, 1, List(1), List(32), breakpoints, rr)
      x18476_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18476_inr_UnitPipe.sm.io.ctrInc)
      b18378_chain.connectStageCtrl((x18476_inr_UnitPipe.done).DS(1.toInt, rr, x18476_inr_UnitPipe.sm.io.backpressure), x18476_inr_UnitPipe.baseEn, 3)
      b18379_chain.connectStageCtrl((x18476_inr_UnitPipe.done).DS(1.toInt, rr, x18476_inr_UnitPipe.sm.io.backpressure), x18476_inr_UnitPipe.baseEn, 3)
      x18476_inr_UnitPipe.backpressure := true.B | x18476_inr_UnitPipe.sm.io.doneLatch
      x18476_inr_UnitPipe.forwardpressure := true.B | x18476_inr_UnitPipe.sm.io.doneLatch
      x18476_inr_UnitPipe.sm.io.enableOut.zip(x18476_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18476_inr_UnitPipe.sm.io.break := false.B
      x18476_inr_UnitPipe.mask := true.B & b18379_chain_read_3
      x18476_inr_UnitPipe.configure("x18476_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18476_inr_UnitPipe.kernel()
    }
    val module = Module(new x18477_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x18477_outr_Foreach **/
