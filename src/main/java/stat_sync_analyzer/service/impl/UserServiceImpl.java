package stat_sync_analyzer.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import stat_sync_analyzer.dto.request.UserRequestDto;
import stat_sync_analyzer.dto.response.UserResponseDto;
import stat_sync_analyzer.exception.AuthenticationException;
import stat_sync_analyzer.mapper.UserMapper;
import stat_sync_analyzer.model.user.User;
import stat_sync_analyzer.repository.UserRepository;
import stat_sync_analyzer.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto login(UserRequestDto userRequestDto) {
        User user = userRepository.findByUsername(userRequestDto.getUsername()).orElseThrow(() ->
                new AuthenticationException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(userRequestDto.getUsername(), user.getPassword())) {
            return userMapper.mapToDto(user);
        }
        throw new AuthenticationException("Invalid password or username", HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserResponseDto register(UserRequestDto userRequestDto) {
        Optional<User> optionalUser = userRepository.findByUsername(userRequestDto.getUsername());

        if (optionalUser.isPresent()) {
            throw new AuthenticationException("User with such username already exists",
                    HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.mapToEntity(userRequestDto);
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        User savedUser = userRepository.save(user);

        return userMapper.mapToDto(savedUser);
    }
}
