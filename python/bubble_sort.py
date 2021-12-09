import sys

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
