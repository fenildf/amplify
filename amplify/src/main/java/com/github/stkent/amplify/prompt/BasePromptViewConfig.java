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
package com.github.stkent.amplify.prompt;

import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.stkent.amplify.R;
import com.github.stkent.amplify.prompt.interfaces.IQuestion;
import com.github.stkent.amplify.prompt.interfaces.IThanks;

import static com.github.stkent.amplify.utils.StringUtils.defaultIfBlank;

//@formatter:off
@SuppressWarnings({"PMD.ExcessiveParameterList", "checkstyle:parameternumber"})
public final class BasePromptViewConfig {

    private static final String DEFAULT_USER_OPINION_QUESTION_TITLE                 = "Enjoying the app?";
    private static final String DEFAULT_POSITIVE_FEEDBACK_QUESTION_TITLE            = "Awesome! We'd love a Play Store review...";
    private static final String DEFAULT_CRITICAL_FEEDBACK_QUESTION_TITLE            = "Bummer. Would you like to send feedback?";
    private static final String DEFAULT_USER_OPINION_QUESTION_POSITIVE_BUTTON_LABEL = "Yes!";
    private static final String DEFAULT_USER_OPINION_QUESTION_NEGATIVE_BUTTON_LABEL = "No";
    private static final String DEFAULT_FEEDBACK_QUESTION_POSITIVE_BUTTON_LABEL     = "Sure thing!";
    private static final String DEFAULT_FEEDBACK_QUESTION_NEGATIVE_BUTTON_LABEL     = "Not right now";
    private static final String DEFAULT_THANKS_TITLE                                = "Thanks for your feedback!";

    @Nullable private final String userOpinionQuestionTitle;
    @Nullable private final String userOpinionQuestionSubtitle;
    @Nullable private final String userOpinionQuestionPositiveButtonLabel;
    @Nullable private final String userOpinionQuestionNegativeButtonLabel;
    @Nullable private final String positiveFeedbackQuestionTitle;
    @Nullable private final String positiveFeedbackQuestionSubtitle;
    @Nullable private final String positiveFeedbackQuestionPositiveButtonLabel;
    @Nullable private final String positiveFeedbackQuestionNegativeButtonLabel;
    @Nullable private final String criticalFeedbackQuestionTitle;
    @Nullable private final String criticalFeedbackQuestionSubtitle;
    @Nullable private final String criticalFeedbackQuestionPositiveButtonLabel;
    @Nullable private final String criticalFeedbackQuestionNegativeButtonLabel;
    @Nullable private final String thanksTitle;
    @Nullable private final String thanksSubtitle;

    public BasePromptViewConfig(@NonNull final TypedArray typedArray) {
        userOpinionQuestionTitle = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_user_opinion_question_title);

