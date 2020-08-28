package spatial.tests.apps

import spatial.dsl._
import utils.math._

@spatial class resnetofficialopt2 extends SpatialTest {
  // override def compileArgs: Args = super.compileArgs and "--forceFuseFMA" and "--noBindParallels"
  override def runtimeArgs: Args = "/path/to/input.csv  /path/to/classes.csv  /path/to/weights/directory/"
  
  type T = FixPt[TRUE,_10,_22]
  
  // Layer 0
  val B_L0   = 2
  val WLP_L0 = 1
  val IP_L0  = 1
  val OP_L0  = 1
  val DLP_L0 = 2
  val SP_L0  = 1

  // Fused_Conv2D_BiasAdd_k1
  val B_L1   = 32
  val WLP_L1 = 8
  val IP_L1  = 32
  val OP_L1  = 8
  val DLP_L1 = 16
  val SP_L1  = 8

  // Fused_Conv2D_BiasAdd_k3
  val B_L3   = 32
  val WLP_L3 = 8
  val IP_L3  = 32
  val OP_L3  = 1
  val DLP_L3 = 4
  val SP_L3  = 1

  val OP_L76 = 1
  val IP_L76 = 4

  def main(args: Array[String]): Unit = {

    val debug:scala.Boolean = false
    
    val i0 = loadCSV1D[T](args(0), "\n").reshape(3,224,224)
    val i0_pad = (0::3, 0::230, 0::230){(i,j,k) => if (j>=3 && j<227 && k>=3 && k<227) i0(i,j-3,k-3) else 0.to[T]};
    val i0_pad_DRAM = DRAM[T](3,230,230)
    val tmp76_DRAM = DRAM[T](1008)
    setMem(i0_pad_DRAM, i0_pad)

    val tmp_DRAM = DRAM[T](3, 802816)

    // Bias DRAM
    val Fused_Conv2D_BiasAdd_k3_bias_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k3_bias_concat.bin").map{e => e.to[T]}
    val Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM = DRAM[T](3776)
    setMem(Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM, Fused_Conv2D_BiasAdd_k3_bias_concat)

    // Weight DRAM
    val Fused_Conv2D_BiasAdd_k3_weights_64_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k3_weights_64_concat.bin").map{e => e.to[T]}.reshape(192,64,3*3)
    val Fused_Conv2D_BiasAdd_k3_weights_128_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k3_weights_128_concat.bin").map{e => e.to[T]}.reshape(512,128,3*3)
    val Fused_Conv2D_BiasAdd_k3_weights_256_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k3_weights_256_concat.bin").map{e => e.to[T]}.reshape(1536,256,3*3)
    val Fused_Conv2D_BiasAdd_k3_weights_512_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k3_weights_512_concat.bin").map{e => e.to[T]}.reshape(1536,512,3*3)
    val Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM = DRAM[T](3776,512*3*3)
    val Fused_Conv2D_BiasAdd_k3_weights_concat_host = (0::3776, 0::512*3*3) { (i,j) =>
      if (i < 192) {
        val i_range = i-(0)
        val in_channel = i_range%64
        val out_channel = j/(3*3) + (i_range/64)*64
        val kernel = j%(3*3)
        if (j/(3*3) < 64) {
          Fused_Conv2D_BiasAdd_k3_weights_64_concat(out_channel, in_channel, kernel)
        } else {
          0.to[T]
        }
      } else if (i < 704) {
        val i_range = i-(192)
        val in_channel = i_range%128
        val out_channel = j/(3*3) + (i_range/128)*128
        val kernel = j%(3*3)
        if (j/(3*3) < 128) {
          Fused_Conv2D_BiasAdd_k3_weights_128_concat(out_channel, in_channel, kernel)
        } else {
          0.to[T]
        }
      } else if (i < 2240) {
        val i_range = i-(704)
        val in_channel = i_range%256
        val out_channel = j/(3*3) + (i_range/256)*256
        val kernel = j%(3*3)
        if (j/(3*3) < 256) {
          Fused_Conv2D_BiasAdd_k3_weights_256_concat(out_channel, in_channel, kernel)
        } else {
          0.to[T]
        }
      } else  {
        val i_range = i-(2240)
        val in_channel = i_range%512
        val out_channel = j/(3*3) + (i_range/512)*512
        val kernel = j%(3*3)
        Fused_Conv2D_BiasAdd_k3_weights_512_concat(out_channel, in_channel, kernel)
      }
    }
    setMem(Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM, Fused_Conv2D_BiasAdd_k3_weights_concat_host)

    // Bias DRAM
    val Fused_Conv2D_BiasAdd_k1_bias_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k1_bias_concat.bin").map{e => e.to[T]}
    val Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM = DRAM[T](22720)
    setMem(Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM, Fused_Conv2D_BiasAdd_k1_bias_concat)

    // Weight DRAM
    val Fused_Conv2D_BiasAdd_k1_weights_64_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k1_weights_64_concat.bin").map{e => e.to[T]}.reshape(1088,64)
    val Fused_Conv2D_BiasAdd_k1_weights_256_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k1_weights_256_concat.bin").map{e => e.to[T]}.reshape(6912,256)
    val Fused_Conv2D_BiasAdd_k1_weights_128_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k1_weights_128_concat.bin").map{e => e.to[T]}.reshape(2048,128)
    val Fused_Conv2D_BiasAdd_k1_weights_512_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k1_weights_512_concat.bin").map{e => e.to[T]}.reshape(7808,512)
    val Fused_Conv2D_BiasAdd_k1_weights_1024_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k1_weights_1024_concat.bin").map{e => e.to[T]}.reshape(3840,1024)
    val Fused_Conv2D_BiasAdd_k1_weights_2048_concat = loadBinary[Float](args(args.length-1) + "/Fused_Conv2D_BiasAdd_k1_weights_2048_concat.bin").map{e => e.to[T]}.reshape(1024,2048)
    val Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM = DRAM[T](22720,2048)
    val Fused_Conv2D_BiasAdd_k1_weights_concat_host = (0::22720, 0::2048) { (i,j) =>
      if (i < 1088) {
        if (j < 64) {
          Fused_Conv2D_BiasAdd_k1_weights_64_concat(i-(0), j)
        } else {
          0.to[T]
        }
      } else if (i < 3136) {
        if (j < 128) {
          Fused_Conv2D_BiasAdd_k1_weights_128_concat(i-(1088), j)
        } else {
          0.to[T]
        }
      } else if (i < 10048) {
        if (j < 256) {
          Fused_Conv2D_BiasAdd_k1_weights_256_concat(i-(3136), j)
        } else {
          0.to[T]
        }
      } else if (i < 17856) {
        if (j < 512) {
          Fused_Conv2D_BiasAdd_k1_weights_512_concat(i-(10048), j)
        } else {
          0.to[T]
        }
      } else if (i < 21696) {
        if (j < 1024) {
          Fused_Conv2D_BiasAdd_k1_weights_1024_concat(i-(17856), j)
        } else {
          0.to[T]
        }
      } else  {
          Fused_Conv2D_BiasAdd_k1_weights_2048_concat(i-(21696), j)
      }
    }
    setMem(Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM, Fused_Conv2D_BiasAdd_k1_weights_concat_host)

    val c87 = loadBinary[Float](args(args.length-1) + "/c87.bin").map{e => e.to[T]} // resnet_model/dense/bias
    val c101 = loadBinary[Float](args(args.length-1) + "/c101.bin").map{e => e.to[T]} // resnet_model/conv2d/kernel
    val c27 = loadBinary[Float](args(args.length-1) + "/c27.bin").map{e => e.to[T]} // resnet_model/conv2d/Conv2D_bn_offset
    val c90 = loadBinary[Float](args(args.length-1) + "/c90.bin").map{e => e.to[T]} // resnet_model/dense/kernel
    val c101_DRAM = DRAM[T](64,3,7*7)
    setMem(c101_DRAM, c101.reshape(64,3,7*7))
    val c27_DRAM = DRAM[T](64)
    setMem(c27_DRAM, c27)
    val c90_DRAM = DRAM[T](1001,2048)
    setMem(c90_DRAM, c90.reshape(1001,2048))
    val c87_DRAM = DRAM[T](1008)
    setMem(c87_DRAM, c87)

    Accel {

      def Fused_Conv2D_BiasAdd_k1(MAX__in2D_aligned: Int, MAX__in_channels: Int, MAX__oc: Int, MAX__or: Int, MAX__out2D_aligned: Int, MAX__out_channels: Int, bias_start_idx : Int, in2D: Int, inB : Int, in_channels: Int, load_idx_0 : Int, nc: Int, nr: Int, oc: Int, or: Int, out2D: Int, out_channels: Int, store_idx : Int, stride: Int, use_relu: Boolean, weights_start_idx : Int, L : Int) : Unit = {

        val B = B_L1
        val s = stride
        val ofmap_block_store_size = mux(inB<B,inB,B.to[Int])
        Foreach(out_channels by B) { outCh_i => // out channels
        
          val bias_SRAM = SRAM[T](B)
          bias_SRAM load Fused_Conv2D_BiasAdd_k1_bias_concat_DRAM(bias_start_idx + outCh_i.to[Int] :: bias_start_idx + outCh_i.to[Int] + B)
      
          val weight_SRAM = SRAM[T](B, MAX__in_channels).flat.noduplicate
          weight_SRAM load Fused_Conv2D_BiasAdd_k1_weights_concat_DRAM(weights_start_idx + outCh_i :: weights_start_idx + outCh_i + B, 0::in_channels par WLP_L1)

          val weight_SRAM_reshape = SRAM[T](B, MAX__in_channels).flat.noduplicate
          Foreach(in_channels by 1, B by 1 par WLP_L1/2) { (inCh_i, b) =>
            weight_SRAM_reshape(b, inCh_i) = weight_SRAM(b, inCh_i)
          }

          val out_SRAM_conv = SRAM[T](MAX__or, MAX__oc, B).buffer
          Foreach(in_channels by inB) { inCh_i => // in channels
            val in_buffer = SRAM[T](3136)
            val start_idx = inCh_i*in2D
            in_buffer load tmp_DRAM(load_idx_0, start_idx :: start_idx + 3136 par DLP_L1)
            
            Pipe.II(1).Foreach(0::inB par 1, 0 until oc par OP_L1, 0 until or, 0 until B par IP_L1) { case List(ib,c,r,b) =>
              val loaded_val = in_buffer(ib*in2D + mux(s==1,r,r*2)*nc + mux(s==1,c,c*2))
              val partial_sum = loaded_val * weight_SRAM_reshape(b, inCh_i.to[Int] + ib.to[Int])              
              val start_from_0 = (inCh_i == 0) && (ib == 0)
              out_SRAM_conv(r,c,b) = partial_sum + mux(start_from_0, 0.to[T], out_SRAM_conv(r,c,b))
            }
          }
          
          // Fused BiasAdd
          Foreach(B by 1) { b =>
            val out_SRAM_bias = SRAM[T](MAX__out2D_aligned)
            Foreach(0 until or, 0 until oc par SP_L1) { (r,c) =>
              val sum = out_SRAM_conv(r,c,b) + bias_SRAM(b)
              out_SRAM_bias(r.to[Int]*oc + c.to[Int]) = mux( use_relu && (sum < 0.to[T]), 0.to[T], sum )
            }
            tmp_DRAM(store_idx, (outCh_i.to[Int] + b.to[Int])*out2D :: (outCh_i.to[Int] + b.to[Int] + 1)*out2D par SP_L1) store out_SRAM_bias
          }
        }
        // Optimization: BiasAdd was merged into Conv2D above
        // Optimization: ReLU was merged into Conv2D above
      }

      def Fused_Conv2D_BiasAdd_k3(MAX__in2D_aligned: Int, MAX__in_channels: Int, MAX__oc: Int, MAX__or: Int, MAX__out2D_aligned: Int, MAX__out_channels: Int, bias_start_idx : Int, in2D: Int, inB : Int, in_channels: Int, load_idx_0 : Int, nc: Int, nr: Int, oc: Int, or: Int, out2D: Int, out_channels: Int, store_idx : Int, stride: Int, use_relu: Boolean, weights_start_idx : Int, L : Int) : Unit = {

        val B = B_L3
        val bias_SRAM = SRAM[T](MAX__out_channels)
        bias_SRAM load Fused_Conv2D_BiasAdd_k3_bias_concat_DRAM(bias_start_idx :: bias_start_idx + out_channels)
        Foreach(out_channels by B) { outCh_i => // out channels
        
          val kr = 3
          val kc = 3
          val kr_ignore = 1
          val kc_ignore = 1
          val s = stride
        
          val out_SRAM_conv = SRAM[T](MAX__or, MAX__oc, B)
          Foreach(in_channels by 1) { inCh_i => // in channels
          
            val weight_SRAM = SRAM[T](B*kr*kc).flat.noduplicate
            weight_SRAM load Fused_Conv2D_BiasAdd_k3_weights_concat_DRAM(weights_start_idx + inCh_i.to[Int], kr*kc*outCh_i.to[Int]::kr*kc*(outCh_i.to[Int]+B) par WLP_L3)
            val weight_SRAM_reshape = SRAM[T](B,kr*kc).hierarchical.noduplicate
            Foreach(kr*kc by 1, B by 1 par WLP_L3/2) { (ij, b) =>
              weight_SRAM_reshape(b, ij) = weight_SRAM(b*kr*kc + ij)
            }
            val img2D = SRAM[T](MAX__in2D_aligned)
            img2D load tmp_DRAM(load_idx_0, inCh_i*in2D :: inCh_i*in2D + in2D par DLP_L3)
            
            Pipe.II(1).Foreach(0 until or, 0 until oc, 0 until B par IP_L3) { (r,c,b) =>
            
              val row_start = min((kr-1).to[Int], max(0.to[Int], (kr_ignore-r.to[Int]*s.to[Int]   ).to[Int]) )
              val row_end   = min((kr  ).to[Int], max(1.to[Int], (nr+kr_ignore-r.to[Int]*s.to[Int]).to[Int]) )
              val col_start = min((kc-1).to[Int], max(0.to[Int], (kc_ignore-c.to[Int]*s.to[Int]   ).to[Int]) )
              val col_end   = min((kc  ).to[Int], max(1.to[Int], (nc+kc_ignore-c.to[Int]*s.to[Int]).to[Int]) )
              
              val kernel: List[T] = List.tabulate(kr){i => List.tabulate(kc){j => 
                weight_SRAM_reshape(b, kc*i.to[Int] + j.to[Int])
              }}.flatten
              
              val data: List[T] = List.tabulate(kr){i => List.tabulate(kc){j => 
              
                if (i < 1 && j < 1) {
                  mux((i < row_start || j < col_start),
                    0.to[T],
                    img2D((i.to[Int]-kr_ignore+mux(s==1,r,r*2))*nc + j.to[Int]-kc_ignore+mux(s==1,c,c*2))
                  )
                }
                else if (i == 1 && j < 1) {
                  mux((j < col_start),
                    0.to[T],
                    img2D((i.to[Int]-kr_ignore+mux(s==1,r,r*2))*nc + j.to[Int]-kc_ignore+mux(s==1,c,c*2))
                  )
                }
                else if (i > 1 && j < 1) {
                  mux((i+1 > row_end || j < col_start),
                    0.to[T],
                    img2D((i.to[Int]-kr_ignore+mux(s==1,r,r*2))*nc + j.to[Int]-kc_ignore+mux(s==1,c,c*2))
                  )
                }
                
                else if (i < 1 && j == 1) {
                  mux((i < row_start),
                    0.to[T],
                    img2D((i.to[Int]-kr_ignore+mux(s==1,r,r*2))*nc + j.to[Int]-kc_ignore+mux(s==1,c,c*2))
                  )
                }
                else if (i == 1 && j == 1) {
                    img2D((i.to[Int]-kr_ignore+mux(s==1,r,r*2))*nc + j.to[Int]-kc_ignore+mux(s==1,c,c*2))
                }
                else if (i > 1 && j == 1) {
                  mux((i+1 > row_end),
                    0.to[T],
                    img2D((i.to[Int]-kr_ignore+mux(s==1,r,r*2))*nc + j.to[Int]-kc_ignore+mux(s==1,c,c*2))
                  )
                }
                
                else if (i < 1 && j > 1) {
                  mux((i < row_start || j+1 > col_end),
                    0.to[T],
                    img2D((i.to[Int]-kr_ignore+mux(s==1,r,r*2))*nc + j.to[Int]-kc_ignore+mux(s==1,c,c*2))
                  )
                }
                else if (i == 1 && j > 1) {
                  mux((j+1 > col_end),
                    0.to[T],
                    img2D((i.to[Int]-kr_ignore+mux(s==1,r,r*2))*nc + j.to[Int]-kc_ignore+mux(s==1,c,c*2))
                  )
                }
                else {// if (i > 1 && j > 1) {
                  mux((i+1 > row_end || j+1 > col_end),
                    0.to[T],
                    img2D((i.to[Int]-kr_ignore+mux(s==1,r,r*2))*nc + j.to[Int]-kc_ignore+mux(s==1,c,c*2))
                  )
                }
              }}.flatten
              
              val partial_sum = ReduceTree(data.zip(kernel).map{case (data_i, kernel_i) => data_i * kernel_i} :_*){_+_}
              out_SRAM_conv(r, c, b) = partial_sum + mux(inCh_i==0, 0.to[T], out_SRAM_conv(r, c, b))
            }
          }
          
          // Fused BiasAdd
          Foreach(B by 1) { b =>
            val out_SRAM_bias = SRAM[T](MAX__out2D_aligned)
            Foreach(0 until or, 0 until oc par SP_L3) { (r,c) =>
              val sum = out_SRAM_conv(r,c,b) + bias_SRAM(outCh_i.to[Int] + b.to[Int])
              out_SRAM_bias(r.to[Int]*oc + c.to[Int]) = mux( use_relu && (sum < 0.to[T]), 0.to[T], sum )
            }
            tmp_DRAM(store_idx, (outCh_i.to[Int] + b.to[Int])*out2D :: (outCh_i.to[Int] + b.to[Int] + 1)*out2D par SP_L3) store out_SRAM_bias
          }
        }
        // Optimization: BiasAdd was merged into Conv2D above
        // Optimization: ReLU was merged into Conv2D above
      }

      def Add3D(MAX__in2D_aligned: Int, in2D: Int, in_channels: Int, load_idx_0 : Int, load_idx_1 : Int, store_idx : Int, L : Int) : Unit = {
        val block_size = MAX__in2D_aligned
        Foreach(in_channels*in2D by block_size) { idx =>
          val feature_map_a = SRAM[T](block_size)
          feature_map_a load tmp_DRAM(load_idx_0, idx :: idx + block_size par 16)
          
          val feature_map_b = SRAM[T](block_size)
          feature_map_b load tmp_DRAM(load_idx_1, idx :: idx + block_size par 16)
          
          val feature_map_sum = SRAM[T](block_size)
          Foreach(block_size by 1 par 16) { i => feature_map_sum(i) = max(0.to[T], feature_map_a(i) + feature_map_b(i)) }
          
          tmp_DRAM(store_idx, idx :: idx + block_size par 16) store feature_map_sum
        }
      }

//    Sequential.Foreach(batch_size by 1) { batch_idx =>

        val B = B_L0
        val c27_SRAM = SRAM[T](64)
        c27_SRAM load c27_DRAM(0::64)
        Foreach(64 by B_L0) { outCh_i => // out channels
          val nr = 230
          val nc = 230
          val kr = 7
          val kc = 7
          val or = 112
          val oc = 112
          val inCh = 3
          val tmp0_SRAM_conv = SRAM[T](or, oc, B)
          val kr_ignore = 3
          val s = 2
        
          // Outside loop since small inCh. Can also move inside loop, e.g. SRAM(B, 1, kr*kc).  
          // Can also load inCh*kr*kc*B (single 1D load) since B small as well.
          val c101_SRAM = SRAM[T](B, inCh, kr*kc).hierarchical.noduplicate
          c101_SRAM load c101_DRAM(outCh_i::outCh_i.to[Int] + B, 0::inCh, 0::kr*kc)
        
          Foreach(inCh by 1) { inCh_i => // in channels
            val lb0 = LineBuffer.strided[T](kr+1, nc, s)
            Foreach(0 until or + kr_ignore) { r =>
              val row_to_load_from = min(r.to[Int]*s.to[Int], nr.to[Int]-s.to[Int])
              lb0 load i0_pad_DRAM(inCh_i, row_to_load_from::row_to_load_from+s, 0::nc par DLP_L0)
              
              Pipe.II(1).Foreach(0 until oc, 0 until B par 1) { (c,b) =>
                
                val row_start = max(0.to[Int], (kr-1-r.to[Int]*s.to[Int]   ).to[Int])
                
                val kernel: List[T] = List.tabulate(kr){i => List.tabulate(kc){j => 
                  c101_SRAM(b, inCh_i, kc*i.to[Int] + j.to[Int])
                }}.flatten
                
                val data: List[T] = List.tabulate(kr){i => List.tabulate(kc){j => 
                  if (i < 3) {
                    mux((i < row_start),
                      0.to[T],
                      lb0(kr-i,j.to[Int]+c.to[Int]*s.to[Int])
                    )
                  }
                  else {
                      lb0(kr-i,j.to[Int]+c.to[Int]*s.to[Int])
                  }
                }}.flatten
                
                val partial_sum = ReduceTree(data.zip(kernel).map{case (data_i, kernel_i) => data_i * kernel_i} :_*){_+_}
                if (r >= kr_ignore) {
                  tmp0_SRAM_conv(r.to[Int]-kr_ignore, c, b) = partial_sum + mux(inCh_i == 0, 0.to[T], tmp0_SRAM_conv(r.to[Int]-kr_ignore, c, b))
                }
              }
            }
          }
          
          // Fused BiasAdd
          Foreach(B by 1) { b =>
            val tmp0_SRAM_pool = SRAM[T](3136)
            Foreach(56 by 1, 56 by 1) { (i,j) =>
              val pool_elements: List[T] = List.tabulate(3){ii => List.tabulate(3){jj =>
                mux(
                    i.to[Int]*2 + ii.to[Int] >= 112 || j.to[Int]*2 + jj.to[Int] >= 112,
                    0.to[T],
                    max(
                        0.to[T], 
                        tmp0_SRAM_conv(
                            min(112-1, i.to[Int]*2 + ii.to[Int]),
                            min(112-1, j.to[Int]*2 + jj.to[Int]),
                            b
                        ) + c27_SRAM(outCh_i.to[Int] + b.to[Int])
                    )
                )
              }}.flatten
              tmp0_SRAM_pool(i.to[Int]*56 + j.to[Int]) = ReduceTree(pool_elements :_*){max(_,_)}
            }
            tmp_DRAM(0.to[Int], (outCh_i.to[Int] + b.to[Int])*3136 :: (outCh_i.to[Int] + b.to[Int])*3136 + 3136) store tmp0_SRAM_pool
          }
        }
        // Optimization: BiasAdd was merged into Conv2D above
        // Optimization: ReLU was merged into Conv2D above
        // Optimization: MaxPool was merged into Conv2D above

        
        val check_Fused_Conv2D_BiasAdd_k3 = LUT[Bit](68)(false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, true, false, false, false, true, false, false)
        val check_Fused_Conv2D_BiasAdd_k1 = LUT[Bit](68)(true, true, false, true, false, true, false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false, true, false)
        // val check_Add3D = LUT[Bit](68)(false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, true, false, false, false, true, false, false, false, true)

        val stride_args = LUT[Int](68)(1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 2, 1, 2, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 2, 1, 2, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 2, 1, 2, -1, 1, 1, 1, -1, 1, 1, 1, -1)
        val in2D_args = LUT[Int](68)(3136, 3136, 3136, 3136, 3136, 3136, 3136, 3136, 3136, 3136, 3136, 3136, 3136, 3136, 3136, 3136, 784, 784, 784, 784, 784, 784, 784, 784, 784, 784, 784, 784, 784, 784, 784, 784, 784, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 196, 49, 196, 49, 49, 49, 49, 49, 49, 49, 49, 49)
        val in_channels_args = LUT[Int](68)(64, 64, 64, 64, 256, 256, 64, 64, 256, 256, 64, 64, 256, 256, 256, 128, 128, 512, 512, 128, 128, 512, 512, 128, 128, 512, 512, 128, 128, 512, 512, 512, 256, 256, 1024, 1024, 256, 256, 1024, 1024, 256, 256, 1024, 1024, 256, 256, 1024, 1024, 256, 256, 1024, 1024, 256, 256, 1024, 1024, 512, 512, 1024, 2048, 2048, 512, 512, 2048, 2048, 512, 512, 2048)
        val weights_start_idx_args = LUT[Int](68)(0, 256, 0, 320, -1, 3136, 64, 576, -1, 3200, 128, 832, -1, 3264, 3776, 192, 1088, -1, 10048, 320, 1600, -1, 10176, 448, 2112, -1, 10304, 576, 2624, -1, 10432, 11456, 704, 3904, -1, 17856, 960, 4928, -1, 18112, 1216, 5952, -1, 18368, 1472, 6976, -1, 18624, 1728, 8000, -1, 18880, 1984, 9024, -1, 19136, 2240, 11712, 19648, -1, 21696, 2752, 13760, -1, 22208, 3264, 15808, -1)
        val bias_start_idx_args = LUT[Int](68)(0, 256, 0, 320, -1, 576, 64, 640, -1, 896, 128, 960, -1, 1216, 1728, 192, 1856, -1, 2368, 320, 2496, -1, 3008, 448, 3136, -1, 3648, 576, 3776, -1, 4288, 5312, 704, 5568, -1, 6592, 960, 6848, -1, 7872, 1216, 8128, -1, 9152, 1472, 9408, -1, 10432, 1728, 10688, -1, 11712, 1984, 11968, -1, 12992, 2240, 13504, 15552, -1, 17600, 2752, 18112, -1, 20160, 3264, 20672, -1)
        val load_idx_0_args = LUT[Int](68)(0, 0, 2, 0, 2, 0, 1, 2, 1, 2, 0, 1, 0, 1, 1, 2, 1, 2, 1, 0, 2, 0, 2, 0, 1, 0, 1, 0, 2, 0, 2, 2, 1, 2, 1, 2, 0, 1, 0, 1, 0, 2, 0, 2, 0, 1, 0, 1, 0, 2, 0, 2, 0, 1, 0, 1, 0, 2, 1, 0, 1, 0, 2, 0, 2, 0, 1, 0)
        val store_idx_args = LUT[Int](68)(1, 2, 0, 2, 0, 1, 2, 1, 2, 0, 1, 0, 1, 0, 2, 1, 2, 1, 0, 2, 0, 2, 0, 1, 0, 1, 0, 2, 0, 2, 0, 1, 2, 1, 2, 0, 1, 0, 1, 0, 2, 0, 2, 0, 1, 0, 1, 0, 2, 0, 2, 0, 1, 0, 1, 0, 2, 0, 2, 1, 0, 2, 0, 2, 0, 1, 0, 1)
        val or_args = LUT[Int](68)(56, 56, 56, 56, -1, 56, 56, 56, -1, 56, 56, 56, -1, 28, 56, 28, 28, -1, 28, 28, 28, -1, 28, 28, 28, -1, 28, 28, 28, -1, 14, 28, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 7, 7, 7, -1, 7, 7, 7, -1, 7, 7, 7, -1)
        val out2D_args = LUT[Int](68)(3136, 3136, 3136, 3136, -1, 3136, 3136, 3136, -1, 3136, 3136, 3136, -1, 784, 3136, 784, 784, -1, 784, 784, 784, -1, 784, 784, 784, -1, 784, 784, 784, -1, 196, 784, 196, 196, -1, 196, 196, 196, -1, 196, 196, 196, -1, 196, 196, 196, -1, 196, 196, 196, -1, 196, 196, 196, -1, 196, 49, 49, 49, -1, 49, 49, 49, -1, 49, 49, 49, -1)
        val nc_args = LUT[Int](68)(56, 56, 56, 56, -1, 56, 56, 56, -1, 56, 56, 56, -1, 56, 56, 56, 28, -1, 28, 28, 28, -1, 28, 28, 28, -1, 28, 28, 28, -1, 28, 28, 28, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 7, 14, -1, 7, 7, 7, -1, 7, 7, 7, -1)
        val oc_args = LUT[Int](68)(56, 56, 56, 56, -1, 56, 56, 56, -1, 56, 56, 56, -1, 28, 56, 28, 28, -1, 28, 28, 28, -1, 28, 28, 28, -1, 28, 28, 28, -1, 14, 28, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 7, 7, 7, -1, 7, 7, 7, -1, 7, 7, 7, -1)
        val nr_args = LUT[Int](68)(56, 56, 56, 56, -1, 56, 56, 56, -1, 56, 56, 56, -1, 56, 56, 56, 28, -1, 28, 28, 28, -1, 28, 28, 28, -1, 28, 28, 28, -1, 28, 28, 28, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 14, -1, 14, 14, 7, 14, -1, 7, 7, 7, -1, 7, 7, 7, -1)
        val out_channels_args = LUT[Int](68)(256, 64, 64, 256, -1, 64, 64, 256, -1, 64, 64, 256, -1, 512, 128, 128, 512, -1, 128, 128, 512, -1, 128, 128, 512, -1, 128, 128, 512, -1, 1024, 256, 256, 1024, -1, 256, 256, 1024, -1, 256, 256, 1024, -1, 256, 256, 1024, -1, 256, 256, 1024, -1, 256, 256, 1024, -1, 512, 512, 2048, 2048, -1, 512, 512, 2048, -1, 512, 512, 2048, -1)

        Sequential.Foreach(0 until 68) { L =>
          if (check_Fused_Conv2D_BiasAdd_k3(L)) {
            Fused_Conv2D_BiasAdd_k3(3136, 512, 56, 56, 3136, 512, bias_start_idx_args(L), in2D_args(L), 1, in_channels_args(L), load_idx_0_args(L), nc_args(L), nr_args(L), oc_args(L), or_args(L), out2D_args(L), out_channels_args(L), store_idx_args(L), stride_args(L), true, weights_start_idx_args(L), L)
          } else if (check_Fused_Conv2D_BiasAdd_k1(L)) {
            val inB_args = LUT[Int](68)(1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, 1, -1, 4, -1, 4, -1, 4, -1, 4, -1, 4, -1, 4, -1, 4, -1, 4, 4, -1, 16, -1, 16, -1, 16, -1, 16, -1, 16, -1, 16, -1, 16, -1, 16, -1, 16, -1, 16, -1, 16, -1, 16, -1, 64, 16, -1, 64, -1, 64, -1, 64, -1, 64, -1)
            val use_relu_args = LUT[Boolean](68)(false, true, false, false, false, true, false, false, false, true, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, true, false, false, false, true, false, false, false)
            Fused_Conv2D_BiasAdd_k1(3136, 2048, 56, 56, 3136, 2048, bias_start_idx_args(L), in2D_args(L), inB_args(L), in_channels_args(L), load_idx_0_args(L), nc_args(L), nr_args(L), oc_args(L), or_args(L), out2D_args(L), out_channels_args(L), store_idx_args(L), stride_args(L), use_relu_args(L), weights_start_idx_args(L), L)
          } else { // if (check_Add3D(L)) {
            val load_idx_1_args = LUT[Int](68)(-1, -1, -1, -1, 1, -1, -1, -1, 0, -1, -1, -1, 2, -1, -1, -1, -1, 0, -1, -1, -1, 1, -1, -1, -1, 2, -1, -1, -1, 1, -1, -1, -1, -1, 0, -1, -1, -1, 2, -1, -1, -1, 1, -1, -1, -1, 2, -1, -1, -1, 1, -1, -1, -1, 2, -1, -1, -1, -1, 2, -1, -1, -1, 1, -1, -1, -1, 2)
            Add3D(3136, in2D_args(L), in_channels_args(L), load_idx_0_args(L), load_idx_1_args(L), store_idx_args(L), L)
          }
        }

        val tmp75_SRAM = SRAM[T](2048)
        Foreach(2048 by 1) { channel =>
          val feature_map = SRAM[T](64)
          feature_map load tmp_DRAM(store_idx_args(67), channel*49 :: channel*49 + 49)
          val sum = Reduce(Reg[T](0.to[T]))(49 by 1 par 1){ i => feature_map(i)*0.0204081632653.to[T] }{_+_}
          tmp75_SRAM(channel) = sum.value
        }

        // MatMul
        val c87_SRAM = SRAM[T](1008)
        c87_SRAM load c87_DRAM(0::1008)
        val tmp76_SRAM = SRAM[T](1008)
        Foreach(1001 by 1 par OP_L76){out_i =>
          val c90_row_SRAM = SRAM[T](2048)
          c90_row_SRAM load c90_DRAM(out_i, 0::2048 par IP_L76)
          val prod = Reduce(Reg[T](0.to[T]))(2048 by 1 par IP_L76){ in_i => tmp75_SRAM(in_i) * c90_row_SRAM(in_i) }{_+_}
          tmp76_SRAM(out_i) = prod.value + c87_SRAM(out_i)
        }
        // Optimization: BiasAdd was merged into MatMul above

        tmp76_DRAM(0::1008) store tmp76_SRAM
//    } Sequential over all images
    }

    val output = getMem(tmp76_DRAM)
    val output_no_extra = Array.tabulate(1000){i => output(i+1)}
    printArray(output_no_extra, "output")
    /* Used for debugging
    val gold = loadCSV1D[T]("data_out.csv", "\n")
    printArray(gold, "gold")
    val margin = 0.005.to[T]
  	val cksum = gold.zip(output_no_extra){(a,b) => abs(a-b) < margin}.reduce{_&&_}
  	println("PASS: " + cksum)
    */

    println("\n")
    val imagenet_classes = loadCSV1D[String](args(args.length-2), "\n")
    println("Top 5 Predictions: ")
    val zipped_with_idx__1 = Array.tabulate(1000){i => pack(output_no_extra(i),i) }
    val max_idx__1         = zipped_with_idx__1.reduce{(a,b) => if (a._1 > b._1) a else b}._2
    val zipped_with_idx__2 = Array.tabulate(1000){i => if (i == max_idx__1) pack(-1.to[T],i) else pack(output_no_extra(i),i) }
    val max_idx__2         = zipped_with_idx__2.reduce{(a,b) => if (a._1 > b._1) a else b}._2
    val zipped_with_idx__3 = Array.tabulate(1000){i => if (i == max_idx__1 || i == max_idx__2) pack(-1.to[T],i) else pack(output_no_extra(i),i) }
    val max_idx__3         = zipped_with_idx__3.reduce{(a,b) => if (a._1 > b._1) a else b}._2
    val zipped_with_idx__4 = Array.tabulate(1000){i => if (i == max_idx__1 || i == max_idx__2 || i == max_idx__3) pack(-1.to[T],i) else pack(output_no_extra(i),i) }
    val max_idx__4         = zipped_with_idx__4.reduce{(a,b) => if (a._1 > b._1) a else b}._2
    val zipped_with_idx__5 = Array.tabulate(1000){i => if (i == max_idx__1 || i == max_idx__2 || i == max_idx__3 || i == max_idx__4) pack(-1.to[T],i) else pack(output_no_extra(i),i) }
    val max_idx__5         = zipped_with_idx__5.reduce{(a,b) => if (a._1 > b._1) a else b}._2
    println("  1. " + imagenet_classes(max_idx__1))
    println("  2. " + imagenet_classes(max_idx__2))
    println("  3. " + imagenet_classes(max_idx__3))
    println("  4. " + imagenet_classes(max_idx__4))
    println("  5. " + imagenet_classes(max_idx__5))
    println("")
  }
}

