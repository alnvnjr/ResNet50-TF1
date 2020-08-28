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

class x3216_lb0_0 {
  val w0 = Access(3297, 0, 0, List(0,1), List(0,0), None, PortInfo(Some(0), 2, 6, List(4,3), 32, List(List(RG(1,0,0)))))
  val r37 = Access(3516, 0, 30, List(30), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(4),RG(1,0,7)))))
  val r36 = Access(3501, 0, 46, List(46), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(5),RG(1,0,7)))))
  val r34 = Access(3520, 0, 4, List(4), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(4),RG(1,0,7)))))
  val r12 = Access(3473, 0, 38, List(38), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(6),RG(1,0,7)))))
  val r14 = Access(3510, 0, 35, List(35), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(5),RG(1,0,7)))))
  val r3 = Access(3530, 0, 43, List(43), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(3),RG(1,0,7)))))
  val r17 = Access(3546, 0, 39, List(39), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(2),RG(1,0,7)))))
  val r45 = Access(3526, 0, 15, List(15), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(4),RG(1,0,7)))))
  val r8 = Access(3485, 0, 44, List(44), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(6),RG(1,0,7)))))
  val r7 = Access(3495, 0, 41, List(41), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(5),RG(1,0,7)))))
  val r1 = Access(3534, 0, 28, List(28), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(3),RG(1,0,7)))))
  val r43 = Access(3570, 0, 45, List(45), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(1),RG(1,0,7)))))
  val r22 = Access(3476, 0, 14, List(14), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(6),RG(1,0,7)))))
  val r35 = Access(3548, 0, 17, List(17), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(2),RG(1,0,7)))))
  val r30 = Access(3554, 0, 29, List(29), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(2),RG(1,0,7)))))
  val r11 = Access(3453, 0, 20, List(20), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(7),RG(1,0,7)))))
  val r10 = Access(3524, 0, 27, List(27), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(4),RG(1,0,7)))))
  val r33 = Access(3488, 0, 8, List(8), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(6),RG(1,0,7)))))
  val r47 = Access(3437, 0, 19, List(19), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(7),RG(1,0,7)))))
  val r18 = Access(3445, 0, 33, List(33), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(7),RG(1,0,7)))))
  val r15 = Access(3550, 0, 7, List(7), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(2),RG(1,0,7)))))
  val r23 = Access(3491, 0, 36, List(36), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(6),RG(1,0,7)))))
  val r26 = Access(3568, 0, 34, List(34), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(1),RG(1,0,7)))))
  val r24 = Access(3536, 0, 37, List(37), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(3),RG(1,0,7)))))
  val r28 = Access(3522, 0, 40, List(40), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(4),RG(1,0,7)))))
  val r41 = Access(3558, 0, 5, List(5), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(1),RG(1,0,7)))))
  val r25 = Access(3504, 0, 25, List(25), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(5),RG(1,0,7)))))
  val r42 = Access(3479, 0, 48, List(48), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(6),RG(1,0,7)))))
  val r4 = Access(3429, 0, 3, List(3), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(7),RG(1,0,7)))))
  val r19 = Access(3482, 0, 26, List(26), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(6),RG(1,0,7)))))
  val r21 = Access(3540, 0, 0, List(0), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(3),RG(1,0,7)))))
  val r40 = Access(3560, 0, 47, List(47), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(1),RG(1,0,7)))))
  val r39 = Access(3469, 0, 32, List(32), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(7),RG(1,0,7)))))
  val r29 = Access(3507, 0, 22, List(22), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(5),RG(1,0,7)))))
  val r13 = Access(3421, 0, 23, List(23), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(7),RG(1,0,7)))))
  val r46 = Access(3528, 0, 6, List(6), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(4),RG(1,0,7)))))
  val r38 = Access(3552, 0, 42, List(42), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(2),RG(1,0,7)))))
  val r44 = Access(3538, 0, 1, List(1), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(3),RG(1,0,7)))))
  val r27 = Access(3532, 0, 10, List(10), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(3),RG(1,0,7)))))
  val r16 = Access(3556, 0, 13, List(13), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(2),RG(1,0,7)))))
  val r31 = Access(3544, 0, 24, List(24), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(2),RG(1,0,7)))))
  val r9 = Access(3542, 0, 9, List(9), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(3),RG(1,0,7)))))
  val r5 = Access(3562, 0, 31, List(31), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(1),RG(1,0,7)))))
  val r0 = Access(3566, 0, 12, List(12), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(1),RG(1,0,7)))))
  val r32 = Access(3564, 0, 21, List(21), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(1),RG(1,0,7)))))
  val r20 = Access(3518, 0, 18, List(18), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(4),RG(1,0,7)))))
  val r2 = Access(3498, 0, 16, List(16), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(5),RG(1,0,7)))))
  val r48 = Access(3461, 0, 2, List(2), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(7),RG(1,0,7)))))
  val r6 = Access(3513, 0, 11, List(11), List(0), None, PortInfo(Some(1), 1, 6, List(4,3), 32, List(List(RG(5),RG(1,0,7)))))
  val m = Module(new NBufMem(LineBufferType,  
    List[Int](8,231), 0,
    2, 32, 
    List[Int](10,7), 
    List[Int](2,7), 
    List(w0),
    List(r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25,r26,r27,r28,r29,r30,r31,r32,r33,r34,r35,r36,r37,r38,r39,r40,r41,r42,r43,r44,r45,r46,r47,r48),
    BankedMemory, 
    None, 
    true, 
    22,
    50, 
    myName = "x3216_lb0_0"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x3216_lb0_0_p", m.io.np)
}
