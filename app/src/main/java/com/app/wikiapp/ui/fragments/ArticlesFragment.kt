package com.app.wikiapp.ui.fragments

import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.wikiapp.R
import com.app.wikiapp.adapter.ArticleAdapter
import com.app.wikiapp.utils.JsonParser
import com.app.wikiapp.viewmodel.AppViewModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONException
import org.json.JSONObject

class ArticlesFragment : Fragment() {

    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var recyclerView: RecyclerView

    val appViewModel : AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_articles, container, false)
        initView(view)
        initActions(view)
        return view
    }

    private fun initView(view: View) {

        articleAdapter = ArticleAdapter(view.context)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = articleAdapter

    }

    private fun initActions(view: View) {

        appViewModel.getArticle().observe(viewLifecycleOwner, Observer { response ->

            Log.d("RESPONSE", ""+response);
            Toast.makeText(context, ""+ Gson().toJson(response), Toast.LENGTH_SHORT).show()
//            try {
//            var jsonObject = JSONObject(response.toString())
//            var queryObject = jsonObject.getJSONObject("query")
//            var pageObject = queryObject.getJSONObject("pages")
//            var numObject = pageObject.getJSONObject("4406048")
//            var id = numObject.getString("pageid")
//                Log.d("IDID", id)
//
//        } catch (e : JSONException) {
//            e.printStackTrace();
//        }



        })



    }

}