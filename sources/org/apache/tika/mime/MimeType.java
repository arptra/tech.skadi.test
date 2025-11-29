package org.apache.tika.mime;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MimeType implements Comparable<MimeType>, Serializable {
    private static final long serialVersionUID = 4357830439860729201L;
    private String acronym = "";
    private String description = "";
    private List<String> extensions = null;
    private boolean isInterpreted = false;
    private List<URI> links = Collections.emptyList();
    private List<Magic> magics = null;
    private final int minLength = 0;
    private List<RootXML> rootXML = null;
    private final MediaType type;
    private String uti = "";

    public static class RootXML implements Serializable {
        private static final long serialVersionUID = 5140496601491000730L;
        private String localName = null;
        private String namespaceURI = null;
        private MimeType type = null;

        public RootXML(MimeType mimeType, String str, String str2) {
            if (!isEmpty(str) || !isEmpty(str2)) {
                this.type = mimeType;
                this.namespaceURI = str;
                this.localName = str2;
                return;
            }
            throw new IllegalArgumentException("Both namespaceURI and localName cannot be empty");
        }

        private boolean isEmpty(String str) {
            return str == null || str.equals("");
        }

        public String getLocalName() {
            return this.localName;
        }

        public String getNameSpaceURI() {
            return this.namespaceURI;
        }

        public MimeType getType() {
            return this.type;
        }

        public boolean matches(String str, String str2) {
            if (!isEmpty(this.namespaceURI)) {
                if (!this.namespaceURI.equals(str)) {
                    return false;
                }
            } else if (!isEmpty(str)) {
                return false;
            }
            return !isEmpty(this.localName) ? this.localName.equals(str2) : isEmpty(str2);
        }

        public String toString() {
            return this.type + ", " + this.namespaceURI + ", " + this.localName;
        }
    }

    public MimeType(MediaType mediaType) {
        if (mediaType != null) {
            this.type = mediaType;
            return;
        }
        throw new IllegalArgumentException("Media type name is missing");
    }

    public static boolean isValid(String str) {
        if (str != null) {
            boolean z = false;
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt <= ' ' || charAt >= 127 || charAt == '(' || charAt == ')' || charAt == '<' || charAt == '>' || charAt == '@' || charAt == ',' || charAt == ';' || charAt == ':' || charAt == '\\' || charAt == '\"' || charAt == '[' || charAt == ']' || charAt == '?' || charAt == '=') {
                    return false;
                }
                if (charAt == '/') {
                    if (z || i == 0 || i + 1 == str.length()) {
                        return false;
                    }
                    z = true;
                }
            }
            return z;
        }
        throw new IllegalArgumentException("Name is missing");
    }

    public void addExtension(String str) {
        List<String> list = this.extensions;
        if (list == null) {
            this.extensions = Collections.singletonList(str);
        } else if (list.size() == 1) {
            this.extensions = new ArrayList(this.extensions);
        }
        if (!this.extensions.contains(str)) {
            this.extensions.add(str);
        }
    }

    public void addLink(URI uri) {
        if (uri != null) {
            ArrayList arrayList = new ArrayList(this.links.size() + 1);
            arrayList.addAll(this.links);
            arrayList.add(uri);
            this.links = Collections.unmodifiableList(arrayList);
            return;
        }
        throw new IllegalArgumentException("Missing Link");
    }

    public void addMagic(Magic magic) {
        if (magic != null) {
            if (this.magics == null) {
                this.magics = new ArrayList();
            }
            this.magics.add(magic);
        }
    }

    public void addRootXML(String str, String str2) {
        if (this.rootXML == null) {
            this.rootXML = new ArrayList();
        }
        this.rootXML.add(new RootXML(this, str, str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof MimeType) {
            return this.type.equals(((MimeType) obj).type);
        }
        return false;
    }

    public String getAcronym() {
        return this.acronym;
    }

    public String getDescription() {
        return this.description;
    }

    public String getExtension() {
        List<String> list = this.extensions;
        return list == null ? "" : list.get(0);
    }

    public List<String> getExtensions() {
        List<String> list = this.extensions;
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    public List<URI> getLinks() {
        return this.links;
    }

    public List<Magic> getMagics() {
        List<Magic> list = this.magics;
        return list != null ? list : Collections.emptyList();
    }

    public int getMinLength() {
        return 0;
    }

    public String getName() {
        return this.type.toString();
    }

    public MediaType getType() {
        return this.type;
    }

    public String getUniformTypeIdentifier() {
        return this.uti;
    }

    public boolean hasMagic() {
        return this.magics != null;
    }

    public boolean hasRootXML() {
        return this.rootXML != null;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public boolean isInterpreted() {
        return this.isInterpreted;
    }

    public boolean matches(byte[] bArr) {
        return matchesMagic(bArr);
    }

    public boolean matchesMagic(byte[] bArr) {
        int i = 0;
        while (true) {
            List<Magic> list = this.magics;
            if (list == null || i >= list.size()) {
                return false;
            }
            if (this.magics.get(i).eval(bArr)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean matchesXML(String str, String str2) {
        List<RootXML> list = this.rootXML;
        if (list == null) {
            return false;
        }
        for (RootXML matches : list) {
            if (matches.matches(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public void setAcronym(String str) {
        if (str != null) {
            this.acronym = str;
            return;
        }
        throw new IllegalArgumentException("Acronym is missing");
    }

    public void setDescription(String str) {
        if (str != null) {
            this.description = str;
            return;
        }
        throw new IllegalArgumentException("Description is missing");
    }

    public void setInterpreted(boolean z) {
        this.isInterpreted = z;
    }

    public void setUniformTypeIdentifier(String str) {
        if (str != null) {
            this.uti = str;
            return;
        }
        throw new IllegalArgumentException("Uniform Type Identifier is missing");
    }

    public String toString() {
        return this.type.toString();
    }

    public int compareTo(MimeType mimeType) {
        return this.type.compareTo(mimeType.type);
    }
}
