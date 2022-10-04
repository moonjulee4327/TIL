import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

#.ui 파일 이름이 UIFILE.ui 일때
form_class = uic.loadUiType("pyqt06.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.le.returnPressed.connect(self.pb.click)
    
    def myclick(self):
        dan = self.le.text()
    
        idan = int(dan)
        su = list(range(1,10))
        
        gugudan = ""
        for i in su :
            gugudan += str(idan) + "*" + str(i) + "=" + str(idan*i) + "\n"
        
        self.te.setText(gugudan)
        
        # 파이썬 3. 대 버전부터 사용가능
        txt = "\n"
        txt += f"{idan}*1={idan*1}\n"
        txt += f"{idan}*2={idan*2}\n"
    
        print("txt", txt)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()