import scala.collection.JavaConversions._

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object Solution {
	def solution(A: Array[Int]): Int = {
		val Nplus2 = A.length + 2

		var left  = leftSliceSum(A)
		var right = leftSliceSum(A.reverse)
		right = (right._1.reverse, right._2.reverse)

		var maxSum = 0
		var i = 0
		while( i < Nplus2 ){
			maxSum = math.max(maxSum, math.max(left._1(i)+right._2(i), left._2(i)+right._1(i)))
			i += 1
    	}
    	// 
    	// This is another way to compute maxSum value. It has no explicit loop, but is less efficient.
    	// 
    	// var l = (left._1, right._2).zipped.map(_ + _)
    	// var r = (left._2, right._1).zipped.map(_ + _)
    	// var maxSum = (l, r).zipped.map(_ max _).reduceLeft(_ max _)
        
    	if( maxSum == 0 && !(A contains 0) ){
			maxSum = A.reduceLeft(_ max _)
		}

		return maxSum
	}

	def leftSliceSum(A: Array[Int]): (Array[Int], Array[Int]) = {
		val N = A.length

		var leftSlice       = Array(0, 0)
		var maxLeft         = 0
		var maxLeftSliceSum = Array(0, 0)
		var a               = 0

		for( i <- 1 to N ){
			a = A(i-1)
			leftSlice       ++= Array(math.max(leftSlice(i) + a, 0))
			maxLeftSliceSum ++= Array(math.max(maxLeftSliceSum(i) + a, maxLeft))
			maxLeft = math.max(maxLeft, a)
		}
		
		return (leftSlice, maxLeftSliceSum)
	}
}
