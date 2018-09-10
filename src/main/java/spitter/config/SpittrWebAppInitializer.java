package spitter.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * You need just to extend your class with AbstractAnnotationConfigDispatcherServletInitializer and
 * configuration  of dispatcher servlet and Spring app context is done
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
