import org.fluentlenium.adapter.FluentTest;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class TamagotchiTest {

  @Test
  public void tamagotchi_instantiatesCorrectly() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals("lil dragon", myPet.getName());
    assertEquals(100, myPet.getFoodLevel());
    assertEquals(100, myPet.getSleepLevel());
    assertEquals(100, myPet.getActivityLevel());
  }

  @Test
  public void timePasses_foodDecreases_true() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    int originalFoodLevel = myPet.getFoodLevel();
    myPet.timePasses();
    assertEquals(true, originalFoodLevel >= myPet.getFoodLevel());
  }

  @Test
  public void isAlive_foodLevelAbove0_true() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals(true, myPet.isAlive());
  }

  @Test
  public void isAlive_foodBelow1_false() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.setFoodLevel(0);
    assertEquals(false, myPet.isAlive());
  }

  @Test
  public void feed_foodLevelIncreasesByTen_15() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.setFoodLevel(5);
    myPet.feed();
    assertEquals(15, myPet.getFoodLevel());
  }

  @Test
  public void nap_sleepLevelToMax() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.setSleepLevel(5);
    myPet.nap();
    assertEquals(100, myPet.getSleepLevel());
  }

  // @Test
  // public void nap_foodLevelDecreases_5() {
  //   Tamagotchi myPet = new Tamagotchi("lil dragon");
  //   myPet.setSleepLevel(5);
  //   myPet.nap();
  //   assertEquals(5, myPet.getFoodLevel());
  // }
  // Food Level will now be random, so this test would need to be modified.

  @Test
  public void play_ActivityLevelIncreasesByTen_15() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.setActivityLevel(5);
    myPet.play();
    assertEquals(15, myPet.getActivityLevel());
  }

  @Test
  public void isHappy_allGreaterThanEighty_true() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals(true, myPet.isHappy());
  }

  @Test
  public void isHappy_foodAtSix_false() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.setFoodLevel(6);
    assertEquals(false, myPet.isHappy());
  }

}
