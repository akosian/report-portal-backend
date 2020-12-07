package reportportal.dao.testruns;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import reportportal.models.TestRun;

import java.util.List;

@Repository
public class TestRunsDaoImpl implements TestRunsDao {

    private SessionFactory sessionFactory;

    public TestRunsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<TestRun> getTestRuns() {
        Session session = startSession();
        List<TestRun> testRuns = session.createQuery("from TestRun").list();
        finishSession(session);
        return testRuns;
    }

    @Override
    public TestRun getTestRunById(int id) {
        Session session = startSession();
        TestRun testRun = session.load(TestRun.class, id);
        finishSession(session);
        return testRun;
    }

    @Override
    public TestRun addTestRun(TestRun testRun) {
        Session session = startSession();
        session.save(testRun);
        finishSession(session);
        return testRun;
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
