from timeit import repeat


user1 = input("Enter player1 name ")
user2 = input("Enter player2 name ")

while True:
    print("Pick from Rock,Paper, Scissor")
    user1_choice = input(user1+ " Enter your choice ").lower()
    user2_choice = input(user2+ " Enter your choice ").lower()

    if user1_choice == user2_choice:
        print("Draw")
    elif user1_choice=="rock":
        if user2_choice=="paper":
            print (user2 +" wins")
        elif user2_choice =="scissor":
            print (user1 +" wins")
    elif user1_choice=="paper":
        if user2_choice=="scissor":
            print (user2 +" wins")
        elif user2_choice =="rock":
            print (user1 +" wins")
    elif user1_choice=="scissor":
        if user2_choice=="rock":
            print (user2 +" wins")
        elif user2_choice =="paper":
            print (user1 +" wins")
    else:
        print("Invalid input, Try again")
    
    repeat = input("Do you wish to continue? ").lower()

    if(repeat == "yes"):
        continue
    elif(repeat == "no"):
        print ("Game ends")
        raise SystemExit
    else:
        print("Invalid input, Try again")
        raise SystemExit