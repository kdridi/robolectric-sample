package your.company;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import com.j256.ormlite.android.apptools.OpenHelperManager;

@RunWith(RobolectricTestRunner.class)
public class SampleActivity1TestCase {
	private SampleActivity activity;

	@Before
	public void setUp() {
		activity = Robolectric.buildActivity(SampleActivity_.class).create().get();
	}

	@After
	public void tearDown() {
		OpenHelperManager.releaseHelper();
	}

	@Test
	public void testFunctionB() {
		Assert.assertEquals(0, activity.feedQueryForAll().size());
		Assert.assertNotNull(activity.feedCreateOrUpdate("url0", "title0", "link0"));
		Assert.assertEquals(1, activity.feedQueryForAll().size());
		Assert.assertNotNull(activity.feedCreateOrUpdate("url1", "title1", "link1"));
		Assert.assertEquals(2, activity.feedQueryForAll().size());
		Assert.assertNotNull(activity.feedCreateOrUpdate("url1", "title1", "link1"));
		Assert.assertEquals(2, activity.feedQueryForAll().size());
		Assert.assertNotNull(activity.feedCreateOrUpdate("url2", "title2", "link2"));
		Assert.assertEquals(3, activity.feedQueryForAll().size());
	}
}
