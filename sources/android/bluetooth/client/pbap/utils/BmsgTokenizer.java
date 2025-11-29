package android.bluetooth.client.pbap.utils;

import com.honey.account.constant.AccountConstantKt;
import java.util.Objects;

public final class BmsgTokenizer {

    public static class Property {

        /* renamed from: a  reason: collision with root package name */
        public final String f81a;
        public final String b;

        public boolean equals(Object obj) {
            if (obj instanceof Property) {
                Property property = (Property) obj;
                return property.f81a.equals(this.f81a) && property.b.equals(this.b);
            }
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f81a, this.b});
        }

        public String toString() {
            return this.f81a + AccountConstantKt.CODE_SEPARTOR + this.b;
        }
    }
}
