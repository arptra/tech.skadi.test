package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.here.posclient.PositionEstimate;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.Objects;

public final class SoundFile {
    private static final String TAG = "SoundFile";
    private int mAvgBitRate;
    private int mChannels;
    private ByteBuffer mDecodedBytes;
    private ShortBuffer mDecodedSamples;
    private long mDuration = 0;
    private int mFileSize;
    private int[] mFrameGains;
    private int[] mFrameLens;
    private int[] mFrameOffsets;
    private long[] mFramesTimes;
    private File mInputFile = null;
    private int mNumFrames;
    private int mNumSamples;
    private int mSampleRate;

    private SoundFile() {
    }

    public static SoundFile create(String str, int i) throws Exception {
        File file = new File(str);
        if (file.exists()) {
            String[] split = file.getName().toLowerCase().split("\\.");
            if (split.length < 2 || !Arrays.asList(getSupportedExtensions()).contains(split[split.length - 1])) {
                return null;
            }
            SoundFile soundFile = new SoundFile();
            soundFile.readFile(file, i);
            return soundFile;
        }
        throw new FileNotFoundException(str);
    }

    private static String[] getSupportedExtensions() {
        return new String[]{"mp3", "wav", "3gpp", "3gp", "amr", "aac", "m4a", "ogg"};
    }

