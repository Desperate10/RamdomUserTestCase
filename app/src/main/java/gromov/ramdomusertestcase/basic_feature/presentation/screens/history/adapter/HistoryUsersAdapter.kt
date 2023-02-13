package gromov.ramdomusertestcase.basic_feature.presentation.screens.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import gromov.ramdomusertestcase.R
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.presentation.model.UserDisplayable
import gromov.ramdomusertestcase.basic_feature.presentation.screens.users.adapter.RandomUserDiffUtil
import gromov.ramdomusertestcase.basic_feature.presentation.screens.users.adapter.RandomUserViewHolder
import gromov.ramdomusertestcase.databinding.ItemRandomUserBinding

class HistoryUsersAdapter : PagingDataAdapter<UserDisplayable, HistoryUserViewHolder>(HistoryUserDiffUtil) {

    var onRandomUserClickListener: OnRandomUserClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryUserViewHolder {
        val binding = ItemRandomUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryUserViewHolder, position: Int) {
        val user = getItem(position)
        with(holder.binding) {
            tvName.text = user?.name +" "+user?.surname
            user.also {
                Glide.with(ivUserPicture)
                    .load(it?.photo)
                    .placeholder(R.drawable.ic_placeholder)
                    .into(ivUserPicture)
            }

            root.setOnClickListener {
                user?.let { it1 -> onRandomUserClickListener?.onClick(it1) }
            }
        }

    }

    interface OnRandomUserClickListener {
        fun onClick(user: UserDisplayable)
    }
}