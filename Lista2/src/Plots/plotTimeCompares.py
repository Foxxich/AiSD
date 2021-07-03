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

import matplotlib.pyplot as plotTimeCompares
number = dataInsert[0]
insertT = dataInsert[2]/number
mergeT = dataMerge[2]/number
quickT = dataQuick[2]/number
dualT = dataDual[2]/number
hybridT = dataHybrid[2]/number
plotTimeCompares.plot(number, insertT,'r--')
plotTimeCompares.plot(number, mergeT,'b--')
plotTimeCompares.plot(number, quickT,'g--')
plotTimeCompares.plot(number, dualT,'k--')
plotTimeCompares.plot(number, hybridT,'y--')
plotTimeCompares.text(10000, 12, "MergeSort", bbox=dict(facecolor='blue', alpha=0.5))
plotTimeCompares.text(10000, 22, "QuickSort", bbox=dict(facecolor='green', alpha=0.5))
plotTimeCompares.text(10000,17 , "Dual", bbox=dict(facecolor='black', alpha=0.5))
plotTimeCompares.text(10000,2500 , "InsertionSort", bbox=dict(facecolor='red', alpha=0.5))
plotTimeCompares.text(10000,30 , "Hybrid", bbox=dict(facecolor='yellow', alpha=0.5))
plotTimeCompares.xlabel('N', fontsize=18)
plotTimeCompares.ylabel('Time', fontsize=16)
xmarks=[i for i in range(0,10001,1000)]
plotTimeCompares.xticks(xmarks)
plotTimeCompares.show()