package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.ParseException;

class PinyinRomanizationTranslator {
    public static String convertRomanizationSystem(String str, PinyinRomanizationType pinyinRomanizationType, PinyinRomanizationType pinyinRomanizationType2) {
        String extractPinyinString = TextHelper.extractPinyinString(str);
        String extractToneNumber = TextHelper.extractToneNumber(str);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("//");
            stringBuffer.append(pinyinRomanizationType.getTagName());
            stringBuffer.append("[text()='");
            stringBuffer.append(extractPinyinString);
            stringBuffer.append("']");
            Element xpathSelectElement = PinyinRomanizationResource.getInstance().getPinyinMappingDoc().xpathSelectElement(stringBuffer.toString());
            if (xpathSelectElement == null) {
                return null;
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("../");
            stringBuffer2.append(pinyinRomanizationType2.getTagName());
            stringBuffer2.append("/text()");
            String xpathSelectString = xpathSelectElement.xpathSelectString(stringBuffer2.toString());
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(xpathSelectString);
            stringBuffer3.append(extractToneNumber);
            return stringBuffer3.toString();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
