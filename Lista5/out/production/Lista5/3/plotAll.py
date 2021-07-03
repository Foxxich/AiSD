import pandas as pd
import numpy as np
import matplotlib.pyplot as plot

dataCSV = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista5\\src\\3\\1000\\Kruskal.txt',sep='\s+',header=None)
dataCSV2 = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista5\\src\\3\\1000\\Prim.txt',sep='\s+',header=None)
dataStat1 = pd.DataFrame(dataCSV)
dataStat2 = pd.DataFrame(dataCSV2)
number = dataStat1[0]
columnStat1 = dataStat1[1]
columnStat2 = dataStat2[1]
plot.plot(number, columnStat1,'r-')
plot.plot(number, columnStat2,'g-')
plot.text(0, columnStat1[49], "Kruskal", bbox=dict(facecolor='red', alpha=0.5))
plot.text(0, columnStat2[49], "Prim", bbox=dict(facecolor='green', alpha=0.5))
plot.xlabel('Attempt', fontsize=18)
plot.ylabel('Time', fontsize=16)
xmarks=[i for i in range(0,51,2)]
plot.xticks(xmarks)

plot.savefig("time.png")
plot.show()




