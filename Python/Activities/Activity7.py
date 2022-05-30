# num_list = [1,2,3,4]

numbers = list(input("Enter number list seperated by comma: ").split(","))
sum = 0

# print (numbers)

for number in numbers:
    sum = sum + int(number)

print (sum)