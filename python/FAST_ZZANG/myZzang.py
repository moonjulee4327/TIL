from fastapi import FastAPI, Form, Request
from fastapi.responses import HTMLResponse
from fastapi.templating import Jinja2Templates
from fastapi.staticfiles import StaticFiles 
from starlette.responses import JSONResponse


app = FastAPI()
templates = Jinja2Templates(directory="templates") 
app.mount("/static", StaticFiles(directory="static"), name="static") 

@app.get("/", response_class=HTMLResponse)
async def zzang(request: Request):
    
    return templates.TemplateResponse("zzang.html", {"request" : request})
