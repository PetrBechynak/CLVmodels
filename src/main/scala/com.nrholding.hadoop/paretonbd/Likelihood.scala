package com.nrholding.hadoop.paretonbd

import org.apache.commons.math3.special.Gamma

object Likelihood extends Serializable {
  
  def apply(r:Double,alpha:Double,s:Double,beta:Double,x:Double,tx:Double,T:Double):Double = {
  		
	if (s <= 0 | beta <= 0 | r <= 0 | alpha <= 0) return Double.NaN
		
	val maxab = Math.max(alpha, beta)
	val absab = Math.abs(alpha-beta)
		
	val param2 = if (alpha < beta) r+x else s+1

	val part1 = (Math.pow(alpha,r)*Math.pow(beta,s) / Gamma.gamma(r))*Gamma.gamma(r+x)
    val part2 = 1.0 / (Math.pow(alpha+T,r+x)*Math.pow(beta+T,s))

	val (f1,f2) = if (absab == 0) {
	  
	  val F1 = 1.0 / Math.pow( maxab + tx, r + s + x )
 	  val F2 = 1.0 / Math.pow( maxab + T , r + s + x )
	
 	  (F1,F2)
 	  
	} else {
	
	  val F1 = Gauss(r+s+x, param2, r+s+x+1, absab /(maxab + tx) ) / Math.pow(maxab + tx, r + s + x)		
	  val F2 = Gauss(r+s+x, param2, r+s+x+1, absab /(maxab + T) ) / Math.pow(maxab + T, r + s + x)
      
	  (F1,F2)
	  
	}

	val f = part1*(part2 + (f1 - f2)*s/(r + s + x))
	f
	
  }

}