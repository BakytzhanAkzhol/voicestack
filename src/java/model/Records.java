/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author bako
 */
@Entity
@Table(name="records")
public class Records implements Serializable {
    @Id
    @Column(name="id")
    int id;
    
    @Column(name="user_id")
    int user_id;
    
    @Column(name="url")
    String url;
    
    @Column(name="during_time")
    Time during_time;
    
    @Column(name="create_date")
    Date create_date;
    
    @Column(name="update_date")
    Date update_date;
    
    @Column(name="listen_count")
    int listen_count;
    
    @Column(name="status")
    int status;
    
    @Column(name="moder_id")
    int moder_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Time getDuring_time() {
        return during_time;
    }

    public void setDuring_time(Time during_time) {
        this.during_time = during_time;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public int getListen_count() {
        return listen_count;
    }

    public void setListen_count(int listen_count) {
        this.listen_count = listen_count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getModer_id() {
        return moder_id;
    }

    public void setModer_id(int moder_id) {
        this.moder_id = moder_id;
    }
    
    
    
}
