package io.mycat.ice.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.mycat.ice.domain.Host;
import io.mycat.ice.domain.User;
import io.mycat.ice.mapping.HostMapper;

/**
 * 
 * @author jackchen
 *
 */
@Service
public class HostService {
	
	@Autowired
	private HostMapper hostDao;
	private List<Host> hostList;
	private Logger log = Logger.getLogger(this.toString());
	/**
	 * find User by userid
	 * @param pUserId
	 * @return User
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Host> getHostsByZoneId(int  zoneId){	
		return hostDao.selectAll();
	}
	
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Host getHostsByZoneString(int  zoneId){	
		return hostDao.selectByPrimaryKey(zoneId);
	}
	
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int setHostNode(Host host){
		return hostDao.insert(host);
	}
}
