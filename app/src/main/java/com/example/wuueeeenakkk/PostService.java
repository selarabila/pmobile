package com.example.wuueeeenakkk;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    @GET("posts")
    Call<List<Post>> getAllPost();

   // @POST("login")
    //Call doLogin(String username, String password);

    //@POST("post")
    //Call addPost(Post data baru);


}
