fruits ={
    "apple":20,
    "banana":5,
    "orange":30
}

check = input("Fruit to check -> ").lower()

if(check in fruits):
    print("Available")
else:
    print("Not Available")
