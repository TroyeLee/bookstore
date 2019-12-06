package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import user.*;

public class UpdateOp {
	Connection conn=null;
    PreparedStatement ps=null;
    DBConn dbc=new DBConn();
	public int resetPsw(String logname,String utype,String passwd){
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
//    	ResultSet re;
    	int flag=0;
		String sql= "update userid set passwd=? where logname = ? and utype = ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, passwd);
			ps.setString(2, logname);
			ps.setString(3, utype);
			 flag = ps.executeUpdate();
			dbc.Close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	public int updateData(User user1,User user2){
		dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
//    	ResultSet re;
	    String sql="";
	    int flag=0;
	    try {
			if(!user1.getLogname().equals(user2.getLogname())){
				sql="update userid set logname=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getLogname());
				ps.setString(2, user1.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
			}
			if(!user1.getRealname().equals(user2.getRealname())){
				sql="update userid set realname=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getRealname());
				ps.setString(2, user2.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
			}
			if(!user1.getEmail().equals(user2.getEmail())){
				sql="update userid set email=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getEmail());
				ps.setString(2, user2.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
			}
			if(!user1.getGender().equals(user2.getGender())){
				sql="update userid set gendere=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getGender());
				ps.setString(2, user2.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
			}
			if(!user1.getUaddress().equals(user2.getUaddress())){
				sql="update userid set uaddress=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getUaddress());
				ps.setString(2, user2.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
			}
			if(!user1.getPhone().equals(user2.getPhone())){
				sql="update userid set phone=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getPhone());
				ps.setString(2, user2.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
				}
			if(!user1.getAnswer().equals(user2.getAnswer())){
				sql="update userid set answer=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getAnswer());
				ps.setString(2, user2.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
				}
			if(!user1.getProvince().equals(user2.getProvince())){
				sql="update userid set province=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getProvince());
				ps.setString(2, user2.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
				}
			if(!user1.getEducation().equals(user2.getEducation())){
				sql="update userid set education=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getEducation());
				ps.setString(2, user2.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
		}
			if(!user1.getHobbies().equals(user2.getHobbies())){
				sql="update userid set hobbies=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getHobbies());
				ps.setString(2, user2.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
		}
			if(!user1.getSelfintro().equals(user2.getSelfintro())){
				sql="update userid set selfintro=? where logname=? and utype=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, user2.getSelfintro());
				ps.setString(2, user2.getLogname());
				ps.setString(3, user1.getUtype());
				ps.executeUpdate();
		}
			flag=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=0;
		}
		
		
		return flag;
	}

}
