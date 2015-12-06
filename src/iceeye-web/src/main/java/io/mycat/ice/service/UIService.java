package io.mycat.ice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.mycat.ice.bean.ui.Menu;
import io.mycat.ice.domain.Host;
import io.mycat.ice.domain.IceProject;
import io.mycat.ice.domain.User;
import io.mycat.ice.mapping.HostMapper;
import io.mycat.ice.mapping.IceProjectMapper;

/**
 * used for ui menu
 * 
 * @author wuzhih
 *
 */
@Service
public class UIService {
	private static final String MENU_TYPE_ZONE = "1";

	private static final String MENU_TYPE_CLUSTER_GROUP = "2";

	private static final String MENU_TYPE_CLUSTER_NODE = "3";

	private static final String MENU_TYPE_HOST_GROUP = "4";

	private static final String MENU_TYPE_HOST_NODE = "5";

	private static final String MENU_TYPE_PROJECT_GROUP = "6";

	private static final String MENU_TYPE_PROJECT_NODE = "7";
	@Autowired
	private IceProjectMapper projectDao;
	@Autowired
	private HostMapper hostDao;

	/**
	 * fetch current user's menu
	 * 
	 * @param curUser
	 * @return
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Menu> generateMenus(User curUser) {
		List<Menu> menus = new ArrayList<Menu>();
		// projects menu
		Menu firstMenu4 = new Menu("projects", "My Applications", "dddddd.do", MENU_TYPE_PROJECT_GROUP);
		menus.add(firstMenu4);

		Menu childMenu = new Menu("project-list", "List ", "project_main.html", MENU_TYPE_PROJECT_NODE);
		firstMenu4.getSubMenus().add(childMenu);

		childMenu = new Menu("project-report", "Report ", "project_report.html", MENU_TYPE_PROJECT_NODE);
		firstMenu4.getSubMenus().add(childMenu);
		
	
		// cluster menu
		Menu firstMenus1 = new Menu("clsdef", "Ice Cluster", "dddddd.do", MENU_TYPE_ZONE);
		// 菜单1 第二级 submenu
		// host pool sub menu
		Menu firstMenuSub2 = new Menu("hostp1", "Host Pool", "ddddd.do", MENU_TYPE_HOST_GROUP);
		firstMenus1.getSubMenus().add(firstMenuSub2);
		menus.add(firstMenus1);
		childMenu = new Menu("host-list", "List ", "host_main.html", MENU_TYPE_HOST_NODE);
		firstMenuSub2.getSubMenus().add(childMenu);

		childMenu = new Menu("host-report", "Report ", "host_report.html", MENU_TYPE_HOST_NODE);
		firstMenuSub2.getSubMenus().add(childMenu);
		// cluster info menu
		Menu firstMenuSub3 = new Menu("cls_inf", "Cluster Inf", "cluster_main.html", MENU_TYPE_PROJECT_GROUP);
		firstMenus1.getSubMenus().add(firstMenuSub3);

		return menus;

	}

	private List<Host> getAllHosts(User curUser) {
		return hostDao.selectAll();

	}

	private List<IceProject> getMyProjects(User curUser) {
		return projectDao.selectAll();
	}
}
