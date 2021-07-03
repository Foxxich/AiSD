import pandas as pd
import numpy as np
import matplotlib.pyplot as plotCompares
array = []
arrayStat = []
arrayStat1 = []
arrayStat2 = []
arrayStat3 = []
arrayStat4 = []
arrayStat5 = []
npMaxN = 1442
nrMaxN = 1340
npMaxN2 = 296
nrMaxN2 = 292
npMaxN4 = 172
nrMaxN4 =  176
dataCSV = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\9,11,13\\11\\MainP.txt",sep='\s+',header=None)
dataResult = pd.DataFrame(dataCSV)
for i in range (0,10): 
    arrayStat.append(npMaxN)#n permutation
    arrayStat1.append(nrMaxN  )#n random
    arrayStat2.append(npMaxN2)#n+2 permutation
    arrayStat3.append(nrMaxN2)#n+2 random
    arrayStat4.append(npMaxN4)#n+4 permutation
    arrayStat5.append(nrMaxN4)#n+4 random

plotCompares.plot(dataResult[3], arrayStat,'g-')
plotCompares.plot(dataResult[3], arrayStat1,'m-')
plotCompares.plot(dataResult[3], arrayStat2,'c-')
plotCompares.plot(dataResult[3], arrayStat3,'y-')
plotCompares.plot(dataResult[3], arrayStat4,'k-')
plotCompares.plot(dataResult[3], arrayStat5,'r-')
plotCompares.text(1, npMaxN , "n permutation", bbox=dict(facecolor='g', alpha=0.5))
plotCompares.text(1,nrMaxN , "n random", bbox=dict(facecolor='m', alpha=0.5))
plotCompares.text(1, npMaxN2 , "n+2 permutation", bbox=dict(facecolor='c', alpha=0.5))
plotCompares.text(1, nrMaxN2, "n+2 random", bbox=dict(facecolor='y', alpha=0.5))
plotCompares.text(1, npMaxN4  , "n+4 permutation", bbox=dict(facecolor='k', alpha=0.5))
plotCompares.text(1, nrMaxN4 , "n+4 random", bbox=dict(facecolor='r', alpha=0.5))
#xmarks=[i for i in range(0,100001,1)]
#plotCompares.xticks(xmarks)
plotCompares.savefig('MAX(compares).png')
plotCompares.show()