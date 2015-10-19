/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import model.Question;
import model.User;

/**
 *
 * @author bako
 */
public interface QuestionDAO {
    public List getAll() throws SQLException;
   public Question create(Question question)throws SQLException;
    public Question update(Question question) throws SQLException;
    public boolean remove(Question question) throws SQLException;
    public Question findById(int id) throws SQLException;
    public Question findById(String id) throws SQLException;
    
}
