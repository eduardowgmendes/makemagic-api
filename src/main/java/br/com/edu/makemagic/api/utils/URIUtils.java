package br.com.edu.makemagic.api.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/* Holds all Constants and util methods for URI on this API */
public class URIUtils {

    public static class UriConstants {
        @Deprecated
        public static final String SCHEME = "https";
        @Deprecated
        public static final String KEY = "key";
        @Deprecated
        public static final String HOST = "www.potterapi.com";
        public static final String API_VERSION = "v1";

        // For Retrofit
        public static final String BASE_URL = "https://www.potterapi.com/";
        public static final String API_KEY = "$2a$10$B2O74JXgo0jnJ8tDU334quYIxCGwp0MGqnU5FEr36hgwFY.eKc6WS";
    }

    /**
     * Returns the URI of an object with path desired on the current request
     *
     * @param object
     * @param withPath
     */
    public static URI getURIOf(Object object, String withPath) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(withPath)
                .buildAndExpand(object)
                .toUri();
    }

    /**
     * Returns a string with the appended URI to be used with an RestTemplate
     */
    public static String buildUriWith(String path) {
        return UriComponentsBuilder
                .newInstance()
                .scheme(UriConstants.SCHEME)
                .host(UriConstants.HOST)
                .pathSegment(UriConstants.API_VERSION)
                .path(path)
                .queryParam(UriConstants.KEY, UriConstants.API_KEY)
                .build().toUriString();
    }

}
