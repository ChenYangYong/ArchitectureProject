package bhz.mst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import bhz.mst.dao.MstSiteDao;
import bhz.mst.facade.MstSiteFacade;

@Service
@com.alibaba.dubbo.config.annotation.Service(protocol = {"dubbo"})
//@com.alibaba.dubbo.config.annotation.Service(interfaceClass=MstSiteFacade.class, protocol = {"rest", "dubbo"})
public class MstSiteService implements MstSiteFacade {

	@Autowired
	private MstSiteDao mstSiteDao;
	
	public void insert (JSONObject json) throws Exception {
		this.mstSiteDao.insert(json);
	}
	
	public int update(JSONObject json) throws Exception {
		return this.mstSiteDao.update(json);
	}
	
	public List<JSONObject> getList(JSONObject jsonParam, Integer start , Integer limit) throws Exception {
		return this.mstSiteDao.getList(jsonParam, start, limit);
	}
	
	public int getTotal(JSONObject jsonParam){
		return this.mstSiteDao.getTotal(jsonParam);
	}
	
	public JSONObject get(String siteId){
		return this.mstSiteDao.get(siteId);
	}
	
	
	
	
	
	
	
}
