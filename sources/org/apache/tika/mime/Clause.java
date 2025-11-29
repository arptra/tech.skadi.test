package org.apache.tika.mime;

import java.io.Serializable;

interface Clause extends Serializable {
    boolean eval(byte[] bArr);

    int size();
}
