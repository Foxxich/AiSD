import pandas as pd
import numpy as np
import matplotlib.pyplot as plot

dataCSV = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista5\\src\\2\\10000\\Dijkstra.txt',sep='\s+',header=None)
dataStat1 = pd.DataFrame(dataCSV)
number = dataStat1[0]
columnStat1 = dataStat1[2]
plot.plot(number, columnStat1,'r-')
plot.text(0, columnStat1[49], "N = 10000", bbox=dict(facecolor='red', alpha=0.5))
plot.xlabel('Attempt', fontsize=18)
plot.ylabel('Time', fontsize=16)
xmarks=[i for i in range(0,51,2)]
plot.xticks(xmarks)
plot.savefig("time.png")
plot.show()




