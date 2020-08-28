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

class x3904_weights_start_idx_args_0 {
  val w0 = AccessHelper.singular(32)
  val r0 = Access(3975, 0, 1, List(1), List(0), None, PortInfo(Some(0), 1, 7, List(7), 32, List(List(RG(1,0,0)))))
  val r1 = Access(9529, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 7, List(7), 32, List(List(RG(1,0,0)))))
  val m = Module(new LUT( 
    List[Int](68), 0,
     32, 
    List[Int](68), 
    List[Int](1), 
    List(w0),
    List(r0,r1),
    BankedMemory, 
    Some(List(0L.toDouble,256L.toDouble,0L.toDouble,320L.toDouble,-1L.toDouble,3136L.toDouble,64L.toDouble,576L.toDouble,-1L.toDouble,3200L.toDouble,128L.toDouble,832L.toDouble,-1L.toDouble,3264L.toDouble,3776L.toDouble,192L.toDouble,1088L.toDouble,-1L.toDouble,10048L.toDouble,320L.toDouble,1600L.toDouble,-1L.toDouble,10176L.toDouble,448L.toDouble,2112L.toDouble,-1L.toDouble,10304L.toDouble,576L.toDouble,2624L.toDouble,-1L.toDouble,10432L.toDouble,11456L.toDouble,704L.toDouble,3904L.toDouble,-1L.toDouble,17856L.toDouble,960L.toDouble,4928L.toDouble,-1L.toDouble,18112L.toDouble,1216L.toDouble,5952L.toDouble,-1L.toDouble,18368L.toDouble,1472L.toDouble,6976L.toDouble,-1L.toDouble,18624L.toDouble,1728L.toDouble,8000L.toDouble,-1L.toDouble,18880L.toDouble,1984L.toDouble,9024L.toDouble,-1L.toDouble,19136L.toDouble,2240L.toDouble,11712L.toDouble,19648L.toDouble,-1L.toDouble,21696L.toDouble,2752L.toDouble,13760L.toDouble,-1L.toDouble,22208L.toDouble,3264L.toDouble,15808L.toDouble,-1L.toDouble)), 
    true, 
    0,
    2, 
    myName = "x3904_weights_start_idx_args_0"
  ))
  m.io.asInstanceOf[StandardInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x3904_weights_start_idx_args_0_p", m.io.p)
}
