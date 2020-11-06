package groovy

@RestController
class WebApplication {

    @RequestMapping("/")
    String home() {
        "Hornyák Balázs AD4AYB"
    }

}