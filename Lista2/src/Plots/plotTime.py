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

import matplotlib.pyplot as plotTime

number = dataInsert[0]
insertT = dataInsert[1]
mergeT = dataMerge[1]
quickT = dataQuick[1]
dualT = dataDual[1]
hybridT = dataHybrid[1]
plotTime.plot(number, insertT,'r--')
plotTime.plot(number, mergeT,'b--')
plotTime.plot(number, quickT,'g--')
plotTime.plot(number, dualT,'k--')
plotTime.plot(number, hybridT,'y--')
plotTime.text(10000, 3, "MergeSort", bbox=dict(facecolor='blue', alpha=0.5))
plotTime.text(10000, 2, "QuickSort", bbox=dict(facecolor='green', alpha=0.5))
plotTime.text(10000,1 , "Dual", bbox=dict(facecolor='black', alpha=0.5))
plotTime.text(10000,15 , "InsertionSort", bbox=dict(facecolor='red', alpha=0.5))
plotTime.text(10000,4 , "Hybrid", bbox=dict(facecolor='yellow', alpha=0.5))
plotTime.xlabel('N', fontsize=18)
plotTime.ylabel('Time', fontsize=16)
xmarks=[i for i in range(0,10001,1000)]
plotTime.xticks(xmarks)
plotTime.show()


