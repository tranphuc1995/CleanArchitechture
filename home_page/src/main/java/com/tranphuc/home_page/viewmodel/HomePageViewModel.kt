package com.tranphuc.home_page.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tranphuc.domain.model.User
import com.tranphuc.domain.usecases.GetListUserFromApiUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomePageViewModel(val getListUserFromApiUseCase: GetListUserFromApiUseCase) : ViewModel() {

    private var mGetListUser: MutableLiveData<MutableList<User>> = MutableLiveData()

    fun getListUser(): LiveData<MutableList<User>> {
        return mGetListUser
    }

    fun doUseCaseGetListUserFromApi() {
        viewModelScope.launch {
            var listItemUser: MutableList<User> = ArrayList()
            withContext(Dispatchers.IO) {
                listItemUser = getListUserFromApiUseCase.execute("1") as MutableList<User>
            }
            mGetListUser.value = listItemUser
        }
    }
}