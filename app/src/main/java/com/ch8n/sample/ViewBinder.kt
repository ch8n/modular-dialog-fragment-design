package com.ch8n.sample

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ViewBinder(
    lifecycle: Lifecycle,
    viewBinding: ViewBinding
) : LifecycleObserver, ReadOnlyProperty<Lifecycle, ViewBinding> {

    private var binding: T? = null

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        binding = null
    }

    override fun getValue(thisRef: Lifecycle, property: KProperty<*>): ViewBinding {
        var binding = this.binding
        if (binding != null) {
            return binding
        }

        if (!thisRef.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            throw IllegalStateException("Should not try to bind when view isn't visible.")
        }

        
        this.binding = binding
        return binding
    }
}

inline fun <reified T : ViewBinding> Fragment.viewBinder() {

}
