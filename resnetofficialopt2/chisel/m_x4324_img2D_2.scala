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

class x4324_img2D_2 {
  val w0 = Access(4444, 0, 0, List(0,1,2,3), List(0,0,0,0), None, PortInfo(Some(0), 4, 10, List(2), 32, List(List(RG(1,0,4)),List(RG(1,0,4)),List(RG(1,0,4)),List(RG(1,0,4)))))
  val r15 = Access(7482, 0, 0, List(0), List(21), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r14 = Access(7536, 0, 0, List(0), List(30), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r31 = Access(7392, 0, 0, List(0), List(6), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r22 = Access(7398, 0, 0, List(0), List(7), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r17 = Access(7362, 0, 0, List(0), List(1), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r20 = Access(7458, 0, 0, List(0), List(17), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r13 = Access(7440, 0, 0, List(0), List(14), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r23 = Access(7374, 0, 0, List(0), List(3), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r2 = Access(7422, 0, 0, List(0), List(11), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r5 = Access(7464, 0, 0, List(0), List(18), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r25 = Access(7380, 0, 0, List(0), List(4), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r10 = Access(7404, 0, 0, List(0), List(8), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r3 = Access(7452, 0, 0, List(0), List(16), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r28 = Access(7530, 0, 0, List(0), List(29), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r30 = Access(7506, 0, 0, List(0), List(25), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r8 = Access(7410, 0, 0, List(0), List(9), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r4 = Access(7386, 0, 0, List(0), List(5), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r16 = Access(7470, 0, 0, List(0), List(19), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r1 = Access(7524, 0, 0, List(0), List(28), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r9 = Access(7428, 0, 0, List(0), List(12), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r7 = Access(7518, 0, 0, List(0), List(27), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r11 = Access(7476, 0, 0, List(0), List(20), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r27 = Access(7416, 0, 0, List(0), List(10), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r29 = Access(7542, 0, 0, List(0), List(31), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r0 = Access(7368, 0, 0, List(0), List(2), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r21 = Access(7494, 0, 0, List(0), List(23), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r26 = Access(7446, 0, 0, List(0), List(15), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r19 = Access(7356, 0, 0, List(0), List(0), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r24 = Access(7488, 0, 0, List(0), List(22), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r6 = Access(7500, 0, 0, List(0), List(24), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r18 = Access(7434, 0, 0, List(0), List(13), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
  val r12 = Access(7512, 0, 0, List(0), List(26), None, PortInfo(Some(1), 1, 10, List(2), 32, List(List(RG(1,0,4)))))
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
    myName = "x4324_img2D_2"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x4324_img2D_2_p", m.io.np)
}
