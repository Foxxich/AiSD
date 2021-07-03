import pandas as pd
import numpy as np
import matplotlib.pyplot as plotCompares
array = []
arrayStat = []
arrayStat1 = []
arrayStat2 = []

for i in range (0,10): 
    arrayStat.append(250168.0 )
    arrayStat1.append(255787.0)
    arrayStat2.append(230013.0 )

dataCSV = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\3,5,7\\3\\MainP.txt",sep='\s+',header=None)
dataCSV1 = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\3,5,7\\5\\MainP.txt",sep='\s+',header=None)
dataCSV2 = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\3,5,7\\7\\MainP.txt",sep='\s+',header=None)
dataResult = pd.DataFrame(dataCSV)
dataResult1 = pd.DataFrame(dataCSV1)
dataResult2 = pd.DataFrame(dataCSV2)
plotCompares.plot(dataResult[3], dataResult[0],'r-')
plotCompares.plot(dataResult[3], dataResult1[0],'b-')
plotCompares.plot(dataResult[3], dataResult2[0],'y-')
plotCompares.plot(dataResult[3], arrayStat,'g-')
plotCompares.plot(dataResult[3], arrayStat1,'m-')
plotCompares.plot(dataResult[3], arrayStat2,'c-')
plotCompares.text(1, 257000, "3", bbox=dict(facecolor='r', alpha=0.5))
plotCompares.text(1, 249000, "5", bbox=dict(facecolor='b', alpha=0.5))
plotCompares.text(1, 235000, "7", bbox=dict(facecolor='y', alpha=0.5))
plotCompares.text(1, 250000, "MAX 3", bbox=dict(facecolor='g', alpha=0.5))
plotCompares.text(1, 255000, "MAX 5", bbox=dict(facecolor='m', alpha=0.5))
plotCompares.text(1, 230000, "MAX 7", bbox=dict(facecolor='c', alpha=0.5))
#xmarks=[i for i in range(0,100001,1)]
#plotCompares.xticks(xmarks)
plotCompares.savefig('Time(permutation).png')
plotCompares.show()