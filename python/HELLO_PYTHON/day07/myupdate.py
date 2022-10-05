import pymysql

e_id = "2"
e_name = "5"
sex = "5"
addr = "6"

conn = pymysql.connect(host='localhost',
                       user='root',
                       password='python',
                       port=3305,
                       db='python',
                       charset='utf8')

curs = conn.cursor()

sql = f"""  update emp 
            set e_id = '{e_id}', e_name = '{e_name}', sex = '{sex}', addr = '{addr}' 
            where e_id = '{e_id}'
        """


# emp = [
#         (3,3,3,3),
#         (3,3,3,3)
#     ]

cnt = curs.execute(sql)
# cnts = curs.executemany(sql,emp)
print("cnt ", cnt);
# print("cnts ", cnts);


conn.commit()
curs.close()
conn.close()