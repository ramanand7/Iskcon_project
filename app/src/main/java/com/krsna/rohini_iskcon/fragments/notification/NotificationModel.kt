package com.krsna.rohini_iskcon.fragments.notification

class NotificationModel {
    private var mName: String? = null
    var date: String? = null

    constructor()
    constructor(mName: String?, date: String?) {
        this.mName = mName
        this.date = date
    }

    fun getmName(): String? {
        return mName
    }

    fun setmName(mName: String?) {
        this.mName = mName
    }
}