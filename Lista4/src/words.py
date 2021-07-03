infile = "lotrTest.txt"
outfile = "cleanedLotrTest.txt"

delete_list = ["find"]
with open(infile) as fin, open(outfile, "w+") as fout:
    for line in fin:
        for word in delete_list:
            line = line.replace(word, "")
        fout.write(line)