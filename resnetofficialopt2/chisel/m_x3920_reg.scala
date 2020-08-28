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

class x3920_reg {
  val w0 = Access(3929, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r6 = Access(18787, 0, 10, List(10), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r5 = Access(17338, 0, 3, List(3), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r11 = Access(9788, 0, 8, List(8), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r7 = Access(18795, 0, 11, List(11), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r4 = Access(18802, 0, 5, List(5), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r0 = Access(9469, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r3 = Access(18767, 0, 2, List(2), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r8 = Access(17722, 0, 9, List(9), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r9 = Access(18067, 0, 7, List(7), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r1 = Access(18810, 0, 6, List(6), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r2 = Access(18800, 0, 4, List(4), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val r10 = Access(9500, 0, 1, List(1), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  val m = Module(new FF( 
    List[Int](1), 0,
     1, 
    List[Int](1), 
    List[Int](), 
    List(w0),
    List(r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11),
    BankedMemory, 
    Some(List(0.toDouble)), 
    true, 
    0,
    13, 
    myName = "x3920_reg"
  ))
  m.io.asInstanceOf[StandardInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x3920_reg_p", m.io.p)
}
