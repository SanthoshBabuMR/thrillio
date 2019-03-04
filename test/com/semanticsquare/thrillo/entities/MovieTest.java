package com.semanticsquare.thrillo.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thirllio.managers.BookmarkManager;
import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.entities.WebLink;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		
		// Test 1 Horror Genre -- false
		Movie movie = BookmarkManager.getInstance().createMovie(3000L, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		
		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
		
		assertFalse("For Horror Genre - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		
		// Test 1 Horror Genre -- false
		movie = BookmarkManager.getInstance().createMovie(3000L, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		
		isKidFriendlyEligible = movie.isKidFriendlyEligible();
		
		assertFalse("For Horror Genre - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

	}

}
