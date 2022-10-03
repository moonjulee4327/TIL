class Korea:
    
    def __init__(self):
        self.kFood = 100
        
    def makeFood(self):
        self.kFood += 1

class America:
    
    def __init__(self):
        self.usFood = 100
        
    def lostFood(self):
        self.usFood -= 1

class Food(Korea, America):
    
    def __init__(self):
        Korea.__init__(self)
        America.__init__(self)
        
        


fd = Food()

print(fd.kFood)
print(fd.usFood)
fd.makeFood()
fd.lostFood()
print(fd.kFood)
print(fd.usFood)