package fr.airweb.news.presentation.utils

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.disposables.Disposable

class LifecycleAutoDisposable(private val disposable: Disposable) : DefaultLifecycleObserver {

    override fun onDestroy(owner: LifecycleOwner) {
        disposable.dispose()
        super.onDestroy(owner)
    }

}