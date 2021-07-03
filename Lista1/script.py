from math import *

# for n lg n
n = 1
time = 86400
while n * log(n, 2) < 1000000 * time:
    n += 1
    print("n is :", n )

print("Minimum value of n (n lg n) :", n - 1)
