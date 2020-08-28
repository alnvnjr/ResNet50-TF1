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

class x3231_fifo {
  val w0 = Access(3260, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 4, List(1), 96, List(List(RG(1,0,0)))))
  val r0 = Access(3266, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 4, List(1), 96, List(List(RG(1,0,0)))))
  val m = Module(new FIFO( 
    List[Int](16), 0,
     96, 
    List[Int](1), 
    List[Int](1), 
    List(w0),
    List(r0),
    BankedMemory, 
    None, 
    true, 
    0,
    2, 
    myName = "x3231_fifo"
  ))
  m.io.asInstanceOf[FIFOInterface] <> DontCare
  // enqActive_x3260_enq_x3231 = 0
  // deqActive_x3266_deq_x3231 = 1
  m.io.reset := false.B
  ModuleParams.addParams("x3231_fifo_p", m.io.p)
}
