package reportportal.dao.users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import reportportal.models.User;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {

    private final SessionFactory sessionFactory;

    public UsersDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserById(int id) {
        Session session = startSession();
        User user = session.load(User.class, id);
        finishSession(session);
        return user;
    }

    @Override
    public List<User> getUsers() {
        Session session = startSession();
        List<User> users = session.createQuery("from User").list();
        finishSession(session);
        return users;
    }

    @Override
    public void addUser(User user) {
        Session session = startSession();
        session.save(user);
        finishSession(session);
    }

    @Override
    public void deleteUser(User user) {
        Session session = startSession();
        session.remove(user);
        finishSession(session);
    }

    @Override
    public void updateUser(User user) {
        Session session = startSession();
        session.update(user);
        finishSession(session);
    }

    private void finishSession(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    private Session startSession() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }
}
