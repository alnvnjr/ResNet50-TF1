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
class CustomAccelInterface(
  val io_w: Int, 
  val io_v: Int, 
  val io_loadStreamInfo: List[StreamParInfo], 
  val io_storeStreamInfo: List[StreamParInfo], 
  val io_gatherStreamInfo: List[StreamParInfo], 
  val io_scatterStreamInfo: List[StreamParInfo], 
  val io_numAllocators: Int, 
  val io_numArgIns: Int, 
  val io_numArgOuts: Int, 
) extends AccelInterface{
  // Control IO
  val enable = Input(Bool())
  val done = Output(Bool())
  val reset = Input(Bool())
  
  // DRAM IO
  val memStreams = Flipped(new AppStreams(io_loadStreamInfo, io_storeStreamInfo, io_gatherStreamInfo, io_scatterStreamInfo))
  
  // HEAP IO
  val heap = Flipped(Vec(io_numAllocators, new HeapIO()))
  
  // Scalar IO
  val argIns = Input(Vec(io_numArgIns, UInt(64.W)))
  val argOuts = Vec(io_numArgOuts, new ArgOut())

  override def cloneType = (new CustomAccelInterface(io_w, io_v, io_loadStreamInfo, io_storeStreamInfo, io_gatherStreamInfo, io_scatterStreamInfo, io_numAllocators, io_numArgIns, io_numArgOuts)).asInstanceOf[this.type] // See chisel3 bug 358
}
trait IOModule extends Module {
  val io_w = if ("AWS_F1" == "VCS" || "AWS_F1" == "ASIC") 8 else 32 // TODO: How to generate these properly?
  val io_v = if ("AWS_F1" == "VCS" || "AWS_F1" == "ASIC") 64 else 16 // TODO: How to generate these properly?
  // Non-memory Streams
  val io_streamInsInfo = List()
  val io_streamOutsInfo = List()
  // Scalars
  val io_numArgIns_reg = 0
  val io_numArgOuts_reg = 0
  val io_numArgIOs_reg = 0
  val io_argOutLoopbacksMap: scala.collection.immutable.Map[Int,Int] = Map()
  // Memory Streams
  val io_loadStreamInfo = List(StreamParInfo(32, 2, 0), StreamParInfo(32, 16, 0), StreamParInfo(32, 16, 0), StreamParInfo(32, 4, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 16, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 8, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 8, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 4, 0), StreamParInfo(32, 1, 0)) 
  val io_storeStreamInfo = List(StreamParInfo(32, 1, 0), StreamParInfo(32, 8, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 1, 0), StreamParInfo(32, 16, 0)) 
  val io_gatherStreamInfo = List() 
  val io_scatterStreamInfo = List() 
  val io_numArgIns_mem = 11
  val outArgMuxMap: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map[Int,Int]()
  // Heap
  val io_numAllocators = scala.math.max(1, 0)
  // Root controller for app: resnetofficialopt2
  
  // Widths: 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 6, 7, 7
  //   Widest Outer Controller: 7
  // Depths: 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 11, 12, 12
  //   Deepest Inner Controller: 12
  // App Characteristics: HasTileStore,HasBroadcastRead,HasUnalignedStore,HasUnalignedLoad,HasAlignedLoad,HasTileLoad
  // Instrumentation
  val io_numArgOuts_instr = 0
  val io_numArgCtrls = 129
  val io_numArgOuts_breakpts = 0
  // Set Build Info
  val max_latency = 53
  globals.target.fixmul_latency = 0.1875
  globals.target.fixdiv_latency = 0.625
  globals.target.fixadd_latency = 0.03125
  globals.target.fixsub_latency = 0.03125
  globals.target.fixmod_latency = 0.5
  globals.target.fixeql_latency = 0.2.toInt
  globals.target.mux_latency    = 0.5.toInt
  globals.target.sramload_latency    = 2.0.toInt
  globals.target.sramstore_latency    = 1.0.toInt
  globals.target.SramThreshold = 1
  globals.retime = true
  globals.enableModular = true
  // Combine values
  val io_numArgIns = scala.math.max(1, io_numArgIns_reg + io_numArgIns_mem + io_numArgIOs_reg)
  val io_numArgOuts = scala.math.max(1, io_numArgOuts_reg + io_numArgIOs_reg + io_numArgOuts_instr + io_numArgOuts_breakpts)
  val io_numArgIOs = io_numArgIOs_reg
  val io_numArgInstrs = io_numArgOuts_instr
  val io_numArgBreakpts = io_numArgOuts_breakpts
  globals.numArgIns = io_numArgIns
  globals.numArgOuts = io_numArgOuts
  globals.numArgIOs = io_numArgIOs
  globals.numArgInstrs = io_numArgInstrs
  globals.loadStreamInfo = io_loadStreamInfo
  globals.storeStreamInfo = io_storeStreamInfo
  globals.gatherStreamInfo = io_gatherStreamInfo
  globals.scatterStreamInfo = io_scatterStreamInfo
  globals.streamInsInfo = io_streamInsInfo
  globals.streamOutsInfo = io_streamOutsInfo
  globals.numAllocators = io_numAllocators
  val io = IO(new CustomAccelInterface(io_w, io_v, globals.LOAD_STREAMS, globals.STORE_STREAMS, globals.GATHER_STREAMS, globals.SCATTER_STREAMS, globals.numAllocators, io_numArgIns, io_numArgOuts))
    var outStreamMuxMap: scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map[String,Int]()
    def getStreamOutLane(id: String): Int = {
      val lane = outStreamMuxMap.getOrElse(id, 0)
      outStreamMuxMap += (id -> {lane + 1})
      lane
    }
    var outBuffMuxMap: scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map[String,Int]()
    def getBuffOutLane(id: String): Int = {
      val lane = outBuffMuxMap.getOrElse(id, 0)
      outBuffMuxMap += (id -> {lane + 1})
      lane
    }
    var inStreamMuxMap: scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map[String,Int]()
    def getStreamInLane(id: String): Int = {
      val lane = inStreamMuxMap.getOrElse(id, 0)
      inStreamMuxMap += (id -> {lane + 1})
      lane
    }
  }
