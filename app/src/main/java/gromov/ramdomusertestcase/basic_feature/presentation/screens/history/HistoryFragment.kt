package gromov.ramdomusertestcase.basic_feature.presentation.screens.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.presentation.screens.history.adapter.HistoryUsersAdapter
import gromov.ramdomusertestcase.basic_feature.presentation.screens.users.UsersFragmentDirections
import gromov.ramdomusertestcase.core.extension.autoCleaned
import gromov.ramdomusertestcase.core.extension.collectLifecycleFlow
import gromov.ramdomusertestcase.databinding.FragmentHistoryBinding

@AndroidEntryPoint
class HistoryFragment : Fragment() , HistoryUsersAdapter.OnRandomUserClickListener{

    private var binding: FragmentHistoryBinding by autoCleaned()
    private var adapter: HistoryUsersAdapter by autoCleaned()
    private val viewModel by viewModels<HistoryViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindAdapter()
        collectLifecycleFlow(viewModel.users) {
            adapter.submitData(it)
        }

    }
    private fun bindAdapter() {
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        adapter = HistoryUsersAdapter()
        binding.recyclerView.adapter = adapter
        linearLayoutManager.isSmoothScrollbarEnabled = true
        binding.recyclerView.layoutManager = linearLayoutManager
        adapter.onRandomUserClickListener = this
    }

    override fun onClick(user: User) {
        navigateToUserDetailScreen(user.id)
    }

    private fun navigateToUserDetailScreen(userId: String) {
        findNavController().navigate(
            HistoryFragmentDirections.actionHistoryFragmentToUserDetailFragment(
                userId
            )
        )
    }


}