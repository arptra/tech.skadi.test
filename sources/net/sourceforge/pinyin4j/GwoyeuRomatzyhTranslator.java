package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.ParseException;

class GwoyeuRomatzyhTranslator {
    private static String[] tones = {"_I", "_II", "_III", "_IV", "_V"};

    public static String convertHanyuPinyinToGwoyeuRomatzyh(String str) {
        String extractPinyinString = TextHelper.extractPinyinString(str);
        String extractToneNumber = TextHelper.extractToneNumber(str);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("//");
            stringBuffer.append(PinyinRomanizationType.HANYU_PINYIN.getTagName());
            stringBuffer.append("[text()='");
            stringBuffer.append(extractPinyinString);
            stringBuffer.append("']");
            Element xpathSelectElement = GwoyeuRomatzyhResource.getInstance().getPinyinToGwoyeuMappingDoc().xpathSelectElement(stringBuffer.toString());
            if (xpathSelectElement == null) {
                return null;
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("../");
            stringBuffer2.append(PinyinRomanizationType.GWOYEU_ROMATZYH.getTagName());
            stringBuffer2.append(tones[Integer.parseInt(extractToneNumber) - 1]);
            stringBuffer2.append("/text()");
            return xpathSelectElement.xpathSelectString(stringBuffer2.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
