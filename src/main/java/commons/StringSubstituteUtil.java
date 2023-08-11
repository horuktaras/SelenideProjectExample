package commons;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSubstituteUtil {

    public static String replacePlaceholders(String value, Map<String, String> params) {
        Pattern pattern = Pattern.compile("\\{([^}]+)}");
        Matcher matcher = pattern.matcher(value);

        while (matcher.find()) {
            String placeholder = matcher.group(0);
            String key = matcher.group(1);
            if (params.containsKey(key)) {
                value = value.replace(placeholder, params.get(key));
            }
        }
        return value;
    }
}
