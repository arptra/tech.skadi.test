package androidx.databinding.adapters;

import android.annotation.TargetApi;
import android.widget.SearchView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;

@BindingMethods
@RestrictTo
public class SearchViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.SearchViewBindingAdapter$1  reason: invalid class name */
    class AnonymousClass1 implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnQueryTextSubmit f999a;
        public final /* synthetic */ OnQueryTextChange b;

        public boolean onQueryTextChange(String str) {
            OnQueryTextChange onQueryTextChange = this.b;
            if (onQueryTextChange != null) {
                return onQueryTextChange.onQueryTextChange(str);
            }
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            OnQueryTextSubmit onQueryTextSubmit = this.f999a;
            if (onQueryTextSubmit != null) {
                return onQueryTextSubmit.onQueryTextSubmit(str);
            }
            return false;
        }
    }

    /* renamed from: androidx.databinding.adapters.SearchViewBindingAdapter$2  reason: invalid class name */
    class AnonymousClass2 implements SearchView.OnSuggestionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnSuggestionSelect f1000a;
        public final /* synthetic */ OnSuggestionClick b;

        public boolean onSuggestionClick(int i) {
            OnSuggestionClick onSuggestionClick = this.b;
            if (onSuggestionClick != null) {
                return onSuggestionClick.onSuggestionClick(i);
            }
            return false;
        }

        public boolean onSuggestionSelect(int i) {
            OnSuggestionSelect onSuggestionSelect = this.f1000a;
            if (onSuggestionSelect != null) {
                return onSuggestionSelect.onSuggestionSelect(i);
            }
            return false;
        }
    }

    @TargetApi(11)
    public interface OnQueryTextChange {
        boolean onQueryTextChange(String str);
    }

    @TargetApi(11)
    public interface OnQueryTextSubmit {
        boolean onQueryTextSubmit(String str);
    }

    @TargetApi(11)
    public interface OnSuggestionClick {
        boolean onSuggestionClick(int i);
    }

    @TargetApi(11)
    public interface OnSuggestionSelect {
        boolean onSuggestionSelect(int i);
    }
}
