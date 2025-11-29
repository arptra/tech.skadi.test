package com.hp.hpl.sparta;

import com.meizu.common.widget.MzContactsContract;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.text.Typography;
import org.apache.commons.codec.language.Soundex;

class ParseCharStream implements ParseSource {
    private static final char[] BEGIN_CDATA = "<![CDATA[".toCharArray();
    private static final char[] BEGIN_ETAG = "</".toCharArray();
    private static final char[] CHARREF_BEGIN = "&#".toCharArray();
    private static final char[] COMMENT_BEGIN = "<!--".toCharArray();
    private static final char[] COMMENT_END = "-->".toCharArray();
    private static final boolean DEBUG = true;
    private static final char[] DOCTYPE_BEGIN = "<!DOCTYPE".toCharArray();
    private static final char[] ENCODING = "encoding".toCharArray();
    private static final char[] END_CDATA = "]]>".toCharArray();
    private static final char[] END_EMPTYTAG = "/>".toCharArray();
    private static final char[] ENTITY_BEGIN = "<!ENTITY".toCharArray();
    public static final int HISTORY_LENGTH = 100;
    private static final boolean H_DEBUG = false;
    private static final boolean[] IS_NAME_CHAR = new boolean[128];
    private static final char[] MARKUPDECL_BEGIN = "<!".toCharArray();
    private static final int MAX_COMMON_CHAR = 128;
    private static final char[] NAME_PUNCT_CHARS = {'.', Soundex.SILENT_MARKER, '_', ':'};
    private static final char[] NDATA = "NDATA".toCharArray();
    private static final char[] PI_BEGIN = "<?".toCharArray();
    private static final char[] PUBLIC = "PUBLIC".toCharArray();
    private static final char[] QU_END = "?>".toCharArray();
    private static final char[] SYSTEM = "SYSTEM".toCharArray();
    private static final int TMP_BUF_SIZE = 255;
    private static final char[] VERSION = "version".toCharArray();
    private static final char[] VERSIONNUM_PUNC_CHARS = {'_', '.', ':', Soundex.SILENT_MARKER};
    private static final char[] XML_BEGIN = "<?xml".toCharArray();
    private final int CBUF_SIZE;
    private final char[] cbuf_;
    private int ch_;
    private int curPos_;
    private String docTypeName_;
    private final String encoding_;
    private int endPos_;
    private final Hashtable entities_;
    private boolean eos_;
    private final ParseHandler handler_;
    private final CharCircBuffer history_;
    private boolean isExternalDtd_;
    private int lineNumber_;
    private final ParseLog log_;
    private final Hashtable pes_;
    private final Reader reader_;
    private String systemId_;
    private final char[] tmpBuf_;

    static {
        for (char c = 0; c < 128; c = (char) (c + 1)) {
            IS_NAME_CHAR[c] = isNameChar(c);
        }
    }

    public ParseCharStream(String str, Reader reader, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this(str, reader, (char[]) null, parseLog, str2, parseHandler);
    }

    private int fillBuf() throws IOException {
        if (this.eos_) {
            return -1;
        }
        int i = this.endPos_;
        char[] cArr = this.cbuf_;
        if (i == cArr.length) {
            this.endPos_ = 0;
            this.curPos_ = 0;
        }
        Reader reader = this.reader_;
        int i2 = this.endPos_;
        int read = reader.read(cArr, i2, cArr.length - i2);
        if (read <= 0) {
            this.eos_ = true;
            return -1;
        }
        this.endPos_ += read;
        return read;
    }

    private boolean isCdSect() throws ParseException, IOException {
        return isSymbol(BEGIN_CDATA);
    }

