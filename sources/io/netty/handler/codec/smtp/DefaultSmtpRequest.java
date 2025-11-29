package io.netty.handler.codec.smtp;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.List;

public final class DefaultSmtpRequest implements SmtpRequest {
    private final SmtpCommand command;
    private final List<CharSequence> parameters;

    public DefaultSmtpRequest(SmtpCommand smtpCommand) {
        this.command = (SmtpCommand) ObjectUtil.checkNotNull(smtpCommand, "command");
        this.parameters = Collections.emptyList();
    }

    public SmtpCommand command() {
        return this.command;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultSmtpRequest)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        DefaultSmtpRequest defaultSmtpRequest = (DefaultSmtpRequest) obj;
        return command().equals(defaultSmtpRequest.command()) && parameters().equals(defaultSmtpRequest.parameters());
    }

    public int hashCode() {
        return (this.command.hashCode() * 31) + this.parameters.hashCode();
    }

    public List<CharSequence> parameters() {
        return this.parameters;
    }

    public String toString() {
        return "DefaultSmtpRequest{command=" + this.command + ", parameters=" + this.parameters + '}';
    }

    public DefaultSmtpRequest(SmtpCommand smtpCommand, CharSequence... charSequenceArr) {
        this.command = (SmtpCommand) ObjectUtil.checkNotNull(smtpCommand, "command");
        this.parameters = SmtpUtils.toUnmodifiableList(charSequenceArr);
    }

    public DefaultSmtpRequest(CharSequence charSequence, CharSequence... charSequenceArr) {
        this(SmtpCommand.valueOf(charSequence), charSequenceArr);
    }

    public DefaultSmtpRequest(SmtpCommand smtpCommand, List<CharSequence> list) {
        this.command = (SmtpCommand) ObjectUtil.checkNotNull(smtpCommand, "command");
        this.parameters = list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }
}
