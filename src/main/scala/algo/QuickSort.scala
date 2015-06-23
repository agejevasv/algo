package algo

import Ordering.Implicits._
import scala.reflect.ClassTag

/**
 * Quick sort implementation.
 *
 * <ol>
 *   <li>Pick an element, called a pivot, from the array.</li>
 *   <li>
 *     Reorder the array so that all elements with values less than the pivot come before
 *     the pivot, while all elements with values greater than the pivot come after it (equal
 *     values can go either way). After this partitioning, the pivot is in its final position.
 *     This is called the partition operation.
 *   </li>
 *   <li>
 *     Recursively apply the above steps to the sub-array of elements with smaller values
 *     and separately to the sub-array of elements with greater values.
 *   </li>
 * </ol>
 *
 * @author Viktoras Agejevas
 */
class QuickSort {

  def sort[T](list: List[T])(implicit evidence: ClassTag[T], ordering: Ordering[T]): List[T] =
    sort(list.toArray, 0, list.size - 1).toList

  private def sort[T: Ordering](array: Array[T], lo: Int, hi: Int): Array[T] =
    if (lo < hi) {
      val p = partition(array, lo, hi)
      sort(array, lo, p - 1)
      sort(array, p + 1, hi)
    } else {
      array
    }

  private def partition[T: Ordering](array: Array[T], lo: Int, hi: Int): Int = {
    val pivotIndex = lo + (hi - lo) / 2
    val pivotValue = array(pivotIndex)
    var storeIndex = lo

    swap(array, pivotIndex, hi)

    for(i <- lo until hi)
      if (array(i) < pivotValue) {
        swap(array, i, storeIndex)
        storeIndex += 1
      }

    swap(array, storeIndex, hi)
    storeIndex
  }

  private def swap[T](array: Array[T], fromIndex: Int, toIndex: Int) = {
    val temp = array(fromIndex)
    array(fromIndex) = array(toIndex)
    array(toIndex) = temp
  }

}

object QuickSort {
  def apply() = new QuickSort()
}
