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
npMaxN = 26395.0
nrMaxN = 25362.0
npMaxN2 =11639.0
nrMaxN2 =11539.0
npMaxN4 = 8964.0
nrMaxN4 =  8964.0
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
plotCompares.savefig('MIN(moves).png')
plotCompares.show()