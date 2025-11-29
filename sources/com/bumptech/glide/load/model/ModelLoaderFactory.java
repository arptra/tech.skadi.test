package com.bumptech.glide.load.model;

public interface ModelLoaderFactory<T, Y> {
    ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory);
}
