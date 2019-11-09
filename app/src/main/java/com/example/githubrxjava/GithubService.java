package com.example.githubrxjava;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubService {

    // TODO(3): Set up Retrofit

    // TODO(4): Add the url we intend pulling data from and make it return an observable
    @GET("users/{user}/starred")
    Observable<List<GithubRepo>> getStarredRepositories(@Path("user") String username);
}
