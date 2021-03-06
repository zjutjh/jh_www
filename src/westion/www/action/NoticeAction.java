package westion.www.action;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import westion.www.entity.Navigator;
import westion.www.entity.Notice;
import westion.www.exception.QueryException;
import westion.www.service.NoticeService;
import westion.www.service.impl.NoticeServiceImpl;

/**
 * 
 * 通知请求类
 * 
 * @version 1.0, 2014-3-20
 * @author westion
 * @since JDK1.7
 * @see westion.www.service.NoticeService
 */
public class NoticeAction {

	/** 请求参数 */
	private Map<String, String[]> params = null;
	/** 网站全局的配置文件 */
	private Properties properties = null;
	/** 网站全局结果文件 */
	private ArrayList<String> errorList = null;
	
	private NoticeService noticeService = new NoticeServiceImpl();

	/**
	 * 构造函数，从request中获取相应的属性，并对私有成员初始化
	 * 
	 * @param request
	 *            HttpServletRequest
	 */
	@SuppressWarnings("unchecked")
	public NoticeAction(HttpServletRequest request) {
		super();
		this.properties = (Properties) request.getServletContext()
				.getAttribute("pageConfig");
		this.errorList = (ArrayList<String>) (request.getAttribute("errorList"));
		this.params = request.getParameterMap();
	}

	/**
	 * 获取最新的通知
	 * 
	 * @return Notice
	 */
	public Notice getNew() {
		Notice notice = null;
		try {
			notice = noticeService.getNew();
		} catch (QueryException e) {
			errorList.add(properties.getProperty("sqlError"));
		} catch (Exception e) {
			errorList.add(properties.getProperty("unknownError"));
		}
		return notice;
	}
	
	/**
	 * 获得一条指定通知
	 * @return event Notice
	 * */
	public Notice getNotice() {
		Notice notice = null;
		try {
			notice = noticeService.findById(Integer.parseInt(params.get("nid")[0]));
		} catch (QueryException e) {
			errorList.add(properties.getProperty("sqlError"));
		} catch (Exception e) {
			errorList.add(properties.getProperty("unknownError"));
		}
		return notice;
	}
}
