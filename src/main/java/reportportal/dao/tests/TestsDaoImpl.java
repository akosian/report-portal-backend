package reportportal.dao.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import reportportal.models.Test;

import java.util.List;

@Repository
public class TestsDaoImpl implements TestsDao {

    private final SessionFactory sessionFactory;

    public TestsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Test> getTests() {
        Session session = startSession();
        List<Test> tests = session.createQuery("from Test").list();
        finishSession(session);
        return tests;
    }

    @Override
    public Test addTest(Test test) {
        Session session = startSession();
        session.save(test);
        finishSession(session);
        return test;
    }

    @Override
    public void removeTest(int id) {
        Session session = startSession();
        session.remove(getTestById(id));
        finishSession(session);
    }

    @Override
    public void updateTest(Test test) {
        Session session = startSession();
        session.update(test);
        finishSession(session);
    }

    @Override
    public Test getTestById(int id) {
        Session session = startSession();
        Test test = session.load(Test.class, id);
        finishSession(session);
        return test;
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
