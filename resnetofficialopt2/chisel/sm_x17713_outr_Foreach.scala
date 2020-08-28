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

/** Hierarchy: x17713 -> x17715 -> x18370 -> x18372 -> x18373 -> x18374 -> x1256 **/
/** BEGIN None x17713_outr_Foreach **/
class x17713_outr_Foreach_kernel(
  list_x9485_reg: List[StandardInterface],
  list_x9593: List[DecoupledIO[AppCommandDense]],
  list_x2682_tmp_DRAM: List[FixedPoint],
  list_x9561: List[DecoupledIO[AppLoadData]],
  list_x17552: List[DecoupledIO[Bool]],
  list_x17551: List[DecoupledIO[AppStoreData]],
  list_x18787_rd_x3920: List[Bool],
  parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 7, isFSM = false   , latency = 0.0.toInt, myName = "x17713_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + fringe.utils.log2Up(1.0.toInt), "x17713_outr_Foreach_iiCtr"))
  
  abstract class x17713_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x9485_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9485_reg_p").asInstanceOf[MemParams] ))
      val in_x9465_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9465_reg_p").asInstanceOf[MemParams] ))
      val in_x9561 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9561_p").asInstanceOf[(Int, Int)] )))
      val in_x2682_tmp_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9497_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9497_reg_p").asInstanceOf[MemParams] ))
      val in_x9593 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9593_p").asInstanceOf[(Int,Int)] ))
      val in_x9490_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9490_reg_p").asInstanceOf[MemParams] ))
      val in_x9488_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9488_reg_p").asInstanceOf[MemParams] ))
      val in_x9868 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9868_p").asInstanceOf[(Int, Int)] )))
      val in_x9493_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9493_reg_p").asInstanceOf[MemParams] ))
      val in_x17550 = Decoupled(new AppCommandDense(ModuleParams.getParams("x17550_p").asInstanceOf[(Int,Int)] ))
      val in_x9498_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9498_reg_p").asInstanceOf[MemParams] ))
      val in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x3920_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3920_reg_p").asInstanceOf[MemParams] ))
      val in_x9484_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9484_reg_p").asInstanceOf[MemParams] ))
      val in_x18787_rd_x3920 = Input(Bool())
      val in_x9496_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9496_reg_p").asInstanceOf[MemParams] ))
      val in_x9560 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9560_p").asInstanceOf[(Int,Int)] ))
      val in_x9867 = Decoupled(new AppCommandDense(ModuleParams.getParams("x9867_p").asInstanceOf[(Int,Int)] ))
      val in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = Input(new FixedPoint(true, 64, 0))
      val in_x9491_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9491_reg_p").asInstanceOf[MemParams] ))
      val in_x9487_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9487_reg_p").asInstanceOf[MemParams] ))
      val in_x9492_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9492_reg_p").asInstanceOf[MemParams] ))
      val in_x9595 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x9595_p").asInstanceOf[(Int, Int)] )))
      val in_x3921_reg = Flipped(new StandardInterface(ModuleParams.getParams("x3921_reg_p").asInstanceOf[MemParams] ))
      val in_x17551 = Decoupled(new AppStoreData(ModuleParams.getParams("x17551_p").asInstanceOf[(Int,Int)] ))
      val in_x18788_rd_x9465 = Input(Bool())
      val in_x9486_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9486_reg_p").asInstanceOf[MemParams] ))
      val in_x9495_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9495_reg_p").asInstanceOf[MemParams] ))
      val in_x17552 = Flipped(Decoupled(Bool()))
      val in_x9466_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9466_reg_p").asInstanceOf[MemParams] ))
      val in_x9489_reg = Flipped(new StandardInterface(ModuleParams.getParams("x9489_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(7, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(7, 1))
      val rr = Input(Bool())
    })
    def x9485_reg = {io.in_x9485_reg} ; io.in_x9485_reg := DontCare
    def x9465_reg = {io.in_x9465_reg} ; io.in_x9465_reg := DontCare
    def x9561 = {io.in_x9561} 
    def x2682_tmp_DRAM = {io.in_x2682_tmp_DRAM} 
    def x9497_reg = {io.in_x9497_reg} ; io.in_x9497_reg := DontCare
    def x9593 = {io.in_x9593} 
    def x9490_reg = {io.in_x9490_reg} ; io.in_x9490_reg := DontCare
    def x9488_reg = {io.in_x9488_reg} ; io.in_x9488_reg := DontCare
    def x9868 = {io.in_x9868} 
    def x9493_reg = {io.in_x9493_reg} ; io.in_x9493_reg := DontCare
    def x17550 = {io.in_x17550} 
    def x9498_reg = {io.in_x9498_reg} ; io.in_x9498_reg := DontCare
    def x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = {io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM} 
    def x3920_reg = {io.in_x3920_reg} ; io.in_x3920_reg := DontCare
    def x9484_reg = {io.in_x9484_reg} ; io.in_x9484_reg := DontCare
    def x18787_rd_x3920 = {io.in_x18787_rd_x3920} 
    def x9496_reg = {io.in_x9496_reg} ; io.in_x9496_reg := DontCare
    def x9560 = {io.in_x9560} 
    def x9867 = {io.in_x9867} 
    def x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = {io.in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM} 
    def x9491_reg = {io.in_x9491_reg} ; io.in_x9491_reg := DontCare
    def x9487_reg = {io.in_x9487_reg} ; io.in_x9487_reg := DontCare
    def x9492_reg = {io.in_x9492_reg} ; io.in_x9492_reg := DontCare
    def x9595 = {io.in_x9595} 
    def x3921_reg = {io.in_x3921_reg} ; io.in_x3921_reg := DontCare
    def x17551 = {io.in_x17551} 
    def x18788_rd_x9465 = {io.in_x18788_rd_x9465} 
    def x9486_reg = {io.in_x9486_reg} ; io.in_x9486_reg := DontCare
    def x9495_reg = {io.in_x9495_reg} ; io.in_x9495_reg := DontCare
    def x17552 = {io.in_x17552} 
    def x9466_reg = {io.in_x9466_reg} ; io.in_x9466_reg := DontCare
    def x9489_reg = {io.in_x9489_reg} ; io.in_x9489_reg := DontCare
  }
  def connectWires0(module: x17713_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x9485_reg.connectLedger(module.io.in_x9485_reg)
    x9465_reg.connectLedger(module.io.in_x9465_reg)
    module.io.in_x9561 <> x9561
    module.io.in_x2682_tmp_DRAM <> x2682_tmp_DRAM
    x9497_reg.connectLedger(module.io.in_x9497_reg)
    module.io.in_x9593 <> x9593
    x9490_reg.connectLedger(module.io.in_x9490_reg)
    x9488_reg.connectLedger(module.io.in_x9488_reg)
    module.io.in_x9868 <> x9868
    x9493_reg.connectLedger(module.io.in_x9493_reg)
    module.io.in_x17550 <> x17550
    x9498_reg.connectLedger(module.io.in_x9498_reg)
    module.io.in_x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM <> x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM
    x3920_reg.connectLedger(module.io.in_x3920_reg)
    x9484_reg.connectLedger(module.io.in_x9484_reg)
    module.io.in_x18787_rd_x3920 <> x18787_rd_x3920
    x9496_reg.connectLedger(module.io.in_x9496_reg)
    module.io.in_x9560 <> x9560
    module.io.in_x9867 <> x9867
    module.io.in_x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM <> x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM
    x9491_reg.connectLedger(module.io.in_x9491_reg)
    x9487_reg.connectLedger(module.io.in_x9487_reg)
    x9492_reg.connectLedger(module.io.in_x9492_reg)
    module.io.in_x9595 <> x9595
    x3921_reg.connectLedger(module.io.in_x3921_reg)
    module.io.in_x17551 <> x17551
    module.io.in_x18788_rd_x9465 <> x18788_rd_x9465
    x9486_reg.connectLedger(module.io.in_x9486_reg)
    x9495_reg.connectLedger(module.io.in_x9495_reg)
    module.io.in_x17552 <> x17552
    x9466_reg.connectLedger(module.io.in_x9466_reg)
    x9489_reg.connectLedger(module.io.in_x9489_reg)
  }
  val x9485_reg = list_x9485_reg(0)
  val x9465_reg = list_x9485_reg(1)
  val x9497_reg = list_x9485_reg(2)
  val x9490_reg = list_x9485_reg(3)
  val x9488_reg = list_x9485_reg(4)
  val x9493_reg = list_x9485_reg(5)
  val x9498_reg = list_x9485_reg(6)
  val x3920_reg = list_x9485_reg(7)
  val x9484_reg = list_x9485_reg(8)
  val x9496_reg = list_x9485_reg(9)
  val x9491_reg = list_x9485_reg(10)
  val x9487_reg = list_x9485_reg(11)
  val x9492_reg = list_x9485_reg(12)
  val x3921_reg = list_x9485_reg(13)
  val x9486_reg = list_x9485_reg(14)
  val x9495_reg = list_x9485_reg(15)
  val x9466_reg = list_x9485_reg(16)
  val x9489_reg = list_x9485_reg(17)
  val x9593 = list_x9593(0)
  val x17550 = list_x9593(1)
  val x9560 = list_x9593(2)
  val x9867 = list_x9593(3)
  val x2682_tmp_DRAM = list_x2682_tmp_DRAM(0)
  val x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = list_x2682_tmp_DRAM(1)
  val x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = list_x2682_tmp_DRAM(2)
  val x9561 = list_x9561(0)
  val x9868 = list_x9561(1)
  val x9595 = list_x9561(2)
  val x17552 = list_x17552(0)
  val x17551 = list_x17551(0)
  val x18787_rd_x3920 = list_x18787_rd_x3920(0)
  val x18788_rd_x9465 = list_x18787_rd_x3920(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x17713_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x17713_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x17713_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b9552 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b9552.suggestName("b9552")
      val b9552_chain = Module(new RegChainPass(7, 32, myName = "b9552_chain")); b9552_chain.io <> DontCare
      b9552_chain.chain_pass(b9552, io.sigsOut.smDoneIn.head)
      val b9552_chain_read_1 = b9552_chain.read(1).FP(true,32,0)
      val b9552_chain_read_2 = b9552_chain.read(2).FP(true,32,0)
      val b9552_chain_read_3 = b9552_chain.read(3).FP(true,32,0)
      val b9552_chain_read_4 = b9552_chain.read(4).FP(true,32,0)
      val b9552_chain_read_5 = b9552_chain.read(5).FP(true,32,0)
      val b9552_chain_read_6 = b9552_chain.read(6).FP(true,32,0)
      val b9553 = ~io.sigsIn.cchainOutputs.head.oobs(0); b9553.suggestName("b9553")
      val b9553_chain = Module(new RegChainPass(7, 1, myName = "b9553_chain")); b9553_chain.io <> DontCare
      b9553_chain.chain_pass(b9553, io.sigsOut.smDoneIn.head)
      val b9553_chain_read_1: Bool = b9553_chain.read(1).apply(0)
      val b9553_chain_read_2: Bool = b9553_chain.read(2).apply(0)
      val b9553_chain_read_3: Bool = b9553_chain.read(3).apply(0)
      val b9553_chain_read_4: Bool = b9553_chain.read(4).apply(0)
      val b9553_chain_read_5: Bool = b9553_chain.read(5).apply(0)
      val b9553_chain_read_6: Bool = b9553_chain.read(6).apply(0)
      val x9554_bias_SRAM_0 = (new x9554_bias_SRAM_0).m.io.asInstanceOf[NBufInterface]
      val x9555_reg = (new x9555_reg).m.io.asInstanceOf[NBufInterface]
      val x9559_inr_UnitPipe = new x9559_inr_UnitPipe_kernel(List(b9553), List(b9552), List(x9555_reg), List(x9484_reg) , Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x9559_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9559_inr_UnitPipe.sm.io.ctrInc)
      b9552_chain.connectStageCtrl((x9559_inr_UnitPipe.done).DS(1.toInt, rr, x9559_inr_UnitPipe.sm.io.backpressure), x9559_inr_UnitPipe.baseEn, 0)
      b9553_chain.connectStageCtrl((x9559_inr_UnitPipe.done).DS(1.toInt, rr, x9559_inr_UnitPipe.sm.io.backpressure), x9559_inr_UnitPipe.baseEn, 0)
      x9559_inr_UnitPipe.backpressure := true.B | x9559_inr_UnitPipe.sm.io.doneLatch
      x9559_inr_UnitPipe.forwardpressure := true.B | x9559_inr_UnitPipe.sm.io.doneLatch
      x9559_inr_UnitPipe.sm.io.enableOut.zip(x9559_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9559_inr_UnitPipe.sm.io.break := false.B
      x9559_inr_UnitPipe.mask := true.B & b9553
      x9559_inr_UnitPipe.configure("x9559_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9559_inr_UnitPipe.kernel()
      val x9582_outr_UnitPipe = new x9582_outr_UnitPipe_kernel(List(x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM), List(b9553_chain_read_1), List(x9554_bias_SRAM_0,x9555_reg), List(x9561), List(x9560) , Some(me), List(), 1, 2, 2, List(1), List(32), breakpoints, rr)
      b9552_chain.connectStageCtrl((x9582_outr_UnitPipe.done).DS(1.toInt, rr, x9582_outr_UnitPipe.sm.io.backpressure), x9582_outr_UnitPipe.baseEn, 1)
      b9553_chain.connectStageCtrl((x9582_outr_UnitPipe.done).DS(1.toInt, rr, x9582_outr_UnitPipe.sm.io.backpressure), x9582_outr_UnitPipe.baseEn, 1)
      x9582_outr_UnitPipe.backpressure := true.B | x9582_outr_UnitPipe.sm.io.doneLatch
      x9582_outr_UnitPipe.forwardpressure := true.B | x9582_outr_UnitPipe.sm.io.doneLatch
      x9582_outr_UnitPipe.sm.io.enableOut.zip(x9582_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9582_outr_UnitPipe.sm.io.break := false.B
      x9582_outr_UnitPipe.mask := true.B & b9553_chain_read_1
      x9582_outr_UnitPipe.configure("x9582_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9582_outr_UnitPipe.kernel()
      val x9583_weight_SRAM_0 = (new x9583_weight_SRAM_0).m.io.asInstanceOf[NBufInterface]
      val x9584_reg = (new x9584_reg).m.io.asInstanceOf[NBufInterface]
      val x9588_inr_UnitPipe = new x9588_inr_UnitPipe_kernel(List(b9553_chain_read_2), List(b9552_chain_read_2), List(x9498_reg), List(x9584_reg,x9554_bias_SRAM_0) , Some(me), List(), 2, 1, 1, List(1), List(32), breakpoints, rr)
      x9588_inr_UnitPipe.sm.io.ctrDone := risingEdge(x9588_inr_UnitPipe.sm.io.ctrInc)
      b9552_chain.connectStageCtrl((x9588_inr_UnitPipe.done).DS(1.toInt, rr, x9588_inr_UnitPipe.sm.io.backpressure), x9588_inr_UnitPipe.baseEn, 2)
      b9553_chain.connectStageCtrl((x9588_inr_UnitPipe.done).DS(1.toInt, rr, x9588_inr_UnitPipe.sm.io.backpressure), x9588_inr_UnitPipe.baseEn, 2)
      x9588_inr_UnitPipe.backpressure := true.B | x9588_inr_UnitPipe.sm.io.doneLatch
      x9588_inr_UnitPipe.forwardpressure := true.B | x9588_inr_UnitPipe.sm.io.doneLatch
      x9588_inr_UnitPipe.sm.io.enableOut.zip(x9588_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x9588_inr_UnitPipe.sm.io.break := false.B
      x9588_inr_UnitPipe.mask := true.B & b9553_chain_read_2
      x9588_inr_UnitPipe.configure("x9588_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9588_inr_UnitPipe.kernel()
      val x9589_ctr = new CtrObject(Left(Some(0)), Left(Some(32)), Left(Some(1)), 1, 32, false)
      val x9590_ctrchain_copyx9624_inr_UnitPipe = (new CChainObject(List[CtrObject](x9589_ctr), "x9590_ctrchain_copyx9624_inr_UnitPipe")).cchain.io 
      x9590_ctrchain_copyx9624_inr_UnitPipe.setup.isStream := false.B
      ModuleParams.addParams("x9590_ctrchain_p", (x9590_ctrchain_copyx9624_inr_UnitPipe.par, x9590_ctrchain_copyx9624_inr_UnitPipe.widths))
      val x9590_ctrchain_copyx9765_outr_UnitPipe = (new CChainObject(List[CtrObject](x9589_ctr), "x9590_ctrchain_copyx9765_outr_UnitPipe")).cchain.io 
      x9590_ctrchain_copyx9765_outr_UnitPipe.setup.isStream := false.B
      ModuleParams.addParams("x9590_ctrchain_p", (x9590_ctrchain_copyx9624_inr_UnitPipe.par, x9590_ctrchain_copyx9624_inr_UnitPipe.widths))
      val x9766_outr_Foreach = new x9766_outr_Foreach_kernel(List(x9593), List(x9584_reg,x9554_bias_SRAM_0,x9583_weight_SRAM_0), List(b9553_chain_read_3), List(x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM), List(x9487_reg), List(x9595) , Some(me), List(x9590_ctrchain_copyx9624_inr_UnitPipe,x9590_ctrchain_copyx9765_outr_UnitPipe), 3, 2, 2, List(1), List(32), breakpoints, rr)
      b9552_chain.connectStageCtrl((x9766_outr_Foreach.done).DS(1.toInt, rr, x9766_outr_Foreach.sm.io.backpressure), x9766_outr_Foreach.baseEn, 3)
      b9553_chain.connectStageCtrl((x9766_outr_Foreach.done).DS(1.toInt, rr, x9766_outr_Foreach.sm.io.backpressure), x9766_outr_Foreach.baseEn, 3)
      x9766_outr_Foreach.backpressure := true.B | x9766_outr_Foreach.sm.io.doneLatch
      x9766_outr_Foreach.forwardpressure := true.B | x9766_outr_Foreach.sm.io.doneLatch
      x9766_outr_Foreach.sm.io.enableOut.zip(x9766_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x9766_outr_Foreach.sm.io.break := false.B
      x9766_outr_Foreach.mask := ~x9766_outr_Foreach.cchain.head.output.noop & b9553_chain_read_3
      x9766_outr_Foreach.configure("x9766_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9766_outr_Foreach.kernel()
      val x9767_weight_SRAM_reshape_0 = (new x9767_weight_SRAM_reshape_0).m.io.asInstanceOf[NBufInterface]
      val x18790_rd_x9487 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18790_rd_x9487""")
      val x18790_rd_x9487_banks = List[UInt]()
      val x18790_rd_x9487_ofs = List[UInt]()
      val x18790_rd_x9487_en = List[Bool](true.B)
      x18790_rd_x9487.toSeq.zip(x9487_reg.connectRPort(18790, x18790_rd_x9487_banks, x18790_rd_x9487_ofs, io.sigsIn.backpressure, x18790_rd_x9487_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9769_ctr = new CtrObject(Left(Some(0)), Right(x18790_rd_x9487), Left(Some(1)), 1, 32, false)
      val x9770_ctr = new CtrObject(Left(Some(0)), Left(Some(32)), Left(Some(1)), 4, 32, false)
      val x9771_ctrchain = (new CChainObject(List[CtrObject](x9769_ctr,x9770_ctr), "x9771_ctrchain")).cchain.io 
      x9771_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x9771_ctrchain_p", (x9771_ctrchain.par, x9771_ctrchain.widths))
      val x18791_rd_x3921 = Wire(Bool()).suggestName("""x18791_rd_x3921""")
      val x18791_rd_x3921_banks = List[UInt]()
      val x18791_rd_x3921_ofs = List[UInt]()
      val x18791_rd_x3921_en = List[Bool](true.B)
      x18791_rd_x3921.toSeq.zip(x3921_reg.connectRPort(18791, x18791_rd_x3921_banks, x18791_rd_x3921_ofs, io.sigsIn.backpressure, x18791_rd_x3921_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18792_rd_x9466 = Wire(Bool()).suggestName("""x18792_rd_x9466""")
      val x18792_rd_x9466_banks = List[UInt]()
      val x18792_rd_x9466_ofs = List[UInt]()
      val x18792_rd_x9466_en = List[Bool](true.B)
      x18792_rd_x9466.toSeq.zip(x9466_reg.connectRPort(18792, x18792_rd_x9466_banks, x18792_rd_x9466_ofs, io.sigsIn.backpressure, x18792_rd_x9466_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9843_inr_Foreach = new x9843_inr_Foreach_kernel(List(x18792_rd_x9466,b9553_chain_read_4,x18791_rd_x3921), List(x9554_bias_SRAM_0,x9767_weight_SRAM_reshape_0,x9583_weight_SRAM_0), List(x9465_reg,x3920_reg) , Some(me), List(x9771_ctrchain), 4, 1, 1, List(1, 4), List(32, 32), breakpoints, rr)
      x9843_inr_Foreach.sm.io.ctrDone := (x9843_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b9552_chain.connectStageCtrl((x9843_inr_Foreach.done).DS(1.toInt, rr, x9843_inr_Foreach.sm.io.backpressure), x9843_inr_Foreach.baseEn, 4)
      b9553_chain.connectStageCtrl((x9843_inr_Foreach.done).DS(1.toInt, rr, x9843_inr_Foreach.sm.io.backpressure), x9843_inr_Foreach.baseEn, 4)
      x9843_inr_Foreach.backpressure := true.B | x9843_inr_Foreach.sm.io.doneLatch
      x9843_inr_Foreach.forwardpressure := true.B | x9843_inr_Foreach.sm.io.doneLatch
      x9843_inr_Foreach.sm.io.enableOut.zip(x9843_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x9843_inr_Foreach.sm.io.break := false.B
      x9843_inr_Foreach.mask := ~x9843_inr_Foreach.cchain.head.output.noop & b9553_chain_read_4 & x18791_rd_x3921 & x18792_rd_x9466
      x9843_inr_Foreach.configure("x9843_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x9843_inr_Foreach.kernel()
      val x9844_out_SRAM_conv_0 = (new x9844_out_SRAM_conv_0).m.io.asInstanceOf[StandardInterface]
      val x9845_out_SRAM_conv_1 = (new x9845_out_SRAM_conv_1).m.io.asInstanceOf[NBufInterface]
      val x18793_rd_x9486 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18793_rd_x9486""")
      val x18793_rd_x9486_banks = List[UInt]()
      val x18793_rd_x9486_ofs = List[UInt]()
      val x18793_rd_x9486_en = List[Bool](true.B)
      x18793_rd_x9486.toSeq.zip(x9486_reg.connectRPort(18793, x18793_rd_x9486_banks, x18793_rd_x9486_ofs, io.sigsIn.backpressure, x18793_rd_x9486_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18794_rd_x9487 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x18794_rd_x9487""")
      val x18794_rd_x9487_banks = List[UInt]()
      val x18794_rd_x9487_ofs = List[UInt]()
      val x18794_rd_x9487_en = List[Bool](true.B)
      x18794_rd_x9487.toSeq.zip(x9487_reg.connectRPort(18794, x18794_rd_x9487_banks, x18794_rd_x9487_ofs, io.sigsIn.backpressure, x18794_rd_x9487_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x9848_ctr = new CtrObject(Left(Some(0)), Right(x18794_rd_x9487), Right(x18793_rd_x9486), 1, 32, false)
      val x9849_ctrchain = (new CChainObject(List[CtrObject](x9848_ctr), "x9849_ctrchain")).cchain.io 
      x9849_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x9849_ctrchain_p", (x9849_ctrchain.par, x9849_ctrchain.widths))
      val x18795_rd_x3920 = Wire(Bool()).suggestName("""x18795_rd_x3920""")
      val x18795_rd_x3920_banks = List[UInt]()
      val x18795_rd_x3920_ofs = List[UInt]()
      val x18795_rd_x3920_en = List[Bool](true.B)
      x18795_rd_x3920.toSeq.zip(x3920_reg.connectRPort(18795, x18795_rd_x3920_banks, x18795_rd_x3920_ofs, io.sigsIn.backpressure, x18795_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18796_rd_x9465 = Wire(Bool()).suggestName("""x18796_rd_x9465""")
      val x18796_rd_x9465_banks = List[UInt]()
      val x18796_rd_x9465_ofs = List[UInt]()
      val x18796_rd_x9465_en = List[Bool](true.B)
      x18796_rd_x9465.toSeq.zip(x9465_reg.connectRPort(18796, x18796_rd_x9465_banks, x18796_rd_x9465_ofs, io.sigsIn.backpressure, x18796_rd_x9465_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17297_outr_Foreach = new x17297_outr_Foreach_kernel(List(x9845_out_SRAM_conv_1,x9554_bias_SRAM_0,x9767_weight_SRAM_reshape_0), List(x9485_reg,x9465_reg,x9490_reg,x9488_reg,x3920_reg,x9496_reg,x9492_reg,x3921_reg,x9486_reg,x9844_out_SRAM_conv_0,x9466_reg,x9489_reg), List(x9867), List(x9868), List(x2682_tmp_DRAM), List(x18796_rd_x9465,x18795_rd_x3920,b9553_chain_read_5) , Some(me), List(x9849_ctrchain), 5, 3, 1, List(1), List(32), breakpoints, rr)
      x17297_outr_Foreach.sm.io.ctrDone := (x17297_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b9552_chain.connectStageCtrl((x17297_outr_Foreach.done).DS(1.toInt, rr, x17297_outr_Foreach.sm.io.backpressure), x17297_outr_Foreach.baseEn, 5)
      b9553_chain.connectStageCtrl((x17297_outr_Foreach.done).DS(1.toInt, rr, x17297_outr_Foreach.sm.io.backpressure), x17297_outr_Foreach.baseEn, 5)
      x17297_outr_Foreach.backpressure := true.B | x17297_outr_Foreach.sm.io.doneLatch
      x17297_outr_Foreach.forwardpressure := true.B | x17297_outr_Foreach.sm.io.doneLatch
      x17297_outr_Foreach.sm.io.enableOut.zip(x17297_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x17297_outr_Foreach.sm.io.break := false.B
      x17297_outr_Foreach.mask := ~x17297_outr_Foreach.cchain.head.output.noop & b9553_chain_read_5 & x18795_rd_x3920 & x18796_rd_x9465
      x17297_outr_Foreach.configure("x17297_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17297_outr_Foreach.kernel()
      val x17298_ctr = new CtrObject(Left(Some(0)), Left(Some(32)), Left(Some(1)), 1, 32, false)
      val x17299_ctrchain = (new CChainObject(List[CtrObject](x17298_ctr), "x17299_ctrchain")).cchain.io 
      x17299_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x17299_ctrchain_p", (x17299_ctrchain.par, x17299_ctrchain.widths))
      val x18802_rd_x3920 = Wire(Bool()).suggestName("""x18802_rd_x3920""")
      val x18802_rd_x3920_banks = List[UInt]()
      val x18802_rd_x3920_ofs = List[UInt]()
      val x18802_rd_x3920_en = List[Bool](true.B)
      x18802_rd_x3920.toSeq.zip(x3920_reg.connectRPort(18802, x18802_rd_x3920_banks, x18802_rd_x3920_ofs, io.sigsIn.backpressure, x18802_rd_x3920_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x18803_rd_x9465 = Wire(Bool()).suggestName("""x18803_rd_x9465""")
      val x18803_rd_x9465_banks = List[UInt]()
      val x18803_rd_x9465_ofs = List[UInt]()
      val x18803_rd_x9465_en = List[Bool](true.B)
      x18803_rd_x9465.toSeq.zip(x9465_reg.connectRPort(18803, x18803_rd_x9465_banks, x18803_rd_x9465_ofs, io.sigsIn.backpressure, x18803_rd_x9465_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiDone).DS(0.0.toInt, rr, io.sigsIn.backpressure) && true.B), true)).foreach{case (a,b) => a := b}
      val x17712_outr_Foreach = new x17712_outr_Foreach_kernel(List(b9552_chain_read_6,x2682_tmp_DRAM), List(x17552), List(x17550), List(x17551), List(x9845_out_SRAM_conv_1,x9554_bias_SRAM_0), List(x18802_rd_x3920,b9553_chain_read_6,x18803_rd_x9465), List(x9465_reg,x9497_reg,x9490_reg,x9493_reg,x3920_reg,x9491_reg,x9492_reg,x3921_reg,x9495_reg,x9466_reg) , Some(me), List(x17299_ctrchain), 6, 3, 1, List(1), List(32), breakpoints, rr)
      x17712_outr_Foreach.sm.io.ctrDone := (x17712_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure)
      b9552_chain.connectStageCtrl((x17712_outr_Foreach.done).DS(1.toInt, rr, x17712_outr_Foreach.sm.io.backpressure), x17712_outr_Foreach.baseEn, 6)
      b9553_chain.connectStageCtrl((x17712_outr_Foreach.done).DS(1.toInt, rr, x17712_outr_Foreach.sm.io.backpressure), x17712_outr_Foreach.baseEn, 6)
      x17712_outr_Foreach.backpressure := true.B | x17712_outr_Foreach.sm.io.doneLatch
      x17712_outr_Foreach.forwardpressure := true.B | x17712_outr_Foreach.sm.io.doneLatch
      x17712_outr_Foreach.sm.io.enableOut.zip(x17712_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x17712_outr_Foreach.sm.io.break := false.B
      x17712_outr_Foreach.mask := ~x17712_outr_Foreach.cchain.head.output.noop & b9553_chain_read_6 & x18802_rd_x3920 & x18803_rd_x9465
      x17712_outr_Foreach.configure("x17712_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x17712_outr_Foreach.kernel()
    }
    val module = Module(new x17713_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x17713_outr_Foreach **/
