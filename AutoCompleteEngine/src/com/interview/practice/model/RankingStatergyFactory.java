package com.interview.practice.model;

public class RankingStatergyFactory {

    public static RankingStatergy getStratergy(AutoCompleteContext contextType){
           if (contextType.getContextType() == ContextType.IDE)
               return new FrequencyBasedRanking();
           return new RelevanceRankingStatergy();
    }
}
