package com.luck.picture.lib.engine;

import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;

public interface PictureSelectorEngine {
    IBridgeLoaderFactory a();

    ExtendLoaderEngine b();

    OnInjectLayoutResourceListener c();

    SandboxFileEngine d();

    VideoPlayerEngine e();

    CompressFileEngine f();

    CompressEngine g();

    OnResultCallbackListener h();

    ImageEngine i();

    UriToFileTransformEngine j();
}
