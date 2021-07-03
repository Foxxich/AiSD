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

import matplotlib.pyplot as plotMoves
number = dataInsert[0]
insertS = dataInsert[3]
mergeS = dataMerge[3]
quickS = dataQuick[3]
dualS = dataDual[3]
hybridS = dataHybrid[3]
plotMoves.plot(number, insertS,'r--')
plotMoves.plot(number, mergeS,'b--')
plotMoves.plot(number, quickS,'g--')
plotMoves.plot(number, dualS,'k--')
plotMoves.plot(number, hybridS,'y--')
plotMoves.text(10000, 300000, "MergeSort", bbox=dict(facecolor='blue', alpha=0.5))
plotMoves.text(10000, 100000, "QuickSort", bbox=dict(facecolor='green', alpha=0.5))
plotMoves.text(10000,50000 , "Dual", bbox=dict(facecolor='black', alpha=0.5))
plotMoves.text(10000,25000000 , "InsertionSort", bbox=dict(facecolor='red', alpha=0.5))
plotMoves.text(10000,75000 , "Hybrid", bbox=dict(facecolor='yellow', alpha=0.5))
plotMoves.xlabel('N', fontsize=18)
plotMoves.ylabel('Moves', fontsize=16)
xmarks=[i for i in range(0,10001,1000)]
plotMoves.xticks(xmarks)
plotMoves.show()