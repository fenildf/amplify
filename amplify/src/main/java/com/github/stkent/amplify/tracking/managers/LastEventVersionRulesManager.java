/**
 * Copyright 2015 Stuart Kent
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.github.stkent.amplify.tracking.managers;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.github.stkent.amplify.ILogger;
import com.github.stkent.amplify.tracking.AppVersionNameProvider;
import com.github.stkent.amplify.tracking.Settings;
import com.github.stkent.amplify.tracking.interfaces.IAppVersionNameProvider;
import com.github.stkent.amplify.tracking.interfaces.ISettings;

public class LastEventVersionRulesManager extends BaseEventsManager<String> {

    private final IAppVersionNameProvider appVersionNameProvider;

    public LastEventVersionRulesManager(@NonNull final Context appContext, @NonNull final ILogger logger) {
        this(logger, new Settings<String>(appContext, logger), new AppVersionNameProvider(appContext));
    }

    @VisibleForTesting
    protected LastEventVersionRulesManager(
            @NonNull final ILogger logger,
            @NonNull final ISettings<String> settings,
            @NonNull final IAppVersionNameProvider appVersionNameProvider) {
        super(logger, settings);

        this.appVersionNameProvider = appVersionNameProvider;
    }

    @NonNull
    @Override
    protected String getTrackingKeySuffix() {
        return "LASTEVENTVERSIONSMANAGER";
    }

    @NonNull
    @Override
    public String defaultTrackingValue() {
        return "";
    }

    @NonNull
    @Override
    public String getUpdatedTrackingValue(@NonNull final String cachedTrackingValue) {
        try {
            return appVersionNameProvider.getVersionName();
        } catch (final PackageManager.NameNotFoundException e) {
            getLogger().d("Could not read current app version name.");
            return cachedTrackingValue;
        }
    }

}