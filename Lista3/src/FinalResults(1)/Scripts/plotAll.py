import pandas as pd
import numpy as np
import matplotlib.pyplot as plotCompares
array = []
arrayAVG = []
for x in range(1, 101):
    dataCSV = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(1)\\Statistics\\k=n_dzielone_przez_2\\RandomSelect(Permutation)\\permutationRS"+str(x)+".txt",sep=',',header=None)
    dataAVGCSV = pd.read_csv("C:\\Users\\Vadym\\Documents\\Lista3\\src\\FinalResults(1)\\Statistics\\k=n_dzielone_przez_2\\RandomSelect(permutation).txt",sep='\s+',header=None)
    dataResult = pd.DataFrame(dataCSV)
    dataResultAVG = pd.DataFrame(dataAVGCSV)
    #print(x)
    #print (dataResult[4])
    #array = dataResult[4]
    #arrayAVG = dataResultAVG[2] #average statistics
    #arrayMIN = dataResultAVG[1] #minimum statistics
    #arrayMAX = dataResultAVG[0] #maximum statistics
    #arrayDVN = dataResultAVG[3] #deviation statistics
    plotCompares.plot(dataResult[0], dataResult[3],'r.')
    plotCompares.plot(dataResult[0], dataResultAVG[2],'b-') #avg
    plotCompares.plot(dataResult[0], dataResultAVG[0],'g-') #max
    plotCompares.plot(dataResult[0], dataResultAVG[1],'y-') #min
    plotCompares.plot(dataResult[0], dataResultAVG[3],'k-') #dvn
plotCompares.text(10000, 30000, "Graph", bbox=dict(facecolor='red', alpha=0.3))
plotCompares.text(0, 20000, "Average", bbox=dict(facecolor='blue', alpha=0.3))
plotCompares.text(0, 60000, "Maximum", bbox=dict(facecolor='g', alpha=0.3))
plotCompares.text(0, 10000, "Deviation", bbox=dict(facecolor='k', alpha=0.3))
plotCompares.text(0, 000, "Minimum", bbox=dict(facecolor='y', alpha=0.3))
#xmarks=[i for i in range(0,100001,1)
#plotCompares.xticks(xmarks)
#print (np.round(np.amax(array)))
plotCompares.savefig('comparisonRSelect(permutation).png')
plotCompares.show()


