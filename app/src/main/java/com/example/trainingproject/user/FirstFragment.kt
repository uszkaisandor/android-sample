package com.example.trainingproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingproject.model.UserWrapper
import com.example.trainingproject.service.HandleResponse
import com.example.trainingproject.service.UserController
import kotlinx.android.synthetic.main.first_fragment.*

class FirstFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.first_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        getUsers()
    }

    private fun setAdapter() {
        mainList?.layoutManager = LinearLayoutManager(requireActivity())
        mainList?.setHasFixedSize(true)
        mainList?.adapter = UserAdapter(requireActivity(), ArrayList())
    }

    private fun getUsers() {
        UserController().getUsers(object : HandleResponse<UserWrapper> {
            override fun onResponse(response: UserWrapper) {
                if (response.users.isNotEmpty()) {
                    (mainList?.adapter as UserAdapter).setDataSet(response.users)
                    mainList?.adapter?.notifyDataSetChanged()
                }
            }

            override fun onError(error: Throwable) {
                //See this
                error.printStackTrace()
                Toast.makeText(requireActivity(), "Error!", Toast.LENGTH_LONG).show()
            }
        })
    }
}
