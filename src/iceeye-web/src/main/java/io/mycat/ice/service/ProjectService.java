package io.mycat.ice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.mycat.ice.domain.IceProject;
import io.mycat.ice.mapping.IceProjectMapper;

/**
 * 
 * @author jackchen
 *
 */
/**
 * 
 * @author jackchen
 *
 */
@Service
public class ProjectService {

	@Autowired
	private IceProjectMapper projectDao;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<IceProject> getAllProjects() {
		return projectDao.selectAll();
	}
}
