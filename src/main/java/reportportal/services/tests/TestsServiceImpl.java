package reportportal.services.tests;

import org.springframework.stereotype.Service;
import reportportal.dao.tests.TestsDao;
import reportportal.models.Test;

import java.util.List;

@Service
public class TestsServiceImpl implements TestsService {

    private TestsDao testsDao;

    public TestsServiceImpl(TestsDao testsDao) {
        this.testsDao = testsDao;
    }

    @Override
    public Test getTestById(int id) {
        return testsDao.getTestById(id);
    }

    @Override
    public List<Test> getTests() {
        return testsDao.getTests();
    }

    @Override
    public Test addTest(Test test) {
        return testsDao.addTest(test);
    }

    @Override
    public void deleteTest(int id) {
        testsDao.removeTest(id);
    }

    @Override
    public void updateTest(Test test) {
        testsDao.updateTest(test);
    }
}
