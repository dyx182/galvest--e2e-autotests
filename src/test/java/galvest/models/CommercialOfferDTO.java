package galvest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CommercialOfferDTO {

    private final String company;
    private final String userName;
    private final String object;

}
