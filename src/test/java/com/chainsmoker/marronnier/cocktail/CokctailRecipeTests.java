package com.chainsmoker.marronnier.cocktail;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.FindCocktailRecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class CokctailRecipeTests {

    @Autowired
    private FindCocktailRecipeService findCocktailRecipeService;

    private static Stream<Arguments> getCocktailRecipeId(){
        return Stream.of(
                Arguments.of(
                    1
                )
        );
    }

    @DisplayName("id로 cocktail조회 시 recipe 컬럼의 내용이 제대로 가져와지는지")
    @ParameterizedTest
    @MethodSource("getCocktailRecipeId")
    void checkIdByRecipeTests(long cocktailId){
        FindCocktailRecipeDTO cocktail = findCocktailRecipeService.findByCocktailRecipeId(cocktailId);
        Assertions.assertNotNull(cocktail.getRecipe());
    }
}