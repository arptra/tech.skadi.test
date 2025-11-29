package io.ktor.http;

import com.honey.account.constant.AccountConstantKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0003\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bR\u001a\u0010\u000e\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0015\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001a\u0010\u0018\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u001a\u0010\u001b\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u001a\u0010\u001e\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001a\u0010!\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u001a\u0010$\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\rR\u001a\u0010&\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001a\u0010(\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u001a\u0010*\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u001a\u0010,\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u001a\u0010.\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b\u001f\u0010\rR\u001a\u00101\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\rR\u001a\u00103\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b2\u0010\u000b\u001a\u0004\b\"\u0010\rR\u001a\u00106\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR\u001a\u00109\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\u001a\u0010;\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b:\u0010\u000b\u001a\u0004\b%\u0010\rR\u001a\u0010=\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b<\u0010\u000b\u001a\u0004\b'\u0010\rR\u001a\u0010@\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\rR\u001a\u0010B\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bA\u0010\u000b\u001a\u0004\b)\u0010\rR\u001a\u0010E\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bC\u0010\u000b\u001a\u0004\bD\u0010\rR\u001a\u0010H\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bF\u0010\u000b\u001a\u0004\bG\u0010\rR\u001a\u0010K\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bI\u0010\u000b\u001a\u0004\bJ\u0010\rR\u001a\u0010M\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bL\u0010\u000b\u001a\u0004\b+\u0010\rR\u001a\u0010P\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bN\u0010\u000b\u001a\u0004\bO\u0010\rR\u001a\u0010R\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bQ\u0010\u000b\u001a\u0004\b-\u0010\rR\u001a\u0010U\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bS\u0010\u000b\u001a\u0004\bT\u0010\rR\u001a\u0010X\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bV\u0010\u000b\u001a\u0004\bW\u0010\rR\u001a\u0010[\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bY\u0010\u000b\u001a\u0004\bZ\u0010\rR\u001a\u0010^\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b\\\u0010\u000b\u001a\u0004\b]\u0010\rR\u001a\u0010a\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b_\u0010\u000b\u001a\u0004\b`\u0010\rR\u001a\u0010d\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bb\u0010\u000b\u001a\u0004\bc\u0010\rR\u001a\u0010f\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\be\u0010\u000b\u001a\u0004\b/\u0010\rR\u001a\u0010h\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bg\u0010\u000b\u001a\u0004\b2\u0010\rR\u001a\u0010k\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bi\u0010\u000b\u001a\u0004\bj\u0010\rR\u001a\u0010n\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bl\u0010\u000b\u001a\u0004\bm\u0010\rR\u001a\u0010p\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bo\u0010\u000b\u001a\u0004\b4\u0010\rR\u001a\u0010r\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bq\u0010\u000b\u001a\u0004\b7\u0010\rR\u001a\u0010t\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bs\u0010\u000b\u001a\u0004\b:\u0010\rR\u001a\u0010w\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bu\u0010\u000b\u001a\u0004\bv\u0010\rR\u001a\u0010z\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\bx\u0010\u000b\u001a\u0004\by\u0010\rR\u001a\u0010}\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b{\u0010\u000b\u001a\u0004\b|\u0010\rR\u001b\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\f\n\u0004\b~\u0010\u000b\u001a\u0004\b\u0010\rR\u001d\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\rR\u001d\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\rR\u001d\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\rR\u001d\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\rR\u001d\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\rR\u001d\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\rR\u001d\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\rR\u001d\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\rR\u001d\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\rR\u001d\u0010\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010\rR\u001d\u0010¡\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b \u0001\u0010\rR\u001d\u0010¤\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b¢\u0001\u0010\u000b\u001a\u0005\b£\u0001\u0010\rR\u001d\u0010§\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b¥\u0001\u0010\u000b\u001a\u0005\b¦\u0001\u0010\rR\u001d\u0010ª\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b¨\u0001\u0010\u000b\u001a\u0005\b©\u0001\u0010\rR\u001c\u0010¬\u0001\u001a\u00020\u00048\u0006XD¢\u0006\r\n\u0005\b«\u0001\u0010\u000b\u001a\u0004\b<\u0010\rR\u001d\u0010¯\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b­\u0001\u0010\u000b\u001a\u0005\b®\u0001\u0010\rR\u001d\u0010²\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b°\u0001\u0010\u000b\u001a\u0005\b±\u0001\u0010\rR\u001d\u0010µ\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b³\u0001\u0010\u000b\u001a\u0005\b´\u0001\u0010\rR\u001c\u0010·\u0001\u001a\u00020\u00048\u0006XD¢\u0006\r\n\u0005\b¶\u0001\u0010\u000b\u001a\u0004\b>\u0010\rR\u001c\u0010¹\u0001\u001a\u00020\u00048\u0006XD¢\u0006\r\n\u0005\b¸\u0001\u0010\u000b\u001a\u0004\bA\u0010\rR\u001d\u0010¼\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bº\u0001\u0010\u000b\u001a\u0005\b»\u0001\u0010\rR\u001c\u0010¾\u0001\u001a\u00020\u00048\u0006XD¢\u0006\r\n\u0005\b½\u0001\u0010\u000b\u001a\u0004\bC\u0010\rR\u001d\u0010Á\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b¿\u0001\u0010\u000b\u001a\u0005\bÀ\u0001\u0010\rR\u001c\u0010Ã\u0001\u001a\u00020\u00048\u0006XD¢\u0006\r\n\u0005\bÂ\u0001\u0010\u000b\u001a\u0004\bF\u0010\rR\u001d\u0010Æ\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bÄ\u0001\u0010\u000b\u001a\u0005\bÅ\u0001\u0010\rR\u001d\u0010É\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bÇ\u0001\u0010\u000b\u001a\u0005\bÈ\u0001\u0010\rR\u001d\u0010Ì\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bÊ\u0001\u0010\u000b\u001a\u0005\bË\u0001\u0010\rR\u001d\u0010Ï\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bÍ\u0001\u0010\u000b\u001a\u0005\bÎ\u0001\u0010\rR\u001d\u0010Ò\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bÐ\u0001\u0010\u000b\u001a\u0005\bÑ\u0001\u0010\rR\u001d\u0010Õ\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bÓ\u0001\u0010\u000b\u001a\u0005\bÔ\u0001\u0010\rR\u001c\u0010×\u0001\u001a\u00020\u00048\u0006XD¢\u0006\r\n\u0005\bÖ\u0001\u0010\u000b\u001a\u0004\bL\u0010\rR\u001c\u0010Ù\u0001\u001a\u00020\u00048\u0006XD¢\u0006\r\n\u0005\bØ\u0001\u0010\u000b\u001a\u0004\bN\u0010\rR\u001c\u0010Û\u0001\u001a\u00020\u00048\u0006XD¢\u0006\r\n\u0005\bÚ\u0001\u0010\u000b\u001a\u0004\bQ\u0010\rR\u001d\u0010Þ\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bÜ\u0001\u0010\u000b\u001a\u0005\bÝ\u0001\u0010\rR\u001c\u0010à\u0001\u001a\u00020\u00048\u0006XD¢\u0006\r\n\u0005\bß\u0001\u0010\u000b\u001a\u0004\bS\u0010\rR\u001d\u0010ã\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bá\u0001\u0010\u000b\u001a\u0005\bâ\u0001\u0010\rR\u001d\u0010æ\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bä\u0001\u0010\u000b\u001a\u0005\bå\u0001\u0010\rR\u001d\u0010é\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bç\u0001\u0010\u000b\u001a\u0005\bè\u0001\u0010\rR\u001d\u0010ì\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bê\u0001\u0010\u000b\u001a\u0005\bë\u0001\u0010\rR\u001d\u0010ï\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bí\u0001\u0010\u000b\u001a\u0005\bî\u0001\u0010\rR\u001d\u0010ò\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bð\u0001\u0010\u000b\u001a\u0005\bñ\u0001\u0010\rR\u001d\u0010õ\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bó\u0001\u0010\u000b\u001a\u0005\bô\u0001\u0010\rR\u001d\u0010ø\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bö\u0001\u0010\u000b\u001a\u0005\b÷\u0001\u0010\rR\u001d\u0010û\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bù\u0001\u0010\u000b\u001a\u0005\bú\u0001\u0010\rR\u001d\u0010þ\u0001\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bü\u0001\u0010\u000b\u001a\u0005\bý\u0001\u0010\rR\u001d\u0010\u0002\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\bÿ\u0001\u0010\u000b\u001a\u0005\b\u0002\u0010\rR\u001d\u0010\u0002\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0002\u0010\u000b\u001a\u0005\b\u0002\u0010\rR\u001d\u0010\u0002\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0002\u0010\u000b\u001a\u0005\b\u0002\u0010\rR\u001d\u0010\u0002\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0002\u0010\u000b\u001a\u0005\b\u0002\u0010\rR\u001d\u0010\u0002\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0002\u0010\u000b\u001a\u0005\b\u0002\u0010\rR\u001d\u0010\u0002\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0002\u0010\u000b\u001a\u0005\b\u0002\u0010\rR\u001d\u0010\u0002\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0002\u0010\u000b\u001a\u0005\b\u0002\u0010\rR\u001d\u0010\u0002\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0005\b\u0002\u0010\u000b\u001a\u0005\b\u0002\u0010\rR\u001e\u0010\u0002\u001a\t\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\"\u0010\u0002\u001a\t\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\u000f\n\u0006\b\u0002\u0010\u0002\u001a\u0005\bI\u0010\u0002¨\u0006 \u0002"}, d2 = {"Lio/ktor/http/HttpHeaders;", "", "<init>", "()V", "", "name", "", "a", "(Ljava/lang/String;)V", "value", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Accept", "d", "AcceptCharset", "getAcceptEncoding", "AcceptEncoding", "e", "getAcceptLanguage", "AcceptLanguage", "f", "getAcceptRanges", "AcceptRanges", "g", "getAge", "Age", "h", "getAllow", "Allow", "i", "getALPN", "ALPN", "j", "getAuthenticationInfo", "AuthenticationInfo", "k", "Authorization", "l", "CacheControl", "m", "Connection", "n", "ContentDisposition", "o", "ContentEncoding", "p", "getContentLanguage", "ContentLanguage", "q", "ContentLength", "r", "getContentLocation", "ContentLocation", "s", "getContentRange", "ContentRange", "t", "ContentType", "u", "Cookie", "v", "getDASL", "DASL", "w", "Date", "x", "getDAV", "DAV", "y", "getDepth", "Depth", "z", "getDestination", "Destination", "A", "ETag", "B", "getExpect", "Expect", "C", "Expires", "D", "getFrom", "From", "E", "getForwarded", "Forwarded", "F", "getHost", "Host", "G", "getHTTP2Settings", "HTTP2Settings", "H", "getIf", "If", "I", "getIfMatch", "IfMatch", "J", "IfModifiedSince", "K", "IfNoneMatch", "L", "getIfRange", "IfRange", "M", "getIfScheduleTagMatch", "IfScheduleTagMatch", "N", "IfUnmodifiedSince", "O", "LastModified", "P", "Location", "Q", "getLockToken", "LockToken", "R", "getLink", "Link", "S", "getMaxForwards", "MaxForwards", "T", "getMIMEVersion", "MIMEVersion", "U", "getOrderingType", "OrderingType", "V", "getOrigin", "Origin", "W", "getOverwrite", "Overwrite", "X", "getPosition", "Position", "Y", "getPragma", "Pragma", "Z", "getPrefer", "Prefer", "a0", "getPreferenceApplied", "PreferenceApplied", "b0", "getProxyAuthenticate", "ProxyAuthenticate", "c0", "getProxyAuthenticationInfo", "ProxyAuthenticationInfo", "d0", "getProxyAuthorization", "ProxyAuthorization", "e0", "getPublicKeyPins", "PublicKeyPins", "f0", "getPublicKeyPinsReportOnly", "PublicKeyPinsReportOnly", "g0", "getRange", "Range", "h0", "getReferrer", "Referrer", "i0", "RetryAfter", "j0", "getScheduleReply", "ScheduleReply", "k0", "getScheduleTag", "ScheduleTag", "l0", "getSecWebSocketAccept", "SecWebSocketAccept", "m0", "SecWebSocketExtensions", "n0", "SecWebSocketKey", "o0", "getSecWebSocketProtocol", "SecWebSocketProtocol", "p0", "SecWebSocketVersion", "q0", "getServer", "Server", "r0", "SetCookie", "s0", "getSLUG", "SLUG", "t0", "getStrictTransportSecurity", "StrictTransportSecurity", "u0", "getTE", "TE", "v0", "getTimeout", "Timeout", "w0", "getTrailer", "Trailer", "x0", "getTransferEncoding", "TransferEncoding", "y0", "Upgrade", "z0", "UserAgent", "A0", "Vary", "B0", "getVia", "Via", "C0", "Warning", "D0", "getWWWAuthenticate", "WWWAuthenticate", "E0", "getAccessControlAllowOrigin", "AccessControlAllowOrigin", "F0", "getAccessControlAllowMethods", "AccessControlAllowMethods", "G0", "getAccessControlAllowCredentials", "AccessControlAllowCredentials", "H0", "getAccessControlAllowHeaders", "AccessControlAllowHeaders", "I0", "getAccessControlRequestMethod", "AccessControlRequestMethod", "J0", "getAccessControlRequestHeaders", "AccessControlRequestHeaders", "K0", "getAccessControlExposeHeaders", "AccessControlExposeHeaders", "L0", "getAccessControlMaxAge", "AccessControlMaxAge", "M0", "getXHttpMethodOverride", "XHttpMethodOverride", "N0", "getXForwardedHost", "XForwardedHost", "O0", "getXForwardedServer", "XForwardedServer", "P0", "getXForwardedProto", "XForwardedProto", "Q0", "getXForwardedFor", "XForwardedFor", "R0", "getXForwardedPort", "XForwardedPort", "S0", "getXRequestId", "XRequestId", "T0", "getXCorrelationId", "XCorrelationId", "U0", "getXTotalCount", "XTotalCount", "", "V0", "[Ljava/lang/String;", "UnsafeHeadersArray", "", "W0", "Ljava/util/List;", "()Ljava/util/List;", "UnsafeHeadersList", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpHeaders.kt\nio/ktor/http/HttpHeaders\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,200:1\n12744#2,2:201\n1183#3,3:203\n1183#3,3:206\n*S KotlinDebug\n*F\n+ 1 HttpHeaders.kt\nio/ktor/http/HttpHeaders\n*L\n130#1:201,2\n147#1:203,3\n158#1:206,3\n*E\n"})
public final class HttpHeaders {
    public static final String A = "ETag";
    public static final String A0 = "Vary";
    public static final String B = "Expect";
    public static final String B0 = "Via";
    public static final String C = "Expires";
    public static final String C0 = "Warning";
    public static final String D = "From";
    public static final String D0 = "WWW-Authenticate";
    public static final String E = com.google.common.net.HttpHeaders.FORWARDED;
    public static final String E0 = "Access-Control-Allow-Origin";
    public static final String F = "Host";
    public static final String F0 = "Access-Control-Allow-Methods";
    public static final String G = com.google.common.net.HttpHeaders.HTTP2_SETTINGS;
    public static final String G0 = "Access-Control-Allow-Credentials";
    public static final String H = "If";
    public static final String H0 = "Access-Control-Allow-Headers";
    public static final String I = "If-Match";
    public static final String I0 = "Access-Control-Request-Method";
    public static final String J = "If-Modified-Since";
    public static final String J0 = "Access-Control-Request-Headers";
    public static final String K = "If-None-Match";
    public static final String K0 = "Access-Control-Expose-Headers";
    public static final String L = "If-Range";
    public static final String L0 = "Access-Control-Max-Age";
    public static final String M = "If-Schedule-Tag-Match";
    public static final String M0 = "X-Http-Method-Override";
    public static final String N = "If-Unmodified-Since";
    public static final String N0 = com.google.common.net.HttpHeaders.X_FORWARDED_HOST;
    public static final String O = "Last-Modified";
    public static final String O0 = "X-Forwarded-Server";
    public static final String P = "Location";
    public static final String P0 = com.google.common.net.HttpHeaders.X_FORWARDED_PROTO;
    public static final String Q = "Lock-Token";
    public static final String Q0 = com.google.common.net.HttpHeaders.X_FORWARDED_FOR;
    public static final String R = com.google.common.net.HttpHeaders.LINK;
    public static final String R0 = com.google.common.net.HttpHeaders.X_FORWARDED_PORT;
    public static final String S = "Max-Forwards";
    public static final String S0 = com.google.common.net.HttpHeaders.X_REQUEST_ID;
    public static final String T = "MIME-Version";
    public static final String T0 = "X-Correlation-ID";
    public static final String U = "Ordering-Type";
    public static final String U0 = "X-Total-Count";
    public static final String V = "Origin";
    public static final String[] V0;
    public static final String W = "Overwrite";
    public static final List W0;
    public static final String X = "Position";
    public static final String Y = "Pragma";
    public static final String Z = "Prefer";

