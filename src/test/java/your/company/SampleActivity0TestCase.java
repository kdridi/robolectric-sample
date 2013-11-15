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
public class SampleActivity0TestCase {
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
	public void testFunctionA() {
		Assert.assertEquals(0, activity.feedQueryForAll().size());
		Assert.assertEquals(0, activity.feedQueryForAll().size());
	}
}
