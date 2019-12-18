package app.service;

import app.DAO.UserDAO;
import app.entities.User;
import app.util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void newUser(User user) {
        getUserDAO().insertUserDAO(user);
    }

    @Override
    public List<User> listUser() {
        return getUserDAO().selectAllUsersDAO();
    }

    @Override
    public User selectUser(Long id) {
        return getUserDAO().selectUserDAO(id);
    }

    @Override
    public void editUser(User user) throws SQLException {
        getUserDAO().updateUserDAO(user);
    }

    @Override
    public void deleteUser(Long id) throws SQLException {
        getUserDAO().deleteUserDAO(id);
    }

    private static UserDAO getUserDAO() {
        return new UserDAO(DBHelper.getConnection());
    }
}
