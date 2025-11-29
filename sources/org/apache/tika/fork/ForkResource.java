package org.apache.tika.fork;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public interface ForkResource {
    Throwable a(DataInputStream dataInputStream, DataOutputStream dataOutputStream);
}
