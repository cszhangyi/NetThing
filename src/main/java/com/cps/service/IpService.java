package com.cps.service;

import com.cps.dao.IpDAO;
import com.cps.model.Ip;
import com.cps.model.Ip_coor_res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yale on 16/10/7.
 */
@Service
public class IpService {
    @Autowired
    private IpDAO ipDAO;

    public List<Ip_coor_res> getAllIpInfo(int num){
        return ipDAO.selectAllWithCoordinateAndCount(num);
    }
}
