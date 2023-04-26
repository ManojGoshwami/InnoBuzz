package com.example.innobuzz.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityEvent

class MyAccessibilityService : AccessibilityService(){
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        TODO("Not yet implemented")

        var packageName= event?.packageName.toString()
        var packageManager=this.packageManager
        packageManager.getApplicationLabel(applicationInfo)

       var  applicationInfo=packageManager.getApplicationInfo(packageName,0)

//       var
    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()

      val info= AccessibilityServiceInfo()

        info.apply {
            // Set the type of events that this service wants to listen to. Others
            // won't be passed to this service.
            eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED or AccessibilityEvent.TYPE_VIEW_FOCUSED

            // If you only want this service to work with specific applications, set their
            // package names here. Otherwise, when the service is activated, it will listen
            // to events from all applications.
            packageNames = arrayOf("com.whatsapp", "com.example.android.mySecondApp")

            // Set the type of feedback your service will provide.
            feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN


            notificationTimeout = 100
        }

        this.serviceInfo = info
    }
}