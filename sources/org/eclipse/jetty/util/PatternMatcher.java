package org.eclipse.jetty.util;

import com.meizu.common.widget.MzContactsContract;
import java.net.URI;
import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class PatternMatcher {
    public void match(Pattern pattern, URI[] uriArr, boolean z) throws Exception {
        if (uriArr != null) {
            String[] split = pattern == null ? null : pattern.pattern().split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            ArrayList<Pattern> arrayList = new ArrayList<>();
            int i = 0;
            while (split != null && i < split.length) {
                arrayList.add(Pattern.compile(split[i]));
                i++;
            }
            if (arrayList.isEmpty()) {
                arrayList.add(pattern);
            }
            if (arrayList.isEmpty()) {
                matchPatterns((Pattern) null, uriArr, z);
                return;
            }
            for (Pattern matchPatterns : arrayList) {
                matchPatterns(matchPatterns, uriArr, z);
            }
        }
    }

    public void matchPatterns(Pattern pattern, URI[] uriArr, boolean z) throws Exception {
        for (int i = 0; i < uriArr.length; i++) {
            String uri = uriArr[i].toString();
            if ((pattern == null && z) || (pattern != null && pattern.matcher(uri).matches())) {
                matched(uriArr[i]);
            }
        }
    }

    public abstract void matched(URI uri) throws Exception;
}
