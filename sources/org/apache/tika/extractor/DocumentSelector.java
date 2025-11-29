package org.apache.tika.extractor;

import org.apache.tika.metadata.Metadata;

public interface DocumentSelector {
    boolean a(Metadata metadata);
}
