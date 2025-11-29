package org.apache.tika.parser;

import com.honey.account.jc.a;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractExternalProcessParser extends AbstractParser {
    private static final ConcurrentHashMap<String, Process> PROCESS_MAP = new ConcurrentHashMap<>();
    private static final long serialVersionUID = 7186985395903074255L;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new a()));
    }

    public String register(Process process) {
        String uuid = UUID.randomUUID().toString();
        PROCESS_MAP.put(uuid, process);
        return uuid;
    }

    public Process release(String str) {
        return PROCESS_MAP.remove(str);
    }
}
