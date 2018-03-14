""" ===============================================================================================================
                                                Program Summary
===================================================================================================================
Title: Find The Maximum Contiguous Sum
Programmer: Jeremy Krovitz
Class: Computer Science 221-01
Professor: Shilad Sen

Program Summary: This program finds the maximum sum of contiguous integers in the passed-in array. The maximum sum
may occur in the first half of the array, the second half of the array, or it may span both halves of the array.
The program assumes that if all of the numbers in the input array are negative, then the empty array will be greater,
and thus 0 will be returned, since there would not be any elements in the array if the array were empty.
===================================================================================================================
                                             The Program Itself
================================================================================================================"""


def find_max_sum_sub_array_recurse(sum_array, lo, hi):
    """This function uses the divide and conquer approach. It computes the index mid of the midpoint. This divides
     the array into a left_sub-array and a right sub_array. The conquering happens by recursively finding maximum
     sub-arrays within the left and right sub-arrays. This function calls find_max_whole_sum_array."""
    if hi == lo:
        return 0
    else:
        mid = (lo + hi) // 2
        left_sum = find_max_sum_sub_array_recurse(sum_array, lo, mid)
        right_sum = find_max_sum_sub_array_recurse(sum_array, mid+1, hi)
        whole_sum = find_max_whole_sum_array(sum_array, lo, mid, hi)
        if left_sum >= right_sum and left_sum >= whole_sum:
            return left_sum
        elif right_sum >= left_sum and right_sum >= whole_sum:
            return right_sum
        else:
            return whole_sum


def find_max_whole_sum_array(sum_array, lo, mid, hi):
    """This function has the added restriction that the subarray that is chosen must cross the midpoint.
    Any subarray crossing the midpoint is itself made of two subarrays sum_array[i... mid] and
    sum_array[mid+1, j]. Therefore, we just need to find maximum subarrays of this form and combine them."""
    the_sum = 0
    left_sum = 0
    for i in range(mid, lo-1, -1):
        the_sum += sum_array[i]
        if the_sum > left_sum:
            left_sum = the_sum
    right_sum = 0
    the_sum = 0
    for j in range(mid+1, hi):
        the_sum += sum_array[j]
        if the_sum > right_sum:
            right_sum = the_sum
    whole_sum = left_sum + right_sum
    if left_sum >= right_sum and left_sum >= whole_sum:
        return left_sum
    elif right_sum >= left_sum and right_sum >= whole_sum:
        return right_sum
    else:
        return whole_sum


def find_max_sum_sub_array(sum_array):
    """This is a wrapper function for find_max_sum_sub_array_recurse. This makes it so one does not need to input
    values for lo and hi each time and can just input the array."""
    return find_max_sum_sub_array_recurse(sum_array, lo=0, hi=len(sum_array))

""" ===============================================================================================================
                                                       Test
================================================================================================================"""


def test_find_max_sum_sub_array():
    assert find_max_sum_sub_array([-30, -12, -19, -24]) == 0  # If all integers are negative, zero will be returned
    assert find_max_sum_sub_array([]) == 0  # If list is empty, zero is returned
    assert find_max_sum_sub_array([67]) == 67 # One number in array
    assert find_max_sum_sub_array([1, -8, 16, 20, -2, -8, 5, 1]) == 36  # Max sum in middle of left_array
    assert find_max_sum_sub_array([3, -16, 1 , -3, 4, -9, -10, 13, 25, -2]) == 38 # Max sum in middle of right_array
    assert find_max_sum_sub_array([1, -10, 8, 7, -2, 8, -3, 1]) == 21  # Max sum crosses the midpoint of the_array
    assert find_max_sum_sub_array([32, 9, -8, 5, -10, 12]) == 41  # Max sum in outer left part of sub array
    assert find_max_sum_sub_array([1, 5, -9, 8, -20, 19, 6]) == 25  # Max sum in outer right part of sub array
    assert find_max_sum_sub_array([1,2,3,4,5,6,7]) == 28  # Max sum spans entire array

    """Some additional tests that I did to double check that all of my code works as it should:"""
    assert find_max_sum_sub_array([-1, -2, 3, 4, -5, 6]) == 8
    assert find_max_sum_sub_array([90]) == 90
    assert find_max_sum_sub_array([-8, 10, -6, -5, -4, -3, -2, -1]) == 10
    assert find_max_sum_sub_array([90, -2]) == 90
    assert find_max_sum_sub_array([-5, -4, -3, -2]) == 0
    assert find_max_sum_sub_array([-30, -2, -7, -9, -12]) == 0
    assert find_max_sum_sub_array([-30, 2]) == 2
    assert find_max_sum_sub_array([-2,1,-3,4,-1,2,1,-5,4]) == 6
    assert find_max_sum_sub_array([2, 4, -30]) == 6
    assert find_max_sum_sub_array([-39, 2, 4]) == 6
    assert find_max_sum_sub_array([-14, -39, 2, 4]) == 6
    assert find_max_sum_sub_array([-14, -39, -2, -4, 10]) == 10
    assert find_max_sum_sub_array([8, 6, 7]) == 21
    assert find_max_sum_sub_array([3,  -6,  1,  0,  9,  -4,  2,  1,  -2,  6,  -4]) == 13
    assert find_max_sum_sub_array([-1000]) == 0
    assert find_max_sum_sub_array([0]) == 0
    assert find_max_sum_sub_array([0,5,0,5,0]) == 10
    assert find_max_sum_sub_array([-2, -3, 4, -1, -2, 1, 5, -3]) == 7
    assert find_max_sum_sub_array([31, -41, 59, 26, -53, 58, 97, -93, -23, 84]) == 187
    assert find_max_sum_sub_array([30, 20, -6, -5, -2]) == 50
    assert find_max_sum_sub_array([-2, -3, -4, 30, 70]) == 100
    assert find_max_sum_sub_array([-2, 30, 70, -2]) == 100
    assert find_max_sum_sub_array([90, 30, 70, -2]) == 190
    assert find_max_sum_sub_array([-2, -2, -2, 1, -2]) == 1
    assert find_max_sum_sub_array([5,-2,4,8]) == 15
    assert find_max_sum_sub_array([2, -10, 15, 6, -7, 26, 8]) == 48
    assert find_max_sum_sub_array([2, -10, 6, -12, -2, 5, 7]) == 12
    assert find_max_sum_sub_array([-4, 30, 6, -12, -2, -5, -7, 2]) == 36