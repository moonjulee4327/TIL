# 첫수를 넣으세요
# 끝수를 넣으세요

a = input("첫수를 넣으세요 ")
b = input("끝수를 넣으세요 ")



array = list(range(int(a),int(b)+1))
sum = 0

for i in array:
    sum += i


print("{}에서 {}까지의 합은 {}입니다.".format(a, b, sum))