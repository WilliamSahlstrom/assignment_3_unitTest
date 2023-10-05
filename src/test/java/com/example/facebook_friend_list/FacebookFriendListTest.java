package com.example.facebook_friend_list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FacebookFriendListTest {
	private FacebookFriendList facebookFriendList;
	@Before
	public void setUp() {
		facebookFriendList = new FacebookFriendList();
	}
	@Test
    public void testGetFriends() {
        // Positive test case: Provide a valid profile link and check if the friends are returned correctly.
        String[] friends = facebookFriendList.getFriends("https://www.facebook.com/johndoe");
        assertArrayEquals(new String[]{"Niklas", "Kim", "Isak", "Mamma"}, friends);
    }
	
	@Test
    public void testInvalidInput() {
        // Negative test case: Provide an invalid profile link and check if the function handles it appropriately.
        String[] friends = facebookFriendList.getFriends("invalid-link");
        assertNull(friends); 
    }
	@Test
    public void testPerformance() {
        // Performance test: Measure the execution time for a large input.
        long startTime = System.currentTimeMillis();
        facebookFriendList.getFriends("https://www.facebook.com/large-profile");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // You can set a performance threshold.
        assertTrue(executionTime < 1000); 
    }

}
