package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.sharedpreferences.Messages;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LegacySharedPreferencesPlugin implements FlutterPlugin, Messages.SharedPreferencesApi {
    private static final String BIG_INTEGER_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy";
    private static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
    private static final String LIST_IDENTIFIER = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    private static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    private static final String TAG = "SharedPreferencesPlugin";
    private SharedPreferencesListEncoder listEncoder;
    private SharedPreferences preferences;

    public static class ListEncoder implements SharedPreferencesListEncoder {
        @NonNull
        public List<String> decode(@NonNull String str) throws RuntimeException {
            try {
                return (List) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 0))).readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @NonNull
        public String encode(@NonNull List<String> list) throws RuntimeException {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(list);
                objectOutputStream.flush();
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public LegacySharedPreferencesPlugin() {
        this(new ListEncoder());
    }

    @NonNull
    private Map<String, Object> getAllPrefs(@NonNull String str, @Nullable Set<String> set) throws RuntimeException {
        Map<String, ?> all = this.preferences.getAll();
        HashMap hashMap = new HashMap();
        for (String next : all.keySet()) {
            if (next.startsWith(str) && (set == null || set.contains(next))) {
                hashMap.put(next, transformPref(next, all.get(next)));
            }
        }
        return hashMap;
    }

    private void setUp(@NonNull BinaryMessenger binaryMessenger, @NonNull Context context) {
        this.preferences = context.getSharedPreferences("FlutterSharedPreferences", 0);
        try {
            Messages.SharedPreferencesApi.setUp(binaryMessenger, this);
        } catch (Exception e) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesPlugin", e);
        }
    }

    private Object transformPref(@NonNull String str, @NonNull Object obj) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
                return this.listEncoder.decode(str2.substring(40));
            }
            if (str2.startsWith(BIG_INTEGER_PREFIX)) {
                return new BigInteger(str2.substring(44), 36);
            }
            if (str2.startsWith(DOUBLE_PREFIX)) {
                return Double.valueOf(str2.substring(40));
            }
        } else if (obj instanceof Set) {
            ArrayList arrayList = new ArrayList((Set) obj);
            SharedPreferences.Editor remove = this.preferences.edit().remove(str);
            remove.putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + this.listEncoder.encode(arrayList)).apply();
            return arrayList;
        }
        return obj;
    }

    @NonNull
    public Boolean clear(@NonNull String str, @Nullable List<String> list) throws RuntimeException {
        SharedPreferences.Editor edit = this.preferences.edit();
        Map<String, ?> all = this.preferences.getAll();
        ArrayList arrayList = new ArrayList();
        for (String next : all.keySet()) {
            if (next.startsWith(str) && (list == null || list.contains(next))) {
                arrayList.add(next);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        return Boolean.valueOf(edit.commit());
    }

    @NonNull
    public Map<String, Object> getAll(@NonNull String str, @Nullable List<String> list) throws RuntimeException {
        return getAllPrefs(str, list == null ? null : new HashSet(list));
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        setUp(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Messages.SharedPreferencesApi.setUp(flutterPluginBinding.getBinaryMessenger(), (Messages.SharedPreferencesApi) null);
    }

    @NonNull
    public Boolean remove(@NonNull String str) {
        return Boolean.valueOf(this.preferences.edit().remove(str).commit());
    }

    @NonNull
    public Boolean setBool(@NonNull String str, @NonNull Boolean bool) {
        return Boolean.valueOf(this.preferences.edit().putBoolean(str, bool.booleanValue()).commit());
    }

    @NonNull
    public Boolean setDouble(@NonNull String str, @NonNull Double d) {
        String d2 = Double.toString(d.doubleValue());
        SharedPreferences.Editor edit = this.preferences.edit();
        return Boolean.valueOf(edit.putString(str, DOUBLE_PREFIX + d2).commit());
    }

    @NonNull
    public Boolean setInt(@NonNull String str, @NonNull Long l) {
        return Boolean.valueOf(this.preferences.edit().putLong(str, l.longValue()).commit());
    }

    @NonNull
    public Boolean setString(@NonNull String str, @NonNull String str2) {
        if (!str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") && !str2.startsWith(BIG_INTEGER_PREFIX) && !str2.startsWith(DOUBLE_PREFIX)) {
            return Boolean.valueOf(this.preferences.edit().putString(str, str2).commit());
        }
        throw new RuntimeException("StorageError: This string cannot be stored as it clashes with special identifier prefixes");
    }

    @NonNull
    public Boolean setStringList(@NonNull String str, @NonNull List<String> list) throws RuntimeException {
        SharedPreferences.Editor edit = this.preferences.edit();
        return Boolean.valueOf(edit.putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + this.listEncoder.encode(list)).commit());
    }

    @VisibleForTesting
    public LegacySharedPreferencesPlugin(@NonNull SharedPreferencesListEncoder sharedPreferencesListEncoder) {
        this.listEncoder = sharedPreferencesListEncoder;
    }
}
