package your.company;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class SampleActivity0TestCase {
	private SampleActivity activity;

	@Before
	public void setUp() {
		activity = Robolectric.buildActivity(SampleActivity_.class).create().get();
	}

	@Test
	public void testFunctionA() {
		Assert.assertEquals(0, activity.feedQueryForAll().size());
		Assert.assertEquals(0, activity.feedQueryForAll().size());
	}
}
