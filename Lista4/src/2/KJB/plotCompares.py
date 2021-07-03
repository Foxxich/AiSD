
# Example Python program to plot a complex bar chart 

import pandas as pd

import matplotlib.pyplot as plot
data = {"BST":[38, 17, 7],
        "RBT":[37, 15, 3],
        "SPLAY":[38,2,2]
        };
index = ["MAX", "AVG", "MIN"];
# Dictionary loaded into a DataFrame       

dataFrame = pd.DataFrame(data=data, index=index);

 

# Draw a vertical bar chart

dataFrame.plot.bar(rot=15, title="KJB");
plot.savefig("test.png");
plot.show(block=True);