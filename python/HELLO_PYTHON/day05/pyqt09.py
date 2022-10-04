import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

#.ui 파일 이름이 UIFILE.ui 일때
form_class = uic.loadUiType("pyqt09.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        # self.pb.clicked.connect(self.myclick)
        
        # self.pb1.clicked.connect(lambda: self.c1(self.pb1.text()))
        
        self.pb1.clicked.connect(self.myclick)
        self.pb2.clicked.connect(self.myclick)
        self.pb3.clicked.connect(self.myclick)
        self.pb4.clicked.connect(self.myclick)
        self.pb5.clicked.connect(self.myclick)
        self.pb6.clicked.connect(self.myclick)
        self.pb7.clicked.connect(self.myclick)
        self.pb8.clicked.connect(self.myclick)
        self.pb9.clicked.connect(self.myclick)
        self.pb0.clicked.connect(self.myclick)
        self.pb.clicked.connect(self.myCall)
    
    def myCall(self):
        str_tel = self.le.text()
        QMessageBox.about(self, 'calling', "calling " + str_tel)
    
    def myclick(self):
        str_new = self.sender().text()
        str_old = self.le.text()
        
        self.le.setText(str_old + str_new)
    
    # def c1(self, str):
    #     self.le.setText(str)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()