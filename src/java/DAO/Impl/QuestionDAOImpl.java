/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.QuestionDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import model.Question;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author bako
 */
public class QuestionDAOImpl implements QuestionDAO {

    private Session session;

    @Override
    public List getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Question.class);
        return cr.list();
    }

    @Override
    public Question create(Question question) throws SQLException {
        Transaction tx = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            question.setCreate_date(new Date(Calendar.getInstance().getTimeInMillis()));
            question.setUpdate_date(new Date(Calendar.getInstance().getTimeInMillis()));
            session.save(question);
            tx.commit();
//            question = findByEmail(question.getEmail());
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return question;
    }

    @Override
    public Question update(Question question) throws SQLException {
        Transaction tx = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            question.setCreate_date(question.getCreate_date());
            question.setUpdate_date(new Date(Calendar.getInstance().getTimeInMillis()));
            session.saveOrUpdate(question);
            tx.commit();
            System.out.println("SaveOrUpdate");
//            question = findByEmail(user.getEmail());
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return question;
    }

    @Override
    public boolean remove(Question question) throws SQLException {

        Transaction tx = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.delete(question);
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
    public Question findById(int id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Question question = (Question) session.get(Question.class, id);
            if (question == null) {
                throw new NullPointerException("Error 404!Question not found");
            } else {
                return question;
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect id");
        }
    }

    @Override
    public Question findById(String id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Question question = (Question) session.get(Question.class, Integer.parseInt(id));
            if (question == null) {
                throw new NullPointerException("Error 404!Question not found");
            } else {
                return question;
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect id");
        }
    }

}
