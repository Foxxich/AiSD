import pandas as pd
import numpy as np
import matplotlib.pyplot as plotCompares
array = []
arrayStat = []
arrayStat1 = []
arrayStat2 = []
arrayStat3 = []
arrayStat4 = []
arrayStat5 = []
npValueMQS = 52940.41
npValueQS = 16920024.0
npValueDUAL = 5638329.21
dataMQS = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\4\\Sorted\\medianQS100.txt",sep='\s+',header=None)
dataQS = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\4\\Sorted\\QS100.txt",sep='\s+',header=None)
dataDUAL = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\4\\Sorted\\DUAL100.txt",sep='\s+',header=None)
dataResultMQS = pd.DataFrame(dataMQS)
dataResultQS = pd.DataFrame(dataQS)
dataResultDUAL = pd.DataFrame(dataDUAL)
arrayStat[0:100] = [npValueMQS]*100
arrayStat1[0:100] = [npValueQS]*100
arrayStat2[0:100] = [npValueDUAL]*100
numberMQS = dataResultMQS[3]
numberQS = dataResultQS[3]
numberDUAL = dataResultDUAL[3]
plotCompares.plot(dataResultMQS[0], arrayStat,'g-')
plotCompares.plot(dataResultMQS[0], arrayStat1,'r-')
plotCompares.plot(dataResultMQS[0], arrayStat2,'b-')
plotCompares.plot(dataResultMQS[0], numberMQS,'y-')
plotCompares.plot(dataResultMQS[0], numberQS,'k-')
plotCompares.plot(dataResultMQS[0], numberDUAL,'m-')
plotCompares.text(1, npValueMQS , "AVG MQS", bbox=dict(facecolor='g', alpha=0.5))
plotCompares.text(1, npValueQS , "AVG QS", bbox=dict(facecolor='r', alpha=0.5))
plotCompares.text(1, npValueDUAL , "AVG DUAL", bbox=dict(facecolor='b', alpha=0.5))
plotCompares.text(1, numberMQS[97], "MQS", bbox=dict(facecolor='y', alpha=0.5))
plotCompares.text(1, numberQS[99]  , "QS", bbox=dict(facecolor='k', alpha=0.5))
plotCompares.text(1, numberDUAL[99]  , "DUAL", bbox=dict(facecolor='m', alpha=0.5))
#xmarks=[i for i in range(0,100001,1)]
#plotCompares.xticks(xmarks)
plotCompares.savefig('Moves100.png')
plotCompares.show()