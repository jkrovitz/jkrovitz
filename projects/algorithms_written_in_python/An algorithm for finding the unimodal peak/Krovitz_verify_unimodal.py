""" ===============================================================================================================
                                                Program Summary
===================================================================================================================
Title: Find The Peak
Class: Computer Science 221-01
Professor: Shilad Sen

Program Summary: This program finds the peak entry in a unimodal array with n numbers in it. I am assuming that
numbers are referring to whole numbers (zero and all positive integers). Edge cases in this program include
checking to see whether the list is empty, if the list only has one element, if the numbers only increase and never
decrease, if the numbers only decrease and never increase and whether the array is unimodal.
===================================================================================================================
                                             The Program Itself
================================================================================================================"""


def find_peak_recurse(num_array, lo, hi, offset):
    n = len(num_array)
    half_len = (lo + hi) // 2
    if n == 0:
        return None  # Returns None if the array is empty.
    if n == 1:
        return offset  # Returns 0 if only one element in array.
    if num_array[0] > num_array[1] and num_array[n-1] > num_array[n-2] or \
                    num_array[half_len] == num_array[half_len-1]:  # Returns None if the array is not unimodal.
        return None
    if num_array[0] > num_array[1]:
        return offset  # Returns offset if array values only decrease.
    if num_array[n-1] > num_array[n-2]:
        return offset + (n-1)  # Returns last index position if array values only increase.
    if n > 2:
        if (num_array[half_len] < num_array[half_len-1] and
                    num_array[half_len] < num_array[half_len+1]) or \
                (num_array[half_len] == num_array[half_len+1]):  # Returns None if the array is not unimodal.
            return None
        else:
            if num_array[half_len-1] <= num_array[half_len] >= num_array[half_len+1]:
                offset = half_len
                return offset
            elif num_array[half_len-1] > num_array[half_len]:
                offset+=offset
                return find_peak_recurse(num_array, lo, half_len, offset)
            elif num_array[half_len] < num_array[half_len+1]:
                offset += half_len
                return find_peak_recurse(num_array, half_len+1, hi, offset)


def find_peak(num_array):
    """This is a wrapper function for find_peak_array_recurse. This makes it so one does not need to input
    values for lo, hi, and offset for each call and will only need to input the array."""
    return find_peak_recurse(num_array, lo=0, hi=len(num_array), offset=0)

""" ===============================================================================================================
                                                       Test
================================================================================================================"""
def test_find_peak():
    assert find_peak([None]) == 0
    assert find_peak([1]) == 0
    assert find_peak([3, 2]) == 0
    assert find_peak([32, 16, 8, 4, 2, 1, 0]) == 0
    assert find_peak([2, 4]) == 1
    assert find_peak([10, 20, 30, 40, 50, 60, 70, 90, 100]) == 8
    assert find_peak([2, 3, 4, 5, 6, 5, 3, 2, 1]) == 4
    assert find_peak([1, 2, 3, 4, 5, 6, 7, 8, 1]) == 7
    assert find_peak([1, 10, 8, 7, 6, 5, 4, 3]) == 1
    assert find_peak([2,3,4,3,2,3,4,3,2]) == None
    assert find_peak([2, 3, 4, 3, 2, 3, 4, 5, 2]) == None
    assert find_peak([2, 3, 5, 3, 2, 3, 4, 3, 2]) == None
    assert find_peak([8,7,6,5,4,3,2,3,4,5]) == None
    assert find_peak([8, 7, 6, 5, 4, 5, 6, 7, 8, 3, 2, 3, 4, 5]) == None
    assert find_peak([11,12,13,14,15,16,17,18,19,20]) == 9
    assert find_peak([0, 0, 0, 0, 0, 0, 0, 0]) == None
    assert find_peak([5,5,5,5,5,5,5]) == None
    assert find_peak([47, 48, 49, 56, 78, 82, 83, 88, 90, 94, 97, 99, 50, 41]) == 11
    assert find_peak([1,2,6,6,5]) == None
    assert find_peak([11, 15, 15, 13, 14]) == None
    assert find_peak([1,2,3,4,5]) == 4
    assert find_peak([355, 345, 335, 325, 315, 305]) == 0
    assert find_peak([1, 2, 6, 5, 7, 4]) == None
""" ===============================================================================================================
                                                Time Complexity
===================================================================================================================
The recurrence relation to find_peak_recurse is T(n) = T(n/2) + c ⟶ T(n) = T(n/4) + c + c
⟶  T(n) = T(n/8) + c + c + c ⟶ T(n) = T(n/2^k) + c k ⟶ T(n) = T(n/2^(log n)) + c  (log n)
⟶ T(n) = T(1) + c  (log n) ⟶ T(n) = ϴ(log n) according to the Master Theorem. Therefore,
the solution to this recurrence relation and time complexity in the worst case is ϴ(log n).
================================================================================================================"""
