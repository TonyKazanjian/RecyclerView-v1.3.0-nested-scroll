package com.disney.recyclerviewupgradepoc

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.NestedScrollingParent3
import androidx.core.view.NestedScrollingParentHelper

class ParentNestedScrollingCoordinatorLayout: CoordinatorLayout, NestedScrollingParent3 {

    private val parentHelper = NestedScrollingParentHelper(this)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    override fun onNestedScrollAccepted(child: View, target: View, nestedScrollAxes: Int) {
        parentHelper.onNestedScrollAccepted(child, target, nestedScrollAxes)
    }

    override fun onNestedScrollAccepted(
        child: View,
        target: View,
        nestedScrollAxes: Int,
        type: Int
    ) {
        parentHelper.onNestedScrollAccepted(child, target, nestedScrollAxes, type)
    }

    override fun getNestedScrollAxes(): Int {
        return parentHelper.nestedScrollAxes
    }

    override fun onStopNestedScroll(target: View) {
        parentHelper.onStopNestedScroll(target)
        Log.d("TONY","Parent nested scrolling stopped target: $target")

    }

    override fun onStopNestedScroll(target: View, type: Int) {
        parentHelper.onStopNestedScroll(target, type)
        Log.d("TONY","Parent nested scrolling stopped target: $target, type: $type")
    }
}