import pandas as pd
import numpy as np
import matplotlib.pyplot as plotCompares
array = []
array2 = []
array3 = []

for x in range(1, 51):
    dataCSV = np.genfromtxt("C:\\Users\\Vadym\\Documents\\Lista4\\src\\2\\Aspell\\BST\\findElement"+str(x)+".txt",dtype='str',delimiter=',')
    dataCSV2 = np.genfromtxt("C:\\Users\\Vadym\\Documents\\Lista4\\src\\2\\Aspell\\RBT\\findElement"+str(x)+".txt",dtype='str',delimiter=',')
    dataCSV3 = np.genfromtxt("C:\\Users\\Vadym\\Documents\\Lista4\\src\\2\\Aspell\\SPLAY\\findElement"+str(x)+".txt",dtype='str',delimiter=',')
    for i in range(0,60):
        array.append((dataCSV[i][2].astype(np.int64)))
        array2.append((dataCSV2[i][2].astype(np.int64)))
        array3.append((dataCSV3[i][2].astype(np.int64)))
    #print(x)
    #print (dataResult[4])
    #array = dataResult[4]
    for i in range(0,60):
        plotCompares.plot(i, array[i],'r.')
        plotCompares.plot(i, array2[i],'y.')
        plotCompares.plot(i, array3[i],'g.')
    #print((np.mean(array)),x)
    array.clear()
    array2.clear()
    array3.clear()
    plotCompares.text(0, 1000, "BST", bbox=dict(facecolor='red', alpha=0.3))
    plotCompares.text(0, 3000, "RBT", bbox=dict(facecolor='y', alpha=0.3))
    plotCompares.text(0, 6000, "SPLAY", bbox=dict(facecolor='g', alpha=0.3))
    plotCompares.savefig('comparison'+str(x)+'.png')
    plotCompares.clf()
#plotCompares.show()


