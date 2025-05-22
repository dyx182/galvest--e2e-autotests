package galvest.testdata;

import galvest.models.CommercialOfferDTO;
import galvest.models.IndividualDTO;

public class TestData {

    public static IndividualDTO INDIVIDUAL_DATA = IndividualDTO.builder()
            .userType("Физическое лицо")
            .userName("Тестов Тест Тестович")
            .email("test@test.ru")
            .phoneNumber("79998887765")
            .comment("Тестовый комментарий")
            .build();

    public static CommercialOfferDTO COMMERCIAL_OFFER_DATA = CommercialOfferDTO.builder()
            .company("Тестовая")
            .userName("Тестовый Иван Иванович")
            .object("Новый объект")
            .build();


}
