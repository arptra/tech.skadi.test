package org.apache.tika.parser;

import java.io.IOException;
import java.io.Serializable;
import org.apache.tika.config.ConfigBase;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.extractor.EmbeddedDocumentExtractorFactory;
import org.apache.tika.extractor.ParsingEmbeddedDocumentExtractorFactory;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.writefilter.MetadataWriteFilterFactory;
import org.apache.tika.parser.DigestingParser;
import org.apache.tika.sax.ContentHandlerDecoratorFactory;
import org.w3c.dom.Element;
import org.xml.sax.ContentHandler;

public class AutoDetectParserConfig extends ConfigBase implements Serializable {
    public static AutoDetectParserConfig DEFAULT = new AutoDetectParserConfig();
    private static ContentHandlerDecoratorFactory NOOP_CONTENT_HANDLER_DECORATOR_FACTORY = new ContentHandlerDecoratorFactory() {
        public ContentHandler decorate(ContentHandler contentHandler, Metadata metadata) {
            return contentHandler;
        }

        public ContentHandler decorate(ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) {
            return contentHandler;
        }
    };
    private ContentHandlerDecoratorFactory contentHandlerDecoratorFactory = NOOP_CONTENT_HANDLER_DECORATOR_FACTORY;
    private DigestingParser.DigesterFactory digesterFactory = null;
    private EmbeddedDocumentExtractorFactory embeddedDocumentExtractorFactory = new ParsingEmbeddedDocumentExtractorFactory();
    private Long maximumCompressionRatio = null;
    private Integer maximumDepth = null;
    private Integer maximumPackageEntryDepth = null;
    private MetadataWriteFilterFactory metadataWriteFilterFactory = null;
    private Long outputThreshold = null;
    private Long spoolToDisk = null;
    private boolean throwOnZeroBytes = true;

    public AutoDetectParserConfig(Long l, Long l2, Long l3, Integer num, Integer num2) {
        this.spoolToDisk = l;
        this.outputThreshold = l2;
        this.maximumCompressionRatio = l3;
        this.maximumDepth = num;
        this.maximumPackageEntryDepth = num2;
    }

    public static AutoDetectParserConfig load(Element element) throws TikaConfigException, IOException {
        return (AutoDetectParserConfig) ConfigBase.buildSingle("autoDetectParserConfig", AutoDetectParserConfig.class, element, DEFAULT);
    }

    public ContentHandlerDecoratorFactory getContentHandlerDecoratorFactory() {
        return this.contentHandlerDecoratorFactory;
    }

    public DigestingParser.DigesterFactory getDigesterFactory() {
        return this.digesterFactory;
    }

    public EmbeddedDocumentExtractorFactory getEmbeddedDocumentExtractorFactory() {
        return this.embeddedDocumentExtractorFactory;
    }

    public Long getMaximumCompressionRatio() {
        return this.maximumCompressionRatio;
    }

    public Integer getMaximumDepth() {
        return this.maximumDepth;
    }

    public Integer getMaximumPackageEntryDepth() {
        return this.maximumPackageEntryDepth;
    }

    public MetadataWriteFilterFactory getMetadataWriteFilterFactory() {
        return this.metadataWriteFilterFactory;
    }

    public Long getOutputThreshold() {
        return this.outputThreshold;
    }

    public Long getSpoolToDisk() {
        return this.spoolToDisk;
    }

    public boolean getThrowOnZeroBytes() {
        return this.throwOnZeroBytes;
    }

    public void setContentHandlerDecoratorFactory(ContentHandlerDecoratorFactory contentHandlerDecoratorFactory2) {
        this.contentHandlerDecoratorFactory = contentHandlerDecoratorFactory2;
    }

    public void setDigesterFactory(DigestingParser.DigesterFactory digesterFactory2) {
        this.digesterFactory = digesterFactory2;
    }

    public void setEmbeddedDocumentExtractorFactory(EmbeddedDocumentExtractorFactory embeddedDocumentExtractorFactory2) {
        this.embeddedDocumentExtractorFactory = embeddedDocumentExtractorFactory2;
    }

    public void setMaximumCompressionRatio(long j) {
        this.maximumCompressionRatio = Long.valueOf(j);
    }

    public void setMaximumDepth(int i) {
        this.maximumDepth = Integer.valueOf(i);
    }

    public void setMaximumPackageEntryDepth(int i) {
        this.maximumPackageEntryDepth = Integer.valueOf(i);
    }

    public void setMetadataWriteFilterFactory(MetadataWriteFilterFactory metadataWriteFilterFactory2) {
        this.metadataWriteFilterFactory = metadataWriteFilterFactory2;
    }

    public void setOutputThreshold(long j) {
        this.outputThreshold = Long.valueOf(j);
    }

    public void setSpoolToDisk(long j) {
        this.spoolToDisk = Long.valueOf(j);
    }

    public void setThrowOnZeroBytes(boolean z) {
        this.throwOnZeroBytes = z;
    }

    public String toString() {
        return "AutoDetectParserConfig{spoolToDisk=" + this.spoolToDisk + ", outputThreshold=" + this.outputThreshold + ", maximumCompressionRatio=" + this.maximumCompressionRatio + ", maximumDepth=" + this.maximumDepth + ", maximumPackageEntryDepth=" + this.maximumPackageEntryDepth + ", metadataWriteFilterFactory=" + this.metadataWriteFilterFactory + ", embeddedDocumentExtractorFactory=" + this.embeddedDocumentExtractorFactory + ", contentHandlerDecoratorFactory=" + this.contentHandlerDecoratorFactory + ", digesterFactory=" + this.digesterFactory + ", throwOnZeroBytes=" + this.throwOnZeroBytes + '}';
    }

    public AutoDetectParserConfig() {
    }
}
