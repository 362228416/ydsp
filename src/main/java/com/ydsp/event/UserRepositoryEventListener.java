package com.ydsp.event;

import com.ydsp.domain.User;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

import java.util.Date;

/**
 * @author: john
 * @version: 1.0 2014-03-03 下午11:42
 */
public class UserRepositoryEventListener extends AbstractRepositoryEventListener<User> {

    @Override
    protected void onBeforeCreate(User entity) {
        entity.setCreateDate(new Date());
    }

}