    /* renamed from: a  reason: collision with root package name */
    public static final HttpHeaders f8966a = new HttpHeaders();
    public static final String a0 = "Preference-Applied";
    public static final String b = "Accept";
    public static final String b0 = "Proxy-Authenticate";
    public static final String c = "Accept-Charset";
    public static final String c0 = "Proxy-Authentication-Info";
    public static final String d = "Accept-Encoding";
    public static final String d0 = "Proxy-Authorization";
    public static final String e = "Accept-Language";
    public static final String e0 = com.google.common.net.HttpHeaders.PUBLIC_KEY_PINS;
    public static final String f = "Accept-Ranges";
    public static final String f0 = com.google.common.net.HttpHeaders.PUBLIC_KEY_PINS_REPORT_ONLY;
    public static final String g = "Age";
    public static final String g0 = "Range";
    public static final String h = "Allow";
    public static final String h0 = "Referer";
    public static final String i = "ALPN";
    public static final String i0 = "Retry-After";
    public static final String j = "Authentication-Info";
    public static final String j0 = "Schedule-Reply";
    public static final String k = "Authorization";
    public static final String k0 = "Schedule-Tag";
    public static final String l = "Cache-Control";
    public static final String l0 = "Sec-WebSocket-Accept";
    public static final String m = "Connection";
    public static final String m0 = com.google.common.net.HttpHeaders.SEC_WEBSOCKET_EXTENSIONS;
    public static final String n = com.google.common.net.HttpHeaders.CONTENT_DISPOSITION;
    public static final String n0 = "Sec-WebSocket-Key";
    public static final String o = "Content-Encoding";
    public static final String o0 = "Sec-WebSocket-Protocol";
    public static final String p = "Content-Language";
    public static final String p0 = "Sec-WebSocket-Version";
    public static final String q = "Content-Length";
    public static final String q0 = "Server";
    public static final String r = "Content-Location";
    public static final String r0 = "Set-Cookie";
    public static final String s = "Content-Range";
    public static final String s0 = "SLUG";
    public static final String t = "Content-Type";
    public static final String t0 = com.google.common.net.HttpHeaders.STRICT_TRANSPORT_SECURITY;
    public static final String u = "Cookie";
    public static final String u0 = "TE";
    public static final String v = "DASL";
    public static final String v0 = "Timeout";
    public static final String w = "Date";
    public static final String w0 = "Trailer";
    public static final String x = "DAV";
    public static final String x0 = "Transfer-Encoding";
    public static final String y = "Depth";
    public static final String y0 = "Upgrade";
    public static final String z = "Destination";
    public static final String z0 = "User-Agent";

