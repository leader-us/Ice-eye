package io.mycat.ice.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.ice.bean.ui.Menu;
import io.mycat.ice.service.UIService;

/**
 * resetFul menu
 * 
 * @author jackChen
 *
 */
@RestController
public class MenuController {
	@Autowired
	private UIService uiService;

	/**
	 * get menus
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/menus", method = RequestMethod.GET)
	public List<Menu> getUserMenus(HttpServletRequest request) {
		return uiService.generateMenus(null);
	}

}
