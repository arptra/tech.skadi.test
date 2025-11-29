package androidx.core.text.util;

import androidx.annotation.RestrictTo;
import java.util.regex.Pattern;

@RestrictTo
class FindAddress {

    /* renamed from: a  reason: collision with root package name */
    public static final ZipRange[] f830a;
    public static final Pattern b = Pattern.compile("[^,*•\t                　\n\u000b\f\r  ]+(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);
    public static final Pattern c = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t                　\n\u000b\f\r  ]|$)", 2);
    public static final Pattern d = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t                　]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t                　]+of[\t                　]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t                　]+states[\t                　]+of[\t                　]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t                　]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t                　]+mariana[\t                　]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t                　]+carolina)|(nd|north[\t                　]+dakota)|(ne|nebraska)|(nh|new[\t                　]+hampshire)|(nj|new[\t                　]+jersey)|(nm|new[\t                　]+mexico)|(nv|nevada)|(ny|new[\t                　]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t                　]+rico)|(pw|palau)|(ri|rhode[\t                　]+island)|(sc|south[\t                　]+carolina)|(sd|south[\t                　]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t                　]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t                　]+virginia)|(wy|wyoming))(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);
    public static final Pattern e = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);
    public static final Pattern f = Pattern.compile("([0-9]+)(st|nd|rd|th)", 2);
    public static final Pattern g = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);

    public static class ZipRange {

        /* renamed from: a  reason: collision with root package name */
        public int f831a;
        public int b;
        public int c;
        public int d;

        public ZipRange(int i, int i2, int i3, int i4) {
            this.f831a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    static {
        ZipRange zipRange = r1;
        ZipRange zipRange2 = new ZipRange(99, 99, -1, -1);
        ZipRange zipRange3 = r2;
        ZipRange zipRange4 = new ZipRange(35, 36, -1, -1);
        ZipRange zipRange5 = r3;
        ZipRange zipRange6 = new ZipRange(71, 72, -1, -1);
        ZipRange zipRange7 = r4;
        ZipRange zipRange8 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange9 = r5;
        ZipRange zipRange10 = new ZipRange(85, 86, -1, -1);
        ZipRange zipRange11 = r6;
        ZipRange zipRange12 = new ZipRange(90, 96, -1, -1);
        ZipRange zipRange13 = r7;
        ZipRange zipRange14 = new ZipRange(80, 81, -1, -1);
        ZipRange zipRange15 = r8;
        ZipRange zipRange16 = new ZipRange(6, 6, -1, -1);
        ZipRange zipRange17 = r9;
        ZipRange zipRange18 = new ZipRange(20, 20, -1, -1);
        ZipRange zipRange19 = zipRange;
        ZipRange zipRange20 = new ZipRange(19, 19, -1, -1);
        ZipRange zipRange21 = new ZipRange(32, 34, -1, -1);
        ZipRange zipRange22 = r12;
        ZipRange zipRange23 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange24 = new ZipRange(30, 31, -1, -1);
        ZipRange zipRange25 = r0;
        ZipRange zipRange26 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange27 = r0;
        ZipRange zipRange28 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange29 = r0;
        ZipRange zipRange30 = new ZipRange(50, 52, -1, -1);
        ZipRange zipRange31 = r0;
        ZipRange zipRange32 = new ZipRange(83, 83, -1, -1);
        ZipRange zipRange33 = r0;
        ZipRange zipRange34 = new ZipRange(60, 62, -1, -1);
        ZipRange zipRange35 = r0;
        ZipRange zipRange36 = new ZipRange(46, 47, -1, -1);
        ZipRange zipRange37 = r0;
        ZipRange zipRange38 = new ZipRange(66, 67, 73, -1);
        ZipRange zipRange39 = r0;
        ZipRange zipRange40 = new ZipRange(40, 42, -1, -1);
        ZipRange zipRange41 = r0;
        ZipRange zipRange42 = new ZipRange(70, 71, -1, -1);
        ZipRange zipRange43 = r0;
        ZipRange zipRange44 = new ZipRange(1, 2, -1, -1);
        ZipRange zipRange45 = r0;
        ZipRange zipRange46 = new ZipRange(20, 21, -1, -1);
        ZipRange zipRange47 = r0;
        ZipRange zipRange48 = new ZipRange(3, 4, -1, -1);
        ZipRange zipRange49 = r0;
        ZipRange zipRange50 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange51 = r0;
        ZipRange zipRange52 = new ZipRange(48, 49, -1, -1);
        ZipRange zipRange53 = r0;
        ZipRange zipRange54 = new ZipRange(55, 56, -1, -1);
        ZipRange zipRange55 = r0;
        ZipRange zipRange56 = new ZipRange(63, 65, -1, -1);
        ZipRange zipRange57 = r0;
        ZipRange zipRange58 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange59 = r0;
        ZipRange zipRange60 = new ZipRange(38, 39, -1, -1);
        ZipRange zipRange61 = r0;
        ZipRange zipRange62 = new ZipRange(55, 56, -1, -1);
        ZipRange zipRange63 = r0;
        ZipRange zipRange64 = new ZipRange(27, 28, -1, -1);
        ZipRange zipRange65 = r0;
        ZipRange zipRange66 = new ZipRange(58, 58, -1, -1);
        ZipRange zipRange67 = r0;
        ZipRange zipRange68 = new ZipRange(68, 69, -1, -1);
        ZipRange zipRange69 = r0;
        ZipRange zipRange70 = new ZipRange(3, 4, -1, -1);
        ZipRange zipRange71 = r0;
        ZipRange zipRange72 = new ZipRange(7, 8, -1, -1);
        ZipRange zipRange73 = r0;
        ZipRange zipRange74 = new ZipRange(87, 88, 86, -1);
        ZipRange zipRange75 = r0;
        ZipRange zipRange76 = new ZipRange(88, 89, 96, -1);
        ZipRange zipRange77 = r0;
        ZipRange zipRange78 = new ZipRange(10, 14, 0, 6);
        ZipRange zipRange79 = r0;
        ZipRange zipRange80 = new ZipRange(43, 45, -1, -1);
        ZipRange zipRange81 = r0;
        ZipRange zipRange82 = new ZipRange(73, 74, -1, -1);
        ZipRange zipRange83 = r0;
        ZipRange zipRange84 = new ZipRange(97, 97, -1, -1);
        ZipRange zipRange85 = r0;
        ZipRange zipRange86 = new ZipRange(15, 19, -1, -1);
        ZipRange zipRange87 = r0;
        ZipRange zipRange88 = new ZipRange(6, 6, 0, 9);
        ZipRange zipRange89 = r0;
        ZipRange zipRange90 = new ZipRange(96, 96, -1, -1);
        ZipRange zipRange91 = r0;
        ZipRange zipRange92 = new ZipRange(2, 2, -1, -1);
        ZipRange zipRange93 = r0;
        ZipRange zipRange94 = new ZipRange(29, 29, -1, -1);
        ZipRange zipRange95 = r0;
        ZipRange zipRange96 = new ZipRange(57, 57, -1, -1);
        ZipRange zipRange97 = r0;
        ZipRange zipRange98 = new ZipRange(37, 38, -1, -1);
        ZipRange zipRange99 = r0;
        ZipRange zipRange100 = new ZipRange(75, 79, 87, 88);
        ZipRange zipRange101 = r0;
        ZipRange zipRange102 = new ZipRange(84, 84, -1, -1);
        ZipRange zipRange103 = r0;
        ZipRange zipRange104 = new ZipRange(22, 24, 20, -1);
        ZipRange zipRange105 = r0;
        ZipRange zipRange106 = new ZipRange(6, 9, -1, -1);
        ZipRange zipRange107 = r0;
        ZipRange zipRange108 = new ZipRange(5, 5, -1, -1);
        ZipRange zipRange109 = r0;
        ZipRange zipRange110 = new ZipRange(98, 99, -1, -1);
        ZipRange zipRange111 = r0;
        ZipRange zipRange112 = new ZipRange(53, 54, -1, -1);
        ZipRange zipRange113 = r0;
        ZipRange zipRange114 = new ZipRange(24, 26, -1, -1);
        ZipRange zipRange115 = r0;
        ZipRange zipRange116 = new ZipRange(82, 83, -1, -1);
        f830a = new ZipRange[]{zipRange19, zipRange3, zipRange5, zipRange7, zipRange9, zipRange11, zipRange13, zipRange15, zipRange17, zipRange20, zipRange21, zipRange22, zipRange24, zipRange25, zipRange27, zipRange29, zipRange31, zipRange33, zipRange35, zipRange37, zipRange39, zipRange41, zipRange43, zipRange45, zipRange47, zipRange49, zipRange51, zipRange53, zipRange55, zipRange57, zipRange59, zipRange61, zipRange63, zipRange65, zipRange67, zipRange69, zipRange71, zipRange73, zipRange75, zipRange77, zipRange79, zipRange81, zipRange83, zipRange85, zipRange87, zipRange89, zipRange91, zipRange93, zipRange95, zipRange97, zipRange99, zipRange101, zipRange103, zipRange105, zipRange107, zipRange109, zipRange111, zipRange113, zipRange115};
    }
}
