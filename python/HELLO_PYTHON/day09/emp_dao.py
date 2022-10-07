import pymysql

class EmpDao:
    
    def __init__(self):
        self.conn = pymysql.connect(host='127.0.0.1',
                       user='root',
                       password='python',
                       port=3305,
                       db='python',
                       charset='utf8')

        self.cur = self.conn.cursor(pymysql.cursors.DictCursor)
    
    def select(self, e_id):
        sql = f"""
            SELECT e_id
                , e_name
                , sex
                , addr 
            FROM emp 
            WHERE e_id = '{e_id}'"""
        self.cur.execute(sql)

        rows = self.cur.fetchall()
        return rows[0]
    
    def selects(self):
        sql = 'SELECT e_id, e_name, sex, addr FROM emp'
        self.cur.execute(sql)

        rows = self.cur.fetchall()
        return rows
    
    def insert(self, e_id, e_name, sex, addr):
        sql = f"""
            INSERT INTO emp(e_id, e_name, sex, addr) 
            VALUES('{e_id}','{e_name}','{sex}','{addr}')
        """
        cnt = self.cur.execute(sql)
        self.conn.commit()
        return cnt
    
    def update(self, e_id, e_name, sex, addr):
        sql = f"""
            UPDATE emp
            SET '{e_name}'
                , '{sex}'
                , '{addr}'
            WHERE e_id = '{e_id}'
        """
        cnt = self.cur.execute(sql)
        self.conn.commit()
        return cnt
    
    def delete(self, e_id):
        sql = f"""
            DELETE FROM emp 
            WHERE e_id = '{e_id}'
        """
        cnt = self.cur.execute(sql)
        self.conn.commit()
        return cnt
    
    def __del(self):
        self.cur.close()
        self.conn.close()
        
if __name__ == '__main__':
    ed = EmpDao()
    emp = ed.insert(7,7,7,7)
    print(emp)