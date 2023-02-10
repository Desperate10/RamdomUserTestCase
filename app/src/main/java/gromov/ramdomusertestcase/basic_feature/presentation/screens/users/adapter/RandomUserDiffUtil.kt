package gromov.ramdomusertestcase.basic_feature.presentation.screens.users.adapter

import androidx.recyclerview.widget.DiffUtil
import gromov.ramdomusertestcase.basic_feature.domain.model.User

object RandomUserDiffUtil : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}