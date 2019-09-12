package com.fedak.denis.mvvmcoroutine.model

import com.fedak.denis.valtech.model.OwnerStackOverflow

data class ItemStackOverflow(
    val owner: OwnerStackOverflow,
    val is_accepted: Boolean,
    val score: Int,
    val last_activity_date: Int,
    val creation_date: Int,
    val answer_id: Int,
    val question_id: Int
)
