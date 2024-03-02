package stat_sync_analyzer.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import stat_sync_analyzer.dto.response.ErrorResponseDto;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {AuthenticationException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponseDto> handleException(AuthenticationException ex) {
        return ResponseEntity.status(ex.getHttpStatus())
                .body(new ErrorResponseDto(ex.getMessage()));
    }
}
