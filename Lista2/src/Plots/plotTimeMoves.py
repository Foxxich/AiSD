import pandas as pd
dataInsert = pd.read_csv('C:\\Users\\Vadym\\Documents\\Projects\\src\\Tests\\Test2(k = 1)\\statInsert.txt',sep='\s+',header=None)
dataMerge = pd.read_csv('C:\\Users\\Vadym\\Documents\\Projects\\src\\Tests\\Test2(k = 1)\\statMerge.txt',sep='\s+',header=None)
dataQuick = pd.read_csv('C:\\Users\\Vadym\\Documents\\Projects\\src\\Tests\\Test2(k = 1)\\statQuick.txt',sep='\s+',header=None)
dataDual = pd.read_csv('C:\\Users\\Vadym\\Documents\\Projects\\src\\Tests\\Test2(k = 1)\\statDual.txt',sep='\s+',header=None)
dataHybrid = pd.read_csv('C:\\Users\\Vadym\\Documents\\Projects\\src\\Tests\\Test2(k = 1)\\statHybrid.txt',sep='\s+',header=None)
dataInsert = pd.DataFrame(dataInsert)
dataMerge = pd.DataFrame(dataMerge)
dataQuick = pd.DataFrame(dataQuick)
dataDual = pd.DataFrame(dataDual)
dataHybrid = pd.DataFrame(dataHybrid)


import matplotlib.pyplot as plotTimeMoves
number = dataInsert[0]
insertT = dataInsert[3]/number
mergeT = dataMerge[3]/number
quickT = dataQuick[3]/number
dualT = dataDual[3]/number
hybridT = dataHybrid[3]/number
plotTimeMoves.plot(number, insertT,'r--')
plotTimeMoves.plot(number, mergeT,'b--')
plotTimeMoves.plot(number, quickT,'g--')
plotTimeMoves.plot(number, dualT,'k--')
plotTimeMoves.plot(number, hybridT,'y--')
plotTimeMoves.text(10000, 27, "MergeSort", bbox=dict(facecolor='blue', alpha=0.5))
plotTimeMoves.text(10000, 10, "QuickSort", bbox=dict(facecolor='green', alpha=0.5))
plotTimeMoves.text(10000,5 , "Dual", bbox=dict(facecolor='black', alpha=0.5))
plotTimeMoves.text(10000,2500 , "InsertionSort", bbox=dict(facecolor='red', alpha=0.5))
plotTimeMoves.text(10000,7 , "Hybrid", bbox=dict(facecolor='yellow', alpha=0.5))
plotTimeMoves.xlabel('N', fontsize=18)
plotTimeMoves.ylabel('Time', fontsize=16)
xmarks=[i for i in range(0,10001,1000)]
plotTimeMoves.xticks(xmarks)
plotTimeMoves.show()