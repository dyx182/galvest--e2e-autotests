package galvest.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CatalogSections {

    ANCHOR("Анкерные составы"),
    CONCRETE_PROTECTION("Ремонт и защита бетона"),


    private final String desc;
}
