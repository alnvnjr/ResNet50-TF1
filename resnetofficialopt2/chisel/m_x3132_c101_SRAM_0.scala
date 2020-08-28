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

class x3132_c101_SRAM_0 {
  val w0 = Access(3208, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(1,0,49)))))
  val r23 = Access(3333, 0, 40, List(40), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(8)))))
  val r45 = Access(3323, 0, 15, List(15), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(3)))))
  val r14 = Access(3327, 0, 29, List(29), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(5)))))
  val r44 = Access(3347, 0, 31, List(31), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(15)))))
  val r21 = Access(3407, 0, 12, List(12), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(45)))))
  val r1 = Access(3399, 0, 36, List(36), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(41)))))
  val r22 = Access(3409, 0, 23, List(23), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(46)))))
  val r26 = Access(3343, 0, 9, List(9), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(13)))))
  val r42 = Access(3373, 0, 37, List(37), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(28)))))
  val r31 = Access(3325, 0, 28, List(28), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(4)))))
  val r6 = Access(3365, 0, 25, List(25), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(24)))))
  val r40 = Access(3351, 0, 3, List(3), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(17)))))
  val r0 = Access(3345, 0, 22, List(22), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(14)))))
  val r15 = Access(3371, 0, 47, List(47), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(27)))))
  val r48 = Access(3405, 0, 48, List(48), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(44)))))
  val r27 = Access(3387, 0, 14, List(14), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(35)))))
  val r13 = Access(3361, 0, 5, List(5), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(22)))))
  val r41 = Access(3379, 0, 19, List(19), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(31)))))
  val r11 = Access(3357, 0, 43, List(43), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(20)))))
  val r32 = Access(3395, 0, 1, List(1), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(39)))))
  val r16 = Access(3339, 0, 8, List(8), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(11)))))
  val r12 = Access(3389, 0, 26, List(26), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(36)))))
  val r43 = Access(3337, 0, 18, List(18), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(10)))))
  val r5 = Access(3367, 0, 20, List(20), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(25)))))
  val r19 = Access(3413, 0, 44, List(44), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(48)))))
  val r7 = Access(3335, 0, 35, List(35), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(9)))))
  val r34 = Access(3359, 0, 17, List(17), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(21)))))
  val r37 = Access(3383, 0, 42, List(42), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(33)))))
  val r17 = Access(3403, 0, 7, List(7), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(43)))))
  val r18 = Access(3349, 0, 45, List(45), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(16)))))
  val r38 = Access(3369, 0, 6, List(6), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(26)))))
  val r4 = Access(3377, 0, 10, List(10), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(30)))))
  val r24 = Access(3321, 0, 0, List(0), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(2)))))
  val r46 = Access(3411, 0, 30, List(30), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(47)))))
  val r33 = Access(3391, 0, 34, List(34), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(37)))))
  val r36 = Access(3401, 0, 21, List(21), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(42)))))
  val r8 = Access(3353, 0, 11, List(11), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(18)))))
  val r3 = Access(3317, 0, 33, List(33), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(0)))))
  val r39 = Access(3331, 0, 2, List(2), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(7)))))
  val r9 = Access(3385, 0, 4, List(4), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(34)))))
  val r10 = Access(3393, 0, 16, List(16), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(38)))))
  val r30 = Access(3363, 0, 39, List(39), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(23)))))
  val r25 = Access(3375, 0, 24, List(24), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(29)))))
  val r47 = Access(3341, 0, 46, List(46), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(12)))))
  val r35 = Access(3329, 0, 13, List(13), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(6)))))
  val r29 = Access(3355, 0, 27, List(27), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(19)))))
  val r20 = Access(3381, 0, 32, List(32), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(32)))))
  val r28 = Access(3319, 0, 41, List(41), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(1)))))
  val r2 = Access(3397, 0, 38, List(38), List(0), None, PortInfo(Some(1), 1, 3, List(1,1,6), 32, List(List(RG(0),RG(0),RG(40)))))
  val m = Module(new NBufMem(BankedSRAMType,  
    List[Int](2,3,49), 0,
    2, 32, 
    List[Int](1,1,49), 
    List[Int](1,1,49), 
    List(w0),
    List(r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25,r26,r27,r28,r29,r30,r31,r32,r33,r34,r35,r36,r37,r38,r39,r40,r41,r42,r43,r44,r45,r46,r47,r48),
    BankedMemory, 
    None, 
    true, 
    22,
    50, 
    myName = "x3132_c101_SRAM_0"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x3132_c101_SRAM_0_p", m.io.np)
}
