package minilib.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import minilib.dao.ManageBrowseDao;
import minilib.vo.Record;

public class ManageBrowseAction extends ActionSupport {
	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	public String findBrowse()throws Exception{
		ManageBrowseDao mt=new ManageBrowseDao();
		List BrowseList=mt.findBrowse(record.getUserid(),record.getBookid());/**/
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("BrowseList",BrowseList);//添加指定的属性并为其赋指定的值
		System.out.println("findBrowse");
		return "querybrowse";
	}

}
