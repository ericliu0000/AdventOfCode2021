with open("input.txt", "r") as f:
    lines = f.readlines()

    oxygen_lines = lines[:]
    co_lines = lines[:]

    for i in range(len(lines[0])):
        if len(oxygen_lines) == 1:
            break
    
        ones = 0
        zeros = 0
        for line in oxygen_lines:
            if line[i] == "1": ones += 1
            else: zeros += 1
        
        temp_lines = []

        if ones >= zeros:
            for line in oxygen_lines:
                if line[i] == "1":
                    temp_lines.append(line)
        else:
            for line in oxygen_lines:
                if line[i] == "0":
                    temp_lines.append(line)

        oxygen_lines = temp_lines[:]
    
    print(oxygen_lines)

    for i in range(len(lines[0])):
        if len(co_lines) == 1:
            break
    
        ones = 0
        zeros = 0
        for line in co_lines:
            if line[i] == "1": ones += 1
            else: zeros += 1
        
        temp_lines = []

        if ones < zeros:
            for line in co_lines:
                if line[i] == "1":
                    temp_lines.append(line)
        else:
            for line in co_lines:
                if line[i] == "0":
                    temp_lines.append(line)

        co_lines = temp_lines[:]

    print(co_lines)

print(int(oxygen_lines[0][:-1], 2) * int(co_lines[0][:-1], 2))
