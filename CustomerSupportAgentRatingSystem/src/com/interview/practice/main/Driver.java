/*Requirements:
1️⃣ Customers give a rating (1–5) to support agents
2️⃣ Each rating is stored with the date
3️⃣ System must return:
⭐ Overall best agents (sorted by average rating)
 📅 Best agent for each month*/


// Customers can raise the issue against any such unsuccessful transactions.
// Customer Issues can be classified into multiple types like Payment Related,
// Mutual Fund Related,Gold Related, Insurance Related
// Customer Service Agents can have their own expertise based on the issue type
// Customer Service Agent can work on the issues assigned to them and update the status
// of the issues 


package com.interview.practice.main;

import com.interview.practice.domain.Rating;
import com.interview.practice.repository.InMemoryRatingRepository;
import com.interview.practice.repository.RatingRepository;

import java.util.List;

public class Driver {

    private static void main(String[] args){
        RatingRepository ratingRepository = new InMemoryRatingRepository();

    }

}
