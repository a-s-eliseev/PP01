package app.DAO;

import app.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    void insertUser(User user);
    User selectUser(Long id);
    List<User> selectAllUsers();
    void deleteUser(Long id) throws SQLException;
    void updateUser(User user) throws SQLException;
}
