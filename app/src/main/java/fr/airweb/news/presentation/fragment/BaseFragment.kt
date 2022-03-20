package fr.airweb.news.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import fr.airweb.news.presentation.model.BaseState
import fr.airweb.news.presentation.viewmodel.BaseViewModel

abstract class BaseFragment<
        State : BaseState,
        ViewModel: BaseViewModel<State>,
        ViewBinding: ViewDataBinding>(val layoutId: Int) : Fragment() {

    protected val navController: NavController by lazy {
        findNavController()
    }
    protected lateinit var binding: ViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)

        return binding.root
    }

    protected abstract fun updateView(state: State)

}