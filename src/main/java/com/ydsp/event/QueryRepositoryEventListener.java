package com.ydsp.event;

import com.ydsp.domain.Query;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

import java.util.Date;

/**
 * @author: john
 * @version: 1.0 2014-03-03 下午11:42
 */
public class QueryRepositoryEventListener extends AbstractRepositoryEventListener<Query> {

    @Override
    protected void onBeforeCreate(Query entity) {
        entity.setCreateDate(new Date());
        entity.setLastDate(new Date());
    }

    @Override
    protected void onBeforeSave(Query entity) {
        entity.setLastDate(new Date());
    }
}
