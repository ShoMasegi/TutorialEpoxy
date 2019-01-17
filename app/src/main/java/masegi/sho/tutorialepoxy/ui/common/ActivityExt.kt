package masegi.sho.tutorialepoxy.ui.common

import android.support.v7.app.AppCompatActivity

val AppCompatActivity.statusBarHeight: Int
    get() {
        var statusBarHeight = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            statusBarHeight = resources.getDimensionPixelSize(resourceId)
        }
        return statusBarHeight
    }

val AppCompatActivity.actionBarHeight: Int
    get() {
        var actionBarHeight = 0
        val styledAttributes = theme.obtainStyledAttributes(
            intArrayOf(android.R.attr.actionBarSize)
        )
        actionBarHeight = styledAttributes.getDimension(0, 0f).toInt()
        styledAttributes.recycle()
        return actionBarHeight
    }
