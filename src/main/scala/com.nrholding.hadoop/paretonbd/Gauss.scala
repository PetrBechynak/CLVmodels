package com.nrholding.hadoop.paretonbd

/**
 * A simple (and relatively robust) numerical method for the evaluation 
 * of the Gaussian hypergeometric function: continue adding terms to the 
 * series until "uj" is less than "machine epsilon" (the smallest number 
 * that a specific computer recognizes as being bigger than zero).
 */
object Gauss extends Serializable {
  
  def apply(a:Double,b:Double,c:Double,z:Double):Double = {
		
    if (Math.abs(z) >= 1) return Double.NaN
    if (a <= 0 | b <= 0 | c <= 0 | z <= 0) return Double.NaN
	
    val EPS:Double = 1E-13
    
	var	j:Double  = 0
    var uj:Double = 1
    
	var y:Double = uj
    var diff:Double = 1
		
    while (diff > EPS) {
			
      var last_y:Double = y
	  j += 1
			
	  uj = uj*(a+j-1)*(b+j-1)*z / ((c+j-1) * j)
	  y += uj
		
      diff = Math.abs(last_y - y)
	
    }
	
    y
    
  }

}