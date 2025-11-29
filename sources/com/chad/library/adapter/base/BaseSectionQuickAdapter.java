package com.chad.library.adapter.base;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0000H$¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/chad/library/adapter/base/BaseSectionQuickAdapter;", "Lcom/chad/library/adapter/base/entity/SectionEntity;", "T", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "helper", "item", "", "v0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/chad/library/adapter/base/entity/SectionEntity;)V", "", "", "payloads", "w0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/chad/library/adapter/base/entity/SectionEntity;Ljava/util/List;)V", "", "type", "", "a0", "(I)Z", "holder", "position", "b0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "c0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;ILjava/util/List;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseSectionQuickAdapter<T extends SectionEntity, VH extends BaseViewHolder> extends BaseMultiItemQuickAdapter<T, VH> {
    public boolean a0(int i) {
        return super.a0(i) || i == -99;
    }

    /* renamed from: b0 */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        if (baseViewHolder.getItemViewType() == -99) {
            v0(baseViewHolder, (SectionEntity) getItem(i - M()));
        } else {
            super.onBindViewHolder(baseViewHolder, i);
        }
    }

    /* renamed from: c0 */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i, List list) {
        if (list.isEmpty()) {
            onBindViewHolder(baseViewHolder, i);
        } else if (baseViewHolder.getItemViewType() == -99) {
            w0(baseViewHolder, (SectionEntity) getItem(i - M()), list);
        } else {
            super.onBindViewHolder(baseViewHolder, i, list);
        }
    }

    public abstract void v0(BaseViewHolder baseViewHolder, SectionEntity sectionEntity);

    public void w0(BaseViewHolder baseViewHolder, SectionEntity sectionEntity, List list) {
    }
}
