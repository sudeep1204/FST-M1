listOne = [1,2,3,4,5]
listTwo =[6,7,8,9,10]

combinedList =[]

for num in listOne:
    if(num%2!=0):
        combinedList.append(num)

for num in listTwo:
    if(num%2 ==0):
        combinedList.append(num)

print("Final list")
print(combinedList)