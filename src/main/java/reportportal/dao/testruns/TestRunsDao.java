package reportportal.dao.testruns;

import reportportal.models.TestRun;

import java.util.List;

public interface TestRunsDao {

    List<TestRun> getTestRuns();

    TestRun getTestRunById(int id);

    TestRun addTestRun(TestRun testRun);
}