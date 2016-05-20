import org.scalatest._

class MaxSliceSwapSpec extends FlatSpec with Matchers {
	var A = Array(1, 2, -1, 3, 4)
	"MaxSliceSwap" should "return 10" in {
		MaxSliceSwap.solution(A) should be === 10
	}
	var B = Array(-1, -1, -1)
	"MaxSliceSwap" should "return -1" in {
		MaxSliceSwap.solution(B) should be === -1
	}
	var C = Array(-1, -1, 0)
	"MaxSliceSwap" should "return 0" in {
		MaxSliceSwap.solution(B) should be === 0
	}
}
