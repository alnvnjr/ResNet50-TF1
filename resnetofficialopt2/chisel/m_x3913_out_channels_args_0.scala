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

class x3913_out_channels_args_0 {
  val w0 = AccessHelper.singular(32)
  val r0 = Access(3969, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 7, List(7), 32, List(List(RG(1,0,0)))))
  val r1 = Access(9521, 0, 1, List(1), List(0), None, PortInfo(Some(0), 1, 7, List(7), 32, List(List(RG(1,0,0)))))
  val m = Module(new LUT( 
    List[Int](68), 0,
     32, 
    List[Int](68), 
    List[Int](1), 
    List(w0),
    List(r0,r1),
    BankedMemory, 
    Some(List(256L.toDouble,64L.toDouble,64L.toDouble,256L.toDouble,-1L.toDouble,64L.toDouble,64L.toDouble,256L.toDouble,-1L.toDouble,64L.toDouble,64L.toDouble,256L.toDouble,-1L.toDouble,512L.toDouble,128L.toDouble,128L.toDouble,512L.toDouble,-1L.toDouble,128L.toDouble,128L.toDouble,512L.toDouble,-1L.toDouble,128L.toDouble,128L.toDouble,512L.toDouble,-1L.toDouble,128L.toDouble,128L.toDouble,512L.toDouble,-1L.toDouble,1024L.toDouble,256L.toDouble,256L.toDouble,1024L.toDouble,-1L.toDouble,256L.toDouble,256L.toDouble,1024L.toDouble,-1L.toDouble,256L.toDouble,256L.toDouble,1024L.toDouble,-1L.toDouble,256L.toDouble,256L.toDouble,1024L.toDouble,-1L.toDouble,256L.toDouble,256L.toDouble,1024L.toDouble,-1L.toDouble,256L.toDouble,256L.toDouble,1024L.toDouble,-1L.toDouble,512L.toDouble,512L.toDouble,2048L.toDouble,2048L.toDouble,-1L.toDouble,512L.toDouble,512L.toDouble,2048L.toDouble,-1L.toDouble,512L.toDouble,512L.toDouble,2048L.toDouble,-1L.toDouble)), 
    true, 
    0,
    2, 
    myName = "x3913_out_channels_args_0"
  ))
  m.io.asInstanceOf[StandardInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x3913_out_channels_args_0_p", m.io.p)
}
