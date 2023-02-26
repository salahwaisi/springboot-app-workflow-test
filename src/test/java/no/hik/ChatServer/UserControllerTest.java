package no.hik.ChatServer;

import no.hik.ChatServer.controllers.api.UserController;
import no.hik.ChatServer.db.models.UserModel;
import no.hik.ChatServer.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Test
    public void testGetUserList() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        var userModels = new ArrayList<UserModel>();
        var userModel = new UserModel();
        userModel.setFirstName("Testperson");
        userModels.add(userModel);
        when(userService.getUsers()).thenReturn(userModels);
        ResponseEntity<List<UserModel>> responseEntity = userController.getUsers();

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        var headers = responseEntity.getHeaders();
        assertThat(responseEntity.getBody().stream().findFirst().get().getFirstName()).isEqualTo("Testperson");
    }
}
