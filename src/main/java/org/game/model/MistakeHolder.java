package org.game.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MistakeHolder {
    final private List<Character> mistakeList;
    final private Set<Character> mistakeSet;

    public MistakeHolder() {
        this.mistakeList = new ArrayList<>();
        this.mistakeSet = new HashSet<>();
    }
    public String getMistakesHistory() {
        StringBuilder mistakeHistoryString = new StringBuilder();
        for (char letterValue : mistakeList) {
            mistakeHistoryString.append(letterValue).append(" ");
        }
        return mistakeHistoryString.toString().trim();
    }

    public int getMistakeCount() {
        return mistakeSet.size();
    }

    public void addMistake(char letterValue) {
        if (mistakeSet.contains(letterValue)) return;
        mistakeList.add(letterValue);
        mistakeSet.add(letterValue);
    }

}
