package com.example.mytodo

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels


class MainFragment: Fragment(R.layout.main_fragment) {
    //プロパティとしてViewModelをもたせる(Delegated Property)
    private val vm: MainViewModel by viewModels()
}