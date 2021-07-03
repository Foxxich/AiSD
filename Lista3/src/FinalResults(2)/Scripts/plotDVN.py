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
dataCSV = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\3,5,7\\5\\MainP.txt",sep='\s+',header=None)
dataResult = pd.DataFrame(dataCSV)
for i in range (0,10): 
    arrayStat.append(522800.0 )#n permutation
    arrayStat1.append(526902.0 )#n random
    arrayStat2.append(276460.0 )#n+2 permutation
    arrayStat3.append(278528.0)#n+2 random
    arrayStat4.append(229373.0)#n+4 permutation
    arrayStat5.append(238999.0)#n+4 random

plotCompares.plot(dataResult[3], arrayStat,'g-')
plotCompares.plot(dataResult[3], arrayStat1,'m-')
plotCompares.plot(dataResult[3], arrayStat2,'c-')
plotCompares.plot(dataResult[3], arrayStat3,'y-')
plotCompares.plot(dataResult[3], arrayStat4,'k-')
plotCompares.plot(dataResult[3], arrayStat5,'r-')
plotCompares.text(1, 249000, "n+4 random", bbox=dict(facecolor='r', alpha=0.5))
plotCompares.text(1, 240000, "n+4 permutation", bbox=dict(facecolor='k', alpha=0.5))
plotCompares.text(1, 275000, "n+2 random", bbox=dict(facecolor='y', alpha=0.5))
plotCompares.text(1, 275000.0, "n permutation", bbox=dict(facecolor='g', alpha=0.5))
plotCompares.text(1, 500000.0, "n random", bbox=dict(facecolor='m', alpha=0.5))
plotCompares.text(1, 520000.0, "n+2 permutation", bbox=dict(facecolor='c', alpha=0.5))
#xmarks=[i for i in range(0,100001,1)]
#plotCompares.xticks(xmarks)
plotCompares.savefig('DVN(time).png')
plotCompares.show()