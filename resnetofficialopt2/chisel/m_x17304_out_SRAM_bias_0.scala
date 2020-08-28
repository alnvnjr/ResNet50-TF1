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

class x17304_out_SRAM_bias_0 {
  val w0 = Access(17537, 0, 0, List(0,1,2,3,4,5,6,7), List(0,0,0,0,0,0,0,0), None, PortInfo(Some(0), 8, 9, List(3), 32, List(List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)))))
  val r0 = Access(17686, 0, 0, List(0,1,2,3,4,5,6,7), List(0,0,0,0,0,0,0,0), None, PortInfo(Some(2), 8, 9, List(3), 32, List(List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)),List(RG(1,0,8)))))
  val m = Module(new NBufMem(BankedSRAMType,  
    List[Int](3136), 0,
    3, 32, 
    List[Int](8), 
    List[Int](8), 
    List(w0),
    List(r0),
    BankedMemory, 
    None, 
    true, 
    22,
    2, 
    myName = "x17304_out_SRAM_bias_0"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x17304_out_SRAM_bias_0_p", m.io.np)
}