    private final boolean isChar(char c) throws ParseException, IOException {
        if (this.curPos_ < this.endPos_ || fillBuf() != -1) {
            return this.cbuf_[this.curPos_] == c;
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    private final boolean isComment() throws ParseException, IOException {
        return isSymbol(COMMENT_BEGIN);
    }

    private boolean isDeclSep() throws ParseException, IOException {
        return isPeReference() || isS();
    }

    private boolean isDocTypeDecl() throws ParseException, IOException {
        return isSymbol(DOCTYPE_BEGIN);
    }

    private boolean isETag() throws ParseException, IOException {
        return isSymbol(BEGIN_ETAG);
    }

    private boolean isEncodingDecl() throws ParseException, IOException {
        return isSymbol(ENCODING);
    }

    private boolean isEntityDecl() throws ParseException, IOException {
        return isSymbol(ENTITY_BEGIN);
    }

    private final boolean isEntityValue() throws ParseException, IOException {
        return isChar('\'', '\"');
    }

    private static boolean isExtender(char c) {
        if (c == 183 || c == 903 || c == 1600 || c == 3654 || c == 3782 || c == 12293 || c == 720 || c == 721 || c == 12445 || c == 12446) {
            return true;
        }
        switch (c) {
            case 12337:
            case 12338:
            case 12339:
            case 12340:
            case 12341:
                return true;
            default:
                switch (c) {
                    case 12540:
                    case 12541:
                    case 12542:
                        return true;
                    default:
                        return false;
                }
        }
    }

    private boolean isExternalId() throws ParseException, IOException {
        return isSymbol(SYSTEM) || isSymbol(PUBLIC);
    }

    private static final boolean isIn(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    private static boolean isLetter(char c) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(c)) != -1;
    }

    private boolean isMisc() throws ParseException, IOException {
        return isComment() || isPi() || isS();
    }

    private boolean isNameChar() throws ParseException, IOException {
        char peekChar = peekChar();
        return peekChar < 128 ? IS_NAME_CHAR[peekChar] : isNameChar(peekChar);
    }

    private boolean isPeReference() throws ParseException, IOException {
        return isChar('%');
    }

    private final boolean isPi() throws ParseException, IOException {
        return isSymbol(PI_BEGIN);
    }

    private final boolean isReference() throws ParseException, IOException {
        return isChar(Typography.amp);
    }

    private final boolean isS() throws ParseException, IOException {
        return isChar(' ', 9, 13, 10);
    }

    private final boolean isSymbol(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.endPos_ - this.curPos_ >= length || fillBuf(length) > 0) {
            char[] cArr2 = this.cbuf_;
            int i = this.endPos_;
            this.ch_ = cArr2[i - 1];
            if (i - this.curPos_ < length) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (this.cbuf_[this.curPos_ + i2] != cArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        this.ch_ = -1;
        return false;
    }

    private boolean isVersionNumChar() throws ParseException, IOException {
        char peekChar = peekChar();
        return Character.isDigit(peekChar) || ('a' <= peekChar && peekChar <= 'z') || (('Z' <= peekChar && peekChar <= 'Z') || isIn(peekChar, VERSIONNUM_PUNC_CHARS));
    }

    private boolean isXmlDecl() throws ParseException, IOException {
        return isSymbol(XML_BEGIN);
    }

    private final char peekChar() throws ParseException, IOException {
        if (this.curPos_ < this.endPos_ || fillBuf() != -1) {
            return this.cbuf_[this.curPos_];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    private String readAttValue() throws ParseException, IOException {
        char readChar = readChar('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!isChar(readChar)) {
            if (isReference()) {
                stringBuffer.append(readReference());
            } else {
                stringBuffer.append(readChar());
            }
        }
        readChar(readChar);
        return stringBuffer.toString();
    }

    private void readAttribute(Element element) throws ParseException, IOException {
        String readName = readName();
        readEq();
        String readAttValue = readAttValue();
        if (element.getAttribute(readName) != null) {
            ParseLog parseLog = this.log_;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Element ");
            stringBuffer.append(this);
            stringBuffer.append(" contains attribute ");
            stringBuffer.append(readName);
            stringBuffer.append("more than once");
            parseLog.warning(stringBuffer.toString(), this.systemId_, getLineNumber());
        }
        element.setAttribute(readName, readAttValue);
    }

    private void readCdSect() throws ParseException, IOException {
        char[] cArr;
        readSymbol(BEGIN_CDATA);
        StringBuffer stringBuffer = null;
        int i = 0;
        while (true) {
            cArr = END_CDATA;
            if (isSymbol(cArr)) {
                break;
            }
            if (i >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i);
                    stringBuffer.append(this.tmpBuf_, 0, i);
                } else {
                    stringBuffer.append(this.tmpBuf_, 0, i);
                }
                i = 0;
            }
            this.tmpBuf_[i] = readChar();
            i++;
        }
        readSymbol(cArr);
        if (stringBuffer != null) {
            stringBuffer.append(this.tmpBuf_, 0, i);
            char[] charArray = stringBuffer.toString().toCharArray();
            this.handler_.characters(charArray, 0, charArray.length);
            return;
        }
        this.handler_.characters(this.tmpBuf_, 0, i);
    }

    private final char readChar() throws ParseException, IOException {
        if (this.curPos_ < this.endPos_ || fillBuf() != -1) {
            char[] cArr = this.cbuf_;
            int i = this.curPos_;
            char c = cArr[i];
            if (c == 10) {
                this.lineNumber_++;
            }
            this.curPos_ = i + 1;
            return c;
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    private char readCharRef() throws ParseException, IOException {
        int i;
        readSymbol(CHARREF_BEGIN);
        if (isChar('x')) {
            readChar();
            i = 16;
        } else {
            i = 10;
        }
        int i2 = 0;
        while (!isChar(';')) {
            int i3 = i2 + 1;
            this.tmpBuf_[i2] = readChar();
            if (i3 >= 255) {
                this.log_.warning("Tmp buffer overflow on readCharRef", this.systemId_, getLineNumber());
                return ' ';
            }
            i2 = i3;
        }
        readChar(';');
        String str = new String(this.tmpBuf_, 0, i2);
        try {
            return (char) Integer.parseInt(str, i);
        } catch (NumberFormatException unused) {
            ParseLog parseLog = this.log_;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\"");
            stringBuffer.append(str);
            stringBuffer.append("\" is not a valid ");
            stringBuffer.append(i == 16 ? "hexadecimal" : "decimal");
            stringBuffer.append(" number");
            parseLog.warning(stringBuffer.toString(), this.systemId_, getLineNumber());
            return ' ';
        }
    }

    private final void readComment() throws ParseException, IOException {
        readSymbol(COMMENT_BEGIN);
        while (true) {
            char[] cArr = COMMENT_END;
            if (isSymbol(cArr)) {
                readSymbol(cArr);
                return;
            }
            readChar();
        }
    }

    private void readContent() throws ParseException, IOException {
        readPossibleCharData();
        boolean z = true;
        while (z) {
            if (!isETag()) {
                if (isReference()) {
                    char[] readReference = readReference();
                    this.handler_.characters(readReference, 0, readReference.length);
                } else if (isCdSect()) {
                    readCdSect();
                } else if (isPi()) {
                    readPi();
                } else if (isComment()) {
                    readComment();
                } else if (isChar(Typography.less)) {
                    readElement();
                }
                readPossibleCharData();
            }
            z = false;
            readPossibleCharData();
        }
    }

    private void readDeclSep() throws ParseException, IOException {
        if (isPeReference()) {
            readPeReference();
        } else {
            readS();
        }
    }

    private void readDocTypeDecl() throws ParseException, IOException {
        readSymbol(DOCTYPE_BEGIN);
        readS();
        this.docTypeName_ = readName();
        if (isS()) {
            readS();
            if (!isChar(Typography.greater) && !isChar('[')) {
                this.isExternalDtd_ = true;
                readExternalId();
                if (isS()) {
                    readS();
                }
            }
        }
        if (isChar('[')) {
            readChar();
            while (!isChar(']')) {
                if (isDeclSep()) {
                    readDeclSep();
                } else {
                    readMarkupDecl();
                }
            }
            readChar(']');
            if (isS()) {
                readS();
            }
        }
        readChar(Typography.greater);
    }

    private void readETag(Element element) throws ParseException, IOException {
        readSymbol(BEGIN_ETAG);
        String readName = readName();
        if (!readName.equals(element.getTagName())) {
            ParseLog parseLog = this.log_;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("end tag (");
            stringBuffer.append(readName);
            stringBuffer.append(") does not match begin tag (");
            stringBuffer.append(element.getTagName());
            stringBuffer.append(")");
            parseLog.warning(stringBuffer.toString(), this.systemId_, getLineNumber());
        }
        if (isS()) {
            readS();
        }
        readChar(Typography.greater);
    }

    private final Element readElement() throws ParseException, IOException {
        Element element = new Element();
        boolean readEmptyElementTagOrSTag = readEmptyElementTagOrSTag(element);
        this.handler_.startElement(element);
        if (readEmptyElementTagOrSTag) {
            readContent();
            readETag(element);
        }
        this.handler_.endElement(element);
        return element;
    }

    private boolean readEmptyElementTagOrSTag(Element element) throws ParseException, IOException {
        readChar(Typography.less);
        element.setTagName(readName());
        while (isS()) {
            readS();
            if (!isChar('/', Typography.greater)) {
                readAttribute(element);
            }
        }
        if (isS()) {
            readS();
        }
        boolean isChar = isChar(Typography.greater);
        if (isChar) {
            readChar(Typography.greater);
        } else {
            readSymbol(END_EMPTYTAG);
        }
        return isChar;
    }

    private String readEncodingDecl() throws ParseException, IOException {
        readSymbol(ENCODING);
        readEq();
        char readChar = readChar('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!isChar(readChar)) {
            stringBuffer.append(readChar());
        }
        readChar(readChar);
        return stringBuffer.toString();
    }

    private void readEntityDecl() throws ParseException, IOException {
        String readName;
        String str;
        Hashtable hashtable;
        String readExternalId;
        readSymbol(ENTITY_BEGIN);
        readS();
        if (isChar('%')) {
            readChar('%');
            readS();
            readName = readName();
            readS();
            str = isEntityValue() ? readEntityValue() : readExternalId();
            hashtable = this.pes_;
        } else {
            readName = readName();
            readS();
            if (isEntityValue()) {
                readExternalId = readEntityValue();
            } else if (isExternalId()) {
                readExternalId = readExternalId();
                if (isS()) {
                    readS();
                }
                char[] cArr = NDATA;
                if (isSymbol(cArr)) {
                    readSymbol(cArr);
                    readS();
                    readName();
                }
            } else {
                throw new ParseException(this, "expecting double-quote, \"PUBLIC\" or \"SYSTEM\" while reading entity declaration");
            }
            hashtable = this.entities_;
        }
        hashtable.put(readName, str);
        if (isS()) {
            readS();
        }
        readChar(Typography.greater);
    }

    private String readEntityRef() throws ParseException, IOException {
        ParseLog parseLog;
        StringBuffer stringBuffer;
        String str;
        readChar(Typography.amp);
        String readName = readName();
        String str2 = (String) this.entities_.get(readName);
        if (str2 == null) {
            if (this.isExternalDtd_) {
                parseLog = this.log_;
                stringBuffer = new StringBuffer();
                stringBuffer.append("&");
                stringBuffer.append(readName);
                str = "; not found -- possibly defined in external DTD)";
            } else {
                parseLog = this.log_;
                stringBuffer = new StringBuffer();
                stringBuffer.append("No declaration of &");
                stringBuffer.append(readName);
                str = MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD;
            }
            stringBuffer.append(str);
            parseLog.warning(stringBuffer.toString(), this.systemId_, getLineNumber());
            str2 = "";
        }
        readChar(';');
        return str2;
    }

    private final String readEntityValue() throws ParseException, IOException {
        char readChar = readChar('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!isChar(readChar)) {
            if (isPeReference()) {
                stringBuffer.append(readPeReference());
            } else if (isReference()) {
                stringBuffer.append(readReference());
            } else {
                stringBuffer.append(readChar());
            }
        }
        readChar(readChar);
        return stringBuffer.toString();
    }

    private final void readEq() throws ParseException, IOException {
        if (isS()) {
            readS();
        }
        readChar('=');
        if (isS()) {
            readS();
        }
    }

    private String readExternalId() throws ParseException, IOException {
        char[] cArr = SYSTEM;
        if (isSymbol(cArr)) {
            readSymbol(cArr);
        } else {
            char[] cArr2 = PUBLIC;
            if (isSymbol(cArr2)) {
                readSymbol(cArr2);
                readS();
                readPubidLiteral();
            } else {
                throw new ParseException(this, "expecting \"SYSTEM\" or \"PUBLIC\" while reading external ID");
            }
        }
        readS();
        readSystemLiteral();
        return "(WARNING: external ID not read)";
    }

    private void readMarkupDecl() throws ParseException, IOException {
        if (isPi()) {
            readPi();
        } else if (isComment()) {
            readComment();
        } else if (isEntityDecl()) {
            readEntityDecl();
        } else if (isSymbol(MARKUPDECL_BEGIN)) {
            while (!isChar(Typography.greater)) {
                if (isChar('\'', '\"')) {
                    char readChar = readChar();
                    while (!isChar(readChar)) {
                        readChar();
                    }
                    readChar(readChar);
                } else {
                    readChar();
                }
            }
            readChar(Typography.greater);
        } else {
            throw new ParseException(this, "expecting processing instruction, comment, or \"<!\"");
        }
    }

    private void readMisc() throws ParseException, IOException {
        if (isComment()) {
            readComment();
        } else if (isPi()) {
            readPi();
        } else if (isS()) {
            readS();
        } else {
            throw new ParseException(this, "expecting comment or processing instruction or space");
        }
    }

    private final String readName() throws ParseException, IOException {
        this.tmpBuf_[0] = readNameStartChar();
        StringBuffer stringBuffer = null;
        int i = 1;
        while (isNameChar()) {
            if (i >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i);
                    stringBuffer.append(this.tmpBuf_, 0, i);
                } else {
                    stringBuffer.append(this.tmpBuf_, 0, i);
                }
                i = 0;
            }
            this.tmpBuf_[i] = readChar();
            i++;
        }
        if (stringBuffer == null) {
            return Sparta.intern(new String(this.tmpBuf_, 0, i));
        }
        stringBuffer.append(this.tmpBuf_, 0, i);
        return stringBuffer.toString();
    }

    private char readNameStartChar() throws ParseException, IOException {
        char readChar = readChar();
        if (isLetter(readChar) || readChar == '_' || readChar == ':') {
            return readChar;
        }
        throw new ParseException(this, readChar, "letter, underscore, colon");
    }

    private String readPeReference() throws ParseException, IOException {
        readChar('%');
        String readName = readName();
        String str = (String) this.pes_.get(readName);
        if (str == null) {
            ParseLog parseLog = this.log_;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No declaration of %");
            stringBuffer.append(readName);
            stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
            parseLog.warning(stringBuffer.toString(), this.systemId_, getLineNumber());
            str = "";
        }
        readChar(';');
        return str;
    }

    private final void readPi() throws ParseException, IOException {
        readSymbol(PI_BEGIN);
        while (true) {
            char[] cArr = QU_END;
            if (isSymbol(cArr)) {
                readSymbol(cArr);
                return;
            }
            readChar();
        }
    }

    private void readPossibleCharData() throws ParseException, IOException {
        int i;
        loop0:
        while (true) {
            i = 0;
            while (!isChar(Typography.less) && !isChar(Typography.amp) && !isSymbol(END_CDATA)) {
                this.tmpBuf_[i] = readChar();
                if (this.tmpBuf_[i] == 13 && peekChar() == 10) {
                    this.tmpBuf_[i] = readChar();
                }
                i++;
                if (i == 255) {
                    this.handler_.characters(this.tmpBuf_, 0, 255);
                }
            }
        }
        if (i > 0) {
            this.handler_.characters(this.tmpBuf_, 0, i);
        }
    }

    private void readProlog() throws ParseException, EncodingMismatchException, IOException {
        if (isXmlDecl()) {
            readXmlDecl();
        }
        while (isMisc()) {
            readMisc();
        }
        if (isDocTypeDecl()) {
            readDocTypeDecl();
            while (isMisc()) {
                readMisc();
            }
        }
    }

    private final void readPubidLiteral() throws ParseException, IOException {
        readSystemLiteral();
    }

    private final char[] readReference() throws ParseException, IOException {
        if (!isSymbol(CHARREF_BEGIN)) {
            return readEntityRef().toCharArray();
        }
        return new char[]{readCharRef()};
    }

    private final void readS() throws ParseException, IOException {
        readChar(' ', 9, 13, 10);
        while (isChar(' ', 9, 13, 10)) {
            readChar();
        }
    }

    private final void readSymbol(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.endPos_ - this.curPos_ >= length || fillBuf(length) > 0) {
            char[] cArr2 = this.cbuf_;
            int i = this.endPos_;
            this.ch_ = cArr2[i - 1];
            if (i - this.curPos_ >= length) {
                int i2 = 0;
                while (i2 < length) {
                    if (this.cbuf_[this.curPos_ + i2] == cArr[i2]) {
                        i2++;
                    } else {
                        throw new ParseException(this, new String(this.cbuf_, this.curPos_, length), cArr);
                    }
                }
                this.curPos_ += length;
                return;
            }
            throw new ParseException(this, "end of XML file", cArr);
        }
        this.ch_ = -1;
        throw new ParseException(this, "end of XML file", cArr);
    }

