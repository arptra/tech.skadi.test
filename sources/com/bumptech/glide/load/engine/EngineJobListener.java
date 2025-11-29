package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

interface EngineJobListener {
    void a(EngineJob engineJob, Key key, EngineResource engineResource);

    void b(EngineJob engineJob, Key key);
}
