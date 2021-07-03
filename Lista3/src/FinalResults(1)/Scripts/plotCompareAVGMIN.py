import pandas as pd
import numpy as np
import matplotlib.pyplot as plotCompares
array = []
arrayStat = []
dataCSV = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(1)\\Statistics\\k=n_dzielone_przez_2\\Select(random).txt",sep='\s+',header=None)
dataCSV1 = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(1)\\Statistics\\k=n_dzielone_przez_2\\RandomSelect(random).txt",sep='\s+',header=None)
dataCSV2 = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(1)\\Statistics\\k=n_dzielone_przez_2\\Select(permutation).txt",sep='\s+',header=None)
dataCSV3 = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(1)\\Statistics\\k=n_dzielone_przez_2\\RandomSelect(permutation).txt",sep='\s+',header=None)
dataResult = pd.DataFrame(dataCSV)
dataResult1 = pd.DataFrame(dataCSV1)
dataResult2 = pd.DataFrame(dataCSV2)
dataResult3 = pd.DataFrame(dataCSV3)
plotCompares.plot(dataResult[4], dataResult[1],'r-')
plotCompares.plot(dataResult[4], dataResult1[1],'b-')
plotCompares.plot(dataResult[4], dataResult2[1],'y-')
plotCompares.plot(dataResult[4], dataResult3[1],'g-')
plotCompares.text(0, 60, "Select(random)", bbox=dict(facecolor='r', alpha=0.5))
plotCompares.text(0, 450, "RandomSelect(random)", bbox=dict(facecolor='b', alpha=0.5))
plotCompares.text(00, 0, "Select(permutation)", bbox=dict(facecolor='y', alpha=0.5))
plotCompares.text(0000, 200, "RandomSelect(permutation)", bbox=dict(facecolor='g', alpha=0.5))
#xmarks=[i for i in range(0,100001,1)]
#plotCompares.xticks(xmarks)
plotCompares.savefig('comparisonMIN.png')
plotCompares.show()