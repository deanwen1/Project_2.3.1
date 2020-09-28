package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void deleteUser(long id);

    void editUser(User user);

    List<User> getAllUsers();

    User getUserId(long Id);
}
