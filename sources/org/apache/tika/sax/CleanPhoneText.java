package org.apache.tika.sax;

import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanPhoneText {

    /* renamed from: a  reason: collision with root package name */
    public static final String[][][] f3318a;

    static {
        String str = "fifteen";
        String str2 = "nineteen";
        String[][] strArr = {new String[]{"oh", "0"}, new String[]{"o", "0"}, new String[]{ProtocolVersions.PROTOCOL_KEY_IDENTIFIER, "1"}, new String[]{"l", "1"}};
        String[][] strArr2 = {new String[]{"&#\\d{1,3};", ""}};
        String[][] strArr3 = {new String[]{"th0usand", "thousand"}, new String[]{"th1rteen", "thirteen"}, new String[]{"f0urteen", "fourteen"}, new String[]{"e1ghteen", "eighteen"}, new String[]{"n1neteen", "nineteen"}, new String[]{"f1fteen", "fifteen"}, new String[]{"s1xteen", "sixteen"}, new String[]{"th1rty", "thirty"}, new String[]{"e1ghty", "eighty"}, new String[]{"n1nety", "ninety"}, new String[]{"fourty", "forty"}, new String[]{"f0urty", "forty"}, new String[]{"e1ght", "eight"}, new String[]{"f0rty", "forty"}, new String[]{"f1fty", "fifty"}, new String[]{"s1xty", "sixty"}, new String[]{"zer0", "zero"}, new String[]{"f0ur", "four"}, new String[]{"f1ve", "five"}, new String[]{"n1ne", "nine"}, new String[]{"0ne", "one"}, new String[]{"tw0", "two"}, new String[]{"s1x", "six"}};
        f3318a = new String[][][]{strArr2, strArr3, new String[][]{new String[]{"twenty[\\W_]{0,3}1", "twenty-one"}, new String[]{"twenty[\\W_]{0,3}2", "twenty-two"}, new String[]{"twenty[\\W_]{0,3}3", "twenty-three"}, new String[]{"twenty[\\W_]{0,3}4", "twenty-four"}, new String[]{"twenty[\\W_]{0,3}5", "twenty-five"}, new String[]{"twenty[\\W_]{0,3}6", "twenty-six"}, new String[]{"twenty[\\W_]{0,3}7", "twenty-seven"}, new String[]{"twenty[\\W_]{0,3}8", "twenty-eight"}, new String[]{"twenty[\\W_]{0,3}9", "twenty-nine"}, new String[]{"thirty[\\W_]{0,3}1", "thirty-one"}, new String[]{"thirty[\\W_]{0,3}2", "thirty-two"}, new String[]{"thirty[\\W_]{0,3}3", "thirty-three"}, new String[]{"thirty[\\W_]{0,3}4", "thirty-four"}, new String[]{"thirty[\\W_]{0,3}5", "thirty-five"}, new String[]{"thirty[\\W_]{0,3}6", "thirty-six"}, new String[]{"thirty[\\W_]{0,3}7", "thirty-seven"}, new String[]{"thirty[\\W_]{0,3}8", "thirty-eight"}, new String[]{"thirty[\\W_]{0,3}9", "thirty-nine"}, new String[]{"forty[\\W_]{0,3}1", "forty-one"}, new String[]{"forty[\\W_]{0,3}2", "forty-two"}, new String[]{"forty[\\W_]{0,3}3", "forty-three"}, new String[]{"forty[\\W_]{0,3}4", "forty-four"}, new String[]{"forty[\\W_]{0,3}5", "forty-five"}, new String[]{"forty[\\W_]{0,3}6", "forty-six"}, new String[]{"forty[\\W_]{0,3}7", "forty-seven"}, new String[]{"forty[\\W_]{0,3}8", "forty-eight"}, new String[]{"forty[\\W_]{0,3}9", "forty-nine"}, new String[]{"fifty[\\W_]{0,3}1", "fifty-one"}, new String[]{"fifty[\\W_]{0,3}2", "fifty-two"}, new String[]{"fifty[\\W_]{0,3}3", "fifty-three"}, new String[]{"fifty[\\W_]{0,3}4", "fifty-four"}, new String[]{"fifty[\\W_]{0,3}5", "fifty-five"}, new String[]{"fifty[\\W_]{0,3}6", "fifty-six"}, new String[]{"fifty[\\W_]{0,3}7", "fifty-seven"}, new String[]{"fifty[\\W_]{0,3}8", "fifty-eight"}, new String[]{"fifty[\\W_]{0,3}9", "fifty-nine"}, new String[]{"sixty[\\W_]{0,3}1", "sixty-one"}, new String[]{"sixty[\\W_]{0,3}2", "sixty-two"}, new String[]{"sixty[\\W_]{0,3}3", "sixty-three"}, new String[]{"sixty[\\W_]{0,3}4", "sixty-four"}, new String[]{"sixty[\\W_]{0,3}5", "sixty-five"}, new String[]{"sixty[\\W_]{0,3}6", "sixty-six"}, new String[]{"sixty[\\W_]{0,3}7", "sixty-seven"}, new String[]{"sixty[\\W_]{0,3}8", "sixty-eight"}, new String[]{"sixty[\\W_]{0,3}9", "sixty-nine"}, new String[]{"seventy[\\W_]{0,3}1", "seventy-one"}, new String[]{"seventy[\\W_]{0,3}2", "seventy-two"}, new String[]{"seventy[\\W_]{0,3}3", "seventy-three"}, new String[]{"seventy[\\W_]{0,3}4", "seventy-four"}, new String[]{"seventy[\\W_]{0,3}5", "seventy-five"}, new String[]{"seventy[\\W_]{0,3}6", "seventy-six"}, new String[]{"seventy[\\W_]{0,3}7", "seventy-seven"}, new String[]{"seventy[\\W_]{0,3}8", "seventy-eight"}, new String[]{"seventy[\\W_]{0,3}9", "seventy-nine"}, new String[]{"eighty[\\W_]{0,3}1", "eighty-one"}, new String[]{"eighty[\\W_]{0,3}2", "eighty-two"}, new String[]{"eighty[\\W_]{0,3}3", "eighty-three"}, new String[]{"eighty[\\W_]{0,3}4", "eighty-four"}, new String[]{"eighty[\\W_]{0,3}5", "eighty-five"}, new String[]{"eighty[\\W_]{0,3}6", "eighty-six"}, new String[]{"eighty[\\W_]{0,3}7", "eighty-seven"}, new String[]{"eighty[\\W_]{0,3}8", "eighty-eight"}, new String[]{"eighty[\\W_]{0,3}9", "eighty-nine"}, new String[]{"ninety[\\W_]{0,3}1", "ninety-one"}, new String[]{"ninety[\\W_]{0,3}2", "ninety-two"}, new String[]{"ninety[\\W_]{0,3}3", "ninety-three"}, new String[]{"ninety[\\W_]{0,3}4", "ninety-four"}, new String[]{"ninety[\\W_]{0,3}5", "ninety-five"}, new String[]{"ninety[\\W_]{0,3}6", "ninety-six"}, new String[]{"ninety[\\W_]{0,3}7", "ninety-seven"}, new String[]{"ninety[\\W_]{0,3}8", "ninety-eight"}, new String[]{"ninety[\\W_]{0,3}9", "ninety-nine"}}, new String[][]{new String[]{"twenty-one", "21"}, new String[]{"twenty-two", "22"}, new String[]{"twenty-three", "23"}, new String[]{"twenty-four", "24"}, new String[]{"twenty-five", "25"}, new String[]{"twenty-six", "26"}, new String[]{"twenty-seven", "27"}, new String[]{"twenty-eight", "28"}, new String[]{"twenty-nine", "29"}, new String[]{"thirty-one", "31"}, new String[]{"thirty-two", "32"}, new String[]{"thirty-three", "33"}, new String[]{"thirty-four", "34"}, new String[]{"thirty-five", "35"}, new String[]{"thirty-six", "36"}, new String[]{"thirty-seven", "37"}, new String[]{"thirty-eight", "38"}, new String[]{"thirty-nine", "39"}, new String[]{"forty-one", "41"}, new String[]{"forty-two", "42"}, new String[]{"forty-three", "43"}, new String[]{"forty-four", "44"}, new String[]{"forty-five", "45"}, new String[]{"forty-six", "46"}, new String[]{"forty-seven", "47"}, new String[]{"forty-eight", "48"}, new String[]{"forty-nine", "49"}, new String[]{"fifty-one", "51"}, new String[]{"fifty-two", "52"}, new String[]{"fifty-three", "53"}, new String[]{"fifty-four", "54"}, new String[]{"fifty-five", "55"}, new String[]{"fifty-six", "56"}, new String[]{"fifty-seven", "57"}, new String[]{"fifty-eight", "58"}, new String[]{"fifty-nine", "59"}, new String[]{"sixty-one", "61"}, new String[]{"sixty-two", "62"}, new String[]{"sixty-three", "63"}, new String[]{"sixty-four", "64"}, new String[]{"sixty-five", "65"}, new String[]{"sixty-six", "66"}, new String[]{"sixty-seven", "67"}, new String[]{"sixty-eight", "68"}, new String[]{"sixty-nine", "69"}, new String[]{"seventy-one", "71"}, new String[]{"seventy-two", "72"}, new String[]{"seventy-three", "73"}, new String[]{"seventy-four", "74"}, new String[]{"seventy-five", "75"}, new String[]{"seventy-six", "76"}, new String[]{"seventy-seven", "77"}, new String[]{"seventy-eight", "78"}, new String[]{"seventy-nine", "79"}, new String[]{"eighty-one", "81"}, new String[]{"eighty-two", "82"}, new String[]{"eighty-three", "83"}, new String[]{"eighty-four", "84"}, new String[]{"eighty-five", "85"}, new String[]{"eighty-six", "86"}, new String[]{"eighty-seven", "87"}, new String[]{"eighty-eight", "88"}, new String[]{"eighty-nine", "89"}, new String[]{"ninety-one", "91"}, new String[]{"ninety-two", "92"}, new String[]{"ninety-three", "93"}, new String[]{"ninety-four", "94"}, new String[]{"ninety-five", "95"}, new String[]{"ninety-six", "96"}, new String[]{"ninety-seven", "97"}, new String[]{"ninety-eight", "98"}, new String[]{"ninety-nine", "99"}}, new String[][]{new String[]{"hundred", "00"}, new String[]{"thousand", "000"}}, new String[][]{new String[]{"seventeen", "17"}, new String[]{"thirteen", "13"}, new String[]{"fourteen", "14"}, new String[]{"eighteen", "18"}, new String[]{str2, "19"}, new String[]{str, "15"}, new String[]{"sixteen", "16"}, new String[]{"seventy", "70"}, new String[]{"eleven", "11"}, new String[]{"twelve", "12"}, new String[]{"twenty", "20"}, new String[]{"thirty", "30"}, new String[]{"eighty", "80"}, new String[]{"ninety", "90"}, new String[]{"three", "3"}, new String[]{"seven", "7"}, new String[]{"eight", "8"}, new String[]{"forty", "40"}, new String[]{"fifty", "50"}, new String[]{"sixty", "60"}, new String[]{"zero", "0"}, new String[]{"four", "4"}, new String[]{"five", "5"}, new String[]{"nine", "9"}, new String[]{"one", "1"}, new String[]{"two", "2"}, new String[]{"six", "6"}, new String[]{"ten", "10"}}, strArr};
    }

    public static String a(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        for (String[][] strArr : f3318a) {
            for (String[] strArr2 : r0[r3]) {
                lowerCase = lowerCase.replaceAll(strArr2[0], strArr2[1]);
            }
        }
        return lowerCase.replaceAll("[\\D+\\s]", "");
    }

    public static ArrayList b(String str) {
        String a2 = a(str);
        Matcher matcher = Pattern.compile("([2-9]\\d{2}[2-9]\\d{6})").matcher(a2);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (matcher.find(i)) {
            String group = matcher.group(1);
            int start = matcher.start(1);
            int end = matcher.end(1);
            String substring = start > 0 ? a2.substring(start - 1, start) : "";
            if (!group.startsWith("82") || !substring.equals("*")) {
                arrayList.add(group);
                i = end;
            } else {
                i += 2;
            }
        }
        return arrayList;
    }
}
