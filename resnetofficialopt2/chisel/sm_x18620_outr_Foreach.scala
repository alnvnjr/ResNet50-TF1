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

/** Hierarchy: x18620 -> x1256 **/
/** BEGIN None x18620_outr_Foreach **/
class x18620_outr_Foreach_kernel(
  list_x3083_c90_DRAM: List[FixedPoint],
  list_x18504: List[DecoupledIO[AppCommandDense]],
  list_x18505: List[DecoupledIO[AppLoadData]],
  list_x18375_tmp75_SRAM_0: List[StandardInterface],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 3, isFSM = false   , latency = 0.0.toInt, myName = "x18620_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18620_outr_Foreach_iiCtr"))
  
  abstract class x18620_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18504 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18504_p").asInstanceOf[(Int,Int)] ))
      val in_x18375_tmp75_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18375_tmp75_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x18498_tmp76_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18498_tmp76_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_x3083_c90_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x18505 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x18505_p").asInstanceOf[(Int, Int)] )))
      val in_x18478_c87_SRAM_0 = Flipped(new StandardInterface(ModuleParams.getParams("x18478_c87_SRAM_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 1))
      val rr = Input(Bool())
    })
    def x18504 = {io.in_x18504} 
    def x18375_tmp75_SRAM_0 = {io.in_x18375_tmp75_SRAM_0} ; io.in_x18375_tmp75_SRAM_0 := DontCare
    def x18498_tmp76_SRAM_0 = {io.in_x18498_tmp76_SRAM_0} ; io.in_x18498_tmp76_SRAM_0 := DontCare
    def x3083_c90_DRAM = {io.in_x3083_c90_DRAM} 
    def x18505 = {io.in_x18505} 
    def x18478_c87_SRAM_0 = {io.in_x18478_c87_SRAM_0} ; io.in_x18478_c87_SRAM_0 := DontCare
  }
  def connectWires0(module: x18620_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18504 <> x18504
    x18375_tmp75_SRAM_0.connectLedger(module.io.in_x18375_tmp75_SRAM_0)
    x18498_tmp76_SRAM_0.connectLedger(module.io.in_x18498_tmp76_SRAM_0)
    module.io.in_x3083_c90_DRAM <> x3083_c90_DRAM
    module.io.in_x18505 <> x18505
    x18478_c87_SRAM_0.connectLedger(module.io.in_x18478_c87_SRAM_0)
  }
  val x3083_c90_DRAM = list_x3083_c90_DRAM(0)
  val x18504 = list_x18504(0)
  val x18505 = list_x18505(0)
  val x18375_tmp75_SRAM_0 = list_x18375_tmp75_SRAM_0(0)
  val x18498_tmp76_SRAM_0 = list_x18375_tmp75_SRAM_0(1)
  val x18478_c87_SRAM_0 = list_x18375_tmp75_SRAM_0(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18620_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x18620_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18620_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b18501 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b18501.suggestName("b18501")
      val b18501_chain = Module(new RegChainPass(3, 32, myName = "b18501_chain")); b18501_chain.io <> DontCare
      b18501_chain.chain_pass(b18501, io.sigsOut.smDoneIn.head)
      val b18501_chain_read_1 = b18501_chain.read(1).FP(true,32,0)
      val b18501_chain_read_2 = b18501_chain.read(2).FP(true,32,0)
      val b18502 = ~io.sigsIn.cchainOutputs.head.oobs(0); b18502.suggestName("b18502")
      val b18502_chain = Module(new RegChainPass(3, 1, myName = "b18502_chain")); b18502_chain.io <> DontCare
      b18502_chain.chain_pass(b18502, io.sigsOut.smDoneIn.head)
      val b18502_chain_read_1: Bool = b18502_chain.read(1).apply(0)
      val b18502_chain_read_2: Bool = b18502_chain.read(2).apply(0)
      val x18503_c90_row_SRAM_0 = (new x18503_c90_row_SRAM_0).m.io.asInstanceOf[NBufInterface]
      val x18549_outr_UnitPipe = new x18549_outr_UnitPipe_kernel(List(x18505), List(x18503_c90_row_SRAM_0), List(x3083_c90_DRAM,b18501), List(x18504), List(b18502) , Some(me), List(), 0, 2, 2, List(1), List(32), breakpoints, rr)
      b18501_chain.connectStageCtrl((x18549_outr_UnitPipe.done).DS(1.toInt, rr, x18549_outr_UnitPipe.sm.io.backpressure), x18549_outr_UnitPipe.baseEn, 0)
      b18502_chain.connectStageCtrl((x18549_outr_UnitPipe.done).DS(1.toInt, rr, x18549_outr_UnitPipe.sm.io.backpressure), x18549_outr_UnitPipe.baseEn, 0)
      x18549_outr_UnitPipe.backpressure := true.B | x18549_outr_UnitPipe.sm.io.doneLatch
      x18549_outr_UnitPipe.forwardpressure := true.B | x18549_outr_UnitPipe.sm.io.doneLatch
      x18549_outr_UnitPipe.sm.io.enableOut.zip(x18549_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18549_outr_UnitPipe.sm.io.break := false.B
      x18549_outr_UnitPipe.mask := true.B & b18502
      x18549_outr_UnitPipe.configure("x18549_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18549_outr_UnitPipe.kernel()
      val x18550_prod_0 = (new x18550_prod_0).m.io.asInstanceOf[FixOpAccumBundle]
      val x18551_prod_1 = (new x18551_prod_1).m.io.asInstanceOf[NBufInterface]
      val x18552_ctr = new CtrObject(Left(Some(0)), Left(Some(2048)), Left(Some(1)), 4, 32, false)
      val x18553_ctrchain = (new CChainObject(List[CtrObject](x18552_ctr), "x18553_ctrchain")).cchain.io 
      x18553_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x18553_ctrchain_p", (x18553_ctrchain.par, x18553_ctrchain.widths))
      val x18611_inr_Reduce = new x18611_inr_Reduce_kernel(List(b18502_chain_read_1), List(x18550_prod_0), List(x18503_c90_row_SRAM_0,x18551_prod_1), List(x18375_tmp75_SRAM_0) , Some(me), List(x18553_ctrchain), 1, 1, 1, List(4), List(32), breakpoints, rr)
      x18611_inr_Reduce.sm.io.ctrDone := (x18611_inr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b18501_chain.connectStageCtrl((x18611_inr_Reduce.done).DS(1.toInt, rr, x18611_inr_Reduce.sm.io.backpressure), x18611_inr_Reduce.baseEn, 1)
      b18502_chain.connectStageCtrl((x18611_inr_Reduce.done).DS(1.toInt, rr, x18611_inr_Reduce.sm.io.backpressure), x18611_inr_Reduce.baseEn, 1)
      x18611_inr_Reduce.backpressure := true.B | x18611_inr_Reduce.sm.io.doneLatch
      x18611_inr_Reduce.forwardpressure := true.B | x18611_inr_Reduce.sm.io.doneLatch
      x18611_inr_Reduce.sm.io.enableOut.zip(x18611_inr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x18611_inr_Reduce.sm.io.break := false.B
      x18611_inr_Reduce.mask := ~x18611_inr_Reduce.cchain.head.output.noop & b18502_chain_read_1
      x18611_inr_Reduce.configure("x18611_inr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18611_inr_Reduce.kernel()
      val x18619_inr_UnitPipe = new x18619_inr_UnitPipe_kernel(List(b18502_chain_read_2), List(b18501_chain_read_2), List(x18551_prod_1), List(x18498_tmp76_SRAM_0,x18478_c87_SRAM_0) , Some(me), List(), 2, 1, 1, List(1), List(32), breakpoints, rr)
      x18619_inr_UnitPipe.sm.io.ctrDone := risingEdge(x18619_inr_UnitPipe.sm.io.ctrInc)
      b18501_chain.connectStageCtrl((x18619_inr_UnitPipe.done).DS(1.toInt, rr, x18619_inr_UnitPipe.sm.io.backpressure), x18619_inr_UnitPipe.baseEn, 2)
      b18502_chain.connectStageCtrl((x18619_inr_UnitPipe.done).DS(1.toInt, rr, x18619_inr_UnitPipe.sm.io.backpressure), x18619_inr_UnitPipe.baseEn, 2)
      x18619_inr_UnitPipe.backpressure := true.B | x18619_inr_UnitPipe.sm.io.doneLatch
      x18619_inr_UnitPipe.forwardpressure := true.B | x18619_inr_UnitPipe.sm.io.doneLatch
      x18619_inr_UnitPipe.sm.io.enableOut.zip(x18619_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18619_inr_UnitPipe.sm.io.break := false.B
      x18619_inr_UnitPipe.mask := true.B & b18502_chain_read_2
      x18619_inr_UnitPipe.configure("x18619_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18619_inr_UnitPipe.kernel()
    }
    val module = Module(new x18620_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x18620_outr_Foreach **/
