import sys

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
