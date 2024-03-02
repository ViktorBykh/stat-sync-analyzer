package stat_sync_analyzer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import stat_sync_analyzer.dto.request.UserRequestDto;
import stat_sync_analyzer.dto.response.UserResponseDto;
import stat_sync_analyzer.model.user.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "token", ignore = true)
    UserResponseDto mapToDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    User mapToEntity(UserRequestDto userRequestDto);
}
