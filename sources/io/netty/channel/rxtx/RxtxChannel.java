package io.netty.channel.rxtx;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.oio.OioByteStreamChannel;
import io.netty.channel.rxtx.RxtxChannelConfig;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

@Deprecated
public class RxtxChannel extends OioByteStreamChannel {
    private static final RxtxDeviceAddress LOCAL_ADDRESS = new RxtxDeviceAddress("localhost");
    private final RxtxChannelConfig config = new DefaultRxtxChannelConfig(this);
    private RxtxDeviceAddress deviceAddress;
    private boolean open = true;
    private SerialPort serialPort;

    public final class RxtxUnsafe extends AbstractChannel.AbstractUnsafe {
        private RxtxUnsafe() {
            super();
        }

        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, final ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    final boolean isActive = RxtxChannel.this.isActive();
                    RxtxChannel.this.doConnect(socketAddress, socketAddress2);
                    int intValue = ((Integer) RxtxChannel.this.config().getOption(RxtxChannelOption.WAIT_TIME)).intValue();
                    if (intValue > 0) {
                        RxtxChannel.this.eventLoop().schedule((Runnable) new Runnable() {
                            public void run() {
                                try {
                                    RxtxChannel.this.doInit();
                                    RxtxUnsafe.this.safeSetSuccess(channelPromise);
                                    if (!isActive && RxtxChannel.this.isActive()) {
                                        RxtxChannel.this.pipeline().fireChannelActive();
                                    }
                                } catch (Throwable th) {
                                    RxtxUnsafe.this.safeSetFailure(channelPromise, th);
                                    RxtxUnsafe.this.closeIfClosed();
                                }
                            }
                        }, (long) intValue, TimeUnit.MILLISECONDS);
                        return;
                    }
                    RxtxChannel.this.doInit();
                    safeSetSuccess(channelPromise);
                    if (!isActive && RxtxChannel.this.isActive()) {
                        RxtxChannel.this.pipeline().fireChannelActive();
                    }
                } catch (Throwable th) {
                    safeSetFailure(channelPromise, th);
                    closeIfClosed();
                }
            }
        }
    }

    public RxtxChannel() {
        super((Channel) null);
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: finally extract failed */
    public void doClose() throws Exception {
        this.open = false;
        try {
            super.doClose();
            SerialPort serialPort2 = this.serialPort;
            if (serialPort2 != null) {
                serialPort2.removeEventListener();
                this.serialPort.close();
                this.serialPort = null;
            }
        } catch (Throwable th) {
            if (this.serialPort != null) {
                this.serialPort.removeEventListener();
                this.serialPort.close();
                this.serialPort = null;
            }
            throw th;
        }
    }

    public void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        RxtxDeviceAddress rxtxDeviceAddress = (RxtxDeviceAddress) socketAddress;
        SerialPort open2 = CommPortIdentifier.getPortIdentifier(rxtxDeviceAddress.value()).open(getClass().getName(), 1000);
        open2.enableReceiveTimeout(((Integer) config().getOption(RxtxChannelOption.READ_TIMEOUT)).intValue());
        this.deviceAddress = rxtxDeviceAddress;
        this.serialPort = open2;
    }

    public void doDisconnect() throws Exception {
        doClose();
    }

    public void doInit() throws Exception {
        this.serialPort.setSerialPortParams(((Integer) config().getOption(RxtxChannelOption.BAUD_RATE)).intValue(), ((RxtxChannelConfig.Databits) config().getOption(RxtxChannelOption.DATA_BITS)).value(), ((RxtxChannelConfig.Stopbits) config().getOption(RxtxChannelOption.STOP_BITS)).value(), ((RxtxChannelConfig.Paritybit) config().getOption(RxtxChannelOption.PARITY_BIT)).value());
        this.serialPort.setDTR(((Boolean) config().getOption(RxtxChannelOption.DTR)).booleanValue());
        this.serialPort.setRTS(((Boolean) config().getOption(RxtxChannelOption.RTS)).booleanValue());
        activate(this.serialPort.getInputStream(), this.serialPort.getOutputStream());
    }

    public boolean isInputShutdown() {
        return !this.open;
    }

    public boolean isOpen() {
        return this.open;
    }

    public AbstractChannel.AbstractUnsafe newUnsafe() {
        return new RxtxUnsafe();
    }

    public ChannelFuture shutdownInput() {
        return newFailedFuture(new UnsupportedOperationException("shutdownInput"));
    }

    public RxtxChannelConfig config() {
        return this.config;
    }

    public RxtxDeviceAddress localAddress() {
        return (RxtxDeviceAddress) super.localAddress();
    }

    public RxtxDeviceAddress localAddress0() {
        return LOCAL_ADDRESS;
    }

    public RxtxDeviceAddress remoteAddress() {
        return (RxtxDeviceAddress) super.remoteAddress();
    }

    public RxtxDeviceAddress remoteAddress0() {
        return this.deviceAddress;
    }
}
