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

class x9861_in_buffer_7 {
  val w0 = Access(10000, 0, 0, List(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(0), 16, 8, List(4), 32, List(List(RG(0)),List(RG(1)),List(RG(2)),List(RG(3)),List(RG(4)),List(RG(5)),List(RG(6)),List(RG(7)),List(RG(8)),List(RG(9)),List(RG(10)),List(RG(11)),List(RG(12)),List(RG(13)),List(RG(14)),List(RG(15)))))
  val r28 = Access(13846, 0, 0, List(0), List(14), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r11 = Access(13822, 0, 0, List(0), List(10), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r29 = Access(13816, 0, 0, List(0), List(9), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r16 = Access(13888, 0, 0, List(0), List(21), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r12 = Access(13864, 0, 0, List(0), List(17), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r20 = Access(13828, 0, 0, List(0), List(11), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r4 = Access(13942, 0, 0, List(0), List(30), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r21 = Access(13882, 0, 0, List(0), List(20), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r14 = Access(13762, 0, 0, List(0), List(0), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r25 = Access(13870, 0, 0, List(0), List(18), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r3 = Access(13906, 0, 0, List(0), List(24), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r0 = Access(13768, 0, 0, List(0), List(1), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r18 = Access(13840, 0, 0, List(0), List(13), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r26 = Access(13858, 0, 0, List(0), List(16), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r24 = Access(13774, 0, 0, List(0), List(2), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r31 = Access(13792, 0, 0, List(0), List(5), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r17 = Access(13930, 0, 0, List(0), List(28), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r2 = Access(13918, 0, 0, List(0), List(26), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r6 = Access(13936, 0, 0, List(0), List(29), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r9 = Access(13900, 0, 0, List(0), List(23), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r23 = Access(13948, 0, 0, List(0), List(31), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r7 = Access(13810, 0, 0, List(0), List(8), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r13 = Access(13798, 0, 0, List(0), List(6), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r8 = Access(13924, 0, 0, List(0), List(27), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r15 = Access(13876, 0, 0, List(0), List(19), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r1 = Access(13834, 0, 0, List(0), List(12), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r10 = Access(13804, 0, 0, List(0), List(7), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r27 = Access(13780, 0, 0, List(0), List(3), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r22 = Access(13912, 0, 0, List(0), List(25), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r19 = Access(13852, 0, 0, List(0), List(15), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r5 = Access(13786, 0, 0, List(0), List(4), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
  val r30 = Access(13894, 0, 0, List(0), List(22), None, PortInfo(Some(1), 1, 8, List(4), 32, List(List(RG(1,0,16)))))
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
    myName = "x9861_in_buffer_7"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x9861_in_buffer_7_p", m.io.np)
}
