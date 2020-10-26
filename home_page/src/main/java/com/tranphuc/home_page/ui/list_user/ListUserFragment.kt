package com.tranphuc.home_page.ui.list_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tranphuc.domain.model.User
import com.tranphuc.home_page.R
import com.tranphuc.home_page.viewmodel.HomePageViewModel
import kotlinx.android.synthetic.main.fragment_list_user.*
import org.koin.android.ext.android.get

class ListUserFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var mUserAdapter: UserAdapter
    val mHomePageViewModel = get<HomePageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_list_user, container, false)
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addObserver()
        initViews()
    }

    private fun initViews() {
        initRvUser()
        mHomePageViewModel.doUseCaseGetListUserFromApi()
    }

    private fun addObserver() {
        mHomePageViewModel.getListUser().observe(viewLifecycleOwner, Observer { listItemUser ->
            mUserAdapter.updateList(listItemUser)
        })
    }

    private fun initRvUser() {
        var listItemUser: MutableList<User> = ArrayList()
        rvUser.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        mUserAdapter = UserAdapter(listItemUser, requireContext())
        rvUser.adapter = mUserAdapter
        mUserAdapter.updateList(listItemUser)
    }
}