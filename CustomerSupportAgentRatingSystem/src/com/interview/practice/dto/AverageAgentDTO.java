package com.interview.practice.dto;

public class AverageAgentDTO {
    public String getAgentId() {
        return agentId;
    }

    public double getAverageRating() {
        return averageRating;
    }

    private String agentId;
    private double averageRating;

    public static class Builder{
        private final AverageAgentDTO dto = new AverageAgentDTO();
        public Builder agentId(String id) { dto.agentId = id; return this;}
        public Builder averageRating(double averageRating) { dto.averageRating = averageRating; return this;}
        public AverageAgentDTO build() { return dto;}

        public static Builder builder() { return new Builder();}



    }
}
