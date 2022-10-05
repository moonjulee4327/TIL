import pymysql

conn = pymysql.connect(host='localhost',
                       user='root',
                       password='python',
                       port=3305,
                       db='python',
                       charset='utf8')

curs = conn.cursor()

sql = """insert into emp(e_id, e_name, sex, addr) values(%s, %s, %s, %s)"""


# emp = [
#         (3,3,3,3),
#         (3,3,3,3)
#     ]

cnt = curs.execute(sql,("3","3","3","3"))
# cnts = curs.executemany(sql,emp)
print("cnt ", cnt);
# print("cnts ", cnts);


conn.commit()
curs.close()
conn.close()