package net.code.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		user user = new user();
		user.setEmail("kurapatiamulya8@gmail.com");
		user.setPassword("amulya@22");
		user.setFirstName("amulya");
		user.setLastName("kurapati");
		
		user savedUser = repo.save(user);
		user existUser = entityManager.find(user.class, savedUser.getId());
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}

}
 