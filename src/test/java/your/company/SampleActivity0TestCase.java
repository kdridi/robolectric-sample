package your.company;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import your.company.shadows.TestSQLiteDatabase;
import your.company.shadows.TestSQLiteOpenHelper;

import com.j256.ormlite.android.apptools.OpenHelperManager;

@Config(shadows = { TestSQLiteDatabase.class, TestSQLiteOpenHelper.class })
@RunWith(RobolectricTestRunner.class)
public class SampleActivity0TestCase {
	private SampleActivity activity;

	@Before
	public void setUp() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "setUp");
		activity = Robolectric.buildActivity(SampleActivity_.class).create().get();
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "setUp");
	}

	@After
	public void tearDown() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "tearDown");
		OpenHelperManager.releaseHelper();
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "tearDown");
	}

	@Test
	public void testFunctionA() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "testFunctionA");
		try {
			assertEquals(0, activity.feedQueryForAll().size());
			assertEquals(0, activity.feedQueryForAll().size());
		} catch (Exception e) {
			e.printStackTrace();
			assertNull(e);
		}
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "testFunctionA");
	}

}
