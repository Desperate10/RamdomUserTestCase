package gromov.ramdomusertestcase.basic_feature.presentation.screens.users

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
import gromov.ramdomusertestcase.basic_feature.presentation.screens.users.adapter.RandomUsersAdapter
import gromov.ramdomusertestcase.core.extension.autoCleaned
import gromov.ramdomusertestcase.core.extension.collectLifecycleFlow
import gromov.ramdomusertestcase.databinding.FragmentUsersBinding

@AndroidEntryPoint
class UsersFragment : Fragment(), RandomUsersAdapter.OnRandomUserClickListener {

    private var binding: FragmentUsersBinding by autoCleaned()
    private var adapter: RandomUsersAdapter by autoCleaned()
    private val viewModel by viewModels<UsersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindAdapter()
        observeViewModel()
        setupListeners()
    }

    private fun observeViewModel() {
        collectLifecycleFlow(viewModel.users) {
            if (it.isLoading) {
                binding.swipeRefreshLayout.isRefreshing = true
            } else if (it.isError) {
                binding.swipeRefreshLayout.isRefreshing = false
            } else {
                binding.swipeRefreshLayout.isRefreshing = false
                adapter.submitList(it.users)
            }
        }
    }

    private fun bindAdapter() {
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        adapter = RandomUsersAdapter()
        binding.recyclerView.adapter = adapter
        linearLayoutManager.isSmoothScrollbarEnabled = true
        binding.recyclerView.layoutManager = linearLayoutManager
        adapter.onRandomUserClickListener = this
    }

    private fun setupListeners() {
        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.getRandomUsers() }
    }

    override fun onClick(position: Int) {
        navigateToUserDetailScreen(position)
    }

    private fun navigateToUserDetailScreen(position: Int) {
        findNavController().navigate(
            UsersFragmentDirections.actionUsersFragmentToUserDetailFragment(
                position
            )
        )
    }

}