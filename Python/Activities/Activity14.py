def fib(number):
    if number<=1:
        return number
    else:
        return (fib(number-1) +fib(number-2))

number = int(input("Enter starting number: "))

print("Series is ")
for i in range (number):
    print(fib(i))