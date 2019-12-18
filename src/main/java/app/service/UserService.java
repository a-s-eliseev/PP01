package app.service;

import app.entities.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void newUser(User user) throws IOException, SQLException;
    List<User> listUser() throws IOException;
    User selectUser(Long id) throws IOException;
    void editUser(User user) throws IOException, SQLException;
    void deleteUser(Long id) throws IOException, SQLException;
}
