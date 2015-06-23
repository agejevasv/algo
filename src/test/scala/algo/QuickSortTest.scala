package algo

import org.scalatest.FunSuite

import scala.util.Random

class QuickSortTest extends FunSuite {

  test("sort should sort given List") {
    val list = Seq.fill(10000)(Random.nextInt).toList

    assertResult(list.sorted, "List is not sorted") {
      QuickSort().sort(list)
    }
  }
}
