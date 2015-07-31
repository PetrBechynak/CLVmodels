package com.nrholding.hadoop.paretonbd

/**
 * Created by petr on 30.7.15.
 */
object Runnable {
  def main(args: Array[String]) = {
    println("Gauss(0.5,0.5,1,1)=", Gauss(1,1,0.5, 0.5))
    println("ProbIsAlive=",ProbIsAlive(1,1, 0.5, 0.5, 20, 25, 30))
    println("ExpectedTrxs",ExpectedTrxs(1,1,0.5, 0.5, 20, 25, 30, 35))
    //println("hovno")
  }
}
