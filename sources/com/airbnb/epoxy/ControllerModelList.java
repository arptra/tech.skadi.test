package com.airbnb.epoxy;

import com.airbnb.epoxy.ModelList;

class ControllerModelList extends ModelList {
    private static final ModelList.ModelListObserver OBSERVER = new ModelList.ModelListObserver() {
        public void a(int i, int i2) {
            throw new IllegalStateException("Models cannot be changed once they are added to the controller");
        }

        public void b(int i, int i2) {
            throw new IllegalStateException("Models cannot be changed once they are added to the controller");
        }
    };

    public ControllerModelList(int i) {
        super(i);
        pauseNotifications();
    }

    public void freeze() {
        setObserver(OBSERVER);
        resumeNotifications();
    }
}
