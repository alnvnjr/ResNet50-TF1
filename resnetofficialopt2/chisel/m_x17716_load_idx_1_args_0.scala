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

class x17716_load_idx_1_args_0 {
  val w0 = AccessHelper.singular(32)
  val r0 = Access(17731, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 7, List(7), 32, List(List(RG(1,0,0)))))
  val m = Module(new LUT( 
    List[Int](68), 0,
     32, 
    List[Int](68), 
    List[Int](1), 
    List(w0),
    List(r0),
    BankedMemory, 
    Some(List(-1L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,1L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,0L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,2L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,0L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,1L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,2L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,1L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,0L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,2L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,1L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,2L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,1L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,2L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,2L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,1L.toDouble,-1L.toDouble,-1L.toDouble,-1L.toDouble,2L.toDouble)), 
    true, 
    0,
    1, 
    myName = "x17716_load_idx_1_args_0"
  ))
  m.io.asInstanceOf[StandardInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x17716_load_idx_1_args_0_p", m.io.p)
}
