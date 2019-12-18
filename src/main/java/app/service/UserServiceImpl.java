package app.service;

import app.DAO.UserDaoImpl;
import app.entities.User;
import app.util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoImpl userDao = new UserDaoImpl(DBHelper.getConnection());

    @Override
    public void newUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public List<User> listUser() {
        return userDao.selectAllUsers();
    }

    @Override
    public User selectUser(Long id) {
        return userDao.selectUser(id);
    }

    @Override
    public void editUser(User user) throws SQLException {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) throws SQLException {
        userDao.deleteUser(id);
    }
}
