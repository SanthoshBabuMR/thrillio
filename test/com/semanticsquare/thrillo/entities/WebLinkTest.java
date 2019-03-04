 package com.semanticsquare.thrillo.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thirllio.managers.BookmarkManager;
import com.semanticsquare.thrillio.entities.WebLink;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1 porn in url -- false
		WebLink weblink = BookmarkManager.getInstance().createWebLink(2000L, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		
		boolean isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse("For porn in url - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		// Test 2 porn in title -- false
		weblink = BookmarkManager.getInstance().createWebLink(2000L, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse("For porn in title - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		// Test 3 adult in host -- false
		weblink = BookmarkManager.getInstance().createWebLink(2000L, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.adult.com");
		
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse("For adult in host - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		
		// Test 4 adult in url, but not in host -- true
		weblink = BookmarkManager.getInstance().createWebLink(2000L, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertTrue("For adult in host - isKidFriendlyEligible() must return true", isKidFriendlyEligible);
		
		// Test 5 adult in title only -- true
		weblink = BookmarkManager.getInstance().createWebLink(2000L, "Taming adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertTrue("For adult in title - isKidFriendlyEligible() must return true", isKidFriendlyEligible);
		
	}

}
