class Animal:
    
    def __init__(self):
        self.hungry = 5
    
    def timegoby(self):
        if self.hungry > 0:
            self.hungry -= 1
        
        return self.hungry
    
    def manttang(self):
        self.hungry = 10

ani = Animal()

print(ani.hungry)
ani.timegoby()
ani.manttang()
print(ani.hungry)


class Human(Animal):
    
    def __init__(self):
        super(Human, self).__init__()
        self.skillLang = 0
    
    def momstouch(self, stroke):
        self.skillLang += stroke
        return self.skillLang
    

hu = Human()

print(hu.hungry)
print(hu.skillLang)
hu.timegoby()
hu.momstouch(5)
print(hu.hungry)
print(hu.skillLang)
