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

import matplotlib.pyplot as plotCompares

number = dataInsert[0]
insertC = dataInsert[2]
insertArray = []
insertArray.append(insertC)
mergeC = dataMerge[2]
mergeArray = []
mergeArray.append(mergeC)
quickC = dataQuick[2]
quickArray = []
quickArray.append(quickC)
dualC = dataDual[2]
dualArray = []
dualArray.append(dualC)
hybridC = dataHybrid[2]
hybridArray = []
hybridArray.append(hybridC)

plotCompares.plot(number, insertC,'r--')
plotCompares.plot(number, mergeC,'b--')
plotCompares.plot(number, quickC,'g--')
plotCompares.plot(number, dualC,'k--')
plotCompares.plot(number, hybridC,'y--')
plotCompares.text(10000, 100000, "MergeSort", bbox=dict(facecolor='blue', alpha=0.5))
plotCompares.text(10000, 300000, "QuickSort", bbox=dict(facecolor='green', alpha=0.5))
plotCompares.text(10000,220000 , "Dual", bbox=dict(facecolor='black', alpha=0.5))
plotCompares.text(10000,25000000 , "InsertionSort", bbox=dict(facecolor='red', alpha=0.5))
plotCompares.text(10000,400000 , "Hybrid", bbox=dict(facecolor='yellow', alpha=0.5))
plotCompares.xlabel('N', fontsize=18)
plotCompares.ylabel('Compares', fontsize=16)
xmarks=[i for i in range(0,10000,1000)]
plotCompares.xticks(xmarks)
plotCompares.save("compares1.png")
plotCompares.show()