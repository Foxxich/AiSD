import pandas as pd
import numpy as np
nameMQS = "medianQS100"
nameQS = "QS100"
nameDUAL = "DUAL100"
dataQMS = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista3\\src\\4\\Sorted\\'+str(nameMQS)+'.txt',sep='\s+',header=None)    
dataQS = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista3\\src\\4\\Sorted\\'+str(nameQS)+'.txt',sep='\s+',header=None)
dataDUAL = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista3\\src\\4\\Sorted\\'+str(nameDUAL)+'.txt',sep='\s+',header=None)
datasQMS = pd.DataFrame(dataQMS)
datasQS = pd.DataFrame(dataQS)
datasDUAL = pd.DataFrame(dataDUAL)
number1 = dataQMS[1]
number2 = dataQS[1]
for i in range (1,4) :
    print(np.mean(datasQMS[i]))
    print(np.mean(datasQS[i]))
    print(np.mean(datasDUAL[i]))
    print('--------------------------------')