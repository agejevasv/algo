package algo

import Ordering.Implicits._

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

  def sort[T: Ordering](list: List[T]): List[T] = ???

}

object QuickSort {
  def apply() = new QuickSort()
}
