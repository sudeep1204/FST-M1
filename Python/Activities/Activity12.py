def calculate(numbers):
    if(numbers):
        return numbers+calculate(numbers-1)
    else:
        return 0

res = calculate(11)
print (res)