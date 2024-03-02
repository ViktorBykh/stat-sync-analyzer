package stat_sync_analyzer.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stat_sync_analyzer.config.AuthProvider;
import stat_sync_analyzer.dto.request.UserRequestDto;
import stat_sync_analyzer.dto.response.UserResponseDto;
import stat_sync_analyzer.service.UserService;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;
    private final AuthProvider authProvider;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto loggedUser = userService.login(userRequestDto);
        loggedUser.setToken(authProvider.createToken(loggedUser));
        return ResponseEntity.ok(loggedUser);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto createdUser = userService.register(userRequestDto);
        createdUser.setToken(authProvider.createToken(createdUser));
        return ResponseEntity
                .created(URI.create("/user/" + createdUser.getId()))
                .body(createdUser);
    }
}
