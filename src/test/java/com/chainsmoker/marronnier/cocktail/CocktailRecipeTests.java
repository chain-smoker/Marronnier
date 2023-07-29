package com.chainsmoker.marronnier.cocktail;

import com.chainsmoker.marronnier.cocktailrecipe.command.application.dto.RegistCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.command.application.service.RegistCocktailRecipeService;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.entity.CocktailRecipe;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.FindCocktailRecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class CocktailRecipeTests {

    @Autowired
    private FindCocktailRecipeService findCocktailRecipeService;

    @Autowired
    private RegistCocktailRecipeService registCocktailRecipeService;

    private static Stream<Arguments> getCocktailRecipe(){
        return Stream.of(
                Arguments.of(
                    "입장주",
                        "처음에 술자리에 입장 할때 마시는 첫잔",
                        "A",
                        "10",
                        "1. 소주잔과 맥주잔을 준비한다.-2. 소주잔에 소주를 가득 채운 후 맥주잔에 따른다.-3. 소주잔에 맥주를 가득 채운 후 맥주잔에 따른다.-4. 숟가락을 맥주잔에 넣고 하단을 빠르게 쳐준다.(깨짐주의!)-5. 잘 섞였으면 마신다.",
                        DifficultyEnum.EASY
                )
        );
    }

    @DisplayName("cocktail 이 정상적으로 등록되는지 테스트")
    @ParameterizedTest(name = "cocktail 이 정상적으로 등록되는지 테스트")
    @MethodSource("getCocktailRecipe")
    void testRegistCocktailRecipeTest(String name, String description, String classification, String abv, String recipe, DifficultyEnum difficulty){
        RegistCocktailRecipeDTO recipeDTO = new RegistCocktailRecipeDTO();
        recipeDTO.setName(name);
        recipeDTO.setDescription(description);
        recipeDTO.setClassification(classification);
        recipeDTO.setAbv(abv);
        recipeDTO.setRecipe(recipe);
        recipeDTO.setDifficulty(difficulty);

        CocktailRecipe registCocktailRecipe = registCocktailRecipeService.regist(recipeDTO);
        Assertions.assertNotNull(registCocktailRecipe);
    }



    @DisplayName("cocktail 조회 시 recipe 컬럼의 내용이 제대로 가져와지는지 테스트")
    @ParameterizedTest(name = "cocktail 조회 시 recipe 컬럼의 내용이 제대로 가져와지는지 테스트")
    @MethodSource("getCocktailRecipe")
    void testGetRecipeByCocktailRecipeIdTests(String name, String description, String classification, String abv, String recipe, DifficultyEnum difficulty){
        RegistCocktailRecipeDTO recipeDTO = new RegistCocktailRecipeDTO();
        recipeDTO.setName(name);
        recipeDTO.setDescription(description);
        recipeDTO.setClassification(classification);
        recipeDTO.setAbv(abv);
        recipeDTO.setRecipe(recipe);
        recipeDTO.setDifficulty(difficulty);

        CocktailRecipe registCocktailRecipe = registCocktailRecipeService.regist(recipeDTO);
        System.out.println("registCocktailRecipe Id = " + registCocktailRecipe.getId());
        FindCocktailRecipeDTO cocktail = findCocktailRecipeService.findByCocktailRecipeId(registCocktailRecipe.getId());
        Assertions.assertNotNull(cocktail.getRecipe());
    }
}