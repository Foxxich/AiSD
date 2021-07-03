
import numpy as np
import pandas as pd
array = []
arrayStat = []
data = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\3,5,7\\7\\MainP.txt',sep='\s+',header=None)
data2 = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(2)\\3,5,7\\7\\MainR.txt',sep='\s+',header=None)
dataMaxTotal = data[0]
dataMinTotal = data[1]
dataAvgTotal = data[2]
maxStatAVG = np.round(np.min(dataMaxTotal))
minStatAVG = np.round(np.min(dataMinTotal))
avgStatAVG = np.round(np.min(dataAvgTotal))
print(maxStatAVG,minStatAVG,avgStatAVG)

dataMaxTotal2 = data2[0]
dataMinTotal2 = data2[1]
dataAvgTotal2 = data2[2]
maxStatAVG2 = np.round(np.min(dataMaxTotal2))
minStatAVG2 = np.round(np.min(dataMinTotal2))
avgStatAVG2 = np.round(np.min(dataAvgTotal2))
print(maxStatAVG2,minStatAVG2,avgStatAVG2)