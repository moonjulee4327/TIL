import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

#.ui 파일 이름이 UIFILE.ui 일때
form_class = uic.loadUiType("pyqt03.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
    
    def myclick(self):
        a = self.le1.text()
        b = self.le2.text()
        aa = int(a)
        bb = int(b)
        sum = aa + bb
        self.le3.setText(str(sum))

if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()