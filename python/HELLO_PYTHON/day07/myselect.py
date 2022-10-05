import pymysql

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
