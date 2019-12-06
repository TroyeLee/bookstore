package bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import user.Book;

public class BookOp {
	Connection conn=null;
    PreparedStatement ps=null;
    DBConn dbc=new DBConn();
    Statement stmt = null;
	public int bookAdd(String bname,String btype,String autho,String press,String Sprice,String Srepertory,String intro,Date times){
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
//        String sql="select COUNT(*) from book where id=?";
//        ResultSet re;

        float price=Float.parseFloat(Sprice);
        int repertory=Integer.parseInt(Srepertory);
//        System.out.println("Sprice is "+price);
//        System.out.println("bname is "+bname);
//        System.out.println("Srepertory is"+repertory);
//        System.out.println("date is "+times);
//        System.out.println("id is "+id);
//        System.out.println("btype is "+btype);
        
        
        
        try {
//			ps=conn.prepareStatement(sql);
//			ps.setString(1, id);
//			re=ps.executeQuery();
//			re.next();
//			if(re.getInt(1)>0) return 2;
//			else 
        	String nid=getNid();
//        	System.out.println("here is running 3 nid is "+nid);
        	{
				String sql="insert into book values (?,?,?,?,?,?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, nid);
				ps.setString(2, bname);
				ps.setString(3, btype);
				ps.setString(4,autho);
				ps.setString(5, press);
				ps.setFloat(6, price);
				ps.setInt(7, repertory);
				ps.setDate(8, times);
				ps.setString(9, intro);
				ps.executeUpdate();
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("add book error");
		}
        return -1;
        
	}
	
	public Book getBook(String id){
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
        String sql="select * from book where id=?";
        ResultSet re;
        Book book=new Book();
        try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			re=ps.executeQuery();
			re.next();
			book.setId(re.getString(1));
			book.setBname(re.getString(2));
			book.setBtype(re.getString(3));
			book.setAutho(re.getString(4));
			book.setPress(re.getString(5));
			book.setPrice(re.getFloat(6));
			book.setRepertory(re.getInt(7));
			book.setTimes(re.getDate(8));
			book.setIntro(re.getString(9));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return book;
	}
	public ArrayList<Book> searchBook(String bname){
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
    	bname="%"+bname+"%";
        String sql="select * from book where bname like '"+bname+"'";
        ResultSet re;
        ArrayList<Book> booklist = new ArrayList<Book>();
        
        try {
			stmt=conn.createStatement();
			re=stmt.executeQuery(sql);
			while(re.next()){
//				System.out.println("here is running 2 bname is"+re.getString(2));
				Book book=new Book();
				book.setId(re.getString(1) );
				book.setBname( re.getString(2));
				book.setBtype( re.getString(3));//类型
				book.setAutho(re.getString(4));//作者
				book.setPress(re.getString(5));//出版社
				book.setPrice(re.getFloat(6));//价格
				book.setRepertory(re.getInt(7));//库存
				book.setTimes(re.getDate(8));//上架时间
				book.setIntro(re.getString(9));//简介
				
				booklist.add(book);
			}
			dbc.Close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return booklist;
	}
	public Book searchBook2(String bname){
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
        String sql="select * from book where bname = ?";
        ResultSet re;
        Book book = new Book();
        
        try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,bname);
			re=ps.executeQuery();
			re.next();
			{
//				System.out.println("here is running 2 bname is"+re.getString(2));
				book.setId(re.getString(1) );
				book.setBname( re.getString(2));
				book.setBtype( re.getString(3));//类型
				book.setAutho(re.getString(4));//作者
				book.setPress(re.getString(5));//出版社
				book.setPrice(re.getFloat(6));//价格
				book.setRepertory(re.getInt(7));//库存
				book.setTimes(re.getDate(8));//上架时间
				book.setIntro(re.getString(9));//简介

			}
			dbc.Close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return book;
	}
	
	public int deleteBook(String id){
		dbc.LoadDatabase();
		conn=dbc.ConnecteDatabase();
		String sql="delete book where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public Book updateBook(Book book1,String bname,String btype,String autho,String press,String Sprice,String Srepertory,String intro){
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
//        String sql="select COUNT(*) from book where id=?";

        float price=Float.parseFloat(Sprice);
        int repertory=Integer.parseInt(Srepertory);
        String sql;
//        System.out.println("Sprice is "+price);
//        System.out.println("bname is "+bname);
//        System.out.println("Srepertory is"+repertory);
//        System.out.println("date is "+times);
//        System.out.println("id is "+id);
//        System.out.println("btype is "+btype);
        String id=book1.getId();
        
        
        try {
//			ps=conn.prepareStatement(sql);
//			ps.setString(1, id);
//			re=ps.executeQuery();
//			re.next();
//			if(re.getInt(1)>0) return 2;
//			else 
//        	String nid=getNid();
//        	System.out.println("here is running 3 nid is "+nid);
        	{
        		if(!bname.equals(book1.getBname()));
        		{
        			book1.setBname(bname);
        			sql="update book set bname=? where id=?";
        			ps=conn.prepareStatement(sql);
        			ps.setString(1, bname);
        			ps.setString(2, id);
        			ps.executeUpdate();
        		}
				if(!book1.getBtype().equals(btype))
				{
					book1.setBtype(btype);
        			sql="update book set btype=? where id=?";
        			ps=conn.prepareStatement(sql);
        			ps.setString(1, btype);
        			ps.setString(2, id);
        			ps.executeUpdate();
				}
				if(!book1.getAutho().equals(autho))
				{
					book1.setAutho(autho);
        			sql="update book set autho=? where id=?";
        			ps=conn.prepareStatement(sql);
        			ps.setString(1, autho);
        			ps.setString(2, id);
        			ps.executeUpdate();
				}
				if(!book1.getPress().equals(press)){
					book1.setPress(press);
        			sql="update book set press=? where id=?";
        			ps=conn.prepareStatement(sql);
        			ps.setString(1, press);
        			ps.setString(2, id);
        			ps.executeUpdate();
				}
				if(book1.getPrice()!=price){
					book1.setPrice(price);
        			sql="update book set price=? where id=?";
        			ps=conn.prepareStatement(sql);
        			ps.setFloat(1, price);
        			ps.setString(2, id);
        			ps.executeUpdate();
				}
				if(book1.getRepertory()!=repertory){
					book1.setRepertory(repertory);
        			sql="update book set repertory=? where id=?";
        			ps=conn.prepareStatement(sql);
        			ps.setInt(1, repertory);
        			ps.setString(2, id);
        			ps.executeUpdate();
				}
				if(!book1.getIntro().equals(intro)){
					book1.setIntro(intro);
        			sql="update book set bname=? where id=?";
        			ps=conn.prepareStatement(sql);
        			ps.setString(1, intro);
        			ps.setString(2, id);
        			ps.executeUpdate();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("add book error");
		}
        return book1;
	}
	
	public String getNid(){
		dbc.LoadDatabase();
		conn=dbc.ConnecteDatabase();
		ResultSet re;
		
		String sql="select top 1 id from book order by id desc";
		
		int count=0;
    	try {
			ps=conn.prepareStatement(sql);
			re=ps.executeQuery();
	    	re.next();
	    		count=Integer.parseInt(re.getString(1));
	    		count+=1;
//	    	System.out.println("here is running 1 count is "+ count );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String tail=""+count;
    	String nid="";
    	while(nid.length()+tail.length()<10){
    		nid+="0";
    	}
    	nid=nid+tail;
 //   	System.out.println("here is running nid is"+nid);
    	return nid;
	}

	public int reduceRepertory(Book book, int count) {
		// TODO Auto-generated method stub
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
    	String sql="update  book set repertory-=? where id=?";
    	try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setString(2,book.getId());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}