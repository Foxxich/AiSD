import pandas as pd
import numpy as np
import matplotlib.pyplot as plotCompares
array = []
arrayStat = []
arrayStat1 = []
arrayStat2 = []

for i in range (0,10): 
    arrayStat.append(7930.0)
    arrayStat1.append(7302.0)
    arrayStat2.append(6900.0)

dataCSV = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\9,11,13\\9\\MainP.txt",sep='\s+',header=None)
dataCSV1 = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\9,11,13\\11\\MainP.txt",sep='\s+',header=None)
dataCSV2 = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\9,11,13\\13\\MainP.txt",sep='\s+',header=None)
dataResult = pd.DataFrame(dataCSV)
dataResult1 = pd.DataFrame(dataCSV1)
dataResult2 = pd.DataFrame(dataCSV2)
plotCompares.plot(dataResult[3], dataResult[2],'r-')
plotCompares.plot(dataResult[3], dataResult1[2],'b-')
plotCompares.plot(dataResult[3], dataResult2[2],'y-')
plotCompares.plot(dataResult[3], arrayStat,'g-')
plotCompares.plot(dataResult[3], arrayStat1,'m-')
plotCompares.plot(dataResult[3], arrayStat2,'c-')
plotCompares.text(1, 7960, "9", bbox=dict(facecolor='r', alpha=0.5))
plotCompares.text(1, 7350, "11", bbox=dict(facecolor='b', alpha=0.5))
plotCompares.text(1, 7000, "13", bbox=dict(facecolor='y', alpha=0.5))
plotCompares.text(1, 7930.0, "AVG 9", bbox=dict(facecolor='g', alpha=0.5))
plotCompares.text(1, 7302.0, "AVG 11", bbox=dict(facecolor='m', alpha=0.5))
plotCompares.text(1, 6900.0, "AVG 13", bbox=dict(facecolor='c', alpha=0.5))
#xmarks=[i for i in range(0,100001,1)]
#plotCompares.xticks(xmarks)
plotCompares.savefig('Moves(permutation).png')
plotCompares.show()