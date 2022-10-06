from fastapi import FastAPI,Response, Form
from fastapi.responses import HTMLResponse
from pydantic import BaseModel
import pymysql


app = FastAPI()

 

@app.get("/")
async def root():
    return "Hello Python"

@app.get("/hello", response_class=HTMLResponse)
async def hello():
    return """
    <html>
        <head>
            <title>Some HTML in here</title>
        </head>
        <body>
            <h1>Look ma! HTML!</h1>
        </body>
    </html>
    """
    

    
# @app.get("/dan", response_class=HTMLResponse)
# async def dan(dan: str= ""):
#
#     su = list(range(1,10))
#
#     dans = "";
#
#     for i in su :
#         dans += f"{dan} * {i} = {int(dan)*i}<br>"
#
#     return f"""
#     <html>
#         <head>
#             <title>구구단</title>
#         </head>
#         <body>
#            {dans}
#         </body> 
#     </html>
#     """
    
@app.post("/dan", response_class=HTMLResponse)
async def dan(dan: str = Form()):
    print(dan)
    
    dans = "";
    
    dans += f"{dan} * {1} = {int(dan)*1}<br>"
    dans += f"{dan} * {2} = {int(dan)*2}<br>"
    dans += f"{dan} * {3} = {int(dan)*3}<br>"
    dans += f"{dan} * {4} = {int(dan)*4}<br>"
    dans += f"{dan} * {5} = {int(dan)*5}<br>"
    dans += f"{dan} * {6} = {int(dan)*6}<br>"
    dans += f"{dan} * {7} = {int(dan)*7}<br>"
    dans += f"{dan} * {8} = {int(dan)*8}<br>"
    dans += f"{dan} * {9} = {int(dan)*9}<br>"
        
    return f"""
    <html>
        <head>
            <title>구구단</title>
        </head>
        <body>
           {dans}
        </body> 
    </html>
    """

@app.get("/select", response_class=HTMLResponse)
async def select():
   
    conn = pymysql.connect(host='127.0.0.1',
                       user='root',
                       password='python',
                       port=3305,
                       db='python',
                       charset='utf8')

    cur = conn.cursor()
    
    sql = 'SELECT * FROM emp'
    cur.execute(sql)
    
    rows = cur.fetchall()
    print(rows)
    
    cur.close()
    conn.close()
        
    return f"""
    <html>
        <head>
            <title>구구단</title>
        </head>
        <body>
           {rows}
        </body> 
    </html>
    """

# root = os.path.dirname(os.path.abspath(__file__))
#
# @app.get("/htmlFile")
# async def main():
#     #print(root)
#     with open(os.path.join(root, 'index.html')) as fh:
#         data = fh.read()
#     return Response(content=data, media_type="text/html")

