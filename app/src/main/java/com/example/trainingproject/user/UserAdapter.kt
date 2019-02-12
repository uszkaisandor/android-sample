package com.example.trainingproject.user


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trainingproject.R
import com.example.trainingproject.model.User
import kotlinx.android.synthetic.main.list_element.view.*

class UserAdapter(
    private var context: Context,
    private var users: List<User>
): RecyclerView.Adapter<UserAdapter.UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): UserHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_element, parent, false)
        return UserHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setDataSet(users: List<User>) {
        this.users = users
    }

    override fun onBindViewHolder(holder: UserHolder, p1: Int) {
        val dynamicPosition: Int = holder.adapterPosition
        val user: User = users[dynamicPosition]

        setTexts(holder, user)
        setImage(holder, user)
    }


    @SuppressLint("SetTextI18n")
    private fun setTexts(holder: UserHolder, user: User) {
        holder.firstName?.text = user.name.first
        holder.lastName?.text = user.name.last
        holder.address?.text = "${user.location.postCode} ${user.location.city} ${user.location.street}"
        holder.mobile?.text = user.mobile
    }

    private fun setImage(holder: UserHolder, user: User) {
        holder.profilePicture ?. let {imageView ->
            Glide.with(context).load(user.picture.picture).into( imageView )
        }
    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var firstName: TextView? = itemView.first_name
        var lastName: TextView? = itemView.last_name
        var address: TextView? = itemView.address
        var mobile: TextView? = itemView.mobile
        var profilePicture: ImageView? = itemView.profile_picture
    }

}