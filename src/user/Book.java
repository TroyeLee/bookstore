package user;

import java.sql.Date;

public class Book {
	String id ;
	String bname ;
	String btype ;//����
	String autho ;//����
	String press ;//������
	float price ;//�۸�
	int repertory ;//��� 
	Date times ;//�ϼ�ʱ��
	String intro ;//���
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getAutho() {
		return autho;
	}
	public void setAutho(String autho) {
		this.autho = autho;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getRepertory() {
		return repertory;
	}
	public void setRepertory(int repertory) {
		this.repertory = repertory;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}


}
