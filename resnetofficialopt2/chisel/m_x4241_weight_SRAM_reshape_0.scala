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

class x4241_weight_SRAM_reshape_0 {
  val w0 = Access(4320, 0, 0, List(0,1,2,3), List(0,0,0,0), None, PortInfo(Some(0), 4, 1, List(5,4), 32, List(List(RG(4,0,32),RG(1,0,9)),List(RG(4,1,32),RG(1,0,9)),List(RG(4,2,32),RG(1,0,9)),List(RG(4,3,32),RG(1,0,9)))))
  val r1 = Access(5557, 0, 224, List(224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(3), 32, 1, List(5,4), 32, List(List(RG(0),RG(8)),List(RG(1),RG(8)),List(RG(2),RG(8)),List(RG(3),RG(8)),List(RG(4),RG(8)),List(RG(5),RG(8)),List(RG(6),RG(8)),List(RG(7),RG(8)),List(RG(8),RG(8)),List(RG(9),RG(8)),List(RG(10),RG(8)),List(RG(11),RG(8)),List(RG(12),RG(8)),List(RG(13),RG(8)),List(RG(14),RG(8)),List(RG(15),RG(8)),List(RG(16),RG(8)),List(RG(17),RG(8)),List(RG(18),RG(8)),List(RG(19),RG(8)),List(RG(20),RG(8)),List(RG(21),RG(8)),List(RG(22),RG(8)),List(RG(23),RG(8)),List(RG(24),RG(8)),List(RG(25),RG(8)),List(RG(26),RG(8)),List(RG(27),RG(8)),List(RG(28),RG(8)),List(RG(29),RG(8)),List(RG(30),RG(8)),List(RG(31),RG(8)))))
  val r8 = Access(5293, 0, 96, List(96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(3), 32, 1, List(5,4), 32, List(List(RG(0),RG(0)),List(RG(1),RG(0)),List(RG(2),RG(0)),List(RG(3),RG(0)),List(RG(4),RG(0)),List(RG(5),RG(0)),List(RG(6),RG(0)),List(RG(7),RG(0)),List(RG(8),RG(0)),List(RG(9),RG(0)),List(RG(10),RG(0)),List(RG(11),RG(0)),List(RG(12),RG(0)),List(RG(13),RG(0)),List(RG(14),RG(0)),List(RG(15),RG(0)),List(RG(16),RG(0)),List(RG(17),RG(0)),List(RG(18),RG(0)),List(RG(19),RG(0)),List(RG(20),RG(0)),List(RG(21),RG(0)),List(RG(22),RG(0)),List(RG(23),RG(0)),List(RG(24),RG(0)),List(RG(25),RG(0)),List(RG(26),RG(0)),List(RG(27),RG(0)),List(RG(28),RG(0)),List(RG(29),RG(0)),List(RG(30),RG(0)),List(RG(31),RG(0)))))
  val r0 = Access(5425, 0, 64, List(64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(3), 32, 1, List(5,4), 32, List(List(RG(0),RG(4)),List(RG(1),RG(4)),List(RG(2),RG(4)),List(RG(3),RG(4)),List(RG(4),RG(4)),List(RG(5),RG(4)),List(RG(6),RG(4)),List(RG(7),RG(4)),List(RG(8),RG(4)),List(RG(9),RG(4)),List(RG(10),RG(4)),List(RG(11),RG(4)),List(RG(12),RG(4)),List(RG(13),RG(4)),List(RG(14),RG(4)),List(RG(15),RG(4)),List(RG(16),RG(4)),List(RG(17),RG(4)),List(RG(18),RG(4)),List(RG(19),RG(4)),List(RG(20),RG(4)),List(RG(21),RG(4)),List(RG(22),RG(4)),List(RG(23),RG(4)),List(RG(24),RG(4)),List(RG(25),RG(4)),List(RG(26),RG(4)),List(RG(27),RG(4)),List(RG(28),RG(4)),List(RG(29),RG(4)),List(RG(30),RG(4)),List(RG(31),RG(4)))))
  val r6 = Access(5326, 0, 192, List(192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(3), 32, 1, List(5,4), 32, List(List(RG(0),RG(1)),List(RG(1),RG(1)),List(RG(2),RG(1)),List(RG(3),RG(1)),List(RG(4),RG(1)),List(RG(5),RG(1)),List(RG(6),RG(1)),List(RG(7),RG(1)),List(RG(8),RG(1)),List(RG(9),RG(1)),List(RG(10),RG(1)),List(RG(11),RG(1)),List(RG(12),RG(1)),List(RG(13),RG(1)),List(RG(14),RG(1)),List(RG(15),RG(1)),List(RG(16),RG(1)),List(RG(17),RG(1)),List(RG(18),RG(1)),List(RG(19),RG(1)),List(RG(20),RG(1)),List(RG(21),RG(1)),List(RG(22),RG(1)),List(RG(23),RG(1)),List(RG(24),RG(1)),List(RG(25),RG(1)),List(RG(26),RG(1)),List(RG(27),RG(1)),List(RG(28),RG(1)),List(RG(29),RG(1)),List(RG(30),RG(1)),List(RG(31),RG(1)))))
  val r3 = Access(5359, 0, 256, List(256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(3), 32, 1, List(5,4), 32, List(List(RG(0),RG(2)),List(RG(1),RG(2)),List(RG(2),RG(2)),List(RG(3),RG(2)),List(RG(4),RG(2)),List(RG(5),RG(2)),List(RG(6),RG(2)),List(RG(7),RG(2)),List(RG(8),RG(2)),List(RG(9),RG(2)),List(RG(10),RG(2)),List(RG(11),RG(2)),List(RG(12),RG(2)),List(RG(13),RG(2)),List(RG(14),RG(2)),List(RG(15),RG(2)),List(RG(16),RG(2)),List(RG(17),RG(2)),List(RG(18),RG(2)),List(RG(19),RG(2)),List(RG(20),RG(2)),List(RG(21),RG(2)),List(RG(22),RG(2)),List(RG(23),RG(2)),List(RG(24),RG(2)),List(RG(25),RG(2)),List(RG(26),RG(2)),List(RG(27),RG(2)),List(RG(28),RG(2)),List(RG(29),RG(2)),List(RG(30),RG(2)),List(RG(31),RG(2)))))
  val r7 = Access(5458, 0, 128, List(128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(3), 32, 1, List(5,4), 32, List(List(RG(0),RG(5)),List(RG(1),RG(5)),List(RG(2),RG(5)),List(RG(3),RG(5)),List(RG(4),RG(5)),List(RG(5),RG(5)),List(RG(6),RG(5)),List(RG(7),RG(5)),List(RG(8),RG(5)),List(RG(9),RG(5)),List(RG(10),RG(5)),List(RG(11),RG(5)),List(RG(12),RG(5)),List(RG(13),RG(5)),List(RG(14),RG(5)),List(RG(15),RG(5)),List(RG(16),RG(5)),List(RG(17),RG(5)),List(RG(18),RG(5)),List(RG(19),RG(5)),List(RG(20),RG(5)),List(RG(21),RG(5)),List(RG(22),RG(5)),List(RG(23),RG(5)),List(RG(24),RG(5)),List(RG(25),RG(5)),List(RG(26),RG(5)),List(RG(27),RG(5)),List(RG(28),RG(5)),List(RG(29),RG(5)),List(RG(30),RG(5)),List(RG(31),RG(5)))))
  val r2 = Access(5524, 0, 32, List(32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(3), 32, 1, List(5,4), 32, List(List(RG(0),RG(7)),List(RG(1),RG(7)),List(RG(2),RG(7)),List(RG(3),RG(7)),List(RG(4),RG(7)),List(RG(5),RG(7)),List(RG(6),RG(7)),List(RG(7),RG(7)),List(RG(8),RG(7)),List(RG(9),RG(7)),List(RG(10),RG(7)),List(RG(11),RG(7)),List(RG(12),RG(7)),List(RG(13),RG(7)),List(RG(14),RG(7)),List(RG(15),RG(7)),List(RG(16),RG(7)),List(RG(17),RG(7)),List(RG(18),RG(7)),List(RG(19),RG(7)),List(RG(20),RG(7)),List(RG(21),RG(7)),List(RG(22),RG(7)),List(RG(23),RG(7)),List(RG(24),RG(7)),List(RG(25),RG(7)),List(RG(26),RG(7)),List(RG(27),RG(7)),List(RG(28),RG(7)),List(RG(29),RG(7)),List(RG(30),RG(7)),List(RG(31),RG(7)))))
  val r5 = Access(5392, 0, 0, List(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(3), 32, 1, List(5,4), 32, List(List(RG(0),RG(3)),List(RG(1),RG(3)),List(RG(2),RG(3)),List(RG(3),RG(3)),List(RG(4),RG(3)),List(RG(5),RG(3)),List(RG(6),RG(3)),List(RG(7),RG(3)),List(RG(8),RG(3)),List(RG(9),RG(3)),List(RG(10),RG(3)),List(RG(11),RG(3)),List(RG(12),RG(3)),List(RG(13),RG(3)),List(RG(14),RG(3)),List(RG(15),RG(3)),List(RG(16),RG(3)),List(RG(17),RG(3)),List(RG(18),RG(3)),List(RG(19),RG(3)),List(RG(20),RG(3)),List(RG(21),RG(3)),List(RG(22),RG(3)),List(RG(23),RG(3)),List(RG(24),RG(3)),List(RG(25),RG(3)),List(RG(26),RG(3)),List(RG(27),RG(3)),List(RG(28),RG(3)),List(RG(29),RG(3)),List(RG(30),RG(3)),List(RG(31),RG(3)))))
  val r4 = Access(5491, 0, 160, List(160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191), List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0), None, PortInfo(Some(3), 32, 1, List(5,4), 32, List(List(RG(0),RG(6)),List(RG(1),RG(6)),List(RG(2),RG(6)),List(RG(3),RG(6)),List(RG(4),RG(6)),List(RG(5),RG(6)),List(RG(6),RG(6)),List(RG(7),RG(6)),List(RG(8),RG(6)),List(RG(9),RG(6)),List(RG(10),RG(6)),List(RG(11),RG(6)),List(RG(12),RG(6)),List(RG(13),RG(6)),List(RG(14),RG(6)),List(RG(15),RG(6)),List(RG(16),RG(6)),List(RG(17),RG(6)),List(RG(18),RG(6)),List(RG(19),RG(6)),List(RG(20),RG(6)),List(RG(21),RG(6)),List(RG(22),RG(6)),List(RG(23),RG(6)),List(RG(24),RG(6)),List(RG(25),RG(6)),List(RG(26),RG(6)),List(RG(27),RG(6)),List(RG(28),RG(6)),List(RG(29),RG(6)),List(RG(30),RG(6)),List(RG(31),RG(6)))))
  val m = Module(new NBufMem(BankedSRAMType,  
    List[Int](32,9), 0,
    4, 32, 
    List[Int](32,9), 
    List[Int](32,9), 
    List(w0),
    List(r0,r1,r2,r3,r4,r5,r6,r7,r8),
    BankedMemory, 
    None, 
    true, 
    22,
    10, 
    myName = "x4241_weight_SRAM_reshape_0"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x4241_weight_SRAM_reshape_0_p", m.io.np)
}
