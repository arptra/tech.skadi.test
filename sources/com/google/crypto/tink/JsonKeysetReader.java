package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Path;

public final class JsonKeysetReader implements KeysetReader {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final InputStream inputStream;
    private final JsonObject json;
    private boolean urlSafeBase64 = false;

    private JsonKeysetReader(InputStream inputStream2) {
        this.inputStream = inputStream2;
        this.json = null;
    }

    private EncryptedKeyset encryptedKeysetFromJson(JsonObject jsonObject) {
        validateEncryptedKeyset(jsonObject);
        return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(this.urlSafeBase64 ? Base64.urlSafeDecode(jsonObject.get("encryptedKeyset").getAsString()) : Base64.decode(jsonObject.get("encryptedKeyset").getAsString()))).setKeysetInfo(keysetInfoFromJson(jsonObject.getAsJsonObject("keysetInfo"))).build();
    }

    private static KeyData.KeyMaterialType getKeyMaterialType(String str) {
        if (str.equals("SYMMETRIC")) {
            return KeyData.KeyMaterialType.SYMMETRIC;
        }
        if (str.equals("ASYMMETRIC_PRIVATE")) {
            return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
        }
        if (str.equals("ASYMMETRIC_PUBLIC")) {
            return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
        }
        if (str.equals("REMOTE")) {
            return KeyData.KeyMaterialType.REMOTE;
        }
        throw new JsonParseException("unknown key material type: " + str);
    }

    private static OutputPrefixType getOutputPrefixType(String str) {
        if (str.equals("TINK")) {
            return OutputPrefixType.TINK;
        }
        if (str.equals("RAW")) {
            return OutputPrefixType.RAW;
        }
        if (str.equals("LEGACY")) {
            return OutputPrefixType.LEGACY;
        }
        if (str.equals("CRUNCHY")) {
            return OutputPrefixType.CRUNCHY;
        }
        throw new JsonParseException("unknown output prefix type: " + str);
    }

    private static KeyStatusType getStatus(String str) {
        if (str.equals("ENABLED")) {
            return KeyStatusType.ENABLED;
        }
        if (str.equals("DISABLED")) {
            return KeyStatusType.DISABLED;
        }
        throw new JsonParseException("unknown status: " + str);
    }

    private KeyData keyDataFromJson(JsonObject jsonObject) {
        validateKeyData(jsonObject);
        return (KeyData) KeyData.newBuilder().setTypeUrl(jsonObject.get("typeUrl").getAsString()).setValue(ByteString.copyFrom(this.urlSafeBase64 ? Base64.urlSafeDecode(jsonObject.get(AccountConstantKt.RESPONSE_VALUE).getAsString()) : Base64.decode(jsonObject.get(AccountConstantKt.RESPONSE_VALUE).getAsString()))).setKeyMaterialType(getKeyMaterialType(jsonObject.get("keyMaterialType").getAsString())).build();
    }

    private Keyset.Key keyFromJson(JsonObject jsonObject) {
        validateKey(jsonObject);
        return (Keyset.Key) Keyset.Key.newBuilder().setStatus(getStatus(jsonObject.get("status").getAsString())).setKeyId(jsonObject.get("keyId").getAsInt()).setOutputPrefixType(getOutputPrefixType(jsonObject.get("outputPrefixType").getAsString())).setKeyData(keyDataFromJson(jsonObject.getAsJsonObject("keyData"))).build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(JsonObject jsonObject) {
        return (KeysetInfo.KeyInfo) KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(jsonObject.get("status").getAsString())).setKeyId(jsonObject.get("keyId").getAsInt()).setOutputPrefixType(getOutputPrefixType(jsonObject.get("outputPrefixType").getAsString())).setTypeUrl(jsonObject.get("typeUrl").getAsString()).build();
    }

    private Keyset keysetFromJson(JsonObject jsonObject) {
        validateKeyset(jsonObject);
        Keyset.Builder newBuilder = Keyset.newBuilder();
        if (jsonObject.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(jsonObject.get("primaryKeyId").getAsInt());
        }
        JsonArray asJsonArray = jsonObject.getAsJsonArray(IntentKey.ACTIVITY.ACTION_KEY);
        for (int i = 0; i < asJsonArray.size(); i++) {
            newBuilder.addKey(keyFromJson(asJsonArray.get(i).getAsJsonObject()));
        }
        return (Keyset) newBuilder.build();
    }

    private static KeysetInfo keysetInfoFromJson(JsonObject jsonObject) {
        KeysetInfo.Builder newBuilder = KeysetInfo.newBuilder();
        if (jsonObject.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(jsonObject.get("primaryKeyId").getAsInt());
        }
        if (jsonObject.has("keyInfo")) {
            JsonArray asJsonArray = jsonObject.getAsJsonArray("keyInfo");
            for (int i = 0; i < asJsonArray.size(); i++) {
                newBuilder.addKeyInfo(keyInfoFromJson(asJsonArray.get(i).getAsJsonObject()));
            }
        }
        return (KeysetInfo) newBuilder.build();
    }

    private static void validateEncryptedKeyset(JsonObject jsonObject) {
        if (!jsonObject.has("encryptedKeyset")) {
            throw new JsonParseException("invalid encrypted keyset");
        }
    }

    private static void validateKey(JsonObject jsonObject) {
        if (!jsonObject.has("keyData") || !jsonObject.has("status") || !jsonObject.has("keyId") || !jsonObject.has("outputPrefixType")) {
            throw new JsonParseException("invalid key");
        }
    }

    private static void validateKeyData(JsonObject jsonObject) {
        if (!jsonObject.has("typeUrl") || !jsonObject.has(AccountConstantKt.RESPONSE_VALUE) || !jsonObject.has("keyMaterialType")) {
            throw new JsonParseException("invalid keyData");
        }
    }

    private static void validateKeyset(JsonObject jsonObject) {
        if (!jsonObject.has(IntentKey.ACTIVITY.ACTION_KEY) || jsonObject.getAsJsonArray(IntentKey.ACTIVITY.ACTION_KEY).size() == 0) {
            throw new JsonParseException("invalid keyset");
        }
    }

    public static JsonKeysetReader withBytes(byte[] bArr) {
        return new JsonKeysetReader((InputStream) new ByteArrayInputStream(bArr));
    }

    public static JsonKeysetReader withFile(File file) throws IOException {
        return new JsonKeysetReader((InputStream) new FileInputStream(file));
    }

    public static KeysetReader withInputStream(InputStream inputStream2) throws IOException {
        return new JsonKeysetReader(inputStream2);
    }

    @Deprecated
    public static JsonKeysetReader withJsonObject(Object obj) {
        return withString(obj.toString());
    }

    public static JsonKeysetReader withPath(String str) throws IOException {
        return withFile(new File(str));
    }

    public static JsonKeysetReader withString(String str) {
        return new JsonKeysetReader((InputStream) new ByteArrayInputStream(str.getBytes(UTF_8)));
    }

    public Keyset read() throws IOException {
        try {
            JsonObject jsonObject = this.json;
            if (jsonObject != null) {
                Keyset keysetFromJson = keysetFromJson(jsonObject);
                InputStream inputStream2 = this.inputStream;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                return keysetFromJson;
            }
            JsonReader jsonReader = new JsonReader(new StringReader(new String(Util.readAll(this.inputStream), UTF_8)));
            jsonReader.setLenient(false);
            Keyset keysetFromJson2 = keysetFromJson(Streams.parse(jsonReader).getAsJsonObject());
            InputStream inputStream3 = this.inputStream;
            if (inputStream3 != null) {
                inputStream3.close();
            }
            return keysetFromJson2;
        } catch (JsonParseException | IllegalStateException e) {
            throw new IOException(e);
        } catch (Throwable th) {
            InputStream inputStream4 = this.inputStream;
            if (inputStream4 != null) {
                inputStream4.close();
            }
            throw th;
        }
    }

    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            JsonObject jsonObject = this.json;
            if (jsonObject != null) {
                EncryptedKeyset encryptedKeysetFromJson = encryptedKeysetFromJson(jsonObject);
                InputStream inputStream2 = this.inputStream;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                return encryptedKeysetFromJson;
            }
            EncryptedKeyset encryptedKeysetFromJson2 = encryptedKeysetFromJson(JsonParser.parseString(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
            InputStream inputStream3 = this.inputStream;
            if (inputStream3 != null) {
                inputStream3.close();
            }
            return encryptedKeysetFromJson2;
        } catch (JsonParseException | IllegalStateException e) {
            throw new IOException(e);
        } catch (Throwable th) {
            InputStream inputStream4 = this.inputStream;
            if (inputStream4 != null) {
                inputStream4.close();
            }
            throw th;
        }
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    public static JsonKeysetReader withPath(Path path) throws IOException {
        return withFile(path.toFile());
    }

    private JsonKeysetReader(JsonObject jsonObject) {
        this.json = jsonObject;
        this.inputStream = null;
    }
}
