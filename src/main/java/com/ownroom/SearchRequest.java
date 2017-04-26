package com.ownroom;

import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public abstract class SearchRequest {

    protected String query;
    protected String URL = "http://change.this.placeholder";
    protected String name = "SearchEngine";
    protected SearchResultGroup srg;

    SearchRequest(String query) {
        this.query = query;
        srg = new SearchResultGroup();
    }

    public void proceed() {
        if (this.query.isEmpty()) return;
        srg.setSearchEngineName(getSearchEngineName());

        try {
            srg.setSearchResults(parseResults(JsoupUtils.getDocument(URL + URLEncoder.encode(query, "UTF-8"))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return;
        }
    }

    public String getSearchEngineName() {
        return name;
    }

    public SearchResultGroup getSearchResults() {
        if (this.query.isEmpty()) return null;
        return srg;
    }

    protected abstract List<SearchResult> parseResults(Document doc);
}
