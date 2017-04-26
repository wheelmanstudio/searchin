package com.ownroom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 4/26/17.
 */


public class SearchResultGroup {
    private String searchEngineName;
    private List<SearchResult> searchResults;

    public SearchResultGroup() {
        this.searchResults = new ArrayList<>();
    }

    public String getSearchEngineName() {
        return searchEngineName;
    }

    public void setSearchEngineName(String searchEngineName) {
        this.searchEngineName = searchEngineName;
    }

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    public void addSearchResult(SearchResult result) {
        this.searchResults.add(result);
    }
}
