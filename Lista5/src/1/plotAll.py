import pandas as pd
import numpy as np
import matplotlib.pyplot as plot

dataCSV = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista5\\src\\1\\PQ10000.txt',sep='\s+',header=None)
dataCSV2 = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista5\\src\\1\\PQ20000.txt',sep='\s+',header=None)
dataStat1 = pd.DataFrame(dataCSV)
dataStat2 = pd.DataFrame(dataCSV2)
number = dataStat1[0]
columnStat1 = dataStat1[6]
columnStat2 = dataStat2[6]
plot.plot(number, columnStat1,'r-')
plot.plot(number, columnStat2,'g-')
plot.text(0, columnStat1[49], "N = 10000", bbox=dict(facecolor='red', alpha=0.5))
plot.text(0, columnStat2[49], "N = 20000", bbox=dict(facecolor='green', alpha=0.5))
plot.xlabel('Attempt', fontsize=18)
plot.ylabel('Time', fontsize=16)
xmarks=[i for i in range(0,51,2)]
plot.xticks(xmarks)
plot.savefig("time_10000-20000.png")
plot.show()




