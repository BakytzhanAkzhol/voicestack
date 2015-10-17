/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import model.User;

/**
 *
 * @author bako
 */
public interface UserDAO {
    public List getAll() throws SQLException;
    public User registrate(User user) throws SQLException;
    public User authority(User user)throws SQLException;
    public User create(User user)throws SQLException;
    public User update(User user) throws SQLException;
    public boolean remove(User user) throws SQLException;
    public User findById(int id) throws SQLException;
    
}
