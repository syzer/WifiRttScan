package com.example.android.wifirttscan.data.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.android.wifirttscan.data.entity.ApEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ApDao_Impl implements ApDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ApEntity> __insertionAdapterOfApEntity;

  public ApDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfApEntity = new EntityInsertionAdapter<ApEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ApEntity` (`BSSID`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ApEntity value) {
        if (value.BSSID == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.BSSID);
        }
      }
    };
  }

  @Override
  public void insertAP(final ApEntity apEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfApEntity.insert(apEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public ApEntity findByBSSID(final String BSSID) {
    final String _sql = "SELECT * FROM ApEntity WHERE BSSID LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BSSID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BSSID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBSSID = CursorUtil.getColumnIndexOrThrow(_cursor, "BSSID");
      final ApEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new ApEntity();
        if (_cursor.isNull(_cursorIndexOfBSSID)) {
          _result.BSSID = null;
        } else {
          _result.BSSID = _cursor.getString(_cursorIndexOfBSSID);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
