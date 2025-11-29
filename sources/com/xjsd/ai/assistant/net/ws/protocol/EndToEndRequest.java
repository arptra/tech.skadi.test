package com.xjsd.ai.assistant.net.ws.protocol;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

@Keep
public class EndToEndRequest {
    private static Gson PARSER = new Gson();
    private EndToEndMetadata metadata;
    private List<EndToEndServiceData> services = new ArrayList();

    public void appendServiceData(EndToEndServiceData endToEndServiceData) {
        this.services.add(endToEndServiceData);
    }

    public EndToEndMetadata getMetadata() {
        return this.metadata;
    }

    public List<EndToEndServiceData> getServices() {
        return this.services;
    }

    public void setMetadata(EndToEndMetadata endToEndMetadata) {
        this.metadata = endToEndMetadata;
    }

    public void setServices(List<EndToEndServiceData> list) {
        this.services = list;
    }

    public String toString() {
        return PARSER.toJson((Object) this);
    }
}
