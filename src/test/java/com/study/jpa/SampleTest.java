package com.study.jpa;

import com.study.jpa.entity.User;
import com.study.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class SampleTest {
    private static EntityManager manager;

    @Test
    public void console() {
        System.out.println("Sample class console 메소드 작동");
    }

    @Test
    @Transactional
    public void jpaTest() {
        System.out.println("Sample jpaTest console 메소드 작동");

        ApplicationContext app = new ClassPathXmlApplicationContext("config/db_config_back.xml");
        EntityManagerFactory factory = app.getBean(EntityManagerFactory.class);
        manager = factory.createEntityManager();
        UserRepository repository = app.getBean(UserRepository.class);

        List list = repository.findAll();

        System.out.println(list);
    }

    @Test
    @Transactional
    public void nativeJpaTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("study");

        emf.close();
    }
}
