package com.xjsd.ai.entity;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class AudioConfig {
    @SerializedName("cwr.config")
    private CwrConfig cwrConfig;
    @SerializedName("faspe.config")
    private FaspeConfig faspeConfig;
    @SerializedName("modules")
    private Modules modules;
    @SerializedName("vad.config")
    private VadConfig vadConfig;
    @SerializedName("wkp.config")
    private WkpConfig wkpConfig;
    @SerializedName("workmode.config")
    private WorkmodeConfig workmodeConfig;

    @Keep
    public static class CwrConfig {
        @SerializedName("iBeamResult")
        private Integer iBeamResult;
        @SerializedName("ucExpIdxVadCwr")
        private Integer ucExpIdxVadCwr;
        @SerializedName("ucGetCwrResTimer")
        private Integer ucGetCwrResTimer;

        public Integer getUcExpIdxVadCwr() {
            return this.ucExpIdxVadCwr;
        }

        public Integer getUcGetCwrResTimer() {
            return this.ucGetCwrResTimer;
        }

        public Integer getiBeamResult() {
            return this.iBeamResult;
        }

        public void setUcExpIdxVadCwr(Integer num) {
            this.ucExpIdxVadCwr = num;
        }

        public void setUcGetCwrResTimer(Integer num) {
            this.ucGetCwrResTimer = num;
        }

        public void setiBeamResult(Integer num) {
            this.iBeamResult = num;
        }
    }

    @Keep
    public static class FaspeConfig {
        @SerializedName("env")
        private String env;
        @SerializedName("nnbf")
        private String nnbf;
        @SerializedName("res")
        private String res;
        @SerializedName("ucChanSelect")
        private Integer ucChanSelect;
        @SerializedName("ucFaspResetSup")
        private Integer ucFaspResetSup;
        @SerializedName("ucIsEngWkpWords")
        private Integer ucIsEngWkpWords;

        public String getEnv() {
            return this.env;
        }

        public String getNnbf() {
            return this.nnbf;
        }

        public String getRes() {
            return this.res;
        }

        public Integer getUcChanSelect() {
            return this.ucChanSelect;
        }

        public Integer getUcFaspResetSup() {
            return this.ucFaspResetSup;
        }

        public Integer getUcIsEngWkpWords() {
            return this.ucIsEngWkpWords;
        }

        public void setEnv(String str) {
            this.env = str;
        }

        public void setNnbf(String str) {
            this.nnbf = str;
        }

        public void setRes(String str) {
            this.res = str;
        }

        public void setUcChanSelect(Integer num) {
            this.ucChanSelect = num;
        }

        public void setUcFaspResetSup(Integer num) {
            this.ucFaspResetSup = num;
        }

        public void setUcIsEngWkpWords(Integer num) {
            this.ucIsEngWkpWords = num;
        }
    }

    @Keep
    public static class Modules {
        @SerializedName("cwr")
        private String cwr;
        @SerializedName("dir")
        private String dir;
        @SerializedName("faspe")
        private String faspe;
        @SerializedName("vad")
        private String vad;

        public String getCwr() {
            return this.cwr;
        }

        public String getDir() {
            return this.dir;
        }

        public String getFaspe() {
            return this.faspe;
        }

        public String getVad() {
            return this.vad;
        }

        public void setCwr(String str) {
            this.cwr = str;
        }

        public void setDir(String str) {
            this.dir = str;
        }

        public void setFaspe(String str) {
            this.faspe = str;
        }

        public void setVad(String str) {
            this.vad = str;
        }
    }

    @Keep
    public static class VadConfig {
        @SerializedName("files")
        private String files;
        @SerializedName("ucExpIdxFspVad")
        private Integer ucExpIdxFspVad;
        @SerializedName("ucExpIdxVadCache")
        private Integer ucExpIdxVadCache;
        @SerializedName("ucPopStreaming")
        private Integer ucPopStreaming;
        @SerializedName("ucRollBackSize")
        private Integer ucRollBackSize;

        public String getFiles() {
            return this.files;
        }

        public Integer getUcExpIdxFspVad() {
            return this.ucExpIdxFspVad;
        }

        public Integer getUcExpIdxVadCache() {
            return this.ucExpIdxVadCache;
        }

        public Integer getUcPopStreaming() {
            return this.ucPopStreaming;
        }

        public Integer getUcRollBackSize() {
            return this.ucRollBackSize;
        }

        public void setFiles(String str) {
            this.files = str;
        }

        public void setUcExpIdxFspVad(Integer num) {
            this.ucExpIdxFspVad = num;
        }

        public void setUcExpIdxVadCache(Integer num) {
            this.ucExpIdxVadCache = num;
        }

        public void setUcPopStreaming(Integer num) {
            this.ucPopStreaming = num;
        }

        public void setUcRollBackSize(Integer num) {
            this.ucRollBackSize = num;
        }
    }

    @Keep
    public static class WkpConfig {
    }

    @Keep
    public static class WorkmodeConfig {
        @SerializedName("iFrmInc")
        private Integer iFrmInc;
        @SerializedName("ucOutputChans")
        private Integer ucOutputChans;

        public Integer getUcOutputChans() {
            return this.ucOutputChans;
        }

        public Integer getiFrmInc() {
            return this.iFrmInc;
        }

        public void setUcOutputChans(Integer num) {
            this.ucOutputChans = num;
        }

        public void setiFrmInc(Integer num) {
            this.iFrmInc = num;
        }
    }

    public CwrConfig getCwrConfig() {
        return this.cwrConfig;
    }

    public FaspeConfig getFaspeConfig() {
        return this.faspeConfig;
    }

    public Modules getModules() {
        return this.modules;
    }

    public VadConfig getVadConfig() {
        return this.vadConfig;
    }

    public WkpConfig getWkpConfig() {
        return this.wkpConfig;
    }

    public WorkmodeConfig getWorkmodeConfig() {
        return this.workmodeConfig;
    }

    public void setCwrConfig(CwrConfig cwrConfig2) {
        this.cwrConfig = cwrConfig2;
    }

    public void setFaspeConfig(FaspeConfig faspeConfig2) {
        this.faspeConfig = faspeConfig2;
    }

    public void setModules(Modules modules2) {
        this.modules = modules2;
    }

    public void setVadConfig(VadConfig vadConfig2) {
        this.vadConfig = vadConfig2;
    }

    public void setWkpConfig(WkpConfig wkpConfig2) {
        this.wkpConfig = wkpConfig2;
    }

    public void setWorkmodeConfig(WorkmodeConfig workmodeConfig2) {
        this.workmodeConfig = workmodeConfig2;
    }

    public String toString() {
        return "AudioConfig{modules=" + this.modules + ", faspeConfig=" + this.faspeConfig + ", vadConfig=" + this.vadConfig + ", cwrConfig=" + this.cwrConfig + ", workmodeConfig=" + this.workmodeConfig + ", wkpConfig=" + this.wkpConfig + '}';
    }
}
