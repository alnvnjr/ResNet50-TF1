#include <vector>
#include <stdint.h>
#include <sys/time.h>
#include <iostream>
#include <fstream>
#include <string> 
#include <sstream> 
#include <stdarg.h>
#include <signal.h>
#include <sys/wait.h>
#include <pwd.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include "Fixed.hpp"
using std::vector;
#ifndef STRUCTS_HPP
#define STRUCTS_HPP
#ifndef ZYNQ
typedef __int128 int128_t;
#endif
struct Tup2FixTRUE_10_22FixTRUE_32_0 {
  int32_t _1; // double
  int32_t _2; // int32_t
  Tup2FixTRUE_10_22FixTRUE_32_0(double _1_in,int32_t _2_in){ /* Normal Constructor */
    set_1(_1_in);
    set_2(_2_in);
  }
  Tup2FixTRUE_10_22FixTRUE_32_0(){} /* For creating empty array */
  std::string toString(){
    return  "_1: " + std::to_string((double) ((double) _1 / ((int32_t)1 << 22)))+ ", " +  "_2: " + std::to_string(_2);
  }
  void set_1(double x){ this->_1 = (int32_t) (x * ((int32_t)1 << 22)); }
  void set_2(int32_t x){ this->_2 = x; }
  int64_t toRaw() { /* For compacting struct into one int */
    int64_t result = 0;
    result = result | ((int64_t) (this->_1) << 0); 
    result = result | ((int64_t) (this->_2) << 32); 
    return result;
  }
  Tup2FixTRUE_10_22FixTRUE_32_0(int128_t bits){ /* Constructor from raw bits */
    set_1((double) (bits >> 0));
    set_2((int32_t) (bits >> 32));
  }
 
} __attribute__((packed));
#endif // STRUCTS_HPP ///:~ 
