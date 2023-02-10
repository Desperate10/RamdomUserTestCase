package gromov.ramdomusertestcase.basic_feature.presentation.screens.history.adapter

import androidx.recyclerview.widget.DiffUtil
import gromov.ramdomusertestcase.basic_feature.domain.model.User

object HistoryUserDiffUtil: DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}