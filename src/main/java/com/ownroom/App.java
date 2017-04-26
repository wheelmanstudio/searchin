package com.ownroom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String searchTerm;
        do {
            System.out.println("Please enter the search term.");
            searchTerm = scanner.nextLine();
        } while (searchTerm.isEmpty());
        scanner.close();

        List<SearchRequest> requests = new ArrayList<>();
        requests.add(new GoogleRequest(searchTerm));
        requests.add(new DuckDuckGoRequest(searchTerm));

        requests.parallelStream().forEach(SearchRequest::proceed);

        for (SearchRequest req: requests) {
            SearchResultGroup result = req.getSearchResults();
            System.out.println();
            System.out.println( "// " + result.getSearchEngineName() + " search");
            System.out.println( "Title: " + result.getSearchResults().get(0).getTitle() );
            System.out.println( "Href: " + result.getSearchResults().get(0).getUrl() );
        }
    }
}
