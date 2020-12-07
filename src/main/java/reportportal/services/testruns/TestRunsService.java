package reportportal.services.testruns;

import reportportal.models.TestRun;

import java.util.List;

public interface TestRunsService {

    List<TestRun> getTestRuns();

    TestRun getTestRunById(int id);

    TestRun addTestRun(TestRun testRun);
}