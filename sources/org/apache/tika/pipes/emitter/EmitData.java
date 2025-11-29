package org.apache.tika.pipes.emitter;

import java.io.Serializable;
import java.util.List;
import org.apache.tika.metadata.Metadata;

public class EmitData implements Serializable {
    private static final long serialVersionUID = -3861669115439125268L;
    private final String containerStackTrace;
    private final EmitKey emitKey;
    private final List<Metadata> metadataList;

    public EmitData(EmitKey emitKey2, List<Metadata> list) {
        this(emitKey2, list, "");
    }

    private static long estimateSizeInBytes(String str, List<Metadata> list, String str2) {
        long length = ((long) ((str.length() * 2) + 36)) + ((long) ((str2.length() * 2) + 36));
        for (Metadata next : list) {
            for (String str3 : next.names()) {
                length += (long) ((str3.length() * 2) + 36);
                for (String length2 : next.getValues(str3)) {
                    length += (long) ((length2.length() * 2) + 36);
                }
            }
        }
        return length;
    }

    public String getContainerStackTrace() {
        return this.containerStackTrace;
    }

    public EmitKey getEmitKey() {
        return this.emitKey;
    }

    public long getEstimatedSizeBytes() {
        return estimateSizeInBytes(getEmitKey().getEmitKey(), getMetadataList(), this.containerStackTrace);
    }

    public List<Metadata> getMetadataList() {
        return this.metadataList;
    }

    public String toString() {
        return "EmitData{emitKey=" + this.emitKey + ", metadataList=" + this.metadataList + ", containerStackTrace='" + this.containerStackTrace + '\'' + '}';
    }

    public EmitData(EmitKey emitKey2, List<Metadata> list, String str) {
        this.emitKey = emitKey2;
        this.metadataList = list;
        this.containerStackTrace = str == null ? "" : str;
    }
}
