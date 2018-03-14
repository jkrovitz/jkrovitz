""" ===============================================================================================================
                                                Program Summary
===================================================================================================================
Title: Find The Peak In A Unimodal Array
Programmer: Jeremy Krovitz
Class: Computer Science 221-01
Professor: Shilad Sen

Program Summary: This program consists of two functions find_peak_recurse and find_peak. The function
find_peak recurse really does most of the work. The function find_peak_recurse, finds the peak or the
maximum value, in a unimodal array with n numbers in it and returns the index position of the peak.
I assume that numbers are whole numbers (zero and all positive integers). Edge cases in this program
include checking to see whether the list is empty, if the list only has one element, if the numbers
are only decreasing over the span of the array and not increasing, and if the numbers are only
increasing over the span of the array and not decreasing. The fuction find_peak is a wrapper function
for find_peak_array_recurse. The wrapper function makes it so one does not need to input values for lo,
hi, and offset for each call and will only need to input the array itself.
===================================================================================================================
                                             The Program Itself
================================================================================================================"""


def find_peak_recurse(num_array, lo, hi, offset):
    n = len(num_array)
    half_len = (lo + hi) // 2
    if n == 0:
        return None  # Returns None if the array is empty.
    if n == 1:
        return offset  # Returns offset if only one element in array.
    if num_array[0] > num_array[1]:
        return offset  # Returns offset if array values only decrease.
    if num_array[n-1] > num_array[n-2]:
        return offset + (n-1)  # Returns last index position if array values only increase.
    if n > 2:
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
    return find_peak_recurse(num_array, lo=0, hi=len(num_array), offset=0)

""" ===============================================================================================================
                                                       Test
================================================================================================================"""


def test_find_peak():
    assert find_peak([]) == None  # If num_array is empty
    assert find_peak([27]) == 0 # If there is only one element in the array.
    assert find_peak([32, 16, 8, 4, 2, 1, 0]) == 0 # If the array values only decrease.
    assert find_peak([11, 12, 13, 14, 15, 16, 17, 18, 19, 20]) == 9  # If the array values only increase.
    assert find_peak([72, 78, 85, 93, 85, 78, 72]) == 3  # If the peak occurs at the midpoint of the original array.
    assert find_peak([47, 48, 49, 56, 78, 82, 83, 88, 90, 94, 97, 99, 50, 41]) == 11  # If peak in right sub-array.
    assert find_peak([1, 10, 8, 7, 6, 5, 4, 3]) == 1  # If the peak occurs in the left sub-array.

    """Some additional tests that I did to double check that all of my code works as it should:"""
    assert find_peak([2, 4]) == 1
    assert find_peak([3, 2]) == 0
    assert find_peak([10, 20, 30, 40, 50, 60, 70, 90, 100]) == 8
    assert find_peak([2, 3, 4, 5, 6, 5, 3, 2, 1]) == 4
    assert find_peak([1, 2, 3, 4, 5, 6, 7, 8, 1]) == 7
    assert find_peak([1,2,3,4,5]) == 4
    assert find_peak([355, 345, 335, 325, 315, 305]) == 0
    assert find_peak([30]) == 0
    assert find_peak([2, 20, 60, 80, 90, 99, 68]) == 5



