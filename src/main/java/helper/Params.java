package helper;

import com.google.common.collect.ImmutableMap;
import commons.StringSubstituteUtil;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.Map;

public class Params {

    private final Map<String, String> params;

    public Params(Map<String, String> params) {
        this.params = params;
    }

    public static ParamsBuilder builder() {
        return new ParamsBuilder();
    }

    public static Params single(String name, Object value) {
        return new ParamsBuilder().param(name, value).build();
    }

    public String applyOn(String value) {
        return StringSubstituteUtil.replacePlaceholders(value, params);
    }

    public static class ParamsBuilder {

        private final ImmutableMap.Builder<String, String> map;

        public ParamsBuilder() {
            this.map = ImmutableMap.builder();
        }

        public ParamsBuilder param(String name, Object value) {
            map.put(name, String.valueOf(value));
            return this;
        }

        public Params build() {
            return new Params(map.build());
        }
    }
}