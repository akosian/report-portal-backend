package reportportal.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import reportportal.dao.tests.TestDao;
import reportportal.dao.users.UsersDao;
import reportportal.models.Test;
import reportportal.models.User;
import reportportal.services.tests.TestService;
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
                .addAnnotatedClass(TestDao.class)
                .addAnnotatedClass(TestService.class)
                .addAnnotatedClass(Test.class)
                .buildSessionFactory();
    }
}