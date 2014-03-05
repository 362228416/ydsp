package com.ydsp.repository;

import com.ydsp.config.YdspConfig;
import com.ydsp.domain.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: john
 * @version: 1.0 2014-03-05 上午10:18
 */
@ContextConfiguration(classes = YdspConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchRepositoryTest {

    @Autowired
    QueryRepository searchRepository;

    @Test
    public void testSave() throws Exception {
        searchRepository.deleteAll();
        Query s = new Query();
        s.setKeyword("酒店");
        searchRepository.save(s);
        System.out.println(searchRepository.findAll());

    }

}
