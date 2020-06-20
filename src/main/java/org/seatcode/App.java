package org.seatcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.cli.*;
import org.seatcode.service.MowerControlService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.seatcode.utils.FileReader.parseInputFile;

/**
 * Hello world!
 *
 */
public class App {

    private static final  Logger LOGGER =
            LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        String path = validateAndParserArgs(args);

        File file = new File(path);
        List<MowerControlService> list = new ArrayList<>();
        try {
            list = parseInputFile(file);
            for (MowerControlService con : list) {
                new Thread(() -> {
                    LOGGER.info("Mower Deployed at x{} and y{}"
                            ,con.getMower().getCurrentPosition().getX()
                            ,con.getMower().getCurrentPosition().getY()
                    );
                    con.makeMovements(con.getFollowingMovements());
                }).start();
            }
        } catch (IOException  e) {
            LOGGER.error("A critical error has occurred: {}"
                    ,e.getMessage());
        }




/*        try {
            control = parseInputFile(file);
            control.getFollowingMovements().forEach(e->control.makeMovements(e));
        } catch (IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }*/


    }

    public static String validateAndParserArgs(String[] args){
        Options options = new Options();

        Option input =
                new Option("i", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        String inputFilePath = cmd.getOptionValue("input");

        return inputFilePath;

    }
}
