package com.ownroom;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class GoogleRequest extends SearchRequest {

    GoogleRequest(String query) {
        super(query);
        URL = "https://www.google.com/search?nfpr=1&q=";
        name = "Google";
    }

    protected List<SearchResult> parseResults(Document doc) {
        Elements results = doc.getElementsByClass("rc");
        List<SearchResult> resultsList = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            Element e = results.get(i);
            SearchResult result = new SearchResult();

            Element title = e.getElementsByTag("a").first();
            result.setUrl(title.attr("href"));
            result.setTitle(title.text());

            result.setDescription(e.getElementsByClass("st").first().text());
            resultsList.add(result);
        }
        return resultsList;
    }
}