        userOpinionQuestionSubtitle = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_user_opinion_question_subtitle);

        userOpinionQuestionPositiveButtonLabel = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_user_opinion_question_positive_button_label);

        userOpinionQuestionNegativeButtonLabel = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_user_opinion_question_negative_button_label);

        positiveFeedbackQuestionTitle = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_positive_feedback_question_title);

        positiveFeedbackQuestionSubtitle = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_positive_feedback_question_subtitle);

        positiveFeedbackQuestionPositiveButtonLabel = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_positive_feedback_question_positive_button_label);

        positiveFeedbackQuestionNegativeButtonLabel = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_positive_feedback_question_negative_button_label);

        criticalFeedbackQuestionTitle = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_critical_feedback_question_title);

        criticalFeedbackQuestionSubtitle = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_critical_feedback_question_subtitle);

        criticalFeedbackQuestionPositiveButtonLabel = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_critical_feedback_question_positive_button_label);

        criticalFeedbackQuestionNegativeButtonLabel = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_critical_feedback_question_negative_button_label);

        thanksTitle = typedArray.getString(R.styleable.BasePromptView_prompt_view_thanks_title);

        thanksSubtitle = typedArray.getString(
                R.styleable.BasePromptView_prompt_view_thanks_subtitle);
    }

    protected BasePromptViewConfig(
            @Nullable final String userOpinionQuestionTitle,
            @Nullable final String userOpinionQuestionPositiveButtonLabel,
            @Nullable final String userOpinionQuestionNegativeButtonLabel,
            @Nullable final String positiveFeedbackQuestionTitle,
            @Nullable final String positiveFeedbackQuestionPositiveButtonLabel,
            @Nullable final String positiveFeedbackQuestionNegativeButtonLabel,
            @Nullable final String criticalFeedbackQuestionTitle,
            @Nullable final String criticalFeedbackQuestionPositiveButtonLabel,
            @Nullable final String criticalFeedbackQuestionNegativeButtonLabel,
            @Nullable final String thanksTitle,
            @Nullable final String userOpinionQuestionSubtitle,
            @Nullable final String positiveFeedbackQuestionSubtitle,
            @Nullable final String criticalFeedbackQuestionSubtitle,
            @Nullable final String thanksSubtitle) {

        this.userOpinionQuestionTitle                    = userOpinionQuestionTitle;
        this.userOpinionQuestionPositiveButtonLabel      = userOpinionQuestionPositiveButtonLabel;
        this.userOpinionQuestionNegativeButtonLabel      = userOpinionQuestionNegativeButtonLabel;
        this.positiveFeedbackQuestionTitle               = positiveFeedbackQuestionTitle;
        this.positiveFeedbackQuestionPositiveButtonLabel = positiveFeedbackQuestionPositiveButtonLabel;
        this.positiveFeedbackQuestionNegativeButtonLabel = positiveFeedbackQuestionNegativeButtonLabel;
        this.criticalFeedbackQuestionTitle               = criticalFeedbackQuestionTitle;
        this.criticalFeedbackQuestionPositiveButtonLabel = criticalFeedbackQuestionPositiveButtonLabel;
        this.criticalFeedbackQuestionNegativeButtonLabel = criticalFeedbackQuestionNegativeButtonLabel;
        this.thanksTitle                                 = thanksTitle;
        this.userOpinionQuestionSubtitle                 = userOpinionQuestionSubtitle;
        this.positiveFeedbackQuestionSubtitle            = positiveFeedbackQuestionSubtitle;
        this.criticalFeedbackQuestionSubtitle            = criticalFeedbackQuestionSubtitle;
        this.thanksSubtitle                              = thanksSubtitle;
    }

    @NonNull
    public IQuestion getUserOpinionQuestion() {
        return new Question(
                getUserOpinionQuestionTitle(),
                userOpinionQuestionSubtitle,
                getUserOpinionQuestionPositiveButtonLabel(),
                getUserOpinionQuestionNegativeButtonLabel());
    }

    @NonNull
    public IQuestion getPositiveFeedbackQuestion() {
        return new Question(
                getPositiveFeedbackQuestionTitle(),
                positiveFeedbackQuestionSubtitle,
                getPositiveFeedbackQuestionPositiveButtonLabel(),
                getPositiveFeedbackQuestionNegativeButtonLabel());
    }

    @NonNull
    public IQuestion getCriticalFeedbackQuestion() {
        return new Question(
                getCriticalFeedbackQuestionTitle(),
                criticalFeedbackQuestionSubtitle,
                getCriticalFeedbackQuestionPositiveButtonLabel(),
                getCriticalFeedbackQuestionNegativeButtonLabel());
    }

    @NonNull
    public IThanks getThanks() {
        return new Thanks(getThanksTitle(), thanksSubtitle);
    }

    @NonNull
    private String getUserOpinionQuestionTitle() {
        return defaultIfBlank(
                userOpinionQuestionTitle, DEFAULT_USER_OPINION_QUESTION_TITLE);
    }

    @NonNull
    private String getUserOpinionQuestionPositiveButtonLabel() {
        return defaultIfBlank(
                userOpinionQuestionPositiveButtonLabel,
                DEFAULT_USER_OPINION_QUESTION_POSITIVE_BUTTON_LABEL);
    }

    @NonNull
    private String getUserOpinionQuestionNegativeButtonLabel() {
        return defaultIfBlank(
                userOpinionQuestionNegativeButtonLabel,
                DEFAULT_USER_OPINION_QUESTION_NEGATIVE_BUTTON_LABEL);
    }

    @NonNull
    private String getPositiveFeedbackQuestionTitle() {
        return defaultIfBlank(
                positiveFeedbackQuestionTitle, DEFAULT_POSITIVE_FEEDBACK_QUESTION_TITLE);
    }

    @NonNull
    private String getPositiveFeedbackQuestionPositiveButtonLabel() {
        return defaultIfBlank(
                positiveFeedbackQuestionPositiveButtonLabel,
                DEFAULT_FEEDBACK_QUESTION_POSITIVE_BUTTON_LABEL);
    }

    @NonNull
    private String getPositiveFeedbackQuestionNegativeButtonLabel() {
        return defaultIfBlank(
                positiveFeedbackQuestionNegativeButtonLabel,
                DEFAULT_FEEDBACK_QUESTION_NEGATIVE_BUTTON_LABEL);
    }

    @NonNull
    private String getCriticalFeedbackQuestionTitle() {
        return defaultIfBlank(
                criticalFeedbackQuestionTitle, DEFAULT_CRITICAL_FEEDBACK_QUESTION_TITLE);
    }

    @NonNull
    private String getCriticalFeedbackQuestionPositiveButtonLabel() {
        return defaultIfBlank(
                criticalFeedbackQuestionPositiveButtonLabel,
                DEFAULT_FEEDBACK_QUESTION_POSITIVE_BUTTON_LABEL);
    }

    @NonNull
    private String getCriticalFeedbackQuestionNegativeButtonLabel() {
        return defaultIfBlank(
                criticalFeedbackQuestionNegativeButtonLabel,
                DEFAULT_FEEDBACK_QUESTION_NEGATIVE_BUTTON_LABEL);
    }

    @NonNull
    private String getThanksTitle() {
        return defaultIfBlank(thanksTitle, DEFAULT_THANKS_TITLE);
    }

    public static final class Builder {

        @Nullable private String userOpinionQuestionTitle;
        @Nullable private String userOpinionQuestionPositiveButtonLabel;
        @Nullable private String userOpinionQuestionNegativeButtonLabel;
        @Nullable private String positiveFeedbackQuestionTitle;
        @Nullable private String positiveFeedbackQuestionPositiveButtonLabel;
        @Nullable private String positiveFeedbackQuestionNegativeButtonLabel;
        @Nullable private String criticalFeedbackQuestionTitle;
        @Nullable private String criticalFeedbackQuestionPositiveButtonLabel;
        @Nullable private String criticalFeedbackQuestionNegativeButtonLabel;
        @Nullable private String thanksTitle;
        @Nullable private String userOpinionQuestionSubtitle;
        @Nullable private String positiveFeedbackQuestionSubtitle;
        @Nullable private String criticalFeedbackQuestionSubtitle;
        @Nullable private String thanksSubtitle;

        public Builder setUserOpinionQuestionTitle(
                @NonNull final String userOpinionQuestionTitle) {

            this.userOpinionQuestionTitle = userOpinionQuestionTitle;
            return this;
        }

        public Builder setUserOpinionQuestionPositiveButtonLabel(
                @NonNull final String userOpinionQuestionPositiveButtonLabel) {

            this.userOpinionQuestionPositiveButtonLabel = userOpinionQuestionPositiveButtonLabel;
            return this;
        }

        public Builder setUserOpinionQuestionNegativeButtonLabel(
                @NonNull final String userOpinionQuestionNegativeButtonLabel) {

            this.userOpinionQuestionNegativeButtonLabel = userOpinionQuestionNegativeButtonLabel;
            return this;
        }

        public Builder setPositiveFeedbackQuestionTitle(
                @NonNull final String positiveFeedbackQuestionTitle) {

            this.positiveFeedbackQuestionTitle = positiveFeedbackQuestionTitle;
            return this;
        }

        public Builder setPositiveFeedbackQuestionPositiveButtonLabel(
                @NonNull final String positiveFeedbackQuestionPositiveButtonLabel) {

            this.positiveFeedbackQuestionPositiveButtonLabel
                    = positiveFeedbackQuestionPositiveButtonLabel;

            return this;
        }

        public Builder setPositiveFeedbackQuestionNegativeButtonLabel(
                @NonNull final String positiveFeedbackQuestionNegativeButtonLabel) {

            this.positiveFeedbackQuestionNegativeButtonLabel
                    = positiveFeedbackQuestionNegativeButtonLabel;

            return this;
        }

        public Builder setCriticalFeedbackQuestionTitle(
                @NonNull final String criticalFeedbackQuestionTitle) {

            this.criticalFeedbackQuestionTitle = criticalFeedbackQuestionTitle;
            return this;
        }

        public Builder setCriticalFeedbackQuestionPositiveButtonLabel(
                @NonNull final String criticalFeedbackQuestionPositiveButtonLabel) {

            this.criticalFeedbackQuestionPositiveButtonLabel
                    = criticalFeedbackQuestionPositiveButtonLabel;

            return this;
        }

        public Builder setCriticalFeedbackQuestionNegativeButtonLabel(
                @NonNull final String criticalFeedbackQuestionNegativeButtonLabel) {

            this.criticalFeedbackQuestionNegativeButtonLabel
                    = criticalFeedbackQuestionNegativeButtonLabel;

            return this;
        }

        public Builder setThanksTitle(@NonNull final String thanksTitle) {
            this.thanksTitle = thanksTitle;
            return this;
        }

        public Builder setUserOpinionQuestionSubtitle(
                @NonNull final String userOpinionQuestionSubtitle) {

            this.userOpinionQuestionSubtitle = userOpinionQuestionSubtitle;
            return this;
        }

        public Builder setPositiveFeedbackQuestionSubtitle(
                @NonNull final String positiveFeedbackQuestionSubtitle) {

            this.positiveFeedbackQuestionSubtitle = positiveFeedbackQuestionSubtitle;
            return this;
        }

        public Builder setCriticalFeedbackQuestionSubtitle(
                @NonNull final String criticalFeedbackQuestionSubtitle) {

            this.criticalFeedbackQuestionSubtitle = criticalFeedbackQuestionSubtitle;
            return this;
        }

        public Builder setThanksSubtitle(@NonNull final String thanksSubtitle) {
            this.thanksSubtitle = thanksSubtitle;
            return this;
        }

        public BasePromptViewConfig build() {
            return new BasePromptViewConfig(
                userOpinionQuestionTitle,
                userOpinionQuestionPositiveButtonLabel,
                userOpinionQuestionNegativeButtonLabel,
                positiveFeedbackQuestionTitle,
                positiveFeedbackQuestionPositiveButtonLabel,
                positiveFeedbackQuestionNegativeButtonLabel,
                criticalFeedbackQuestionTitle,
                criticalFeedbackQuestionPositiveButtonLabel,
                criticalFeedbackQuestionNegativeButtonLabel,
                thanksTitle,
                userOpinionQuestionSubtitle,
                positiveFeedbackQuestionSubtitle,
                criticalFeedbackQuestionSubtitle,
                thanksSubtitle);
        }
    }

}
//@formatter:on