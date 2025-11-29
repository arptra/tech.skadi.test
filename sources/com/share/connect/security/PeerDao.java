package com.share.connect.security;

import androidx.room.Dao;

@Dao
public interface PeerDao {
    void a(String str);

    long b(Peer peer);

    int c(String str);

    Peer get(String str);

    Peer getLast();
}
