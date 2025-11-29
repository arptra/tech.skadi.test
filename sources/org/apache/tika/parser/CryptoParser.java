package org.apache.tika.parser;

import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import org.apache.tika.exception.EncryptedDocumentException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public abstract class CryptoParser extends DelegatingParser {
    private static final long serialVersionUID = -3507995752666557731L;
    private final Provider provider;
    private final String transformation;
    private final Set<MediaType> types;

    public CryptoParser(String str, Provider provider2, Set<MediaType> set) {
        this.transformation = str;
        this.provider = provider2;
        this.types = set;
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return this.types;
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        try {
            Provider provider2 = this.provider;
            Cipher instance = provider2 != null ? Cipher.getInstance(this.transformation, provider2) : Cipher.getInstance(this.transformation);
            Key key = (Key) parseContext.get(Key.class);
            if (key != null) {
                AlgorithmParameters algorithmParameters = (AlgorithmParameters) parseContext.get(AlgorithmParameters.class);
                SecureRandom secureRandom = (SecureRandom) parseContext.get(SecureRandom.class);
                if (algorithmParameters != null && secureRandom != null) {
                    instance.init(2, key, algorithmParameters, secureRandom);
                } else if (algorithmParameters != null) {
                    instance.init(2, key, algorithmParameters);
                } else if (secureRandom != null) {
                    instance.init(2, key, secureRandom);
                } else {
                    instance.init(2, key);
                }
                super.parse(new CipherInputStream(inputStream, instance), contentHandler, metadata, parseContext);
                return;
            }
            throw new EncryptedDocumentException("No decryption key provided");
        } catch (GeneralSecurityException e) {
            throw new TikaException("Unable to decrypt document stream", e);
        }
    }

    public CryptoParser(String str, Set<MediaType> set) {
        this(str, (Provider) null, set);
    }
}
