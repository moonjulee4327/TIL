# 첫수를 넣으세요 2
# 끝수를 넣으세요 4
# 배수를 넣으세요 3

# 2에서 4까지 3의 배수의 합은 3입니다.

a = input("첫수를 넣으세요 ")
b = input("끝수를 넣으세요 ")
c = input("배수를 넣으세요 ")
sum = 0

arr = list(range(int(a), int(b)+1))

for i in arr :
    if i % int(c) == 0 : 
        sum += i
    else :
        pass

print("{}에서 {}까지 {}의 배수의 합은 {}입니다.".format(a, b, c, sum))
