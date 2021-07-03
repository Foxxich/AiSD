
# Example Python program to plot a complex bar chart 

import pandas as pd

import matplotlib.pyplot as plot
data = {"BST":[47, 26, 9],
        "RBT":[32, 17, 3],
        "SPLAY":[40,2,2]
        };
index = ["MAX", "AVG", "MIN"];
# Dictionary loaded into a DataFrame       

dataFrame = pd.DataFrame(data=data, index=index);

 

# Draw a vertical bar chart

dataFrame.plot.bar(rot=15, title="Lotr");
plot.savefig("test.png");
plot.show(block=True);