package minilib.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import minilib.dao.ManageCodeDao;
import minilib.vo.CodeBookType;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ManageCodeAction extends ActionSupport {
	private CodeBookType code;
	public CodeBookType getCode() {
		return code;
	}

	public void setCode(CodeBookType code) {
		this.code = code;
	}
	
	public String findBookCodePress() throws Exception{
		ManageCodeDao mtpress=new ManageCodeDao();
		List bookCodePressList=mtpress.findBookCodePress();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("bookCodePressList", bookCodePressList);
		System.out.println("findBookCodePress");
		return "codepress";
	}
	
	public String addCodePress() throws Exception{
		ManageCodeDao mtadd=new ManageCodeDao();
		mtadd.addCodePress(code);  
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("message","添加成功请继续添加！");
		System.out.println("addCodePress"+code.getCodeId()+code.getCodeName());
		return "addcodepress";
	}
	
	public String findCodePress()throws Exception{
		ManageCodeDao mt=new ManageCodeDao();
		List CodePressList=mt.findCodePress(code.getCodeName());
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("CodePressList",CodePressList);//添加指定的属性并为其赋指定的值
		System.out.println("findcodepress");
		return "querycodepress";
	}
	
	public String deletePress() throws Exception{
		ManageCodeDao mt=new ManageCodeDao();
		mt.deletePress(code.getCodeName());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("deletePress", "删除成功！");
		System.out.println("deletepress"+code.getCodeName());
		return "deletepress";
	}
	
	public String findBookCodeType() throws Exception{
		ManageCodeDao mttype=new ManageCodeDao();
	    List bookCodeTypeList=mttype.findBookCodeType();//返回放到一个列表里
	    HttpServletRequest request=ServletActionContext.getRequest();
	    request.setAttribute("bookCodeTypeList", bookCodeTypeList);
	    System.out.println("findBookCodeType");
	    return "codetype";
    }

	public String addCodeType()throws Exception{
		ManageCodeDao mtadd=new ManageCodeDao();
		mtadd.addCodeType(code);  
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("message","添加成功请继续添加！");
		System.out.println("addCodeType"+code.getCodeId()+code.getCodeName());
		return "addcodetype";
	}
	
	public String findCodeType()throws Exception{
		ManageCodeDao mt=new ManageCodeDao();
		List CodeTypeList=mt.findCodeType(code.getCodeName());
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("CodeTypeList",CodeTypeList);//添加指定的属性并为其赋指定的值
		System.out.println("findcodetype");
		return "querycodetype";
	}
	
	public String deleteType()throws Exception{
		ManageCodeDao mt = new ManageCodeDao();
	    mt.deleteType(code.getCodeName());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("deleteType", "删除成功！");
		System.out.println("deletetype"+code.getCodeName());
		return "deletetype";
	}

}
