package reportportal.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import reportportal.dao.testruns.TestRunsDao;
import reportportal.dao.tests.TestsDao;
import reportportal.dao.users.UsersDao;
import reportportal.models.Test;
import reportportal.models.TestRun;
import reportportal.models.User;
import reportportal.services.testruns.TestRunsService;
import reportportal.services.tests.TestsService;
import reportportal.services.users.UsersService;

@org.springframework.context.annotation.Configuration
@ComponentScan("reportportal")
public class AppConfiguration {

    @Bean
    public SessionFactory userService() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UsersDao.class)
                .addAnnotatedClass(UsersService.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(TestsDao.class)
                .addAnnotatedClass(TestsService.class)
                .addAnnotatedClass(Test.class)
                .addAnnotatedClass(TestRun.class)
                .addAnnotatedClass(TestRunsService.class)
                .addAnnotatedClass(TestRunsDao.class)
                .buildSessionFactory();
    }
}