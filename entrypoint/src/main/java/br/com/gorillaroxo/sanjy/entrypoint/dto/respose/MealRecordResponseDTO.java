package br.com.gorillaroxo.sanjy.entrypoint.dto.respose;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Schema(description = "Response DTO representing a meal record - a historical record of a food item consumed")
public record MealRecordResponseDTO(

    @Schema(
        description = "Unique identifier of the meal record",
        example = "123",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    Long id,

    @Schema(
        description = "Exact date and time when the item was consumed",
        example = "2025-10-13T12:30:00",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    LocalDateTime consumedAt,

    @Schema(
        description = "Meal type information (breakfast, lunch, snack, dinner, etc...)",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    MealTypeResponseDTO mealType,

    @Schema(
        description = "Indicates if this is a free meal (off-plan) or a standard meal (following the diet plan). " +
                      "TRUE = free meal | FALSE = standard meal",
        example = "false",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    Boolean isFreeMeal,

    @Schema(
        description = "The selected diet plan option that was consumed. This field contains the standard option chosen from the diet plan. " +
                      "NULL when isFreeMeal = TRUE (free meals don't follow the plan)",
        nullable = true,
        requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    StandardOptionResponseDTO standardOption,

    @Schema(
        description = "Text description of the free meal item consumed. " +
                      "NULL when isFreeMeal = FALSE (standard meals use standardOption instead)",
        example = "Grilled chicken with vegetables",
        nullable = true,
        requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    String freeMealDescription,

    @Schema(
        description = "Quantity of the item consumed",
        example = "1.5",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    BigDecimal quantity,

    @Schema(
        description = "Unit of measurement for the quantity (serving, g, ml, units, etc.)",
        example = "serving",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    String unit,

    @Schema(
        description = "Additional observations or notes about the meal",
        example = "Extra spicy, no salt",
        requiredMode = Schema.RequiredMode.NOT_REQUIRED,
        nullable = true
    )
    String notes,

    @Schema(
        description = "System timestamp when the record was created",
        example = "2025-10-13T12:31:45",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    LocalDateTime createdAt
) {

}
