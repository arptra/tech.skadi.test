package com.upuphone.runasone.channel.proxy.server.socks;

import android.util.LruCache;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.server.base.UDPHelper;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.AttributeKey;
import java.net.InetSocketAddress;

public class SocksProxyUDPHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    private static final String TAG = "SocksProxyUDPHandler";
    public static final AttributeKey<UDPHelper.DestAddress> address = AttributeKey.valueOf(MzContactsContract.MzContactColumns.ADDRESS);
    /* access modifiers changed from: private */
    public static LruCache<Integer, Channel> mCacheChannel = new LruCache<Integer, Channel>(100) {
        public void entryRemoved(boolean z, Integer num, Channel channel, Channel channel2) {
            if ((channel2 == null || channel2 != channel) && channel != null) {
                channel.close();
            }
        }
    };
    public static final AttributeKey<InetSocketAddress> sender = AttributeKey.valueOf("sender");
    private EventLoopGroup proxyBossGroup = new NioEventLoopGroup();

    public static void clear() {
        mCacheChannel.evictAll();
    }

    /* access modifiers changed from: private */
    public int createKey(InetSocketAddress inetSocketAddress, UDPHelper.DestAddress destAddress) {
        String str = inetSocketAddress.getAddress().getHostAddress() + AccountConstantKt.CODE_SEPARTOR + inetSocketAddress.getPort() + "->" + destAddress.toString();
        int hashCode = str.hashCode();
        DebugLog.i("%s: createKey key=%d, seqStr=%s", TAG, Integer.valueOf(hashCode), str);
        return hashCode;
    }

    /* access modifiers changed from: private */
    public String getLog(InetSocketAddress inetSocketAddress, UDPHelper.DestAddress destAddress) {
        return inetSocketAddress.getAddress().getHostAddress() + AccountConstantKt.CODE_SEPARTOR + inetSocketAddress.getPort() + "->" + destAddress.toString();
    }

    public void channelRead0(final ChannelHandlerContext channelHandlerContext, final DatagramPacket datagramPacket) {
        final InetSocketAddress inetSocketAddress = (InetSocketAddress) datagramPacket.sender();
        final UDPHelper.DestAddress parseData = UDPHelper.parseData((ByteBuf) datagramPacket.content());
        int createKey = createKey(inetSocketAddress, parseData);
        DebugLog.d(" %s channelRead0 key = %d", TAG, Integer.valueOf(createKey));
        Channel channel = mCacheChannel.get(Integer.valueOf(createKey));
        if (channel != null) {
            try {
                if (channel.isActive()) {
                    DebugLog.d("%s: send length=%d key=%d remoteChannel=%s", TAG, Integer.valueOf(((ByteBuf) datagramPacket.content()).readableBytes()), Integer.valueOf(createKey), channel.toString());
                    channel.writeAndFlush(new DatagramPacket((ByteBuf) datagramPacket.retain().content(), parseData.getInetSocketAddress()));
                    return;
                }
            } catch (Exception e) {
                DebugLog.e("%s: error=%s", TAG, e);
                return;
            }
        }
        ((Bootstrap) ((Bootstrap) ((Bootstrap) new Bootstrap().group(this.proxyBossGroup)).channel(NioDatagramChannel.class)).handler(new ChannelInitializer<Channel>() {
            public void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast(new SimpleChannelInboundHandler<DatagramPacket>() {
                    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
                        InetSocketAddress inetSocketAddress = channelHandlerContext.channel().attr(SocksProxyUDPHandler.sender).get();
                        UDPHelper.DestAddress destAddress = channelHandlerContext.channel().attr(SocksProxyUDPHandler.address).get();
                        int access$000 = SocksProxyUDPHandler.this.createKey(inetSocketAddress, destAddress);
                        DebugLog.e("%s: channelInactive key= %d(%s) ", SocksProxyUDPHandler.TAG, Integer.valueOf(access$000), SocksProxyUDPHandler.this.getLog(inetSocketAddress, destAddress));
                        SocksProxyUDPHandler.mCacheChannel.remove(Integer.valueOf(access$000));
                    }

                    public void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
                        DebugLog.d("%s: rec length= %d", SocksProxyUDPHandler.TAG, Integer.valueOf(((ByteBuf) datagramPacket.content()).readableBytes()));
                        InetSocketAddress inetSocketAddress = channelHandlerContext.channel().attr(SocksProxyUDPHandler.sender).get();
                        UDPHelper.DestAddress destAddress = channelHandlerContext.channel().attr(SocksProxyUDPHandler.address).get();
                        DebugLog.d("%s: send  %s", SocksProxyUDPHandler.TAG, SocksProxyUDPHandler.this.getLog(inetSocketAddress, destAddress));
                        channelHandlerContext.writeAndFlush(new DatagramPacket(UDPHelper.wrapData(datagramPacket.retain(), destAddress), inetSocketAddress));
                    }
                });
            }
        })).bind(0).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    channelFuture.channel().attr(SocksProxyUDPHandler.sender).set(inetSocketAddress);
                    channelFuture.channel().attr(SocksProxyUDPHandler.address).set(parseData);
                    SocksProxyUDPHandler.mCacheChannel.put(Integer.valueOf(SocksProxyUDPHandler.this.createKey(inetSocketAddress, parseData)), channelFuture.channel());
                    channelFuture.channel().writeAndFlush(new DatagramPacket((ByteBuf) datagramPacket.content(), parseData.getInetSocketAddress()));
                }
            }
        }).syncUninterruptibly().channel();
        DebugLog.d("%s: create finish", TAG);
        datagramPacket.retain();
    }
}
