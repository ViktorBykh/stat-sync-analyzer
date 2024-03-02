package stat_sync_analyzer.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import stat_sync_analyzer.dto.response.UserResponseDto;

@RequiredArgsConstructor
@Component
public class AuthProvider {
    public static final String USERNAME = "username";

    @Value("${jwt.token.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expire-length.ms}")
    private long validityPeriod;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(UserResponseDto dto) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityPeriod);

        return JWT.create()
                .withIssuer(dto.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withClaim(USERNAME, dto.getUsername())
                .sign(Algorithm.HMAC256(secretKey));
    }

    public Authentication validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedToken = verifier.verify(token);
        UserResponseDto user = new UserResponseDto()
                .setUsername(decodedToken.getIssuer());

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }
}
