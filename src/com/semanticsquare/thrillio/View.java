package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.controllers.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partner.Shareable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New Item Bookmarked --" + bookmark);

						if (user.getUserType() == UserType.EDITOR_TYPE
								|| user.getUserType() == (UserType.CHIEF_EDITOR_TYPE)) {
							
							// Mark as kid-friendly
							if (bookmark.isKidFriendlyEligible()
									&& bookmark.getKidFriendlyStatus() == (KidFriendlyStatus.UNKNOWN)) {
								String kidFriendlyStatus= getKidFriendlyStatusDecision(bookmark);
								if (kidFriendlyStatus != (KidFriendlyStatus.UNKNOWN)) {
									BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
								}
							}
							
							// Sharing
							if(bookmark.getKidFriendlyStatus() == KidFriendlyStatus.APPROVED && bookmark instanceof Shareable) {
								boolean isShared = getShareDecision();
								if (isShared) {
									BookmarkController.getInstance().share(user, bookmark);
								}
							}
						}

					}
				}
			}
		}

	}

	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= .4 && Math.random() < .8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}

}
