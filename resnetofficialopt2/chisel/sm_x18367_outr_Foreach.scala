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

/** Hierarchy: x18367 -> x18369 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x18367_outr_Foreach **/
class x18367_outr_Foreach_kernel(
  list_x17719_reg: List[StandardInterface],
  list_x18216: List[DecoupledIO[AppStoreData]],
  list_x17883: List[DecoupledIO[AppLoadData]],
  list_x18215: List[DecoupledIO[AppCommandDense]],
  list_x18810_rd_x3920: List[Bool],
  list_x18217: List[DecoupledIO[Bool]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 4, isFSM = false   , latency = 0.0.toInt, myName = "x18367_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x18367_outr_Foreach_iiCtr"))
  
  abstract class x18367_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x18810_rd_x3920 = Input(Bool())
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x18215 = Decoupled(new AppCommandDense(ModuleParams.getParams("x18215_p").asInstanceOf[(Int,Int)] ))
      val in_x17719_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17719_reg_p").asInstanceOf[MemParams] ))
      val in_x17883 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17883_p").asInstanceOf[(Int, Int)] )))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x18216 = Decoupled(new AppStoreData(ModuleParams.getParams("x18216_p").asInstanceOf[(Int,Int)] ))
      val in_x9468_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9468_reg_p").asInstanceOf[MemParams] ))
      val in_x17882 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17882_p").asInstanceOf[(Int,Int)] ))
      val in_x17749 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17749_p").asInstanceOf[(Int,Int)] ))
      val in_x3921_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3921_reg_p").asInstanceOf[MemParams] ))
      val in_x9467_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9467_reg_p").asInstanceOf[MemParams] ))
      val in_x17717_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17717_reg_p").asInstanceOf[MemParams] ))
      val in_x17750 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x17750_p").asInstanceOf[(Int, Int)] )))
      val in_x18811_rd_x9467 = Input(Bool())
      val in_x18217 = Flipped(Decoupled(Bool()))
      val in_x17718_reg = Flipped(new StandardInterface(ModuleParams.getParams("x17718_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(4, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(4, 1))
      val rr = Input(Bool())
    })
    def x18810_rd_x3920 = {io.in_x18810_rd_x3920} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x18215 = {io.in_x18215} 
    def x17719_reg = {io.in_x17719_reg} ; io.in_x17719_reg := DontCare
    def x17883 = {io.in_x17883} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x18216 = {io.in_x18216} 
    def x9468_reg = {io.in_x9468_reg} ; io.in_x9468_reg := DontCare
    def x17882 = {io.in_x17882} 
    def x17749 = {io.in_x17749} 
    def x3921_reg = {io.in_x3921_reg} ; io.in_x3921_reg := DontCare
    def x9467_reg = {io.in_x9467_reg} ; io.in_x9467_reg := DontCare
    def x17717_reg = {io.in_x17717_reg} ; io.in_x17717_reg := DontCare
    def x17750 = {io.in_x17750} 
    def x18811_rd_x9467 = {io.in_x18811_rd_x9467} 
    def x18217 = {io.in_x18217} 
    def x17718_reg = {io.in_x17718_reg} ; io.in_x17718_reg := DontCare
  }
  def connectWires0(module: x18367_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x18810_rd_x3920 <> x18810_rd_x3920
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    module.io.in_x18215 <> x18215
    x17719_reg.connectLedger(module.io.in_x17719_reg)
    module.io.in_x17883 <> x17883
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    module.io.in_x18216 <> x18216
    x9468_reg.connectLedger(module.io.in_x9468_reg)
    module.io.in_x17882 <> x17882
    module.io.in_x17749 <> x17749
    x3921_reg.connectLedger(module.io.in_x3921_reg)
    x9467_reg.connectLedger(module.io.in_x9467_reg)
    x17717_reg.connectLedger(module.io.in_x17717_reg)
    module.io.in_x17750 <> x17750
    module.io.in_x18811_rd_x9467 <> x18811_rd_x9467
    module.io.in_x18217 <> x18217
    x17718_reg.connectLedger(module.io.in_x17718_reg)
  }
  val x17719_reg = list_x17719_reg(0)
  val x3920_reg = list_x17719_reg(1)
  val x9468_reg = list_x17719_reg(2)
  val x3921_reg = list_x17719_reg(3)
  val x9467_reg = list_x17719_reg(4)
  val x17717_reg = list_x17719_reg(5)
  val x17718_reg = list_x17719_reg(6)
  val x18216 = list_x18216(0)
  val x17883 = list_x17883(0)
  val x17750 = list_x17883(1)
  val x18215 = list_x18215(0)
  val x17882 = list_x18215(1)
  val x17749 = list_x18215(2)
  val x18810_rd_x3920 = list_x18810_rd_x3920(0)
  val x18811_rd_x9467 = list_x18810_rd_x3920(1)
  val x18217 = list_x18217(0)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x18367_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x18367_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x18367_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b17746 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b17746.suggestName("b17746")
      val b17746_chain = Module(new RegChainPass(4, 32, myName = "b17746_chain")); b17746_chain.io <> DontCare
      b17746_chain.chain_pass(b17746, io.sigsOut.smDoneIn.head)
      val b17746_chain_read_1 = b17746_chain.read(1).FP(true,32,0)
      val b17746_chain_read_2 = b17746_chain.read(2).FP(true,32,0)
      val b17746_chain_read_3 = b17746_chain.read(3).FP(true,32,0)
      val b17747 = ~io.sigsIn.cchainOutputs.head.oobs(0); b17747.suggestName("b17747")
      val b17747_chain = Module(new RegChainPass(4, 1, myName = "b17747_chain")); b17747_chain.io <> DontCare
      b17747_chain.chain_pass(b17747, io.sigsOut.smDoneIn.head)
      val b17747_chain_read_1: Bool = b17747_chain.read(1).apply(0)
      val b17747_chain_read_2: Bool = b17747_chain.read(2).apply(0)
      val b17747_chain_read_3: Bool = b17747_chain.read(3).apply(0)
      val x17748_feature_map_a_0 = (new x17748_feature_map_a_0).m.io.asInstanceOf[NBufInterface]
      val x17880_outr_UnitPipe = new x17880_outr_UnitPipe_kernel(List(x2682_tmp_DRAM,b17746), List(x17749), List(b17747), List(x17748_feature_map_a_0), List(x17750), List(x17717_reg) , Some(me), List(), 0, 2, 2, List(1), List(32), breakpoints, rr)
      b17746_chain.connectStageCtrl((x17880_outr_UnitPipe.done).DS(1.toInt, rr, x17880_outr_UnitPipe.sm.io.backpressure), x17880_outr_UnitPipe.baseEn, 0)
      b17747_chain.connectStageCtrl((x17880_outr_UnitPipe.done).DS(1.toInt, rr, x17880_outr_UnitPipe.sm.io.backpressure), x17880_outr_UnitPipe.baseEn, 0)
      x17880_outr_UnitPipe.backpressure := true.B | x17880_outr_UnitPipe.sm.io.doneLatch
      x17880_outr_UnitPipe.forwardpressure := true.B | x17880_outr_UnitPipe.sm.io.doneLatch
      x17880_outr_UnitPipe.sm.io.enableOut.zip(x17880_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x17880_outr_UnitPipe.sm.io.break := false.B
      x17880_outr_UnitPipe.mask := true.B & b17747
      x17880_outr_UnitPipe.configure("x17880_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17880_outr_UnitPipe.kernel()
      val x17881_feature_map_b_0 = (new x17881_feature_map_b_0).m.io.asInstanceOf[NBufInterface]
      val x18013_outr_UnitPipe = new x18013_outr_UnitPipe_kernel(List(x17883), List(x17882), List(x2682_tmp_DRAM,b17746_chain_read_1), List(x17718_reg), List(x17748_feature_map_a_0,x17881_feature_map_b_0), List(b17747_chain_read_1) , Some(me), List(), 1, 2, 2, List(1), List(32), breakpoints, rr)
      b17746_chain.connectStageCtrl((x18013_outr_UnitPipe.done).DS(1.toInt, rr, x18013_outr_UnitPipe.sm.io.backpressure), x18013_outr_UnitPipe.baseEn, 1)
      b17747_chain.connectStageCtrl((x18013_outr_UnitPipe.done).DS(1.toInt, rr, x18013_outr_UnitPipe.sm.io.backpressure), x18013_outr_UnitPipe.baseEn, 1)
      x18013_outr_UnitPipe.backpressure := true.B | x18013_outr_UnitPipe.sm.io.doneLatch
      x18013_outr_UnitPipe.forwardpressure := true.B | x18013_outr_UnitPipe.sm.io.doneLatch
      x18013_outr_UnitPipe.sm.io.enableOut.zip(x18013_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18013_outr_UnitPipe.sm.io.break := false.B
      x18013_outr_UnitPipe.mask := true.B & b17747_chain_read_1
      x18013_outr_UnitPipe.configure("x18013_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18013_outr_UnitPipe.kernel()
      val x18014_feature_map_sum_0 = (new x18014_feature_map_sum_0).m.io.asInstanceOf[NBufInterface]
      val x18015_ctr = new CtrObject(Left(Some(0)), Left(Some(3136)), Left(Some(1)), 16, 32, false)
      val x18016_ctrchain = (new CChainObject(List[CtrObject](x18015_ctr), "x18016_ctrchain")).cchain.io 
      x18016_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x18016_ctrchain_p", (x18016_ctrchain.par, x18016_ctrchain.widths))
      val x18812_rd_x3921 = Wire(Bool()).suggestName("""x18812_rd_x3921""")
      val x18812_rd_x3921_banks = List[UInt]()
      val x18812_rd_x3921_ofs = List[UInt]()
      val x18812_rd_x3921_en = List[Bool](true.B)
      x18812_rd_x3921.toSeq.zip(x3921_reg.connectRPort(18812, x18812_rd_x3921_banks, x18812_rd_x3921_ofs, io.sigsIn.backpressure, x18812_rd_x3921_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18813_rd_x9468 = Wire(Bool()).suggestName("""x18813_rd_x9468""")
      val x18813_rd_x9468_banks = List[UInt]()
      val x18813_rd_x9468_ofs = List[UInt]()
      val x18813_rd_x9468_en = List[Bool](true.B)
      x18813_rd_x9468.toSeq.zip(x9468_reg.connectRPort(18813, x18813_rd_x9468_banks, x18813_rd_x9468_ofs, io.sigsIn.backpressure, x18813_rd_x9468_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18214_inr_Foreach = new x18214_inr_Foreach_kernel(List(b17747_chain_read_2,x18813_rd_x9468,x18812_rd_x3921), List(x17748_feature_map_a_0,x17881_feature_map_b_0,x18014_feature_map_sum_0), List(x3920_reg,x9467_reg) , Some(me), List(x18016_ctrchain), 2, 1, 1, List(16), List(32), breakpoints, rr)
      x18214_inr_Foreach.sm.io.ctrDone := (x18214_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b17746_chain.connectStageCtrl((x18214_inr_Foreach.done).DS(1.toInt, rr, x18214_inr_Foreach.sm.io.backpressure), x18214_inr_Foreach.baseEn, 2)
      b17747_chain.connectStageCtrl((x18214_inr_Foreach.done).DS(1.toInt, rr, x18214_inr_Foreach.sm.io.backpressure), x18214_inr_Foreach.baseEn, 2)
      x18214_inr_Foreach.backpressure := true.B | x18214_inr_Foreach.sm.io.doneLatch
      x18214_inr_Foreach.forwardpressure := true.B | x18214_inr_Foreach.sm.io.doneLatch
      x18214_inr_Foreach.sm.io.enableOut.zip(x18214_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x18214_inr_Foreach.sm.io.break := false.B
      x18214_inr_Foreach.mask := ~x18214_inr_Foreach.cchain.head.output.noop & b17747_chain_read_2 & x18812_rd_x3921 & x18813_rd_x9468
      x18214_inr_Foreach.configure("x18214_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18214_inr_Foreach.kernel()
      val x18366_outr_UnitPipe = new x18366_outr_UnitPipe_kernel(List(x18216), List(x2682_tmp_DRAM,b17746_chain_read_3), List(x17719_reg), List(x18215), List(b17747_chain_read_3), List(x18217), List(x18014_feature_map_sum_0) , Some(me), List(), 3, 3, 3, List(1), List(32), breakpoints, rr)
      b17746_chain.connectStageCtrl((x18366_outr_UnitPipe.done).DS(1.toInt, rr, x18366_outr_UnitPipe.sm.io.backpressure), x18366_outr_UnitPipe.baseEn, 3)
      b17747_chain.connectStageCtrl((x18366_outr_UnitPipe.done).DS(1.toInt, rr, x18366_outr_UnitPipe.sm.io.backpressure), x18366_outr_UnitPipe.baseEn, 3)
      x18366_outr_UnitPipe.backpressure := true.B | x18366_outr_UnitPipe.sm.io.doneLatch
      x18366_outr_UnitPipe.forwardpressure := true.B | x18366_outr_UnitPipe.sm.io.doneLatch
      x18366_outr_UnitPipe.sm.io.enableOut.zip(x18366_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x18366_outr_UnitPipe.sm.io.break := false.B
      x18366_outr_UnitPipe.mask := true.B & b17747_chain_read_3
      x18366_outr_UnitPipe.configure("x18366_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x18366_outr_UnitPipe.kernel()
    }
    val module = Module(new x18367_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x18367_outr_Foreach **/
