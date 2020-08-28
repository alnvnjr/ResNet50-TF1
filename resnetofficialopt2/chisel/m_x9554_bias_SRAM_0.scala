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

class x9554_bias_SRAM_0 {
  val w0 = Access(9580, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 5, List(1), 32, List(List(RG(0)))))
  val r6 = Access(17427, 0, 0, List(0), List(1), None, PortInfo(Some(5), 1, 5, List(1), 32, List(List(RG(0)))))
  val r1 = Access(17433, 0, 0, List(0), List(4), None, PortInfo(Some(5), 1, 5, List(1), 32, List(List(RG(0)))))
  val r2 = Access(17425, 0, 0, List(0), List(0), None, PortInfo(Some(5), 1, 5, List(1), 32, List(List(RG(0)))))
  val r3 = Access(17429, 0, 0, List(0), List(2), None, PortInfo(Some(5), 1, 5, List(1), 32, List(List(RG(0)))))
  val r4 = Access(17439, 0, 0, List(0), List(7), None, PortInfo(Some(5), 1, 5, List(1), 32, List(List(RG(0)))))
  val r0 = Access(17437, 0, 0, List(0), List(6), None, PortInfo(Some(5), 1, 5, List(1), 32, List(List(RG(0)))))
  val r5 = Access(17435, 0, 0, List(0), List(5), None, PortInfo(Some(5), 1, 5, List(1), 32, List(List(RG(0)))))
  val r7 = Access(17431, 0, 0, List(0), List(3), None, PortInfo(Some(5), 1, 5, List(1), 32, List(List(RG(0)))))
  val m = Module(new NBufMem(BankedSRAMType,  
    List[Int](32), 0,
    6, 32, 
    List[Int](1), 
    List[Int](1), 
    List(w0),
    List(r0,r1,r2,r3,r4,r5,r6,r7),
    BankedMemory, 
    None, 
    true, 
    22,
    9, 
    myName = "x9554_bias_SRAM_0"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x9554_bias_SRAM_0_p", m.io.np)
}
