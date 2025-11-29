package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapterModuleImp;
import com.chad.library.adapter.base.animation.AlphaInAnimation;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.listener.BaseListenerImp;
import com.chad.library.adapter.base.listener.GridSpanSizeLookup;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.BaseUpFetchModule;
import com.chad.library.adapter.base.module.DraggableModule;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.module.UpFetchModule;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\b&\u0018\u0000 \"*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00052\u00020\u0006:\u0004õ\u0001ö\u0001B%\b\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u0004\u0018\u00018\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00028\u0000H$¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00028\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0014¢\u0006\u0004\b\"\u0010#J\u001f\u0010'\u001a\u00028\u00012\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00028\u00012\u0006\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010/J-\u00100\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00028\u00012\u0006\u0010+\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\tH\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u0002022\u0006\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\r2\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\r2\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b;\u0010:J\u0017\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020\u0007H\u0014¢\u0006\u0004\b>\u0010?J\u0019\u0010@\u001a\u00028\u00002\b\b\u0001\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u0010AJ\u0019\u0010B\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\bB\u0010CJ\u0013\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070D¢\u0006\u0004\bE\u0010FJ\u001b\u0010I\u001a\u00020\r2\f\b\u0001\u0010H\u001a\u00020G\"\u00020\u0007¢\u0006\u0004\bI\u0010JJ\u0013\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070D¢\u0006\u0004\bK\u0010FJ\u001f\u0010M\u001a\u00020\r2\u0006\u0010L\u001a\u00028\u00012\u0006\u0010&\u001a\u00020\u0007H\u0014¢\u0006\u0004\bM\u0010/J\u001f\u0010O\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0007H\u0014¢\u0006\u0004\bO\u0010PJ\u001f\u0010Q\u001a\u00020=2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0007H\u0014¢\u0006\u0004\bQ\u0010RJ\u001f\u0010S\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0007H\u0014¢\u0006\u0004\bS\u0010PJ\u001f\u0010T\u001a\u00020=2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0007H\u0014¢\u0006\u0004\bT\u0010RJ\u001f\u0010U\u001a\u00020\r2\u0006\u0010L\u001a\u00028\u00012\u0006\u0010&\u001a\u00020\u0007H\u0014¢\u0006\u0004\bU\u0010/J\u000f\u0010V\u001a\u00020\u0007H\u0014¢\u0006\u0004\bV\u0010*J\u0017\u0010W\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014¢\u0006\u0004\bW\u0010-J\u001f\u0010X\u001a\u00028\u00012\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0007H\u0014¢\u0006\u0004\bX\u0010(J!\u0010Y\u001a\u00028\u00012\u0006\u0010%\u001a\u00020$2\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\bY\u0010(J\u0017\u0010Z\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\bZ\u0010[J\u0017\u0010\\\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\\\u0010\u001bJ+\u0010_\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010]\u001a\u00020\u00072\b\b\u0002\u0010^\u001a\u00020\u0007H\u0007¢\u0006\u0004\b_\u0010`J\r\u0010a\u001a\u00020=¢\u0006\u0004\ba\u0010bJ\r\u0010c\u001a\u00020=¢\u0006\u0004\bc\u0010bJ\r\u0010d\u001a\u00020=¢\u0006\u0004\bd\u0010bJ\u001f\u0010g\u001a\u00020\r2\u0006\u0010f\u001a\u00020e2\u0006\u0010]\u001a\u00020\u0007H\u0014¢\u0006\u0004\bg\u0010hJ!\u0010i\u001a\u00020\r2\b\b\u0001\u0010]\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\bi\u0010jJ!\u0010k\u001a\u00020\r2\b\b\u0001\u0010+\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\bk\u0010jJ\u0019\u0010l\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\bl\u0010mJ\u001f\u0010p\u001a\u00020\r2\u000e\b\u0001\u0010o\u001a\b\u0012\u0004\u0012\u00028\u00000nH\u0016¢\u0006\u0004\bp\u0010qJ\u0019\u0010r\u001a\u00020\r2\b\b\u0001\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\br\u0010sJ\u0017\u0010t\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\bt\u0010mJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010u\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\u0011\u0010sJ\u0019\u0010x\u001a\u00020\r2\b\u0010w\u001a\u0004\u0018\u00010vH\u0016¢\u0006\u0004\bx\u0010yJ\u0019\u0010{\u001a\u00020\r2\b\u0010w\u001a\u0004\u0018\u00010zH\u0016¢\u0006\u0004\b{\u0010|J\u0019\u0010~\u001a\u00020\r2\b\u0010w\u001a\u0004\u0018\u00010}H\u0016¢\u0006\u0004\b~\u0010J\u0012\u0010\u0001\u001a\u0004\u0018\u00010v¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u0004\u0018\u00010z¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0001\u001a\u0004\u0018\u00010}¢\u0006\u0005\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u0005\u0018\u00010\u0001¢\u0006\u0006\b\u0001\u0010\u0001R=\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0006@@X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u00020=8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010a\u001a\u0005\b\u0001\u0010b\"\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u00020=8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010a\u001a\u0005\b\u0001\u0010b\"\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u00020=8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010a\u001a\u0005\b\u0001\u0010b\"\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u00020=8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010a\u001a\u0005\b\u0001\u0010b\"\u0006\b\u0001\u0010\u0001R'\u0010¢\u0001\u001a\u00020=8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010a\u001a\u0005\b \u0001\u0010b\"\u0006\b¡\u0001\u0010\u0001R'\u0010¦\u0001\u001a\u00020=8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b£\u0001\u0010a\u001a\u0005\b¤\u0001\u0010b\"\u0006\b¥\u0001\u0010\u0001R'\u0010¨\u0001\u001a\u00020=8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b§\u0001\u0010a\u001a\u0005\b¨\u0001\u0010b\"\u0006\b©\u0001\u0010\u0001R8\u0010²\u0001\u001a\u0005\u0018\u00010ª\u00012\n\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006@FX\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010­\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u001a\u0010¶\u0001\u001a\u00030³\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010¸\u0001\u001a\u00030³\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b·\u0001\u0010µ\u0001R\u001a\u0010¼\u0001\u001a\u00030¹\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u0018\u0010¾\u0001\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b½\u0001\u0010VR\u001b\u0010Á\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010À\u0001R\u001a\u0010Ã\u0001\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bI\u0010Â\u0001R\u001a\u0010Å\u0001\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bk\u0010Ä\u0001R\u001a\u0010Ç\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bl\u0010Æ\u0001R\u001b\u0010É\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bp\u0010È\u0001R\u001c\u0010Í\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u001b\u0010Ð\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b_\u0010Ï\u0001R,\u0010Ø\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0000@\u0000X\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R+\u0010Ý\u0001\u001a\u00030Ù\u00012\b\u0010\u0001\u001a\u00030Ù\u00018\u0004@BX.¢\u0006\u000f\n\u0005\bN\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001R7\u0010æ\u0001\u001a\t\u0012\u0004\u0012\u0002070Þ\u00018\u0006@\u0006X.¢\u0006\u001f\n\u0006\bß\u0001\u0010à\u0001\u0012\u0005\bå\u0001\u0010\u000f\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R)\u0010ë\u0001\u001a\u0004\u0018\u0001078\u0000@\u0000X\u000e¢\u0006\u0016\n\u0005\bM\u0010ç\u0001\u001a\u0006\bè\u0001\u0010é\u0001\"\u0005\bê\u0001\u0010:R\u001c\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070D8\u0002X\u0004¢\u0006\u0007\n\u0005\b\u000e\u0010ì\u0001R\u001c\u0010î\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070D8\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0011\u0010ì\u0001R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010VR\u0013\u0010ð\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\bï\u0001\u0010*R\u0013\u0010ò\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\bñ\u0001\u0010*R\u0013\u0010ô\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\bó\u0001\u0010*¨\u0006÷\u0001"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter;", "T", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapterModuleImp;", "Lcom/chad/library/adapter/base/listener/BaseListenerImp;", "", "layoutResId", "", "data", "<init>", "(ILjava/util/List;)V", "", "y", "()V", "Ljava/lang/Class;", "z", "P", "(Ljava/lang/Class;)Ljava/lang/Class;", "Landroid/view/View;", "view", "C", "(Ljava/lang/Class;Landroid/view/View;)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "n", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "item", "A", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "", "", "payloads", "B", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "e0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "getItemCount", "()I", "position", "getItemViewType", "(I)I", "b0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "c0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;ILjava/util/List;)V", "", "getItemId", "(I)J", "g0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "type", "", "a0", "(I)Z", "getItem", "(I)Ljava/lang/Object;", "Q", "(Ljava/lang/Object;)I", "Ljava/util/LinkedHashSet;", "F", "()Ljava/util/LinkedHashSet;", "", "viewIds", "o", "([I)V", "G", "viewHolder", "x", "v", "p0", "(Landroid/view/View;I)V", "r0", "(Landroid/view/View;I)Z", "m0", "o0", "f0", "I", "J", "d0", "E", "D", "(Landroid/view/View;)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "l0", "index", "orientation", "t", "(Landroid/view/View;II)I", "Z", "()Z", "Y", "X", "Landroid/animation/Animator;", "anim", "t0", "(Landroid/animation/Animator;I)V", "j0", "(ILjava/lang/Object;)V", "p", "q", "(Ljava/lang/Object;)V", "", "newData", "r", "(Ljava/util/Collection;)V", "i0", "(I)V", "h0", "size", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "listener", "q0", "(Lcom/chad/library/adapter/base/listener/OnItemClickListener;)V", "Lcom/chad/library/adapter/base/listener/OnItemLongClickListener;", "s0", "(Lcom/chad/library/adapter/base/listener/OnItemLongClickListener;)V", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "n0", "(Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;)V", "V", "()Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "W", "()Lcom/chad/library/adapter/base/listener/OnItemLongClickListener;", "()Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "Lcom/chad/library/adapter/base/listener/OnItemChildLongClickListener;", "U", "()Lcom/chad/library/adapter/base/listener/OnItemChildLongClickListener;", "<set-?>", "a", "Ljava/util/List;", "getData", "()Ljava/util/List;", "k0", "(Ljava/util/List;)V", "b", "getHeaderWithEmptyEnable", "setHeaderWithEmptyEnable", "(Z)V", "headerWithEmptyEnable", "c", "getFooterWithEmptyEnable", "setFooterWithEmptyEnable", "footerWithEmptyEnable", "d", "isUseEmpty", "setUseEmpty", "e", "N", "setHeaderViewAsFlow", "headerViewAsFlow", "f", "L", "setFooterViewAsFlow", "footerViewAsFlow", "g", "getAnimationEnable", "setAnimationEnable", "animationEnable", "h", "isAnimationFirstOnly", "setAnimationFirstOnly", "Lcom/chad/library/adapter/base/animation/BaseAnimation;", "value", "i", "Lcom/chad/library/adapter/base/animation/BaseAnimation;", "getAdapterAnimation", "()Lcom/chad/library/adapter/base/animation/BaseAnimation;", "setAdapterAnimation", "(Lcom/chad/library/adapter/base/animation/BaseAnimation;)V", "adapterAnimation", "Landroid/widget/LinearLayout;", "j", "Landroid/widget/LinearLayout;", "mHeaderLayout", "k", "mFooterLayout", "Landroid/widget/FrameLayout;", "l", "Landroid/widget/FrameLayout;", "mEmptyLayout", "m", "mLastPosition", "Lcom/chad/library/adapter/base/listener/GridSpanSizeLookup;", "Lcom/chad/library/adapter/base/listener/GridSpanSizeLookup;", "mSpanSizeLookup", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "mOnItemClickListener", "Lcom/chad/library/adapter/base/listener/OnItemLongClickListener;", "mOnItemLongClickListener", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "mOnItemChildClickListener", "Lcom/chad/library/adapter/base/listener/OnItemChildLongClickListener;", "mOnItemChildLongClickListener", "Lcom/chad/library/adapter/base/module/BaseUpFetchModule;", "s", "Lcom/chad/library/adapter/base/module/BaseUpFetchModule;", "mUpFetchModule", "Lcom/chad/library/adapter/base/module/BaseDraggableModule;", "Lcom/chad/library/adapter/base/module/BaseDraggableModule;", "mDraggableModule", "Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "u", "Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "R", "()Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "setMLoadMoreModule$com_github_CymChad_brvah", "(Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;)V", "mLoadMoreModule", "Landroid/content/Context;", "Landroid/content/Context;", "H", "()Landroid/content/Context;", "context", "Ljava/lang/ref/WeakReference;", "w", "Ljava/lang/ref/WeakReference;", "getWeakRecyclerView", "()Ljava/lang/ref/WeakReference;", "setWeakRecyclerView", "(Ljava/lang/ref/WeakReference;)V", "weakRecyclerView$annotations", "weakRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "S", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView$com_github_CymChad_brvah", "mRecyclerView", "Ljava/util/LinkedHashSet;", "childClickViewIds", "childLongClickViewIds", "O", "headerViewPosition", "M", "headerLayoutCount", "K", "footerLayoutCount", "AnimationType", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseQuickAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> implements BaseQuickAdapterModuleImp, BaseListenerImp {
    public static final Companion B = new Companion((DefaultConstructorMarker) null);
    public final int A;

    /* renamed from: a  reason: collision with root package name */
    public List f2770a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public BaseAnimation i;
    public LinearLayout j;
    public LinearLayout k;
    public FrameLayout l;
    public int m;
    public GridSpanSizeLookup n;
    public OnItemClickListener o;
    public OnItemLongClickListener p;
    public OnItemChildClickListener q;
    public OnItemChildLongClickListener r;
    public BaseUpFetchModule s;
    public BaseDraggableModule t;
    public BaseLoadMoreModule u;
    public Context v;
    public WeakReference w;
    public RecyclerView x;
    public final LinkedHashSet y;
    public final LinkedHashSet z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter$AnimationType;", "", "(Ljava/lang/String;I)V", "AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
    public enum AnimationType {
        AlphaIn,
        ScaleIn,
        SlideInBottom,
        SlideInLeft,
        SlideInRight
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter$Companion;", "", "()V", "EMPTY_VIEW", "", "FOOTER_VIEW", "HEADER_VIEW", "LOAD_MORE_VIEW", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnimationType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AnimationType.AlphaIn.ordinal()] = 1;
            iArr[AnimationType.ScaleIn.ordinal()] = 2;
            iArr[AnimationType.SlideInBottom.ordinal()] = 3;
            iArr[AnimationType.SlideInLeft.ordinal()] = 4;
            iArr[AnimationType.SlideInRight.ordinal()] = 5;
        }
    }

    public BaseQuickAdapter(int i2, List list) {
        this.A = i2;
        this.f2770a = list == null ? new ArrayList() : list;
        this.d = true;
        this.h = true;
        this.m = -1;
        y();
        this.y = new LinkedHashSet();
        this.z = new LinkedHashSet();
    }

    public static final /* synthetic */ FrameLayout g(BaseQuickAdapter baseQuickAdapter) {
        FrameLayout frameLayout = baseQuickAdapter.l;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        }
        return frameLayout;
    }

    public static final /* synthetic */ LinearLayout h(BaseQuickAdapter baseQuickAdapter) {
        LinearLayout linearLayout = baseQuickAdapter.k;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
        }
        return linearLayout;
    }

    public static final /* synthetic */ LinearLayout i(BaseQuickAdapter baseQuickAdapter) {
        LinearLayout linearLayout = baseQuickAdapter.j;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
        }
        return linearLayout;
    }

    public static /* synthetic */ int u(BaseQuickAdapter baseQuickAdapter, View view, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = -1;
            }
            if ((i4 & 4) != 0) {
                i3 = 1;
            }
            return baseQuickAdapter.t(view, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHeaderView");
    }

    public abstract void A(BaseViewHolder baseViewHolder, Object obj);

    public void B(BaseViewHolder baseViewHolder, Object obj, List list) {
    }

    public final BaseViewHolder C(Class cls, View view) {
        try {
            Class<View> cls2 = View.class;
            if (cls.isMemberClass()) {
                if (!Modifier.isStatic(cls.getModifiers())) {
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{getClass(), cls2});
                    Intrinsics.checkExpressionValueIsNotNull(declaredConstructor, "z.getDeclaredConstructor…aClass, View::class.java)");
                    declaredConstructor.setAccessible(true);
                    Object newInstance = declaredConstructor.newInstance(new Object[]{this, view});
                    if (newInstance != null) {
                        return (BaseViewHolder) newInstance;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type VH");
                }
            }
            Constructor declaredConstructor2 = cls.getDeclaredConstructor(new Class[]{cls2});
            Intrinsics.checkExpressionValueIsNotNull(declaredConstructor2, "z.getDeclaredConstructor(View::class.java)");
            declaredConstructor2.setAccessible(true);
            Object newInstance2 = declaredConstructor2.newInstance(new Object[]{view});
            if (newInstance2 != null) {
                return (BaseViewHolder) newInstance2;
            }
            throw new TypeCastException("null cannot be cast to non-null type VH");
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public BaseViewHolder D(View view) {
        Class cls = getClass();
        Class cls2 = null;
        while (cls2 == null && cls != null) {
            cls2 = P(cls);
            cls = cls.getSuperclass();
        }
        BaseViewHolder baseViewHolder = cls2 == null ? new BaseViewHolder(view) : C(cls2, view);
        return baseViewHolder != null ? baseViewHolder : new BaseViewHolder(view);
    }

    public BaseViewHolder E(ViewGroup viewGroup, int i2) {
        return D(AdapterUtilsKt.a(viewGroup, i2));
    }

    public final LinkedHashSet F() {
        return this.y;
    }

    public final LinkedHashSet G() {
        return this.z;
    }

    public final Context H() {
        Context context = this.v;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    public int I() {
        return this.f2770a.size();
    }

    public int J(int i2) {
        return super.getItemViewType(i2);
    }

    public final int K() {
        return Y() ? 1 : 0;
    }

    public final boolean L() {
        return this.f;
    }

    public final int M() {
        return Z() ? 1 : 0;
    }

    public final boolean N() {
        return this.e;
    }

    public final int O() {
        return (!X() || this.b) ? 0 : -1;
    }

    public final Class P(Class cls) {
        try {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return null;
            }
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            Intrinsics.checkExpressionValueIsNotNull(actualTypeArguments, "type.actualTypeArguments");
            for (Type type : actualTypeArguments) {
                Class<BaseViewHolder> cls2 = BaseViewHolder.class;
                if (type instanceof Class) {
                    if (cls2.isAssignableFrom((Class) type)) {
                        return (Class) type;
                    }
                } else if (type instanceof ParameterizedType) {
                    Type rawType = ((ParameterizedType) type).getRawType();
                    Intrinsics.checkExpressionValueIsNotNull(rawType, "temp.rawType");
                    if ((rawType instanceof Class) && cls2.isAssignableFrom((Class) rawType)) {
                        return (Class) rawType;
                    }
                } else {
                    continue;
                }
            }
            return null;
        } catch (GenericSignatureFormatError e2) {
            e2.printStackTrace();
            return null;
        } catch (TypeNotPresentException e3) {
            e3.printStackTrace();
            return null;
        } catch (MalformedParameterizedTypeException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public int Q(Object obj) {
        if (obj == null || !(!this.f2770a.isEmpty())) {
            return -1;
        }
        return this.f2770a.indexOf(obj);
    }

    public final BaseLoadMoreModule R() {
        return this.u;
    }

    public final RecyclerView S() {
        return this.x;
    }

    public final OnItemChildClickListener T() {
        return this.q;
    }

    public final OnItemChildLongClickListener U() {
        return this.r;
    }

    public final OnItemClickListener V() {
        return this.o;
    }

    public final OnItemLongClickListener W() {
        return this.p;
    }

    public final boolean X() {
        FrameLayout frameLayout = this.l;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
            }
            if (frameLayout.getChildCount() != 0 && this.d) {
                return this.f2770a.isEmpty();
            }
            return false;
        }
        return false;
    }

    public final boolean Y() {
        LinearLayout linearLayout = this.k;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
        }
        return linearLayout.getChildCount() > 0;
    }

    public final boolean Z() {
        LinearLayout linearLayout = this.j;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
        }
        return linearLayout.getChildCount() > 0;
    }

    public boolean a0(int i2) {
        return i2 == 268436821 || i2 == 268435729 || i2 == 268436275 || i2 == 268436002;
    }

    /* renamed from: b0 */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        BaseUpFetchModule baseUpFetchModule = this.s;
        if (baseUpFetchModule != null) {
            baseUpFetchModule.a(i2);
        }
        BaseLoadMoreModule baseLoadMoreModule = this.u;
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.f(i2);
        }
        switch (baseViewHolder.getItemViewType()) {
            case 268435729:
            case 268436275:
            case 268436821:
                return;
            case 268436002:
                BaseLoadMoreModule baseLoadMoreModule2 = this.u;
                if (baseLoadMoreModule2 != null) {
                    baseLoadMoreModule2.i().a(baseViewHolder, i2, baseLoadMoreModule2.h());
                    return;
                }
                return;
            default:
                A(baseViewHolder, getItem(i2 - M()));
                return;
        }
    }

    /* renamed from: c0 */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2, List list) {
        if (list.isEmpty()) {
            onBindViewHolder(baseViewHolder, i2);
            return;
        }
        BaseUpFetchModule baseUpFetchModule = this.s;
        if (baseUpFetchModule != null) {
            baseUpFetchModule.a(i2);
        }
        BaseLoadMoreModule baseLoadMoreModule = this.u;
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.f(i2);
        }
        switch (baseViewHolder.getItemViewType()) {
            case 268435729:
            case 268436275:
            case 268436821:
                return;
            case 268436002:
                BaseLoadMoreModule baseLoadMoreModule2 = this.u;
                if (baseLoadMoreModule2 != null) {
                    baseLoadMoreModule2.i().a(baseViewHolder, i2, baseLoadMoreModule2.h());
                    return;
                }
                return;
            default:
                B(baseViewHolder, getItem(i2 - M()), list);
                return;
        }
    }

    public BaseViewHolder d0(ViewGroup viewGroup, int i2) {
        return E(viewGroup, this.A);
    }

    /* renamed from: e0 */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        switch (i2) {
            case 268435729:
                LinearLayout linearLayout = this.j;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                }
                ViewParent parent = linearLayout.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) parent;
                    LinearLayout linearLayout2 = this.j;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                    }
                    viewGroup2.removeView(linearLayout2);
                }
                LinearLayout linearLayout3 = this.j;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                }
                return D(linearLayout3);
            case 268436002:
                BaseLoadMoreModule baseLoadMoreModule = this.u;
                if (baseLoadMoreModule == null) {
                    Intrinsics.throwNpe();
                }
                BaseViewHolder D = D(baseLoadMoreModule.i().f(viewGroup));
                BaseLoadMoreModule baseLoadMoreModule2 = this.u;
                if (baseLoadMoreModule2 == null) {
                    Intrinsics.throwNpe();
                }
                baseLoadMoreModule2.p(D);
                return D;
            case 268436275:
                LinearLayout linearLayout4 = this.k;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                }
                ViewParent parent2 = linearLayout4.getParent();
                if (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup3 = (ViewGroup) parent2;
                    LinearLayout linearLayout5 = this.k;
                    if (linearLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                    }
                    viewGroup3.removeView(linearLayout5);
                }
                LinearLayout linearLayout6 = this.k;
                if (linearLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                }
                return D(linearLayout6);
            case 268436821:
                FrameLayout frameLayout = this.l;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                }
                ViewParent parent3 = frameLayout.getParent();
                if (parent3 instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) parent3;
                    FrameLayout frameLayout2 = this.l;
                    if (frameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                    }
                    viewGroup4.removeView(frameLayout2);
                }
                FrameLayout frameLayout3 = this.l;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                }
                return D(frameLayout3);
            default:
                BaseViewHolder d0 = d0(viewGroup, i2);
                x(d0, i2);
                BaseDraggableModule baseDraggableModule = this.t;
                if (baseDraggableModule != null) {
                    baseDraggableModule.g(d0);
                }
                f0(d0, i2);
                return d0;
        }
    }

    public void f0(BaseViewHolder baseViewHolder, int i2) {
    }

    /* renamed from: g0 */
    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        super.onViewAttachedToWindow(baseViewHolder);
        if (a0(baseViewHolder.getItemViewType())) {
            l0(baseViewHolder);
        } else {
            n(baseViewHolder);
        }
    }

    public final List getData() {
        return this.f2770a;
    }

    public Object getItem(int i2) {
        return this.f2770a.get(i2);
    }

    public int getItemCount() {
        int i2 = 1;
        if (X()) {
            if (this.b && Z()) {
                i2 = 2;
            }
            return (!this.c || !Y()) ? i2 : i2 + 1;
        }
        BaseLoadMoreModule baseLoadMoreModule = this.u;
        if (baseLoadMoreModule == null || !baseLoadMoreModule.l()) {
            i2 = 0;
        }
        return M() + I() + K() + i2;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public int getItemViewType(int i2) {
        if (X()) {
            boolean z2 = this.b && Z();
            if (i2 != 0) {
                if (i2 != 1) {
                }
                return 268436275;
            } else if (z2) {
                return 268435729;
            }
            return 268436821;
        }
        boolean Z = Z();
        if (Z && i2 == 0) {
            return 268435729;
        }
        if (Z) {
            i2--;
        }
        int size = this.f2770a.size();
        return i2 < size ? J(i2) : i2 - size < Y() ? 268436275 : 268436002;
    }

    public void h0(Object obj) {
        int indexOf = this.f2770a.indexOf(obj);
        if (indexOf != -1) {
            i0(indexOf);
        }
    }

    public void i0(int i2) {
        if (i2 < this.f2770a.size()) {
            this.f2770a.remove(i2);
            int M = i2 + M();
            notifyItemRemoved(M);
            z(0);
            notifyItemRangeChanged(M, this.f2770a.size() - M);
        }
    }

    public void j0(int i2, Object obj) {
        if (i2 < this.f2770a.size()) {
            this.f2770a.set(i2, obj);
            notifyItemChanged(i2 + M());
        }
    }

    public final void k0(List list) {
        this.f2770a = list;
    }

    public void l0(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void m0(View view, int i2) {
        OnItemChildClickListener onItemChildClickListener = this.q;
        if (onItemChildClickListener != null) {
            onItemChildClickListener.a(this, view, i2);
        }
    }

    public final void n(RecyclerView.ViewHolder viewHolder) {
        if (!this.g) {
            return;
        }
        if (!this.h || viewHolder.getLayoutPosition() > this.m) {
            BaseAnimation baseAnimation = this.i;
            if (baseAnimation == null) {
                baseAnimation = new AlphaInAnimation(0.0f, 1, (DefaultConstructorMarker) null);
            }
            View view = viewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            for (Animator t0 : baseAnimation.a(view)) {
                t0(t0, viewHolder.getLayoutPosition());
            }
            this.m = viewHolder.getLayoutPosition();
        }
    }

    public void n0(OnItemChildClickListener onItemChildClickListener) {
        this.q = onItemChildClickListener;
    }

    public final void o(int... iArr) {
        for (int valueOf : iArr) {
            this.y.add(Integer.valueOf(valueOf));
        }
    }

    public boolean o0(View view, int i2) {
        OnItemChildLongClickListener onItemChildLongClickListener = this.r;
        if (onItemChildLongClickListener != null) {
            return onItemChildLongClickListener.a(this, view, i2);
        }
        return false;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.w = new WeakReference(recyclerView);
        this.x = recyclerView;
        Context context = recyclerView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "recyclerView.context");
        this.v = context;
        BaseDraggableModule baseDraggableModule = this.t;
        if (baseDraggableModule != null) {
            baseDraggableModule.a(recyclerView);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new BaseQuickAdapter$onAttachedToRecyclerView$1(this, layoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.x = null;
    }

    public void p(int i2, Object obj) {
        this.f2770a.add(i2, obj);
        notifyItemInserted(i2 + M());
        z(1);
    }

    public void p0(View view, int i2) {
        OnItemClickListener onItemClickListener = this.o;
        if (onItemClickListener != null) {
            onItemClickListener.a(this, view, i2);
        }
    }

    public void q(Object obj) {
        this.f2770a.add(obj);
        notifyItemInserted(this.f2770a.size() + M());
        z(1);
    }

    public void q0(OnItemClickListener onItemClickListener) {
        this.o = onItemClickListener;
    }

    public void r(Collection collection) {
        this.f2770a.addAll(collection);
        notifyItemRangeInserted((this.f2770a.size() - collection.size()) + M(), collection.size());
        z(collection.size());
    }

    public boolean r0(View view, int i2) {
        OnItemLongClickListener onItemLongClickListener = this.p;
        if (onItemLongClickListener != null) {
            return onItemLongClickListener.a(this, view, i2);
        }
        return false;
    }

    public BaseDraggableModule s(BaseQuickAdapter baseQuickAdapter) {
        return BaseQuickAdapterModuleImp.DefaultImpls.a(this, baseQuickAdapter);
    }

    public void s0(OnItemLongClickListener onItemLongClickListener) {
        this.p = onItemLongClickListener;
    }

    public final int t(View view, int i2, int i3) {
        int O;
        if (this.j == null) {
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            this.j = linearLayout;
            linearLayout.setOrientation(i3);
            LinearLayout linearLayout2 = this.j;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
            }
            linearLayout2.setLayoutParams(i3 == 1 ? new RecyclerView.LayoutParams(-1, -2) : new RecyclerView.LayoutParams(-2, -1));
        }
        LinearLayout linearLayout3 = this.j;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
        }
        int childCount = linearLayout3.getChildCount();
        if (i2 < 0 || i2 > childCount) {
            i2 = childCount;
        }
        LinearLayout linearLayout4 = this.j;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
        }
        linearLayout4.addView(view, i2);
        LinearLayout linearLayout5 = this.j;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
        }
        if (linearLayout5.getChildCount() == 1 && (O = O()) != -1) {
            notifyItemInserted(O);
        }
        return i2;
    }

    public void t0(Animator animator, int i2) {
        animator.start();
    }

    public BaseLoadMoreModule v(BaseQuickAdapter baseQuickAdapter) {
        return BaseQuickAdapterModuleImp.DefaultImpls.b(this, baseQuickAdapter);
    }

    public BaseUpFetchModule w(BaseQuickAdapter baseQuickAdapter) {
        return BaseQuickAdapterModuleImp.DefaultImpls.c(this, baseQuickAdapter);
    }

    public void x(BaseViewHolder baseViewHolder, int i2) {
        if (this.o != null) {
            baseViewHolder.itemView.setOnClickListener(new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$1(this, baseViewHolder));
        }
        if (this.p != null) {
            baseViewHolder.itemView.setOnLongClickListener(new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$2(this, baseViewHolder));
        }
        if (this.q != null) {
            Iterator it = F().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                View view = baseViewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(num, "id");
                View findViewById = view.findViewById(num.intValue());
                if (findViewById != null) {
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$3(this, baseViewHolder));
                }
            }
        }
        if (this.r != null) {
            Iterator it2 = G().iterator();
            while (it2.hasNext()) {
                Integer num2 = (Integer) it2.next();
                View view2 = baseViewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(num2, "id");
                View findViewById2 = view2.findViewById(num2.intValue());
                if (findViewById2 != null) {
                    if (!findViewById2.isLongClickable()) {
                        findViewById2.setLongClickable(true);
                    }
                    findViewById2.setOnLongClickListener(new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$4(this, baseViewHolder));
                }
            }
        }
    }

    public final void y() {
        if (this instanceof LoadMoreModule) {
            this.u = v(this);
        }
        if (this instanceof UpFetchModule) {
            this.s = w(this);
        }
        if (this instanceof DraggableModule) {
            this.t = s(this);
        }
    }

    public final void z(int i2) {
        if (this.f2770a.size() == i2) {
            notifyDataSetChanged();
        }
    }
}
