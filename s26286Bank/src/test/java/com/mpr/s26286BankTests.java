package com.mpr;

import com.mpr.model.Status;
import com.mpr.model.TransferInfo;
import com.mpr.model.User;
import com.mpr.storage.TransferStorage;
import com.mpr.storage.UserStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class s26286BankTests {

	private TransferService transferService;
	private UserService userService;
	@BeforeEach
	void setup() {
		UserStorage userStorage = new UserStorage();
		TransferStorage transferStorage = new TransferStorage();
		transferService = new TransferService(userStorage, transferStorage);
		userService = new UserService(userStorage);
	}
	@Test
	void successCreateUser () {
		User user = userService.createUser("test", 1000);
		assertThat(user).hasToString("id=test balance=1000.0");
	}

	@Test
	void successReadUserData () {
		userService.createUser("test", 1000);
		userService.createUser("test2", 2000);
		userService.createUser("test3", 3000);

		User user = userService.findUserbyId("test2");
		assertThat(user).hasToString("id=test2 balance=2000.0");
	}

	@Test
	void successUpdateBalance () {
		userService.createUser("test", 1000);
		userService.createUser("test2", 2000);
		userService.createUser("test3", 3000);

		userService.updateBalanceById("test", 1234);
		User user = userService.findUserbyId("test");

		assertThat(user.getBalance()).isEqualTo(1234);
	}

	@Test
	void successMakeTransferFrom () {
		userService.createUser("test", 1000);

		TransferInfo transferInfo = transferService.makeTransferFrom("test", 100);
		assertThat(transferInfo.getStatus()).isEqualTo(Status.ACCEPTED);

		User user = userService.findUserbyId("test");
		assertThat(user.getBalance()).isEqualTo(900);
	}

	@Test
	void failedMakeTransferFrom () {
		userService.createUser("test", 1000);

		TransferInfo transferInfo = transferService.makeTransferFrom("test", 10000);
		assertThat(transferInfo.getStatus()).isEqualTo(Status.DECLINED);

		User user = userService.findUserbyId("test");
		assertThat(user.getBalance()).isEqualTo(1000);
	}

	@Test
	void successMakeTransferTo () {
		userService.createUser("test", 1000);

		TransferInfo transferInfo = transferService.makeTransferTo("test", 100);
		assertThat(transferInfo.getStatus()).isEqualTo(Status.ACCEPTED);

		User user = userService.findUserbyId("test");
		assertThat(user.getBalance()).isEqualTo(1100);
	}

	@Test
	void failedMakeTransferTo () {
		userService.createUser("test", 1000);

		TransferInfo transferInfo = transferService.makeTransferTo("test2", 10000);
		assertThat(transferInfo.getStatus()).isEqualTo(Status.DECLINED);

	}

}
