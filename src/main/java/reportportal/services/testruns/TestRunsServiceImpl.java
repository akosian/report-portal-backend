package reportportal.services.testruns;

import org.springframework.stereotype.Service;
import reportportal.dao.testruns.TestRunsDao;
import reportportal.models.TestRun;

import java.util.List;

@Service
public class TestRunsServiceImpl implements TestRunsService {

    private TestRunsDao testRunsDao;

    public TestRunsServiceImpl(TestRunsDao testRunsDao) {
        this.testRunsDao = testRunsDao;
    }

    @Override
    public List<TestRun> getTestRuns() {
        return testRunsDao.getTestRuns();
    }

    @Override
    public TestRun getTestRunById(int id) {
        return testRunsDao.getTestRunById(id);
    }

    @Override
    public TestRun addTestRun(TestRun testRun) {
        return testRunsDao.addTestRun(testRun);
    }
}
