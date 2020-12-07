package reportportal.controllers;

import org.springframework.web.bind.annotation.*;
import reportportal.models.TestRun;
import reportportal.services.testruns.TestRunsService;

import java.util.List;

@RestController
@RequestMapping("/testruns")
public class TestRunsController {

    private TestRunsService testRunsService;

    public TestRunsController(TestRunsService testRunsService) {
        this.testRunsService = testRunsService;
    }

    @GetMapping
    public List<TestRun> getTestRuns() {
        return testRunsService.getTestRuns();
    }

    @PostMapping
    public TestRun addTestRun(@RequestBody TestRun testRun) {
        return testRunsService.addTestRun(testRun);
    }
}