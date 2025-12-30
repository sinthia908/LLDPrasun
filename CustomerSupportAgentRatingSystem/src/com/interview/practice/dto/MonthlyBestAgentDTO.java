package com.interview.practice.dto;

import java.time.YearMonth;

public class MonthlyBestAgentDTO {

    private YearMonth month;
    private String agentId;
    private double averageRating;

    public static final class Builder{
        private final MonthlyBestAgentDTO dto = new MonthlyBestAgentDTO();
        public Builder month(YearMonth m) { dto.month = m ;return this;}
        public Builder agentId(String id){ dto.agentId = id ; return this;}
        public Builder averageRating(double averageRating){ dto.averageRating = averageRating; return this;}
        public MonthlyBestAgentDTO build() { return dto;}

        public static Builder builder() {return new Builder();}

    }

}
