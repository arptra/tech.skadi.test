package io.flutter.embedding.engine.systemchannels;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.android.gms.common.Scopes;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import com.meizu.common.datetimepicker.date.MonthView;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.editing.TextEditingDelta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TextInputChannel {
    private static final String TAG = "TextInputChannel";
    @NonNull
    public final MethodChannel channel;
    @VisibleForTesting
    @NonNull
    final MethodChannel.MethodCallHandler parsingMethodHandler;
    /* access modifiers changed from: private */
    @Nullable
    public TextInputMethodHandler textInputMethodHandler;

    public static class Configuration {
        @Nullable
        public final String actionLabel;
        public final boolean autocorrect;
        @Nullable
        public final Autofill autofill;
        @Nullable
        public final String[] contentCommitMimeTypes;
        public final boolean enableDeltaModel;
        public final boolean enableIMEPersonalizedLearning;
        public final boolean enableSuggestions;
        @Nullable
        public final Configuration[] fields;
        @Nullable
        public final Integer inputAction;
        @NonNull
        public final InputType inputType;
        public final boolean obscureText;
        @NonNull
        public final TextCapitalization textCapitalization;

        public static class Autofill {
            public final TextEditState editState;
            public final String hintText;
            public final String[] hints;
            public final String uniqueIdentifier;

            public Autofill(@NonNull String str, @NonNull String[] strArr, @Nullable String str2, @NonNull TextEditState textEditState) {
                this.uniqueIdentifier = str;
                this.hints = strArr;
                this.hintText = str2;
                this.editState = textEditState;
            }

            @NonNull
            public static Autofill fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    strArr[i] = translateAutofillHint(jSONArray.getString(i));
                }
                return new Autofill(string, strArr, string2, TextEditState.fromJson(jSONObject2));
            }

            @NonNull
            private static String translateAutofillHint(@NonNull String str) {
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case -2058889126:
                        if (str.equals("birthdayYear")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1917283616:
                        if (str.equals("oneTimeCode")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1844815832:
                        if (str.equals("creditCardExpirationMonth")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1825589953:
                        if (str.equals("telephoneNumberNational")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1821235109:
                        if (str.equals("newPassword")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1757573738:
                        if (str.equals("creditCardSecurityCode")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -1682373820:
                        if (str.equals("creditCardExpirationDay")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -1658955742:
                        if (str.equals("fullStreetAddress")) {
                            c = 7;
                            break;
                        }
                        break;
                    case -1567118045:
                        if (str.equals("telephoneNumberDevice")) {
                            c = 8;
                            break;
                        }
                        break;
                    case -1476752575:
                        if (str.equals("countryName")) {
                            c = 9;
                            break;
                        }
                        break;
                    case -1413737489:
                        if (str.equals("middleInitial")) {
                            c = 10;
                            break;
                        }
                        break;
                    case -1377792129:
                        if (str.equals("addressCity")) {
                            c = 11;
                            break;
                        }
                        break;
                    case -1249512767:
                        if (str.equals("gender")) {
                            c = 12;
                            break;
                        }
                        break;
                    case -1186060294:
                        if (str.equals("postalAddressExtendedPostalCode")) {
                            c = 13;
                            break;
                        }
                        break;
                    case -1151034798:
                        if (str.equals("creditCardNumber")) {
                            c = 14;
                            break;
                        }
                        break;
                    case -835992323:
                        if (str.equals("namePrefix")) {
                            c = 15;
                            break;
                        }
                        break;
                    case -818219584:
                        if (str.equals("middleName")) {
                            c = 16;
                            break;
                        }
                        break;
                    case -747304516:
                        if (str.equals("nameSuffix")) {
                            c = 17;
                            break;
                        }
                        break;
                    case -613980922:
                        if (str.equals("creditCardExpirationDate")) {
                            c = 18;
                            break;
                        }
                        break;
                    case -613352043:
                        if (str.equals("creditCardExpirationYear")) {
                            c = 19;
                            break;
                        }
                        break;
                    case -549230602:
                        if (str.equals("telephoneNumberCountryCode")) {
                            c = 20;
                            break;
                        }
                        break;
                    case -265713450:
                        if (str.equals("username")) {
                            c = 21;
                            break;
                        }
                        break;
                    case 3373707:
                        if (str.equals("name")) {
                            c = 22;
                            break;
                        }
                        break;
                    case 96619420:
                        if (str.equals(Scopes.EMAIL)) {
                            c = 23;
                            break;
                        }
                        break;
                    case 253202685:
                        if (str.equals("addressState")) {
                            c = 24;
                            break;
                        }
                        break;
                    case 588174851:
                        if (str.equals("birthdayMonth")) {
                            c = 25;
                            break;
                        }
                        break;
                    case 798554127:
                        if (str.equals("familyName")) {
                            c = JSONLexer.EOI;
                            break;
                        }
                        break;
                    case 892233837:
                        if (str.equals("telephoneNumber")) {
                            c = 27;
                            break;
                        }
                        break;
                    case 991032982:
                        if (str.equals("newUsername")) {
                            c = 28;
                            break;
                        }
                        break;
                    case 1069376125:
                        if (str.equals("birthday")) {
                            c = 29;
                            break;
                        }
                        break;
                    case 1216985755:
                        if (str.equals(AccountConstantKt.INTENT_PARAM_PASSWORD)) {
                            c = 30;
                            break;
                        }
                        break;
                    case 1469046696:
                        if (str.equals("givenName")) {
                            c = 31;
                            break;
                        }
                        break;
                    case 1662667945:
                        if (str.equals("postalAddress")) {
                            c = ' ';
                            break;
                        }
                        break;
                    case 1921869058:
                        if (str.equals("postalAddressExtended")) {
                            c = '!';
                            break;
                        }
                        break;
                    case 2011152728:
                        if (str.equals("postalCode")) {
                            c = '\"';
                            break;
                        }
                        break;
                    case 2011773919:
                        if (str.equals("birthdayDay")) {
                            c = '#';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        return "birthDateYear";
                    case 1:
                        return "smsOTPCode";
                    case 2:
                        return "creditCardExpirationMonth";
                    case 3:
                        return "phoneNational";
                    case 4:
                        return "newPassword";
                    case 5:
                        return "creditCardSecurityCode";
                    case 6:
                        return "creditCardExpirationDay";
                    case 7:
                        return "streetAddress";
                    case 8:
                        return "phoneNumberDevice";
                    case 9:
                        return "addressCountry";
                    case 10:
                        return "personMiddleInitial";
                    case 11:
                        return "addressLocality";
                    case 12:
                        return "gender";
                    case 13:
                        return "extendedPostalCode";
                    case 14:
                        return "creditCardNumber";
                    case 15:
                        return "personNamePrefix";
                    case 16:
                        return "personMiddleName";
                    case 17:
                        return "personNameSuffix";
                    case 18:
                        return "creditCardExpirationDate";
                    case 19:
                        return "creditCardExpirationYear";
                    case 20:
                        return "phoneCountryCode";
                    case 21:
                        return "username";
                    case 22:
                        return "personName";
                    case 23:
                        return "emailAddress";
                    case 24:
                        return "addressRegion";
                    case 25:
                        return "birthDateMonth";
                    case 26:
                        return "personFamilyName";
                    case 27:
                        return "phoneNumber";
                    case 28:
                        return "newUsername";
                    case 29:
                        return "birthDateFull";
                    case 30:
                        return AccountConstantKt.INTENT_PARAM_PASSWORD;
                    case 31:
                        return "personGivenName";
                    case ' ':
                        return "postalAddress";
                    case '!':
                        return "extendedAddress";
                    case '\"':
                        return "postalCode";
                    case '#':
                        return "birthDateDay";
                    default:
                        return str;
                }
            }
        }

        public Configuration(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @NonNull TextCapitalization textCapitalization2, @NonNull InputType inputType2, @Nullable Integer num, @Nullable String str, @Nullable Autofill autofill2, @Nullable String[] strArr, @Nullable Configuration[] configurationArr) {
            this.obscureText = z;
            this.autocorrect = z2;
            this.enableSuggestions = z3;
            this.enableIMEPersonalizedLearning = z4;
            this.enableDeltaModel = z5;
            this.textCapitalization = textCapitalization2;
            this.inputType = inputType2;
            this.inputAction = num;
            this.actionLabel = str;
            this.autofill = autofill2;
            this.contentCommitMimeTypes = strArr;
            this.fields = configurationArr;
        }

        @NonNull
        public static Configuration fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            Configuration[] configurationArr;
            JSONObject jSONObject2 = jSONObject;
            String string = jSONObject2.getString("inputAction");
            if (string != null) {
                Autofill autofill2 = null;
                if (!jSONObject2.isNull("fields")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("fields");
                    int length = jSONArray.length();
                    Configuration[] configurationArr2 = new Configuration[length];
                    for (int i = 0; i < length; i++) {
                        configurationArr2[i] = fromJson(jSONArray.getJSONObject(i));
                    }
                    configurationArr = configurationArr2;
                } else {
                    configurationArr = null;
                }
                Integer inputActionFromTextInputAction = inputActionFromTextInputAction(string);
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray2 = jSONObject2.isNull("contentCommitMimeTypes") ? null : jSONObject2.getJSONArray("contentCommitMimeTypes");
                if (jSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        arrayList.add(jSONArray2.optString(i2));
                    }
                }
                boolean optBoolean = jSONObject2.optBoolean("obscureText");
                boolean optBoolean2 = jSONObject2.optBoolean("autocorrect", true);
                boolean optBoolean3 = jSONObject2.optBoolean("enableSuggestions");
                boolean optBoolean4 = jSONObject2.optBoolean("enableIMEPersonalizedLearning");
                boolean optBoolean5 = jSONObject2.optBoolean("enableDeltaModel");
                TextCapitalization fromValue = TextCapitalization.fromValue(jSONObject2.getString("textCapitalization"));
                InputType fromJson = InputType.fromJson(jSONObject2.getJSONObject("inputType"));
                String string2 = jSONObject2.isNull("actionLabel") ? null : jSONObject2.getString("actionLabel");
                if (!jSONObject2.isNull("autofill")) {
                    autofill2 = Autofill.fromJson(jSONObject2.getJSONObject("autofill"));
                }
                return new Configuration(optBoolean, optBoolean2, optBoolean3, optBoolean4, optBoolean5, fromValue, fromJson, inputActionFromTextInputAction, string2, autofill2, (String[]) arrayList.toArray(new String[arrayList.size()]), configurationArr);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
            if (r12.equals("TextInputAction.done") == false) goto L_0x001b;
         */
        @androidx.annotation.NonNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.Integer inputActionFromTextInputAction(@androidx.annotation.NonNull java.lang.String r12) {
            /*
                r0 = 7
                r1 = 6
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r12.hashCode()
                r6 = 1
                java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
                r8 = 0
                java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
                r10 = -1
                int r11 = r12.hashCode()
                switch(r11) {
                    case -810971940: goto L_0x0076;
                    case -737377923: goto L_0x006d;
                    case -737089298: goto L_0x0062;
                    case -737080013: goto L_0x0057;
                    case -736940669: goto L_0x004c;
                    case 469250275: goto L_0x0041;
                    case 1241689507: goto L_0x0036;
                    case 1539450297: goto L_0x002b;
                    case 2110497650: goto L_0x001e;
                    default: goto L_0x001b;
                }
            L_0x001b:
                r6 = r10
                goto L_0x0080
            L_0x001e:
                java.lang.String r6 = "TextInputAction.previous"
                boolean r12 = r12.equals(r6)
                if (r12 != 0) goto L_0x0027
                goto L_0x001b
            L_0x0027:
                r6 = 8
                goto L_0x0080
            L_0x002b:
                java.lang.String r6 = "TextInputAction.newline"
                boolean r12 = r12.equals(r6)
                if (r12 != 0) goto L_0x0034
                goto L_0x001b
            L_0x0034:
                r6 = r0
                goto L_0x0080
            L_0x0036:
                java.lang.String r6 = "TextInputAction.go"
                boolean r12 = r12.equals(r6)
                if (r12 != 0) goto L_0x003f
                goto L_0x001b
            L_0x003f:
                r6 = r1
                goto L_0x0080
            L_0x0041:
                java.lang.String r6 = "TextInputAction.search"
                boolean r12 = r12.equals(r6)
                if (r12 != 0) goto L_0x004a
                goto L_0x001b
            L_0x004a:
                r6 = r2
                goto L_0x0080
            L_0x004c:
                java.lang.String r6 = "TextInputAction.send"
                boolean r12 = r12.equals(r6)
                if (r12 != 0) goto L_0x0055
                goto L_0x001b
            L_0x0055:
                r6 = r3
                goto L_0x0080
            L_0x0057:
                java.lang.String r6 = "TextInputAction.none"
                boolean r12 = r12.equals(r6)
                if (r12 != 0) goto L_0x0060
                goto L_0x001b
            L_0x0060:
                r6 = r4
                goto L_0x0080
            L_0x0062:
                java.lang.String r6 = "TextInputAction.next"
                boolean r12 = r12.equals(r6)
                if (r12 != 0) goto L_0x006b
                goto L_0x001b
            L_0x006b:
                r6 = r5
                goto L_0x0080
            L_0x006d:
                java.lang.String r8 = "TextInputAction.done"
                boolean r12 = r12.equals(r8)
                if (r12 != 0) goto L_0x0080
                goto L_0x001b
            L_0x0076:
                java.lang.String r6 = "TextInputAction.unspecified"
                boolean r12 = r12.equals(r6)
                if (r12 != 0) goto L_0x007f
                goto L_0x001b
            L_0x007f:
                r6 = r8
            L_0x0080:
                switch(r6) {
                    case 0: goto L_0x00a4;
                    case 1: goto L_0x009f;
                    case 2: goto L_0x009a;
                    case 3: goto L_0x0099;
                    case 4: goto L_0x0094;
                    case 5: goto L_0x008f;
                    case 6: goto L_0x008a;
                    case 7: goto L_0x0089;
                    case 8: goto L_0x0084;
                    default: goto L_0x0083;
                }
            L_0x0083:
                return r9
            L_0x0084:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r0)
                return r12
            L_0x0089:
                return r7
            L_0x008a:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
                return r12
            L_0x008f:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
                return r12
            L_0x0094:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
                return r12
            L_0x0099:
                return r7
            L_0x009a:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
                return r12
            L_0x009f:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                return r12
            L_0x00a4:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.inputActionFromTextInputAction(java.lang.String):java.lang.Integer");
        }
    }

    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;
        @NonNull
        public final TextInputType type;

        public InputType(@NonNull TextInputType textInputType, boolean z, boolean z2) {
            this.type = textInputType;
            this.isSigned = z;
            this.isDecimal = z2;
        }

        @NonNull
        public static InputType fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            return new InputType(TextInputType.fromValue(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        
        @NonNull
        private final String encodedName;

        private TextCapitalization(@NonNull String str) {
            this.encodedName = str;
        }

        public static TextCapitalization fromValue(@NonNull String str) throws NoSuchFieldException {
            for (TextCapitalization textCapitalization : values()) {
                if (textCapitalization.encodedName.equals(str)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    public static class TextEditState {
        public final int composingEnd;
        public final int composingStart;
        public final int selectionEnd;
        public final int selectionStart;
        @NonNull
        public final String text;

        public TextEditState(@NonNull String str, int i, int i2, int i3, int i4) throws IndexOutOfBoundsException {
            if (!(i == -1 && i2 == -1) && (i < 0 || i2 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i) + ", " + String.valueOf(i2) + ")");
            } else if (!(i3 == -1 && i4 == -1) && (i3 < 0 || i3 > i4)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i3) + ", " + String.valueOf(i4) + ")");
            } else if (i4 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i3));
            } else if (i > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i));
            } else if (i2 <= str.length()) {
                this.text = str;
                this.selectionStart = i;
                this.selectionEnd = i2;
                this.composingStart = i3;
                this.composingEnd = i4;
            } else {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i2));
            }
        }

        @NonNull
        public static TextEditState fromJson(@NonNull JSONObject jSONObject) throws JSONException {
            return new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean hasComposing() {
            int i = this.composingStart;
            return i >= 0 && this.composingEnd > i;
        }

        public boolean hasSelection() {
            return this.selectionStart >= 0;
        }
    }

    public interface TextInputMethodHandler {
        void clearClient();

        void finishAutofillContext(boolean z);

        void hide();

        void requestAutofill();

        void sendAppPrivateCommand(@NonNull String str, @NonNull Bundle bundle);

        void setClient(int i, @NonNull Configuration configuration);

        void setEditableSizeAndTransform(double d, double d2, @NonNull double[] dArr);

        void setEditingState(@NonNull TextEditState textEditState);

        void setPlatformViewClient(int i, boolean z);

        void show();
    }

    public enum TextInputType {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");
        
        @NonNull
        private final String encodedName;

        private TextInputType(@NonNull String str) {
            this.encodedName = str;
        }

        public static TextInputType fromValue(@NonNull String str) throws NoSuchFieldException {
            for (TextInputType textInputType : values()) {
                if (textInputType.encodedName.equals(str)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public TextInputChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Bundle bundle;
                MethodCall methodCall2 = methodCall;
                MethodChannel.Result result2 = result;
                if (TextInputChannel.this.textInputMethodHandler != null) {
                    String str = methodCall2.method;
                    Object obj = methodCall2.arguments;
                    Log.v(TextInputChannel.TAG, "Received '" + str + "' message.");
                    str.hashCode();
                    char c = 65535;
                    switch (str.hashCode()) {
                        case -1779068172:
                            if (str.equals("TextInput.setPlatformViewClient")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1015421462:
                            if (str.equals("TextInput.setEditingState")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -37561188:
                            if (str.equals("TextInput.setClient")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 270476819:
                            if (str.equals("TextInput.hide")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 270803918:
                            if (str.equals("TextInput.show")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 649192816:
                            if (str.equals("TextInput.sendAppPrivateCommand")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1204752139:
                            if (str.equals("TextInput.setEditableSizeAndTransform")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1727570905:
                            if (str.equals("TextInput.finishAutofillContext")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 1904427655:
                            if (str.equals("TextInput.clearClient")) {
                                c = 8;
                                break;
                            }
                            break;
                        case 2113369584:
                            if (str.equals("TextInput.requestAutofill")) {
                                c = 9;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            try {
                                JSONObject jSONObject = (JSONObject) obj;
                                TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                                result2.success((Object) null);
                                return;
                            } catch (JSONException e) {
                                result2.error("error", e.getMessage(), (Object) null);
                                return;
                            }
                        case 1:
                            try {
                                TextInputChannel.this.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) obj));
                                result2.success((Object) null);
                                return;
                            } catch (JSONException e2) {
                                result2.error("error", e2.getMessage(), (Object) null);
                                return;
                            }
                        case 2:
                            try {
                                JSONArray jSONArray = (JSONArray) obj;
                                TextInputChannel.this.textInputMethodHandler.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                                result2.success((Object) null);
                                return;
                            } catch (NoSuchFieldException | JSONException e3) {
                                result2.error("error", e3.getMessage(), (Object) null);
                                return;
                            }
                        case 3:
                            TextInputChannel.this.textInputMethodHandler.hide();
                            result2.success((Object) null);
                            return;
                        case 4:
                            TextInputChannel.this.textInputMethodHandler.show();
                            result2.success((Object) null);
                            return;
                        case 5:
                            try {
                                JSONObject jSONObject2 = (JSONObject) obj;
                                String string = jSONObject2.getString(WebJs.ACTION);
                                String string2 = jSONObject2.getString("data");
                                if (string2 == null || string2.isEmpty()) {
                                    bundle = null;
                                } else {
                                    bundle = new Bundle();
                                    bundle.putString("data", string2);
                                }
                                TextInputChannel.this.textInputMethodHandler.sendAppPrivateCommand(string, bundle);
                                result2.success((Object) null);
                                return;
                            } catch (JSONException e4) {
                                result2.error("error", e4.getMessage(), (Object) null);
                                return;
                            }
                        case 6:
                            try {
                                JSONObject jSONObject3 = (JSONObject) obj;
                                double d = jSONObject3.getDouble(MonthView.VIEW_PARAMS_WIDTH);
                                double d2 = jSONObject3.getDouble(MonthView.VIEW_PARAMS_HEIGHT);
                                JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                                double[] dArr = new double[16];
                                for (int i = 0; i < 16; i++) {
                                    dArr[i] = jSONArray2.getDouble(i);
                                }
                                TextInputChannel.this.textInputMethodHandler.setEditableSizeAndTransform(d, d2, dArr);
                                result2.success((Object) null);
                                return;
                            } catch (JSONException e5) {
                                result2.error("error", e5.getMessage(), (Object) null);
                                return;
                            }
                        case 7:
                            TextInputChannel.this.textInputMethodHandler.finishAutofillContext(((Boolean) obj).booleanValue());
                            result2.success((Object) null);
                            return;
                        case 8:
                            TextInputChannel.this.textInputMethodHandler.clearClient();
                            result2.success((Object) null);
                            return;
                        case 9:
                            TextInputChannel.this.textInputMethodHandler.requestAutofill();
                            result2.success((Object) null);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                }
            }
        };
        this.parsingMethodHandler = r0;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    private static HashMap<Object, Object> createEditingDeltaJSON(ArrayList<TextEditingDelta> arrayList) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<TextEditingDelta> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJSON());
        }
        hashMap.put("deltas", jSONArray);
        return hashMap;
    }

    private static HashMap<Object, Object> createEditingStateJSON(String str, int i, int i2, int i3, int i4) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i));
        hashMap.put("selectionExtent", Integer.valueOf(i2));
        hashMap.put("composingBase", Integer.valueOf(i3));
        hashMap.put("composingExtent", Integer.valueOf(i4));
        return hashMap;
    }

    public void commitContent(int i, Map<String, Object> map) {
        Log.v(TAG, "Sending 'commitContent' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Object[]{Integer.valueOf(i), "TextInputAction.commitContent", map}));
    }

    public void done(int i) {
        Log.v(TAG, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.done"}));
    }

    public void go(int i) {
        Log.v(TAG, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.go"}));
    }

    public void newline(int i) {
        Log.v(TAG, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.newline"}));
    }

    public void next(int i) {
        Log.v(TAG, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.next"}));
    }

    public void performPrivateCommand(int i, @NonNull String str, @NonNull Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(WebJs.ACTION, str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj instanceof byte[]) {
                    hashMap2.put(next, bundle.getByteArray(next));
                } else if (obj instanceof Byte) {
                    hashMap2.put(next, Byte.valueOf(bundle.getByte(next)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(next, bundle.getCharArray(next));
                } else if (obj instanceof Character) {
                    hashMap2.put(next, Character.valueOf(bundle.getChar(next)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(next, bundle.getCharSequenceArray(next));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(next, bundle.getCharSequence(next));
                } else if (obj instanceof float[]) {
                    hashMap2.put(next, bundle.getFloatArray(next));
                } else if (obj instanceof Float) {
                    hashMap2.put(next, Float.valueOf(bundle.getFloat(next)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(new Serializable[]{Integer.valueOf(i), hashMap}));
    }

    public void previous(int i) {
        Log.v(TAG, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.previous"}));
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", (Object) null);
    }

    public void search(int i) {
        Log.v(TAG, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.search"}));
    }

    public void send(int i) {
        Log.v(TAG, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.send"}));
    }

    public void setTextInputMethodHandler(@Nullable TextInputMethodHandler textInputMethodHandler2) {
        this.textInputMethodHandler = textInputMethodHandler2;
    }

    public void unspecifiedAction(int i) {
        Log.v(TAG, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i), "TextInputAction.unspecified"}));
    }

    public void updateEditingState(int i, @NonNull String str, int i2, int i3, int i4, int i5) {
        Log.v(TAG, "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i2 + "\nSelection end: " + i3 + "\nComposing start: " + i4 + "\nComposing end: " + i5);
        HashMap<Object, Object> createEditingStateJSON = createEditingStateJSON(str, i2, i3, i4, i5);
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(new Serializable[]{Integer.valueOf(i), createEditingStateJSON}));
    }

    public void updateEditingStateWithDeltas(int i, @NonNull ArrayList<TextEditingDelta> arrayList) {
        Log.v(TAG, "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        HashMap<Object, Object> createEditingDeltaJSON = createEditingDeltaJSON(arrayList);
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(new Serializable[]{Integer.valueOf(i), createEditingDeltaJSON}));
    }

    public void updateEditingStateWithTag(int i, @NonNull HashMap<String, TextEditState> hashMap) {
        Log.v(TAG, "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next : hashMap.entrySet()) {
            TextEditState textEditState = (TextEditState) next.getValue();
            hashMap2.put((String) next.getKey(), createEditingStateJSON(textEditState.text, textEditState.selectionStart, textEditState.selectionEnd, -1, -1));
        }
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(new Serializable[]{Integer.valueOf(i), hashMap2}));
    }
}
