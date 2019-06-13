package bhz.mst.facade;

import java.util.List;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@Path("/mstSiteService")
//@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
//@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public interface MstSiteFacade {
	
	public List<JSONObject> getList(JSONObject jsonParam, Integer start , Integer limit) throws Exception;

	public int getTotal(JSONObject jsonParam);
	
	public void insert(JSONObject jsonObject) throws Exception;
	
	public int update(JSONObject json) throws Exception;

//	@GET
//	@Path("/testget")
	public JSONObject get(String siteId) throws Exception;
	
}
