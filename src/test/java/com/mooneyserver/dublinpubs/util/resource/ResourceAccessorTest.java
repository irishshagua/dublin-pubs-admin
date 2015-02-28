package com.mooneyserver.dublinpubs.util.resource;

import java.io.IOException;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class ResourceAccessorTest {

	@Test
	public void testGetResourceBundleReturnsResourceBundle() {
		Assert.assertNotNull(new ResourceAccessor().getResourceBundle());
	}

	@Test
	public void testGetResourceBundleUsesCorrectLocale() {
		Locale defaultLocale = Locale.getDefault();
		Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
		try {
			Assert.assertEquals(Locale.SIMPLIFIED_CHINESE,
					new ResourceAccessor().getResourceBundle().getLocale());
		} finally {
			Locale.setDefault(defaultLocale);
		}
	}

	@Test
	public void testGetMainFxmlIsNotNull() {
		verifyResourceIsNotNull(ResourceAccessor.FXML_LANDING_PAGE);
	}

	@Test
	public void testMainFxmlUrlResolvesToFxmlFile() throws IOException {
		verifyResourceResolvesToContent(ResourceAccessor.FXML_LANDING_PAGE);
	}

	@Test
	public void testGetCssIsNotNull() {
		verifyResourceIsNotNull(ResourceAccessor.CSS_APP);
	}

	@Test
	public void testCssUrlResolvesToCssFile() throws IOException {
		verifyResourceResolvesToContent(ResourceAccessor.CSS_APP);
	}

	private void verifyResourceIsNotNull(String resourceName) {
		Assert.assertNotNull(new ResourceAccessor().getResource(resourceName));
	}

	private void verifyResourceResolvesToContent(String resourceName)
			throws IOException {
		Assert.assertNotNull(new ResourceAccessor().getResource(resourceName)
				.getContent());
	}
}