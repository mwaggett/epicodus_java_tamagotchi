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
  private int mFoodLevel = 10;
  private int mSleepLevel = 10;
  private int mActivityLevel = 10;

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
    mFoodLevel -= randomGenerator.nextInt(mFoodLevel+1);
    mSleepLevel -= randomGenerator.nextInt(mSleepLevel+1);
    mActivityLevel -= randomGenerator.nextInt(mActivityLevel+1);
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
    if (mFoodLevel < 10) {
      mFoodLevel += 1;
    }
    return this;
  }

  public Tamagotchi setSleepLevel(int newSleepLevel) {
    mSleepLevel = newSleepLevel;
    return this;
  }

  public Tamagotchi nap() {
    timePasses();
    mSleepLevel = 10;
    return this;
  }

  public Tamagotchi setActivityLevel(int newActivityLevel) {
    mActivityLevel = newActivityLevel;
    return this;
  }

  public Tamagotchi play() {
    if (mActivityLevel < 10) {
      mActivityLevel += 1;
    }
    return this;
  }

  public boolean isHappy() {
    return ((mFoodLevel == 10) && (mSleepLevel == 10) && (mActivityLevel == 10));
  }


}
