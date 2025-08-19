package com.skillswap.backend.config;

import com.skillswap.backend.model.Skill;
import com.skillswap.backend.repository.SkillRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    // Disabled for now - using data.sql instead
    /*
    @Bean
    CommandLineRunner initDatabase(SkillRepo skillRepository) {
        return args -> {
            if (skillRepository.count() == 0) {
                skillRepository.save(new Skill("Java Programming", "Software Development", "Learn Java from basics to advanced."));
                skillRepository.save(new Skill("Photography", "Arts & Media", "Master the art of capturing stunning images."));
                skillRepository.save(new Skill("Digital Marketing", "Business & Marketing", "Boost brands through SEO, SEM, and social media."));
                skillRepository.save(new Skill("Guitar Playing", "Music", "Learn chords, strumming patterns, and popular songs."));
                skillRepository.save(new Skill("Cooking", "Lifestyle", "From beginner recipes to gourmet dishes."));
                System.out.println("✅ Sample skills inserted into the database!");
            } else {
                System.out.println("ℹ️ Skills table already has data. Skipping seeding.");
            }
        };
    }
    */
}
