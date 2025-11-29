package io.netty.handler.codec.smtp;

import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

public final class SmtpRequests {
    private static final SmtpRequest DATA = new DefaultSmtpRequest(SmtpCommand.DATA);
    private static final AsciiString FROM_NULL_SENDER = AsciiString.cached("FROM:<>");
    private static final SmtpRequest HELP_NO_ARG = new DefaultSmtpRequest(SmtpCommand.HELP);
    private static final SmtpRequest NOOP = new DefaultSmtpRequest(SmtpCommand.NOOP);
    private static final SmtpRequest QUIT = new DefaultSmtpRequest(SmtpCommand.QUIT);
    private static final SmtpRequest RSET = new DefaultSmtpRequest(SmtpCommand.RSET);

    private SmtpRequests() {
    }

    public static SmtpRequest auth(CharSequence... charSequenceArr) {
        return new DefaultSmtpRequest(SmtpCommand.AUTH, charSequenceArr);
    }

    public static SmtpRequest data() {
        return DATA;
    }

    public static SmtpRequest ehlo(CharSequence charSequence) {
        return new DefaultSmtpRequest(SmtpCommand.EHLO, charSequence);
    }

    public static SmtpRequest empty(CharSequence... charSequenceArr) {
        return new DefaultSmtpRequest(SmtpCommand.EMPTY, charSequenceArr);
    }

    public static SmtpRequest expn(CharSequence charSequence) {
        return new DefaultSmtpRequest(SmtpCommand.EXPN, (CharSequence) ObjectUtil.checkNotNull(charSequence, "mailingList"));
    }

    public static SmtpRequest helo(CharSequence charSequence) {
        return new DefaultSmtpRequest(SmtpCommand.HELO, charSequence);
    }

    public static SmtpRequest help(String str) {
        if (str == null) {
            return HELP_NO_ARG;
        }
        return new DefaultSmtpRequest(SmtpCommand.HELP, str);
    }

    public static SmtpRequest mail(CharSequence charSequence, CharSequence... charSequenceArr) {
        CharSequence charSequence2;
        Object obj;
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            SmtpCommand smtpCommand = SmtpCommand.MAIL;
            CharSequence[] charSequenceArr2 = new CharSequence[1];
            if (charSequence != null) {
                charSequence2 = "FROM:<" + charSequence + Typography.greater;
            } else {
                charSequence2 = FROM_NULL_SENDER;
            }
            charSequenceArr2[0] = charSequence2;
            return new DefaultSmtpRequest(smtpCommand, charSequenceArr2);
        }
        ArrayList arrayList = new ArrayList(charSequenceArr.length + 1);
        if (charSequence != null) {
            obj = "FROM:<" + charSequence + Typography.greater;
        } else {
            obj = FROM_NULL_SENDER;
        }
        arrayList.add(obj);
        Collections.addAll(arrayList, charSequenceArr);
        return new DefaultSmtpRequest(SmtpCommand.MAIL, (List<CharSequence>) arrayList);
    }

    public static SmtpRequest noop() {
        return NOOP;
    }

    public static SmtpRequest quit() {
        return QUIT;
    }

    public static SmtpRequest rcpt(CharSequence charSequence, CharSequence... charSequenceArr) {
        ObjectUtil.checkNotNull(charSequence, "recipient");
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            SmtpCommand smtpCommand = SmtpCommand.RCPT;
            return new DefaultSmtpRequest(smtpCommand, "TO:<" + charSequence + Typography.greater);
        }
        ArrayList arrayList = new ArrayList(charSequenceArr.length + 1);
        arrayList.add("TO:<" + charSequence + Typography.greater);
        Collections.addAll(arrayList, charSequenceArr);
        return new DefaultSmtpRequest(SmtpCommand.RCPT, (List<CharSequence>) arrayList);
    }

    public static SmtpRequest rset() {
        return RSET;
    }

    public static SmtpRequest vrfy(CharSequence charSequence) {
        return new DefaultSmtpRequest(SmtpCommand.VRFY, (CharSequence) ObjectUtil.checkNotNull(charSequence, "user"));
    }
}
