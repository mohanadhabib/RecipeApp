package com.example.recipeapp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.model.CategoriesList
import com.example.recipeapp.service.retrofit
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    var listOfCategory = mutableStateOf(CategoriesList(listOf()))

    init {
        getCategories()
    }

    private fun getCategories(){
        viewModelScope.launch {
            listOfCategory.value = retrofit.getCategories()
        }
    }

}