//package org.example.services;
//
//import org.example.models.DishModel;
//import org.example.repositories.DataRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class DishServiceTest {
//
//  private DishService dishService;
//  private DataRepository mockRepository;
//
//  @BeforeEach
//  void setUp() {
//    mockRepository = mock(DataRepository.class);
//    dishService = new DishService(mockRepository);
//  }
//
//  @Test
//  @DisplayName("Test Create Dish")
//  void testCreateDish() {
//    String name = "Plato 1";
//    String description = "Descripción";
//    double price = 10.0;
//
//    dishService.createDish(name, description, price);
//
//    verify(mockRepository).addDish(any(DishModel.class));
//  }
//
//  @Test
//  @DisplayName("Test Get Average Rating Of Dish")
//  void testGetAverageRatingOfDish() {
//    String dishName = "Plato 1";
//    DishModel mockDish = mock(DishModel.class);
//    when(mockRepository.getDish(dishName)).thenReturn(mockDish);
//    when(mockDish.getAverageRating()).thenReturn(4.5);
//
//    double averageRating = dishService.getAverageRatingOfDish(dishName);
//
//    assertEquals(4.5, averageRating);
//  }
//
//  @Test
//  @DisplayName("Test Get Average Rating Of Dish - Dish Not Found")
//  void testGetAverageRatingOfDishNotFound() {
//    String dishName = "Plato 1";
//    when(mockRepository.getDish(dishName)).thenReturn(null);
//
//    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//      dishService.getAverageRatingOfDish(dishName);
//    });
//
//    assertEquals("Plato no encontrado: Plato 1", exception.getMessage());
//  }
//
//  @Test
//  @DisplayName("Test Update Method")
//  void testUpdate() {
//    String message = "Nuevo plato agregado";
//    dishService.update(message);
//
//  }
//}