package com.interview.practice.model;

public class RankingStatergyFactory {

    public static RankingStatergy getStatergy(AutoCompleteContext contextType){
           if (contextType.getContextType() == ContextType.TEXT)
               return new FrequencyBasedRanking();
           return new RelevanceRankingStatergy();
    }
}
