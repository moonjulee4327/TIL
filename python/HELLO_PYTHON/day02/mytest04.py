# 홀/짝을 입력하시오 
# 나 : 홀
# 컴 : 홀
# 결과 : 승리
from random import random

rs = input("홀/짝을 입력하시오 ")

comRan = random()

#print(comRan)

if comRan > 0.5 :
    comRan = "짝"
else : 
    comRan = "홀"

if rs == comRan :
    print("나 : ", rs)
    print("컴 : ", comRan)
    print("결과 : 승리")
else : 
    print("나 : ", rs)
    print("컴 : ", comRan)
    print("결과 : 패배")

