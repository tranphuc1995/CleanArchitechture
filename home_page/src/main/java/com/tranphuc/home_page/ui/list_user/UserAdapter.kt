package com.tranphuc.home_page.ui.list_user

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tranphuc.domain.model.User
import com.tranphuc.home_page.R
import com.tranphuc.home_page.utils.ModuleUtils.formatMilisecondToDate
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(var listItemUser: MutableList<User>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_user, viewGroup, false)
        return UserViewHolder(
            view
        )
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as UserViewHolder).bindData(listItemUser.get(position), context)

    }

    override fun getItemCount(): Int {
        return listItemUser.size
    }


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(itemUser: User, context: Context) {

            Glide.with(context).load(itemUser.avatar)
                .into(itemView.ivAvatar)
            itemView.tvName.text = "Name: "+  itemUser.name
            itemView.tvReputation.text = "Reputation: "  + itemUser.reputation
            itemView.tvLocation.text = "Location:" + itemUser.location
            itemView.tvLastAccessDate.text = "Last access date: " +  formatMilisecondToDate(itemUser.lastAccessDate)

            // check bookmarked
            if (itemUser.isBookMarked) {
                Glide.with(context).load(R.drawable.ic_star_active).into(itemView.ivBookMark)
            } else {
                Glide.with(context).load(R.drawable.ic_star_not_active).into(itemView.ivBookMark)
            }
        }

    }

    fun updateList(listItemUserNew: List<User>) {
        val diffCallback = ListUserDiffUtil(listItemUser, listItemUserNew)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        listItemUser.clear()
        listItemUser.addAll(listItemUserNew)
        diffResult.dispatchUpdatesTo(this)
    }
}