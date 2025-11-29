package org.apache.commons.io.output;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.IOExceptionList;
import org.apache.commons.io.IOIndexedException;

public class FilterCollectionWriter extends Writer {
    protected final Collection<Writer> EMPTY_WRITERS;
    protected final Collection<Writer> writers;

    public FilterCollectionWriter(Collection<Writer> collection) {
        List emptyList = Collections.emptyList();
        this.EMPTY_WRITERS = emptyList;
        this.writers = collection == null ? emptyList : collection;
    }

    private List<Exception> add(List<Exception> list, int i, IOException iOException) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new IOIndexedException(i, iOException));
        return list;
    }

    private boolean notEmpty(List<Exception> list) {
        return list != null && !list.isEmpty();
    }

    public void close() throws IOException {
        List<Exception> list = null;
        int i = 0;
        for (Writer next : this.writers) {
            if (next != null) {
                try {
                    next.close();
                } catch (IOException e) {
                    list = add(list, i, e);
                }
            }
            i++;
        }
        if (notEmpty(list)) {
            throw new IOExceptionList("close", list);
        }
    }

    public void flush() throws IOException {
        List<Exception> list = null;
        int i = 0;
        for (Writer next : this.writers) {
            if (next != null) {
                try {
                    next.flush();
                } catch (IOException e) {
                    list = add(list, i, e);
                }
            }
            i++;
        }
        if (notEmpty(list)) {
            throw new IOExceptionList("flush", list);
        }
    }

    public void write(char[] cArr) throws IOException {
        List<Exception> list = null;
        int i = 0;
        for (Writer next : this.writers) {
            if (next != null) {
                try {
                    next.write(cArr);
                } catch (IOException e) {
                    list = add(list, i, e);
                }
            }
            i++;
        }
        if (notEmpty(list)) {
            throw new IOExceptionList("write", list);
        }
    }

    public FilterCollectionWriter(Writer... writerArr) {
        List emptyList = Collections.emptyList();
        this.EMPTY_WRITERS = emptyList;
        this.writers = writerArr != null ? Arrays.asList(writerArr) : emptyList;
    }

    public Writer append(char c) throws IOException {
        List<Exception> list = null;
        int i = 0;
        for (Writer next : this.writers) {
            if (next != null) {
                try {
                    next.append(c);
                } catch (IOException e) {
                    list = add(list, i, e);
                }
            }
            i++;
        }
        if (!notEmpty(list)) {
            return this;
        }
        throw new IOExceptionList(RtspHeaders.Values.APPEND, list);
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        List<Exception> list = null;
        int i3 = 0;
        for (Writer next : this.writers) {
            if (next != null) {
                try {
                    next.write(cArr, i, i2);
                } catch (IOException e) {
                    list = add(list, i3, e);
                }
            }
            i3++;
        }
        if (notEmpty(list)) {
            throw new IOExceptionList("write", list);
        }
    }

    public Writer append(CharSequence charSequence) throws IOException {
        List<Exception> list = null;
        int i = 0;
        for (Writer next : this.writers) {
            if (next != null) {
                try {
                    next.append(charSequence);
                } catch (IOException e) {
                    list = add(list, i, e);
                }
            }
            i++;
        }
        if (!notEmpty(list)) {
            return this;
        }
        throw new IOExceptionList(RtspHeaders.Values.APPEND, list);
    }

    public void write(int i) throws IOException {
        List<Exception> list = null;
        int i2 = 0;
        for (Writer next : this.writers) {
            if (next != null) {
                try {
                    next.write(i);
                } catch (IOException e) {
                    list = add(list, i2, e);
                }
            }
            i2++;
        }
        if (notEmpty(list)) {
            throw new IOExceptionList("write", list);
        }
    }

    public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
        List<Exception> list = null;
        int i3 = 0;
        for (Writer next : this.writers) {
            if (next != null) {
                try {
                    next.append(charSequence, i, i2);
                } catch (IOException e) {
                    list = add(list, i3, e);
                }
            }
            i3++;
        }
        if (!notEmpty(list)) {
            return this;
        }
        throw new IOExceptionList(RtspHeaders.Values.APPEND, list);
    }

    public void write(String str) throws IOException {
        List<Exception> list = null;
        int i = 0;
        for (Writer next : this.writers) {
            if (next != null) {
                try {
                    next.write(str);
                } catch (IOException e) {
                    list = add(list, i, e);
                }
            }
            i++;
        }
        if (notEmpty(list)) {
            throw new IOExceptionList("write", list);
        }
    }

    public void write(String str, int i, int i2) throws IOException {
        List<Exception> list = null;
        int i3 = 0;
        for (Writer next : this.writers) {
            if (next != null) {
                try {
                    next.write(str, i, i2);
                } catch (IOException e) {
                    list = add(list, i3, e);
                }
            }
            i3++;
        }
        if (notEmpty(list)) {
            throw new IOExceptionList("write", list);
        }
    }
}
