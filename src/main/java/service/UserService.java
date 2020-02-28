package service;

import dao.UserDao;
import exceptions.DBException;
import model.User;

import java.util.List;

public class UserService {
    private static volatile UserService instance;
    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }

    UserDao dao = UserDao.getInstance();

    public void createTable() throws DBException {

        dao.createTable();
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public boolean isNotReg(String name) {
        return dao.isNotReg(name);
    }

    public boolean addUser(User user) {

        if (isNotReg(user.getName())) {
            return false;
        } else {
            dao.addUser(user);
            return true;
        }
    }

    public boolean reomveUser(long id) {
        return dao.removeUser(id);
    }

    public void updateUser(String name, String password, Long id) {

            dao.updateUser(name, password, id);
    }
    public List<User> getUserById (long id) {
       return dao.getUserById(id);
    }
}


