#include "structs.hpp"
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
#include <map>
#include <math.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
// #include "FringeContext.h"
#include "/../aws.sw-resources/headers/FringeContext.h"
#include "functions.hpp"
#include "ArgAPI.hpp"
#include "Fixed.hpp"
#include <vector>
#include <filesystem>
namespace fs = std::filesystem;
using std::vector;

#ifndef ZYNQ
typedef __int128 int128_t;
#endif

void printHelp(); 

using namespace std;

void Application(int numThreads, vector<string> * args,vector<string> * img_list) {
  // Create an execution context.
  FringeContext *c1 = new FringeContext("./verilog/accel.bit.bin");
  c1->load();

  
  vector<string>* x2637 = args;
  // COPYING WEIGHTS TO DEVICE
  int32_t x2683 = (*x2637).size();
  int32_t x2684 = x2683 - 1;
  string x2685;
  try {
    x2685 = (*x2637).at(x2684);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }

  string x2686 = (x2685 + string("/Fused_Conv2D_BiasAdd_k3_bias_concat.bin"));
  std::ifstream x2687 (x2686, std::ios::binary);
  assert(x2687.good() && "File x2686 does not exist"); 
  x2687.seekg(0, std::ios::end);
  std::ifstream::pos_type x2688_pos = x2687.tellg();
  std::vector<char> x2688_temp (x2688_pos); 
  x2687.seekg(0, std::ios::beg);
  x2687.read(&x2688_temp[0], x2688_pos);
  std::vector<float>* x2688_raw = new std::vector<float>(x2688_temp.size()/4);
  memcpy((void*)&((*x2688_raw)[0]), &(x2688_temp[0]), x2688_temp.size() * sizeof(char));
  vector<float>* x2688 = new vector<float>((*x2688_raw).size());
  x2688 = x2688_raw;
  x2687.close();
  vector<double>* x2692 = new vector<double>((*x2688).size());
  for (int b56 = 0; b56 < (*x2688).size(); b56++) { 
    float x2690 = (*x2688)[b56];
    double x2691 = (double) x2690;
    (*x2692)[b56] = x2691;
  }
  uint64_t x2693 = c1->malloc(sizeof(double) * 3776);
  c1->setArg(FUSED_CONV2D_BIASADD_K3_BIAS_CONCAT_DRAM_ptr, x2693, false);
  printf("Allocate mem of size 3776 at %p\n", (void*)x2693);
  vector<int32_t>* x2693_rawified = new vector<int32_t>((*x2692).size());
  for (int x2693_rawified_i = 0; x2693_rawified_i < (*x2692).size(); x2693_rawified_i++) {
    (*x2693_rawified)[x2693_rawified_i] = (int32_t) ((*x2692)[x2693_rawified_i] * ((int32_t)1 << 22));
  }
  c1->memcpy(x2693, &(*x2693_rawified)[0], (*x2693_rawified).size() * sizeof(int32_t));
  string x2695 = (x2685 + string("/Fused_Conv2D_BiasAdd_k3_weights_64_concat.bin"));
  std::ifstream x2696 (x2695, std::ios::binary);
  assert(x2696.good() && "File x2695 does not exist"); 
  x2696.seekg(0, std::ios::end);
  std::ifstream::pos_type x2697_pos = x2696.tellg();
  std::vector<char> x2697_temp (x2697_pos); 
  x2696.seekg(0, std::ios::beg);
  x2696.read(&x2697_temp[0], x2697_pos);
  std::vector<float>* x2697_raw = new std::vector<float>(x2697_temp.size()/4);
  memcpy((void*)&((*x2697_raw)[0]), &(x2697_temp[0]), x2697_temp.size() * sizeof(char));
  vector<float>* x2697 = new vector<float>((*x2697_raw).size());
  x2697 = x2697_raw;
  x2696.close();
  vector<double>* x2701 = new vector<double>((*x2697).size());
  for (int b66 = 0; b66 < (*x2697).size(); b66++) { 
    float x2699 = (*x2697)[b66];
    double x2700 = (double) x2699;
    (*x2701)[b66] = x2700;
  }
  int32_t x2702 = (*x2701).size();
  bool x2703 = 110592 == x2702;
  string x2704 = std::to_string(x2702);
  string x2705 = (string("Number of elements in vector (") + x2704);
  string x2706 = (x2705 + string(") must match number of elements in matrix ("));
  string x2707 = (x2706 + string("192"));
  string x2708 = (x2707 + string("x"));
  string x2709 = (x2708 + string("64"));
  string x2710 = (x2709 + string("x"));
  string x2711 = (x2710 + string("9"));
  string x2712 = (x2711 + string(")"));
  string x2713 = (string("resnetofficialopt2.scala:57:168:") + x2712);
  string x2714 = ("\n=================\n" + (x2713 + "\n=================\n"));
  if (true) { ASSERT(x2703, x2714.c_str()); }
  int32_t x2715 = (*x2637).size();
  int32_t x2716 = x2715 - 1;
  string x2717;
  try {
    x2717 = (*x2637).at(x2716);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }
  string x2718 = (x2717 + string("/Fused_Conv2D_BiasAdd_k3_weights_128_concat.bin"));
  std::ifstream x2719 (x2718, std::ios::binary);
  assert(x2719.good() && "File x2718 does not exist"); 
  x2719.seekg(0, std::ios::end);
  std::ifstream::pos_type x2720_pos = x2719.tellg();
  std::vector<char> x2720_temp (x2720_pos); 
  x2719.seekg(0, std::ios::beg);
  x2719.read(&x2720_temp[0], x2720_pos);
  std::vector<float>* x2720_raw = new std::vector<float>(x2720_temp.size()/4);
  memcpy((void*)&((*x2720_raw)[0]), &(x2720_temp[0]), x2720_temp.size() * sizeof(char));
  vector<float>* x2720 = new vector<float>((*x2720_raw).size());
  x2720 = x2720_raw;
  x2719.close();
  vector<double>* x2724 = new vector<double>((*x2720).size());
  for (int b90 = 0; b90 < (*x2720).size(); b90++) { 
    float x2722 = (*x2720)[b90];
    double x2723 = (double) x2722;
    (*x2724)[b90] = x2723;
  }
  int32_t x2725 = (*x2724).size();
  bool x2726 = 589824 == x2725;
  string x2727 = std::to_string(x2725);
  string x2728 = (string("Number of elements in vector (") + x2727);
  string x2729 = (x2728 + string(") must match number of elements in matrix ("));
  string x2730 = (x2729 + string("512"));
  string x2731 = (x2730 + string("x"));
  string x2732 = (x2731 + string("128"));
  string x2733 = (x2732 + string("x"));
  string x2734 = (x2733 + string("9"));
  string x2735 = (x2734 + string(")"));
  string x2736 = (string("resnetofficialopt2.scala:58:170:") + x2735);
  string x2737 = ("\n=================\n" + (x2736 + "\n=================\n"));
  if (true) { ASSERT(x2726, x2737.c_str()); }
  int32_t x2738 = (*x2637).size();
  int32_t x2739 = x2738 - 1;
  string x2740;
  try {
    x2740 = (*x2637).at(x2739);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }
  string x2741 = (x2740 + string("/Fused_Conv2D_BiasAdd_k3_weights_256_concat.bin"));
  std::ifstream x2742 (x2741, std::ios::binary);
  assert(x2742.good() && "File x2741 does not exist"); 
  x2742.seekg(0, std::ios::end);
  std::ifstream::pos_type x2743_pos = x2742.tellg();
  std::vector<char> x2743_temp (x2743_pos); 
  x2742.seekg(0, std::ios::beg);
  x2742.read(&x2743_temp[0], x2743_pos);
  std::vector<float>* x2743_raw = new std::vector<float>(x2743_temp.size()/4);
  memcpy((void*)&((*x2743_raw)[0]), &(x2743_temp[0]), x2743_temp.size() * sizeof(char));
  vector<float>* x2743 = new vector<float>((*x2743_raw).size());
  x2743 = x2743_raw;
  x2742.close();
  vector<double>* x2747 = new vector<double>((*x2743).size());
  for (int b114 = 0; b114 < (*x2743).size(); b114++) { 
    float x2745 = (*x2743)[b114];
    double x2746 = (double) x2745;
    (*x2747)[b114] = x2746;
  }
  int32_t x2748 = (*x2747).size();
  bool x2749 = 3538944 == x2748;
  string x2750 = std::to_string(x2748);
  string x2751 = (string("Number of elements in vector (") + x2750);
  string x2752 = (x2751 + string(") must match number of elements in matrix ("));
  string x2753 = (x2752 + string("1536"));
  string x2754 = (x2753 + string("x"));
  string x2755 = (x2754 + string("256"));
  string x2756 = (x2755 + string("x"));
  string x2757 = (x2756 + string("9"));
  string x2758 = (x2757 + string(")"));
  string x2759 = (string("resnetofficialopt2.scala:59:170:") + x2758);
  string x2760 = ("\n=================\n" + (x2759 + "\n=================\n"));
  if (true) { ASSERT(x2749, x2760.c_str()); }
  int32_t x2761 = (*x2637).size();
  int32_t x2762 = x2761 - 1;
  string x2763;
  try {
    x2763 = (*x2637).at(x2762);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }
  string x2764 = (x2763 + string("/Fused_Conv2D_BiasAdd_k3_weights_512_concat.bin"));
  std::ifstream x2765 (x2764, std::ios::binary);
  assert(x2765.good() && "File x2764 does not exist"); 
  x2765.seekg(0, std::ios::end);
  std::ifstream::pos_type x2766_pos = x2765.tellg();
  std::vector<char> x2766_temp (x2766_pos); 
  x2765.seekg(0, std::ios::beg);
  x2765.read(&x2766_temp[0], x2766_pos);
  std::vector<float>* x2766_raw = new std::vector<float>(x2766_temp.size()/4);
  memcpy((void*)&((*x2766_raw)[0]), &(x2766_temp[0]), x2766_temp.size() * sizeof(char));
  vector<float>* x2766 = new vector<float>((*x2766_raw).size());
  x2766 = x2766_raw;
  x2765.close();
  vector<double>* x2770 = new vector<double>((*x2766).size());
  for (int b138 = 0; b138 < (*x2766).size(); b138++) { 
    float x2768 = (*x2766)[b138];
    double x2769 = (double) x2768;
    (*x2770)[b138] = x2769;
  }
  int32_t x2771 = (*x2770).size();
  bool x2772 = 7077888 == x2771;
  string x2773 = std::to_string(x2771);
  string x2774 = (string("Number of elements in vector (") + x2773);
  string x2775 = (x2774 + string(") must match number of elements in matrix ("));
  string x2776 = (x2775 + string("1536"));
  string x2777 = (x2776 + string("x"));
  string x2778 = (x2777 + string("512"));
  string x2779 = (x2778 + string("x"));
  string x2780 = (x2779 + string("9"));
  string x2781 = (x2780 + string(")"));
  string x2782 = (string("resnetofficialopt2.scala:60:170:") + x2781);
  string x2783 = ("\n=================\n" + (x2782 + "\n=================\n"));
  if (true) { ASSERT(x2772, x2783.c_str()); }
  uint64_t x2784 = c1->malloc(sizeof(double) * 3776*4608);
  c1->setArg(FUSED_CONV2D_BIASADD_K3_WEIGHTS_CONCAT_DRAM_ptr, x2784, false);
  printf("Allocate mem of size 3776*4608 at %p\n", (void*)x2784);
  vector<double>* x2850 = new vector<double>(17399808);
  for (int b156 = 0; b156 < 17399808; b156++) {
    int32_t x2785 = b156 / 4608;
    int32_t x2786 = (int32_t) ((b156 % 4608 + 4608) % 4608);
    bool x2787 = x2785 < 192;
    double x2849;
    if (x2787) { 
      int32_t x2788 = (int32_t) ((x2785 % 64 + 64) % 64);
      int32_t x2789 = x2786 / 9;
      int32_t x2790 = x2785 >> 6;
      int32_t x2791 = x2790 << 6;
      int32_t x2792 = x2789 + x2791;
      int32_t x2793 = (int32_t) ((x2786 % 9 + 9) % 9);
      bool x2794 = x2789 < 64;
      double x2801;
      if (x2794) { 
        int32_t x2795 = x2792 << 6;
        int32_t x2796 = x2795 * 9;
        int32_t x2797 = x2788 * 9;
        int32_t x2798 = x2796 + x2797;
        int32_t x2799 = x2798 + x2793;
        double x2800 = (*x2701)[x2799];
        x2801 = x2800;
      }
      else {
        x2801 = 0;
      }
      x2849 = x2801;
    }
    else {
      bool x2802 = x2785 < 704;
      double x2848;
      if (x2802) { 
        int32_t x2803 = x2785 - 192;
        int32_t x2804 = (int32_t) ((x2803 % 128 + 128) % 128);
        int32_t x2805 = x2786 / 9;
        int32_t x2806 = x2803 >> 7;
        int32_t x2807 = x2806 << 7;
        int32_t x2808 = x2805 + x2807;
        int32_t x2809 = (int32_t) ((x2786 % 9 + 9) % 9);
        bool x2810 = x2805 < 128;
        double x2817;
        if (x2810) { 
          int32_t x2811 = x2808 << 7;
          int32_t x2812 = x2811 * 9;
          int32_t x2813 = x2804 * 9;
          int32_t x2814 = x2812 + x2813;
          int32_t x2815 = x2814 + x2809;
          double x2816 = (*x2724)[x2815];
          x2817 = x2816;
        }
        else {
          x2817 = 0;
        }
        x2848 = x2817;
      }
      else {
        bool x2818 = x2785 < 2240;
        double x2847;
        if (x2818) { 
          int32_t x2819 = x2785 - 704;
          int32_t x2820 = (int32_t) ((x2819 % 256 + 256) % 256);
          int32_t x2821 = x2786 / 9;
          int32_t x2822 = x2819 >> 8;
          int32_t x2823 = x2822 << 8;
          int32_t x2824 = x2821 + x2823;
          int32_t x2825 = (int32_t) ((x2786 % 9 + 9) % 9);
          bool x2826 = x2821 < 256;
          double x2833;
          if (x2826) { 
            int32_t x2827 = x2824 << 8;
            int32_t x2828 = x2827 * 9;
            int32_t x2829 = x2820 * 9;
            int32_t x2830 = x2828 + x2829;
            int32_t x2831 = x2830 + x2825;
            double x2832 = (*x2747)[x2831];
            x2833 = x2832;
          }
          else {
            x2833 = 0;
          }
          x2847 = x2833;
        }
        else {
          int32_t x2834 = x2785 - 2240;
          int32_t x2835 = (int32_t) ((x2834 % 512 + 512) % 512);
          int32_t x2836 = x2786 / 9;
          int32_t x2837 = x2834 >> 9;
          int32_t x2838 = x2837 << 9;
          int32_t x2839 = x2836 + x2838;
          int32_t x2840 = (int32_t) ((x2786 % 9 + 9) % 9);
          int32_t x2841 = x2839 << 9;
          int32_t x2842 = x2841 * 9;
          int32_t x2843 = x2835 * 9;
          int32_t x2844 = x2842 + x2843;
          int32_t x2845 = x2844 + x2840;
          double x2846 = (*x2770)[x2845];
          x2847 = x2846;
        }
        x2848 = x2847;
      }
      x2849 = x2848;
    }
    (*x2850)[b156] = x2849;
  }
  vector<int32_t>* x2784_rawified = new vector<int32_t>((*x2850).size());
  for (int x2784_rawified_i = 0; x2784_rawified_i < (*x2850).size(); x2784_rawified_i++) {
    (*x2784_rawified)[x2784_rawified_i] = (int32_t) ((*x2850)[x2784_rawified_i] * ((int32_t)1 << 22));
  }
  c1->memcpy(x2784, &(*x2784_rawified)[0], (*x2784_rawified).size() * sizeof(int32_t));
  int32_t x2852 = (*x2637).size();
  int32_t x2853 = x2852 - 1;
  string x2854;
  try {
    x2854 = (*x2637).at(x2853);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }
  string x2855 = (x2854 + string("/Fused_Conv2D_BiasAdd_k1_bias_concat.bin"));
  std::ifstream x2856 (x2855, std::ios::binary);
  assert(x2856.good() && "File x2855 does not exist"); 
  x2856.seekg(0, std::ios::end);
  std::ifstream::pos_type x2857_pos = x2856.tellg();
  std::vector<char> x2857_temp (x2857_pos); 
  x2856.seekg(0, std::ios::beg);
  x2856.read(&x2857_temp[0], x2857_pos);
  std::vector<float>* x2857_raw = new std::vector<float>(x2857_temp.size()/4);
  memcpy((void*)&((*x2857_raw)[0]), &(x2857_temp[0]), x2857_temp.size() * sizeof(char));
  vector<float>* x2857 = new vector<float>((*x2857_raw).size());
  x2857 = x2857_raw;
  x2856.close();
  vector<double>* x2861 = new vector<double>((*x2857).size());
  for (int b232 = 0; b232 < (*x2857).size(); b232++) { 
    float x2859 = (*x2857)[b232];
    double x2860 = (double) x2859;
    (*x2861)[b232] = x2860;
  }
  uint64_t x2862 = c1->malloc(sizeof(double) * 22720);
  c1->setArg(FUSED_CONV2D_BIASADD_K1_BIAS_CONCAT_DRAM_ptr, x2862, false);
  printf("Allocate mem of size 22720 at %p\n", (void*)x2862);
  vector<int32_t>* x2862_rawified = new vector<int32_t>((*x2861).size());
  for (int x2862_rawified_i = 0; x2862_rawified_i < (*x2861).size(); x2862_rawified_i++) {
    (*x2862_rawified)[x2862_rawified_i] = (int32_t) ((*x2861)[x2862_rawified_i] * ((int32_t)1 << 22));
  }
  c1->memcpy(x2862, &(*x2862_rawified)[0], (*x2862_rawified).size() * sizeof(int32_t));
  string x2864 = (x2854 + string("/Fused_Conv2D_BiasAdd_k1_weights_64_concat.bin"));
  std::ifstream x2865 (x2864, std::ios::binary);
  assert(x2865.good() && "File x2864 does not exist"); 
  x2865.seekg(0, std::ios::end);
  std::ifstream::pos_type x2866_pos = x2865.tellg();
  std::vector<char> x2866_temp (x2866_pos); 
  x2865.seekg(0, std::ios::beg);
  x2865.read(&x2866_temp[0], x2866_pos);
  std::vector<float>* x2866_raw = new std::vector<float>(x2866_temp.size()/4);
  memcpy((void*)&((*x2866_raw)[0]), &(x2866_temp[0]), x2866_temp.size() * sizeof(char));
  vector<float>* x2866 = new vector<float>((*x2866_raw).size());
  x2866 = x2866_raw;
  x2865.close();
  vector<double>* x2870 = new vector<double>((*x2866).size());
  for (int b242 = 0; b242 < (*x2866).size(); b242++) { 
    float x2868 = (*x2866)[b242];
    double x2869 = (double) x2868;
    (*x2870)[b242] = x2869;
  }
  int32_t x2871 = (*x2870).size();
  bool x2872 = 69632 == x2871;
  string x2873 = std::to_string(x2871);
  string x2874 = (string("Number of elements in vector (") + x2873);
  string x2875 = (x2874 + string(") must match number of elements in matrix ("));
  string x2876 = (x2875 + string("1088"));
  string x2877 = (x2876 + string("x"));
  string x2878 = (x2877 + string("64"));
  string x2879 = (x2878 + string(")"));
  string x2880 = (string("resnetofficialopt2.scala:109:168:") + x2879);
  string x2881 = ("\n=================\n" + (x2880 + "\n=================\n"));
  if (true) { ASSERT(x2872, x2881.c_str()); }
  int32_t x2882 = (*x2637).size();
  int32_t x2883 = x2882 - 1;
  string x2884;
  try {
    x2884 = (*x2637).at(x2883);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }
  string x2885 = (x2884 + string("/Fused_Conv2D_BiasAdd_k1_weights_256_concat.bin"));
  std::ifstream x2886 (x2885, std::ios::binary);
  assert(x2886.good() && "File x2885 does not exist"); 
  x2886.seekg(0, std::ios::end);
  std::ifstream::pos_type x2887_pos = x2886.tellg();
  std::vector<char> x2887_temp (x2887_pos); 
  x2886.seekg(0, std::ios::beg);
  x2886.read(&x2887_temp[0], x2887_pos);
  std::vector<float>* x2887_raw = new std::vector<float>(x2887_temp.size()/4);
  memcpy((void*)&((*x2887_raw)[0]), &(x2887_temp[0]), x2887_temp.size() * sizeof(char));
  vector<float>* x2887 = new vector<float>((*x2887_raw).size());
  x2887 = x2887_raw;
  x2886.close();
  vector<double>* x2891 = new vector<double>((*x2887).size());
  for (int b264 = 0; b264 < (*x2887).size(); b264++) { 
    float x2889 = (*x2887)[b264];
    double x2890 = (double) x2889;
    (*x2891)[b264] = x2890;
  }
  int32_t x2892 = (*x2891).size();
  bool x2893 = 1769472 == x2892;
  string x2894 = std::to_string(x2892);
  string x2895 = (string("Number of elements in vector (") + x2894);
  string x2896 = (x2895 + string(") must match number of elements in matrix ("));
  string x2897 = (x2896 + string("6912"));
  string x2898 = (x2897 + string("x"));
  string x2899 = (x2898 + string("256"));
  string x2900 = (x2899 + string(")"));
  string x2901 = (string("resnetofficialopt2.scala:110:170:") + x2900);
  string x2902 = ("\n=================\n" + (x2901 + "\n=================\n"));
  if (true) { ASSERT(x2893, x2902.c_str()); }
  int32_t x2903 = (*x2637).size();
  int32_t x2904 = x2903 - 1;
  string x2905;
  try {
    x2905 = (*x2637).at(x2904);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }
  string x2906 = (x2905 + string("/Fused_Conv2D_BiasAdd_k1_weights_128_concat.bin"));
  std::ifstream x2907 (x2906, std::ios::binary);
  assert(x2907.good() && "File x2906 does not exist"); 
  x2907.seekg(0, std::ios::end);
  std::ifstream::pos_type x2908_pos = x2907.tellg();
  std::vector<char> x2908_temp (x2908_pos); 
  x2907.seekg(0, std::ios::beg);
  x2907.read(&x2908_temp[0], x2908_pos);
  std::vector<float>* x2908_raw = new std::vector<float>(x2908_temp.size()/4);
  memcpy((void*)&((*x2908_raw)[0]), &(x2908_temp[0]), x2908_temp.size() * sizeof(char));
  vector<float>* x2908 = new vector<float>((*x2908_raw).size());
  x2908 = x2908_raw;
  x2907.close();
  vector<double>* x2912 = new vector<double>((*x2908).size());
  for (int b286 = 0; b286 < (*x2908).size(); b286++) { 
    float x2910 = (*x2908)[b286];
    double x2911 = (double) x2910;
    (*x2912)[b286] = x2911;
  }
  int32_t x2913 = (*x2912).size();
  bool x2914 = 262144 == x2913;
  string x2915 = std::to_string(x2913);
  string x2916 = (string("Number of elements in vector (") + x2915);
  string x2917 = (x2916 + string(") must match number of elements in matrix ("));
  string x2918 = (x2917 + string("2048"));
  string x2919 = (x2918 + string("x"));
  string x2920 = (x2919 + string("128"));
  string x2921 = (x2920 + string(")"));
  string x2922 = (string("resnetofficialopt2.scala:111:170:") + x2921);
  string x2923 = ("\n=================\n" + (x2922 + "\n=================\n"));
  if (true) { ASSERT(x2914, x2923.c_str()); }
  int32_t x2924 = (*x2637).size();
  int32_t x2925 = x2924 - 1;
  string x2926;
  try {
    x2926 = (*x2637).at(x2925);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }
  string x2927 = (x2926 + string("/Fused_Conv2D_BiasAdd_k1_weights_512_concat.bin"));
  std::ifstream x2928 (x2927, std::ios::binary);
  assert(x2928.good() && "File x2927 does not exist"); 
  x2928.seekg(0, std::ios::end);
  std::ifstream::pos_type x2929_pos = x2928.tellg();
  std::vector<char> x2929_temp (x2929_pos); 
  x2928.seekg(0, std::ios::beg);
  x2928.read(&x2929_temp[0], x2929_pos);
  std::vector<float>* x2929_raw = new std::vector<float>(x2929_temp.size()/4);
  memcpy((void*)&((*x2929_raw)[0]), &(x2929_temp[0]), x2929_temp.size() * sizeof(char));
  vector<float>* x2929 = new vector<float>((*x2929_raw).size());
  x2929 = x2929_raw;
  x2928.close();
  vector<double>* x2933 = new vector<double>((*x2929).size());
  for (int b308 = 0; b308 < (*x2929).size(); b308++) { 
    float x2931 = (*x2929)[b308];
    double x2932 = (double) x2931;
    (*x2933)[b308] = x2932;
  }
  int32_t x2934 = (*x2933).size();
  bool x2935 = 3997696 == x2934;
  string x2936 = std::to_string(x2934);
  string x2937 = (string("Number of elements in vector (") + x2936);
  string x2938 = (x2937 + string(") must match number of elements in matrix ("));
  string x2939 = (x2938 + string("7808"));
  string x2940 = (x2939 + string("x"));
  string x2941 = (x2940 + string("512"));
  string x2942 = (x2941 + string(")"));
  string x2943 = (string("resnetofficialopt2.scala:112:170:") + x2942);
  string x2944 = ("\n=================\n" + (x2943 + "\n=================\n"));
  if (true) { ASSERT(x2935, x2944.c_str()); }
  int32_t x2945 = (*x2637).size();
  int32_t x2946 = x2945 - 1;
  string x2947;
  try {
    x2947 = (*x2637).at(x2946);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }
  string x2948 = (x2947 + string("/Fused_Conv2D_BiasAdd_k1_weights_1024_concat.bin"));
  std::ifstream x2949 (x2948, std::ios::binary);
  assert(x2949.good() && "File x2948 does not exist"); 
  x2949.seekg(0, std::ios::end);
  std::ifstream::pos_type x2950_pos = x2949.tellg();
  std::vector<char> x2950_temp (x2950_pos); 
  x2949.seekg(0, std::ios::beg);
  x2949.read(&x2950_temp[0], x2950_pos);
  std::vector<float>* x2950_raw = new std::vector<float>(x2950_temp.size()/4);
  memcpy((void*)&((*x2950_raw)[0]), &(x2950_temp[0]), x2950_temp.size() * sizeof(char));
  vector<float>* x2950 = new vector<float>((*x2950_raw).size());
  x2950 = x2950_raw;
  x2949.close();
  vector<double>* x2954 = new vector<double>((*x2950).size());
  for (int b330 = 0; b330 < (*x2950).size(); b330++) { 
    float x2952 = (*x2950)[b330];
    double x2953 = (double) x2952;
    (*x2954)[b330] = x2953;
  }
  int32_t x2955 = (*x2954).size();
  bool x2956 = 3932160 == x2955;
  string x2957 = std::to_string(x2955);
  string x2958 = (string("Number of elements in vector (") + x2957);
  string x2959 = (x2958 + string(") must match number of elements in matrix ("));
  string x2960 = (x2959 + string("3840"));
  string x2961 = (x2960 + string("x"));
  string x2962 = (x2961 + string("1024"));
  string x2963 = (x2962 + string(")"));
  string x2964 = (string("resnetofficialopt2.scala:113:172:") + x2963);
  string x2965 = ("\n=================\n" + (x2964 + "\n=================\n"));
  if (true) { ASSERT(x2956, x2965.c_str()); }
  int32_t x2966 = (*x2637).size();
  int32_t x2967 = x2966 - 1;
  string x2968;
  try {
    x2968 = (*x2637).at(x2967);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }
  string x2969 = (x2968 + string("/Fused_Conv2D_BiasAdd_k1_weights_2048_concat.bin"));
  std::ifstream x2970 (x2969, std::ios::binary);
  assert(x2970.good() && "File x2969 does not exist"); 
  x2970.seekg(0, std::ios::end);
  std::ifstream::pos_type x2971_pos = x2970.tellg();
  std::vector<char> x2971_temp (x2971_pos); 
  x2970.seekg(0, std::ios::beg);
  x2970.read(&x2971_temp[0], x2971_pos);
  std::vector<float>* x2971_raw = new std::vector<float>(x2971_temp.size()/4);
  memcpy((void*)&((*x2971_raw)[0]), &(x2971_temp[0]), x2971_temp.size() * sizeof(char));
  vector<float>* x2971 = new vector<float>((*x2971_raw).size());
  x2971 = x2971_raw;
  x2970.close();
  vector<double>* x2975 = new vector<double>((*x2971).size());
  for (int b352 = 0; b352 < (*x2971).size(); b352++) { 
    float x2973 = (*x2971)[b352];
    double x2974 = (double) x2973;
    (*x2975)[b352] = x2974;
  }
  int32_t x2976 = (*x2975).size();
  bool x2977 = 2097152 == x2976;
  string x2978 = std::to_string(x2976);
  string x2979 = (string("Number of elements in vector (") + x2978);
  string x2980 = (x2979 + string(") must match number of elements in matrix ("));
  string x2981 = (x2980 + string("1024"));
  string x2982 = (x2981 + string("x"));
  string x2983 = (x2982 + string("2048"));
  string x2984 = (x2983 + string(")"));
  string x2985 = (string("resnetofficialopt2.scala:114:172:") + x2984);
  string x2986 = ("\n=================\n" + (x2985 + "\n=================\n"));
  if (true) { ASSERT(x2977, x2986.c_str()); }
  uint64_t x2987 = c1->malloc(sizeof(double) * 22720*2048);
  c1->setArg(FUSED_CONV2D_BIASADD_K1_WEIGHTS_CONCAT_DRAM_ptr, x2987, false);
  printf("Allocate mem of size 22720*2048 at %p\n", (void*)x2987);
  vector<double>* x3033 = new vector<double>(46530560);
  for (int b368 = 0; b368 < 46530560; b368++) {
    int32_t x2988 = b368 >> 11;
    int32_t x2989 = (int32_t) ((b368 % 2048 + 2048) % 2048);
    bool x2990 = x2988 < 1088;
    double x3032;
    if (x2990) { 
      bool x2991 = x2989 < 64;
      double x2995;
      if (x2991) { 
        int32_t x2992 = x2988 << 6;
        int32_t x2993 = x2992 + x2989;
        double x2994 = (*x2870)[x2993];
        x2995 = x2994;
      }
      else {
        x2995 = 0;
      }
      x3032 = x2995;
    }
    else {
      bool x2996 = x2988 < 3136;
      double x3031;
      if (x2996) { 
        bool x2997 = x2989 < 128;
        double x3002;
        if (x2997) { 
          int32_t x2998 = x2988 - 1088;
          int32_t x2999 = x2998 << 7;
          int32_t x3000 = x2999 + x2989;
          double x3001 = (*x2912)[x3000];
          x3002 = x3001;
        }
        else {
          x3002 = 0;
        }
        x3031 = x3002;
      }
      else {
        bool x3003 = x2988 < 10048;
        double x3030;
        if (x3003) { 
          bool x3004 = x2989 < 256;
          double x3009;
          if (x3004) { 
            int32_t x3005 = x2988 - 3136;
            int32_t x3006 = x3005 << 8;
            int32_t x3007 = x3006 + x2989;
            double x3008 = (*x2891)[x3007];
            x3009 = x3008;
          }
          else {
            x3009 = 0;
          }
          x3030 = x3009;
        }
        else {
          bool x3010 = x2988 < 17856;
          double x3029;
          if (x3010) { 
            bool x3011 = x2989 < 512;
            double x3016;
            if (x3011) { 
              int32_t x3012 = x2988 - 10048;
              int32_t x3013 = x3012 << 9;
              int32_t x3014 = x3013 + x2989;
              double x3015 = (*x2933)[x3014];
              x3016 = x3015;
            }
            else {
              x3016 = 0;
            }
            x3029 = x3016;
          }
          else {
            bool x3017 = x2988 < 21696;
            double x3028;
            if (x3017) { 
              bool x3018 = x2989 < 1024;
              double x3023;
              if (x3018) { 
                int32_t x3019 = x2988 - 17856;
                int32_t x3020 = x3019 << 10;
                int32_t x3021 = x3020 + x2989;
                double x3022 = (*x2954)[x3021];
                x3023 = x3022;
              }
              else {
                x3023 = 0;
              }
              x3028 = x3023;
            }
            else {
              int32_t x3024 = x2988 - 21696;
              int32_t x3025 = x3024 << 11;
              int32_t x3026 = x3025 + x2989;
              double x3027 = (*x2975)[x3026];
              x3028 = x3027;
            }
            x3029 = x3028;
          }
          x3030 = x3029;
        }
        x3031 = x3030;
      }
      x3032 = x3031;
    }
    (*x3033)[b368] = x3032;
  }
  vector<int32_t>* x2987_rawified = new vector<int32_t>((*x3033).size());
  for (int x2987_rawified_i = 0; x2987_rawified_i < (*x3033).size(); x2987_rawified_i++) {
    (*x2987_rawified)[x2987_rawified_i] = (int32_t) ((*x3033)[x2987_rawified_i] * ((int32_t)1 << 22));
  }
  c1->memcpy(x2987, &(*x2987_rawified)[0], (*x2987_rawified).size() * sizeof(int32_t));
  int32_t x3035 = (*x2637).size();
  int32_t x3036 = x3035 - 1;
  string x3037;
  try {
    x3037 = (*x2637).at(x3036);
  }
  catch (std::out_of_range& e) {
    printHelp();
  }
  string x3038 = (x3037 + string("/c87.bin"));
  std::ifstream x3039 (x3038, std::ios::binary);
  assert(x3039.good() && "File x3038 does not exist"); 
  x3039.seekg(0, std::ios::end);
  std::ifstream::pos_type x3040_pos = x3039.tellg();
  std::vector<char> x3040_temp (x3040_pos); 
  x3039.seekg(0, std::ios::beg);
  x3039.read(&x3040_temp[0], x3040_pos);
  std::vector<float>* x3040_raw = new std::vector<float>(x3040_temp.size()/4);
  memcpy((void*)&((*x3040_raw)[0]), &(x3040_temp[0]), x3040_temp.size() * sizeof(char));
  vector<float>* x3040 = new vector<float>((*x3040_raw).size());
  x3040 = x3040_raw;
  x3039.close();
  vector<double>* x3044 = new vector<double>((*x3040).size());
  for (int b424 = 0; b424 < (*x3040).size(); b424++) { 
    float x3042 = (*x3040)[b424];
    double x3043 = (double) x3042;
    (*x3044)[b424] = x3043;
  }
  string x3045 = (x3037 + string("/c101.bin"));
  std::ifstream x3046 (x3045, std::ios::binary);
  assert(x3046.good() && "File x3045 does not exist"); 
  x3046.seekg(0, std::ios::end);
  std::ifstream::pos_type x3047_pos = x3046.tellg();
  std::vector<char> x3047_temp (x3047_pos); 
  x3046.seekg(0, std::ios::beg);
  x3046.read(&x3047_temp[0], x3047_pos);
  std::vector<float>* x3047_raw = new std::vector<float>(x3047_temp.size()/4);
  memcpy((void*)&((*x3047_raw)[0]), &(x3047_temp[0]), x3047_temp.size() * sizeof(char));
  vector<float>* x3047 = new vector<float>((*x3047_raw).size());
  x3047 = x3047_raw;
  x3046.close();
  vector<double>* x3051 = new vector<double>((*x3047).size());
  for (int b432 = 0; b432 < (*x3047).size(); b432++) { 
    float x3049 = (*x3047)[b432];
    double x3050 = (double) x3049;
    (*x3051)[b432] = x3050;
  }
  string x3052 = (x3037 + string("/c27.bin"));
  std::ifstream x3053 (x3052, std::ios::binary);
  assert(x3053.good() && "File x3052 does not exist"); 
  x3053.seekg(0, std::ios::end);
  std::ifstream::pos_type x3054_pos = x3053.tellg();
  std::vector<char> x3054_temp (x3054_pos); 
  x3053.seekg(0, std::ios::beg);
  x3053.read(&x3054_temp[0], x3054_pos);
  std::vector<float>* x3054_raw = new std::vector<float>(x3054_temp.size()/4);
  memcpy((void*)&((*x3054_raw)[0]), &(x3054_temp[0]), x3054_temp.size() * sizeof(char));
  vector<float>* x3054 = new vector<float>((*x3054_raw).size());
  x3054 = x3054_raw;
  x3053.close();
  vector<double>* x3058 = new vector<double>((*x3054).size());
  for (int b440 = 0; b440 < (*x3054).size(); b440++) { 
    float x3056 = (*x3054)[b440];
    double x3057 = (double) x3056;
    (*x3058)[b440] = x3057;
  }
  string x3059 = (x3037 + string("/c90.bin"));
  std::ifstream x3060 (x3059, std::ios::binary);
  assert(x3060.good() && "File x3059 does not exist"); 
  x3060.seekg(0, std::ios::end);
  std::ifstream::pos_type x3061_pos = x3060.tellg();
  std::vector<char> x3061_temp (x3061_pos); 
  x3060.seekg(0, std::ios::beg);
  x3060.read(&x3061_temp[0], x3061_pos);
  std::vector<float>* x3061_raw = new std::vector<float>(x3061_temp.size()/4);
  memcpy((void*)&((*x3061_raw)[0]), &(x3061_temp[0]), x3061_temp.size() * sizeof(char));
  vector<float>* x3061 = new vector<float>((*x3061_raw).size());
  x3061 = x3061_raw;
  x3060.close();
  vector<double>* x3065 = new vector<double>((*x3061).size());
  for (int b448 = 0; b448 < (*x3061).size(); b448++) { 
    float x3063 = (*x3061)[b448];
    double x3064 = (double) x3063;
    (*x3065)[b448] = x3064;
  }
  uint64_t x3066 = c1->malloc(sizeof(double) * 64*3*49);
  c1->setArg(C101_DRAM_ptr, x3066, false);
  printf("Allocate mem of size 64*3*49 at %p\n", (void*)x3066);
  int32_t x3067 = (*x3051).size();
  bool x3068 = 9408 == x3067;
  string x3069 = std::to_string(x3067);
  string x3070 = (string("Number of elements in vector (") + x3069);
  string x3071 = (x3070 + string(") must match number of elements in matrix ("));
  string x3072 = (x3071 + string("64"));
  string x3073 = (x3072 + string("x"));
  string x3074 = (x3073 + string("3"));
  string x3075 = (x3074 + string("x"));
  string x3076 = (x3075 + string("49"));
  string x3077 = (x3076 + string(")"));
  string x3078 = (string("resnetofficialopt2.scala:158:35:") + x3077);
  string x3079 = ("\n=================\n" + (x3078 + "\n=================\n"));
  if (true) { ASSERT(x3068, x3079.c_str()); }
  vector<int32_t>* x3066_rawified = new vector<int32_t>((*x3051).size());
  for (int x3066_rawified_i = 0; x3066_rawified_i < (*x3051).size(); x3066_rawified_i++) {
    (*x3066_rawified)[x3066_rawified_i] = (int32_t) ((*x3051)[x3066_rawified_i] * ((int32_t)1 << 22));
  }
  c1->memcpy(x3066, &(*x3066_rawified)[0], (*x3066_rawified).size() * sizeof(int32_t));
  uint64_t x3081 = c1->malloc(sizeof(double) * 64);
  c1->setArg(C27_DRAM_ptr, x3081, false);
  printf("Allocate mem of size 64 at %p\n", (void*)x3081);
  vector<int32_t>* x3081_rawified = new vector<int32_t>((*x3058).size());
  for (int x3081_rawified_i = 0; x3081_rawified_i < (*x3058).size(); x3081_rawified_i++) {
    (*x3081_rawified)[x3081_rawified_i] = (int32_t) ((*x3058)[x3081_rawified_i] * ((int32_t)1 << 22));
  }
  c1->memcpy(x3081, &(*x3081_rawified)[0], (*x3081_rawified).size() * sizeof(int32_t));
  uint64_t x3083 = c1->malloc(sizeof(double) * 1001*2048);
  c1->setArg(C90_DRAM_ptr, x3083, false);
  printf("Allocate mem of size 1001*2048 at %p\n", (void*)x3083);
  int32_t x3084 = (*x3065).size();
  bool x3085 = 2050048 == x3084;
  string x3086 = std::to_string(x3084);
  string x3087 = (string("Number of elements in vector (") + x3086);
  string x3088 = (x3087 + string(") must match number of elements in matrix ("));
  string x3089 = (x3088 + string("1001"));
  string x3090 = (x3089 + string("x"));
  string x3091 = (x3090 + string("2048"));
  string x3092 = (x3091 + string(")"));
  string x3093 = (string("resnetofficialopt2.scala:162:33:") + x3092);
  string x3094 = ("\n=================\n" + (x3093 + "\n=================\n"));
  if (true) { ASSERT(x3085, x3094.c_str()); }
  vector<int32_t>* x3083_rawified = new vector<int32_t>((*x3065).size());
  for (int x3083_rawified_i = 0; x3083_rawified_i < (*x3065).size(); x3083_rawified_i++) {
    (*x3083_rawified)[x3083_rawified_i] = (int32_t) ((*x3065)[x3083_rawified_i] * ((int32_t)1 << 22));
  }
  c1->memcpy(x3083, &(*x3083_rawified)[0], (*x3083_rawified).size() * sizeof(int32_t));
  uint64_t x3096 = c1->malloc(sizeof(double) * 1008);
  c1->setArg(C87_DRAM_ptr, x3096, false);
  printf("Allocate mem of size 1008 at %p\n", (void*)x3096);
  vector<int32_t>* x3096_rawified = new vector<int32_t>((*x3044).size());
  for (int x3096_rawified_i = 0; x3096_rawified_i < (*x3044).size(); x3096_rawified_i++) {
    (*x3096_rawified)[x3096_rawified_i] = (int32_t) ((*x3044)[x3096_rawified_i] * ((int32_t)1 << 22));
  }
  c1->memcpy(x3096, &(*x3096_rawified)[0], (*x3096_rawified).size() * sizeof(int32_t));


  // Register ArgIns and ArgIOs in case some are unused
  c1->setNumArgIns(0 + 11 + 0);
  c1->setNumArgIOs(0);
  c1->setNumArgOuts(0);
  c1->setNumArgOutInstrs(0);
  c1->setNumEarlyExits(0);
  c1->flushCache(1024);
  time_t tstart = time(0);

  vector<string>* x2600 = img_list;
  int num_img = (*x2600).size();

  for (int i = 0; i < num_img; i++) {
    string x2638;
    try {
      x2638 = (*x2600).at(i);
    }
    catch (std::out_of_range& e) {
    printHelp();
    }
    // ifstream: input stream class to operate on files
    std::ifstream x2639_file (x2638);
    assert(x2639_file.good() && "File x2638 does not exist"); 
    std::vector<string>* x2640 = new std::vector<string>; 
    if (x2639_file.is_open()) {
      while ( x2639_file.good() ) {
        string x2640_line;
        // get contents from .csv and store in x2640
        getline (x2639_file, x2640_line);
        
        // used to iterate through and remove "\n"
        string x2640_delim = string("\n");
        size_t x2640_pos = 0;

        // loop to remove the "\n" chars
        while (x2640_line.find(x2640_delim) != std::string::npos | x2640_line.length() > 0) {
          if (x2640_line.find(x2640_delim) != std::string::npos) {
            // TODO: seems redundant
            x2640_pos = x2640_line.find(x2640_delim);
          } else {
            x2640_pos = x2640_line.length();
          }
          string x2640_token = x2640_line.substr(0, x2640_pos);
          x2640_line.erase(0, x2640_pos + x2640_delim.length());
          // push to new vector x2640
          x2640->push_back(x2640_token);
        }
      }
    }

    // set new value for stream internal error
    x2639_file.clear();
    // return to beginning of file
    x2639_file.seekg(0, x2639_file.beg);
    //close
    x2639_file.close();

    // convert from string to double
    vector<double>* x2644 = new vector<double>((*x2640).size());
    for (int b5 = 0; b5 < (*x2640).size(); b5++) { 
      string x2642 = (*x2640)[b5];
      double x2643 = std::stod(x2642);
      (*x2644)[b5] = x2643;
    }
    // Check if number of elements is correct
    int32_t x2645 = (*x2644).size();
    bool x2646 = 150528 == x2645;
    string x2647 = std::to_string(x2645);
    string x2648 = (string("Number of elements in vector (") + x2647);
    string x2649 = (x2648 + string(") must match number of elements in matrix ("));
    string x2650 = (x2649 + string("3"));
    string x2651 = (x2650 + string("x"));
    string x2652 = (x2651 + string("224"));
    string x2653 = (x2652 + string("x"));
    string x2654 = (x2653 + string("224"));
    string x2655 = (x2654 + string(")"));
    string x2656 = (string("resnetofficialopt2.scala:43:49:") + x2655);
    string x2657 = ("\n=================\n" + (x2656 + "\n=================\n"));
    // ASSERT defined in FringeContext
    if (true) { ASSERT(x2646, x2657.c_str()); }
    vector<double>* x2678 = new vector<double>(158700);

    // Checking for matching numer of elements per row? Not sure
    for (int b22 = 0; b22 < 158700; b22++) {
      int32_t x2658 = b22 / 52900;
      int32_t x2659 = b22 / 230;
      int32_t x2660 = (int32_t) ((x2659 % 230 + 230) % 230);
      int32_t x2661 = (int32_t) ((b22 % 230 + 230) % 230);
      bool x2662 = 3 <= x2660;
      bool x2663 = x2660 < 227;
      bool x2664 = x2662 & x2663;
      bool x2665 = 3 <= x2661;
      bool x2666 = x2664 & x2665;
      bool x2667 = x2661 < 227;
      bool x2668 = x2666 & x2667;
      double x2677;
      if (x2668) { 
        int32_t x2669 = x2660 - 3;
        int32_t x2670 = x2661 - 3;
        int32_t x2671 = x2658 * 224;
        int32_t x2672 = x2671 * 224;
        int32_t x2673 = x2669 * 224;
        int32_t x2674 = x2672 + x2673;
        int32_t x2675 = x2674 + x2670;
        double x2676 = (*x2644)[x2675];
        x2677 = x2676;
      }
      else {
        x2677 = 0;
      }
      (*x2678)[b22] = x2677;
    }

    // allocate memory in device memory
    uint64_t x2679 = c1->malloc(sizeof(double) * 3*230*230);
    c1->setArg(I0_PAD_DRAM_ptr, x2679, false);
    printf("Allocate mem of size 3*230*230 at %p\n", (void*)x2679);

    uint64_t x2680 = c1->malloc(sizeof(double) * 1008);
    c1->setArg(TMP76_DRAM_ptr, x2680, false);
    printf("Allocate mem of size 1008 at %p\n", (void*)x2680);

    vector<int32_t>* x2679_rawified = new vector<int32_t>((*x2678).size());
    for (int x2679_rawified_i = 0; x2679_rawified_i < (*x2678).size(); x2679_rawified_i++) {
      (*x2679_rawified)[x2679_rawified_i] = (int32_t) ((*x2678)[x2679_rawified_i] * ((int32_t)1 << 22));
    }

    c1->memcpy(x2679, &(*x2679_rawified)[0], (*x2679_rawified).size() * sizeof(int32_t));
    uint64_t x2682 = c1->malloc(sizeof(double) * 3*802816);
    c1->setArg(TMP_DRAM_ptr, x2682, false);
    printf("Allocate mem of size 3*802816 at %p\n", (void*)x2682);

    c1->run();
    c1->flushCache(1024);
    vector<double>* x18645 = new vector<double>(1008);
    vector<int32_t>* x18645_rawified = new vector<int32_t>((*x18645).size());
    c1->memcpy(&(*x18645_rawified)[0], x2680, (*x18645_rawified).size() * sizeof(int32_t));
    for (int x18645_i = 0; x18645_i < (*x18645).size(); x18645_i++) {
      int32_t x18645_tmp = (*x18645_rawified)[x18645_i];
      (*x18645)[x18645_i] = (double) x18645_tmp / ((int32_t)1 << 22);
    }
    vector<double>* x18649 = new vector<double>(1000);
    for (int b1259 = 0; b1259 < 1000; b1259++) {
      int32_t x18647 = b1259 + 1;
      double x18648 = (*x18645)[x18647];
      (*x18649)[b1259] = x18648;
    }
    string x18650 = (string("output") + string("\n"));
    std::cout << x18650;
    int32_t x18652 = (*x18649).size();
    for (int b1266 = 0; b1266 < x18652; b1266 = b1266 + 1) {
      double x18653 = (*x18649)[b1266];
      string x18654 = std::to_string(x18653);
      string x18655 = (x18654 + string(" "));
      std::cout << x18655;
    }
    std::cout << string("\n");
    std::cout << string("\n\n");
    int32_t x18660 = (*x2637).size();
    int32_t x18661 = x18660 - 2;
    string x18662;
    try {
      x18662 = (*x2637).at(x18661);
    }
    catch (std::out_of_range& e) {
      printHelp();
    }
    std::ifstream x18663_file (x18662);
    assert(x18663_file.good() && "File x18662 does not exist"); 
    std::vector<string>* x18664 = new std::vector<string>; 
    if (x18663_file.is_open()) {
      while ( x18663_file.good() ) {
        string x18664_line;
        getline (x18663_file, x18664_line);
        string x18664_delim = string("\n");
        size_t x18664_pos = 0;
        while (x18664_line.find(x18664_delim) != std::string::npos | x18664_line.length() > 0) {
          if (x18664_line.find(x18664_delim) != std::string::npos) {
            x18664_pos = x18664_line.find(x18664_delim);
          } else {
            x18664_pos = x18664_line.length();
          }
          string x18664_token = x18664_line.substr(0, x18664_pos);
          x18664_line.erase(0, x18664_pos + x18664_delim.length());
          x18664->push_back(x18664_token);
        }
      }
    }
    x18663_file.clear();
    x18663_file.seekg(0, x18663_file.beg);
    x18663_file.close();
    vector<string>* x18667 = new vector<string>((*x18664).size());
    for (int b1280 = 0; b1280 < (*x18664).size(); b1280++) { 
      string x18666 = (*x18664)[b1280];
      (*x18667)[b1280] = x18666;
    }
    std::cout << string("Top 5 Predictions: \n");
    vector<Tup2FixTRUE_10_22FixTRUE_32_0>* x18671 = new vector<Tup2FixTRUE_10_22FixTRUE_32_0>(1000);
    for (int b1284 = 0; b1284 < 1000; b1284++) {
      double x18669 = (*x18649)[b1284];
      Tup2FixTRUE_10_22FixTRUE_32_0 x18670 = Tup2FixTRUE_10_22FixTRUE_32_0(x18669,b1284);
      (*x18671)[b1284] = x18670;
    }
    Tup2FixTRUE_10_22FixTRUE_32_0 x18677;
    if ((*x18671).size() > 0) { // Hack to handle reductions on things of length 0
      x18677 = (*x18671)[0];
    }
    else {
      x18677 = *(new Tup2FixTRUE_10_22FixTRUE_32_0(0,0));;
    }
    for (int b1288 = 1; b1288 < (*x18671).size(); b1288++) {
      Tup2FixTRUE_10_22FixTRUE_32_0 b1289 = (*x18671)[b1288];
      Tup2FixTRUE_10_22FixTRUE_32_0 b1290 = x18677;
      double x18673 = b1289._1;
      double x18674 = b1290._1;
      bool x18675 = x18674 < x18673;
      Tup2FixTRUE_10_22FixTRUE_32_0 x18676;
      if (x18675) { 
        x18676 = b1289;
      }
      else {
        x18676 = b1290;
      }
      x18677 = x18676;
    }
    int32_t x18678 = x18677._2;
    vector<Tup2FixTRUE_10_22FixTRUE_32_0>* x18684 = new vector<Tup2FixTRUE_10_22FixTRUE_32_0>(1000);
    for (int b1298 = 0; b1298 < 1000; b1298++) {
      bool x18679 = b1298 == x18678;
      Tup2FixTRUE_10_22FixTRUE_32_0 x18683;
      if (x18679) { 
        Tup2FixTRUE_10_22FixTRUE_32_0 x18680 = Tup2FixTRUE_10_22FixTRUE_32_0(-1,b1298);
        x18683 = x18680;
      }
      else {
        double x18681 = (*x18649)[b1298];
        Tup2FixTRUE_10_22FixTRUE_32_0 x18682 = Tup2FixTRUE_10_22FixTRUE_32_0(x18681,b1298);
        x18683 = x18682;
      }
      (*x18684)[b1298] = x18683;
    }
    Tup2FixTRUE_10_22FixTRUE_32_0 x18690;
    if ((*x18684).size() > 0) { // Hack to handle reductions on things of length 0
      x18690 = (*x18684)[0];
    }
    else {
      x18690 = *(new Tup2FixTRUE_10_22FixTRUE_32_0(0,0));;
    }
    for (int b1305 = 1; b1305 < (*x18684).size(); b1305++) {
      Tup2FixTRUE_10_22FixTRUE_32_0 b1306 = (*x18684)[b1305];
      Tup2FixTRUE_10_22FixTRUE_32_0 b1307 = x18690;
      double x18686 = b1306._1;
      double x18687 = b1307._1;
      bool x18688 = x18687 < x18686;
      Tup2FixTRUE_10_22FixTRUE_32_0 x18689;
      if (x18688) { 
        x18689 = b1306;
      }
      else {
        x18689 = b1307;
      }
      x18690 = x18689;
    }
    int32_t x18691 = x18690._2;
    vector<Tup2FixTRUE_10_22FixTRUE_32_0>* x18699 = new vector<Tup2FixTRUE_10_22FixTRUE_32_0>(1000);
    for (int b1315 = 0; b1315 < 1000; b1315++) {
      bool x18692 = b1315 == x18678;
      bool x18693 = b1315 == x18691;
      bool x18694 = x18692 | x18693;
      Tup2FixTRUE_10_22FixTRUE_32_0 x18698;
      if (x18694) { 
        Tup2FixTRUE_10_22FixTRUE_32_0 x18695 = Tup2FixTRUE_10_22FixTRUE_32_0(-1,b1315);
        x18698 = x18695;
      }
      else {
        double x18696 = (*x18649)[b1315];
        Tup2FixTRUE_10_22FixTRUE_32_0 x18697 = Tup2FixTRUE_10_22FixTRUE_32_0(x18696,b1315);
        x18698 = x18697;
      }
      (*x18699)[b1315] = x18698;
    }
    Tup2FixTRUE_10_22FixTRUE_32_0 x18705;
    if ((*x18699).size() > 0) { // Hack to handle reductions on things of length 0
      x18705 = (*x18699)[0];
    }
    else {
      x18705 = *(new Tup2FixTRUE_10_22FixTRUE_32_0(0,0));;
    }
    for (int b1324 = 1; b1324 < (*x18699).size(); b1324++) {
      Tup2FixTRUE_10_22FixTRUE_32_0 b1325 = (*x18699)[b1324];
      Tup2FixTRUE_10_22FixTRUE_32_0 b1326 = x18705;
      double x18701 = b1325._1;
      double x18702 = b1326._1;
      bool x18703 = x18702 < x18701;
      Tup2FixTRUE_10_22FixTRUE_32_0 x18704;
      if (x18703) { 
        x18704 = b1325;
      }
      else {
        x18704 = b1326;
      }
      x18705 = x18704;
    }
    int32_t x18706 = x18705._2;
    vector<Tup2FixTRUE_10_22FixTRUE_32_0>* x18716 = new vector<Tup2FixTRUE_10_22FixTRUE_32_0>(1000);
    for (int b1334 = 0; b1334 < 1000; b1334++) {
    bool x18707 = b1334 == x18678;
    bool x18708 = b1334 == x18691;
    bool x18709 = x18707 | x18708;
    bool x18710 = b1334 == x18706;
    bool x18711 = x18709 | x18710;
    Tup2FixTRUE_10_22FixTRUE_32_0 x18715;
    if (x18711) { 
    Tup2FixTRUE_10_22FixTRUE_32_0 x18712 = Tup2FixTRUE_10_22FixTRUE_32_0(-1,b1334);
    x18715 = x18712;
    }
    else {
    double x18713 = (*x18649)[b1334];
    Tup2FixTRUE_10_22FixTRUE_32_0 x18714 = Tup2FixTRUE_10_22FixTRUE_32_0(x18713,b1334);
    x18715 = x18714;
    }
    (*x18716)[b1334] = x18715;
    }
    Tup2FixTRUE_10_22FixTRUE_32_0 x18722;
    if ((*x18716).size() > 0) { // Hack to handle reductions on things of length 0
    x18722 = (*x18716)[0];
    }
    else {
    x18722 = *(new Tup2FixTRUE_10_22FixTRUE_32_0(0,0));;
    }
    for (int b1345 = 1; b1345 < (*x18716).size(); b1345++) {
    Tup2FixTRUE_10_22FixTRUE_32_0 b1346 = (*x18716)[b1345];
    Tup2FixTRUE_10_22FixTRUE_32_0 b1347 = x18722;
    double x18718 = b1346._1;
    double x18719 = b1347._1;
    bool x18720 = x18719 < x18718;
    Tup2FixTRUE_10_22FixTRUE_32_0 x18721;
    if (x18720) { 
    x18721 = b1346;
    }
    else {
    x18721 = b1347;
    }
    x18722 = x18721;
    }
    int32_t x18723 = x18722._2;
    vector<Tup2FixTRUE_10_22FixTRUE_32_0>* x18735 = new vector<Tup2FixTRUE_10_22FixTRUE_32_0>(1000);
    for (int b1355 = 0; b1355 < 1000; b1355++) {
    bool x18724 = b1355 == x18678;
    bool x18725 = b1355 == x18691;
    bool x18726 = x18724 | x18725;
    bool x18727 = b1355 == x18706;
    bool x18728 = x18726 | x18727;
    bool x18729 = b1355 == x18723;
    bool x18730 = x18728 | x18729;
    Tup2FixTRUE_10_22FixTRUE_32_0 x18734;
    if (x18730) { 
    Tup2FixTRUE_10_22FixTRUE_32_0 x18731 = Tup2FixTRUE_10_22FixTRUE_32_0(-1,b1355);
    x18734 = x18731;
    }
    else {
    double x18732 = (*x18649)[b1355];
    Tup2FixTRUE_10_22FixTRUE_32_0 x18733 = Tup2FixTRUE_10_22FixTRUE_32_0(x18732,b1355);
    x18734 = x18733;
    }
    (*x18735)[b1355] = x18734;
    }
    Tup2FixTRUE_10_22FixTRUE_32_0 x18741;
    if ((*x18735).size() > 0) { // Hack to handle reductions on things of length 0
    x18741 = (*x18735)[0];
    }
    else {
    x18741 = *(new Tup2FixTRUE_10_22FixTRUE_32_0(0,0));;
    }
    for (int b1368 = 1; b1368 < (*x18735).size(); b1368++) {
    Tup2FixTRUE_10_22FixTRUE_32_0 b1369 = (*x18735)[b1368];
    Tup2FixTRUE_10_22FixTRUE_32_0 b1370 = x18741;
    double x18737 = b1369._1;
    double x18738 = b1370._1;
    bool x18739 = x18738 < x18737;
    Tup2FixTRUE_10_22FixTRUE_32_0 x18740;
    if (x18739) { 
    x18740 = b1369;
    }
    else {
    x18740 = b1370;
    }
    x18741 = x18740;
    }
    int32_t x18742 = x18741._2;
    string x18743 = (*x18667)[x18678];
    string x18744 = (string("  1. ") + x18743);
    string x18745 = (x18744 + string("\n"));
    std::cout << x18745;
    string x18747 = (*x18667)[x18691];
    string x18748 = (string("  2. ") + x18747);
    string x18749 = (x18748 + string("\n"));
    std::cout << x18749;
    string x18751 = (*x18667)[x18706];
    string x18752 = (string("  3. ") + x18751);
    string x18753 = (x18752 + string("\n"));
    std::cout << x18753;
    string x18755 = (*x18667)[x18723];
    string x18756 = (string("  4. ") + x18755);
    string x18757 = (x18756 + string("\n"));
    std::cout << x18757;
    string x18759 = (*x18667)[x18742];
    string x18760 = (string("  5. ") + x18759);
    string x18761 = (x18760 + string("\n"));
    std::cout << x18761;
    std::cout << string("\n");
  

  }
  
  time_t tend = time(0);
  double elapsed = difftime(tend, tstart);
  std::cout << "Kernel done, test run time = " << elapsed << " ms" << std::endl;
  delete c1;
  
}

