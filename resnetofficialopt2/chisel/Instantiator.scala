package top

import accel._
import fringe._
import chisel3.core.Module
import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

import scala.collection.mutable.ListBuffer
/**
 * Top test harness
 */
class TopUnitTester(c: Top)(implicit args: Array[String]) extends ArgsTester(c) {
}

object Instantiator extends CommonMain {
  type DUTType = Top
  
  def dut = () => {
    // Non-memory Streams
    val streamInsInfo = List()
    val streamOutsInfo = List()
    
    // Scalars
    val numArgIns_reg = 0
    val numArgOuts_reg = 0
    val numArgIOs_reg = 0
    val io_argOutLoopbacksMap: scala.collection.immutable.Map[Int,Int] = Map()
    
    // Memory streams
    val loadStreamInfo = List(StreamParInfo(32, 2, 0), StreamParInfo(32, 16, 0), StreamParInfo(32, 16, 0), StreamParInfo(32, 4, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 16, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 8, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 8, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 4, 0), StreamParInfo(32, 1, 0)) 
    val storeStreamInfo = List(StreamParInfo(32, 1, 0), StreamParInfo(32, 8, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 16, 0)) 
    val gatherStreamInfo = List() 
    val scatterStreamInfo = List() 
    val numArgIns_mem = 11
    // Heap
    val numAllocators = 0
    
    // Instrumentation
    val numArgOuts_instr = 0
    val numCtrls = 129
    val numArgOuts_breakpts = 0
    /* Breakpoint Contexts:
    */
    val w = if (this.target == "zcu") 32 else if (this.target == "VCS" || this.target == "ASIC") 8 else 32
    val numArgIns = numArgIns_mem  + numArgIns_reg + numArgIOs_reg
    val numArgOuts = numArgOuts_reg + numArgIOs_reg + numArgOuts_instr + numArgOuts_breakpts
    val numArgIOs = numArgIOs_reg
    val numArgInstrs = numArgOuts_instr
    val numArgBreakpts = numArgOuts_breakpts
    new Top(this.target, () => Module(new AccelTop(w, numArgIns, numArgOuts, numArgIOs, numArgOuts_instr + numArgBreakpts, numAllocators, loadStreamInfo, storeStreamInfo, gatherStreamInfo, scatterStreamInfo, streamInsInfo, streamOutsInfo)))
  }
  def tester = { c: DUTType => new TopUnitTester(c) }
}
