package example;

import example.service.HelloAppService;

/**
 * 
 * @author t_endo
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String... args) throws Exception {
        new HelloAppService().run(args);
    }
}
