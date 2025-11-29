package com.here.services;

import android.content.Context;
import android.os.Bundle;
import com.here.services.Api.Options;
import com.here.services.internal.ServiceController;

public interface Api<O extends Options> {

    public interface Options {

        public interface None extends Options {
        }

        public interface Optional extends None {
        }

        public interface Required extends Options {
        }
    }

    public interface ServiceOptions extends Options.Optional {
        void put(Context context, Bundle bundle);
    }

    ServiceController createController(Context context, Options options);
}
