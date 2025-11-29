package com.airbnb.epoxy;

import androidx.annotation.NonNull;

class ImmutableModelException extends RuntimeException {
    private static final String MODEL_CANNOT_BE_CHANGED_MESSAGE = "Epoxy attribute fields on a model cannot be changed once the model is added to a controller. Check that these fields are not updated, or that the assigned objects are not mutated, outside of the buildModels method. The only exception is if the change is made inside an Interceptor callback. Consider using an interceptor if you need to change a model after it is added to the controller and before it is set on the adapter. If the model is already set on the adapter then you must call `requestModelBuild` instead to recreate all models.";

    public ImmutableModelException(EpoxyModel epoxyModel, int i) {
        this(epoxyModel, "", i);
    }

    @NonNull
    private static String buildMessage(EpoxyModel epoxyModel, String str, int i) {
        return str + " Position: " + i + " Model: " + epoxyModel.toString() + "\n\n" + MODEL_CANNOT_BE_CHANGED_MESSAGE;
    }

    public ImmutableModelException(EpoxyModel epoxyModel, String str, int i) {
        super(buildMessage(epoxyModel, str, i));
    }
}
