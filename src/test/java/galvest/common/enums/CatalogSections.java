package galvest.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CatalogSections {

    ANCHOR("Анкерные составы", 0),
    CONCRETE_PROTECTION("Ремонт и защита бетона", 1),
    ANTI_CORROSION("Антикоррозийные покрытия", 2),
    STRENGTHENING_STRUCTURES("Усиление конструкций", 3),
    WATERPROOFING("Гидроизоляция бетона", 4),
    SEALANTS("Герметики", 5),
    INDUSTRIAL_FLOORS("Промышленные полы", 6),
    GLUE("Клеи", 7);


    private final String desc;
    private final int index;
}
