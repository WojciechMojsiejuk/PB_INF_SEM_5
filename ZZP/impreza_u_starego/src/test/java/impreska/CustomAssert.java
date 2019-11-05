package impreska;

import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.Assertions;

public class CustomAssert extends AbstractAssert<CustomAssert, String> {

    private CustomAssert(String actual){
        super(actual, CustomAssert.class);
    }

    public static CustomAssert assertThat(String actual){
        return new CustomAssert(actual);
    }

    public CustomAssert hasLength(String input){
        isNotNull();
        Assertions.assertTrue(input.length() >= 10);
        return this;
    }
}
