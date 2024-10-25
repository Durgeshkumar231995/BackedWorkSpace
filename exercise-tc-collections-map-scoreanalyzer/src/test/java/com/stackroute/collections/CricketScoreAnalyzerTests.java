package com.stackroute.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stackroute.collections.CricketScoreAnalyzer;

public class CricketScoreAnalyzerTests {

	CricketScoreAnalyzer cricketScoreAnalyzer;
	Map<String, Integer> scoreCard;


	@BeforeEach
	public void setUp() {

		scoreCard = new HashMap<>();
		scoreCard.put("Rahul", 3);
		scoreCard.put("Sachin", 7);
		scoreCard.put("Saurav", 5);
		scoreCard.put("Dinesh", 6);

		cricketScoreAnalyzer = new CricketScoreAnalyzer(scoreCard);

	}

	@AfterEach
	public void tearDown() {
		cricketScoreAnalyzer = null;
	}

	@Test
	public void testGetScoreCard() {

		Map<String, Integer> sc = cricketScoreAnalyzer.getScoreCard();
		assertNotNull(sc);
		assertEquals(4, scoreCard.size());
		assertEquals(7, scoreCard.get("Sachin"));
		assertEquals(5, scoreCard.get("Saurav"));

	}

	@Test
	public void testAddRunsToScoreCardNameNull() {

		boolean addRunsToScoreCard = cricketScoreAnalyzer.addRunsToScoreCard(null, 11);
		assertEquals(false, addRunsToScoreCard);

	}

	@Test
	public void testAddRunsToScoreCardName() {

		boolean addRunsToScoreCard2 = cricketScoreAnalyzer.addRunsToScoreCard("Durgesh", 11);
		assertEquals(true, addRunsToScoreCard2);

	}

	@Test
	public void testGetRunsScored() {

		Integer runs = cricketScoreAnalyzer.getRunsScored("Rahul");
		assertEquals(3, runs);

	}

	@Test
	public void testGetRunsScoredBatsmanNoExist() {
		
		Integer runs = cricketScoreAnalyzer.getRunsScored("Ram");
		assertNull(runs, "Ram not exist in map");
	}

	@Test
	public void testGetRunsScoredBatsmanNameNull() {

		Integer runs = cricketScoreAnalyzer.getRunsScored(null);
		assertNull(runs, "Runs scored by null batsman should be null");
	}

	@Test
	public void testGetTotalRuns() {

		int expectedTotal = 3 + 5 + 6 + 7; // 21
		int actualTotalRuns = cricketScoreAnalyzer.getTotalRuns();
		assertEquals(expectedTotal, actualTotalRuns);

	}

	@Test
	public void testGetSortedBatsmanName() {

		cricketScoreAnalyzer.addRunsToScoreCard("Prashant", 12);
		List<String> sortedBatsmanName = cricketScoreAnalyzer.getSortedBatsmanName();
		assertEquals(5, sortedBatsmanName.size());
		assertEquals("Saurav", sortedBatsmanName.get(0));

	}
	
	
	@Test
    void testGetHighestRunsScored() {
		
        Integer highestRun = cricketScoreAnalyzer.getHighestRunsScored();
        assertNotNull(highestRun);
        assertEquals(7, highestRun);
    }
	
	@Test
    void testtestGetBatsmenNamesWithHighestRuns() {
       
		cricketScoreAnalyzer.addRunsToScoreCard("Preveen", 50);
        List<String> batsmenNames = cricketScoreAnalyzer.getBatsmenNamesWithHighestRuns();
        assertEquals(1, batsmenNames.size());
        assertEquals("Preveen", batsmenNames.get(0));
    }
	
	@Test
	void testGetBatsmenNamesWithHighestRunsWithMultiplePlayer() {

		cricketScoreAnalyzer.addRunsToScoreCard("Suchi", 200);
		cricketScoreAnalyzer.addRunsToScoreCard("Durgesh", 200);
		cricketScoreAnalyzer.addRunsToScoreCard("Vishnu", 175);
		cricketScoreAnalyzer.addRunsToScoreCard("Harshi", 175);

		List<String> batsmenNames = cricketScoreAnalyzer.getBatsmenNamesWithHighestRuns();
		assertEquals(2, batsmenNames.size());
		assertEquals("Durgesh", batsmenNames.get(0));
	}

	@Test
    void testGetBatsmenNamesWithHighestRunsNotNull() {
       
        List<String> batsmenNames = cricketScoreAnalyzer.getBatsmenNamesWithHighestRuns();
        assertNotNull(batsmenNames);
    }
	
	
	 

}
