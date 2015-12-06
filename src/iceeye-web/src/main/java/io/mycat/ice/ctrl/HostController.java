package io.mycat.ice.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.ice.bean.GridData;
import io.mycat.ice.domain.Host;
import io.mycat.ice.service.HostService;

@RestController
public class HostController {

	@Autowired
	private HostService hostService;
	ModelMap model;
	private Logger log = Logger.getLogger(this.toString());
	
	@RequestMapping(value = "/addlist/{zoneId}")
	public GridData getProjects(@PathVariable("zoneId") int zoneId) {
		GridData grid = new GridData();
		List<Host> pros = hostService.getHostsByZoneId(zoneId);
		log.info("进入了！！！");
		grid.setData(pros);
		return grid;
	}
	
	

	/**
	 * add host
	 * 
	 * 
	 *
	 *
	 */
	@RequestMapping(value = "/hostl")
	public int checkLogin(HttpServletRequest request,
			@RequestParam("zone_id") String zone_id,
			@RequestParam("host_name") String host_name,
			@RequestParam("ip") String ip,
			@RequestParam("root_passwd") String root_passwd,
			@RequestParam("location") String location,
			@RequestParam("note") String note,
			@RequestParam("cores") String cores,
			@RequestParam("memory") String memory,
			@RequestParam("usage_flag") String usage_flag,
			@RequestParam("ssh_login") String ssh_login,
			@RequestParam("cluster_id") String cluster_id) {
		Host host = new Host();

		
		host.setHostName(host_name);
		host.setIp(ip);
		host.setRootPasswd(root_passwd);
		host.setLocation(location);
		host.setNote(note);
		host.setCores(new Byte(cores));
		host.setMemory(Integer.parseInt(memory));
		host.setUsageFlag(new Byte(usage_flag));
		host.setSshLogin(new Byte(ssh_login));
		
		
    	Date curDate = new Date(System.currentTimeMillis());//获取当前时间
    	host.setLastUpdated(curDate);
		int a = hostService.setHostNode(host);
		return a;
	}
}