package io.flutter.plugins.pathprovider;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.eb.a;
import com.honey.account.eb.b;
import com.honey.account.eb.c;
import com.honey.account.eb.d;
import com.honey.account.eb.e;
import com.honey.account.eb.f;
import com.honey.account.eb.g;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.ArrayList;
import java.util.List;

public class Messages {

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public interface PathProviderApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getTemporaryPath());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getApplicationSupportPath());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$2(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getApplicationDocumentsPath());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$3(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getApplicationCachePath());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$4(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getExternalStoragePath());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$5(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getExternalCachePaths());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$6(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, pathProviderApi.getExternalStoragePaths(arrayList2.get(0) == null ? null : StorageDirectory.values()[((Integer) arrayList2.get(0)).intValue()]));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable PathProviderApi pathProviderApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getTemporaryPath", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                basicMessageChannel.setMessageHandler(new a(pathProviderApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getApplicationSupportPath", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                basicMessageChannel2.setMessageHandler(new b(pathProviderApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getApplicationDocumentsPath", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                basicMessageChannel3.setMessageHandler(new c(pathProviderApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getApplicationCachePath", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                basicMessageChannel4.setMessageHandler(new d(pathProviderApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePath", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                basicMessageChannel5.setMessageHandler(new e(pathProviderApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getExternalCachePaths", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                basicMessageChannel6.setMessageHandler(new f(pathProviderApi));
            } else {
                basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePaths", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                basicMessageChannel7.setMessageHandler(new g(pathProviderApi));
            } else {
                basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        @Nullable
        String getApplicationCachePath();

        @Nullable
        String getApplicationDocumentsPath();

        @Nullable
        String getApplicationSupportPath();

        @NonNull
        List<String> getExternalCachePaths();

        @Nullable
        String getExternalStoragePath();

        @NonNull
        List<String> getExternalStoragePaths(@NonNull StorageDirectory storageDirectory);

        @Nullable
        String getTemporaryPath();
    }

    public enum StorageDirectory {
        ROOT(0),
        MUSIC(1),
        PODCASTS(2),
        RINGTONES(3),
        ALARMS(4),
        NOTIFICATIONS(5),
        PICTURES(6),
        MOVIES(7),
        DOWNLOADS(8),
        DCIM(9),
        DOCUMENTS(10);
        
        final int index;

        private StorageDirectory(int i) {
            this.index = i;
        }
    }

    @NonNull
    public static ArrayList<Object> wrapError(@NonNull Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}
