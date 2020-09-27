package br.com.edu.makemagic.api;

import br.com.edu.makemagic.api.utils.URIUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class Tests {


    private final Logger log = LogManager.getLogger(Tests.class);

    @Test
    public void URIGenTest() {

        URI uriOf = URIUtils.getURIOf("intellij", "/{id}");
        log.info(uriOf);

        String url = build("houses");
        log.info(url);

        final String DEFAULT_URL = "https://www.potterapi.com/v1/houses?key=$2a$10$B2O74JXgo0jnJ8tDU334quYIxCGwp0MGqnU5FEr36hgwFY.eKc6WS";

        String mountedURI = URIUtils.buildUriWith("houses");

        assertEquals(DEFAULT_URL, mountedURI);

    }

    private static final String SCHEME = "https";
    private static final String KEY = "key";
    private static final String HOST = "www.potterapi.com";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = "$2a$10$B2O74JXgo0jnJ8tDU334quYIxCGwp0MGqnU5FEr36hgwFY.eKc6WS";

    @Test
    public static String build(String path) {
        return UriComponentsBuilder
                .newInstance()
                .scheme(SCHEME)
                .host(HOST)
                .pathSegment(API_VERSION)
                .path(path)
                .queryParam(KEY, API_KEY)
                .build().toUriString();
    }


}
