package com.talentroc.t5.interview.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;

import java.util.Collection;
import java.util.Map;

/**
 * Layout component for pages of application t5-interview.
 */
public class Layout {
    private static final Map<String, String> pageNameToPageTitle = CollectionFactory.newMap();

    {
        pageNameToPageTitle.put("index", "Index");
        pageNameToPageTitle.put("contact/index", "Contacts");
    }

    /**
     * The page title, for the <title> element and the <h1> element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    private String pageName;

    @Inject
    private ComponentResources resources;

    public String getClassForPageName() {
        return resources.getPageName().equalsIgnoreCase(pageName)
                ? "active"
                : null;
    }

    public String getPageTitle() {
        return pageNameToPageTitle.get(pageName);
    }

    public Collection<String> getPageNames() {
        return pageNameToPageTitle.keySet();
    }
}
