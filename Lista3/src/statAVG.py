import pandas as pd
import numpy as np
nameMQS = "medianQS10"
nameQS = "QS10"
dataQMS = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista3\\src\\'+str(nameMQS)+'.txt',sep='\s+',header=None)    
dataQS = pd.read_csv('C:\\Users\\Vadym\\Documents\\Lista3\\src\\'+str(nameQS)+'.txt',sep='\s+',header=None)
datasQMS = pd.DataFrame(dataQMS)
datasQS = pd.DataFrame(dataQS)
number1 = dataQMS[1]
number2 = dataQS[1]
for i in range (1,4) :
    print(np.mean(datasQMS[i]))
    print(np.mean(datasQS[i]))