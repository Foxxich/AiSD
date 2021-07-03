
# Example Python program to plot a complex bar chart 

import pandas as pd

import matplotlib.pyplot as plot
data = {"BST":[36847, 14971, 63.711],
        "RBT":[30, 24.433333333333334, 18],
        "SPLAY":[36847,63.711,2]
        };
index = ["MAX", "AVG", "MIN"];
# Dictionary loaded into a DataFrame       

dataFrame = pd.DataFrame(data=data, index=index);

 

# Draw a vertical bar chart

dataFrame.plot.bar(rot=15, title="Aspell");
plot.savefig("test.png");
plot.show(block=True);