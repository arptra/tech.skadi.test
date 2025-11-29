package com.upuphone.ar.fastrecord.phone.db;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.here.posclient.PositionEstimate;
import com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean;
import com.upuphone.runasone.uupcast.CaptureType;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b¯\u0001\b\b\u0018\u00002\u00020\u0001Bõ\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0018\u0012\b\b\u0002\u0010#\u001a\u00020\u0018\u0012\b\b\u0002\u0010$\u001a\u00020\u0018\u0012\b\b\u0002\u0010%\u001a\u00020\u0018\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\b\b\u0002\u0010(\u001a\u00020\u0005\u0012\b\b\u0002\u0010)\u001a\u00020\u0018\u0012\b\b\u0002\u0010*\u001a\u00020\u0018\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\b\b\u0002\u0010,\u001a\u00020\u0005\u0012\b\b\u0002\u0010-\u001a\u00020\u0003\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u0018\u0012\b\b\u0002\u00100\u001a\u00020\u0003\u0012\b\b\u0002\u00101\u001a\u00020\u0018\u0012\b\b\u0002\u00102\u001a\u00020\u0018\u0012\b\b\u0002\u00103\u001a\u00020\u0018\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u00107\u001a\u00020\u0014\u0012\b\b\u0002\u00108\u001a\u00020\u0014\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;\u0012\u0018\b\u0002\u0010=\u001a\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@\u0012\u0018\b\u0002\u0010A\u001a\u0012\u0012\u0004\u0012\u00020B0>j\b\u0012\u0004\u0012\u00020B`@¢\u0006\u0002\u0010CJ\n\u0010µ\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010º\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010½\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010Â\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010È\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010É\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Ó\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010×\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ù\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Û\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Ý\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Þ\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010ß\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010à\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010á\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010â\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010ã\u0001\u001a\u00020\u0014HÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010å\u0001\u001a\b\u0012\u0004\u0012\u00020<0;HÆ\u0003J\u001a\u0010æ\u0001\u001a\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@HÆ\u0003J\u001a\u0010ç\u0001\u001a\u0012\u0012\u0004\u0012\u00020B0>j\b\u0012\u0004\u0012\u00020B`@HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010é\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010ê\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010ë\u0001\u001a\u00020\u0003HÆ\u0003Jú\u0004\u0010ì\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00182\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010$\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00182\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00182\b\b\u0002\u00102\u001a\u00020\u00182\b\b\u0002\u00103\u001a\u00020\u00182\b\b\u0002\u00104\u001a\u00020\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00107\u001a\u00020\u00142\b\b\u0002\u00108\u001a\u00020\u00142\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\u0018\b\u0002\u0010=\u001a\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@2\u0018\b\u0002\u0010A\u001a\u0012\u0012\u0004\u0012\u00020B0>j\b\u0012\u0004\u0012\u00020B`@HÆ\u0001J\u0015\u0010í\u0001\u001a\u00020\u00182\t\u0010î\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010ï\u0001\u001a\u00020\u0014HÖ\u0001J\n\u0010ð\u0001\u001a\u00020\u0005HÖ\u0001R\u001a\u0010'\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u00103\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001e\u00102\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010M\"\u0004\bQ\u0010OR\u001e\u00104\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001e\u00101\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010M\"\u0004\bW\u0010OR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010E\"\u0004\bY\u0010GR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010E\"\u0004\b[\u0010GR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010E\"\u0004\b]\u0010GR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010E\"\u0004\b_\u0010GR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010E\"\u0004\ba\u0010GR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010E\"\u0004\bc\u0010GR\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010E\"\u0004\be\u0010GR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010S\"\u0004\bg\u0010UR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010E\"\u0004\bi\u0010GR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010E\"\u0004\bk\u0010GR\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010S\"\u0004\bm\u0010UR\u001a\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010M\"\u0004\bo\u0010OR\u001e\u0010/\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010M\"\u0004\bp\u0010OR\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010M\"\u0004\bq\u0010OR\u001a\u0010)\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010M\"\u0004\br\u0010OR\u001a\u0010$\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010M\"\u0004\bs\u0010OR\u001a\u0010#\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010M\"\u0004\bt\u0010OR\u001a\u0010\u001b\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010M\"\u0004\bu\u0010OR\u001a\u0010%\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010M\"\u0004\bv\u0010OR\u001a\u0010\"\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010M\"\u0004\bw\u0010OR\u001a\u0010*\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010M\"\u0004\bx\u0010OR\u001a\u0010,\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010E\"\u0004\bz\u0010GR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010S\"\u0004\b|\u0010UR\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010S\"\u0004\b~\u0010UR\u001d\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010E\"\u0005\b\u0001\u0010GR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010E\"\u0005\b\u0001\u0010GR\u001c\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010S\"\u0005\b\u0001\u0010UR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010E\"\u0005\b\u0001\u0010GR\u001c\u0010+\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010S\"\u0005\b\u0001\u0010UR2\u0010A\u001a\u0012\u0012\u0004\u0012\u00020B0>j\b\u0012\u0004\u0012\u00020B`@8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001c\u0010(\u001a\u00020\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010E\"\u0005\b\u0001\u0010GR \u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010S\"\u0005\b\u0001\u0010UR\u001e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001c\u0010&\u001a\u00020\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010E\"\u0005\b\u0001\u0010GR\"\u00108\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u00107\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u00109\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010E\"\u0005\b\u0001\u0010GR\"\u00105\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010E\"\u0005\b \u0001\u0010GR\"\u00106\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010E\"\u0005\b¢\u0001\u0010GR \u00100\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010S\"\u0005\b¤\u0001\u0010UR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010E\"\u0005\b¦\u0001\u0010GR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010E\"\u0005\b¨\u0001\u0010GR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010E\"\u0005\bª\u0001\u0010GR2\u0010=\u001a\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0001\u0010\u0001\"\u0006\b¬\u0001\u0010\u0001R\u001c\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b­\u0001\u0010S\"\u0005\b®\u0001\u0010UR\u001e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¯\u0001\u0010\u0001\"\u0006\b°\u0001\u0010\u0001R \u0010.\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010S\"\u0005\b²\u0001\u0010UR \u0010-\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b³\u0001\u0010S\"\u0005\b´\u0001\u0010U¨\u0006ñ\u0001"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "", "recordId", "", "filePath", "", "fileName", "md5", "shortHandText", "shortHandTitle", "location", "locationShort", "totalTime", "summaryInfo", "fileSize", "lastModified", "createTime", "latitude", "longitude", "type", "", "playStatus", "recordStatus", "isChoose", "", "hasRenameRecord", "cacheFileDir", "isFinishFileMerge", "cacheLastMergeAllScenePcmChannelPath", "cacheLastUpMergePcmChannelPath", "cacheLastDownMergePcmChannelPath", "cacheLastUpMergeWavChannelPath", "cacheLastDownMergeWavChannelPath", "cacheLastWavChannelPath", "isTwoChannelType", "isFinishAsr", "isEmptyRecord", "isNewRecordItem", "requestId", "accountId", "recognizeId", "isDownloading", "isVoiceHasNewMerge", "originTextSize", "languageType", "wordShareCount", "videoShareCount", "isChangeVoice", "searchWeight", "asrFail", "arsIsStart", "arsIsFinish", "arsProgress", "searchShowContent", "searchShowTitle", "searchIndexTitle", "searchIndexContent", "searchKeyWord", "amplitudeBeans", "Ljava/util/LinkedList;", "Lcom/upuphone/ar/fastrecord/phone/bean/AmplitudeBean;", "tagBeanList", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordContentTagEntity;", "Lkotlin/collections/ArrayList;", "personBeanList", "Lcom/upuphone/ar/fastrecord/phone/db/RecordPersonEntity;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJJJIIIZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJLjava/lang/String;JJZJZZZJLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/LinkedList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "getAmplitudeBeans", "()Ljava/util/LinkedList;", "setAmplitudeBeans", "(Ljava/util/LinkedList;)V", "getArsIsFinish", "()Z", "setArsIsFinish", "(Z)V", "getArsIsStart", "setArsIsStart", "getArsProgress", "()J", "setArsProgress", "(J)V", "getAsrFail", "setAsrFail", "getCacheFileDir", "setCacheFileDir", "getCacheLastDownMergePcmChannelPath", "setCacheLastDownMergePcmChannelPath", "getCacheLastDownMergeWavChannelPath", "setCacheLastDownMergeWavChannelPath", "getCacheLastMergeAllScenePcmChannelPath", "setCacheLastMergeAllScenePcmChannelPath", "getCacheLastUpMergePcmChannelPath", "setCacheLastUpMergePcmChannelPath", "getCacheLastUpMergeWavChannelPath", "setCacheLastUpMergeWavChannelPath", "getCacheLastWavChannelPath", "setCacheLastWavChannelPath", "getCreateTime", "setCreateTime", "getFileName", "setFileName", "getFilePath", "setFilePath", "getFileSize", "setFileSize", "getHasRenameRecord", "setHasRenameRecord", "setChangeVoice", "setChoose", "setDownloading", "setEmptyRecord", "setFinishAsr", "setFinishFileMerge", "setNewRecordItem", "setTwoChannelType", "setVoiceHasNewMerge", "getLanguageType", "setLanguageType", "getLastModified", "setLastModified", "getLatitude", "setLatitude", "getLocation", "setLocation", "getLocationShort", "setLocationShort", "getLongitude", "setLongitude", "getMd5", "setMd5", "getOriginTextSize", "setOriginTextSize", "getPersonBeanList", "()Ljava/util/ArrayList;", "setPersonBeanList", "(Ljava/util/ArrayList;)V", "getPlayStatus", "()I", "setPlayStatus", "(I)V", "getRecognizeId", "setRecognizeId", "getRecordId", "setRecordId", "getRecordStatus", "setRecordStatus", "getRequestId", "setRequestId", "getSearchIndexContent", "setSearchIndexContent", "getSearchIndexTitle", "setSearchIndexTitle", "getSearchKeyWord", "setSearchKeyWord", "getSearchShowContent", "setSearchShowContent", "getSearchShowTitle", "setSearchShowTitle", "getSearchWeight", "setSearchWeight", "getShortHandText", "setShortHandText", "getShortHandTitle", "setShortHandTitle", "getSummaryInfo", "setSummaryInfo", "getTagBeanList", "setTagBeanList", "getTotalTime", "setTotalTime", "getType", "setType", "getVideoShareCount", "setVideoShareCount", "getWordShareCount", "setWordShareCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class RecordEntity {
    @NotNull
    private String accountId;
    @Ignore
    @NotNull
    private LinkedList<AmplitudeBean> amplitudeBeans;
    @Ignore
    private boolean arsIsFinish;
    @Ignore
    private boolean arsIsStart;
    @Ignore
    private long arsProgress;
    @Ignore
    private boolean asrFail;
    @Nullable
    private String cacheFileDir;
    @Nullable
    private String cacheLastDownMergePcmChannelPath;
    @Nullable
    private String cacheLastDownMergeWavChannelPath;
    @Nullable
    private String cacheLastMergeAllScenePcmChannelPath;
    @Nullable
    private String cacheLastUpMergePcmChannelPath;
    @Nullable
    private String cacheLastUpMergeWavChannelPath;
    @Nullable
    private String cacheLastWavChannelPath;
    private long createTime;
    @Nullable
    private String fileName;
    @Nullable
    private String filePath;
    private long fileSize;
    private boolean hasRenameRecord;
    @Ignore
    private boolean isChangeVoice;
    private boolean isChoose;
    private boolean isDownloading;
    private boolean isEmptyRecord;
    private boolean isFinishAsr;
    private boolean isFinishFileMerge;
    private boolean isNewRecordItem;
    private boolean isTwoChannelType;
    private boolean isVoiceHasNewMerge;
    @NotNull
    private String languageType;
    private long lastModified;
    private long latitude;
    @Nullable
    private String location;
    @Nullable
    private String locationShort;
    private long longitude;
    @Nullable
    private String md5;
    private long originTextSize;
    @Ignore
    @NotNull
    private ArrayList<RecordPersonEntity> personBeanList;
    private int playStatus;
    @NotNull
    private String recognizeId;
    @PrimaryKey
    private long recordId;
    private int recordStatus;
    @NotNull
    private String requestId;
    @Ignore
    private int searchIndexContent;
    @Ignore
    private int searchIndexTitle;
    @Ignore
    @Nullable
    private String searchKeyWord;
    @Ignore
    @Nullable
    private String searchShowContent;
    @Ignore
    @Nullable
    private String searchShowTitle;
    @Ignore
    private long searchWeight;
    @Nullable
    private String shortHandText;
    @Nullable
    private String shortHandTitle;
    @Nullable
    private String summaryInfo;
    @Ignore
    @NotNull
    private ArrayList<RecordContentTagEntity> tagBeanList;
    private long totalTime;
    private int type;
    @ColumnInfo
    private long videoShareCount;
    @ColumnInfo
    private long wordShareCount;

    public RecordEntity() {
        this(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, 0, 0, 0, 0, 0, false, false, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, false, false, false, (String) null, (String) null, (String) null, false, false, 0, (String) null, 0, 0, false, 0, false, false, false, 0, (String) null, (String) null, 0, 0, (String) null, (LinkedList) null, (ArrayList) null, (ArrayList) null, -1, 8388607, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordEntity copy$default(RecordEntity recordEntity, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, long j3, long j4, long j5, long j6, long j7, int i, int i2, int i3, boolean z, boolean z2, String str9, boolean z3, String str10, String str11, String str12, String str13, String str14, String str15, boolean z4, boolean z5, boolean z6, boolean z7, String str16, String str17, String str18, boolean z8, boolean z9, long j8, String str19, long j9, long j10, boolean z10, long j11, boolean z11, boolean z12, boolean z13, long j12, String str20, String str21, int i4, int i5, String str22, LinkedList linkedList, ArrayList arrayList, ArrayList arrayList2, int i6, int i7, Object obj) {
        RecordEntity recordEntity2 = recordEntity;
        int i8 = i6;
        int i9 = i7;
        long j13 = (i8 & 1) != 0 ? recordEntity2.recordId : j;
        String str23 = (i8 & 2) != 0 ? recordEntity2.filePath : str;
        String str24 = (i8 & 4) != 0 ? recordEntity2.fileName : str2;
        String str25 = (i8 & 8) != 0 ? recordEntity2.md5 : str3;
        String str26 = (i8 & 16) != 0 ? recordEntity2.shortHandText : str4;
        String str27 = (i8 & 32) != 0 ? recordEntity2.shortHandTitle : str5;
        String str28 = (i8 & 64) != 0 ? recordEntity2.location : str6;
        String str29 = (i8 & 128) != 0 ? recordEntity2.locationShort : str7;
        long j14 = (i8 & 256) != 0 ? recordEntity2.totalTime : j2;
        String str30 = (i8 & 512) != 0 ? recordEntity2.summaryInfo : str8;
        long j15 = (i8 & 1024) != 0 ? recordEntity2.fileSize : j3;
        long j16 = (i8 & 2048) != 0 ? recordEntity2.lastModified : j4;
        long j17 = (i8 & 4096) != 0 ? recordEntity2.createTime : j5;
        long j18 = (i8 & 8192) != 0 ? recordEntity2.latitude : j6;
        long j19 = (i8 & 16384) != 0 ? recordEntity2.longitude : j7;
        int i10 = (i8 & 32768) != 0 ? recordEntity2.type : i;
        int i11 = (i8 & 65536) != 0 ? recordEntity2.playStatus : i2;
        int i12 = (i8 & 131072) != 0 ? recordEntity2.recordStatus : i3;
        boolean z14 = (i8 & PositionEstimate.Value.BUILDING_NAME) != 0 ? recordEntity2.isChoose : z;
        boolean z15 = (i8 & PositionEstimate.Value.TIME_SINCE_BOOT) != 0 ? recordEntity2.hasRenameRecord : z2;
        String str31 = (i8 & PositionEstimate.Value.SITUATION) != 0 ? recordEntity2.cacheFileDir : str9;
        boolean z16 = (i8 & PositionEstimate.Value.WLAN_AP_COUNT) != 0 ? recordEntity2.isFinishFileMerge : z3;
        String str32 = (i8 & PositionEstimate.Value.WLAN_AP_TIMESTAMPS) != 0 ? recordEntity2.cacheLastMergeAllScenePcmChannelPath : str10;
        String str33 = (i8 & PositionEstimate.Value.ACTIVITY) != 0 ? recordEntity2.cacheLastUpMergePcmChannelPath : str11;
        String str34 = (i8 & 16777216) != 0 ? recordEntity2.cacheLastDownMergePcmChannelPath : str12;
        String str35 = (i8 & PositionEstimate.Value.GNSS_TIME) != 0 ? recordEntity2.cacheLastUpMergeWavChannelPath : str13;
        String str36 = (i8 & CaptureType.CAPTURE_TYPE_ICCOA) != 0 ? recordEntity2.cacheLastDownMergeWavChannelPath : str14;
        String str37 = (i8 & CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW) != 0 ? recordEntity2.cacheLastWavChannelPath : str15;
        boolean z17 = (i8 & CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED) != 0 ? recordEntity2.isTwoChannelType : z4;
        boolean z18 = (i8 & 536870912) != 0 ? recordEntity2.isFinishAsr : z5;
        boolean z19 = (i8 & 1073741824) != 0 ? recordEntity2.isEmptyRecord : z6;
        return recordEntity.copy(j13, str23, str24, str25, str26, str27, str28, str29, j14, str30, j15, j16, j17, j18, j19, i10, i11, i12, z14, z15, str31, z16, str32, str33, str34, str35, str36, str37, z17, z18, z19, (i8 & Integer.MIN_VALUE) != 0 ? recordEntity2.isNewRecordItem : z7, (i9 & 1) != 0 ? recordEntity2.requestId : str16, (i9 & 2) != 0 ? recordEntity2.accountId : str17, (i9 & 4) != 0 ? recordEntity2.recognizeId : str18, (i9 & 8) != 0 ? recordEntity2.isDownloading : z8, (i9 & 16) != 0 ? recordEntity2.isVoiceHasNewMerge : z9, (i9 & 32) != 0 ? recordEntity2.originTextSize : j8, (i9 & 64) != 0 ? recordEntity2.languageType : str19, (i9 & 128) != 0 ? recordEntity2.wordShareCount : j9, (i9 & 256) != 0 ? recordEntity2.videoShareCount : j10, (i9 & 512) != 0 ? recordEntity2.isChangeVoice : z10, (i9 & 1024) != 0 ? recordEntity2.searchWeight : j11, (i9 & 2048) != 0 ? recordEntity2.asrFail : z11, (i9 & 4096) != 0 ? recordEntity2.arsIsStart : z12, (i9 & 8192) != 0 ? recordEntity2.arsIsFinish : z13, (i9 & 16384) != 0 ? recordEntity2.arsProgress : j12, (i9 & 32768) != 0 ? recordEntity2.searchShowContent : str20, (65536 & i9) != 0 ? recordEntity2.searchShowTitle : str21, (i9 & 131072) != 0 ? recordEntity2.searchIndexTitle : i4, (i9 & PositionEstimate.Value.BUILDING_NAME) != 0 ? recordEntity2.searchIndexContent : i5, (i9 & PositionEstimate.Value.TIME_SINCE_BOOT) != 0 ? recordEntity2.searchKeyWord : str22, (i9 & PositionEstimate.Value.SITUATION) != 0 ? recordEntity2.amplitudeBeans : linkedList, (i9 & PositionEstimate.Value.WLAN_AP_COUNT) != 0 ? recordEntity2.tagBeanList : arrayList, (i9 & PositionEstimate.Value.WLAN_AP_TIMESTAMPS) != 0 ? recordEntity2.personBeanList : arrayList2);
    }

    public final long component1() {
        return this.recordId;
    }

    @Nullable
    public final String component10() {
        return this.summaryInfo;
    }

    public final long component11() {
        return this.fileSize;
    }

    public final long component12() {
        return this.lastModified;
    }

    public final long component13() {
        return this.createTime;
    }

    public final long component14() {
        return this.latitude;
    }

    public final long component15() {
        return this.longitude;
    }

    public final int component16() {
        return this.type;
    }

    public final int component17() {
        return this.playStatus;
    }

    public final int component18() {
        return this.recordStatus;
    }

    public final boolean component19() {
        return this.isChoose;
    }

    @Nullable
    public final String component2() {
        return this.filePath;
    }

    public final boolean component20() {
        return this.hasRenameRecord;
    }

    @Nullable
    public final String component21() {
        return this.cacheFileDir;
    }

    public final boolean component22() {
        return this.isFinishFileMerge;
    }

    @Nullable
    public final String component23() {
        return this.cacheLastMergeAllScenePcmChannelPath;
    }

    @Nullable
    public final String component24() {
        return this.cacheLastUpMergePcmChannelPath;
    }

    @Nullable
    public final String component25() {
        return this.cacheLastDownMergePcmChannelPath;
    }

    @Nullable
    public final String component26() {
        return this.cacheLastUpMergeWavChannelPath;
    }

    @Nullable
    public final String component27() {
        return this.cacheLastDownMergeWavChannelPath;
    }

    @Nullable
    public final String component28() {
        return this.cacheLastWavChannelPath;
    }

    public final boolean component29() {
        return this.isTwoChannelType;
    }

    @Nullable
    public final String component3() {
        return this.fileName;
    }

    public final boolean component30() {
        return this.isFinishAsr;
    }

    public final boolean component31() {
        return this.isEmptyRecord;
    }

    public final boolean component32() {
        return this.isNewRecordItem;
    }

    @NotNull
    public final String component33() {
        return this.requestId;
    }

    @NotNull
    public final String component34() {
        return this.accountId;
    }

    @NotNull
    public final String component35() {
        return this.recognizeId;
    }

    public final boolean component36() {
        return this.isDownloading;
    }

    public final boolean component37() {
        return this.isVoiceHasNewMerge;
    }

    public final long component38() {
        return this.originTextSize;
    }

    @NotNull
    public final String component39() {
        return this.languageType;
    }

    @Nullable
    public final String component4() {
        return this.md5;
    }

    public final long component40() {
        return this.wordShareCount;
    }

    public final long component41() {
        return this.videoShareCount;
    }

    public final boolean component42() {
        return this.isChangeVoice;
    }

    public final long component43() {
        return this.searchWeight;
    }

    public final boolean component44() {
        return this.asrFail;
    }

    public final boolean component45() {
        return this.arsIsStart;
    }

    public final boolean component46() {
        return this.arsIsFinish;
    }

    public final long component47() {
        return this.arsProgress;
    }

    @Nullable
    public final String component48() {
        return this.searchShowContent;
    }

    @Nullable
    public final String component49() {
        return this.searchShowTitle;
    }

    @Nullable
    public final String component5() {
        return this.shortHandText;
    }

    public final int component50() {
        return this.searchIndexTitle;
    }

    public final int component51() {
        return this.searchIndexContent;
    }

    @Nullable
    public final String component52() {
        return this.searchKeyWord;
    }

    @NotNull
    public final LinkedList<AmplitudeBean> component53() {
        return this.amplitudeBeans;
    }

    @NotNull
    public final ArrayList<RecordContentTagEntity> component54() {
        return this.tagBeanList;
    }

    @NotNull
    public final ArrayList<RecordPersonEntity> component55() {
        return this.personBeanList;
    }

    @Nullable
    public final String component6() {
        return this.shortHandTitle;
    }

    @Nullable
    public final String component7() {
        return this.location;
    }

    @Nullable
    public final String component8() {
        return this.locationShort;
    }

    public final long component9() {
        return this.totalTime;
    }

    @NotNull
    public final RecordEntity copy(long j, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j2, @Nullable String str8, long j3, long j4, long j5, long j6, long j7, int i, int i2, int i3, boolean z, boolean z2, @Nullable String str9, boolean z3, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, boolean z4, boolean z5, boolean z6, boolean z7, @NotNull String str16, @NotNull String str17, @NotNull String str18, boolean z8, boolean z9, long j8, @NotNull String str19, long j9, long j10, boolean z10, long j11, boolean z11, boolean z12, boolean z13, long j12, @Nullable String str20, @Nullable String str21, int i4, int i5, @Nullable String str22, @NotNull LinkedList<AmplitudeBean> linkedList, @NotNull ArrayList<RecordContentTagEntity> arrayList, @NotNull ArrayList<RecordPersonEntity> arrayList2) {
        Intrinsics.checkNotNullParameter(str16, "requestId");
        Intrinsics.checkNotNullParameter(str17, "accountId");
        Intrinsics.checkNotNullParameter(str18, "recognizeId");
        Intrinsics.checkNotNullParameter(str19, "languageType");
        Intrinsics.checkNotNullParameter(linkedList, "amplitudeBeans");
        Intrinsics.checkNotNullParameter(arrayList, "tagBeanList");
        Intrinsics.checkNotNullParameter(arrayList2, "personBeanList");
        return new RecordEntity(j, str, str2, str3, str4, str5, str6, str7, j2, str8, j3, j4, j5, j6, j7, i, i2, i3, z, z2, str9, z3, str10, str11, str12, str13, str14, str15, z4, z5, z6, z7, str16, str17, str18, z8, z9, j8, str19, j9, j10, z10, j11, z11, z12, z13, j12, str20, str21, i4, i5, str22, linkedList, arrayList, arrayList2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordEntity)) {
            return false;
        }
        RecordEntity recordEntity = (RecordEntity) obj;
        return this.recordId == recordEntity.recordId && Intrinsics.areEqual((Object) this.filePath, (Object) recordEntity.filePath) && Intrinsics.areEqual((Object) this.fileName, (Object) recordEntity.fileName) && Intrinsics.areEqual((Object) this.md5, (Object) recordEntity.md5) && Intrinsics.areEqual((Object) this.shortHandText, (Object) recordEntity.shortHandText) && Intrinsics.areEqual((Object) this.shortHandTitle, (Object) recordEntity.shortHandTitle) && Intrinsics.areEqual((Object) this.location, (Object) recordEntity.location) && Intrinsics.areEqual((Object) this.locationShort, (Object) recordEntity.locationShort) && this.totalTime == recordEntity.totalTime && Intrinsics.areEqual((Object) this.summaryInfo, (Object) recordEntity.summaryInfo) && this.fileSize == recordEntity.fileSize && this.lastModified == recordEntity.lastModified && this.createTime == recordEntity.createTime && this.latitude == recordEntity.latitude && this.longitude == recordEntity.longitude && this.type == recordEntity.type && this.playStatus == recordEntity.playStatus && this.recordStatus == recordEntity.recordStatus && this.isChoose == recordEntity.isChoose && this.hasRenameRecord == recordEntity.hasRenameRecord && Intrinsics.areEqual((Object) this.cacheFileDir, (Object) recordEntity.cacheFileDir) && this.isFinishFileMerge == recordEntity.isFinishFileMerge && Intrinsics.areEqual((Object) this.cacheLastMergeAllScenePcmChannelPath, (Object) recordEntity.cacheLastMergeAllScenePcmChannelPath) && Intrinsics.areEqual((Object) this.cacheLastUpMergePcmChannelPath, (Object) recordEntity.cacheLastUpMergePcmChannelPath) && Intrinsics.areEqual((Object) this.cacheLastDownMergePcmChannelPath, (Object) recordEntity.cacheLastDownMergePcmChannelPath) && Intrinsics.areEqual((Object) this.cacheLastUpMergeWavChannelPath, (Object) recordEntity.cacheLastUpMergeWavChannelPath) && Intrinsics.areEqual((Object) this.cacheLastDownMergeWavChannelPath, (Object) recordEntity.cacheLastDownMergeWavChannelPath) && Intrinsics.areEqual((Object) this.cacheLastWavChannelPath, (Object) recordEntity.cacheLastWavChannelPath) && this.isTwoChannelType == recordEntity.isTwoChannelType && this.isFinishAsr == recordEntity.isFinishAsr && this.isEmptyRecord == recordEntity.isEmptyRecord && this.isNewRecordItem == recordEntity.isNewRecordItem && Intrinsics.areEqual((Object) this.requestId, (Object) recordEntity.requestId) && Intrinsics.areEqual((Object) this.accountId, (Object) recordEntity.accountId) && Intrinsics.areEqual((Object) this.recognizeId, (Object) recordEntity.recognizeId) && this.isDownloading == recordEntity.isDownloading && this.isVoiceHasNewMerge == recordEntity.isVoiceHasNewMerge && this.originTextSize == recordEntity.originTextSize && Intrinsics.areEqual((Object) this.languageType, (Object) recordEntity.languageType) && this.wordShareCount == recordEntity.wordShareCount && this.videoShareCount == recordEntity.videoShareCount && this.isChangeVoice == recordEntity.isChangeVoice && this.searchWeight == recordEntity.searchWeight && this.asrFail == recordEntity.asrFail && this.arsIsStart == recordEntity.arsIsStart && this.arsIsFinish == recordEntity.arsIsFinish && this.arsProgress == recordEntity.arsProgress && Intrinsics.areEqual((Object) this.searchShowContent, (Object) recordEntity.searchShowContent) && Intrinsics.areEqual((Object) this.searchShowTitle, (Object) recordEntity.searchShowTitle) && this.searchIndexTitle == recordEntity.searchIndexTitle && this.searchIndexContent == recordEntity.searchIndexContent && Intrinsics.areEqual((Object) this.searchKeyWord, (Object) recordEntity.searchKeyWord) && Intrinsics.areEqual((Object) this.amplitudeBeans, (Object) recordEntity.amplitudeBeans) && Intrinsics.areEqual((Object) this.tagBeanList, (Object) recordEntity.tagBeanList) && Intrinsics.areEqual((Object) this.personBeanList, (Object) recordEntity.personBeanList);
    }

    @NotNull
    public final String getAccountId() {
        return this.accountId;
    }

    @NotNull
    public final LinkedList<AmplitudeBean> getAmplitudeBeans() {
        return this.amplitudeBeans;
    }

    public final boolean getArsIsFinish() {
        return this.arsIsFinish;
    }

    public final boolean getArsIsStart() {
        return this.arsIsStart;
    }

    public final long getArsProgress() {
        return this.arsProgress;
    }

    public final boolean getAsrFail() {
        return this.asrFail;
    }

    @Nullable
    public final String getCacheFileDir() {
        return this.cacheFileDir;
    }

    @Nullable
    public final String getCacheLastDownMergePcmChannelPath() {
        return this.cacheLastDownMergePcmChannelPath;
    }

    @Nullable
    public final String getCacheLastDownMergeWavChannelPath() {
        return this.cacheLastDownMergeWavChannelPath;
    }

    @Nullable
    public final String getCacheLastMergeAllScenePcmChannelPath() {
        return this.cacheLastMergeAllScenePcmChannelPath;
    }

    @Nullable
    public final String getCacheLastUpMergePcmChannelPath() {
        return this.cacheLastUpMergePcmChannelPath;
    }

    @Nullable
    public final String getCacheLastUpMergeWavChannelPath() {
        return this.cacheLastUpMergeWavChannelPath;
    }

    @Nullable
    public final String getCacheLastWavChannelPath() {
        return this.cacheLastWavChannelPath;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final String getFileName() {
        return this.fileName;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final boolean getHasRenameRecord() {
        return this.hasRenameRecord;
    }

    @NotNull
    public final String getLanguageType() {
        return this.languageType;
    }

    public final long getLastModified() {
        return this.lastModified;
    }

    public final long getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final String getLocationShort() {
        return this.locationShort;
    }

    public final long getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final String getMd5() {
        return this.md5;
    }

    public final long getOriginTextSize() {
        return this.originTextSize;
    }

    @NotNull
    public final ArrayList<RecordPersonEntity> getPersonBeanList() {
        return this.personBeanList;
    }

    public final int getPlayStatus() {
        return this.playStatus;
    }

    @NotNull
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    public final long getRecordId() {
        return this.recordId;
    }

    public final int getRecordStatus() {
        return this.recordStatus;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public final int getSearchIndexContent() {
        return this.searchIndexContent;
    }

    public final int getSearchIndexTitle() {
        return this.searchIndexTitle;
    }

    @Nullable
    public final String getSearchKeyWord() {
        return this.searchKeyWord;
    }

    @Nullable
    public final String getSearchShowContent() {
        return this.searchShowContent;
    }

    @Nullable
    public final String getSearchShowTitle() {
        return this.searchShowTitle;
    }

    public final long getSearchWeight() {
        return this.searchWeight;
    }

    @Nullable
    public final String getShortHandText() {
        return this.shortHandText;
    }

    @Nullable
    public final String getShortHandTitle() {
        return this.shortHandTitle;
    }

    @Nullable
    public final String getSummaryInfo() {
        return this.summaryInfo;
    }

    @NotNull
    public final ArrayList<RecordContentTagEntity> getTagBeanList() {
        return this.tagBeanList;
    }

    public final long getTotalTime() {
        return this.totalTime;
    }

    public final int getType() {
        return this.type;
    }

    public final long getVideoShareCount() {
        return this.videoShareCount;
    }

    public final long getWordShareCount() {
        return this.wordShareCount;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.recordId) * 31;
        String str = this.filePath;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fileName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.md5;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.shortHandText;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.shortHandTitle;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.location;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.locationShort;
        int hashCode8 = (((hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Long.hashCode(this.totalTime)) * 31;
        String str8 = this.summaryInfo;
        int hashCode9 = (((((((((((((((((((((hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31) + Long.hashCode(this.fileSize)) * 31) + Long.hashCode(this.lastModified)) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.latitude)) * 31) + Long.hashCode(this.longitude)) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.playStatus)) * 31) + Integer.hashCode(this.recordStatus)) * 31) + Boolean.hashCode(this.isChoose)) * 31) + Boolean.hashCode(this.hasRenameRecord)) * 31;
        String str9 = this.cacheFileDir;
        int hashCode10 = (((hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31) + Boolean.hashCode(this.isFinishFileMerge)) * 31;
        String str10 = this.cacheLastMergeAllScenePcmChannelPath;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.cacheLastUpMergePcmChannelPath;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.cacheLastDownMergePcmChannelPath;
        int hashCode13 = (hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.cacheLastUpMergeWavChannelPath;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.cacheLastDownMergeWavChannelPath;
        int hashCode15 = (hashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.cacheLastWavChannelPath;
        int hashCode16 = (((((((((((((((((((((((((((((((((((((((hashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31) + Boolean.hashCode(this.isTwoChannelType)) * 31) + Boolean.hashCode(this.isFinishAsr)) * 31) + Boolean.hashCode(this.isEmptyRecord)) * 31) + Boolean.hashCode(this.isNewRecordItem)) * 31) + this.requestId.hashCode()) * 31) + this.accountId.hashCode()) * 31) + this.recognizeId.hashCode()) * 31) + Boolean.hashCode(this.isDownloading)) * 31) + Boolean.hashCode(this.isVoiceHasNewMerge)) * 31) + Long.hashCode(this.originTextSize)) * 31) + this.languageType.hashCode()) * 31) + Long.hashCode(this.wordShareCount)) * 31) + Long.hashCode(this.videoShareCount)) * 31) + Boolean.hashCode(this.isChangeVoice)) * 31) + Long.hashCode(this.searchWeight)) * 31) + Boolean.hashCode(this.asrFail)) * 31) + Boolean.hashCode(this.arsIsStart)) * 31) + Boolean.hashCode(this.arsIsFinish)) * 31) + Long.hashCode(this.arsProgress)) * 31;
        String str16 = this.searchShowContent;
        int hashCode17 = (hashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.searchShowTitle;
        int hashCode18 = (((((hashCode17 + (str17 == null ? 0 : str17.hashCode())) * 31) + Integer.hashCode(this.searchIndexTitle)) * 31) + Integer.hashCode(this.searchIndexContent)) * 31;
        String str18 = this.searchKeyWord;
        if (str18 != null) {
            i = str18.hashCode();
        }
        return ((((((hashCode18 + i) * 31) + this.amplitudeBeans.hashCode()) * 31) + this.tagBeanList.hashCode()) * 31) + this.personBeanList.hashCode();
    }

    public final boolean isChangeVoice() {
        return this.isChangeVoice;
    }

    public final boolean isChoose() {
        return this.isChoose;
    }

    public final boolean isDownloading() {
        return this.isDownloading;
    }

    public final boolean isEmptyRecord() {
        return this.isEmptyRecord;
    }

    public final boolean isFinishAsr() {
        return this.isFinishAsr;
    }

    public final boolean isFinishFileMerge() {
        return this.isFinishFileMerge;
    }

    public final boolean isNewRecordItem() {
        return this.isNewRecordItem;
    }

    public final boolean isTwoChannelType() {
        return this.isTwoChannelType;
    }

    public final boolean isVoiceHasNewMerge() {
        return this.isVoiceHasNewMerge;
    }

    public final void setAccountId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountId = str;
    }

    public final void setAmplitudeBeans(@NotNull LinkedList<AmplitudeBean> linkedList) {
        Intrinsics.checkNotNullParameter(linkedList, "<set-?>");
        this.amplitudeBeans = linkedList;
    }

    public final void setArsIsFinish(boolean z) {
        this.arsIsFinish = z;
    }

    public final void setArsIsStart(boolean z) {
        this.arsIsStart = z;
    }

    public final void setArsProgress(long j) {
        this.arsProgress = j;
    }

    public final void setAsrFail(boolean z) {
        this.asrFail = z;
    }

    public final void setCacheFileDir(@Nullable String str) {
        this.cacheFileDir = str;
    }

    public final void setCacheLastDownMergePcmChannelPath(@Nullable String str) {
        this.cacheLastDownMergePcmChannelPath = str;
    }

    public final void setCacheLastDownMergeWavChannelPath(@Nullable String str) {
        this.cacheLastDownMergeWavChannelPath = str;
    }

    public final void setCacheLastMergeAllScenePcmChannelPath(@Nullable String str) {
        this.cacheLastMergeAllScenePcmChannelPath = str;
    }

    public final void setCacheLastUpMergePcmChannelPath(@Nullable String str) {
        this.cacheLastUpMergePcmChannelPath = str;
    }

    public final void setCacheLastUpMergeWavChannelPath(@Nullable String str) {
        this.cacheLastUpMergeWavChannelPath = str;
    }

    public final void setCacheLastWavChannelPath(@Nullable String str) {
        this.cacheLastWavChannelPath = str;
    }

    public final void setChangeVoice(boolean z) {
        this.isChangeVoice = z;
    }

    public final void setChoose(boolean z) {
        this.isChoose = z;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final void setDownloading(boolean z) {
        this.isDownloading = z;
    }

    public final void setEmptyRecord(boolean z) {
        this.isEmptyRecord = z;
    }

    public final void setFileName(@Nullable String str) {
        this.fileName = str;
    }

    public final void setFilePath(@Nullable String str) {
        this.filePath = str;
    }

    public final void setFileSize(long j) {
        this.fileSize = j;
    }

    public final void setFinishAsr(boolean z) {
        this.isFinishAsr = z;
    }

    public final void setFinishFileMerge(boolean z) {
        this.isFinishFileMerge = z;
    }

    public final void setHasRenameRecord(boolean z) {
        this.hasRenameRecord = z;
    }

    public final void setLanguageType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.languageType = str;
    }

    public final void setLastModified(long j) {
        this.lastModified = j;
    }

    public final void setLatitude(long j) {
        this.latitude = j;
    }

    public final void setLocation(@Nullable String str) {
        this.location = str;
    }

    public final void setLocationShort(@Nullable String str) {
        this.locationShort = str;
    }

    public final void setLongitude(long j) {
        this.longitude = j;
    }

    public final void setMd5(@Nullable String str) {
        this.md5 = str;
    }

    public final void setNewRecordItem(boolean z) {
        this.isNewRecordItem = z;
    }

    public final void setOriginTextSize(long j) {
        this.originTextSize = j;
    }

    public final void setPersonBeanList(@NotNull ArrayList<RecordPersonEntity> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.personBeanList = arrayList;
    }

    public final void setPlayStatus(int i) {
        this.playStatus = i;
    }

    public final void setRecognizeId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recognizeId = str;
    }

    public final void setRecordId(long j) {
        this.recordId = j;
    }

    public final void setRecordStatus(int i) {
        this.recordStatus = i;
    }

    public final void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }

    public final void setSearchIndexContent(int i) {
        this.searchIndexContent = i;
    }

    public final void setSearchIndexTitle(int i) {
        this.searchIndexTitle = i;
    }

    public final void setSearchKeyWord(@Nullable String str) {
        this.searchKeyWord = str;
    }

    public final void setSearchShowContent(@Nullable String str) {
        this.searchShowContent = str;
    }

    public final void setSearchShowTitle(@Nullable String str) {
        this.searchShowTitle = str;
    }

    public final void setSearchWeight(long j) {
        this.searchWeight = j;
    }

    public final void setShortHandText(@Nullable String str) {
        this.shortHandText = str;
    }

    public final void setShortHandTitle(@Nullable String str) {
        this.shortHandTitle = str;
    }

    public final void setSummaryInfo(@Nullable String str) {
        this.summaryInfo = str;
    }

    public final void setTagBeanList(@NotNull ArrayList<RecordContentTagEntity> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.tagBeanList = arrayList;
    }

    public final void setTotalTime(long j) {
        this.totalTime = j;
    }

    public final void setTwoChannelType(boolean z) {
        this.isTwoChannelType = z;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setVideoShareCount(long j) {
        this.videoShareCount = j;
    }

    public final void setVoiceHasNewMerge(boolean z) {
        this.isVoiceHasNewMerge = z;
    }

    public final void setWordShareCount(long j) {
        this.wordShareCount = j;
    }

    @NotNull
    public String toString() {
        long j = this.recordId;
        String str = this.filePath;
        String str2 = this.fileName;
        String str3 = this.md5;
        String str4 = this.shortHandText;
        String str5 = this.shortHandTitle;
        String str6 = this.location;
        String str7 = this.locationShort;
        long j2 = this.totalTime;
        String str8 = this.summaryInfo;
        long j3 = this.fileSize;
        long j4 = this.lastModified;
        long j5 = this.createTime;
        long j6 = this.latitude;
        long j7 = this.longitude;
        long j8 = j3;
        int i = this.type;
        int i2 = this.playStatus;
        int i3 = this.recordStatus;
        boolean z = this.isChoose;
        boolean z2 = this.hasRenameRecord;
        String str9 = this.cacheFileDir;
        boolean z3 = this.isFinishFileMerge;
        String str10 = this.cacheLastMergeAllScenePcmChannelPath;
        String str11 = this.cacheLastUpMergePcmChannelPath;
        String str12 = this.cacheLastDownMergePcmChannelPath;
        String str13 = this.cacheLastUpMergeWavChannelPath;
        String str14 = this.cacheLastDownMergeWavChannelPath;
        String str15 = this.cacheLastWavChannelPath;
        boolean z4 = this.isTwoChannelType;
        boolean z5 = this.isFinishAsr;
        boolean z6 = this.isEmptyRecord;
        boolean z7 = this.isNewRecordItem;
        String str16 = this.requestId;
        String str17 = this.accountId;
        String str18 = this.recognizeId;
        boolean z8 = this.isDownloading;
        boolean z9 = this.isVoiceHasNewMerge;
        long j9 = j7;
        long j10 = this.originTextSize;
        String str19 = this.languageType;
        long j11 = this.wordShareCount;
        long j12 = this.videoShareCount;
        boolean z10 = this.isChangeVoice;
        long j13 = this.searchWeight;
        boolean z11 = this.asrFail;
        boolean z12 = this.arsIsStart;
        boolean z13 = z11;
        boolean z14 = this.arsIsFinish;
        long j14 = this.arsProgress;
        String str20 = this.searchShowContent;
        String str21 = this.searchShowTitle;
        int i4 = this.searchIndexTitle;
        int i5 = this.searchIndexContent;
        String str22 = this.searchKeyWord;
        LinkedList<AmplitudeBean> linkedList = this.amplitudeBeans;
        ArrayList<RecordContentTagEntity> arrayList = this.tagBeanList;
        ArrayList<RecordPersonEntity> arrayList2 = this.personBeanList;
        return "RecordEntity(recordId=" + j + ", filePath=" + str + ", fileName=" + str2 + ", md5=" + str3 + ", shortHandText=" + str4 + ", shortHandTitle=" + str5 + ", location=" + str6 + ", locationShort=" + str7 + ", totalTime=" + j2 + ", summaryInfo=" + str8 + ", fileSize=" + j8 + ", lastModified=" + j4 + ", createTime=" + j5 + ", latitude=" + j6 + ", longitude=" + j9 + ", type=" + i + ", playStatus=" + i2 + ", recordStatus=" + i3 + ", isChoose=" + z + ", hasRenameRecord=" + z2 + ", cacheFileDir=" + str9 + ", isFinishFileMerge=" + z3 + ", cacheLastMergeAllScenePcmChannelPath=" + str10 + ", cacheLastUpMergePcmChannelPath=" + str11 + ", cacheLastDownMergePcmChannelPath=" + str12 + ", cacheLastUpMergeWavChannelPath=" + str13 + ", cacheLastDownMergeWavChannelPath=" + str14 + ", cacheLastWavChannelPath=" + str15 + ", isTwoChannelType=" + z4 + ", isFinishAsr=" + z5 + ", isEmptyRecord=" + z6 + ", isNewRecordItem=" + z7 + ", requestId=" + str16 + ", accountId=" + str17 + ", recognizeId=" + str18 + ", isDownloading=" + z8 + ", isVoiceHasNewMerge=" + z9 + ", originTextSize=" + j10 + ", languageType=" + str19 + ", wordShareCount=" + j11 + ", videoShareCount=" + j12 + ", isChangeVoice=" + z10 + ", searchWeight=" + j13 + ", asrFail=" + z13 + ", arsIsStart=" + z12 + ", arsIsFinish=" + z14 + ", arsProgress=" + j14 + ", searchShowContent=" + str20 + ", searchShowTitle=" + str21 + ", searchIndexTitle=" + i4 + ", searchIndexContent=" + i5 + ", searchKeyWord=" + str22 + ", amplitudeBeans=" + linkedList + ", tagBeanList=" + arrayList + ", personBeanList=" + arrayList2 + ")";
    }

    public RecordEntity(long j, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j2, @Nullable String str8, long j3, long j4, long j5, long j6, long j7, int i, int i2, int i3, boolean z, boolean z2, @Nullable String str9, boolean z3, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, boolean z4, boolean z5, boolean z6, boolean z7, @NotNull String str16, @NotNull String str17, @NotNull String str18, boolean z8, boolean z9, long j8, @NotNull String str19, long j9, long j10, boolean z10, long j11, boolean z11, boolean z12, boolean z13, long j12, @Nullable String str20, @Nullable String str21, int i4, int i5, @Nullable String str22, @NotNull LinkedList<AmplitudeBean> linkedList, @NotNull ArrayList<RecordContentTagEntity> arrayList, @NotNull ArrayList<RecordPersonEntity> arrayList2) {
        String str23 = str16;
        String str24 = str17;
        String str25 = str18;
        String str26 = str19;
        LinkedList<AmplitudeBean> linkedList2 = linkedList;
        ArrayList<RecordContentTagEntity> arrayList3 = arrayList;
        ArrayList<RecordPersonEntity> arrayList4 = arrayList2;
        Intrinsics.checkNotNullParameter(str23, "requestId");
        Intrinsics.checkNotNullParameter(str24, "accountId");
        Intrinsics.checkNotNullParameter(str25, "recognizeId");
        Intrinsics.checkNotNullParameter(str26, "languageType");
        Intrinsics.checkNotNullParameter(linkedList2, "amplitudeBeans");
        Intrinsics.checkNotNullParameter(arrayList3, "tagBeanList");
        Intrinsics.checkNotNullParameter(arrayList4, "personBeanList");
        this.recordId = j;
        this.filePath = str;
        this.fileName = str2;
        this.md5 = str3;
        this.shortHandText = str4;
        this.shortHandTitle = str5;
        this.location = str6;
        this.locationShort = str7;
        this.totalTime = j2;
        this.summaryInfo = str8;
        this.fileSize = j3;
        this.lastModified = j4;
        this.createTime = j5;
        this.latitude = j6;
        this.longitude = j7;
        this.type = i;
        this.playStatus = i2;
        this.recordStatus = i3;
        this.isChoose = z;
        this.hasRenameRecord = z2;
        this.cacheFileDir = str9;
        this.isFinishFileMerge = z3;
        this.cacheLastMergeAllScenePcmChannelPath = str10;
        this.cacheLastUpMergePcmChannelPath = str11;
        this.cacheLastDownMergePcmChannelPath = str12;
        this.cacheLastUpMergeWavChannelPath = str13;
        this.cacheLastDownMergeWavChannelPath = str14;
        this.cacheLastWavChannelPath = str15;
        this.isTwoChannelType = z4;
        this.isFinishAsr = z5;
        this.isEmptyRecord = z6;
        this.isNewRecordItem = z7;
        this.requestId = str23;
        this.accountId = str24;
        this.recognizeId = str25;
        this.isDownloading = z8;
        this.isVoiceHasNewMerge = z9;
        this.originTextSize = j8;
        this.languageType = str26;
        this.wordShareCount = j9;
        this.videoShareCount = j10;
        this.isChangeVoice = z10;
        this.searchWeight = j11;
        this.asrFail = z11;
        this.arsIsStart = z12;
        this.arsIsFinish = z13;
        this.arsProgress = j12;
        this.searchShowContent = str20;
        this.searchShowTitle = str21;
        this.searchIndexTitle = i4;
        this.searchIndexContent = i5;
        this.searchKeyWord = str22;
        this.amplitudeBeans = linkedList2;
        this.tagBeanList = arrayList3;
        this.personBeanList = arrayList4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RecordEntity(long r66, java.lang.String r68, java.lang.String r69, java.lang.String r70, java.lang.String r71, java.lang.String r72, java.lang.String r73, java.lang.String r74, long r75, java.lang.String r77, long r78, long r80, long r82, long r84, long r86, int r88, int r89, int r90, boolean r91, boolean r92, java.lang.String r93, boolean r94, java.lang.String r95, java.lang.String r96, java.lang.String r97, java.lang.String r98, java.lang.String r99, java.lang.String r100, boolean r101, boolean r102, boolean r103, boolean r104, java.lang.String r105, java.lang.String r106, java.lang.String r107, boolean r108, boolean r109, long r110, java.lang.String r112, long r113, long r115, boolean r117, long r118, boolean r120, boolean r121, boolean r122, long r123, java.lang.String r125, java.lang.String r126, int r127, int r128, java.lang.String r129, java.util.LinkedList r130, java.util.ArrayList r131, java.util.ArrayList r132, int r133, int r134, kotlin.jvm.internal.DefaultConstructorMarker r135) {
        /*
            r65 = this;
            r0 = r133
            r1 = r134
            r2 = r0 & 1
            if (r2 == 0) goto L_0x000b
            r5 = 0
            goto L_0x000d
        L_0x000b:
            r5 = r66
        L_0x000d:
            r2 = r0 & 2
            java.lang.String r7 = ""
            if (r2 == 0) goto L_0x0015
            r2 = r7
            goto L_0x0017
        L_0x0015:
            r2 = r68
        L_0x0017:
            r8 = r0 & 4
            if (r8 == 0) goto L_0x001d
            r8 = r7
            goto L_0x001f
        L_0x001d:
            r8 = r69
        L_0x001f:
            r9 = r0 & 8
            if (r9 == 0) goto L_0x0025
            r9 = r7
            goto L_0x0027
        L_0x0025:
            r9 = r70
        L_0x0027:
            r10 = r0 & 16
            if (r10 == 0) goto L_0x002d
            r10 = r7
            goto L_0x002f
        L_0x002d:
            r10 = r71
        L_0x002f:
            r11 = r0 & 32
            if (r11 == 0) goto L_0x0035
            r11 = r7
            goto L_0x0037
        L_0x0035:
            r11 = r72
        L_0x0037:
            r12 = r0 & 64
            if (r12 == 0) goto L_0x003d
            r12 = r7
            goto L_0x003f
        L_0x003d:
            r12 = r73
        L_0x003f:
            r13 = r0 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x0045
            r13 = r7
            goto L_0x0047
        L_0x0045:
            r13 = r74
        L_0x0047:
            r14 = r0 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x004e
            r14 = 0
            goto L_0x0050
        L_0x004e:
            r14 = r75
        L_0x0050:
            r3 = r0 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0056
            r3 = r7
            goto L_0x0058
        L_0x0056:
            r3 = r77
        L_0x0058:
            r4 = r0 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x005f
            r18 = 0
            goto L_0x0061
        L_0x005f:
            r18 = r78
        L_0x0061:
            r4 = r0 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0068
            r20 = 0
            goto L_0x006a
        L_0x0068:
            r20 = r80
        L_0x006a:
            r4 = r0 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x0071
            r22 = 0
            goto L_0x0073
        L_0x0071:
            r22 = r82
        L_0x0073:
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x007a
            r24 = 0
            goto L_0x007c
        L_0x007a:
            r24 = r84
        L_0x007c:
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x0083
            r26 = 0
            goto L_0x0085
        L_0x0083:
            r26 = r86
        L_0x0085:
            r4 = 32768(0x8000, float:4.5918E-41)
            r28 = r0 & r4
            r29 = 0
            if (r28 == 0) goto L_0x0091
            r28 = r29
            goto L_0x0093
        L_0x0091:
            r28 = r88
        L_0x0093:
            r30 = 65536(0x10000, float:9.18355E-41)
            r31 = r0 & r30
            if (r31 == 0) goto L_0x009c
            r31 = r29
            goto L_0x009e
        L_0x009c:
            r31 = r89
        L_0x009e:
            r32 = 131072(0x20000, float:1.83671E-40)
            r33 = r0 & r32
            if (r33 == 0) goto L_0x00a7
            r33 = r29
            goto L_0x00a9
        L_0x00a7:
            r33 = r90
        L_0x00a9:
            r34 = 262144(0x40000, float:3.67342E-40)
            r34 = r0 & r34
            if (r34 == 0) goto L_0x00b2
            r34 = r29
            goto L_0x00b4
        L_0x00b2:
            r34 = r91
        L_0x00b4:
            r35 = 524288(0x80000, float:7.34684E-40)
            r35 = r0 & r35
            if (r35 == 0) goto L_0x00bd
            r35 = r29
            goto L_0x00bf
        L_0x00bd:
            r35 = r92
        L_0x00bf:
            r36 = 1048576(0x100000, float:1.469368E-39)
            r36 = r0 & r36
            r37 = 0
            if (r36 == 0) goto L_0x00ca
            r36 = r37
            goto L_0x00cc
        L_0x00ca:
            r36 = r93
        L_0x00cc:
            r38 = 2097152(0x200000, float:2.938736E-39)
            r38 = r0 & r38
            if (r38 == 0) goto L_0x00d5
            r38 = r29
            goto L_0x00d7
        L_0x00d5:
            r38 = r94
        L_0x00d7:
            r39 = 4194304(0x400000, float:5.877472E-39)
            r39 = r0 & r39
            if (r39 == 0) goto L_0x00e0
            r39 = r37
            goto L_0x00e2
        L_0x00e0:
            r39 = r95
        L_0x00e2:
            r40 = 8388608(0x800000, float:1.17549435E-38)
            r40 = r0 & r40
            if (r40 == 0) goto L_0x00eb
            r40 = r37
            goto L_0x00ed
        L_0x00eb:
            r40 = r96
        L_0x00ed:
            r41 = 16777216(0x1000000, float:2.3509887E-38)
            r41 = r0 & r41
            if (r41 == 0) goto L_0x00f6
            r41 = r37
            goto L_0x00f8
        L_0x00f6:
            r41 = r97
        L_0x00f8:
            r42 = 33554432(0x2000000, float:9.403955E-38)
            r42 = r0 & r42
            if (r42 == 0) goto L_0x0101
            r42 = r37
            goto L_0x0103
        L_0x0101:
            r42 = r98
        L_0x0103:
            r43 = 67108864(0x4000000, float:1.5046328E-36)
            r43 = r0 & r43
            if (r43 == 0) goto L_0x010c
            r43 = r37
            goto L_0x010e
        L_0x010c:
            r43 = r99
        L_0x010e:
            r44 = 134217728(0x8000000, float:3.85186E-34)
            r44 = r0 & r44
            if (r44 == 0) goto L_0x0117
            r44 = r37
            goto L_0x0119
        L_0x0117:
            r44 = r100
        L_0x0119:
            r45 = 268435456(0x10000000, float:2.5243549E-29)
            r45 = r0 & r45
            if (r45 == 0) goto L_0x0122
            r45 = r29
            goto L_0x0124
        L_0x0122:
            r45 = r101
        L_0x0124:
            r46 = 536870912(0x20000000, float:1.0842022E-19)
            r46 = r0 & r46
            if (r46 == 0) goto L_0x012d
            r46 = r29
            goto L_0x012f
        L_0x012d:
            r46 = r102
        L_0x012f:
            r47 = 1073741824(0x40000000, float:2.0)
            r47 = r0 & r47
            if (r47 == 0) goto L_0x0138
            r47 = r29
            goto L_0x013a
        L_0x0138:
            r47 = r103
        L_0x013a:
            r48 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r48
            if (r0 == 0) goto L_0x0143
            r0 = r29
            goto L_0x0145
        L_0x0143:
            r0 = r104
        L_0x0145:
            r48 = r1 & 1
            if (r48 == 0) goto L_0x014c
            r48 = r7
            goto L_0x014e
        L_0x014c:
            r48 = r105
        L_0x014e:
            r49 = r1 & 2
            if (r49 == 0) goto L_0x0155
            r49 = r7
            goto L_0x0157
        L_0x0155:
            r49 = r106
        L_0x0157:
            r50 = r1 & 4
            if (r50 == 0) goto L_0x015e
            r50 = r7
            goto L_0x0160
        L_0x015e:
            r50 = r107
        L_0x0160:
            r51 = r1 & 8
            if (r51 == 0) goto L_0x0167
            r51 = r29
            goto L_0x0169
        L_0x0167:
            r51 = r108
        L_0x0169:
            r52 = r1 & 16
            if (r52 == 0) goto L_0x0170
            r52 = r29
            goto L_0x0172
        L_0x0170:
            r52 = r109
        L_0x0172:
            r53 = r1 & 32
            if (r53 == 0) goto L_0x0179
            r53 = 0
            goto L_0x017b
        L_0x0179:
            r53 = r110
        L_0x017b:
            r55 = r1 & 64
            if (r55 == 0) goto L_0x0180
            goto L_0x0182
        L_0x0180:
            r7 = r112
        L_0x0182:
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0189
            r55 = 0
            goto L_0x018b
        L_0x0189:
            r55 = r113
        L_0x018b:
            r4 = r1 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x0192
            r57 = 0
            goto L_0x0194
        L_0x0192:
            r57 = r115
        L_0x0194:
            r4 = r1 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x019b
            r4 = r29
            goto L_0x019d
        L_0x019b:
            r4 = r117
        L_0x019d:
            r117 = r4
            r4 = r1 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x01a6
            r59 = 0
            goto L_0x01a8
        L_0x01a6:
            r59 = r118
        L_0x01a8:
            r4 = r1 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x01af
            r4 = r29
            goto L_0x01b1
        L_0x01af:
            r4 = r120
        L_0x01b1:
            r120 = r4
            r4 = r1 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x01ba
            r4 = r29
            goto L_0x01bc
        L_0x01ba:
            r4 = r121
        L_0x01bc:
            r121 = r4
            r4 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x01c3
            goto L_0x01c5
        L_0x01c3:
            r29 = r122
        L_0x01c5:
            r4 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x01cf
            r4 = 32768(0x8000, float:4.5918E-41)
            r16 = 0
            goto L_0x01d4
        L_0x01cf:
            r16 = r123
            r4 = 32768(0x8000, float:4.5918E-41)
        L_0x01d4:
            r4 = r4 & r1
            if (r4 == 0) goto L_0x01da
            r4 = r37
            goto L_0x01dc
        L_0x01da:
            r4 = r125
        L_0x01dc:
            r30 = r1 & r30
            if (r30 == 0) goto L_0x01e3
            r30 = r37
            goto L_0x01e5
        L_0x01e3:
            r30 = r126
        L_0x01e5:
            r32 = r1 & r32
            if (r32 == 0) goto L_0x01ec
            r32 = -1
            goto L_0x01ee
        L_0x01ec:
            r32 = r127
        L_0x01ee:
            r61 = 262144(0x40000, float:3.67342E-40)
            r61 = r1 & r61
            if (r61 == 0) goto L_0x01f7
            r61 = -1
            goto L_0x01f9
        L_0x01f7:
            r61 = r128
        L_0x01f9:
            r62 = 524288(0x80000, float:7.34684E-40)
            r62 = r1 & r62
            if (r62 == 0) goto L_0x0200
            goto L_0x0202
        L_0x0200:
            r37 = r129
        L_0x0202:
            r62 = 1048576(0x100000, float:1.469368E-39)
            r62 = r1 & r62
            if (r62 == 0) goto L_0x020e
            java.util.LinkedList r62 = new java.util.LinkedList
            r62.<init>()
            goto L_0x0210
        L_0x020e:
            r62 = r130
        L_0x0210:
            r63 = 2097152(0x200000, float:2.938736E-39)
            r63 = r1 & r63
            if (r63 == 0) goto L_0x021c
            java.util.ArrayList r63 = new java.util.ArrayList
            r63.<init>()
            goto L_0x021e
        L_0x021c:
            r63 = r131
        L_0x021e:
            r64 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r64
            if (r1 == 0) goto L_0x022a
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            goto L_0x022c
        L_0x022a:
            r1 = r132
        L_0x022c:
            r66 = r5
            r68 = r2
            r69 = r8
            r70 = r9
            r71 = r10
            r72 = r11
            r73 = r12
            r74 = r13
            r75 = r14
            r77 = r3
            r78 = r18
            r80 = r20
            r82 = r22
            r84 = r24
            r86 = r26
            r88 = r28
            r89 = r31
            r90 = r33
            r91 = r34
            r92 = r35
            r93 = r36
            r94 = r38
            r95 = r39
            r96 = r40
            r97 = r41
            r98 = r42
            r99 = r43
            r100 = r44
            r101 = r45
            r102 = r46
            r103 = r47
            r104 = r0
            r105 = r48
            r106 = r49
            r107 = r50
            r108 = r51
            r109 = r52
            r110 = r53
            r112 = r7
            r113 = r55
            r115 = r57
            r118 = r59
            r122 = r29
            r123 = r16
            r125 = r4
            r126 = r30
            r127 = r32
            r128 = r61
            r129 = r37
            r130 = r62
            r131 = r63
            r132 = r1
            r65.<init>(r66, r68, r69, r70, r71, r72, r73, r74, r75, r77, r78, r80, r82, r84, r86, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r112, r113, r115, r117, r118, r120, r121, r122, r123, r125, r126, r127, r128, r129, r130, r131, r132)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.db.RecordEntity.<init>(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, long, long, long, int, int, int, boolean, boolean, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, long, java.lang.String, long, long, boolean, long, boolean, boolean, boolean, long, java.lang.String, java.lang.String, int, int, java.lang.String, java.util.LinkedList, java.util.ArrayList, java.util.ArrayList, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
