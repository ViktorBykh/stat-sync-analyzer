package stat_sync_analyzer.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserResponseDto {
    private String id;
    private String username;
    private String token;
}
