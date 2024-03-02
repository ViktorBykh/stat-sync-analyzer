package stat_sync_analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class StatSyncAnalyzerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatSyncAnalyzerApplication.class, args);
    }
}
