package com.google.crypto.tink.shaded.protobuf;

final class ExtensionSchemas {
    private static final ExtensionSchema<?> FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final ExtensionSchema<?> LITE_SCHEMA = new ExtensionSchemaLite();

    public static ExtensionSchema<?> full() {
        ExtensionSchema<?> extensionSchema = FULL_SCHEMA;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static ExtensionSchema<?> lite() {
        return LITE_SCHEMA;
    }

    private static ExtensionSchema<?> loadSchemaForFullRuntime() {
        Class<ExtensionSchemaFull> cls = ExtensionSchemaFull.class;
        try {
            int i = ExtensionSchemaFull.f9704a;
            return cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
