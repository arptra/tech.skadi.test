package androidx.browser.trusted;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.upuphone.runasone.uupcast.CaptureType;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

class PackageIdentityUtils {

    @RequiresApi
    public static class Api28Implementation implements SignaturesCompat {
        public boolean a(String str, PackageManager packageManager, TokenContents tokenContents) {
            List b;
            if (tokenContents.f().equals(str) && (b = b(str, packageManager)) != null) {
                return b.size() == 1 ? packageManager.hasSigningCertificate(str, tokenContents.e(0), 1) : tokenContents.equals(TokenContents.c(str, b));
            }
            return false;
        }

        public List b(String str, PackageManager packageManager) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW);
            ArrayList arrayList = new ArrayList();
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (signingInfo.hasMultipleSigners()) {
                for (Signature a2 : signingInfo.getApkContentsSigners()) {
                    arrayList.add(PackageIdentityUtils.a(a2));
                }
            } else {
                arrayList.add(PackageIdentityUtils.a(signingInfo.getSigningCertificateHistory()[0]));
            }
            return arrayList;
        }
    }

    public static class Pre28Implementation implements SignaturesCompat {
        public boolean a(String str, PackageManager packageManager, TokenContents tokenContents) {
            List b;
            if (str.equals(tokenContents.f()) && (b = b(str, packageManager)) != null) {
                return tokenContents.equals(TokenContents.c(str, b));
            }
            return false;
        }

        public List b(String str, PackageManager packageManager) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            ArrayList arrayList = new ArrayList(packageInfo.signatures.length);
            for (Signature a2 : packageInfo.signatures) {
                byte[] a3 = PackageIdentityUtils.a(a2);
                if (a3 == null) {
                    return null;
                }
                arrayList.add(a3);
            }
            return arrayList;
        }
    }

    public interface SignaturesCompat {
        boolean a(String str, PackageManager packageManager, TokenContents tokenContents);
    }

    public static byte[] a(Signature signature) {
        try {
            return MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static SignaturesCompat b() {
        return new Api28Implementation();
    }

    public static boolean c(String str, PackageManager packageManager, TokenContents tokenContents) {
        try {
            return b().a(str, packageManager, tokenContents);
        } catch (PackageManager.NameNotFoundException | IOException e) {
            Log.e("PackageIdentity", "Could not check if package matches token.", e);
            return false;
        }
    }
}
