package retrofit2.converter.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;

final class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final Feature[] EMPTY_SERIALIZER_FEATURES = new Feature[0];
    private ParserConfig config;
    private int featureValues;
    private Feature[] features;
    private Type mType;

    public FastJsonResponseBodyConverter(Type type, ParserConfig parserConfig, int i, Feature... featureArr) {
        this.mType = type;
        this.config = parserConfig;
        this.featureValues = i;
        this.features = featureArr;
    }

    public T convert(ResponseBody responseBody) throws IOException {
        try {
            String string = responseBody.string();
            Type type = this.mType;
            ParserConfig parserConfig = this.config;
            int i = this.featureValues;
            Feature[] featureArr = this.features;
            if (featureArr == null) {
                featureArr = EMPTY_SERIALIZER_FEATURES;
            }
            return JSON.parseObject(string, type, parserConfig, i, featureArr);
        } finally {
            responseBody.close();
        }
    }
}
