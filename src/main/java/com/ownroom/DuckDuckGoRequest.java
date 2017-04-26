package com.ownroom;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class DuckDuckGoRequest extends SearchRequest {

    DuckDuckGoRequest(String query) {
        super(query);
        URL = "https://duckduckgo.com/html/?norw=1&q=";
        name = "DuckDuckGo";
    }

    protected List<SearchResult> parseResults(Document doc) {
        Elements results = doc.getElementById("links").getElementsByClass("results_links");
        List<SearchResult> resultsList = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            Element e = results.get(i);
            SearchResult sr = new SearchResult();

            Element result = e.getElementsByClass("links_main").first();
            sr.setUrl(result.getElementsByClass("result__a").first().attr("href"));
            sr.setTitle(result.getElementsByClass("result__a").first().text());

            sr.setDescription(result.getElementsByClass("result__snippet").first().text());

            resultsList.add(sr);
        }
        return resultsList;
    }
}
