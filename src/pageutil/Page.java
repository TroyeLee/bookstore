package pageutil;

public class Page {
	
	int totalCount;		//�ܼ�¼��
	int pageCount;		//ÿҳ��¼������
	int currentPage;	//��ǰҳ��
	int totalPage;		//������ҳ��
	int pageBegin;		//ÿҳ��ʼ��¼�ı��
	boolean hasNext;	//�Ƿ�����һҳ
	boolean hasPre;		//�Ƿ�����һҳ
	
	public Page(int totalCount, int pageCount, int currentPage, int totalPage, int pageBegin, boolean hasNext, boolean hasPre ){
		 this.totalCount = totalCount;
		 this.pageCount = pageCount;
		 this.currentPage = currentPage;
		 this.totalPage = totalPage;
		 this.pageBegin = pageBegin;
		 this.hasNext = hasNext;
		 this.hasPre = hasPre;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public boolean isHasPre() {
		return hasPre;
	}
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
}


