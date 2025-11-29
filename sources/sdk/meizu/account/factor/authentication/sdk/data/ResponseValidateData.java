package sdk.meizu.account.factor.authentication.sdk.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/data/ResponseValidateData;", "", "userAnswerValidate", "", "Lsdk/meizu/account/factor/authentication/sdk/data/AnswerType;", "userBasicInfoValidate", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "(Ljava/util/List;Ljava/util/List;)V", "getUserAnswerValidate", "()Ljava/util/List;", "setUserAnswerValidate", "(Ljava/util/List;)V", "getUserBasicInfoValidate", "setUserBasicInfoValidate", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ResponseValidateData {
    @Nullable
    private List<AnswerType> userAnswerValidate;
    @Nullable
    private List<BasicInfoType> userBasicInfoValidate;

    public ResponseValidateData() {
        this((List) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ResponseValidateData copy$default(ResponseValidateData responseValidateData, List<AnswerType> list, List<BasicInfoType> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = responseValidateData.userAnswerValidate;
        }
        if ((i & 2) != 0) {
            list2 = responseValidateData.userBasicInfoValidate;
        }
        return responseValidateData.copy(list, list2);
    }

    @Nullable
    public final List<AnswerType> component1() {
        return this.userAnswerValidate;
    }

    @Nullable
    public final List<BasicInfoType> component2() {
        return this.userBasicInfoValidate;
    }

    @NotNull
    public final ResponseValidateData copy(@Nullable List<AnswerType> list, @Nullable List<BasicInfoType> list2) {
        return new ResponseValidateData(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseValidateData)) {
            return false;
        }
        ResponseValidateData responseValidateData = (ResponseValidateData) obj;
        return Intrinsics.areEqual((Object) this.userAnswerValidate, (Object) responseValidateData.userAnswerValidate) && Intrinsics.areEqual((Object) this.userBasicInfoValidate, (Object) responseValidateData.userBasicInfoValidate);
    }

    @Nullable
    public final List<AnswerType> getUserAnswerValidate() {
        return this.userAnswerValidate;
    }

    @Nullable
    public final List<BasicInfoType> getUserBasicInfoValidate() {
        return this.userBasicInfoValidate;
    }

    public int hashCode() {
        List<AnswerType> list = this.userAnswerValidate;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<BasicInfoType> list2 = this.userBasicInfoValidate;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    public final void setUserAnswerValidate(@Nullable List<AnswerType> list) {
        this.userAnswerValidate = list;
    }

    public final void setUserBasicInfoValidate(@Nullable List<BasicInfoType> list) {
        this.userBasicInfoValidate = list;
    }

    @NotNull
    public String toString() {
        return "ResponseValidateData(userAnswerValidate=" + this.userAnswerValidate + ", userBasicInfoValidate=" + this.userBasicInfoValidate + ')';
    }

    public ResponseValidateData(@Nullable List<AnswerType> list, @Nullable List<BasicInfoType> list2) {
        this.userAnswerValidate = list;
        this.userBasicInfoValidate = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponseValidateData(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }
}
