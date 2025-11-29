package androidx.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.preference.DialogPreference;
import com.upuphone.runasone.relay.api.IntentKey;

public abstract class PreferenceDialogFragmentCompat extends DialogFragment implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public DialogPreference f1665a;
    public CharSequence b;
    public CharSequence c;
    public CharSequence d;
    public CharSequence e;
    public int f;
    public BitmapDrawable g;
    public int h;

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static void a(@NonNull Window window) {
            window.getDecorView().getWindowInsetsController().show(WindowInsets.Type.ime());
        }
    }

    public DialogPreference i0() {
        if (this.f1665a == null) {
            this.f1665a = (DialogPreference) ((DialogPreference.TargetFragment) getTargetFragment()).n(requireArguments().getString(IntentKey.ACTIVITY.ACTION_KEY));
        }
        return this.f1665a;
    }

    public boolean j0() {
        return false;
    }

    public void k0(View view) {
        int i;
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence charSequence = this.e;
            if (!TextUtils.isEmpty(charSequence)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i = 0;
            } else {
                i = 8;
            }
            if (findViewById.getVisibility() != i) {
                findViewById.setVisibility(i);
            }
        }
    }

    public View l0(Context context) {
        int i = this.f;
        if (i == 0) {
            return null;
        }
        return getLayoutInflater().inflate(i, (ViewGroup) null);
    }

    public abstract void m0(boolean z);

    public void n0(AlertDialog.Builder builder) {
    }

    public final void o0(Dialog dialog) {
        Window window = dialog.getWindow();
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(window);
        } else {
            s0();
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.h = i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment targetFragment = getTargetFragment();
        if (targetFragment instanceof DialogPreference.TargetFragment) {
            DialogPreference.TargetFragment targetFragment2 = (DialogPreference.TargetFragment) targetFragment;
            String string = requireArguments().getString(IntentKey.ACTIVITY.ACTION_KEY);
            if (bundle == null) {
                DialogPreference dialogPreference = (DialogPreference) targetFragment2.n(string);
                this.f1665a = dialogPreference;
                this.b = dialogPreference.o();
                this.c = this.f1665a.q();
                this.d = this.f1665a.p();
                this.e = this.f1665a.n();
                this.f = this.f1665a.m();
                Drawable l = this.f1665a.l();
                if (l == null || (l instanceof BitmapDrawable)) {
                    this.g = (BitmapDrawable) l;
                    return;
                }
                Bitmap createBitmap = Bitmap.createBitmap(l.getIntrinsicWidth(), l.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                l.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                l.draw(canvas);
                this.g = new BitmapDrawable(getResources(), createBitmap);
                return;
            }
            this.b = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.c = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.d = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.e = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.g = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.h = -2;
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(requireContext()).setTitle(this.b).setIcon((Drawable) this.g).setPositiveButton(this.c, (DialogInterface.OnClickListener) this).setNegativeButton(this.d, (DialogInterface.OnClickListener) this);
        View l0 = l0(requireContext());
        if (l0 != null) {
            k0(l0);
            negativeButton.setView(l0);
        } else {
            negativeButton.setMessage(this.e);
        }
        n0(negativeButton);
        AlertDialog create = negativeButton.create();
        if (j0()) {
            o0(create);
        }
        return create;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        m0(this.h == -1);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.b);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.c);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.d);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.e);
        bundle.putInt("PreferenceDialogFragment.layout", this.f);
        BitmapDrawable bitmapDrawable = this.g;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public void s0() {
    }
}
