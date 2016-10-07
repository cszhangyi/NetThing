package com.cps;

import com.cps.dao.IpDAO;
import com.cps.model.Ip;
import com.cps.model.Ip_coor_res;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Yale on 16/10/7.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NetthingApplication.class)
public class getAllCoordinateTests {
    @Autowired
    IpDAO ipDAO;

    @Test
    public void test(){
        List<Ip_coor_res> res = ipDAO.selectAllWithCoordinateAndCount(1);
        for(Ip_coor_res list : res){
            System.out.println(list.getCoordinate() + "  " + list.getCount());
        }
        System.out.println(res.size());
    }
}
