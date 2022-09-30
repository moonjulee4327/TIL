import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from random import random

#.ui 파일 이름이 UIFILE.ui 일때
form_class = uic.loadUiType("pyqt04.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
    
    def myclick(self):
        lotto = list(range(1,46))
    
        for i in range(100) :
            rnd = int(random()*len(lotto))
            a = lotto[0]
            b = lotto[rnd]
            lotto[0] = b
            lotto[rnd] = a
        print(lotto[0:6])
        
        self.le1.setText(str(lotto[0]));
        self.le2.setText(str(lotto[1]));
        self.le3.setText(str(lotto[2]));
        self.le4.setText(str(lotto[3]));
        self.le5.setText(str(lotto[4]));
        self.le6.setText(str(lotto[5]));
        #return lotto[0:6]
        


if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()