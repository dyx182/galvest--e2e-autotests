package galvest;

public class TestData {

    public enum ProductIndex {
        EPOXY_GLUE(13),
        SEALANT(5);

        private final int index;

        ProductIndex(int index) { this.index = index; }

        public int getIndex() { return index; }
    }

    public static final String BASE_URL = "https://galvest.ru/";

    public static final String PHONE_NUMBER = "79998887765";

    public static final String USERNAME = "Тестов Тест Тестович";

    public static final String EMAIL = "test@test.ru";

    public static final String AMOUNT = "30 400";

    public static final String USER_TYPE = "Физическое лицо";

    public static final String COMMENT = "Тестовый комментарий";

    private TestData() {
        throw new UnsupportedOperationException("This is a constants class and cannot be instantiated");
    }
}
