package reportportal.services.users;

import org.springframework.stereotype.Service;
import reportportal.dao.users.UsersDao;
import reportportal.models.User;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao){
        this.usersDao = usersDao;
    }

    @Override
    public User getUserById(int id) {
        return usersDao.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return usersDao.getUsers();
    }

    @Override
    public void addUser(User user) {
        usersDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        usersDao.deleteUser(getUserById(id));
    }

    @Override
    public void updateUser(User user) {
        usersDao.updateUser(user);
    }
}
