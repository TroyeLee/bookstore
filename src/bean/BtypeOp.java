package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import user.Orders;
import user.Booktype;

public class BtypeOp {
	Connection conn=null;
    PreparedStatement ps=null;
    DBConn dbc=new DBConn();
    ResultSet re=null;
    public Booktype getbtype(){
    	
    	dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
    	String sql="select * from booktype ";
    	Booktype booktype=new Booktype();
    	try {
			ps=conn.prepareStatement(sql);
			re=ps.executeQuery();
	    	ArrayList<String> btypeList=new ArrayList<String>();
	    	while( re.next() ){
				String btype=re.getString(1);
				btypeList.add(btype);
//				System.out.println("here is runing 3: bytpename is " +btype);
			}
	    	booktype.setBooktype(btypeList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return booktype;
    }

}
