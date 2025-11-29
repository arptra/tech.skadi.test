package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class WindowsLineEndingInputStream extends InputStream {
    private final boolean ensureLineFeedAtEndOfFile;
    private boolean eofSeen;
    private boolean injectSlashN;
    private boolean slashNSeen;
    private boolean slashRSeen;
    private final InputStream target;

    public WindowsLineEndingInputStream(InputStream inputStream, boolean z) {
        this.target = inputStream;
        this.ensureLineFeedAtEndOfFile = z;
    }

    private int eofGame() {
        if (!this.ensureLineFeedAtEndOfFile) {
            return -1;
        }
        boolean z = this.slashNSeen;
        if (!z && !this.slashRSeen) {
            this.slashRSeen = true;
            return 13;
        } else if (z) {
            return -1;
        } else {
            this.slashRSeen = false;
            this.slashNSeen = true;
            return 10;
        }
    }

    private int readWithUpdate() throws IOException {
        int read = this.target.read();
        boolean z = false;
        boolean z2 = read == -1;
        this.eofSeen = z2;
        if (z2) {
            return read;
        }
        this.slashRSeen = read == 13;
        if (read == 10) {
            z = true;
        }
        this.slashNSeen = z;
        return read;
    }

    public void close() throws IOException {
        super.close();
        this.target.close();
    }

    public synchronized void mark(int i) {
        throw UnsupportedOperationExceptions.mark();
    }

    public int read() throws IOException {
        if (this.eofSeen) {
            return eofGame();
        }
        if (this.injectSlashN) {
            this.injectSlashN = false;
            return 10;
        }
        boolean z = this.slashRSeen;
        int readWithUpdate = readWithUpdate();
        if (this.eofSeen) {
            return eofGame();
        }
        if (readWithUpdate != 10 || z) {
            return readWithUpdate;
        }
        this.injectSlashN = true;
        return 13;
    }
}
