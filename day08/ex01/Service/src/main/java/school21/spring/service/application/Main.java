package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.repositories.UsersRepository;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println("-------------------- Standart");
        UsersRepository usersRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
       System.out.println(usersRepository.findAll());

        System.out.println("-------------------- Template");
        usersRepository = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
        System.out.println(usersRepository.findAll());
        usersRepository.delete(2L);
        System.out.println(usersRepository.findAll());
    }
}
