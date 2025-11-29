package flyme.support.v7.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import flyme.support.v7.permission.PermissionGroup;
import flyme.support.v7.view.PermissionDialogView;
import java.util.List;

public interface PermissionViewHandler {
    void bindData(PermissionDialogView.Builder builder);

    View createView(ViewGroup viewGroup);

    CheckBox getCheckBox();

    List<PermissionGroup> getPermissions();

    TextView getTermsView();
}
