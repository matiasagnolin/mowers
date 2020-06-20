package org.seatcode.utils;

import org.seatcode.domain.Ground;
import org.seatcode.domain.LawnMower;
import org.seatcode.domain.Movements;
import org.seatcode.domain.Orientation;
import org.seatcode.service.MowerControlService;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FileReader {
    private static String[] readRawFile(File f) throws IOException
    {
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(f)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                lines.add(line.trim());
            }
        }

        return lines.toArray(new String[lines.size()]);
    }

    public static List<MowerControlService> parseInputFile(File f) throws IOException
    {
        final List<MowerControlService> result = new ArrayList<>();
        final String[] lines = readRawFile(f);

        if (lines.length > 0)
        {
            String[] dimensions = lines[0].split(" ");

            final Ground g = new Ground(parseInt(dimensions[0].trim())+1, parseInt(dimensions[1].trim())+1);

            for (int i = 1; i < lines.length; i += 2) {
                String[] position = lines[i].split(" ");
                if(position.length != 3){
                    throw new IllegalArgumentException("Position must have 3 arguments");
                }

                LawnMower lawnmower =
                        new LawnMower(parseInt(position[0]), parseInt(position[1]),
                                Orientation.valueOf(position[2].toUpperCase()));
                lawnmower.setGround(g);
                MowerControlService mower = new MowerControlService(lawnmower);
                mower.setFollowingMovements(Arrays.asList(parseMovements(lines[i + 1])));
                result.add(mower);
            }
        }

        return result;
    }

    private static Movements[] parseMovements(String line)
    {
        Movements[] commands = new Movements[line.length()];

        for (int i = 0; i < line.length(); i++)
        {
            commands[i] = Movements.valueOf(line.substring(i, i + 1));
        }

        return commands;
    }
}
