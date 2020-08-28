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

class x3992_bias_SRAM_0 {
  val w0 = Access(4051, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 9, List(1), 32, List(List(RG(0)))))
  val r0 = Access(9376, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 9, List(1), 32, List(List(RG(0)))))
  val m = Module(new BankedSRAM( 
    List[Int](512), 0,
     32, 
    List[Int](1), 
    List[Int](1), 
    List(w0),
    List(r0),
    BankedMemory, 
    None, 
    true, 
    22,
    2, 
    myName = "x3992_bias_SRAM_0"
  ))
  m.io.asInstanceOf[StandardInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x3992_bias_SRAM_0_p", m.io.p)
}
