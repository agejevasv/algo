package algo

import Ordering.Implicits._

/**
 * Recursive Merge sort implementation.
 *
 * <ol>
 *   <li>Divide the unsorted list into n sublists, each containing 1 element
 *    (a list of 1 element is considered sorted).</li>
 *   <li>Repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist
 *    remaining. This will be the sorted list.</li>
 * </ol>
 *
 * @author Viktoras Agejevas
 */
class MergeSort {

  def sort[T: Ordering](list: List[T]): List[T] =
    if (list.size <= 1) list
    else {
      val (left, right) = list.splitAt(list.size / 2)
      merge(sort(left), sort(right), Nil)
    }

  private
  def merge[T: Ordering](left: List[T], right: List[T], result: List[T]): List[T] =
    if (!left.isEmpty && !right.isEmpty)
      if (left.head < right.head)
        merge(left.tail, right, left.head :: result)
      else
        merge(left, right.tail, right.head :: result)
    else if (!left.isEmpty)
      merge(left.tail, right, left.head :: result)
    else if (!right.isEmpty)
      merge(left, right.tail, right.head :: result)
    else
      result.reverse.toList
}

object MergeSort {
  def apply() = new MergeSort()
}
