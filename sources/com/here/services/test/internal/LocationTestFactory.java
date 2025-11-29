package com.here.services.test.internal;

import android.content.Context;
import com.here.services.internal.ServiceNotFoundException;

public class LocationTestFactory {
    private LocationTestFactory() {
    }

    public static ILocationTest open(Context context) throws ServiceNotFoundException {
        return new LocationTestClient(context);
    }
}
