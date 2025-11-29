package org.apache.commons.io.input;

import com.honey.account.vb.c;
import java.io.Reader;
import java.util.function.IntPredicate;

public class CharacterFilterReader extends AbstractCharacterFilterReader {
    public CharacterFilterReader(Reader reader, int i) {
        super(reader, new c(i));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(int i, int i2) {
        return i2 == i;
    }

    public CharacterFilterReader(Reader reader, IntPredicate intPredicate) {
        super(reader, intPredicate);
    }
}
