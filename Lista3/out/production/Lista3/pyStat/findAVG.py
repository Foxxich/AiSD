import numpy as np

mysum = 0
n = 0
with open('C:\\Users\\Vadym\\Documents\\Lista3\\src\\plik.txt','r') as f:
    for line in f:
        mysum += int(line.split()[2])
        n += int(line.split()[0])
print(mysum/100)
