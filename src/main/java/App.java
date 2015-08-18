import java.util.Random;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.*;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.Map;

public class App {

  public static void main(String[] args) {

    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      request.session().attribute("pet", null);
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/pet", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Tamagotchi pet = request.session().attribute("pet");

      if (pet == null) {
        String petName = request.queryParams("name");
        pet = new Tamagotchi(petName);
        request.session().attribute("pet", pet);
        model.put("pet", request.session().attribute("pet"));
      }

      String feed = request.queryParams("feed");
      if (Boolean.parseBoolean(feed)) {
        pet = pet.feed();
        model.put("pet", request.session().attribute("pet"));
      }

      String doNothing = request.queryParams("doNothing");
      if (Boolean.parseBoolean(doNothing)) {
        pet = pet.timePasses();
        model.put("pet", request.session().attribute("pet"));
      }

      String nap = request.queryParams("nap");
      if (Boolean.parseBoolean(nap)) {
        pet = pet.nap();
        model.put("pet", request.session().attribute("pet"));
      }

      String play = request.queryParams("play");
      if (Boolean.parseBoolean(play)) {
        pet = pet.play();
        model.put("pet", request.session().attribute("pet"));
      }

      model.put("template", "templates/pet.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

}
