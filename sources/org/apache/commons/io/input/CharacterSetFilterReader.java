package org.apache.commons.io.input;

import com.honey.account.vb.d;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntPredicate;

public class CharacterSetFilterReader extends AbstractCharacterFilterReader {
    public CharacterSetFilterReader(Reader reader, Integer... numArr) {
        this(reader, (Set<Integer>) new HashSet(Arrays.asList(numArr)));
    }

    private static IntPredicate toIntPredicate(Set<Integer> set) {
        return set == null ? AbstractCharacterFilterReader.SKIP_NONE : new d(Collections.unmodifiableSet(set));
    }

    public CharacterSetFilterReader(Reader reader, Set<Integer> set) {
        super(reader, toIntPredicate(set));
    }
}
