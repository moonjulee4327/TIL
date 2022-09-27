# 출력 원하는 난수를 입력하세요

dan = input("단수를 입력하세요 ")
idan = int(dan)

su = list(range(1,10))

for i in su :
    print("{} * {} = {}".format(idan, i, idan*i))