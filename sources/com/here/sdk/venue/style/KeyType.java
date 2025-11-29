package com.here.sdk.venue.style;

enum KeyType {
    CUSTOM_NAME(0),
    OCCUPANT_NAMES(1),
    SPACE_NAME(2),
    INTERNAL_ADDRESS_SHORT(3),
    INTERNAL_ADDRESS(4),
    INTERNAL_ADDRESS_LONG(5),
    SPACE_TYPE_NAME(6),
    SPACE_CATEGORY_NAME(7),
    NONE(8);
    
    final int value;

    private KeyType(int i) {
        this.value = i;
    }
}
