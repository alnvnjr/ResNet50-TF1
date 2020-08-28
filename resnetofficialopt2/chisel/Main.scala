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

object Main {
  def main(top: AccelTop): Unit = {
    top.io <> DontCare
    val x3230 = top.io.memStreams.loads(0).cmd // StreamOut
    ModuleParams.addParams("x3230_p", (x3230.bits.addrWidth, x3230.bits.sizeWidth))  
    val x3232 = top.io.memStreams.loads(0).data // StreamIn
    ModuleParams.addParams("x3232_p", (x3232.bits.v, x3232.bits.w))  
    // scoped in dram is  
    val x2679_i0_pad_DRAM = Wire(new FixedPoint(true, 64, 0))
    x2679_i0_pad_DRAM.r := top.io.argIns(api.I0_PAD_DRAM_ptr)
    val x18621 = top.io.memStreams.stores(0).cmd // StreamOut
    ModuleParams.addParams("x18621_p", (x18621.bits.addrWidth, x18621.bits.sizeWidth))  
    val x18622 = top.io.memStreams.stores(0).data // StreamOut
    ModuleParams.addParams("x18622_p", (x18622.bits.v, x18622.bits.w))  
    val x18623  = top.io.memStreams.stores(0).wresp // StreamIn
    // scoped in dram is  
    val x2680_tmp76_DRAM = Wire(new FixedPoint(true, 64, 0))
    x2680_tmp76_DRAM.r := top.io.argIns(api.TMP76_DRAM_ptr)
    val x9867 = top.io.memStreams.loads(1).cmd // StreamOut
    ModuleParams.addParams("x9867_p", (x9867.bits.addrWidth, x9867.bits.sizeWidth))  
    val x9868 = top.io.memStreams.loads(1).data // StreamIn
    ModuleParams.addParams("x9868_p", (x9868.bits.v, x9868.bits.w))  
    val x17882 = top.io.memStreams.loads(2).cmd // StreamOut
    ModuleParams.addParams("x17882_p", (x17882.bits.addrWidth, x17882.bits.sizeWidth))  
    val x17883 = top.io.memStreams.loads(2).data // StreamIn
    ModuleParams.addParams("x17883_p", (x17883.bits.v, x17883.bits.w))  
    val x4336 = top.io.memStreams.loads(3).cmd // StreamOut
    ModuleParams.addParams("x4336_p", (x4336.bits.addrWidth, x4336.bits.sizeWidth))  
    val x4338 = top.io.memStreams.loads(3).data // StreamIn
    ModuleParams.addParams("x4338_p", (x4338.bits.v, x4338.bits.w))  
    val x18388 = top.io.memStreams.loads(4).cmd // StreamOut
    ModuleParams.addParams("x18388_p", (x18388.bits.addrWidth, x18388.bits.sizeWidth))  
    val x18390 = top.io.memStreams.loads(4).data // StreamIn
    ModuleParams.addParams("x18390_p", (x18390.bits.v, x18390.bits.w))  
    val x17749 = top.io.memStreams.loads(5).cmd // StreamOut
    ModuleParams.addParams("x17749_p", (x17749.bits.addrWidth, x17749.bits.sizeWidth))  
    val x17750 = top.io.memStreams.loads(5).data // StreamIn
    ModuleParams.addParams("x17750_p", (x17750.bits.v, x17750.bits.w))  
    val x17550 = top.io.memStreams.stores(1).cmd // StreamOut
    ModuleParams.addParams("x17550_p", (x17550.bits.addrWidth, x17550.bits.sizeWidth))  
    val x17551 = top.io.memStreams.stores(1).data // StreamOut
    ModuleParams.addParams("x17551_p", (x17551.bits.v, x17551.bits.w))  
    val x17552  = top.io.memStreams.stores(1).wresp // StreamIn
    val x9399 = top.io.memStreams.stores(2).cmd // StreamOut
    ModuleParams.addParams("x9399_p", (x9399.bits.addrWidth, x9399.bits.sizeWidth))  
    val x9400 = top.io.memStreams.stores(2).data // StreamOut
    ModuleParams.addParams("x9400_p", (x9400.bits.v, x9400.bits.w))  
    val x9401  = top.io.memStreams.stores(2).wresp // StreamIn
    val x3869 = top.io.memStreams.stores(3).cmd // StreamOut
    ModuleParams.addParams("x3869_p", (x3869.bits.addrWidth, x3869.bits.sizeWidth))  
    val x3870 = top.io.memStreams.stores(3).data // StreamOut
    ModuleParams.addParams("x3870_p", (x3870.bits.v, x3870.bits.w))  
    val x3871  = top.io.memStreams.stores(3).wresp // StreamIn
    val x18215 = top.io.memStreams.stores(4).cmd // StreamOut
    ModuleParams.addParams("x18215_p", (x18215.bits.addrWidth, x18215.bits.sizeWidth))  
    val x18216 = top.io.memStreams.stores(4).data // StreamOut
    ModuleParams.addParams("x18216_p", (x18216.bits.v, x18216.bits.w))  
    val x18217  = top.io.memStreams.stores(4).wresp // StreamIn
    // scoped in dram is  
    val x2682_tmp_DRAM = Wire(new FixedPoint(true, 64, 0))
    x2682_tmp_DRAM.r := top.io.argIns(api.TMP_DRAM_ptr)
    val x3993 = top.io.memStreams.loads(6).cmd // StreamOut
    ModuleParams.addParams("x3993_p", (x3993.bits.addrWidth, x3993.bits.sizeWidth))  
    val x3995 = top.io.memStreams.loads(6).data // StreamIn
    ModuleParams.addParams("x3995_p", (x3995.bits.v, x3995.bits.w))  
    // scoped in dram is  
    val x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = Wire(new FixedPoint(true, 64, 0))
    x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM.r := top.io.argIns(api.FUSED_CONV2D_BIASADD_K3_BIAS_CONCAT_DRAM_ptr)
    val x4083 = top.io.memStreams.loads(7).cmd // StreamOut
    ModuleParams.addParams("x4083_p", (x4083.bits.addrWidth, x4083.bits.sizeWidth))  
    val x4085 = top.io.memStreams.loads(7).data // StreamIn
    ModuleParams.addParams("x4085_p", (x4085.bits.v, x4085.bits.w))  
    // scoped in dram is  
    val x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = Wire(new FixedPoint(true, 64, 0))
    x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM.r := top.io.argIns(api.FUSED_CONV2D_BIASADD_K3_WEIGHTS_CONCAT_DRAM_ptr)
    val x9560 = top.io.memStreams.loads(8).cmd // StreamOut
    ModuleParams.addParams("x9560_p", (x9560.bits.addrWidth, x9560.bits.sizeWidth))  
    val x9561 = top.io.memStreams.loads(8).data // StreamIn
    ModuleParams.addParams("x9561_p", (x9561.bits.v, x9561.bits.w))  
    // scoped in dram is  
    val x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = Wire(new FixedPoint(true, 64, 0))
    x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM.r := top.io.argIns(api.FUSED_CONV2D_BIASADD_K1_BIAS_CONCAT_DRAM_ptr)
    val x9593 = top.io.memStreams.loads(9).cmd // StreamOut
    ModuleParams.addParams("x9593_p", (x9593.bits.addrWidth, x9593.bits.sizeWidth))  
    val x9595 = top.io.memStreams.loads(9).data // StreamIn
    ModuleParams.addParams("x9595_p", (x9595.bits.v, x9595.bits.w))  
    // scoped in dram is  
    val x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = Wire(new FixedPoint(true, 64, 0))
    x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM.r := top.io.argIns(api.FUSED_CONV2D_BIASADD_K1_WEIGHTS_CONCAT_DRAM_ptr)
    val x3140 = top.io.memStreams.loads(10).cmd // StreamOut
    ModuleParams.addParams("x3140_p", (x3140.bits.addrWidth, x3140.bits.sizeWidth))  
    val x3142 = top.io.memStreams.loads(10).data // StreamIn
    ModuleParams.addParams("x3142_p", (x3142.bits.v, x3142.bits.w))  
    // scoped in dram is  
    val x3066_c101_DRAM = Wire(new FixedPoint(true, 64, 0))
    x3066_c101_DRAM.r := top.io.argIns(api.C101_DRAM_ptr)
    val x3099 = top.io.memStreams.loads(11).cmd // StreamOut
    ModuleParams.addParams("x3099_p", (x3099.bits.addrWidth, x3099.bits.sizeWidth))  
    val x3100 = top.io.memStreams.loads(11).data // StreamIn
    ModuleParams.addParams("x3100_p", (x3100.bits.v, x3100.bits.w))  
    // scoped in dram is  
    val x3081_c27_DRAM = Wire(new FixedPoint(true, 64, 0))
    x3081_c27_DRAM.r := top.io.argIns(api.C27_DRAM_ptr)
    val x18504 = top.io.memStreams.loads(12).cmd // StreamOut
    ModuleParams.addParams("x18504_p", (x18504.bits.addrWidth, x18504.bits.sizeWidth))  
    val x18505 = top.io.memStreams.loads(12).data // StreamIn
    ModuleParams.addParams("x18505_p", (x18505.bits.v, x18505.bits.w))  
    // scoped in dram is  
    val x3083_c90_DRAM = Wire(new FixedPoint(true, 64, 0))
    x3083_c90_DRAM.r := top.io.argIns(api.C90_DRAM_ptr)
    val x18479 = top.io.memStreams.loads(13).cmd // StreamOut
    ModuleParams.addParams("x18479_p", (x18479.bits.addrWidth, x18479.bits.sizeWidth))  
    val x18480 = top.io.memStreams.loads(13).data // StreamIn
    ModuleParams.addParams("x18480_p", (x18480.bits.v, x18480.bits.w))  
    // scoped in dram is  
    val x3096_c87_DRAM = Wire(new FixedPoint(true, 64, 0))
    x3096_c87_DRAM.r := top.io.argIns(api.C87_DRAM_ptr)
    val retime_counter = Module(new SingleCounter(1, Some(0), Some(top.max_latency), Some(1), false)); retime_counter.io <> DontCare // Counter for masking out the noise that comes out of ShiftRegister in the first few cycles of the app
    retime_counter.io.setup.saturate := true.B; retime_counter.io.input.reset := top.reset.toBool; retime_counter.io.input.enable := true.B;
    val rr = getRetimed(retime_counter.io.output.done, 1, true.B) // break up critical path by delaying this 
    val breakpoints = Wire(Vec(top.io_numArgOuts_breakpts max 1, Bool())); breakpoints.zipWithIndex.foreach{case(b,i) => b.suggestName(s"breakpoint" + i)}; breakpoints := DontCare
    val done_latch = Module(new SRFF())
    val RootController = new RootController_kernel(List(x9561,x3995,x9868,x18480,x17883,x4085,x3142,x18505,x9595,x18390,x17750,x4338,x3232,x3100), List(x9400,x3870,x18216,x17551,x18622), List(x9401,x3871,x17552,x18217,x18623), List(x2682_tmp_DRAM,x2862_Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM,x3083_c90_DRAM,x3081_c27_DRAM,x2679_i0_pad_DRAM,x2987_Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM,x3066_c101_DRAM,x2693_Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM,x2784_Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM,x2680_tmp76_DRAM,x3096_c87_DRAM), List(x18504,x18388,x3230,x3140,x3099,x18215,x18479,x9593,x17550,x18621,x17882,x17749,x9560,x9867,x4336,x3993,x4083,x3869,x9399) , None, List(), -1, 7, 1, List(1), List(32), breakpoints, rr)
    RootController.baseEn := top.io.enable && rr && ~done_latch.io.output
    RootController.resetMe := getRetimed(top.accelReset, 1)
    RootController.mask := true.B
    RootController.sm.io.parentAck := top.io.done
    RootController.sm.io.enable := RootController.baseEn & !top.io.done & true.B
    done_latch.io.input.reset := RootController.resetMe
    done_latch.io.input.asyn_reset := RootController.resetMe
    top.io.done := done_latch.io.output
    RootController.sm.io.ctrDone := risingEdge(RootController.sm.io.ctrInc)
    RootController.backpressure := true.B | RootController.sm.io.doneLatch
    RootController.forwardpressure := true.B | RootController.sm.io.doneLatch
    RootController.sm.io.enableOut.zip(RootController.smEnableOuts).foreach{case (l,r) => r := l}
    RootController.sm.io.break := false.B
    RootController.mask := true.B & true.B
    RootController.configure("RootController", None, None, isSwitchCase = false)
    RootController.kernel()
    done_latch.io.input.set := RootController.done
    Ledger.finish()
  }
}
