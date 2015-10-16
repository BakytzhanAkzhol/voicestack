/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author bako
 */import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 *
 * @author bako
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password_hash")
    private String password_hash;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "create_date")
    private Date create_date;
    
    @Column(name = "update_date")
    private Date update_date;
    
    @Column(name = "moder_id")
    private int moder_id;

    public User() {
    }
    
    public User(String email,String password,String name,String surname){
        this.id=10;
        this.email=email;
        this.name=name;
        this.surname=surname;
        this.password_hash=md5(password);
        this.create_date=new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.update_date=new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.moder_id=20;
    }
    public String md5(String text){
            
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(text.getBytes(),0,text.length());
        return new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public int getModer_id() {
        return moder_id;
    }

    public void setModer_id(int moder_id) {
        this.moder_id = moder_id;
    }
}
