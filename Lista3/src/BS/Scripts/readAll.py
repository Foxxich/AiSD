
import numpy as np
array = []
arrayComp = []
for x in range(1, 51):
    arr = np.genfromtxt("C:\\Users\\Vadym\\Documents\\Lista3\\src\\BS\\statBScenter\\BS"+str(x)+".txt",dtype='str',delimiter=',')
    #print (arr)

    #2 - time, 3 - compares
    for i in range(0,100):
        array.append((arr[i][2].astype(np.int64)))
        arrayComp.append((arr[i][3].astype(np.int64)))
    #print(array)
    #arrayStat.append(np.std(array))
    meanTime = np.round(np.mean(array))
    meanCompares = np.round(np.mean(arrayComp))
    print(x,meanTime,meanCompares)
    array.clear()
    arrayComp.clear()


