package your.company.shadows;

import java.sql.Connection;
import java.util.List;

import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowSQLiteDatabase;

import your.company.TestLogger;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteStatement;

@Implements(SQLiteDatabase.class)
public class TestSQLiteDatabase extends ShadowSQLiteDatabase {

	@Override
	public void lock() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "lock");
		super.lock();
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "lock");
	}

	@Override
	public boolean isDbLockedByCurrentThread() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "isDbLockedByCurrentThread");
		boolean result = super.isDbLockedByCurrentThread();
		TestLogger.debug("%s.%s -> (boolean result = %s)", getClass().getName(), "isDbLockedByCurrentThread", result ? "true" : "faslse");
		return result;
	}

	@Override
	public Connection getConnection() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "getConnection");
		Connection result = super.getConnection();
		TestLogger.debug("%s.%s -> (Connection result)", getClass().getName(), "getConnection");
		return result;
	}

	@Override
	public String getPath() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "getPath");
		String result = super.getPath();
		TestLogger.debug("%s.%s -> (String result = %s)", getClass().getName(), "getPath", result);
		return result;
	}

	@Override
	public long insert(String table, String nullColumnHack, ContentValues values) {
		TestLogger.debug("%s.%s <- (String table = \"%s\", String nullColumnHack = \"%s\", ContentValues values = %s)", getClass().getName(), "insert", table, nullColumnHack, values);
		long result = super.insert(table, nullColumnHack, values);
		TestLogger.debug("%s.%s -> (long result = %d)", getClass().getName(), "insert", result);
		return result;
	}

	@Override
	public long insertOrThrow(String table, String nullColumnHack, ContentValues values) throws SQLException {
		TestLogger.debug("%s.%s <- (String table = \"%s\", String nullColumnHack = \"%s\", ContentValues values = %s) throws SQLException", getClass().getName(), "insertOrThrow", table, nullColumnHack, values);
		long result = super.insertOrThrow(table, nullColumnHack, values);
		TestLogger.debug("%s.%s -> (long result = %d)", getClass().getName(), "insertOrThrow", result);
		return result;
	}

	@Override
	public long insertWithOnConflict(String table, String nullColumnHack, ContentValues initialValues, int conflictAlgorithm) throws SQLException {
		TestLogger.debug("%s.%s <- (String table, String nullColumnHack, ContentValues initialValues, int conflictAlgorithm) throws SQLException", getClass().getName(), "insertWithOnConflict");
		long result = super.insertWithOnConflict(table, nullColumnHack, initialValues, conflictAlgorithm);
		TestLogger.debug("%s.%s -> (long result = %d)", getClass().getName(), "insertWithOnConflict", result);
		return result;
	}

	@Override
	public Cursor query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		TestLogger.debug("%s.%s <- (boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)", getClass().getName(), "query");
		Cursor result = super.query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
		TestLogger.debug("%s.%s -> (Cursor result)", getClass().getName(), "query");
		return result;
	}

	@Override
	public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		TestLogger.debug("%s.%s <- (String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)", getClass().getName(), "query");
		Cursor result = super.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
		TestLogger.debug("%s.%s -> (Cursor result)", getClass().getName(), "query");
		return result;
	}

	@Override
	public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		TestLogger.debug("%s.%s <- (String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)", getClass().getName(), "query");
		Cursor result = super.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
		TestLogger.debug("%s.%s -> (Cursor result)", getClass().getName(), "query");
		return result;
	}

	@Override
	public int delete(String table, String whereClause, String[] whereArgs) {
		TestLogger.debug("%s.%s <- (String table, String whereClause, String[] whereArgs)", getClass().getName(), "delete");
		int result = super.delete(table, whereClause, whereArgs);
		TestLogger.debug("%s.%s -> (int result = %d)", getClass().getName(), "delete", result);
		return result;
	}

	@Override
	public void execSQL(String sql) throws SQLException {
		TestLogger.debug("%s.%s <- (String sql = \"%s\") throws SQLException", getClass().getName(), "execSQL", sql);
		super.execSQL(sql);
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "execSQL");
	}

	@Override
	public void execSQL(String sql, Object[] bindArgs) throws java.sql.SQLException {
		TestLogger.debug("%s.%s <- (String sql = \"%s\", Object[] bindArgs = %s) throws java.sql.SQLException", getClass().getName(), "execSQL", sql, bindArgs);
		super.execSQL(sql, bindArgs);
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "execSQL");
	}

	@Override
	public boolean isOpen() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "isOpen");
		boolean result = super.isOpen();
		TestLogger.debug("%s.%s -> (boolean result = %s)", getClass().getName(), "isOpen", result ? "true" : "false");
		return result;
	}

	@Override
	public void close() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "close");
		super.close();
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "close");
	}

	@Override
	public boolean isReadOnly() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "isReadOnly");
		boolean result = super.isReadOnly();
		TestLogger.debug("%s.%s -> (boolean result)", getClass().getName(), "isReadOnly", result ? "true" : "false");
		return result;
	}

	@Override
	public void beginTransaction() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "beginTransaction");
		super.beginTransaction();
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "beginTransaction");
	}

	@Override
	public void endTransaction() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "endTransaction");
		super.endTransaction();
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "endTransaction");
	}

	@Override
	public boolean inTransaction() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "inTransaction");
		boolean result = super.inTransaction();
		TestLogger.debug("%s.%s -> (boolean result = %s)", getClass().getName(), "inTransaction", result ? "true" : "false");
		return result;
	}

	@Override
	public boolean isTransactionSuccess() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "isTransactionSuccess");
		boolean result = super.isTransactionSuccess();
		TestLogger.debug("%s.%s -> (boolean result = %s)", getClass().getName(), "isTransactionSuccess", result ? "true" : "false");
		return result;
	}

	@Override
	public SQLiteStatement compileStatement(String sql) throws java.sql.SQLException {
		TestLogger.debug("%s.%s <- (String sql = \"%s\") throws java.sql.SQLException", getClass().getName(), "compileStatement", sql);
		SQLiteStatement result = super.compileStatement(sql);
		TestLogger.debug("%s.%s -> (SQLiteStatement result)", getClass().getName(), "compileStatement");
		return result;
	}

	@Override
	public boolean hasOpenCursors() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "hasOpenCursors");
		boolean result = super.hasOpenCursors();
		TestLogger.debug("%s.%s -> (boolean result = %s)", getClass().getName(), "hasOpenCursors", result ? "true" : "false");
		return result;
	}

	@Override
	public List<String> getQuerySql() {
		TestLogger.debug("%s.%s <- > getQuerySql()", getClass().getName(), "getQuerySql");
		List<String> result = super.getQuerySql();
		TestLogger.debug("%s.%s -> (List<String> result = %s)", getClass().getName(), "getQuerySql", result.toArray());
		return result;
	}

	@Override
	public Cursor queryWithFactory(CursorFactory cursorFactory, boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		TestLogger.debug("%s.%s <- (CursorFactory cursorFactory, boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)", getClass().getName(), "queryWithFactory");
		Cursor result = super.queryWithFactory(cursorFactory, distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
		TestLogger.debug("%s.%s -> (Cursor result)", getClass().getName(), "queryWithFactory");
		return result;
	}

	@Override
	public void setLockingEnabled(boolean lockingEnabled) {
		TestLogger.debug("%s.%s <- (boolean lockingEnabled)", getClass().getName(), "setLockingEnabled");
		super.setLockingEnabled(lockingEnabled);
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "setLockingEnabled");
	}

	@Override
	public void unlock() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "unlock");
		super.unlock();
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "unlock");
	}

	@Override
	public void setThrowOnInsert(boolean throwOnInsert) {
		TestLogger.debug("%s.%s <- (boolean throwOnInsert)", getClass().getName(), "setThrowOnInsert");
		super.setThrowOnInsert(throwOnInsert);
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "setThrowOnInsert");
	}

	@Override
	public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
		TestLogger.debug("%s.%s <- (String table, ContentValues values, String whereClause, String[] whereArgs)", getClass().getName(), "update");
		int result = super.update(table, values, whereClause, whereArgs);
		TestLogger.debug("%s.%s -> (int result = %d)", getClass().getName(), "update", result);
		return result;
	}

	@Override
	public Cursor rawQuery(String sql, String[] selectionArgs) {
		TestLogger.debug("%s.%s <- (String sql, String[] selectionArgs)", getClass().getName(), "rawQuery");
		Cursor result = super.rawQuery(sql, selectionArgs);
		TestLogger.debug("%s.%s -> (Cursor result)", getClass().getName(), "rawQuery");
		return result;
	}

	@Override
	public Cursor rawQueryWithFactory(CursorFactory arg0, String arg1, String[] arg2, String arg3) {
		TestLogger.debug("%s.%s <- (CursorFactory arg0, String arg1, String[] arg2, String arg3)", getClass().getName(), "rawQueryWithFactory");
		Cursor result = super.rawQueryWithFactory(arg0, arg1, arg2, arg3);
		TestLogger.debug("%s.%s -> (Cursor result)", getClass().getName(), "rawQueryWithFactory");
		return result;
	}

	@Override
	public long replace(String table, String nullColumnHack, ContentValues values) {
		TestLogger.debug("%s.%s <- (String table, String nullColumnHack, ContentValues values)", getClass().getName(), "replace");
		long result = super.replace(table, nullColumnHack, values);
		TestLogger.debug("%s.%s -> (long result = %d)", getClass().getName(), "replace", result);
		return result;
	}

	@Override
	public long replaceOrThrow(String table, String nullColumnHack, ContentValues values) {
		TestLogger.debug("%s.%s <- (String table, String nullColumnHack, ContentValues values)", getClass().getName(), "replaceOrThrow");
		long result = super.replaceOrThrow(table, nullColumnHack, values);
		TestLogger.debug("%s.%s -> (long result = %d)", getClass().getName(), "replaceOrThrow", result);
		return result;
	}

	@Override
	public void setTransactionSuccessful() {
		TestLogger.debug("%s.%s <- ()", getClass().getName(), "setTransactionSuccessful");
		super.setTransactionSuccessful();
		TestLogger.debug("%s.%s -> ()", getClass().getName(), "setTransactionSuccessful");
	}

}