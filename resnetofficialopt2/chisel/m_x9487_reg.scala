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

class x9487_reg {
  val w0 = Access(9534, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 1, List(1), 32, List(List())))
  val r0 = Access(9601, 0, 2, List(2), List(0), None, PortInfo(Some(0), 1, 1, List(1), 32, List(List())))
  val r1 = Access(18790, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 1, List(1), 32, List(List())))
  val r2 = Access(18794, 0, 1, List(1), List(0), None, PortInfo(Some(0), 1, 1, List(1), 32, List(List())))
  val m = Module(new FF( 
    List[Int](1), 0,
     32, 
    List[Int](1), 
    List[Int](), 
    List(w0),
    List(r0,r1,r2),
    BankedMemory, 
    Some(List(0L.toDouble)), 
    true, 
    0,
    4, 
    myName = "x9487_reg"
  ))
  m.io.asInstanceOf[StandardInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x9487_reg_p", m.io.p)
}