    private void readFile(File file, int i) throws Exception {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        ByteBuffer[] byteBufferArr;
        int i8;
        byte[] bArr;
        int i9;
        ByteBuffer byteBuffer;
        this.mFramesTimes = new long[(i + 2)];
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.mInputFile = file;
        this.mFileSize = (int) file.length();
        mediaExtractor.setDataSource(this.mInputFile.getPath());
        int trackCount = mediaExtractor.getTrackCount();
        int i10 = 0;
        MediaFormat mediaFormat = null;
        int i11 = 0;
        while (true) {
            if (i11 >= trackCount) {
                str = null;
                break;
            }
            mediaFormat = mediaExtractor.getTrackFormat(i11);
            if (mediaFormat.getString("mime").startsWith("audio/")) {
                mediaExtractor.selectTrack(i11);
                str = "";
                break;
            }
            i11++;
        }
        Objects.requireNonNull(str, "No audio track found in " + this.mInputFile);
        this.mChannels = mediaFormat.getInteger("channel-count");
        this.mSampleRate = mediaFormat.getInteger("sample-rate");
        long j = mediaFormat.getLong("durationUs");
        this.mDuration = j;
        int i12 = (int) (((((float) j) / 1000000.0f) * ((float) this.mSampleRate)) + 0.5f);
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
        createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        createDecoderByType.start();
        ByteBuffer[] inputBuffers = createDecoderByType.getInputBuffers();
        ByteBuffer[] outputBuffers = createDecoderByType.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        this.mDecodedBytes = ByteBuffer.allocate(PositionEstimate.Value.SITUATION);
        int i13 = this.mFileSize / i;
        byte[] bArr2 = null;
        int i14 = 0;
        int i15 = 0;
        boolean z = false;
        int i16 = 0;
        ByteBuffer[] byteBufferArr2 = outputBuffers;
        while (true) {
            int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(100);
            if (z || dequeueInputBuffer < 0) {
                i2 = i14;
                i3 = i15;
                i4 = i16;
            } else {
                int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i10);
                if (readSampleData < 0) {
                    i2 = i14;
                    createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, -1, 4);
                    i3 = i15;
                    i4 = i16;
                    z = true;
                } else {
                    i2 = i14;
                    int i17 = i15;
                    long sampleTime = mediaExtractor.getSampleTime();
                    if (i17 >= this.mFramesTimes.length) {
                        LogExt.logE("SoundFile00 ReadFile1 t >= count errer!", TAG);
                    }
                    int i18 = i17 + 1;
                    long[] jArr = this.mFramesTimes;
                    if (jArr.length > i18) {
                        jArr[i18] = sampleTime;
                    }
                    createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                    int i19 = i13 * i18;
                    while (true) {
                        mediaExtractor.advance();
                        i4 = i16 + readSampleData;
                        if (i4 > i19) {
                            break;
                        }
                        i16 = i4;
                    }
                    i3 = i18;
                }
            }
            int dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 100);
            if (dequeueOutputBuffer < 0 || (i8 = bufferInfo.size) <= 0) {
                byteBufferArr = inputBuffers;
                i5 = i3;
                int i20 = i2;
                if (dequeueOutputBuffer == -3) {
                    byteBufferArr2 = createDecoderByType.getOutputBuffers();
                }
                i14 = i20;
            } else {
                int i21 = i2;
                if (i21 < i8) {
                    bArr = new byte[i8];
                    i21 = i8;
                } else {
                    bArr = bArr2;
                }
                byteBufferArr2[dequeueOutputBuffer].get(bArr, 0, i8);
                byteBufferArr2[dequeueOutputBuffer].clear();
                if (this.mDecodedBytes.remaining() < bufferInfo.size) {
                    int position = this.mDecodedBytes.position();
                    byteBufferArr = inputBuffers;
                    i9 = i21;
                    i5 = i3;
                    int i22 = (int) (((double) position) * ((((double) this.mFileSize) * 1.0d) / ((double) i4)) * 1.2d);
                    int i23 = i22 - position;
                    int i24 = bufferInfo.size;
                    if (i23 < i24 + 5242880) {
                        i22 = i24 + position + 5242880;
                    }
                    int i25 = 10;
                    while (true) {
                        if (i25 <= 0) {
                            byteBuffer = null;
                            break;
                        }
                        try {
                            byteBuffer = ByteBuffer.allocate(i22);
                            break;
                        } catch (OutOfMemoryError unused) {
                            i25--;
                        }
                    }
                    if (i25 == 0) {
                        break;
                    }
                    this.mDecodedBytes.rewind();
                    byteBuffer.put(this.mDecodedBytes);
                    this.mDecodedBytes = byteBuffer;
                    byteBuffer.position(position);
                } else {
                    byteBufferArr = inputBuffers;
                    i9 = i21;
                    i5 = i3;
                }
                this.mDecodedBytes.put(bArr, 0, bufferInfo.size);
                createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                i14 = i9;
                bArr2 = bArr;
            }
            if ((bufferInfo.flags & 4) != 0 || this.mDecodedBytes.position() / (this.mChannels * 2) >= i12) {
                break;
            }
            inputBuffers = byteBufferArr;
            i15 = i5;
            i10 = 0;
            i16 = i4;
        }
        this.mNumSamples = this.mDecodedBytes.position() / (this.mChannels * 2);
        this.mDecodedBytes.rewind();
        this.mDecodedBytes.order(ByteOrder.LITTLE_ENDIAN);
        this.mDecodedSamples = this.mDecodedBytes.asShortBuffer();
        this.mAvgBitRate = (int) ((((float) (this.mFileSize * 8)) * (((float) this.mSampleRate) / ((float) this.mNumSamples))) / 1000.0f);
        try {
            i6 = mediaExtractor.getTrackFormat(0).getInteger("bitrate");
        } catch (Exception e) {
            e.printStackTrace();
            i6 = 40000;
        }
        mediaExtractor.release();
        createDecoderByType.stop();
        createDecoderByType.release();
        this.mNumFrames = this.mNumSamples / getSamplesPerFrame();
        if (this.mNumSamples % getSamplesPerFrame() != 0) {
            this.mNumFrames++;
        }
        int i26 = i5;
        this.mNumFrames = i26;
        this.mFrameGains = new int[i26];
        this.mFrameLens = new int[i26];
        this.mFrameOffsets = new int[i26];
        int samplesPerFrame = (int) (((float) ((this.mAvgBitRate * 1000) / i6)) * (((float) getSamplesPerFrame()) / ((float) this.mSampleRate)));
        for (int i27 = 0; i27 < this.mNumFrames; i27++) {
            int i28 = -1;
            for (int i29 = 0; i29 < getSamplesPerFrame(); i29++) {
                int i30 = 0;
                int i31 = 0;
                while (true) {
                    i7 = this.mChannels;
                    if (i30 >= i7) {
                        break;
                    }
                    if (this.mDecodedSamples.remaining() > 0) {
                        i31 += Math.abs(this.mDecodedSamples.get());
                    }
                    i30++;
                }
                int i32 = i31 / i7;
                if (i28 < i32) {
                    i28 = i32;
                }
            }
            this.mFrameGains[i27] = (int) Math.sqrt((double) i28);
            this.mFrameLens[i27] = samplesPerFrame;
            this.mFrameOffsets[i27] = (int) (((float) (((this.mAvgBitRate * 1000) / i6) * i27)) * (((float) getSamplesPerFrame()) / ((float) this.mSampleRate)));
        }
        this.mDecodedSamples.rewind();
    }

    public long getDuration() {
        return this.mDuration;
    }

    public int[] getFrameGains() {
        return this.mFrameGains;
    }

    public long[] getFramesTimes() {
        return this.mFramesTimes;
    }

    public int getNumFrames() {
        return this.mNumFrames;
    }

    public int getSamplesPerFrame() {
        return 1024;
    }
}
