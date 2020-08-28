package accel
import chisel3._
import chisel3.util._
import fringe._
import utils.implicits._
import fringe.templates.math._
import fringe.templates.counters._
import fringe.templates.vector._
import fringe.templates.memory._
import fringe.templates.retiming._
class AccelTop(
  val top_w: Int,
  val numArgIns: Int,
  val numArgOuts: Int,
  val numArgIOs: Int,
  val numArgInstrs: Int,
  val numAllocators: Int,
  val loadStreamInfo: List[StreamParInfo],
  val storeStreamInfo: List[StreamParInfo],
  val gatherStreamInfo: List[StreamParInfo],
  val scatterStreamInfo: List[StreamParInfo],
  val streamInsInfo: List[StreamParInfo],
  val streamOutsInfo: List[StreamParInfo]
) extends AbstractAccelTop with IOModule { 
  val retime_released_reg = RegInit(false.B)
  val accelReset = reset.toBool | io.reset
  Main.main(this)
}
