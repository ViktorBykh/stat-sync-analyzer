package stat_sync_analyzer.service;

import stat_sync_analyzer.dto.request.UserRequestDto;
import stat_sync_analyzer.dto.response.UserResponseDto;
import stat_sync_analyzer.model.user.User;

public interface UserService {
    UserResponseDto login(UserRequestDto userRequestDto);

    UserResponseDto register(UserRequestDto userRequestDto);
}
