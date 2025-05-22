package galvest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class IndividualDTO {

    private final String userType;
    private final String userName;
    private final String phoneNumber;
    private final String email;
    private final String comment;

}
