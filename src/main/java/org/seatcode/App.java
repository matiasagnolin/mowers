package org.seatcode;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.commons.cli.*;
import org.seatcode.domain.LawnMower;
import org.seatcode.service.MowerControlService;

import java.io.File;
import java.io.IOException;

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
        MowerControlService control;

        try {
            control = parseInputFile(file);
            control.getFollowingMovements().forEach(e->control.makeMovements(e));
        } catch (IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }


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
