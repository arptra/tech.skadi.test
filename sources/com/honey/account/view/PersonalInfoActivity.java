package com.honey.account.view;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.lifecycle.ViewModelLazy;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.honey.account.R;
import com.honey.account.data.AccountData;
import com.honey.account.k2.a;
import com.honey.account.k2.b;
import com.honey.account.utils.coroutine.CoroutineUtilsKt;
import com.honey.account.utils.log.LogUtils;
import com.honey.account.utils.system.SystemUtilsKt;
import com.honey.account.view.helper.DialogHelperKt;
import com.honey.account.view.home.AccountHomepageViewModel;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPersonalInfoActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersonalInfoActivity.kt\ncom/honey/account/view/PersonalInfoActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,307:1\n75#2,13:308\n*S KotlinDebug\n*F\n+ 1 PersonalInfoActivity.kt\ncom/honey/account/view/PersonalInfoActivity\n*L\n59#1:308,13\n*E\n"})
@AndroidEntryPoint
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020$H\u0002J\"\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020$2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020$H\u0014J-\u00104\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u000e\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u000207062\u0006\u00108\u001a\u000209H\u0016¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020$H\u0002J\b\u0010<\u001a\u00020$H\u0002J\u0010\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u000207H\u0002J\u0010\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u000207H\u0002J\u0010\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u000207H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006G"}, d2 = {"Lcom/honey/account/view/PersonalInfoActivity;", "Lcom/honey/account/view/BaseCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "mAlertDialog", "Lcom/honey/account/view/AccountAlertDialog;", "mBtDialogOk", "Landroid/widget/Button;", "mEdNickNameLay", "Landroid/widget/LinearLayout;", "mEdVcodeEdit", "Landroid/widget/EditText;", "mImageUri", "Landroid/net/Uri;", "mIvAvatar", "Landroid/widget/ImageView;", "mIvClearText", "mRlAccount", "Landroid/widget/RelativeLayout;", "mRlAvatar", "mRlNickName", "mTextWatcher", "Landroid/text/TextWatcher;", "mTvErrorMsg", "Landroid/widget/TextView;", "mTvName", "mTvPhone", "viewModel", "Lcom/honey/account/view/home/AccountHomepageViewModel;", "getViewModel", "()Lcom/honey/account/view/home/AccountHomepageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkPermission", "", "cropAvatar", "", "selectedImage", "initView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "selectAvatar", "showUpdateNickNameDialog", "updateAccountUiState", "accountData", "Lcom/honey/account/data/AccountData;", "updateNickName", "name", "uploadAvatar", "uploadPath", "uploadAvatarSuccess", "uploadAvatarPath", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PersonalInfoActivity extends Hilt_PersonalInfoActivity implements View.OnClickListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int REQUEST_CROP_PHOTO = 4115;
    private static final int RESULT_LOAD_IMAGE = 4119;
    @NotNull
    private static final String TAG = "PersonalInfoActivity";
    /* access modifiers changed from: private */
    @Nullable
    public AccountAlertDialog mAlertDialog;
    /* access modifiers changed from: private */
    public Button mBtDialogOk;
    /* access modifiers changed from: private */
    public LinearLayout mEdNickNameLay;
    /* access modifiers changed from: private */
    public EditText mEdVcodeEdit;
    @Nullable
    private Uri mImageUri;
    private ImageView mIvAvatar;
    /* access modifiers changed from: private */
    public ImageView mIvClearText;
    private RelativeLayout mRlAccount;
    private RelativeLayout mRlAvatar;
    private RelativeLayout mRlNickName;
    @NotNull
    private final TextWatcher mTextWatcher = new PersonalInfoActivity$mTextWatcher$1(this);
    /* access modifiers changed from: private */
    public TextView mTvErrorMsg;
    /* access modifiers changed from: private */
    public TextView mTvName;
    private TextView mTvPhone;
    @NotNull
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AccountHomepageViewModel.class), new PersonalInfoActivity$special$$inlined$viewModels$default$2(this), new PersonalInfoActivity$special$$inlined$viewModels$default$1(this), new PersonalInfoActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/honey/account/view/PersonalInfoActivity$Companion;", "", "()V", "PERMISSION_REQUEST_CODE", "", "REQUEST_CROP_PHOTO", "RESULT_LOAD_IMAGE", "TAG", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean checkPermission() {
        if (Build.VERSION.SDK_INT < 33) {
            if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
                return false;
            }
        } else if (checkSelfPermission("android.permission.READ_MEDIA_IMAGES") != 0) {
            requestPermissions(new String[]{"android.permission.READ_MEDIA_IMAGES"}, 1);
            return false;
        }
        return true;
    }

    private final void cropAvatar(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        if (SystemUtilsKt.isHuawei()) {
            intent.putExtra("aspectX", 9998);
            intent.putExtra("aspectY", 9999);
        } else {
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
        }
        intent.putExtra("scale", true);
        intent.putExtra("output", this.mImageUri);
        startActivityForResult(intent, REQUEST_CROP_PHOTO);
    }

    private final AccountHomepageViewModel getViewModel() {
        return (AccountHomepageViewModel) this.viewModel$delegate.getValue();
    }

    private final void initView() {
        setTitle(R.string.personal_info);
        View findViewById = findViewById(R.id.rl_avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mRlAvatar = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.iv_avatar_1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mIvAvatar = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.rl_nick_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mRlNickName = (RelativeLayout) findViewById3;
        View findViewById4 = findViewById(R.id.tv_name);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mTvName = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.rl_account);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mRlAccount = (RelativeLayout) findViewById5;
        View findViewById6 = findViewById(R.id.tv_phone);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.mTvPhone = (TextView) findViewById6;
        RelativeLayout relativeLayout = this.mRlAvatar;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRlAvatar");
            relativeLayout = null;
        }
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout3 = this.mRlNickName;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRlNickName");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        relativeLayout2.setOnClickListener(this);
    }

    private final void selectAvatar() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory, Environment.DIRECTORY_DOWNLOADS + '/' + getPackageName() + "_account_icon.jpg");
        if (file.exists()) {
            file.delete();
        }
        this.mImageUri = Uri.fromFile(file);
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        intent.putExtra("output", this.mImageUri);
        try {
            startActivityForResult(intent, RESULT_LOAD_IMAGE);
        } catch (Exception e) {
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.e(TAG, "[updateAvatar] error = " + e.getMessage());
        }
    }

    private final void showUpdateNickNameDialog() {
        AccountAlertDialog accountAlertDialog = this.mAlertDialog;
        if (accountAlertDialog == null || !accountAlertDialog.isShowing()) {
            String string = getResources().getString(R.string.change_nick_name);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Button button = null;
            View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_nick_name, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.iv_clear);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.mIvClearText = (ImageView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.tv_nick_error);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            TextView textView = (TextView) findViewById2;
            this.mTvErrorMsg = textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvErrorMsg");
                textView = null;
            }
            textView.setVisibility(8);
            View findViewById3 = inflate.findViewById(R.id.et_changed_nick_name_lay);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.mEdNickNameLay = (LinearLayout) findViewById3;
            View findViewById4 = inflate.findViewById(R.id.et_changed_nick_name);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.mEdVcodeEdit = (EditText) findViewById4;
            ImageView imageView = this.mIvClearText;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvClearText");
                imageView = null;
            }
            imageView.setOnClickListener(this);
            EditText editText = this.mEdVcodeEdit;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEdVcodeEdit");
                editText = null;
            }
            editText.requestFocus();
            EditText editText2 = this.mEdVcodeEdit;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEdVcodeEdit");
                editText2 = null;
            }
            TextView textView2 = this.mTvName;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvName");
                textView2 = null;
            }
            editText2.setHint(textView2.getText());
            EditText editText3 = this.mEdVcodeEdit;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEdVcodeEdit");
                editText3 = null;
            }
            editText3.addTextChangedListener(this.mTextWatcher);
            String string2 = getResources().getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = getResources().getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            AccountAlertDialog showAccountDialog = DialogHelperKt.showAccountDialog(this, string, inflate, string2, string3, new a(this), new b(this));
            this.mAlertDialog = showAccountDialog;
            Button button2 = showAccountDialog != null ? (Button) showAccountDialog.findViewById(R.id.bt_dialog_ok) : null;
            Intrinsics.checkNotNull(button2);
            this.mBtDialogOk = button2;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtDialogOk");
            } else {
                button = button2;
            }
            button.setTextColor(getResources().getColor(R.color.ha_blue_25));
            AccountAlertDialog accountAlertDialog2 = this.mAlertDialog;
            if (accountAlertDialog2 != null) {
                accountAlertDialog2.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void showUpdateNickNameDialog$lambda$1(PersonalInfoActivity personalInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(personalInfoActivity, "this$0");
        AccountAlertDialog accountAlertDialog = personalInfoActivity.mAlertDialog;
        if (accountAlertDialog != null) {
            accountAlertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void showUpdateNickNameDialog$lambda$2(PersonalInfoActivity personalInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(personalInfoActivity, "this$0");
        Button button = personalInfoActivity.mBtDialogOk;
        EditText editText = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtDialogOk");
            button = null;
        }
        button.setTextColor(personalInfoActivity.getResources().getColor(R.color.ha_blue_25));
        Button button2 = personalInfoActivity.mBtDialogOk;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtDialogOk");
            button2 = null;
        }
        button2.setEnabled(false);
        EditText editText2 = personalInfoActivity.mEdVcodeEdit;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEdVcodeEdit");
        } else {
            editText = editText2;
        }
        personalInfoActivity.updateNickName(StringsKt.trim((CharSequence) editText.getText().toString()).toString());
    }

    /* access modifiers changed from: private */
    public final void updateAccountUiState(AccountData accountData) {
        RequestBuilder requestBuilder = (RequestBuilder) Glide.u(this).s(accountData.getIcon()).e();
        ImageView imageView = this.mIvAvatar;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvAvatar");
            imageView = null;
        }
        requestBuilder.z0(imageView);
        TextView textView2 = this.mTvName;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvName");
            textView2 = null;
        }
        textView2.setText(accountData.getNickname());
        TextView textView3 = this.mTvPhone;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvPhone");
        } else {
            textView = textView3;
        }
        textView.setText(accountData.getPhone());
    }

    private final void updateNickName(String str) {
        CoroutineUtilsKt.launchMain(new PersonalInfoActivity$updateNickName$1(this, str, (Continuation<? super PersonalInfoActivity$updateNickName$1>) null));
    }

    private final void uploadAvatar(String str) {
        CoroutineUtilsKt.launchMain(new PersonalInfoActivity$uploadAvatar$1(this, str, (Continuation<? super PersonalInfoActivity$uploadAvatar$1>) null));
    }

    /* access modifiers changed from: private */
    public final void uploadAvatarSuccess(String str) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        RoundedBitmapDrawable roundedBitmapDrawable = getRoundedBitmapDrawable(resources, str);
        roundedBitmapDrawable.f(true);
        ImageView imageView = this.mIvAvatar;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvAvatar");
            imageView = null;
        }
        imageView.setImageDrawable(roundedBitmapDrawable);
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != REQUEST_CROP_PHOTO) {
            if (i == RESULT_LOAD_IMAGE && i2 == -1 && intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                Intrinsics.checkNotNull(data);
                cropAvatar(data);
            }
        } else if (i2 == -1) {
            Uri uri = this.mImageUri;
            if ((uri != null ? uri.getPath() : null) != null) {
                Uri uri2 = this.mImageUri;
                Intrinsics.checkNotNull(uri2);
                String path = uri2.getPath();
                Intrinsics.checkNotNull(path);
                uploadAvatar(path);
            }
        }
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        int id = view.getId();
        if (id == R.id.rl_avatar) {
            if (checkPermission()) {
                selectAvatar();
            }
        } else if (id == R.id.rl_nick_name) {
            showUpdateNickNameDialog();
        } else if (id == R.id.iv_clear) {
            EditText editText = this.mEdVcodeEdit;
            LinearLayout linearLayout = null;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEdVcodeEdit");
                editText = null;
            }
            editText.setText("");
            LinearLayout linearLayout2 = this.mEdNickNameLay;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEdNickNameLay");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setBackground(getDrawable(R.drawable.ha_et_bg_blue));
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_personal_info);
        initView();
        collectLifecycleFlow(this, getViewModel().getAccountState(), new PersonalInfoActivity$onCreate$1(this, (Continuation<? super PersonalInfoActivity$onCreate$1>) null));
        getViewModel().getDetail();
    }

    public void onDestroy() {
        AccountAlertDialog accountAlertDialog;
        super.onDestroy();
        AccountAlertDialog accountAlertDialog2 = this.mAlertDialog;
        if (accountAlertDialog2 != null && accountAlertDialog2.isShowing() && (accountAlertDialog = this.mAlertDialog) != null) {
            accountAlertDialog.dismiss();
        }
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            if (!(!(iArr.length == 0))) {
                return;
            }
            if (iArr[0] == 0) {
                selectAvatar();
            } else {
                Toast.makeText(this, getResources().getString(R.string.upload_avatar_permission_denied_tip), 1).show();
            }
        }
    }
}
