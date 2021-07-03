
import numpy as np
arrayTimeP = []
arrayComparesP = []
arrayMovesP = [] 
arrayTimeR = []
arrayComparesR = []
arrayMovesR = [] 
arrayStat = []
for x in range(1, 11):
    arr = np.genfromtxt("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\3,5,7\\7\\permutationS"+str(x)+".txt",dtype='str',delimiter=',')
    arrR = np.genfromtxt("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\3,5,7\\7\\randomS"+str(x)+".txt",dtype='str',delimiter=',')
    #print (arr)

    for i in range(0,100):
        arrayTimeP.append(arr[i][2].astype(np.float64))
        arrayComparesP.append((arr[i][3].astype(np.int64)))
        arrayMovesP.append((arr[i][4].astype(np.int64)))
        arrayTimeR.append((arrR[i][2]).astype(np.float64))
        arrayComparesR.append((arrR[i][3].astype(np.int64)))
        arrayMovesR.append((arrR[i][4].astype(np.int64)))
    #print(array)
    #arrayStat.append(np.std(array))
    meanTimeR = np.round(np.std(arrayTimeR))
    meanComparesR =  np.round(np.std(arrayComparesR))
    meanMovesR= np.round(np.mean(arrayMovesR))
    meanTimeP = np.round(np.std(arrayTimeP))
    meanComparesP =  np.round(np.std(arrayComparesP))
    meanMovesP= np.round(np.mean(arrayMovesP))
print(meanTimeR,meanComparesR,meanMovesR)
print(meanTimeP,meanComparesP,meanMovesP)