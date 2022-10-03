import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

#.ui 파일 이름이 UIFILE.ui 일때
form_class = uic.loadUiType("pyqt01.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
    
    def myclick(self):
        self.lbl.setText("Good Evening")
        
##내용 추가

if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()