package com.example.mytodo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mytodo.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.main_fragment) {
    //プロパティとしてViewModelをもたせる(Delegated Property)
    private val vm: MainViewModel by viewModels()

    //内部でMainFragmentBindingクラスが作成されこのクラスがviewを扱うのでonDestroyで破棄させる
    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding get() = _binding!!

    //_bindingプロパティへの値のセットはonViewCreated()で行う
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = MainFragmentBinding.bind(view)

        val adapter = ToDoAdapter()
        binding.recycler.adapter = adapter

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_createToDoFragment)
        }

        vm.todoList.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }

    override fun onDestroy() {
        this._binding = null
        super.onDestroy()
    }
}