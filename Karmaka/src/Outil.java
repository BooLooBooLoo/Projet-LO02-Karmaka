package Karmaka.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Cartes.*;

public class Outil implements Serializable{
	
    public static List<List<Carte>> getCombinations(List<Carte> nums, int r) {
        List<List<Carte>> result = new ArrayList<>();
        if (nums == null || nums.isEmpty() || r <= 0 || r > nums.size()) {
            return result;
        }
        List<Carte> combination = new ArrayList<>();
        getCombinationsHelper(nums, r, 0, combination, result);
        return result;
    }

    private static void getCombinationsHelper(List<Carte> nums, int r, int start, List<Carte> combination, List<List<Carte>> result) {
        if (combination.size() == r) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            combination.add(nums.get(i));
            getCombinationsHelper(nums, r, i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    
    public static void main(String[] args) {
    	List<Carte> nums = new ArrayList<>();
        nums.add(new Destinee());
        nums.add(new Roulette());
        nums.add(new Vol());
        List<List<Carte>> result = getCombinations(nums, 2);
        for (List<Carte> combination : result) {
            System.out.println(combination);
        }
	}
}
