package com.upuphone.starrynet.strategy.encrypt.bean;

public class KeyPair {
    private byte[] privateKey;
    private byte[] publicKey;

    public KeyPair(byte[] bArr, byte[] bArr2) {
        this.privateKey = bArr;
        this.publicKey = bArr2;
    }

    public byte[] getPrivateKey() {
        return this.privateKey;
    }

    public byte[] getPublicKey() {
        return this.publicKey;
    }

    public void setPrivateKey(byte[] bArr) {
        this.privateKey = bArr;
    }

    public void setPublicKey(byte[] bArr) {
        this.publicKey = bArr;
    }

    public String toString() {
        return "ECKeyPair{privateKey='" + this.privateKey + '\'' + ", publicKey='" + this.publicKey + '\'' + '}';
    }
}
