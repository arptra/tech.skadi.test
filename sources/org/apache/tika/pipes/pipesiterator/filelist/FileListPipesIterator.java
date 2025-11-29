package org.apache.tika.pipes.pipesiterator.filelist;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.pipes.FetchEmitTuple;
import org.apache.tika.pipes.emitter.EmitKey;
import org.apache.tika.pipes.fetcher.FetchKey;
import org.apache.tika.pipes.pipesiterator.PipesIterator;
import org.apache.tika.utils.StringUtils;

public class FileListPipesIterator extends PipesIterator implements Initializable {
    public String o;
    public boolean p;
    public Path q;

    public void c0() {
        BufferedReader newBufferedReader = Files.newBufferedReader(this.q, StandardCharsets.UTF_8);
        try {
            if (this.p) {
                newBufferedReader.readLine();
            }
            for (String readLine = newBufferedReader.readLine(); readLine != null; readLine = newBufferedReader.readLine()) {
                if (!readLine.startsWith("#") && !StringUtils.a(readLine)) {
                    q0(new FetchEmitTuple(readLine, new FetchKey(f0(), readLine), new EmitKey(d0(), readLine), new Metadata(), i0(), p0()));
                }
            }
            newBufferedReader.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
        TikaConfig.D("fileList", this.o);
        TikaConfig.D("fetcherName", f0());
        TikaConfig.D("emitterName", f0());
        Path path = Paths.get(this.o, new String[0]);
        this.q = path;
        if (!Files.isRegularFile(path, new LinkOption[0])) {
            throw new TikaConfigException("file list " + this.o + " does not exist. Must specify an existing file");
        }
    }
}
