package io.netty.channel.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

final class SelectedSelectionKeySetSelector extends Selector {
    private final Selector delegate;
    private final SelectedSelectionKeySet selectionKeys;

    public SelectedSelectionKeySetSelector(Selector selector, SelectedSelectionKeySet selectedSelectionKeySet) {
        this.delegate = selector;
        this.selectionKeys = selectedSelectionKeySet;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    public Set<SelectionKey> keys() {
        return this.delegate.keys();
    }

    public SelectorProvider provider() {
        return this.delegate.provider();
    }

    public int select(long j) throws IOException {
        this.selectionKeys.reset();
        return this.delegate.select(j);
    }

    public int selectNow() throws IOException {
        this.selectionKeys.reset();
        return this.delegate.selectNow();
    }

    public Set<SelectionKey> selectedKeys() {
        return this.delegate.selectedKeys();
    }

    public Selector wakeup() {
        return this.delegate.wakeup();
    }

    public int select() throws IOException {
        this.selectionKeys.reset();
        return this.delegate.select();
    }
}
