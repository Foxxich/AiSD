
import numpy as np
array = []
arrayStat = []
for x in range(1, 101):
    arr = np.genfromtxt("C:\\Users\\Vadym\\Documents\\Lista3\\src\\permutationRS"+str(x)+".txt",dtype='str',delimiter=',')
    #print (arr)

    for i in range(0,3):
        array.append((arr[i][0].astype(np.int64)))
    #print(array)
    #arrayStat.append(np.std(array))
    maxStat = np.round(np.amax(array))
    minStat =  np.round(np.amin(array))
    meanStat = np.round(np.mean(array))
    stdStat = np.round(np.std(array))
    print(maxStat,minStat,meanStat,stdStat,x)
    array.clear()


