package retrofit2.converter.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

final class FastJsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private SerializeConfig serializeConfig;
    private SerializerFeature[] serializerFeatures;

    public FastJsonRequestBodyConverter(SerializeConfig serializeConfig2, SerializerFeature... serializerFeatureArr) {
        this.serializeConfig = serializeConfig2;
        this.serializerFeatures = serializerFeatureArr;
    }

    public RequestBody convert(T t) throws IOException {
        byte[] bArr;
        SerializeConfig serializeConfig2 = this.serializeConfig;
        if (serializeConfig2 != null) {
            SerializerFeature[] serializerFeatureArr = this.serializerFeatures;
            if (serializerFeatureArr != null) {
                bArr = JSON.toJSONBytes((Object) t, serializeConfig2, serializerFeatureArr);
            } else {
                bArr = JSON.toJSONBytes((Object) t, serializeConfig2, new SerializerFeature[0]);
            }
        } else {
            SerializerFeature[] serializerFeatureArr2 = this.serializerFeatures;
            if (serializerFeatureArr2 != null) {
                bArr = JSON.toJSONBytes(t, serializerFeatureArr2);
            } else {
                bArr = JSON.toJSONBytes(t, new SerializerFeature[0]);
            }
        }
        return RequestBody.create(MEDIA_TYPE, bArr);
    }
}
