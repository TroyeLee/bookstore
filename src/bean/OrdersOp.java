package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import user.*;

public class OrdersOp {
	Connection conn=null;
    PreparedStatement ps=null;
    DBConn dbc=new DBConn();
	public int addOrders(String logname,String bname,int count){
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
    	ResultSet re;
    	String sql="select count(*) from orders where user_names=? and goods_names=? ";
    	int flag=0;
    	System.out.println("here is running1 flag is "+flag);
    	try {
//    		System.out.println("here is running2 ");
			ps=conn.prepareStatement(sql);
			ps.setString(1,logname);
	    	ps.setString(2, bname);
	    	re=ps.executeQuery();
	    	re.next();
	    	flag=re.getInt(1);
//	    	System.out.println("here is runing 3 flag is"+flag);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	if(flag>0){
 //   		System.out.println("here is running 4 falg is"+flag);
    		sql="update orders set goods_count+=? where user_names=? and goods_names=?";
    		try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, count);
				ps.setString(2, logname);
				ps.setString(3,bname);
				ps.executeUpdate();
				return 1;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("add orders fails2");
			}
    	}
    	
    	
    	else{
    		 sql="insert into orders values (?,?,?,?)";
//    		 System.out.println("here is running 5 flag is "+flag);
    		 int id=getid();
    		try {
    			ps=conn.prepareStatement(sql);
    			
    			System.out.println("here is running 1 id= "+id);
    			ps.setInt(1, id);
    			ps.setString(2, logname);
    			ps.setString(3, bname);
    			ps.setInt(4, count);
    			ps.executeUpdate();
    			return 1;
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			System.out.print("add orders fails1");
    		}
    	}
		return -1;
	}
	
	public int deleteOrders(String Oid){
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
    	String sql="delete orders where Oid=?";
    	int id=Integer.parseInt(Oid);
    	try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return -1;
		
	}
	public String getBname(String Oid){
		dbc.LoadDatabase();
		conn=dbc.ConnecteDatabase();
		ResultSet re;
		int id=Integer.parseInt(Oid);
		String sql="select goods_names from orders where oid=?";
		String bname="";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			re=ps.executeQuery();
			if(re.next())
				bname=re.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bname;
	}
	
	public int getid(){
		dbc.LoadDatabase();
		conn=dbc.ConnecteDatabase();
		ResultSet re;
		
		String sql="select top 1 Oid from orders order by Oid desc";
		
		int count=0;
    	try {
			ps=conn.prepareStatement(sql);
			re=ps.executeQuery();
	    	if(re.next())
	    		count=Integer.parseInt(re.getString(1));
	    		count+=1;
	    	System.out.println("here is running 1 count is "+ count );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getid faild");
		}
//   	System.out.println("here is running nid is"+nid);
    	return count;
	}

}
