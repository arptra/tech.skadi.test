package org.apache.tika.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.tika.config.Field;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.Param;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class RegexCaptureParser extends AbstractParser implements Initializable {
    private static final Set<MediaType> SUPPORTED_TYPES = Collections.singleton(MediaType.TEXT_PLAIN);
    private Map<String, Pattern> captureMap = new HashMap();
    private Map<String, Pattern> matchMap = new HashMap();
    private boolean writeContent = false;

    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) throws TikaConfigException {
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return SUPPORTED_TYPES;
    }

    public void initialize(Map<String, Param> map) throws TikaConfigException {
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : this.captureMap.entrySet()) {
                hashMap.put((String) next.getKey(), ((Pattern) next.getValue()).matcher(""));
            }
            HashMap hashMap2 = new HashMap();
            for (Map.Entry next2 : this.matchMap.entrySet()) {
                hashMap2.put((String) next2.getKey(), ((Pattern) next2.getValue()).matcher(""));
            }
            HashMap hashMap3 = new HashMap();
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    Matcher matcher = (Matcher) entry.getValue();
                    if (matcher.reset(readLine).find()) {
                        String group = matcher.group(1);
                        Set set = (Set) hashMap3.get(entry.getKey());
                        if (set == null) {
                            set = new LinkedHashSet();
                            hashMap3.put((String) entry.getKey(), set);
                        }
                        set.add(group);
                    }
                }
                for (Map.Entry entry2 : hashMap2.entrySet()) {
                    if (((Matcher) entry2.getValue()).reset(readLine).find()) {
                        metadata.set((String) entry2.getKey(), BooleanUtils.TRUE);
                    }
                }
                if (this.writeContent) {
                    char[] charArray = readLine.toCharArray();
                    contentHandler.characters(charArray, 0, charArray.length);
                }
            }
            for (Map.Entry entry3 : hashMap3.entrySet()) {
                for (String add : (Set) entry3.getValue()) {
                    metadata.add((String) entry3.getKey(), add);
                }
            }
            bufferedReader.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @Field
    public void setCaptureMap(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            Pattern compile = Pattern.compile((String) next.getValue());
            this.captureMap.put((String) next.getKey(), compile);
        }
    }

    @Field
    public void setMatchMap(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            Pattern compile = Pattern.compile((String) next.getValue());
            this.matchMap.put((String) next.getKey(), compile);
        }
    }

    @Field
    @Deprecated
    public void setRegexMap(Map<String, String> map) {
        setCaptureMap(map);
    }

    @Field
    public void setWriteContent(boolean z) {
        this.writeContent = z;
    }
}
