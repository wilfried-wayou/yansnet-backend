package com.etsia.auth.infrastructure.controller;


import com.etsia.auth.application.service.*;
import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.model.dto.request.user.CreateUserDto;
import com.etsia.auth.domain.model.dto.request.user.UserUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserDeleteService userDeleteService;
    private final UserexistsByEmailService userexistsByEmailService;
    private final UserFindByEmailAndPasswordService userFindByEmailAndPasswordService;
    private final UserFindByEmailService userFindByEmailService;
    private final UserFindByIdService userFindByIdService;
    private final UserSaveService userSaveService;
    private UserupdateService userupdateService;

    @GetMapping("/{id}")
    public ResponseEntity<User> FindById(@PathVariable Integer id) {
        User user = userFindByIdService.exec(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> FindByEmail(@PathVariable String email) {
        User user = userFindByEmailService.exec(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email/{email}/exists")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        Boolean exists = userexistsByEmailService.exec(email);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/auth")
    public ResponseEntity<User> FindByEmailAndPassword(
            @RequestParam String email,
            @RequestParam String password) {
        User user = userFindByEmailAndPasswordService.exec(email, password);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> Save(@RequestBody CreateUserDto user) {
        User user_save = userSaveService.execute(user);
        return ResponseEntity.ok(user_save);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody UserUpdateDto user) {
        User user_update = userupdateService.exec(user);
        return ResponseEntity.ok(user_update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Integer id) {
        userDeleteService.execute(id);
        return ResponseEntity.noContent().build();
    }
}