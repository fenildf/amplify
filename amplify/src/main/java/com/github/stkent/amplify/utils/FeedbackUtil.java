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
package com.github.stkent.amplify.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.github.stkent.amplify.tracking.interfaces.IApplicationInfoProvider;
import com.github.stkent.amplify.tracking.interfaces.IEnvironmentInfoProvider;

public final class FeedbackUtil {

    private static final String TAG = "FeedbackUtils";
    private static final int BASE_MESSAGE_LENGTH = 78;

    private final IApplicationInfoProvider applicationInfoProvider;
    private final IEnvironmentInfoProvider environmentInfoProvider;

    public FeedbackUtil(
            @NonNull final IApplicationInfoProvider applicationInfoProvider,
            @NonNull final IEnvironmentInfoProvider environmentInfoProvider) {
        this.applicationInfoProvider = applicationInfoProvider;
        this.environmentInfoProvider = environmentInfoProvider;
    }

    public void showFeedbackEmailChooser(@Nullable final Activity activity) {
        final Intent feedbackEmailIntent = getFeedbackEmailIntent();

        if (!environmentInfoProvider.canHandleIntent(feedbackEmailIntent)) {
            // fixme: log here
            return;
        }

        if (ActivityStateUtil.isActivityValid(activity)) {
            activity.startActivity(Intent.createChooser(getFeedbackEmailIntent(), "Choose an email provider:"));
            activity.overridePendingTransition(0, 0);
        }
    }

    @NonNull
    private Intent getFeedbackEmailIntent() {
        // fixme: pull in app name here?
        final String feedbackEmailSubject = Uri.encode("Android App Feedback", "UTF-8");
        final String appInfo = getApplicationInfoString();

        final StringBuilder uriStringBuilder = new StringBuilder("mailto:");

        try {
            uriStringBuilder.append(applicationInfoProvider.getFeedbackEmailAddress());
        } catch (final IllegalStateException e) {
            Log.d(TAG, "ResourceNotFound", e);
        }

        uriStringBuilder.append("?subject=")
                .append(feedbackEmailSubject)
                .append("&body=")
                .append(appInfo);

        final Uri uri = Uri.parse(uriStringBuilder.toString());

        return new Intent(Intent.ACTION_SENDTO, uri);
    }

    @NonNull
    private String getApplicationInfoString() {
        String versionString = "Error fetching version string";

        try {
            versionString = applicationInfoProvider.getVersionCode() + " - " + applicationInfoProvider.getVersionName();
        } catch (PackageManager.NameNotFoundException e) {
            Log.d(TAG, "MissingVersion", e);
        }

        return new StringBuilder(BASE_MESSAGE_LENGTH)
                .append("\n\n\n---------------------\nApp Version: ")

                .append(versionString)
                .append("\n")

                .append("Android OS Version: ")
                .append(Build.VERSION.RELEASE)
                .append(" - ")
                .append(Build.VERSION.SDK_INT)

                .append("\n")
                .append("Date: ")
                .append(System.currentTimeMillis())
                .toString();
    }

}
