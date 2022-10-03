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
    
    def myclick(self):
        me = self.leMine.text()
        
        comRan = random()

        #print(comRan)
        
        if comRan > 0.5 :
            comRan = "짝"
        else : 
            comRan = "홀"
        
        if me == comRan :
            self.leCom.setText(comRan)
            self.leRs.setText("승리")

        else : 
            self.leCom.setText(comRan)
            self.leRs.setText("패배")


        


if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()