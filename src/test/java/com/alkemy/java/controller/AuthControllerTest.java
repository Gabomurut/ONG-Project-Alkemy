package com.alkemy.java.controller;



import javax.sql.DataSource;

import com.alkemy.java.dto.UserDto;
import com.alkemy.java.dto.UserLoginDto;
import com.alkemy.java.repository.UserRepository;
import com.alkemy.java.security.JwtTokenService;
import com.alkemy.java.service.UserService;

import org.apache.tomcat.jni.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    @MockBean
    AuthController authController;

    // write test cases here

    @Test
public void authControllerLoginOk()
  throws Exception {
    
    UserLoginDto testUser = new UserLoginDto();

    given(((Object) authController.createAuthenticationToken(testUser)).willReturn(ResponseEntity.ok("Token")));

    mvc.perform(post("/auth/login")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
    
}


}
