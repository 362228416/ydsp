package com.ydsp.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author: john
 * @version: 1.0 2014-03-05 上午10:04
 */
@Document
public class Query {

    @Id
    private String id;

    @Indexed
    private String keyword;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date lastDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "Search{" +
                "id='" + id + '\'' +
                ", keyword='" + keyword + '\'' +
                ", createDate=" + createDate +
                ", lastDate=" + lastDate +
                '}';
    }
}
