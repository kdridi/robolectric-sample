package your.company;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableUtils;

public class SampleDatabase {
	public static abstract class DAO<M extends Model> extends BaseDaoImpl<M, Long> {

		private DAO(Class<M> dataClass) throws SQLException {
			super(dataClass);
		}

		private DAO(ConnectionSource connectionSource, Class<M> dataClass) throws SQLException {
			super(connectionSource, dataClass);
		}

		private DAO(ConnectionSource connectionSource, DatabaseTableConfig<M> tableConfig) throws SQLException {
			super(connectionSource, tableConfig);
		}

		public M queryUniqueForProperty(String property, Object value) throws SQLException {
			M result = null;
			final List<M> models = Collections.unmodifiableList(queryForEq(property, value));
			final int size = models.size();
			if (size == 1) {
				result = models.iterator().next();
			} else if (size > 1) {
				throw new SQLException("Not unique");
			} else if (size < 0) {
				throw new SQLException("Illegal Error");
			}
			return result;
		}

		public static class Feed extends DAO<Model.Feed> {
			protected Feed() throws SQLException {
				super(Model.Feed.class);
			}

			public Feed(ConnectionSource connectionSource) throws SQLException {
				super(connectionSource, Model.Feed.class);
			}

			public Feed(ConnectionSource connectionSource, DatabaseTableConfig<Model.Feed> tableConfig) throws SQLException {
				super(connectionSource, tableConfig);
			}

			public Model.Feed findByURL(String url) throws SQLException {
				return queryUniqueForProperty(Model.Feed.PROPERTY_URL, url);
			}

			public Model.Feed createOrUpdate(String url, String title, String link) throws SQLException {
				boolean created = false;
				Model.Feed feed = findByURL(url);
				if (feed == null) {
					feed = new Model.Feed(url);
					created = true;
				}
				feed.setTitle(title);
				feed.setLink(link);
				CreateOrUpdateStatus status = createOrUpdate(feed);
				if (status.isCreated() != created) {
					throw new SQLiteException();
				}
				return feed;
			}
		}
	}

	public static abstract class Model implements Serializable {
		private static final long serialVersionUID = -991229410636319900L;

		private Model() {
			super();
			setId(null);
		}

		// /////////////////////////////////////////////////////////////////////////
		// ID
		// /////////////////////////////////////////////////////////////////////////
		public static final String PROPERTY_ID = "id";
		@DatabaseField(generatedId = true, columnName = PROPERTY_ID)
		private Long id;

		public Long getId() {
			return id;
		}

		private void setId(Long id) {
			this.id = id;
		}

		@DatabaseTable(tableName = Feed.TABLE_NAME, daoClass = DAO.Feed.class)
		public static class Feed extends Model {
			public final static String TABLE_NAME = "feed";

			private static final long serialVersionUID = -6244432707125478559L;

			public Feed(String url) {
				this();
				setUrl(url);
			}

			private Feed() {
				super();
				setUrl(null);
				setLink(null);
				setTitle(null);
			}

			// /////////////////////////////////////////////////////////////////////////
			// URL
			// /////////////////////////////////////////////////////////////////////////
			public static final String PROPERTY_URL = "url";
			@DatabaseField(index = true, dataType = DataType.STRING, columnName = PROPERTY_URL)
			private String url;

			public String getUrl() {
				return url;
			}

			private void setUrl(String url) {
				this.url = url;
			}

			// /////////////////////////////////////////////////////////////////////////
			// URL
			// /////////////////////////////////////////////////////////////////////////
			public static final String PROPERTY_LINK = "link";
			@DatabaseField(index = false, dataType = DataType.STRING, columnName = PROPERTY_LINK)
			private String link;

			public String getLink() {
				return link;
			}

			public void setLink(String link) {
				this.link = link;
			}

			// /////////////////////////////////////////////////////////////////////////
			// TITLE
			// /////////////////////////////////////////////////////////////////////////
			public static final String PROPERTY_TITLE = "title";
			@DatabaseField(index = false, dataType = DataType.STRING, columnName = PROPERTY_TITLE)
			private String title;

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}
		}
	}

	private static class Config {
		public static final String NAME = "name";
		public static final CursorFactory FACTORY = null;
		public static final int VERSION = 1;
	}

	public static class Helper extends OrmLiteSqliteOpenHelper {

		public Helper(Context context) {
			super(context, Config.NAME, Config.FACTORY, Config.VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
			Log.i(getClass().getName(), "onCreate");
			try {
				TableUtils.createTable(connectionSource, Model.Feed.class);
			} catch (Exception e) {
				Log.e(getClass().getName(), "Can't create database", e);
				throw new RuntimeException(e);
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
			Log.i(getClass().getName(), "onUpgrade");
			try {
				TableUtils.dropTable(connectionSource, Model.Feed.class, false);
			} catch (Exception e) {
				Log.e(getClass().getName(), "Can't upgrade database", e);
				throw new RuntimeException(e);
			}
			onCreate(database, connectionSource);
		}

	}

}
