package com.gsn;


import com.gsn.piclib.domain.PageDomain;
import com.gsn.piclib.domain.PicDomain;
import com.gsn.piclib.service.PicService;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfiguration.class})
public class TestService {

    private static final Logger logger = Logger.getLogger(TestService.class);
    @Autowired
    private PicService picService;

    @Test
    public void testList() {
        logger.info("调用PicService.list");
        List<PicDomain> list = picService.list();
        System.out.println(list);
    }

    @Test
    public void testListByPage() {
        PicDomain picDomain = new PicDomain(1, "", "test");
        picDomain.setPage(1);
        logger.info("调用PicService.listByPage");
        PageDomain<PicDomain> list = picService.listByPage(picDomain);
        System.out.println(list);
    }

    @Test
    public void testSave() {
        Random r = new Random();
        PicDomain picDomain = new PicDomain(7, "new pic" + r.nextInt(9999), "very very test");
        picService.save(picDomain);
        logger.info("新增的产品编号:" + picDomain.getId());
        //断言.
        Assert.notNull(picDomain.getId(), "not insert");
    }

    @Test
    public void testDelete() {
        picService.delete(1);
    }


}
