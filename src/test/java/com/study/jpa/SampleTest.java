package com.study.jpa;

import com.study.jpa.entity.enums.Gender;
import com.study.jpa.entity.User;
import com.study.jpa.repository.UserRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import java.time.LocalDate;
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

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); // JPA의 모든 활동은 transaction 안에서 실행되야 함.
        tx.begin();

        try {
            User user = new User();
            user.setEmail("byEmSettingEmail");
            user.setPassword("124455");
            user.setName("userName-");
            user.setBirth(LocalDate.now());
            user.setCell_phone("01098649402");
            user.setGender(Gender.FEMALE);

            em.persist(user);

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 사용 후에는 꼭 close
        }

        emf.close();
    }
}
