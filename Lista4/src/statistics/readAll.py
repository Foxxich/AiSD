
import numpy as np

array = []
arrayStat = []
for x in range(1, 51):
    arr = np.genfromtxt("C:\\Users\\Vadym\\Documents\\Lista4\\src\\2\\Lotr\\SPLAY\\findElement"+str(x)+".txt",dtype='str',delimiter=',')
    #print (arr)

    for i in range(0,51):
        #print(arr[i][1])
        array.append(arr[i][2])
    #print(array)
    #arrayStat.append(np.std(array))
    new_l = list(map(int, array))
print(np.max(new_l))




