import sys

for i in range(1, 11):
    ch = "input" + str(i) + ".txt"
    sys.stdin = open(ch, "wt")