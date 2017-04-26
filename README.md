# Searchin
---

Searchin is a java parser for search engines results. It sends GET request with a filled search term to all the supported search engines and fetches the web page. Then jsoup library helps to parse html page and extract titles and hrefs of search results. Anyway only the first one is shown for the user, but other can also become visible after some code tweaks.

## Usage
### Prepare
Before running you need to set a correct JAVA_HOME variable. It shoulld point to a java8 installation folder. 

```sh
$ export JAVA_HOME=<path_to_java_folder>
$ cd searchin
$ mvn install
```

### Run
```sh
$ mvn exec:java
```

