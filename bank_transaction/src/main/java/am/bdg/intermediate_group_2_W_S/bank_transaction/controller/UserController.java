package am.bdg.intermediate_group_2_W_S.bank_transaction.controller;

import am.bdg.intermediate_group_2_W_S.bank_transaction.dto.UserDto;
import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.RoleTypes;
import am.bdg.intermediate_group_2_W_S.bank_transaction.service.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.register(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(userService.login(loginDto.getEmail(), loginDto.getPass()));
    }

    @PutMapping("/{id}/{role}")
    public ResponseEntity<?> createRole(@PathVariable Long id, @PathVariable  String role) {
        return ResponseEntity.ok(userService.changeRole(id,  role));
    }

    @Data
    private class LoginDto {
        private String email;
        private String pass;
    }
}
