package com.tranphuc.home_page.ui.list_user

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.tranphuc.domain.model.User

class ListUserDiffUtil (
    private val oldList: List<User>,
    private val newList: List<User>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].userID == newList.get(newItemPosition).userID
    }
    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return  oldList[oldPosition] == newList[newPosition]
    }
    @Nullable
    override fun getChangePayload(oldPosition: Int, newPosition: Int): Any? {
        return super.getChangePayload(oldPosition, newPosition)
    }
}
