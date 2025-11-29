package org.apache.tika.detect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

public abstract class TrainedModelDetector implements Detector {
    private static final long serialVersionUID = 1;
    private final Map<MediaType, TrainedModel> MODEL_MAP = new HashMap();

    public TrainedModelDetector() {
        loadDefaultModels(getClass().getClassLoader());
    }

    private void writeHisto(float[] fArr) throws IOException {
        BufferedWriter newBufferedWriter = Files.newBufferedWriter(new TemporaryResources().c(), StandardCharsets.UTF_8, new OpenOption[0]);
        try {
            for (float f : fArr) {
                newBufferedWriter.write(f + "\t");
            }
            newBufferedWriter.write("\r\n");
            newBufferedWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public MediaType detect(InputStream inputStream, Metadata metadata) throws IOException {
        if (inputStream == null) {
            return null;
        }
        inputStream.mark(getMinLength());
        float[] readByteFrequencies = readByteFrequencies(inputStream);
        MediaType mediaType = MediaType.OCTET_STREAM;
        float f = 0.5f;
        for (Map.Entry next : this.MODEL_MAP.entrySet()) {
            MediaType mediaType2 = (MediaType) next.getKey();
            float a2 = ((TrainedModel) next.getValue()).a(readByteFrequencies);
            if (f < a2) {
                f = a2;
                mediaType = mediaType2;
            }
        }
        inputStream.reset();
        return mediaType;
    }

    public int getMinLength() {
        return Integer.MAX_VALUE;
    }

    public abstract void loadDefaultModels(InputStream inputStream);

    public abstract void loadDefaultModels(ClassLoader classLoader);

    public void loadDefaultModels(Path path) {
        InputStream newInputStream;
        try {
            newInputStream = Files.newInputStream(path, new OpenOption[0]);
            loadDefaultModels(newInputStream);
            if (newInputStream != null) {
                newInputStream.close();
                return;
            }
            return;
        } catch (IOException e) {
            throw new RuntimeException("Unable to read the default media type registry", e);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public float[] readByteFrequencies(InputStream inputStream) throws IOException {
        ReadableByteChannel newChannel = Channels.newChannel(inputStream);
        float[] fArr = new float[257];
        fArr[0] = 1.0f;
        ByteBuffer allocate = ByteBuffer.allocate(5120);
        float f = -1.0f;
        for (int read = newChannel.read(allocate); read != -1; read = newChannel.read(allocate)) {
            allocate.flip();
            while (allocate.hasRemaining()) {
                byte b = allocate.get();
                int i = b + 1;
                if (b < 0) {
                    i = b + 257;
                    fArr[i] = fArr[i] + 1.0f;
                } else {
                    fArr[i] = fArr[i] + 1.0f;
                }
                f = Math.max(f, fArr[i]);
            }
            allocate.clear();
        }
        for (int i2 = 1; i2 < 257; i2++) {
            float f2 = fArr[i2] / f;
            fArr[i2] = f2;
            fArr[i2] = (float) Math.sqrt((double) f2);
        }
        return fArr;
    }

    public void registerModels(MediaType mediaType, TrainedModel trainedModel) {
        this.MODEL_MAP.put(mediaType, trainedModel);
    }

    public void loadDefaultModels(File file) {
        loadDefaultModels(file.toPath());
    }
}
