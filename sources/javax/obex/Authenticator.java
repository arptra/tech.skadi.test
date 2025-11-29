package javax.obex;

public interface Authenticator {
    byte[] a(byte[] bArr);

    PasswordAuthentication b(String str, boolean z, boolean z2);
}
