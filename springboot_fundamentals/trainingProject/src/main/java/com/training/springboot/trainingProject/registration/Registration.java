package com.training.springboot.trainingProject.registration;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Documents;


public record Registration(
        Integer id,
        @NotNull(message = "Product Id is required") Integer productId,
        String ticketCode,
        String attendeeName) {
}
