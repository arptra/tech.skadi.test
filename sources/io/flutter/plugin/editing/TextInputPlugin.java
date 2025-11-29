package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.inputmethod.EditorInfoCompat;
import com.here.posclient.PositionEstimate;
import io.flutter.Log;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.editing.ListenableEditingState;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashMap;

public class TextInputPlugin implements ListenableEditingState.EditingStateWatcher {
    private static final String TAG = "TextInputPlugin";
    /* access modifiers changed from: private */
    @NonNull
    public final AutofillManager afm;
    @Nullable
    private SparseArray<TextInputChannel.Configuration> autofillConfiguration;
    @Nullable
    private TextInputChannel.Configuration configuration;
    private ImeSyncDeferringInsetsCallback imeSyncCallback;
    /* access modifiers changed from: private */
    @NonNull
    public InputTarget inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
    private boolean isInputConnectionLocked;
    @Nullable
    private Rect lastClientRect;
    @Nullable
    private InputConnection lastInputConnection;
    @NonNull
    private ListenableEditingState mEditable;
    @NonNull
    private final InputMethodManager mImm;
    private TextInputChannel.TextEditState mLastKnownFrameworkTextEditingState;
    private boolean mRestartInputPending;
    /* access modifiers changed from: private */
    @NonNull
    public final View mView;
    @NonNull
    private PlatformViewsController platformViewsController;
    @NonNull
    private final TextInputChannel textInputChannel;

    public static class InputTarget {
        int id;
        @NonNull
        Type type;

        public enum Type {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VIRTUAL_DISPLAY_PLATFORM_VIEW,
            PHYSICAL_DISPLAY_PLATFORM_VIEW
        }

        public InputTarget(@NonNull Type type2, int i) {
            this.type = type2;
            this.id = i;
        }
    }

    public interface MinMax {
        void inspect(double d, double d2);
    }

