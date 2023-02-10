package gromov.ramdomusertestcase.basic_feature.presentation.screens.user_detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import gromov.ramdomusertestcase.R
import gromov.ramdomusertestcase.basic_feature.presentation.screens.users.UsersViewModel
import gromov.ramdomusertestcase.basic_feature.presentation.screens.users.adapter.RandomUsersAdapter
import gromov.ramdomusertestcase.core.extension.autoCleaned
import gromov.ramdomusertestcase.core.extension.collectLifecycleFlow
import gromov.ramdomusertestcase.databinding.FragmentUserDetailBinding
import gromov.ramdomusertestcase.databinding.FragmentUsersBinding

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private var binding: FragmentUserDetailBinding by autoCleaned()
    private val viewModel by viewModels<UserDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        collectLifecycleFlow(viewModel.user) { user->
            binding.textViewUserEmail.text = user.email
            binding.textViewUserCity.text = user.city + " / "+ user.country
            binding.textViewName.text = user.name +" "+ user.surname
            binding.textViewUserTel.text = user.phone
            Glide.with(binding.imageViewUserPic)
                .load(user.picture)
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.imageViewUserPic)
        }
    }
}