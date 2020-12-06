package reportportal.services.tests;

import org.springframework.stereotype.Service;
import reportportal.dao.tests.TestDao;
import reportportal.models.Test;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public Test getTestById(int id) {
        return testDao.getTestById(id);
    }

    @Override
    public List<Test> getTests() {
        return testDao.getTests();
    }

    @Override
    public Test addTest(Test test) {
        return testDao.addTest(test);
    }

    @Override
    public void deleteTest(int id) {
        testDao.removeTest(id);
    }

    @Override
    public void updateTest(Test test) {
        testDao.updateTest(test);
    }
}
