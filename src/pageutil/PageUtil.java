package pageutil;

import bean.*;

public class PageUtil{
	
	public static Page createPage(int pageCount, int totalCount, int currentPage){
		pageCount = getPageCount(pageCount);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(pageCount, totalCount);
		int pageBegin = getPageBegin(pageCount, currentPage);
		boolean hasNext = getHasNextPage(totalPage, currentPage);
		boolean hasPre = getHasPrePage(currentPage);
		return new Page(totalCount, pageCount, currentPage, totalPage, pageBegin, hasNext, hasPre);
	}
	
	public static int getPageCount(int pageCount){
		return pageCount == 0 ? 5 : pageCount;  	//Ĭ��ֵΪÿҳ5����¼
	}
	
	public static int getCurrentPage(int currentPage) { //��õ�ǰҳ,Ĭ�ϸ�1
        return currentPage == 0 ? 1 : currentPage;
    }
	
	public static int getTotalPage(int pageCount,int totalCount) {//�����ҳ��
		return totalCount % pageCount == 0 ? totalCount / pageCount : totalCount / pageCount + 1;
	}
	
	public static int getPageBegin(int pageCount,int currentPage) {//�����ʼλ��
        return ( currentPage - 1 ) * pageCount;
    }
	
	public static boolean getHasPrePage(int currentPage) {//�Ƿ�����һҳ
        return currentPage == 1 ? false : true;
    }
    public static boolean getHasNextPage(int totalPage, int currentPage) {  //�Ƿ�����һҳ
        return currentPage == totalPage || totalPage == 0 ? false : true;
    }
}
