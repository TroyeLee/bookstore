package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindOp {
	Connection conn=null;
    PreparedStatement ps=null;
    DBConn dbc=new DBConn();
	
	 public String getProblem(String logname,String utype){
	    	dbc.LoadDatabase();
	    	conn=dbc.ConnecteDatabase();
//	    	System.out.println("Loagining........");
//	    	System.out.println(utype);
	        String sql="select * from userid where logname=? and utype=? ";
	        ResultSet re;
	        
	        try {
	            ps=conn.prepareStatement(sql);
	            ps.setString(1,logname);
	            ps.setString(2, utype);

	            re=ps.executeQuery();
	            if(re.next()){
	                
	                return re.getString(8);
	                
	            }

	        } catch (SQLException e) {
	            // TODO 自动生成的 catch 块
	            e.printStackTrace();
	            System.out.println("error2");
	        }
	        dbc.Close();
	        return "null";
	    }
	    public int chkAnswer(String logname,String utype,String answer){
	    	dbc.LoadDatabase();
	    	conn=dbc.ConnecteDatabase();
//	    	System.out.println("Loagining........");
//	    	System.out.println(utype);
	        ResultSet re;
	        String sql="select answer from userid where logname=? and utype=?";//
	        
	        try {
	            ps=conn.prepareStatement(sql);
	            ps.setString(1,logname);
	            ps.setString(2, utype);
	            re=ps.executeQuery();
	            re.next();
//	            System.out.println("the real answer is:"+re.getString(1)+re.getString(1).length()+answer);
	            if(re.getString(1).equalsIgnoreCase(answer))
	                return 1;//回答正确
	                else return 2;//回答错误
	                

	        } catch (SQLException e) {
	            // TODO 自动生成的 catch 块
	            e.printStackTrace();
	            System.out.println("error2");
	        }
	        dbc.Close();
	        return 0;
	    }

}
