object Solution {
	def solution(A: Array[Int]): Int = {
		//
		// Construct left and right sums, combine results
		//
		var left  = leftSliceSum(A, 1, Array(0,0), 0, Array(0,0))
		var right = leftSliceSum(A.reverse, 1, Array(0,0), 0, Array(0,0))
		right = (right._1.reverse, right._2.reverse)

		var maxSum = maxCombSum(left, right, 0, 0)

		if(maxSum == 0 && !(A contains 0)){
			maxSum = A.reduceLeft(_ max _)
		}
		
		return maxSum
	}

	//
	// Construct a tuple of maximus left slice sums and combinations of left slice sums plus maximum
	// element to the left of the slice:
	// for each A(i) left slices are either empty or end at position A(i-1)
	//
    @tailrec def leftSliceSum(A: Array[Int], i: Int, lss: Array[Int], maxLeft: Int, comb: Array[Int]): (Array[Int], Array[Int]) = {
		if( i <= A.length ) {
			var a   = A(i-1)
			var sum = math.max(lss(i) + a, 0)
			var mx  = math.max(maxLeft, a)
			var c   = math.max(comb(i) + a, mx)
			leftSliceSum(A, i+1, lss ++ Array(sum), mx, comb ++ Array(c))
		} else {
			(lss, comb)
		}
	}

	//
	// Construct a tuple of maximus left slice sums:
	// for A(i) left slices are either empty or end at position A(i-1)
	// Here we assume that all argument arrays in both tuples are of the same length
	// 
	@tailrec def maxCombSum(left: (Array[Int], Array[Int]), right: (Array[Int], Array[Int]), i: Int, maxSum: Int): Int = {
		if(i < left._1.length) {
			var mx = math.max(maxSum, math.max(left._1(i)+right._2(i), left._2(i)+right._1(i)))
			maxCombSum(left, right, i+1, mx)
		} else {
			maxSum
		}
	}
}
