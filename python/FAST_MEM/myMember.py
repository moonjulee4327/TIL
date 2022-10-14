from fastapi import FastAPI, Form, Request
from fastapi.responses import HTMLResponse
from fastapi.templating import Jinja2Templates
from fastapi.staticfiles import StaticFiles 
from starlette.responses import JSONResponse
from memDao import MemDao
from pydantic import BaseModel

class Mem(BaseModel):
    m_seq: str = None
    m_name: str = None
    tel: str = None
    army_yn: str = None


app = FastAPI()
templates = Jinja2Templates(directory="templates") 
app.mount("/static", StaticFiles(directory="static"), name="static") 

@app.get("/mem", response_class=HTMLResponse)
async def mem_list(request: Request):
    
    return templates.TemplateResponse("mem.html", {"request" : request})


@app.get("/mem_selects")
async def mem_selects():
    mem = MemDao()
    mems = mem.selects()
    return JSONResponse(mems)


@app.post("/mem_select")
async def mem_select(mem:Mem):
    ed = MemDao()
    emp = ed.select(mem.m_seq)
    return JSONResponse(emp)

@app.post("/mem_insert")
async def mem_insert(mem:Mem):
    ed = MemDao()
    cnt = ed.insert(mem.m_name, mem.tel, mem.army_yn)
    return JSONResponse(cnt)

@app.post("/mem_update")
async def mem_update(mem:Mem):
    ed = MemDao()
    cnt = ed.update(mem.m_name, mem.tel, mem.army_yn)
    return JSONResponse(cnt)

@app.post("/mem_delete")
async def mem_delete(mem:Mem):
    ed = MemDao()
    cnt = ed.delete(mem.m_seq)
    return JSONResponse(cnt)