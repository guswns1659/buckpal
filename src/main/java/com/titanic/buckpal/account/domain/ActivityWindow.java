package com.titanic.buckpal.account.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.NonNull;

/**
 * A window of account activities.
 */
public class ActivityWindow {

    private List<Activity> activities;

    // TODO : create constructor
    public ActivityWindow(@NonNull List<Activity> activities) {
        this.activities = activities;
    }

    public ActivityWindow(@NonNull Activity... activities) {
        this.activities = new ArrayList<>(Arrays.asList(activities));
    }

}
