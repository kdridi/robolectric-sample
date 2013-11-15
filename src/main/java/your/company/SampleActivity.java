package your.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import your.company.SampleDatabase.DAO;
import your.company.SampleDatabase.Helper;
import your.company.SampleDatabase.Model;
import android.app.Activity;

import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OptionsMenu;
import com.googlecode.androidannotations.annotations.OrmLiteDao;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class SampleActivity extends Activity {

	@OrmLiteDao(helper = Helper.class, model = Model.Feed.class)
	DAO.Feed feedDAO;

	public Model.Feed feedCreateOrUpdate(String url, String title, String link) {
		Model.Feed result = null;
		try {
			result = feedDAO.createOrUpdate(url, title, link);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public List<Model.Feed> feedQueryForAll() {
		final List<Model.Feed> result = new ArrayList<Model.Feed>();
		try {
			result.addAll(feedDAO.queryForAll());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return Collections.unmodifiableList(result);
	}
}
