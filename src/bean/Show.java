package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import user.*;

public class Show {
	Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs = null;
    Statement stmt = null;
    DBConn dbc=new DBConn();
    
    public int getCount(){
    	dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
        String sql = "select count(*) from book";	
		int flag = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next())
				flag = rs.getInt(1);
			
			dbc.Close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
    }
    public int getCount2(String logname){
    	dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
        String sql = "select count(*) from orders where user_names= ?";	
		int flag = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, logname);
			rs = ps.executeQuery();
			
			if(rs.next())
				flag = rs.getInt(1);
			
			dbc.Close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
    }
    public ArrayList<Book> getBook(int currentPage, int pageCount){

//    	String sql="select * from book limit ?,?";
    	
    	int number=currentPage*pageCount;
    	
		String sql = "select * from book b where id in("+
				     "select top "+pageCount+" id from("+
					 "select top "+number+" id from book order by id asc )"+
					 "bb order by bb.id desc) order by b.id asc";
//		String sql="select * from book order by bname";
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
		
		ArrayList<Book> blist = new ArrayList<Book>();
		
//		System.out.println("here is runing 1;number is "+currentPage+"pageCount is "+pageCount+"number is "+number);
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
//			System.out.println("here is runing 2; sql is "+sql);
			while( rs.next() ){
				Book book = new Book();
				book.setId(rs.getString(1) );
				book.setBname( rs.getString(2));
				book.setBtype( rs.getString(3));//类型
				book.setAutho(rs.getString(4));//作者
				book.setPress(rs.getString(5));//出版社
				book.setPrice(rs.getFloat(6));//价格
				book.setRepertory(rs.getInt(7));//库存
				book.setTimes(rs.getDate(8));//上架时间
				book.setIntro(rs.getString(9));//简介
				
				blist.add(book);
//				System.out.println("here is runing 3: bookname is " +book.getBname());
			}
			
			dbc.Close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return blist;
    }
    
    public ArrayList<Orders> getOrders(int currentPage, int pageCount,String logname){

//    	String sql="select * from book limit ?,?";
    	
    	dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
    	
    	String sql="select count(*) from orders where user_names=?";
    	int flag=1;
    	try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, logname);
			rs = ps.executeQuery();
	    	rs.next();
	    	flag=rs.getInt(1);
//	    	System.out.println("here is running 1 flag="+flag);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	if(flag>0){
    		int number=currentPage*pageCount;
    	
    		sql = "select * from orders o where user_names in("+
				     "select top "+pageCount+" user_names from("+
					 "select top "+number+" user_names from orders order by user_names asc )"+
					 "oo order by oo.user_names desc) and user_names='"+logname+"'";
    		ArrayList<Orders> Olist = new ArrayList<Orders>();
		
//		System.out.println("here is runing 1;number is "+currentPage+"pageCount is "+pageCount+"number is "+number);
		
    		try {
    			stmt = conn.createStatement();
    			rs = stmt.executeQuery(sql);
			
//    			System.out.println("here is runing 2; sql is "+sql);
    			while( rs.next() ){
    				System.out.println("here is running getorderA Oid="+rs.getInt(1));
    				Orders order=new Orders();
    				order.setOid(rs.getInt(1));
    				
    				order.setUser_names(rs.getString(2));
    				order.setGoods_names(rs.getString(3));
    				order.setGoods_count(rs.getInt(4));
    				System.out.println("here is running order.get()"+order.getOid()+order.getGoods_names()+order.getGoods_count()+order.getUser_names());
    				Olist.add(order);
//    				System.out.println("here is runing 3: goodscount is " +order.getGoods_count());
    			}
    			
			
    			dbc.Close();
			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
	
    		return Olist;
    	}
    	return null;
    }

}
