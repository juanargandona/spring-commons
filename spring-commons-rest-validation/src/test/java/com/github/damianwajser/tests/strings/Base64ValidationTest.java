package com.github.damianwajser.tests.strings;

import com.github.damianwajser.model.strings.Base64StringObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.github.damianwajser.TestUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class Base64ValidationTest {

    @Test
    public void base64_string() {
        assertThat(validationFor(new Base64StringObject(), onField("value")), fails());
        assertThat(validationFor(new Base64StringObject("c3ByaW5nLWNvbW1vbnM="), onField("value")), succedes());
        //isBase64 treats whitespace as valid
        assertThat(validationFor(new Base64StringObject("a b c d"), onField("value")), succedes());
        assertThat(validationFor(new Base64StringObject("c3ByaW5nLWNvbW1vbn..."), onField("value")), fails());
        assertThat(validationFor(new Base64StringObject("abcd**"), onField("value")), fails());
    }

}
