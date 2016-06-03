import scala.collection.JavaConversions._

object MaxSliceSwap {
	def solution(A: Array[Int]): Int = {
		def leftSliceSum(A: Array[Int]): (Array[Int], Array[Int]) = {
			val N = A.length
	
			var leftSlice       = Array(0, 0)
			var maxLeft         = 0
			var maxLeftSliceSum = Array(0, 0)
			var a               = 0
			
			var i = 1
			while( i < N+1 ){
				a = A(i-1)
				leftSlice       ++= Array(math.max(leftSlice(i) + a, 0))
				maxLeftSliceSum ++= Array(math.max(maxLeftSliceSum(i) + a, maxLeft))
				maxLeft = math.max(maxLeft, a)
				i += 1
			}
			
			return (leftSlice, maxLeftSliceSum)
		}

		val Nplus2 = A.length + 2

		var left  = leftSliceSum(A)
		var right = leftSliceSum(A.reverse)

		var maxSum = 0
		var i = 0
		while( i < Nplus2 ){
			maxSum = math.max(
				maxSum
			,	math.max(left._1(i)+right._2(Nplus2-1-i), left._2(i)+right._1(Nplus2-1-i))
			)
			i += 1
    		}
	    	// 
	    	// This is another way to compute maxSum value (instead of a while loop),
	    	// but it seems to be less efficient.
	    	// 
	    	// var l = (left._1, right._2).zipped.map(_ + _)
	    	// var r = (left._2, right._1).zipped.map(_ + _)
	    	// var maxSum = (l, r).zipped.map(_ max _).reduceLeft(_ max _)
        
	    	if( maxSum == 0 && !(A contains 0) ){
			maxSum = A.reduceLeft(_ max _)
		}

		return maxSum
	}
}
