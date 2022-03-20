package fr.airweb.news.presentation.viewmodel

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import fr.airweb.news.presentation.model.BaseState
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.Observable
import org.koin.java.KoinJavaComponent.inject

abstract class BaseViewModel<State : BaseState>(defaultState: State) : ViewModel() {

    protected val resources: Resources by inject(Resources::class.java)
    protected val model: State = defaultState

    protected val _state = BehaviorSubject.create<State>()

    val state: Observable<State>
        get() = _state

}