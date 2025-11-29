package com.upuphone.runasone.io.engine.mailbox;

import com.upuphone.runasone.io.engine.message.Message;
import com.upuphone.runasone.io.engine.message.PriorityMessage;
import com.upuphone.runasone.io.engine.message.PriorityType;
import java.util.ArrayDeque;

public class PriorityMailbox implements ActorMailbox {
    private final ArrayDeque<Message> hightMailbox;
    private final ArrayDeque<Message> lowMailbox;
    private final ArrayDeque<Message> middleMailbox;

    /* renamed from: com.upuphone.runasone.io.engine.mailbox.PriorityMailbox$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$upuphone$runasone$io$engine$message$PriorityType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.upuphone.runasone.io.engine.message.PriorityType[] r0 = com.upuphone.runasone.io.engine.message.PriorityType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$upuphone$runasone$io$engine$message$PriorityType = r0
                com.upuphone.runasone.io.engine.message.PriorityType r1 = com.upuphone.runasone.io.engine.message.PriorityType.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$upuphone$runasone$io$engine$message$PriorityType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.upuphone.runasone.io.engine.message.PriorityType r1 = com.upuphone.runasone.io.engine.message.PriorityType.HIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.io.engine.mailbox.PriorityMailbox.AnonymousClass1.<clinit>():void");
        }
    }

    public PriorityMailbox() {
        this(32);
    }

    public void clear() {
        this.lowMailbox.clear();
        this.middleMailbox.clear();
        this.hightMailbox.clear();
    }

    public boolean isEmpty() {
        return this.hightMailbox.isEmpty() && this.middleMailbox.isEmpty() && this.lowMailbox.isEmpty();
    }

    public void offer(Message message) {
        PriorityType priority;
        PriorityType priorityType = PriorityType.LOW;
        if ((message instanceof PriorityMessage) && (priority = ((PriorityMessage) message).getPriority()) != null) {
            priorityType = priority;
        }
        int i = AnonymousClass1.$SwitchMap$com$upuphone$runasone$io$engine$message$PriorityType[priorityType.ordinal()];
        if (i == 1) {
            this.lowMailbox.offer(message);
        } else if (i != 2) {
            this.middleMailbox.offer(message);
        } else {
            this.hightMailbox.offer(message);
        }
    }

    public Message poll() {
        if (this.hightMailbox.size() > 0) {
            return this.hightMailbox.poll();
        }
        if (this.middleMailbox.size() > 0) {
            return this.middleMailbox.poll();
        }
        if (this.lowMailbox.size() > 0) {
            return this.lowMailbox.poll();
        }
        return null;
    }

    public int size() {
        return this.lowMailbox.size() + this.middleMailbox.size() + this.hightMailbox.size();
    }

    public PriorityMailbox(int i) {
        this.lowMailbox = new ArrayDeque<>(i);
        this.middleMailbox = new ArrayDeque<>(i);
        this.hightMailbox = new ArrayDeque<>(i);
    }
}
