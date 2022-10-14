import pymysql

class MemDao:
    
    def __init__(self):
        self.conn = pymysql.connect(
                host='127.0.0.1',
                user='root',
                password='python',
                port=3305,
                db='python',
                charset='utf8'
            )
        
        self.cur = self.conn.cursor(pymysql.cursors.DictCursor)
        
    def select(self, m_seq):
        sql = f"""
            SELECT m_seq
                , m_name
                , tel
                , army_yn 
            FROM member 
            WHERE m_seq = '{m_seq}'"""
        self.cur.execute(sql)

        rows = self.cur.fetchall()
        return rows[0]    
    
    def selects(self):
        sql = 'select m_seq, m_name, tel, army_yn from member'
        self.cur.execute(sql)
        
        rows = self.cur.fetchall()
        return rows
        
    def insert(self, m_name, tel, army_yn):
        sql = f"""
            INSERT INTO member(m_name, tel, army_yn) 
            VALUES('{m_name}','{tel}','{army_yn}')
        """
        cnt = self.cur.execute(sql)
        self.conn.commit()
        return cnt
    
    def update(self, m_name, tel, army_yn):
        sql = f"""
            UPDATE member
            SET m_name='{m_name}'
                , tel='{tel}'
                , army_yn='{army_yn}'
            WHERE m_name = '{m_name}'
        """
        cnt = self.cur.execute(sql)
        self.conn.commit()
        return cnt
        
    def delete(self, m_seq):
        sql = f"""
            DELETE FROM member 
            WHERE m_seq = '{m_seq}'
        """
        cnt = self.cur.execute(sql)
        self.conn.commit()
        return cnt
    
    
    def __del(self):
        self.cur.close()
        self.conn.close()
    
    
    
if __name__ == '__main__':
    ed = MemDao()
    emp = ed.select(4)
    print(emp)  
    
    
    
    
    
    