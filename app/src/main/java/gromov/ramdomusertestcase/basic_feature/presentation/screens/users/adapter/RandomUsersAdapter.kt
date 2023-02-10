package gromov.ramdomusertestcase.basic_feature.presentation.screens.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import gromov.ramdomusertestcase.R
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.databinding.ItemRandomUserBinding

class RandomUsersAdapter : ListAdapter<User, RandomUserViewHolder>(RandomUserDiffUtil) {

    var onRandomUserClickListener: OnRandomUserClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder {
        val binding = ItemRandomUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RandomUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val user = getItem(position)
        with(holder.binding) {
            tvName.text = user.name+ " "+ user.surname
            user.also {
                Glide.with(ivUserPicture)
                    .load(it.picture)
                    .placeholder(R.drawable.ic_placeholder)
                    .into(ivUserPicture)
            }

            root.setOnClickListener {
                onRandomUserClickListener?.onClick(user)
            }
        }

    }

    interface OnRandomUserClickListener {
        fun onClick(user: User)
    }
}