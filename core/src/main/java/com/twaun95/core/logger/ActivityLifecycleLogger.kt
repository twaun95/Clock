package com.twaun95.core.logger

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityLifecycleLogger(
    private val supplier: LogSupplier
) : Application.ActivityLifecycleCallbacks {

    private val fragmentLogTracker = FragmentLifecycleLogger(supplier)

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        supplier.log(activity.getLifeCycleMessage("onCreate"))

        if (activity is AppCompatActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                fragmentLogTracker,
                true
            )
        }
    }

    override fun onActivityStarted(activity: Activity) {
        supplier.log(activity.getLifeCycleMessage("onStart"))
    }

    override fun onActivityResumed(activity: Activity) {
        supplier.log(activity.getLifeCycleMessage("onResume"))
    }

    override fun onActivityPaused(activity: Activity) {
        supplier.log(activity.getLifeCycleMessage("onPause"))
    }

    override fun onActivityStopped(activity: Activity) {
        supplier.log(activity.getLifeCycleMessage("onStop"))
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        supplier.log(activity.getLifeCycleMessage("onSaveInstanceState"))
    }

    override fun onActivityDestroyed(activity: Activity) {
        supplier.log(activity.getLifeCycleMessage("onDestroy"))
    }
}