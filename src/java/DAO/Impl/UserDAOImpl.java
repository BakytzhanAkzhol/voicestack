/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.UserDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionException;
import util.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author bako
 */
public class UserDAOImpl implements UserDAO {

    private Session session;

    @Override
    public List getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        session.close();
        return cr.list();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User registrate(User user) throws SQLException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User authority(User user) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("email", user.getEmail()).ignoreCase());
        cr.add(Restrictions.eq("password_hash", user.getPassword_hash()).ignoreCase());
        cr.setMaxResults(1);
        cr.setFirstResult(0);
        if (!cr.list().isEmpty()) {
            return (User) cr.list().get(0);
        }
        session.close();
        return null;
//        session.createCriteria(User.class).createCriteria(string);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User create(User user) throws SQLException {
        /*
        Transaction tx;
 try {
     tx = sess.beginTransaction();
     //do some work
     ...
     tx.commit();
 }
 catch (Exception e) {
     if (tx!=null) tx.rollback();
     throw e;
 }
 finally {
     sess.close();
 }*/
        Transaction tx = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
            user.setName("Bako");
            user.setSurname("Akzhol");
            user.setCreate_date(timeNow);
            user.setUpdate_date(timeNow);
            user.setModer_id(2);
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User update(User user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(User user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isConnected() throws SQLException {
        return HibernateUtil.getSessionFactory().openSession().isConnected();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
