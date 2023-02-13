package gromov.ramdomusertestcase.basic_feature.presentation.screens.history.adapter

import androidx.recyclerview.widget.DiffUtil
import gromov.ramdomusertestcase.basic_feature.presentation.model.UserDisplayable

object HistoryUserDiffUtil: DiffUtil.ItemCallback<UserDisplayable>() {

    override fun areItemsTheSame(oldItem: UserDisplayable, newItem: UserDisplayable): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserDisplayable, newItem: UserDisplayable): Boolean {
        return oldItem == newItem
    }
}