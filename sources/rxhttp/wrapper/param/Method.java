package rxhttp.wrapper.param;

public enum Method {
    GET,
    HEAD,
    POST,
    PUT,
    PATCH,
    DELETE;

    public boolean isDelete() {
        return name().equals("DELETE");
    }

    public boolean isGet() {
        return name().equals("GET");
    }

    public boolean isHead() {
        return name().equals("HEAD");
    }

    public boolean isPatch() {
        return name().equals("PATCH");
    }

    public boolean isPost() {
        return name().equals("POST");
    }

    public boolean isPut() {
        return name().equals("PUT");
    }
}
