package bean;


import java.sql.*;

public class DBConn {
	Connection conn=null;
//    PreparedStatement ps=null;
	public void LoadDatabase(){
		
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Load database success");
        } catch (ClassNotFoundException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
            System.out.println("Load database faild");
        }
        
    }
    public Connection ConnecteDatabase(){
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=bookStore";
        try {
            conn=DriverManager.getConnection(url,"bookstore","987654321");
            System.out.println("connecte database success");
        } catch (SQLException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
            System.out.println("Connection database faild");
        }
        return conn;
    }

    public void Close(){
        try {
            conn.close();
            System.out.println("connection is closed");
        } catch (SQLException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }    
    }
//	private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
//	private static String user = "root";
//	private static String password = "123456";
//
//	static Connection conn = null;
//
//	public static Connection getConn() {
//
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		} catch (Exception e) {
//			System.out.println("��������ʧ��");
//		}
//
//		try {
//			conn=DriverManager.getConnection(url,"sa","thisispassword");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("��ȡ����error");
//			e.printStackTrace();
//		}
//
//		return conn;
//
//	}
//
//	public static void closeConn() {
//		if (conn != null)
//
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
}
