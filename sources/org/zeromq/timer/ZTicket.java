package org.zeromq.timer;

public final class ZTicket {

    public static final class Ticket implements Comparable<Ticket> {

        /* renamed from: a  reason: collision with root package name */
        public long f3517a;
        public long b;
        public boolean c;

        /* renamed from: a */
        public int compareTo(Ticket ticket) {
            if (!this.c) {
                return ticket.c ? 1 : 0;
            }
            if (ticket.c) {
                return Long.valueOf(this.f3517a - ticket.f3517a).compareTo(Long.valueOf(ticket.b - this.b));
            }
            return -1;
        }
    }
}
