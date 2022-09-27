from random import random
def getLotto():
    
    # arr45 = [
    # 1,2,3,4,5       ,6,7,8,9,10,
    # 11,12,13,14,15  ,16,17,18,19,20,
    # 21,22,23,24,25  ,26,27,28,29,30,
    # 31,32,33,34,35  ,36,37,38,39,40,
    # 41,42,43,44,45 
    # ]

    # arr45 = range(1,45+1)
    
    
    lotto = list(range(1,46))
    
    for i in range(100) :
        rnd = int(random()*len(lotto))
        a = lotto[0]
        b = lotto[rnd]
        lotto[0] = b
        lotto[rnd] = a
    
    return lotto[0:6]


arr6 = getLotto()
print(arr6)