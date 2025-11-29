package zmq.io.net;

import java.nio.channels.spi.SelectorProvider;
import zmq.Options;
import zmq.io.net.Address;

public interface SelectorProviderChooser {
    SelectorProvider a(Address.IZAddress iZAddress, Options options);
}
