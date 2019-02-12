package com.example.trainingproject.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingproject.BaseFragment
import com.example.trainingproject.R
import com.example.trainingproject.model.UserWrapper
import com.example.trainingproject.service.HandleResponse
import com.example.trainingproject.service.UserController
import kotlinx.android.synthetic.main.first_fragment.*

class FirstFragment : BaseFragment() {

    override fun getTitle(): Int {
        return R.string.users
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.visibility = View.GONE
        setAdapter()
        getUsers()
    }

    private fun setAdapter() {
        recyclerView?.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = UserAdapter(requireActivity(), ArrayList())
    }

    private fun getUsers() {
        UserController().getUsers(object : HandleResponse<UserWrapper> {
            override fun onResponse(response: UserWrapper) {
                if (response.users.isNotEmpty()) {
                    (recyclerView?.adapter as UserAdapter).setDataSet(response.users)
                    recyclerView?.adapter?.notifyDataSetChanged()
                }
                progressBarCircular.visibility = View.GONE
                recyclerView?.visibility = View.VISIBLE
            }

            override fun onError(error: Throwable) {
                error.printStackTrace()
                Toast.makeText(requireActivity(), getString(R.string.error), Toast.LENGTH_LONG).show()
            }
        })
    }
}
