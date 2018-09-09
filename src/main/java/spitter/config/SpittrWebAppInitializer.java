package spitter.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * do konfiguracji serwletu dystrybutora i kontekstu aplikacji Springa
 * w kontekście serwletu wystarczy dowolna klasa rozszerzająca AbstractAnnotationConfigDispatcherServletInitializer.
 */
public class SpittrWebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/"}; // odwzorowanie dispatcher servletu na "/"
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class};
    }
}
