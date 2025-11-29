package com.honey.account.view.web;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/honey/account/view/web/WebEvent;", "", "eventName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "COMPLETE_PROCESS", "CLOSE_PAGE", "IS_EVENT_EXIST", "OPEN_LINK_IN_BROWSER", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum WebEvent {
    COMPLETE_PROCESS("completeProcess"),
    CLOSE_PAGE("closePage"),
    IS_EVENT_EXIST("isEventExist"),
    OPEN_LINK_IN_BROWSER("openLinkInBrowser");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String eventName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/honey/account/view/web/WebEvent$Companion;", "", "()V", "parse", "Lcom/honey/account/view/web/WebEvent;", "name", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final WebEvent parse(@Nullable String str) {
            WebEvent webEvent = WebEvent.COMPLETE_PROCESS;
            if (Intrinsics.areEqual((Object) str, (Object) webEvent.toString())) {
                return webEvent;
            }
            WebEvent webEvent2 = WebEvent.CLOSE_PAGE;
            if (Intrinsics.areEqual((Object) str, (Object) webEvent2.toString())) {
                return webEvent2;
            }
            WebEvent webEvent3 = WebEvent.IS_EVENT_EXIST;
            if (Intrinsics.areEqual((Object) str, (Object) webEvent3.toString())) {
                return webEvent3;
            }
            WebEvent webEvent4 = WebEvent.OPEN_LINK_IN_BROWSER;
            if (Intrinsics.areEqual((Object) str, (Object) webEvent4.toString())) {
                return webEvent4;
            }
            return null;
        }

        private Companion() {
        }
    }

    static {
        WebEvent[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private WebEvent(String str) {
        this.eventName = str;
    }

    @NotNull
    public static EnumEntries<WebEvent> getEntries() {
        return $ENTRIES;
    }

    @NotNull
    public String toString() {
        return this.eventName;
    }
}
