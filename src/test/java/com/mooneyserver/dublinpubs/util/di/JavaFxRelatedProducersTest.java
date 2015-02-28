package com.mooneyserver.dublinpubs.util.di;

import org.junit.Assert;
import org.junit.Test;

public class JavaFxRelatedProducersTest {

	@Test
	public void testCreateLoader() {
		Assert.assertNotNull(new JavaFxRelatedProducers().createLoader());
	}
}