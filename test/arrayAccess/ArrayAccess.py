import random
import time

LIST_LENGTH = 10000
LIST_MAX_VALUE = 1_000_000

def selection_sort1(arr):
    for i in range(len(arr)):
        min_value = arr[i]
        min_idx = i
        for j in range(i + 1, len(arr)):
            if arr[j] < min_value:
                min_value = arr[j]
                min_idx = j
        arr[min_idx] = arr[i]
        arr[i] = min_value
    return arr

def selection_sort2(arr):
    for i in range(len(arr)):
        min_idx = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[min_idx]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]
    return arr

def measure_sort_performance():
    average_ratio = 0

    for _ in range(4):
        list1 = [random.randint(0, LIST_MAX_VALUE) for _ in range(LIST_LENGTH)]
        list2 = list1[:]
        
        start_time1 = time.time_ns()
        selection_sort1(list1)
        end_time1 = time.time_ns()
        
        start_time2 = time.time_ns()
        selection_sort2(list2)
        end_time2 = time.time_ns()
        
        time1 = end_time1 - start_time1
        time2 = end_time2 - start_time2
        
        average_ratio += time2 / time1
        
        print(f"selection_sort1: {time1}")
        print(f"selection_sort2: {time2}")
        print(f"Difference (2 - 1): {time2 - time1}")
        print(f"Ratio (2 / 1): {time2 / time1}\n")
        
    average_ratio /= 4
    print(f"Average ratio (2 / 1): {average_ratio}")

if __name__ == "__main__":
    measure_sort_performance()
