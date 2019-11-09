package com.example.githubrxjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GithubRepoAdapter extends BaseAdapter {

    private List<GithubRepo> githubRepoList = new ArrayList<>();

    @Override
    public int getCount() {
        return githubRepoList.size();
    }

    @Override
    public GithubRepo getItem(int i) {
        if (i < 0 || i >= githubRepoList.size()) {
            return null;
        } else {
            return githubRepoList.get(i);
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View views = (view != null ? view : createView(viewGroup));

        final GithubRepoViewHolder viewHolder = (GithubRepoViewHolder) views.getTag();
        viewHolder.setGithubRepo(getItem(i));
        return views;

    }

    public void setGithubRepo(@Nullable List<GithubRepo> repos) {
        if (repos == null) {
            return;
        }

        githubRepoList.clear();
        githubRepoList.addAll(repos);
        notifyDataSetChanged();
    }

    private View createView(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_github_repo, parent, false);
        final GithubRepoViewHolder viewHolder = new GithubRepoViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    private static class GithubRepoViewHolder {

        private TextView textRepoName;
        private TextView textRepoDescription;
        private TextView textLanguage;
        private TextView textStars;

        public GithubRepoViewHolder(View view) {

            textRepoName = view.findViewById(R.id.text_repo_name);
            textRepoDescription = view.findViewById(R.id.text_repo_description);
            textLanguage = view.findViewById(R.id.text_language);
            textStars = view.findViewById(R.id.text_stars);
        }

        public void setGithubRepo(GithubRepo githubRepo) {
            textRepoName.setText(githubRepo.name);
            textRepoDescription.setText(githubRepo.description);
            textLanguage.setText("Language: " + githubRepo.language);
            textStars.setText("Stars: " + githubRepo.stargazersCount);
        }


    }
}
