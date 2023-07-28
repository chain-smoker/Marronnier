package com.chainsmoker.marronnier.cocktail;

import com.chainsmoker.marronnier.cocktailrecipe.command.application.service.UpdateCocktailRecipeService;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.FindCocktailRecipeService;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.RecommandService;
import com.chainsmoker.marronnier.elementbyrecipe.query.application.service.FindElementByRecipeService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.Photo;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import com.chainsmoker.marronnier.photo.query.application.service.FindPhotoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class CokctailRecipeTests {

    @Autowired
    private FindCocktailRecipeService findCocktailRecipeService;

    @Autowired
    private FindElementByRecipeService findElementByRecipeService;

    @Autowired
    private UpdateCocktailRecipeService updateCocktailRecipeService;

    @Autowired
    private FindPhotoService findPhotoService;
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
        System.out.println("cocktail = " + cocktail);
        Assertions.assertNotNull(cocktail.getRecipe());
    }
    @DisplayName("id로 cocktail조회 시 사진 정보가 제대로 가져와지는지")
    @ParameterizedTest
    @MethodSource("getCocktailRecipeId")
    void checkIdByPictureTests(long cocktailId) {
        List<FindPhotoDTO> photo=findPhotoService.findPhoto(cocktailId, PhotoCategory.COCKTAIL_RECIPE);
        Assertions.assertNotNull(photo);
    }
}