    private final void readSystemLiteral() throws ParseException, IOException {
        char readChar = readChar();
        while (peekChar() != readChar) {
            readChar();
        }
        readChar(readChar);
    }

    private void readVersionInfo() throws ParseException, IOException {
        readS();
        readSymbol(VERSION);
        readEq();
        char readChar = readChar('\'', '\"');
        readVersionNum();
        readChar(readChar);
    }

    private void readVersionNum() throws ParseException, IOException {
        do {
            readChar();
        } while (isVersionNumChar());
    }

    private void readXmlDecl() throws ParseException, EncodingMismatchException, IOException {
        readSymbol(XML_BEGIN);
        readVersionInfo();
        if (isS()) {
            readS();
        }
        if (isEncodingDecl()) {
            String readEncodingDecl = readEncodingDecl();
            if (this.encoding_ != null && !readEncodingDecl.toLowerCase().equals(this.encoding_)) {
                throw new EncodingMismatchException(this.systemId_, readEncodingDecl, this.encoding_);
            }
        }
        while (true) {
            char[] cArr = QU_END;
            if (isSymbol(cArr)) {
                readSymbol(cArr);
                return;
            }
            readChar();
        }
    }

    public final String getHistory() {
        return "";
    }

    public int getLastCharRead() {
        return this.ch_;
    }

