package com.amazon.ata.maps.partsdiscovery;

import java.util.*;

/**
 * Helps expose key words from new editions of part catalogs.
 */
public class DevicePartDiscovery {

    // --- Part A ---
    /**
     * Calculate how often each word appears in a Catalog.
     * @param catalog The catalog to calculate word frequencies for.
     * @return A Map of words that appear in the catalog to the number of times they appear.
     */
    public Map<String, Integer> calculateWordCounts(PartCatalog catalog) {

        Map<String, Integer> returnedMap = new HashMap<>();

        for (String word : catalog.getCatalogWords()) {
            if (returnedMap.containsKey(word)) {
                returnedMap.put(word, returnedMap.get(word) + 1);
            } else {
                returnedMap.put(word, 1);
            }

        }

        return returnedMap;
    }

    // --- Part B ---
    /**
     * Removes a word from the provided word count map.
     * @param word the word to be removed
     * @param wordCounts the map to remove the word from
     */
    public void removeWord(String word, Map<String, Integer> wordCounts) {
        wordCounts.remove(word);
        return;
    }

    // --- Part C ---
    /**
     * Find the word that appears most frequently based on the word counts from a catalog.
     * @param wordCounts an association between a word and the total number of times it appeared in a catalog
     * @return The word that appears most frequently in the catalog to the number of times they appear.
     */
    public String getMostFrequentWord(Map<String, Integer> wordCounts) {
        Integer highestCount = 0;
        String highestWord = "";

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                highestWord = entry.getKey();
            }
        }
        return highestWord;
    }

    // --- Part D ---
    /**
     * Calculates the TF-IDF score for each word in a catalog. The TF-IDF score for a word
     * is equal to the count * idf score. You can assume there will be an idfScore for each word
     * in wordCounts.
     * @param wordCounts - associates a count for each word from a catalog
     * @param idfScores - associates an IDF score for each word in the catalog
     * @return a map associating each word with its TF-IDF score.
     */
    public Map<String, Double> getTfIdfScores(Map<String, Integer> wordCounts, Map<String, Double> idfScores) {

        Map<String, Double> tfIdfScores = new TreeMap<>();

        for (Map.Entry<String, Integer> anEntry : wordCounts.entrySet()) {
            tfIdfScores.put(anEntry.getKey(), anEntry.getValue() * idfScores.get(anEntry.getKey()));
        }

        return tfIdfScores;
    }
}
