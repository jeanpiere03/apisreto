package com.jeanpiere.retotest.api;

import com.jeanpiere.retotest.model.Comments;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CommentsApi {
    @GET("comments")
    Call<List<Comments>> getComments();

    @GET("comments")
    Call<List<Comments>> getCommentsByPost(@Query("postId") int postId);
}
