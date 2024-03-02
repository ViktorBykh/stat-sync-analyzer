package stat_sync_analyzer.dto.response;

import lombok.Data;

@Data
public class ErrorResponseDto {
    private String message;

    public ErrorResponseDto(String message) {
        this.message = message;
    }
}
