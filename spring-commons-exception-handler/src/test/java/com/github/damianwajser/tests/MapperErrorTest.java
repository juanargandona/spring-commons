package com.github.damianwajser.tests;

import com.github.damianwajser.utils.TestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperErrorTest {
	@Test
	public void ParseMessage() throws Exception {
		String bodyCammel = "{\"details\":[{\"errorCode\":\"400\",\"errorMessage\":\"badrequest\",\"errorDetail\":null,\"metaData\":null}]}";
		Assert.assertEquals("400", TestUtils.getMessage(bodyCammel).getDetails().get(0).getErrorCode());
		String bodySnake = "{\"details\":[{\"error_code\":\"400\",\"error_message\":\"badrequest\",\"error_detail\":null,\"meta_data\":null}]}";
		Assert.assertEquals("400", TestUtils.getMessage(bodySnake).getDetails().get(0).getErrorCode());
	}
}
