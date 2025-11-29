package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Set;

public class ThrowableDeserializer extends BeanDeserializer {
    protected static final String PROP_NAME_MESSAGE = "message";
    private static final long serialVersionUID = 1;

    public ThrowableDeserializer(BeanDeserializer beanDeserializer) {
        super(beanDeserializer);
        this._vanillaProcessing = false;
    }

    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingPropertyBased(jsonParser, deserializationContext);
        }
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(deserializationContext, jsonDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (this._beanType.isAbstract()) {
            return deserializationContext.handleMissingInstantiator(handledType(), getValueInstantiator(), jsonParser, "abstract type (need to add/enable type information?)", new Object[0]);
        }
        boolean canCreateFromString = this._valueInstantiator.canCreateFromString();
        boolean canCreateUsingDefault = this._valueInstantiator.canCreateUsingDefault();
        if (canCreateFromString || canCreateUsingDefault) {
            int i = 0;
            Object obj = null;
            Object[] objArr = null;
            while (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                String currentName = jsonParser.getCurrentName();
                SettableBeanProperty find = this._beanProperties.find(currentName);
                jsonParser.nextToken();
                if (find != null) {
                    if (obj != null) {
                        find.deserializeAndSet(jsonParser, deserializationContext, obj);
                    } else {
                        if (objArr == null) {
                            int size = this._beanProperties.size();
                            objArr = new Object[(size + size)];
                        }
                        int i2 = i + 1;
                        objArr[i] = find;
                        i += 2;
                        objArr[i2] = find.deserialize(jsonParser, deserializationContext);
                    }
                } else if (!"message".equals(currentName) || !canCreateFromString) {
                    Set<String> set = this._ignorableProps;
                    if (set == null || !set.contains(currentName)) {
                        SettableAnyProperty settableAnyProperty = this._anySetter;
                        if (settableAnyProperty != null) {
                            settableAnyProperty.deserializeAndSet(jsonParser, deserializationContext, obj, currentName);
                        } else {
                            handleUnknownProperty(jsonParser, deserializationContext, obj, currentName);
                        }
                    } else {
                        jsonParser.skipChildren();
                    }
                } else {
                    obj = this._valueInstantiator.createFromString(deserializationContext, jsonParser.getValueAsString());
                    if (objArr != null) {
                        for (int i3 = 0; i3 < i; i3 += 2) {
                            ((SettableBeanProperty) objArr[i3]).set(obj, objArr[i3 + 1]);
                        }
                        objArr = null;
                    }
                }
                jsonParser.nextToken();
            }
            if (obj == null) {
                obj = canCreateFromString ? this._valueInstantiator.createFromString(deserializationContext, (String) null) : this._valueInstantiator.createUsingDefault(deserializationContext);
                if (objArr != null) {
                    for (int i4 = 0; i4 < i; i4 += 2) {
                        ((SettableBeanProperty) objArr[i4]).set(obj, objArr[i4 + 1]);
                    }
                }
            }
            return obj;
        }
        return deserializationContext.handleMissingInstantiator(handledType(), getValueInstantiator(), jsonParser, "Throwable needs a default contructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
    }

    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer nameTransformer) {
        return getClass() != ThrowableDeserializer.class ? this : new ThrowableDeserializer(this, nameTransformer);
    }

    public ThrowableDeserializer(BeanDeserializer beanDeserializer, NameTransformer nameTransformer) {
        super((BeanDeserializerBase) beanDeserializer, nameTransformer);
    }
}