    public int getLineNumber() {
        return this.lineNumber_;
    }

    public ParseLog getLog() {
        return this.log_;
    }

    public String getSystemId() {
        return this.systemId_;
    }

    public String toString() {
        return this.systemId_;
    }

    public ParseCharStream(String str, Reader reader, char[] cArr, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this.docTypeName_ = null;
        Hashtable hashtable = new Hashtable();
        this.entities_ = hashtable;
        this.pes_ = new Hashtable();
        this.ch_ = -2;
        this.isExternalDtd_ = false;
        this.CBUF_SIZE = 1024;
        this.curPos_ = 0;
        this.endPos_ = 0;
        this.eos_ = false;
        this.tmpBuf_ = new char[255];
        this.lineNumber_ = 1;
        this.history_ = null;
        parseLog = parseLog == null ? ParseSource.DEFAULT_LOG : parseLog;
        this.log_ = parseLog;
        this.encoding_ = str2 == null ? null : str2.toLowerCase();
        hashtable.put("lt", "<");
        hashtable.put("gt", ">");
        hashtable.put("amp", "&");
        hashtable.put("apos", "'");
        hashtable.put("quot", "\"");
        if (cArr != null) {
            this.cbuf_ = cArr;
            this.curPos_ = 0;
            this.endPos_ = cArr.length;
            this.eos_ = true;
            this.reader_ = null;
        } else {
            this.reader_ = reader;
            this.cbuf_ = new char[1024];
            fillBuf();
        }
        this.systemId_ = str;
        this.handler_ = parseHandler;
        parseHandler.setParseSource(this);
        readProlog();
        parseHandler.startDocument();
        Element readElement = readElement();
        String str3 = this.docTypeName_;
        if (str3 != null && !str3.equals(readElement.getTagName())) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("DOCTYPE name \"");
            stringBuffer.append(this.docTypeName_);
            stringBuffer.append("\" not same as tag name, \"");
            stringBuffer.append(readElement.getTagName());
            stringBuffer.append("\" of root element");
            parseLog.warning(stringBuffer.toString(), this.systemId_, getLineNumber());
        }
        while (isMisc()) {
            readMisc();
        }
        Reader reader2 = this.reader_;
        if (reader2 != null) {
            reader2.close();
        }
        this.handler_.endDocument();
    }

    private int fillBuf(int i) throws IOException {
        int i2;
        int i3;
        if (this.eos_) {
            return -1;
        }
        int i4 = 0;
        if (this.cbuf_.length - this.curPos_ < i) {
            int i5 = 0;
            while (true) {
                i2 = this.curPos_;
                int i6 = i2 + i5;
                i3 = this.endPos_;
                if (i6 >= i3) {
                    break;
                }
                char[] cArr = this.cbuf_;
                cArr[i5] = cArr[i2 + i5];
                i5++;
            }
            int i7 = i3 - i2;
            this.endPos_ = i7;
            this.curPos_ = 0;
            i4 = i7;
        }
        int fillBuf = fillBuf();
        if (fillBuf != -1) {
            return i4 + fillBuf;
        }
        if (i4 == 0) {
            return -1;
        }
        return i4;
    }

    private final boolean isChar(char c, char c2) throws ParseException, IOException {
        if (this.curPos_ >= this.endPos_ && fillBuf() == -1) {
            return false;
        }
        char c3 = this.cbuf_[this.curPos_];
        return c3 == c || c3 == c2;
    }

    private static boolean isNameChar(char c) {
        return Character.isDigit(c) || isLetter(c) || isIn(c, NAME_PUNCT_CHARS) || isExtender(c);
    }

    private final char readChar(char c, char c2) throws ParseException, IOException {
        char readChar = readChar();
        if (readChar == c || readChar == c2) {
            return readChar;
        }
        throw new ParseException(this, readChar, new char[]{c, c2});
    }

    public ParseCharStream(String str, char[] cArr, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this(str, (Reader) null, cArr, parseLog, str2, parseHandler);
    }

    private final boolean isChar(char c, char c2, char c3, char c4) throws ParseException, IOException {
        if (this.curPos_ >= this.endPos_ && fillBuf() == -1) {
            return false;
        }
        char c5 = this.cbuf_[this.curPos_];
        return c5 == c || c5 == c2 || c5 == c3 || c5 == c4;
    }

    private final char readChar(char c, char c2, char c3, char c4) throws ParseException, IOException {
        char readChar = readChar();
        if (readChar == c || readChar == c2 || readChar == c3 || readChar == c4) {
            return readChar;
        }
        throw new ParseException(this, readChar, new char[]{c, c2, c3, c4});
    }

    private final void readChar(char c) throws ParseException, IOException {
        char readChar = readChar();
        if (readChar != c) {
            throw new ParseException(this, readChar, c);
        }
    }
}
