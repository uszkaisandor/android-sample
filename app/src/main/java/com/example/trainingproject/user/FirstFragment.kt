package com.example.trainingproject.user

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingproject.BaseFragment
import com.example.trainingproject.R
import com.example.trainingproject.common.DisposableManager
import com.example.trainingproject.service.UserController
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.first_fragment.*

class FirstFragment : BaseFragment() {

    private val disposableManager = DisposableManager()

    override fun getTitle(): Int {
        return R.string.users
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        recyclerView?.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = UserAdapter(requireActivity(), ArrayList())
    }

    override fun onStart() {
        super.onStart()
        getUsers()
    }

    private fun getUsers() {
        disposableManager.add(
            UserController().getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                if (response.isNotEmpty()) {
                    (recyclerView?.adapter as UserAdapter).setDataSet(response)
                    recyclerView?.adapter?.notifyDataSetChanged()
                }
                crossfade()
            }, { error ->
                error.printStackTrace()
                Toast.makeText(requireActivity(), getString(R.string.error), Toast.LENGTH_LONG).show()
            })
        )
    }

    private fun crossfade() {
        recyclerView.apply {
            animate()
                .alpha(1f)
                .setDuration(animationTime)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        recyclerView?.visibility = View.VISIBLE
                    }
                })
        }
        progressBarCircular.animate()
            .alpha(0f)
            .setDuration(animationTime)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    progressBarCircular?.visibility = View.GONE
                }
            })
    }

    override fun onStop() {
        super.onStop()
        disposableManager.dispose()
    }
}