    @SuppressLint({"NewApi"})
    public TextInputPlugin(@NonNull View view, @NonNull TextInputChannel textInputChannel2, @NonNull PlatformViewsController platformViewsController2) {
        this.mView = view;
        this.mEditable = new ListenableEditingState((TextInputChannel.TextEditState) null, view);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i = Build.VERSION.SDK_INT;
        this.afm = (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
        if (i >= 30) {
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view);
            this.imeSyncCallback = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.textInputChannel = textInputChannel2;
        textInputChannel2.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() {
            public void clearClient() {
                TextInputPlugin.this.clearTextInputClient();
            }

            public void finishAutofillContext(boolean z) {
                if (TextInputPlugin.this.afm != null) {
                    if (z) {
                        TextInputPlugin.this.afm.commit();
                    } else {
                        TextInputPlugin.this.afm.cancel();
                    }
                }
            }

            public void hide() {
                if (TextInputPlugin.this.inputTarget.type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
                    TextInputPlugin.this.notifyViewExited();
                    return;
                }
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.hideTextInput(textInputPlugin.mView);
            }

            public void requestAutofill() {
                TextInputPlugin.this.notifyViewEntered();
            }

            public void sendAppPrivateCommand(String str, Bundle bundle) {
                TextInputPlugin.this.sendTextInputAppPrivateCommand(str, bundle);
            }

            public void setClient(int i, TextInputChannel.Configuration configuration) {
                TextInputPlugin.this.setTextInputClient(i, configuration);
            }

            public void setEditableSizeAndTransform(double d, double d2, double[] dArr) {
                TextInputPlugin.this.saveEditableSizeAndTransform(d, d2, dArr);
            }

            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.setTextInputEditingState(textInputPlugin.mView, textEditState);
            }

            public void setPlatformViewClient(int i, boolean z) {
                TextInputPlugin.this.setPlatformViewTextInputClient(i, z);
            }

            public void show() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.showTextInput(textInputPlugin.mView);
            }
        });
        textInputChannel2.requestExistingInputState();
        this.platformViewsController = platformViewsController2;
        platformViewsController2.attachTextInputPlugin(this);
    }

    private static boolean composingChanged(TextInputChannel.TextEditState textEditState, TextInputChannel.TextEditState textEditState2) {
        int i = textEditState.composingEnd - textEditState.composingStart;
        if (i != textEditState2.composingEnd - textEditState2.composingStart) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (textEditState.text.charAt(textEditState.composingStart + i2) != textEditState2.text.charAt(textEditState2.composingStart + i2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void hideTextInput(View view) {
        notifyViewExited();
        this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int inputTypeFromTextInputType(io.flutter.embedding.engine.systemchannels.TextInputChannel.InputType r1, boolean r2, boolean r3, boolean r4, boolean r5, io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization r6) {
        /*
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r5 = r1.type
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r0 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.DATETIME
            if (r5 != r0) goto L_0x0008
            r1 = 4
            return r1
        L_0x0008:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r0 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.NUMBER
            if (r5 != r0) goto L_0x001b
            boolean r2 = r1.isSigned
            if (r2 == 0) goto L_0x0013
            r2 = 4098(0x1002, float:5.743E-42)
            goto L_0x0014
        L_0x0013:
            r2 = 2
        L_0x0014:
            boolean r1 = r1.isDecimal
            if (r1 == 0) goto L_0x001a
            r2 = r2 | 8192(0x2000, float:1.14794E-41)
        L_0x001a:
            return r2
        L_0x001b:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.PHONE
            if (r5 != r1) goto L_0x0021
            r1 = 3
            return r1
        L_0x0021:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.NONE
            if (r5 != r1) goto L_0x0027
            r1 = 0
            return r1
        L_0x0027:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.MULTILINE
            if (r5 != r1) goto L_0x002f
            r1 = 131073(0x20001, float:1.83672E-40)
            goto L_0x0053
        L_0x002f:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.EMAIL_ADDRESS
            if (r5 != r1) goto L_0x0036
            r1 = 33
            goto L_0x0053
        L_0x0036:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.URL
            if (r5 != r1) goto L_0x003d
            r1 = 17
            goto L_0x0053
        L_0x003d:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.VISIBLE_PASSWORD
            if (r5 != r1) goto L_0x0044
            r1 = 145(0x91, float:2.03E-43)
            goto L_0x0053
        L_0x0044:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.NAME
            if (r5 != r1) goto L_0x004b
            r1 = 97
            goto L_0x0053
        L_0x004b:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.POSTAL_ADDRESS
            if (r5 != r1) goto L_0x0052
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x0053
        L_0x0052:
            r1 = 1
        L_0x0053:
            if (r2 == 0) goto L_0x005a
            r2 = 524416(0x80080, float:7.34863E-40)
        L_0x0058:
            r1 = r1 | r2
            goto L_0x0066
        L_0x005a:
            if (r3 == 0) goto L_0x0060
            r2 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 | r2
        L_0x0060:
            if (r4 != 0) goto L_0x0066
            r2 = 524432(0x80090, float:7.34886E-40)
            goto L_0x0058
        L_0x0066:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextCapitalization r2 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization.CHARACTERS
            if (r6 != r2) goto L_0x006d
            r1 = r1 | 4096(0x1000, float:5.74E-42)
            goto L_0x007a
        L_0x006d:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextCapitalization r2 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization.WORDS
            if (r6 != r2) goto L_0x0074
            r1 = r1 | 8192(0x2000, float:1.14794E-41)
            goto L_0x007a
        L_0x0074:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextCapitalization r2 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization.SENTENCES
            if (r6 != r2) goto L_0x007a
            r1 = r1 | 16384(0x4000, float:2.2959E-41)
        L_0x007a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.TextInputPlugin.inputTypeFromTextInputType(io.flutter.embedding.engine.systemchannels.TextInputChannel$InputType, boolean, boolean, boolean, boolean, io.flutter.embedding.engine.systemchannels.TextInputChannel$TextCapitalization):int");
    }

    private boolean needsAutofill() {
        return this.autofillConfiguration != null;
    }

    private void notifyValueChanged(String str) {
        if (this.afm != null && needsAutofill()) {
            this.afm.notifyValueChanged(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(str));
        }
    }

    /* access modifiers changed from: private */
    public void notifyViewEntered() {
        if (this.afm != null && needsAutofill()) {
            String str = this.configuration.autofill.uniqueIdentifier;
            int[] iArr = new int[2];
            this.mView.getLocationOnScreen(iArr);
            Rect rect = new Rect(this.lastClientRect);
            rect.offset(iArr[0], iArr[1]);
            this.afm.notifyViewEntered(this.mView, str.hashCode(), rect);
        }
    }

    /* access modifiers changed from: private */
    public void notifyViewExited() {
        TextInputChannel.Configuration configuration2;
        if (this.afm != null && (configuration2 = this.configuration) != null && configuration2.autofill != null && needsAutofill()) {
            this.afm.notifyViewExited(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode());
        }
    }

    /* access modifiers changed from: private */
    public void saveEditableSizeAndTransform(double d, double d2, double[] dArr) {
        double d3 = d;
        double d4 = d2;
        final double[] dArr2 = dArr;
        final double[] dArr3 = new double[4];
        final boolean z = dArr2[3] == 0.0d && dArr2[7] == 0.0d && dArr2[15] == 1.0d;
        double d5 = dArr2[12];
        double d6 = dArr2[15];
        double d7 = d5 / d6;
        dArr3[1] = d7;
        dArr3[0] = d7;
        double d8 = dArr2[13] / d6;
        dArr3[3] = d8;
        dArr3[2] = d8;
        AnonymousClass2 r14 = new MinMax() {
            public void inspect(double d, double d2) {
                double d3 = 1.0d;
                if (!z) {
                    double[] dArr = dArr2;
                    d3 = 1.0d / (((dArr[3] * d) + (dArr[7] * d2)) + dArr[15]);
                }
                double[] dArr2 = dArr2;
                double d4 = ((dArr2[0] * d) + (dArr2[4] * d2) + dArr2[12]) * d3;
                double d5 = ((dArr2[1] * d) + (dArr2[5] * d2) + dArr2[13]) * d3;
                double[] dArr3 = dArr3;
                if (d4 < dArr3[0]) {
                    dArr3[0] = d4;
                } else if (d4 > dArr3[1]) {
                    dArr3[1] = d4;
                }
                if (d5 < dArr3[2]) {
                    dArr3[2] = d5;
                } else if (d5 > dArr3[3]) {
                    dArr3[3] = d5;
                }
            }
        };
        r14.inspect(d3, 0.0d);
        r14.inspect(d3, d4);
        r14.inspect(0.0d, d4);
        double d9 = (double) this.mView.getContext().getResources().getDisplayMetrics().density;
        this.lastClientRect = new Rect((int) (dArr3[0] * d9), (int) (dArr3[2] * d9), (int) Math.ceil(dArr3[1] * d9), (int) Math.ceil(dArr3[3] * d9));
    }

    /* access modifiers changed from: private */
    public void setPlatformViewTextInputClient(int i, boolean z) {
        if (z) {
            this.mView.requestFocus();
            this.inputTarget = new InputTarget(InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW, i);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
            return;
        }
        this.inputTarget = new InputTarget(InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW, i);
        this.lastInputConnection = null;
    }

    private void updateAutofillConfigurationIfNeeded(TextInputChannel.Configuration configuration2) {
        if (configuration2 == null || configuration2.autofill == null) {
            this.autofillConfiguration = null;
            return;
        }
        TextInputChannel.Configuration[] configurationArr = configuration2.fields;
        SparseArray<TextInputChannel.Configuration> sparseArray = new SparseArray<>();
        this.autofillConfiguration = sparseArray;
        if (configurationArr == null) {
            sparseArray.put(configuration2.autofill.uniqueIdentifier.hashCode(), configuration2);
            return;
        }
        for (TextInputChannel.Configuration configuration3 : configurationArr) {
            TextInputChannel.Configuration.Autofill autofill = configuration3.autofill;
            if (autofill != null) {
                this.autofillConfiguration.put(autofill.uniqueIdentifier.hashCode(), configuration3);
                this.afm.notifyValueChanged(this.mView, autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(autofill.editState.text));
            }
        }
    }

    public void autofill(@NonNull SparseArray<AutofillValue> sparseArray) {
        TextInputChannel.Configuration.Autofill autofill;
        TextInputChannel.Configuration.Autofill autofill2;
        TextInputChannel.Configuration configuration2 = this.configuration;
        if (configuration2 != null && this.autofillConfiguration != null && (autofill = configuration2.autofill) != null) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                TextInputChannel.Configuration configuration3 = this.autofillConfiguration.get(sparseArray.keyAt(i));
                if (!(configuration3 == null || (autofill2 = configuration3.autofill) == null)) {
                    String charSequence = sparseArray.valueAt(i).getTextValue().toString();
                    TextInputChannel.TextEditState textEditState = new TextInputChannel.TextEditState(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                    if (autofill2.uniqueIdentifier.equals(autofill.uniqueIdentifier)) {
                        this.mEditable.setEditingState(textEditState);
                    } else {
                        hashMap.put(autofill2.uniqueIdentifier, textEditState);
                    }
                }
            }
            this.textInputChannel.updateEditingStateWithTag(this.inputTarget.id, hashMap);
        }
    }

    public void clearPlatformViewClient(int i) {
        InputTarget inputTarget2 = this.inputTarget;
        InputTarget.Type type = inputTarget2.type;
        if ((type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW || type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) && inputTarget2.id == i) {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            notifyViewExited();
            this.mImm.hideSoftInputFromWindow(this.mView.getApplicationWindowToken(), 0);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
        }
    }

    @VisibleForTesting
    public void clearTextInputClient() {
        if (this.inputTarget.type != InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.mEditable.removeEditingStateListener(this);
            notifyViewExited();
            this.configuration = null;
            updateAutofillConfigurationIfNeeded((TextInputChannel.Configuration) null);
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            unlockPlatformViewInputConnection();
            this.lastClientRect = null;
            this.mImm.restartInput(this.mView);
        }
    }

    @Nullable
    public InputConnection createInputConnection(@NonNull View view, @NonNull KeyboardManager keyboardManager, @NonNull EditorInfo editorInfo) {
        InputTarget inputTarget2 = this.inputTarget;
        InputTarget.Type type = inputTarget2.type;
        if (type == InputTarget.Type.NO_TARGET) {
            this.lastInputConnection = null;
            return null;
        } else if (type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
            return null;
        } else {
            if (type != InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
                TextInputChannel.Configuration configuration2 = this.configuration;
                int inputTypeFromTextInputType = inputTypeFromTextInputType(configuration2.inputType, configuration2.obscureText, configuration2.autocorrect, configuration2.enableSuggestions, configuration2.enableIMEPersonalizedLearning, configuration2.textCapitalization);
                editorInfo.inputType = inputTypeFromTextInputType;
                editorInfo.imeOptions = PositionEstimate.Value.GNSS_TIME;
                TextInputChannel.Configuration configuration3 = this.configuration;
                if (!configuration3.enableIMEPersonalizedLearning) {
                    editorInfo.imeOptions = 33554432 | 16777216;
                }
                Integer num = configuration3.inputAction;
                int intValue = num == null ? (inputTypeFromTextInputType & 131072) != 0 ? 1 : 6 : num.intValue();
                TextInputChannel.Configuration configuration4 = this.configuration;
                String str = configuration4.actionLabel;
                if (str != null) {
                    editorInfo.actionLabel = str;
                    editorInfo.actionId = intValue;
                }
                editorInfo.imeOptions = intValue | editorInfo.imeOptions;
                String[] strArr = configuration4.contentCommitMimeTypes;
                if (strArr != null) {
                    EditorInfoCompat.c(editorInfo, strArr);
                }
                InputConnectionAdaptor inputConnectionAdaptor = new InputConnectionAdaptor(view, this.inputTarget.id, this.textInputChannel, keyboardManager, this.mEditable, editorInfo);
                editorInfo.initialSelStart = this.mEditable.getSelectionStart();
                editorInfo.initialSelEnd = this.mEditable.getSelectionEnd();
                this.lastInputConnection = inputConnectionAdaptor;
                return inputConnectionAdaptor;
            } else if (this.isInputConnectionLocked) {
                return this.lastInputConnection;
            } else {
                InputConnection onCreateInputConnection = this.platformViewsController.getPlatformViewById(inputTarget2.id).onCreateInputConnection(editorInfo);
                this.lastInputConnection = onCreateInputConnection;
                return onCreateInputConnection;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void destroy() {
        this.platformViewsController.detachTextInputPlugin();
        this.textInputChannel.setTextInputMethodHandler((TextInputChannel.TextInputMethodHandler) null);
        notifyViewExited();
        this.mEditable.removeEditingStateListener(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.imeSyncCallback;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r7 == r1.composingEnd) goto L_0x00a7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void didChangeEditingState(boolean r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x000b
            io.flutter.plugin.editing.ListenableEditingState r9 = r8.mEditable
            java.lang.String r9 = r9.toString()
            r8.notifyValueChanged(r9)
        L_0x000b:
            io.flutter.plugin.editing.ListenableEditingState r9 = r8.mEditable
            int r9 = r9.getSelectionStart()
            io.flutter.plugin.editing.ListenableEditingState r10 = r8.mEditable
            int r10 = r10.getSelectionEnd()
            io.flutter.plugin.editing.ListenableEditingState r11 = r8.mEditable
            int r11 = r11.getComposingStart()
            io.flutter.plugin.editing.ListenableEditingState r0 = r8.mEditable
            int r7 = r0.getComposingEnd()
            io.flutter.plugin.editing.ListenableEditingState r0 = r8.mEditable
            java.util.ArrayList r0 = r0.extractBatchTextEditingDeltas()
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r1 = r8.mLastKnownFrameworkTextEditingState
            if (r1 == 0) goto L_0x00a7
            io.flutter.plugin.editing.ListenableEditingState r1 = r8.mEditable
            java.lang.String r1 = r1.toString()
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r2 = r8.mLastKnownFrameworkTextEditingState
            java.lang.String r2 = r2.text
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0050
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r1 = r8.mLastKnownFrameworkTextEditingState
            int r2 = r1.selectionStart
            if (r9 != r2) goto L_0x0050
            int r2 = r1.selectionEnd
            if (r10 != r2) goto L_0x0050
            int r2 = r1.composingStart
            if (r11 != r2) goto L_0x0050
            int r1 = r1.composingEnd
            if (r7 != r1) goto L_0x0050
            goto L_0x00a7
        L_0x0050:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "send EditingState to flutter: "
            r1.append(r2)
            io.flutter.plugin.editing.ListenableEditingState r2 = r8.mEditable
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TextInputPlugin"
            io.flutter.Log.v(r2, r1)
            io.flutter.embedding.engine.systemchannels.TextInputChannel$Configuration r1 = r8.configuration
            boolean r1 = r1.enableDeltaModel
            if (r1 == 0) goto L_0x0081
            io.flutter.embedding.engine.systemchannels.TextInputChannel r1 = r8.textInputChannel
            io.flutter.plugin.editing.TextInputPlugin$InputTarget r2 = r8.inputTarget
            int r2 = r2.id
            r1.updateEditingStateWithDeltas(r2, r0)
            io.flutter.plugin.editing.ListenableEditingState r0 = r8.mEditable
            r0.clearBatchDeltas()
            goto L_0x0094
        L_0x0081:
            io.flutter.embedding.engine.systemchannels.TextInputChannel r0 = r8.textInputChannel
            io.flutter.plugin.editing.TextInputPlugin$InputTarget r1 = r8.inputTarget
            int r1 = r1.id
            io.flutter.plugin.editing.ListenableEditingState r2 = r8.mEditable
            java.lang.String r2 = r2.toString()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r7
            r0.updateEditingState(r1, r2, r3, r4, r5, r6)
        L_0x0094:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r6 = new io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState
            io.flutter.plugin.editing.ListenableEditingState r0 = r8.mEditable
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.mLastKnownFrameworkTextEditingState = r6
            goto L_0x00ac
        L_0x00a7:
            io.flutter.plugin.editing.ListenableEditingState r8 = r8.mEditable
            r8.clearBatchDeltas()
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.TextInputPlugin.didChangeEditingState(boolean, boolean, boolean):void");
    }

    @VisibleForTesting
    public Editable getEditable() {
        return this.mEditable;
    }

    @VisibleForTesting
    public ImeSyncDeferringInsetsCallback getImeSyncCallback() {
        return this.imeSyncCallback;
    }

    @NonNull
    public InputMethodManager getInputMethodManager() {
        return this.mImm;
    }

    @Nullable
    public InputConnection getLastInputConnection() {
        return this.lastInputConnection;
    }

    public boolean handleKeyEvent(@NonNull KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!getInputMethodManager().isAcceptingText() || (inputConnection = this.lastInputConnection) == null) {
            return false;
        }
        return inputConnection instanceof InputConnectionAdaptor ? ((InputConnectionAdaptor) inputConnection).handleKeyEvent(keyEvent) : inputConnection.sendKeyEvent(keyEvent);
    }

    public void lockPlatformViewInputConnection() {
        if (this.inputTarget.type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.isInputConnectionLocked = true;
        }
    }

    public void onProvideAutofillVirtualStructure(@NonNull ViewStructure viewStructure, int i) {
        Rect rect;
        ViewStructure viewStructure2 = viewStructure;
        if (needsAutofill()) {
            String str = this.configuration.autofill.uniqueIdentifier;
            AutofillId autofillId = viewStructure.getAutofillId();
            for (int i2 = 0; i2 < this.autofillConfiguration.size(); i2++) {
                int keyAt = this.autofillConfiguration.keyAt(i2);
                TextInputChannel.Configuration.Autofill autofill = this.autofillConfiguration.valueAt(i2).autofill;
                if (autofill != null) {
                    viewStructure2.addChildCount(1);
                    ViewStructure newChild = viewStructure2.newChild(i2);
                    newChild.setAutofillId(autofillId, keyAt);
                    String[] strArr = autofill.hints;
                    if (strArr.length > 0) {
                        newChild.setAutofillHints(strArr);
                    }
                    newChild.setAutofillType(1);
                    newChild.setVisibility(0);
                    String str2 = autofill.hintText;
                    if (str2 != null) {
                        newChild.setHint(str2);
                    }
                    if (str.hashCode() != keyAt || (rect = this.lastClientRect) == null) {
                        ViewStructure viewStructure3 = newChild;
                        viewStructure3.setDimens(0, 0, 0, 0, 1, 1);
                        viewStructure3.setAutofillValue(AutofillValue.forText(autofill.editState.text));
                    } else {
                        newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.lastClientRect.height());
                        newChild.setAutofillValue(AutofillValue.forText(this.mEditable));
                    }
                }
            }
        }
    }

    public void sendTextInputAppPrivateCommand(@NonNull String str, @NonNull Bundle bundle) {
        this.mImm.sendAppPrivateCommand(this.mView, str, bundle);
    }

    @VisibleForTesting
    public void setTextInputClient(int i, TextInputChannel.Configuration configuration2) {
        notifyViewExited();
        this.configuration = configuration2;
        this.inputTarget = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i);
        this.mEditable.removeEditingStateListener(this);
        TextInputChannel.Configuration.Autofill autofill = configuration2.autofill;
        this.mEditable = new ListenableEditingState(autofill != null ? autofill.editState : null, this.mView);
        updateAutofillConfigurationIfNeeded(configuration2);
        this.mRestartInputPending = true;
        unlockPlatformViewInputConnection();
        this.lastClientRect = null;
        this.mEditable.addEditingStateListener(this);
    }

    @VisibleForTesting
    public void setTextInputEditingState(View view, TextInputChannel.TextEditState textEditState) {
        TextInputChannel.TextEditState textEditState2;
        if (!this.mRestartInputPending && (textEditState2 = this.mLastKnownFrameworkTextEditingState) != null && textEditState2.hasComposing()) {
            boolean composingChanged = composingChanged(this.mLastKnownFrameworkTextEditingState, textEditState);
            this.mRestartInputPending = composingChanged;
            if (composingChanged) {
                Log.i(TAG, "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.mLastKnownFrameworkTextEditingState = textEditState;
        this.mEditable.setEditingState(textEditState);
        if (this.mRestartInputPending) {
            this.mImm.restartInput(view);
            this.mRestartInputPending = false;
        }
    }

    @VisibleForTesting
    public void showTextInput(View view) {
        TextInputChannel.InputType inputType;
        TextInputChannel.Configuration configuration2 = this.configuration;
        if (configuration2 == null || (inputType = configuration2.inputType) == null || inputType.type != TextInputChannel.TextInputType.NONE) {
            view.requestFocus();
            this.mImm.showSoftInput(view, 0);
            return;
        }
        hideTextInput(view);
    }

    public void unlockPlatformViewInputConnection() {
        if (this.inputTarget.type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.isInputConnectionLocked = false;
        }
    }
}
