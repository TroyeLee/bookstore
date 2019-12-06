package bean;

//import java.io.UnsupportedEncodingException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.User;

public class ChkLogin {
	Connection conn=null;
    PreparedStatement ps=null;
    DBConn dbc=new DBConn();
   
    public int Login(String logname,String passwd,String utype){        //登录
    	dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();

        String sql="select COUNT(*) from userid where logname=? and utype=?";
        ResultSet re;
        
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,logname);
            ps.setString(2, utype);
            re=ps.executeQuery();
            re.next();
            if(re.getInt(1)>0){
                sql="select COUNT(*) from userid where logname=? and passwd=?";//
                ps=conn.prepareStatement(sql);         //
                ps.setString(1, logname);             //
//                String userpwd_e=Encryption(passwd);  //调用加密函数
//                ps.setString(2, userpwd_e);
                ps.setString(2, passwd);

                re=ps.executeQuery();
                re.next();
//                System.out.println(re.getInt(1));
                if(re.getInt(1)>0)
                return 1; //弹出窗口,登陆成功
                else return 2;//弹出窗口，密码错误
                
            }
            else return 3;//    "用户不存在"

        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            System.out.println("Login error");
        }
        dbc.Close();
        return 0;
    }
    
//    public String getProblem(String logname,String utype){
//    	dbc.LoadDatabase();
//    	conn=dbc.ConnecteDatabase();
////    	System.out.println("Loagining........");
////    	System.out.println(utype);
//        String sql="select * from userid where logname=? and utype=? ";
//        ResultSet re;
//        
//        try {
//            ps=conn.prepareStatement(sql);
//            ps.setString(1,logname);
//            ps.setString(2, utype);
//
//            re=ps.executeQuery();
//            ;
//            if(re.next()){
//                
//                return re.getString(8);
//                
//            }
//
//        } catch (SQLException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//            System.out.println("error2");
//        }
//        dbc.Close();
//        return "null";
//    }
//    public int chkAnswer(String logname,String utype,String answer){
//    	dbc.LoadDatabase();
//    	conn=dbc.ConnecteDatabase();
////    	System.out.println("Loagining........");
////    	System.out.println(utype);
//        String sql="select COUNT(*) from userid where logname=? and utype=?";
//        ResultSet re;
//        
//        try {
//            ps=conn.prepareStatement(sql);
//            ps.setString(1,logname);
//            ps.setString(2, utype);
//            re=ps.executeQuery();
//            re.next();
//            if(re.getInt(1)>0){
//                sql="select problem from userid where logname=? and answer=?";//
//                ps=conn.prepareStatement(sql);         //
//                ps.setString(1, logname);             //
//                ps.setString(2, answer);
//                re=ps.executeQuery();
//                re.next();
//                if(re.getInt(1)>0)
//                return 1;//回答正确
//                else return 2;//回答错误
//                
//            }
//
//        } catch (SQLException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//            System.out.println("error2");
//        }
//        dbc.Close();
//        return 0;
//    }
    
    public User getUser(String logname,String utype){
    	dbc.LoadDatabase();
    	conn=dbc.ConnecteDatabase();
        String sql="select * from userid where logname=? and utype=?";
        ResultSet re;
        User user =new User();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,logname);
            ps.setString(2, utype);
            re=ps.executeQuery();
            re.next();         
            user.setLogname(re.getString(1));
            user.setRealname(re.getString(2));
            user.setPasswd(re.getString(3));
            user.setEmail(re.getString(4));
            user.setGender(re.getString(5));
            user.setUaddress(re.getString(6));
            user.setPhone(re.getString(7));
            user.setProblem(re.getString(8));
            user.setAnswer(re.getString(9));
            user.setProvince(re.getString(10));
            user.setEducation(re.getString(11));
            user.setHobbies(re.getString(12));
            user.setSelfintro(re.getString(13));
            user.setUtype(re.getString(14));
            System.out.println(user.getLogname());
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            System.out.println("Login error");
        }
        dbc.Close();
        return user;
    	
    }
//    public String Encryption(String passwd){//加密
//        String userpwd_e="";
//        try {
//            MessageDigest md5=MessageDigest.getInstance("MD5");
//            byte data[];
//            data=passwd.trim().getBytes("UTF-8");
//            userpwd_e=new String(md5.digest(),"UTF-8");
////             BASE64Encoder base64en = new BASE64Encoder();//加密后的字符串
////             userpwd_e=base64en.encode(md5.digest(userpwd.trim().getBytes("utf-8")));
//           System.out.println("encryption success,userpwd="+passwd+"userpwd_e="+userpwd_e);
//        } catch (NoSuchAlgorithmException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//            System.out.println("MD5 error");
//            return passwd;
//        } catch (UnsupportedEncodingException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//            System.out.println("encryption error");
//            return passwd;
//        }
//        
//        return userpwd_e;
//        
//    }

}
