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

class x9860_in_buffer_6 {
  val w0 = Access(9999, 0, 0, List(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(0), 16, 8, List(4), 32, List(List(RG(0)),List(RG(1)),List(RG(2)),List(RG(3)),List(RG(4)),List(RG(5)),List(RG(6)),List(RG(7)),List(RG(8)),List(RG(9)),List(RG(10)),List(RG(11)),List(RG(12)),List(RG(13)),List(RG(14)),List(RG(15)))))
  val r29 = Access(13720, 0, 0, List(0), List(25), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r22 = Access(13666, 0, 0, List(0), List(16), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r31 = Access(13684, 0, 0, List(0), List(19), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r30 = Access(13678, 0, 0, List(0), List(18), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r15 = Access(13648, 0, 0, List(0), List(13), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r24 = Access(13570, 0, 0, List(0), List(0), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r7 = Access(13708, 0, 0, List(0), List(23), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r4 = Access(13696, 0, 0, List(0), List(21), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r23 = Access(13702, 0, 0, List(0), List(22), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r28 = Access(13738, 0, 0, List(0), List(28), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r21 = Access(13630, 0, 0, List(0), List(10), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r2 = Access(13660, 0, 0, List(0), List(15), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r3 = Access(13732, 0, 0, List(0), List(27), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r14 = Access(13714, 0, 0, List(0), List(24), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r1 = Access(13672, 0, 0, List(0), List(17), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r18 = Access(13606, 0, 0, List(0), List(6), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r12 = Access(13576, 0, 0, List(0), List(1), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r19 = Access(13582, 0, 0, List(0), List(2), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r20 = Access(13588, 0, 0, List(0), List(3), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r27 = Access(13624, 0, 0, List(0), List(9), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r6 = Access(13744, 0, 0, List(0), List(29), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r10 = Access(13612, 0, 0, List(0), List(7), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r5 = Access(13636, 0, 0, List(0), List(11), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r17 = Access(13618, 0, 0, List(0), List(8), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r26 = Access(13642, 0, 0, List(0), List(12), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r11 = Access(13750, 0, 0, List(0), List(30), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r9 = Access(13654, 0, 0, List(0), List(14), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r13 = Access(13594, 0, 0, List(0), List(4), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r25 = Access(13756, 0, 0, List(0), List(31), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r16 = Access(13726, 0, 0, List(0), List(26), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r0 = Access(13690, 0, 0, List(0), List(20), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r8 = Access(13600, 0, 0, List(0), List(5), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val m = Module(new NBufMem(BankedSRAMType,  
    List[Int](3136), 0,
    2, 32, 
    List[Int](16), 
    List[Int](16), 
    List(w0),
    List(r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25,r26,r27,r28,r29,r30,r31),
    BankedMemory, 
    None, 
    true, 
    22,
    33, 
    myName = "x9860_in_buffer_6"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x9860_in_buffer_6_p", m.io.np)
}
