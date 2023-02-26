package no.hik.ChatServer.controllers.api;

import no.hik.ChatServer.db.models.UserModel;
import no.hik.ChatServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserModel>> getUsers() {

        List<UserModel> userModels = userService.getUsers();

        return ResponseEntity.ok(userModels);
    }
}
