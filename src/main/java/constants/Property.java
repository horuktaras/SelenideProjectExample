package constants;

public enum Property {

    BASE_URL("base.url", "https://www.saucedemo.com"),
    RETRIES_NUM("retries", Integer.toString(3)),
    TIMEOUT_MILLS("timeout", Long.toString(5000)),
    HEADLESS("headless", Boolean.TRUE.toString()),
    EXTENT_REPORT("report.output", "target/test-output/extent-report.html");

    private final String propertyName;
    private final String defaultValue;

    Property(String propertyName, String defaultValue) {
        this.propertyName = propertyName;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return propertyName;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}