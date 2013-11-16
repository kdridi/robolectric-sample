package your.company.shadows;

import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowSQLiteOpenHelper;

import your.company.TestLogger;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

@Implements(SQLiteOpenHelper.class)
public class TestSQLiteOpenHelper extends ShadowSQLiteOpenHelper {

	@Override
	public void __constructor__(Context context, String name, CursorFactory factory, int version) {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "__constructor__");
		super.__constructor__(context, name, factory, version);
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "__constructor__");
	}

	@Override
	public synchronized void close() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "close");
		super.close();
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "close");
	}

	@Override
	public synchronized SQLiteDatabase getReadableDatabase() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "getReadableDatabase");
		SQLiteDatabase result = super.getReadableDatabase();
		TestLogger.debug("%s.%s -> (SQLiteDatabase result)", getClass().getName(), "getReadableDatabase");
		return result;
	}

	@Override
	public synchronized SQLiteDatabase getWritableDatabase() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "getWritableDatabase");
		SQLiteDatabase result = super.getWritableDatabase();
		TestLogger.debug("%s.%s -> (SQLiteDatabase result)", getClass().getName(), "getWritableDatabase");
		return result;
	}

	@Override
	public String getDatabaseName() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "getDatabaseName");
		String result = super.getDatabaseName();
		TestLogger.debug("%s.%s -> (String result = \"%s\")", getClass().getName(), "getDatabaseName", result);
		return result;
	}

}
