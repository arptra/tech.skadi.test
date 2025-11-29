package com.xjsd.ai.voice;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.Keep;
import com.xjsd.ai.annotation.AudioConfigFile;
import com.xjsd.ai.natives.NativeLib;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Keep
public class VoiceAdapter {
    private static final String CONFIG_PATH_PREFIX = "/fsp/";
    private static final String TAG = "VoiceAdapter";
    private static final List<String> resource = Arrays.asList(new String[]{AudioConfigFile.GLOABLE_AEC_BFVAD_ASSISTANT_STAR_SIGWKPONLY, AudioConfigFile.GLOABLE_AEC_BFVAD_ASSISTANT_STAR, AudioConfigFile.GLOABLE_AEC_GEVNNBF_TRANS_STAR, AudioConfigFile.GLOABLE_AEC_VADON_BFVAD_ASSISTANT_STAR_SIGWKPONLY, AudioConfigFile.GLOABLE_ASSISTANT_STAR_WKPVADCWRONLY, AudioConfigFile.GLOABLE_ASSISTANT_VADONLY, AudioConfigFile.GLOABLE_BFVAD_ASSISTANT_STAR_SIGONLY, AudioConfigFile.GLOABLE_BFVAD_ASSISTANT_STAR, AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR_SIGNOLY, AudioConfigFile.GLOABLE_BFVAD_TRANS_STAR, AudioConfigFile.GLOABLE_BFVAD_WECHAT_STAR, AudioConfigFile.GLOABLE_GEVNNBF_ASSISTANT_CONCEPT_SIGONLY, AudioConfigFile.GLOABLE_GEVNNBF_ASSISTANT_CONCEPT, AudioConfigFile.GLOABLE_GEVNNBF_TRANS_CONCEPT_SIGONLY, AudioConfigFile.GLOABLE_GEVNNBF_TRANS_CONCEPT, AudioConfigFile.GLOABLE_GEVNNBF_TRANS_STAR_SIGONLY, AudioConfigFile.GLOABLE_GEVNNBF_TRANS_STAR, AudioConfigFile.GLOABLE_GEVNNBF_WECHAT_CONCEPT, AudioConfigFile.GLOABLE_VADCWRONLY, AudioConfigFile.GLOABLE_VADONLY_AIR, AudioConfigFile.GLOABLE_VADONLY});
    private int index = -1;
    private NativeLib mNativeLib = new NativeLib();

    public static void assetsInit(Context context) throws IOException {
        AssetManager assets = context.getAssets();
        String str = context.getFilesDir() + "/" + "fsp/res/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (String str2 : assets.list("fsp")) {
            Log.i(TAG, "file " + str2);
            if (resource.contains(str2)) {
                File file2 = new File(context.getFilesDir(), "fsp/" + str2);
                if (!file2.exists() || file2.length() == 0) {
                    Log.i(TAG, "Unzipping fsp/" + str2 + " to " + file2.getAbsolutePath());
                    StringBuilder sb = new StringBuilder();
                    sb.append("fsp/");
                    sb.append(str2);
                    InputStream open = assets.open(sb.toString());
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                }
            }
        }
        for (String str3 : assets.list("fsp/res/")) {
            Log.i(TAG, "Unzipping " + str3 + " to " + str + str3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fsp/res/");
            sb2.append(str3);
            copyAssetResource2File(context, sb2.toString(), str + str3);
        }
    }

    public static void copyAssetResource2File(Context context, String str, String str2) throws IOException {
        InputStream open = context.getAssets().open(str);
        File file = new File(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                file.setReadable(true);
                return;
            }
        }
    }

    public void Destory() {
        synchronized (this) {
            Log.d(TAG, "Destory1");
            this.mNativeLib.Destory(this.index);
        }
    }

    public int Feed(byte[] bArr) {
        return this.mNativeLib.Feed(bArr);
    }

    public int GetSizePerSend() {
        return this.mNativeLib.GetSizePerSend();
    }

    @Deprecated
    public void Init(Context context, String str) throws Exception {
        FspResourceUtil.copyModelData(context);
        this.index = this.mNativeLib.Init(str);
    }

    public float Itensity(byte[] bArr) {
        return this.mNativeLib.Itensity(bArr);
    }

    public void Reset() {
        this.mNativeLib.Reset();
    }

    public int Start() {
        return this.mNativeLib.Start();
    }

    public void Stop() {
        this.mNativeLib.Stop();
    }

    public String Version() {
        return this.mNativeLib.Version();
    }

    public void addKwsWords(String str, float f) {
        this.mNativeLib.AddKwsWords(str, f);
    }

    public void init(Context context, String str) throws Exception {
        FspResourceUtil.copyModelData(context);
        NativeLib nativeLib = this.mNativeLib;
        this.index = nativeLib.Init(context.getFilesDir() + CONFIG_PATH_PREFIX + str);
    }

    public void registerListener(IVoiceListener iVoiceListener) {
        this.mNativeLib.registerListener(iVoiceListener);
    }

    public void setKwsDefault() {
        this.mNativeLib.SetKwsGrams(348, 197, 348, 197);
    }

    public void setKwsGrams(short s, short s2, short s3, short s4) {
        this.mNativeLib.SetKwsGrams(s, s2, s3, s4);
    }

    public void setKwsThreshold(float f) {
        this.mNativeLib.SetKwsThreshold(f);
    }

    public void setKwsThresholdDefault() {
        this.mNativeLib.SetKwsThreshold(0.4f);
    }

    public void setPttEvent() {
        this.mNativeLib.SetPttEvent();
    }

    public void setVadPause(int i) {
        this.mNativeLib.SetVadPause(i);
    }

    public void switchOff() {
        this.mNativeLib.Switch(0);
    }

    public void switchOn() {
        this.mNativeLib.Switch(1);
    }

    public void unregisterListener() {
        this.mNativeLib.unregisterListener();
    }

    public float wakeupConfidence() {
        return this.mNativeLib.WakeupConfidence();
    }

    public int Feed(byte[] bArr, int i) {
        return this.mNativeLib.FeedWithLen(bArr, i);
    }
}
