package com.share.connect.security;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database
public abstract class PeerDatabase extends RoomDatabase {
    public abstract PeerDao d();
}
