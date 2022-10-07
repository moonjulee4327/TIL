# from fastapi import FastAPI, Form, Request
# from fastapi.responses import HTMLResponse
# from pydantic import BaseModel
# from fastapi.templating import Jinja2Templates
# from fastapi.staticfiles import StaticFiles 
# import pymysql
# from day09.emp_dao import EmpDao
#
#
#
#
# app = FastAPI()
# templates = Jinja2Templates(directory="templates") 
# app.mount("/static", StaticFiles(directory="static"), name="static") 
#
#
# @app.get("/emp_list", response_class=HTMLResponse)
# async def selects(request: Request):
#
#     ed = EmpDao()
#     emps = ed.selects()
#
#     return templates.TemplateResponse("emp_list.html", {"request": request, "emps": emps})
#
# @app.get("/emp_add", response_class=HTMLResponse)
# async def insert(request: Request):
#
#     return "hello"



# root = os.path.dirname(os.path.abspath(__file__))
#
# @app.get("/htmlFile")
# async def main():
#     #print(root)
#     with open(os.path.join(root, 'index.html')) as fh:
#         data = fh.read()
#     return Response(content=data, media_type="text/html")

