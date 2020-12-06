package reportportal.services.tests;

import reportportal.models.Test;

import java.util.List;

public interface TestService {

    Test getTestById(int id);

    List<Test> getTests();

    Test addTest(Test test);

    void deleteTest(int id);

    void updateTest(Test test);
}
