package org.apache.tika.pipes.pipesiterator.fs;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.pipes.FetchEmitTuple;
import org.apache.tika.pipes.async.AsyncProcessor;
import org.apache.tika.pipes.emitter.EmitKey;
import org.apache.tika.pipes.fetcher.FetchKey;
import org.apache.tika.pipes.pipesiterator.PipesIterator;
import org.apache.tika.pipes.pipesiterator.TotalCountResult;
import org.apache.tika.pipes.pipesiterator.TotalCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSystemPipesIterator extends PipesIterator implements TotalCounter, Initializable, Closeable {
    public static final Logger r = LoggerFactory.k(AsyncProcessor.class);
    public Path o;
    public boolean p;
    public FileCountWorker q;

    public class FSFileVisitor implements FileVisitor<Path> {

        /* renamed from: a  reason: collision with root package name */
        public final String f3310a;
        public final String b;

        /* renamed from: a */
        public FileVisitResult postVisitDirectory(Path path, IOException iOException) {
            return FileVisitResult.CONTINUE;
        }

        /* renamed from: b */
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) {
            return FileVisitResult.CONTINUE;
        }

        /* renamed from: c */
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
            String path2 = FileSystemPipesIterator.this.o.relativize(path).toString();
            try {
                FileSystemPipesIterator.this.q0(new FetchEmitTuple(path2, new FetchKey(this.f3310a, path2), new EmitKey(this.b, path2), new Metadata(), FileSystemPipesIterator.this.i0(), FileSystemPipesIterator.this.p0()));
                return FileVisitResult.CONTINUE;
            } catch (TimeoutException e) {
                throw new IOException(e);
            } catch (InterruptedException unused) {
                return FileVisitResult.TERMINATE;
            }
        }

        /* renamed from: d */
        public FileVisitResult visitFileFailed(Path path, IOException iOException) {
            return FileVisitResult.CONTINUE;
        }

        public FSFileVisitor(String str, String str2) {
            this.f3310a = str;
            this.b = str2;
        }
    }

    public static class FileCountWorker implements TotalCounter, Closeable {

        /* renamed from: a  reason: collision with root package name */
        public Thread f3311a;
        public final AtomicLong b = new AtomicLong(0);
        public TotalCountResult.STATUS c;
        public final Path d;

        public class FSFileCounter implements FileVisitor<Path> {

            /* renamed from: a  reason: collision with root package name */
            public final AtomicLong f3312a;

            /* renamed from: a */
            public FileVisitResult postVisitDirectory(Path path, IOException iOException) {
                return FileVisitResult.CONTINUE;
            }

            /* renamed from: b */
            public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) {
                return FileVisitResult.CONTINUE;
            }

            /* renamed from: c */
            public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
                this.f3312a.incrementAndGet();
                return FileVisitResult.CONTINUE;
            }

            /* renamed from: d */
            public FileVisitResult visitFileFailed(Path path, IOException iOException) {
                return FileVisitResult.CONTINUE;
            }
        }

        public FileCountWorker(Path path) {
            this.d = path;
            this.c = TotalCountResult.STATUS.NOT_COMPLETED;
        }

        public void close() {
            this.f3311a.interrupt();
        }
    }

    public void c0() {
        if (Files.isDirectory(this.o, new LinkOption[0])) {
            try {
                Files.walkFileTree(this.o, new FSFileVisitor(f0(), d0()));
            } catch (IOException e) {
                Throwable cause = e.getCause();
                if (cause == null || !(cause instanceof TimeoutException)) {
                    throw e;
                }
                throw ((TimeoutException) cause);
            }
        } else {
            throw new IllegalArgumentException("\"basePath\" directory does not exist: " + this.o.toAbsolutePath());
        }
    }

    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
        TikaConfig.E("basePath", this.o);
        TikaConfig.D("fetcherName", f0());
        TikaConfig.D("emitterName", f0());
    }

    public void close() {
        FileCountWorker fileCountWorker = this.q;
        if (fileCountWorker != null) {
            fileCountWorker.close();
        }
    }

    public void initialize(Map map) {
        if (this.p) {
            this.q = new FileCountWorker(this.o);
        }
    }
}
