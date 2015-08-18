import java.util.Random;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.*;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.Map;

public class Tamagotchi {

  private String mName;
  private int mFoodLevel = 100;
  private int mSleepLevel = 100;
  private int mActivityLevel = 100;

  public Tamagotchi(String name) {
    mName = name;
  }

  public String getName() {
    return mName;
  }

  public int getFoodLevel() {
    return mFoodLevel;
  }

  public int getSleepLevel() {
    return mSleepLevel;
  }

  public int getActivityLevel() {
    return mActivityLevel;
  }

  public Tamagotchi timePasses() {
    Random randomGenerator = new Random();
    mFoodLevel -= randomGenerator.nextInt(11);
    mSleepLevel -= randomGenerator.nextInt(11);
    mActivityLevel -= randomGenerator.nextInt(11);
    return this;
  }

  public boolean isAlive() {
    return ((mFoodLevel > 0) && (mSleepLevel > 0) && (mActivityLevel > 0));
  }

  public Tamagotchi setFoodLevel(int newFoodLevel) {
    mFoodLevel = newFoodLevel;
    return this;
  }

  public Tamagotchi feed() {
    if (mFoodLevel < 90) {
      mFoodLevel += 10;
    }
    else if (mFoodLevel < 100) {
      mFoodLevel = 100;
    }
    return this;
  }

  public Tamagotchi setSleepLevel(int newSleepLevel) {
    mSleepLevel = newSleepLevel;
    return this;
  }

  public Tamagotchi nap() {
    timePasses();
    mSleepLevel = 100;
    return this;
  }

  public Tamagotchi setActivityLevel(int newActivityLevel) {
    mActivityLevel = newActivityLevel;
    return this;
  }

  public Tamagotchi play() {
    if (mActivityLevel < 90) {
      mActivityLevel += 10;
      mFoodLevel -= 10;
      mSleepLevel -= 10;
    } else if (mActivityLevel < 100) {
      mActivityLevel = 100;
      mFoodLevel -= 10;
      mSleepLevel -= 10;
    }

    return this;
  }

  public boolean isHappy() {
    return ((mFoodLevel >= 80) && (mSleepLevel >= 80) && (mActivityLevel >= 80));
  }


}
