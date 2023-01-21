package com.mpr;

import com.mpr.model.Status;
import com.mpr.model.TransferInfo;
import com.mpr.model.User;
import com.mpr.storage.UserStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class s26286BankIntegrationTests {

	@MockBean
	private UserStorage userStorage;
	@Autowired
	private TransferService transferService;
	@Autowired
	private UserService userService;

	@Test
	void successUpdateBalance () {
		when(userStorage.getUserById(any()))
				.thenReturn(Optional.of(new User("test", 200)));

		User testUser = userService.updateBalanceById("test", 300);

		userService.updateBalanceById("test", 1234);
		User user = userService.findUserbyId("test");

		assertThat(testUser.getBalance()).isEqualTo(1234);
	}

}
