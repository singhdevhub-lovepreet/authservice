package authservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "event.publisher")
@Data
public class EventPublisherConfig
{

    private String bootstrapServers;

}
