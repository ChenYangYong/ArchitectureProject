package bhz.sys.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bhz.sys.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bhz.com.dao.RoleFuncComDao;
import bhz.com.util.RequestUtils;
import bhz.com.util.ResponseUtils;
import bhz.sys.facade.SysUserFacade;

import com.alibaba.fastjson.JSONObject;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author bhz（Alienware）
 * @since 2016年2月29日
 */
@Controller
public class SysIndexController {
	
	@Resource
	private SysUserFacade sysUserFacade;

	private RoleFuncComDao roleFuncComDao;
	
	
	public RoleFuncComDao getRoleFuncComDao() {
		return roleFuncComDao;
	}

	@Autowired
	public void setRoleFuncComDao(RoleFuncComDao roleFuncComDao) {
		this.roleFuncComDao = roleFuncComDao;
	}

	/**
     * <B>方法名称：</B>系统首页<BR>
     * <B>概要说明：</B><BR>
     * 
     * @param request 页面请求
     * @param response 页面响应
     * @return ModelAndView 模型视图
     */
	@RequestMapping("/sysindex.html")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView ret = new ModelAndView();
		SysUser user = this.sysUserFacade.getUser();
		System.out.println(user);
		return ret;
	}
    
    @RequestMapping("/sysFuncList.json")
    public void sysFuncList(HttpServletRequest request, HttpServletResponse response, String id){
    	String roleCode = RequestUtils.getCurrentRoleCode(request);
    	List<JSONObject> records = new ArrayList<JSONObject>();
    	List<JSONObject> funcList = this.roleFuncComDao.getFuncList(roleCode, id);
    	for (JSONObject jsonObject : funcList) {
			JSONObject record = new JSONObject();
			//'id' ,'text' , 'type' , 'leaf', 'url'
			record.put("id", jsonObject.getString("FUNC_CODE"));
			record.put("text", jsonObject.getString("FUNC_NAME"));
			record.put("type", jsonObject.getString("FUNC_TYPE"));
			record.put("leaf", true);
			record.put("url", jsonObject.getString("FUNC_PATH"));
			records.add(record);
		}
    	ResponseUtils.putJsonResponse(response, records);
    	
    }
    
    

}
