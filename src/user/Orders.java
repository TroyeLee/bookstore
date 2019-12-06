package user;

public class Orders {
	int oid;
	String user_names ;
	String goods_names ;
	int goods_count  ;
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getUser_names() {
		return user_names;
	}
	public void setUser_names(String User_names) {
		this.user_names =User_names;
	}
	public String getGoods_names() {
		return goods_names;
	}
	public void setGoods_names(String goods_names) {
		this.goods_names = goods_names;
	}
	public int getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}
}
