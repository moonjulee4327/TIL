from fastapi import FastAPI, Form, Request
from fastapi.responses import HTMLResponse
from pydantic import BaseModel
from fastapi.templating import Jinja2Templates
from fastapi.staticfiles import StaticFiles 
import pymysql
from emp_dao import EmpDao



app = FastAPI()
templates = Jinja2Templates(directory="templates") 
app.mount("/static", StaticFiles(directory="static"), name="static") 

@app.get("/", response_class=HTMLResponse)
@app.get("/emp_list", response_class=HTMLResponse)
async def selects(request: Request):
    
    ed = EmpDao()
    rows = ed.selects()
    
    return templates.TemplateResponse("emp_list.html", {"request": request, "rows": rows})


@app.get("/emp_detail", response_class=HTMLResponse)
async def select(request: Request, e_id : str):

    print(e_id)
    ed = EmpDao()
    rows = ed.select(e_id)
    
    return templates.TemplateResponse("emp_detail.html", {"request": request, "rows": rows})

@app.get("/emp_mod", response_class=HTMLResponse)
async def detail(request: Request, e_id : str):

    print(e_id)
    ed = EmpDao()
    rows = ed.select(e_id)
    
    return templates.TemplateResponse("emp_mod.html", {"request": request, "rows": rows})

@app.post("/emp_mod_act", response_class=HTMLResponse)
async def update(request: Request, e_id : str = Form(), e_name : str = Form(), sex : str = Form(), addr : str = Form()):

    print(e_id)
    ed = EmpDao()
    rows = ed.update(e_id, e_name, sex, addr)
    
    return templates.TemplateResponse("emp_mod_act.html", {"request": request, "rows": rows})



@app.get("/emp_addForm", response_class=HTMLResponse)
async def insertForm(request: Request):

    return templates.TemplateResponse("emp_add.html", {"request": request})

@app.post("/emp_add", response_class=HTMLResponse)
async def insert(request: Request, e_id : str = Form(), e_name : str = Form(), sex : str = Form(), addr : str = Form()):

    print(e_id)
    ed = EmpDao()
    rows = ed.insert(e_id, e_name, sex, addr)
    
    return templates.TemplateResponse("/emp_add_act.html", {"request": request, "rows": rows})


@app.post("/emp_delete", response_class=HTMLResponse)
async def delete(request: Request, e_id: str=Form()):
    
    print(e_id)
    ed = EmpDao()
    rows = ed.delete(e_id)
    
    return templates.TemplateResponse("/emp_delete_act.html", {"request": request, "rows": rows})


# root = os.path.dirname(os.path.abspath(__file__))
#
# @app.get("/htmlFile")
# async def main():
#     #print(root)
#     with open(os.path.join(root, 'index.html')) as fh:
#         data = fh.read()
#     return Response(content=data, media_type="text/html")

