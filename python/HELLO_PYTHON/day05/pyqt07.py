import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from random import random

#.ui 파일 이름이 UIFILE.ui 일때
form_class = uic.loadUiType("pyqt07.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
    
    def myclick(self):
        mine = self.le1.text()
        com = ""
        rs = ""
        comRan = random()
        
        #print(comRan)
        
        if 0.3 > comRan :
            com = "가위"
        elif 0.6 > comRan :
            com = "바위"
        else : 
            com = "보"
        
        if mine == com :
            rs = "비김"
        elif (mine == "가위" and com =="보") | (mine == "바위" and com == "가위") | (mine == "보" and com == "바위"):
            rs = "승리"
        else : 
            rs = "패배"
        
        print(com)
        print(rs)
        self.le2.setText(com)
        self.le3.setText(rs)

if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()