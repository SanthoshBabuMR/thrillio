package com.semanticsquare.thirllio;

import com.semanticsquare.thirllio.managers.BookmarkManager;
import com.semanticsquare.thirllio.managers.UserManager;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;

public class Launch {
	
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {
		System.out.println("1. Loading Data ... ");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
	}

	private static void printBookmarkData() {
		for(Bookmark[] bookmarklist: bookmarks) {
			for(Bookmark bookmark: bookmarklist) {
				System.out.println(bookmark);
			}
		}
	}

	private static void printUserData() {
		for (User user: users) {
			System.out.println(user);
		}
	}

	public static void main(String[] args) {
		loadData();
		start();
	}

	private static void start() {
		for(User user:users) {
			View.browse(user, bookmarks);
		}
	}
}
