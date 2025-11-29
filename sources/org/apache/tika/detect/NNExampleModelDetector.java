package org.apache.tika.detect;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Objects;
import org.apache.tika.mime.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NNExampleModelDetector extends TrainedModelDetector {
    private static final String EXAMPLE_NNMODEL_FILE = "tika-example.nnmodel";
    private static final Logger LOG = LoggerFactory.k(NNExampleModelDetector.class);
    private static final long serialVersionUID = 1;

    public NNExampleModelDetector() {
    }

    private void readDescription(NNTrainedModelBuilder nNTrainedModelBuilder, String str) {
        String[] split = str.split("\t");
        try {
            MediaType parse = MediaType.parse(split[1]);
            int parseInt = Integer.parseInt(split[2]);
            int parseInt2 = Integer.parseInt(split[3]);
            int parseInt3 = Integer.parseInt(split[4]);
            nNTrainedModelBuilder.d(parseInt);
            nNTrainedModelBuilder.c(parseInt2);
            nNTrainedModelBuilder.e(parseInt3);
            nNTrainedModelBuilder.g(parse);
        } catch (Exception e) {
            LOG.warn("Unable to parse the model configuration", (Throwable) e);
            throw new RuntimeException("Unable to parse the model configuration", e);
        }
    }

    private void readNNParams(NNTrainedModelBuilder nNTrainedModelBuilder, String str) {
        String[] split = str.split("\t");
        float[] fArr = new float[split.length];
        try {
            int i = 0;
            for (String parseFloat : split) {
                fArr[i] = Float.parseFloat(parseFloat);
                i++;
            }
            nNTrainedModelBuilder.f(fArr);
        } catch (Exception e) {
            LOG.warn("Unable to parse the model configuration", (Throwable) e);
            throw new RuntimeException("Unable to parse the model configuration", e);
        }
    }

    public void loadDefaultModels(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        NNTrainedModelBuilder nNTrainedModelBuilder = new NNTrainedModelBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String trim = readLine.trim();
                    if (trim.startsWith("#")) {
                        readDescription(nNTrainedModelBuilder, trim);
                    } else {
                        readNNParams(nNTrainedModelBuilder, trim);
                        super.registerModels(nNTrainedModelBuilder.b(), nNTrainedModelBuilder.a());
                    }
                } else {
                    return;
                }
            } catch (IOException e) {
                throw new RuntimeException("Unable to read the default media type registry", e);
            }
        }
    }

    public NNExampleModelDetector(Path path) {
        loadDefaultModels(path);
    }

    public NNExampleModelDetector(File file) {
        loadDefaultModels(file);
    }

    public void loadDefaultModels(ClassLoader classLoader) {
        InputStream openStream;
        Class<TrainedModelDetector> cls = TrainedModelDetector.class;
        if (classLoader == null) {
            classLoader = cls.getClassLoader();
        }
        String str = cls.getPackage().getName().replace('.', '/') + "/";
        URL resource = classLoader.getResource(str + EXAMPLE_NNMODEL_FILE);
        Objects.requireNonNull(resource, "required resource " + str + EXAMPLE_NNMODEL_FILE + " not found");
        try {
            openStream = resource.openStream();
            loadDefaultModels(openStream);
            if (openStream != null) {
                openStream.close();
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
}
