package reportportal.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tests")
@Proxy(lazy = false)
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "summary")
    private String summary;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "testruns_tests",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "testrun_id"))
    private List<TestRun> testRuns;

    public Test() {
    }

    public Test(String summary) {
        this.summary = summary;
    }

    public void addTestRun(TestRun testRun) {
        if (testRuns == null) {
            testRuns = new ArrayList<>();
        }
        testRuns.add(testRun);
    }
}