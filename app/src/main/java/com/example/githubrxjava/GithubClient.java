package com.example.githubrxjava;

import androidx.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class GithubClient {

    // TODO(4): Add our base url for the api
    private static final String GITHUB_BASE_URL = "https://api.github.com/";


    // TODO(5) Create instance for our Helper class to help fetch data
    private static GithubClient instance;

    // TODO(6): gET the todo services
    private GithubService githubService;


    private GithubClient() {
        final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        final Retrofit retrofit = new Retrofit.Builder().baseUrl(GITHUB_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        githubService = retrofit.create(GithubService.class);
    }

    public static GithubClient getInstance() {
        if (instance == null) {
            instance = new GithubClient();
        }
        return instance;
    }

    public Observable<List<GithubRepo>> getStarredRepos(@NonNull String userName) {
        return githubService.getStarredRepositories(userName);
    }

}
