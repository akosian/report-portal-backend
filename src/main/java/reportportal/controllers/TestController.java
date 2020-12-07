package reportportal.controllers;

import org.springframework.web.bind.annotation.*;
import reportportal.models.Test;
import reportportal.services.tests.TestsService;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    private TestsService testsService;

    public TestController(TestsService service) {
        this.testsService = service;
    }

    @GetMapping
    public List<Test> getTest() {
        return testsService.getTests();
    }

    @PostMapping
    public Test addTest(@RequestBody Test test) {
        return testsService.addTest(test);
    }
}