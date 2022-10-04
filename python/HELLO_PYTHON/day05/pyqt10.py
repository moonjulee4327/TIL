import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from random import random

#.ui 파일 이름이 UIFILE.ui 일때
form_class = uic.loadUiType("pyqt10.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
    
    # 전역변수 선언, 랜덤 숫자 메소드 바로 실행, 문자열 자르기 [fNum:lNum]
    def ranNum(self):
        
        com1 = list(range(1,10))
        
    
        for i in range(100):
            rnd = int(random()*len(com1))
            a = com1[0]
            b = com1[rnd]
            com1[0] = b
            com1[rnd] = a
    
        return com1
    
    
    
    def myclick(self):
        
        com1 = ranNum()
        mine = self.le.text()
        com = str(com1[0]) + str(com1[1]) + str(com1[2])
        sRs = 0
        bRs = 0
        
        print(com)
        
        if (mine[0] == com[0]): sRs += 1
        if (mine[1] == com[1]): sRs += 1
        if (mine[2] == com[2]): sRs += 1


        if (mine[0] == com[1]) or (mine[0] == com[2]):
            bRs += 1 
        if (mine[1] == com[2]) or (mine[1] == com[0]):
            bRs += 1 
        if (mine[2] == com[0]) or (mine[2] == com[1]):
            bRs += 1 
        
        self.te.setText(str(sRs) + "S" + str(bRs) + "B")
        # QMessageBox.about(self, '결과', "승리")
        
##내용 추가

if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()