
import numpy as np
import pandas as pd
array = []
arrayStat = []
data = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(1)\\Statistics\\k_blisko_n\\Compares\\RandomSelect(permutation).txt',sep='\s+',header=None)
dataMaxTotal = data[0]
dataMinTotal = data[1]
dataAvgTotal = data[2]
dataStdTotal = data[3]
dataNTotal = data[4]
maxStatAVG = np.round(np.mean(dataMaxTotal))
minStatAVG = np.round(np.mean(dataMinTotal))
avgStatAVG = np.round(np.mean(dataAvgTotal))
stdStatAVG = np.round(np.mean(dataStdTotal))
nStatAVG = np.round(np.mean(dataNTotal))
print(maxStatAVG,minStatAVG,avgStatAVG,stdStatAVG,nStatAVG)
