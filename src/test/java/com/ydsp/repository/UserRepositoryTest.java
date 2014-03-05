package com.ydsp.repository;

import com.ydsp.config.YdspConfig;
import com.ydsp.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: john
 * @version: 1.0 2014-02-28 下午11:29
 */
@ContextConfiguration(classes = YdspConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testMarker() throws Exception {
        Assert.notNull(restTemplate);
        Assert.notNull(userRepository);
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> list = userRepository.findAll();
        Assert.notNull(list);
    }

    @Test
    public void testSave() throws Exception {
        userRepository.deleteAll();
        userRepository.save(new User("1", "john"));
        userRepository.save(new User("2", "mary"));
        System.out.println(userRepository.findAll());
    }


}
