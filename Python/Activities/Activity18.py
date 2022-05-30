import pandas

dataframe = pandas.read_csv("activity17.csv")

# print(dataframe["Usernames"])
# print("----------------")
# print(dataframe["Usernames"][1], " = ",dataframe["Passwords"][1])

# Print the values in the Usernames column only
print("===============")
print("Usernames:")
print(dataframe["Usernames"])
 
# Print the username and password of the second row
print("===============")
print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])
 
#Sort the Usernames column in ascending order
print("====================================")
print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('Usernames'))
 
#Sort the Passwords column in descending order
print("====================================")
print("Data sorted in descending Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))
