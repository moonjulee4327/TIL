from fastapi import FastAPI, Form, Request
from fastapi.responses import HTMLResponse
from pydantic import BaseModel
from fastapi.templating import Jinja2Templates
from fastapi.staticfiles import StaticFiles 
import pymysql


app = FastAPI()
templates = Jinja2Templates(directory="templates") 
app.mount("/static", StaticFiles(directory="static"), name="static") 
 

@app.get("/hello", response_class=HTMLResponse)
async def read_item(request: Request):
    str = "FastAPI"
    arr = ["홍길동","전우치","이순신"]
    emp = [
        # 연관배열
        {'e_id':'1','e_name':'1','sex':'1','addr':'1',},
        {'e_id':'2','e_name':'2','sex':'2','addr':'2',},
        {'e_id':'3','e_name':'3','sex':'3','addr':'3',}
    ]
    return templates.TemplateResponse("index.html", {"request": request, "str": str, "arr": arr, "emp":emp})



@app.get("/list", response_class=HTMLResponse)
async def select(request: Request):

    conn = pymysql.connect(host='127.0.0.1',
                       user='root',
                       password='python',
                       port=3305,
                       db='python',
                       charset='utf8')

    cur = conn.cursor(pymysql.cursors.DictCursor)

    sql = 'SELECT * FROM emp'
    cur.execute(sql)

    rows = cur.fetchall()
    # print(rows)

    cur.close()
    conn.close()

    return templates.TemplateResponse("index1.html", {"request": request, "rows": rows})

# root = os.path.dirname(os.path.abspath(__file__))
#
# @app.get("/htmlFile")
# async def main():
#     #print(root)
#     with open(os.path.join(root, 'index.html')) as fh:
#         data = fh.read()
#     return Response(content=data, media_type="text/html")

