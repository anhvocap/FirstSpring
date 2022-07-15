package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.models.PricingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPricingCategoryRepository extends JpaRepository<PricingCategory, Long> {
}
