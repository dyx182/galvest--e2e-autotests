package galvest.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Filter {

    BRAND_BASF("BASF"),
    BRAND_MAPEI("MAPEI"),
    BRAND_PCI("PCI"),
    BRAND_SIKA("Sika"),

    DIAMETER_1MM("1 мм."),
    DIAMETER_10MM("10 мм."),
    DIAMETER_2_5MM("2,5 мм."),
    DIAMETER_3MM("3 мм."),
    DIAMETER_6MM("6 мм."),

    BASE_VINYL_ETHER("Винилэфир"),
    BASE_METHACRYLATE("Метакрилат"),
    BASE_POLYESTER("Полиэфир"),
    BASE_CEMENT("Цементная"),
    BASE_EPOXY("Эпоксидная"),

    COUNTRY_GERMANY("Германия"),
    COUNTRY_RUSSIA("Россия"),
    COUNTRY_SWITZERLAND("Швейцария"),

    TEMP_UP_TO_5("до +5℃"),
    TEMP_UP_TO_MINUS_5("до -5℃"),
    TEMP_UP_TO_MINUS_10("до -10℃"),
    TEMP_UP_TO_MINUS_20("до -20℃"),

    TYPE_POURABLE("Наливного типа"),
    TYPE_THIXOTROPIC("Тиксотропного типа");


    private final String value;

}
