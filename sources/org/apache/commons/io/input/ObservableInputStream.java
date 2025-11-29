package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.IOUtils;

public class ObservableInputStream extends ProxyInputStream {
    private final List<Observer> observers;

    public static abstract class Observer {
        public void closed() throws IOException {
        }

        public void data(int i) throws IOException {
        }

        public void error(IOException iOException) throws IOException {
            throw iOException;
        }

        public void finished() throws IOException {
        }

        public void data(byte[] bArr, int i, int i2) throws IOException {
        }
    }

    public ObservableInputStream(InputStream inputStream) {
        this(inputStream, (List<Observer>) new ArrayList());
    }

    private void notify(byte[] bArr, int i, int i2, IOException iOException) throws IOException {
        if (iOException != null) {
            noteError(iOException);
            throw iOException;
        } else if (i2 == -1) {
            noteFinished();
        } else if (i2 > 0) {
            noteDataBytes(bArr, i, i2);
        }
    }

    public void add(Observer observer) {
        this.observers.add(observer);
    }

    public void close() throws IOException {
        try {
            super.close();
            e = null;
        } catch (IOException e) {
            e = e;
        }
        if (e == null) {
            noteClosed();
        } else {
            noteError(e);
        }
    }

    public void consume() throws IOException {
        do {
        } while (read(IOUtils.byteArray()) != -1);
    }

    public List<Observer> getObservers() {
        return this.observers;
    }

    public void noteClosed() throws IOException {
        for (Observer closed : getObservers()) {
            closed.closed();
        }
    }

    public void noteDataByte(int i) throws IOException {
        for (Observer data : getObservers()) {
            data.data(i);
        }
    }

    public void noteDataBytes(byte[] bArr, int i, int i2) throws IOException {
        for (Observer data : getObservers()) {
            data.data(bArr, i, i2);
        }
    }

    public void noteError(IOException iOException) throws IOException {
        for (Observer error : getObservers()) {
            error.error(iOException);
        }
    }

    public void noteFinished() throws IOException {
        for (Observer finished : getObservers()) {
            finished.finished();
        }
    }

    public int read() throws IOException {
        int i;
        try {
            i = super.read();
            e = null;
        } catch (IOException e) {
            e = e;
            i = 0;
        }
        if (e == null) {
            if (i == -1) {
                noteFinished();
            } else {
                noteDataByte(i);
            }
            return i;
        }
        noteError(e);
        throw e;
    }

    public void remove(Observer observer) {
        this.observers.remove(observer);
    }

    public void removeAllObservers() {
        this.observers.clear();
    }

    private ObservableInputStream(InputStream inputStream, List<Observer> list) {
        super(inputStream);
        this.observers = list;
    }

    public ObservableInputStream(InputStream inputStream, Observer... observerArr) {
        this(inputStream, (List<Observer>) Arrays.asList(observerArr));
    }

    public int read(byte[] bArr) throws IOException {
        int i;
        try {
            i = super.read(bArr);
            e = null;
        } catch (IOException e) {
            e = e;
            i = 0;
        }
        notify(bArr, 0, i, e);
        return i;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        try {
            i3 = super.read(bArr, i, i2);
            e = null;
        } catch (IOException e) {
            e = e;
            i3 = 0;
        }
        notify(bArr, i, i3, e);
        return i3;
    }
}
