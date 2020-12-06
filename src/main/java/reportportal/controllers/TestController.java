package reportportal.controllers;

import org.springframework.web.bind.annotation.*;
import reportportal.models.Test;
import reportportal.services.tests.TestService;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    private TestService testService;

    public TestController(TestService service) {
        this.testService = service;
    }

    @GetMapping
    public List<Test> getTest() {
        return testService.getTests();
    }

    @PostMapping
    public Test addTest(@RequestBody Test test) {
        return testService.addTest(test);
    }
}