package aem.core.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class IdentiteAssertion extends AbstractAssert<IdentiteAssertion, String>{

        private IdentiteAssertion(String actual) {
        super(actual, IdentiteAssertion.class);
    }

        public static IdentiteAssertion assertThat(String actual) {
        return new IdentiteAssertion(actual);
    }

        public IdentiteAssertion displayMessageEquals(String expected) {
        Assertions.assertThat(actual).isEqualTo(expected);
        return this;
    }

}