    static {
        String[] strArr = {"Transfer-Encoding", "Upgrade"};
        V0 = strArr;
        W0 = ArraysKt.asList((T[]) strArr);
    }

    public final String A() {
        return y0;
    }

    public final String B() {
        return z0;
    }

    public final String C() {
        return A0;
    }

    public final String D() {
        return C0;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            int i4 = i3 + 1;
            if (Intrinsics.compare((int) charAt, 32) <= 0 || HttpHeadersKt.b(charAt)) {
                throw new IllegalHeaderNameException(str, i3);
            }
            i2++;
            i3 = i4;
        }
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            int i4 = i3 + 1;
            if (Intrinsics.compare((int) charAt, 32) >= 0 || charAt == 9) {
                i2++;
                i3 = i4;
            } else {
                throw new IllegalHeaderValueException(str, i3);
            }
        }
    }

    public final String c() {
        return b;
    }

    public final String d() {
        return c;
    }

    public final String e() {
        return k;
    }

    public final String f() {
        return l;
    }

    public final String g() {
        return m;
    }

    public final String h() {
        return n;
    }

    public final String i() {
        return o;
    }

    public final String j() {
        return q;
    }

    public final String k() {
        return t;
    }

    public final String l() {
        return u;
    }

    public final String m() {
        return w;
    }

    public final String n() {
        return A;
    }

    public final String o() {
        return C;
    }

    public final String p() {
        return J;
    }

    public final String q() {
        return K;
    }

    public final String r() {
        return N;
    }

    public final String s() {
        return O;
    }

    public final String t() {
        return P;
    }

    public final String u() {
        return i0;
    }

    public final String v() {
        return m0;
    }

    public final String w() {
        return n0;
    }

    public final String x() {
        return p0;
    }

    public final String y() {
        return r0;
    }

    public final List z() {
        return W0;
    }
}
