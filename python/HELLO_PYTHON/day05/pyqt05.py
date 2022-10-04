import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from random import random

#.ui 파일 이름이 UIFILE.ui 일때
form_class = uic.loadUiType("pyqt05.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.leMine.returnPressed.connect(self.pb.click)
    
    def myclick(self):
        me = self.leMine.text()
        com = ""
        result = ""
        
        comRan = random()

        #print(comRan)
        
        if comRan > 0.5 :
            com = "짝"
        else : 
            com = "홀"
        
        if me == com :
            # self.leCom.setText(comRan)
            # self.leRs.setText("승리")
            result = "승리"

        else : 
            # self.leCom.setText(comRan)
            # self.leRs.setText("패배")
            result = "패배"

        self.leCom.setText(com)
        self.leRs.setText(result)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()