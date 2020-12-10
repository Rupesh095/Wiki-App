package com.app.wikiapp.data

class AppModel(var query : String,
               var pages : String,
               var pageid : String,
               var title : String,
               var ns : String,
               var contentmodel : String,
               var revisions : MutableList<AppModel> = mutableListOf<AppModel>(),
               var images : MutableList<AppModel> = mutableListOf<AppModel>()
)