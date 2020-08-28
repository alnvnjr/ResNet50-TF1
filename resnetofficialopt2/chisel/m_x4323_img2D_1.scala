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

class x4323_img2D_1 {
  val w0 = Access(4441, 0, 0, List(0,1,2,3), List(0,0,0,0), None, PortInfo(Some(0), 4, 10, List(2), 32, List(List(RG(1,0,4)),List(RG(1,0,4)),List(RG(1,0,4)),List(RG(1,0,4)))))
  val r28 = Access(8240, 0, 0, List(0), List(30), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r1 = Access(8114, 0, 0, List(0), List(9), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r27 = Access(8228, 0, 0, List(0), List(28), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r16 = Access(8222, 0, 0, List(0), List(27), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r25 = Access(8216, 0, 0, List(0), List(26), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r4 = Access(8204, 0, 0, List(0), List(24), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r10 = Access(8132, 0, 0, List(0), List(12), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r26 = Access(8108, 0, 0, List(0), List(8), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r18 = Access(8192, 0, 0, List(0), List(22), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r15 = Access(8234, 0, 0, List(0), List(29), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r20 = Access(8198, 0, 0, List(0), List(23), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r23 = Access(8096, 0, 0, List(0), List(6), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r11 = Access(8072, 0, 0, List(0), List(2), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r24 = Access(8060, 0, 0, List(0), List(0), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r21 = Access(8084, 0, 0, List(0), List(4), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r3 = Access(8210, 0, 0, List(0), List(25), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r9 = Access(8138, 0, 0, List(0), List(13), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r12 = Access(8090, 0, 0, List(0), List(5), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r2 = Access(8150, 0, 0, List(0), List(15), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r17 = Access(8120, 0, 0, List(0), List(10), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r5 = Access(8126, 0, 0, List(0), List(11), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r6 = Access(8246, 0, 0, List(0), List(31), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r19 = Access(8156, 0, 0, List(0), List(16), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r14 = Access(8174, 0, 0, List(0), List(19), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r29 = Access(8102, 0, 0, List(0), List(7), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r13 = Access(8144, 0, 0, List(0), List(14), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r22 = Access(8180, 0, 0, List(0), List(20), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r31 = Access(8066, 0, 0, List(0), List(1), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r8 = Access(8168, 0, 0, List(0), List(18), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r0 = Access(8186, 0, 0, List(0), List(21), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r7 = Access(8078, 0, 0, List(0), List(3), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r30 = Access(8162, 0, 0, List(0), List(17), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val m = Module(new NBufMem(BankedSRAMType,  
    List[Int](3136), 0,
    2, 32, 
    List[Int](4), 
    List[Int](4), 
    List(w0),
    List(r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25,r26,r27,r28,r29,r30,r31),
    BankedMemory, 
    None, 
    true, 
    22,
    33, 
    myName = "x4323_img2D_1"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x4323_img2D_1_p", m.io.np)
}
