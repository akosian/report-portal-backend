package reportportal.dao.tests;

import reportportal.models.Test;

import java.util.List;

public interface TestDao {

    List<Test> getTests();

    Test addTest(Test test);

    void removeTest(int id);

    void updateTest(Test test);

    Test getTestById(int id);
}