void printHelp() {
  fprintf(stderr, "Help for app: resnetofficialopt2\n");
  fprintf(stderr, "  -- Args:    <0: i0>\n");
  fprintf(stderr, "    -- Example: bash run.sh /path/to/input.csv  /path/to/classes.csv  /path/to/weights/directory/\n");
  exit(1);
}

int main(int argc, char *argv[]) {

  // argv[0] will point to images directory
  std::string path = argv[1];
  vector<string> *img_list = new vector<string>();
  for (const auto & entry : fs::directory_iterator(path)) {
    string img_path = entry.path();
    img_list->push_back(img_path);
  }
  
  // add all .csv files to vector
  vector<string> *args = new vector<string>(argc-1);
  for (int i=1; i<argc; i++) {
    (*args)[i-1] = std::string(argv[i]);
    if (std::string(argv[i]) == "--help" | std::string(argv[i]) == "-h") {printHelp();}
  }

  int numThreads = 1;
  char *env_threads = getenv("DELITE_NUM_THREADS");
  // atoi() converts string to int
  if (env_threads != NULL) { numThreads = atoi(env_threads); } else {
    fprintf(stderr, "[WARNING]: DELITE_NUM_THREADS undefined, defaulting to 1\n");
  }
  fprintf(stderr, "Executing with %d thread(s)\n", numThreads);
  Application(numThreads, args, img_list);
  return 0;
}
