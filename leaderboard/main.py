import json
from datetime import datetime

board = {}
with open("lb.txt") as n: 
    board = json.load(n)

member_ids = [member for member in board["members"]]

while 1:
    day = input("What day do you want? ")
    for member in member_ids:
        if day in board["members"][member]["completion_day_level"]:
            entry = board["members"][member]["completion_day_level"][day]
            
            # correction for EST (UTC - 5)
            times = [datetime.utcfromtimestamp(int(entry[str(i + 1)]['get_star_ts']) - 18000).strftime('%H:%M') for i in range(len(entry))]
        
            print(f"\n{member}:")
            print("\n".join(times))
