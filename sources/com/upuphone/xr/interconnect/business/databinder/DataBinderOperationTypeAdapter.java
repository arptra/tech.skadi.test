package com.upuphone.xr.interconnect.business.databinder;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.upuphone.xr.interconnect.business.databinder.DataBinderOperation;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperationTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation;", "()V", "valueTypeAdapter", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderValueTypeAdapter;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DataBinderOperationTypeAdapter extends TypeAdapter<DataBinderOperation> {
    @NotNull
    private final DataBinderValueTypeAdapter valueTypeAdapter = new DataBinderValueTypeAdapter();

    @Nullable
    public DataBinderOperation read(@NotNull JsonReader jsonReader) {
        DataBinderOperation dataBinderOperation;
        Intrinsics.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        jsonReader.beginArray();
        try {
            byte nextInt = (byte) jsonReader.nextInt();
            if (nextInt == 2) {
                String nextString = jsonReader.nextString();
                Intrinsics.checkNotNullExpressionValue(nextString, "nextString(...)");
                dataBinderOperation = new DataBinderOperation.Delete(nextString);
            } else if (nextInt == 1) {
                String nextString2 = jsonReader.nextString();
                Intrinsics.checkNotNullExpressionValue(nextString2, "nextString(...)");
                DataBinderValue<?> read = this.valueTypeAdapter.read(jsonReader);
                Intrinsics.checkNotNull(read);
                dataBinderOperation = new DataBinderOperation.Update(nextString2, read);
            } else {
                throw new IOException("DataBinderOperation unknown type " + nextInt + "!");
            }
            jsonReader.endArray();
            return dataBinderOperation;
        } catch (Throwable th) {
            throw new IOException("DataBinderOperation deserialization failed!", th);
        }
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable DataBinderOperation dataBinderOperation) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        if (dataBinderOperation == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        if (dataBinderOperation instanceof DataBinderOperation.Delete) {
            jsonWriter.value((Number) (byte) 2);
            jsonWriter.value(((DataBinderOperation.Delete) dataBinderOperation).getName());
        } else if (dataBinderOperation instanceof DataBinderOperation.Update) {
            jsonWriter.value((Number) (byte) 1);
            DataBinderOperation.Update update = (DataBinderOperation.Update) dataBinderOperation;
            jsonWriter.value(update.getName());
            this.valueTypeAdapter.write(jsonWriter, update.getValue());
        }
        jsonWriter.endArray();
    }
}
