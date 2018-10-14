import org.scalatest.FunSpec

/**
  * @author cabos
  */
class FizzBuzzTest extends FunSpec {

  private case class TestCase(in: Int, out: String)

  private def fb: FizzBuzz.type = FizzBuzz
  private def testCaseList: List[TestCase] = List.apply(
    TestCase(2, "2"),
    TestCase(3, "fizz"),
    TestCase(4, "4"),
    TestCase(5, "buzz"),
    TestCase(6, "fizz"),
    TestCase(10, "buzz"),
    TestCase(15, "fizzbuzz"),
  )

  describe("test of fizz buzz") {
    it("test case を全て満たすこと") {
      testCaseList.foreach(testCase => assert(fb.fizzBuzz(testCase.in) == testCase.out))
    }
  }
}
