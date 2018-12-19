package minilib.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import minilib.dao.ManageTitlesDao;

import minilib.vo.Title;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ManageTitlesAction extends ActionSupport {
	private Title book; 
	public Title getBook() {
		return book;
	}
	public void setBook(Title book) {
		this.book = book;
	}
	
	public String findBookType() throws Exception{
		ManageTitlesDao mttype=new ManageTitlesDao();
		List allTypeList=mttype.findBookType();//返回放到一个列表里
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("allTypeList", allTypeList);
		System.out.println("findBookType");
		return "booktype";
	}
	
	public String addTitle()throws Exception{
		ManageTitlesDao mtadd=new ManageTitlesDao();
		mtadd.addTitle(book);  
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("message","添加成功请继续添加！");
		System.out.println("addbookTitles"+book.getTypeid()+book.getTitle());
		return "addbook";
	}

	public String deleteTitle() throws Exception{
		ManageTitlesDao mt = new ManageTitlesDao();
	    mt.deleteTitle(book.getTitle());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("deleteTitle", "删除成功！");
		System.out.println("deletebook");
		return "deletebook";
	}
	
	public String findTitles()throws Exception{
		ManageTitlesDao mt=new ManageTitlesDao();
		List TitlesList=mt.findTitles(book.getTitle());
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("TitlesList",TitlesList);//添加指定的属性并为其赋指定的值
		System.out.println("findTitles");
		return "querybook";
	}

}
