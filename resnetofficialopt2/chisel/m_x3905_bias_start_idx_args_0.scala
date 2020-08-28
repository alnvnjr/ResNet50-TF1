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

class x3905_bias_start_idx_args_0 {
  val w0 = AccessHelper.singular(32)
  val r0 = Access(3951, 0, 1, List(1), List(0), None, PortInfo(Some(0), 1, 7, List(7), 32, List(List(RG(1,0,0)))))
  val r1 = Access(9503, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 7, List(7), 32, List(List(RG(1,0,0)))))
  val m = Module(new LUT( 
    List[Int](68), 0,
     32, 
    List[Int](68), 
    List[Int](1), 
    List(w0),
    List(r0,r1),
    BankedMemory, 
    Some(List(0L.toDouble,256L.toDouble,0L.toDouble,320L.toDouble,-1L.toDouble,576L.toDouble,64L.toDouble,640L.toDouble,-1L.toDouble,896L.toDouble,128L.toDouble,960L.toDouble,-1L.toDouble,1216L.toDouble,1728L.toDouble,192L.toDouble,1856L.toDouble,-1L.toDouble,2368L.toDouble,320L.toDouble,2496L.toDouble,-1L.toDouble,3008L.toDouble,448L.toDouble,3136L.toDouble,-1L.toDouble,3648L.toDouble,576L.toDouble,3776L.toDouble,-1L.toDouble,4288L.toDouble,5312L.toDouble,704L.toDouble,5568L.toDouble,-1L.toDouble,6592L.toDouble,960L.toDouble,6848L.toDouble,-1L.toDouble,7872L.toDouble,1216L.toDouble,8128L.toDouble,-1L.toDouble,9152L.toDouble,1472L.toDouble,9408L.toDouble,-1L.toDouble,10432L.toDouble,1728L.toDouble,10688L.toDouble,-1L.toDouble,11712L.toDouble,1984L.toDouble,11968L.toDouble,-1L.toDouble,12992L.toDouble,2240L.toDouble,13504L.toDouble,15552L.toDouble,-1L.toDouble,17600L.toDouble,2752L.toDouble,18112L.toDouble,-1L.toDouble,20160L.toDouble,3264L.toDouble,20672L.toDouble,-1L.toDouble)), 
    true, 
    0,
    2, 
    myName = "x3905_bias_start_idx_args_0"
  ))
  m.io.asInstanceOf[StandardInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x3905_bias_start_idx_args_0_p", m.io.p)
}
