package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {

        userDao.addUser(user);
    }

    @Override
    public void deleteUser(long id) {

        userDao.deleteUser(id);
    }

    @Override
    public void editUser(User user) {

        userDao.editUser(user);
    }

    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    @Override
    public User getUserId(long id) {
        return userDao.getUserId(id);
    }
}
