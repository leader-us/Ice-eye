package io.mycat.ice.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.ice.bean.GridData;
import io.mycat.ice.domain.IceProject;
import io.mycat.ice.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/projectlist")
	public GridData getProjects(){
        GridData grid = new GridData();
		List<IceProject> pros = projectService.getAllProjects();
		grid.setData(pros);
        return grid;
	}
}
