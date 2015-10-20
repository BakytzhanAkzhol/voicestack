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
import java.util.List;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

import org.hibernate.Transaction;
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
        return cr.list();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public User authority(User user) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("email", user.getEmail()).ignoreCase());
        cr.add(Restrictions.eq("password_hash", user.md5(user.getPassword_hash())).ignoreCase());
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
        Transaction tx = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            user.setPassword_hash(user.md5(user.getPassword_hash()));
            user.setCreate_date(new Date(Calendar.getInstance().getTimeInMillis()));
            user.setUpdate_date(new Date(Calendar.getInstance().getTimeInMillis()));
            session.save(user);
            tx.commit();
            user = findByEmail(user.getEmail());
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
        Transaction tx = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            user.setCreate_date(new Date(Calendar.getInstance().getTimeInMillis()));
            user.setUpdate_date(new Date(Calendar.getInstance().getTimeInMillis()));
            session.saveOrUpdate(user);
            tx.commit();
            user = findByEmail(user.getEmail());
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
    public boolean remove(User user) throws SQLException {
        Transaction tx = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public User findById(String id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            User user = (User) session.get(User.class, Integer.parseInt(id));
            if (user == null) {
                throw new NullPointerException("404!User not found");
            } else {
                return user;
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect id");
        }
    }

    @Override
    public User findById(int id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);

        if (user == null) {
            throw new NullPointerException("404!User not found");
        } else {
            return user;
        }

    }

    @Override
    public User findByEmail(String user_email) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("email", user_email).ignoreCase());
        cr.setMaxResults(1);
        cr.setFirstResult(0);
        if (!cr.list().isEmpty()) {
            System.out.println("before converts");
            return (User) cr.list().get(0);
        }
        return null;
    }

}
