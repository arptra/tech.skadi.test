package com.upuphone.xr.sapp.monitor.notification.cache;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.upuphone.xr.sapp.monitor.notification.model.ArTakeoutModel;
import java.util.Collections;
import java.util.List;

public final class TakeoutDao_Impl implements TakeoutDao {

    /* renamed from: com.upuphone.xr.sapp.monitor.notification.cache.TakeoutDao_Impl$1  reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<ArTakeoutModel> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `ArTakeout` (`id`,`crate_time`,`reminder_type`,`package_name`,`takeout_state`,`takeout_state_desc`,`estimated_delivery_time`,`show_text`,`restaurant_name`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: d */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ArTakeoutModel arTakeoutModel) {
            supportSQLiteStatement.B(1, arTakeoutModel.getId());
            supportSQLiteStatement.F(2, arTakeoutModel.getCrateTime());
            supportSQLiteStatement.B(3, arTakeoutModel.getReminderType());
            supportSQLiteStatement.B(4, arTakeoutModel.getPackageName());
            supportSQLiteStatement.B(5, arTakeoutModel.getTakeoutState());
            supportSQLiteStatement.B(6, arTakeoutModel.getTakeoutStateDesc());
            supportSQLiteStatement.B(7, arTakeoutModel.getEstimatedDeliveryTime());
            supportSQLiteStatement.B(8, arTakeoutModel.getShowText());
            supportSQLiteStatement.B(9, arTakeoutModel.getRestaurantName());
        }
    }

    /* renamed from: com.upuphone.xr.sapp.monitor.notification.cache.TakeoutDao_Impl$2  reason: invalid class name */
    class AnonymousClass2 extends EntityDeletionOrUpdateAdapter<ArTakeoutModel> {
        public String createQuery() {
            return "DELETE FROM `ArTakeout` WHERE `id` = ?";
        }

        /* renamed from: d */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ArTakeoutModel arTakeoutModel) {
            supportSQLiteStatement.B(1, arTakeoutModel.getId());
        }
    }

    /* renamed from: com.upuphone.xr.sapp.monitor.notification.cache.TakeoutDao_Impl$3  reason: invalid class name */
    class AnonymousClass3 extends EntityDeletionOrUpdateAdapter<ArTakeoutModel> {
        public String createQuery() {
            return "UPDATE OR ABORT `ArTakeout` SET `id` = ?,`crate_time` = ?,`reminder_type` = ?,`package_name` = ?,`takeout_state` = ?,`takeout_state_desc` = ?,`estimated_delivery_time` = ?,`show_text` = ?,`restaurant_name` = ? WHERE `id` = ?";
        }

        /* renamed from: d */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ArTakeoutModel arTakeoutModel) {
            supportSQLiteStatement.B(1, arTakeoutModel.getId());
            supportSQLiteStatement.F(2, arTakeoutModel.getCrateTime());
            supportSQLiteStatement.B(3, arTakeoutModel.getReminderType());
            supportSQLiteStatement.B(4, arTakeoutModel.getPackageName());
            supportSQLiteStatement.B(5, arTakeoutModel.getTakeoutState());
            supportSQLiteStatement.B(6, arTakeoutModel.getTakeoutStateDesc());
            supportSQLiteStatement.B(7, arTakeoutModel.getEstimatedDeliveryTime());
            supportSQLiteStatement.B(8, arTakeoutModel.getShowText());
            supportSQLiteStatement.B(9, arTakeoutModel.getRestaurantName());
            supportSQLiteStatement.B(10, arTakeoutModel.getId());
        }
    }

    /* renamed from: com.upuphone.xr.sapp.monitor.notification.cache.TakeoutDao_Impl$4  reason: invalid class name */
    class AnonymousClass4 extends SharedSQLiteStatement {
        public String createQuery() {
            return "delete from ArTakeout";
        }
    }

    public static List e() {
        return Collections.emptyList();
    }
}
