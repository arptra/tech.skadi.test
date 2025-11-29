package com.upuphone.xr.interconnect.business.databinder;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderValueTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDataBinderValueTypeAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderValueTypeAdapter.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderValueTypeAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n1855#2,2:70\n*S KotlinDebug\n*F\n+ 1 DataBinderValueTypeAdapter.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderValueTypeAdapter\n*L\n31#1:70,2\n*E\n"})
public final class DataBinderValueTypeAdapter extends TypeAdapter<DataBinderValue<?>> {
    @Nullable
    public DataBinderValue<?> read(@NotNull JsonReader jsonReader) {
        DataBinderValue<?> dataBinderValue;
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        jsonReader.beginArray();
        try {
            byte nextInt = (byte) jsonReader.nextInt();
            if (nextInt == 2) {
                dataBinderValue = new DataBinderValue.Boolean(jsonReader.nextBoolean());
            } else if (nextInt == 3) {
                dataBinderValue = new DataBinderValue.Integer(jsonReader.nextInt());
            } else if (nextInt == 4) {
                dataBinderValue = new DataBinderValue.Long(jsonReader.nextLong());
            } else if (nextInt == 5) {
                dataBinderValue = new DataBinderValue.Float((float) jsonReader.nextDouble());
            } else if (nextInt == 6) {
                String nextString = jsonReader.nextString();
                Intrinsics.checkNotNullExpressionValue(nextString, "nextString(...)");
                dataBinderValue = new DataBinderValue.String(nextString);
            } else if (nextInt == 7) {
                int nextInt2 = jsonReader.nextInt();
                ArrayList arrayList = new ArrayList(nextInt2);
                for (int i = 0; i < nextInt2; i++) {
                    arrayList.add(read(jsonReader));
                }
                dataBinderValue = new DataBinderValue.Batch((List<? extends DataBinderValue<?>>) arrayList);
            } else {
                dataBinderValue = new DataBinderValue.Null();
            }
            jsonReader.endArray();
            return dataBinderValue;
        } catch (Throwable th) {
            throw new IOException("DataBinderValue deserialization failed!", th);
        }
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        if (dataBinderValue == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        jsonWriter.value((Number) Byte.valueOf(dataBinderValue.getType()));
        if (!(dataBinderValue instanceof DataBinderValue.Null)) {
            if (dataBinderValue instanceof DataBinderValue.Boolean) {
                jsonWriter.value(((Boolean) ((DataBinderValue.Boolean) dataBinderValue).getValue()).booleanValue());
            } else if (dataBinderValue instanceof DataBinderValue.Integer) {
                jsonWriter.value((Number) ((DataBinderValue.Integer) dataBinderValue).getValue());
            } else if (dataBinderValue instanceof DataBinderValue.Long) {
                jsonWriter.value(((Number) ((DataBinderValue.Long) dataBinderValue).getValue()).longValue());
            } else if (dataBinderValue instanceof DataBinderValue.Float) {
                jsonWriter.value(((Number) ((DataBinderValue.Float) dataBinderValue).getValue()).floatValue());
            } else if (dataBinderValue instanceof DataBinderValue.String) {
                jsonWriter.value((String) ((DataBinderValue.String) dataBinderValue).getValue());
            } else if (dataBinderValue instanceof DataBinderValue.Batch) {
                DataBinderValue.Batch batch = (DataBinderValue.Batch) dataBinderValue;
                jsonWriter.value((Number) Integer.valueOf(((List) batch.getValue()).size()));
                for (DataBinderValue write : (Iterable) batch.getValue()) {
                    write(jsonWriter, (DataBinderValue<?>) write);
                }
            }
        }
        jsonWriter.endArray();
    }
}
