package com.upuphone.starrynet.tracker;

import com.upuphone.starrynet.tracker.reporter.GooglePlayReporter;
import com.upuphone.starrynet.tracker.reporter.IReporter;

public final class BuildConfig {
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String LIBRARY_PACKAGE_NAME = "com.upuphone.starrynet.tracker";
    public static final IReporter TRACKER_REPORTER = new GooglePlayReporter();
    public static final String VERSION = "2.6.7";
}
