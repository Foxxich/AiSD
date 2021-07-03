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
dataCSV = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\21,23,25\\25\\MainP.txt",sep='\s+',header=None)
dataResult = pd.DataFrame(dataCSV)
for i in range (0,10): 
    arrayStat.append(6119.0)#n permutation
    arrayStat1.append(6087.0 )#n random
    arrayStat2.append(6023.0 )#n+2 permutation
    arrayStat3.append(5987.0)#n+2 random
    arrayStat4.append(5937.0)#n+4 permutation
    arrayStat5.append( 5904.0)#n+4 random

plotCompares.plot(dataResult[3], arrayStat,'g-')
plotCompares.plot(dataResult[3], arrayStat1,'m-')
plotCompares.plot(dataResult[3], arrayStat2,'c-')
plotCompares.plot(dataResult[3], arrayStat3,'y-')
plotCompares.plot(dataResult[3], arrayStat4,'k-')
plotCompares.plot(dataResult[3], arrayStat5,'r-')
plotCompares.text(1,  5904.0, "n+4 random", bbox=dict(facecolor='r', alpha=0.5))
plotCompares.text(1, 5937.0, "n+4 permutation", bbox=dict(facecolor='k', alpha=0.5))
plotCompares.text(1, 5987.0, "n+2 random", bbox=dict(facecolor='y', alpha=0.5))
plotCompares.text(1,6119.0, "n permutation", bbox=dict(facecolor='g', alpha=0.5))
plotCompares.text(1, 6087.0, "n random", bbox=dict(facecolor='m', alpha=0.5))
plotCompares.text(1, 6023.0, "n+2 permutation", bbox=dict(facecolor='c', alpha=0.5))
#xmarks=[i for i in range(0,100001,1)]
#plotCompares.xticks(xmarks)
plotCompares.savefig('DVN(Moves).png')
plotCompares.show()