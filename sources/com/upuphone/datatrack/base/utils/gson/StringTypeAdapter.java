package com.upuphone.datatrack.base.utils.gson;

import android.util.Log;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class StringTypeAdapter extends TypeAdapter<String> {
    public String read(JsonReader jsonReader) {
        try {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return "";
            }
        } catch (Exception e) {
            Log.e("StringTypeAdapter", "read exception:" + e);
        }
        return jsonReader.nextString();
    }

    public void write(JsonWriter jsonWriter, String str) {
        if (str == null) {
            str = "";
        }
        try {
            jsonWriter.value(str);
        } catch (Exception e) {
            Log.e("StringTypeAdapter", "write exception:" + e);
        }
    }
}
