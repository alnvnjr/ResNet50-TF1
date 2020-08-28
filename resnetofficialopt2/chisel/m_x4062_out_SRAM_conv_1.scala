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

class x4062_out_SRAM_conv_1 {
  val w0 = Access(9341, 0, 0, List(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(0), 32, 12, List(5), 32, List(List(RG(0)),List(RG(1)),List(RG(2)),List(RG(3)),List(RG(4)),List(RG(5)),List(RG(6)),List(RG(7)),List(RG(8)),List(RG(9)),List(RG(10)),List(RG(11)),List(RG(12)),List(RG(13)),List(RG(14)),List(RG(15)),List(RG(16)),List(RG(17)),List(RG(18)),List(RG(19)),List(RG(20)),List(RG(21)),List(RG(22)),List(RG(23)),List(RG(24)),List(RG(25)),List(RG(26)),List(RG(27)),List(RG(28)),List(RG(29)),List(RG(30)),List(RG(31)))))
  val r0 = Access(9371, 0, 0, List(0), List(0), None, PortInfo(Some(1), 1, 12, List(5), 32, List(List(RG(1,0,32)))))
  val m = Module(new NBufMem(BankedSRAMType,  
    List[Int](56,56,32), 0,
    2, 32, 
    List[Int](32), 
    List[Int](1,1,32), 
    List(w0),
    List(r0),
    BankedMemory, 
    None, 
    true, 
    22,
    2, 
    myName = "x4062_out_SRAM_conv_1"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x4062_out_SRAM_conv_1_p", m.io.np)
}
