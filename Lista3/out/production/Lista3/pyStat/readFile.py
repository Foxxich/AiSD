for x in range(1, 3):
    fp = open("C:\\Users\\Vadym\\Documents\\Lista3\\src\\randomS"+str(x)+".txt")
    array = []
    for i, line in enumerate(fp):
        if i == 0:
            print(line.split(",",6))
            compares = line.split(',', expand=True)[0]
            array.append(compares)
        elif i == 2:
            print(fp)
        elif i > 2:
            break
    print(array)
    fp.close()