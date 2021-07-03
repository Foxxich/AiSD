import pandas as pd
dataQuick = pd.read_csv('C:\\Users\\Vadym\\Documents\\Projects\\src\\Dual\\statQuick.txt',sep='\s+',header=None)
dataDual = pd.read_csv('C:\\Users\\Vadym\\Documents\\Projects\\src\\Dual\\statDual.txt',sep='\s+',header=None)
dataQuick = pd.DataFrame(dataQuick)
dataDual = pd.DataFrame(dataDual)

import matplotlib.pyplot as plotMoves
number = dataQuick[0]
quickS = dataQuick[2]/number
dualS = dataDual[2]/number
plotMoves.plot(number, quickS,'g--')
plotMoves.plot(number, dualS,'k--')
plotMoves.text(10000, 30, "QuickSort", bbox=dict(facecolor='green', alpha=0.5))
plotMoves.text(10000,20 , "Dual", bbox=dict(facecolor='black', alpha=0.5))
plotMoves.xlabel('N', fontsize=18)
plotMoves.ylabel('Moves', fontsize=16)
xmarks=[i for i in range(0,10001,1000)]
plotMoves.xticks(xmarks)
plotMoves.savefig('TimeCompares.png')
plotMoves.show()