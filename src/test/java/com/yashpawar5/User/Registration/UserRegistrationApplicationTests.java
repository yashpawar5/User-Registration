package com.yashpawar5.User.Registration;

import com.yashpawar5.User.Registration.Models.Authority;
import com.yashpawar5.User.Registration.Models.User;
import com.yashpawar5.User.Registration.Repositories.AuthorityRepository;
import com.yashpawar5.User.Registration.Repositories.UserRepository;
import com.yashpawar5.User.Registration.Requests.RegisterUserRequest;
import com.yashpawar5.User.Registration.Services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserRegistrationApplicationTests {

//	@Test
//	void contextLoads() {
//	}


	@Test
	public void test_register_user_success() {
		UserRepository userRepository = mock(UserRepository.class);
		AuthorityRepository authorityRepository = mock(AuthorityRepository.class);
		UserService userService = new UserService();
		ReflectionTestUtils.setField(userService, "userRepository", userRepository);
		ReflectionTestUtils.setField(userService, "authorityRepository", authorityRepository);

		RegisterUserRequest request = new RegisterUserRequest();
		request.setUsername("testuser");
		request.setPassword("password");
		request.setEmail("testuser@example.com");

		when(userRepository.existsByUsername("testuser")).thenReturn(false);
		when(userRepository.save(ArgumentMatchers.any(User.class))).thenAnswer(invocation -> {
			User user = invocation.getArgument(0);
			user.setUserId(1);
			return user;
		});

		String result = userService.registerUser(request);

		assertEquals("User registered successfully with User ID: 1", result);
		verify(userRepository).existsByUsername("testuser");
		verify(userRepository).save(ArgumentMatchers.any(User.class));
		verify(authorityRepository).save(ArgumentMatchers.any(Authority.class));
	}

}
