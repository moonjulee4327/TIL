from fastapi import FastAPI, Form, Request
from fastapi.responses import HTMLResponse
from fastapi.templating import Jinja2Templates
from fastapi.staticfiles import StaticFiles 
from starlette.responses import JSONResponse
from emp_dao import EmpDao
from pydantic import BaseModel

class Emp(BaseModel):
    e_id: str = None
    e_name: str = None
    sex: str = None
    addr: str = None


app = FastAPI()
templates = Jinja2Templates(directory="templates") 
app.mount("/static", StaticFiles(directory="static"), name="static") 

@app.get("/emp", response_class=HTMLResponse)
async def emp_list(request: Request):
    
    return templates.TemplateResponse("emp.html", {"request": request})


@app.get("/emp_selects")
async def emp_selects():
    ed = EmpDao()
    emps = ed.selects()
    return JSONResponse(emps)

@app.post("/emp_select")
async def emp_select(emp:Emp):
    ed = EmpDao()
    emp = ed.select(emp.e_id)
    return JSONResponse(emp)

@app.post("/emp_insert")
async def emp_insert(emp:Emp):
    ed = EmpDao()
    cnt = ed.insert(emp.e_id, emp.e_name, emp.sex, emp.addr)
    return JSONResponse(cnt)

@app.post("/emp_update")
async def emp_update(emp:Emp):
    ed = EmpDao()
    cnt = ed.update(emp.e_id, emp.e_name, emp.sex, emp.addr)
    return JSONResponse(cnt)

@app.post("/emp_delete")
async def emp_delete(emp:Emp):
    ed = EmpDao()
    cnt = ed.delete(emp.e_id)
    return JSONResponse(cnt)