import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

#.ui 파일 이름이 UIFILE.ui 일때
form_class = uic.loadUiType("pyqt08.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)

    def drawStar(self,cnt):
        str = ""
        
        for i in range(cnt):
            str += "*"
        str += "\n"
        return str
    
    def myclick(self):
        intFirst = int(self.le_first.text())
        intLast = int(self.le_last.text())
        
        star = ""
        
        arr = range(intFirst, intLast+1)
        for i in arr:
            star += self.drawStar(i)
        
        self.te.setText(star)
        
            
        

if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()