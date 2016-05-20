<?php

function maxLeft($A) {
	$N2 = count($A)+2;

	$leftSliceSum    = [0, 0];
	$maxLeftSliceSum = [0, 0];
	$maxLeft         = 0;

	for ($i=2; $i < $N2; $i++) {
		$a = $A[$i-2];

		$leftSliceSum[$i]    = max($leftSliceSum[$i-1] + $a, 0);
		$maxLeftSliceSum[$i] = max($maxLeftSliceSum[$i-1] + $a, $maxLeft);
		$maxLeft             = max($maxLeft, $a);
	}

	return [$leftSliceSum, $maxLeftSliceSum];
}

function solution($A) {
	$left  = maxLeft($A);
	$right = maxLeft(array_reverse($A));

	$N2 = count($A)+2;

	for ($i=0; $i < $N2; $i++) {
		$maxSum[$i] = max($left[0][$i] + $right[1][$N2-1-$i], $left[1][$i] + $right[0][$N2-1-$i]);
	}

	$maxSum = max($maxSum);

	if (!$maxSum && !in_array(0, $A)) {
		$maxSum = max($A);
	}

	// return $maxSum;
	print_r('<pre>');print_r($maxSum);print_r('</pre>');exit;
}

$A = [-2,1,-3,4,-1,2,3,-5,4]; // 13
// $A = [3,2,-6,3,1]; // 9
// $A = [3,9,-6,7,-3,9,-6,-10]; // 28
// $A = [20,-10,10,-2,-100]; // 30
// $A = [-1,1,-1,1,-1,1,1]; // 4
// $A = [-1,-1,-1,-1]; // -1
// $A = [-1,-1,0,-1]; // 0
// $A = [1,1]; // 2

// $A = array_reverse($A);

// $A = [];
// for ($i=0; $i < 100001; $i++) {
// 	$A[] = mt_rand(-10000, 10000);
// }

solution($A);

/**
 *
 */
