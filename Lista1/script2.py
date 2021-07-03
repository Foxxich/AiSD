# for n!
n = 1
time = 2592000
while factorial(n) < 1000000 * time:
    n += 1

print("Minimum value of n (n!)     :", n - 1)