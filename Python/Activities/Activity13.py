# Write a function sum() such that it can accept a list of elements and print the sum of all elements

def calSum(num):
    sum = 0
    for number in num:
        sum = sum +number
    return sum

numList=[1,3,5,7]

res = calSum(numList)
print(res)