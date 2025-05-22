package galvest.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Product {
    GLUE_PRODUCT(13,"30 400"),
    ANCHOR_PRODUCT(0,"2 318");

    private final int index;
    private final String amount;

}
