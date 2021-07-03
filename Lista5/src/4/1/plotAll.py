import pandas as pd
import numpy as np
import matplotlib.pyplot as plot

dataCSV = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista5\\src\\4\\1\\100.txt',sep='\s+',header=None)
dataStat1 = pd.DataFrame(dataCSV)
number = dataStat1[0]
columnStat1 = dataStat1[2]
plot.plot(number, columnStat1,'r-')
plot.xlabel('Attempt', fontsize=18)
plot.ylabel('Compares', fontsize=16)
xmarks=[i for i in range(0,51,2)]
plot.xticks(xmarks)

plot.savefig("compares_100.png")
plot.show()




