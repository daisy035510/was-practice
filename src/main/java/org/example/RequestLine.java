package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String urlPaths;
    private QueryStrings queryStrings;

    /**
     * GET /calculate?operand1=11&operator=*&operand=55
     */
    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPaths = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }
    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPaths = urlPathTokens[0];

        if(urlPathTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]);
        }
    }


    public boolean isGetReuquest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String requestPath) {
        return this.urlPaths.equals(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }

    /**
     * 객체 equlas 객체와 비교하기 위해서는
     * equals and hashcode가 있어야 한다
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPaths, that.urlPaths) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPaths, queryStrings);
    }
}
