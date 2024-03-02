package stat_sync_analyzer.model.user;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
}
