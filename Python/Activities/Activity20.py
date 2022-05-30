import pandas

dataframe = pandas.read_excel("activity19.xlsx")

print(dataframe)
print("==============")
print("Number of rows+cols")
print(dataframe.shape)
print("==============")
print("Emails")
print(dataframe["Email"])
print("==============")
print("Sort data")
print(dataframe.sort_values("FirstName"))