import sys
import time

# The complexity of binary search is O(Log n)
def binary_search(data,value):
    print data
    low = 0
    high = len(data)
    mid = (high-low)/2
    while value!=data[mid]:
        if value > data[mid]:
            low = mid
            mid = mid + (high-low)/2
        if value < data[mid]:
            high = mid
            mid=(high-low)/2
        print mid
    return mid

print(binary_search([1,2,3,4,5,6,7,8,9],int(sys.argv[1])))

# The complexity of bubble sort is O(n^2)
def bubble_sort(data):
    sorted = False
    while sorted == False:
        sorted = True
        for i in range(0,len(data)-1):
            if data[i]>data[i+1]:
                s = data[i]
                data[i] = data[i+1]
                data[i+1] = s
                sorted = False
                print (data)

bubble_sort([99,1,12,44,2,98])
