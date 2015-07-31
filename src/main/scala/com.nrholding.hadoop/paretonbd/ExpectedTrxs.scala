package com.nrholding.hadoop.paretonbd

/**
 * Pareto/NBD Expectation denotes the predicted number of transactions in the 
 * period (T, T+t) for an individual with observed behavior (x,tx,T)
 */
object ExpectedTrxs extends Serializable {
 
  def apply(r:Double,alpha:Double,s:Double,beta:Double,x:Double,tx:Double,T:Double, t:Double):Double = {

    val tmp1 = (r+x) * (beta+T) / ((alpha+T) * (s-1))
	  val tmp2 = Math.pow((beta+T) / (beta+T+t),s-1)
	
    val ce = tmp1 * (1-tmp2) * ProbIsAlive(r,alpha,s,beta,x,tx,T)
	ce
	
  }

}