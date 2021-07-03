import numpy as np

mysum = 0
n = 0
with open('C:\\Users\\Vadym\\Documents\\Projects\\src\\Dual\\statDual.txt','r') as f:
    for line in f:
        array = []
        array = float(line.split()[1])
        mysum += float(line.split()[1])
print(mysum/100)