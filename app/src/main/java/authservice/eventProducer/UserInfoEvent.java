package authservice.eventProducer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@JsonNaming (PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoEvent
{
    private String firstName;

    private String lastName;

    private String email;

    private Long phoneNumber;

    private String userId;
}
