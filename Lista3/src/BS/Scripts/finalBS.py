
import numpy as np
import pandas as pd
array = []
arrayComp = []
for x in range(1, 51):
    arr = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\BS\\statBScenter.txt",sep='\s+',header=None)
    #print (arr)
    array.append(arr[1])
    arrayComp.append(arr[2])
    #print(array)
    #arrayStat.append(np.std(array))
meanTime = np.round(np.mean(array))
meanCompares = np.round(np.mean(arrayComp))
print(meanTime,meanCompares)
